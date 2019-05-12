package capstone.bcs.lifo.model;


import javax.persistence.Embeddable;


@Embeddable
public class Address {

    /**
     * this is an embeddable JPA/Hibernate object
     * it stores Address information and is used in CartV2
     */


    private String aAddress;
    private String aAddress2;
    private String aCity;
    private String aState;
    private String aZip;
    private String aCountry;
    private String aAdditionalInfo;
    private String aHomePhone;
    private String aMobilePhone;


    public String getaAddress() {
        return aAddress;
    }



    public void setaAddress(String aAddress) {
        this.aAddress = aAddress;
    }

    public String getaAddress2() {
        return aAddress2;
    }

    public void setaAddress2(String aAddress2) {
        this.aAddress2 = aAddress2;
    }

    public String getaCity() {
        return aCity;
    }

    public void setaCity(String aCity) {
        this.aCity = aCity;
    }

    public String getaState() {
        return aState;
    }

    public void setaState(String aState) {
        this.aState = aState;
    }

    public String getaZip() {
        return aZip;
    }

    public void setaZip(String aZip) {
        this.aZip = aZip;
    }

    public String getaCountry() {
        return aCountry;
    }

    public void setaCountry(String aCountry) {
        this.aCountry = aCountry;
    }

    public String getaAdditionalInfo() {
        return aAdditionalInfo;
    }

    public void setaAdditionalInfo(String aAdditionalInfo) {
        this.aAdditionalInfo = aAdditionalInfo;
    }

    public String getaHomePhone() {
        return aHomePhone;
    }

    public void setaHomePhone(String aHomePhone) {
        this.aHomePhone = aHomePhone;
    }

    public String getaMobilePhone() {
        return aMobilePhone;
    }

    public void setaMobilePhone(String aMobilePhone) {
        this.aMobilePhone = aMobilePhone;
    }
}
