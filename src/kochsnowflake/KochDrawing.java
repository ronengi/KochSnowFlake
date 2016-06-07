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
public class KochDrawing extends JPanel {

    private final int WIDTH = 400, HEIGHT = 400;
    private final int MIN = 1, MAX = 9;
    private int order;

    private final double SQ = Math.sqrt(3.0) / 6;
    
    private final int TOPX = 200, TOPY = 20;
    private final int LEFTX = 60, LEFTY = 300;
    private final int RIGHTX = 340, RIGHTY = 300;
    
    
    public KochDrawing(int order) {
        this.order = order;

        setBackground(Color.black);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    
    public void drawFractal(int order, int x1, int y1, int x5, int y5, Graphics gr) {
        int deltaX, deltaY, x2, y2, x3, y3, x4, y4;

        if (order == 1)
            gr.drawLine(x1, y1, x5, y5);
        else {
            deltaX = x5 - x1;       // distance between end points
            deltaY = y5 - y1;
            
            x2 = x1 + deltaX / 3;       // one third
            y2 = y1 + deltaY / 3;
            
            x3 = (int)((x1 + x5) / 2 + SQ * (y1 - y5));     // tip of projection
            y3 = (int)((y1 + y5) / 2 + SQ * (x5 - x1));
            
            x4 = x1 + deltaX * 2 / 3;   // two thirds
            y4 = y1 + deltaY * 2 / 3;
            
            drawFractal(order - 1, x1, y1, x2, y2, gr);
            drawFractal(order - 1, x2, y2, x3, y3, gr);
            drawFractal(order - 1, x3, y3, x4, y4, gr);
            drawFractal(order - 1, x4, y4, x5, y5, gr);
        }
    }

    
    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        
        gr.setColor(Color.green);
        drawFractal(order, TOPX, TOPY, LEFTX, LEFTY, gr);       // initial calls to drawFractal method
        drawFractal(order, LEFTX, LEFTY, RIGHTX, RIGHTY, gr);
        drawFractal(order, RIGHTX, RIGHTY, TOPX, TOPY, gr);
    }
    
    
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getMIN() {
        return MIN;
    }

    public int getMAX() {
        return MAX;
    }
       
}
