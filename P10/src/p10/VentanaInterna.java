package p10;


import sm.dsv.Imagen.PanelLienzo;

/**
 *
 * @author Diego
 */
public class VentanaInterna extends javax.swing.JInternalFrame {

    //private PanelLienzo lienzo;

    /**
     * Creates new form VentanaInterna
     */
    public VentanaInterna() {
        super("Ventana Interna",
              true,   // resizable
              true,   // closable
              true,   // maximizable
              true);  // iconifiable
        
        initComponents();
        // Crea una instancia de Lienzo2D y añádela al centro de la ventana interna
        //lienzo = new PanelLienzo();
        //this.add(lienzo);

        // Establece el tamaño predeterminado de la ventana interna
        this.setSize(500, 500);
    }

    
    // Método para obtener el lienzo 2D
    public PanelLienzo getLienzo2D() {
        return lienzo;
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
        lienzo = new sm.dsv.Imagen.PanelLienzo();

        javax.swing.GroupLayout lienzoLayout = new javax.swing.GroupLayout(lienzo);
        lienzo.setLayout(lienzoLayout);
        lienzoLayout.setHorizontalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );
        lienzoLayout.setVerticalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(lienzo);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private sm.dsv.Imagen.PanelLienzo lienzo;
    // End of variables declaration//GEN-END:variables
}