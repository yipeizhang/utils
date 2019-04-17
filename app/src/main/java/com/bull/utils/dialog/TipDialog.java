package com.bull.utils.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.bull.utils.R;

public class TipDialog extends Dialog {

    public TipDialog(Context context) {
        super(context);
        init();
    }

    private void init(){
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.dialog_tip);
        findViewById(R.id.bt_sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public TipDialog setTitle(String title){
        TextView textView = findViewById(R.id.tv_title);
        if (TextUtils.isEmpty(title)) {
            textView.setVisibility(View.GONE);
            return this;
        }
        textView.setText(title);
        return this;
    }

    public TipDialog setMessage(String msg){
        TextView textView = findViewById(R.id.tv_msg);
        textView.setText(msg);
        return this;
    }

    public TipDialog setButtonText(String buttonText){
        if (TextUtils.isEmpty(buttonText)) {
            return this;
        }
        TextView textView = findViewById(R.id.bt_sure);
        textView.setText(buttonText);
        return this;
    }

}
