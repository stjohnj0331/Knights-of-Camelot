/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.soundFX;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;


/**
 *
 * @author justin
 */
public class AudioPlayer {
    
    private AudioClip song;
    private URL songpath;
    
    public AudioPlayer(String filename){
        try{
            songpath = this.getClass().getClassLoader().getResource(filename);
            song = Applet.newAudioClip(songpath);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void playSound(){
        song.play();
    }
    public void stopSound(){
        song.stop();
    }
    public void loopSound(){
        song.loop();
    }
    
    
}
