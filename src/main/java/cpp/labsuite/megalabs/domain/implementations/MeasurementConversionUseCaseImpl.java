package cpp.labsuite.megalabs.domain.implementations;

import org.springframework.stereotype.Component;

@Component
public class MeasurementConversionUseCaseImpl implements cpp.labsuite.megalabs.domain.MeasurementConversionUseCase {

    @Override
    public String inchesToMeters(String metricValue) {
        double sourceVal = Double.parseDouble(metricValue);
        return String.valueOf(sourceVal * 39.37) + "\"";
    }

    @Override
    public String metersToInches(String inchValue) {
        double sourceVal = Double.parseDouble(inchValue);
        return String.valueOf(sourceVal / 39.37) + "m";
    }
}
