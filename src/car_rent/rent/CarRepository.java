package car_rent.rent;

import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CarRepository {

    public static boolean save(Car car) {

        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.save(car);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

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

    public static List<Car> findAvaibleCar(ZonedDateTime startDate,
                                           ZonedDateTime endDate) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT c FROM Car c WHERE c.id " +
                    "NOT IN (SELECT r.car.id FROM Rent r WHERE (r.startDate < :startDate AND r.endDate < :startDate)" +
                    "OR (r.startDate > :endDate AND r.endDate < :endDate))";
            Query query = session.createQuery(hql);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

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

        Session session = null;
        try {

            session = HibernateUtil.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Car> query = criteriaBuilder.createQuery(Car.class);

            Root<Car> car = query.from(Car.class);
            query.select(car);
            Predicate makePredicate = criteriaBuilder.equal(car.get("make"), make);
            Predicate carSegmentPredicate = criteriaBuilder.equal(car.get("carSegment"), carSegment);
            Predicate capacityPredicate = criteriaBuilder.equal(car.get("capacity"), capacity);

            //TODO dodać predykaty z datami

            Predicate and = criteriaBuilder.and(makePredicate, carSegmentPredicate, capacityPredicate);

            query.where(and);
            return session.createQuery(query).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
