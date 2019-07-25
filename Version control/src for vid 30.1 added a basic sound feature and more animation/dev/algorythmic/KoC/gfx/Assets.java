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
    
    public static BufferedImage[] btn_start;
    
    public static BufferedImage[] player_down;
    public static BufferedImage[] player_up;
    public static BufferedImage[] player_left;
    public static BufferedImage[] player_right;
    public static BufferedImage[] player_stand;
    public static BufferedImage[] atk_down;
    public static BufferedImage[] atk_up;
    public static BufferedImage[] atk_left;
    public static BufferedImage[] atk_right;
    
    public static void init(){
        
        //IMAGES
        SpriteSheet foliageSheet = new SpriteSheet(ImageLoader.loadImage("/textures/master-tileset-65x65.png"));
        SpriteSheet waterSheet = new SpriteSheet(ImageLoader.loadImage("/textures/waterTile.png"));
        SpriteSheet treeSheet = new SpriteSheet(ImageLoader.loadImage("/textures/tree64x128.png"));
        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/CharacterAnimationSprite.png"));
        SpriteSheet startButton = new SpriteSheet(ImageLoader.loadImage("/textures/UI/startButton350x150.png"));
        SpriteSheet startButtonHovering = new SpriteSheet(ImageLoader.loadImage("/textures/UI/startButtonHovering.png"));
        SpriteSheet attackAnimations = new SpriteSheet(ImageLoader.loadImage("/textures/Character/attackAnimationsDown.png"));
        
        //UI
            //MENU BUTTON FOR MENU STATE
            btn_start = new BufferedImage[2];
            btn_start[0] = startButton.crop(0, 0, 350, 150);
            btn_start[1] = startButtonHovering.crop(0, 0, 350, 150);
        
        //PLAYER ACTIONS
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

            player_stand = new BufferedImage[4];
            /*down*/  player_stand[0] = playerSheet.crop(0, 0, WIDTH, HEIGHT);
            /*left*/  player_stand[1] = playerSheet.crop(0, HEIGHT, WIDTH, HEIGHT);
            /*right*/ player_stand[2] = playerSheet.crop(0, HEIGHT * 2, WIDTH, HEIGHT);
            /*up*/    player_stand[3] = playerSheet.crop(0, HEIGHT * 3, WIDTH, HEIGHT);

            atk_down = new BufferedImage[3];
            atk_down[0] = attackAnimations.crop(0, 0, WIDTH, HEIGHT);
            atk_down[1] = attackAnimations.crop(WIDTH, 0, WIDTH, HEIGHT);
            atk_down[2] = attackAnimations.crop(WIDTH * 2, 0, WIDTH, HEIGHT);
            
            atk_left = new BufferedImage[3];
            atk_left[0] = attackAnimations.crop(0, 0, WIDTH, HEIGHT);
            atk_left[1] = attackAnimations.crop(0, 0, WIDTH, HEIGHT);
            atk_left[2] = attackAnimations.crop(0, 0, WIDTH, HEIGHT);
            
            atk_right = new BufferedImage[3];
            atk_right[0] = attackAnimations.crop(0, 0, WIDTH, HEIGHT);
            atk_right[1] = attackAnimations.crop(0, 0, WIDTH, HEIGHT);
            atk_right[2] = attackAnimations.crop(0, 0, WIDTH, HEIGHT);
            
            atk_up = new BufferedImage[3];
            atk_up[0] = attackAnimations.crop(0, 0, WIDTH, HEIGHT);
            atk_up[1] = attackAnimations.crop(WIDTH, 0, WIDTH, HEIGHT);
            atk_up[2] = attackAnimations.crop(WIDTH * 2, 0, WIDTH, HEIGHT);
        
         
        //TILE ASSETS 
            dirt = foliageSheet.crop(0, HEIGHT * 3, WIDTH, HEIGHT);
            sand = foliageSheet.crop(0, HEIGHT, WIDTH, HEIGHT);
            grass = foliageSheet.crop(0, HEIGHT * 2, WIDTH, HEIGHT);
            stoneWall = foliageSheet.crop(0, 0, WIDTH, HEIGHT);
            sandWall = foliageSheet.crop(0, HEIGHT * 4, WIDTH, HEIGHT);
            water = waterSheet.crop(0,0,WIDTH, HEIGHT);
            tree = treeSheet.crop(0, 0,WIDTH, HEIGHT*2);

    }
    
}
