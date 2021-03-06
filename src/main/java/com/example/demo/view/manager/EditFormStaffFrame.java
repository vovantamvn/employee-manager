/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.view.manager;

import com.example.demo.controller.EditFormStaffController;
import com.example.demo.model.User;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class EditFormStaffFrame extends javax.swing.JFrame {

    /**
     * Creates new form EditFormStaffFrame
     */
    
    private EditFormStaffController controller;
    private DefaultTableModel tableModel;
    private int indexSelected = 0;
    private int idSelected = 0;
            
    public EditFormStaffFrame() {
        initComponents();
        
        controller = new EditFormStaffController();
        tableModel = new DefaultTableModel();
        tableUser.setModel(tableModel);
        
        tableModel.addColumn("ID");
        tableModel.addColumn("Họ tên");
        tableModel.addColumn("Tuổi");
        tableModel.addColumn("Giới tính");
        tableModel.addColumn("Ngày sinh");
        tableModel.addColumn("Bộ phận");
        tableModel.addColumn("Email");
        
        ListSelectionModel listSelectionModel = tableUser.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel.addListSelectionListener( new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                int[] rows = tableUser.getSelectedRows();
                
                try {
                    int id = (int) tableUser.getValueAt(rows[0], 0);
                    
                    User user = controller.findUserByID(id);
                
                    if(user != null) {
                        indexSelected = rows[0];
                        idSelected = id;
                        setDataFromUser(user);
                    }
                
                } catch(Exception e) {
                    //
                }
            }
        });
        
        roleCombobox.setEnabled(false);
        
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

        deleteButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        departmentText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dobText = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        genderCombobox = new javax.swing.JComboBox<>();
        roleCombobox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ageText = new javax.swing.JTextField();
        resetButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        addressText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        passwordText = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        deleteButton.setFont(deleteButton.getFont());
        deleteButton.setText("Xóa");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(jLabel7.getFont());
        jLabel7.setText("Bộ phận");

        jLabel8.setFont(jLabel8.getFont());
        jLabel8.setText("Ngày sinh");

        dobText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-mm-dd"))));

        jLabel9.setFont(jLabel9.getFont());
        jLabel9.setText("Giới tính");

        genderCombobox.setFont(genderCombobox.getFont());
        genderCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nữ", "Nam" }));

        roleCombobox.setFont(roleCombobox.getFont());
        roleCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Quản lý", "Admin" }));

        jLabel10.setFont(jLabel10.getFont());
        jLabel10.setText("Chức vụ");

        jLabel1.setFont(jLabel1.getFont());
        jLabel1.setText("Họ tên");

        jLabel2.setFont(jLabel2.getFont());
        jLabel2.setText("Tuổi");

        resetButton.setFont(resetButton.getFont());
        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(jLabel3.getFont());
        jLabel3.setText("Địa chỉ");

        jLabel4.setFont(jLabel4.getFont());
        jLabel4.setText("Tên ĐN");

        jLabel5.setFont(jLabel5.getFont());
        jLabel5.setText("Email");

        jLabel6.setFont(jLabel6.getFont());
        jLabel6.setText("Mật khẩu");

        updateButton.setFont(updateButton.getFont());
        updateButton.setText("Cập nhật");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        tableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableUser);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameText)
                                    .addComponent(addressText)
                                    .addComponent(emailText, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                    .addComponent(departmentText)
                                    .addComponent(genderCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ageText)
                                    .addComponent(usernameText)
                                    .addComponent(passwordText, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                    .addComponent(dobText)
                                    .addComponent(roleCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ageText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(dobText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(genderCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roleCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(deleteButton)
                    .addComponent(resetButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        deleteUser();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        clearData();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        updateUser();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void initData() {
        List<User> users = controller.getAllStaff();
        
        for(int i=0; i<users.size(); i++) {
            User user = users.get(i);
            
            tableModel.addRow(new Object[] {
                user.getId(),
                user.getName(),
                user.getAge(),
                (user.getGender() == 1)? "Nam" : "Nữ",
                user.getDob().toString(),
                user.getDepartment(),
                user.getEmail()
            });
        }
    }
    
    private void deleteUser() {
        controller.deleteUser(idSelected);
        
        JOptionPane.showMessageDialog(this, "Xóa thành công");
        
        tableModel.removeRow(indexSelected);
    }

    private void updateUser() {
        User user = getDataToUser();
        
        boolean result = (user != null) && controller.updateUser(idSelected, user);
        
        if(!result) {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            return;
        }
        
        JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        
        tableModel.removeRow(indexSelected);
        tableModel.insertRow(indexSelected, new Object[] {
                idSelected,
                user.getName(),
                user.getAge(),
                (user.getGender() == 1)? "Nam" : "Nữ",
                user.getDob().toString(),
                user.getDepartment(),
                user.getEmail()
        });
    }
    
    private boolean checkData() {
        if(usernameText.getText().equals(""))
            return false;
        
        if(passwordText.getText().equals(""))
            return false;
        
        if(nameText.getText().equals(""))
            return false;
        
        return true;
    }
    
    private void clearData() {
        usernameText.setText("");
        passwordText.setText("");
        nameText.setText("");
        addressText.setText("");
        departmentText.setText("");
        dobText.setText("");
        ageText.setText("");
        emailText.setText("");
    }
    
    private User getDataToUser() {
        
        if(!checkData()) {
            JOptionPane.showMessageDialog(this, "Nhập đầy đủ các trường");
            return null;
        }
        
        User user = new User();
        user.setAddress(addressText.getText());
        user.setEmail(emailText.getText());
        user.setName(nameText.getText());
        user.setUsername(usernameText.getText());
        user.setPassword(passwordText.getText());
        user.setDepartment(departmentText.getText());
        
        // Index = 0 => Nu
        user.setGender(genderCombobox.getSelectedIndex());
        
        // Role
        int role = roleCombobox.getSelectedIndex();
        
        if (role == 1) {
            // Quan Ly
            user.setRole(User.ROLE_MANAGER);
        } else if(role == 2) {
            // Admin
            user.setRole(User.ROLE_ADMIN);
        } else {
            user.setRole(User.ROLE_EMPLOYEE);
        }
        
        // Date of birth, Age
        try {
            int age = Integer.parseInt(ageText.getText());
            user.setAge(age);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(this, "Tuổi phải là số nguyên");
            return null;
        }
        
        try {
            String date = dobText.getText();
            LocalDate dob = LocalDate.parse(date);
            user.setDob(dob);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Nhập ngày theo định dạng năm-tháng-ngày");
            return null;
        }
        
        return user;
    }
    
    private void setDataFromUser(User user) {
        usernameText.setText(user.getUsername());
        passwordText.setText(user.getPassword());
        nameText.setText(user.getName());
        addressText.setText(user.getAddress());
        departmentText.setText(user.getDepartment());
        dobText.setText(user.getDob().toString());
        ageText.setText(String.valueOf(user.getAge()));
        emailText.setText(user.getEmail());
        
        genderCombobox.setSelectedIndex(user.getGender());
        
        int role = user.getRole();
        
        if(role == User.ROLE_ADMIN) {
            roleCombobox.setSelectedIndex(2);
        } else if(role == User.ROLE_MANAGER) {
            roleCombobox.setSelectedIndex(1);
        } else {
            roleCombobox.setSelectedIndex(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressText;
    private javax.swing.JTextField ageText;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField departmentText;
    private javax.swing.JFormattedTextField dobText;
    private javax.swing.JTextField emailText;
    private javax.swing.JComboBox<String> genderCombobox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField passwordText;
    private javax.swing.JButton resetButton;
    private javax.swing.JComboBox<String> roleCombobox;
    private javax.swing.JTable tableUser;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
