package com.myprojects.storejava.presentation.desktop;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener {

    JButton addCatBtn, showCatBtn, addProdBtn, showProdBtn, showSizesBtn, showBrandsBtn;
    ImageIcon icon1, icon2, icon3, icon4, icon5, icon6;

    public MainFrame() {

        this.setTitle("Store Home Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1620, 1620);
        this.setResizable(false);

        ImageIcon image = new ImageIcon("src\\main\\resources\\appicon.png");

        this.setIconImage(image.getImage());
        this.topLabel();

        // Add Category Button
        addCatBtn = new JButton();
         addCatBtn.addActionListener(this);
        addCatBtn.setBounds(350, 200, 400, 50);
        addCatBtn.setText("Add Category");

        icon1 = new ImageIcon("src\\main\\resources\\addcategory.png");

        addCatBtn.setFocusable(false);
        addCatBtn.setIcon(icon1);
        addCatBtn.setHorizontalAlignment(JLabel.LEFT);
        addCatBtn.setHorizontalTextPosition(JButton.RIGHT);
        addCatBtn.setVerticalTextPosition(JButton.CENTER);

        addCatBtn.setFont(new Font("Comic Sans", Font.BOLD, 30));
        addCatBtn.setIconTextGap(25);
        addCatBtn.setForeground(Color.red);
        addCatBtn.setBackground(Color.WHITE);
        addCatBtn.setBorder(BorderFactory.createEtchedBorder());
        

        // Show Categories Button
        showCatBtn = new JButton();
        showCatBtn.addActionListener(this);
        showCatBtn.setBounds(800, 200, 400, 50);
        showCatBtn.setText("Show Categories");

        icon2 = new ImageIcon("src\\main\\resources\\showcategories.png");

        showCatBtn.setFocusable(false);
        showCatBtn.setIcon(icon2);
        showCatBtn.setHorizontalAlignment(JLabel.LEFT);
        showCatBtn.setHorizontalTextPosition(JButton.RIGHT);
        showCatBtn.setVerticalTextPosition(JButton.CENTER);

        showCatBtn.setFont(new Font("Comic Sans", Font.BOLD, 30));
        showCatBtn.setIconTextGap(25);
        showCatBtn.setForeground(Color.red);
        showCatBtn.setBackground(Color.lightGray);
        showCatBtn.setBorder(BorderFactory.createEtchedBorder());
        

        // Add Product Button
        addProdBtn = new JButton();
        addProdBtn.setBounds(350, 300, 400, 50);
        addProdBtn.setText("Add Product");

        icon3 = new ImageIcon("src\\main\\resources\\add-product.png");

        addProdBtn.setFocusable(false);
        addProdBtn.setIcon(icon3);
        addProdBtn.setHorizontalAlignment(JLabel.LEFT);
        addProdBtn.setHorizontalTextPosition(JButton.RIGHT);
        addProdBtn.setVerticalTextPosition(JButton.CENTER);

        addProdBtn.setFont(new Font("Comic Sans", Font.BOLD, 30));
        addProdBtn.setIconTextGap(25);
        addProdBtn.setForeground(Color.red);
        addProdBtn.setBackground(Color.lightGray);
        addProdBtn.setBorder(BorderFactory.createEtchedBorder());
        

        // Show Products Button
        showProdBtn = new JButton();
        showProdBtn.setBounds(800, 300, 400, 50);
        showProdBtn.setText("Show Products");

        icon4 = new ImageIcon("src\\main\\resources\\showproducts.png");

        showProdBtn.setFocusable(false);
        showProdBtn.setIcon(icon4);
        showProdBtn.setHorizontalAlignment(JLabel.LEFT);
        showProdBtn.setHorizontalTextPosition(JButton.RIGHT);
        showProdBtn.setVerticalTextPosition(JButton.CENTER);

        showProdBtn.setFont(new Font("Comic Sans", Font.BOLD, 30));
        showProdBtn.setIconTextGap(25);
        showProdBtn.setForeground(Color.red);
        showProdBtn.setBackground(Color.lightGray);
        showProdBtn.setBorder(BorderFactory.createEtchedBorder());
        
        
        // ShowSizes Button
        showSizesBtn = new JButton();
         showSizesBtn.addActionListener(this);
        showSizesBtn.setBounds(350, 400, 400, 50);
        showSizesBtn.setText("Show Sizes");

        icon5 = new ImageIcon("src\\main\\resources\\addcategory.png");

        showSizesBtn.setFocusable(false);
        showSizesBtn.setIcon(icon1);
        showSizesBtn.setHorizontalAlignment(JLabel.LEFT);
        showSizesBtn.setHorizontalTextPosition(JButton.RIGHT);
        showSizesBtn.setVerticalTextPosition(JButton.CENTER);

        showSizesBtn.setFont(new Font("Comic Sans", Font.BOLD, 30));
        showSizesBtn.setIconTextGap(25);
        showSizesBtn.setForeground(Color.red);
        showSizesBtn.setBackground(Color.WHITE);
        showSizesBtn.setBorder(BorderFactory.createEtchedBorder());
        
        
        // Show Brands Button
        showBrandsBtn = new JButton();
        showBrandsBtn.setBounds(800, 400, 400, 50);
        showBrandsBtn.setText("Show Brands");

        icon6 = new ImageIcon("src\\main\\resources\\showproducts.png");

        showBrandsBtn.setFocusable(false);
        showBrandsBtn.setIcon(icon4);
        showBrandsBtn.setHorizontalAlignment(JLabel.LEFT);
        showBrandsBtn.setHorizontalTextPosition(JButton.RIGHT);
        showBrandsBtn.setVerticalTextPosition(JButton.CENTER);

        showBrandsBtn.setFont(new Font("Comic Sans", Font.BOLD, 30));
        showBrandsBtn.setIconTextGap(25);
        showBrandsBtn.setForeground(Color.red);
        showBrandsBtn.setBackground(Color.lightGray);
        showBrandsBtn.setBorder(BorderFactory.createEtchedBorder());
        

        this.add(addCatBtn);
        this.add(showCatBtn);
        this.add(addProdBtn);
        this.add(showProdBtn);
        this.add(showSizesBtn);
        this.add(showBrandsBtn);

        this.setLayout(null);
        this.setVisible(true);

       
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // when click on add category button
        if (e.getSource() == addCatBtn) {
            this.setVisible(false);
            AddCatFrame addCategory = new AddCatFrame();
        }
        
        // when click on show categories button
        if(e.getSource() == showCatBtn){
            this.setVisible(false);
            ShowCatFrame showCategories = new ShowCatFrame();
        }
        
        // when click on show sizes button
        if(e.getSource() == showSizesBtn){
            this.setVisible(false);
            new ShowSizesFrame();
        }
        
    }

    public void topLabel() {

        // JPanel = a GUI component that functions as a container to hold other components
        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Color.WHITE);
        whitePanel.setBounds(0, 0, 1620, 150);

        // JLabel = a GUI display area for a string of text, an image, or both
        //create a label
        JLabel label = new JLabel();

        ImageIcon icon = new ImageIcon("src\\main\\resources\\jacket.png");

        label.setText("Store Management System");
        label.setIcon(icon);

        label.setHorizontalAlignment(JLabel.LEFT); //set horizontal position of icon+text within label
        label.setVerticalAlignment(JLabel.TOP); //set vertical position of icon+text within label
        label.setHorizontalTextPosition(JLabel.RIGHT); //set text LEFT,CENTER, RIGHT of imageicon
        label.setVerticalTextPosition(JLabel.CENTER); //set text TOP,CENTER, BOTTOM of imageicon
        label.setForeground(Color.BLACK); //set font color of text
        label.setFont(new Font("MV Boli", Font.BOLD, 55)); //set font of text
        label.setIconTextGap(15); //set gap of text to image

        whitePanel.add(label);
        this.add(whitePanel);

        this.setLayout(null);

        this.pack();
        this.setSize(1620, 1620);

    }

}
