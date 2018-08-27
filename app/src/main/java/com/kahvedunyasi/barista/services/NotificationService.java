package com.kahvedunyasi.barista.services;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.kahvedunyasi.barista.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class NotificationService extends FirebaseMessagingService {

    private static final String TAG = "NotificationService";

    private static final String APPLICATIONID = "com.basefy.basemvpproject.";
    public static final String REFRESHED_TOKEN = APPLICATIONID + "REFRESHED_TOKEN";
    public static final String FOREGROUND = APPLICATIONID + "FOREGROUND";
    ;
    private Intent intent;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        intent = new Intent(FOREGROUND);

//        // Check if message contains a notificationData payload.
        if (remoteMessage.getData().size() > 0) {
            Map<String, String> notificationData = remoteMessage.getData();

            for (Map.Entry<String, String> entry : notificationData.entrySet()) {
                intent.putExtra(entry.getKey(), entry.getValue());
            }

            Log.d(TAG, "Message notificationData payload: " + remoteMessage.getData());
        }

        RemoteMessage.Notification notification = remoteMessage.getNotification();
        String channelId = getString(R.string.default_channel_id); // can be determined in the future. @Url https://firebase.google.com/docs/cloud-messaging/android/topic-messaging?authuser=1
        String channelName = getString(R.string.default_channel_name); // can be determined in the future.

        // Check if message contains a notification payload.
        if (notification != null) {
            intent.putExtra("title", notification.getTitle());
            intent.putExtra("message", notification.getBody());
        }

        sendBroadcast();
    }

    private void sendBroadcast() {
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.sendBroadcast(intent);
    }


    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);

        sendRegistrationToServer(s);
    }

    private void sendRegistrationToServer(String refreshedToken) {

        intent = new Intent(REFRESHED_TOKEN);

        intent.putExtra("token", refreshedToken);

        sendBroadcast();

    }

}
