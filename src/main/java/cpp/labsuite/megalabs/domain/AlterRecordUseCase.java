package cpp.labsuite.megalabs.domain;

import cpp.labsuite.megalabs.external.models.ColCrudExternalModel;

public interface AlterRecordUseCase {
    boolean alterRecord(int listIndex, ColCrudExternalModel target);
}
