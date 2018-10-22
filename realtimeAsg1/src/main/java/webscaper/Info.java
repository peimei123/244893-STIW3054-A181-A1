package webscaper;

public class Info {

    private String characteristic;
    private String information;

    public Info(String characteristic,String information){
        this.characteristic=characteristic;
        this.information=information;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getInformation() {

        return information;
    }

    public void setInformation(String information) {

        this.information = information;
    }
}
