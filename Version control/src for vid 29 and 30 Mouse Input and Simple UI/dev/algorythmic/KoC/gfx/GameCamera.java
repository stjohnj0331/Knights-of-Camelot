/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.gfx;

import dev.algorythmic.KoC.Game;
import dev.algorythmic.KoC.Handler;
import dev.algorythmic.KoC.entities.Entity;
import dev.algorythmic.KoC.tiles.Tile;

/**
 *
 * @author justin
 */
public class GameCamera {
    
    //CLASS VARIABLES
    private float xOffset, yOffset;
    private Handler handler;
    
    //ACCESSORS
    public float getxOffset() {return xOffset;}

    public float getyOffset() {return yOffset;}
    
    //MUTATORS
    public void setxOffset(float xOffset) {this.xOffset = xOffset;}

    public void setyOffset(float yOffset) {this.yOffset = yOffset;}
    
    //CONSTRUCTOR
    public GameCamera(Handler handler, float xOffset, float yOffset){
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    
    //OTHER METHODS
    public void move(float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }
    
    public void centerOnEntity(Entity e){
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
        checkBlankSpace();
    }
    public void checkBlankSpace(){
        if(xOffset < 0){
            xOffset = 0;
        }else if(xOffset > handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth()){
            xOffset = handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
        }
        if(yOffset < 0){
            yOffset = 0;
        }else if(yOffset > handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight()){
            yOffset = handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
        }
    }
}
