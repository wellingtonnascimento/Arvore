package arvore;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import javax.swing.JPanel;

/**
 * Classe do objeto árvore binária - A classe ArvBinaria cria a árvore binária
 * definindo a raiz da árvore, chama a função para inserção e remove valores na
 * árvore, além de percorrer a árvore em pré-ordem, ordem e pós-ordem. Ela
 * também desenha a árvore gráfica.
 *
 * @author Turma 316-5
 * @version 2.2
 * @param <T> Referente ao Genereics
 */
public class ArvBinaria<T extends Comparable<T>> {

    /**
     * Atributo para a raiz da árvore binária
     */
    public NoArvore<T> root;

    String listaOrdem = "";
    String listaPreOrdem = "";
    String listaPosOrdem = "";

    /**
     * Construtor da classe - Inicializa uma árvore de inteiros vazia
     */
    public ArvBinaria() {
        root = null;
    }

    /**
     * Método para limpar as Strings com os valores contidos na árvore nas ordem
     * em que são percorridas
     */
    public void limparStrings() {
        listaOrdem = "";
        listaPosOrdem = "";
        listaPreOrdem = "";
    }

    /**
     * Método para inserir um nó na árvore
     *
     * @param insereValor Variável que armazena o valor a ser inserido na árvore
     */
    public void insereNo(T insereValor) {
        // Se a raiz do nó está vazia, então o valor a ser inserido é inserido
        // na raiz
        if (root == null) {
            root = new NoArvore<T>(insereValor);
        } // Se a raiz já estiver preenchida o valor e inserido por meio da
        // verificação se ele é maior ou menor que o seu valor anterior por meio
        // da recursividade
        else {
            root.insere(insereValor);
        }
    }

    /**
     * Método que chama o outro método que percorre a árvore em pré-ordem
     *
     * @return String - chama o método preOrdemAjudante para que seja retornado
     * a String com os elementos da árvore na pré-ordem
     */
    public String preOrdem() {
        return preOrdemAjudante(root);
    }

    /**
     * Método que percorre a árvore em pré-ordem
     *
     * @param no Variável referente ao nó da árvore que está sendo percorrida
     * @return String - Para que a recursão seja interrompida e retornar a
     * String listaPreOrdem com os valores na pré-ordem que estão contidos na
     * árvore
     */
    private String preOrdemAjudante(NoArvore<T> no) {
        // Verifica se o nó está vazio, então para de percorrer a árvore
        // recursivamente
        if (no == null) {
            return listaPreOrdem;
        }

        // Atribuir a String os valores contidos da árvore na forma pré-ordem de
        // percorrer a árvore
        listaPreOrdem += no.data.toString() + " ";

        // Imprimi os valores da árvore
        System.out.printf("%s ", no.data);
        preOrdemAjudante(no.noEsquerdo);
        preOrdemAjudante(no.noDireito);

        return listaPreOrdem;
    }

    /**
     * Método que chama o outro método que percorre a árvore em ordem
     *
     * @return String - chama o método ordemAjudante para que seja retornado a
     * String com os elementos da árvore na ordem
     */
    public String Ordem() {
        return ordemAjudante(root);
    }

    /**
     * Método que percorre a árvore em ordem
     *
     * @param no Variável referente ao nó da árvore que está sendo percorrida
     * @return String - Para que a recursão seja interrompida e retornar a
     * String listaOrdem com os valores em ordem que estão contidos na árvore
     */
    private String ordemAjudante(NoArvore<T> no) {
        // Verifica se o nó está vazio, então para de percorrer a árvore
        // recursivamente
        if (no == null) {
            return listaOrdem;
        }

        ordemAjudante(no.noEsquerdo);

        // Atribuir a String os valores contidos da árvore na forma pré-ordem de
        // percorrer a árvore
        listaOrdem += no.data.toString() + " ";

        // Imprimi os valores da árvore
        System.out.printf("%s ", no.data);
        ordemAjudante(no.noDireito);

        return listaOrdem;
    }

    /**
     * Método que chama o outro método que percorre a árvore em pós-ordem
     *
     * @return String - chama o método posOrdemAjudante para que seja retornado
     * a String com os elementos da árvore na pós-ordem
     */
    public String posOrdem() {
        return posOrdemAjudante(root);
    }

