package biblioteca.fechas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;

/**
 * Clase Fecha: Manejo de dias, meses, años, horas, minutos
 */
public class Fecha {
   public String fecha;
   String dd,mm,aa;
   String hora,min,seg;
   String distrito="Lima";
   Fecha(String dd,String mm,String aa){
      this.fecha=dd+"-"+mm+"-"+aa;
   }
   public Fecha(){
      this("","","");
   }
   public Fecha(JComboBox d,JComboBox m,JComboBox a){
      this.dd=forma2(d);
      this.mm=forma2(m);
      this.aa=a.getSelectedItem().toString();
      this.fecha=dd+"-"+mm+"-"+aa;
   }
   String forma2(JComboBox xx){
      int pos=xx.getSelectedIndex();
      return pos>9?""+pos:"0"+pos;
   }
   String forma2(int xx){
      return xx>9?""+xx:"0"+xx;
   }
   public String fecha(){
      return fecha;
   }
   String Fecha(int conDia) {
      Calendar f = Calendar.getInstance();
      String di[] = {" ","Domingo","Lunes","Martes","Miercoles", "Jueves","Viernes","Sabado"};
      String me[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
         "Agosto","Setiembre","Octubre","Noviembre","Diciembre"};
      int A=f.get(Calendar.YEAR);
      int M=f.get(Calendar.MONTH);
      int D=f.get(Calendar.DAY_OF_MONTH);
      int S=f.get(Calendar.DAY_OF_WEEK);
      String dia="";
      if(conDia>0)dia=di[S]+" ";
      return distrito+", "+dia+D+" de "+me[M]+" del "+A;
   }
   public String fecha(int conDia){
      return Fecha(conDia);
   }
   void cargaHora(JComboBox xx){
      xx.removeAllItems();
      xx.addItem("-Hora-");
      for(int i=0; i<25; i++){
         String x="0"+i;
         if(i>9)x=""+i;
         xx.addItem(x);
      }
   }
   void cargaMinSeg(JComboBox xx,int cual){
      Calendar f = Calendar.getInstance();
      int Ax=f.get(Calendar.MINUTE);
      xx.removeAllItems();
      if(cual == 0)xx.addItem("Min");
      else xx.addItem("Seg");
      for(int i=0; i<60; i++){
         String x="0"+i;
         if(i>9)x=""+i;
         xx.addItem(x);
      }
   }
   void cargaAa(JComboBox xx){
      Calendar f = Calendar.getInstance();
      int Ax=f.get(Calendar.YEAR);
      int fin = 20;
      xx.removeAllItems();
      xx.addItem("-Año-");
      for(int i=Ax; i<Ax-fin; i--){
         xx.addItem(i);
      }
   }
   public void cargaAa(JComboBox xx, int fin){
      Calendar f = Calendar.getInstance();
      int Ax=f.get(Calendar.YEAR);
      xx.removeAllItems();
      xx.addItem("-Año-");
      for(int i=Ax; i>Ax-fin; i--){
         xx.addItem(i);
      }
   }
   public void cargaMm(JComboBox xx){
      String me[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
         "Agosto","Setiembre","Octubre","Noviembre","Diciembre"};
      Calendar f = Calendar.getInstance();
      xx.removeAllItems();
      xx.addItem("-Mes-");
      for(int i=0; i<12; i++){
          xx.addItem(me[i].substring(0, 3));
      }
      //xx.setSelectedIndex(f.get(Calendar.MONTH));
   }
   public void cargaDd(JComboBox dias,JComboBox meses,JComboBox year){
      boolean bisiesto=false;
      int AA=Integer.parseInt(year.getSelectedItem().toString());
      if(AA%4==0 && AA%400!=0)bisiesto=true;
      int ultimo=31;
      int mes=meses.getSelectedIndex();
      if(mes == 4 || mes == 6 || mes == 9 || mes == 11)ultimo = 30;
      if(mes==2){
         ultimo=28;
         if(bisiesto)ultimo=29;
      }
      dias.removeAllItems();
      dias.addItem("Día");
      for(int i=1; i<=ultimo; i++){
         dias.addItem(forma2(i));
      }
      /*
      for(int i=1; i<=ultimo; i++){
         String x=""+i;
         if(i<10)x="0"+i;
         dias.addItem(x);
      }
      Calendar f = Calendar.getInstance();
      int D=f.get(Calendar.DAY_OF_MONTH);
      if(D<=ultimo)dias.setSelectedIndex(D);
      */
   }
   String anno(){
      Calendar f = Calendar.getInstance();
      return ""+f.get(Calendar.YEAR);
   }
   String dia(){
      String di[] = {" ","Domingo","Lunes","Martes","Miercoles", "Jueves",
         "Viernes","Sabado"};
      Calendar f = Calendar.getInstance();
      int S=f.get(Calendar.DAY_OF_WEEK);
      return di[S];
   }
   String dd(){
      Calendar f = Calendar.getInstance();
      int d=f.get(Calendar.DAY_OF_MONTH);
      String dx=""+d;
      if(d<10)dx="0"+d;
      return dx;
   }
   String mes(boolean enLetras){
      String me[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
         "Agosto","Setiembre","Octubre","Noviembre","Diciembre"};
      Calendar f = Calendar.getInstance();
      int M=f.get(Calendar.MONTH)+1;
      String Mm=""+M;
      if(M<10)Mm="0"+M;
      if(enLetras)Mm=me[M-1];
      return Mm;
   }
   String FechaManana() {
      Calendar cal = Calendar.getInstance();
      cal.add(Calendar.DAY_OF_MONTH, 1);
      SimpleDateFormat dateformat = new SimpleDateFormat("dd / MM / yyyy");
      return dateformat.format(cal.getTime());
   }
   String TimeFull24() {
      return Hora() + ":" + Minuto() + ":" + Segundo();
   }

