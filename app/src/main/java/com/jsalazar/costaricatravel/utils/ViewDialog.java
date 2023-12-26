package com.jsalazar.costaricatravel.utils;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.jsalazar.costaricatravel.R;

public class ViewDialog {

    public static void showDialog(Activity activity, int msgId){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_custom);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        text.setText(msgId);

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();

    }
}
