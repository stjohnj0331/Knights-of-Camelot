/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

/**
 *
 * @author justin
 */
public class GFXAssets {
    
    private static final int WIDTH = 64, HEIGHT = 64;
    //TILE ASSETS
    public static BufferedImage sand, grass, dirt, stoneWall, sandWall, water, 
            tree, wood, rock, stone, copperOre, steelOre, platinumOre, starMetalOre, 
            copperIngot, steelIngot, platinumIngot, starMetalIngot;
    //UI
    public static BufferedImage[] btn_start;
    public static BufferedImage inventoryScreen;
    public static Font font28;
    //ANIMATION
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
        SpriteSheet foliageSheet = new SpriteSheet(ImageLoader.loadImage("/textures/world/master-tileset-65x65.png"));
        SpriteSheet waterSheet = new SpriteSheet(ImageLoader.loadImage("/textures/world/waterTile.png"));
        SpriteSheet treeSheet = new SpriteSheet(ImageLoader.loadImage("/textures/world/tree64x128.png"));
        SpriteSheet startButton = new SpriteSheet(ImageLoader.loadImage("/textures/UI/startButton350x150.png"));
        SpriteSheet startButtonHovering = new SpriteSheet(ImageLoader.loadImage("/textures/UI/startButtonHovering.png"));
        SpriteSheet woodSheet = new SpriteSheet(ImageLoader.loadImage("/textures/world/wood120x120.png"));
        SpriteSheet worldDrops = new SpriteSheet(ImageLoader.loadImage("/textures/world/worldDrops.png"));
        SpriteSheet RockSpriteSheet = new SpriteSheet(ImageLoader.loadImage("/textures/world/RocksSpriteSheet32x32.png"));
        
        //UI
            //FONT
            font28 = FontLoader.loadFont("res/textures/UI/Fonts/slkscr.ttf", 28f);
            //INVENTORY UI
            inventoryScreen = ImageLoader.loadImage("/textures/UI/inventoryScreen.png");
            //MENU BUTTON FOR MENU STATE
            btn_start = new BufferedImage[2];
            btn_start[0] = startButton.crop(0, 0, 350, 150);
            btn_start[1] = startButtonHovering.crop(0, 0, 350, 150);
        
        //PLAYER ACTIONS
            //MOVE  (xCoord, yCoord, width, height)
            SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Character/Character_1_animations.png"));
            player_down = new BufferedImage[2];
            player_down[0] = playerSheet.crop(WIDTH, HEIGHT * 5, WIDTH, HEIGHT);
            player_down[1] = playerSheet.crop(WIDTH * 2, HEIGHT * 5, WIDTH, HEIGHT);

            player_left = new BufferedImage[2];
            player_left[0] = playerSheet.crop(WIDTH, HEIGHT * 6, WIDTH, HEIGHT);
            player_left[1] = playerSheet.crop(WIDTH * 2, HEIGHT * 6, WIDTH, HEIGHT);

            player_right = new BufferedImage[2];
            player_right[0] = playerSheet.crop(WIDTH, HEIGHT * 7, WIDTH, HEIGHT);
            player_right[1] = playerSheet.crop(WIDTH * 2, HEIGHT * 7, WIDTH, HEIGHT);

            player_up = new BufferedImage[2];
            player_up[0] = playerSheet.crop(WIDTH, HEIGHT * 8, WIDTH, HEIGHT);
            player_up[1] = playerSheet.crop(WIDTH * 2, HEIGHT * 8, WIDTH, HEIGHT);

            player_stand = new BufferedImage[4];
            /*down*/  player_stand[0] = playerSheet.crop(0, HEIGHT * 3, WIDTH, HEIGHT);
            /*left*/  player_stand[1] = playerSheet.crop(WIDTH, HEIGHT * 3, WIDTH, HEIGHT);
            /*right*/ player_stand[2] = playerSheet.crop(WIDTH * 2, HEIGHT * 3, WIDTH, HEIGHT);
            /*up*/    player_stand[3] = playerSheet.crop(WIDTH * 3, HEIGHT * 3, WIDTH, HEIGHT);

