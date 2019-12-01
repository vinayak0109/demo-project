package com.example.demo_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.demo_project.fragments.PageFragment1;
import com.example.demo_project.fragments.PageFragment2;
import com.example.demo_project.fragments.PageFragment3;
import com.example.demo_project.fragments.PageFragment4;
import com.example.demo_project.fragments.PageFragment5;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class ProfileActivity extends AppCompatActivity {

    int id=1;
    String name;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        id = intent.getIntExtra("Id", 1);
        name = intent.getStringExtra("Name");
        textView = findViewById(R.id.textView);
        textView.setText(name);

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

}
