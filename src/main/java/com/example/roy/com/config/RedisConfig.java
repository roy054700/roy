package com.example.roy.com.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import com.example.roy.com.util.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
 
import java.util.HashSet;
import java.util.Set;

@Configuration
//@ConditionalOnClass({JedisCluster.class})
public class RedisConfig {
    @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.timeout}")
    private int timeout;
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxActive;
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;
    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;
    @Value("${spring.redis.timeout}")
    private int commandTimeout;
    @Bean
    public JedisCluster getJedisCluster() {
        String[] cNodes = clusterNodes.split(",");
        Set<HostAndPort> nodes =new HashSet<HostAndPort>();
        //分割出集群节点
        for(String node : cNodes) {
            String[] hp = node.split(":");
            nodes.add(new HostAndPort(hp[0],Integer.parseInt(hp[1])));
        }
        JedisPoolConfig jedisPoolConfig =new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        //创建集群对象
//      JedisCluster jedisCluster = new JedisCluster(nodes,commandTimeout);
        return new JedisCluster( nodes, commandTimeout, commandTimeout,100, password, jedisPoolConfig);
        //return new JedisCluster(nodes,commandTimeout,jedisPoolConfig);
    }
 
    
 

}
