package sfx;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import main.Main;

public final class SoundResource {

    private Clip clip;
    private long currentMicrosecondPosition = 0;

    /**
     * Loads supplied file and creates threaded audio clip
     * 
     * @param fileName - Name of audio file (ONLY .wav)
     * @throws LineUnavailableException
     * @throws UnsupportedAudioFileException
     * @throws IOException
     */
    public SoundResource(String fileName) throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                Main.class.getResourceAsStream("../res/" + fileName));
        this.clip = AudioSystem.getClip();
        this.clip.open(audioInputStream);

    }



    /**
     * Plays Clip
     */
    public final void play() {

        this.clip.start();

    }



    /**
     * Saves current position and stops clip
     */
    public final void pause() {

        this.currentMicrosecondPosition = this.clip.getMicrosecondPosition();
        this.clip.stop();

    }



    /**
     * Sets clip position to saved current position and plays clip
     */
    public final void resume() {

        this.clip.setMicrosecondPosition(this.currentMicrosecondPosition);
        this.clip.start();

    }



    /**
     * Loops Clip for supplied count times
     * 
     * @param count - Times to loop the clip (-1 for continuous)
     */
    public final void loop(int count) {

        this.clip.loop(count);

    }



    /**
     * Stops Clip
     */
    public final void stop() {

        this.currentMicrosecondPosition = 0;
        this.clip.setMicrosecondPosition(this.currentMicrosecondPosition);
        this.clip.stop();

    }



    /**
     * @return Current playing status
     */
    public final boolean isPlaying() {

        return this.clip.isRunning();

    }

}