   String FechaFull() {
      Calendar calendario = Calendar.getInstance();
      return String.valueOf(calendario.get(Calendar.DAY_OF_MONTH))
         + "/" + String.valueOf(calendario.get(Calendar.MONTH))
         + "/" + String.valueOf(calendario.get(Calendar.YEAR));
   }

    String Hora() {
      Calendar calendario = Calendar.getInstance();
      if (String.valueOf(calendario.get(Calendar.HOUR_OF_DAY)).length() == 2) {
         return String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
      } else {
         return "0" + String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
      }
   }

   String Hora_AMPM() {
      Calendar calendario = Calendar.getInstance();
      if (String.valueOf(calendario.get(Calendar.HOUR)).length() == 2) {
         return String.valueOf(calendario.get(Calendar.HOUR));
      } else {
         return "0" + String.valueOf(calendario.get(Calendar.HOUR));
      }
   }

   String Minuto() {
      Calendar calendario = Calendar.getInstance();
      if (String.valueOf(calendario.get(Calendar.MINUTE)).length() == 2) {
         return String.valueOf(calendario.get(Calendar.MINUTE));
      } else {
         return "0" + String.valueOf(calendario.get(Calendar.MINUTE));
      }
   }

   public static String Segundo() {
      Calendar calendario = Calendar.getInstance();
      if (String.valueOf(calendario.get(Calendar.SECOND)).length() == 2) {
         return String.valueOf(calendario.get(Calendar.SECOND));
      } else {
         return "0" + String.valueOf(calendario.get(Calendar.SECOND));
      }
   }
   public int diasEntreFechas(String fecha1, String fecha2){
      int dias=0;
      // FORMATO: "yyyy-MM-dd"
      try {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Date fechaInicial=dateFormat.parse(fecha1);
         Date fechaFinal=dateFormat.parse(fecha2);
         dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
      } catch (ParseException ex) {
      }
      return dias;
   }
   /*Metodo que calcula la diferencia de las horas entre dos fechas*/
   public long diferenciaHoras(Calendar fechaInicial, Calendar fechaFinal) {
      long diferenciaHoras = 0;
      diferenciaHoras = (fechaFinal.get(Calendar.HOUR_OF_DAY) - fechaInicial.get(Calendar.HOUR_OF_DAY));
      return diferenciaHoras;
   }
   
