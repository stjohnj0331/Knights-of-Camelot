/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.states;

import dev.algorythmic.KoC.Game;
import dev.algorythmic.KoC.entities.creatures.Player;
import dev.algorythmic.KoC.tiles.Tile;
import java.awt.Graphics;

/**
 *
 * @author justin
 */
public class GameState extends State{
    
    private Player player;
    
    //CONSTRUCTOR
    public GameState(Game game){
        super(game);
        player = new Player(game,100,100);
    }
    
    //OTHER METHODS
    @Override public void tick() {
        player.tick();
    }

    @Override public void render(Graphics g) {
        player.render(g);
        Tile.tiles[0].render(g, 0, 0);
        Tile.tiles[2].render(g, 64,0);
    }
    
    
    
}
