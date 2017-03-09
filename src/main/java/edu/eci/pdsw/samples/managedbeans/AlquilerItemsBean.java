/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;

import edu.eci.pdsw.samples.services.ServiciosAlquilerItemsStub;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author 2106913
 */
@ManagedBean(name = "AlquilerItems")
@SessionScoped
public class AlquilerItemsBean implements Serializable {
    
    private Cliente cliente;
    private final Date fechaActual = java.sql.Date.valueOf(LocalDate.now());
    private int codigo;
    private int dias;
    private long costoAlquiler;
    private boolean conditionFlag = true;

    private String nombre;
    private long documento;
    private String telefono;
    private String direccion;
    private String email;
    
    
    ServiciosAlquiler sp = ServiciosAlquiler.getInstance();
    
    public AlquilerItemsBean() {

        
    }
    
    public void agregar() throws ExcepcionServiciosAlquiler{
        sp.registrarCliente(new Cliente(getNombre(), getDocumento(), getTelefono(), getDireccion(), getEmail()));
        System.out.println("test"+sp.consultarCliente(getDocumento()));
    }

    public Cliente getCliente() {
        return cliente;
    }
    

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public ServiciosAlquiler getSp() {
        return sp;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
    
    public void agregarAlquiler(){
        try {
            sp.registrarAlquilerCliente(fechaActual, cliente.getDocumento(), sp.consultarItem(codigo), dias);
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", ex.getMessage()));
        }
    }

    public long getCostoAlquiler(){
        return costoAlquiler;
    }

    public void calcularCostoAlquiler() {
        try {
            this.costoAlquiler = sp.consultarCostoAlquiler(codigo, dias);
            conditionFlag = true;
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", ex.getMessage()));
            conditionFlag = false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isConditionFlag() {
        return conditionFlag;
    }

    
}
