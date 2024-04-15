package sm.dsv.graficos;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;


/**
 * Clase que representa un objeto de tipo Fantasma.
 * @author Diego
 */
public class Fantasma extends MiShape {

    private ArrayList<Shape> componentes;
    private Point2D punto;

    
    /**
     * Constructor por defecto que inicializa un Fantasma con valores predeterminados.
     */
    public Fantasma() {
        componentes = new ArrayList<>();
        float x = 50,  y = 50,  width = 50,  height = 50;
        punto = new Point2D.Float(x, y);
        Arc2D.Float cabeza = new Arc2D.Float(x, y, width, height, 0, 180, Arc2D.CHORD);

        Ellipse2D.Float ojoI = new Ellipse2D.Float((float) (x + 0.25*width),(float) (y + 0.25*height), 10, 10);
        Ellipse2D.Float ojoD = new Ellipse2D.Float((float) (x + 0.6*width),(float) (y + 0.25*height), 10, 10);

        Rectangle2D.Float cuerpo = new Rectangle2D.Float(x, y + height / 2, width, height / 2);

        // Picadura del cuerpo del fantasma
        Path2D.Float picos = new Path2D.Float();
        picos.moveTo(x, y + height);
        picos.lineTo(x + width / 8, y + height * 3 / 4);
        picos.lineTo(x + width * 2 / 8, y + height);
        picos.lineTo(x + width * 3 / 8, y + height * 3 / 4);
        picos.lineTo(x + width * 4 / 8, y + height);
        picos.lineTo(x + width * 5 / 8, y + height * 3 / 4);
        picos.lineTo(x + width * 6 / 8, y + height);
        picos.lineTo(x + width * 7 / 8, y + height * 3 / 4);
        picos.lineTo(x + width, y + height);
        picos.closePath();

        componentes.add(cabeza);
        componentes.add(cuerpo);
        componentes.add(picos);
        componentes.add(ojoI);
        componentes.add(ojoD);
    }

    /**
     * Constructor que inicializa un Fantasma con componentes dados.
     * @param componentes Lista de componentes del fantasma.
     */   
    public Fantasma(ArrayList<Shape> componentes) {
        this.componentes = componentes;
    }
  
    /**
     * Constructor que inicializa un Fantasma con coordenadas y dimensiones dadas.
     * @param x Coordenada x del punto de referencia del fantasma.
     * @param y Coordenada y del punto de referencia del fantasma.
     * @param width Ancho del fantasma.
     * @param height Altura del fantasma.
     */
    public Fantasma(float x, float y, float width, float height){
        componentes = new ArrayList<>();
        punto = new Point2D.Float(x, y);

        Arc2D.Float cabeza = new Arc2D.Float(x, y, width, height, 0, 180, Arc2D.CHORD);

        Ellipse2D.Float ojoI = new Ellipse2D.Float((float) (x + 0.25*width),(float) (y + 0.25*height), 10, 10);
        Ellipse2D.Float ojoD = new Ellipse2D.Float((float) (x + 0.6*width),(float) (y + 0.25*height), 10, 10);

        Rectangle2D.Float cuerpo = new Rectangle2D.Float(x, y + height / 2, width, height / 2);

        // Picadura del cuerpo del fantasma
        Path2D.Float picos = new Path2D.Float();
        picos.moveTo(x, y + height);
        picos.lineTo(x + width / 8, y + height * 3 / 4);
        picos.lineTo(x + width * 2 / 8, y + height);
        picos.lineTo(x + width * 3 / 8, y + height * 3 / 4);
        picos.lineTo(x + width * 4 / 8, y + height);
        picos.lineTo(x + width * 5 / 8, y + height * 3 / 4);
        picos.lineTo(x + width * 6 / 8, y + height);
        picos.lineTo(x + width * 7 / 8, y + height * 3 / 4);
        picos.lineTo(x + width, y + height);
        picos.closePath();

        componentes.add(cabeza);
        componentes.add(cuerpo);
        componentes.add(picos);
        componentes.add(ojoI);
        componentes.add(ojoD);
    }
    
