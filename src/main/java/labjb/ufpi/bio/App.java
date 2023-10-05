package labjb.ufpi.bio;

import labjb.ufpi.bio.core.GeradorRNA;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GeradorRNA geradorRNA = new GeradorRNA();
        String entrada = "ACCAAACCGAGT";
        String saida   = geradorRNA.transcritarDNA(entrada);

        System.out.println(entrada);
        System.out.println(saida);
    }
}
