/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.input;

import dev.algorythmic.KoC.ui.UIManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author justin
 */
public class MouseManager implements MouseListener, MouseMotionListener{
    
    private boolean rightPressed, leftPressed;
    private int mouseX, mouseY;
    private UIManager uiManager;
    
    //ACCESSORS && MUTATORS
    public boolean isLeftPressed(){return leftPressed;}
    public boolean isRightPressed(){return rightPressed;}
    public int getMouseX(){return mouseX;}
    public int getMouseY(){return mouseY;}
    public void setUIManager(UIManager uiManager){
        this.uiManager = uiManager;
    }
    
    //CONSTRUCTOR
    public MouseManager(){
        
    }
    
    //IMPLEMENTED METHODS
    @Override public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftPressed = true;
        if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed = true;
    }
    @Override public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftPressed = false;
        if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed = false;
        
        if(uiManager != null)
            uiManager.onMouseRelease(e);
    }
    @Override public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        if(uiManager != null)
            uiManager.onMouseMove(e);
    }
    //NOT USED
    @Override public void mouseDragged(MouseEvent e) {
        
    }
    @Override public void mouseClicked(MouseEvent e) {
        
    }
    @Override public void mouseEntered(MouseEvent e) {
        
    }
    @Override public void mouseExited(MouseEvent e) {
        
    }
}
