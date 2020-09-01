package pl.grizzlysoftware.chlorek.core.model;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class EmployeeShiftTime {
    public final String employeeName;
    public final ShiftTime shiftTime;

    public EmployeeShiftTime(String employeeName, ShiftTime shiftTime) {
        this.employeeName = employeeName;
        this.shiftTime = shiftTime;
    }
}
