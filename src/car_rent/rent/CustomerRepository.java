package car_rent.rent;

import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Optional;

public class CustomerRepository {


    public static Optional<Customer> findByEmail(String email) {

        Session session = null;
        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT c FROM Customer c WHERE c.id = (SELECT u FROM User u WHERE u.email = :email)";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            return Optional.ofNullable((Customer) query.getSingleResult());
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static boolean update(Customer customer) {

        Session session = null;

        try {
            session = HibernateUtil.openSession();
            session.beginTransaction();
            session.update(customer);
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

    public static Optional<Customer> findById(int userId){
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            return Optional.ofNullable(session.find(Customer.class, userId));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
