package com.eslabon.finalquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText authorNameInput, quoteInput;
    Button saveBtn, nextBtn;
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authorNameInput = (EditText) findViewById(R.id.authorNameInput);
        quoteInput      = (EditText) findViewById(R.id.quoteInput);

        saveBtn = (Button) findViewById(R.id.saveBtn);
        nextBtn = (Button) findViewById(R.id.nextBtn);
    }

    public void internalStorage(View view) {
        String message = authorNameInput.getText().toString() + " SAID: \n"  + quoteInput.getText().toString();
        try {
            fos = openFileOutput("output.txt", Context.MODE_PRIVATE);
            fos.write(message.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public void toSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }
}
