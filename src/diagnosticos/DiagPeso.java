package diagnosticos;

import biblioteca.archivos.Manager;
import historias.Historia;
import interfaces_graficas.PacientesApp;
import javax.swing.*;
import personas.pacientes.Pacientitos;


public class DiagPeso extends Manager{
   void comentario(){
      /*
      * Para diagnosticar Bajo de peso / Sobre Peso / Peso Normal
      * Datos necesarios: sexo, Talla, Peso, contextura
      * PesoM: para sexo Masculino
      * PesoF: para sexo Femenino
      * Datos de la matriz [fila][coñumna]
      * Columna [0] : talla
      * CONTEXTURA DELGADA
      * Columna [1] : Peso Límite inferior
      * Columna [2] : Peso Límite superior
      * CONTEXTURA MEDIA
      * Columna [3] : Peso Límite inferior
      * Columna [4] : Peso Límite superior
      * CONTEXTURA GrUESA
      * Columna [5] : Peso Límite inferior
      * Columna [6] : Peso Límite superior
      */
   }
   // Variables de clase - valores de las matrices
   private int n=36;// numero de filas
   private float PesoM [][];
   private float PesoF[][];
   // Datos del paciente
   private float peso, talla;
   private char sexo, contextura;
   private String estado;
   // DATOS A ENCONTRAR DENTRO DE LA MATRIZ
   private float PesoInf, PesoSup; 
   //Metodo contructor por omisión - para iniciar evaluación
   public DiagPeso(){
      this(' ',0,0,' ');
   }
   
