package com.example.linda.androidtutorial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    private String TAG = "ThirdActivity";
    private Context mContext;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Log.i(TAG, "on start");
        mContext = this;
        textView = (TextView) findViewById(R.id.text);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("text")) {
            textView.setText(extras.getString("text"));
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG, "on start");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i(TAG, "on pause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG, "on stop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "on Destory");
    }

    public void backToFirstActivity(View view){
        Intent intent = new Intent();
        intent.putExtra("text", "3");
        setResult(3, intent);
        finish();
    }
}
