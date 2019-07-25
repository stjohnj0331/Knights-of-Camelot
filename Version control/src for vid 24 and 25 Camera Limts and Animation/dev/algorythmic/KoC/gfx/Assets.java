/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author justin
 */
public class Assets {
    
    private static final int WIDTH = 64, HEIGHT = 64;
    
    public static BufferedImage sand, grass, dirt, stoneWall, sandWall, water, tree;
    public static BufferedImage[] player_down;
    public static BufferedImage[] player_up;
    public static BufferedImage[] player_left;
    public static BufferedImage[] player_right;
    public static BufferedImage[] player_stand;
    
    public static void init(){
        SpriteSheet foliageSheet = new SpriteSheet(ImageLoader.loadImage("/textures/master-tileset-65x65.png"));
        SpriteSheet waterSheet = new SpriteSheet(ImageLoader.loadImage("/textures/waterTile.png"));
        SpriteSheet treeSheet = new SpriteSheet(ImageLoader.loadImage("/textures/TreeTile90x125.png"));
        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/CharacterAnimationSprite.png"));
        
        
        
        player_down = new BufferedImage[2];
        player_down[0] = playerSheet.crop(WIDTH, 0, WIDTH, HEIGHT);
        player_down[1] = playerSheet.crop(WIDTH * 2, 0, WIDTH, HEIGHT);
        
        player_left = new BufferedImage[2];
        player_left[0] = playerSheet.crop(WIDTH, HEIGHT, WIDTH, HEIGHT);
        player_left[1] = playerSheet.crop(WIDTH * 2, HEIGHT, WIDTH, HEIGHT);
        
        player_right = new BufferedImage[2];
        player_right[0] = playerSheet.crop(WIDTH, HEIGHT * 2, WIDTH, HEIGHT);
        player_right[1] = playerSheet.crop(WIDTH * 2, HEIGHT * 2, WIDTH, HEIGHT);
        
        player_up = new BufferedImage[2];
        player_up[0] = playerSheet.crop(WIDTH, HEIGHT * 3, WIDTH, HEIGHT);
        player_up[1] = playerSheet.crop(WIDTH * 2, HEIGHT * 3, WIDTH, HEIGHT);
        
        /*
        down
        left
        right
        up
        */
        player_stand = new BufferedImage[4];
        player_stand[0] = playerSheet.crop(0, 0, WIDTH, HEIGHT);
        player_stand[1] = playerSheet.crop(0, HEIGHT, WIDTH, HEIGHT);
        player_stand[2] = playerSheet.crop(0, HEIGHT * 2, WIDTH, HEIGHT);
        player_stand[3] = playerSheet.crop(0, HEIGHT * 3, WIDTH, HEIGHT);
        
        
        dirt = foliageSheet.crop(0, HEIGHT * 3, WIDTH, HEIGHT);
        sand = foliageSheet.crop(0, HEIGHT, WIDTH, HEIGHT);
        grass = foliageSheet.crop(0, HEIGHT * 2, WIDTH, HEIGHT);
        stoneWall = foliageSheet.crop(0, 0, WIDTH, HEIGHT);
        sandWall = foliageSheet.crop(0, HEIGHT * 4, WIDTH, HEIGHT);
        water = waterSheet.crop(0,0,WIDTH, HEIGHT);
        tree = treeSheet.crop(0, 0, 90, 125);
    }
    
}
