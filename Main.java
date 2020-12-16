package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main implements ActionListener {
    List list = new List(this);
    Info info = new Info(this,list);
    Level level = new Level(this,list);
    Label label = new Label(this,list);
    Date_Time dateTime = new Date_Time(this,list);
    FileMenu file = new FileMenu(this,list);
    RewriteBoxes rewriteBoxes = new RewriteBoxes(this,list);
    JFrame window;
    JMenuBar menuBar;
    JMenu editMenu, sortMenu, helpMenu;
    JMenuItem add, delete, save, byDate, byLevel, aboutProgram, exit;
    JPanel panel;
    Color color = Color.lightGray;

    public static void main(String[] args){
        new Main();
    }
    public Main(){
        createWindow();
        createMenuBar();
        createPanel();
        window.setVisible(true);
    }
    public void createWindow(){
        window = new JFrame("Do Not Forget To Do");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800,600);
        window.setLayout(null);
        window.setVisible(true);
    }

    public void createMenuBar(){
        menuBar = new JMenuBar(); //Menu bar
        window.setJMenuBar(menuBar);

        editMenu = new JMenu("Edit"); //Edit menu
        menuBar.add(editMenu);

        add = new JMenuItem("Add"); //Add item in Edit menu
        editMenu.add(add);
        add.addActionListener(this);
        add.setActionCommand("add");

        delete = new JMenuItem("Delete"); //Delete item in Edit menu
        editMenu.add(delete);
        delete.addActionListener(this);
        delete.setActionCommand("delete");

        save = new JMenuItem("Save in text file"); //Save item in Edit menu
        editMenu.add(save);
        save.addActionListener(this);
        save.setActionCommand("save menu");

        exit = new JMenuItem("Exit"); //Exit item in Edit menu
        editMenu.add(exit);
        exit.addActionListener(this);
        exit.setActionCommand("exit");

        sortMenu = new JMenu("Sort"); //Sort menu to compare lists
        menuBar.add(sortMenu);

        byDate = new JMenuItem("By Date"); //to compare dates
        sortMenu.add(byDate);
        byDate.addActionListener(this);
        byDate.setActionCommand("by date");

        byLevel = new JMenuItem("By Level"); //to compare levels
        sortMenu.add(byLevel);
        byLevel.addActionListener(this);
        byLevel.setActionCommand("by level");

        helpMenu = new JMenu("Help"); //Help menu
        menuBar.add(helpMenu);

        aboutProgram = new JMenuItem("About program"); //About program item in Help menu
        helpMenu.add(aboutProgram);
        aboutProgram.addActionListener(this);
        aboutProgram.setActionCommand("help");
    }
    
    public void createPanel(){ //i created a panel to add into the window
        panel = new JPanel();
        panel.setSize(800,600);
        window.add(panel);
    }
    public void setColors(){
        if(list.level == "High") {
            color = Color.red;
        }else if(list.level == "Middle") {
            color = new Color(243, 163, 13, 255);
        }else if(list.level == "Low") {
            color = Color.yellow;
        }
    }
    public void setNull(){ //to initialize the variables
        list.info = "No info";
        list.date = LocalDate.now();
        list.time = LocalTime.now();
        list.level = "No level";
        list.label = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch (command) {
            case "add":
                list.createListWindow();
                break;
            case "delete":
                list.remove();
                break;
            case "help":
                file.helpFunction();
                break;
            case "save menu":
                file.saveFunction();
                break;
            case "exit":
                file.exitFunction();
                break;
            case "save":
                list.createList();
                list.add();
                list.listWindow.dispose();
                list.createSaveMessage();
                list.print();
                setNull();
                break;
            case "by date":
                Collections.sort(list.mainList);
                list.print();
                rewriteBoxes.rewriteCheckBoxes();
                break;
            case "by level":
                Collections.sort(list.mainList, new CompareLevels());
                list.print();
                rewriteBoxes.rewriteCheckBoxes();
                break;
            case "info":
                info.createInfoWindow();
                break;
            case "set title":
                level.setValues();
                list.addOk();
                list.iconLabel.setBounds(270,100,50,20);
                info.saveTitle();
                info.infoWindow.dispose();
                break;
            case "level":
                level.createLevelWindow();
                break;
            case "choose level":
                list.addOk();
                list.iconLabel.setBounds(270,160,50,20);
                level.levelWindow.dispose();
                break;
            case "high":
                list.setLevel("High");
                setColors();
                break;
            case "middle":
                list.setLevel("Middle");
                setColors();
                break;
            case "low":
                list.setLevel("Low");
                setColors();
                break;
            case "label":
                label.createLabelWindow();
                break;
            case "save label":
                list.addOk();
                list.iconLabel.setBounds(270,190,50,20);
                label.labelWindow.dispose();
                label.seeContentOfList();
                break;
            case "add label":
                label.addLabelIntoList();
                label.textField.setText("");
                break;
            case "date":
                dateTime.createDateWindow();
                break;
            case "pick date":
                list.addOk();
                list.iconLabel.setBounds(270,130,50,20);
                dateTime.saveSelectedDate();
                dateTime.saveSelectedTime();
                dateTime.dateWindow.dispose();
                break;
        }
    }
}
