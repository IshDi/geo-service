package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

public class LocalizationServiceTest {
    LocalizationService localizationService = new LocalizationServiceImpl();

    @Test
    public void testMessageForRussia() {
        String result = localizationService.locale(Country.RUSSIA);
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMessageForOtherCountries() {
        String result = localizationService.locale(Country.BRAZIL);
        Assertions.assertEquals("Welcome", result);
    }
}
