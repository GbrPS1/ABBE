// Classe ABBE para demonstrar a inserção e o atravessamento em-ordem 
// em uma Árvore Binária de Busca (ABBE)
// Ledón, 2016-2020.

package testa_abb;

import java.util.LinkedList;

class ABBE <E extends Comparable<E>> {  // Árvore Binária de Busca 

    private No raiz;

    public ABBE() {
        raiz = null; // a ABBE criada estará inicialmente vazia
    }
    
    public void setRaiz (No raiz) {
        this.raiz = raiz;
    }   
    
    public No getRaiz() {
        return raiz;
    }


    public boolean isEmpty() {
        return (raiz == null);
    }
    
    
    public void emOrdem() {
        emOrdem(raiz);
    }

    public void emOrdem(No raiz) { // mostra os objetos separados por espaços
        if (raiz != null) {
            emOrdem(raiz.getEsq());
            System.out.print(raiz.getValor() + " ");
            emOrdem(raiz.getDir());
        }
    }   
    
    
    // Exercício: Média mulheres
    private float mediaM = 0;
    private int totalM = 0;
    
    public float mediaNotasMulheres(){
        emOrdemMulheres(raiz);
        if (totalM == 0) totalM++;
        return mediaM/totalM;
    }
    
    private void emOrdemMulheres(No raiz){
        if (raiz != null){
            emOrdemMulheres(raiz.getEsq());
            Aluno a = (Aluno) raiz.getValor();
            if (a.getSexo() == 'F') {
                mediaM += a.getMedia();
                totalM++;
            }
            emOrdemMulheres(raiz.getDir());
        }
    }
    
    
    public void preOrdem() {
        preOrdem(raiz);
    }
    
    public void preOrdem( No raiz ){
        if (raiz != null){
            System.out.print( raiz.getValor() + " ");
            preOrdem( raiz.getEsq() );
            preOrdem( raiz.getDir() );
        }
    }
    
        
    public void posOrdem() {
        posOrdem(raiz);
    }
    
    public void posOrdem( No raiz ){
        if (raiz != null){
            posOrdem( raiz.getEsq() );
            posOrdem( raiz.getDir() );
            System.out.print( raiz.getValor()+" " );
        }
    }

    public void emNivel(){
        No noAux;
        ArrayQueue f;
        if (raiz != null){
            f = new ArrayQueue(); 
            f.enQueue( raiz );
            while( !f.qIsEmpty() ){
                noAux = (No) f.deQueue ();
                if (noAux.getEsq() != null)
                    f.enQueue( noAux.getEsq() );
                if (noAux.getDir() != null) 
                    f.enQueue( noAux.getDir() );
                System.out.print( noAux.getValor()+" " );
            } 
        } 
    }
    
    // Busca um objeto na árvore e retorna o nó onde encontrou ou retorna null 
    private No searchABB (No no, Object obj) {
        // Se no é nulo (árvore vazia) ou chegou em uma folha 
        // => não achou o objeto procurado
        if (no == null) return null;
        else {
            // Se achou o elemento, retornar o nó:
            if( ((Comparable)obj).compareTo(no.getValor()) == 0 ) return no;
            else {   
                  // Se não achou, buscar recursivamente para 
                  // a esquerda ou para a direita:
 		  if( ((Comparable)obj).compareTo(no.getValor()) < 0 )
                      return searchABB(no.getEsq(), obj);
                  else
                      return searchABB(no.getDir(), obj);
            }
        }
    }  
    
    // procura obj a partir do nó raiz
    public No searchABB (Object obj) {
        return searchABB(raiz, obj);
    }
    
    //Determina o menor elemento a partir de um nó
    public No getMenor (No no) {
       if ( isEmpty() || no==null ) return null;
       if ( no.getEsq() == null ) return no;
       else return getMenor (no.getEsq());
    } 

    //Determina o maior elemento a partir de um nó
    public No getMaior (No no) {
       if ( isEmpty() || no==null ) return null;
       if ( no.getDir() == null ) return no;
       else return getMaior (no.getDir());
    } 

    // método inicial com um parâmetro:  objeto a inserir
    public E insert (E valor) {    
        try {
            No novo = new No(valor);       	// alocamos memória para o novo nó
            this.insert(novo, raiz);   		// chamamos o método recursivo, 
					// que tem dois parâmetros
        }
        catch (Exception exMemoria) { return null; }  // memória insuficiente
        return (valor);  // retorna o objeto inserido
    }  
  

