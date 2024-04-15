package sm.dsv.graficos;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;

/**
 * Esta clase representa un rectángulo en el lienzo.
 * Extiende la clase abstracta MiShape.
 * @author Diego
 */
public class Rectangulo extends MiShape {
    /** El rectángulo representado por esta instancia. */
    private Rectangle2D rectangulo;

    /**
     * Constructor por defecto que inicializa un rectángulo vacío.
     */
    public Rectangulo() {
        rectangulo = new Rectangle2D.Float();
    }

    /**
     * Constructor que inicializa un rectángulo con las coordenadas y dimensiones especificadas.
     * @param x La coordenada x de la esquina superior izquierda del rectángulo.
     * @param y La coordenada y de la esquina superior izquierda del rectángulo.
     * @param w El ancho del rectángulo.
     * @param h La altura del rectángulo.
     */
    public Rectangulo(float x, float y, float w, float h) {
        rectangulo = new Rectangle2D.Float(x, y, w, h);
    }
    
    /**
     * Constructor que inicializa un rectángulo con otro rectángulo dado.
     * @param rectangulo El rectángulo a ser representado por esta instancia.
     */
    public Rectangulo(Rectangle2D rectangulo) {
        this.rectangulo = rectangulo;
    }

    /**
     * Constructor que inicializa un rectángulo con dos puntos dados.
     * @param point El primer punto.
     * @param point0 El segundo punto.
     */
    public Rectangulo(Point point, Point point0) {
        rectangulo = new Rectangle2D.Float((float) point.getX(), (float) point.getY(), (float) point0.getX(), (float) point0.getY());
    }

    /**
     * Dibuja el rectángulo en el contexto gráfico especificado.
     * @param g2d El contexto gráfico en el que se dibujará el rectángulo.
     */
    @Override
    public void draw(Graphics2D g2d) {
        this.update();
        
        g2d.setRenderingHints(render);
        g2d.setComposite(composite);
        g2d.setStroke(trazo);
        g2d.setColor(color);
        
        if (fill) {
            g2d.fill(rectangulo);
        }
        
        g2d.draw(rectangulo);
    }

    /**
     * Establece la posición del rectángulo.
     * @param point El punto al que se moverá la esquina superior izquierda del rectángulo.
     */
    public void setLocation(Point point) {
        double deltaX = point.getX() - rectangulo.getX();
        double deltaY = point.getY() - rectangulo.getY();
        rectangulo.setFrame(rectangulo.getX() + deltaX, rectangulo.getY() + deltaY, rectangulo.getWidth(), rectangulo.getHeight());
    }

    // Métodos heredados de la clase Rectangle2D

    @Override
    public double getX() {
        return rectangulo.getX();
    }

    @Override
    public double getY() {
        return rectangulo.getY();
    }

    @Override
    public double getWidth() {
        return rectangulo.getWidth();
    }

    @Override
    public double getHeight() {
        return rectangulo.getHeight();
    }

    @Override
    public boolean isEmpty() {
        return rectangulo.isEmpty();
    }

    @Override
    public void setFrame(double x, double y, double w, double h) {
        rectangulo.setFrame(x, y, w, h);
    }

    @Override
    public Rectangle2D getBounds2D() {
        return rectangulo.getBounds2D();
    }

    @Override
    public boolean contains(double x, double y) {
        return rectangulo.contains(x, y);
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return rectangulo.contains(x, y, w, h);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
