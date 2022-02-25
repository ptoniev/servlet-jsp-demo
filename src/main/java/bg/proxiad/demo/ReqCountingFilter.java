package bg.proxiad.demo;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter("/count-my-requests")
public class ReqCountingFilter implements Filter {

  // public static final String COUNTER_ATTR = "counter";
  // public String url;

  // @Override
  // public void init(FilterConfig filterConfig) throws ServletException {
  //  filterConfig.getServletContext().setAttribute(COUNTER_ATTR, Long.valueOf(0L));
  // }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    System.out.println("Single link request");

    HttpSession session = ((HttpServletRequest) request).getSession();
    Long localCounter = 1L;
    if (session.getAttribute("myCounter") != null) {
      localCounter = ((Long) session.getAttribute("myCounter")) + 1;
    }

    session.setAttribute("myCounter", localCounter);

    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    System.out.println("MyFirstFilter, destroying");
  }
}