    /*
      Os métodos 'insert' utiliza o método 'compareTo', que deverá existir na classe de objetos a inserir na ABBE.
      O método 'compareTo' da interface Comparable (implementado nas classes Double, Integer, String etc.) lançará 
      uma exception se são comparados objetos de tipos diferentes.
      Consequentemente, este método 'inserir' só conseguirá adicionar novos nodos que guardem objetos do mesmo tipo
      que o objeto inicial guardado na ABBE, ou seja, a ABBE guardará objetos do mesmo tipo.
    */    
     private No insert (No novo, No anterior) {  // método recursivo
        if (raiz == null) {   // se a árvore estiver vazia   -   ou  if ( isEmpty() )
            raiz = novo;
            return raiz;
        }
        if (anterior != null) {
            if (novo.getValor().compareTo(anterior.getValor()) < 0)
                anterior.setEsq(insert(novo, anterior.getEsq()));
                else anterior.setDir(insert(novo, anterior.getDir()));
        }
        else {  // se o anterior era nulo:
            anterior = novo;  // fim recursivo
        }        
        return anterior; 
    }

     
    //Determina o maior elemento a partir de um nó 'raiz' (e enlaça seu pai para eliminar 
    // esse nodo 'raiz' desta posição). Retorna o nodo com maior valor desta subárvore.
    public No getMax(No raiz, No paiRaiz) {
        if (isEmpty()) {
            return null;
        }
        No aux;
        //Se não tiver mais filho direito
        if (raiz.getDir() == null) { //encontrou o maior
            aux = raiz;
            //Se tiver um pai, ele assume o filho esquerdo (nunca terá filho direito)
            if (paiRaiz != null) {
                if (paiRaiz.getEsq() == raiz) { //se 'raiz' era filho esquerdo do pai
                    paiRaiz.setEsq(raiz.getEsq());
                } else {  //se 'raiz' era filho direito do pai
                    paiRaiz.setDir(raiz.getEsq());
                }
            }
            return aux;
        } else {
            return getMax(raiz.getDir(), raiz);       
        }    
    }
    
    // Eliminar o objeto e da ABBE
    public boolean eliminar (Object e) {   
       return eliminar(raiz, null, e);   // começamos procurando pela raiz
    }

     //Remove o nó que guarda o objeto e da árvore, retornando true ou false
    private boolean eliminar (No node, No paiRaiz, Object e) {
        No aux;
        if ( node == null ) {   
	// não achou o elemento, não existe (chegou na folha) ou árvore vazia
               return false;
        } else {   // a árvore (ou sub-árvore) não está vazia, vamos procurar e
            if (compara(e, node.getValor()) == 0) {  // o nó a eliminar está em node
                //Caso A:  o nó a ser eliminado não possui filhos, basta eliminar o nó:
                if (node.getEsq() == null && node.getDir() == null) {  //sem filhos
                    //se não tiver pai, é a raiz da árvore
                    if (paiRaiz == null) { 
                        setRaiz(null);
                    } //senão, o pai deve "deserdar" o filho (colocar null no enlace do filho eliminado)
                    else {
                        //verifica se o nó que será eliminado é o filho esquerdo ou direito  do pai:
                        if (paiRaiz.getEsq() != null && 
                                compara(paiRaiz.getEsq().getValor(), e) == 0) {
                                paiRaiz.setEsq(null);
                        } else if (paiRaiz.getDir() != null && 
                                compara(paiRaiz.getDir().getValor(), e) == 0) {
                                paiRaiz.setDir(null);
                        }
                    }                
                } 
                //Caso B1:  o nó a ser eliminado tem apenas um filho (esquerdo)
                else if (node.getDir() == null) {   // se só tiver o filho esquerdo
                    //se tiver um pai, ele assume o filho esquerdo
                    if (paiRaiz != null) {
                        //verifica se a raiz é filho esquerdo ou direito para assumir o neto
                        if (paiRaiz.getEsq() != null && compara(paiRaiz.getEsq().getValor(), e) == 0) {
                            paiRaiz.setEsq(node.getEsq());
                        } else {
                            paiRaiz.setDir(node.getEsq());
                        }
                    } //se não tiver pai (caso da raiz), adotar seu filho esquerdo
                    else {   // pegar valor do filho esquerdo e apontar para os netos:
                        node.setValor(node.getEsq().getValor());                                  
                        node.setEsq(node.getEsq().getEsq());
                        node.setDir(node.getEsq().getDir());
                    }
                } 
                //Caso B2:  o nó a ser eliminado tem apenas um filho (direito)
                else if (node.getEsq() == null) {   // se só tiver o filho direito
                    //se tiver um pai, ele assume o filho esquerdo
                    if (paiRaiz != null) {
                        //verifica se a raiz é filho esquerdo ou direito para assumir o neto
                        if (paiRaiz.getEsq() != null && 
		            compara(paiRaiz.getEsq().getValor(), e) == 0) {
                            paiRaiz.setEsq(node.getDir());
                        } else {
                            paiRaiz.setDir(node.getDir());
                        }
                    } //se não tiver pai (caso da raiz), adotar seu filho direito
                    else {// pegar valor do filho direito e apontar para os netos:
                        node.setValor(node.getDir().getValor());
                        node.setEsq(node.getDir().getEsq());
                        node.setDir(node.getDir().getDir());
                    }
                }         
            //Caso C:  o nó a ser eliminado tem os dois filhos
            else {   // se a raiz possui os 2 filhos
                // usaremos sempre o maior da sub-árvore esquerda:
                aux = getMax(node.getEsq(), node);
                node.setValor(aux.getValor());
            }
            return true;
        } 
        else {  //Se não achou o nó a eliminar na raiz, continuemos procurando recursivamente
                //Se for menor que a raiz, continuar procurando à esquerda:
                if (compara(e, node.getValor()) < 0) {
                    return eliminar(node.getEsq(), node, e);  // chamada recursiva
                } else { // senão, procurar à direita
                    return eliminar(node.getDir(), node, e);   // chamada recursiva
                }
            }
        }
    }  
        
    private int compara (Object ob1, Object ob2) {
        return ((Comparable)ob1).compareTo(((Comparable)ob2));
    }

}
