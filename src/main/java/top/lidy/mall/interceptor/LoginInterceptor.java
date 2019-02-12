package top.lidy.mall.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.messaging.handler.HandlerMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.lidy.mall.Constant;
import top.lidy.mall.annotation.MustLogin;
import top.lidy.mall.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @Author lidey
 * @DATE 2019/2/11
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(MustLogin.class)) {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute(Constant.KEY_USER_ID);
            if (user == null){
                response.sendRedirect("/toLogin");
            }

        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex) throws Exception {
    }


}
