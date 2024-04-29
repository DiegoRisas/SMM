package sm.dsv.Imagen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;



/**
 *
 * @author Diego
 */
public class PanelLienzo extends javax.swing.JPanel {

    public enum Herramienta{
        Linea, Rectangulo, Elipse, Arrastrar, Fantasma
    }
    
    private MiShape mForma = new Linea();
    private Color color = Color.black;
    private Herramienta herramienta = null;
    private Point punto;
    private Stroke trazo = new BasicStroke();
    private Boolean relleno = false;
    private Boolean mover = false;
    private ModoEdicion modoEdicion = null;
    private Boolean alisado = false;
    private Boolean transparencia = false;
    private ArrayList<MiShape> mShape = new ArrayList();
    private BufferedImage img;
    private MiShape figuraSeleccionada = null;
    
    
    public MiShape getForma() {
        return mForma;
    }

    public void setForma(MiShape mForma) {
        this.mForma = mForma;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Boolean getRelleno() {
        return relleno;
    }

    public void setRelleno(Boolean relleno) {
        this.relleno = relleno;
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }

    public Stroke getTrazo() {
        return trazo;
    }

    public void setTrazo(Stroke trazo) {
        this.trazo = trazo;
    }

    public Boolean getAlisado() {
        return alisado;
    }

    public void setAlisado(Boolean alisado) {
        this.alisado = alisado;
    }

    public Boolean getTransparencia() {
        return transparencia;
    }

    public void setTransparencia(Boolean transparencia) {
        this.transparencia = transparencia;
    }

    public Boolean getMover() {
        return mover;
    }

    public void setMover(Boolean mover) {
        this.mover = mover;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
            
    
    /**
     * Creates new form PanelLienzo
     */
    public PanelLienzo() {
        initComponents();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        
        if(img!=null) g2d.drawImage(img,0,0,this);
        
        for(MiShape s: mShape) {
            s.draw(g2d);
        }
        
        if(modoEdicion != null && mover){
            modoEdicion.draw(g2d);
        }
        
    }

    private MiShape figuraSeleccionada(Point2D p){
        for(MiShape s:mShape)
            if(s.contains(p)){
                Point2D aux = new Point2D.Double(s.getX(), s.getY());
                modoEdicion = new ModoEdicion(aux);
                figuraSeleccionada = s;
                return s;
            }
        modoEdicion = null;
        return null;
    }
    
    public BufferedImage getPaintedImage(){
        // Código para crear una nueva imagen que
        // contenga la imagen actual más las figuras
        BufferedImage imgout = new BufferedImage(img.getWidth(),
                                           img.getHeight(),
                                           img.getType());

        Graphics2D g2dImagen = imgout.createGraphics();
        if(img!=null) g2dImagen.drawImage(img,0,0,this);
        for(MiShape s: mShape) {
            s.draw(g2dImagen);
        }
     
     return imgout;
    }

    public void actualizarSelectedFigure(){
        if(figuraSeleccionada!= null){
            figuraSeleccionada.setColor(color);
            figuraSeleccionada.setFill(relleno);
            figuraSeleccionada.setTrazo(trazo);
            figuraSeleccionada.setTransparencia(transparencia);
            figuraSeleccionada.setAlisado(alisado);
            
            this.repaint();
        }
    }
    public void volcarFigura() {
        if(figuraSeleccionada != null){
            Graphics2D g2d = img.createGraphics();
            figuraSeleccionada.draw(g2d);
            g2d.dispose();
            mShape.remove(figuraSeleccionada);
            figuraSeleccionada = null;
            modoEdicion = null;
            this.repaint();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if(mover){
                mForma = figuraSeleccionada(evt.getPoint()); 
                if(mForma != null){
                    punto = new Point(evt.getPoint().x - mForma.getBounds().x, evt.getPoint().y - mForma.getBounds().y);
                }
        }else{
            switch (herramienta) {
                case Linea: 
                    mForma = new Linea(evt.getPoint(),evt.getPoint());
                    break;
                case Rectangulo:
                    mForma = new Rectangulo(evt.getPoint(), evt.getPoint());
                    break;

                case Elipse:
                    mForma = new Elipse(evt.getPoint().x,evt.getPoint().y,evt.getPoint().x,evt.getPoint().y);
                    break;
                case Fantasma:
                    mForma = new Fantasma(evt.getPoint().x, evt.getPoint().y, 50, 50); // Tamaño predeterminado para el fantasma
                    break;
                default:
                    System.out.println("Ninguna herramienta seleccionada");
            }
            mForma.setColor(color);
            mForma.setTrazo(trazo);
            mForma.setFill(relleno);
            mForma.setTransparencia(transparencia);
            mForma.setAlisado(alisado);
            mShape.add(mForma);
        }

        punto = evt.getPoint();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if (mover) {
           if (mForma != null) {          
               if (mForma instanceof Linea) {
                    ((Linea)mForma).setLocation(evt.getPoint());
               } else if (mForma instanceof Rectangulo) {
                   ((Rectangulo) mForma).setLocation(evt.getPoint());
               } else if (mForma instanceof Elipse) {
                    ((Elipse)mForma).setLocation(evt.getPoint());
               }else if (mForma instanceof Fantasma){
                    ((Fantasma) mForma).setLocation(punto,evt.getPoint());
                    punto = evt.getPoint();
               }if(modoEdicion != null){
                   Point2D aux = new Point2D.Double(mForma.getX(), mForma.getY());
                   modoEdicion.setLocation(aux);
               }
           }
        }else{
            if(herramienta == Herramienta.Linea)((Linea)mForma).setLine(((Linea)mForma).getP1(), evt.getPoint());
            if(herramienta == Herramienta.Rectangulo)((Rectangulo)mForma).setFrameFromDiagonal(punto,evt.getPoint());
            if(herramienta == Herramienta.Elipse)((Elipse)mForma).setFrameFromDiagonal(punto, evt.getPoint());
            if(herramienta == Herramienta.Fantasma);// ((Fantasma) forma).setFrameFromDiagonal(punto, evt.getPoint());
        }

        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        repaint();
    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
