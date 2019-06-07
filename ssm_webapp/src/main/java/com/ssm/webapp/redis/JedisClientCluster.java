package com.ssm.webapp.redis;

import java.util.List;
import java.util.Map;
import redis.clients.jedis.JedisCluster;

/**
 * 
 * 类描述 redis集群操作工具类
 * 
 */
public class JedisClientCluster {

    private JedisCluster jedisCluster;

    public JedisCluster getJedisCluster() {
	return jedisCluster;
    }

    public void setJedisCluster(JedisCluster jedisCluster) {
	this.jedisCluster = jedisCluster;
    }

    /**
     * 设置一个字符串类型的值,如果记录存在则覆盖原有value
     *
     * @param key
     *            值对应的键
     * @param value
     *            值
     * @return 状态码, 成功则返回OK
     */
    public String set(String key, String value) {
	return jedisCluster.set(key, value);
    }

    /**
     * 从redis中根据key取值
     *
     * @param key
     *            要取得值对应的key
     * @return 取到的value值
     */
    public String get(String key) {
	return jedisCluster.get(key);
    }

    /**
     * 判断某个键值对是否存在
     *
     * @param key
     *            根据键判断
     * @return 判断结果
     */
    public Boolean exists(String key) {
	return jedisCluster.exists(key);
    }

    /**
     * 设置键值对的过期时间
     *
     * @param key
     *            要设置过期时间的k键值对的键
     * @param seconds
     *            过期时间
     * @return 影响的记录数
     */
    public Long expire(String key, int seconds) {
	return jedisCluster.expire(key, seconds);
    }

    /**
     * 查看键值对的剩余时间
     *
     * @param key
     *            要查看的键值对的键
     * @return 剩余时间
     */
    public Long ttl(String key) {
	return jedisCluster.ttl(key);
    }

    /**
     * 添加一个对应关系
     *
     * @param key
     *            存储的键
     * @param field
     *            存储的名字
     * @param value
     *            存储的值
     * @return 状态码, 1成功, 0失败, 如果field已存在将更新, 返回0
     */
    public Long hset(String key, String field, String value) {
	return jedisCluster.hset(key, field, value);
    }

    /**
     * 返回hash中指定存储的值
     *
     * @param key
     *            查找的存储的键
     * @param field
     *            查找的存储的名字
     * @return 指定存储的值
     */
    public String hget(String key, String field) {
	return jedisCluster.hget(key, field);
    }

    /**
     * 从hash中删除指定的存储
     *
     * @param key
     *            存储的键
     * @param field
     *            存储的名字
     * @return 状态码, 1成功, 0失败
     */
    public Long hdel(String key, String... field) {
	return jedisCluster.hdel(key, field);
    }

    /**
     * 检测hash中指定的存储是否存在
     *
     * @param key
     *            存储的键
     * @param field
     *            存储的额名字
     * @return 状态码, 1代表成功, 0代表失败
     */
    public Boolean hexists(String key, String field) {
	return jedisCluster.hexists(key, field);
    }

    /**
     * 以map的形式返回hash存储的名字和值
     *
     * @param key
     *            存储的键
     * @return 根据key查找到的存储的名字和值
     */
    public Map<String, String> hgetAll(String key) {
	return jedisCluster.hgetAll(key);
    }

    /**
     * 获取hash中value的集合
     *
     * @param key
     *            hash中存储的键
     * @return 指定键的所有value的集合
     */
    public List<String> hvals(String key) {
	return jedisCluster.hvals(key);
    }

    /**
     * 根据存储的键删除存储
     *
     * @param key
     *            存储的键
     * @return 状态码, 1成功, 0失败
     */
    public Long del(String key) {
	return jedisCluster.del(key);
    }

}
