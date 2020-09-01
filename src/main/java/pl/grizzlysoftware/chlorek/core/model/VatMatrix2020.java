package pl.grizzlysoftware.chlorek.core.model;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class VatMatrix2020 implements VatMatrix {
    @Override
    public Collection<Vat> values() {
        return Arrays.asList(
                Vat.VAT_0,
                Vat.VAT_5,
                Vat.VAT_8,
                Vat.VAT_23
        );
    }
}
