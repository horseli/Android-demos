package com.example.asus.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.widget.Button;
import android.widget.Toast;

public class AnotherCustomReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        Toast toast=Toast.makeText(context,"Receive AnotherCustomReceiver",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
        //abortBroadcast();
    }

}

