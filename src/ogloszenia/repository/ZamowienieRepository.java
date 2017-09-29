package ogloszenia.repository;

import ogloszenia.model.PozycjaZamowienia;
import ogloszenia.model.Zabawka;
import ogloszenia.model.Zamowienie;
import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.mapping.Collection;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.*;

public class ZamowienieRepository {

    public static boolean createOrder(HashMap<Zabawka, Integer> toys, String email) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            Zamowienie order = new Zamowienie(email, toys);
            Set<PozycjaZamowienia> pozycjaZamowieniaSet = new HashSet<>();

            toys.forEach((zabawka, liczba) -> pozycjaZamowieniaSet.add(new PozycjaZamowienia(liczba, zabawka, order)));

            for (PozycjaZamowienia pz : pozycjaZamowieniaSet) {
                session.save(pz);
            }
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

    public static List<Zamowienie> findAllOrdersbyToy(Zabawka z) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT z FROM Zamowienie z " +
                    "LEFT JOIN z.pozycjaZamowieniaSet pz" +
                    " WHERE pz.zabawka.id = :id";

            Query query = session.createQuery(hql, Zamowienie.class);
            query.setParameter("id", z.getId());
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
