package cpp.labsuite.megalabs.external.models;

public final class ConvertResponse {
    private boolean success;
    private String result;

    public ConvertResponse() { }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getResult() {
        return result;
    }
}
