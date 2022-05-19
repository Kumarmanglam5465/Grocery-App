package com.e.category_store.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.e.category_store.Books;
import com.e.category_store.Computer;
import com.e.category_store.DailyProducts;
import com.e.category_store.Electronics;
import com.e.category_store.R;

import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    RecyclerView category;
    ViewPager viewPager;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.


    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
       category=root.findViewById(R.id.category);
       viewPager=root.findViewById(R.id.slider);
        CustomePager adapter = new CustomePager(getActivity());
        viewPager.setAdapter(adapter);



      /*  Bundle bundle=new Bundle();
        bundle.putString("aa","jagyf");
        Navigation.findNavController(root).navigate(R.id.action_nav_home_to_nav_gallery,bundle);*/

        /*After setting the adapter use the timer */
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 4) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);



       CustomAdapter ca=new CustomAdapter(getActivity());
       category.setHasFixedSize(true);
      category.setLayoutManager(new GridLayoutManager(getActivity(),2));
       category.setAdapter(ca);
       category.addOnItemTouchListener(new RecyclerItemClick(getActivity(),category,new RecyclerItemClick.OnItemClickListener()
       {
           public void OnItemClick(View v,int position) {
               if (position == 0) {
                 startActivity(new Intent(getActivity(),Computer.class));
               }
               if (position == 1) {
                   startActivity(new Intent(getActivity(), Electronics.class));
               }
               if (position == 2) {
                   startActivity(new Intent(getActivity(),Books.class));
               }
               if (position == 3) {
                   startActivity(new Intent(getActivity(), DailyProducts.class));
               }

           }

       }
       ));

        return root;
    }
}