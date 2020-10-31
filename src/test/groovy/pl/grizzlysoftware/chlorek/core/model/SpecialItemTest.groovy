package pl.grizzlysoftware.chlorek.core.model

import spock.lang.Specification
import spock.lang.Unroll

import static java.util.stream.Collectors.toList
import static TagRegistry.SPECIAL_ITEM_TAG_PREFIX

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class SpecialItemTest extends Specification {
    def "returns true if item contains special item tag"() {
        given:
            def input = new SpecialItemImpl([new KeyValueTag("${SPECIAL_ITEM_TAG_PREFIX}-tag-1"), new KeyValueTag( "${SPECIAL_ITEM_TAG_PREFIX}-tag-2")])
        when:
            def output = input.isSpecial()
        then:
            output == true
    }

    @Unroll
    def "returns false if item does not contain special item tag"(tags) {
        given:
            def input = new SpecialItemImpl(tags.stream().map({e -> new KeyValueTag(e)}).collect(toList()))
        when:
            def output = input.isSpecial()
        then:
            output == false
        where:
            tags << [[], ['tag1', 'tag2', 'tag3', 'not-sp-product']]
    }


}