   private void cargaData(){
      PesoM [0] [0] = 1.55f;PesoM [0] [1] = 50f;PesoM [0] [2] = 54f;PesoM [0] [3] = 53f;PesoM [0] [4] = 58f;PesoM [0] [5] = 56f;PesoM [0] [6] = 63f;
PesoM [1] [0] = 1.56f;PesoM [1] [1] = 50.3f;PesoM [1] [2] = 54.3f;PesoM [1] [3] = 54.3f;PesoM [1] [4] = 60.3f;PesoM [1] [5] = 58.3f;PesoM [1] [6] = 63.3f;
PesoM [2] [0] = 1.57f;PesoM [2] [1] = 52f;PesoM [2] [2] = 55f;PesoM [2] [3] = 54f;PesoM [2] [4] = 60f;PesoM [2] [5] = 58f;PesoM [2] [6] = 65f;
PesoM [3] [0] = 1.58f;PesoM [3] [1] = 52.3f;PesoM [3] [2] = 55.3f;PesoM [3] [3] = 54.3f;PesoM [3] [4] = 60.3f;PesoM [3] [5] = 58.3f;PesoM [3] [6] = 65.3f;
PesoM [4] [0] = 1.59f;PesoM [4] [1] = 52.6f;PesoM [4] [2] = 55.6f;PesoM [4] [3] = 54.6f;PesoM [4] [4] = 60.6f;PesoM [4] [5] = 58.6f;PesoM [4] [6] = 65.6f;
PesoM [5] [0] = 1.6f;PesoM [5] [1] = 53f;PesoM [5] [2] = 56f;PesoM [5] [3] = 56f;PesoM [5] [4] = 61f;PesoM [5] [5] = 59f;PesoM [5] [6] = 66f;
PesoM [6] [0] = 1.61f;PesoM [6] [1] = 53.5f;PesoM [6] [2] = 56.5f;PesoM [6] [3] = 56.5f;PesoM [6] [4] = 61.5f;PesoM [6] [5] = 59.5f;PesoM [6] [6] = 66.5f;
PesoM [7] [0] = 1.62f;PesoM [7] [1] = 54f;PesoM [7] [2] = 60f;PesoM [7] [3] = 57f;PesoM [7] [4] = 62f;PesoM [7] [5] = 61f;PesoM [7] [6] = 68f;
PesoM [8] [0] = 1.63f;PesoM [8] [1] = 54.3f;PesoM [8] [2] = 60.3f;PesoM [8] [3] = 57.3f;PesoM [8] [4] = 62.3f;PesoM [8] [5] = 61.3f;PesoM [8] [6] = 68.3f;
PesoM [9] [0] = 1.64f;PesoM [9] [1] = 54.6f;PesoM [9] [2] = 60.6f;PesoM [9] [3] = 57.3f;PesoM [9] [4] = 62.6f;PesoM [9] [5] = 61.6f;PesoM [9] [6] = 68.6f;
PesoM [10] [0] = 1.65f;PesoM [10] [1] = 56f;PesoM [10] [2] = 60f;PesoM [10] [3] = 58f;PesoM [10] [4] = 64f;PesoM [10] [5] = 62f;PesoM [10] [6] = 70f;
PesoM [11] [0] = 1.66f;PesoM [11] [1] = 56.5f;PesoM [11] [2] = 60.5f;PesoM [11] [3] = 59f;PesoM [11] [4] = 65f;PesoM [11] [5] = 63f;PesoM [11] [6] = 71f;
PesoM [12] [0] = 1.67f;PesoM [12] [1] = 57f;PesoM [12] [2] = 61f;PesoM [12] [3] = 60f;PesoM [12] [4] = 66f;PesoM [12] [5] = 64f;PesoM [12] [6] = 72f;
PesoM [13] [0] = 1.68f;PesoM [13] [1] = 57.7f;PesoM [13] [2] = 61.7f;PesoM [13] [3] = 60.7f;PesoM [13] [4] = 66.7f;PesoM [13] [5] = 64.7f;PesoM [13] [6] = 72.7f;
PesoM [14] [0] = 1.69f;PesoM [14] [1] = 58.4f;PesoM [14] [2] = 62.4f;PesoM [14] [3] = 61.4f;PesoM [14] [4] = 67.4f;PesoM [14] [5] = 65.4f;PesoM [14] [6] = 73.4f;
PesoM [15] [0] = 1.7f;PesoM [15] [1] = 59f;PesoM [15] [2] = 63f;PesoM [15] [3] = 62f;PesoM [15] [4] = 68f;PesoM [15] [5] = 66f;PesoM [15] [6] = 74f;
PesoM [16] [0] = 1.71f;PesoM [16] [1] = 60f;PesoM [16] [2] = 64f;PesoM [16] [3] = 63f;PesoM [16] [4] = 69f;PesoM [16] [5] = 67f;PesoM [16] [6] = 75f;
PesoM [17] [0] = 1.72f;PesoM [17] [1] = 61f;PesoM [17] [2] = 65f;PesoM [17] [3] = 64f;PesoM [17] [4] = 70f;PesoM [17] [5] = 68f;PesoM [17] [6] = 76f;
PesoM [18] [0] = 1.73f;PesoM [18] [1] = 61.7f;PesoM [18] [2] = 65.7f;PesoM [18] [3] = 64.3f;PesoM [18] [4] = 70.7f;PesoM [18] [5] = 68.3f;PesoM [18] [6] = 76.7f;
PesoM [19] [0] = 1.74f;PesoM [19] [1] = 62.4f;PesoM [19] [2] = 66.3f;PesoM [19] [3] = 64.7f;PesoM [19] [4] = 71.3f;PesoM [19] [5] = 68.7f;PesoM [19] [6] = 77.4f;
PesoM [20] [0] = 1.75f;PesoM [20] [1] = 63f;PesoM [20] [2] = 67f;PesoM [20] [3] = 65f;PesoM [20] [4] = 72f;PesoM [20] [5] = 69f;PesoM [20] [6] = 78f;
PesoM [21] [0] = 1.76f;PesoM [21] [1] = 63.5f;PesoM [21] [2] = 68f;PesoM [21] [3] = 65.7f;PesoM [21] [4] = 73f;PesoM [21] [5] = 70f;PesoM [21] [6] = 79f;
PesoM [22] [0] = 1.77f;PesoM [22] [1] = 64f;PesoM [22] [2] = 69f;PesoM [22] [3] = 67f;PesoM [22] [4] = 74f;PesoM [22] [5] = 71f;PesoM [22] [6] = 80f;
PesoM [23] [0] = 1.78f;PesoM [23] [1] = 64.7f;PesoM [23] [2] = 69.7f;PesoM [23] [3] = 67.7f;PesoM [23] [4] = 74.7f;PesoM [23] [5] = 71.7f;PesoM [23] [6] = 81f;
PesoM [24] [0] = 1.79f;PesoM [24] [1] = 65.4f;PesoM [24] [2] = 70.4f;PesoM [24] [3] = 68.4f;PesoM [24] [4] = 75.4f;PesoM [24] [5] = 72.4f;PesoM [24] [6] = 82f;
PesoM [25] [0] = 1.8f;PesoM [25] [1] = 66f;PesoM [25] [2] = 71f;PesoM [25] [3] = 69f;PesoM [25] [4] = 76f;PesoM [25] [5] = 73f;PesoM [25] [6] = 83f;
PesoM [26] [0] = 1.81f;PesoM [26] [1] = 67f;PesoM [26] [2] = 72f;PesoM [26] [3] = 70f;PesoM [26] [4] = 77f;PesoM [26] [5] = 75f;PesoM [26] [6] = 84f;
PesoM [27] [0] = 1.82f;PesoM [27] [1] = 68f;PesoM [27] [2] = 73f;PesoM [27] [3] = 71f;PesoM [27] [4] = 78f;PesoM [27] [5] = 77f;PesoM [27] [6] = 85f;
PesoM [28] [0] = 1.83f;PesoM [28] [1] = 68.7f;PesoM [28] [2] = 73.7f;PesoM [28] [3] = 71.7f;PesoM [28] [4] = 78.7f;PesoM [28] [5] = 77.3f;PesoM [28] [6] = 85.7f;
PesoM [29] [0] = 1.84f;PesoM [29] [1] = 69.4f;PesoM [29] [2] = 74.4f;PesoM [29] [3] = 72.4f;PesoM [29] [4] = 79.4f;PesoM [29] [5] = 77.7f;PesoM [29] [6] = 86.4f;
PesoM [30] [0] = 1.85f;PesoM [30] [1] = 70f;PesoM [30] [2] = 75f;PesoM [30] [3] = 73f;PesoM [30] [4] = 81f;PesoM [30] [5] = 78f;PesoM [30] [6] = 87f;
PesoM [31] [0] = 1.86f;PesoM [31] [1] = 71f;PesoM [31] [2] = 76f;PesoM [31] [3] = 74f;PesoM [31] [4] = 82f;PesoM [31] [5] = 79f;PesoM [31] [6] = 88f;
PesoM [32] [0] = 1.87f;PesoM [32] [1] = 72f;PesoM [32] [2] = 77f;PesoM [32] [3] = 75f;PesoM [32] [4] = 83f;PesoM [32] [5] = 80f;PesoM [32] [6] = 89f;
PesoM [33] [0] = 1.88f;PesoM [33] [1] = 72.3f;PesoM [33] [2] = 77.3f;PesoM [33] [3] = 75.7f;PesoM [33] [4] = 83.7f;PesoM [33] [5] = 80.7f;PesoM [33] [6] = 90f;
PesoM [34] [0] = 1.89f;PesoM [34] [1] = 72.7f;PesoM [34] [2] = 77.7f;PesoM [34] [3] = 76.4f;PesoM [34] [4] = 84.4f;PesoM [34] [5] = 81.4f;PesoM [34] [6] = 91f;
PesoM [35] [0] = 1.9f;PesoM [35] [1] = 73f;PesoM [35] [2] = 78f;PesoM [35] [3] = 77f;PesoM [35] [4] = 85f;PesoM [35] [5] = 82f;PesoM [35] [6] = 92f;
PesoF [0] [0] = 1.42f;PesoF [0] [1] = 41f;PesoF [0] [2] = 44f;PesoF [0] [3] = 43f;PesoF [0] [4] = 48f;PesoF [0] [5] = 47f;PesoF [0] [6] = 53f;
PesoF [1] [0] = 1.43f;PesoF [1] [1] = 42.3f;PesoF [1] [2] = 45.3f;PesoF [1] [3] = 44.3f;PesoF [1] [4] = 49.3f;PesoF [1] [5] = 48.3f;PesoF [1] [6] = 55.3f;
PesoF [2] [0] = 1.44f;PesoF [2] [1] = 42f;PesoF [2] [2] = 45f;PesoF [2] [3] = 44f;PesoF [2] [4] = 49f;PesoF [2] [5] = 48f;PesoF [2] [6] = 55f;
PesoF [3] [0] = 1.45f;PesoF [3] [1] = 42.3f;PesoF [3] [2] = 45.3f;PesoF [3] [3] = 44.3f;PesoF [3] [4] = 49.3f;PesoF [3] [5] = 48.3f;PesoF [3] [6] = 55.3f;
PesoF [4] [0] = 1.46f;PesoF [4] [1] = 42.6f;PesoF [4] [2] = 45.6f;PesoF [4] [3] = 44.6f;PesoF [4] [4] = 49.6f;PesoF [4] [5] = 48.6f;PesoF [4] [6] = 55.6f;
PesoF [5] [0] = 1.47f;PesoF [5] [1] = 43f;PesoF [5] [2] = 47f;PesoF [5] [3] = 45f;PesoF [5] [4] = 51f;PesoF [5] [5] = 49f;PesoF [5] [6] = 56f;
PesoF [6] [0] = 1.48f;PesoF [6] [1] = 43.3f;PesoF [6] [2] = 47.3f;PesoF [6] [3] = 45.3f;PesoF [6] [4] = 51.3f;PesoF [6] [5] = 49.3f;PesoF [6] [6] = 56.3f;
PesoF [7] [0] = 1.49f;PesoF [7] [1] = 43.6f;PesoF [7] [2] = 47.6f;PesoF [7] [3] = 45.6f;PesoF [7] [4] = 51.6f;PesoF [7] [5] = 49.6f;PesoF [7] [6] = 56.6f;
PesoF [8] [0] = 1.5f;PesoF [8] [1] = 44f;PesoF [8] [2] = 48f;PesoF [8] [3] = 47f;PesoF [8] [4] = 53f;PesoF [8] [5] = 50f;PesoF [8] [6] = 58f;
PesoF [9] [0] = 1.51f;PesoF [9] [1] = 45f;PesoF [9] [2] = 48.5f;PesoF [9] [3] = 47.5f;PesoF [9] [4] = 53.5f;PesoF [9] [5] = 51f;PesoF [9] [6] = 58.5f;
PesoF [10] [0] = 1.52f;PesoF [10] [1] = 46f;PesoF [10] [2] = 49f;PesoF [10] [3] = 48f;PesoF [10] [4] = 54f;PesoF [10] [5] = 52f;PesoF [10] [6] = 59f;
PesoF [11] [0] = 1.53f;PesoF [11] [1] = 46.3f;PesoF [11] [2] = 49.3f;PesoF [11] [3] = 48.3f;PesoF [11] [4] = 54.3f;PesoF [11] [5] = 52.3f;PesoF [11] [6] = 59.3f;
PesoF [12] [0] = 1.54f;PesoF [12] [1] = 46.7f;PesoF [12] [2] = 49.7f;PesoF [12] [3] = 48.7f;PesoF [12] [4] = 54.7f;PesoF [12] [5] = 52.7f;PesoF [12] [6] = 60.7f;
PesoF [13] [0] = 1.55f;PesoF [13] [1] = 47f;PesoF [13] [2] = 51f;PesoF [13] [3] = 49f;PesoF [13] [4] = 55f;PesoF [13] [5] = 53f;PesoF [13] [6] = 60f;
PesoF [14] [0] = 1.56f;PesoF [14] [1] = 47.5f;PesoF [14] [2] = 52f;PesoF [14] [3] = 50f;PesoF [14] [4] = 57.5f;PesoF [14] [5] = 53.5f;PesoF [14] [6] = 63f;
PesoF [15] [0] = 1.57f;PesoF [15] [1] = 48f;PesoF [15] [2] = 53f;PesoF [15] [3] = 51f;PesoF [15] [4] = 57f;PesoF [15] [5] = 54f;PesoF [15] [6] = 62f;
PesoF [16] [0] = 1.58f;PesoF [16] [1] = 48.7f;PesoF [16] [2] = 53.3f;PesoF [16] [3] = 51.7f;PesoF [16] [4] = 58.3f;PesoF [16] [5] = 54.7f;PesoF [16] [6] = 62.7f;
PesoF [17] [0] = 1.59f;PesoF [17] [1] = 49.4f;PesoF [17] [2] = 53.7f;PesoF [17] [3] = 52.4f;PesoF [17] [4] = 58.7f;PesoF [17] [5] = 55.3f;PesoF [17] [6] = 63.4f;
PesoF [18] [0] = 1.6f;PesoF [18] [1] = 50f;PesoF [18] [2] = 54f;PesoF [18] [3] = 53f;PesoF [18] [4] = 58f;PesoF [18] [5] = 56f;PesoF [18] [6] = 64f;
PesoF [19] [0] = 1.61f;PesoF [19] [1] = 50.5f;PesoF [19] [2] = 54.5f;PesoF [19] [3] = 53.5f;PesoF [19] [4] = 59.7f;PesoF [19] [5] = 57f;PesoF [19] [6] = 65f;
PesoF [20] [0] = 1.62f;PesoF [20] [1] = 51f;PesoF [20] [2] = 55f;PesoF [20] [3] = 54f;PesoF [20] [4] = 61f;PesoF [20] [5] = 58f;PesoF [20] [6] = 66f;
PesoF [21] [0] = 1.63f;PesoF [21] [1] = 51.7f;PesoF [21] [2] = 55.7f;PesoF [21] [3] = 54.7f;PesoF [21] [4] = 61.7f;PesoF [21] [5] = 58.7f;PesoF [21] [6] = 66.7f;
PesoF [22] [0] = 1.64f;PesoF [22] [1] = 52.4f;PesoF [22] [2] = 56.4f;PesoF [22] [3] = 55.4f;PesoF [22] [4] = 62.4f;PesoF [22] [5] = 59.4f;PesoF [22] [6] = 67.4f;
PesoF [23] [0] = 1.65f;PesoF [23] [1] = 53f;PesoF [23] [2] = 57f;PesoF [23] [3] = 56f;PesoF [23] [4] = 63f;PesoF [23] [5] = 60f;PesoF [23] [6] = 68f;
PesoF [24] [0] = 1.66f;PesoF [24] [1] = 54f;PesoF [24] [2] = 60.5f;PesoF [24] [3] = 56.5f;PesoF [24] [4] = 64.5f;PesoF [24] [5] = 61f;PesoF [24] [6] = 68.5f;
PesoF [25] [0] = 1.67f;PesoF [25] [1] = 55f;PesoF [25] [2] = 60f;PesoF [25] [3] = 57f;PesoF [25] [4] = 64f;PesoF [25] [5] = 62f;PesoF [25] [6] = 69f;
PesoF [26] [0] = 1.68f;PesoF [26] [1] = 55.7f;PesoF [26] [2] = 60.3f;PesoF [26] [3] = 57.7f;PesoF [26] [4] = 64.7f;PesoF [26] [5] = 62.3f;PesoF [26] [6] = 69.7f;
PesoF [27] [0] = 1.69f;PesoF [27] [1] = 56.4f;PesoF [27] [2] = 60.7f;PesoF [27] [3] = 58.3f;PesoF [27] [4] = 65.3f;PesoF [27] [5] = 62.7f;PesoF [27] [6] = 70.3f;
PesoF [28] [0] = 1.7f;PesoF [28] [1] = 57f;PesoF [28] [2] = 61f;PesoF [28] [3] = 59f;PesoF [28] [4] = 66f;PesoF [28] [5] = 63f;PesoF [28] [6] = 71f;
PesoF [29] [0] = 1.71f;PesoF [29] [1] = 57.5f;PesoF [29] [2] = 62f;PesoF [29] [3] = 60f;PesoF [29] [4] = 67f;PesoF [29] [5] = 64f;PesoF [29] [6] = 72f;
PesoF [30] [0] = 1.72f;PesoF [30] [1] = 58f;PesoF [30] [2] = 63f;PesoF [30] [3] = 61f;PesoF [30] [4] = 68f;PesoF [30] [5] = 65f;PesoF [30] [6] = 73f;
PesoF [31] [0] = 1.73f;PesoF [31] [1] = 58.7f;PesoF [31] [2] = 63.7f;PesoF [31] [3] = 61.7f;PesoF [31] [4] = 68.7f;PesoF [31] [5] = 65.7f;PesoF [31] [6] = 74f;
PesoF [32] [0] = 1.74f;PesoF [32] [1] = 59.3f;PesoF [32] [2] = 64.3f;PesoF [32] [3] = 62.3f;PesoF [32] [4] = 69.3f;PesoF [32] [5] = 66.3f;PesoF [32] [6] = 75f;
PesoF [33] [0] = 1.75f;PesoF [33] [1] = 60f;PesoF [33] [2] = 65f;PesoF [33] [3] = 63f;PesoF [33] [4] = 70f;PesoF [33] [5] = 67f;PesoF [33] [6] = 76f;
PesoF [34] [0] = 1.76f;PesoF [34] [1] = 61f;PesoF [34] [2] = 66f;PesoF [34] [3] = 64f;PesoF [34] [4] = 71f;PesoF [34] [5] = 68.5f;PesoF [34] [6] = 77f;
PesoF [35] [0] = 1.77f;PesoF [35] [1] = 62f;PesoF [35] [2] = 67f;PesoF [35] [3] = 65f;PesoF [35] [4] = 72f;PesoF [35] [5] = 70f;PesoF [35] [6] = 78f;
   }
   // CAPTACION DE DATOS
   // Constructor final
   private DiagPeso(char sexo, float peso, float talla, char contextura){
      this.sexo=sexo; this.peso=peso; 
      this.talla=talla; this.contextura=contextura;
      PesoM = new float[n][7];
      PesoF = new float[n][7];
      cargaData();
   }
   //Contructor intermedio 
   // Objetos visuales que se usaran
   public DiagPeso(JComboBox sexo,JTextField peso, JTextField talla, JComboBox contextura){
      this(
         sexo.getSelectedItem().toString().charAt(0),
         Float.valueOf(peso.getText()),
         Float.valueOf(talla.getText()),
         contextura.getSelectedItem().toString().charAt(0)
      );
   }
   // METODOS PARTICULARES
   
