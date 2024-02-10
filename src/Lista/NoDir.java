package Lista;

public class NoDir {
    private NoDir ant, prox;
    private ListaArq arq;
    private ListaDir baixo;
    private String info;

    public NoDir(String info)
    {
        this.info = info;
        ant = prox = null;
        baixo = new ListaDir();
        arq = new ListaArq();
    }
    
    public NoDir()
    {
        ant = prox = null;
        baixo = new ListaDir();
        arq = new ListaArq();
        info = "";
    }
    
    public NoDir getAnt() {
        return ant;
    }

    public void setAnt(NoDir ant) {
        this.ant = ant;
    }

    public NoDir getProx() {
        return prox;
    }

    public void setProx(NoDir prox) {
        this.prox = prox;
    }

    public ListaArq getArq() {
        return arq;
    }

    public void setArq(ListaArq arq) {
        this.arq = arq;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ListaDir getBaixo() {
        return baixo;
    }

    public void setBaixo(ListaDir baixo) {
        this.baixo = baixo;
    }
    
    public void copyContent(NoDir no){
        this.arq = no.getArq();
        this.baixo = no.getBaixo();
        this.info = no.getInfo();
    }
    
}