    // Métodos de acceso y modificación de atributos
    public ArrayList<Shape> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<Shape> componentes) {
        this.componentes = componentes;
    }

    public Point2D getPunto() {
        return punto;
    }

    public void setPunto(Point2D punto) {
        this.punto = punto;
    }
    

    /**
     * Ajusta el tamaño del fantasma para enmarcarlo dentro de un rectángulo dado por sus diagonales.
     * @param x1 Coordenada x del primer punto de la diagonal del rectángulo.
     * @param y1 Coordenada y del primer punto de la diagonal del rectángulo.
     * @param x2 Coordenada x del segundo punto de la diagonal del rectángulo.
     * @param y2 Coordenada y del segundo punto de la diagonal del rectángulo.
     */
    @Override
    public void setFrameFromDiagonal(double x1, double y1, double x2, double y2) {
        // Calcular el nuevo rectángulo que contiene la forma
        double minX = Math.min(x1, x2);
        double minY = Math.min(y1, y2);
        double maxX = Math.max(x1, x2);
        double maxY = Math.max(y1, y2);

        double width = maxX - minX;
        double height = maxY - minY;

        // Calcular la escala y la traslación para ajustar todos los componentes del fantasma al nuevo rectángulo
        double scaleX = width / (getBounds2D().getWidth());
        double scaleY = height / (getBounds2D().getHeight());
        double translateX = minX - getBounds2D().getX();
        double translateY = minY - getBounds2D().getY();

        // Aplicar la escala y la traslación a todos los componentes del fantasma
        for (Shape componente : componentes) {
            AffineTransform transform = new AffineTransform();
            transform.translate(translateX, translateY);
            transform.scale(scaleX, scaleY);
            if (componente instanceof Arc2D) {
                Arc2D arc = (Arc2D) componente;
                arc.setFrame(arc.getX() * scaleX + translateX,
                             arc.getY() * scaleY + translateY,
                             arc.getWidth() * scaleX,
                             arc.getHeight() * scaleY);
            } else {
            }
        }
    }

    /**
     * Ajusta el tamaño del fantasma para enmarcarlo dentro de un rectángulo dado por sus diagonales.
     * @param p1 Primer punto de la diagonal del rectángulo.
     * @param p2 Segundo punto de la diagonal del rectángulo.
     */
    @Override
    public void setFrameFromDiagonal(Point2D p1, Point2D p2) {
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();

        setFrameFromDiagonal(x1, y1, x2, y2);
    }
    
    
    /**
     * Devuelve el límite en 2D del fantasma.
     * @return Límite en 2D del fantasma.
     */
    @Override
    public Rectangle2D getBounds2D() {

        Rectangle2D bounds = null;
        for (Shape componente : componentes) {
            if (bounds == null) {
                bounds = componente.getBounds2D();
            } else {
                bounds.add(componente.getBounds2D());
            }
        }
        return bounds;
    }

    /**
     * Comprueba si el punto especificado está dentro del fantasma.
     * @param x Coordenada x del punto a comprobar.
     * @param y Coordenada y del punto a comprobar.
     * @return true si el punto está dentro del fantasma, false en caso contrario.
     */
    @Override
    public boolean contains(double x, double y) {
        for (Shape componente : componentes) {
            if (componente.contains(x, y)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si el punto especificado está dentro del fantasma.
     * @param p Punto a comprobar.
     * @return true si el punto está dentro del fantasma, false en caso contrario.
     */
    @Override
    public boolean contains(Point2D p) {
        return contains(p.getX(), p.getY());
    }

    
    /**
     * Devuelve un iterador de trazado para el fantasma transformado por la matriz de transformación especificada.
     * @param at La matriz de transformación a aplicar al trazado.
     * @return Un objeto PathIterator que proporciona acceso a la secuencia de segmentos de trazado.
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        GeneralPath path = new GeneralPath();
        for (Shape componente : componentes) {
            path.append(componente.getPathIterator(at), true);
        }
        return path.getPathIterator(at);
    }

    /**
     * Devuelve un iterador de trazado para el fantasma transformado por la matriz de transformación especificada y con una precisión de aplanamiento.
     * @param at La matriz de transformación a aplicar al trazado.
     * @param flatness La máxima distancia que puede haber entre el trazado real y su aproximación aplanada.
     * @return Un objeto PathIterator que proporciona acceso a la secuencia de segmentos de trazado.
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        GeneralPath path = new GeneralPath();
        for (Shape componente : componentes) {
            path.append(componente.getPathIterator(at, flatness), true);
        }
        return path.getPathIterator(at, flatness);
    }

    
    /**
     * Establece la nueva ubicación del fantasma mediante la diferencia entre la nueva y la antigua posición.
     * @param antigua La antigua posición del fantasma.
     * @param nueva La nueva posición del fantasma.
     */
    public void setLocation(Point2D antigua,Point2D nueva) {
        double deltaX = nueva.getX() - antigua.getX();
        double deltaY = nueva.getY() - antigua.getY();

        // Mover cada componente del fantasma a la nueva ubicación    
        for (Shape componente : componentes) {
            if (componente instanceof Arc2D) {
                Arc2D arc = (Arc2D) componente;
                arc.setFrame(arc.getX() + deltaX, arc.getY() + deltaY, arc.getWidth(), arc.getHeight());
            } else if (componente instanceof Ellipse2D) {
                Ellipse2D ellipse = (Ellipse2D) componente;
                ellipse.setFrame(ellipse.getX() + deltaX, ellipse.getY() + deltaY, ellipse.getWidth(), ellipse.getHeight());
            } else if (componente instanceof Rectangle2D) {
                Rectangle2D rect = (Rectangle2D) componente;
                rect.setFrame(rect.getX() + deltaX, rect.getY() + deltaY, rect.getWidth(), rect.getHeight());
            } else if (componente instanceof Path2D) {
                Path2D path = (Path2D) componente;
                AffineTransform tx = AffineTransform.getTranslateInstance(deltaX, deltaY);
                path.transform(tx);
            }
        }
    }
    
    /**
     * Establece la nueva ubicación del fantasma mediante la diferencia entre la nueva posición y la posición actual.
     * @param pos La nueva posición del fantasma.
     */
    public void setLocation(Point2D pos) {
        double deltaX = pos.getX() - this.getPunto().getX();
        double deltaY = pos.getY() - this.getPunto().getY();

        // Mover cada componente del fantasma a la nueva ubicación    
        for (Shape componente : componentes) {
            if (componente instanceof Arc2D) {
                Arc2D arc = (Arc2D) componente;
                arc.setFrame(arc.getX() + deltaX, arc.getY() + deltaY, arc.getWidth(), arc.getHeight());
            } else if (componente instanceof Ellipse2D) {
                Ellipse2D ellipse = (Ellipse2D) componente;
                ellipse.setFrame(ellipse.getX() + deltaX, ellipse.getY() + deltaY, ellipse.getWidth(), ellipse.getHeight());
            } else if (componente instanceof Rectangle2D) {
                Rectangle2D rect = (Rectangle2D) componente;
                rect.setFrame(rect.getX() + deltaX, rect.getY() + deltaY, rect.getWidth(), rect.getHeight());
            } else if (componente instanceof Path2D) {
                Path2D path = (Path2D) componente;
                AffineTransform tx = AffineTransform.getTranslateInstance(deltaX, deltaY);
                path.transform(tx);
            }
        }
    }

    /**
     * Dibuja el fantasma en el contexto gráfico especificado.
     * @param g2d El contexto gráfico en el que se dibuja la línea.
     */
    @Override
    public void draw(Graphics2D g2d) {
        this.update();
        
        g2d.setRenderingHints(render);
        g2d.setComposite(composite);
        g2d.setStroke(trazo);
        g2d.setColor(color);
        for(Shape s : componentes) {
     
            if(s instanceof Ellipse2D) {
                // Si la forma es un ojo, rellenar con color blanco
                g2d.setColor(Color.WHITE);
                g2d.fill(s);
                // Restaurar el color original antes de dibujar el borde
                g2d.setColor(super.color);
                g2d.draw(s);
            }else{
                // Para otras formas, aplicar el relleno si es necesario y dibujar el borde
                if(fill && !(s instanceof Ellipse2D)) g2d.fill(s);
                g2d.draw(s);  
            }
        }
    }
    
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
    public Rectangle getBounds() {
        Rectangle bounds = null;
        for (Shape componente : componentes) {
            if (bounds == null) {
                bounds = componente.getBounds();
            } else {
                bounds.add(componente.getBounds());
            }
        }
        return bounds;
    }
    

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean contains(Rectangle2D r) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
