package pl.grizzlysoftware.chlorek.core.model;

import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDate;

class ShiftTimeTest extends Specification {
    def "throws NullPointerException when given shiftDate is null"() {
        when:
            new ShiftTime(null, 5, 55)
        then:
            thrown(NullPointerException)
    }

    @Unroll
    def "throws IllegalArgumentException when either hours or minutes are invalid"(hours, minutes) {
        when:
            new ShiftTime(LocalDate.of(2020, 1, 1), hours, minutes)
        then:
            thrown(IllegalArgumentException)
        where:
            hours | minutes
            -1    | -1
            -1    | 0
            0     | -1
            99    | 99
            24    | 59
            23    | 60
    }

    def "returns this ShiftTime if given ShiftTime is null"() {
        given:
            def shiftTime1 = new ShiftTime(LocalDate.of(2020, 1, 1), 5, 55)
        when:
            def shiftTime = shiftTime1.mergeAndGetNew(null)
        then:
            shiftTime1 == shiftTime
    }

    def "returns this ShiftTime if given ShiftTime is this"() {
        given:
            def shiftTime1 = new ShiftTime(LocalDate.of(2020, 1, 1), 5, 55)
        when:
            def shiftTime = shiftTime1.mergeAndGetNew(shiftTime1)
        then:
            shiftTime1 == shiftTime
    }

    def "returns this ShiftTime if given ShiftTime's date is different"() {
        given:
            def shiftTime1 = new ShiftTime(LocalDate.of(2020, 1, 1), 5, 55)
            def shiftTime2 = new ShiftTime(LocalDate.of(2020, 1, 2), 5, 55)
        when:
            def shiftTime = shiftTime1.mergeAndGetNew(shiftTime2)
        then:
            shiftTime1 == shiftTime
    }

    def "returns new ShiftTime object after merge"() {
        given:
            def shiftTime1 = new ShiftTime(LocalDate.of(2020, 1, 1), 5, 55)
            def shiftTime2 = new ShiftTime(LocalDate.of(2020, 1, 1), 10, 0)
        when:
            def shiftTime = shiftTime1.mergeAndGetNew(shiftTime2)
        then:
            shiftTime != shiftTime1
            shiftTime != shiftTime2
    }

    def "new ShiftTime contains properly sumed hours"() {
        given:
            def shiftTime1 = new ShiftTime(LocalDate.of(2020, 1, 1), 5, 55)
            def shiftTime2 = new ShiftTime(LocalDate.of(2020, 1, 1), 10, 0)
        when:
            def shiftTime = shiftTime1.mergeAndGetNew(shiftTime2)
        then:
            shiftTime.hours == 15
    }

    def "new ShiftTime contains properly sumed hours with overflow"() {
        given:
            def shiftTime1 = new ShiftTime(LocalDate.of(2020, 1, 1), 5, 55)
            def shiftTime2 = new ShiftTime(LocalDate.of(2020, 1, 1), 23, 0)
        when:
            def shiftTime = shiftTime1.mergeAndGetNew(shiftTime2)
        then:
            shiftTime.hours == 23
    }

    def "new ShiftTime contains properly sumed minutes"() {
        given:
            def shiftTime1 = new ShiftTime(LocalDate.of(2020, 1, 1), 5, 55)
            def shiftTime2 = new ShiftTime(LocalDate.of(2020, 1, 1), 10, 4)
        when:
            def shiftTime = shiftTime1.mergeAndGetNew(shiftTime2)
        then:
            shiftTime.minutes == 59
    }

    def "new ShiftTime contains properly sumed minutes with overflow"() {
        given:
            def shiftTime1 = new ShiftTime(LocalDate.of(2020, 1, 1), 5, 55)
            def shiftTime2 = new ShiftTime(LocalDate.of(2020, 1, 1), 10, 55)
        when:
            def shiftTime = shiftTime1.mergeAndGetNew(shiftTime2)
        then:
            shiftTime.hours == 16
            shiftTime.minutes == 50
    }
}
