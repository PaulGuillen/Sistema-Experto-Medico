package pruebas;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class PruebaArchi {
   
   static String dir="C:/Database/Prueba2";
   static String arch="/pruebita.txt";
   
   private static void usaTabla(int cual){
      switch(cual){
         case 1: dir="C:/Database/Prueba1";arch="/pruebita.txt";break;
         case 2: dir="C:/Database/Prueba2";arch="/pruebOta.txt";break;
      }
      File dire = new File( dir );
      if(!dire.exists()){
         dire.mkdirs();
      }
      File a = new File( dir+arch );
      if(!a.exists()){
         creaArch();
      }
   }
   private static void creaArch() {
      FileOutputStream fos = null;
      DataOutputStream out = null;
      try {
         fos = new FileOutputStream(dir+arch);
         out = new DataOutputStream(fos);
         out.writeUTF("");
      } catch (FileNotFoundException ex) {
      } catch (IOException ex) {
      } finally {
         try {
            fos.close();
            out.close();
         } catch (IOException ex) {
         }
      }
   }
   public static void main(String arg[]){
      usaTabla(1);
      
    }
}
