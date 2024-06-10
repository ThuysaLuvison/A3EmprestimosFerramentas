package visao;

import dao.ConexaoDataBaseDAO;
import dao.EmprestimoDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Emprestimo;

/**
 * Classe que representa a janela de relatório de totais de empréstimos.
 */
public class FrmRelatorioTotal extends javax.swing.JFrame {

    // DAO para acessar os empréstimos
    private EmprestimoDAO dao;

    // Objeto para armazenar o empréstimo atual
    private Emprestimo objetoEmprestimo;

    /**
     * Construtor da classe FrmRelatorioTotais. Inicializa os componentes da
     * interface gráfica e carrega a tabela de empréstimos.
     */
    public FrmRelatorioTotal() {
        initComponents();
        this.dao = new EmprestimoDAO();
        this.objetoEmprestimo = new Emprestimo();
        carregaTabelaEmprestimos();
    }

    /**
     * Método privado para carregar os dados dos empréstimos na tabela.
     */
    private void carregaTabelaEmprestimos() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTable.getModel();
        modelo.setNumRows(0);
        for (Emprestimo a : dao.getMinhaLista()) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getIdAmg(),
                a.getDataEmprestimo(),
                a.getDataDevolucao(),
                a.isEntregue()});
        }
        // Define a largura das colunas da tabela
        jTable.getColumn("ID").setPreferredWidth(50);
        jTable.getColumn("ID_Amg").setPreferredWidth(50);
        jTable.getColumn("Data_Empréstimo").setPreferredWidth(140);
        jTable.getColumn("Data_Devolução").setPreferredWidth(140);
        jTable.getColumn("Entregue").setPreferredWidth(57);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        JBApagar = new javax.swing.JButton();
        JBCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro Geral de Empréstimos");
        setResizable(false);

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
        jScrollPane1.setViewportView(jTable);

        JBApagar.setText("Apagar");
        JBApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBApagarActionPerformed(evt);
            }
        });

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBApagar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(JBApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(756, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JBApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBApagarActionPerformed
        /**
         * Tenta apagar um empréstimo selecionado na tabela. Se o empréstimo
         * estiver pendente, exibe uma mensagem e não permite a exclusão. Se a
         * exclusão for confirmada pelo usuário, o empréstimo é apagado.
         */
        try {
            int id = 0;
            // Verifica se alguma linha da tabela está selecionada
            if (this.jTable.getSelectedRow() == -1) {
                throw new Mensagem(
                        "Primeiro Selecione um Empréstimo para APAGAR");
            } else {
                // Obtém o ID do empréstimo selecionado
                id = Integer.parseInt(this.jTable.getValueAt(this.jTable.getSelectedRow(), 0).toString());

                // Verifica se o empréstimo está pendente
                boolean Ver = dao.verificarPendencia(id);
                if (Ver == true) {
                    // Exibe uma mensagem informando que o empréstimo está pendente e não pode ser excluído
                    JOptionPane.showMessageDialog(null, "Esse Empréstimo está pendente "
                            + "\n   e não pode ser excluido");
                } else {
                    // Confirma se o usuário deseja realmente apagar o empréstimo
                    int respostaUsuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar este Empréstimo?");

                    if (respostaUsuario == 0) {
                        // Se a resposta for sim, tenta apagar o empréstimo
                        if (dao.alterarIdEmpFerramentaPendente(id) && this.objetoEmprestimo.apagarEmprestimo(id)) {
                            // Exibe uma mensagem de sucesso se o empréstimo for apagado com sucesso
                            JOptionPane.showMessageDialog(rootPane, "Empréstimo Apagado com Sucesso!");
                        }
                    }
                }
            }
            // Imprime a lista atualizada de empréstimos
            System.out.println(this.dao.getMinhaLista().toString());
        } catch (Mensagem erro) {
            // Exibe mensagens de erro
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            // Atualiza a tabela de empréstimos
            carregaTabelaEmprestimos();
        }
    }//GEN-LAST:event_JBApagarActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        // Fecha a janela atual
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed
    /**
     * Método principal que inicializa a interface gráfica do formulário de
     * Relatorio Totais. É chamado pelo método main da aplicação para iniciar
     * a execução da interface.
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRelatorioTotal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBApagar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
