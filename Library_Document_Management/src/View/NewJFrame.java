/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.BookController;
import Model.DTO.BookDTO;
import com.sun.xml.internal.fastinfoset.util.StringArray;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author vutro
 */
public class NewJFrame extends javax.swing.JFrame {

    BookController bc = BookController.GetInstance();
    /**
     * Creates new form NewJFrame
     */
    CardLayout cardLayout;
    CardLayout Cl;
    CardLayout Cl1;
    BookDTO bookDTO = new BookDTO();
    Border border = BorderFactory.createLineBorder(Color.RED, 1);
    DefaultTableModel model = new DefaultTableModel();
    Border border1 = BorderUIResource.getBlackLineBorderUIResource();

    public void getAllBook2() {
        ArrayList<BookDTO> getallbook1 = bc.getAllBook();
        Object colunm1[] = new Object[]{"id", "name", "author", "producer", "type", "publishing_company", "issue_number", "price"};

        jTable1.setModel(model);
        model.setColumnIdentifiers(colunm1);
        model.setRowCount(0);
        for (BookDTO bookDTO : getallbook1) {
            String[] data = new String[8];
            data[0] = bookDTO.getId() + "";
            data[1] = bookDTO.getName();
            data[2] = bookDTO.getAuthor();
            data[3] = bookDTO.getProducer();
            data[4] = bookDTO.getType();
            data[5] = bookDTO.getPublishing_company();
            data[6] = String.valueOf(bookDTO.getIssue_number());
            data[7] = String.valueOf(bookDTO.getPrice());
            model.addRow(data);
        }

    }

    public void getAllBook1() {
        ArrayList<BookDTO> getallbook1 = bc.getAllBook();
        Object colunm[] = new Object[]{"id", "name", "author", "producer", "type", "publishing_company", "issue_number", "price"};

        jTable2.setModel(model);
        model.setColumnIdentifiers(colunm);
        model.setRowCount(0);
        for (BookDTO bookDTO : getallbook1) {
            String[] data = new String[8];
            data[0] = bookDTO.getId() + "";
            data[1] = bookDTO.getName();
            data[2] = bookDTO.getAuthor();
            data[3] = bookDTO.getProducer();
            data[4] = bookDTO.getType();
            data[5] = bookDTO.getPublishing_company();
            data[6] = String.valueOf(bookDTO.getIssue_number());
            data[7] = String.valueOf(bookDTO.getPrice());
            model.addRow(data);
        }
    }

    public void searchBook1() {

        jButton8.addActionListener((ae) -> {
//        if(jTextField9.getText().equals("")){
//            jTextField9.setBorder(border);
//        }else{
//            jTextField9.setBorder(BorderUIResource.getBlackLineBorderUIResource());
//            bc.getBookByName(jTextField9.getText());
//        }
//        jButton11.addActionListener((al) -> {
//            jTextField9.setText("");
//        });

            if (jTextField9.getText().equals("")) {
                jTextField9.setBorder(border);
            } else {
                jTextField9.setBorder(BorderUIResource.getBlackLineBorderUIResource());
//           for( int k = 0; k < jTable2.getRowCount(); k++){//For each row
//        for(int j = 0; j < jTable2.getColumnCount(); j++){//For each column in that row
//            if(jTable2.getModel().getValueAt(k, j).equals(jTextField9.getText())){//Search the model
//                jTable2.getModel().getValueAt(k, j);//Print if found string
////            
//           }
//        }//For loop inner
//    }//For loop outer\

                BookDTO SBook = bc.getBookByName(jTextField9.getText());
                if (SBook == null) {
                    JOptionPane.showMessageDialog(rootPane, "khong co sach nay");
                } else {
                    model.setRowCount(0);
                    String[] data = new String[8];
                    data[0] = SBook.getId() + "";
                    data[1] = SBook.getName();
                    data[2] = SBook.getAuthor();
                    data[3] = SBook.getProducer();
                    data[4] = SBook.getType();
                    data[5] = SBook.getPublishing_company();
                    data[6] = String.valueOf(SBook.getIssue_number());
                    data[7] = String.valueOf(SBook.getPrice());
                    model.addRow(data);
                }

            }
            jButton11.addActionListener((al) -> {
                jTextField9.setText("");
            });

        });
    }

