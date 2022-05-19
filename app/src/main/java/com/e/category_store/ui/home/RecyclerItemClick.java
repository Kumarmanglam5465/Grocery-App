package com.e.category_store.ui.home;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemClick implements RecyclerView.OnItemTouchListener {
    OnItemClickListener Listener;
    GestureDetector detector;
    public RecyclerItemClick(FragmentActivity activity, RecyclerView category, RecyclerItemClick.OnItemClickListener onItemClickListener) {
        Listener=onItemClickListener;
        detector=new GestureDetector(activity, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        View v =rv.findChildViewUnder(e.getX(),e.getY());
        if(v!=null && Listener!=null&&detector.onTouchEvent(e)){
           Listener.OnItemClick(v,rv.getChildAdapterPosition(v));
            return true;
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public interface OnItemClickListener {
        public void OnItemClick(View v,int position);
    }
}
