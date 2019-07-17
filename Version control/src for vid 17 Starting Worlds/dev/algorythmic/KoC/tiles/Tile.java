/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author justin
 */
public class Tile {
    
    //STATIC VARIABLES
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile sandTile = new SandTile(2);
    public static Tile sandWallTile = new SandWallTile(3);
    public static Tile stoneWallTile = new StoneWallTile(4);
    
    
    //CLASS
        //VARIABLES
    protected BufferedImage texture;
    protected final int id;
    public static final int TILE_WIDTH = 64,
                            TILE_HEIGHT = 64;
    
        //ACCESSORS
    public int getId(){return id;}
    
        //CONSTRUCTOR
    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;
        
        tiles[id] = this;
    }
    
        //OTHER METHODS
    public void tick(){
        
    }
    
    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }
    
    public boolean isSolid(){ return false; }
}
