/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.entities.creatures;

import dev.algorythmic.KoC.Handler;
import dev.algorythmic.KoC.entities.Entity;
import dev.algorythmic.KoC.tiles.Tile;

/**
 *
 * @author justin
 */
public abstract class Creature extends Entity{
    
    //CLASS VARIABLES
    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64,
                            DEFAULT_CREATURE_HEIGHT = 64;
    
    protected int health;
    protected float speed;
    protected float xMove, yMove;
    
    //ACCESSORS
    public int getHealth() { return health; }

    public float getSpeed() { return speed; }

    public float getxMove() { return xMove; }

    public float getyMove() { return yMove; }
    
    //MUTATORS
    public void setHealth(int health) { this.health = health; }

    public void setSpeed(float speed) { this.speed = speed; }

    public void setxMove(float xMove) { this.xMove = xMove; }

    public void setyMove(float yMove) { this.yMove = yMove; }
    
    //CONSTRUCTORS
    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }
    
    //OTHER MEHODS
    public void move(){
       moveX();
       moveY();
    }
    /**
     * Collision detection
     */
    public void moveX(){
        if(xMove > 0){//moving right
            int tx = (int)(x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            
            if(!collisionWithTile(tx,(int)(y+bounds.y) / Tile.TILE_HEIGHT) && 
                    !collisionWithTile(tx,(int)(y+bounds.y+bounds.height) / Tile.TILE_HEIGHT)){
                x+=xMove;
            }else{
                x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
            }
        }else if(xMove < 0){//moveing left
            int tx = (int)(x + xMove + bounds.x) / Tile.TILE_WIDTH;
            
            if(!collisionWithTile(tx,(int)(y+bounds.y) / Tile.TILE_HEIGHT) && 
                    !collisionWithTile(tx,(int)(y+bounds.y+bounds.height) / Tile.TILE_HEIGHT)){
                x+=xMove;
            }else{
                x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
            }
        }
            
    }
    
    public void moveY(){
         if(yMove< 0){//up
             int ty = (int)(y + yMove + bounds.y)/ Tile.TILE_HEIGHT;
             
             if(!collisionWithTile((int)(x + bounds.x) / Tile.TILE_WIDTH, ty) && 
                     !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)){
                 y += yMove;
             }else{
                 y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
             }
         }else if(yMove > 0){//down
             int ty = (int)(y + yMove + bounds.y + bounds.height)/ Tile.TILE_HEIGHT;
             
             if(!collisionWithTile((int)(x + bounds.x) / Tile.TILE_WIDTH, ty) && 
                     !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)){
                 y += yMove;
             }else{
                 y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
             }
         }
    }
    
    
    protected boolean collisionWithTile(int x, int y){
        return handler.getWorld().getTile(x, y).isNotTraversable();
    }
}
