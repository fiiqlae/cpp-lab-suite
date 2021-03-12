package cpp.labsuite.megalabs.domain;

import cpp.labsuite.megalabs.external.models.ColCrudExternalModel;

public interface CreateRecordUseCase {
    boolean createRecord(ColCrudExternalModel request);
}
