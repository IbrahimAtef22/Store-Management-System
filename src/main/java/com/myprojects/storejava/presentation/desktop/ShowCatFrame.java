package com.myprojects.storejava.presentation.desktop;

import com.myprojects.storejava.bll.BusinessLogicCore;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import storejava.dal.hibernate.entity.Categories;

public class ShowCatFrame extends JFrame implements ActionListener {

    JButton homeBtn, btnDelete, btnUpdate;
    JTable table;
    DefaultTableModel model;
    JScrollPane scrollPane;
    JTextField textId, textName;
    JTextArea textDescription;
    JLabel labelID, labelName, labelDescription;
    BusinessLogicCore blcCat;

    public ShowCatFrame() {

        this.setTitle("Show Categories Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1620, 1620);
        this.setLayout(new BorderLayout(10, 10));
        this.setResizable(false);

        ImageIcon image = new ImageIcon("src\\main\\resources\\appicon.png");

        this.setIconImage(image.getImage());

        // JPanel = a GUI component that functions as a container to hold other components
        //create a panel
        JPanel upPanel = new JPanel();
        upPanel.setLayout(null);    //set layout to null
        upPanel.setBackground(Color.WHITE);
        upPanel.setPreferredSize(new Dimension(100, 100));

        ImageIcon homeIcon = new ImageIcon("src\\main\\resources\\homepage.png");

        //create a button
        homeBtn = new JButton(homeIcon);
        homeBtn.addActionListener(this);

        homeBtn.setText("<<Home");
        homeBtn.setFont(new Font("MV Boli", Font.BOLD, 18));
        homeBtn.setBounds(20, 10, 95, 80); //set position and size of button
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
        label.setText("All Categories");
        label.setForeground(Color.BLACK); //set font color of text
        label.setFont(new Font("MV Boli", Font.BOLD, 55)); //set font of text
        label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of text within label
        label.setBounds(500, 10, 500, 100); //set position and size of label

        // create left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);    //set layout to null
        leftPanel.setBackground(Color.pink);
        leftPanel.setPreferredSize(new Dimension(300, 100));

        try {
            blcCat = new BusinessLogicCore();
            List<Categories> resultList = blcCat.findAllCategories();

            model = new DefaultTableModel();
            model.addColumn("Id");
            model.addColumn("Category Name");
            model.addColumn("Description");

            for (Categories iCategory : resultList) {
                model.addRow(new Object[]{iCategory.getId(), iCategory.getName(), iCategory.getDescription()});

            }

            table = new JTable(model);

            table.setVisible(true);
            table.setSize(500, 500);

            // Change A JTable Background Color, Font Size, Font Color, Row Height
            table.setBackground(Color.LIGHT_GRAY);
            table.setForeground(Color.black);

            table.setFont(new Font("Comic Sans", Font.PLAIN, 16));
            table.setRowHeight(30);

            labelID = new JLabel("Id :");
            labelName = new JLabel("Category Name :");
            labelDescription = new JLabel("Description :");

            textId = new JTextField();
            textName = new JTextField();
            textDescription = new JTextArea();

            // create JButtons
            btnDelete = new JButton("Delete");
            btnUpdate = new JButton("Update");

            labelID.setBounds(20, 220, 110, 25);
            labelName.setBounds(20, 270, 110, 25);
            labelDescription.setBounds(20, 320, 110, 25);

            textId.setBounds(130, 220, 60, 25);
            textName.setBounds(130, 270, 100, 25);
            textDescription.setBounds(130, 320, 140, 100);

            btnUpdate.setBounds(80, 450, 100, 25);
            btnDelete.setBounds(80, 490, 100, 25);

            scrollPane = new JScrollPane(table);
            
            scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(30, 20));
            scrollPane.getVerticalScrollBar().setBorder(BorderFactory.createLineBorder(Color.BLACK));
            scrollPane.getVerticalScrollBar().setBackground(Color.DARK_GRAY);
            
           
            
            scrollPane.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        upPanel.add(homeBtn);   //add button to panel
        upPanel.add(label);           //add label to panel
        upPanel.setFocusable(false);

        leftPanel.add(labelID);
        leftPanel.add(labelName);
        leftPanel.add(labelDescription);
        leftPanel.add(textId);
        leftPanel.add(textName);
        leftPanel.add(textDescription);
        leftPanel.add(btnUpdate);
        leftPanel.add(btnDelete);

        this.add(upPanel, BorderLayout.NORTH); //add up panel to frame
        this.add(leftPanel, BorderLayout.WEST);
        this.add(scrollPane, BorderLayout.CENTER);
        // this.add(rightPanel, BorderLayout.EAST);

        //this.pack();
        this.setVisible(true);

        // get selected row data From table to textfields 
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();

                textId.setText(model.getValueAt(i, 0).toString());
                textName.setText(model.getValueAt(i, 1).toString());
                textDescription.setText(model.getValueAt(i, 2).toString());

            }
        });

        // button update row
        btnUpdate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();

                if (i >= 0) {
                    try {
                        String id = textId.getText();
                        String txtName = textName.getText();
                        String txtDescription = textDescription.getText();

                        if (txtName.equals("")) {
                            JOptionPane.showMessageDialog(null, "Category Name field is mandatory!!", "field required", JOptionPane.WARNING_MESSAGE);
                        } else {

                            Categories updateCategory = new Categories(txtName, txtDescription);
                            updateCategory.setId(Integer.parseInt(id));
                            Categories categoryUpdated = blcCat.editCategory(updateCategory);

                            if (categoryUpdated != null) {
                                model.setValueAt(textId.getText(), i, 0);
                                model.setValueAt(textName.getText(), i, 1);
                                model.setValueAt(textDescription.getText(), i, 2);
                                JOptionPane.showMessageDialog(null, "Category updated with id = " + categoryUpdated.getId(), "update category", JOptionPane.INFORMATION_MESSAGE);

                            }
                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }else{
                    JOptionPane.showMessageDialog(null, "" + "You should select row first !!", "info", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        
        
        // button remove row
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                     try {
                        String id = textId.getText();
                        String txtName = textName.getText();
                        String txtDescription = textDescription.getText();

                        if (txtName.equals("")) {
                            JOptionPane.showMessageDialog(null, "Category Name field is mandatory!!", "field required", JOptionPane.WARNING_MESSAGE);
                        } else {

                            Categories deletedCategory = new Categories(txtName, txtDescription);
                            deletedCategory.setId(Integer.parseInt(id));
                            blcCat.deleteCategory(deletedCategory);

                            // remove a row from jtable
                            model.removeRow(i);
                            
                                JOptionPane.showMessageDialog(null, "Category deleted with id = " + deletedCategory.getId(), "delete category", JOptionPane.INFORMATION_MESSAGE);

                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "" + "You should select row first !!", "info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // when click on home button
        if (e.getSource() == homeBtn) {
            this.setVisible(false);
            new MainFrame();

        }
    }

}
