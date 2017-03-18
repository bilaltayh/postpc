package com.example.abdallahsamara.bilal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textV = (TextView) findViewById(R.id.display);
        textV.setMovementMethod(new ScrollingMovementMethod());
        //  if(savedInstanceState != null) {
        //    textV.setText(savedInstanceState.getString("chat"));
        //}
    }

    public void selfMessage(View view) {
        EditText text = (EditText) findViewById(R.id.input);
        String message = text.getText().toString();

        if (message == null || message == "") {
            return;
        }

        TextView textV = (TextView) findViewById(R.id.display);
        textV.setText(textV.getText().toString() + "  " + message + "\n");
        text.getText().clear();
        while (textV.canScrollVertically(1)) {
            textV.scrollBy(0, 10);
        }
    }

    // public void onSaveInstanceState(Bundle savedInstanceState) {
    //   TextView textV = (TextView) findViewById(R.id.display);
    // savedInstanceState.putString("chat", textV.getText().toString());
    //super.onSaveInstanceState(savedInstanceState);
    //}
}