/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.entities.creatures;

import dev.algorythmic.KoC.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author justin
 */
public class Player extends Creature{
    

    public Player(float x, float y) {
        super(x, y);
    }

    @Override public void tick() {
        
    }

    @Override public void render(Graphics g) {
        //TEMP
        g.drawImage(Assets.player, (int) x, (int) y, null);
    }
    
}
