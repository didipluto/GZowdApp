package com.example.gecong.gzowdapp;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

import com.xys.libzxing.zxing.activity.CaptureActivity;


public class MainActivity extends AppCompatActivity {

    private TextView mTvResult;
    public TextView webLink;
    public final static String EXTRA_MESSAGE = "com.example.gecong.gzowdapp.MESSAGE";
    public String weblink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvResult = (TextView) findViewById(R.id.tv_result);
        webLink = (TextView) findViewById(R.id.web_link);
        webLink.setText(mTvResult.getText());
    }

    public void scan(View view){
        startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class),0);
    }

    public void goToWS(View view) {
        Intent intent = new Intent(MainActivity.this, WebScreenActivity.class);
        intent.putExtra("EXTRA_MESSAGE", weblink);
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            mTvResult.setText(result);
            weblink = result;
        }
    }
}
