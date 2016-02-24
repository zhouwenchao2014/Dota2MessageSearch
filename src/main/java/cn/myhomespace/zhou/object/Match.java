package cn.myhomespace.zhou.object;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhouwenchao on 16/2/18.
 */
public class Match implements Serializable {
    private String match_id;
    private String match_seq_num;
    private long start_time;
    private String lobby_type;
    private String radiant_team_id;
    private String dire_team_id;
    private List<Player> players;

    public Match() {
    }

    public Match(String match_id, String match_seq_num, long start_time, String lobby_type, String radiant_team_id, String dire_team_id, List<Player> players) {

        this.match_id = match_id;
        this.match_seq_num = match_seq_num;
        this.start_time = start_time;
        this.lobby_type = lobby_type;
        this.radiant_team_id = radiant_team_id;
        this.dire_team_id = dire_team_id;
        this.players = players;
    }

    @Override
    public String toString() {
        return "Match{" +
                "match_id='" + match_id + '\'' +
                ", match_seq_num='" + match_seq_num + '\'' +
                ", start_time=" + start_time +
                ", lobby_type='" + lobby_type + '\'' +
                ", radiant_team_id='" + radiant_team_id + '\'' +
                ", dire_team_id='" + dire_team_id + '\'' +
                ", players=" + players +
                '}';
    }

    public String getMatch_id() {
        return match_id;
    }

    public void setMatch_id(String match_id) {
        this.match_id = match_id;
    }

    public String getMatch_seq_num() {
        return match_seq_num;
    }

    public void setMatch_seq_num(String match_seq_num) {
        this.match_seq_num = match_seq_num;
    }

    public long getStart_time() {
        return start_time;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    public String getLobby_type() {
        return lobby_type;
    }

    public void setLobby_type(String lobby_type) {
        this.lobby_type = lobby_type;
    }

    public String getRadiant_team_id() {
        return radiant_team_id;
    }

    public void setRadiant_team_id(String radiant_team_id) {
        this.radiant_team_id = radiant_team_id;
    }

    public String getDire_team_id() {
        return dire_team_id;
    }

    public void setDire_team_id(String dire_team_id) {
        this.dire_team_id = dire_team_id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
