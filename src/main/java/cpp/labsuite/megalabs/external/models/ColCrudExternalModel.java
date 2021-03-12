package cpp.labsuite.megalabs.external.models;

public class ColCrudExternalModel {
    private final String firstName;
    private final String lastName;

    public ColCrudExternalModel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
