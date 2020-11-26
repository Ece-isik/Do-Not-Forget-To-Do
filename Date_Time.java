package com.company;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Date_Time {
    Main main;
    List list;
    JButton pickDateButton;
    JFrame dateWindow;
    JFormattedTextField textDay, textMonth, textYear, textHour, textMinute;
    JLabel labelOfDay, labelOfMonth, labelOfYear, labelOfHour, labelOfMinute;
    LocalDate localDate, todayDate;
    LocalTime localTime, newTime;
    int numberOfYears, numberOfMonths, numberOfDays, numberOfHours, numberOfMinutes;

    public Date_Time(Main main, List list) {
        this.main = main;
        this.list = list;
    }

    public void createDateWindow(){ // to create date&time window
        dateWindow = new JFrame("Pick Date & Time");
        dateWindow.setSize(400, 400);
        dateWindow.setLayout(null);
        dateWindow.setVisible(true);
        pickDate();
        createTime();
    }
    public void pickDate() { // picking the date

        todayDate = LocalDate.now();
        JLabel label = new JLabel("Today's Date: " + todayDate);
        label.setBounds(110, 10, 200, 50);
        dateWindow.add(label);

        pickDateButton = new JButton("Save");
        pickDateButton.setBounds(140, 300, 100, 20);
        pickDateButton.addActionListener(this.main);
        pickDateButton.setActionCommand("pick date");
        dateWindow.add(pickDateButton);

        labelOfYear = new JLabel("Year:"); // year label
        labelOfYear.setBounds(50, 80, 50, 20);
        dateWindow.add(labelOfYear);
        textYear = new JFormattedTextField(todayDate.getYear());
        textYear.setBounds(110, 80, 50, 20);
        dateWindow.add(textYear);

        labelOfMonth = new JLabel("Month:"); // month label
        labelOfMonth.setBounds(50, 110, 50, 20);
        dateWindow.add(labelOfMonth);
        textMonth = new JFormattedTextField(todayDate.getMonthValue());
        textMonth.setBounds(110, 110, 50, 20);
        dateWindow.add(textMonth);

        labelOfDay = new JLabel("Day:"); // day label
        labelOfDay.setBounds(50, 140, 50, 20);
        dateWindow.add(labelOfDay);
        textDay = new JFormattedTextField(todayDate.getDayOfMonth());
        textDay.setBounds(110, 140, 50, 20);
        dateWindow.add(textDay);
    }

    public void saveSelectedDate(){ // saving the chosen date
        numberOfYears = (int) textYear.getValue();
        numberOfMonths = (int) textMonth.getValue();
        numberOfDays = (int) textDay.getValue();
        localDate = LocalDate.of(numberOfYears,numberOfMonths,numberOfDays);
        list.setDate(localDate);
    }

    public void createTime() { // picking a time
        localTime = LocalTime.now();

        labelOfHour = new JLabel("Hour:"); // hour label
        labelOfHour.setBounds(220, 90, 50, 20);
        dateWindow.add(labelOfHour);
        textHour = new JFormattedTextField(localTime.getHour());
        textHour.setBounds(280,90,50,20);
        dateWindow.add(textHour);

        labelOfMinute = new JLabel("Minute:"); // minute label
        labelOfMinute.setBounds(220, 120, 50, 20);
        dateWindow.add(labelOfMinute);
        textMinute = new JFormattedTextField(localTime.getMinute());
        textMinute.setBounds(280,120,50,20);
        dateWindow.add(textMinute);
    }

    public void saveSelectedTime(){ // saving the chosen time
        numberOfHours = (int) textHour.getValue();
        numberOfMinutes = (int) textMinute.getValue();
        newTime = LocalTime.of(numberOfHours,numberOfMinutes);
        list.setTime(newTime);
    }

}
