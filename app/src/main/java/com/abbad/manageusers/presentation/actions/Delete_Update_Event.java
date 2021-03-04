package com.abbad.manageusers.presentation.actions;

import android.util.Log;

import androidx.fragment.app.FragmentManager;

import com.abbad.manageusers.Utils.CustomUserAdapter;
import com.abbad.manageusers.Utils.MyContext;
import com.abbad.manageusers.model.User;
import com.abbad.manageusers.presentation.controllers.UpdateUser;
import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuListView;

public class Delete_Update_Event implements SwipeMenuListView.OnMenuItemClickListener {
    private MyContext context;
    private UpdateUser updateBottomSheet;
    private CustomUserAdapter adapter;
    private FragmentManager fragmentManager;
    public Delete_Update_Event(MyContext context, CustomUserAdapter adpter, FragmentManager fragmentManager){
        this.context = context;
        this.adapter = adpter;
        this.fragmentManager = fragmentManager;
    }
    @Override
    public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {

        switch (index) {
            case 0:
                //Update
                User user = context.getServices().getUser(context.getServices().getUsers().get(position).getId());
                user.setId(context.getServices().getUsers().get(position).getId());
                updateBottomSheet = new UpdateUser(context,adapter,user);
                updateBottomSheet.show(fragmentManager,"BottomFragement"+position);
                Log.i("dackerState","Update Clicker");
                break;
            case 1:
                //Delete

                context.getServices().deleteUser(context.getServices().getUsers().get(position).getId());

                Log.i("dackerState","Delete Clicker"+position);
                break;
        }
        Log.i("dackerState","General Clicker");
        adapter.notifyDataSetChanged();
        return false;
    }
}
