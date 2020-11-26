package com.company;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class List{
    Main main;
    JFrame listWindow;
    ArrayList<List> mainList;
    String info, level;
    ArrayList<String> label;
    JButton saveButton, infoButton, dateButton, levelButton, labelButton;
    LocalDate date;
    LocalTime time;
    JDialog saveMessage, confirmMessage;
    ArrayList<JCheckBox> boxArr;
    int y=0;
    JLabel iconLabel;

    public List(String info, LocalDate date, LocalTime time, String level, ArrayList<String> label) {
        this.info = info;
        this.date = date;
        this.time = time;
        this.level = level;
        this.label = label;
    }

    public List(Main main){
        this.main = main;
        info = "No info";
        date = LocalDate.now();
        time = LocalTime.now();
        level = "No level";
        mainList = new ArrayList<>();
        label = new ArrayList<>();
        boxArr = new ArrayList<>();
    }

    public void createListWindow(){
        listWindow = new JFrame("New List");
        listWindow.setSize(400,400);
        listWindow.setLayout(null);
        listWindow.setVisible(true);
        createButtons();
    }

    public void createButtons(){
        saveButton = new JButton("Save");
        saveButton.setBounds(140, 300, 100, 20);
        listWindow.add(saveButton);
        saveButton.addActionListener(this.main);
        saveButton.setActionCommand("save");

        infoButton = new JButton("Set Title"); //info button to set title
        infoButton.setBounds(120,100,150,20);
        infoButton.addActionListener(this.main);
        infoButton.setActionCommand("info");
        listWindow.add(infoButton);

        dateButton = new JButton("Pick Date & Time"); //date & time button
        dateButton.setBounds(120,130,150,20);
        dateButton.addActionListener(this.main);
        dateButton.setActionCommand("date");
        listWindow.add(dateButton);

        levelButton = new JButton("Importance Level"); //importance level button
        levelButton.setBounds(120,160,150,20);
        levelButton.addActionListener(this.main);
        levelButton.setActionCommand("level");
        listWindow.add(levelButton);

        labelButton = new JButton("Add Label(s)"); //label button to add label(s)
        labelButton.setBounds(120,190,150,20);
        labelButton.addActionListener(this.main);
        labelButton.setActionCommand("label");
        listWindow.add(labelButton);
    }
    public void addOk(){ // adding ok icon
        ImageIcon icon = new ImageIcon("C:\\Users\\pc\\Desktop\\tick1.png");
        iconLabel = new JLabel(icon);
        listWindow.add(iconLabel);
    }

    public void createSaveMessage(){ // to inform the user
        saveMessage = new JDialog();
        JOptionPane.showMessageDialog(saveMessage, "Changes saved.");
    }

    public void createList(){ // adding lists into arrayList
        mainList.add(new List(getInfo(),getDate(),getTime(),getLevel(),getLabel()));
    }

    public void add(){ // to add check boxes for each list
            String labelText = "";
            for (int i = 0; i < label.size(); i++) {
                labelText += "#";
                labelText += label.get(i);
                labelText += " ";
            }
            JCheckBox box = new JCheckBox(getInfo() + " ||| " + getDate() + " & " + getTime() + " ||| " + labelText);
            box.setBackground(main.color);
            box.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
            box.setBounds(20,50+y,750,60);
            main.panel.add(box);
            boxArr.add(box);
            y+=80;
    }

    public void remove(){ // to remove the lists and the check boxes
        boolean flag = true;
            for (int t = 0; t < boxArr.size(); t++) {
                if (boxArr.get(t).isSelected()) {
                    main.panel.remove(boxArr.get(t));
                    main.panel.updateUI();
                    boxArr.remove(t); // removing boxes
                    mainList.remove(t); // removing lists
                    System.out.println("Update:");
                    print();
                    flag = false;
                }
            }
            if(flag) {
                createConfirmMessage();
            }
    }
    public void createConfirmMessage(){ // a confirm message about removing boxes
        confirmMessage = new JDialog();
        JOptionPane.showConfirmDialog(confirmMessage,"Firstly, you must select the box(es) that you want to remove from the list."
                ,"Warning", JOptionPane.DEFAULT_OPTION);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) { this.info = info; }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public ArrayList<String> getLabel() { return label; }

    public void setLabel(ArrayList<String> label) { this.label = label; }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void print() { // to print the lists
        if (mainList != null) {
            String msg = "";
            for (int j = 0; j < label.size(); j++) {
                msg += label.get(j);
                msg += " ";
            }
            System.out.println(getInfo() + " " + getDate() +
                    " " + getTime() + " " + getLevel() + " " + msg);
        } else {
            System.out.println("not found!!");
        }
        System.out.println("size of list:" + mainList.size());
    }

}
