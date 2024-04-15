package sm.dsv.graficos;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Clase que representa una línea en un espacio bidimensional.
 * Esta clase extiende la clase abstracta MiShape y define métodos para trabajar con líneas.
 * @author Diego
 */
public class Linea extends MiShape {

    /** La línea representada por esta instancia */
    private Line2D line;

    /**
     * Constructor predeterminado que crea una línea vacía.
     */
    public Linea() {
        line = new Line2D.Float();
    }

    /**
     * Constructor que crea una línea con las coordenadas especificadas.
     * @param x1 La coordenada x del primer punto.
     * @param y1 La coordenada y del primer punto.
     * @param x2 La coordenada x del segundo punto.
     * @param y2 La coordenada y del segundo punto.
     */
    public Linea(float x1, float y1, float x2, float y2) {
        line = new Line2D.Float(x1, y1, x2, y2);
    }

    /**
     * Constructor que crea una línea con los puntos especificados.
     * @param p1 El primer punto.
     * @param p2 El segundo punto.
     */
    public Linea(Point2D p1, Point2D p2) {
        line = new Line2D.Float(p1, p2);
    }

    /**
     * Devuelve la línea representada por esta instancia.
     * @return La línea.
     */
    public Line2D getLine() {
        return line;
    }

    /**
     * Establece la línea representada por esta instancia.
     * @param line La línea a establecer.
     */
    public void setLine(Line2D line) {
        this.line = line;
    }
    
    /**
     * Establece la línea con los puntos especificados.
     * @param p1 El primer punto.
     * @param p2 El segundo punto.
     */
    public void setLine(Point2D p1, Point2D p2){
        this.line.setLine(p1, p2);
    }
    
    /**
     * Establece la posición de la línea moviendo ambos puntos.
     * @param pos La nueva posición de la línea.
     */
    public void setLocation(Point2D pos){
        double dx=pos.getX()-line.getX1();
        double dy=pos.getY()-line.getY1();
        Point2D newp2 = new Point2D.Double(line.getX2()+dx,line.getY2()+dy);
        line.setLine(pos,newp2);
    }
    
    /**
     * Verifica si un punto está cerca de la línea.
     * @param p El punto a verificar.
     * @return true si el punto está cerca de la línea, false en caso contrario.
     */
    public boolean isNear(Point2D p){
        if(line.getP1().equals(line.getP2())) return line.getP1().distance(p)<=2.0; //p1=p2
        return line.ptLineDist(p)<=2.0; // p1!=p2
    }
    
    /**
     * Verifica si un punto está contenido dentro de la línea.
     * @param p El punto a verificar.
     * @return true si el punto está contenido dentro de la línea, false en caso contrario.
     */
    @Override
    public boolean contains(Point2D p) {
        return isNear(p);
    } 
     
    /**
     * Dibuja la línea en el contexto gráfico especificado.
     * @param g2d El contexto gráfico en el que se dibuja la línea.
     */
    @Override
    public void draw(Graphics2D g2d) {
        this.update();
        
        g2d.setRenderingHints(render);
        g2d.setComposite(composite);
        g2d.setStroke(trazo);
        g2d.setColor(color);

        g2d.draw(line);
    }

    /**
     * Devuelve el primer punto de la línea.
     * @return El primer punto de la línea.
     */
    public Point2D getP1(){
        Point2D p =  new Point2D.Float((float)line.getX1(),(float)line.getY1());
        return p;
    }
    
    // Métodos heredados de la clase abstracta MiShape
    // Implementados como lanzadores de excepción UnsupportedOperationException
    // debido a que no son aplicables para una línea, ya que no tiene dimensiones
    
    @Override
    public double getX() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double getY() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double getWidth() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double getHeight() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setFrame(double x, double y, double w, double h) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Rectangle2D getBounds2D() {
        return line.getBounds2D();
    }

    @Override
    public boolean contains(double x, double y) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return line.getPathIterator(at);
    }
}
