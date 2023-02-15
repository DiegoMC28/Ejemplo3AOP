/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tutorial.aop;

import tutorial.aop.dao.ClienteDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tutorial.aop.dao.ClienteVIPDAO;

/**
 *
 * @author DIEGO
 */
public class ClasePrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // Leer la configuracion de Spring
        
        AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
        
        // Obtener el bean del contenedor de Spring
        
        ClienteDAO elCliente = contexto.getBean("clienteDAO", ClienteDAO.class);
        ClienteVIPDAO elClienteVip = contexto.getBean("clienteVIPDAO", ClienteVIPDAO.class);
        
         elClienteVip.insertaClienteVIP();
        Cliente cliente = new Cliente("Bartolito", "Especial");
        elCliente.insertaCliente(cliente);
        elCliente.retornaCliente();
       
        //Cerrar el contexto
        contexto.close();
    }
    
}
