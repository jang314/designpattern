package modeling;

public class Person {
    private Phone homePhones;
    private Phone officePhone;

    public Phone getHomePhones() {
        return homePhones;
    }
    public void setHomePhones(Phone homePhones) {
        this.homePhones = homePhones;
    }
    public Phone getOfficePhone() {
        return officePhone;
    }
    public void setOfficePhone(Phone officePhone) {
        this.officePhone = officePhone;
    }
}
