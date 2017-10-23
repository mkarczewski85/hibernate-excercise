package car_rent.account;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        if (remember != null && !remember.trim().isEmpty()) {
            Cookie cookie = new Cookie("remember", email);
            cookie.setMaxAge(120);
            resp.addCookie(cookie);
        }

        Optional<User> user = UserRepository.findUserByMailAndPassword(email, password);

        user.ifPresent(u -> req.getSession().setAttribute("userId", u.getId()));

        if (user.isPresent()) {
            resp.sendRedirect("index.jsp");
        } else {
            resp.sendRedirect("login.jsp?error=true");
        }

    }


}
