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
public class PosterizarOP extends BufferedImageOpAdapter{
    private int niveles;
    
    public PosterizarOP (int niveles){
        this.niveles = niveles;
    }
    
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if (src == null) {
            throw new NullPointerException("src image is null");
        }
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }
        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
        int sample;
        
        
        float K = 256.0f/niveles;
        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                for (int band = 0; band < srcRaster.getNumBands(); band++){
                    sample = srcRaster.getSample(x, y, band);
                    int posterizado = (int)K * (int)(sample / K);
                    destRaster.setSample(x, y, band, posterizado);
                }
            }
        }
        return dest;
    } 
    
}
