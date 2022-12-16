package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceTest {
    GeoService geoService = new GeoServiceImpl();

    @Test
    public void testErrorIp() {
        Location result = geoService.byIp("00.0.00.00");
        Assertions.assertNull(result);
    }

    @Test
    public void testCreateNewLocation() {
        Location result = geoService.byIp("127.0.0.1");
        Location expected = new Location(null, null, null, 0);
        Assertions.assertEquals(expected.getCity(), result.getCity());
        Assertions.assertEquals(expected.getCountry(), result.getCountry());
        Assertions.assertEquals(expected.getStreet(), result.getStreet());
        Assertions.assertEquals(expected.getBuiling(), result.getBuiling());
    }

    @Test
    public void testMoscowIp() {
        Location result = geoService.byIp("172.0.32.11");
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Assertions.assertEquals(expected.getCity(), result.getCity());
        Assertions.assertEquals(expected.getCountry(), result.getCountry());
        Assertions.assertEquals(expected.getStreet(), result.getStreet());
        Assertions.assertEquals(expected.getBuiling(), result.getBuiling());
    }

    @Test
    public void testNewYorkIp() {
        Location result = geoService.byIp("96.44.183.149");
        Location expected = new Location("New York", Country.USA, " 10th Avenue", 32);
        Assertions.assertEquals(expected.getCity(), result.getCity());
        Assertions.assertEquals(expected.getCountry(), result.getCountry());
        Assertions.assertEquals(expected.getStreet(), result.getStreet());
        Assertions.assertEquals(expected.getBuiling(), result.getBuiling());
    }

    @Test
    public void testAllMoscowIp() {
        Location result = geoService.byIp("172.00.00.00");
        Location expected = new Location("Moscow", Country.RUSSIA, null, 0);
        Assertions.assertEquals(expected.getCity(), result.getCity());
        Assertions.assertEquals(expected.getCountry(), result.getCountry());
        Assertions.assertEquals(expected.getStreet(), result.getStreet());
        Assertions.assertEquals(expected.getBuiling(), result.getBuiling());
    }

    @Test
    public void testAllNewYorkIp() {
        Location result = geoService.byIp("96.00.00.00");
        Location expected = new Location("New York", Country.USA, null,  0);
        Assertions.assertEquals(expected.getCity(), result.getCity());
        Assertions.assertEquals(expected.getCountry(), result.getCountry());
        Assertions.assertEquals(expected.getStreet(), result.getStreet());
        Assertions.assertEquals(expected.getBuiling(), result.getBuiling());
    }
}
