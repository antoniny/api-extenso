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
    public void testCerti() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"1").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"um\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"-1042").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"menos mil e quarenta e dois\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"94587").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"noventa e quatro mil e quinhentos e oitenta e sete\"}"));
    }

    @Test
    public void testGETNumeroNegativo() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"-1").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"menos um\"}"));
    }

    @Test
    public void testGETNumeroPositivo() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"377").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"trezentos e setenta e sete\"}"));
    }

    @Test
    public void testGETLimiteRange() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"99999").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"noventa e nove mil e novecentos e noventa e nove\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"-99999").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"menos noventa e nove mil e novecentos e noventa e nove\"}"));
    }

    @Test
    public void testGETIntervaloUnidade() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"0").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"zero\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"1").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"um\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"2").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"dois\"}"));
        //this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"3").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
         //       andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"três\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"4").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"quatro\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"5").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"cinco\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"6").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"seis\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"7").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"sete\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"8").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"oito\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"9").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"nove\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"10").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"dez\"}"));
    }

    @Test
    public void testGETIntervaloUnidadeDezena() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"11").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"onze\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"12").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"doze\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"13").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"treze\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"14").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"quatorze\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"15").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"quinze\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"16").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"dezesseis\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"17").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"dezessete\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"18").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"dezoito\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"19").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"dezenove\"}"));
    }

    @Test
    public void testGETIntervaloDezena() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"10").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"dez\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"20").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"vinte\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"30").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"trinta\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"40").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"quarenta\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"50").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"cinquenta\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"60").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"sessenta\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"70").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setenta\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"80").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"oitenta\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"90").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"noventa\"}"));

        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"51").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"cinquenta e um\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"52").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"cinquenta e dois\"}"));
        //this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"53").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                //andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"cinquenta e três\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"54").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"cinquenta e quatro\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"55").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"cinquenta e cinco\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"56").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"cinquenta e seis\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"57").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"cinquenta e sete\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"58").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"cinquenta e oito\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"59").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"cinquenta e nove\"}"));
    }

    @Test
    public void testGETIntervaloCentena() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"100").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"cem\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"200").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"duzentos\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"300").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"trezentos\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"400").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"quatrocentos\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"500").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"quinhentos\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"600").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"seiscentos\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"700").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"800").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"oitocentos\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"900").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"novecentos\"}"));

        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"701").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e um\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"702").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e dois\"}"));
        //this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"703").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                //andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e três\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"704").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e quatro\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"705").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e cinco\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"706").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e seis\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"707").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e sete\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"708").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e oito\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"709").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e nove\"}"));

        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"711").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e onze\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"712").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e doze\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"713").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e treze\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"714").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e quatorze\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"715").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e quinze\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"716").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e dezesseis\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"717").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e dezessete\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"718").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e dezoito\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"719").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e dezenove\"}"));

        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"721").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e vinte e um\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"732").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e trinta e dois\"}"));
        //this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"743").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                //andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e quarenta e três\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"754").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e cinquenta e quatro\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"765").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e sessenta e cinco\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"776").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e setenta e seis\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"787").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e oitenta e sete\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"798").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e noventa e oito\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"799").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setecentos e noventa e nove\"}"));
    }

    @Test
    public void testGETIntervaloMilhar() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"1000").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"mil\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"10000").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"dez mil\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"20000").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"vinte mil\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"30000").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"trinta mil\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"40000").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"quarenta mil\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"50000").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"cinquenta mil\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"60000").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"sessenta mil\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"70000").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setenta mil\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"80000").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"oitenta mil\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"90000").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"noventa mil\"}"));

        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"1701").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"mil e setecentos e um\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"2702").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"dois mil e setecentos e dois\"}"));
        //this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"3703").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                //andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"tr/s mil e setecentos e três\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"4704").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"quatro mil e setecentos e quatro\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"5705").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"cinco mil e setecentos e cinco\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"6706").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"seis mil e setecentos e seis\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"7707").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"sete mil e setecentos e sete\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"8708").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"oito mil e setecentos e oito\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"9709").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"nove mil e setecentos e nove\"}"));

        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"1711").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"mil e setecentos e onze\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"2712").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"dois mil e setecentos e doze\"}"));
        //this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"3713").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                //andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"três mil e setecentos e treze\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"4714").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"quatro mil e setecentos e quatorze\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"5715").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"cinco mil e setecentos e quinze\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"6716").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"seis mil e setecentos e dezesseis\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"7717").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"sete mil e setecentos e dezessete\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"8718").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"oito mil e setecentos e dezoito\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"9719").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"nove mil e setecentos e dezenove\"}"));

        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"10721").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"dez mil e setecentos e vinte e um\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"20732").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"vinte mil e setecentos e trinta e dois\"}"));
        //this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"30743").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                //andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"trinta mil e setecentos e quarenta e três\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"40754").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"quarenta mil e setecentos e cinquenta e quatro\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"50765").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"cinquenta mil e setecentos e sessenta e cinco\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"60776").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"sessenta mil e setecentos e setenta e seis\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"70787").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"setenta mil e setecentos e oitenta e sete\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"80798").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"oitenta mil e setecentos e noventa e oito\"}"));
        this.mockMvc.perform(MockMvcRequestBuilders.get(CLASS_PATH_API+"90799").header(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LOCALE_CODE)).
                andExpect(MockMvcResultMatchers.content().string("{\"extenso\":\"noventa mil e setecentos e noventa e nove\"}"));
    }




}
