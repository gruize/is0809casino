package bbdd.beans;
// Generated 09-mar-2009 10:54:47 by Hibernate Tools 3.2.1.GA



import java.util.HashSet;
import java.util.Set;

/**
 * Salas generated by hbm2java
 */
public class Salas  implements java.io.Serializable {


     private int codigo;
     private Juegos juegos;
     private String nombre;
     private Set mesases = new HashSet(0);

    public Salas() {
    }

	
    public Salas(int codigo, Juegos juegos, String nombre) {
        this.codigo = codigo;
        this.juegos = juegos;
        this.nombre = nombre;
    }
    public Salas(int codigo, Juegos juegos, String nombre, Set mesases) {
       this.codigo = codigo;
       this.juegos = juegos;
       this.nombre = nombre;
       this.mesases = mesases;
    }
   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Juegos getJuegos() {
        return this.juegos;
    }
    
    public void setJuegos(Juegos juegos) {
        this.juegos = juegos;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getMesases() {
        return this.mesases;
    }
    
    public void setMesases(Set mesases) {
        this.mesases = mesases;
    }




}


