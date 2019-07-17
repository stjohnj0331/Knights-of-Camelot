/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.gfx;

import dev.algorythmic.KoC.Game;
import dev.algorythmic.KoC.entities.Entity;

/**
 *
 * @author justin
 */
public class GameCamera {
    
    //CLASS VARIABLES
    private float xOffset, yOffset;
    private Game game;
    
    //ACCESSORS
    public float getxOffset() {return xOffset;}

    public float getyOffset() {return yOffset;}
    
    //MUTATORS
    public void setxOffset(float xOffset) {this.xOffset = xOffset;}

    public void setyOffset(float yOffset) {this.yOffset = yOffset;}
    
    //CONSTRUCTOR
    public GameCamera(Game game, float xOffset, float yOffset){
        this.game = game;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    
    //OTHER METHODS
    public void move(float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
    }
    
    public void centerOnEntity(Entity e){
        xOffset = e.getX() - game.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() / 2;
    }
}
