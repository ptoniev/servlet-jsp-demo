package bg.proxiad.demo;

import java.io.IOException;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(
    name = "SayHello",
    urlPatterns = {"/say-hello-my-way"})
public class SayHello extends HttpServlet implements Servlet {

  protected String greeting;

  public void init(ServletConfig servletConfig) throws ServletException {
    this.greeting = servletConfig.getInitParameter("greeting");
  }

  @Override
  public void service(ServletRequest req, ServletResponse resp)
      throws ServletException, IOException {

    resp.getWriter()
        .write("<html><body>" + this.greeting + " " + req.getParameter("name") + "</body></html>");
  }
}
