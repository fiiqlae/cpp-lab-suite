package cpp.labsuite.megalabs.domain;

import cpp.labsuite.megalabs.external.models.MeasurementType;
import org.springframework.stereotype.Component;

@Component
public interface MeasurementConversionServiceFactory {
    ConversionService getConverter(MeasurementType targetSystem);
}
