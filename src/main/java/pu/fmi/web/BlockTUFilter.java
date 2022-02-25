package pu.fmi.web;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class BlockTUFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // TODO Auto-generated method stub

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    String name = req.getParameter("name");
    if ("TU".equalsIgnoreCase(name)) {
      ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
    } else {
      chain.doFilter(request, response);
    }
  }

  @Override
  public void destroy() {
    // TODO Auto-generated method stub

  }
}
