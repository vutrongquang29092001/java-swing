/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author vutro
 */
public class NewClass extends JFrame implements ActionListener{
private JFrame jF;
private JLabel nameJLabel;
private JLabel idJLabel;
private JLabel priceJLabel;
private JLabel producerJLabel;
private JLabel authotJLabel;
private JLabel typeJLabel;
private JFrame publishing_companyJLabel;
private JLabel issue_numberJLabel;
private TextField nameField;
private TextField idField;
private TextField priceField;
private TextField producerField;
private TextField authorField;
private TextField typeField;
private TextField publishing_companyField;
private TextField issue_numberField;
private JButton okButton;
private JButton cancelButton;
private  NewJPanel NpJPanel;
public void add(){
    NpJPanel = new NewJPanel();
    jF = new JFrame("Add Book");
    nameJLabel = new JLabel("name");
    nameJLabel.setSize(100,50);
    
    idJLabel = new JLabel("id");
    idJLabel.setSize(100,50);
    
    nameField = new TextField("");
    nameField.setSize(100,50);
    
    idField = new TextField("");
    idField.setSize(100,50);
    
    jF.add(NpJPanel);
    
    jF.add(nameField);
    jF.add(idField);
    jF.add(nameJLabel);
    jF.add(idJLabel);
    jF.setBounds(500,250,500,500);
//     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(22, 22, 22)
//                .addComponent(idJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
//                .addComponent(nameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(95, 95, 95)));
    jF.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jF.setLayout(new FlowLayout(20,50,100));
    
jF.setLayout(new GridLayout(HEIGHT,ALLBITS,2,20));
    jF.setVisible(true);
    
}
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewClass().add();
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
      
    }
    
}
