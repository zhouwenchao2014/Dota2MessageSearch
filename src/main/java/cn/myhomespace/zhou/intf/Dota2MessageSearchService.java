package cn.myhomespace.zhou.intf;

import cn.myhomespace.zhou.object.Match;

import java.util.List;

/**
 * Created by zhouwenchao on 16/2/18.
 */
public interface Dota2MessageSearchService {
    public Object getHistoryMatchMessageBySecretKey(String SecretKey);
}
