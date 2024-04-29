package sm.dsv.Imagen;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;


/**
 * Clase que representa un objeto de tipo Fantasma.
 * @author Diego
 */
public class Fantasma extends MiShape {

    private Area fantasma;
    private Point2D punto;
    private double height = 50;
    private double width = 50;

    
    /**
     * Constructor por defecto que inicializa un Fantasma con valores predeterminados.
     */
    public Fantasma() {
        float x = 50,  y = 50;
        punto = new Point2D.Float(x, y);

        this.fantasma = createFantasma();

    }

    /**
     * Constructor que inicializa un Fantasma con componentes dados.
     * @param componentes Lista de componentes del fantasma.
     */   
    public Fantasma(Area aux) {
        this.fantasma = aux;
    }
  
    /**
     * Constructor que inicializa un Fantasma con coordenadas y dimensiones dadas.
     * @param x Coordenada x del punto de referencia del fantasma.
     * @param y Coordenada y del punto de referencia del fantasma.
     * @param width Ancho del fantasma.
     * @param height Altura del fantasma.
     */
    public Fantasma(float x, float y, float width, float height){
        this.width = width;
        this.height = height;
        punto = new Point2D.Float(x, y);
        this.fantasma = createFantasma();


    }
    
    private Area createFantasma(){
        Area areaFantasma = new Area();
        // Semicircunferencia superior
        double altoCabeza = height * 0.7;
        Ellipse2D.Double cabeza = new Ellipse2D.Double(punto.getX(), punto.getY(), width, altoCabeza);
        areaFantasma.add(new Area(cabeza));
        
        //Cuerpo
        double parteSuperior = punto.getY() + altoCabeza / 2;
        double parteInferior = punto.getY() + height*1.2;
        
        // Picos
        int numeroPicos = 6;
        double alturaPico = height / 4;
        double anchoPico = width / numeroPicos;
        GeneralPath picos = new GeneralPath();
        picos.moveTo(punto.getX(), parteSuperior);
        for (int i = 0; i < numeroPicos; i++) {
            picos.lineTo(punto.getX() + i * anchoPico, parteInferior);
            picos.lineTo(punto.getX() + (i + 0.5) * anchoPico, parteInferior - alturaPico);
            picos.lineTo(punto.getX() + (i + 1) * anchoPico, parteInferior);
        }
        picos.lineTo(punto.getX() + width, parteSuperior);
        picos.closePath();

        // Agregar los picos al área del fantasma
        areaFantasma.add(new Area(picos));
        
        // Ojos
        
        Ellipse2D.Float ojoI = new Ellipse2D.Float((float) (punto.getX() + 0.25*width),(float) (punto.getY() + 0.25*height), 10, 10);
        Ellipse2D.Float ojoD = new Ellipse2D.Float((float) (punto.getX() + 0.6*width),(float) (punto.getY() + 0.25*height), 10, 10);
        
        /*
        Ellipse2D.Double ojoIzquierdo = new Ellipse2D.Double(punto.getX() + width / 2 - tamanoOjo - espacioEntreOjos, alturaOjo, tamanoOjo, tamanoOjo);
        Ellipse2D.Double ojoDerecho = new Ellipse2D.Double(punto.getX() + width / 2 + espacioEntreOjos, alturaOjo, tamanoOjo, tamanoOjo);
        */
        areaFantasma.subtract(new Area(ojoI));
        areaFantasma.subtract(new Area(ojoD));
        
        return areaFantasma;
    }
    
    
    // Métodos de acceso y modificación de atributos
 
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
        return fantasma.getBounds2D();
    }

    /**
     * Comprueba si el punto especificado está dentro del fantasma.
     * @param x Coordenada x del punto a comprobar.
     * @param y Coordenada y del punto a comprobar.
     * @return true si el punto está dentro del fantasma, false en caso contrario.
     */
    @Override
    public boolean contains(double x, double y) {
        return fantasma.contains(x, y);
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
        return fantasma.getPathIterator(at);
    }

    /**
     * Devuelve un iterador de trazado para el fantasma transformado por la matriz de transformación especificada y con una precisión de aplanamiento.
     * @param at La matriz de transformación a aplicar al trazado.
     * @param flatness La máxima distancia que puede haber entre el trazado real y su aproximación aplanada.
     * @return Un objeto PathIterator que proporciona acceso a la secuencia de segmentos de trazado.
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return fantasma.getPathIterator(at, flatness);
    }

    
    /**
     * Establece la nueva ubicación del fantasma mediante la diferencia entre la nueva y la antigua posición.
     * @param antigua La antigua posición del fantasma.
     * @param nueva La nueva posición del fantasma.
     */
    public void setLocation(Point2D antigua,Point2D nueva) {
        double deltaX = nueva.getX() - antigua.getX();
        double deltaY = nueva.getY() - antigua.getY();

        punto = nueva;
        fantasma.transform(AffineTransform.getTranslateInstance(deltaX, deltaY));
    }
    
    /**
     * Establece la nueva ubicación del fantasma mediante la diferencia entre la nueva posición y la posición actual.
     * @param pos La nueva posición del fantasma.
     */
    public void setLocation(Point2D pos) {
        double deltaX = pos.getX() - punto.getX();
        double deltaY = pos.getY() - punto.getY();
        punto = pos;
        fantasma.transform(AffineTransform.getTranslateInstance(deltaX, deltaY));
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
        
        if(fill) g2d.fill(fantasma);
        
        g2d.draw(fantasma);
    }
    
    @Override
    public double getX() {
        return punto.getX();
    }

    @Override
    public double getY() {
        return punto.getY();
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
        return fantasma.getBounds();
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
