package labjb.ufpi.bio.core;

import labjb.ufpi.bio.core.exceptions.EntradaInvalidaException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GeradorRNA {

    public String transcritarDNA(String dna){
        if(Objects.isNull(dna) || dna.isEmpty()){
            throw new EntradaInvalidaException("DNA não válido");
        }

        StringBuilder RNABuilder = new StringBuilder();
        for (int i = 0; i < dna.length(); i++) {
            RNABuilder.append(matcher(dna.charAt(i)));
        }

        return RNABuilder.toString();
    }

    public List<Map.Entry<String, String>> transcritarDNA(List<String> dnas){
        if(Objects.isNull(dnas) || dnas.isEmpty()){
            throw new EntradaInvalidaException("A lista de fitas de DNA devém ser passados e não podem ser vazias.");
        }

        List<Map.Entry<String, String>> rnas = new ArrayList<>();
        for (var dna : dnas){
            String rna = transcritarDNA(dna);
            rnas.add(Map.entry(dna, rna));
        }

        return rnas;
    }

    private char matcher(char nucleotideo){
        switch (nucleotideo){
            case 'A':
                return 'U';
            case 'C':
                return 'G';
            case 'G':
                return 'C';
            case 'T':
                return 'A';
            case '.':
                return '.';
            default:
                throw new EntradaInvalidaException("Nucleotídeo inválido "+nucleotideo);
        }
    }

}