    /**
     * Método que percorre a árvore em ordem
     *
     * @param no Variável referente ao nó da árvore que está sendo percorrida
     * @return String - Para que a recursão seja interrompida e retornar a
     * String listaPosOrdem com os valores na pós-ordem que estão contidos na
     * árvore
     */
    private String posOrdemAjudante(NoArvore<T> no) {
        // Verifica se o nó está vazio, então para de percorrer a árvore
        // recursivamente
        if (no == null) {
            return listaPosOrdem;
        }

        posOrdemAjudante(no.noEsquerdo);
        posOrdemAjudante(no.noDireito);

        // Atribuir a String os valores contidos da árvore na forma pré-ordem de
        // percorrer a árvore
        listaPosOrdem += no.data.toString() + " ";

        // Imprimi os valores da árvore 
        System.out.printf("%s ", no.data);

        return listaPosOrdem;
    }

    /**
     * Método que remove um nó da árvore
     *
     * @param valor Variável que armazena o valor a ser removido da árvore
     * @return boolean - Retorna true caso o valor foi removido da árvore e
     * false caso não tenha sido removido
     */
    public boolean removerNo(T valor) {
        // Verifica se a raiz da árvore está vazia, ou seja ela não existe
        if (root == null) {
            return false;
        }

        // Cria um objeto representando o nó atual
        NoArvore<T> atual = root;
        // Cria um objeto representando o anscestral
        NoArvore<T> pai = root;
        // Variável para saber o lado onde está o nó a ser removido
        boolean estaNaEsquerda = true;

        // Laço para buscar o nó a ser removido da árvore
        while (atual.data.compareTo(valor) != 0) {
            // Variável que recebe o nó atual
            pai = atual;

            // Caso o nó a ser removiso está no lado esquerdo
            if (atual.data.compareTo(valor) == 1) {
                // Informa que está a esquerda true
                estaNaEsquerda = true;
                atual = atual.noEsquerdo;
            } // Caso o nó a ser removido está no lado direito
            else {
                // Informa que está a direita false
                estaNaEsquerda = false;
                atual = atual.noDireito;
            }

            //Se o nó não a ser removido não foi encontrado
            if (atual == null) {
                // Informa false, porque não encontrou o valor
                return false;
            }
        }

        // Se o nó a ser removido NÃO possui filhos
        if (atual.noEsquerdo == null && atual.noDireito == null) {
            // Se o nó for igual a raiz
            if (atual == root) {
                // A raiz fica vazia então a árvore fica vazia
                root = null;
            } // Se o nó a ser removido estiver no lado esquerdo
            else if (estaNaEsquerda) {
                // Então o valor nulo é atribuido ao nó do lado esquerdo
                pai.noEsquerdo = null;
            } // Se o nó a ser removido estiver no lado direito
            else {
                // Então o valor nulo é atribuido do lado direito
                pai.noDireito = null;
            }
        } // Se o nó a ser removido só possui um filho que fica no lado esquerdo
        else if (atual.noDireito == null) {
            // Se o nó atual for igual a raiz
            if (atual == root) {
                // O nó do filho a esquerda parssa para a raiz
                root = atual.noEsquerdo;
            } // Se o nó atual for um filho a esquerda 
            else if (estaNaEsquerda) {
                // O nó esquerdo do pai rebece o filho da esquerda do no atual
                pai.noEsquerdo = atual.noEsquerdo;
            } // Se o no atual for um filho a direita
            else {
                // O nó direito do pai recebe o filho da esquerda do no atual
                pai.noDireito = atual.noEsquerdo;
            }
        } // Se o nó a ser removido só possui um filho que fica no lado direito
        else if (atual.noEsquerdo == null) {
            // Se o nó atual for igual a raiz
            if (atual == root) {
                // O nó filho a direita é passado para a raiz
                root = atual.noDireito;
            } // Se o nó atual é um filho a esquerda
            else if (estaNaEsquerda) {
                // O nó a esquerda do pai recebe o valor do nó filho a direita
                pai.noEsquerdo = atual.noDireito;
            } // Se o nó atual é um filho a direita
            else {
                // O nó a direita do pai recebe o nó seguinte a direita
                pai.noDireito = atual.noDireito;
            }
        } // Se o nó a ser removido possui dois filhos
        else {
            // Chama o método getSuccessor que verifica o nó atual para ser 
            // removido e substituído
            NoArvore<T> sucessor = getSucessor(atual);
            // O nó esquerdo do sucessor recebe o nó substituto
            sucessor.noEsquerdo = atual.noEsquerdo;

            // Se o nó a ser removido for a raiz
            if (atual == root) {
                // O nó sucessor a esqueda substitui a raiz
                root = sucessor;
            } // Se o nó a ser removido for um filho do lado esquerdo
            else if (estaNaEsquerda) {
                // O nó pai removido é substituído pelo nó sucessor do lado esquerdo
                pai.noEsquerdo = sucessor;
            } // Se o nó a ser removido é um filho do lado direito
            else {
                // O nó removido é substituído pelo nó sucessor
                pai.noDireito = sucessor;
                // O nó do lado esquerdo do sucessor é um nó esquerdo do atual
                sucessor.noEsquerdo = atual.noEsquerdo;
            }
        }

        // O método retorna true para quando o nó for removido
        return true;
    }

