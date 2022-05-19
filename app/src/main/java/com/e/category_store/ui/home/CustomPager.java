package com.e.category_store.ui.home;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;

import com.e.category_store.R;

class CustomePager extends PagerAdapter {

    private Activity activity;
    private Integer[] imagesArray={R.drawable.cmain,R.drawable.emain,R.drawable.bmain,R.drawable.watermelon};



    public CustomePager(FragmentActivity activity) {
        this.activity = activity;


    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = (activity).getLayoutInflater();
        //creating  xml file for custom viewpager
        View viewItem = inflater.inflate(R.layout.content_custom, container, false);
        //finding id
        ImageView imageView =  viewItem.findViewById(R.id.imageView4);
        //setting data
        imageView.setBackgroundResource(imagesArray[position]);

        container.addView(viewItem);

        return viewItem;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imagesArray.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // TODO Auto-generated method stub
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        container.removeView((View) object);
    }
}
