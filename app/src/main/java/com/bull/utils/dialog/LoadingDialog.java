package com.bull.utils.dialog;

import android.app.Dialog;
import android.content.Context;

import com.bull.utils.R;
import com.bull.utils.view.MaterialProgressBar;

public class LoadingDialog extends Dialog {


    public LoadingDialog(Context context) {
        super(context);
        init();
    }

    private void init(){
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.dialog_loading);
    }

    public void setProgressColor(int colorRes) {
        if (colorRes > 0) {
            MaterialProgressBar progressBar = findViewById(R.id.mpb);
            progressBar.setColor(colorRes);
        }
    }

}
