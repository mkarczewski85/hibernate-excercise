package car_rent.rent;

import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CarRepository {

    public static Optional<Car> findCar(int id) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            return Optional.ofNullable(session.find(Car.class, id));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static List<Car> findAvaibleCar(ZonedDateTime startdate,
                                           ZonedDateTime endDate) {

        return findAvaibleCar(startdate, endDate, null);

    }

    public static List<Car> findAvaibleCar(ZonedDateTime startdate,
                                           ZonedDateTime endDate,
                                           Integer capacity) {

        return findAvaibleCar(startdate, endDate, capacity, null);

    }

    public static List<Car> findAvaibleCar(ZonedDateTime startdate,
                                           ZonedDateTime endDate,
                                           Integer capacity,
                                           CarSegment carSegment) {

        return findAvaibleCar(startdate, endDate, capacity, carSegment, null);


    }

    public static List<Car> findAvaibleCar(ZonedDateTime startdate,
                                           ZonedDateTime endDate,
                                           Integer capacity,
                                           CarSegment carSegment,
                                           Make make) {

        return Collections.emptyList();

    }


}
