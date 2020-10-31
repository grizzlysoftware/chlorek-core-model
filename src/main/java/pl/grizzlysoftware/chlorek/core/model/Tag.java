package pl.grizzlysoftware.chlorek.core.model;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public interface Tag {
    String name();
    String value();

    default String stringify() {
        var out = new StringBuilder().append(name());
        var value = value();
        if (value != null) {
            out
                    .append(":")
                    .append(value);
        }
        return out.toString();
    }
}
