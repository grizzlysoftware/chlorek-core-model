package pl.grizzlysoftware.chlorek.core.model;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class Supplier extends Updatable {
    public Long id;
    public Integer cloudId;
    public Long companyId;
    public String externalId;
    public String vatId;
    /**
     * wtf is that, it seems to be some sort of name, not id
     */
    public String name;

    public String phone;
    public String address1;
    public String address2;
    public String city;
    public String countryCode;
    public boolean isDeleted;
    public String email;
    public String vatNumber;
    public String zipCode;
}
