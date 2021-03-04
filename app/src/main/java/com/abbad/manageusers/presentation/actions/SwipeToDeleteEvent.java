package com.abbad.manageusers.presentation.actions;




import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.abbad.manageusers.R;
import com.abbad.manageusers.Utils.MyContext;
import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;


public class SwipeToDeleteEvent implements SwipeMenuCreator {

    private MyContext context;

    public SwipeToDeleteEvent(MyContext context) {
        this.context = context;
    }

    @Override
    public void create(SwipeMenu menu) {

        SwipeMenuItem openItem = new SwipeMenuItem(
                context);
        openItem.setBackground(new ColorDrawable(Color.rgb(0x00, 0x66,
                0xff)));
        openItem.setWidth(170);
        openItem.setIcon(R.drawable.ic_edit);
        openItem.setTitleColor(Color.WHITE);
        menu.addMenuItem(openItem);

        SwipeMenuItem deleteItem = new SwipeMenuItem(
                context);
        deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                0x3F, 0x25)));
        deleteItem.setWidth(170);
        deleteItem.setIcon(R.drawable.ic_baseline_delete_24);
        menu.addMenuItem(deleteItem);

    }
}
