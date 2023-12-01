/**
 * Contiene la estructura basica para crear objetos pokemon. Incluye todas las estadisticas, asi como el peso y altura
 * @author Alex
 */

public class Pokemon {
    private final int id, ps, ataque, defensa, ataqueEspecial, defensaEspecial, velocidad;
    private final float peso, altura;
    private final String nombre, tipo1, tipo2, urlImagen;
    
    public Pokemon(int id, String nombre, String tipo1, String tipo2,float peso, float altura, int ps, int ataque, int defensa,
                    int ataqueEspecial, int defensaEspecial, int velocidad, String imagen){
        this.id = id;
        this.nombre = nombre.toUpperCase();
        this.tipo1 = tipo1;
        
        if("null".equals(tipo2)) this.tipo2 = null;
        else this.tipo2 = tipo2;
        
        this.peso = peso;
        this.altura = altura;
        this.ps = ps;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.urlImagen = imagen;
    }
    
    public int get(String atributo){
        switch(atributo){
            case "id": return id;
            case "hp": return ps;
            case "attack": return ataque;
            case "defense": return defensa;
            case "sp. attack": return ataqueEspecial;
            case "sp. defense": return defensaEspecial;
            case "speed": return velocidad;
            default: return id;      
        } 
    }
    public int getId() {
        return id;
    }

    public int getPs() {
        return ps;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo1() {
        return tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public String getUrlImagen() {
        return urlImagen;
    }
    /**
     * Se utiliza para ingresar los datos del pokemon en la tabla de ordenamiento
     * @return id, nombre y todas las estadisticas
     */
    public String[] getDatos(){
        String datos[] = {String.valueOf(id), nombre, String.valueOf(ps), String.valueOf(ataque),String.valueOf(defensa),
        String.valueOf(ataqueEspecial), String.valueOf(defensaEspecial), String.valueOf(velocidad)};
        return datos;
    }
    
    public String imprimirDatos(){
        return String.format("%d %s %s %s ",id, nombre,tipo1,tipo2);
    }
}
