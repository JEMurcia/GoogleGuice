/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *Intento de agregar cliente con el atributo vetado =true
 * addItem1: cuando el atributo vetado es igual a true, entonces no se debe permitir agregar a un cliente
 * 
 * El cliente ya se encuentra registrado
 * clienteRegitrado: se invoca el metodo consultarCliente y si ya se encuentra, entonces no se debe agregar 
 * 
 * 
 */
public class ClientesTest {

    public ClientesTest() {
    }
    
    @Before
    public void setUp() {
    }
    
  
    @Test
    public void additems1() throws ExcepcionServiciosAlquiler{
    	
    }
    
    public void addCliente() throws ExcepcionServiciosAlquiler{
        ServiciosAlquiler sa=ServiciosAlquiler.getInstance();
        
        Cliente cl= new Cliente("Juan Perez",3842,"24234","calle 123","aa@gmail.com");
        
        if(sa.consultarCliente(cl.getDocumento())!=null){
            assertEquals("el cliente ya se encuentra registrado", null,sa.consultarCliente(cl.getDocumento()));
        }
    }
    
      
    
    
    
    
    
    
    
}
