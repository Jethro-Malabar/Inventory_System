public class Inventory {

    private String code;
    private String nameOfHardware;
    private String kindOfPeripheral;
    

    Inventory(String code, String nameOfHardware, String kindOfPeripheral) {
        this.code = code;
        this.nameOfHardware = nameOfHardware;
        this.kindOfPeripheral = kindOfPeripheral;

    }

    public String getCode() {
        return code;
    }

    public String getNameOfHardware() {
        return nameOfHardware;
    }

    public String getKindOfPeripheral() {
        return kindOfPeripheral;
    }

}
