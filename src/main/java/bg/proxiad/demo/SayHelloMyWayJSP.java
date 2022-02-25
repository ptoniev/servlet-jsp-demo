package bg.proxiad.demo;

import java.io.IOException;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = {"/say-hello-my-way-through-jsp"},
    initParams = {@WebInitParam(name = "greet", value = "Hello, ")})
public class SayHelloMyWayJSP extends HttpServlet implements Servlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setAttribute("greet", "Hello, ");
    req.getRequestDispatcher("/MyJSP.jsp").forward(req, resp);
    // RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MyJSP.jsp");
    // dispatcher.forward(req, resp);
  }
}
