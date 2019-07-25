/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.states;

import dev.algorythmic.KoC.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author justin
 */
public class GameState extends State{
    
    //CONSTRUCTOR
    public GameState(){
        
    }
    
    //OTHER METHODS
    @Override public void tick() {
        
    }

    @Override public void render(Graphics g) {
        g.drawImage(Assets.dirt, 0, 0, null);
    }
    
    
    
}
