package com.peanut.controller;

import com.peanut.myUtils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ResdisMemberController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 保存key value键值对
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("redis/set/key/value")
    public ResultEntity<String> setKeyValue
            (@RequestParam("key")String key, @RequestParam("value") String value){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        try{
            operations.set(key,value);
            return ResultEntity.succeedWithOutData(ResultEntity.SUCCEED);
        }catch (Exception e){
            return ResultEntity.failedWithOutData(e.getMessage());
        }
    }

    /**
     * 设置到redis中会超时的键值对
     * @param key
     * @param value
     * @param timeUnit
     * @return
     */
    @RequestMapping("set/key/value/in/time")
    public ResultEntity<String> setKeyValueInTime
            (@RequestParam("key")String key,@RequestParam("value")String value,
             @RequestParam("timeUnit")Long timeUnit){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        try{
            operations.set(key,value,timeUnit);
            return ResultEntity.succeedWithOutData(ResultEntity.SUCCEED);
        }catch (Exception e){
            return ResultEntity.failedWithOutData(e.getMessage());
        }
    }

    /**
     * 通过key删除value
     * @param key
     * @return
     */
    @RequestMapping("delete/value/by/key")
    public ResultEntity<String> deleteValueByKey(@RequestParam("key")String key){
        try{
            Boolean delete = redisTemplate.delete(key);
            if(delete){
                return ResultEntity.succeedWithOutData(ResultEntity.SUCCEED);
            }else {
                return ResultEntity.failedWithOutData("删除失败");
            }
        }catch (Exception e){
            return ResultEntity.failedWithOutData(e.getMessage());
        }
    }

    /**
     * 通过key查询redis中存储的value的方法
     * @param key
     * @return
     */
    @RequestMapping("get/value/by/key")
    public ResultEntity<String> getValueByKey(@RequestParam("key")String key){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        try{
            String code = operations.get(key);
            return ResultEntity.succeedWithData(code,ResultEntity.SUCCEED);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResultEntity.failedWithOutData(e.getMessage());
        }
    }

}
