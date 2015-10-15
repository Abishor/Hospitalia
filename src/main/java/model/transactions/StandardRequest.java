package model.transactions;

import model.Patient;
import org.joda.time.Interval;

public class StandardRequest extends Request<StandardRequest.Data> {

    public static class Data {
        private final Patient patient;
        private final Interval interval;

        public Data(final Patient patient, final Interval interval) {
            this.patient = patient;
            this.interval = interval;
        }

        public Interval getInterval() {
            return interval;
        }

        public Patient getPatient() {
            return patient;
        }
    }
}
