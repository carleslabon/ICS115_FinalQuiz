package com.eslabon.finalquiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;

public class SecondActivity extends AppCompatActivity {

    Button backBtn;
    TextView textDisplay;
    FileInputStream fis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        backBtn = (Button) findViewById(R.id.backBtn);
        textDisplay = (TextView) findViewById(R.id.textDisplay);

        StringBuilder buffer = new StringBuilder();
        int read;
        try {
            fis = openFileInput("output.txt");
            while ((read = fis.read()) != -1) {
                buffer.append((char) read);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        textDisplay.setText(buffer.toString());

    }

    public void goToMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
