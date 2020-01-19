package com.storm.mylibrary.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;

import com.storm.mylibrary.base.UIChangeLiveData.ParameterField;
import com.storm.mylibrary.progress.CustomProgressDialog;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public abstract class SuperBaseFragment<V extends ViewDataBinding, VM extends SuperBaseViewModel> extends Fragment {
    protected V mBinding;
    protected VM mViewModel;
    private CustomProgressDialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mBinding == null)
            mBinding = DataBindingUtil.inflate(inflater, initContentView(inflater, container, savedInstanceState), container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initParam();
        if (mViewModel != null) {
            mBinding.setVariable(initVariableId(), mViewModel);
            return;
        }

        mViewModel = initViewModel();
        if (mViewModel == null) {
            Class modelClass;
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {//通过反射获取对象
                modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
            } else {
                //如果没有指定泛型参数，则默认使用BaseViewModel
                modelClass = SuperBaseViewModel.class;
            }
            mViewModel = (VM) ViewModelProviders.of(this).get(modelClass);
        }
        mBinding.setVariable(initVariableId(), mViewModel);
        getLifecycle().addObserver(mViewModel);
        registorUIChangeLiveDataCallBack();
        initData();
    }

    protected void initData() {
    }

    protected void initParam() {
    }


    protected VM initViewModel() {
        return null;
    }

    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
    public abstract int initVariableId();

    public abstract int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);


    //注册ViewModel与View的契约UI回调事件
    protected void registorUIChangeLiveDataCallBack() {
        //加载对话框显示
        mViewModel.getUC().getShowDialogEvent().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String title) {
                showDialog(title);
            }
        });
        //加载对话框消失
        mViewModel.getUC().getDismissDialogEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void v) {
                dismissDialog();
            }
        });
        //跳入新页面
        mViewModel.getUC().getStartActivityEvent().observe(this, new Observer<Map<String, Object>>() {
            @Override
            public void onChanged(@Nullable Map<String, Object> params) {
                Intent intent = (Intent) params.get(ParameterField.INTENT);
                if (intent == null) {
                    Class<?> clz = (Class<?>) params.get(ParameterField.CLASS);
                    Bundle bundle = (Bundle) params.get(ParameterField.BUNDLE);
                    startActivity(clz, bundle);
                } else {
                    startActivity(intent);
                }
            }
        });
        //跳入ContainerActivity
        mViewModel.getUC().getStartNavEvent().observe(this, new Observer<Map<String, Object>>() {
            @Override
            public void onChanged(@Nullable Map<String, Object> params) {
                int canonicalName = (int) params.get(ParameterField.NAV_ID);
                Bundle bundle = (Bundle) params.get(ParameterField.BUNDLE);
                startNav(canonicalName, bundle);
            }
        });
        //关闭界面
        mViewModel.getUC().getFinishEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void v) {
                getActivity().finish();
            }
        });
        //关闭上一层
        mViewModel.getUC().getOnBackPressedEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void v) {
                NavHostFragment.findNavController(SuperBaseFragment.this).popBackStack();
            }
        });
    }

    public void showDialog(String title) {
        if (dialog != null) {
            dismissDialog();
        }
        dialog = new CustomProgressDialog(getContext(), title);
        dialog.show();
    }

    public void dismissDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
    }

    /**
     * 跳转页面
     *
     * @param clz 所跳转的目的Activity类
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getContext(), clz));
    }

    /**
     * 跳转页面
     *
     * @param clz    所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(getContext(), clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void startNav(int canonicalName, Bundle bundle) {
        NavHostFragment.findNavController(this).navigate(canonicalName, bundle);
    }
}