   private boolean error(JComboBox sexo,JTextField peso, JTextField talla, JComboBox contextura){
      boolean error=false;
      String mens="";
      if(sexo.getSelectedIndex()<1)mens+="\nERIO: No selecciono SEXO";
      if(contextura.getSelectedIndex()<1)mens+="\nERIO: No selecciono CONTEXTURA";
      if(peso.getText().equals(""))mens+="\nERIO: No ingreso PESO";
      if(talla.getText().equals(""))mens+="\nERIO: No ingreso TALLA";
      if(mens.length() > 0){
         error=true;
         mensaje(mens);
      }
      return error;
   }
   public boolean errores(JComboBox sexo,JTextField peso, JTextField talla, JComboBox contextura){
      return error(sexo,peso, talla, contextura);
   }
   public void cargaCombos(JComboBox sexo, JComboBox contextura){
      sexo.removeAllItems();
      sexo.addItem("  Sexo ??");
      sexo.addItem("Masculino");
      sexo.addItem("Femenino");
      contextura.removeAllItems();
      contextura.addItem("Contextura?");
      contextura.addItem("Delgada");
      contextura.addItem("Mediana");
      contextura.addItem("Gruesa");
   }
   private String analiza(){
      estado = "NORMAL";
      //Determinación de columna de límite inferior
      int LI = 1;
      switch(contextura){
         case 'M': LI = 3;break;
         case 'G': LI = 5;
      }
      int LS = LI + 1;//columna Limite superior
      // Búsqueda Limites de pesso para la talla
      if(sexo == 'M')buscaM(LI,LS);
      else buscaF(LI,LS);
      
      if(peso < PesoInf)estado = "BAJO DE PESO";
      if(peso > PesoSup)estado = "SOBRE-PESO";
      estado="Limites de peso:\n"+
           "   Inferior: "+PesoInf+"  Superior: "+PesoSup+
            "\n Su estado es: "+estado;
      return estado;
   }
   private void buscaM(int LI,int LS){
      for(int i=0; i<n; i++){
         if(PesoM[i][0] == talla){
            PesoInf = PesoM[i][LI];
            PesoSup = PesoM[i][LS];
            break;
         }
      }
   }
   private void buscaF(int LI,int LS){
      for(int i=0; i<n; i++){
         if(PesoF[i][0] == talla){
            PesoInf = PesoF[i][LI];
            PesoSup = PesoF[i][LS];
            break;
         }
      }
   }
   public void diagnostica(JTextArea TA){
      TA.setText(analiza());
      int graba = JOptionPane.showConfirmDialog(null, "Graba en Historia?");
      if (graba == 0) {
         String xx = "\n\tPeso: " + peso + "\tTalla: " + talla + "\n\tDiagnostico: "
            + estado + "\tLimites (" + PesoInf + " - " + PesoSup + ")";
         JTextField DNI = new JTextField();
         String dni = "";
         while (true) {
            dni = JOptionPane.showInputDialog("Ingrese DNI");
            DNI.setText(dni);
            if (!errorDNI(DNI)) break;
         }
         Pacientitos P = new Pacientitos();
         int pos = P.hallarDNI(DNI);
         if (pos >= 0) {
            Historia H = new Historia(DNI);
            H.creaHistoria(P.PA[pos]);
            H.agrega(3, xx);
         } else {
            int opc=JOptionPane.showConfirmDialog(null,"NO EXISTE PACIENTE!!!\n Hace la filiacion??");
            if(opc == 0){
               new PacientesApp().show();
            }
         }
         
      }

   }
   
}
