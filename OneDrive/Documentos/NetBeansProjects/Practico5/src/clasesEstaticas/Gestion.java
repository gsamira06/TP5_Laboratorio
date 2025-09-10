
package clasesEstaticas;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import practico5.Entidades.Ciudad;
import practico5.Entidades.Contacto;
import practico5.Entidades.Directorio;

/**
 *
 * @author Grupo 2
 */
public class Gestion {
    private static final Directorio directorio = new Directorio();
    private static final Set<Ciudad> listaCiudad = new HashSet<>();
    
    //CONTACTOS 
    public static void agregarContacto(Long telefono, Contacto c) {
        directorio.agregarContacto(telefono, c);
    }
    
    public static Contacto buscarContacto(Long telefono) {
        return directorio.buscarContacto(telefono);
    }

    public static Set<Long> listarTelefonos(){ //Este metodo me trae los Key del TreeMap y los guarda en un Set para poder utilizarlos en los iFrame
        return directorio.getMapaContacto().keySet();
    }
    
    public static void borrarContacto(Long telefono) {
        directorio.borrarContactos(telefono);
    }
    
    public static Collection<Contacto> listarContactos(){ //Para usarlo en otros metodos
        return directorio.getMapaContacto().values();
    }
    //CIUDADES 
    
    public static void agregarCiudad(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            listaCiudad.add(new Ciudad(nombre));
        }
    }

    public static Set<Ciudad> listarCiudades() {
        return new HashSet<>(listaCiudad);
    }
    
    public static Set<Long> listarDni(){//listamos los dnis para despues usarlo en las vistas
        Set<Long> dni = new HashSet<>();
        for (Contacto c : directorio.getMapaContacto().values()) {
            dni.add(c.getDni());
        }
        return dni;
    }
  
    public static Contacto buscarDni(Long dni){
        for (Contacto c : listarContactos()) {
            if(c.getDni().equals(dni)){
                return c;
            }
        }
        return null;
    }
    public static Long buscarTelefonoPorDni(long dni) {
    for (Map.Entry<Long,Contacto> entry 
            : directorio.getMapaContacto().entrySet()) {
        if (entry.getValue().getDni() == dni) {
            return entry.getKey();
        }
    }
    return null;
}

    
}
