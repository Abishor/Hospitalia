package model.hospital;

import geo.google.datamodel.GeoAddress;
import geo.google.datamodel.GeoCoordinate;

import static com.google.common.base.Preconditions.checkArgument;

public class Hospital {
    private String name;
    private GeoAddress geoAddress;

    public Hospital(final String name) {
        this(name, null);
    }

    public Hospital(final String name, final GeoAddress geoAddress) {
        checkArgument(!name.isEmpty(), "A name should be provided for the hospital");
        this.name = name;
        this.geoAddress = geoAddress;
    }

    public String getName() {
        return name;
    }

    public GeoAddress getGeoAddress() {
        return geoAddress;
    }

    public GeoCoordinate getGeoCoordinate() {
        return geoAddress.getCoordinate();
    }
}
