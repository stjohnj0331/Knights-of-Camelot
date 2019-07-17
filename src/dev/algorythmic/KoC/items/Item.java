/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.items;

import dev.algorythmic.KoC.Handler;
import dev.algorythmic.KoC.gfx.Assets;
import dev.algorythmic.KoC.inventory.Inventory;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author justin
 */
public class Item {
    
    //HANDLER
    public static Item[] items = new Item[256];
    public static Item wood = new Item(Assets.wood, "Wood",0);
    public static Item stone = new Item(Assets.stone, "Stone",1);
    public static Item copperOre = new Item(Assets.copperOre, "Copper ore",2);
    public static Item copperIngot = new Item(Assets.copperIngot, "Copper Ingot",3);
    public static Item steelOre = new Item(Assets.steelOre, "Steel ore",4);
    public static Item steelIngot = new Item(Assets.steelIngot, "Steel Ingot",5);
    public static Item platinumOre = new Item(Assets.platinumOre, "Platinum ore",6);
    public static Item platinumIngot = new Item(Assets.platinumIngot, "Platinum ingot",7);
    public static Item starMetalOre = new Item(Assets.starMetalOre, "Starmetal ore",8);
    public static Item starMetalIngot = new Item(Assets.starMetalIngot, "Starmetal Ingot",9);
    
    //ITEM CLASS
    public static final int ITEM_WIDTH = 32, ITEM_HEIGHT = 32;
    
    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected Inventory inventory;
    protected final int ID;
    
    protected int x, y, count;
    protected boolean pickedUp = false;
    
    protected Rectangle bounds;
    
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
    public boolean isPickedUp(){return pickedUp;}
    public void setPickedUp(boolean pickedUp){this.pickedUp = pickedUp;}
    
    //CONSTRUCTOR
    public Item(BufferedImage texture, String name, int ID){
        this.texture = texture;
        this.name = name;
        this.ID = ID;
        count = 1;
        
        bounds = new Rectangle(x, y, ITEM_WIDTH, ITEM_HEIGHT);
        
        items[ID] = this;
        
    }
    
    //OTHER METHODS
    public void tick(){
        if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)){
            pickedUp = true;
            handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
        }
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
        bounds.x = x;
        bounds.y = y;
    }
    //TEST CODE
    public Item createNew(int count){
        Item i = new Item(texture, name, ID);
        i.setPickedUp(true);
        i.setCount(count);
        return i;
    }
}
