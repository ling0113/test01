package com.test.test01.defineinterface;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: com.test.test01.defineinterface.CountBuSi
 * @Description: 拦截器
 * @Author: lgrong
 * @CreateDate: 2019/10/21 14:14
 * @Version: 1.0
 */
public class CountBuSi implements HandlerInterceptor {
    // 在业务处理器处理请求之前被调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        return true;
    }
    // 在业务处理器处理请求完成之后，生成视图之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
        throws Exception{
    }
    // 在DispatcherServlet完全处理完请求之后被调用，可用于清理资源
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception{
    }

}
