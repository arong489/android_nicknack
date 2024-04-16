package com.example.chapter08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.chapter08.util.ToastUtil;

public class SpinnerDropdownActivity extends AppCompatActivity {

    private Spinner sp_dropdown;
    private Spinner sp_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_dropdown);

        sp_dropdown = findViewById(R.id.dropdown);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_select, new String[]{"1", "2", "3", "4", "5"});
        sp_dropdown.setAdapter(adapter);
        sp_dropdown.setSelection(0);
        sp_dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ToastUtil.show(SpinnerDropdownActivity.this, "[dropdown]您选择的是" + position + " " + id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ToastUtil.show(SpinnerDropdownActivity.this, "[dropdown]fucking your mother choose a number");
            }
        });

        sp_dialog = findViewById(R.id.dialog);

        sp_dialog.setAdapter(adapter);
        sp_dialog.setPrompt("fucking your mother choose a number");
        sp_dialog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ToastUtil.show(SpinnerDropdownActivity.this, "[dialog]您选择的是" + position + " " + id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ToastUtil.show(SpinnerDropdownActivity.this, "[dialog]fucking your mother choose a number");
            }
        });
    }
}