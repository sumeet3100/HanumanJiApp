package com.example.shiva.hanumanji;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import com.app.hanumanji.R;

import java.util.Calendar;

import database.DataBaseHelper;

public class AlarmReceiver extends WakefulBroadcastReceiver {

    private NotificationManager alarmNotificationManager;
    DataBaseHelper dataBaseHelper;
    protected MyApplication app;
    Calendar calendar;
    private PendingIntent pendingIntent;
    AlarmManager alarmManager;

    String parentId="";
    @Override
    public void onReceive(final Context context, Intent intent) {
        //this will update the UI with message
//        DemoAlarmActivity inst = DemoAlarmActivity.instance();
//        inst.setAlarmText("Alarm! Wake up! Wake up!");

        //this will sound the alarm tone
        //this will sound the alarm once, if you wish to
        //raise alarm in loop continuously then use MediaPlayer and setLooping(true)
//        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
//        if (alarmUri == null) {
//            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        }
//        Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
//        ringtone.play();


//        try {
//            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//            Ringtone r = RingtoneManager.getRingtone(context, notification);
//            r.play();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //this will send a notification message
//        ComponentName comp = new ComponentName(context.getPackageName(),
//                AlarmService.class.getName());
//        startWakefulService(context, (intent.setComponent(comp)));
//        setResultCode(Activity.RESULT_OK);

        sendNotification("Wake Up! Wake Up!",context);



    }



    private void sendNotification(String msg,Context context) {
        dataBaseHelper = new DataBaseHelper(context);
//        app = (MyApplication)context.getApplication();
        calendar = Calendar.getInstance();
//        alarmManager = (AlarmManager)context.getSystemService();

        Log.d("AlarmService", "Preparing to send notification...: " + msg);
        alarmNotificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        Intent splash = new Intent(context,SplashAwesome.class);
        splash.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                splash, PendingIntent.FLAG_UPDATE_CURRENT);
//Define sound URI
                Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
//        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(
                context).setContentTitle("Jai Hanuman").setSmallIcon(R.mipmap.hanumanjisplash)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg)).setSound(alarmUri)
                .setContentText(msg).setAutoCancel(true);


        alamNotificationBuilder.setContentIntent(contentIntent);
        alarmNotificationManager.notify(1, alamNotificationBuilder.build());
        Log.d("AlarmService", "Notification sent.");



//            String appDayId = app.getDayId();
//            // int day = Integer.parseInt(time.getDay());
//            boolean checkForSunday = true;
//            boolean checkForMonday = true;
//            boolean checkForTuesday = true;
//            boolean checkForWednesday = true;
//            boolean checkForThursday = true;
//            boolean checkForFriday = true;
//            boolean checkForSaturday = true;
//
//
//            if(appDayId.equalsIgnoreCase(Constant.sunday)){
//
//                checkForSunday = false;
//
//            }else if(appDayId.equalsIgnoreCase(Constant.monday)){
//
//                checkForMonday = false;
//
//            }else if(appDayId.equalsIgnoreCase(Constant.tuesday)){
//                checkForTuesday = false;
//
//            }else if(appDayId.equalsIgnoreCase(Constant.wednesday)){
//
//                checkForWednesday = false;
//
//            }else if(appDayId.equalsIgnoreCase(Constant.thursday)){
//
//                checkForThursday = false;
//
//            }else if(appDayId.equalsIgnoreCase(Constant.friday)){
//
//                checkForFriday = false;
//
//            }else if(appDayId.equalsIgnoreCase(Constant.saturday)){
//
//                checkForSaturday = false;
//            }
//
//            if(checkForSunday){
//
//
//                String day = Constant.sunday;
//                Time timeFromDatabase = dataBaseHelper.getData(day);
//                if(timeFromDatabase!=null){
//
//                    setAlarmAccordingToTime(timeFromDatabase);
//                }
//
//
//
//            }else if(checkForMonday){
//
//                String day = Constant.monday;
//                Time timeFromDatabase = dataBaseHelper.getData(day);
//                if(timeFromDatabase!=null){
//
//                    setAlarmAccordingToTime(timeFromDatabase);
//                }
//
//            }else if(checkForTuesday){
//
//                String day = Constant.tuesday;
//                Time timeFromDatabase = dataBaseHelper.getData(day);
//                if(timeFromDatabase!=null){
//
//                    setAlarmAccordingToTime(timeFromDatabase);
//                }
//
//            }else if(checkForWednesday){
//
//                String day = Constant.wednesday;
//                Time timeFromDatabase = dataBaseHelper.getData(day);
//                if(timeFromDatabase!=null){
//
//                    setAlarmAccordingToTime(timeFromDatabase);
//                }
//
//
//            }else if(checkForThursday){
//
//                String day = Constant.thursday;
//                Time timeFromDatabase = dataBaseHelper.getData(day);
//                if(timeFromDatabase!=null){
//
//                    setAlarmAccordingToTime(timeFromDatabase);
//                }
//
//            }else if(checkForFriday){
//
//                String day = Constant.friday;
//                Time timeFromDatabase = dataBaseHelper.getData(day);
//                if(timeFromDatabase!=null){
//
//                    setAlarmAccordingToTime(timeFromDatabase);
//                }
//
//            }else if(checkForSaturday){
//
//                String day = Constant.saturday;
//                Time timeFromDatabase = dataBaseHelper.getData(day);
//                if(timeFromDatabase!=null){
//
//                    setAlarmAccordingToTime(timeFromDatabase);
//                }
//            }


    }

}
