package com.variant.ktapp.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
    public static final int SEC = 60;
    public static final int MIN = 60;
    public static final int HOUR = 24;
    public static final int DAY = 30;
    public static final int MONTH = 12;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 'at' h.mm aa");
    private static final SimpleDateFormat simpleDateFormatEvent = new SimpleDateFormat("MMM dd, h.mm aa");
    private static final SimpleDateFormat simpleDonationFormatEvent = new SimpleDateFormat("dd MMM");
    private static final SimpleDateFormat simpleTimeFormatEvent = new SimpleDateFormat("h.mmaa");
    private static final SimpleDateFormat dateFormatEvent = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormatEventNotification = new SimpleDateFormat("h.mmaa MMM dd");

    private static TimeUtils timeUtils;

    public static TimeUtils getInstance() {
        if (timeUtils == null) {
            timeUtils = new TimeUtils();
        }
        return timeUtils;
    }

    public String getRelativeTime(Date date) {
        long curTime = System.currentTimeMillis();
        long diffTime = (curTime - date.getTime()) / 1000;
        String msg;
        if (diffTime < SEC) {
            msg = "Few seconds ago";
        } else if ((diffTime /= SEC) < MIN) {
            msg = (diffTime == 1) ? "1 minute ago" : diffTime + " minutes ago";
        } else if ((diffTime /= MIN) < HOUR) {
            msg = (diffTime == 1) ? "An hour ago" : diffTime + " hours ago";
        } else if ((diffTime /= HOUR) < DAY) {
            msg = (diffTime == 1) ? "Yesterday" : diffTime + " days ago";
        } else if ((diffTime /= DAY) < MONTH) {
            msg = (diffTime == 1) ? "Month ago" : diffTime + " months ago";
        } else {
            msg = simpleDateFormat.format(date);
        }
        return msg;
    }

    public String getEventTime(Date date) {
        Calendar now = Calendar.getInstance();
        Calendar givenCal = Calendar.getInstance();
        givenCal.setTime(date);
        String msg = simpleDateFormatEvent.format(date);
        if (now.get(Calendar.DATE) == givenCal.get(Calendar.DATE)) {
            return "Today, " + simpleTimeFormatEvent.format(date);
        } else {
            return msg;
        }
    }

    public String getEventCalendarTime(Date date) {
        Calendar now = Calendar.getInstance();
        Calendar givenCal = Calendar.getInstance();
        givenCal.setTime(date);
        String msg = simpleDonationFormatEvent.format(date);
        return msg;
    }

    public String getDonationHistoryTime(Date date) {
        String msg = simpleDonationFormatEvent.format(date);
        return msg;
    }

    public static String getPrayerTime(String date) {
        Date date1 =  Utils.parseEventStringDate(date);
        String msg = simpleDonationFormatEvent.format(date1);
        return msg;
    }

    public static String getPrayerTimeFormat(Date date) {
        String msg = simpleTimeFormatEvent.format(date);
        return msg;
    }

    public static String getPrayerDateFormat(Date date) {
        String msg = dateFormatEvent.format(date);
        return msg;
    }

    public static String getEventNotificationDateFormat(Date date) {
        String msg = timeFormatEventNotification.format(date);
        return msg;
    }

}
