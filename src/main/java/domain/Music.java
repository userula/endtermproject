package domain;

public class Music {
    private int id;
    private String musicName;

    public Music(int id, String name)
    {
        setId(id);
        setMusicName(name);
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
