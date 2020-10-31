package pl.grizzlysoftware.chlorek.core.model;

import java.util.Objects;

import static pl.grizzlysoftware.chlorek.core.model.TagRegistry.SPECIAL_ITEM_TAG_PREFIX;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public interface SpecialItem extends Taggable {
    default boolean isSpecial() {
        return getTags()
                .stream()
                .filter(Objects::nonNull)
                .anyMatch(e -> e.name().startsWith(SPECIAL_ITEM_TAG_PREFIX));
    }
}
