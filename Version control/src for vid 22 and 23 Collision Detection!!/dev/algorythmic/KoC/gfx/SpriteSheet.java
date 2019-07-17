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
public class SpriteSheet {
    //CLASS VARIABLES
    private BufferedImage sheet;
    
    //CONSTRUCTOR
    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
    }
    //OTHER METHODS
    public BufferedImage crop(int x, int y, int width, int height){
        return sheet.getSubimage(x, y, width, height);
    }
    
}
