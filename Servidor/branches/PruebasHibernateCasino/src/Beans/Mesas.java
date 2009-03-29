package Beans;
// Generated 09-mar-2009 10:54:47 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Mesas generated by hbm2java
 */
public class Mesas  implements java.io.Serializable {


     private int codigo;
     private Salas salas;
     private int puestos;
     private int jugadores;
     private double apuestamin;
     private double apuestamax;
     private Set partidases = new HashSet(0);

    public Mesas() {
    }

	
    public Mesas(int codigo, Salas salas, int puestos, int jugadores, double apuestamin, double apuestamax) {
        this.codigo = codigo;
        this.salas = salas;
        this.puestos = puestos;
        this.jugadores = jugadores;
        this.apuestamin = apuestamin;
        this.apuestamax = apuestamax;
    }
    public Mesas(int codigo, Salas salas, int puestos, int jugadores, double apuestamin, double apuestamax, Set partidases) {
       this.codigo = codigo;
       this.salas = salas;
       this.puestos = puestos;
       this.jugadores = jugadores;
       this.apuestamin = apuestamin;
       this.apuestamax = apuestamax;
       this.partidases = partidases;
    }
   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Salas getSalas() {
        return this.salas;
    }
    
    public void setSalas(Salas salas) {
        this.salas = salas;
    }
    public int getPuestos() {
        return this.puestos;
    }
    
    public void setPuestos(int puestos) {
        this.puestos = puestos;
    }
    public int getJugadores() {
        return this.jugadores;
    }
    
    public void setJugadores(int jugadores) {
        this.jugadores = jugadores;
    }
    public double getApuestamin() {
        return this.apuestamin;
    }
    
    public void setApuestamin(double apuestamin) {
        this.apuestamin = apuestamin;
    }
    public double getApuestamax() {
        return this.apuestamax;
    }
    
    public void setApuestamax(double apuestamax) {
        this.apuestamax = apuestamax;
    }
    public Set getPartidases() {
        return this.partidases;
    }
    
    public void setPartidases(Set partidases) {
        this.partidases = partidases;
    }




}


