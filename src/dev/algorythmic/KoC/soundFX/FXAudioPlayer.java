/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.soundFX;

/**
 *
 * @author Justin GamingPC
 */
import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author Justin GamingPC
 */
public class FXAudioPlayer extends Application{
    
    private MediaPlayer player;
    
    @Override public void init(){
        new JFXPanel();
    }

    @Override public void start(Stage stage) throws Exception {
        init();
        //Locate the media content in the CLASSPATH
        String resource = "C:/Users/Justin GamingPC/Documents/NetBeansProjects/SimpleJavaApps/audio1231321/New folder/Billy's Sacrifice.mp3";
        URL url = ClassLoader.getSystemResource(resource);
        String path = null;
        if(url == null){
            path = new File(resource).toURI().toString();
        }else
            path = url.toString();
        try{
            //Create a Media
            final Media media = new Media(path);
            //Create a media player
            player = new MediaPlayer(media);
            player.play();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
