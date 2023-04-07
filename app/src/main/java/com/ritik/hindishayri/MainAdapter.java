package com.ritik.hindishayri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainAdapter extends BaseAdapter {
    TopicActivity topicActivity;
    String [] title;
    Animation  ani;

    public MainAdapter(TopicActivity topicActivity,String [] title){
        this.topicActivity=topicActivity;
        this.title=title;
    }
    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(topicActivity).inflate(R.layout.view,viewGroup,false);
        ani = AnimationUtils.loadAnimation(topicActivity,R.anim.animation1);
        TextView textView;
        textView =view.findViewById(R.id.textView);
        textView.setText(title[i]);
        textView.setAnimation(ani);
        return view;
    }
}
