package pl.grizzlysoftware.chlorek.core.model;

import java.time.LocalDateTime;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class Shift {
    public Long branchId;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public String employeeName;
}
