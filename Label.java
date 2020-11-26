package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Label {
    Main main;
    List list;
    JFrame labelWindow;
    JButton saveLabel, addButton;
    JLabel otherLabel, jLabel;
    JTextField textField;

    public Label(Main main, List list) {
        this.main = main;
        this.list = list;
    }

    public void createLabelWindow(){ // to create label window
        labelWindow = new JFrame("Add Label");
        labelWindow.setSize(400, 400);
        labelWindow.setLayout(null);
        labelWindow.setVisible(true);
        createLabelField();
    }

    public void createLabelField(){
        list.label = new ArrayList<>(); // to initialize the arrayList of label

        otherLabel = new JLabel("Create your own label(s):");
        otherLabel.setBounds(80,120,150,20);
        labelWindow.add(otherLabel);

        jLabel = new JLabel("(Write a label, then click on \"Add\" button.)");
        jLabel.setBounds(80,170,240,15);
        labelWindow.add(jLabel);

        textField = new JTextField();
        textField.setBounds(80,150,200,20);
        textField.setUI(new Hint("Example:homework,meeting,etc.", Color.gray));
        labelWindow.add(textField);

        addButton = new JButton("Add");
        addButton.setBounds(280,150,60,20);
        labelWindow.add(addButton);
        addButton.addActionListener(this.main);
        addButton.setActionCommand("add label");

        saveLabel = new JButton("Save");
        saveLabel.setBounds(140, 300, 100, 20);
        saveLabel.addActionListener(this.main);
        saveLabel.setActionCommand("save label");
        labelWindow.add(saveLabel);
    }

    public void addLabelIntoList(){ // adding label(s) one by one
        list.label.add(textField.getText());
        list.setLabel(list.label);
    }

    public void seeContentOfList(){ // a message dialog to see list of label(s)
        JDialog message = new JDialog();
        String msg = "";
            for (int i = 0; i < list.label.size(); i++) {
                msg += list.label.get(i);
                msg += "\n";
            }
        JOptionPane.showMessageDialog(message, "List:\n"+msg+"--------\n"+"Changes saved.");
    }
}
