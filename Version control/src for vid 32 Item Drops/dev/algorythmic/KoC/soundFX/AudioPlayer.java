/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.soundFX;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.midi.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author justin
 */
public class AudioPlayer {
    
    private String midiFile, audioFile;
    private Sequencer sequencer;
    private InputStream is;
    private Clip clip;
    private AudioInputStream inputStream;
    
    //SETTER
    public void setMidiAudioFile(String midiFile){this.midiFile= midiFile;}
    public void setAudioFile(String audioFile){this.audioFile= audioFile;}
    
    //CONSTRUCTOR
    public AudioPlayer(){}
    
    //MIDI PLAYER
    public void playMidiClip(){
        try{
            sequencer = MidiSystem.getSequencer();
            is = new BufferedInputStream(new FileInputStream(new File(midiFile)));
            sequencer.setSequence(is);
            sequencer.start();
        }catch(IOException | InvalidMidiDataException | MidiUnavailableException e){
            e.printStackTrace();
        }
    }
    public void playMidiClipOnLoop(){
        try{
            sequencer = MidiSystem.getSequencer();
            is = new BufferedInputStream(new FileInputStream(new File(midiFile)));
            sequencer.setSequence(is);
            sequencer.setLoopCount(1);
        }catch(IOException | InvalidMidiDataException | MidiUnavailableException e){
            e.printStackTrace();
        }
    }
    public void stopMidiClip(){
        sequencer.stop();
    }
    
    //AUDIO PLAYER
    public void playAudioClip(){
        try{
            inputStream = AudioSystem.getAudioInputStream(new File(audioFile).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.start();
        }catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){
            e.printStackTrace();
        }
    }
    public void playAudioClipOnLoop(){
        try{
            inputStream = AudioSystem.getAudioInputStream(new File(audioFile).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){
            e.printStackTrace();
        }
    }
    public void stopAudioClip(){
        clip.stop();
    }
}
