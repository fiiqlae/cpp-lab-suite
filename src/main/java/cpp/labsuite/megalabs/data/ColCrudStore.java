package cpp.labsuite.megalabs.data;

import cpp.labsuite.megalabs.data.models.ColCrudRecordDataModel;
import cpp.labsuite.megalabs.domain.models.ColCrudRecordDomainModel;

import java.util.Collection;

public interface ColCrudStore {
    void createRecord(ColCrudRecordDomainModel record);
    void alterRecordByListIndex(int index, ColCrudRecordDomainModel target);
    void deleteRecordByListIndex(int index);
    Collection<ColCrudRecordDataModel> getAllRecords();
    ColCrudRecordDataModel getRecord(int id);
    ColCrudRecordDataModel getRecordByListIndex(int index);
}
