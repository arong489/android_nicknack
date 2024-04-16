package com.example.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.chapter04.Util.util.DateUtil;

public class ActReceiveActivity extends AppCompatActivity implements View.OnClickListener {

    String mReply = "fuck you bitch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_receive);

        Bundle bundle = getIntent().getExtras();

        ((TextView)findViewById(R.id.tv_request)).setText(bundle.getString("request_time") + "收到请求\n" + bundle.getString("request_content"));
        ((TextView)findViewById(R.id.tv_reply)).setText("回信消息为\n" + mReply);
        findViewById(R.id.btn_reply).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("response_time", DateUtil.getNowTime());
        bundle.putString("response_content", mReply);
        intent.putExtras(bundle);

        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}