package com.ritik.hindishayri;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class lastViewShayriActivity extends AppCompatActivity {
    int pos;
    String[]shayri;
    TextView textView;
    Button btnNext,btnPrevious,btnShare,btnCopy;
    Animation animation;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_view_shayri);

        animation = AnimationUtils.loadAnimation(lastViewShayriActivity.this,R.anim.animation2);
        textView=findViewById(R.id.last_view_shayri);

        builder =new AlertDialog.Builder(this);

        btnNext=findViewById(R.id.btnNext);
        btnPrevious=findViewById(R.id.btnPrevious);
        btnShare=findViewById(R.id.btnShare);
        btnCopy=findViewById(R.id.btnCopy);

        pos=getIntent().getIntExtra("position",0);
        shayri=getIntent().getStringArrayExtra("shayri");

        textView.setText(""+shayri[pos]);
        textView.setAnimation(animation);

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos--;
                try {
                    textView.setAnimation(animation);
                    textView.setText(""+shayri[pos]);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos++;
                try {
                    textView.setAnimation(animation);
                    textView.setText("" + shayri[pos]);
                }catch (Exception e){

                }
            }
        });

        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ss =textView.getText().toString();
                ClipboardManager clipbord =(ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("test",ss);
                clipbord.setPrimaryClip(clip);

                showtoast();
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ss = textView.getText().toString();
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT,"My application name");
                    String shareMessage ="\n"+ ss +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT,shareMessage);
                    startActivity(Intent.createChooser(shareIntent,"choose one"));
                }catch (Exception e){

                }
            }
        });
    }

    void showtoast(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.toast));
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}