   long diferenciaHoras(String fechaIni, String fechaFin) {
      //FORMATO de Fechas: "2014/10/09 19:59:44" ..."2014/10/09 22:35:46"
      Date fechaInicial, fechaFinal;
      Calendar calFechaInicial=null, calFechaFinal=null;
      try {
         fechaInicial = StringToDate(fechaIni, "/", 0);//yyyy-MM-dd
         fechaFinal = StringToDate(fechaFin, "/", 0);
         calFechaInicial = Calendar.getInstance();
         calFechaFinal = Calendar.getInstance();
         calFechaInicial.setTime(fechaInicial);
         calFechaFinal.setTime(fechaFinal);
         
      } catch (ParseException ex) {
         
      }
      return diferenciaHoras(calFechaInicial, calFechaFinal);
   }
   public long cuantasHoras(String fechaIni, String fechaFin) {
      //FORMATO de Fechas: "2014/10/09 19:59:44" ..."2014/10/09 22:35:46"
      return diferenciaHoras(fechaIni, fechaFin);
   }
  // Diferencia de fecja de Hoy a una Fecha - Retorna Años, meses,dias
  private String difHOYaFecha(String fechita){
      // formato fecha: dd/mm/aaaa o dd.mm.aaa o dd-mm-aaaa
      String diff="";
      java.util.Calendar fechaHoy, fechaAntes;
      fechaHoy= java.util.Calendar.getInstance();
      fechaAntes= java.util.Calendar.getInstance();
      int dia=Integer.parseInt(fechita.substring(0, 2));
      int mes=Integer.parseInt(fechita.substring(3, 5));
      int years=Integer.parseInt(fechita.substring(6));
      fechaAntes.set(years,mes,dia);
      java.util.Calendar aux = java.util.Calendar.getInstance();
      aux.setTimeInMillis(fechaHoy.getTimeInMillis() - fechaAntes.getTimeInMillis());
      diff="" +(aux.get(java.util.Calendar.YEAR) - 1970) + 
         " años, " + aux.get(java.util.Calendar.MONTH) + " meses, "
         + aux.get(java.util.Calendar.DAY_OF_MONTH)+" dias";
      return diff;
   }
  public String difHoyAFecha(String fechita){
     return difHOYaFecha(fechita);
  }
   //Convertir fecha date en string
  Date StringToDate(String fecha, String caracter, int op) throws ParseException {
      String formatoHora = " HH:mm:ss";
      String formato = "yyyy" + caracter + "MM" + caracter + "dd" + formatoHora;
      switch (op) {
         case 1:
            formato = "yyyy" + caracter + "dd" + caracter + "MM" + formatoHora;
            break;
         case 2:
            formato = "MM" + caracter + "yyyy" + caracter + "dd" + formatoHora;
            break;
         case 3:
            formato = "MM" + caracter + "dd" + caracter + "yyyy" + formatoHora;
            break;
         case 4:
            formato = "dd" + caracter + "yyyy" + caracter + "MM" + formatoHora;
            break;
         case 5:
            formato = "dd" + caracter + "MM" + caracter + "yyyy" + formatoHora;
            break;
         default:
            break;
      }
      SimpleDateFormat sdf = new SimpleDateFormat(formato, Locale.getDefault());
      Date fechaFormato = null;
      sdf.setLenient(false);
      fechaFormato = sdf.parse(fecha);
      return fechaFormato;
   }
   //Convierte una fecha en date a string
   String DateToString(Date fecha, String caracter, int op) {
      String formatoHora = " HH:mm:ss";//Formato de hora
      //caracter hace referencia al separador / -
      String formato = "yyyy" + caracter + "MM" + caracter + "dd" + formatoHora;
      switch (op) {
         case 1:
            formato = "yyyy" + caracter + "dd" + caracter + "MM" + formatoHora;
            break;
         case 2:
            formato = "MM" + caracter + "yyyy" + caracter + "dd" + formatoHora;
            break;
         case 3:
            formato = "MM" + caracter + "dd" + caracter + "yyyy" + formatoHora;
            break;
         case 4:
            formato = "dd" + caracter + "yyyy" + caracter + "MM" + formatoHora;
            break;
         case 5:
            formato = "dd" + caracter + "MM" + caracter + "yyyy" + formatoHora;
            break;
         default:
            break;
      }
      SimpleDateFormat sdf = new SimpleDateFormat(formato, Locale.getDefault());
      String fechaFormato = null;
      sdf.setLenient(false);
      fechaFormato = sdf.format(fecha);
      return fechaFormato;
   }
   private boolean bisiesto(int year) {
      boolean es = false;
      if (year % 4 == 0 && year % 400 != 0) {
         es = true;
      }
      return es;
   }

   int ultdiaMesFecha(String fecha) {
      int mes = Integer.parseInt(fecha.substring(3, 5));
      int ultimo = 30;
      if ((mes % 2 != 0 && mes < 8) || (mes % 2 == 0 && mes > 7)) {
         ultimo++;
      }
      if (mes == 2) {
         ultimo = 28;
         if (bisiesto(Integer.parseInt(fecha.substring(6)))) {
            ultimo++;
         }
      }
      return ultimo;
   }

