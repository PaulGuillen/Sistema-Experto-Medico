package biblioteca.fechas;

import java.util.Date;

public class Prueba {
   public static void msj(String men){
      javax.swing.JOptionPane.showMessageDialog(null, men);
   }
   
   public static void main(String ar[]){
      Date fecha = new Date();
      String f=fecha.toLocaleString();
      System.out.println ("fecha y hora: "+f);
      System.out.println ("año: "+f.substring(6, 10));
      System.out.println ("mes: "+f.substring(3, 5));
      System.out.println ("dia: "+f.substring(0, 2));
      System.out.println ("hora: "+f.substring(11, 13));
      System.out.println ("min: "+f.substring(14, 16));
      System.out.println ("seg: "+f.substring(17, 19));
      System.out.println ("am/pm: "+f.substring(20));
      //Fecha();
      Fecha FF=new Fecha();
      System.out.println ("Fecha de hoy: "+FF.Fecha(0));
      System.out.println ("Fecha de hoy con día: "+FF.Fecha(1));
      System.out.println ("Año actual: "+FF.anno());
      System.out.println ("Mes literal de Hoy: "+FF.mes(true));
      System.out.println ("Mes numerico de Hoy: "+FF.mes(false));
      System.out.println ("Dia literal de Hoy: "+FF.dia());
      System.out.println ("Dia numerico de hoy: "+FF.dd());
      System.out.println ("Fecha de Mañana: "+FF.FechaManana());
   }
}
