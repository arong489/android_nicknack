package com.example.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chapter03.util.DateUtil;

public class ButtonStyleActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_test;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_style);
        Button btn_enable = findViewById(R.id.btn_enable);
        Button btn_disable = findViewById(R.id.btn_disable);
        btn_test = findViewById(R.id.btn_test);
        textView = findViewById(R.id.tv_result);
        btn_enable.setOnClickListener(this);
        btn_disable.setOnClickListener(this);
        btn_test.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_enable) {
            btn_test.setEnabled(true);
        } else if (id == R.id.btn_disable) {
            btn_test.setEnabled(false);
        } else if (id == R.id.btn_test) {
            String outAns = String.format("%s 您点击了按钮 %s", DateUtil.getNowTime(), ((Button) v).getText());
            textView.setText(outAns);
        }
    }
}