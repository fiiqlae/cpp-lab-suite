package cpp.labsuite.megalabs.external.controllers;

import cpp.labsuite.megalabs.domain.AlterRecordUseCase;
import cpp.labsuite.megalabs.domain.CreateRecordUseCase;
import cpp.labsuite.megalabs.domain.DeleteRecordUseCase;
import cpp.labsuite.megalabs.domain.GetRecordUseCase;
import cpp.labsuite.megalabs.external.models.ColCrudExternalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/colcrud/create", method = RequestMethod.GET)
    @ResponseBody
    public HttpStatus createRecord(ColCrudExternalModel request) {
        createRecordUseCase.createRecord(request);
        return HttpStatus.OK;
    }
}
