package cn.myhomespace.zhou.impl;

import cn.myhomespace.zhou.intf.Dota2MessageSearchService;
import cn.myhomespace.zhou.object.Match;
import cn.myhomespace.zhou.object.Result;
import cn.myhomespace.zhou.utils.StringUtils;
import cn.myhomespace.zhou.utils.UrlUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouwenchao on 16/2/18.
 */
public class Dota2MessageSearchImpl implements Dota2MessageSearchService{

    private final String SECRETKEY="8600B85E1F822CEB5C3A9A42C973CB45";

    public static void main(String[] args) {
        Dota2MessageSearchImpl dota2MessageSearch=new Dota2MessageSearchImpl();
        dota2MessageSearch.getHistoryMatchMessageBySecretKey("8600B85E1F822CEB5C3A9A42C973CB45");
    }
    public Object getHistoryMatchMessageBySecretKey(String secretKey) {
        if(!StringUtils.isNotBlank(secretKey)){
            secretKey="8600B85E1F822CEB5C3A9A42C973CB45";
        }
        BufferedReader bufferedReader=UrlUtils.getBufferByUrl("https://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/V001/?key="+secretKey+"&language=zh");
        String line="";
        StringBuffer stringBuffer=new StringBuffer();
        List<Match> matches=null;
        try {
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
                stringBuffer.append(line);
            }
            Map<String,Map<String,Object>> result= (Map<String, Map<String, Object>>) JSONObject.parse(stringBuffer.toString());
            Map<String,Object> re=result.get("result");
            StringBuffer matcheStr=new StringBuffer(JSONObject.toJSONString(re.get("matches")));
            matches=JSONObject.parseArray(matcheStr.toString(),Match.class);
            System.out.println(matches.toArray());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return matches;
    }
}
