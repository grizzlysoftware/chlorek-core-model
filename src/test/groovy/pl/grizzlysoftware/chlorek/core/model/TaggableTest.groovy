package pl.grizzlysoftware.chlorek.core.model

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class TaggableTest extends Specification {
    @Unroll
    def "returns true if tag exists, false otherwise"(tag, shouldExist) {
        given:
            def m = new TaggableImpl()
            m.tags = [new DefaultTag("tag0"), new DefaultTag("tag1"), new DefaultTag("tag2"), new DefaultTag("tag3")]
        when:
            def exists = m.hasTag(tag)
        then:
            exists == shouldExist
        where:
            tag    | shouldExist
            null   | false
            ""     | false
            "tag"  | false
            "tag0" | true
            "tag1" | true
            "tag2" | true
            "tag3" | true
    }

    def "returns tag by name"(tagName, expectedTagAtPosition) {
        given:
            def m = new TaggableImpl()
            m.tags = [new DefaultTag("tag0"), new DefaultTag("tag1"), new DefaultTag("tag2"), new DefaultTag("tag3")]
        when:
            def output = m.getTag(tagName)
        then:
            output == m.tags[expectedTagAtPosition]
        where:
            tagName || expectedTagAtPosition
            "tag0"  || 0
            "tag1"  || 1
            "tag2"  || 2
            "tag3"  || 3
    }

    def "returns NullTag when given tag does not exist"() {
        given:
            def m = new TaggableImpl()
            m.tags = [new DefaultTag("tag0"), new DefaultTag("tag1"), new DefaultTag("tag2"), new DefaultTag("tag3")]
        when:
            def output = m.getTag("not existing tag")
        then:
            output instanceof NullTag
            output.name == "NULL_TAG"
    }
}
