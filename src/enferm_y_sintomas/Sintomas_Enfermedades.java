package enferm_y_sintomas;

import biblioteca.archivos.Manager;
import javax.swing.JComboBox;
import javax.swing.JTextField;
public class Sintomas_Enfermedades extends Manager {
   //Enfermedades,Sintomas,Relacion de sintoma enfermedad
   public Enfermedad E[],SE[];
   public Sintoma S[];
   // Cantidad de datos en Enfermedades,Sintomas,Relacion Eenf/Sint
   public int N1, N2, N3;
   Enfermedad Ex = new Enfermedad();
   private int numArch;
   //******* METODO CONSTRUCTOR
   public Sintomas_Enfermedades(){
      cargaDatos();
   }
   // METDODOS PARTICULARES
   // Manejan Base de Datos
   private void cargaDatos(){
     if(!veriArch(1)){//Segun el Manager (1) para enfermedades
        N1=2;
        E=new Enfermedad[N1];
        E[0]=new Enfermedad("Elija Enfermedad");
        E[1]=new Enfermedad("NUEVO");
        String que[]=new String[N1];
        for(int i=0; i<N1; i++){
           que[i]=E[i].data();
        }
        grabaRegistros(1,que);
     }else{
        leeRegistros(1);
        N1=numReg;
        E=new Enfermedad[N1];
        for(int i=0; i<N1; i++){
           E[i]=new Enfermedad();
           E[i].cargaData(cosa[i]);
        }
     }
     
     if(!veriArch(2)){//Segun el Manager (2) para Sintomas
        N2=2;
        S=new Sintoma[N2];
        S[0]=new Sintoma("Elija Sintoma");
        S[1]=new Sintoma("NUEVO");
        String que[]=new String[N2];
        for(int i=0; i<N2; i++){
           que[i]=S[i].data();
        }
        grabaRegistros(2,que);
     }else{
        leeRegistros(2);
        N2=numReg;
        S=new Sintoma[N2];
        for(int i=0; i<N2; i++){
           S[i]=new Sintoma();
           S[i].cargaData(cosa[i]);
        }
     }
     
     if(!veriArch(3)){//Segun el Manager (3) para BD Relacional Enfermedades con sintomas
        String que[]=new String [0];
        grabaRegistros(numArch,que);
        //usarTabla(3);
     }else{
        leeRegistros(3);
        N3=numReg;
        SE=new Enfermedad[N3];
        for(int i=0; i<N3; i++){
           SE[i]=new Enfermedad();
           SE[i].cargaData(cosa[i]);
        }
     }
   }

   public void cargaData(){
      cargaDatos();
   }
   //************* METODOS AUXILIARES
   // Carga selectores
   private void cargaSeleSin(JComboBox sin,int como){
      cargaDatos();
      sin.removeAllItems();
      sin.addItem(S[0].nom);
      if(como==1)sin.addItem(S[1].nom);
      for(int i=2; i<N2-1; i++){
         for(int j=i+1; j<N2; j++)
            if(S[i].nom.compareTo(S[j].nom)>0){
               Sintoma aux=S[i];
               S[i]=S[j];
               S[j]=aux;
            }
         sin.addItem(S[i].nom);
      }
   }
   
   public void cargaSelSin(JComboBox sin,int como){
      cargaSeleSin(sin,como);
   }
   
   private int buscaEnf(JTextField campo){
      String nom=campo.getText().toUpperCase();
      int hallado=-1;
      for(int i=2; i<N1; i++){
         if(nom.compareTo(E[i].nom) == 0){
            hallado=i;
            break;
         }
      }
      return hallado;
   }
   private int buscaSin(JTextField campo){
      String nom=campo.getText().toUpperCase();
      int hallado=-1;
      for(int i=2; i<N2; i++){
         if(nom.compareTo(S[i].nom) == 0){
            hallado=i;
            break;
         }
      }
      return hallado;
   }
   public int buscarSin(JTextField campo){
      return buscaSin(campo);
   }
   private void ingresa(int numArch, JTextField campo){
      cargaDatos();
      String mensa="Se GRABO con exito la informacion";
      //Verifica duplicado en Enfermedades
      if(numArch == 1){
         if(buscaEnf(campo)>0) mensa="ER-BD01\nDATO YA EXISE!!!";
         else{
            Enfermedad X[] = new Enfermedad[N1];
            System.arraycopy(E, 0, X, 0, N1);
            N1++;
            E = new Enfermedad[N1];
            System.arraycopy(X, 0, E, 0, N1 - 1);
            E[N1 - 1] = new Enfermedad(campo);
            String que[] = new String[N1];
            for (int i = 0; i < N1; i++) {
               que[i] = E[i].data();
            }
            grabaRegistros(numArch, que);
         }
      }
      if(numArch == 2){//Verifica duplicado en Sintomas
         if(buscaSin(campo)>0) mensa="ER-BD01\nDATO YA EXISE!!!";
         else{
            Sintoma X[]=new Sintoma [N2];
            System.arraycopy(S, 0, X, 0, N2);
            N2++;
            S=new Sintoma [N2];
            System.arraycopy(X, 0, S, 0, N2-1);
            S[N2-1]=new Sintoma(campo);
            String que[]=new String [N2];
            for(int i=0; i<N2; i++){
               que[i]=S[i].data();
            }
            grabaRegistros(numArch,que);
         }
      }
      mensaje(mensa);
   }
  
