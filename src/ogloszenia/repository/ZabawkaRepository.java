package ogloszenia.repository;

import ogloszenia.model.Zabawka;
import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ZabawkaRepository {

    public static int save(Zabawka zabawka) {

        try {
            Session session = HibernateUtil.openSession();
            session.save(zabawka);
            return zabawka.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static List<Zabawka> findToyWithPriceLessThanPara(BigDecimal price) {

        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT z FROM Zabawka z WHERE z.cena.wartosc < :price";
            Query query = session.createQuery(hql);
            query.setParameter("price", price);
            List<Zabawka> resultList = query.getResultList();
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public static Long countAllToys() {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT COUNT(z) FROM Zabawka z";
            Query query = session.createQuery(hql);
            Long count = (Long) query.getSingleResult();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return new Long(-1);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

    }

    public static Optional<Zabawka> findToy(int id) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            return Optional.ofNullable(session.find(Zabawka.class, id));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static boolean delete(Zabawka toy) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            session.beginTransaction();
            session.delete(toy);
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

    public static boolean update(Zabawka zabawka) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            session.beginTransaction();
            session.update(zabawka);
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

    public static List<Zabawka> findToyWithNameAndAvaibility() {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT new Zabawka(nazwa, stanMagazynu) FROM Zabawka z";
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

    public static boolean updatePrice(BigDecimal newPrice) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.getTransaction().begin();
            String sql = "UPDATE zabawki SET wartosc = :price WHERE id > 0";
            Query query = session.createNativeQuery(sql);
            query.setParameter("price", newPrice);
            query.executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static List<Zabawka> findToyByNameLike(String name) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT z FROM Zabawka z WHERE LOWER(z.nazwa) LIKE :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", "%" + name.toLowerCase() + "%");
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
