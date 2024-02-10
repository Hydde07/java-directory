package Lista;

import java.io.File;

public class ListaDir {
    private NoDir inicio;
    private NoDir fim;


    public void insereNoFinal(String info){
        NoDir caixa = new NoDir(info);
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
    
    public static void shellSort(ListaDir L){
        int dist = (L.length()/3)+1;
        NoDir no, aux, back, aux2;
        aux2 = new NoDir();
        for(int i = dist; i>0; i/=2)
        {
            for(int j = 0; j <= i; j++)
            {
                no = L.seek(j);
                aux = L.seek(no, i);
                while(aux!=null)
                {
                    if(no.getInfo().compareToIgnoreCase(aux.getInfo())<0)
                    {
                        aux2.copyContent(no);
                        no.copyContent(aux);
                        aux.copyContent(aux2);
                        
                        back = L.seek(no, -i);
                        while(back!=null && back.getInfo().compareToIgnoreCase(no.getInfo())<0)
                        {
                            aux2.copyContent(no);
                            no.copyContent(back);
                            back.copyContent(aux2);
                            
                            no = back;
                            back = L.seek(no, -i);
                        }
                    }
                    no = aux;
                    aux = L.seek(aux, i);
                }
            }
        }
    }
    
    public void insereArqFinal(ListaDir dir, String nomeArq){
        NoDir no = dir.getFim();
        no.getArq().insereNoFinal(nomeArq);
    }
    
    public void insereAbaixoFinal(ListaDir caixa){
        NoDir n = getFim();
        n.setBaixo(caixa);
    }
    
    public NoDir seek(int n){
        NoDir aux = inicio;
        for(int i = 0; aux!= null && i < n; i++)
            aux=aux.getProx();
        return aux;
    }
    
    public NoDir seek(NoDir aux, int n){
        if(n>0)
            for(int i = 0; aux!= null && i < n; i++)
                aux=aux.getProx();
        else
            for(int i = 0; aux!= null && i > n; i--)
                aux=aux.getAnt();
        return aux;
    }
    
    public int length(){
        int cont = 0;
        NoDir no = inicio;
        while(no!=null)
        {
            cont++;
            no=no.getProx();
        }
        return cont;
    }
   
    public NoDir getInicio() {
        return inicio;
    }

    public void setInicio(NoDir inicio) {
        this.inicio = inicio;
    }

    public NoDir getFim() {
        return fim;
    }

    public void setFim(NoDir fim) {
        this.fim = fim;
    }
    
    public void exibe(){
        exibeLista(getInicio(),0);
    }
    
    private void exibeLista(NoDir no, int nivel){
        while(no!=null){
            for(int i = 0; i < nivel; i++)
                System.out.print("\t");
            System.out.println("+ "+no.getInfo());
            no.getArq().exibe(no.getArq(),nivel+1);
            shellSort(no.getBaixo());
            no.getBaixo().exibeLista(no.getBaixo().getInicio(), nivel+1);
            System.out.println("");
            no = no.getProx();
        }
    }
}
