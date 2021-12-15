package trabalhopo;

import Lista.ListaDir;
import java.io.File;

public class TrabalhoPO {
     
    private static void criaLista(String diretorio, String nome, ListaDir lista){
        lista.insereNoFinal(nome);
        lista.insereAbaixoFinal(percorre(diretorio, lista));
    }
    
    private static ListaDir percorre(String diretorio, ListaDir sobe)
    {
        ListaDir L = new ListaDir();
        File pasta = new File(diretorio);
        File[] vet = pasta.listFiles();
        for (File vet1 : vet)
            if (vet1.isDirectory()) {
                L.insereNoFinal(vet1.getName());
                L.insereAbaixoFinal(percorre(vet1.getAbsolutePath(),L));
            } else if (vet1.isFile())
                L.insereArqFinal(sobe,vet1.getName());
        return L;
    }
    
    public static void main(String[] args) {
        ListaDir lista = new ListaDir();
        //Inserir aqui o diretório que quer que seja representado em forma de árvore
        criaLista("D:\\ExcluirApos05.12","ExcluirApos05.12",lista);
        lista.exibe();
    }
    
}
