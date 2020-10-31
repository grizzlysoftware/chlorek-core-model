package pl.grizzlysoftware.chlorek.core.model;

import java.util.Collection;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class SpecialItemImpl implements SpecialItem {
    private Collection<Tag> tags;

    public SpecialItemImpl(Collection<Tag> tags) {
        this.tags = tags;
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
        tags.add(new DefaultTag(tag));
    }

    @Override
    public void removeTag(String tag) {
        tags.removeIf(e -> e.name().equals(tag));
    }

    @Override
    public Collection<Tag> getTags() {
        return tags;
    }
}
