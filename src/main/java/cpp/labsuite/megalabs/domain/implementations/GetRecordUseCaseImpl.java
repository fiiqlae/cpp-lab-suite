package cpp.labsuite.megalabs.domain.implementations;

import cpp.labsuite.megalabs.data.ColCrudStore;
import cpp.labsuite.megalabs.data.models.ColCrudRecordDataModel;
import cpp.labsuite.megalabs.domain.GetRecordUseCase;
import cpp.labsuite.megalabs.external.models.ColCrudExternalModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GetRecordUseCaseImpl implements GetRecordUseCase {

    @Autowired
    ColCrudStore store;

    @Override
    public ColCrudExternalModel getColCrudRecord(int listIndex) {
        ColCrudRecordDataModel record = store.getRecordByListIndex(listIndex);
        return new ColCrudExternalModel(
                record.getFirstName(),
                record.getLastName()
        );
    }

    @Override
    public List<ColCrudExternalModel> getAllRecords() {
        Collection<ColCrudRecordDataModel> allRecords = store.getAllRecords();
        return allRecords.stream().map(r -> new ColCrudExternalModel(
                r.getFirstName(),
                r.getLastName()
        )).collect(Collectors.toList());
    }
}
