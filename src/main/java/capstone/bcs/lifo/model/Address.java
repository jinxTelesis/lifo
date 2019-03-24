package capstone.bcs.lifo.model;

import javax.persistence.Embeddable;


@Embeddable
public class Address {

    private String aFirstName;
    private String aLastName;
    private String aCompnay;
    private String aAddress;
    private String aAddress2;
    private String aCity;
    private String aState;
    private String aZip;
    private String aCountry;
    private String aAdditionalInfo;
    private String aHomePhone;
    private String aMobilePhone;

    public String getaFirstName() {
        return aFirstName;
    }

    public void setaFirstName(String aFirstName) {
        this.aFirstName = aFirstName;
    }

    public String getaLastName() {
        return aLastName;
    }

    public void setaLastName(String aLastName) {
        this.aLastName = aLastName;
    }

    public String getaCompnay() {
        return aCompnay;
    }

    public void setaCompnay(String aCompnay) {
        this.aCompnay = aCompnay;
    }

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
