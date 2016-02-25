package cn.myhomespace.zhou.utils;

import java.io.*;
import java.nio.Buffer;

/**
 * 根据文件URL下载文件
 * 各种文件，如图片，txt。等
 * Created by wenchao on 2016-2-24.
 */
public class DownLoadFile {

    private static String path=SystemMessage.getUserHome()+"/Img";

    public static void main(String[] args) {
        System.out.println(SystemMessage.getUserHome());
        downLoadImg("http://cdn.dota2.com/apps/dota2/images/heroes/antimage_lg.png");
    }

    public static boolean downLoadImg(String url){
        InputStream inputStream=UrlUtils.getInputStreamByUrl(url);
        String fileName=url.substring(url.lastIndexOf("/"),url.length());
        createAndDownLoadFile(inputStream,fileName);
        return true;
    }

    public static void createAndDownLoadFile(InputStream inputStream,String fileName){
        File dir=new File(path);
        File file=new File(path+"/"+fileName);
        if(!file.exists()){
            try {
                dir.mkdir();
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int byteread=0;
        int bytesum=0;
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            byte[] buffer = new byte[1204];
            int length;
            while ((byteread = inputStream.read(buffer)) != -1) {
                bytesum += byteread;
                System.out.println(bytesum);
                fileOutputStream.write(buffer, 0, byteread);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
