package pl.grizzlysoftware.chlorek.core.model;

import lombok.EqualsAndHashCode;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@EqualsAndHashCode(exclude = "value")
public class Tag {
    public final String name;
    public final String value;

    public Tag(String name, String value) {
        this.name = requireNonBlank(name);
        this.value = value;
    }

    public Tag(String name) {
        this(name, null);
    }

    protected String requireNonBlank(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException("tag name cannot be neither null nor blank");
        }

        return name;
    }

    @Override
    public String toString() {
        var out = new StringBuilder().append(name);
        if (value != null) {
            out
                    .append(":")
                    .append(value);
        }
        return out.toString();
    }
}
