package pl.grizzlysoftware.chlorek.core.model;


import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public interface Taggable {
    void addTag(Tag tag);

    void addTag(String tag);

    void removeTag(String tag);

    default boolean hasTag(String tag) {
        return getTags()
                .stream()
                .filter(withName(tag))
                .findAny()
                .isPresent();
    }

    Collection<Tag> getTags();

    default Tag getTag(String name) {
        return getTags()
                .stream()
                .filter(withName(name))
                .findAny()
                .orElse(NullTag.INSTANCE);
    }

    static Predicate<Tag> withName(String name) {
        return e -> StringUtils.equals(e.name, name);
    }
}
