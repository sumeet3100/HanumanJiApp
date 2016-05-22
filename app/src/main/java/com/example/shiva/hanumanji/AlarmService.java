package com.example.shiva.hanumanji;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.app.hanumanji.R;

import java.sql.Timestamp;
import java.util.Calendar;
import constant.Constant;
import data.Time;
import database.DataBaseHelper;


public class AlarmService extends IntentService {
    private NotificationManager alarmNotificationManager;
    DataBaseHelper dataBaseHelper;
    protected MyApplication app;
    Calendar calendar;
    private PendingIntent pendingIntent;
    AlarmManager alarmManager;
    public AlarmService() {
        super("AlarmService");
    }

    @Override
    public void onHandleIntent(Intent intent) {
        sendNotification("Wake Up! Wake Up!");
    }

    private void sendNotification(String msg) {
        dataBaseHelper = new DataBaseHelper(this);
        app = (MyApplication)getApplication();
        calendar = Calendar.getInstance();
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        Log.d("AlarmService", "Preparing to send notification...: " + msg);
        alarmNotificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);

        Intent splash = new Intent(this,SplashAwesome.class);
        splash.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                splash, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(
                this).setContentTitle("Jai Hanuman").setSmallIcon(R.mipmap.hanumanjisplash)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
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