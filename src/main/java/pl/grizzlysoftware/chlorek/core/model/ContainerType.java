package pl.grizzlysoftware.chlorek.core.model;

public enum ContainerType {
    BOTTLE_RETURNABLE("BUT ZW"),
    BOTTLE_NOT_RETURNABLE("BUT BZW"),
    BOTTLE_PET("BUT PET"),
    CAN("PUSZ"),
    IRRELEVANT("INNY - NIEISTOTNE", false)
    ;
    public final String value;
    public final boolean nameApplicable;

    ContainerType(String value) {
        this.value = value;
        this.nameApplicable = true;
    }

    ContainerType(String value, boolean applicable) {
        this.value = value;
        this.nameApplicable = applicable;
    }
}
