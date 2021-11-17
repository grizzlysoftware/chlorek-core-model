package pl.grizzlysoftware.chlorek.core.model;

import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashSet;

import static java.util.stream.Collectors.joining;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@EqualsAndHashCode
public class Product implements Taggable, SpecialItem, Container {
    public Long id;
    public String name;
    public String ean;
    public String plu;
    public BigDecimal vat;
    public BigDecimal points;
    public String categoryName;
    public Long categoryId;
    public BigDecimal grossSellPrice;
    public BigDecimal netSellPrice;
    public BigDecimal margin;
    public BigDecimal minMargin;
    public BigDecimal flatMargin;
    public boolean isDeleted;
    public boolean isDiscountAllowed;
    public ContainerType containerType;
    private Collection<Tag> tags;

    public Product() {
        this.tags = initializeTags();
    }

    public Product(String name, String ean, BigDecimal vat, BigDecimal grossSellPrice, BigDecimal netSellPrice) {
        this.name = name;
        this.ean = ean;
        this.vat = vat;
        this.grossSellPrice = grossSellPrice;
        this.netSellPrice = netSellPrice;
        this.tags = initializeTags();
    }

    protected Collection<Tag> initializeTags() {
        return new LinkedHashSet<>();
    }

    @Override
    public void addTag(Tag tag) {
        if (tag == null) {
            return;
        }
        tags.add(tag);
    }

    @Override
    public void addTag(String tag) {
        if (isBlank(tag)) {
            return;
        }
        tags.add(new KeyValueTag(tag));
    }

    @Override
    public void removeTag(String tag) {
        tags.removeIf(e -> e.name().equals(tag));
    }

    @Override
    public Collection<Tag> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        var out = new StringBuilder()
                .append("id=")
                .append(id)
                .append(", name=")
                .append(name)
                .append(", tags=")
                .append(tags.stream()
                        .map(Object::toString)
                        .collect(joining(",")));
        return out.toString();
    }

    @Override
    public ContainerType getContainerType() {
        return containerType;
    }
}
