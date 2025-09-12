
package practico5.Entidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Cetera Evelyn
 */
public class Directorio {
    
    private static TreeMap<Long, Contacto> mapaContacto = new TreeMap<>();
    //Extra
    public  static Set<String> listaCiudades = new HashSet<>();

    public static TreeMap<Long, Contacto> getMapaContacto() {//Si el atributo es estatico su getter también deberia serlo
        return mapaContacto;
    }

    public void setMapaContacto(TreeMap<Long, Contacto> mapaContacto) {
        Directorio.mapaContacto = mapaContacto;
    }

    
    public static void agregarContacto(Long t, Contacto c){//Permite registrar un nuevo contacto con su repectivo nro.
        mapaContacto.put(t, c);
    }
    
    public static Contacto buscarContacto(Long tel){//En base al nro de telefono retorna el contacto asociado
        return mapaContacto.get(tel);
    }
    
    public static Set<Long> buscarTelefono(String apellido){
        //Que en base a un apellido nos devuelve un Set<Long> con los numeros asociados a la ciudad
        Set<Long> telefonos = new HashSet<>(); //guardamos conjunto de telefonos de cierto apellido 
        Set<Long> claves = mapaContacto.keySet(); //guardamos todos los telefonos 
        Contacto con;
        //Recorremos el set "claves" con iterador para acceder a cada cliente
        Iterator it = claves.iterator();
        while(it.hasNext()){
          long tel = (Long) it.next();
          con = mapaContacto.get(tel); //obtengo el cliente a partir de una llave 
          
          if(con.getApellido().equals(apellido)){
              telefonos.add(tel);
          }
        }
        return telefonos;
    }
    
    public static ArrayList<Contacto> buscarContactos(String ciudad){
        //Que en base a una ciudad nos devuelve un ArrayList con los Contactos asociados a la ciudad
        ArrayList<Contacto> contact = new ArrayList<>(); 
        Set<Long> claves = mapaContacto.keySet(); //guardamos todos los telefonos 
        Contacto con;
        //Recorremos el set "claves" con iterador para acceder a cada cliente
        Iterator it = claves.iterator();
        while(it.hasNext()){
          long tel = (Long) it.next();
          con = mapaContacto.get(tel); //obtengo el cliente a partir de una llave 
          
          if(con.getCiudad().equals(ciudad)){
              contact.add(con);
          }
        }
        return contact;
    }
    
    public static void borrarContactos(Long telef){//que en base al número de teléfono elimina el contacto del directorio.
        if(mapaContacto.containsKey(telef)){
            mapaContacto.remove(telef);
        }
    }
    
    //Metodos extras
     public static Set<Long> listarTelefonos(){ //Este metodo me trae los Key del TreeMap y los guarda en un Set para poder utilizarlos en los iFrame
        return mapaContacto.keySet();
    }
    public static Collection<Contacto> listarContactos(){ //Lista los contactos
        return mapaContacto.values();
    }
    public static void agregarCiudad(String nombre){
        if(nombre != null && !nombre.isEmpty()){
            listaCiudades.add(nombre);
        }
    }
    public static Set<Long> listarDni(){
        Set<Long> dni = new HashSet<>();
        for(Contacto c: mapaContacto.values()){
            dni.add(c.getDni());
        }
        return dni;
    }
    public  static Contacto buscarDni(Long dni){
        for(Contacto c : listarContactos()){
            if(c.getDni().equals(dni)){
                return c;
            }
        }
        return null;
    }
    public static Long buscarTelPorDni(Long dni){
        for (Map.Entry<Long, Contacto> entry : mapaContacto.entrySet()) {
            Long key = entry.getKey();
            Contacto value = entry.getValue();
            
            if(value.getDni().equals(dni)){
                return key;
            }
        }
        return null;
    }
            
    
    
    
    
}//CIERRE DIRECTORIO
