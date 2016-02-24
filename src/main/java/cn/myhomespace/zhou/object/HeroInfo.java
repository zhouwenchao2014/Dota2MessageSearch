package cn.myhomespace.zhou.object;

import java.io.Serializable;

/**
 * Dota2英雄信息
 * Created by zhouwenchao on 16/2/18.
 */
public class HeroInfo implements Serializable{
    public String name;
    public String id;
    public String localized_name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeroInfo heroInfo = (HeroInfo) o;

        if (name != null ? !name.equals(heroInfo.name) : heroInfo.name != null) return false;
        if (id != null ? !id.equals(heroInfo.id) : heroInfo.id != null) return false;
        return localized_name != null ? localized_name.equals(heroInfo.localized_name) : heroInfo.localized_name == null;

    }

    @Override
    public String toString() {
        return "HeroInfo{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", localized_name='" + localized_name + '\'' +
                '}';
    }

    public HeroInfo() {
    }

    public HeroInfo(String name, String id, String localized_name) {
        this.name = name;
        this.id = id;
        this.localized_name = localized_name;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (localized_name != null ? localized_name.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocalized_name() {
        return localized_name;
    }

    public void setLocalized_name(String localized_name) {
        this.localized_name = localized_name;
    }
}
