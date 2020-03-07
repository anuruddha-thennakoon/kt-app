package com.variant.ktapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Utils {
    public static SimpleDateFormat fullDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    public static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    public static SimpleDateFormat datePrayerFormat = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
    public static SimpleDateFormat dateMonthFormat = new SimpleDateFormat("dd MMM", Locale.getDefault());

    public static float convertDpToPx(Context context, float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

    public static Date parseStringDate(String date) {
        try {
            return fullDateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date parseEventStringDate(String date) {
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String getCurrentDate(){
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        return dateInString;
    }

    public static String getCurrentTime(){
        String pattern = "h.mmaa";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        return dateInString;
    }

    public static Calendar getTimeAsCal(String time){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        try {
            cal.setTime(sdf.parse(time));
            return cal;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date timeConvertToDate(String date) {
        try {
            return timeFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String getDatePrayerFormat(String date){
        Date date1 = parseEventStringDate(date);
        return datePrayerFormat.format(date1);
    }

    public static String getDateMonthFormat(String date){
        Date date1 = parseEventStringDate(date);
        return dateMonthFormat.format(date1);
    }

    public static boolean checkDateWithToday(String date){
        try {
            if(dateFormat.parse(getCurrentDate()).after(dateFormat.parse(date))){
                return true;
            }else{
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean checkConnected(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null
                    && activeNetwork.isConnectedOrConnecting();
            return isConnected;
        } catch (Exception e) {
            return false;
        }
    }

}
