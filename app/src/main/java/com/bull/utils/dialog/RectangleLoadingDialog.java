package com.bull.utils.dialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.bull.utils.R;
import com.bull.utils.view.MaterialProgressBar;

public class RectangleLoadingDialog extends Dialog {


    public RectangleLoadingDialog(Context context) {
        super(context);
        init();
    }

    private void init(){
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.dialog_loading_rectangle);
    }

    public void setProgressColor(int colorRes) {
        MaterialProgressBar progressBar = findViewById(R.id.mpb);
        progressBar.setColor(colorRes);
    }

    public void setMessage(String message) {
        TextView textView = findViewById(R.id.tv);
        textView.setText(message);
    }
}
