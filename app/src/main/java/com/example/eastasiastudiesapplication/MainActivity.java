package com.example.eastasiastudiesapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private CardView cv1,cv2,cv3,cv4,cv5;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv1 = (CardView) findViewById(R.id.china1);
        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, ChinaMain.class);
                it.putExtra("country", "China");
                startActivity(it);
            }
        });

        cv2 = (CardView) findViewById(R.id.japan1);
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, JapanMain.class);
                startActivity(it);
            }
        });

        cv3 = (CardView) findViewById(R.id.korea1);
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, KoreaMain.class);
                startActivity(it);
            }
        });

        cv4 = (CardView) findViewById(R.id.southeastasia1);
        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, SouthEastAsianMain.class);
                startActivity(it);
            }
        });

        cv5 = (CardView) findViewById(R.id.indopacific1);
        cv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, IndoPacificMain.class);
                startActivity(it);
            }
        });

    }
}