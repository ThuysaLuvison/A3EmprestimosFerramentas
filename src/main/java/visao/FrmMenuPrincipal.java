package visao;

/**
 * Classe responsável por fornecer o menu principal da aplicação. Permite
 * acessar diferentes funcionalidades, como cadastro de ferramentas, cadastro de
 * amigos, visualização de relatórios e opção de sair. Esta classe utiliza
 * outras classes para exibir as funcionalidades correspondentes. O menu é
 * composto por opções de "Opções" e "Sobre".
 *
 * @author Thuysa
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {

    /**
     * Cria uma nova instância do formulário FrmMenuPrincipal. Inicializa os
     * componentes da interface gráfica.
     */
    public FrmMenuPrincipal() {
        initComponents();
    }

    /**
     * Este método é chamado a partir do construtor para inicializar o
     * formulário. AVISO: Não modifique este código. O conteúdo deste método é
     * sempre regenerado pelo editor de formulários.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemFerramentas = new javax.swing.JMenuItem();
        jMenuItemCadastroAmigos = new javax.swing.JMenuItem();
        jMenuItemRelatorio = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setText("EMPRÉSTIMOS");

        jMenu1.setText("Opções");

        jMenuItemFerramentas.setText("Ferramentas");
        jMenuItemFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFerramentasActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFerramentas);

        jMenuItemCadastroAmigos.setText("Amigos");
        jMenuItemCadastroAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroAmigosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCadastroAmigos);

        jMenuItemRelatorio.setText("Relatorio");
        jMenuItemRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemRelatorio);

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sobre");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel1)
                .addContainerGap(275, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(281, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(718, 376));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
     * Abre a janela de cadastro de ferramentas.
     *
     * @param evt - O evento de clique do item de menu.
     */
    private void jMenuItemFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFerramentasActionPerformed

        FrmCadastroFerramentas objeto = new FrmCadastroFerramentas();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemFerramentasActionPerformed
    /**
     * Abre a janela de cadastro de amigos.
     *
     * @param evt - O evento de clique do item de menu.
     */
    private void jMenuItemCadastroAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroAmigosActionPerformed
        /**
         * Abre a janela de cadastro de amigos.
         */
        FrmCadastroAmigos objeto = new FrmCadastroAmigos();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroAmigosActionPerformed
    /**
     * Fecha a aplicação.
     *
     * @param evt - O evento de clique do item de menu.
     */
    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed

        /**
         * Fecha a aplicação.
         */
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSairActionPerformed
    /**
     * Abre a janela de relatórios.
     *
     * @param evt - O evento de clique do item de menu.
     */
    private void jMenuItemRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioActionPerformed
        /**
         * Abre a janela de relatórios.
         */
        FrmRelatorio objeto = new FrmRelatorio();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemRelatorioActionPerformed

    /**
     * @param args - Argumentos da linha de comando.
     */
    public static void main(String args[]) {
        /**
         * Defina a aparência do Nimbus.
         */
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
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /**
         * Cria e exibe o formulário.
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }
    /**
     * Declaração de variáveis - não modificar.
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItemCadastroAmigos;
    private javax.swing.JMenuItem jMenuItemFerramentas;
    private javax.swing.JMenuItem jMenuItemRelatorio;
    private javax.swing.JMenuItem jMenuItemSair;
    // End of variables declaration//GEN-END:variables
    /**
     * Fim da declaração de variáveis.
     */
}
