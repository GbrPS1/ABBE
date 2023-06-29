// Classe ABBE para demonstrar a inserção e o atravessamento em-ordem 
// em uma Árvore Binária de Busca (ABBE)
// Ledón, 2016-2020.

package testa_abb;

public class Testa_ABB {

    public static void main(String[] args) {
        
/*
Seja uma árvore de busca binária, inicialmente vazia. 
Esquematize o seu percurso em nível, após terem sido 
inseridos os elementos 4, 1, 0, 5, 3, 7, 2, 6, 9, 
removido os elementos 5 e 3 e inseridos os elementos 
10, 21 e –5 nesta ordem. A árvore resultante após as 
operações é cheia   Por quê 
*/        
   ABBE abb0 = new ABBE();
   abb0.insert(4); abb0.insert(1); abb0.insert(0);
   abb0.insert(5); abb0.insert(3); abb0.insert(7);     
   abb0.insert(2); abb0.insert(6); abb0.insert(9);        
   abb0.eliminar(5); abb0.eliminar(3);
   abb0.insert(10); abb0.insert(21); abb0.insert(-5);  
   System.out.print("Nível: ");
   abb0.emNivel();
   System.out.println("\n");
   
        
 /*
   Seja uma árvore de busca binária, inicialmente vazia. 
   Esquematize o seu percurso em pré ordem, pós ordem e 
   em ordem simétrica, após terem sido inseridos os 
   elementos 10, 5, 20, -6, 7, 21, 11, 26, 31, 43, 56, 0, 9, 
   removido os elementos 20, 10 e 7,  e inseridos os 
   elementos 15, 18 e –5 nesta ordem. A árvore resultante 
   após as operações é cheia   Por quê     
*/       
   ABBE abb1 = new ABBE();
   abb1.insert(10); abb1.insert(5); abb1.insert(20);
   abb1.insert(-6); abb1.insert(7); abb1.insert(21);     
   abb1.insert(11); abb1.insert(26); abb1.insert(31);        
   abb1.insert(43); abb1.insert(56); abb1.insert(0); 
   abb1.insert(9); 
   abb1.eliminar(20); abb1.eliminar(10);abb1.eliminar(7);
   abb1.insert(15); abb1.insert(18); abb1.insert(-5);  
   System.out.print("Pré-ordem: ");
   abb1.preOrdem();
   System.out.println("\n");   
   System.out.print("Pos-ordem: ");
   abb1.posOrdem();
   System.out.println("\n");   
   System.out.print("Simétrica: ");
   abb1.emOrdem();
   System.out.println("\n");  
 
 /*
 Implemente um ou mais 
 métodos que permita percorrer uma árvore binária que 
 guarda objetos da classe Aluno e que calcule a média 
 das notas das mulheres da turma. Sugestão: adapte um 
 dos percursos para realizar o solicitado.
 */

   System.out.println("Agora vamos criar uma ABB (e percorrer em-ordem pelos RGMs) de objetos da classe Aluno:");
   ABBE abb3 = new ABBE();
   
   abb3.insert(new Aluno("8331-9", "Ana", 'F', 9.5f));
   abb3.insert(new Aluno("9354-9", "Fabiana", 'F', 9.0f));
   abb3.insert(new Aluno("1001-9", "Marcos", 'M', 5.5f));  
   abb3.insert(new Aluno("5301-9", "Maria", 'F', 8.5f));
   abb3.insert(new Aluno("3138-9", "Jony", 'M', 8.5f));
   System.out.println("Média Notas Mulheres: " +
           abb3.mediaNotasMulheres());
    
    }
}
