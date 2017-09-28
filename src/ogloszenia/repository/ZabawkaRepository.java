package ogloszenia.repository;

import ogloszenia.model.Zabawka;
import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

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

}
