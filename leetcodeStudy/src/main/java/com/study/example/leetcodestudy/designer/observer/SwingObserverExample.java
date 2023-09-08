package com.study.example.leetcodestudy.designer.observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingObserverExample {

    JFrame jFrame;

    public static void main(String[] args) {

        SwingObserverExample swingObserverExample = new SwingObserverExample();
        swingObserverExample.go();

    }

    private void go() {
        jFrame = new JFrame();
        JButton s = new JButton("should i do it ?");
        AngelListener angelListener = new AngelListener();
        DevilListener devilListener = new DevilListener();
        s.addActionListener(angelListener);
        s.addActionListener(devilListener);
        jFrame.getContentPane().add(BorderLayout.CENTER,s);
    }


    class AngelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("不要做");
        }
    }

    class DevilListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("赶快做");
        }
    }


}
