package com.example.chapter08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.example.chapter08.util.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpinnerIconActivity extends AppCompatActivity {

    private Spinner sp_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_icon);

        sp_icon = findViewById(R.id.sp_icon);

        List<Map<String, Object>> items = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("icon", R.drawable.ic_launcher_foreground);
            item.put("name", Integer.toString(i));
            items.add(item);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, items, R.layout.item_simple, new String[]{"name", "icon"}, new int[]{R.id.tv_item_name, R.id.iv_item_icon});

        sp_icon.setAdapter(simpleAdapter);
        sp_icon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ToastUtil.show(SpinnerIconActivity.this, "你选择了第" + position + "项");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ToastUtil.show(SpinnerIconActivity.this, "你tm啥都不选是吧");
            }
        });
    }
}