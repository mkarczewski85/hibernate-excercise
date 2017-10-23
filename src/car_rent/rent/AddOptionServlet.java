package car_rent.rent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddOptionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String optionName = req.getParameter("optionName");
        if (optionName != null && !optionName.trim().isEmpty()){
            Option option = new Option(optionName);
            OptionRepository.saveOrUpdate(option);
        }
        resp.sendRedirect("adminPanelOptionList.jsp");

    }
}
