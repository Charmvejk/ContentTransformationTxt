package com.example.contenttransformationtxt;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String finalContent;
    private EditText edtName;
    private EditText edtNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_save).setOnClickListener(this);
        edtName = findViewById(R.id.edt_name);
        edtNumber = findViewById(R.id.edt_number);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                //todo 编辑的内容转换成txt文件
                finalContent = edtName.getText().toString();
                stringTxt(finalContent);
                break;
        }

    }

    public static void stringTxt(String str) {
        try {
            FileWriter fw = new FileWriter("/sdcard/aaa" + "/cmd.txt");//SD卡中的路径
            fw.flush();
            fw.write(str);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
