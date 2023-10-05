package labjb.ufpi.bio;

import labjb.ufpi.bio.core.GeradorRNA;
import labjb.ufpi.bio.core.exceptions.EntradaInvalidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AppTest {
    private GeradorRNA geradorRNA;

    public AppTest(){
        this.geradorRNA = new GeradorRNA();
    }

    @Test
    public void testTranscricaoDNAValido()
    {
        String entrada = "ACCAAACCGAGT";
        String esperado = "UGGUUUGGCUCA";
        String RNAGerado = geradorRNA.transcritarDNA(entrada);

        Assertions.assertEquals(esperado, RNAGerado);
    }

    @Test
    public void testTranscricaoDNAInvalido()
    {
        String entrada = "ACCAAAC?CGAGT";
        String esperado = "Nucleotídeo inválido ?";
        RuntimeException exception = Assertions.assertThrows(EntradaInvalidaException.class, () -> geradorRNA.transcritarDNA(entrada));

        Assertions.assertEquals(esperado, exception.getMessage());
    }

    @Test
    public void testTranscricaoDNASListaValido()
    {
        String entrada = "ACCAAACCGAGT";
        String esperado = "UGGUUUGGCUCA";
        int quantidadeDeRNAS = 1;
        List<String> dnas = List.of(entrada);
        List<Map.Entry<String, String>> rnas = geradorRNA.transcritarDNA(dnas);
        Assertions.assertEquals(quantidadeDeRNAS, rnas.size());
        Map.Entry trascricao = rnas.get(0);

        Assertions.assertEquals(entrada, trascricao.getKey());
        Assertions.assertEquals(esperado, trascricao.getValue());
    }

    @Test
    public void testTranscricaoDNASListaComDNAInValido()
    {
        String entradaValida = "ACCAAACCGAGT";
        String entradaInvalida = "ACC.AAA.CCG.AGT!";
        String esperado = "Nucleotídeo inválido !";
        int quantidadeDeRNAS = 1;

        List<String> dnas = List.of(entradaValida, entradaInvalida);

        RuntimeException exception = Assertions.assertThrows(EntradaInvalidaException.class, () -> geradorRNA.transcritarDNA(dnas));
        Assertions.assertEquals(esperado,exception.getMessage());

    }

    @Test
    public void testTranscricaoDNASListaSemDNA()
    {
        String esperado = "A lista de fitas de DNA devém ser passados e não podem ser vazias.";

        List<String> dnas = new ArrayList<>();

        RuntimeException exception = Assertions.assertThrows(EntradaInvalidaException.class, () -> geradorRNA.transcritarDNA(dnas));
        Assertions.assertEquals(esperado,exception.getMessage());

    }
}
