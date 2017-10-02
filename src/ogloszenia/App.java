package ogloszenia;

import ogloszenia.model.*;
import ogloszenia.repository.ZabawkaRepository;
import ogloszenia.repository.ZamowienieRepository;
import ogloszeniar.hibernate.util.HibernateUtil;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

/**
 * Created by Lukasz on 27.09.2017.
 */
public class App {

    public static void main(String[] args) throws Exception {

        Logger logger = Logger.getLogger(App.class);

        HibernateUtil.openSession();
//
//        Path path = Paths.get("C:\\Projekty Maciej\\hibernate\\src\\ogloszenia\\toy.jpg");
//        byte[] image = Files.readAllBytes(path);
//
//        Path path2 = Paths.get("C:\\Projekty Maciej\\hibernate\\src\\ogloszenia\\toy2.jpg");
//        byte[] image2 = Files.readAllBytes(path2);
//
//        Path path_doc = Paths.get("C:\\Projekty Maciej\\hibernate\\src\\ogloszenia\\toy_report.pdf");
//        byte[] document = Files.readAllBytes(path_doc);
//
//        Cena cena = new Cena(new BigDecimal(34.56), "PLN");
//        Cena cena2 = new Cena(new BigDecimal(46.84), "PLN");
//        Zabawka doll = new Zabawka("Lalka Barbie", cena, Kolor.CZERWONY, 56, false, Material.PLASTIK, LocalDateTime.now(),
//                image, document);
//        Zabawka teddyBear = new Zabawka("Miś Uszatek", cena2, Kolor.SZARY, 43, true, Material.PLUSZ, LocalDateTime.now(),
//                image2, document);
//
//        ZabawkaRepository.save(doll);
//        ZabawkaRepository.save(teddyBear);
//
//        List<Zabawka> toysList = ZabawkaRepository.findToyWithPriceLessThanPara(new BigDecimal(50));
//
//        toysList.forEach(t -> logger.info(t.getNazwa()));
//
//        long count = ZabawkaRepository.countAllToys();
//
//        logger.info("Ilość: " + count);
//
//        //TWORZENIE ZAMOWIENIA
//
//        HashMap<Zabawka, Integer> listaZakupow = new HashMap<>();
//        listaZakupow.put(toysList.stream().findAny().orElse(doll), new Integer(5));
//        ZamowienieRepository.createOrder(listaZakupow, "test@wp.pl");
//
//        //SZUKANIE ZABAWKI O PODANYM ID
//
//        Optional<Zabawka> toy = ZabawkaRepository.findToy(1);
//
//        if (toy.isPresent()) {
//            logger.info("Zabawka z if: " + toy.get().getId());
//        }
//
//        toy.ifPresent(t -> logger.info("Zabawka (lambda consumer): " + toy.get().getId()));
//
////        //USUWANIE ZABAWKI
////        if (toy.isPresent()) {
////            ZabawkaRepository.delete(toy.get());
////        }
//
//        //UPDATE NA BAZIE
//        if (toy.isPresent()) {
//            toy.get().setNazwa("Lalka bez nazwy");
//            ZabawkaRepository.update(toy.get());
//        }
//
//        if (toy.isPresent()) {
//
//            List<Zamowienie> allOrdersbyToy = ZamowienieRepository.findAllOrdersbyToy(toy.get());
//            for (Zamowienie z : allOrdersbyToy) {
//                logger.info(z.getId() + " : " + z.getDataZamowienia());
//            }
//        }
//
//        logger.info(ZabawkaRepository.findToyWithNameAndAvaibility().get(0).toString());
//
//        ZabawkaRepository.updatePrice(new BigDecimal(100));
//
//        List<Zabawka> toyByNameLike = ZabawkaRepository.findToyByNameLike("toyByNameLike");
//        for (Zabawka z : toyByNameLike){
//            logger.info(z.getNazwa());
//        }

    }
}
