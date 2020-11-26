package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FileMenu {
    Main main;
    List list;
    int response;
    String fileName;
    String fileDirectory;
    JPanel panel;
    JLabel label;

    public FileMenu(Main main, List list) {
        this.main=main;
        this.list=list;
    }

    public void saveFunction() { // to save the lists into file
        FileDialog fileDialog = new FileDialog(main.window, "Save File", FileDialog.SAVE);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            fileName = fileDialog.getFile();
            fileDirectory = fileDialog.getDirectory();
            main.window.setTitle(fileName);
        }
        try {
            File file = new File(fileDirectory + fileName);
            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            String msg = "";
            for (int i = 0; i < list.mainList.size(); i++) {
                for (int j = 0; j < list.mainList.get(i).getLabel().size(); j++) {
                    msg += list.mainList.get(i).getLabel().get(j);
                    msg += " ";
                }
                bw.write(list.mainList.get(i).getInfo() + " " + list.mainList.get(i).getDate() + " " +
                        list.mainList.get(i).getTime() + " " + list.mainList.get(i).getLevel() + " " + msg);
                bw.newLine();
            }bw.close();

        } catch (Exception e) {
            System.out.println("File is not saved.");
        }

    }

    public void exitFunction() {
        messagePanel();
        panel.setVisible(true);
        if (response == 0) { //Yes
            saveFunction();
        } else if (response == 1) { //No
            System.exit(0);
        }
    }

    public void messagePanel() { //Sending a message which clarifies if user wants a file to be saved
        panel = new JPanel();
        panel.setSize(250, 100);
        panel.setLayout(null);

        label = new JLabel("Would you like to save that file before closing?");
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(40, 80, 280, 20);
        panel.add(label);

        UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
        response = JOptionPane.showConfirmDialog(null, panel, "Warning",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
    }

    public void helpFunction() {
        JDialog help = new JDialog();
        JOptionPane.showMessageDialog(help, "Created by Ece IŞIK");
    }
}
