package bg.proxiad.demo;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;

@WebFilter("/*")
public class MyCountingFilter extends HttpServlet implements Filter {

  public static final String My_COUNTER_ATTR = "myCounter";

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    filterConfig.getServletContext().setAttribute(My_COUNTER_ATTR, Long.valueOf(0L));
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    System.out.println("Test clicks for all requests");

    Long allCount = (Long) request.getServletContext().getAttribute(My_COUNTER_ATTR);
    allCount++;
    request.getServletContext().setAttribute(My_COUNTER_ATTR, allCount);

    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    System.out.println("MyFirstFilter, destroing");
  }
}
