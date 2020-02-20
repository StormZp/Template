package com.storm.mylibrary.binding.swipemenulistview;

import androidx.databinding.BindingAdapter;

import com.storm.mylibrary.command.BindingCommand;
import com.storm.mylibrary.view.swipemenu.SwipeMenu;
import com.storm.mylibrary.view.swipemenu.SwipeMenuCreator;
import com.storm.mylibrary.view.swipemenu.SwipeMenuListView;

public class ViewApdater {

    @BindingAdapter({"creator","menuClick"})
    public static void setSwipeMenuCreator(SwipeMenuListView view, SwipeMenuCreator creator, final BindingCommand clickCommand) {
        if (creator != null)
            view.setMenuCreator(creator);


        view.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(int position, SwipeMenu menu, int index) {
                if (clickCommand!=null){
                    clickCommand.execute(new int[]{index,position});
                }
            }
        });

    }
}
