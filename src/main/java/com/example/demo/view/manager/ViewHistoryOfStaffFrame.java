/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.view.manager;

import com.example.demo.controller.ViewHistoryOfStaffController;
import com.example.demo.model.UserDayOff;
import com.example.demo.model.UserDayOffModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class ViewHistoryOfStaffFrame extends javax.swing.JFrame {

    /**
     * Creates new form ViewHistoryOfStaffFrame
     */
    
    private ViewHistoryOfStaffController controller;
    private DefaultTableModel tableModel;
    private int idSelected = 0;
    private int indexSelected = 0;
    
    public ViewHistoryOfStaffFrame() {
        initComponents();
        
        controller = new ViewHistoryOfStaffController();
        
        tableModel = new DefaultTableModel();
        tableHistory.setModel(tableModel);
        
        tableModel.addColumn("ID");
        tableModel.addColumn("Họ tên");
        tableModel.addColumn("Ngày nghỉ");
        tableModel.addColumn("Số ngày nghĩ");
        tableModel.addColumn("Ghi chú");
        
        ListSelectionModel listSelectionModel = tableHistory.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                int[] rows = tableHistory.getSelectedRows();
                try {
                    idSelected = (int) tableHistory.getValueAt(rows[0], 0);
                    indexSelected = rows[0];
                } catch(Exception e){
                    
                }
            }
        });
        
        initData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableHistory = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        messengerText = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableHistory);

        jLabel1.setFont(jLabel1.getFont());
        jLabel1.setText("Nhập tin nhắn");

        sendButton.setFont(sendButton.getFont());
        sendButton.setText("Gửi tin nhắn");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(sendButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(messengerText)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messengerText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sendButton)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        sendMessager();
    }//GEN-LAST:event_sendButtonActionPerformed
    
    private void sendMessager() {
        String messenger = messengerText.getText().trim();
        if (messenger.equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return;
        }
        
        controller.sendMessager(idSelected, messenger);
        JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        
        tableModel.setValueAt(messenger, indexSelected, 4);
    }
    
    private void initData() {
        List<UserDayOffModel> models = controller.getStaffDayOffs();
        
        for(UserDayOffModel item : models) {
            
            tableModel.addRow(new Object[] {
                item.getId(),
                item.getName(),
                item.getDate().toString(),
                item.getNumberDayOff(),
                item.getComment()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField messengerText;
    private javax.swing.JButton sendButton;
    private javax.swing.JTable tableHistory;
    // End of variables declaration//GEN-END:variables
}
