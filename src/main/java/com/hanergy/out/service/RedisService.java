package com.hanergy.out.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Han LiDong
 * @create: 2020/9/11 13:12
 * @update: 2020/9/11 13:12
 */
public interface RedisService {
    /********************************基本操作***********************************************************/

    /**
     * 设置key的有效时间
     *
     * @param key
     * @param seconds
     * @param value
     * @param timeUnit
     */
    void expire(String key, Long seconds, String value, TimeUnit timeUnit);

    /**
     * 正则方式获取key的列表
     *
     * @param patter
     * @return
     */
    Set<String> keys(String patter);

    /**
     * 移除key的失效时间,使其成为永久存储
     *
     * @param key
     * @return
     */
    Boolean persist(String key);

    /**
     * 修改key值
     *
     * @param oldKey
     * @param newKey
     */
    void rename(String oldKey, String newKey);

    /**
     * 返回key的剩余生存时间
     *
     * @param key
     * @return 剩余生存时间, 单位:秒,无生存时间,返回-1
     */
    Long ttlKeyExpire(String key);


    /**
     * key的失效时间,单位秒
     *
     * @param key
     * @param mills
     */
    void expire(String key, long mills);

    /**
     * key的失效时间,单位秒
     *
     * @param key
     * @param mills
     * @param timeUnit
     */
    void expire(String key, long mills, TimeUnit timeUnit);

    /**
     * 删除
     *
     * @param key
     */
    void remove(String key);

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    Boolean hasKey(String key);

    /*****************************String操作*********************************************/

    /**
     * 新增或设置
     *
     * @param key
     * @param value
     */
    void stringSet(String key, String value);

    /**
     * 获取
     *
     * @param key
     * @return
     */
    String stringGet(String key);

    /**
     * 增加或减少(加负号)
     *
     * @param key
     * @param value
     * @return
     */
    Long incr(String key, Long value);

    /**
     * 批量查询
     * 若key不存在,返回null
     *
     * @param keys
     * @return
     */
    List<String> moreGet(List<String> keys);

    /**
     * 批量设置
     *
     * @param map
     */
    void moreSet(Map<String, String> map);

    /**
     * 如果key是一个字符串,且已存在,则将value追加到原来的value的末尾;若key不存在,则执行set(key,value)操作
     *
     * @param key
     * @param value
     * @return 追加后的字符串长度
     */
    Long append(String key, String value);

    /*******************************HASH 操作 *********************************************/

    /**
     * 判断子key是否存在
     *
     * @param key
     * @param childKey
     * @return
     */
    Boolean hashExists(String key, Object childKey);

    /**
     * 批量删除
     *
     * @param key
     * @param childKey
     * @return
     */
    Long hashRemove(String key, Object... childKey);

    /**
     * 获取指定子key的值
     *
     * @param key
     * @param childKey
     * @return
     */
    Object hashGet(String key, Object childKey);

    /**
     * 获取所有值
     *
     * @param key
     * @return
     */
    List<Object> hashValues(String key);

    /**
     * 获取所有的子key
     *
     * @param key
     * @return
     */
    Set<Object> hashChildKeys(String key);

    /**
     * 获取键值集合
     *
     * @param key
     * @return
     */
    Map<Object, Object> hashGetAll(String key);

    /**
     * 为指定的子key增加数值
     *
     * @param key
     * @param childKey
     * @param delta
     * @return
     */
    Long hashIncr(String key, Object childKey, Long delta);

    /**
     * 获取指定子key集合的值集合
     *
     * @param key
     * @param childKeys
     * @return
     */
    List<Object> hashGetValueList(String key, List<? extends Object> childKeys);

    /**
     * 添加或修改
     *
     * @param key
     * @param childKey
     * @param value
     */
    void hashSet(String key, Object childKey, Object value);

    /**
     * 批量添加
     *
     * @param key
     * @param map
     */
    void hashPutAll(String key, Map<? extends Object, ? extends Object> map);

    /**
     * 返回对应的map长度
     *
     * @param key
     * @return
     */
    Long hashLen(String key);

    /******************************************** List 操作*************************************************************************/
    /**
     * 将数据插入key对应的列表的表头
     *
     * @param key
     * @param value
     * @return 列表长度
     */
    Long lpush(String key, String value);

    /**
     * 将数据插入key对应的列表的表尾
     *
     * @param key
     * @param value
     * @return 列表长度
     */
    Long rpush(String key, String value);

    /**
     * 获取列表的表头元素值
     *
     * @param key
     * @return
     */
    String lpop(String key);

    /**
     * 获取列表的表尾元素值
     *
     * @param key
     * @return
     */
    String rpop(String key);

    /**
     * 获取下表为index的元素
     *
     * @param key
     * @param index
     * @return
     */
    String lindex(String key, Long index);

    /**
     * 插入某个元素之前或者之后
     *
     * @param key
     * @param value   要插入的值
     * @param element 元素对象
     */
    void linsert(String key, String element, String value);

    /**
     * 返回列表长度
     *
     * @param key
     * @return
     */
    Long llen(String key);

