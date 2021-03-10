package cpp.labsuite.megalabs.domain;

import org.springframework.stereotype.Component;

@Component
public interface MeasurementConversionUseCase {
    String inchesToMeters(String metricValue);
    String metersToInches(String inchValue);
}