   public void ingresar(int numArch, JTextField campo){
      ingresa(numArch, campo);
   }
   private void ingresa(JComboBox sint, JTextField enfrm){
      //Ingresa relacion Enfermedad-Sintoma
      cargaDatos();
      boolean hallado=false;
      String enf=enfrm.getText().toUpperCase();
      String sin=sint.getSelectedItem().toString();
      String mens="Registro de "+sin+" para "+enf+"\n";
      for(int i=0; i<N3; i++){
         String compara=SE[i].cod+SE[i].nom;
         if(compara.compareTo(enf+sin) == 0){
            hallado=true;
         }
      }
      if(!hallado){
         Enfermedad X[]=new Enfermedad [N3];
         System.arraycopy(SE, 0, X, 0, N3);
         N3++;
         SE=new Enfermedad [N3];
         System.arraycopy(X, 0, SE, 0, N3-1);
         SE[N3-1]=new Enfermedad(enf,sin);
         String que[]=new String [N3];
         for(int i=0; i<N3; i++){
            que[i]=SE[i].data();
         }
         grabaRegistros(3,que);
        // que=new String [N2];
         hallado=false;
         for(int i=0; i<N2; i++){
            if(sin.compareTo(S[i].nom) == 0){
               S[i].cant++; hallado=true;
               break;
            }
         }
         if(hallado){
            que=new String [N2];
            for(int i=0; i<N2; i++){
               que[i]=S[i].data();
            }
            grabaRegistros(2,que);
         }
         mens+="       SATISFACTORIO!!!";
      }else mens+="         Ya EXISTE";
      mensaje(mens);
   }
   public void ingresar(JComboBox sin, JTextField enf){
      ingresa(sin, enf);
   }
   public void visualiza(JTextField enf,javax.swing.JTextArea salida){
      // Vizualiza enfermedad y sintomas
      cargaDatos();
      String nom=E[buscaEnf(enf)].nom;
      salida.setText("Enfermedad: "+nom+"\nSintomas:");
      for(int i=0; i<N3-1; i++){
         for(int j=i+1; j<N3; j++){
            if(SE[i].data().compareTo(SE[j].data())>0){
               Enfermedad aux=SE[i];
               SE[i]=SE[j];
               SE[j]=aux;
            }
         }
      }
      for(int i=0; i<N3; i++){
         if(nom.compareTo(SE[i].cod)==0){
            salida.append("\n\t"+SE[i].nom);
         }
      }
   }
   private void modSint(String anterior, JTextField sin){
      String sintoma=sin.getText().toUpperCase();
      cargaDatos();
      String que[]=new String[N2];
      for(int i=0; i<N2; i++){
         if(anterior.compareTo(S[i].nom) == 0){
            S[i].nom=sintoma;
            que[i]=S[i].data();
         }
      }
      grabaRegistros(2,que);
      que=new String [N3];
      for(int i=0; i<N3; i++){
         if(anterior.compareTo(SE[i].nom) == 0){
            SE[i].nom=sintoma;
            que[i]=SE[i].data();
         }
      }
      grabaRegistros(3,que);
   }
   public void modSintoma(String ant, JTextField sint){
      modSint(ant, sint);
   }
   private void borraSint(String anterior){
      cargaDatos();
      int cuantos=0;
      String mensa="";
      for(int i=0; i<N3; i++){
         if(anterior.compareTo(SE[i].nom) == 0){
            mensa+="\n  > "+SE[i].cod;
            cuantos++;
         }
      }
      if(mensa.length()>0){
         mensa="CUIDADO... HAY "+cuantos+" ENFERMEDADES con este sintoma:"+mensa;
         int opc=javax.swing.JOptionPane.showConfirmDialog(null, mensa);
         if(opc == 0){
            JTextField TF=new JTextField();
            TF.setText(anterior);
            int pos=buscaSin(TF);
            String que[]=new String[N2-1];
            int j=0;
            for(int i=0; i<N2; i++){
               if(i != pos){
                  que[j]=S[i].data();
                  j++;
               }
            }
            grabaRegistros(2,que);
            que=new String[N3-cuantos];
            for(int i=0; i<N3; i++){
               if(SE[i].nom.compareTo(anterior) == 0){
                  que[j]=SE[i].data();
                  j++;
               }
            }
            grabaRegistros(3,que);
         }
      }
   }
   public void borraSintoma(String anterior){
      borraSint(anterior);
   }

   
}