    public void methodBook() {
        Cl = (CardLayout) (book3.getLayout());

        book3.setLayout(Cl);
        book3.add(addBook, "addBook");
        book3.add(searchBook, "searchBook");
        book3.add(deleteBook, "deleteBook");
        book3.add(updateBook, "updateBook");
        Cl1 = (CardLayout) (getAllBook.getLayout());
        getAllBook.setLayout(Cl1);
        getAllBook.add(jPanel6, "tabel");
        getAllBook.add(jPanel3, "jPanel3");
        GAB.addActionListener((ae) -> {
            Cl1.show(getAllBook, "tabel");
//            Cl.show(book3, "addBook");
////           book3.setVisible(falsek);
//            this.getAllBook1(); 
//            S

        });
        SB.addActionListener((ae) -> {
            Cl1.show(getAllBook, "jPanel3");
            Cl.show(book3, "searchBook");
        });
        AB.addActionListener((ae) -> {
            Cl1.show(getAllBook, "jPanel3");
            Cl.show(book3, "addBook");

        });
        DB.addActionListener((ae) -> {
            Cl1.show(getAllBook, "jPanel3");
            Cl.show(book3, "deleteBook");
        });
        UB.addActionListener((ae) -> {
            Cl1.show(getAllBook, "jPanel3");
            Cl.show(book3, "updateBook");
        });
    }

    public void addBook() {
        jTextField5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                jTextField5.setText("Book");
            }

