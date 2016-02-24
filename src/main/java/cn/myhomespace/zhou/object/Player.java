package cn.myhomespace.zhou.object;

import java.io.Serializable;

/**
 * Created by zhouwenchao on 16/2/18.
 */
public class Player implements Serializable{

    private String account_id;
    private String player_slot;
    private String hero_id;

    public Player() {
    }

    public Player(String account_id, String player_slot, String hero_id) {

        this.account_id = account_id;
        this.player_slot = player_slot;
        this.hero_id = hero_id;
    }

    public String getAccount_id() {

        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getPlayer_slot() {
        return player_slot;
    }

    public void setPlayer_slot(String player_slot) {
        this.player_slot = player_slot;
    }

    public String getHero_id() {
        return hero_id;
    }

    public void setHero_id(String hero_id) {
        this.hero_id = hero_id;
    }
}
