package mx.mobilestudio.promohunters;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


//Heredamos de la clase FirebaseMessagingService que viene del SDK de Firebase
//
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public MyFirebaseMessagingService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);



        //Revisamos si el mensaje tiene info


        if(remoteMessage.getData().size() > 0){

            Log.d(this.getClass().getName(), "DATA: "+remoteMessage.getData());

        }


        if(remoteMessage.getNotification() != null){
            senddNotification(remoteMessage.getNotification().getBody());
        }

    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);

        //¿Para que demonios me dan el Token??
        //R.- Es para integrarlo en tu DB de usuarios y poder ligarlo a un cliente en Especifico.
    }



    public void senddNotification(String message){

        //Este metodo es el encargado de mandar la notifcación local con  el mensaje que recibido


        Intent intent = new Intent(this, MainActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 , intent, PendingIntent.FLAG_ONE_SHOT);


        Uri  defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.ic_launcher_background)
                                                                        .setContentTitle("Promo Hunters")
                                                                            .setAutoCancel(true)
                                                                                .setSound(defaultSoundUri)
                                                                                    .setContentIntent(pendingIntent);


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());
    }



}
