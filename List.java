package com.company;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class List  implements Comparable<List>{
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
    int y=0, valueOfLevel;
    JLabel iconLabel;

    public List(String info, LocalDate date, LocalTime time, String level, ArrayList<String> label, int valueOfLevel) {
        this.info = info;
        this.date = date;
        this.time = time;
        this.level = level;
        this.label = label;
        this.valueOfLevel = valueOfLevel;
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
        valueOfLevel = 0;
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
        ImageIcon icon = new ImageIcon("C:\Users\pc\IdeaProjects\DoNotForgetToDo\src\com\company\tick1.png");
        iconLabel = new JLabel(icon);
        listWindow.add(iconLabel);
    }

    public void createSaveMessage(){ // to inform the user
        saveMessage = new JDialog();
        JOptionPane.showMessageDialog(saveMessage, "Changes saved.");
    }

    public void createList(){ // adding lists into arrayList
        mainList.add(new List(getInfo(),getDate(),getTime(),getLevel(),getLabel(),getValueOfLevel()));
    }

    public void add(){ // to add check boxes for each list
            String labelText = "";
        if(label.size()==0){
            labelText += "No label";
        }else {
            for (int i = 0; i < label.size(); i++) {
                labelText += "#";
                labelText += label.get(i);
                labelText += " ";
            }
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
    
    public int getValueOfLevel() {
        return valueOfLevel;
    }

    public void setValueOfLevel(int valueOfLevel) {
        this.valueOfLevel = valueOfLevel;
    }

    public void print() { // to print the lists
        if (mainList != null) {
            for(int i=0;i<mainList.size();i++) {
                String msg = "";
                if(mainList.get(i).label.size()==0){
                    msg += "No label";
                }else {
                for (int j = 0; j < mainList.get(i).label.size(); j++) {
                    msg += mainList.get(i).label.get(j);
                    msg += " ";
                }
                }
                System.out.println(mainList.get(i).getInfo() + " " + mainList.get(i).getDate() +
                        " " + mainList.get(i).getTime() + " " + mainList.get(i).getLevel() + " " + msg +
                        " " + mainList.get(i).getValueOfLevel());
            }
        } else {
            System.out.println("List is empty!!");
        }
        System.out.println("size of list:" + mainList.size());
    }

    @Override
    public int compareTo(List o) {

       return this.getDate().atTime(getTime()).compareTo(o.getDate().atTime(o.getTime()));    
    }

}
