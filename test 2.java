import java.awt.event.ActionEvent;
import java.util.*;
import java.io.*;

public class test extends javax.swing.JFrame {

    private javax.swing.JButton addKeybtn;
    private javax.swing.JButton deleteKeybtn;
    private javax.swing.JTextField insertKey;
    private javax.swing.JButton addbucketSizebtn;
    private javax.swing.JTextField bucketSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea optext;
    private javax.swing.JButton searchKeybtn;


    private PrintStream standardOut;

    public test() {
        initComponents();
        PrintStream printStream = new PrintStream(new CustomOutputStream(optext));
        standardOut = System.out;
        System.setOut(printStream);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new test().setVisible(true);
            }
        });
//        new test();
    }

    hashTable hash = new hashTable(1);

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private  void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bucketSize = new javax.swing.JTextField("Enter bucket size");
        addbucketSizebtn = new javax.swing.JButton();
        insertKey = new javax.swing.JTextField("insert key");
        addKeybtn = new javax.swing.JButton();
        deleteKeybtn =  new javax.swing.JButton();
        searchKeybtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        optext = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bucketSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bucketSizeActionPerformed(evt);
            }
        });

        addbucketSizebtn.setText("Insert buckets size");
        addbucketSizebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbucketSizebtnActionPerformed(evt);
            }
        });

        insertKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        addKeybtn.setText("ADD");
        addKeybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        deleteKeybtn.setText("DELETE");
        deleteKeybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        searchKeybtn.setText("SEARCH");
        searchKeybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        optext.setColumns(20);
        optext.setRows(5);
        jScrollPane1.setViewportView(optext);


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(bucketSize)
                                                .addComponent(addbucketSizebtn)
                                                .addComponent(addKeybtn)
                                                .addComponent(deleteKeybtn)
                                                .addComponent(searchKeybtn))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(insertKey, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))

//                                                .addComponent(insertKey, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(83, 83, 83)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)

                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(158, 158, 158)
                                                .addComponent(bucketSize, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(addbucketSizebtn)
                                                .addComponent(insertKey, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(addKeybtn)
                                                        .addComponent(deleteKeybtn)
                                                        .addComponent(searchKeybtn))

                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EXTENDIBLE HASHING");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(335, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(318, 318, 318))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(ActionEvent evt) {
        String k = insertKey.getText();
        hash.delete(Integer.parseInt(k));
        hash.print();
    }

    private void addbucketSizebtnActionPerformed(ActionEvent evt) {

         hash= new hashTable(Integer.parseInt(bucketSize.getText()));
    }

    private void bucketSizeActionPerformed(ActionEvent evt) {
    }

    private void searchActionPerformed(ActionEvent evt) {
        String k = insertKey.getText();
        hash.lookup(Integer.parseInt(k));
    }

    private void addActionPerformed(ActionEvent evt) {
        String k = insertKey.getText();
        hash.insert(Integer.parseInt(k));

        hash.print();


    }

    private void inputActionPerformed(ActionEvent evt) {
    }


}
