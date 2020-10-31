package pl.grizzlysoftware.chlorek.core.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.LinkedHashSet;

import static java.util.stream.Collectors.toList;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */

public class TaggableImpl implements Taggable, Container {
    ContainerType containerType;
    Collection<Tag> tags;

    public TaggableImpl(Collection<String> tags) {
        this.tags = tags
                .stream()
                .map(DefaultTag::new)
                .collect(toList());
    }

    public TaggableImpl() {
        this.tags = new LinkedHashSet<>();
    }

    @Override
    public void addTag(Tag tag) {
        tags.add(tag);
    }

    @Override
    public void addTag(String tag) {
        tags.add(new DefaultTag(tag));
    }

    @Override
    public void removeTag(String tag) {
        tags.removeIf(e -> StringUtils.equals(e.name(), tag));
    }

    @Override
    public Collection<Tag> getTags() {
        return tags;
    }

    @Override
    public ContainerType getContainerType() {
        return containerType;
    }
}
