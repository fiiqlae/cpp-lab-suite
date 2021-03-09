package cpp.labsuite.megalabs.domain.implementations;

import org.springframework.stereotype.Component;

@Component
public class MetersToInchConversionUseCaseImpl implements cpp.labsuite.megalabs.domain.MetersToInchConversionUseCase {

    @Override
    public String convert(String metricValue) throws NumberFormatException {
        double sourceVal = Double.parseDouble(metricValue);
        return String.valueOf(sourceVal * 39.37) + "\"";
    }
}
