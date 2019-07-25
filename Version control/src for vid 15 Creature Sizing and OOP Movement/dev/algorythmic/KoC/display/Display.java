/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;



/**
 *
 * @author justin
 * This class handles the creation of our JFrame to display our game
 */
public class Display {
    //CLASS VARIABLES
    private JFrame frame;//where we display our images
    private Canvas canvas;//where we draw our images to
    
    private String title;
    private int width, height;
    
    //ACCESSORS
    public Canvas getCanvas(){return canvas;}
    public JFrame getFrame(){return frame;}
    
    //CONSTRUCTOR
    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }
    
    //OTHER METHODS
    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        //initializing our canvas and locking its size
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        
        frame.add(canvas);
        frame.pack();
    }
}
