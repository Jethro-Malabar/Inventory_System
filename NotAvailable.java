public class NotAvailable {
    private String nameOfHardware;
    private String nameOfAssignedEmployee;
    private String code;

    NotAvailable(String nameOfHardware, String nameOfAssignedEmployee, String code) {
        this.nameOfAssignedEmployee = nameOfAssignedEmployee;
        this.nameOfHardware = nameOfHardware;
        this.code = code;
    }

    public String getNameOfHardware() {
        return nameOfHardware;
    }

    public String getNameOfAssignedEmployee() {
        return nameOfAssignedEmployee;
    }
    public String getCode(){
        return code;
    }
    
}
