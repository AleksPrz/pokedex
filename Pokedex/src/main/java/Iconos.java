import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * Contiene los iconos con las imagenes de los 18 tipos de pokemon. Ademas incluye un Color para cada tipo
 * @author Alex
 */
public class Iconos {
    private static final ImageIcon BUG = new ImageIcon(Iconos.class.getResource("/bug.png"));
    private static final ImageIcon DARK = new ImageIcon(Iconos.class.getResource("/dark.png"));
    private static final ImageIcon DRAGON = new ImageIcon(Iconos.class.getResource("/dragon.png"));
    private static final ImageIcon ELECTRIC = new ImageIcon(Iconos.class.getResource("/electric.png"));
    private static final ImageIcon FAIRY = new ImageIcon(Iconos.class.getResource("/fairy.png"));
    private static final ImageIcon FIRE = new ImageIcon(Iconos.class.getResource("/fire.png"));
    private static final ImageIcon FIGHTING = new ImageIcon(Iconos.class.getResource("/fighting.png"));
    private static final ImageIcon FLYING = new ImageIcon(Iconos.class.getResource("/flying.png"));
    private static final ImageIcon GHOST = new ImageIcon(Iconos.class.getResource("/ghost.png"));
    private static final ImageIcon GRASS = new ImageIcon(Iconos.class.getResource("/grass.png"));
    private static final ImageIcon GROUND = new ImageIcon(Iconos.class.getResource("/ground.png"));
    private static final ImageIcon ICE = new ImageIcon(Iconos.class.getResource("/ice.png"));
    private static final ImageIcon NORMAL = new ImageIcon(Iconos.class.getResource("/normal.png"));
    private static final ImageIcon POISON = new ImageIcon(Iconos.class.getResource("/poison.png"));
    private static final ImageIcon PSYCHIC = new ImageIcon(Iconos.class.getResource("/psychic.png"));
    private static final ImageIcon ROCK = new ImageIcon(Iconos.class.getResource("/rock.png"));
    private static final ImageIcon STEEL = new ImageIcon(Iconos.class.getResource("/steel.png"));
    private static final ImageIcon WATER = new ImageIcon(Iconos.class.getResource("/water.png"));

    public static final ImageIcon MISSINGNO = new ImageIcon(Iconos.class.getResource("/MissingNo.png"));
    public static final ImageIcon POKEBALL = new ImageIcon(Iconos.class.getResource("/pokeball.png"));
    
    /**
     * Retorna el icono que contiene la referencia a la imagen del tipo
     * @param tipo
     * @return objeto ImageIcon
     */
    public static ImageIcon getIcon(String tipo){
        switch(tipo){
            case "bug": return BUG;
            case "dark": return DARK;
            case "dragon": return DRAGON;
            case "electric": return ELECTRIC;
            case "fairy": return FAIRY;
            case "fire": return FIRE;
            case "fighting": return FIGHTING;
            case "flying": return FLYING;
            case "ghost": return GHOST;
            case "grass": return GRASS;
            case "ground": return GROUND;
            case "ice": return ICE;
            case "normal": return NORMAL;
            case "poison": return POISON;
            case "psychic": return PSYCHIC;
            case "rock": return ROCK;
            case "steel": return STEEL;
            case "water": return WATER;
            default: return null;
        }
    }
    
    /**
     * Retorna un color igual al de la imagen del icono
     * @param tipo
     * @return color del tipo del pokemon
     */
    public static Color getColorIcon(String tipo){
        switch(tipo){
            case "bug": return new Color(159,164,36);
            case "dark": return new Color(104,103,103);
            case "dragon": return new Color(84,98,214);
            case "electric": return new Color(240,219,0);
            case "fairy": return new Color(255,177,255);
            case "fire": return new Color(255,97,44);
            case "fighting": return new Color(255,162,2);
            case "flying": return new Color(149,201,255);
            case "ghost": return new Color(110,69,112);
            case "grass": return new Color(107,209,97);
            case "ground": return new Color(197,148,86);
            case "ice": return new Color(66,191,255);
            case "normal": return new Color(153,153,153);
            case "poison": return new Color(153,77,207);
            case "psychic": return new Color(255,99,127);
            case "rock": return new Color(188,184,137);
            case "steel": return new Color(106,174,201);
            case "water": return new Color(41,146,255);
            default: return new Color(204,204,504);
        }
    }
    
    
    
    
}

