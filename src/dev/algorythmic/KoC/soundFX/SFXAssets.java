/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.soundFX;

import java.util.ArrayList;

/**
 *
 * @author justin
 */
public class SFXAssets {
    
    
    public static ArrayList<String> music;
    public static ArrayList<String> animations;
    public static ArrayList<String> menus;
    public static ArrayList<String> ambient;
    
    public static String getMusicTrack(int x){return music.get(x);}
    public static String getAnimationTrack(int x){return animations.get(x);}
    
    public static void init(){
        music = new ArrayList<>();
        animations = new ArrayList<>();
        menus = new ArrayList<>();
        ambient = new ArrayList<>();
    
        //music
        music.add("Medieval Melancholy.wav");
        //animations
        
        //menus
        
        //ambient        
    }
    
    
}
