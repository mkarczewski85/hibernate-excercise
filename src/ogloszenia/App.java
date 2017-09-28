package ogloszenia;

import ogloszenia.model.Cena;
import ogloszenia.model.Kolor;
import ogloszenia.model.Material;
import ogloszenia.model.Zabawka;
import ogloszenia.repository.ZabawkaRepository;
import ogloszeniar.hibernate.util.HibernateUtil;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

/**
 * Created by Lukasz on 27.09.2017.
 */
public class App {

    public static void main(String[] args) throws Exception {

        Logger logger = Logger.getLogger(App.class);

        HibernateUtil.openSession();

        Path path = Paths.get("C:\\Projekty Maciej\\hibernate\\src\\ogloszenia\\toy.jpg");
        byte[] image = Files.readAllBytes(path);

        Path path_doc = Paths.get("C:\\Projekty Maciej\\hibernate\\src\\ogloszenia\\toy_report.pdf");
        byte[] document = Files.readAllBytes(path_doc);

        Cena cena = new Cena(new BigDecimal(34.56), "PLN");
        Zabawka lalka = new Zabawka("Lalka Barbie", cena, Kolor.CZERWONY, 56, false, Material.PLASTIK, LocalDate.now(),
                image, document);

        ZabawkaRepository.save(lalka);

        List<Zabawka> toysList = ZabawkaRepository.findToyWithPriceLessThanPara(new BigDecimal(50));

        toysList.forEach(t -> logger.info(t.getNazwa()));


    }
}
