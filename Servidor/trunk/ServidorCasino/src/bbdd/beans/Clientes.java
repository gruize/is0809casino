package bbdd.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Clientes generated by hbm2java
 */
public class Clientes  implements java.io.Serializable {


     private int codigo;
     private String nombre;
     private String apellidos;
     private String dni;
     private String usuario;
     private String password;
     private String direccion;
     private Date fechaingreso;
     private String numerocuenta;
     private int recargas;
     private Date fecharecarga;
     private int saldo;
     private String telefono;
     private Set partidases = new HashSet(0);

    public Clientes() {
    }

	
    public Clientes(int codigo, String nombre, String apellidos, String dni, String usuario, String password, String direccion, Date fechaingreso, String numerocuenta, int recargas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.usuario = usuario;
        this.password = password;
        this.direccion = direccion;
        this.fechaingreso = fechaingreso;
        this.numerocuenta = numerocuenta;
        this.recargas = recargas;
    }
    public Clientes(int codigo, String nombre, String apellidos, String dni, String usuario, String password, String direccion, Date fechaingreso, String numerocuenta, int recargas, String telefono, Set partidases) {
       this.codigo = codigo;
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.dni = dni;
       this.usuario = usuario;
       this.password = password;
       this.direccion = direccion;
       this.fechaingreso = fechaingreso;
       this.numerocuenta = numerocuenta;
       this.recargas = recargas;
       this.telefono = telefono;
       this.partidases = partidases;
    }
   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Date getFechaingreso() {
        return this.fechaingreso;
    }
    
    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }
    public String getNumerocuenta() {
        return this.numerocuenta;
    }
    
    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }
    public int getRecargas() {
        return this.recargas;
    }
    
    public void setRecargas(int recargas) {
        this.recargas = recargas;
    }

    public Date getFecharecarga() {
        return fecharecarga;
    }

    public void setFecharecarga(Date fecharecarga) {
        this.fecharecarga = fecharecarga;
    }
    
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Set getPartidases() {
        return this.partidases;
    }
    
    public void setPartidases(Set partidases) {
        this.partidases = partidases;
    }

    /**
     * @return the saldo
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }




}


