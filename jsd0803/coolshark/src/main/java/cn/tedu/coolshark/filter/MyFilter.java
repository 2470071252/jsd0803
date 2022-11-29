package cn.tedu.coolshark.filter;

import cn.tedu.coolshark.pojo.vo.UserVO;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
// 在urlPartterns里面配置需要当前过滤器处理的资源路径
@WebFilter(filterName = "MyFilter",urlPatterns = {"/admin.html",
        "/insertProduct.html","/insertBanner.html","/updateProduct.html","/updateBanner.html"})
public class MyFilter implements Filter {
    // 过滤器初始化方法
    public void init(FilterConfig config) throws ServletException {
    }
    // 过滤器销毁时执行的方法
    public void destroy() {
    }
    // 在请求资源之前或之后会进入doFilter方法之中
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //判断是否登录
        HttpServletRequest rt = (HttpServletRequest) request;
        HttpServletResponse re = (HttpServletResponse) response;
        // 得到会话对象
        HttpSession session = rt.getSession();
        // 从会话对象中得到登陆的用户对象
        UserVO user = (UserVO) session.getAttribute("user");
        if (user!=null) { //代表登陆过 允许放行
            chain.doFilter(request, response);  // 放行
        }else { // 没有登陆 跳转到登陆页面
            re.sendRedirect("/login.html");  // 重定向到登陆页面
        }

    }
}
