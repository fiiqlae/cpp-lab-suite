package cpp.labsuite.megalabs.external.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ConverterController {
    @RequestMapping(value = "/converter", method = RequestMethod.GET)
    public String index() {
        return "converter";
    }

    @RequestMapping(value = "/converter/convert", method = RequestMethod.GET)
    @ResponseBody
    public String convert(@RequestParam Map<String,String> params) {
        switch (params.get("target")) {
            case "in":
                return "inch value of " + params.get("value");
            case "m":
                return "metric value of " + params.get("value");
            default:
                throw new RuntimeException("No!");
        }
    }
}
