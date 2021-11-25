package pl.grizzlysoftware.chlorek.core.model;

import java.math.BigDecimal;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class Category extends Updatable {
    public Long id;
    public Integer cloudId;
    public boolean isDeleted;
    public boolean isDisplayed;
    public boolean isFiscalizationEnabled;
    public String name;
    public BigDecimal vat;
}
