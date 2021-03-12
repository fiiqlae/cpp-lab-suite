package cpp.labsuite.megalabs.data;

import cpp.labsuite.megalabs.data.models.ColCrudRecordDataModel;
import cpp.labsuite.megalabs.domain.models.ColCrudRecordDomainModel;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

@Component
public class ColCrudStoreImpl implements ColCrudStore {

    private HashMap<Integer, ColCrudRecordDataModel> storage;

    public ColCrudStoreImpl() {
        this.storage = new HashMap<>();
    }

    @Override
    public void createRecord(ColCrudRecordDomainModel record) {
        storage.put(
                record.hashCode(),
                new ColCrudRecordDataModel(
                        record.hashCode(),
                        record.getFirstName(),
                        record.getLastName()
                )
        );
    }

    @Override
    public void alterRecordByListIndex(int index, ColCrudRecordDomainModel target) {
        try {
            ColCrudRecordDataModel record = getRecordByListIndex(index);
            record.setFirstName(target.getFirstName());
            record.setLastName(target.getLastName());
            storage.remove(record.getId());
            storage.put(record.getId(), record);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRecordByListIndex(int index) {
        try {
            ColCrudRecordDataModel record = getRecordByListIndex(index);
            storage.remove(record.getId());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<ColCrudRecordDataModel> getAllRecords() {
        return storage.values();
    }

    @Override
    public ColCrudRecordDataModel getRecord(int id) {
        try {
            return storage.get(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ColCrudRecordDataModel getRecordByListIndex(int index) {
        int id = getIdByListIndex(index);
        return getRecord(id);
    }

    private int getIdByListIndex(int index) throws IndexOutOfBoundsException {
        Set<Integer> keys = storage.keySet();
        return (int) keys.toArray()[index];
    }
}
