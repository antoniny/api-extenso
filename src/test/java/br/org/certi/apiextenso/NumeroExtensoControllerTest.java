package br.org.certi.apiextenso;

import br.org.certi.apiextenso.resource.NumeroExtensoController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class NumeroExtensoControllerTest extends ApiExtensoApplicationTests {

    private MockMvc mockMvc;
    private static final String CLASS_PATH_API = "/extenso/v1/";
    private static final String DEFAULT_LOCALE_CODE = "pt";

    @Autowired
    private NumeroExtensoController numeroExtensoController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(numeroExtensoController).build();
    }

    @Test
    public void testGETIndexNumeroExtensoController() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"0").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    ;
    }

    @Test
    public void testGETNegativeNumeroExtensoController() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"-1").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"menos um\"}"));
    }

    @Test
    public void testGETPositiveNumeroExtensoController() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"377").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"trezentos e setenta e sete\"}"));
    }

    @Test
    public void testGETPositiveLimitNumeroExtensoController() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"99999").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"noventa e nove mil novecentos e noventa e nove\"}"));

      //  this.mockMvc.perform(MockMvcRequestBuilders.get("/100000")).
       //         andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    public void testGETNegativeLimitNumeroExtensoController() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"-99999").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"menos noventa e nove mil novecentos e noventa e nove\"}"));
    }




}
