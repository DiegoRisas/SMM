package sm.dsv.Imagen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Diego
 */
public class ModoEdicion extends MiShape {
    
    private Elipse elipseEdicion;
    private static final int radio = 10;
    private static final Stroke stroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, new float[]{5}, 0);
    private static final Color color = Color.RED;
    
    private Point2D location;

    public ModoEdicion(Point2D location) {
        this.location = location;
        this.elipseEdicion = new Elipse(location.getX(), location.getY(), radio);

    }
        
    @Override
    public void draw(Graphics2D g2d) {
        if (elipseEdicion != null) {
            g2d.setColor(color);
            g2d.setStroke(stroke);
            g2d.draw(elipseEdicion);
        }
    }

    public void setLocation(Point2D pos) {
        // Calcula el desplazamiento del ratón
        double deltaX = pos.getX() - elipseEdicion.getX()-radio;
        double deltaY = pos.getY() - elipseEdicion.getY()-radio;
        // Mueve la elipse sumando el desplazamiento a su posición actual
        elipseEdicion.setFrame(elipseEdicion.getX() + deltaX, elipseEdicion.getY() + deltaY, elipseEdicion.getWidth(), elipseEdicion.getHeight());
    }
    
    @Override
    public double getX() {
        if (elipseEdicion != null) {
            return elipseEdicion.getX();
        }
        return 0;
    }

    @Override
    public double getY() {
        if (elipseEdicion != null) {
            return elipseEdicion.getY();
        }
        return 0;
    }

    @Override
    public double getWidth() {
        if (elipseEdicion != null) {
            return elipseEdicion.getWidth();
        }
        return 0;
    }

    @Override
    public double getHeight() {
        if (elipseEdicion != null) {
            return elipseEdicion.getHeight();
        }
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return elipseEdicion == null || elipseEdicion.isEmpty();
    }

    @Override
    public void setFrame(double x, double y, double w, double h) {
        if (elipseEdicion == null) {
            elipseEdicion = new Elipse((float)x, (float)y,(float)w, (float)h);
        } else {
            elipseEdicion.setFrame(x, y, w, h);
        }
    }

    @Override
    public Rectangle2D getBounds2D() {
        if (elipseEdicion != null) {
            return elipseEdicion.getBounds2D();
        }
        return null;
    }

    @Override
    public boolean contains(double x, double y) {
        if (elipseEdicion != null) {
            return elipseEdicion.contains(x, y);
        }
        return false;
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        if (elipseEdicion != null) {
            return elipseEdicion.intersects(x, y, w, h);
        }
        return false;
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        if (elipseEdicion != null) {
            return elipseEdicion.contains(x, y, w, h);
        }
        return false;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        if (elipseEdicion != null) {
            return elipseEdicion.getPathIterator(at);
        }
        return null;
    }
    
}
