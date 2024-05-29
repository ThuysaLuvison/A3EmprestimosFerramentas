package visao;

import com.mysql.cj.util.Util;
import dao.ConexaoDataBaseDAO;
import dao.EmprestimoDAO;
import dao.FerramentaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Amigo;
import modelo.Emprestimo;
import modelo.Ferramenta;
import modelo.Data;

/**
 * Classe responsável por fornecer o menu principal da aplicação. Permite
 * acessar diferentes funcionalidades, como cadastro de ferramentas, cadastro de
 * amigos, visualização de relatórios e opção de sair. Esta classe utiliza
 * outras classes para exibir as funcionalidades correspondentes. O menu é
 * composto por opções de "Opções" e "Sobre".
 *
 * @author Thuysa
 */
public class FrmCadastroEmprestimos extends javax.swing.JFrame {

    private FerramentaDAO dao = new FerramentaDAO();
    private EmprestimoDAO daoEmp = new EmprestimoDAO();
    private boolean countData = true;
    private Emprestimo objEmprestimo;
    private ConexaoDataBaseDAO connect;
    public ArrayList<String> FerSelect = new ArrayList<>();
    private ConexaoDataBaseDAO db;
    private Ferramenta objetoferramenta;

    /**
     * Cria uma nova instância do formulário FrmMenuPrincipal. Inicializa os
     * componentes da interface gráfica.
     */
    public FrmCadastroEmprestimos() {
        initComponents();
        preencherComboBox();
        this.objEmprestimo = new Emprestimo();
        connect = new ConexaoDataBaseDAO();
        String data = Data.dataAtual().toString();
        inputDateEmprestimo.setText(data);
        this.carregaTabelaFerramentas();
    }

