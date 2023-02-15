/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorial.aop.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import tutorial.aop.Cliente;

/**
 *
 * @author DIEGO
 */
@Component
public class ClienteDAO {
    
 
    public void insertaCliente(Cliente cliente){
        
        System.out.println("Se inserto el cliente correctamente");
        
    }
    
    public List<Cliente> retornaCliente(){
        
        List<Cliente> listaDeClientes = new ArrayList();
        
        listaDeClientes.add(new Cliente("Joce","Normal"));
        listaDeClientes.add(new Cliente("Barto","Especial"));
        listaDeClientes.add(new Cliente("Marquito","Normal"));
        listaDeClientes.add(new Cliente("Ramona","Normal"));
        listaDeClientes.add(new Cliente("Luisiño","Especial"));
        listaDeClientes.add(new Cliente("Octavio","Normal"));
        listaDeClientes.add(new Cliente("Rigoberta","Especial"));
        
        return listaDeClientes;
    }
}
