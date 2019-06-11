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
import java.io.OutputStreamWriter;
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
                writeToSdCard(finalContent);
                break;
        }
    }

    public void writeToSdCard(String s) {
        try {
            File dst = new File("/sdcard/system/test_sensor/" + "aaaaaaa" + ".txt");
            File parent = dst.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }
            FileOutputStream outStream = new FileOutputStream(dst, true);
            OutputStreamWriter writer = new OutputStreamWriter(outStream, "gb2312");
            writer.write(s);
            writer.write("\n");
            writer.flush();
            writer.close();// 记得关闭
            outStream.close();
        } catch (Exception e) {
            Log.i("test result", "file write error");
            Toast.makeText(MainActivity.this, "路径不存在！！！", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
