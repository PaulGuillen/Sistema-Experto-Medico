package personas;
/**
 * Cliente: DNI, nombre, apellidos, dirección y teléfono
 * Mecanico: DNI, nombre apellidos, fecha de contratación y salario
 * 
 */
abstract public class SUPER_Persona {
   public String dni, apeNom;
   private char ss='~';//separador de campos
   public char s=ss;
   public String dato(){
      return "\nCodigo: "+dni+"\tApellidos y Nombres: "+apeNom;
   }
   public String data(){
      return dni+s+apeNom;
   }
}
