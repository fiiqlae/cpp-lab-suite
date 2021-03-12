package cpp.labsuite.megalabs.domain.implementations;

import cpp.labsuite.megalabs.data.ColCrudStore;
import cpp.labsuite.megalabs.data.models.ColCrudRecordDataModel;
import cpp.labsuite.megalabs.domain.AlterRecordUseCase;
import cpp.labsuite.megalabs.domain.models.ColCrudRecordDomainModel;
import cpp.labsuite.megalabs.external.models.ColCrudExternalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlterRecordUseCaseImpl implements AlterRecordUseCase {

    @Autowired
    ColCrudStore store;

    @Override
    public boolean alterRecord(int listIndex, ColCrudExternalModel model) {
        try {
            ColCrudRecordDataModel record = store.getRecordByListIndex(listIndex);
            record.setLastName(model.getLastName());
            record.setFirstName(record.getFirstName());
            store.alterRecordByListIndex(listIndex, new ColCrudRecordDomainModel(
                    model.getFirstName(),
                    model.getLastName()
            ));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
