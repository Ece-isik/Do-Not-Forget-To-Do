package com.company;

import javax.swing.*;
import java.awt.*;

public class Level {
    Main main;
    List list;
    JFrame levelWindow;
    JLabel label;
    JButton chooseLevel;
    JRadioButton low, middle, high;
    ButtonGroup buttonGroup;

    public Level(Main main, List list) {
        this.main = main;
        this.list = list;
    }

    public void createLevelWindow(){ // to create level window
        levelWindow = new JFrame("Choose Importance Level");
        levelWindow.setSize(400, 400);
        levelWindow.setLayout(null);
        levelWindow.setVisible(true);
        radioButton();
    }

    public void radioButton(){ // creating the radio buttons
        label = new JLabel("Importance Level:"); //level field
        label.setBounds(120,100,150,20);
        levelWindow.add(label);

        chooseLevel = new JButton("Save");
        chooseLevel.setBounds(140, 300, 100, 20);
        chooseLevel.addActionListener(this.main);
        chooseLevel.setActionCommand("choose level");
        levelWindow.add(chooseLevel);

        high = new JRadioButton("High"); //high radio button
        high.setBackground(Color.red);
        high.setBounds(120,120,100,20);
        high.addActionListener(this.main);
        high.setActionCommand("high");

        middle = new JRadioButton("Middle"); //middle radio button
        middle.setBackground(new Color(243, 163, 13, 255));
        middle.setBounds(120,150,100,20);
        middle.addActionListener(this.main);
        middle.setActionCommand("middle");

        low = new JRadioButton("Low"); //low radio button
        low.setBackground(Color.yellow);
        low.setBounds(120,180,100,20);
        low.addActionListener(this.main);
        low.setActionCommand("low");

        buttonGroup = new ButtonGroup(); // i add all the radio buttons that i have created into this
        buttonGroup.add(high);
        buttonGroup.add(middle);
        buttonGroup.add(low);
        levelWindow.add(high);
        levelWindow.add(middle);
        levelWindow.add(low);
    }
}
