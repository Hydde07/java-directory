package Lista;

public class ListaArq{
    private NoArq inicio;
    private NoArq fim;

    public ListaArq(){
        inicio = null;
        fim = null;
    }
    
    public void insereNoFinal(String info){
        NoArq caixa = new NoArq(info);
        if(inicio == null)
        {
            inicio = fim = caixa;
        }
        else{
            fim.setProx(caixa);
            caixa.setAnt(fim);
            fim = caixa;
        }
    }
    
    public static void selectionSort(ListaArq L)
    {
        String aux;
        NoArq auxA = L.getInicio(),auxB;
        NoArq maior;
        while(auxA!= null && auxA.getProx() != null)
        {
            maior = auxA;
            auxB = auxA.getProx();
            while(auxB != null)
            {
                if(maior.getInfo().compareToIgnoreCase(auxB.getInfo()) < 0)
                {
                    maior = auxB;
                }
                auxB = auxB.getProx();
            }
            aux = maior.getInfo();
            maior.setInfo(auxA.getInfo());
            auxA.setInfo(aux);
            auxA = auxA.getProx();
        }
    }
    
    public NoArq getInicio() {
        return inicio;
    }

    public void setInicio(NoArq inicio) {
        this.inicio = inicio;
    }

    public NoArq getFim() {
        return fim;
    }

    public void setFim(NoArq fim) {
        this.fim = fim;
    }
    
    public void exibe(ListaArq a,int nivel){
        selectionSort(a);
        exibeLista(getInicio(),nivel);
    }
    
    private void exibeLista(NoArq no, int nivel){
        while(no!=null){
            for(int i = 0; i < nivel; i++)
                System.out.print("\t");
            System.out.println(no.getInfo());
            no = no.getProx();
        }
    }
}
