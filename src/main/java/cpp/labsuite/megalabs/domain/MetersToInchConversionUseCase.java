package cpp.labsuite.megalabs.domain;

import org.springframework.stereotype.Component;

@Component
public interface MetersToInchConversionUseCase {
    String convert(String metricValue);
}
