package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceMock;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceMock;

import java.util.HashMap;
import java.util.Map;

class MessageSenderTest {

    @Test
    void sendEnglishText() {
        GeoService geoService = new GeoServiceMock();
        LocalizationService localizationService = new LocalizationServiceMock();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("x-real-ip", "96.44.183.149");
        Assertions.assertEquals(messageSender.send(headers), "Welcome");
    }

    @Test
    void sendRussianText() {
        GeoService geoService = new GeoServiceMock();
        LocalizationService localizationService = new LocalizationServiceMock();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("x-real-ip", "172.0.32.11");
        Assertions.assertEquals(messageSender.send(headers), "Добро пожаловать");
    }

    @Test
    void sendEnglishTextWithMockito() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService
                .byIp("96.44.183.149"))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService
                .locale(Country.USA))
                .thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("x-real-ip", "96.44.183.149");
        Assertions.assertEquals(messageSender.send(headers), "Welcome");
    }

    @Test
    void sendRussianTextWithMockito() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService
                .byIp("172.0.32.11"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService
                .locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("x-real-ip", "172.0.32.11");
        Assertions.assertEquals(messageSender.send(headers), "Добро пожаловать");
    }
}