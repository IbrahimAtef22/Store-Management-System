package com.myprojects.storejava.presentation.desktop;

import com.myprojects.storejava.bll.BusinessLogicCore;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import storejava.dal.hibernate.entity.Categories;

public class AddCatFrame extends JFrame implements ActionListener {

    JButton homeBtn, addCatButton;
    JTextField txtField;
    JTextArea txtArea;

    public AddCatFrame() {
        this.setTitle("Add Category Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1620, 1620);
        this.setResizable(false);
        //this.setVisible(true);

        ImageIcon image = new ImageIcon("src\\main\\resources\\appicon.png");

        this.setIconImage(image.getImage());

        // JPanel = a GUI component that functions as a container to hold other components
        //create a panel
        JPanel whitePanel = new JPanel();
        whitePanel.setLayout(null);    //set layout to null
        whitePanel.setBackground(Color.WHITE);
        whitePanel.setBounds(0, 0, 1620, 150);

        ImageIcon homeIcon = new ImageIcon("src\\main\\resources\\homepage.png");

        //create a button
        homeBtn = new JButton(homeIcon);
        homeBtn.addActionListener(this);

        homeBtn.setText("<<Home");
        homeBtn.setFont(new Font("MV Boli", Font.BOLD, 20));
        homeBtn.setBounds(20, 20, 105, 100); //set position and size of button
        homeBtn.setFocusable(false);

        homeBtn.setVerticalTextPosition(JLabel.BOTTOM); //set text TOP,CENTER, BOTTOM of imageicon
        homeBtn.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT,CENTER, RIGHT of imageicon
        homeBtn.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within button
        homeBtn.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text within button

        homeBtn.setBackground(Color.BLACK);
        homeBtn.setForeground(Color.GREEN);
        homeBtn.setBorder(BorderFactory.createEtchedBorder());

        //create a label
        JLabel label = new JLabel();
        label.setText("Add Category");
        label.setForeground(Color.BLACK); //set font color of text
        label.setFont(new Font("MV Boli", Font.BOLD, 55)); //set font of text
        label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of text within label
        label.setBounds(500, 10, 500, 100); //set position and size of label

        whitePanel.add(homeBtn);   //add button to panel
        whitePanel.add(label);           //add label to panel
        whitePanel.setFocusable(false);

        this.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);    //set layout to null
        panel.setBackground(Color.WHITE);
        panel.setBounds(450, 200, 600, 600);

        JLabel label1 = new JLabel();
        label1.setText("Name:");
        label1.setForeground(Color.BLACK); //set font color of text
        label1.setFont(new Font("Serif", Font.BOLD, 24)); //set font of text
        label1.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of text within label
        label1.setBounds(5, 40, 160, 50); //set position and size of label

        // text field
        txtField = new JTextField();
        txtField.setBounds(170, 40, 350, 40);
        txtField.setBackground(Color.LIGHT_GRAY);
        txtField.setFont(new Font("Serif", Font.BOLD, 24));

        JLabel label2 = new JLabel();
        label2.setText("Description:");
        label2.setForeground(Color.BLACK); //set font color of text
        label2.setFont(new Font("Serif", Font.BOLD, 24)); //set font of text
        label2.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of text within label
        label2.setBounds(5, 130, 160, 50); //set position and size of label

        // text area
        txtArea = new JTextArea();
        txtArea.setBackground(Color.LIGHT_GRAY);
        txtArea.setFont(new Font("Serif", Font.BOLD, 24));
        txtArea.setBounds(170, 130, 350, 200);
        
        // add category button
        addCatButton = new JButton("Add");
        addCatButton.addActionListener(this);

        addCatButton.setFont(new Font("Comic Sans", Font.BOLD, 20));
        addCatButton.setBounds(300, 400, 80, 60); //set position and size of button
        addCatButton.setFocusable(false);

        addCatButton.setVerticalTextPosition(JLabel.CENTER); //set text TOP,CENTER, BOTTOM of imageicon
        addCatButton.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT,CENTER, RIGHT of imageicon
        addCatButton.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within button
        addCatButton.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text within button

        addCatButton.setBackground(Color.BLACK);
        addCatButton.setForeground(Color.GREEN);
        addCatButton.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        panel.add(label1);
        panel.add(label2);
        panel.add(txtField);
        panel.add(txtArea);
        panel.add(addCatButton);

        this.add(whitePanel); //add panel to frame
        this.add(panel);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // when click on home button
        if (e.getSource() == homeBtn) {
            this.setVisible(false);
            new MainFrame();

        }
        
        // when click on Add category button
        if (e.getSource() == addCatButton) {
            try {
                String txtName = txtField.getText();
                String txtDescription = txtArea.getText();

                if (txtName.equals("")) {
                    JOptionPane.showMessageDialog(null, "Category Name field is mandatory!!", "field required", JOptionPane.WARNING_MESSAGE);
                } else {

                    BusinessLogicCore blcAddCat = new BusinessLogicCore();
                    Categories newCategory = new Categories(txtName, txtDescription);
                    Categories categoryAdded = blcAddCat.addCategory(newCategory);

                    if (categoryAdded != null) {
                        JOptionPane.showMessageDialog(null, "New Category added with id = " + categoryAdded.getId(), "new category", JOptionPane.INFORMATION_MESSAGE);
                        txtField.setText("");
                        txtArea.setText("");
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
    }

}
