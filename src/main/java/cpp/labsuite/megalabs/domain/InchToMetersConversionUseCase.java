package cpp.labsuite.megalabs.domain;

import org.springframework.stereotype.Component;

@Component
public interface InchToMetersConversionUseCase {
    String convert(String inchValue);
}
