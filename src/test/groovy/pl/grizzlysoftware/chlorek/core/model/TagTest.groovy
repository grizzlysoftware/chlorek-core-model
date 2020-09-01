package pl.grizzlysoftware.chlorek.core.model

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class TagTest extends Specification {
    @Unroll
    def "constructor throws IllegalArgumentException when given tag name is null or blank #0"(name) {
        when:
            new Tag(name, null)
        then:
            thrown(IllegalArgumentException)
        where:
            name << [null, "", " ", "        ", "                      "]
    }

    @Unroll
    def "constructor throws IllegalArgumentException when given tag name is null or blank #1"(name) {
        when:
            new Tag(name)
        then:
            thrown(IllegalArgumentException)
        where:
            name << [null, "", " ", "        ", "                      "]
    }
}
