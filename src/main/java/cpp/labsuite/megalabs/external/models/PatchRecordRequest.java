package cpp.labsuite.megalabs.external.models;

public class PatchRecordRequest {
    private final String firstName;
    private final String lastName;
    private final int listIndex;


    public PatchRecordRequest(String firstName, String lastName, int listIndex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.listIndex = listIndex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getListIndex() {
        return listIndex;
    }
}
