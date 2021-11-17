package pl.grizzlysoftware.chlorek.core.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class InvoicePosition {
    public Long id;
    public Long invoiceId;
    public Long branchId;
    public Long categoryId;
    public Long customerId;
    public Long employeeId;
    public Long productId;
    public Long refundId;
    public Integer cloudId;

    public String ean;
    public String name;
    public Collection<String> tags;

    public LocalDateTime completedAt;
    public LocalDateTime cancelledAt;
    public String currency;

    public BigDecimal discountFixed;
    public BigDecimal discountPercent;

    /** points granted for this position */
    public BigDecimal points;

    public BigDecimal vat;
    public BigDecimal priceWithoutVat;
    public BigDecimal priceBilledWithoutVat;

    /** product count that was sold */
    public BigDecimal quantity;
}
