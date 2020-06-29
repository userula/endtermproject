package repositories;

import domain.Playlist;
import domain.User;
import repositories.interfaces.IDBRepository;
import repositories.interfaces.IPlaylistRepository;

import javax.ws.rs.BadRequestException;
import java.sql.*;
import java.util.ArrayList;

public class PlaylistRepository implements IPlaylistRepository {

    private IDBRepository dbrepo =  new PostgresRepository();

    public Playlist getPlayslist(int id)
    {
        String sql = "SELECT * FROM playlist WHERE id = " + id + "LIMIT 1";
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())
            {
                return new Playlist(rs.getInt("id"),
                                    rs.getString("playlistName"),
                        (ArrayList) rs.getArray("musics_id"));
            }

        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList queryOne(String sql) {
        ArrayList<Playlist> pl = new ArrayList<>();
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ArrayList<Integer> aa = (ArrayList<Integer>) rs.getArray("playlist_id");
            if(rs.next())
            {
                for (int n : aa) {
                    pl.add(getPlayslist(n));
                }
                return pl;
            }

        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList getPlayByUserID(int id) {
        String sql = "SELECT playlist_id FROM users WHERE id = " + id + "LIMIT 1";
        return queryOne(sql);
    }

    @Override
    public void add(Playlist p) {
        try {
            String sql = "INSERT INTO playlist(playlistName, musics_id) " +
                    "VALUES(?, ?)";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, p.getPlaylistName());
            stmt.setArray(2, (Array) p.getMusics());

            stmt.execute();
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
    }


}
