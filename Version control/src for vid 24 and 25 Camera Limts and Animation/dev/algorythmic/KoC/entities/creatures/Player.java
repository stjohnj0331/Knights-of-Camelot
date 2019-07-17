/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.entities.creatures;

import dev.algorythmic.KoC.Handler;
import dev.algorythmic.KoC.gfx.Animation;
import dev.algorythmic.KoC.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author justin
 */
public class Player extends Creature{
    
    //ANIMATIONS
    private Animation animDown, animUp, animLeft, animRight, animStand;
    private int lastXDir, lastYDir;
    
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, 150, 150);
        //customize this to fit your character.
        bounds.x = 67;
        bounds.y = 78;
        bounds.width = 18;
        bounds.height = 30;
        
        //ANIMATIONS
        animDown = new Animation(500, Assets.player_down);
        animUp = new Animation(500, Assets.player_up);
        animLeft = new Animation(500, Assets.player_left);
        animRight = new Animation(500, Assets.player_right);
        animStand = new Animation(500,Assets.player_stand);
    }

    @Override public void tick() {
        //ANIMATIONS
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        animStand.tick();
        
        //MOVEMENT
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }
    
    private void getInput(){
        xMove = 0;
        yMove = 0;
        lastYDir = 0;
        lastXDir = 0;
        if(handler.getKeyManager().up){
            yMove = -speed;
            lastYDir = -1;
        }
        if(handler.getKeyManager().down){
            yMove = speed;
            lastYDir = 1;
        }
        if(handler.getKeyManager().left){
            xMove = -speed;
            lastXDir = -1;
        }
        if(handler.getKeyManager().right){
            xMove = speed;
            lastXDir = 1;
        }
    }
    @Override public void render(Graphics g) {
        
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), 
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        
        //for making the collision box visible
        //g.setColor(Color.red);
        //g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
                //(int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }
    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){//left
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){//right
            return animRight.getCurrentFrame();
        }else if(yMove < 0){//up
            return animUp.getCurrentFrame();
        }else if(yMove > 0){//down
            return animDown.getCurrentFrame();
        }else if(lastYDir == 0 && lastXDir > 0){//standing right
                return Assets.player_stand[2];
        }else if(lastYDir == 0 && lastXDir < 0){//facing left
                return Assets.player_stand[1];
        }else if(lastXDir == 1 && lastYDir > 0){//facing up
                return Assets.player_stand[3];
        }else//facing down
            return Assets.player_stand[0];
        
    }
}
