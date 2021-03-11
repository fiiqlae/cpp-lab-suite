package cpp.labsuite.megalabs.domain;

import cpp.labsuite.megalabs.external.models.ColCrudExternalModel;

import java.util.List;

public interface GetRecordUseCase {
    ColCrudExternalModel getColCrudRecord(int listIndex);
    List<ColCrudExternalModel> getAllRecords();
}
