package model;

import geo.google.datamodel.GeoAddress;

public class Patient extends Person<Patient.Data> {
    private Patient.Data info;

    public Patient(final String name, final Patient.Data info) {
        super(name);
        this.info = info;
    }

    public Patient.Data getInfo() {
        return info;
    }

    public void setInfo(final Patient.Data info) {
        this.info = info;
    }

    public static class Data {
        private final GeoAddress currentLocation;
        private final GeoAddress address;

        public Data(final GeoAddress currentLocation, final GeoAddress address) {
            this.currentLocation = currentLocation;
            this.address = address;
        }

        public GeoAddress getCurrentLocation() {
            return currentLocation;
        }

        public GeoAddress getAddress() {
            return address;
        }
    }
}
