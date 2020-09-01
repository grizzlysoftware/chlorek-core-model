package pl.grizzlysoftware.chlorek.core.model;

import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@EqualsAndHashCode
public class Stockup {
    public Long warehouseId;
    public Invoice invoice;
    public ZonedDateTime createdAt;
    public String createdBy;
    public ZonedDateTime updatedAt;
    public String updatedBy;
    public String notes;
}
