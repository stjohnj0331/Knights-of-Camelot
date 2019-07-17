/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author justin
 */
public class KeyManager implements KeyListener{
    
    private boolean[] keys;
    public boolean up, down, left, right;
    public boolean aUp, aDown, aLeft, aRight;
    
    public KeyManager(){
        keys = new boolean[256];
    }
    public void tick(){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        
        aUp = keys[KeyEvent.VK_UP];
        aDown = keys[KeyEvent.VK_DOWN];
        aLeft = keys[KeyEvent.VK_LEFT];
        aRight = keys[KeyEvent.VK_RIGHT];
        
    }

    @Override public void keyTyped(KeyEvent ke) {
        
    }

    @Override public void keyPressed(KeyEvent ke) {
        keys[ke.getKeyCode()] = true;
        //System.out.println(ke.getKeyChar()+" was pressed!");
    }

    @Override public void keyReleased(KeyEvent ke) {
     keys[ke.getKeyCode()] = false;   
    }
    
}
