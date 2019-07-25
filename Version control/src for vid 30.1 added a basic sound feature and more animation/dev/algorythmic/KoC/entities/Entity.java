/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.entities;

import dev.algorythmic.KoC.Handler;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author justin
 */
public abstract class Entity {
    
    //CLASS VARIABLES
    protected float x, y;
    protected int width, height;
    protected Handler handler;
    protected Rectangle bounds;//collision detection
    
    public static final int DEFAULT_HEALTH = 10;
    protected int health;
    protected boolean active = true;
    
    //MUTATORS
    public void setX(float x) {this.x = x;}

    public void setY(float y) {this.y = y;}

    public void setWidth(int width) {this.width = width;}

    public void setHeight(int height) {this.height = height;}

    public void setHealth(int health) {
        this.health = health;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    //ACCESSORS
    public float getX() {return x;}

    public float getY() {return y;}

    public int getWidth() {return width;}

    public int getHeight() {return height;}

    public int getHealth() {return health;
    }

    public boolean isActive() {
        return active;
    }
    
    //CONSTRUCTOR
    public Entity(Handler handler, float x, float y, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        health = DEFAULT_HEALTH;
        
        bounds = new Rectangle(0, 0, width, height);
    }
    
    //OTHER METHODS
    public abstract void tick();
    public abstract void render(Graphics g);
    
    //DAMAGE
    public abstract void die();
    
    public void hurt(int amount){
        health -= amount;
        if(health <= 0)
            active = false;
        die();
    }
    
    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int)(x + bounds.x + xOffset),(int)(y + bounds.y + yOffset), bounds.width, bounds.height);
    }
    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0, 0).intersects(getCollisionBounds(xOffset,yOffset)))
                return true;
        }
        return false;
    }
}
