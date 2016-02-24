package cn.myhomespace.zhou.Client;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by zhouwenchao on 16/2/18.
 */
public class RedisClient {

    private String ip;

    private int port;

    private Jedis jedis;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void init(){
        jedis=new Jedis(ip,port);
    }

    public boolean setl(int DBNum){
        Jedis jedis=getDB(DBNum);
//        jedis.set
        return false;
    }

    public boolean set(int DBNum,String key,String value){
        Jedis jedis=getDB(DBNum);
        String result=jedis.set(key,value);
        if(result!=null) return true;
        return false;
    }
    public Jedis getDB(int DBNum){
        if(jedis.getDB()!=DBNum){
            jedis.select(DBNum);
        }
        return jedis;
    }

    public String get(int DBNum,String key){
        Jedis jedis=getDB(DBNum);
        String value=jedis.get(key);
        return value;
    }
}
