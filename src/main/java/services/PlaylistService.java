package services;

import domain.Playlist;
import repositories.PlaylistRepository;
import repositories.interfaces.IPlaylistRepository;
import services.interfaces.IPlaylistService;

import java.util.ArrayList;

public class PlaylistService implements IPlaylistService {
    private IPlaylistRepository playRepo = new PlaylistRepository();

    @Override
    public ArrayList getPlaylistByUserID(int id) {
        return playRepo.getPlayByUserID(id);
    }

    @Override
    public void addPlaylist(Playlist p) {
        playRepo.add(p);
    }
}
