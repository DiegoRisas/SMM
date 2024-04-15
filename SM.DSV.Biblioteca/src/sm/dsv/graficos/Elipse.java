package sm.dsv.graficos;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Clase que representa una elipse. Extiende la clase abstracta MiShape.
 * @author Diego
 */
public class Elipse extends MiShape {

    private Ellipse2D elipse;

    /**
     * Constructor por defecto. Crea una elipse vacía.
     */
    public Elipse() {
        elipse = new Ellipse2D.Float();
    }

    /**
     * Constructor que crea una elipse con las coordenadas y dimensiones
     * especificadas.
     *
     * @param x La coordenada x de la esquina superior izquierda del rectángulo
     * delimitador.
     * @param y La coordenada y de la esquina superior izquierda del rectángulo
     * delimitador.
     * @param w La anchura del rectángulo delimitador.
     * @param h La altura del rectángulo delimitador.
     */
    public Elipse(float x, float y, float w, float h) {
        elipse = new Ellipse2D.Float(x, y, w, h);
    }

    /**
     * Establece la ubicación de la elipse.
     *
     * @param pos La nueva ubicación de la elipse.
     */
    public void setLocation(Point2D pos) {
        // Calcula el desplazamiento del ratón
        double deltaX = pos.getX() - elipse.getX();
        double deltaY = pos.getY() - elipse.getY();
        // Mueve la elipse sumando el desplazamiento a su posición actual
        elipse.setFrame(elipse.getX() + deltaX, elipse.getY() + deltaY, elipse.getWidth(), elipse.getHeight());
    }

    /**
     * Dibuja la elipse en el contexto gráfico especificado.
     *
     * @param g2d El contexto gráfico donde se dibuja la elipse.
     */
    @Override
    public void draw(Graphics2D g2d) {
        this.update();
        
        g2d.setRenderingHints(render);
        g2d.setComposite(composite);
        g2d.setStroke(trazo);
        g2d.setColor(color);
        if (fill) {
            g2d.fill(elipse);
        }

        g2d.draw(elipse);
    }

    // Métodos heredados de la clase Ellipse2D
    /**
     * Obtiene la coordenada x de la esquina superior izquierda del rectángulo
     * delimitador.
     *
     * @return La coordenada x de la esquina superior izquierda del rectángulo
     * delimitador.
     */
    @Override
    public double getX() {
        return elipse.getX();
    }

    /**
     * Obtiene la coordenada y de la esquina superior izquierda del rectángulo
     * delimitador.
     *
     * @return La coordenada y de la esquina superior izquierda del rectángulo
     * delimitador.
     */
    @Override
    public double getY() {
        return elipse.getY();
    }

    /**
     * Obtiene la anchura del rectángulo delimitador.
     *
     * @return La anchura del rectángulo delimitador.
     */
    @Override
    public double getWidth() {
        return elipse.getWidth();
    }

    /**
     * Obtiene la altura del rectángulo delimitador.
     *
     * @return La altura del rectángulo delimitador.
     */
    @Override
    public double getHeight() {
        return elipse.getHeight();
    }

    /**
     * Comprueba si la elipse está vacía.
     *
     * @return true si la elipse está vacía; false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return elipse.isEmpty();
    }

    /**
     * Establece el marco de la elipse a las coordenadas y dimensiones
     * especificadas.
     *
     * @param x La coordenada x de la esquina superior izquierda del rectángulo
     * delimitador.
     * @param y La coordenada y de la esquina superior izquierda del rectángulo
     * delimitador.
     * @param w La anchura del rectángulo delimitador.
     * @param h La altura del rectángulo delimitador.
     */
    @Override
    public void setFrame(double x, double y, double w, double h) {
        elipse.setFrame(x, y, w, h);
    }

    /**
     * Obtiene el rectángulo delimitador de la elipse.
     *
     * @return El rectángulo delimitador de la elipse.
     */
    @Override
    public Rectangle2D getBounds2D() {
        return elipse.getBounds2D();
    }

    /**
     * Comprueba si la elipse contiene el punto especificado.
     *
     * @param x La coordenada x del punto.
     * @param y La coordenada y del punto.
     * @return true si la elipse contiene el punto especificado; false en caso
     * contrario.
     */
    @Override
    public boolean contains(double x, double y) {
        return elipse.contains(x, y);
    }

    /**
     * Comprueba si la elipse intersecta el rectángulo delimitador especificado.
     *
     * @param x La coordenada x de la esquina superior izquierda del rectángulo
     * delimitador.
     * @param y La coordenada y de la esquina superior izquierda del rectángulo
     * delimitador.
     * @param w La anchura del rectángulo delimitador.
     * @param h La altura del rectángulo delimitador.
     * @return true si la elipse intersecta el rectángulo delimitador
     * especificado; false en caso contrario.
     */
    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return elipse.intersects(x, y, w, h);
    }

    /**
     * Comprueba si la elipse contiene completamente el rectángulo delimitador
     * especificado.
     *
     * @param x La coordenada x de la esquina superior izquierda del rectángulo
     * delimitador.
     * @param y La coordenada y de la esquina superior izquierda del rectángulo
     * delimitador.
     * @param w La anchura del rectángulo delimitador.
     * @param h La altura del rectángulo delimitador.
     * @return true si la elipse contiene completamente el rectángulo
     * delimitador especificado; false en caso contrario.
     */
    @Override
    public boolean contains(double x, double y, double w, double h) {
        return elipse.contains(x, y, w, h);
    }

    /**
     * Devuelve un iterador de forma para la elipse.
     *
     * @param at La transformación aplicada a la elipse (si es null, se utiliza
     * la transformación identidad).
     * @return Un iterador de forma para la elipse.
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return elipse.getPathIterator(at);
    }
}
