package Lista;

public class NoArq {
    private NoArq ant, prox;
    private String info;

    public NoArq(String info)
    {
        ant = prox = null;
        this.info = info;
    }
    public NoArq getAnt() {
        return ant;
    }

    public void setAnt(NoArq ant) {
        this.ant = ant;
    }

    public NoArq getProx() {
        return prox;
    }

    public void setProx(NoArq prox) {
        this.prox = prox;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    
}
