package visao;

/**
 * Classe que representa a janela principal do menu da aplicação.
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {

    /**
     * Construtor da classe FrmMenuPrincipal. Inicializa os componentes da
     * interface gráfica.
     */
    public FrmMenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemAmigos = new javax.swing.JMenuItem();
        jMenuItemFerramentas = new javax.swing.JMenuItem();
        jMenuItemEmpréstimos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setText("EMPRÉSTIMOS DE FERRAMENTAS DO TIO AVÔ");

        jMenu1.setText("Opções");

        jMenuItemAmigos.setText("Amigos");
        jMenuItemAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAmigosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAmigos);

        jMenuItemFerramentas.setText("Ferramentas");
        jMenuItemFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFerramentasActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFerramentas);

        jMenuItemEmpréstimos.setText("Empréstimos");
        jMenuItemEmpréstimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEmpréstimosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemEmpréstimos);

        jMenu3.setText("Relatório");

        jMenuItem2.setText("Ativos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem5.setText("Pendentes");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Totais");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem3.setText("Mais Empréstimos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenu1.add(jMenu3);

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel1)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(756, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        /**
         * Finaliza a aplicação.
         */
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAmigosActionPerformed
        /**
         * Cria uma instância do formulário de cadastro de amigos e o torna
         * visível.
         */
        FrmCadastroAmigo objeto = new FrmCadastroAmigo();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemAmigosActionPerformed

    private void jMenuItemFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFerramentasActionPerformed
        /**
         * Cria uma instância do formulário de cadastro de ferramentas e o torna
         * visível.
         */
        FrmCadastroFerramenta objeto = new FrmCadastroFerramenta();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemFerramentasActionPerformed

    private void jMenuItemEmpréstimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEmpréstimosActionPerformed
        /**
         * Cria uma instância do formulário de cadastro de empréstimos e o torna
         * visível.
         */
        FrmCadastroEmprestimo objeto = new FrmCadastroEmprestimo();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemEmpréstimosActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        /**
         * Cria uma instância do formulário de relatório de empréstimos ativos e
         * o torna visível.
         */
        FrmRelatorioAtivo objeto = new FrmRelatorioAtivo();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        /**
         * Cria uma instância do formulário de relatório de empréstimos
         * pendentes e o torna visível.
         */
        FrmRelatorioPendente objeto = new FrmRelatorioPendente();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        /**
         * Cria uma instância do formulário de relatório de empréstimos totais e
         * o torna visível.
         */
        FrmRelatorioTotal objeto = new FrmRelatorioTotal();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        /**
         * Cria uma instância do formulário de relatório de mais empréstimos e
         * o torna visível.
         */
        FrmRelatorioMaisEmprestimo objeto = new FrmRelatorioMaisEmprestimo();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    /**
     * Método principal da aplicação, responsável por configurar o look and feel
     * e iniciar o formulário principal.
     *
     * @param args os argumentos da linha de comando
     */
    public static void main(String args[]) {
        /* Configura a aparência Nimbus (opcional) */
        //<editor-fold defaultstate="collapsed" desc=" Configuração do look and feel ">
        /* Se o Nimbus (introduzido no Java SE 6) não estiver disponível, mantenha o visual padrão.
     * Para detalhes, consulte http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
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

        /* Cria e exibe o formulário */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItemAmigos;
    private javax.swing.JMenuItem jMenuItemEmpréstimos;
    private javax.swing.JMenuItem jMenuItemFerramentas;
    private javax.swing.JMenuItem jMenuItemSair;
    // End of variables declaration//GEN-END:variables
}
