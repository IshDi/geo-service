package ru.netology.i18n;

import ru.netology.entity.Country;

public class LocalizationServiceMock extends LocalizationServiceImpl {

    private Country currentCountry;

    public void setCurrentCountry(Country country) {
        this.currentCountry = country;
    }
}
