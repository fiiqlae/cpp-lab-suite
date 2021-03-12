package cpp.labsuite.megalabs.domain.implementations;

import cpp.labsuite.megalabs.data.ColCrudStore;
import cpp.labsuite.megalabs.domain.CreateRecordUseCase;
import cpp.labsuite.megalabs.domain.models.ColCrudRecordDomainModel;
import cpp.labsuite.megalabs.external.models.ColCrudExternalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateRecordUseCaseImpl implements CreateRecordUseCase {

    @Autowired
    ColCrudStore store;

    @Override
    public boolean createRecord(ColCrudExternalModel request) {
        try {
            store.createRecord(new ColCrudRecordDomainModel(
                    request.getFirstName(),
                    request.getLastName()
            ));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
