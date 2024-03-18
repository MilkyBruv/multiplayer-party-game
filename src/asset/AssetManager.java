package asset;

import java.util.ArrayList;
import java.util.List;

import com.raylib.Raylib;
import com.raylib.Raylib.Sound;
import com.raylib.Raylib.Music;
import com.raylib.Raylib.Texture;

public abstract class AssetManager {

    private static boolean isVerbose = false;
    private static final String TEXTURE_PATH = "./res/texture/";
    private static final String SOUND_MUSIC_PATH = "./res/sound/";
    public static final String CONTROLLER_TEXTURE_PATH = "./res/texture/controller/";
    private static final List<Texture> TEXTURES = new ArrayList<Texture>() {};
    private static final List<Sound> SOUNDS = new ArrayList<Sound>() {};
    private static final List<Music> MUSIC = new ArrayList<Music>() {};
    
    // Load content

    public static final Texture loadTexture(String filename) {

        Texture texture = Raylib.LoadTexture(filename);

        if (!TEXTURES.contains(texture)) { 
            
            TEXTURES.add(Raylib.LoadTexture(TEXTURE_PATH + filename));
            return TEXTURES.get(TEXTURES.size() - 1);

        }

        Raylib.UnloadTexture(texture);
        if (isVerbose) System.out.println("[DEBUG] Texture already loaded <" + texture.toString() + ">");

        return null;

    }

    public static final Sound loadSound(String filename) {

        Sound sound = Raylib.LoadSound(SOUND_MUSIC_PATH + filename);

        if (!SOUNDS.contains(sound)) { 
            
            SOUNDS.add(sound);
            return sound;

        }

        Raylib.UnloadSound(sound);
        if (isVerbose) System.out.println("[DEBUG] Sound already loaded <" + sound.toString() + ">");

        return null;

    }

    public static final Music loadMusic(String filename) {

        Music music = Raylib.LoadMusicStream(SOUND_MUSIC_PATH + filename);

        if (!MUSIC.contains(music)) { 
            
            MUSIC.add(music);
            return music;

        }

        Raylib.UnloadMusicStream(music);
        if (isVerbose) System.out.println("[DEBUG] Music already loaded <" + music.toString() + ">");

        return null;

    }



    // Unload content

    public static final void unloadTexture(Texture texture) {

        if (!TEXTURES.remove(texture)) { 
            
            if (isVerbose) System.out.println("[DEBUG] Texture not loaded <" + texture.toString() + ">");
            return;
        
        }

        Raylib.UnloadTexture(texture);

    }

    public static final void unloadSound(Sound sound) {

        if (!SOUNDS.remove(sound)) { 
            
            if (isVerbose) System.out.println("[DEBUG] Sound not loaded <" + sound.toString() + ">");
            return;
        
        }

        Raylib.UnloadSound(sound);

    }

    public static final void unloadMusic(Music music) {

        if (!MUSIC.remove(music)) { 
            
            if (isVerbose) System.out.println("[DEBUG] Music not loaded <" + music.toString() + ">");
            return;
        
        }

        Raylib.UnloadMusicStream(music);

    }

    public static final void unloadAll() {

        for (Texture texture : TEXTURES) {
            
            Raylib.UnloadTexture(texture);
            if (isVerbose) System.out.println("[DEBUG] Texture unloaded <" + texture.toString() + ">");

        }

        for (Sound sound : SOUNDS) {
            
            Raylib.UnloadSound(sound);
            if (isVerbose) System.out.println("[DEBUG] Sound unloaded <" + sound.toString() + ">");
            
        }

        for (Music music : MUSIC) {
            
            Raylib.UnloadMusicStream(music);
            if (isVerbose) System.out.println("[DEBUG] Music unloaded <" + music.toString() + ">");

        }

    }



    // Setters

    public static final void setVerbose(boolean isVerbose) {

        AssetManager.isVerbose = isVerbose;

    }

}
