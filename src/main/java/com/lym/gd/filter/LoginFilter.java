package com.lym.gd.filter;

import com.lym.gd.entity.LoginFilterEntity;
import com.lym.gd.entity.User;
import com.lym.gd.repository.LoginFilterEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author liuyaming
 * @date 2018/3/14 下午8:45
 */
@WebFilter
public class LoginFilter implements Filter {
  private static List<LoginFilterEntity> loginFilterEntityList;

  @Autowired private LoginFilterEntityRepository loginFilterEntityRepository;

  @Override
  public void init(FilterConfig filterConfig) {
    loginFilterEntityList = loginFilterEntityRepository.findAll();
  }

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {


    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    String servletPath = request.getServletPath();

    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("user");

    if (user == null) {
      if (isFilter(servletPath)) {
        response.sendRedirect("/login");
        return;
      }
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }

  /**
   * 是不是要过滤
   *
   * @param path 访问的路径
   * @return true 需要
   */
  private boolean isFilter(String path) {

    for (LoginFilterEntity loginFilterEntity : loginFilterEntityList) {
      // 匹配过滤规则
      boolean flag =
          path.startsWith(loginFilterEntity.getLoginFilterPath() + "/")
              || path.equals(loginFilterEntity.getLoginFilterPath());
      if (flag) {
        return false;
      }
    }

    return true;
  }

  @Override
  public void destroy() {}
}
