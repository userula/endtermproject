package domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Playlist {
    private int id;
    private String playlistName;
    private ArrayList<Music> m;

    public Playlist(String name, ArrayList m)
    {
        setPlaylistName(name);
        setMusics(m);
    }

    public Playlist(int id, String name, ArrayList m){
        setId(id);
        setPlaylistName(name);
        setMusics(m);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public ArrayList<Music> getMusics() {
        return m;
    }

    public void setMusics(ArrayList m) {
        this.m = m;
    }
}
