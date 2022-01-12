package personas;


abstract public class Persona {
   public String dni, apeNom;
   private char ss='~';//separador de campos
   public char s=ss;
   public String dato(){
      return "DNI: "+dni+"\nApellidos y Nombres: "+apeNom;
   }
   public String data(){
      return dni+s+apeNom;
   }
}
