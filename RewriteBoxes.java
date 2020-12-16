package com.company;


import javax.swing.*;
import java.awt.*;

public class RewriteBoxes {
    Main main;
    List list;
    int y=0;

    public RewriteBoxes(Main main, List list) {
        this.main = main;
        this.list = list;
    }

    public void rewriteCheckBoxes(){
        list.boxArr.removeAll(list.boxArr);
        main.panel.removeAll();

        for(int t=0;t<list.mainList.size();t++) {
            String labelText = "";
            for (int i = 0; i < list.mainList.get(t).label.size(); i++) {
                labelText += "#";
                labelText += list.mainList.get(t).label.get(i);
                labelText += " ";
            }
            JCheckBox box = new JCheckBox(list.mainList.get(t).getInfo() + " ||| " + list.mainList.get(t).getDate() +
                    " & " + list.mainList.get(t).getTime() + " ||| " + labelText);
            if(list.mainList.get(t).level == "High") {
                box.setBackground(Color.red);
            }else if(list.mainList.get(t).level == "Middle") {
                box.setBackground(new Color(243, 163, 13, 255));
            }else if(list.mainList.get(t).level == "Low") {
                box.setBackground(Color.yellow);
            }
            box.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
            box.setBounds(20, 50 + y, 750, 60);
            main.panel.add(box);
            list.boxArr.add(box);
            y += 80;
        }
        main.panel.revalidate();
    }
}
