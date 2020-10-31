package pl.grizzlysoftware.chlorek.core.resolver;

import pl.grizzlysoftware.chlorek.core.model.KeyValueTag;
import pl.grizzlysoftware.chlorek.core.model.LoyaltyPointsTimeRangePromoTag;
import pl.grizzlysoftware.chlorek.core.model.NullTag;
import pl.grizzlysoftware.chlorek.core.model.Tag;

import java.math.BigDecimal;
import java.time.LocalDate;

import static pl.grizzlysoftware.chlorek.core.model.TagRegistry.LOYALTY_POINTS_TIME_RANGE_PROMO_TAG;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class ChlorekCsvTagParser extends CsvTagParser {

    public ChlorekCsvTagParser() {
        super(":");
    }

    @Override
    protected Tag resolve(String[] csvParts) {
        if (csvParts.length == 0) {
            return NullTag.INSTANCE;
        }

        if (csvParts.length == 1) {
            return new KeyValueTag(csvParts[0]);
        }

        var tagName = csvParts[0];
        if (LOYALTY_POINTS_TIME_RANGE_PROMO_TAG.equals(tagName)) {
            return loyaltyPointsTimeRangePromoTag(csvParts);
        } else {
            return new KeyValueTag(csvParts[0], csvParts[1]);
        }
    }

    private Tag loyaltyPointsTimeRangePromoTag(String[] parts) {
        var tagParts = parts[1].split(",");
        return new LoyaltyPointsTimeRangePromoTag(
                LocalDate.parse(tagParts[1]),
                LocalDate.parse(tagParts[2]),
                BigDecimal.valueOf(Double.parseDouble(tagParts[0]))
        );
    }
}
