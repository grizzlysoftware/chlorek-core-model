package pl.grizzlysoftware.chlorek.core.model;

import java.time.LocalDate;

import static java.util.Objects.requireNonNull;

public class ShiftTime {
    public final LocalDate shiftDate;
    public final int hours;
    public final int minutes;

    public ShiftTime(LocalDate shiftDate, int hours, int minutes) {
        this.shiftDate = requireNonNull(shiftDate);
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException();
        }
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException();
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    public ShiftTime mergeAndGetNew(ShiftTime in) {
        if (in == null) {
            return this;
        }

        if (this == in) {
            return this;
        }

        if (in.shiftDate.compareTo(shiftDate) != 0) {
            return this;
        }

        var minutes = in.minutes + this.minutes;
        var tmpHrs = minutes / 60;
        minutes = minutes - tmpHrs * 60;

        if (minutes > 59) {
            minutes = 59;
        }

        var hrs = in.hours + hours + tmpHrs;
        if (hrs > 23) {
            hrs = 23;
        }

        var out = new ShiftTime(in.shiftDate, hrs, minutes);
        return out;
    }
}
