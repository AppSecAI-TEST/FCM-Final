package manandharbibesh.fcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by Bibesh on 8/11/17.
 */

public class FirebaseMessaging extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        System.out.println("Notification: "+remoteMessage.getNotification());
        System.out.println("Data: "+remoteMessage.getData());
        System.out.println("Messageid: "+remoteMessage.getMessageId());
        System.out.println("send time: "+remoteMessage.getSentTime());
        showNotification(remoteMessage.getData());
    }

    void showNotification(Map<String, String> data) {
        NotificationCompat.Builder notifcation = new NotificationCompat.Builder(this)
                .setContentTitle(data.get("subject"))
                .setContentText(data.get("message"))
                .setSmallIcon(R.mipmap.ic_launcher);
        Intent intent2 = new Intent(this, MainActivity.class);
        PendingIntent intent = PendingIntent.getActivity(this, 0, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
        notifcation.setContentIntent(intent);
        NotificationManager manage = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manage.notify(1, notifcation.build());
    }
}
