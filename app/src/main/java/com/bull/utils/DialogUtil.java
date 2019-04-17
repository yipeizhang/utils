package com.bull.utils;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;

import com.bull.utils.dialog.ConfirmDialog;
import com.bull.utils.dialog.LoadingDialog;
import com.bull.utils.dialog.RectangleLoadingDialog;
import com.bull.utils.dialog.TipDialog;

public class DialogUtil {

    /**
     * 显示加载条
     * @param context Activity
     * @param message 加载时显示的文字信息
     * @param progressColor 加载进度条的颜色，传入颜色资源，若使用默认颜色，传入-1即可
     */
    public static Dialog showLoadingDialog(Context context, String message, int progressColor) {
        if (TextUtils.isEmpty(message)) {
            LoadingDialog dialog = new LoadingDialog(context);
            dialog.setProgressColor(progressColor);
            dialog.show();
            return dialog;
        }
        RectangleLoadingDialog dialog = new RectangleLoadingDialog(context);
        dialog.setProgressColor(progressColor);
        dialog.setMessage(message);
        dialog.show();
        return dialog;
    }

    /**
     * 显示提示框
     * @param context
     * @param title
     * @param message
     * @param buttonText
     * @return
     */
    public static Dialog showTipDialog(Context context, String title, String message, String buttonText) {
        TipDialog dialog = new TipDialog(context).setTitle(title).setMessage(message).setButtonText(buttonText);
        dialog.show();
        return dialog;
    }

    /**
     * 显示确认框
     * @param context
     * @param title
     * @param message
     * @param sureButtonText
     * @param cancelButtonText
     * @param listener
     * @return
     */
    public static Dialog showConfirmDialog(Context context, String title, String message, String sureButtonText, String cancelButtonText, ConfirmDialog.OnButtonClickListener listener) {
        ConfirmDialog dialog = new ConfirmDialog(context).setTitle(title).setMessage(message).setSureButtonText(sureButtonText).setCancelButtonText(cancelButtonText).setOnButtonClickListener(listener);
        dialog.show();
        return dialog;
    }
}
