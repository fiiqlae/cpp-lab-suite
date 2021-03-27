package cpp.labsuite.megalabs.domain.implementations;

import cpp.labsuite.megalabs.domain.ConversionService;

public class MetersToInchesConversionService  implements ConversionService {
    private String metersToInches(String metricValue) {
        double sourceVal = Double.parseDouble(metricValue);
        return String.valueOf(sourceVal * 39.37) + "\"";
    }

    @Override
    public String convert(String value) {
        return metersToInches(value);
    }
}