            @Override
            public void mousePressed(MouseEvent me) {
                //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent me) {
                //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        jTextField5.addActionListener((ae) -> {
            jTextField5.setText("Book");
        });

        book3.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        applyadd.addActionListener((al) -> {

            if (id.getText().equals("")) {
                id.setBorder(border);
            } else {
                id.setBorder(BorderUIResource.getBlackLineBorderUIResource());

                bookDTO.setId(id.getText());
            };
            if (jTextField2.getText().equals("")) {
                jTextField2.setBorder(border);

            } else {
                jTextField2.setBorder(BorderUIResource.getBlackLineBorderUIResource());
                bookDTO.setName(jTextField2.getText());
            };
            if (jTextField3.getText().equals("")) {
                jTextField3.setBorder(border);

            } else {
                jTextField3.setBorder(BorderUIResource.getBlackLineBorderUIResource());
                bookDTO.setAuthor(jTextField3.getText());
            };
            if (jTextField4.getText().equals("")) {
                jTextField4.setBorder(border);

            } else {
                jTextField4.setBorder(BorderUIResource.getBlackLineBorderUIResource());
                bookDTO.setProducer(jTextField4.getText());
            };
            if (jTextField5.getText().equals("")) {
                jTextField5.setBorder(border);

            } else {
                jTextField5.setBorder(BorderUIResource.getBlackLineBorderUIResource());
                bookDTO.setType(jTextField5.getText());
            };
            if (jTextField6.getText().equals("")) {
                jTextField6.setBorder(border);

            } else {
                jTextField6.setBorder(BorderUIResource.getBlackLineBorderUIResource());
                bookDTO.setPublishing_company(jTextField6.getText());
            };
            if (jTextField7.getText().equals("")) {
                jTextField7.setBorder(border);

            } else {
                jTextField7.setBorder(BorderUIResource.getBlackLineBorderUIResource());
                bookDTO.setIssue_number(Integer.parseInt(jTextField7.getText()));
            };
            if (jTextField8.getText().equals("")) {
                jTextField8.setBorder(border);

            } else {
                jTextField8.setBorder(BorderUIResource.getBlackLineBorderUIResource());
                bookDTO.setPrice(Float.valueOf(jTextField8.getText()));

            };
            bc.addBook(bookDTO);
            getAllBook1();
        });
        cannelAdd.addActionListener((as) -> {
            id.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
            jTextField7.setText("");
            jTextField8.setText("");
        });
    }

    public void deleteBook() {

        jButton12.addActionListener((ActionEvent ae) -> {
//            if (jTable2.getSelectedRowCount() == 1) {
//                jTextField10.setText((String) jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 1));
//                model.removeRow(jTable2.getSelectedRow());
            bc.deleteBook(jTextField10.getText());
            getAllBook1();
//            }

        });

    }

    public void updateBook() {
        jTextField14.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                jTextField14.setText("Book");
            }

            @Override
            public void mousePressed(MouseEvent me) {
                //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent me) {
                //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        jTextField14.addActionListener((ae) -> {
            jTextField14.setText("Book");
        });
        jButton2.addActionListener((ae) -> {
            if (id2.getText().equals("")) {
                id2.setBorder(border);
            } else {
                id2.setBorder(border1);
                bookDTO.setId(id2.getText());
            }
            if (jTextField11.getText().equals("")) {
                jTextField11.setBorder(border);
            } else {
                jTextField11.setBorder(border1);
                bookDTO.setName(jTextField11.getText());
            }
            if (jTextField12.getText().equals("")) {
                jTextField12.setBorder(border);
            } else {
                jTextField12.setBorder(border1);
                bookDTO.setAuthor(jTextField12.getText());
            }
            if (jTextField13.getText().equals("")) {
                jTextField13.setBorder(border);
            } else {
                jTextField13.setBorder(border1);
                bookDTO.setProducer(jTextField13.getText());
            }
            if (jTextField14.getText().equals("")) {
                jTextField14.setBorder(border);
            } else {
                jTextField14.setBorder(border1);
                bookDTO.setType(jTextField14.getText());
            }
            if (jTextField15.getText().equals("")) {
                jTextField15.setBorder(border);
            } else {
                jTextField15.setBorder(border1);
                bookDTO.setPublishing_company(jTextField15.getText());
            }
            if (jTextField16.getText().equals("")) {
                jTextField16.setBorder(border);
            } else {
                jTextField16.setBorder(border1);
                bookDTO.setIssue_number(Integer.valueOf(jTextField16.getText()));
            }
            if (jTextField17.getText().equals("")) {
                jTextField17.setBorder(border);
            } else {
                jTextField17.setBorder(border1);
                bookDTO.setPrice(Float.valueOf(jTextField17.getText()));
            }
            bc.updateBook(bookDTO);
            getAllBook1();
        });
        jButton3.addActionListener((ae) -> {
            id2.setText("");
            jTextField11.setText("");
            jTextField12.setText("");
            jTextField13.setText("");
            jTextField14.setText("");
            jTextField15.setText("");
            jTextField16.setText("");
            jTextField17.setText("");
        });

    }

    public NewJFrame() {
        initComponents();

//        jPanel1.setBounds(100,100,500,500);
//        
//        jPanel1.setBackground(Color.DARK_GRAY);
//        jPanel1.setLayout(new FlowLayout());
//        add(jPanel1);
//JButton jb = new JButton("hello");
//jb.setSize(100, 100);
//jPanel1.add(jb);
        cardLayout = (CardLayout) (jPanel4.getLayout());
        jPanel4.setLayout(cardLayout);
        jPanel4.add(book, "book");
        jPanel4.add(newPaper, "newPaper");
        jPanel4.add(document, "document");
        jPanel4.add(magazines, "magazines");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        book = new javax.swing.JPanel();
        book1 = new javax.swing.JPanel();
        getAllBook = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        book3 = new javax.swing.JPanel();
        searchBook = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        addBook = new javax.swing.JPanel();
        idBookjL = new javax.swing.JLabel();
        nameBookjL = new javax.swing.JLabel();
        authorBookjL = new javax.swing.JLabel();
        producerBookjL = new javax.swing.JLabel();
        typeBookjL = new javax.swing.JLabel();
        pCBookjL = new javax.swing.JLabel();
        iNBookjL = new javax.swing.JLabel();
        priceBookjL = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        applyadd = new javax.swing.JButton();
        cannelAdd = new javax.swing.JButton();
        deleteBook = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        updateBook = new javax.swing.JPanel();
        idBookjL2 = new javax.swing.JLabel();
        nameBookjL2 = new javax.swing.JLabel();
        authorBookjL2 = new javax.swing.JLabel();
        producerBookjL2 = new javax.swing.JLabel();
        typeBookjL2 = new javax.swing.JLabel();
        pCBookjL2 = new javax.swing.JLabel();
        iNBookjL2 = new javax.swing.JLabel();
        priceBookjL2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        id2 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        GAB = new javax.swing.JButton();
        SB = new javax.swing.JButton();
        AB = new javax.swing.JButton();
        DB = new javax.swing.JButton();
        UB = new javax.swing.JButton();
        nextBook = new javax.swing.JButton();
        BackBook = new javax.swing.JButton();
        document = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        magazines = new javax.swing.JPanel();
        newPaper = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        Document = new javax.swing.JButton();
        Magazines = new javax.swing.JButton();
        Book = new javax.swing.JButton();
        NewPaper = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        Close = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new java.awt.CardLayout());

        book.setBackground(new java.awt.Color(51, 255, 255));
        book.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        book1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                book1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        book1.setLayout(new java.awt.CardLayout());

        getAllBook.setBackground(new java.awt.Color(204, 204, 204));
        getAllBook.setLayout(new java.awt.CardLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );

        getAllBook.add(jPanel6, "card2");

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable2MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 640, 540));

        book3.setBackground(new java.awt.Color(0, 0, 0));
        book3.setLayout(new java.awt.CardLayout());

        jLabel3.setText("nhap name");

        jButton8.setText("Apply");

        jButton11.setText("cannel");

        javax.swing.GroupLayout searchBookLayout = new javax.swing.GroupLayout(searchBook);
        searchBook.setLayout(searchBookLayout);
        searchBookLayout.setHorizontalGroup(
            searchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(238, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchBookLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        searchBookLayout.setVerticalGroup(
            searchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBookLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addGroup(searchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton11))
                .addContainerGap(289, Short.MAX_VALUE))
        );

        book3.add(searchBook, "card5");

        idBookjL.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        idBookjL.setForeground(new java.awt.Color(0, 0, 0));
        idBookjL.setText("ID");
        idBookjL.setPreferredSize(new java.awt.Dimension(50, 0));

        nameBookjL.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        nameBookjL.setForeground(new java.awt.Color(0, 0, 0));
        nameBookjL.setText("Name");
        nameBookjL.setPreferredSize(new java.awt.Dimension(50, 0));

        authorBookjL.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        authorBookjL.setForeground(new java.awt.Color(0, 0, 0));
        authorBookjL.setText("Author");
        authorBookjL.setPreferredSize(new java.awt.Dimension(50, 0));

        producerBookjL.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        producerBookjL.setForeground(new java.awt.Color(0, 0, 0));
        producerBookjL.setText("Producer");
        producerBookjL.setPreferredSize(new java.awt.Dimension(50, 0));

        typeBookjL.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        typeBookjL.setForeground(new java.awt.Color(0, 0, 0));
        typeBookjL.setText("Type");
        typeBookjL.setPreferredSize(new java.awt.Dimension(50, 0));

        pCBookjL.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        pCBookjL.setForeground(new java.awt.Color(0, 0, 0));
        pCBookjL.setText("Publishing Company");
        pCBookjL.setPreferredSize(new java.awt.Dimension(50, 0));

        iNBookjL.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        iNBookjL.setForeground(new java.awt.Color(0, 0, 0));
        iNBookjL.setText("Issue Number");
        iNBookjL.setPreferredSize(new java.awt.Dimension(50, 0));

        priceBookjL.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        priceBookjL.setForeground(new java.awt.Color(0, 0, 0));
        priceBookjL.setText("Price");
        priceBookjL.setPreferredSize(new java.awt.Dimension(50, 0));

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        applyadd.setText("Apply");

        cannelAdd.setText("Cannel");

        javax.swing.GroupLayout addBookLayout = new javax.swing.GroupLayout(addBook);
        addBook.setLayout(addBookLayout);
        addBookLayout.setHorizontalGroup(
            addBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(applyadd, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(priceBookjL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idBookjL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameBookjL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(typeBookjL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(producerBookjL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(authorBookjL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pCBookjL, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(iNBookjL, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(addBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addBookLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(addBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5)
                            .addComponent(jTextField6)
                            .addComponent(jTextField7)
                            .addComponent(jTextField8)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addBookLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(cannelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        addBookLayout.setVerticalGroup(
            addBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addBookLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(addBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addBookLayout.createSequentialGroup()
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(addBookLayout.createSequentialGroup()
                        .addComponent(idBookjL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameBookjL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(authorBookjL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(producerBookjL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(typeBookjL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pCBookjL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iNBookjL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceBookjL, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addGroup(addBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(applyadd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cannelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58))))
        );

        book3.add(addBook, "card4");

        deleteBook.setBackground(new java.awt.Color(153, 153, 153));

        jLabel5.setText("nhap name");

        jTextField10.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField10CaretUpdate(evt);
            }
        });

        jButton12.setText("Apply");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
        });

        jButton13.setText("Canner");

        javax.swing.GroupLayout deleteBookLayout = new javax.swing.GroupLayout(deleteBook);
        deleteBook.setLayout(deleteBookLayout);
        deleteBookLayout.setHorizontalGroup(
            deleteBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteBookLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(deleteBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deleteBookLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton12)
                .addGap(18, 18, 18)
                .addComponent(jButton13)
                .addGap(14, 14, 14))
        );
        deleteBookLayout.setVerticalGroup(
            deleteBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteBookLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(deleteBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton13))
                .addContainerGap(321, Short.MAX_VALUE))
        );

        book3.add(deleteBook, "card5");

        updateBook.setBackground(new java.awt.Color(153, 153, 153));
        updateBook.setPreferredSize(new java.awt.Dimension(100, 100));

        idBookjL2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        idBookjL2.setForeground(new java.awt.Color(0, 0, 0));
        idBookjL2.setText("ID");
        idBookjL2.setPreferredSize(new java.awt.Dimension(50, 0));

        nameBookjL2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        nameBookjL2.setForeground(new java.awt.Color(0, 0, 0));
        nameBookjL2.setText("Name");
        nameBookjL2.setPreferredSize(new java.awt.Dimension(50, 0));

        authorBookjL2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        authorBookjL2.setForeground(new java.awt.Color(0, 0, 0));
        authorBookjL2.setText("Author");
        authorBookjL2.setPreferredSize(new java.awt.Dimension(50, 0));

        producerBookjL2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        producerBookjL2.setForeground(new java.awt.Color(0, 0, 0));
        producerBookjL2.setText("Producer");
        producerBookjL2.setPreferredSize(new java.awt.Dimension(50, 0));

        typeBookjL2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        typeBookjL2.setForeground(new java.awt.Color(0, 0, 0));
        typeBookjL2.setText("Type");
        typeBookjL2.setPreferredSize(new java.awt.Dimension(50, 0));

        pCBookjL2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        pCBookjL2.setForeground(new java.awt.Color(0, 0, 0));
        pCBookjL2.setText("Publishing Company");
        pCBookjL2.setPreferredSize(new java.awt.Dimension(50, 0));

        iNBookjL2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        iNBookjL2.setForeground(new java.awt.Color(0, 0, 0));
        iNBookjL2.setText("Issue Number");
        iNBookjL2.setPreferredSize(new java.awt.Dimension(50, 0));

        priceBookjL2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        priceBookjL2.setForeground(new java.awt.Color(0, 0, 0));
        priceBookjL2.setText("Price");
        priceBookjL2.setPreferredSize(new java.awt.Dimension(50, 0));

        id2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id2ActionPerformed(evt);
            }
        });

        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        jButton2.setText("ok");

        jButton3.setText("cannel");

        javax.swing.GroupLayout updateBookLayout = new javax.swing.GroupLayout(updateBook);
        updateBook.setLayout(updateBookLayout);
        updateBookLayout.setHorizontalGroup(
            updateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateBookLayout.createSequentialGroup()
                .addGroup(updateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateBookLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(updateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(priceBookjL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idBookjL2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameBookjL2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(typeBookjL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(producerBookjL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(authorBookjL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pCBookjL2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iNBookjL2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(updateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField11)
                            .addComponent(jTextField12)
                            .addComponent(jTextField13)
                            .addComponent(jTextField14)
                            .addComponent(jTextField15)
                            .addComponent(jTextField16)
                            .addComponent(jTextField17)
                            .addComponent(id2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(updateBookLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jButton2)
                        .addGap(71, 71, 71)
                        .addComponent(jButton3)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        updateBookLayout.setVerticalGroup(
            updateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateBookLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(updateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateBookLayout.createSequentialGroup()
                        .addComponent(id2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(updateBookLayout.createSequentialGroup()
                        .addComponent(idBookjL2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameBookjL2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(authorBookjL2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(producerBookjL2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(typeBookjL2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pCBookjL2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iNBookjL2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceBookjL2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        book3.add(updateBook, "card6");

        jPanel3.add(book3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 550));

        getAllBook.add(jPanel3, "card3");

        book1.add(getAllBook, "card2");

        book.add(book1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 1080, 540));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        GAB.setText("Get All Book");
        GAB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GABActionPerformed(evt);
            }
        });

        SB.setText("Search");

        AB.setText("Add");

        DB.setText("Delete");

        UB.setText("Update");

        nextBook.setText("Next");

        BackBook.setText("Back");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(AB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(GAB, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
            .addComponent(UB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nextBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BackBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(GAB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AB, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UB, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nextBook, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BackBook, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        book.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 540));

        jPanel4.add(book, "card5");

        document.setBackground(new java.awt.Color(204, 255, 204));

        jButton1.setText("jButton1");

        javax.swing.GroupLayout documentLayout = new javax.swing.GroupLayout(document);
        document.setLayout(documentLayout);
        documentLayout.setHorizontalGroup(
            documentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(documentLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jButton1)
                .addContainerGap(1025, Short.MAX_VALUE))
        );
        documentLayout.setVerticalGroup(
            documentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(documentLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jButton1)
                .addContainerGap(418, Short.MAX_VALUE))
        );

        jPanel4.add(document, "card3");

        magazines.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout magazinesLayout = new javax.swing.GroupLayout(magazines);
        magazines.setLayout(magazinesLayout);
        magazinesLayout.setHorizontalGroup(
            magazinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        magazinesLayout.setVerticalGroup(
            magazinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        jPanel4.add(magazines, "card4");

        newPaper.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout newPaperLayout = new javax.swing.GroupLayout(newPaper);
        newPaper.setLayout(newPaperLayout);
        newPaperLayout.setHorizontalGroup(
            newPaperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        newPaperLayout.setVerticalGroup(
            newPaperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        jPanel4.add(newPaper, "card2");

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1200, 540));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        Document.setText("Document");
        Document.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocumentActionPerformed(evt);
            }
        });

        Magazines.setText("Magazines");
        Magazines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MagazinesActionPerformed(evt);
            }
        });

        Book.setText("Book");
        Book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookActionPerformed(evt);
            }
        });

        NewPaper.setText("NewPaper");
        NewPaper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewPaperActionPerformed(evt);
            }
        });

        Next.setText("Next");

        Close.setText("Close");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Book, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Document, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Magazines, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NewPaper, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Close, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 449, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Book, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Magazines, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewPaper, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Document, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Close, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(279, 279, 279))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1210, 60));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("WELCOME TO LIBRARY IN HA NOI University Of Sience and Technology");
        jLabel2.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(245, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(164, 164, 164))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel2.getAccessibleContext().setAccessibleName("jLabel2\n");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocumentActionPerformed

        cardLayout.show(jPanel4, "document");

    }//GEN-LAST:event_DocumentActionPerformed

    private void MagazinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MagazinesActionPerformed
        cardLayout.show(jPanel4, "magazines");
    }//GEN-LAST:event_MagazinesActionPerformed

    private void BookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookActionPerformed
        cardLayout.show(jPanel4, "book");

        getAllBook2();
        getAllBook1();
        searchBook1();
        addBook();
        methodBook();
        deleteBook();
        updateBook();

