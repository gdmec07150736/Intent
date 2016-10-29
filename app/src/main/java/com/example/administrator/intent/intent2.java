package com.example.administrator.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class intent2 extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intenddemo);
    }
    public void upper(View v){
        Intent in=getIntent();
        Bundle b=in.getExtras();
        final String str=b.getString("value").toUpperCase();
        Intent inresult=new Intent();
        inresult.putExtra("result",str);
        setResult(RESULT_OK,inresult);
        finish();
    }
}
