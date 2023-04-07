package com.ritik.hindishayri;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopicDes extends AppCompatActivity {
    String title;
    String[] str;
    ListView second_list;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_des);

        second_list=findViewById(R.id.second_list);
        title = getIntent().getStringExtra("title");

        if (title.equals("Good Morning Shayri")){
            str=getResources().getStringArray(R.array.goodmorning);
        }
        if (title.equals("Good Night Shayri")){
            str = getResources().getStringArray(R.array.goodnight);
        }
        if (title.equals("Love Shayri")){
            str = getResources().getStringArray(R.array.loveshayri);
        }
        if (title.equals("Friend Shayri")){
            str =getResources().getStringArray(R.array.friend);
        }
        if (title.equals("Attitude Shayri")){
            str =getResources().getStringArray(R.array.attitude);
        }
        if (title.equals("Emoji Shayri")){
            str = getResources().getStringArray(R.array.emoji);
        }
        if (title.equals("Funny Shayri")){
            str =getResources().getStringArray(R.array.funny);
        }
        if (title.equals("Birthday Shayri")){
            str = getResources().getStringArray(R.array.birthday);
        }
        if (title.equals("Romantic Shyari")){
            str = getResources().getStringArray(R.array.romantic);
        }
        if (title.equals("Life Shyari")){
            str = getResources().getStringArray(R.array.life);
        }
        if (title.equals("God Shayri")){
            str=getResources().getStringArray(R.array.god);
        }
        if (title.equals("Sad Shayri")){
            str = getResources().getStringArray(R.array.sad);
        }
        if (title.equals("Happy Shayri")){
            str = getResources().getStringArray(R.array.happy);
        }
        if (title.equals("Dard Shayri")){
            str = getResources().getStringArray(R.array.dard);
        }
        if (title.equals("Intezar Shayri")){
            str = getResources().getStringArray(R.array.intezar);
        }
        if (title.equals("Bewafa Shayri")){
            str = getResources().getStringArray(R.array.bewafa);
        }
        if (title.equals("Navratri Shayri")){
            str=getResources().getStringArray(R.array.navratri);
        }
        if (title.equals("New Year Shayri")){
            str = getResources().getStringArray(R.array.newyear);
        }
        if (title.equals("Chrismas Shayri")){
            str = getResources().getStringArray(R.array.chismas);
        }
        if (title.equals("Utrayan Shayri")){
            str = getResources().getStringArray(R.array.utrayan);
        }
        if (title.equals("Republicday Shayri")){
            str = getResources().getStringArray(R.array.republic);
        }
        if (title.equals("Valentine Shayri")){
            str = getResources().getStringArray(R.array.valentine);
        }
        if (title.equals("Rakshabandhan Shayri")){
            str = getResources().getStringArray(R.array.rakshabandhan);
        }
        if (title.equals("Diwali Shayri")){
            str = getResources().getStringArray(R.array.diwali);
        }
        if (title.equals("Maa Shayri")){
            str = getResources().getStringArray(R.array.maa);
        }
        if (title.equals("Baap Shayri")){
            str = getResources().getStringArray(R.array.baap);
        }
        if (title.equals("Family Shayri")){
            str = getResources().getStringArray(R.array.family);
        }
        if (title.equals("Sharabi Shayri")){
            str = getResources().getStringArray(R.array.sharabi);
        }
        if (title.equals("Cutness Shayri")){
            str = getResources().getStringArray(R.array.cutness);
        }
        if (title.equals("2 line Shayri")){
            str = getResources().getStringArray(R.array.line);
        }
        if (title.equals("All in one")){
            str = getResources().getStringArray(R.array.allinone);
        }

        SecondAdapter add = new SecondAdapter(TopicDes.this,str);
        second_list.setAdapter(add);
        second_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent last = new Intent(TopicDes.this,lastViewShayriActivity.class);
                last.putExtra("shayri",str);
                last.putExtra("position",i);
                startActivity(last);
            }
        });

    }
}