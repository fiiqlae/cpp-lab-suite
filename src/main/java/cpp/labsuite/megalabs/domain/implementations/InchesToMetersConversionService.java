package cpp.labsuite.megalabs.domain.implementations;

import cpp.labsuite.megalabs.domain.ConversionService;

public class InchesToMetersConversionService implements ConversionService {
    private String inchesToMeters(String inchValue) {
        double sourceVal = Double.parseDouble(inchValue);
        return String.valueOf(sourceVal / 39.37) + "m";
    }


    @Override
    public String convert(String value) {
        return inchesToMeters(value);
    }
}
