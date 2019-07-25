/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.entities;

import dev.algorythmic.KoC.Handler;
import dev.algorythmic.KoC.entities.creatures.Player;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author justin
 */
public class EntityManager {
    
    //CLASS VARIABLES
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    
    //ACCESSORS
    public Handler getHandler() {return handler;}
    public Player getPlayer() {return player;}
    public ArrayList<Entity> getEntities() {return entities;}
    
    //SORTING ARRAYLIST
    private Comparator<Entity> renderSorter = new Comparator<Entity>(){
        @Override public int compare(Entity a, Entity b) {
            if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
                return -1;
            return 1;
        }
    };
    
    //MUTATORS
    public void setHandler(Handler handler) { this.handler = handler;}
    public void setPlayer(Player player) {this.player = player;}
    public void setEntities(ArrayList<Entity> entities) {this.entities = entities;}
     
    //CONSTRUCTOR
    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<>();
        entities.add(player);
    }
    
    //OTHER METHODS
    public void tick(){
        for(int i = 0 ; i < entities.size() ; i++){
            Entity e = entities.get(i);
            e.tick();
        }
        entities.sort(renderSorter);
    }
    public void render(Graphics g){
        for(Entity e : entities){
            e.render(g);
        }
    }
    
    public void addEntity(Entity e){
        entities.add(e);
    }
}
