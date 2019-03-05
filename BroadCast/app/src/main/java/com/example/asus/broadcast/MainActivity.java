package com.example.asus.broadcast;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent("com.example.asus.broadcast.customBroadCast");
//            intent.setComponent(new ComponentName("com.example.asus.broadcast",
//                    "com.example.asus.broadcast.CustomReceiver"));
                intent.setPackage("com.example.asus.broadcast");
            sendOrderedBroadcast(intent,null);
            }
        });
        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.example.asus.broadcast.customBroadCast");
            intent.setComponent(new ComponentName("com.example.asus.broadcast",
                    "com.example.asus.broadcast.CustomReceiver"));
                sendBroadcast(intent,null);
            }
        });
        intentFilter=new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver=new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }
    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context,Intent intent){
            //Toast.makeText(context,"Network change",Toast.LENGTH_SHORT).show();
            ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null&&networkInfo.isAvailable()) {
                Toast.makeText(context,"Network is Avalible",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context,"Network is unAvalible",Toast.LENGTH_SHORT).show();
            }
            }
        }
    }
