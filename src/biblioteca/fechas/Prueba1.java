package biblioteca.fechas;


public class Prueba1 {
   static String difHOYaFecha(String fecha){
      // formato fecha: dd/mm/aaaa o dd.mm.aaa o dd-mm-aaaa
      String diff="";
      java.util.Calendar fechaHoy, fechaAntes;
      fechaHoy= java.util.Calendar.getInstance();
      fechaAntes= java.util.Calendar.getInstance();
      int dd=Integer.parseInt(fecha.substring(0, 2));
      int mm=Integer.parseInt(fecha.substring(3, 5));
      int aa=Integer.parseInt(fecha.substring(6));
      fechaAntes.set(aa,mm,dd);
      java.util.Calendar aux = java.util.Calendar.getInstance();
      aux.setTimeInMillis(fechaHoy.getTimeInMillis());
      System.out.println("Fecha de hoy: "+aux.get(java.util.Calendar.YEAR));
      aux.setTimeInMillis(fechaHoy.getTimeInMillis() - fechaAntes.getTimeInMillis());
      
      diff="" +(aux.get(java.util.Calendar.YEAR) - 1970) + 
         " Años, " + aux.get(java.util.Calendar.MONTH) + " Meses, "
         + aux.get(java.util.Calendar.DAY_OF_MONTH)+" Dias";
      return diff;
   }
   public static void main (String []args){
      System.out.println(difHOYaFecha("29.10.1966"));
   }
}
