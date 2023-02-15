/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorial.aop.aspectos;

import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import tutorial.aop.Cliente;


/**
 *
 * @author DIEGO
 */
@Aspect
@Component
@Order(2)
public class LoginConAspecto {
    
    
    @Pointcut("execution(public * insertaCliente*(..))")
    public void paraClientes(){}
    
    @Before("paraClientes()") 
    public void antesInsertarCliente(JoinPoint miJoin){
        
        System.out.println("El usuario esta logeado");
        System.out.println("El perfil para insertar clientes es correcto");
        
        
        //miJoin.getArgs(); //Devuelve un array con los argumentos del metodo insertaCliente
        Object[] argumentos = miJoin.getArgs();
        
        for(Object item:argumentos){
            
            if(item instanceof Cliente){
                Cliente cliente = (Cliente) item;
                System.out.println("Nombre: "+cliente.getNombre() + " Tipo: "+cliente.getTipo());
            }
        }
    }
    
    @AfterReturning(pointcut="execution(* tutorial.aop.dao.ClienteDAO.retornaCliente(..))",returning="listaDeClientes")
    public void tareaTrasRetornaClientes(List<Cliente> listaDeClientes){
        
        for(Cliente item: listaDeClientes){
            
            if(item.getTipo() == "Especial"){
                System.out.println("CLIENTE ESPECIAL: "+item.getNombre());
            }
        }
        
    }
    
   
    
}
