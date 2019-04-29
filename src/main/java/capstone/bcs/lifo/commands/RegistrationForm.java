package capstone.bcs.lifo.commands;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegistrationForm {

    // == account ==
    @NotEmpty
    @Size(min = 6, max = 100)
    private String username;

    @NotEmpty
    @Size(min = 8, max = 80)
    private String passwordPlain;

    @NotEmpty
    @Size(min =8, max = 80)
    private String passwordConformation;

    // customer
    @NotEmpty
    @Size(min =2, max = 50)
    private String pFirstName;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String pLastName;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String pEmail;

    @NotEmpty
    @Size(min = 6, max = 15)
    private String pDoB;

    // == this is for the address ==
    @NotEmpty
    @Size(min = 5, max = 50)
    private String aAddress;

    // == can be empty ==
    @Size(max = 50)
    private String aAddress2;

    @NotEmpty
    @Size(min =3, max = 50)
    private String aCity;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String aState;

    @NotEmpty
    @Size(min = 5, max = 10)
    private String aZip;

    // == can be empty ==
    private String aCountry;

    // == can be empty ==
    @Size(max = 255)
    private String aAdditionalInfo;

    @NotEmpty
    @Size(min = 7, max = 14)
    private String aHomePhone;

    @NotEmpty
    @Size(min = 7, max = 14)
    private String aMobilePhone;

    public String getpFirstName() {
        return pFirstName;
    }

    public void setpFirstName(String pFirstName) {
        this.pFirstName = pFirstName;
    }

    public String getpLastName() {
        return pLastName;
    }

    public void setpLastName(String pLastName) {
        this.pLastName = pLastName;
    }

    public String getpEmail() {
        return pEmail;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public String getPasswordPlain() {
        return passwordPlain;
    }

    public void setPasswordPlain(String passwordPlain) {
        this.passwordPlain = passwordPlain;
    }

    public String getPasswordConformation() {
        return passwordConformation;
    }

    public void setPasswordConformation(String passwordConformation) {
        this.passwordConformation = passwordConformation;
    }

    public String getpDoB() {
        return pDoB;
    }

    public void setpDoB(String pDoB) {
        this.pDoB = pDoB;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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