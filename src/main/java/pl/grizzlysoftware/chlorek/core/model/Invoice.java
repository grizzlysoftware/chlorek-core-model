package pl.grizzlysoftware.chlorek.core.model;

import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@EqualsAndHashCode
public class Invoice {
    public String number;
    public BigDecimal netValue;
    public BigDecimal grossValue;
    public boolean isPaid;
    public LocalDate issuedAt;
    public LocalDate paymentDueTo;
    public Long supplierId;
    public Collection<InvoiceItem> items;
}
