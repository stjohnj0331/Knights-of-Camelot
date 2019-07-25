/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.entities.creatures;

import dev.algorythmic.KoC.Handler;
import dev.algorythmic.KoC.entities.Entity;

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
        x += xMove;
        y += yMove;
    }
    
}
