package arvore;

import java.awt.Graphics;
import javafx.scene.control.ScrollBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 * Frame do projeto - Tela de impressão da árvore gráfica
 *
 * @author Turma 315-6
 * @version 2.2
 */
public class FrameArvore extends javax.swing.JFrame {

    /**
     * Chamada da árvore binária para sua criação
     */
    ArvBinaria<Integer> arvore = new ArvBinaria<>();

    /**
     * Construtor do frame - Cria o novo frame, chama todos os componentes que
     * compõem o frame
     */
    public FrameArvore() {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);

        // Para atualizar a árvore a medida que for usando a barra de scroll 
        // vertical
        JScrollBar a = psArvore.getVerticalScrollBar();
        a.addAdjustmentListener((e) -> {
            Graphics g = painelArvore.getGraphics();
            painelArvore.update(g);
            arvore.desenha(arvore.root, painelArvore.getWidth() / 2, 100, painelArvore.getWidth() / 2 - 15, painelArvore);
        });

        // Para atualizar a árvore a medida que for usando a barra de scroll 
        // horizontal
        JScrollBar b = psArvore.getHorizontalScrollBar();
        b.addAdjustmentListener((e) -> {
            Graphics g = painelArvore.getGraphics();
            painelArvore.update(g);
            arvore.desenha(arvore.root, painelArvore.getWidth() / 2, 100, painelArvore.getWidth() / 2 - 15, painelArvore);
        });
    }

    /**
     * Método de busca de um valor na árvore
     *
     * @param n Variável que contém o valor a ser buscado na árvore
     * @return boolean - Caso o valor esteja na árvore então é retornado true,
     * se não estiver é retornado false
     */
    public boolean buscarNaArvore(int n) {
        NoArvore atual = arvore.root;
        NoArvore pai = arvore.root;
        boolean estaNaEsquerda = true;

        // Se a raiz da árvore estiver vazia significa que a árvore está vazia, 
        // retorna false
        if (arvore.root == null) {
            return false;
        }

        // Laço de busca para encontrar o nó a ser removido
        while (atual.data.compareTo(n) != 0) {
            // Variável ancestral que reebe o nó atual
            pai = atual;

            // Caso o valor esteja no lado esquerdo
            if (atual.data.compareTo(n) == 1) {
                estaNaEsquerda = true;
                atual = atual.noEsquerdo;
            } // Caso esteja do lado direito
            else {
                estaNaEsquerda = false;
                atual = atual.noDireito;
            }

            // Se o valor não for encontrado
            if (atual == null) {
                return false;
            }
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        lbValor = new javax.swing.JLabel();
        tfValorNo = new javax.swing.JTextField();
        btAdicionarNo = new javax.swing.JButton();
        btRemoverNo = new javax.swing.JButton();
        lbPercorrer = new javax.swing.JLabel();
        btPercorrerPreOrdem = new javax.swing.JButton();
        btPercorrerOrdem = new javax.swing.JButton();
        btPercorrerPosOrdem = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        lbStatus = new javax.swing.JLabel();
        pOrdem = new javax.swing.JPanel();
        lbOrdem = new javax.swing.JLabel();
        pPreOrdem = new javax.swing.JPanel();
        lbPreOrdem = new javax.swing.JLabel();
        pPosOrdem = new javax.swing.JPanel();
        lbPosOrdem = new javax.swing.JLabel();
        psArvore = new javax.swing.JScrollPane();
        painelArvore = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Árvore Gráfica");
        setResizable(false);

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        lbValor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbValor.setText("Valor:");

        btAdicionarNo.setText("Adicionar Nó");
        btAdicionarNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarNoActionPerformed(evt);
            }
        });

        btRemoverNo.setText("Remover Nó");
        btRemoverNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverNoActionPerformed(evt);
            }
        });

        lbPercorrer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbPercorrer.setText("Percorrer:");

        btPercorrerPreOrdem.setText("Pré-Ordem");
        btPercorrerPreOrdem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPercorrerPreOrdemActionPerformed(evt);
            }
        });

        btPercorrerOrdem.setText("Ordem");
        btPercorrerOrdem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPercorrerOrdemActionPerformed(evt);
            }
        });

        btPercorrerPosOrdem.setText("Pós-Ordem");
        btPercorrerPosOrdem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPercorrerPosOrdemActionPerformed(evt);
            }
        });

        btAtualizar.setText("Atualizar ");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        lbStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(255, 51, 0));
        lbStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        pOrdem.setBorder(javax.swing.BorderFactory.createTitledBorder("Em Ordem"));
        pOrdem.setPreferredSize(new java.awt.Dimension(125, 100));

        lbOrdem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout pOrdemLayout = new javax.swing.GroupLayout(pOrdem);
        pOrdem.setLayout(pOrdemLayout);
        pOrdemLayout.setHorizontalGroup(
            pOrdemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pOrdemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbOrdem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pOrdemLayout.setVerticalGroup(
            pOrdemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pOrdemLayout.createSequentialGroup()
                .addComponent(lbOrdem, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addContainerGap())
        );

        pPreOrdem.setBorder(javax.swing.BorderFactory.createTitledBorder("Pré Ordem"));
        pPreOrdem.setPreferredSize(new java.awt.Dimension(125, 100));

        lbPreOrdem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout pPreOrdemLayout = new javax.swing.GroupLayout(pPreOrdem);
        pPreOrdem.setLayout(pPreOrdemLayout);
        pPreOrdemLayout.setHorizontalGroup(
            pPreOrdemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPreOrdemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPreOrdem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pPreOrdemLayout.setVerticalGroup(
            pPreOrdemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPreOrdemLayout.createSequentialGroup()
                .addComponent(lbPreOrdem, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addContainerGap())
        );

        pPosOrdem.setBorder(javax.swing.BorderFactory.createTitledBorder("Pós Ordem"));
        pPosOrdem.setPreferredSize(new java.awt.Dimension(125, 100));

        lbPosOrdem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout pPosOrdemLayout = new javax.swing.GroupLayout(pPosOrdem);
        pPosOrdem.setLayout(pPosOrdemLayout);
        pPosOrdemLayout.setHorizontalGroup(
            pPosOrdemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPosOrdemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPosOrdem, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
                .addContainerGap())
        );
        pPosOrdemLayout.setVerticalGroup(
            pPosOrdemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPosOrdemLayout.createSequentialGroup()
                .addComponent(lbPosOrdem, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addContainerGap())
        );

        psArvore.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        psArvore.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        psArvore.setAutoscrolls(true);

        painelArvore.setMinimumSize(new java.awt.Dimension(920, 937));
        painelArvore.setPreferredSize(new java.awt.Dimension(1750, 1750));

        javax.swing.GroupLayout painelArvoreLayout = new javax.swing.GroupLayout(painelArvore);
        painelArvore.setLayout(painelArvoreLayout);
        painelArvoreLayout.setHorizontalGroup(
            painelArvoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1750, Short.MAX_VALUE)
        );
        painelArvoreLayout.setVerticalGroup(
            painelArvoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1750, Short.MAX_VALUE)
        );

        psArvore.setViewportView(painelArvore);

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btPercorrerOrdem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btPercorrerPreOrdem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAtualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btPercorrerPosOrdem, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                        .addComponent(tfValorNo)
                        .addComponent(lbValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbPercorrer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btAdicionarNo, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(btRemoverNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)))
                .addGap(30, 30, 30)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pPosOrdem, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                            .addComponent(pPreOrdem, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                            .addComponent(lbStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pOrdem, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE))
                        .addGap(30, 30, 30))
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(psArvore, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(lbValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfValorNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(btAdicionarNo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemoverNo)
                        .addGap(18, 18, 18)
                        .addComponent(lbPercorrer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPercorrerOrdem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPercorrerPreOrdem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPercorrerPosOrdem)
                        .addGap(33, 33, 33)
                        .addComponent(btAtualizar)
                        .addGap(0, 546, Short.MAX_VALUE))
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(psArvore, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pPreOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pPosOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para o botão que adiciona nós a árvore
     *
     * @param evt
     */
    private void btAdicionarNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarNoActionPerformed
        // Se o campo de texto com o valor a ser inserido NÃO estiver vazio
        if (!tfValorNo.getText().isEmpty()) {
            // Busca na árvore o valor e verifica se o valor já está contido na 
            // árvore e informa caso esteja
            if (buscarNaArvore(Integer.parseInt(tfValorNo.getText()))) {
                lbStatus.setText("Valor já existente!");
                tfValorNo.requestFocus();
            } // Se ele ainda NÃO estiver contido na árvore
            else {
                // O valor é pego, é calculado o tamanho para que o valor seja 
                // inserido no painel então o local é desenhado no painel
                arvore.insereNo(Integer.parseInt(tfValorNo.getText()));
                arvore.desenha(arvore.root, painelArvore.getWidth() / 2, 100, painelArvore.getWidth() / 2 - 15, painelArvore);
                // Os campos de texto são limpos
                tfValorNo.setText(null);
                lbStatus.setText(null);
                tfValorNo.requestFocus();
            }
        } // Se o campo de texto com o valor estiver vazio
        else {
            // É informada a mensagem para inserir um valor no campo
            lbStatus.setText("Digite um valor para inserir!");
            tfValorNo.setText(null);
            tfValorNo.requestFocus();
        }
    }//GEN-LAST:event_btAdicionarNoActionPerformed

    /**
     * Método para o botão que remove nós da árvore
     *
     * @param evt
     */
    private void btRemoverNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverNoActionPerformed
        Graphics g = painelArvore.getGraphics();

        // Caso o campo de texto esteja vazio
        if (tfValorNo.getText().isEmpty()) {
            // A mensagem é impressa para informar
            lbStatus.setText("Digite um valor para remover!");
            tfValorNo.requestFocus();
        } // Caso contrário, o valor informado na campo é pego e removido
        else if (arvore.removerNo(Integer.parseInt(tfValorNo.getText()))) {
            // O painel é atualizado sem o valor e ele é desenhado no painel
            painelArvore.update(g);
            arvore.desenha(arvore.root, painelArvore.getWidth() / 2, 100, painelArvore.getWidth() / 2 - 15, painelArvore);
            // Os campos de texto são limpos 
            tfValorNo.setText(null);
            lbStatus.setText(null);
            tfValorNo.requestFocus();
        } // Caso o valor a ser removido não está contido na árvore
        else {
            lbStatus.setText("Valor inexistente!");
            tfValorNo.requestFocus();
        }
    }//GEN-LAST:event_btRemoverNoActionPerformed

    /**
     * Método para o botão que atualiza a árvore
     *
     * @param evt
     */
    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        // A árvore gráfica é redesenhada no painel
        lbStatus.setText("");
        lbOrdem.setText("");
        lbPosOrdem.setText("");
        lbPreOrdem.setText("");
        Graphics g = painelArvore.getGraphics();
        painelArvore.update(g);
        arvore.desenha(arvore.root, painelArvore.getWidth() / 2, 100, painelArvore.getWidth() / 2 - 15, painelArvore);
    }//GEN-LAST:event_btAtualizarActionPerformed

    /**
     * Método para percorrer a árvore na ordem
     *
     * @param evt
     */
    private void btPercorrerOrdemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPercorrerOrdemActionPerformed
        // Imprimi a sequência em que a árvore é percorrida em ordem
        if (arvore.root == null) {
            lbStatus.setText("Árvore está vazia!");
        } else {
            lbOrdem.setText(arvore.Ordem());
            arvore.limparStrings();
        }
    }//GEN-LAST:event_btPercorrerOrdemActionPerformed

    /**
     * Método para percorrer a árvore na pré-ordem
     *
     * @param evt
     */
    private void btPercorrerPreOrdemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPercorrerPreOrdemActionPerformed
        // Imprimi a sequência em que a árvore é percorrida em pré-ordem
        if (arvore.root == null) {
            lbStatus.setText("Árvore está vazia!");
        } else {
            lbPreOrdem.setText(arvore.preOrdem());
            arvore.limparStrings();
        }
    }//GEN-LAST:event_btPercorrerPreOrdemActionPerformed

    /**
     * Método para percorrer a árvore na pós-ordem
     *
     * @param evt
     */
    private void btPercorrerPosOrdemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPercorrerPosOrdemActionPerformed
        // Imprimi a sequência em que a árvore é percorrida em pós-ordem
        if (arvore.root == null) {
            lbStatus.setText("Árvore está vazia!");
        } else {
            lbPosOrdem.setText(arvore.posOrdem());
            arvore.limparStrings();
        }
    }//GEN-LAST:event_btPercorrerPosOrdemActionPerformed

    /**
     * Método main para chamar a tela com os componentes que a compõem
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameArvore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameArvore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameArvore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameArvore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new FrameArvore().setVisible(true);

            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarNo;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btPercorrerOrdem;
    private javax.swing.JButton btPercorrerPosOrdem;
    private javax.swing.JButton btPercorrerPreOrdem;
    private javax.swing.JButton btRemoverNo;
    private javax.swing.JLabel lbOrdem;
    private javax.swing.JLabel lbPercorrer;
    private javax.swing.JLabel lbPosOrdem;
    private javax.swing.JLabel lbPreOrdem;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbValor;
    private javax.swing.JPanel pOrdem;
    private javax.swing.JPanel pPosOrdem;
    private javax.swing.JPanel pPreOrdem;
    private javax.swing.JPanel painelArvore;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JScrollPane psArvore;
    private javax.swing.JTextField tfValorNo;
    // End of variables declaration//GEN-END:variables
}
