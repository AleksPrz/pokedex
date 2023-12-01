import java.util.List;

public class BusquedaBinaria {
    
    /**
     * Busca el objeto Pokemon con el numero de id ingresado y retorna el objeto en si. 
     * La lista debe estar ordenada por numero de pokedex
     * @param lista lista donde se buscara
     * @param numero id de pokedex
     * @return objeto Pokemon encontrado; null si no existe en la lista
     */
    public static Pokemon busquedaBinaria(List<Pokemon> lista, int numero){
        if(lista.isEmpty()) return null;
        
        return busqueda(lista, numero);
    }
    
    /**
     * Busca el objeto Pokemon con el nombre dado y retorna el objeto en si. 
     * La lista debe estar ordenada por nombre
     * @param lista lista donde se buscara
     * @param nombre nombre del pokemon a buscar
     * @return objeto Pokemon encontrado; null si no existe en la lista
     */
    public static Pokemon busquedaBinaria(List<Pokemon> lista, String nombre){
        if(lista.isEmpty()) return null;
        
        return busqueda(lista, nombre);
    }
    
    private static Pokemon busqueda(List<Pokemon> lista, int numero){
        int inicio = 0;
        int fin = lista.size() -1;
        while (inicio <= fin){
            int centro = (inicio + fin) / 2;
            int actual = lista.get(centro).getId();
            if(actual == numero){
                return lista.get(centro);
            }
            else if(actual > numero){
                fin = centro - 1;
            }
            else{
                inicio = centro + 1;
            }
        }
        return null;
    }
    
    private static Pokemon busqueda(List<Pokemon> lista, String nombre){
        int inicio = 0;
        int fin = lista.size() -1;
        while (inicio <= fin){
            int centro = (inicio + fin) / 2;
            String actual = lista.get(centro).getNombre();
            if(actual.compareToIgnoreCase(nombre) == 0){
                return lista.get(centro);
            }
            else if(actual.compareToIgnoreCase(nombre) > 0){
                fin = centro - 1;
            }
            else{
                inicio = centro + 1;
            }
        }
        return null;
    }
}
