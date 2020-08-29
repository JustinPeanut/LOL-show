package com.peanut.api;

import com.peanut.myUtils.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("LOL-show-redis-provider")
public interface RedisRemoteService {

    /**
     * 保存key value键值对
     * @param key
     * @param value
     * @return
     */
    @ResponseBody
    @RequestMapping("redis/set/key/value")
    public ResultEntity<String> setKeyValue
            (@RequestParam("key")String key, @RequestParam("value") String value);

    /**
     * 设置到redis中会超时的键值对
     * @param key
     * @param value
     * @param timeUnit
     * @return
     */

    @ResponseBody
    @RequestMapping("set/key/value/in/time")
    public ResultEntity<String> setKeyValueInTime
    (@RequestParam("key")String key,@RequestParam("value")String value,
     @RequestParam("timeUnit")Long timeUnit);

    /**
     * 通过key删除value
     * @param key
     * @return
     */
    @ResponseBody
    @RequestMapping("delete/value/by/key")
    public ResultEntity<String> deleteValueByKey(@RequestParam("key")String key);

    /**
     * 通过key查询redis中存储的value的方法
     * @param key
     * @return
     */
    @ResponseBody
    @RequestMapping("get/value/by/key")
    public ResultEntity<String> getValueByKey(@RequestParam("key")String key);

}
