package pl.grizzlysoftware.chlorek.core.model;

import java.math.BigDecimal;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class ProductWithStockStatus extends Product {
    public Integer lastInventoryValue;
    public Integer stockQuantity;
    public BigDecimal lastPurchaseNetPrice;
    public Long warehouseId;
}