//   book.setLayout(Cl);
//   book.add(book1,"book1");
//   book.add(jPanel2,"jPanel2");

    }//GEN-LAST:event_BookActionPerformed

    private void NewPaperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewPaperActionPerformed
        cardLayout.show(jPanel4, "newPaper");
    }//GEN-LAST:event_NewPaperActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CloseActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void GABActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GABActionPerformed

    }//GEN-LAST:event_GABActionPerformed
    private void book1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_book1AncestorAdded

    }//GEN-LAST:event_book1AncestorAdded

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField10CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField10CaretUpdate

        String str;
        str = jTextField10.getText();
        BookDTO bookDTO1 = bc.getBookByName(str);
        if (bookDTO1 != null) {
            model.setRowCount(0);
            String[] data = new String[8];
            data[0] = bookDTO1.getId() + "";
            data[1] = bookDTO1.getName();
            data[2] = bookDTO1.getAuthor();
            data[3] = bookDTO1.getProducer();
            data[4] = bookDTO1.getType();
            data[5] = bookDTO1.getPublishing_company();
            data[6] = String.valueOf(bookDTO1.getIssue_number());
            data[7] = String.valueOf(bookDTO1.getPrice());
            model.addRow(data);
        }


    }//GEN-LAST:event_jTextField10CaretUpdate

    private void id2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id2ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
