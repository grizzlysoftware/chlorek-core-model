package pl.grizzlysoftware.chlorek.core.model;

import java.math.BigDecimal;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class ProductIngredient extends Updatable {
    public Long id;
    public Long productId;
    public BigDecimal quantity;
    public String unit;
}
