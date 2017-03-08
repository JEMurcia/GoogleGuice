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
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;
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
    private final Date fechaActual = new Date();
    private int codigo;
    private int dias;
    private long costoAlquiler;
    
    ServiciosAlquiler sp = ServiciosAlquiler.getInstance();
    
    public AlquilerItemsBean() {
    }

    public Cliente getCliente() throws ExcepcionServiciosAlquiler {
        return sp.consultarCliente(3842);
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
    
    public void AgregarAlquiler() throws ExcepcionServiciosAlquiler{
        sp.registrarAlquilerCliente(java.sql.Date.valueOf(fechaActual.toLocaleString()), cliente.getDocumento(), sp.consultarItem(codigo), dias);
    }

    public long getCostoAlquiler() throws ExcepcionServiciosAlquiler {
        return costoAlquiler;
    }

    public void calcularCostoAlquiler() throws ExcepcionServiciosAlquiler {
        Item i1=new Item(sp.consultarTipoItem(1), 300, "Los 4 Fantasticos", "Los 4 Fantásticos  es una película de superhéroes  basada en la serie de cómic homónima de Marvel.", java.sql.Date.valueOf("2005-06-08"), 2000, "DVD", "Ciencia Ficcion");
        sp.registrarItem(i1);
        this.costoAlquiler = sp.consultarCostoAlquiler(codigo, dias);
    }
    
}
