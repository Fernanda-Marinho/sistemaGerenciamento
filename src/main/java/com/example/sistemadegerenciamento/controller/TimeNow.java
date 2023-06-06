package com.example.sistemadegerenciamento.controller;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeNow {
    public static volatile boolean stop = false;
    public static void timeNow(Label label){
        Thread thread = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy - hh:mm:ss a");
            while(!stop){
                try{
                    Thread.sleep(1000); //1 sec
                } catch (Exception e){
                    System.out.println(e.toString());
                }
                final String timenow = sdf.format(new Date());
                Platform.runLater(() -> {
                    label.setText(timenow);
                });
            }
        });
        thread.start();
    }
}