//   
//model.removeRow(jTable2.getSelectedRow());
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseEntered


    }//GEN-LAST:event_jTable2MouseEntered

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseClicked
//         if (jTable2.getSelectedRowCount() == 1) {
////                jTextField10.setText((String) jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 1));
//                model.removeRow(jTable2.getSelectedRow());
//                bc.deleteBook(jTextField10.getText());
//         }
    }//GEN-LAST:event_jButton12MouseClicked

    private void jTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MousePressed
        String str = (String) jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 1);
        jTextField10.setText(str);
    }//GEN-LAST:event_jTable2MousePressed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseReleased

    /**
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                NewJFrame jf = new NewJFrame();
//             jf.pack();
                jf.setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AB;
    private javax.swing.JButton BackBook;
    private javax.swing.JButton Book;
    private javax.swing.JButton Close;
    private javax.swing.JButton DB;
    private javax.swing.JButton Document;
    private javax.swing.JButton GAB;
    private javax.swing.JButton Magazines;
    private javax.swing.JButton NewPaper;
    private javax.swing.JButton Next;
    private javax.swing.JButton SB;
    private javax.swing.JButton UB;
    private javax.swing.JPanel addBook;
    private javax.swing.JButton applyadd;
    private javax.swing.JLabel authorBookjL;
    private javax.swing.JLabel authorBookjL2;
    private javax.swing.JPanel book;
    private javax.swing.JPanel book1;
    private javax.swing.JPanel book3;
    private javax.swing.JButton cannelAdd;
    private javax.swing.JPanel deleteBook;
    private javax.swing.JPanel document;
    private javax.swing.JPanel getAllBook;
    private javax.swing.JLabel iNBookjL;
    private javax.swing.JLabel iNBookjL2;
    private javax.swing.JTextField id;
    private javax.swing.JTextField id2;
    private javax.swing.JLabel idBookjL;
    private javax.swing.JLabel idBookjL2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel magazines;
    private javax.swing.JLabel nameBookjL;
    private javax.swing.JLabel nameBookjL2;
    private javax.swing.JPanel newPaper;
    private javax.swing.JButton nextBook;
    private javax.swing.JLabel pCBookjL;
    private javax.swing.JLabel pCBookjL2;
    private javax.swing.JLabel priceBookjL;
    private javax.swing.JLabel priceBookjL2;
    private javax.swing.JLabel producerBookjL;
    private javax.swing.JLabel producerBookjL2;
    private javax.swing.JPanel searchBook;
    private javax.swing.JLabel typeBookjL;
    private javax.swing.JLabel typeBookjL2;
    private javax.swing.JPanel updateBook;
    // End of variables declaration//GEN-END:variables
}
