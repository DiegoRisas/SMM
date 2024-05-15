/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.dsv.Imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;


/**
 *
 * @author Diego
 */
public class RojoOp extends BufferedImageOpAdapter{
    private int umbral;
    
    public RojoOp (int umbral){
        this.umbral = umbral;
    }
    
    public BufferedImage filter(BufferedImage src, BufferedImage dest){
        if (src == null) {
            throw new NullPointerException("src image is null");
        }
        if (dest == null) {
         dest = createCompatibleDestImage(src, null);
        }
        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
        int[] pixelComp = new int[srcRaster.getNumBands()];
        int[] pixelCompDest = new int[srcRaster.getNumBands()];

        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                srcRaster.getPixel(x, y, pixelComp);
                
                // Calculamos la diferencia entre el componente rojo y la suma de verde y azul
                int diferencia = pixelComp[0] - (pixelComp[1] + pixelComp[2]);

                // Si la diferencia es mayor que el umbral, consideramos que el píxel es rojo
                if (diferencia > umbral) {
                    // Mantenemos el color original del píxel
                    pixelCompDest[0] = pixelComp[0];
                    pixelCompDest[1] = pixelComp[1];
                    pixelCompDest[2] = pixelComp[2];
                } else {
                    // Convertimos el píxel a nivel de gris (promedio de los tres componentes)
                    int promedio = (pixelComp[0] + pixelComp[1] + pixelComp[2]) / 3;
                    pixelCompDest[0] = promedio;
                    pixelCompDest[1] = promedio;
                    pixelCompDest[2] = promedio;
                }                
                
                destRaster.setPixel(x, y, pixelCompDest);
            }

        }
        return dest;
    }

    
}
