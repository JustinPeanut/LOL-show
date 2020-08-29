package com.peanut.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.peanut.constant.Constant;
import com.peanut.constant.FilterHelper;
import com.peanut.entity.vo.LoginMemberVO;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 做登录检查
 * @author Peanut
 */

@Component
public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // 在处理请求之前拦截
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 获取当前线程的request对象
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String path = request.getServletPath();
        // 先判断是不是'/'
        String rootPath = "/";
        // 如果是根目录直接放行
        if(rootPath.equals(path)){
            return false;
        }
        return !FilterHelper.judgeAccessPath(path) && !FilterHelper.judgeStaticSource(path);
    }

    @SneakyThrows
    @Override
    public Object run() throws ZuulException {
        // 获取当前线程的request对象
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        // 获取当前线程的session域
        HttpSession session = request.getSession();
        // 获取loginMember
        LoginMemberVO loginMemberVO = (LoginMemberVO) session.getAttribute(Constant.ATTR_LOGIN_MEMBER);
        // 判断loginMember是否有效
        if(loginMemberVO == null){
            // 如果无效，获取响应对象，重定向
            HttpServletResponse response = context.getResponse();
            session.setAttribute(Constant.ATTR_MESSAGE_EXCEPTION,"请登录以后再访问！");
            response.sendRedirect("http://localhost/to/login/page");
        }

        return null;
    }
}
