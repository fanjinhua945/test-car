package com.fh.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionPool {

    private static final int Max_Total =50;

    private static final int Min_IDLE =10;

    private static final int Max_IDLE =49;

    private static final String REDIS_SEVERIP ="192.168.220.128";

    private static final int REDIS_SERVER_PORT =6379;

    private static JedisPool jedisPool;

    static {
        initPool();
    }

    private static void initPool(){
        JedisPoolConfig config =new JedisPoolConfig();
        config.setMaxTotal(Max_Total);
        config.setMaxIdle(Max_IDLE);
        config.setMinIdle(Min_IDLE);
        jedisPool = new JedisPool(config, REDIS_SEVERIP, REDIS_SERVER_PORT);
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }


}
