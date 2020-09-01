package pl.grizzlysoftware.chlorek.core.model;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public interface FeatureFlag {
    String name();
    String value();
    boolean isEnabled();
}
