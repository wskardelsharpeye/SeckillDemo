package com.example.generaltest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DateFormatTest {

    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatDate(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static Date parse(String strDate) throws ParseException {
        return threadLocal.get().parse(strDate);
    }

    // 新建 DateTimeFormatter 类
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static String formatDate(LocalDateTime dateTime) {
        return FORMATTER.format(dateTime);
    }

    private static LocalDateTime parse2(String dateNow) {
        return LocalDateTime.parse(dateNow, FORMATTER);
    }

    public static void main(String[] args) throws ParseException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 10; j++) {

                    try {
                        System.out.println(formatDate(new Date()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }

            });
        }
        executorService.shutdown();
    }

}
