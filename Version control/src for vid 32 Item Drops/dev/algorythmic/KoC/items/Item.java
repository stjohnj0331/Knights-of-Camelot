/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.items;

import dev.algorythmic.KoC.Handler;
import dev.algorythmic.KoC.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author justin
 */
public class Item {
    
    //HANDLER
    public static Item[] items = new Item[256];
    public static Item woodItem = new Item(Assets.wood, "Wood",0);
    
    //ITEM CLASS
    public static final int ITEM_WIDTH = 32, ITEM_HEIGHT = 32, PICKED_UP = -1;
    
    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected final int ID;
    protected int x, y, count;
    
    //ACCESSORS AND MUTATORS
    public int getID(){
        return ID;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    //CONSTRUCTOR
    public Item(BufferedImage texture, String name, int ID){
        this.texture = texture;
        this.name = name;
        this.ID = ID;
        count = 1;
        items[ID] = this;
    }
    
    //OTHER METHODS
    public void tick(){
        
    }
    public void render(Graphics g){
        if(handler == null)
            return;
        render(g, (int)(x - handler.getGameCamera().getxOffset()),
                  (int)(y - handler.getGameCamera().getyOffset()));
    }
    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, ITEM_WIDTH, ITEM_HEIGHT, null);
    }
    
    public Item createNew(int x, int y){
        Item i = new Item(texture, name, ID);
        i.setPosition(x, y);
        return i;
    }
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
}