            //ATTACK
            atk_down = new BufferedImage[5];
            atk_down[0] = playerSheet.crop(0, 0, WIDTH, HEIGHT);
            atk_down[1] = playerSheet.crop(WIDTH, 0, WIDTH, HEIGHT);
            atk_down[2] = playerSheet.crop(WIDTH *2, 0, WIDTH, HEIGHT);
            atk_down[3] = playerSheet.crop(WIDTH * 3, 0, WIDTH, HEIGHT);
            atk_down[4] = playerSheet.crop(WIDTH * 4, 0, WIDTH, HEIGHT);
            
            atk_left = new BufferedImage[5];
            atk_left[0] = playerSheet.crop(0, HEIGHT, WIDTH, HEIGHT);
            atk_left[1] = playerSheet.crop(WIDTH, HEIGHT, WIDTH, HEIGHT);
            atk_left[2] = playerSheet.crop(WIDTH * 2, HEIGHT, WIDTH, HEIGHT);
            atk_left[3] = playerSheet.crop(WIDTH * 3, HEIGHT, WIDTH, HEIGHT);
            atk_left[4] = playerSheet.crop(WIDTH * 4, HEIGHT, WIDTH, HEIGHT);
            
            atk_right = new BufferedImage[5];
            atk_right[0] = playerSheet.crop(0, HEIGHT * 2, WIDTH, HEIGHT);
            atk_right[1] = playerSheet.crop(WIDTH, HEIGHT * 2, WIDTH, HEIGHT);
            atk_right[2] = playerSheet.crop(WIDTH * 2, HEIGHT * 2, WIDTH, HEIGHT);
            atk_right[3] = playerSheet.crop(WIDTH * 3, HEIGHT * 2, WIDTH, HEIGHT);
            atk_right[4] = playerSheet.crop(WIDTH * 4, HEIGHT * 2, WIDTH, HEIGHT);
            
            atk_up = new BufferedImage[5];
            atk_up[0] = playerSheet.crop(0, HEIGHT * 4, WIDTH, HEIGHT);
            atk_up[1] = playerSheet.crop(WIDTH, HEIGHT * 4, WIDTH, HEIGHT);
            atk_up[2] = playerSheet.crop(WIDTH * 2, HEIGHT * 4, WIDTH, HEIGHT);
            atk_up[3] = playerSheet.crop(WIDTH * 3, HEIGHT * 4, WIDTH, HEIGHT);
            atk_up[4] = playerSheet.crop(WIDTH * 4, HEIGHT * 4, WIDTH, HEIGHT);
        
         
        //TILE ASSETS 
            dirt = foliageSheet.crop(0, HEIGHT * 3, WIDTH, HEIGHT);
            sand = foliageSheet.crop(0, HEIGHT, WIDTH, HEIGHT);
            
            grass = foliageSheet.crop(0, HEIGHT * 2, WIDTH, HEIGHT);
            stoneWall = foliageSheet.crop(0, 0, WIDTH, HEIGHT);
            
            sandWall = foliageSheet.crop(0, HEIGHT * 4, WIDTH, HEIGHT);
            water = waterSheet.crop(0,0,WIDTH, HEIGHT);
            
            tree = treeSheet.crop(0, 0,WIDTH, HEIGHT*2);
            rock = RockSpriteSheet.crop(0,10+HEIGHT * 10 / 2,WIDTH/2,HEIGHT/2);
            
        //ITEM ASSETS    
            wood = woodSheet.crop(0, 0, 120, 120);
            stone = RockSpriteSheet.crop(0,HEIGHT * 10 / 2,WIDTH/2,HEIGHT/2);
            
            copperOre = worldDrops.crop(20+WIDTH * 3,35,WIDTH, HEIGHT);
            copperIngot = worldDrops.crop(20+WIDTH * 3,HEIGHT+50,WIDTH, HEIGHT);
            
            steelOre = worldDrops.crop(47+WIDTH * 4,35,WIDTH, HEIGHT);
            steelIngot = worldDrops.crop(47+WIDTH * 4,HEIGHT+45,WIDTH, HEIGHT);
            
            platinumOre = worldDrops.crop(WIDTH * 2,35,WIDTH, HEIGHT);
            platinumIngot = worldDrops.crop(-5+WIDTH * 2,HEIGHT+50,WIDTH, HEIGHT);
            
            starMetalOre = worldDrops.crop(35,30,WIDTH, HEIGHT);
            starMetalIngot = worldDrops.crop(35,HEIGHT+50,WIDTH, HEIGHT);
    }
    
}
