package com.company;

import javax.swing.*;
import java.awt.*;

public class Info {
    Main main;
    List list;
    JFrame infoWindow;
    JLabel label;
    JTextField textInfo;
    JButton setInfoButton;

    public Info(Main main, List list) {
        this.main = main;
        this.list = list;
    }

    public void createInfoWindow() { // to create title window
        infoWindow = new JFrame("Set Title");
        infoWindow.setSize(400, 400);
        infoWindow.setLayout(null);
        infoWindow.setVisible(true);
        createInfoField();
    }

    public void createInfoField(){
        label = new JLabel("Title:"); //info field
        label.setBounds(100,150,30,20);
        infoWindow.add(label);
        textInfo = new JTextField();
        textInfo.setBounds(130,150,180,20);
        textInfo.setUI(new Hint("title", Color.gray));
        infoWindow.add(textInfo);

        setInfoButton = new JButton("Save"); //set the title
        setInfoButton.setBounds(140, 300, 100, 20);
        setInfoButton.addActionListener(this.main);
        setInfoButton.setActionCommand("set title");
        infoWindow.add(setInfoButton);
    }

    public void saveTitle(){
        list.setInfo(textInfo.getText());
    }
}
