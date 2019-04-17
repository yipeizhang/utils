package com.bull.utils.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.bull.utils.R;

public class ConfirmDialog extends Dialog {

    public ConfirmDialog(Context context) {
        super(context);
        init();
    }

    private void init(){
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.dialog_confirm);
        findViewById(R.id.bt_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public ConfirmDialog setTitle(String title){
        TextView textView = findViewById(R.id.tv_title);
        if (TextUtils.isEmpty(title)) {
            textView.setVisibility(View.GONE);
            return this;
        }
        textView.setText(title);
        return this;
    }

    public ConfirmDialog setMessage(String msg){
        TextView textView = findViewById(R.id.tv_msg);
        textView.setText(msg);
        return this;
    }

    public ConfirmDialog setSureButtonText(String buttonText){
        if (TextUtils.isEmpty(buttonText)) {
            return this;
        }
        TextView textView = findViewById(R.id.bt_sure);
        textView.setText(buttonText);
        return this;
    }

    public ConfirmDialog setCancelButtonText(String buttonText){
        if (TextUtils.isEmpty(buttonText)) {
            return this;
        }
        TextView textView = findViewById(R.id.bt_cancel);
        textView.setText(buttonText);
        return this;
    }

    public ConfirmDialog setOnButtonClickListener(final OnButtonClickListener listener){
        TextView textView = findViewById(R.id.bt_sure);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onSure();
                }
                dismiss();
            }
        });
        return this;
    }

    public interface OnButtonClickListener{
        void onSure();
    }
    
}
