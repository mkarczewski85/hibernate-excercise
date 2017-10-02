package car_rent.account;

import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Optional;

public class UserRepository {

    public static Optional<User> findUserByMailAndPassword(String email, String password) {

        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            query.setParameter("password", password);
            return Optional.ofNullable((User) query.getSingleResult());
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    public static boolean saveUser(User user) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            session.save(user);
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


}
