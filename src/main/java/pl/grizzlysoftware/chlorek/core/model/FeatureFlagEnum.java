package pl.grizzlysoftware.chlorek.core.model;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public enum FeatureFlagEnum {
    STOCK_UPDATE_PRODUCT_PRICE("FEATURE.STOCK.PRODUCT_PRICE_UPDATE")
    ;
    public final String name;
    FeatureFlagEnum(String name) {
        this.name = name;
    }
}
