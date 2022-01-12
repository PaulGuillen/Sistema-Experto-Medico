package biblioteca.fechas;

public class Prueba4 {
   static void setFecha(java.util.Calendar fecha, String fechaDada){
      int dd=Integer.parseInt(fechaDada.substring(0, 2));
      int mm=Integer.parseInt(fechaDada.substring(3, 5));
      int aa=Integer.parseInt(fechaDada.substring(6));
      fecha.set(aa,mm,dd);
   }
   static String diferenciaFechas(String fec1, String fec2){
      // formato fecha: dd/mm/aaaa o dd.mm.aaa o dd-mm-aaaa
      String diff="";
      java.util.Calendar fecha1, fecha2, aux;
      fecha1 = java.util.Calendar.getInstance();
      fecha2= java.util.Calendar.getInstance();
      setFecha(fecha1,fec1);
      setFecha(fecha2,fec2);
      aux = java.util.Calendar.getInstance();
      aux.setTimeInMillis(fecha1.getTimeInMillis() - fecha2.getTimeInMillis());
      int years=aux.get(java.util.Calendar.YEAR) -1970;
      int meses=aux.get(java.util.Calendar.MONTH);
      int dias=aux.get(java.util.Calendar.DAY_OF_MONTH);
      //if(dias == 31)
      System.out.println("Años: "+years);
      System.out.println("Meses: "+meses);
      System.out.println("dias: "+dias);
      diff="" +(aux.get(java.util.Calendar.YEAR) - 1970) + 
         " Años, " + aux.get(java.util.Calendar.MONTH) + " Meses, "
         + aux.get(java.util.Calendar.DAY_OF_MONTH)+" Dias";
      return diff;
   }
   public static void main(String arg[]){
      System.out.println(diferenciaFechas("01.10.2017","01/11/1966"));
   }
}
