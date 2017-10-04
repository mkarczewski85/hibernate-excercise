package car_rent.rent;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public class CarRepositoryTest {

    @Test
    public void findAvaibleCar() throws Exception {

        List<Car> avaibleMercedesCar = CarRepository.findAvaibleCar(ZonedDateTime.now(), ZonedDateTime.now(), 5,
                CarSegment.PREMIUM, Make.MERCEDES);

        Assert.assertTrue("Find car", avaibleMercedesCar.size() > 0);

        List<Car> avaibleKiaCar = CarRepository.findAvaibleCar(ZonedDateTime.now(), ZonedDateTime.now(), 5,
                CarSegment.BASIC, Make.KIA);

        Assert.assertTrue("Find car", avaibleKiaCar.size() == 0);

    }

    @Test
    public void save() throws Exception {

        Engine newEngine = new Engine(new BigDecimal(4200), EngineType.DIESEL, new BigDecimal(15),
                GearBox.AUTO, 350, 500);
        Car newCar = new Car("Mercedes", Make.MERCEDES, 5, newEngine, CarSegment.PREMIUM, Color.RED, new BigDecimal(300),
                new BigDecimal(100));

        CarRepository.save(newCar);

    }

    @Test
    public void testRentCar() {
        List<Car> avaibleMercedesCar = CarRepository.findAvaibleCar(ZonedDateTime.now(), ZonedDateTime.now(), 5,
                CarSegment.PREMIUM, Make.MERCEDES);
        Optional<Car> car = avaibleMercedesCar.stream().findAny();
        if (car.isPresent()) {
            car.get().rentCar(new Customer(), ZonedDateTime.now(), ZonedDateTime.now().plusDays(3));
        }
    }

    @Test
    public void testAvaibleCar(){
        Engine newEngine = new Engine(new BigDecimal(4200), EngineType.DIESEL, new BigDecimal(15),
                GearBox.AUTO, 350, 500);
        Car newCar = new Car("Mercedes ML", Make.MERCEDES, 5, newEngine, CarSegment.PREMIUM, Color.RED,
                new BigDecimal(300), new BigDecimal(100));
        newCar.rentCar(new Customer(), ZonedDateTime.now(), ZonedDateTime.now().plusDays(3));

        List<Car> avaibleCars = CarRepository.findAvaibleCar(ZonedDateTime.now(), ZonedDateTime.now().plusDays(1));

        Assert.assertEquals(newCar, CarRepository.findCar(newCar.getId()).get());
        Assert.assertFalse("rent car is no longer avaible", avaibleCars.contains(newCar));

        newCar.rentCar(new Customer(), ZonedDateTime.now().plusDays(2), ZonedDateTime.now().plusDays(5));

        List<Car> avaibleCar2 = CarRepository.findAvaibleCar(ZonedDateTime.now(), ZonedDateTime.now().plusDays(3));

        Assert.assertFalse("rent car is no longer avaible", avaibleCar2.contains(newCar));
    }

}