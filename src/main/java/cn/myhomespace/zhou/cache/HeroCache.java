package cn.myhomespace.zhou.cache;

import cn.myhomespace.zhou.Client.RedisClient;
import cn.myhomespace.zhou.object.HeroInfo;
import cn.myhomespace.zhou.utils.UrlUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouwenchao on 16/2/18.
 */
public class HeroCache {

    private LoadingCache<String,HeroInfo> heroCache;

    @Autowired
    private RedisClient redisClient;

    private Logger logger= LoggerFactory.getLogger(HeroCache.class);

    private final String SECRETKEY="8600B85E1F822CEB5C3A9A42C973CB45";

    private final int DB_NUM=1;

    @PostConstruct
    public void init(){
        try {
            BufferedReader bufferedReader=UrlUtils.getBufferByUrl("https://api.steampowered.com/IEconDOTA2_570/GetHeroes/v0001/?key="+SECRETKEY+"&language=zh");
            StringBuffer message=new StringBuffer();
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                message.append(line);
            }
            Map<String,Map<String,List<String>>> messageInfo= (Map<String, Map<String, List<String>>>) JSONObject.parse(message.toString());
            Map<String,List<String>> heroInfosMap= (Map<String, List<String>>) messageInfo.get("result");
            List<String> heroInfoStr=heroInfosMap.get("heroes");
            List<HeroInfo> heroInfos=JSONObject.parseArray(heroInfoStr.toString(),HeroInfo.class);
            if(heroInfos!=null){
                for(HeroInfo heroInfo : heroInfos){
                    redisClient.set(DB_NUM,heroInfo.getId(), JSON.toJSONString(heroInfo));
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String heroId){
        return redisClient.get(DB_NUM,heroId);

    }
}
