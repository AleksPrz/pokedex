import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * Clase Runnable que utiliza la url de la imagen del pokemon para hacer la busqueda en linea y poner la imagen recibida
 * como icono al Jlabel ingresado en el constructor
 */
public class DescargaImagen implements Runnable {

    private final String stringUrl;
    private final JLabel label;
    
    public DescargaImagen(String url, JLabel label){
        this.stringUrl = url;
        this.label = label;
    }
    
    @Override
    /**
     * Inicia la conexion con la url del pokemon y actualiza el Jlabel con la imagen obtenida.
     */
    public void run() {
        try {
            URL url = new URL(stringUrl);
            Image imagen = ImageIO.read(url).getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(imagen));
        } catch (MalformedURLException ex) {
            Logger.getLogger(DescargaImagen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DescargaImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
