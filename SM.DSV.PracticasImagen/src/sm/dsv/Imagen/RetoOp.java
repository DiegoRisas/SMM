package sm.dsv.Imagen;


import java.awt.Color;
import java.awt.image.BufferedImage;
import sm.image.BufferedImageOpAdapter;

public class RetoOp extends BufferedImageOpAdapter {
    private Color colorOriginal;
    private Color nuevoColor;
    private int umbral;

    public RetoOp(Color colorOriginal, Color nuevoColor, int umbral) {
        this.colorOriginal = colorOriginal;
        this.nuevoColor = nuevoColor;
        this.umbral = umbral;
    }

    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if (src == null) {
            throw new NullPointerException("src image is null");
        }
        if (dest == null) {
            dest = createCompatibleDestImage(src, src.getColorModel());
        }

        float[] hsb = new float[3];

        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                int rgb = src.getRGB(x, y);

                // Convertimos el color del píxel de RGB a HSB
                Color.RGBtoHSB((rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, rgb & 0xFF, hsb);

                float Hpx = hsb[0] * 360; //H de 0,1 a 0,360
                float Spx = hsb[1]; //saturacion
                float Bpx = hsb[2]; //brillo
                
                float[] hsbC1 = Color.RGBtoHSB(colorOriginal.getRed(), colorOriginal.getGreen(), colorOriginal.getBlue(), null);
                float[] hsbC2 = Color.RGBtoHSB(nuevoColor.getRed(), nuevoColor.getGreen(), nuevoColor.getBlue(), null);
                
                // Calculamos la distancia entre los tonos
                float distancia = calcularDistanciaTono(Hpx, hsbC1[0]*360);

                // Si la distancia es menor o igual al umbral, cambiamos el tono del píxel
                if (distancia <= umbral) {
                    // Cambiamos el tono del píxel
                    Hpx = hsbC2[0]*360;
                }

                // Convertimos el nuevo color HSB a RGB
                int rgbResultado = Color.HSBtoRGB(Hpx/360, hsb[1], hsb[2]);

                dest.setRGB(x, y, rgbResultado);     
            }
        }
        return dest;
    }

    public static float calcularDistanciaTono(float tono1, float tono2) {
        float distancia = Math.abs(tono1 - tono2);
        if (distancia <= 180) {
            return distancia;
        } else {
            return 360 - distancia;
        }
    }
}
