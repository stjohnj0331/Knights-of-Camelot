/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.worlds;

import dev.algorythmic.KoC.Game;
import dev.algorythmic.KoC.tiles.Tile;
import dev.algorythmic.KoC.utilities.Utils;
import java.awt.Graphics;

/**
 *
 * @author justin
 */
public class World {
    //CLASS VARIABLES
    private Game game;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    
    //CONSTRUCTOR
    public World(Game game, String path){
        this.game = game;
        loadWorld(path);
    }
    
    //OTHER METHODS
    public void tick(){
        
    }
    
    public void render(Graphics g){
        for(int y = 0 ; y < height ; y++){
            for(int x = 0 ; x < width ; x++){
                getTile(x,y).render(g, (int)(x * Tile.TILE_WIDTH - game.getGameCamera().getxOffset()), 
                        (int)(y * Tile.TILE_HEIGHT - game.getGameCamera().getyOffset()));
            }
        }
    }
    
    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
            return Tile.dirtTile;
        return t;
    }
    
    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");// or "\\s+"
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);
        
        tiles = new int[width][height];
        for(int y = 0 ; y < height ; y++){
            for(int x = 0 ; x < width ; x++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }
}
