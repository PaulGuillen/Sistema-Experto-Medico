package biblioteca.fechas;

import java.util.Calendar;
import java.util.Scanner;


public class Prueba3 {
   private static Scanner scan;
   private static final String INSTRUCCIONES = "Ingrese la fecha de nacimiento y la fecha a la que desea calcular la diferencia en años, meses y días."
      + "\nSi solo ingresa una fecha, se calculará la diferencia a la fecha actual"
      + "\n Ejemplo: si ingresa '23/01/1987 23/01/2015' obtiene '28 años, 0 meses y 0 días'";
   private static final String PAST = "La fecha de nacimiento es posterior a la actual";
   private static final String SALIDA = "La diferencia es de: %d años, %d meses y %d días. %n";
   private static final String ERROR = "La fecha ingresada no tiene el formato correcto DD/MM/YYYY";
   private static Calendar[] fechasCal;
   private static int anios = 0, meses = 0, dias = 0;

   public static void main(String[] args) {
      System.out.println(INSTRUCCIONES);
      scan = new Scanner(System.in);
      String fechas = scan.nextLine();
      obtenerEdad(fechas);
   }

   private static void obtenerEdad(String fechas) {
      try {
         fechasCal = obtenerFechas(fechas);
         if (fechasCal[0].after(fechasCal[1])) {
            System.out.println(PAST);
         }
         incrementa(Calendar.YEAR);
         incrementa(Calendar.MONTH);
         incrementa(Calendar.DAY_OF_MONTH);
         System.out.printf(SALIDA, anios, meses, dias);
      } catch (Exception e) {
         System.out.println(ERROR);
      }
   }

   private static void incrementa(int periodo) {
      int val = 0;
      while (!fechasCal[0].after(fechasCal[1])) {
         fechasCal[0].add(periodo, 1);
         val++;
      }
      fechasCal[0].add(periodo, -1);
      val--;
      switch (periodo) {
         case Calendar.YEAR:
            anios = val;
            break;
         case Calendar.MONTH:
            meses = val;
            break;
         case Calendar.DAY_OF_MONTH:
            dias = val;
            break;
      }
   }

   private static Calendar[] obtenerFechas(String fechas) {
      Calendar nacimiento = Calendar.getInstance();
      Calendar actual = Calendar.getInstance();
      String fecha[] = fechas.split(" ");
      String born[] = fecha[0].split("/");
      if (fecha.length > 1) {
         String now[] = fecha[1].split("/");
         actual.set(Integer.valueOf(now[2]), Integer.valueOf(now[1]) - 1, Integer.valueOf(now[0]));
      }
      nacimiento.set(Integer.valueOf(born[2]), Integer.valueOf(born[1]) - 1, Integer.valueOf(born[0]));
      Calendar Fecha[] = {nacimiento, actual};
      return Fecha;
   }
}
