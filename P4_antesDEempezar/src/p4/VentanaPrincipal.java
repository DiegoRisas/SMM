/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package p4;

/**
 *
 * @author Diego
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paint = new javax.swing.ButtonGroup();
        colo = new javax.swing.ButtonGroup();
        jPanel7 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jToggleButton12 = new javax.swing.JToggleButton();
        jToggleButton11 = new javax.swing.JToggleButton();
        jToggleButton10 = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jToggleButton14 = new javax.swing.JToggleButton();
        jToggleButton16 = new javax.swing.JToggleButton();
        jToggleButton17 = new javax.swing.JToggleButton();
        jToggleButton15 = new javax.swing.JToggleButton();
        jToggleButton13 = new javax.swing.JToggleButton();
        jToggleButton18 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jCheckBox2 = new javax.swing.JCheckBox();
        Prelleno3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jToolBar2.setRollover(true);
        jToolBar2.setBorderPainted(false);

        paint.add(jToggleButton12);
        jToggleButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/p4/linea.png"))); // NOI18N
        jToggleButton12.setBorderPainted(false);
        jToggleButton12.setFocusable(false);
        jToggleButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jToggleButton12);

        paint.add(jToggleButton11);
        jToggleButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/p4/rectangulo.png"))); // NOI18N
        jToggleButton11.setBorderPainted(false);
        jToggleButton11.setFocusable(false);
        jToggleButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jToggleButton11);

        paint.add(jToggleButton10);
        jToggleButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/p4/elipse.png"))); // NOI18N
        jToggleButton10.setToolTipText("");
        jToggleButton10.setBorderPainted(false);
        jToggleButton10.setFocusable(false);
        jToggleButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jToggleButton10);

        jPanel7.add(jToolBar2);

        getContentPane().add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 941, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel8.setMaximumSize(new java.awt.Dimension(180, 120));
        jPanel8.setPreferredSize(new java.awt.Dimension(70, 69));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel9.setMaximumSize(new java.awt.Dimension(90, 60));
        jPanel9.setPreferredSize(new java.awt.Dimension(90, 60));
        jPanel9.setLayout(new java.awt.GridLayout(2, 0));

        jToggleButton14.setBackground(new java.awt.Color(0, 0, 0));
        colo.add(jToggleButton14);
        jToggleButton14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButton14.setMaximumSize(new java.awt.Dimension(30, 30));
        jToggleButton14.setMinimumSize(new java.awt.Dimension(30, 30));
        jToggleButton14.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(jToggleButton14);

        jToggleButton16.setBackground(new java.awt.Color(255, 0, 0));
        colo.add(jToggleButton16);
        jToggleButton16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButton16.setMaximumSize(new java.awt.Dimension(30, 30));
        jToggleButton16.setMinimumSize(new java.awt.Dimension(30, 30));
        jToggleButton16.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(jToggleButton16);

        jToggleButton17.setBackground(new java.awt.Color(0, 0, 255));
        colo.add(jToggleButton17);
        jToggleButton17.setSelected(true);
        jToggleButton17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButton17.setMaximumSize(new java.awt.Dimension(30, 30));
        jToggleButton17.setMinimumSize(new java.awt.Dimension(30, 30));
        jToggleButton17.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(jToggleButton17);

        colo.add(jToggleButton15);
        jToggleButton15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButton15.setMaximumSize(new java.awt.Dimension(30, 30));
        jToggleButton15.setMinimumSize(new java.awt.Dimension(30, 30));
        jToggleButton15.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(jToggleButton15);

        jToggleButton13.setBackground(new java.awt.Color(255, 255, 0));
        colo.add(jToggleButton13);
        jToggleButton13.setForeground(new java.awt.Color(255, 255, 0));
        jToggleButton13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButton13.setMaximumSize(new java.awt.Dimension(30, 30));
        jToggleButton13.setMinimumSize(new java.awt.Dimension(30, 30));
        jToggleButton13.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(jToggleButton13);

        jToggleButton18.setBackground(new java.awt.Color(0, 255, 0));
        colo.add(jToggleButton18);
        jToggleButton18.setToolTipText("");
        jToggleButton18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButton18.setMaximumSize(new java.awt.Dimension(30, 30));
        jToggleButton18.setMinimumSize(new java.awt.Dimension(30, 30));
        jToggleButton18.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(jToggleButton18);

        jPanel8.add(jPanel9, java.awt.BorderLayout.WEST);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jCheckBox2.setText("Relleno");
        jPanel2.add(jCheckBox2);

        jPanel8.add(jPanel2, java.awt.BorderLayout.EAST);

        Prelleno3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Prelleno3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setText("Barra de estado");
        Prelleno3.add(jLabel1);

        jPanel8.add(Prelleno3, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel8, java.awt.BorderLayout.PAGE_END);

        jMenu2.setText("File");

        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Abrir");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Guardar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Prelleno3;
    private javax.swing.ButtonGroup colo;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JToggleButton jToggleButton10;
    private javax.swing.JToggleButton jToggleButton11;
    private javax.swing.JToggleButton jToggleButton12;
    private javax.swing.JToggleButton jToggleButton13;
    private javax.swing.JToggleButton jToggleButton14;
    private javax.swing.JToggleButton jToggleButton15;
    private javax.swing.JToggleButton jToggleButton16;
    private javax.swing.JToggleButton jToggleButton17;
    private javax.swing.JToggleButton jToggleButton18;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.ButtonGroup paint;
    // End of variables declaration//GEN-END:variables
}
