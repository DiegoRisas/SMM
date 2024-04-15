package sm.dsv.graficos;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.RectangularShape;
import java.awt.BasicStroke;
import java.awt.Composite;
import java.awt.RenderingHints;

/**
 * Clase abstracta que representa una figura personalizada en un lienzo gráfico.
 * Esta clase proporciona métodos para establecer atributos como el color,
 * el trazo, la capacidad de relleno, el alisado y la transparencia de la figura,
 * así como un método abstracto para dibujar la figura en un contexto gráfico.
 * @author Diego
 */
public abstract class MiShape extends RectangularShape {
    
    // Atributos
    protected Color color;          // Color de la figura
    protected Stroke trazo;         // Trazo de la figura
    protected boolean fill;         // Indica si la figura debe ser rellena o no
    protected boolean alisado;      // Indica si el alisado está activado o desactivado
    protected boolean transparencia;// Indica si la transparencia está activada o desactivada
    protected Composite composite;
    protected RenderingHints render;

    /**
     * Constructor de la clase MiShape.
     * Inicializa los atributos con valores predeterminados.
     */
    public MiShape() {
        super();
        color = Color.black;                // Color predeterminado: negro
        trazo = new BasicStroke();          // Trazo predeterminado
        fill = false;                       // Sin relleno por defecto
        alisado = false;                    // Sin alisado por defecto
        transparencia = false;              // Sin transparencia por defecto
    }

    /**
     * Establece el color de la figura.
     * @param color Color de la figura.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Establece el trazo de la figura.
     * @param trazo Trazo de la figura.
     */
    public void setTrazo(Stroke trazo) {
        this.trazo = trazo;
    }
    
    /**
     * Establece si la figura debe ser rellena o no.
     * @param fill Indica si la figura debe ser rellena (true) o no (false).
     */
    public void setFill(boolean fill){
        this.fill = fill;
    }

    /**
     * Establece si el alisado está activado o desactivado.
     * @param alisado Indica si el alisado está activado (true) o desactivado (false).
     */
    public void setAlisado(boolean alisado) {
        this.alisado = alisado;
    }

    /**
     * Establece si la transparencia está activada o desactivada.
     * @param transparencia Indica si la transparencia está activada (true) o desactivada (false).
     */
    public void setTransparencia(boolean transparencia) {
        this.transparencia = transparencia;
    }
    
    public void update(){
        if (transparencia) {
            composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
        } else {
            composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
        }

        if (alisado) {
            render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        } else {
            render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        }
    }
    
    /**
     * Método abstracto que debe ser implementado por las subclases para dibujar la figura.
     * @param g2d Contexto gráfico en el que se dibujará la figura.
     */
    public abstract void draw(Graphics2D g2d);
}
