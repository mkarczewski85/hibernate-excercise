package car_rent.rent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteOptionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String optionId = req.getParameter("optionId");
        Integer id = null;
        try {
            id = Integer.valueOf(optionId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (id != null) {
            OptionRepository.delete(id);
        }

        resp.sendRedirect("adminPanelOptionList.jsp");

    }
}
