package com.example.demo_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.demo_project.fragments.PageFragment1;
import com.example.demo_project.fragments.PageFragment2;
import com.example.demo_project.fragments.PageFragment3;
import com.example.demo_project.fragments.PageFragment4;
import com.example.demo_project.fragments.PageFragment5;

public class SubscribeActivity extends AppCompatActivity {

    int id=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        id = intent.getIntExtra("Id", 1);
    }

    @Override
    public void onBackPressed() {
        Intent setIntent = new Intent(getApplicationContext(), PageFragment1.class);
        switch (id) {
            case 1: setIntent = new Intent(getApplicationContext(), PageFragment1.class); break;
            case 2: setIntent = new Intent(getApplicationContext(), PageFragment2.class); break;
            case 3: setIntent = new Intent(getApplicationContext(), PageFragment3.class); break;
            case 4: setIntent = new Intent(getApplicationContext(), PageFragment4.class); break;
            case 5: setIntent = new Intent(getApplicationContext(), PageFragment5.class); break;
            default: setIntent = new Intent(getApplicationContext(), PageFragment1.class); break;
        };
        startActivity(setIntent);
    }

    public void onClick(View view){
        Toast.makeText(this, "subscribed", Toast.LENGTH_SHORT).show();
    }
}
