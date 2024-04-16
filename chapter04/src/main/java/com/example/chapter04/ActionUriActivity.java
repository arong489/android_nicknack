package com.example.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class ActionUriActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_uri);
        findViewById(R.id.btn_dial).setOnClickListener(this);
        findViewById(R.id.btn_sms).setOnClickListener(this);
        findViewById(R.id.btn_my).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        int id = v.getId();
        if (id == R.id.btn_dial) {
            intent.setAction(Intent.ACTION_DIAL);
            Uri uri = Uri.parse("tel:12345");
            intent.setData(uri);
            startActivity(intent);
        } else if (id == R.id.btn_sms) {
            intent.setAction(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:12345"));
            startActivity(intent);
        } else if (id == R.id.btn_my) {
            intent.setAction("android.intent.action.ning");
            //默认
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            startActivity(intent);
        }
    }
}