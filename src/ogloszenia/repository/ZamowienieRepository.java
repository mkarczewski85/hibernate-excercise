package ogloszenia.repository;

import ogloszenia.model.PozycjaZamowienia;
import ogloszenia.model.Zabawka;
import ogloszenia.model.Zamowienie;
import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ZamowienieRepository {

    public static boolean createOrder(HashMap<Zabawka, Integer> toys, String email) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            Zamowienie order = new Zamowienie(email, toys);
            Set<PozycjaZamowienia> pozycjaZamowieniaSet = new HashSet<>();

            toys.forEach((zabawka, liczba) -> pozycjaZamowieniaSet.add(new PozycjaZamowienia(liczba, zabawka, order)));

            for (PozycjaZamowienia pz : pozycjaZamowieniaSet){
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
}
