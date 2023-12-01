import java.util.List;

/**
 * Esta clase contiene dos variaciones del metodo quick sort: una para ordenar por nombre y otra para 
 * ordenar con cualquier atributo
 * Se modifico el metodo original anadiendo una variable condicional para ordenar ya sea de forma ascendente o descendente
 * @author Alex
 */
public class QuickSort {
    
    /**
     * Ordena la lista segun el atributo dado de forma ascendente
     * @param lista lista a ordenar
     * @param atributo indica si se ordena por estadistica, id o nombre
     * @return la lista ordenada
     */
    public static List<Pokemon> quickSort(List<Pokemon> lista, String atributo) {
        if(lista.size() <= 1) return lista;
        
        String orden = "ascendente";
        if(atributo.equalsIgnoreCase("name"))
            return quickSortNombre(lista, 0, lista.size() - 1, orden);
        else
            return quickSort(lista, 0, lista.size() - 1, atributo, orden);
    }
    
    /**
     * Ordena la lista segun el tipo de orden que proporciona el parametro orden
     * @param lista lista a ordenar
     * @param atributo indica si se ordena por estadistica, id o nombre
     * @param orden indica si se ordena de forma ascendente o descendente
     * @return la lista ordenada
     */
    public static List<Pokemon> quickSort(List<Pokemon> lista, String atributo, String orden) {
        if(lista.size() <= 1) return lista;
        //Verificar que el parametro orden sea correcto
        if(!orden.equals("ascendente") && !orden.equals("descendente"))
            orden = "ascendente";
        
        if(atributo.equals("name"))
            return quickSortNombre(lista, 0, lista.size() - 1, orden);
        else
            return quickSort(lista, 0, lista.size() - 1, atributo, orden);
    }
    
    //Ordena la lista en base al atributo elegido
    private static List<Pokemon> quickSort(List<Pokemon> lista, int primero, int ultimo, String atributo, String orden) {
        int i, j, central;
        double pivote;
        central = (primero + ultimo) / 2;
        pivote = lista.get(central).get(atributo);
        i = primero;
        j = ultimo;
        do {
            switch(orden){
                case "ascendente":
                    while (lista.get(i).get (atributo) < pivote) {
                        i++;
                    }
                    while (lista.get(j).get(atributo) > pivote)
                        j--;
                    break;
                case "descendente":
                    while (lista.get(i).get(atributo) > pivote) {
                        i++;
                    }
                    while (lista.get(j).get(atributo) < pivote)
                        j--;
                    break;
            }
            if (i <= j) {
                Pokemon aux = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, aux);
                i++;
                j--;
            }
        } while (i <= j);

        if (primero < j)
            quickSort(lista, primero, j, atributo, orden);
        if (i < ultimo) 
            quickSort(lista, i, ultimo, atributo, orden);

        return lista;
    }
    
    //Ordena la lista en base al orden alfabetico de los nombres de los Pokemon
    //Funciona exactamente igual al quickSort normal, lo unico que cambia es el uso de 'String.compareTo'
    private static List<Pokemon> quickSortNombre(List<Pokemon> lista, int primero, int ultimo, String orden) {
        int i, j, central;
        String pivote;
        central = (primero + ultimo) / 2;
        pivote = lista.get(central).getNombre();
        i = primero;
        j = ultimo;
        do {
            switch(orden){
                case "ascendente":
                    while (lista.get(i).getNombre().compareTo(pivote) < 0) //Si i es menor alfabeticamente que el pivote
                        i++;
                    while (lista.get(j).getNombre().compareTo(pivote) > 0)
                        j--;
                    break;
                case "descendente": //pivote.compareTo(lista.get(i).getNombre()
                    while (lista.get(i).getNombre().compareTo(pivote) > 0) //Si i es menor alfabeticamente que el pivote
                        i++;
                    while (lista.get(j).getNombre().compareTo(pivote) < 0)
                        j--;
                    break;
            }
            if (i <= j) {
                Pokemon aux = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, aux);
                i++;
                j--;
            }
        } while (i <= j);

        if (primero < j)
            quickSortNombre(lista, primero, j, orden);
        if (i < ultimo) 
            quickSortNombre(lista, i, ultimo, orden);

        return lista;
    }
    
    
}
