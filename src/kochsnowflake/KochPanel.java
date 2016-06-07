/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kochsnowflake;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author stimpy
 */
public class KochPanel extends JPanel {
    
    private final int WIDTH = 400, HEIGHT = 450;
    
    private KochTools tools;
    private KochDrawing drawing;
    
    public KochPanel() {
        drawing = new KochDrawing(1);
        tools = new KochTools(drawing);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(tools);
        add(Box.createVerticalStrut(5));
        add(drawing);
        
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
}
