package arvore;

/**
 * Classe do objeto nó árvore - A classe NoArvore utiliza o Comparable para
 * realizar a comparação entre o valor a ser inserido e o valor do nó da raiz ou
 * do nó pai, dessa forma ela pode criar o novo nó e inserir o valor.
 *
 * @author Turma 315-6
 * @version 2.2
 * @param <T> Referente ao Generics
 */
public class NoArvore<T extends Comparable<T>> {

    /**
     * Atributos da classe
     */
    T data;
    NoArvore<T> noEsquerdo;
    NoArvore<T> noDireito;

    /**
     * Construtor da classe - Inicializa os dados
     *
     * @param noData Variável que armazena o valor do novo nó
     */
    public NoArvore(T noData) {
        data = noData;
        noEsquerdo = noDireito = null;
    }

    /**
     * Método para inserção de um valor na árvore
     *
     * @param insereValor Variável que armazena o valor a ser inserido no novo
     * nó da árvore
     */
    public void insere(T insereValor) {
        // Se o valor passado for menor que o valor da raiz ou do nó pai
        // Então o valor é inserido na subárvore esquerda
        if (insereValor.compareTo(data) < 0) {
            // Se o nó esquerdo está vazio, 
            // Então um novo nó com o valor é criado
            if (noEsquerdo == null) {
                noEsquerdo = new NoArvore<T>(insereValor);
            } // Continua percorrendo a subárvore recursivamente
            else {
                noEsquerdo.insere(insereValor);
            }
        } // Se o valor passado for maior que o valor da raiz ou do nó pai
        // Então o valor é inserido na subárvore direita
        else if (insereValor.compareTo(data) > 0) {
            // Se o nó direito está vazio, 
            // Então um novo nó com o valor é criado
            if (noDireito == null) {
                noDireito = new NoArvore<T>(insereValor);
            } // Continua percorrendo a subárvore recursivamente 
            else {
                noDireito.insere(insereValor);
            }
        }
    }

}
