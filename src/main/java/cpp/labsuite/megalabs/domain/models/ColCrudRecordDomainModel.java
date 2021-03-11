package cpp.labsuite.megalabs.domain.models;

public class ColCrudRecordDomainModel {
    private final String firstName;
    private final String lastName;

    public ColCrudRecordDomainModel(String firstName, String lastName) {
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
