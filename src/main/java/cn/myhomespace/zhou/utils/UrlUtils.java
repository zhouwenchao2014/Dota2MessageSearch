package cn.myhomespace.zhou.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by zhouwenchao on 16/2/18.
 */
public class UrlUtils {

    public static BufferedReader getBufferByUrl(String urlStr){
        BufferedReader bufferedReader=null;
        try {
            URL url=new URL(urlStr);
            URLConnection urlConnection=url.openConnection();
            InputStream inputStream=urlConnection.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            bufferedReader=new BufferedReader(inputStreamReader);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }
}