    /**
     * 返回指定下表从start开始,到end(也包括该位置)结尾的元素列表
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    List<String> lrange(String key, Long start, Long end);

    /**
     * 根据count的值,删除与value相等的元素
     *
     * @param key
     * @param count count>0,从表头开始搜索;count<0;从表尾开始搜索;count=0,删除所有
     * @param value
     * @return 被移除元素的数量
     */
    Long lrem(String key, Long count, String value);

    /**
     * 将下标为index的元素设置为value
     *
     * @param key
     * @param index
     * @param value
     */
    void lset(String key, Long index, String value);

    /**
     * 保留区间内的元素,其余全部删除
     *
     * @param key
     * @param start
     * @param end
     */
    void ltrim(String key, Long start, Long end);

    /**
     * 将key对应的列表的末尾元素弹出并且作为表头元素插入的destination对应的列表
     *
     * @param srcKey
     * @param destination
     * @return
     */
    String rpoplpush(String srcKey, String destination);

    /**
     * 带阻塞的rpoplpush
     * 当srcKey对应的列表不为空时,执行rpoplpush,正常操作
     * 如果srcKey对应的列表为空,则会阻塞,直到srcKey对应的列表有lpush或者rpush操作时为止或者等待timeout的时间后退出
     *
     * @param srcKey
     * @param destination
     * @param timeout
     * @param unit
     * @return 假如在指定时间内没有任何元素被弹出，则返回一个 nil 和等待时长。
     * 反之，返回一个含有两个元素的列表，第一个元素是被弹出元素的值，第二个元素是等待时长。
     */
    String brpoplpush(String srcKey, String destination, Long timeout, TimeUnit unit);

    /**************************************************************set操作************************************************************************************/
    /**
     * 添加
     *
     * @param key
     * @param values
     * @return
     */
    Long sAdd(String key, String... values);

    /**
     * 返回集合长度
     *
     * @param key
     * @return
     */
    Long sLength(String key);

    /**
     * 获取集合中所有成员
     *
     * @param key
     * @return
     */
    Set<String> sMembers(String key);

    /**
     * 比较key列表及其他列表,获取差值元素集合
     *
     * @param key
     * @param keys
     * @return
     */
    Set<String> sDifferent(String key, List<String> keys);

    /**
     * 比较差值结合,保存到destKey的列表,若destKey已存在,则覆盖
     *
     * @param key
     * @param keys
     * @param destKey
     * @return
     */
    Long sDifferentAndStore(String key, List<String> keys, String destKey);

    /**
     * 判断target是否是key列表的成员
     *
     * @param key
     * @param target
     * @return
     */
    Boolean sIsMember(String key, String target);

    /**
     * 从srcKey中移除member,并将其添加到destKey列表中,若srcKey不存在,则什么都不做
     *
     * @param srcKey
     * @param destKey
     * @param member
     * @return
     */
    Boolean sMove(String srcKey, String destKey, String member);

    /**
     * 返回列表的交集
     *
     * @param key
     * @param keys
     * @return
     */
    Set<String> sInterMembers(String key, List<String> keys);

    /**
     * 随机移除并返回集合元素
     *
     * @param key
     * @return
     */
    String sPop(String key);

    /**
     * 移除元素
     *
     * @param key
     * @param values
     */
    void sRemove(String key, String... values);

    /**
     * 返回所有集合的并集
     *
     * @param key
     * @param keys
     * @return
     */
    Set<String> sUnion(String key, List<String> keys);

    /**
     * description: redis分布式锁
     * @creater: fuqingsheng
     * @updater: fuqingsheng
     * @create: 2021-3-1 10:00:16
     * @update: 2021-3-1 10:00:16
     * @param k key
     * @param v value
     * @param e 有效期
     * @param t 时间单位
     * @return: boolean
     */
    boolean setNx(String k, String v, Long e, TimeUnit t);

    /**
     * description: 获取当日剩余毫秒数
     * @creater: fuqingsheng
     * @updater: fuqingsheng
     * @create: 2021-3-1 10:00:16
     * @update: 2021-3-1 10:00:16
     * @return: long
     */
    long getRemainingMillisecondToday();

    /**
     * description: 设置序列化缓存
     * @creater: fuqingsheng
     * @updater: fuqingsheng
     * @create: 2021-3-1 10:00:16
     * @update: 2021-3-1 10:00:16
     * @param k key
     * @param v value
     * @param s 有效期
     * @param t 时间单位
     * @return: long
     */
    void setSerializ(String k, Object v, Long s, TimeUnit t);

    /**
     * description: 设置序列化缓存
     * @creater: fuqingsheng
     * @updater: fuqingsheng
     * @create: 2021-3-1 10:00:16
     * @update: 2021-3-1 10:00:16
     * @param k key
     * @param v value
     * @return: long
     */
    void setSerializ(String k, Object v);

    /**
     * description: 获取已序列化缓存转换成对象
     * @creater: fuqingsheng
     * @updater: fuqingsheng
     * @create: 2021-3-1 10:00:16
     * @update: 2021-3-1 10:00:16
     * @param key 缓存key
     * @param type class类型
     * @return: type.calss
     */
    <T> T get(String key, Class<T> type);
}
