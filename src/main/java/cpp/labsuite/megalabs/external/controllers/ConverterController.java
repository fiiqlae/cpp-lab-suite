package cpp.labsuite.megalabs.external.controllers;

import cpp.labsuite.megalabs.domain.InchToMetersConversionUseCase;
import cpp.labsuite.megalabs.domain.MetersToInchConversionUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
@Component
public class ConverterController {

    @Autowired
    InchToMetersConversionUseCase inchToMetersConversionUseCase;

    @Autowired
    MetersToInchConversionUseCase metersToInchConversionUseCase;

    @RequestMapping(value = "/converter", method = RequestMethod.GET)
    public String index() {
        return "converter";
    }

    @RequestMapping(value = "/converter/convert",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> convert(@RequestParam Map<String, String> params) {
        if (!(params.containsKey("target") && params.containsKey("value")))
            throw new RuntimeException("Invalid request");
        Map<String, String> response = executeConversion(params.get("target"), params.get("value"));
        return response;
    }

    private Map<String, String> executeConversion(String target, String value) {
        Map<String, String> response = new HashMap<>();
        value = value.replaceAll("[^\\d.]", "");
        switch (target) {
            case "in":
                try {
                    String convertedValue = metersToInchConversionUseCase.convert(value);
                    response.put("result", convertedValue);
                    response.put("success", "true");
                } catch (NumberFormatException e) {
                    response.put("success", "false");
                }
                break;
            case "m":
                try {
                    String convertedValue = inchToMetersConversionUseCase.convert(value);
                    response.put("result", convertedValue);
                    response.put("success", "true");
                } catch (NumberFormatException e) {
                    response.put("success", "false");
                }
                break;
            default:
                throw new RuntimeException("No!");
        }
        return response;
    }
}

