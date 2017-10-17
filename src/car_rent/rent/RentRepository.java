package car_rent.rent;

import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

public class RentRepository {

    public static boolean save(Rent rent) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            session.save(rent);
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


    public static boolean remove(Rent rent) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            session.getTransaction().begin();
            session.remove(rent);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    public static List<Rent> findAll() {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT r FROM Rent r ORDER BY r.startDate DESC";
            Query query = session.createQuery(hql);
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

    public static List<Rent> findByUserId(int id) {

        Session session = null;
        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT r FROM Rent r WHERE r.customer.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
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

}
