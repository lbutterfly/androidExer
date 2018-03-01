package com.example.linda.androidtutorial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {
    private String TAG = "FirstActivity";
    private Context mContent;
    private String text = "1";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Log.i(TAG, "on create");
        mContent = this;
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

    public void startSecondActivity(View view){
        Intent intent = new Intent(mContent, SecondActivity.class);
        intent.putExtra("text", text);
        startActivity(intent);
    }

    public void startThirdActivity(View view){
        Intent intent = new Intent(mContent, ThirdActivity.class);
        intent.putExtra("text", text);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        Log.i(TAG, "requestCode:" + requestCode + " resultCode:" + resultCode);
        if(data != null && data.hasExtra("text")){
            updateValue(data.getStringExtra("text"));
        }
    }

    private void updateValue(String string){
        textView.setText(string);
    }
}
