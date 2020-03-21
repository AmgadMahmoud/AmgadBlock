package com.example.amgad.amgadblock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MyMessagesReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String messagePhoneNumber = "";
        String messageBody = "";
        String reason = "";
        Object[] parts = (Object[])intent.getExtras().get("pdus");
        for (int i =0 ; i<parts.length ; i++){
            SmsMessage sms = SmsMessage.createFromPdu((byte[]) parts[i]);
            if (i==0){
                messagePhoneNumber += sms.getDisplayOriginatingAddress();
            }
            messageBody += sms.getMessageBody();
        }
        DBHelper db = new DBHelper(context);

        String numbers = db.readNumbers();
        String[] n = numbers.split("\n");
        for (int i =0 ; i<n.length ; i++){
            if (messagePhoneNumber.contains(n[i])){
                Toast.makeText(context,"Message from blocked number\nPhone Number:"+messagePhoneNumber, Toast.LENGTH_LONG).show();
                reason += "from blocked Phone Number: "+messagePhoneNumber;
            }

        }

        String keywords = db.readKeywords();
        String[] k = keywords.split("\n");
        for (int i =0 ; i<k.length ; i++){
            String x =messageBody.toLowerCase();
            if (x.contains(k[i].toLowerCase())){
                Toast.makeText(context,"Message contains blocked keywords\nKeyword:"+k[i], Toast.LENGTH_LONG).show();
                reason += "contains blocked keywords: "+k[i];
            }
        }
        db.addMessage(messageBody,messagePhoneNumber,reason);
    }
}
