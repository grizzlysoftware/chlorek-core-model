package pl.grizzlysoftware.chlorek.core.model

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class ProductTest extends Specification {
    def "created product has predefined empty tags list"() {
        when:
            def product = new Product()
        then:
            product.tags != null
    }

    def "does not add tag when trying to add null String tag"() {
        given:
            def product = new Product()
        when:
            product.addTag(null as String)
        then:
            product.getTags().isEmpty()
    }

    def "does not add tag when trying to add null Tag"() {
        given:
            def product = new Product()
        when:
            product.addTag(null as KeyValueTag)
        then:
            product.getTags().isEmpty()
    }

    def "adds Tag"() {
        given:
            def product = new Product()
        when:
            product.addTag(new KeyValueTag("tag"))
        then:
            product.getTags().size() == 1
    }

    def "adds only unique Tags"() {
        given:
            def product = new Product()
        when:
            product.addTag(new KeyValueTag("tag"))
            product.addTag(new KeyValueTag("tag"))
            product.addTag(new KeyValueTag("tag"))
        then:
            product.getTags().size() == 1
    }

    def "adds string tag"() {
        given:
            def product = new Product()
        when:
            product.addTag("tag")
        then:
            product.getTags().size() == 1
    }

    def "adds only unique string tags"() {
        given:
            def product = new Product()
        when:
            product.addTag("tag")
            product.addTag("tag")
            product.addTag("tag")
        then:
            product.getTags().size() == 1
    }

    def "removes tag"(tag) {
        given:
            def product = new Product()
            product.tags = [new KeyValueTag("tag1"), new KeyValueTag("tag2"), new KeyValueTag("tag3")]
        when:
            product.removeTag(tag)
        then:
            product.tags.stream().filter({ e -> e == tag }).findAny().isEmpty()
        where:
            tag << ["", null, "tag1", "tag2", "tag3"]
    }

    def "returns empty tags list"() {
        given:
            def product = new Product()
        when:
            def tags = product.getTags()
        then:
            tags != null
    }

    def "returns tags"() {
        given:
            def product = new Product()
            product.tags = ["tag1", "tag2", "tag3"]
        when:
            def tags = product.getTags()
        then:
            org.apache.commons.collections4.CollectionUtils.isEqualCollection(product.tags, tags)
    }

    def "is of type Taggable"() {
        when:
            def product = new Product()
        then:
            product instanceof Taggable
    }

    def "is of type Container"() {
        when:
            def product = new Product()
        then:
            product instanceof Container
    }

    @Unroll
    def "returns ContainerType"(containerType) {
        given:
            def product = new Product()
            product.containerType = containerType
        when:
            def output = product.getContainerType()
        then:
            output == containerType
        where:
            containerType << ContainerType.values()
    }

    def "is of type SpecialItem"() {
        when:
            def product = new Product()
        then:
            product instanceof SpecialItem
    }

}
