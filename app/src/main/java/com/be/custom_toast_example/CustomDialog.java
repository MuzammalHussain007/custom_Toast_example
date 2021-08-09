package com.be.custom_toast_example;

import android.app.ProgressDialog;
import android.content.Context;

public class CustomDialog {
    private ProgressDialog progressDialog ;

    public CustomDialog (Context context)
    {
        progressDialog = new ProgressDialog(context);

    }

    public void setProgressBar(String title ,String msg)
    {
        progressDialog.setTitle(title);
        progressDialog.setMessage(msg);
    }
    public void showProgress()
    {
        progressDialog.show();
    }
    public void endProgress()
    {
        progressDialog.dismiss();
    }
}
