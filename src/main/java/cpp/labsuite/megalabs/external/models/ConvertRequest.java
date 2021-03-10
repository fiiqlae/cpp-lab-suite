package cpp.labsuite.megalabs.external.models;

public final class ConvertRequest {

    private String targetSystem;
    private String requestValue;

    public ConvertRequest() { }

    public MeasurementType getTargetSystem() {
        return targetSystem.equals("m") ? MeasurementType.METERS : MeasurementType.INCHES;
    }

    public String getRequestValue() {
        return requestValue.replaceAll("[^\\d.]", "");
    }

    public void setTargetSystem(String targetSystem) {
        this.targetSystem = targetSystem;
    }

    public void setRequestValue(String requestValue) {
        this.requestValue = requestValue;
    }
}
