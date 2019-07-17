/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.items;

import dev.algorythmic.KoC.Handler;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author justin
 */
public class ItemManager {
    
    //CLASS VARIABLES
    private Handler handler;
    private ArrayList<Item> items;
    
    //ACCESSORS AND MUTATORS
    public Handler getHandler() {
        return handler;
    }
    
    //CONSTRUCTOR
    public ItemManager(Handler handler){
        this.handler = handler;
        items = new ArrayList<>();
    }
    
    //OTHER METHODS
    public void tick(){
        Iterator<Item> it = items.iterator();
        while(it.hasNext()){
            Item i = it.next();
            i.tick();
            if(i.getCount() == Item.PICKED_UP)
                it.remove();
        }
    }
    public void render(Graphics g){
        for(Item i : items)
            i.render(g);
    }
    public void addItem(Item i){
        i.setHandler(handler);
        items.add(i);
    }
}
