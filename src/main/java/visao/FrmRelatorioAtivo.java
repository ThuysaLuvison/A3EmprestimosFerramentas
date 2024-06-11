package visao;

import com.google.protobuf.TextFormat;
import dao.ConexaoDataBaseDAO;
import dao.EmprestimoDAO;
import java.sql.Date;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Emprestimo;
import modelo.Util;

/**
 * JFrame para exibir o relatório de empréstimos ativos.
 */
public class FrmRelatorioAtivo extends javax.swing.JFrame {

    private Emprestimo objetoEmprestimo;
    private EmprestimoDAO dao;

    /**
     * Construtor da classe. Inicializa os componentes da interface gráfica,
     * cria um objeto Emprestimo e um objeto EmprestimoDAO, e carrega a tabela
     * de empréstimos ativos.
     */
    public FrmRelatorioAtivo() {
        initComponents();
        this.objetoEmprestimo = new Emprestimo();
        this.dao = new EmprestimoDAO();
        carregaTabelaEmprestimos();
    }

    /**
     * Método para carregar a tabela de empréstimos ativos. Obtém os empréstimos
     * ativos do banco de dados através do EmprestimoDAO e os adiciona à tabela.
     * Define as larguras preferenciais das colunas da tabela.
     */
    private void carregaTabelaEmprestimos() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTable.getModel();
        modelo.setNumRows(0);
        for (Emprestimo a : dao.getEmprestimosAtivos()) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getIdAmg(),
                a.getDataEmprestimo(),
                a.getDataDevolucao(),
                a.isEntregue()});
        }
        jTable.getColumn("ID").setPreferredWidth(50);
        jTable.getColumn("ID_Amg").setPreferredWidth(50);
        jTable.getColumn("Data_Empréstimo").setPreferredWidth(140);
        jTable.getColumn("Data_Devolução").setPreferredWidth(140);
        jTable.getColumn("Entregue").setPreferredWidth(57);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JCBEntregue = new javax.swing.JCheckBox();
        JTFDataEmp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTFDataDev = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JBAlterar = new javax.swing.JButton();
        JBCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Empréstimos Ativos");
        setResizable(false);

        JCBEntregue.setBorder(null);
        JCBEntregue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        JTFDataEmp.setEditable(false);
        JTFDataEmp.setBackground(new java.awt.Color(255, 255, 255));
        JTFDataEmp.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        JTFDataEmp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel4.setText("Empréstimo:");

        JTFDataDev.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        JTFDataDev.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "ID_Amg", "Data_Empréstimo", "Data_Devolução", "Entregue"
            }
        ));
        jTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable.setShowGrid(true);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel1.setText("Devolução:");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        jLabel2.setText("Clique Aqui Para Confimar Entrega");

        JBAlterar.setText("Alterar");
        JBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAlterarActionPerformed(evt);
            }
        });

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel5.setText("RELATÓRIO DE EMPRÉSTIMOS ATIVOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JTFDataEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JTFDataDev, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JCBEntregue, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(169, 169, 169))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(JBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(JTFDataEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFDataDev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JCBEntregue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBAlterar)
                    .addComponent(JBCancelar))
                .addGap(27, 27, 27))
        );

        setSize(new java.awt.Dimension(756, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        /**
         * Atualiza os campos de texto com as datas de devolução e empréstimo da
         * linha selecionada na tabela. Se nenhuma linha estiver selecionada, os
         * campos de texto permanecem inalterados.
         */
        if (this.jTable.getSelectedRow() != -1) {
            String dataDev = this.jTable.getValueAt(this.jTable.getSelectedRow(), 3).toString();
            String dataEmp = this.jTable.getValueAt(this.jTable.getSelectedRow(), 2).toString();

            this.JTFDataDev.setText(dataDev);
            this.JTFDataEmp.setText(dataEmp);
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void JBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAlterarActionPerformed
        /**
         * Método para alterar um empréstimo existente.
         */
        try {
            int id = 0;
            /**
             * Verifica se foi selecionada uma linha na tabela.
             */
            if (this.jTable.getSelectedRow() == -1) {
                throw new Mensagem(
                        "Primeiro Selecione um Empréstimo para ALTERAR");
            } else {
                /**
                 * Obtém o ID do empréstimo selecionado na tabela.
                 */
                id = Integer.parseInt(this.jTable.getValueAt(this.jTable.getSelectedRow(), 0).toString());
            }

            String regex = "\\d{4}-\\d{2}-\\d{2}";
            Date dataDevolucao = null;
            Date dataEmprestimo = Util.stringParaDateSQL(JTFDataEmp.getText());
            boolean Entregue = false;

            /**
             * Verifica se a data de devolução está no formato correto.
             */
            if (this.JTFDataDev.getText().matches(regex)) {
                dataDevolucao = Util.stringParaDateSQL(JTFDataDev.getText());
                /**
                 * Verifica se a data de devolução é válida.
                 */
                if (dataDevolucao.before(dataEmprestimo)) {
                    dataDevolucao = null;
                    throw new Mensagem("Data de Devolução não pode ser antes da Data do Empréstimo");

                } else if (dataDevolucao.after(dataEmprestimo)) {
                    dataDevolucao = Util.stringParaDateSQL(JTFDataDev.getText());
                } else {
                    dataDevolucao = null;
                    throw new Mensagem("Data de Devolução não pode ser igual a da Data do Empréstimo");
                }
            } else {
                throw new Mensagem("Data de Devolução deve conter o seguinte formato:\nyyyy-MM-dd");
            }
            /**
             * Verifica se o empréstimo foi entregue.
             */
            if (JCBEntregue.isSelected()) {
                int respostaUsuario = JOptionPane.showConfirmDialog(null, "Tem certeza que este Empréstimo foi finalizado?");

                if (respostaUsuario == 0) {
                    if (JCBEntregue.isSelected()) {
                        Entregue = true;
                        dao.alterarIdEmpFerramentaPendente(id);
                    }

                } else {
                    return;
                }
            }

            /**
             * Altera o empréstimo no banco de dados.
             */
            if (this.objetoEmprestimo.alterarEmprestimo(dataDevolucao, Entregue, id)) {
                this.JTFDataDev.setText("");
                this.JCBEntregue.setSelected(false);
                JOptionPane.showMessageDialog(rootPane, "Empréstimo Alterado com Sucesso!");
            }
            System.out.println(this.dao.getMinhaLista().toString());
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");

        } catch (TextFormat.ParseException | ParseException ex) {
            Logger.getLogger(FrmRelatorioTotal.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            carregaTabelaEmprestimos();
        }
    }//GEN-LAST:event_JBAlterarActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        /**
         * Fecha a janela atual.
         */
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed
    /**
     * Método principal que inicializa a interface gráfica do formulário de
     * Relatorio Ativos. É chamado pelo método main da aplicação para iniciar a
     * execução da interface.
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRelatorioAtivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAlterar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JCheckBox JCBEntregue;
    private javax.swing.JTextField JTFDataDev;
    private javax.swing.JTextField JTFDataEmp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
