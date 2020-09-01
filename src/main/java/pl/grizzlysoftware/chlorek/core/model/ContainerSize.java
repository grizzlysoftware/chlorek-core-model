package pl.grizzlysoftware.chlorek.core.model;

import java.util.Collection;

import static java.util.Arrays.asList;

public class ContainerSize {
    public final String value;
    public final boolean nameApplicable;

    public ContainerSize(String value) {
        this.value = value;
        this.nameApplicable = true;
    }

    public ContainerSize(String value, boolean nameApplicable) {
        this.value = value;
        this.nameApplicable = nameApplicable;
    }

    private static final Collection<ContainerSize> sizes = asList(
            new ContainerSize("90ML"),
            new ContainerSize("100ML"),
            new ContainerSize("200ML"),
            new ContainerSize("0.25L"),
            new ContainerSize("0.33L"),
            new ContainerSize("0.35L"),
            new ContainerSize("0.4L"),
            new ContainerSize("0.5L"),
            new ContainerSize("0.65L"),
            new ContainerSize("0.66L"),
            new ContainerSize("0.7L"),
            new ContainerSize("0.75L"),
            new ContainerSize("0.85L"),
            new ContainerSize("1L"),
            new ContainerSize("1.5L"),
            new ContainerSize("2L"),
            new ContainerSize("2.5L"),
            new ContainerSize("INNY - NIEISTOTNE", false)
    );

    public static Collection<ContainerSize> sizes() {
        return sizes;
    }

    public static ContainerSize getByName(String name) {
        var out = sizes()
                .stream()
                .filter(e -> e.value.equals(name))
                .findAny()
                .orElse(null);
        return out;
    }
}
