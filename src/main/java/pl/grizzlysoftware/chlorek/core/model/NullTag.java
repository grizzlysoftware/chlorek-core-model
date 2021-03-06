package pl.grizzlysoftware.chlorek.core.model;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class NullTag extends KeyValueTag {
    public static NullTag INSTANCE = new NullTag();

    private NullTag() {
        super("NULL_TAG");
    }
}
