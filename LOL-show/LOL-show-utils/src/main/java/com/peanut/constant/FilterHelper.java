package com.peanut.constant;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Peanut
 * 用于辅助ZuulFilter的工具类
 * 判断是否是静态资源
 */
public class FilterHelper {
    /**
     * 存放静态资源的set
     */
    private static Set<String> staticSource = new HashSet<>();

    /**
     * 初始化存放静态路径的HashSet
     */
    static{
        staticSource.add("css");
        staticSource.add("img");
        staticSource.add("js");
        staticSource.add("bootstrap-3.3.7");
        staticSource.add("layer");
    }

    /**
     * 存放不拦截的请求，比如去往登陆页面的请求
     */
    private static Set<String> accessPath = new HashSet<>();

    static{
        accessPath.add("/to/login/page");
        accessPath.add("/do/member/login");
        accessPath.add("/quit/login/member");
        accessPath.add("/to/regist/page");
        accessPath.add("/get/home/page");
        accessPath.add("/api/kaptcha/defaultKaptcha");
        accessPath.add("/do/member/regist");
        accessPath.add("/market/to/market/home/page");
        accessPath.add("get/portal/big/img");
        accessPath.add("/hero/to/get/hero/page");
        accessPath.add("/hero/detail/**");
        accessPath.add("/market/get/stick/info.json");
        accessPath.add("/market/to/cart");
    }

    /**
     * 判断是不是静态资源
     * @param path
     * @return 如果是静态资源，就返回ture，反之返回false
     */
    public static boolean judgeStaticSource(String path){
        String[] split = path.split("/");
        // 如果set里面包含了静态资源，就返回true
        if(staticSource.contains(split[1])){
            return true;
        }
        return false;
    }

    /**
     * 判断是否是直接可以放行的资源
     * @param path
     * @return
     */
    public static boolean judgeAccessPath(String path){
        String[] split = path.split("/");
        if(split[1].equals("hero") || split[1].equals("market")){
            if(split[2].equals("detail") || split[2].equals("to")){
                return true;
            }
        }
        return accessPath.contains(path);
    }
}
