/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.entities;

import dev.algorythmic.KoC.Game;
import dev.algorythmic.KoC.Handler;
import java.awt.Graphics;

/**
 *
 * @author justin
 */
public abstract class Entity {
    
    //CLASS VARIABLES
    protected float x, y;
    protected int width, height;
    protected Handler handler;
    
    //MUTATORS
    public void setX(float x) {this.x = x;}

    public void setY(float y) {this.y = y;}

    public void setWidth(int width) {this.width = width;}

    public void setHeight(int height) {this.height = height;}
    
    //ACCESSORS
    public float getX() {return x;}

    public float getY() {return y;}

    public int getWidth() {return width;}

    public int getHeight() {return height;}
    
    //CONSTRUCTOR
    public Entity(Handler handler, float x, float y, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    //OTHER METHODS
    public abstract void tick();
    public abstract void render(Graphics g);
    
}
