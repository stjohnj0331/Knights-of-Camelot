/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.worlds;

import dev.algorythmic.KoC.Handler;
import dev.algorythmic.KoC.entities.EntityManager;
import dev.algorythmic.KoC.entities.creatures.Player;
import dev.algorythmic.KoC.entities.statics.Tree;
import dev.algorythmic.KoC.tiles.Tile;
import dev.algorythmic.KoC.utilities.Utils;
import java.awt.Graphics;

/**
 *
 * @author justin
 */
public class World {
    //CLASS VARIABLES
    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    
    //ENTITIES
    private EntityManager entityManager;
    
    //ACCESSORS

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    //ACCESSORS
    public int getWidth(){return width;}
    public int getHeight(){return height;}
    
    //CONSTRUCTOR
    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));
        entityManager.addEntity(new Tree(handler, 100, 250));
        entityManager.addEntity(new Tree(handler, 100, 350));
        entityManager.addEntity(new Tree(handler, 100, 450));
        entityManager.addEntity(new Tree(handler, 100, 500));
        
        loadWorld(path);
        
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }
    
    //OTHER METHODS
    public void tick(){
        entityManager.tick();
    }
    
    public void render(Graphics g){
        
        int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset()/ Tile.TILE_WIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
        int yStart = (int)Math.max(0, handler.getGameCamera().getyOffset()/ Tile.TILE_HEIGHT);;
        int yEnd = (int) Math.min(width, (handler.getGameCamera().getyOffset() + handler.getWidth()) / Tile.TILE_HEIGHT + 1);;
        
        for(int y = yStart ; y < yEnd ; y++){
            for(int x = xStart ; x < xEnd ; x++){
                getTile(x,y).render(g, (int)(x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), 
                        (int)(y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
        //ENTITIES
        entityManager.render(g);
    }
    
    public Tile getTile(int x, int y){
        
        if( x < 0 || y < 0 || x > width || y > height)
            return Tile.grassTile;
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
