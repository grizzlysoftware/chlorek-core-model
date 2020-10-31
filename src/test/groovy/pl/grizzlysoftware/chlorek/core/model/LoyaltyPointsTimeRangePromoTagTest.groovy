package pl.grizzlysoftware.chlorek.core.model

import spock.lang.Specification

import static java.time.LocalDate.of

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class LoyaltyPointsTimeRangePromoTagTest extends Specification {
    def "constructor - throws IllegalArgumentException when given 'startingAt' parameter is null"() {
        when:
            new LoyaltyPointsTimeRangePromoTag(null, of(2010, 10, 10), 1.0)
        then:
            thrown(IllegalArgumentException)
        where:
            startingAt       | endingAt         | points
            of(2010, 10, 10) | of(2020, 10, 10) | null
            of(2030, 10, 10) | of(2020, 10, 10) | 5
    }

    def "constructor - throws IllegalArgumentException when given 'endingAt' parameter is null"() {
        when:
            new LoyaltyPointsTimeRangePromoTag(of(2010, 10, 10), null, 1)
        then:
            thrown(IllegalArgumentException)
    }

    def "constructor - throws IllegalArgumentException when given 'startingAt' parameter is after 'endingAt' parameter"() {
        when:
            new LoyaltyPointsTimeRangePromoTag(of(2010, 10, 10),
                    of(2000, 10, 10), 1.0)
        then:
            thrown(IllegalArgumentException)
    }

    def "constructor - throws IllegalArgumentException when given 'points' parameter is null"() {
        when:
            new LoyaltyPointsTimeRangePromoTag(of(2010, 10, 10),
                    of(2020, 10, 10), null)
        then:
            thrown(IllegalArgumentException)
    }

    def "constructor - throws IllegalArgumentException when given 'points' parameter is lesser than 0"() {
        when:
            new LoyaltyPointsTimeRangePromoTag(of(2010, 10, 10),
                    of(2020, 10, 10), -1.0)
        then:
            thrown(IllegalArgumentException)
    }

    def "constructor - throws IllegalArgumentException when given 'points' parameter is greater than 200"() {
        when:
            new LoyaltyPointsTimeRangePromoTag(of(2010, 10, 10),
                    of(2020, 10, 10), 200.01)
        then:
            thrown(IllegalArgumentException)
    }

    def "constructor - maps parameters to attributes properly"() {
        given:
            def startingAt = of(2010, 10, 10)
            def endingAt = of(2020, 10, 10)
            def points = 200.0
        when:
            def output = new LoyaltyPointsTimeRangePromoTag(startingAt, endingAt, points)
        then:
            output.startingAt == startingAt
            output.endingAt == endingAt
            output.points == points
    }

    def "name - returns 'LOYALTY_POINTS_TIME_RANGE_PROMO_TAG'"() {
        given:
            def tag = new LoyaltyPointsTimeRangePromoTag(of(2010, 10, 10),
                    of(2020, 10, 10), 200.0)
        when:
            def output = tag.name()
        then:
            output == TagRegistry.LOYALTY_POINTS_TIME_RANGE_PROMO_TAG
    }

    def "value - returns comma-separated triple of startingAt, endingAt, points"() {
        given:
            def startingAt = of(2010, 10, 10)
            def endingAt = of(2020, 10, 10)
            def points = 200.0
            def tag = new LoyaltyPointsTimeRangePromoTag(startingAt, endingAt, points)
        when:
            def output = tag.value()
        then:
            output == "${points},${startingAt},${endingAt}"
    }
}
