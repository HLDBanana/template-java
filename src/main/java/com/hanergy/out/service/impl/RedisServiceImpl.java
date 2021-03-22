package com.hanergy.out.service.impl;

import com.alibaba.fastjson.JSON;
import com.hanergy.out.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Han LiDong
 * @create: 2020/9/11 13:13
 * @update: 2020/9/11 13:13
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private SetOperations<String, String> setOperations() {
        return redisTemplate.opsForSet();
    }

    private HashOperations hashOperations() {
        return redisTemplate.opsForHash();
    }

    private ListOperations<String, String> listOperations() {
        return redisTemplate.opsForList();
    }

    private ValueOperations<String, String> valueOperations() {
        return redisTemplate.opsForValue();
    }

    @Override
    public void stringSet(String key, String value) {
        valueOperations().set(key, value);
    }

    @Override
    public String stringGet(String key) {
        return valueOperations().get(key);
    }

    @Override
    public void expire(String key, long mills) {
        expire(key, mills, TimeUnit.SECONDS);
    }

    @Override
    public void expire(String key, long mills, TimeUnit timeUnit) {
        redisTemplate.expire(key,mills,timeUnit);
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public Long incr(String key, Long value) {
        return valueOperations().increment(key, value);
    }

    @Override
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public List<String> moreGet(List<String> keys) {
        return valueOperations().multiGet(keys);
    }

    @Override
    public void moreSet(Map<String, String> map) {
        valueOperations().multiSet(map);
    }

    @Override
    public void expire(String key, Long seconds, String value, TimeUnit timeUnit) {
        valueOperations().set(key, value, seconds, timeUnit);
    }

    @Override
    public Set<String> keys(String patter) {
        return redisTemplate.keys(patter);
    }

    @Override
    public Boolean persist(String key) {
        return redisTemplate.persist(key);
    }

    @Override
    public void rename(String oldKey, String newKey) {
        redisTemplate.rename(oldKey, newKey);
    }

    @Override
    public Long ttlKeyExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    @Override
    public Long append(String key, String value) {
        return Long.valueOf(valueOperations().append(key,value));
    }

    @Override
    public Boolean hashExists(String key, Object childKey) {
        return hashOperations().hasKey(key,childKey);
    }

    @Override
    public Long hashRemove(String key, Object... childKey) {
        return hashOperations().delete(key,childKey);
    }

    @Override
    public Object hashGet(String key, Object childKey) {
        return hashOperations().get(key,childKey);
    }

    @Override
    public List<Object> hashValues(String key) {
        return hashOperations().values(key);
    }

    @Override
    public Set<Object> hashChildKeys(String key) {
        return hashOperations().keys(key);
    }

    @Override
    public Map<Object, Object> hashGetAll(String key) {
        return hashOperations().entries(key);
    }

    @Override
    public Long hashIncr(String key, Object childKey, Long delta) {
        return hashOperations().increment(key,childKey,delta);
    }

    @Override
    public List<Object> hashGetValueList(String key, List<? extends Object> childKeys) {
        return hashOperations().multiGet(key,childKeys);
    }

    @Override
    public void hashSet(String key, Object childKey, Object value) {
        hashOperations().put(key,childKey,value);
    }

    @Override
    public void hashPutAll(String key, Map<?, ?> map) {
        hashOperations().putAll(key,map);
    }

    @Override
    public Long hashLen(String key) {
        return hashOperations().size(key);
    }

    @Override
    public Long lpush(String key, String value) {
        return listOperations().leftPush(key,value);
    }

    @Override
    public Long rpush(String key, String value) {
        return listOperations().rightPush(key,value);
    }

    @Override
    public String lpop(String key) {
        return listOperations().leftPop(key);

    }

    @Override
    public String rpop(String key) {
        return listOperations().rightPop(key);
    }

    @Override
    public void linsert(String key, String element, String value) {
        listOperations().leftPush(key,element,value);
    }

    @Override
    public String lindex(String key, Long index) {
        return listOperations().index(key,index);
    }

    @Override
    public Long llen(String key) {
        return listOperations().size(key);
    }

    @Override
    public List<String> lrange(String key, Long start, Long end) {
        return listOperations().range(key,start,end);
    }

    @Override
    public Long lrem(String key, Long count, String value) {
        return listOperations().remove(key,count,value);
    }

    @Override
    public void lset(String key, Long index, String value) {
        listOperations().set(key,index,value);
    }

    @Override
    public void ltrim(String key, Long start, Long end) {
        listOperations().trim(key,start,end);
    }

    @Override
    public String rpoplpush(String key, String destination) {
        return listOperations().rightPopAndLeftPush(key,destination);
    }

    @Override
    public String brpoplpush(String srcKey, String destination, Long timeout, TimeUnit unit) {
        return listOperations().rightPopAndLeftPush(srcKey,destination,timeout,unit);
    }

    @Override
    public Long sAdd(String key, String... values) {
        return setOperations().add(key,values);
    }

    @Override
    public Long sLength(String key) {
        return setOperations().size(key);
    }

    @Override
    public Set<String> sMembers(String key) {
        return setOperations().members(key);
    }

    @Override
    public Set<String> sDifferent(String key, List<String> otherKeys) {
        return setOperations().difference(key,otherKeys);
    }

    @Override
    public Long sDifferentAndStore(String key, List<String> keys, String destKey) {
        return setOperations().differenceAndStore(key,keys,destKey);
    }

    @Override
    public Boolean sIsMember(String key, String target) {
        return setOperations().isMember(key,target);
    }

    @Override
    public Boolean sMove(String srcKey, String destKey, String member) {
        return setOperations().move(srcKey,member,destKey);
    }

    @Override
    public Set<String> sInterMembers(String key, List<String> keys) {
        return setOperations().intersect(key,keys);
    }

    @Override
    public String sPop(String key) {
        return setOperations().pop(key);
    }

    @Override
    public void sRemove(String key, String... values) {
        setOperations().remove(key,values);
    }

    @Override
    public Set<String> sUnion(String key, List<String> keys) {
        return setOperations().union(key,keys);
    }

    @Override
    public boolean setNx(String k, String v,Long s,  TimeUnit t){
        return valueOperations().setIfAbsent(k,v,s,t);
    }

    @Override
    public long getRemainingMillisecondToday() {
        Instant now = Instant.now();
        LocalDateTime midnight = LocalDateTime.ofInstant(now,
                ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);
        LocalDateTime currentDateTime = LocalDateTime.ofInstant(now,
                ZoneId.systemDefault());
        return ChronoUnit.MILLIS.between(currentDateTime, midnight);
    }

    @Override
    public void setSerializ(String k, Object v,Long s,  TimeUnit t){
        if(null==s){
            valueOperations().set(k, JSON.toJSONString(v));
            return;
        }
        valueOperations().set(k, JSON.toJSONString(v),s,t);
    }

    @Override
    public void setSerializ(String k, Object v){
        setSerializ(k, v,null,null);
    }

    @Override
    public <T> T get(String key, Class<T> type){
        String s = valueOperations().get(key);
        if(StringUtils.isEmpty(s)){
            return null;
        }
        return JSON.parseObject(s,type);
    }

}
