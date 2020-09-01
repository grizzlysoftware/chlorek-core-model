package pl.grizzlysoftware.chlorek.core.model;

import java.math.BigDecimal;

import static pl.grizzlysoftware.commons.NumberUtils.with2Scale;


/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public enum Vat {
    VAT_0(0.00),
    VAT_5(0.05),
    VAT_8(0.08),
    VAT_23(0.23),
    DO_NOT_USE_THAT(99999999.00);
    public final BigDecimal value;

    Vat(double val) {
        this.value = with2Scale(val);
    }
}
