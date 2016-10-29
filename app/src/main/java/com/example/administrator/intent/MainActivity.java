package com.example.administrator.intent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText) findViewById(R.id.url);
        et2=(EditText) findViewById(R.id.phone);
        tv1=(TextView) findViewById(R.id.tv1);
    }
    public void componentname(View v){
        ComponentName cname=new ComponentName(this,intent2.class);
        Intent in1=new Intent();
        in1.setComponent(cname);
        startActivity(in1);
    }
    public void intentfilter(View v){
        String str="com.example.administrator.test";
        Intent in2=new Intent();
        in2.setComponent(ComponentName.unflattenFromString(str));
        startActivity(in2);
    }
    public void View(View v){
        Intent in3=new Intent();
        in3.setAction(Intent.ACTION_VIEW);
        Uri u= Uri.parse(et1.getText().toString());
        in3.setData(u);
        startActivity(in3);
    }
    public void dial(View v){
        Intent in4=new Intent();
        Uri u=Uri.parse("tel:"+et2.getText().toString());
        in4.setData(u);
        startActivity(in4);
    }
    public void startresult(){
        Bundle b=new Bundle();
        b.putString("value",et1.getText().toString());
        Intent in=new Intent(MainActivity.this,intent2.class);
        in.putExtras(b);
        startActivityForResult(in,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 10:
                Bundle b=data.getExtras();
                tv1.setText(b.getString("result"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
