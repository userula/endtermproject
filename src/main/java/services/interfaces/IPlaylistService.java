package services.interfaces;

import domain.Playlist;

import java.util.ArrayList;

public interface IPlaylistService {
    ArrayList getPlaylistByUserID(int id);

    void addPlaylist(Playlist p);
}
