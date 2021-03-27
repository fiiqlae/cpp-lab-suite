package cpp.labsuite.megalabs.domain.implementations;

import cpp.labsuite.megalabs.domain.ConversionService;
import cpp.labsuite.megalabs.domain.MeasurementConversionServiceFactory;
import cpp.labsuite.megalabs.external.models.MeasurementType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MeasurementConversionServiceFactoryImpl implements MeasurementConversionServiceFactory {
    Logger logger = LoggerFactory.getLogger(MeasurementConversionServiceFactoryImpl.class);

    @Override
    public ConversionService getConverter(MeasurementType targetSystem) {
        switch (targetSystem) {
            case METERS:
                return new InchesToMetersConversionService();
            case INCHES:
                return new MetersToInchesConversionService();
            default:
                logger.error("impossible target system");
                throw new RuntimeException("impossible target system");
        }
    }
}
