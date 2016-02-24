package cn.myhomespace.zhou.controller;

import cn.myhomespace.zhou.Client.RedisClient;
import cn.myhomespace.zhou.cache.HeroCache;
import cn.myhomespace.zhou.intf.Dota2MessageSearchService;
import cn.myhomespace.zhou.object.Match;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by zhouwenchao on 16/2/18.
 */
@Controller
public class HomeController {

    private Logger logger= LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private HeroCache heroCache;

    @Autowired
    private RedisClient redisClient;

    @Autowired
    private Dota2MessageSearchService dota2MessageSearchService;

    private final int DB_NUM=1;

    @RequestMapping("/home")
    public String home(Model model) {

        model.addAttribute("message", "hello, world");
        //return "WEB-INF/views/home.jsp";
        return "home";
    }

    @RequestMapping("/getMatchHistory")
    public void getMatchHistory(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        List<Match> matches= (List<Match>) dota2MessageSearchService.getHistoryMatchMessageBySecretKey("");
        renderData(response,matches);
    }
    private void renderData(HttpServletResponse response, Object data) {
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            String message=JSONObject.toJSONString(data);
            printWriter.print(message);
        } catch (IOException ex) {
            logger.info(String.valueOf(ex));
        } finally {
            if (null != printWriter) {
                printWriter.flush();
                printWriter.close();
            }
        }
    }

    @RequestMapping("/getHeroInfo")
    public void getHeroByHeroId(HttpServletRequest request,HttpServletResponse response){
        String heroId=request.getParameter("heroId");
        String heroInfo=redisClient.get(DB_NUM,heroId);
        JSONObject jsonObject=JSONObject.parseObject(heroInfo);
        renderData(response,jsonObject);
    }

    @RequestMapping("/getImg")
    public void getHeroImg(){
//        redisClient.
//        for(){
//
//        }
    }
}
