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
    
    public static BufferedImage player, sand, grass, dirt, stoneWall, sandWall;
    
    public static void init(){
        SpriteSheet foliageSheet = new SpriteSheet(ImageLoader.loadImage("/textures/master-tileset-65x65.png"));
        SpriteSheet characters = new SpriteSheet(ImageLoader.loadImage("/textures/Player.png"));
        
        player = characters.crop(0,0,WIDTH,HEIGHT);
        dirt = foliageSheet.crop(0, HEIGHT * 3, WIDTH, HEIGHT);
        sand = foliageSheet.crop(0, HEIGHT, WIDTH, HEIGHT);
        grass = foliageSheet.crop(0, HEIGHT * 2, WIDTH, HEIGHT);
        stoneWall = foliageSheet.crop(0, 0, WIDTH, HEIGHT);
        sandWall = foliageSheet.crop(0, HEIGHT * 4, WIDTH, HEIGHT);
    }
    
}
