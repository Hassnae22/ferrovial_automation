package com.ferrovial.interfaceUI;


import javax.swing.*;

import com.ferrovial.accesstodatabricks.Test_AccessToDataBricks;
import com.ferrovial.accesstodatabricks.Test_Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

	public static void main(String[] args) {
		 JFrame frame = new JFrame("User Registration Form");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400, 200);

	        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

	        JLabel emailLabel = new JLabel("Email:");
	        JTextField emailField = new JTextField();

	        JLabel passwordLabel = new JLabel("Password:");
	        JPasswordField passwordField = new JPasswordField();

	        JLabel dateLabel = new JLabel("Date:");
	        JTextField dateField = new JTextField();

	        JButton submitButton = new JButton("Submit");
	        final Test_Login test_login = new Test_Login();
	        final Test_AccessToDataBricks test_AccessToDataBricks= new Test_AccessToDataBricks();
	        
	        submitButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String email = emailField.getText();
	                String password = new String(passwordField.getPassword());
	                String date = dateField.getText();

	                System.out.println("Email: " + email);
	                System.out.println("Password: " + new String(password));
	                System.out.println("Date: " + date);
	                test_login.setCredentials(email, password);
	                test_AccessToDataBricks.setDate(date);
	                
	                try {
	                    test_login.doLogIn();
	                    test_AccessToDataBricks.doAccessToDataBricks();
	                } catch (Exception err) {
	                    err.printStackTrace(); 
	                }
	            }
	        });

	        panel.add(emailLabel);
	        panel.add(emailField);
	        panel.add(passwordLabel);
	        panel.add(passwordField);
	        panel.add(dateLabel);
	        panel.add(dateField);
	        panel.add(new JLabel());
	        panel.add(submitButton);

	        frame.add(panel);
	        frame.setVisible(true);

	}
		   


	

}
