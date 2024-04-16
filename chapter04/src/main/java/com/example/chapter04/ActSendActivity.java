package com.example.chapter04;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.chapter04.Util.util.DateUtil;

public class ActSendActivity extends AppCompatActivity implements View.OnClickListener {

    String mRequest = "fbi warning";
    ActivityResultLauncher<Intent> register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_send);

        ((TextView)findViewById(R.id.tv_send)).setText("发信内容\n" + mRequest);

        findViewById(R.id.btn_request).setOnClickListener(this);
        register = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result != null) {
                Intent intent = result.getData();
                if (intent != null && result.getResultCode() == Activity.RESULT_OK){
                    Bundle bundle = intent.getExtras();
                    ((TextView)findViewById(R.id.tv_receive)).setText(bundle.getString("response_time") + "收到回复\n" + bundle.getString("response_content"));
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ActReceiveActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("request_time", DateUtil.getNowTime());
        bundle.putString("request_content", mRequest);
        intent.putExtras(bundle);
        register.launch(intent);
    }
}