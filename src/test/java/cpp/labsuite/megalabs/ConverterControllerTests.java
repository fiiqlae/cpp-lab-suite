package cpp.labsuite.megalabs;

import com.fasterxml.jackson.databind.ObjectMapper;
import cpp.labsuite.megalabs.external.models.ConvertResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ConverterControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void indexEndpointAvailable() throws Exception {
        mockMvc.perform(get("/converter")).andExpect(status().isOk());
    }

    @Test
    void conversionEndpointAvailableAndMetersToInchesConversionReturnsExpectedValue() throws Exception {
        MvcResult result =  mockMvc.perform(get("/converter/convert?targetSystem=in&requestValue=123"))
                .andReturn();
        ConvertResponse response =  objectMapper.readValue(result.getResponse().getContentAsString(),
                ConvertResponse.class);
        assertThat(response.isSuccess()).isEqualTo(true);
        assertThat(response.getResult()).isEqualTo("4842.509999999999\"");
    }

    @Test
    void conversionEndpointAvailableAndInchesToMetersConversionReturnsExpectedValue() throws Exception {
        MvcResult result =  mockMvc.perform(get("/converter/convert?targetSystem=m&requestValue=123"))
                .andReturn();
        ConvertResponse response =  objectMapper.readValue(result.getResponse().getContentAsString(),
                ConvertResponse.class);
        assertThat(response.isSuccess()).isEqualTo(true);
        assertThat(response.getResult()).isEqualTo("3.124206248412497m");
    }

}
