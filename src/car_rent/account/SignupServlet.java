package car_rent.account;

import car_rent.rent.Customer;
import car_rent.rent.CustomerRepository;
import car_rent.rent.ProjectUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Optional;

public class SignupServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HashMap<String, String> errors = new HashMap<>();


        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordRepeat = req.getParameter("passwordRepeat");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phoneNumber = req.getParameter("phoneNumber");
        String dayOfBirth = req.getParameter("dayOfBirth");
        String licenseDate = req.getParameter("licenseDate");

        Boolean isValid = true;
        int age = Period.between(ProjectUtil.parsedateFromCalendar(dayOfBirth).toLocalDate(), LocalDate.now()).getYears();

        if (email == null || email.isEmpty()) {
            isValid = false;
            errors.put("email", "Nieprawidłowy adres e-mail!");
        }

        if (password == null || password.isEmpty() || password.length() < 6) {
            isValid = false;
            errors.put("password", "Nieprawidłowe hasło! Minimum 6 znaków!");
        }

        if (passwordRepeat == null || passwordRepeat.isEmpty() || !passwordRepeat.equals(password)) {
            isValid = false;
            errors.put("passwordRepeat", "Potwierdz hasło!");
        }

        if (firstName == null || firstName.isEmpty()) {
            isValid = false;
            errors.put("firstName", "Wpisz imię!");
        }

        if (lastName == null || lastName.isEmpty()) {
            isValid = false;
            errors.put("lastName", "Wpisz nazwisko!");
        }

        if (phoneNumber == null || phoneNumber.isEmpty()) {
            isValid = false;
            errors.put("phoneNumber", "Wpisz numer telefonu!");
        }

        if (dayOfBirth == null || dayOfBirth.isEmpty()) {
            isValid = false;
            errors.put("dayOfBirth", "Podaj datę urodzenia!");
        } else if (age < 18 || age > 90) {
            isValid = false;
            errors.put("dayOfBirth", "Twój wiek nie spełnia regulaminu!");
        }

        if (licenseDate == null || licenseDate.isEmpty() ||
                !ProjectUtil.parsedateFromCalendar(dayOfBirth).isBefore(ProjectUtil.parsedateFromCalendar(licenseDate))) {
            isValid = false;
            errors.put("licenseDate", "Podaj datę uzyskania prawa jazdy!");
        }

        if (!isValid) {
            req.setAttribute("error", errors);
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        } else {
            User user = new User(email, password);
            UserRepository.saveUser(user);
            Optional<Customer> customerOptional = CustomerRepository.findByEmail(email);
            if (customerOptional.isPresent()) {
                Customer customer = customerOptional.get();
                customer.setName(firstName);
                customer.setLastName(lastName);
                customer.setPhoneNumber(phoneNumber);
                customer.setBirthday(ProjectUtil.parsedateFromCalendar(dayOfBirth).toLocalDateTime());
                customer.setLicenseCarDate(ProjectUtil.parsedateFromCalendar(licenseDate).toLocalDateTime());
                CustomerRepository.saveOrUpdate(customer);
                resp.sendRedirect("login.jsp");
            } else {
                resp.sendRedirect("signup.jsp");
            }
        }
    }

}