    private void preencherComboBox() {
        try {
            String query = "SELECT nome FROM tb_amigos";
            PreparedStatement statement = connect.getConexao().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                JComboBoxAmigo.addItem(nome);
            }
            String queryFerramentas = "SELECT ferramenta FROM tb_ferramentas";
            PreparedStatement statementFerramentas = connect.getConexao().prepareStatement(queryFerramentas);
            ResultSet resultSetFerramentas = statementFerramentas.executeQuery();

            while (resultSetFerramentas.next()) {
                String nomeFerramenta = resultSetFerramentas.getString("ferramenta");
                JComboBoxFerramenta.addItem(nomeFerramenta);
            }

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
            // Lidar com exceções adequadamente
        }
    }

    public void carregaTabelaFerramentas() {
        DefaultTableModel modelo = (DefaultTableModel) JTableEmprestimo.getModel(); // Corrigido para tabelaFerramentas
        modelo.setNumRows(0);
        for (Ferramenta a : dao.getFerramentasDisponiveis()) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getFerramenta()
            });
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableEmprestimo = new javax.swing.JTable();
        JComboBoxAmigo = new javax.swing.JComboBox<>();
        JComboBoxFerramenta = new javax.swing.JComboBox<>();
        b_emprestar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputDateEmprestimo = new javax.swing.JLabel();
        mensagemEmprestimo = new javax.swing.JFormattedTextField();
        b_concluir = new javax.swing.JButton();
        JTextDevolucao = new javax.swing.JFormattedTextField();
        b_cancelar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Empréstimos");
        setPreferredSize(new java.awt.Dimension(740, 430));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setText("EMPRÉSTIMOS");

        JTableEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Ferramenta", "Empréstimo", "Devolução"
            }
        ));
        jScrollPane1.setViewportView(JTableEmprestimo);

        JComboBoxAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxAmigoActionPerformed(evt);
            }
        });

        JComboBoxFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxFerramentaActionPerformed(evt);
            }
        });

        b_emprestar.setText("Emprestar");
        b_emprestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_emprestarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel2.setText("Amigo");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel3.setText("Ferramenta");

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel4.setText("Data de empréstimo");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel5.setText("Data de devolução");

        mensagemEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mensagemEmprestimoActionPerformed(evt);
            }
        });

        b_concluir.setText("Concluir");

        JTextDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextDevolucaoActionPerformed(evt);
            }
        });

        b_cancelar.setText("Cancelar");
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(b_emprestar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_concluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(JComboBoxAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JComboBoxFerramenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(inputDateEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(JTextDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(mensagemEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inputDateEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(JTextDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JComboBoxAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JComboBoxFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(mensagemEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(b_concluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_emprestar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_cancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(756, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   /**
     * Método chamado quando há uma ação no JComboBox2.
     *
     * @param evt - O evento de clique do JComboBox2.
     */
    private void JComboBoxFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxFerramentaActionPerformed

    }//GEN-LAST:event_JComboBoxFerramentaActionPerformed
    /**
     * Método chamado quando há uma ação no botão "Emprestar".
     *
     * @param evt - O evento de clique do botão "Emprestar".
     */
    private void b_emprestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_emprestarActionPerformed
        b_emprestar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String infoAmigos = (String) JComboBoxAmigo.getSelectedItem();
                String infoFerramentas = (String) JComboBoxFerramenta.getSelectedItem();
                String dateEmprestimo = inputDateEmprestimo.getText();
                String dateDevolucao = JTextDevolucao.getText();

                DefaultTableModel model = (DefaultTableModel) JTableEmprestimo.getModel();
                model.addRow(new Object[]{infoAmigos, infoFerramentas, dateEmprestimo, dateDevolucao});

                try {
                    String query = "INSERT INTO tb_emprestimo (colunaAmigos, colunaFerramentas, colunaDateEmprestimo, colunaDateDevolucao) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt = db.prepareStatement(query);
                    pstmt.setString(1, infoAmigos);
                    pstmt.setString(2, infoFerramentas);
                    pstmt.setString(3, dateEmprestimo);
                    pstmt.setString(4, dateDevolucao);
                    pstmt.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }//GEN-LAST:event_b_emprestarActionPerformed
    /**
     * Método chamado quando há uma ação no JComboBox1.
     *
     * @param evt - O evento de clique do JComboBox1.
     */
    private void JComboBoxAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxAmigoActionPerformed
        // TODO add your handling code here:
        Object selectedAmigo = JComboBoxAmigo.getSelectedItem();
        Object selectedFerramenta = JComboBoxFerramenta.getSelectedItem();
        String inputDate = this.mensagemEmprestimo.getText();

        if (selectedAmigo != null && selectedFerramenta != null && !inputDate.isEmpty()) {
            String amigo = selectedAmigo.toString();
            String ferramenta = selectedFerramenta.toString();
            mensagemEmprestimo.setText(amigo + " irá pegar " + ferramenta + " emprestado até " + inputDate + ", certo?");
        } else {
            mensagemEmprestimo.setText("Por favor, selecione um amigo, uma ferramenta e insira a data de devolução.");
        }
    }//GEN-LAST:event_JComboBoxAmigoActionPerformed

    private void JTextDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextDevolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextDevolucaoActionPerformed

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_b_cancelarActionPerformed

    private void mensagemEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mensagemEmprestimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mensagemEmprestimoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCadastroEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /**
         * Cria e exibe o formulário.
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroEmprestimos().setVisible(true);
            }
        });
    }
    /**
     * Declaração de variáveis - não modificar.
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboBoxAmigo;
    private javax.swing.JComboBox<String> JComboBoxFerramenta;
    private javax.swing.JTable JTableEmprestimo;
    private javax.swing.JFormattedTextField JTextDevolucao;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JButton b_concluir;
    private javax.swing.JButton b_emprestar;
    private javax.swing.JLabel inputDateEmprestimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField mensagemEmprestimo;
    // End of variables declaration//GEN-END:variables
    /**
     * Fim da declaração de variáveis.
     */
}
