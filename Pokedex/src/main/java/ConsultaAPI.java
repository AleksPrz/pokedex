import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConsultaAPI {

    public static void main(String[] args) {
        File archivo = new File("listaPokemon.csv");
        if(archivo.exists()){
            System.out.println("El archivo csv ya existe");
            System.exit(0);
        }
        try {
            //INICIAR CONEXION CON LA POKEAPI
            URL pokeApi = new URL("https://pokeapi.co/api/v2/pokemon/?limit=1017");
            HttpURLConnection conn = (HttpURLConnection) pokeApi.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Revisar si la peticion fue correcta
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException();
            } else { //En caso de exito

//Guardar la informacion recibida
                StringBuilder informacion = new StringBuilder();
                Scanner lector = new Scanner(pokeApi.openStream());
                while (lector.hasNext()) {
                    informacion.append(lector.nextLine());
                }
                lector.close();

                //*La pokeAPI devuelve un objeto, dentro de ese objeto, una llave devuelve un arreglo con todos los pokemon*
                //Crear un JSONArray en base a ese arreglo que devuelve la pokeAPI
                JSONArray listaPokemon = new JSONArray((new JSONObject(informacion.toString())).get("results").toString());

                //*Cada elemento del arreglo se compone de: nombre, url*
                //ITERAR POR CADA POKEMON EN LA LISTA DE TODOS LOS POKEMON
                try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))){
                    writer.write("id,nombre,tipo1,tipo2,peso,altura,hp,at,def,spa,spdf,spd,imagen\n");
                    for (Object objeto : listaPokemon) {
                        //Iniciar conexion con la url que devuelve los datos
                        URL pokeInfo = new URL((new JSONObject(((JSONObject) objeto).toString())).get("url").toString());
                        HttpURLConnection conn2 = (HttpURLConnection) pokeInfo.openConnection();
                        conn2.setRequestMethod("GET");
                        conn2.connect();

                        //Revisar si la peticion fue correcta
                        if (conn2.getResponseCode() != 200) {
                            throw new RuntimeException();
                        } else {
                            //Guardar la nueva informacion recibida
                            informacion.setLength(0);
                            lector = new Scanner(pokeInfo.openStream());
                            while (lector.hasNext()) {
                                informacion.append(lector.nextLine());
                            }
                            lector.close();

                            //Crear un JSON object que representa al pokemon
                            JSONObject pokemon = new JSONObject(informacion.toString());

                            //GUARDAR LOS ATRIBUTOS DE LOS POKEMON
                            String id = pokemon.get("id").toString();
                            String nombre = pokemon.get("name").toString();

                            //*Algunos atributos se encuentran dentro de objetos dentro de arreglos dentro del objeto pokemon,
                            //entonces hay que realizar un poco de trabajo extra*
                            JSONArray tipos = new JSONArray(pokemon.get("types").toString());
                            //*La estructura de tipos luce algo asi:
                            // types: [0: {type:{name:   } } ]  *
                            //Se accede al indice 0 del array "tipos", luego al objeto "type" y ahi al valor de la llave "name"
                            String tipo1 = new JSONObject(new JSONObject(tipos.get(0).toString()).get("type").toString()).get("name").toString();

                            //Ahora el segundo tipo para los pokemon que si tienen
                            String tipo2 = "null";
                            if (tipos.length() == 2) {
                                tipo2 = new JSONObject(new JSONObject(tipos.get(1).toString()).get("type").toString()).get("name").toString();
                            }
                            String altura = pokemon.get("height").toString();
                            String peso = pokemon.get("weight").toString();
                            
                            String stats[] = new String[6]; //0:hp, 1:attack, 2:defense, 3:special_attack, 4:special_defense, 5:speed
                            JSONArray statsArr = new JSONArray(pokemon.get("stats").toString());
                            //La estructura de los stats luce algo asi:
                            // stats: [ 0: {base_stat: }...]
                            for (int i = 0; i < 6; i++) {
                                stats[i] = (new JSONObject(statsArr.get(i).toString())).get("base_stat").toString();
                            }
                            //La estructura de sprites luce algo asi:
                            //sprites: {other:{ official-artwork:{front_default: } } }
                            String imagen = new JSONObject(new JSONObject((new JSONObject(pokemon.get("sprites").toString())).get("other").toString()).get("official-artwork").toString()).get("front_default").toString();

                            StringBuilder fila = new StringBuilder();
                            fila.append(String.format("%s,%s,%s,%s,%s,%s,", id, nombre, tipo1, tipo2,peso,altura));

                            for (int i = 0; i < 6; i++) {
                                fila.append(stats[i] + ",");
                            }
                            fila.append(imagen + "\n");

                            //ESCRIBE LOS ATRIBUTOS EN EL ARCHIVO CSV
                            writer.write(fila.toString());
                            System.out.print(fila);
                        }
                    }
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConsultaAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConsultaAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }
}
