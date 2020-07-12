/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.view.manager;

import com.example.demo.controller.ManagerController;
import com.example.demo.model.DayOff;
import com.example.demo.model.UserDayOff;
import com.example.demo.model.UserDayOffModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vovantam
 */
public class ManagerFrame extends javax.swing.JFrame {

    /**
     * Creates new form ManagerFrame
     */
    
    private DefaultTableModel tableModel;
    private ManagerController controller;
    private int idSelected = 0;
    private int indexSelected = 0;
    
    public ManagerFrame() {
        initComponents();
        
        tableModel = new DefaultTableModel();
        tableDayOff.setModel(tableModel);
        
        controller = new ManagerController();
        
        tableModel.addColumn("ID");
        tableModel.addColumn("Họ tên");
        tableModel.addColumn("Ngày nghỉ");
        tableModel.addColumn("Số ngày nghỉ");
        
        ListSelectionModel listSelectionModel = tableDayOff.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                int[] rows = tableDayOff.getSelectedRows();
                
                try{
                    idSelected = (int) tableModel.getValueAt(rows[0], 0);
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

        deleteOffer = new javax.swing.JButton();
        editStaffsButton = new javax.swing.JButton();
        agreeOffer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDayOff = new javax.swing.JTable();
        updateDayOffsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        deleteOffer.setText("Xóa đề xuất");
        deleteOffer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOfferActionPerformed(evt);
            }
        });

        editStaffsButton.setText("Chỉnh sửa nhân viên");
        editStaffsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editStaffsButtonActionPerformed(evt);
            }
        });

        agreeOffer.setText("Chấp nhận");
        agreeOffer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agreeOfferActionPerformed(evt);
            }
        });

        tableDayOff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableDayOff);

        updateDayOffsButton.setText("Cập nhật ngày nghỉ");
        updateDayOffsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDayOffsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteOffer, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agreeOffer, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editStaffsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateDayOffsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(103, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteOffer)
                    .addComponent(editStaffsButton)
                    .addComponent(agreeOffer)
                    .addComponent(updateDayOffsButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteOfferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOfferActionPerformed
        boolean result = controller.setStatusOfOffer(idSelected, DayOff.REFUSE);
        
        if(result){
            tableModel.removeRow(indexSelected);
            JOptionPane.showMessageDialog(this, "Bạn đã chấp nhận thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Bạn đã chấp nhận thất bại");
        }
    }//GEN-LAST:event_deleteOfferActionPerformed

    private void agreeOfferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agreeOfferActionPerformed
        boolean result = controller.setStatusOfOffer(idSelected, DayOff.ALLOW);
        
        if(result){
            tableModel.removeRow(indexSelected);
            JOptionPane.showMessageDialog(this, "Bạn đã chấp nhận thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Bạn đã chấp nhận thất bại");
        }
    }//GEN-LAST:event_agreeOfferActionPerformed

    private void editStaffsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editStaffsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editStaffsButtonActionPerformed

    private void updateDayOffsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDayOffsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateDayOffsButtonActionPerformed

    private void initData() {
        List<UserDayOffModel> userDayOffs = controller.getUserDayOffModelWhereStatusEqualZero();
        
        for(UserDayOffModel item : userDayOffs) {
            
            tableModel.addRow(new Object[] {
                item.getId(),
                item.getName(),
                item.getDate().toString(),
                item.getNumberDayOff()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agreeOffer;
    private javax.swing.JButton deleteOffer;
    private javax.swing.JButton editStaffsButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDayOff;
    private javax.swing.JButton updateDayOffsButton;
    // End of variables declaration//GEN-END:variables
}
