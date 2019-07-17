/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.entities.creatures;

import dev.algorythmic.KoC.Handler;
import dev.algorythmic.KoC.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author justin
 */
public class Player extends Creature{
    
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, 100, 100);
    }

    @Override public void tick() {
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }
    
    private void getInput(){
        xMove = 0;
        yMove = 0;
        if(handler.getKeyManager().up)
            yMove = -speed;
        if(handler.getKeyManager().down)
            yMove = speed;
        if(handler.getKeyManager().left)
            xMove = -speed;
        if(handler.getKeyManager().right)
            xMove = speed;
    }
    @Override public void render(Graphics g) {
        //TEST CODE
        g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()), 
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }
    
}
