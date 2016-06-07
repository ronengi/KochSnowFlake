/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kochsnowflake;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author stimpy
 */
public class KochTools extends JPanel {
    
    private final int WIDTH = 400, HEIGHT = 48;
    
    private JButton increase, decrease;
    private JLabel titleLabel, orderLabel;
    
    private KochDrawing drawing;
    
    public KochTools(KochDrawing drawing) {
        
        this.drawing = drawing;
        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(Color.yellow);
        setOpaque(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        titleLabel = new JLabel("The Koch Snowflake");
        titleLabel.setForeground(Color.black);
        
        orderLabel = new JLabel("Order: 1");
        orderLabel.setForeground(Color.black);
        
        increase = new JButton(new ImageIcon("img/arrowUp.png"));
        increase.setPressedIcon(new ImageIcon("img/arrowDown.png"));
        increase.setMargin(new Insets(0, 0, 0, 0));
        increase.addActionListener(new KochListener());
        
        decrease = new JButton(new ImageIcon("img/arrowDown.png"));
        decrease.setPressedIcon(new ImageIcon("img/arrowUp.png"));
        decrease.setMargin(new Insets(0, 0, 0, 0));
        decrease.addActionListener(new KochListener());
        
        add(Box.createHorizontalStrut(20));
        add(titleLabel);
        add(Box.createHorizontalStrut(25));
        add(decrease);
        add(increase);
        add(Box.createHorizontalStrut(25));
        add(orderLabel);
        add(Box.createHorizontalStrut(20));
        
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
    
    private class KochListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event) {
            int order = drawing.getOrder();
            
            if (event.getSource() == increase)
                ++order;
            else
                --order;
            
            if (order >= drawing.getMIN()  &&  order <= drawing.getMAX()) {
                orderLabel.setText("Order: " + order);
                drawing.setOrder(order);
                
                // getTopLevelAncestor().repaint();
                drawing.repaint();
            }
        }
        
    }
    
    
}