   private String diferenciaFechas(String fec1, String fec2) {
      // formato fecha: dd/mm/aaaa o dd.mm.aaa o dd-mm-aaaa
      String fecha1 = fec1.substring(6) + fec1.substring(3, 5) + fec1.substring(0, 2);
      String fecha2 = fec2.substring(6) + fec2.substring(3, 5) + fec2.substring(0, 2);
      if (fecha2.compareTo(fecha1) < 0) {
         String aux = fec1;
         fec1 = fec2;
         fec2 = aux;
      }
      //Hallando diferencia de años de las fechas
      int inicio = Integer.parseInt(fec1.substring(6));
      int fin = Integer.parseInt(fec2.substring(6));
      int AA = fin - inicio - 1;
      //Calculando el diferencia de meses de las fechas
      int MM = Integer.parseInt(fec1.substring(3, 5));//mes Fecha1
      MM -= Integer.parseInt(fec2.substring(3, 5));//Menos mes Fecha2
      //Calculando la diferencia de dias de las fechas
      int DD = Integer.parseInt(fec1.substring(0, 2));
      DD -= Integer.parseInt(fec2.substring(0, 2));
      // Si los meses y dias son lso mismos
      if (MM == 0 && DD == 0) {
         AA++;
      } else {//En caso contrario
         //Se determina la fecha1 del año anterior a la segunda fecha
         //Hasta aqui se tiene la diferencia de años - 1
         //Suponiendo que NO ha cumplido años en la fecha2
         fec1 = fec1.substring(0, 6) + ("" + (Integer.parseInt(fec2.substring(6)) - 1));
         //Se calcula los meses entre nueva fecha1 y la fecha2
         // se determinan los meses de la nueva fecha1 a diciembre
         MM = 12 - Integer.parseInt(fec1.substring(3, 5));
         //se suman los meses de enero al mes anterior de la fecha2
         MM += Integer.parseInt(fec2.substring(3, 5)) - 1;
         if (MM >= 12) {//Si los meses son mayores a 12
            MM -= 12;//Se restan 12 meses
            AA++;//Se suma 1 año
         }//Esto significa que el mes de la fecha2 es mayor que el mes de fecha1  
         //Se evalua el mes anterior de la fecha2 como cadena
         int mesAnt = Integer.parseInt(fec2.substring(3, 5)) - 1;
         String mesCad = "" + mesAnt;
         if (mesAnt < 10) {
            mesCad = "0" + mesAnt;
         }
         //Se evalua la fecha1 en el mes anterior de la fecha2
         fec1 = fec1.substring(0, 2) + "/" + mesCad + "/" + fec2.substring(6);
         //Se halla el ultimo dia del mes anterior de la fecha2
         int ultDia = ultdiaMesFecha(fec1);
         //se deteminan los dias de la nueva fecha1 al ultimo dia del mes
         int diasFecha1 = ultDia - Integer.parseInt(fec1.substring(0, 2));
         //se determinan los dias hasta el dia anterior de la fecha2
         int diasFecha2 = Integer.parseInt(fec2.substring(0, 2));
         //Se suman los dias
         DD = diasFecha1 + diasFecha2;
         if (DD >= ultDia) {//Si los dias son mas del los dias del mes
            DD -= ultDia;//Se restan los dias del mes
            MM++;//Se suma un mes
            if (MM >= 12) {//Si los meses son mayores a 12
               MM -= 12;//Se restan 12 meses
               AA++;//Se suma 1 año
            }//Esto significa que el mes de la fecha2 es mayor que el mes de fecha1
         }
      }
      return "" + AA + " Años, " + MM + " Meses, " + DD + " Dias";
   }

   public String diferenciaFechas(
      javax.swing.JTextField fec1, javax.swing.JTextField fec2) {
      return diferenciaFechas(fec1.getText(), fec2.getText());
   }
   private String diferenciaHoyFecha(String fec2) {
      String FECHA="";
      Date FechaHoy = new Date();
      String f=FechaHoy.toLocaleString();
      f=f.substring(0, 2)+"/"+f.substring(3, 5)+"/"+f.substring(6,10);
      return diferenciaFechas(f,fec2);
   }
   public String diferenciaHoyFechas(javax.swing.JTextField fec2) {
      return diferenciaHoyFecha(fec2.getText());
   }
}

