package personas.pacientes;

import biblioteca.ubigeo.Peru;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import personas.Persona;

/**
 * DATOS DE Paciente: DNI, nombre, apellidos //heredados de Persona
 * lugar de nacimiento (ubigeo)
 * Fecha de nacimiento 
 * Domicilio actual (ubigeo)
 * Telefono 
 * Edad sexo  
 * Estado civil 
 * Numero de hijos 
 */
public class Paciente extends Persona{
   String direc,fono;
   String data;
   String ubigeoNac, ubigeoDom; //Ubigeos Nacimiento  y Domicilio
   String fechaNac; // formato dd/mm/aaaa o dd-mm-aaaa o dd.mm.aaaa
   int numHijos;
   char sexo,estCiv;
   Paciente(String dni,String apeNom, String direc, String fono, 
      String ubigeoNac, String ubigeoDom, String fechaNac, int numHijos,
      char sexo, char estCiv){
      this.dni = dni; this.apeNom = apeNom; this.direc = direc;
      this.fono = fono; 
      this.ubigeoNac = ubigeoNac; this.ubigeoDom = ubigeoDom;
      this.fechaNac = fechaNac; this.numHijos = numHijos; this.sexo = sexo;
      this.estCiv = estCiv;
      this.data = data() + s + direc + s + fono + s + ubigeoNac + s + 
         ubigeoDom + s + fechaNac + s + numHijos + s + sexo + s + estCiv ;
   }
   public Paciente(){
      this("-","-","-","-","-","-","-",0,'-','-');
   }
   public Paciente(JTextField code, JTextField apeNom, JTextField direc, 
      JTextField fono,JTextField ubigeoNac, JTextField ubigeoDom, JTextField fechaNac, 
      JTextField numHijos, JComboBox sexo, JComboBox estCiv){
      this(code.getText(),apeNom.getText().toUpperCase(),
         direc.getText().toUpperCase(),fono.getText(),
         ubigeoNac.getText(), ubigeoDom.getText(),
         fechaNac.getText().toUpperCase(),
         Integer.parseInt(numHijos.getText()),
         sexo.getSelectedItem().toString().charAt(0),
         (""+estCiv.getSelectedIndex()).charAt(0)
         );
   }
   // String direc, String fono, 
     // String ubigeoNac, String ubigeoDom, String fechaNac, int numHijos,
      //char sexo, char estCiv
   void cargaData(String QUE){
      String cosaX="";
      int numCampo=0;
      for(int i=0; i<QUE.length();i++){
         if(QUE.charAt(i) != s){
            cosaX+=QUE.charAt(i);
            if(i+1 == QUE.length()) estCiv=cosaX.charAt(0);
         }else{
            numCampo++;
            switch(numCampo){
               case 1: dni=cosaX; break;
               case 2: apeNom=cosaX; break;
               case 3: direc=cosaX; break;
               case 4: fono=cosaX; break;
               case 5: ubigeoNac=cosaX; break;
               case 6: ubigeoDom=cosaX; break;
               case 7: fechaNac=cosaX; break;
               case 8: numHijos=Integer.parseInt(cosaX); break;
               case 9: sexo=cosaX.charAt(0); break;
            }
            cosaX="";
         }
      }
      data = data() + s + direc + s + fono + s + ubigeoNac + s + ubigeoDom +
         s + fechaNac + s + numHijos + s + sexo + s + estCiv ;
   } 
   public String datos(){
      Peru peru=new Peru();
      String ubiNac=peru.dameUbigeo(ubigeoNac);
      String ubiDom=peru.dameUbigeo(ubigeoDom);
      return dato()+"\nDIRECCION: "+direc+"\nTELEFONO: "+fono+
         "\nUbigeo Nacimiento: "+ubigeoNac+ubiNac+
         "\nUbigeo Domicilio:  "+ubigeoDom+ubiDom+
         "\nFecha de Nacimiento: "+fechaNac+"\nEdad: "+edad()+
         "\n Numero de hijos: "+numHijos+"  Sexo:"+sexo+"  Estado Civil: "+
         estadoCivil()+"\n<>";
   }
   String edad(){
      biblioteca.fechas.Fecha f=new biblioteca.fechas.Fecha();
      return f.difHoyAFecha(fechaNac);
   }
   String estadoCivil(){
      String x="";
      switch (estCiv){
         case '1':x="SOLTERO(A)";break;
         case '2':x="CASADO(A)";break;
         case '3':x="VIUDO(A)";break;
         case '4':x="DIVORCIADO(A)";break;
         case '5':x="CONVIVIENTE";break;
      }
      return x;
   }
   void leeUbigeo(int x){
      biblioteca.ubigeo.Peru PE=new biblioteca.ubigeo.Peru();
      JTextField codigo=new JTextField();
      PE.leeUbigeo(codigo);
      if(x == 1)ubigeoNac=codigo.getText();
      else ubigeoDom=codigo.getText();
   }
}
