package pl.grizzlysoftware.chlorek.core.model;

import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

import static pl.grizzlysoftware.chlorek.core.model.TagRegistry.LOYALTY_POINTS_TIME_RANGE_PROMO_TAG;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@EqualsAndHashCode
public class LoyaltyPointsTimeRangePromoTag implements Tag {
    public final LocalDate startingAt;
    public final LocalDate endingAt;
    public final BigDecimal points;

    public LoyaltyPointsTimeRangePromoTag(LocalDate startingAt, LocalDate endingAt, BigDecimal points) {
        this.startingAt = startingAt;
        this.endingAt = endingAt;
        this.points = points;
        validate();
    }

    private void validate() {
        if (startingAt == null) {
            throw new IllegalArgumentException("'startingAt' parameter cannot be null");
        }

        if (endingAt == null) {
            throw new IllegalArgumentException("'endingAt' parameter cannot be null");
        }

        if (startingAt.isAfter(endingAt)) {
            throw new IllegalArgumentException("'startingAt' parameter cannot be after ending at");
        }

        if (points == null) {
            throw new IllegalArgumentException("'points' parameter cannot be null");
        }

        if (points.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("'points' parameter cannot be lesser than 0");
        }

        if (points.compareTo(BigDecimal.valueOf(200)) > 0) {
            throw new IllegalArgumentException("'points' parameter cannot be greater than 200");
        }
    }

    @Override
    public String name() {
        return LOYALTY_POINTS_TIME_RANGE_PROMO_TAG;
    }

    @Override
    public String value() {
        var out = new StringBuilder()
                .append(points)
                .append(',')
                .append(startingAt)
                .append(',')
                .append(endingAt)
                .toString();
        return out;
    }
}
