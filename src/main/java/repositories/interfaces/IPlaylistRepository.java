package repositories.interfaces;

import domain.Playlist;
import domain.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface IPlaylistRepository{
    ArrayList getPlayByUserID(int id);

    void add(Playlist p);

    ArrayList queryOne(String sql);
}
