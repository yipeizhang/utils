package com.bull.utils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bull.utils.dialog.ConfirmDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DialogUtil.showLoadingDialog(MainActivity.this, "", -1);
//                DialogUtil.showTipDialog(MainActivity.this, "提示", "该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好", "知道了");
                DialogUtil.showConfirmDialog(MainActivity.this, "提示", "该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好该信号不好", "确定了", "拒绝", new ConfirmDialog.OnButtonClickListener() {
                    @Override
                    public void onSure() {
                        Toast.makeText(MainActivity.this, "哈哈", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
