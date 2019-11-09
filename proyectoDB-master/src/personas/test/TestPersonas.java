package personas.test;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import personas.dto.PersonaDTO;
import personas.jdbc.PersonaDao;
import personas.jdbc.PersonaDaoJDBC;

public class TestPersonas {
    /**
 * @author Figueras, Galarza, Gutierrez
 * Clase main (principal). Se utiliza para poder llamar . Se realiza un while para
 * poder manejar todas las opciones posibles en este CRUD. AL final al seleccionar
 * la opcion de terminar el ciclo se realiza un break para romper la ejecucion
 * 
 * 
 * @throws SQLException
 * 
 * @version 1.0.1
 */

    public static void main(String[] args) throws SQLException {
        
        /**define la opcion ingresada por el usuario, tipo int */
        int opcion=0;
        
        PersonaDao personaDao= new PersonaDaoJDBC();
        /**objeto del tipo PersonaDAO
         * @see PersonaDao.java
         */
        
        System.out.println("********* Crud Para Base de Datos*********\n"
                    + "*********  Alumnos: Figueras, Galarza, Gutierrez*********\n"
                    + "*********Docente: Rodrigo Marquez*********\n");
        
        while(opcion !=5){
            
            
            /**
             * validando while...
             */
            Scanner sc= new Scanner(System.in);
            System.out.println("Ingrese 1 para crear:");
            System.out.println("Ingrese 2 para actualizar:");
            System.out.println("Ingrese 3 para eliminar:");
            System.out.println("Ingrese 4 para listar: ");
            System.out.println("Ingrese 5 para Salir.");
            opcion=sc.nextInt();
         
            
            if(opcion==1){
                /**
                 * opcion 1, crea un nuevo registro.
                 */
                Scanner sc2= new Scanner(System.in);
                PersonaDTO perPrueba= new PersonaDTO();
                System.out.println("Ingrese nombre");
                String nombre = sc2.nextLine();
                perPrueba.setNombre(nombre);
                System.out.println("Ingrese apellido");
                String apellido=sc2.nextLine();
                perPrueba.setApellido(apellido);
                System.out.println("Ingrese ID del curso(1,2,3)");
                int id_curso=sc2.nextInt();
                perPrueba.getId_curso();
                System.out.println("Ingrese ID del Aula (1,2)");
                int id_aula=sc2.nextInt();
                perPrueba.getId_aula();
                System.out.println("Ingrese ID de la Escuela(1,2)");
                int escuela=sc2.nextInt();
                perPrueba.getEscuela();
                personaDao.insert(perPrueba);
                
            }else if(opcion ==2){
                /**
                 * opcion 2, modifica un registro.
                 * 
                 */
                Scanner sc3= new Scanner(System.in);
                PersonaDTO personaTmp =new PersonaDTO();
                System.out.println("Ingrese el ID a modificar:");
                int id= sc3.nextInt();
                personaTmp.setId_persona(id);
                sc3= new Scanner(System.in);
                System.out.println("Ingrese el nuevo nombre: ");
                String nombre1=sc3.nextLine();
                personaTmp.setNombre(nombre1);
                System.out.println("Ingrese el nuevo apellido: ");
                String apellido1=sc3.nextLine();
                personaTmp.setApellido(apellido1);
                System.out.println("Ingrese el ID del nuevo curso: ");
                int id_curso1=sc3.nextInt();
                personaTmp.setId_curso(id_curso1);
                System.out.println("Ingrese el ID del aula: ");
                int id_aula1=sc3.nextInt();
                personaTmp.setId_aula(id_aula1);
                System.out.println("Ingrese el ID de la escuela: ");
                int id_escuela1=sc3.nextInt();
                personaTmp.setEscuela(id_escuela1);
                personaDao.update(personaTmp);
            }else if(opcion ==3){
                /**
                 * opcion 3 , elimina un registro.
                 */
                Scanner sc4= new Scanner (System.in);
                System.out.println("Ingrese el ID del registro a eliminar: ");
                int borrar = sc.nextInt();
                personaDao.delete(new PersonaDTO(borrar));
            } else if(opcion == 4){
                /**
                 * opcion 4, lista registros.
                 */
            List<PersonaDTO> personas = personaDao.select();
            for (PersonaDTO personaDTO: personas){
                System.out.print(personaDTO);
                System.out.println();
            } 
            }else if(opcion == 5){ 
                System.out.println("Gracias.");
                break;
        }
        }
    }
}

