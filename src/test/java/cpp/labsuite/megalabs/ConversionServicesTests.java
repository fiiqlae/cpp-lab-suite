package cpp.labsuite.megalabs;

import cpp.labsuite.megalabs.domain.ConversionService;
import cpp.labsuite.megalabs.domain.MeasurementConversionServiceFactory;
import cpp.labsuite.megalabs.external.models.MeasurementType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ConversionServicesTests {
    @Autowired
    MeasurementConversionServiceFactory factory;

    @Test
    void metersToInchesConversionServiceProducesExpectedValue() throws Exception {
        ConversionService service = factory.getConverter(MeasurementType.METERS);
        String result = service.convert("123");
        assertThat(result).isEqualTo("3.124206248412497m");
    }

    @Test
    void inchesToMetersConversionServiceProducesExpectedValue() throws Exception {
        ConversionService service = factory.getConverter(MeasurementType.INCHES);
        String result = service.convert("123");
        assertThat(result).isEqualTo("4842.509999999999\"");
    }
}
