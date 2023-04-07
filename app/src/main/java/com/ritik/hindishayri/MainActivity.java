package com.ritik.hindishayri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AppCompatButton btnStart,btnRate,btnExist;
//    AlertDialog.Builder builder;
    Animation ani;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ani = AnimationUtils.loadAnimation(MainActivity.this,R.anim.animation3);

        btnStart=findViewById(R.id.btnStart);
        btnRate=findViewById(R.id.btnRate);
        btnExist=findViewById(R.id.btnExits);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start = new Intent(MainActivity.this,TopicActivity.class);
                startActivity(start);
            }
        });


        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Link is not ready", Toast.LENGTH_SHORT).show();
            }
        });

        btnExist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder exist = new AlertDialog.Builder(MainActivity.this);
                exist.setTitle("Exit")
                        .setIcon(R.drawable.baseline_home_24)
                        .setMessage("Are you sure want to exit!");
                exist.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                exist.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                exist.show();
            }
        });
    }
}