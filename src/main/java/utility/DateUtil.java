package utility;

import javax.xml.bind.DatatypeConverter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Utility class used for parsing Dates from Strings and converting Dates to Strings according
 * to ISO 8601.
 */
public final class DateUtil {

    private DateUtil() {
        // prevent construction
    }

    /**
     * Parses a date representing a Date in ISO 8601 format.
     *
     * @param strDate String to parse
     * @return
     */
    public static Date parse(final String strDate) {
        return DatatypeConverter.parseDateTime(strDate).getTime();
    }

    /**
     * Returns a date representation in ISO8601 format and UTC timezone.
     *
     * @param date date to print
     * @return
     */
    public static String print(final Date date) {
        final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal.setTime(date);
        return DatatypeConverter.printDateTime(cal);
    }
}
