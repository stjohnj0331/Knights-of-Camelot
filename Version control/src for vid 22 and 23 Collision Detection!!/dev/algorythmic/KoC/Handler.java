/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC;

import dev.algorythmic.KoC.gfx.GameCamera;
import dev.algorythmic.KoC.input.KeyManager;
import dev.algorythmic.KoC.worlds.World;

/**
 *
 * @author justin
 */
public class Handler {
    
    private Game game;
    private World world;
    
    //ACCESSORS
    public Game getGame() {return game;}
    public World getWorld() {return world;}
    public KeyManager getKeyManager(){return game.getKeyManager();}
    public GameCamera getGameCamera(){return game.getGameCamera();}
    
    public int getWidth(){return game.getWidth();}
    public int getHeight(){return game.getHeight();}
    
    //MUTATORS
    public void setGame(Game game) {this.game = game;}
    public void setWorld(World world) {this.world = world;}
    
    //CONSTRUCTOR
    public Handler(Game game){
        this.game = game;
    }
    
    //OTHER METHODS
    
}
