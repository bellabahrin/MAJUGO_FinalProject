package com.example.majugoscreen;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TrackActivity extends AppCompatActivity {

    public static TextView resultTExtview;
    Button scan_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);



                resultTExtview = (TextView) findViewById(R.id.result_text);
                scan_btn = (Button) findViewById(R.id.btn_scan);
                scan_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        startActivity(new Intent(getApplicationContext(),ScanCodeActivity.class));
                    }
                });


    }
}