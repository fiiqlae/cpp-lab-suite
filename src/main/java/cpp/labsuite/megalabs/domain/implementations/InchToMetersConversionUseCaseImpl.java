package cpp.labsuite.megalabs.domain.implementations;

import cpp.labsuite.megalabs.domain.InchToMetersConversionUseCase;
import org.springframework.stereotype.Component;

@Component
public class InchToMetersConversionUseCaseImpl implements InchToMetersConversionUseCase {
    @Override
    public String convert(String inchValue) throws NumberFormatException {
        double sourceVal = Double.parseDouble(inchValue);
        return String.valueOf(sourceVal / 39.37) + " m";
    }
}
