package cpp.labsuite.megalabs.external.controllers;

import cpp.labsuite.megalabs.domain.AlterRecordUseCase;
import cpp.labsuite.megalabs.domain.CreateRecordUseCase;
import cpp.labsuite.megalabs.domain.DeleteRecordUseCase;
import cpp.labsuite.megalabs.domain.GetRecordUseCase;
import cpp.labsuite.megalabs.external.models.ColCrudExternalModel;
import cpp.labsuite.megalabs.external.models.PatchRecordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Component
public class ColCrudController {

    @Autowired
    CreateRecordUseCase createRecordUseCase;

    @Autowired
    AlterRecordUseCase alterRecordUseCase;

    @Autowired
    DeleteRecordUseCase deleteRecordUseCase;

    @Autowired
    GetRecordUseCase getRecordUseCase;


    @RequestMapping(value = "/colcrud", method = RequestMethod.GET)
    public String index() {
        return "colcrud";
    }

    @RequestMapping(value = "/colcrud/create", method = RequestMethod.PUT)
    @ResponseBody
    public HttpStatus createRecord(ColCrudExternalModel request) {
        createRecordUseCase.createRecord(request);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/colcrud/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public HttpStatus deleteRecord(PatchRecordRequest request) {
        deleteRecordUseCase.deleteRecord(request.getListIndex());
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/colcrud/all",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<List<ColCrudExternalModel>> getAllRecords() {
        List<ColCrudExternalModel> records = getRecordUseCase.getAllRecords();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @RequestMapping(value = "/colcrud/edit", method = RequestMethod.PATCH)
    @ResponseBody
    public ResponseEntity<ColCrudExternalModel> alterRecord(PatchRecordRequest request) {
        ColCrudExternalModel requestBody = new ColCrudExternalModel(request.getFirstName(), request.getLastName());
        alterRecordUseCase.alterRecord(request.getListIndex(), requestBody);
        return new ResponseEntity<>(requestBody, HttpStatus.OK);
    }
}
