
package practico5.Entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Cetera Evelyn
 */
public class Directorio {
    
    private TreeMap<Long, Contacto> mapaContacto = new TreeMap<>();

    public TreeMap<Long, Contacto> getMapaContacto() {
        return mapaContacto;
    }

    public void setMapaContacto(TreeMap<Long, Contacto> mapaContacto) {
        this.mapaContacto = mapaContacto;
    }

    
    public void agregarContacto(Long t, Contacto c){
        //Permite registrar un nuevo contacto con su repectivo nro.
        mapaContacto.put(t, c);
    }
    
    public  Contacto buscarContacto(Long tel){
        //En base al nro de telefono retorna el contacto asociado
        return mapaContacto.get(tel);
    }
    
    public Set<Long> buscarTelefono(String apellido){
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
    
    public ArrayList<Contacto> buscarContactos(String ciudad){
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
    
    public void borrarContactos(Long telef){
        //que en base al número de teléfono elimina el contacto del directorio.
        if(mapaContacto.containsKey(telef)){
            mapaContacto.remove(telef);
        }
    }
    
    
}//CIERRE DIRECTORIO
