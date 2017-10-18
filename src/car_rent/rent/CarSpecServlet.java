package car_rent.rent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Optional;

public class CarSpecServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("carId");
        Optional<Car> car = CarRepository.findCar(Integer.valueOf(id));

        PrintWriter writer = resp.getWriter();
        writer.write("<html><head></head><body>OK");
        if (car.isPresent()) {
            writer.write("<div><p>Model: " + car.get().getModel() + "</p></div>");
            writer.write("<div><p>Make: " + car.get().getMake().name() + "</p></div>");
            writer.write("<div><p>Price: " + car.get().getBasePrice().toString() + "</p></div>");
            writer.write("<div>Parametry: <ul>");
            for (Option o : car.get().getOptionSet()) {
                writer.write("<li>" + o.getName() + "</li>");
            }
            writer.write("</ul></div>");
        }
        writer.write("</body></html>");

        writer.write("<div><form action=\"carSpec?carId=" + car.get().getId() + "\" method=\"POST\">");
        writer.write("<input type=\"submit\" value=\"Dodaj\"/>");
        writer.write("</form>");
        writer.write("</div>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("carId");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        Optional<Car> car = CarRepository.findCar(Integer.valueOf(id));

        Customer nowak = new Customer("Jan", "Nowak", LocalDateTime.now(), LocalDateTime.now(), true, "0000112");

        car.ifPresent(x -> x.rentCar(nowak, ProjectUtil.parsedateFromCalendar(startDate), ProjectUtil.parsedateFromCalendar(endDate)));

        PrintWriter writer = resp.getWriter();
        writer.write("<html><head></head><body>DODANO</body></html>");

    }

}
