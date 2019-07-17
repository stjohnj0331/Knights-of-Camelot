/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.states;

import dev.algorythmic.KoC.Handler;
import dev.algorythmic.KoC.entities.creatures.Player;
import dev.algorythmic.KoC.worlds.World;
import java.awt.Graphics;

/**
 *
 * @author justin
 */
public class GameState extends State{
    
    private Player player;
    private World world;
    
    //CONSTRUCTOR
    /**
     * VERY ORDER SPECIFIC
     * @param handler 
     */
    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"res/worlds/worlds2.txt");
        handler.setWorld(world);
        player = new Player(handler,100,100);
    }
    
    //OTHER METHODS
    @Override public void tick() {
        world.tick();
        player.tick();
    }

    @Override public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }
    
    
    
}
