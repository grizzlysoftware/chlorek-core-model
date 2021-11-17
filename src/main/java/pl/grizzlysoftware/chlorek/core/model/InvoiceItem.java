package pl.grizzlysoftware.chlorek.core.model;

import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@EqualsAndHashCode
public class InvoiceItem {
    public Long id;
    public Long itemId;
    public String itemName;
    public BigDecimal netPurchasePrice;
    public BigDecimal vat;
    public BigDecimal grossSellPrice;
    public BigDecimal netPurchaseTotalPrice;
    public BigDecimal currentGrossSellPrice;
    public BigDecimal quantity;
}
