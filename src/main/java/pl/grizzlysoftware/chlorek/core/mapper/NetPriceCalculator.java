package pl.grizzlysoftware.chlorek.core.mapper;

import java.math.BigDecimal;
import java.util.function.BiFunction;

import static pl.grizzlysoftware.commons.NumberUtils.with2Scale;


/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class NetPriceCalculator implements BiFunction<BigDecimal, BigDecimal, BigDecimal> {
    @Override
    public BigDecimal apply(BigDecimal grossPrice, BigDecimal vat) {
        if (grossPrice == null || vat == null) {
            return null;
        }

        var vat_ = vat.doubleValue();

        if (vat_ < 0 || vat_ > 1.0) {
            throw new IllegalArgumentException("vat cannot be neither a negative BigDecimal or greater than 1");
        }

        if (vat_ == 0) {
            return with2Scale(grossPrice);
        }

        return with2Scale(grossPrice.divide(BigDecimal.valueOf(1 + vat_)));
    }
}
