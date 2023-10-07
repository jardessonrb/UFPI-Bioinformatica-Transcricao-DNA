package labjb.ufpi.bio;

import labjb.ufpi.bio.core.GeradorRNA;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private List<String> split(String DNAS){
        DNAS = DNAS.replace(" ", "");
        String valores[] = DNAS.split(";");
        return Arrays.asList(valores);
    }
    public static void main( String[] args )
    {
        App aplicacao = new App();
        GeradorRNA geradorRNA = new GeradorRNA();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("Entre com um DNA");
        System.out.println("Exemplo: ACCAAACCGAGT ou ACC.AAA.CCG.AGT  ou use DNA separador por ';' como ACCAAACCGAGT;GGTAAACCGAGT;TTG.AAA.ACC.GAGT");
        System.out.println("Ou use 'exit' para sair.");
        System.out.println("--------------------------------------");
        while(true){
            System.out.println("Digite uma fita de DNA(ou 'exit' para sair): ");
            String input = scanner.nextLine();
            if(input.equals("exit")) {
                System.out.println("Saindo ...");
                break;
            }
            if(input.contains(";")){
                List<String> dnas = aplicacao.split(input);
                List<Map.Entry<String, String>> rnas = geradorRNA.transcritarDNA(dnas);
                rnas.forEach(valor -> {
                    System.out.println("DNA: "+valor.getKey());
                    System.out.println("RNA: "+valor.getValue());
                });
            }else {
                String rna = geradorRNA.transcritarDNA(input);
                System.out.println("DNA: "+input);
                System.out.println("DNA: "+rna);
            }
        }
    }
}
