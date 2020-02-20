package com.storm.template.module.item

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ObservableList
import com.storm.mylibrary.command.BindingCommand
import com.storm.mylibrary.command.BindingConsumer
import com.storm.mylibrary.utils.AppUtil
import com.storm.mylibrary.view.swipemenu.SwipeMenuCreator
import com.storm.mylibrary.view.swipemenu.SwipeMenuItem
import com.storm.template.BR
import com.storm.template.R
import com.storm.template.base.BaseViewModel
import me.tatarka.bindingcollectionadapter2.ItemBinding

open class ItemViewModel : BaseViewModel() {

    open var itemBinding =
        ItemBinding.of<ItemItemViewModel>(
           BR.viewModel,
            R.layout.item_item
        )
   open var items: ObservableList<ItemItemViewModel> = ObservableArrayList<ItemItemViewModel>()
    open var creator = ObservableField<SwipeMenuCreator>();
    open var menuClick = BindingCommand<IntArray>(BindingConsumer<IntArray> {
        toast("我点击了${it[0]}  ${it[1]}")
    })

    override fun initData() {
        for (item in 0..100){
            items.add(ItemItemViewModel(this,item))
        }
    }

    init {
        creator.set(SwipeMenuCreator { menu ->
            val deleteItem = SwipeMenuItem(application)
            deleteItem.background = ColorDrawable(Color.rgb(0xF9, 0x3F, 0x25))
            deleteItem.width = AppUtil.dip2Px(application, 60f)
            deleteItem.setIcon(R.mipmap.ic_delete)
            menu.addMenuItem(deleteItem)
        })

    }
}