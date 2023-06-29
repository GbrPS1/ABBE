// Ledón, 2016/2019.

package testa_abb;

class No <E extends Comparable<E>> {  // Nodo, nó ou elemento da árvore

    private E valor;
    private No esq;
    private No dir;
    
    public String toString () {
        return valor.toString();
    }
        
    public No(E valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
    }

    public E getValor() {
        return valor;
    }

    public void setValor(E valor) {
        this.valor = valor;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }
    
}