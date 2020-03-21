package com.example.amgad.amgadblock;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyCallsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String incomingPhoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
        DBHelper db = new DBHelper(context);
        String numbers = db.readNumbers();
        String[] n = numbers.split("\n");
        for (int i =0 ; i<n.length ; i++){
            if (n[i].contains(incomingPhoneNumber)){
                Toast.makeText(context,"Incoming call from blocked number\nPhone Number:"+incomingPhoneNumber, Toast.LENGTH_LONG).show();
            }
        }

    }
}
