# UFPI-Bioinformatica-Transcrição-DNA
## Járdesson Ribeiro

### Como usar ?
 - Execute a classe App
   - Abrirá um "menu" mostrando as opções de input
     ```
          Entre com um DNA
          Exemplo: ACCAAACCGAGT ou ACC.AAA.CCG.AGT  ou use DNA separador por ';' como ACCAAACCGAGT;GGTAAACCGAGT;TTG.AAA.ACC.GAGT
          Ou use 'exit' para sair.
     ```
   - Em seguisa insira o input de DNA. Exemplo
     - ```
       Entrada
       $ ACC.AAA.CCG.AGT
       saida 
       $ DNA: ACC.AAA.CCG.AGT
       $ DNA: UGG.UUU.GGC.UCA
       ```
   - Ou entre com varios DNAS separados por ';'. Exemplo
     ```
     Entrada
     $ ACCAAACCGAGT;GGTAAACCGAGT;TTGAAAACCGAGT
     Saida
     $ DNA: ACCAAACCGAGT
     $ RNA: UGGUUUGGCUCA
     $ DNA: GGTAAACCGAGT
     $ RNA: CCAUUUGGCUCA
     $ DNA: TTGAAAACCGAGT
     $ RNA: AACUUUUGGCUCA
     ```
   - Sair da execução do programa
     ```
       Digite
       $ exit
       Saindo ...

       Process finished with exit code 0   
       ```