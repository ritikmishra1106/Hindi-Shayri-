package com.ritik.hindishayri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopicActivity extends AppCompatActivity {
    ListView listView;
    String[]title;
    Animation ani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        listView=findViewById(R.id.listView);
        title =getResources().getStringArray(R.array.title);

        MainAdapter adapter = new MainAdapter(TopicActivity.this,title);
        ani = AnimationUtils.loadAnimation(TopicActivity.this,R.anim.animation1);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent TopicIntent = new Intent(TopicActivity.this,TopicDes.class);
                TopicIntent.putExtra("title",title[i]);
                startActivity(TopicIntent);

            }
        });
    }
}