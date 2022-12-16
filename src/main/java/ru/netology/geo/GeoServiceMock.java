package ru.netology.geo;

import ru.netology.entity.Location;

public class GeoServiceMock extends GeoServiceImpl {

    private Location currentLocation;

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }
}
