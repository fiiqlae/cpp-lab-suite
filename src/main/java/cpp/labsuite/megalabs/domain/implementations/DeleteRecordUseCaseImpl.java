package cpp.labsuite.megalabs.domain.implementations;

import cpp.labsuite.megalabs.data.ColCrudStore;
import cpp.labsuite.megalabs.domain.DeleteRecordUseCase;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteRecordUseCaseImpl implements DeleteRecordUseCase {

    @Autowired
    ColCrudStore store;

    @Override
    public boolean deleteRecord(int listIndex) {
        try {
            store.deleteRecordByListIndex(listIndex);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
