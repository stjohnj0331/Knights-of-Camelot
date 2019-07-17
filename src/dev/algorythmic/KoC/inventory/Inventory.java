/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.inventory;

import dev.algorythmic.KoC.Handler;
import dev.algorythmic.KoC.gfx.Assets;
import dev.algorythmic.KoC.gfx.Text;
import dev.algorythmic.KoC.items.Item;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author justin
 */
public class Inventory {
    
    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;
    
    private int invX = 64, invY = 48, 
                invWidth = 512, invHeight = 384,
                invListCenterX = invX + 171, 
                invListCenterY = invY + invHeight / 2 + 5,
                invListSpacing = 30;
    
    private int invImageX = 452, invImageY = 82, invImageWidth = 64, 
                      invImageHeight = 64;
    
    private int invCountX = 484, invCountY = 172;
    
    private int selectedItem = 0;
    
    //ACESSORS AND MUTATORS
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public boolean isActive() {
        return active;
    }
    
    //CONSTRUCTOR
    public Inventory(Handler handler){
        this.handler = handler;
        inventoryItems = new ArrayList<>();
        
        //TEST CODE
        addItem(Item.wood.createNew(5));
        addItem(Item.copperOre.createNew(6));
        addItem(Item.copperIngot.createNew(2));
        addItem(Item.steelOre.createNew(1));
        addItem(Item.steelIngot.createNew(6));
        addItem(Item.platinumOre.createNew(6));
        addItem(Item.platinumIngot.createNew(6));
        addItem(Item.starMetalOre.createNew(6));
        addItem(Item.starMetalIngot.createNew(6));
    }
    
    //INVENTORY METHODS
    public void addItem(Item item){
        for(Item i : inventoryItems){
            if(i.getID() == item.getID()){
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
    }
    
    //OTHER METHODS
    public void tick(){
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_I))
            active = !active;
        if(!active)
            return;
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W))
            selectedItem--;
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S))
            selectedItem++;
        if(selectedItem < 0){
            selectedItem = inventoryItems.size() - 1;
        }else if(selectedItem >= inventoryItems.size()){
            selectedItem = 0;
        }
            
            
        //TEST CODE
        /*System.out.println("Inventory:");
        for(Item i : inventoryItems)
            System.out.println(i.getName()+"  "+i.getCount());*/
        //System.out.println("inventory working");
    }
    public void render(Graphics g){
        if(!active)
            return;
        g.drawImage(Assets.inventoryScreen, invX, invY, invWidth, invHeight, null);
        
        int len = inventoryItems.size();
        
        if(len == 0)
            return;
        
        for(int i = -5; i < 6 ; i++){
            if(selectedItem + i < 0 || selectedItem + i >= len)
                continue;
            if( i == 0){
                Text.drawString(g,"> "+inventoryItems.get(selectedItem + i).getName()+" <", 
                    invListCenterX, invListCenterY + i * invListSpacing, true, Color.YELLOW, Assets.font28);
            }else{
                Text.drawString(g, inventoryItems.get(selectedItem + i).getName(), 
                    invListCenterX, invListCenterY + i * invListSpacing, true, Color.white, Assets.font28);
            }
            Item item = inventoryItems.get(selectedItem);
            g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
            Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.WHITE, Assets.font28);
        }
    }
}