    /**
     * Método que ajuda a encontrar o valor que substituirá o valor a ser
     * removido no caso dele ter dois nós filhos
     *
     * @param noParaDeletar Variável que armazena o nó a ser removido
     * @return NoArvore<T> Retorna o valor que substituirá o valor
     */
    private NoArvore<T> getSucessor(NoArvore<T> noParaDeletar) {
        // Variável referente ao nó pai do nó sucessor ao no a ser removido
        NoArvore<T> sucessorPai = noParaDeletar;
        // Variável referente ao nó sucessor ao nó a ser removido
        NoArvore<T> sucessor = noParaDeletar;
        // Variável referente ao nó atual 
        NoArvore<T> atual = noParaDeletar.noDireito;

        // Laço  para enquanto o nó atual NÃO for nulo
        while (atual != null) {
            // O nó pai do nó sucessor recebe o sucessor
            sucessorPai = sucessor;
            // O nó sucessor recebe o atual
            sucessor = atual;
            // O nó atual recebe o filho do lado esquerdo do nó atual
            atual = atual.noEsquerdo;
        }

        // Se o nó sucessor for diferente do nó filho do lado direito do nó a
        // ser removido
        if (sucessor != noParaDeletar.noDireito) {
            // O nó filho do lado esquerdo do nó pai do nó sucessor recebe o
            // filho do lado direito do nó sucessor
            sucessorPai.noEsquerdo = sucessor.noDireito;

            // O nó filho do lado direito do nó sucessor recebe o filho do lado
            // direito do nó passado como parametro
            sucessor.noDireito = noParaDeletar.noDireito;
        }

        // Retorna o nó que contém o número seguinte ao passado como parâmetro
        return sucessor;
    }

    /**
     * Método que desenha a árvore gráfica
     *
     * @param arvore Váriável referente ao nó da árvore
     * @param x Variável referente a linha horizontal do painel
     * @param y Variável referente a linha vertical do painel
     * @param dist Variável referente a distância
     * @param painel Variavel referente ao painel
     */
    public static void desenha(NoArvore<Integer> arvore, int x, int y, int dist, JPanel painel) {
        // Criação do painel gráfico para a árvore
        Graphics2D g = (Graphics2D) painel.getGraphics();

        // Se o nó da árvore não estiver nulo
        if (arvore != null) {
            // Definição das cores dos nós e o tamanho
            g.setPaint(Color.GREEN);
            g.fill(new Arc2D.Float(x - 20, y - 20, 40, 40, 0, 360, Arc2D.PIE));
            g.setPaint(Color.BLACK);
            g.drawString(String.valueOf(arvore.data), x - 5, y + 5);

            // Cálculo da distância para colocar os nós da árvore
            int xEsq = x - ((dist) / 2);
            int xDir = x + ((dist) / 2);
            int yEsqDir = y + 60;

            // Se o nó esquerdo da árvore não estiver vazio
            if (arvore.noEsquerdo != null) {
                // A linha ligando os nós é desenhada da esquerda para direita
                g.drawLine(x, y, xEsq, yEsqDir);
            }

            // Se o nó direito da árvore não estiver vazio
            if (arvore.noDireito != null) {
                // A linha ligando os nós é desenhada da direita para a esquerda
                g.drawLine(x, y, xDir, yEsqDir);
            }

            // Desenha recursivamente as subárvores esquerdas e direitas até que
            // cheguem ao final
            desenha(arvore.noEsquerdo, xEsq, yEsqDir, (dist) / 2, painel);
            desenha(arvore.noDireito, xDir, yEsqDir, (dist) / 2, painel);
        }
    }

}
