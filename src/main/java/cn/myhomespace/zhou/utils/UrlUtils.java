package cn.myhomespace.zhou.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 根据url获取各种流
 * Created by zhouwenchao on 16/2/18.
 */
public class UrlUtils {

    /**
     * 根据url获取字符流
     * @param urlStr
     * @return
     */
    public static BufferedReader getBufferByUrl(String urlStr){
        BufferedReader bufferedReader=null;
        InputStream inputStream=null;
        InputStreamReader inputStreamReader=null;
        try {
            URL url=new URL(urlStr);
            URLConnection urlConnection=url.openConnection();
            inputStream=urlConnection.getInputStream();
            inputStreamReader=new InputStreamReader(inputStream);
            bufferedReader=new BufferedReader(inputStreamReader);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
//            try {
//                if (inputStream!=null){
//                    inputStream.close();
//                }
//                if(inputStreamReader!=null){
//                    inputStreamReader.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        return bufferedReader;
    }

    /**
     * 根据url获取InputStream
     * @return
     */
    public static InputStream getInputStreamByUrl(String urlStr){
        InputStream inputStream=null;
        try {
            URL url=new URL(urlStr);
            URLConnection urlConnection=url.openConnection();
            inputStream=urlConnection.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
        return inputStream;
    }

    /**
     * 根据InputStream获取BufferedReader
     * @param inputStream
     * @return
     */
    public static BufferedReader getbufferByInputSteam(InputStream inputStream){
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        return bufferedReader;
    }
}
