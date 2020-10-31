package pl.grizzlysoftware.chlorek.core.resolver

import pl.grizzlysoftware.chlorek.core.model.KeyValueTag
import pl.grizzlysoftware.chlorek.core.model.LoyaltyPointsTimeRangePromoTag
import pl.grizzlysoftware.chlorek.core.model.NullTag
import pl.grizzlysoftware.chlorek.core.model.TagRegistry
import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDate

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class ChlorekCsvTagParserTest extends Specification {
    def parser = new ChlorekCsvTagParser()

    def "parse - parses LoyaltyPointsTimeRangePromoTag when 'LOYALTY_POINTS_TIME_RANGE_PROMO_TAG' tag is given"() {
        given:
            def startingAt = "2020-01-01"
            def endingAt = "2020-12-31"
            def points = "21.5"
            def input = "${TagRegistry.LOYALTY_POINTS_TIME_RANGE_PROMO_TAG}:${points},${startingAt},${endingAt}"
        when:
            def output = parser.parse(input)
        then:
            output instanceof LoyaltyPointsTimeRangePromoTag
            output.startingAt == LocalDate.parse(startingAt)
            output.endingAt == LocalDate.parse(endingAt)
            output.points == Double.parseDouble(points)
    }

    @Unroll
    def "parse - parses NullTag when malformed 'LOYALTY_POINTS_TIME_RANGE_PROMO_TAG' tag is given"(startingAt, endingAt, points) {
        given:
            def input = "${TagRegistry.LOYALTY_POINTS_TIME_RANGE_PROMO_TAG}:${points},${startingAt},${endingAt}"
        when:
            def output = parser.parse(input)
        then:
            output instanceof NullTag
        where:
            startingAt   | endingAt     | points
            "xxx"        | "2020-12-31" | "21.5"
            ""           | "2020-12-31" | "21.5"
            "2020-01-01" | "xxx"        | "21.5"
            "2020-01-01" | ""           | "21.5"
            "2020-01-01" | "2020-12-31" | "xxx"
            "2020-01-01" | "2020-12-31" | ""
    }

    @Unroll
    def "parse - parses NullTag for not specific, malformed tags"(input) {
        given:
        when:
            def output = parser.parse(input)
        then:
            output instanceof NullTag
        where:
            input << [
                    "",
                    null
            ]
    }

    @Unroll
    def "parse - parses KeyValueTag for not specific tags without value"(input) {
        given:
        when:
            def output = parser.parse(input)
        then:
            output instanceof KeyValueTag
            output.name() == input
        where:
            input << [
                    "TAG",
                    "XXXXXXXX"
            ]
    }

    @Unroll
    def "parse - parses KeyValueTag for not specific tags with value"(input) {
        given:
        when:
            def output = parser.parse(input)
            def tagParts = input.split(":")
        then:
            output instanceof KeyValueTag
            output.name() == tagParts[0]
            output.value() == tagParts[1]
        where:
            input << [
                    "TAG:XXXX",
                    "XXXXXXXX:YYYYYYY"
            ]
    }
}
