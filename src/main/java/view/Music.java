package view;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



public enum Music {

    MENU_THEME("MainMenuTheme.wav"),
    BOARD_THEME("BoardTheme.wav"),
    SELECTION_THEME("SelectionTheme.wav");
    
    private Clip clip;
    private int currentFrame;
    
    Music(final String musicName) {
        final InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(musicName); 
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(new BufferedInputStream(input))){
            
            this.clip = AudioSystem.getClip();
            this.clip.open(audioStream);
            
        } catch(LineUnavailableException e1) {
            e1.printStackTrace();
        } catch (UnsupportedAudioFileException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }
    
    /**
     * Start the current music
     */
    public void startMusic() {
        this.clip.start();
    }
    
    /**
     * Start and Loop the current music
     */
    public void loopMusic() {
        this.clip.setFramePosition(0);
        this.clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    /**
     * Stop the current music
     */
    public void stopMusic() {
        this.clip.stop();
    }
    
    /**
     * @return true if line is active otherwise false
     */
    public boolean musicIsActive() {
        return this.clip.isActive();
    }
    
    /**
     * Pause and Resume the current music
     */
    public void pauseAndResumeMusic() {
        if (this.musicIsActive()) {
            this.currentFrame = this.clip.getFramePosition();
            this.stopMusic();
        } else {
            this.clip.setFramePosition(this.currentFrame);
            this.startMusic();
        }
    }
    
    /**
     * Pre-load all sound files.
     */
    public static void init() {
        values();
    }
    
}
