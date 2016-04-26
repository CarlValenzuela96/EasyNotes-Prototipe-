

package easynotes;


import java.util.Scanner;


public class EasyNotes {

    
    
    public static void main(String[] args) {
        int cantR = cantRamos(); 
        int cantNT = cantNotasTeorico();
        int cantNP = cantNotasPractico(); 
        double [][]teorico = agregarRamos(cantR,cantNT+1);
        double [][]practico = agregarRamos(cantR,cantNP+1);
        double [][]pondNT = agregarPond(cantR,cantNT);
        double [][]pondNP = agregarPond(cantR,cantNP);
        menuPrincipal(teorico,practico,cantNT,cantNP,pondNT,pondNP);
        
        }
       
    public static int leer(){
        Scanner leer = new Scanner(System.in);
        int num = leer.nextInt();
        return num;
    }   
    
    
    public static void menuPrincipal(double [][]teorico,double[][]practico,int cantNT , int cantNP, double[][]pondNT, double[][] pondNP){
         int opc;
        do{
        System.out.println("----------menu------------");    
        System.out.println("1. Agregar notas");
        System.out.println("2. Agregar ponderaciones");
        System.out.println("3. Ver notas agregadas");
        System.out.println("4. Calcular promedio");
        System.out.println("5. salir");
        
         opc = leer();
        switch(opc){
            case 1 :agregarNotas(teorico,practico); break;
            case 2: agregarPonderaciones(pondNT,pondNP);break;
            case 3: mostrarNotas(teorico,practico,pondNT,pondNP);break; 
            case 4:{
                    System.out.println("asignatura a promediar :");
                    int ramo = leer();
                    System.out.println("como se aprueba:");
                    System.out.println("1. T-P por separado");
                    System.out.println("2. T-P juntos");
                    int aprob = leer();
                    
                    double a = promedioPractico(ramo,practico,pondNP,cantNP);
                    double b = promedioTeorico(ramo,teorico,pondNT,cantNT);
                    if (aprob == 1){
                        
                        if((a>=3.95)&&(b>= 3.95)){
                            mostrarPromedioSeparado(b,a);
                            System.out.println("usted esta aprobado");
                            
                        }else{
                           mostrarPromedioSeparado(b,a);
                            System.out.println("usted esta reprobado");
                        }
                    }
                    if (aprob == 2){
                        System.out.println("ingrese ponderacion parte teorica en %");
                        double pondT = leer();
                        System.out.println("ingrese ponderacion parte Practica en %");
                        double pondP = leer();
                        
                        double promT = b*(pondT/100);
                        double promP = a*(pondP/100);
                        
                        double promFinal = promT+promP;
                        if(promFinal>=3.95){
                            mostrarPromedioJunto(b,a,promFinal);
                            System.out.println("usted esta aprobado");
                        }else{
                            mostrarPromedioJunto(b,a,promFinal);
                            System.out.println("usted esta reprobado");
                        }
                    }
                   };break;
                   
            
            case 5: break;
            default: break;
        }
        }while(opc !=5);
    }
    
    public static int cantNotasTeorico(){
        int asign;
        do{
        System.out.println("ingrese cantidad de notas teoricas de las asignaturas");
         asign = leer();
        }while(asign <=0);
        return asign;
    }
    public static int cantNotasPractico(){
        int asign;
        do{
        System.out.println("ingrese cantidad de notas practicas de las asignaturas");
         asign = leer();
        }while(asign <=0);
        return asign;
    }
    public static int cantRamos(){
        int ramos;
        do{
        System.out.println("ingrese cantidad de ramos del semestre");
         ramos = leer();
       }while(ramos <=0);
        return ramos;
    }
    public static double[][] agregarRamos(int ramos,int asign){
       
        double asignaturas [][] = new double[ramos][asign];
      
            return asignaturas;
    }
     public static double[][] agregarPond(int ramos,int asign){
          
        double ponderaciones [][] = new double[ramos][asign];
      
            return ponderaciones;       
        
    }
    public static void agregarNotas(double [][]teorico, double[][]practico){
        Scanner leer = new Scanner(System.in);
        int a;
        do{  
        System.out.println("asignatura a la que quiere agregar notas");
        
        a = leer();
        }while(a<=0 || a>teorico.length);
        
             
            for (int j = 0; j < teorico[0].length-1; j++) {
                do{
                
                System.out.println("agregar nota teorica "+(j+1));
                teorico[a-1][j]=leer.nextDouble();   
                
                }while(teorico[a-1][j]<1||teorico[a-1][j]>7);
        }    
            for (int j = 0; j < teorico[0].length-1; j++) {
                do{
                
                System.out.println("agregar nota practica "+(j+1));
                practico[a-1][j]=leer.nextDouble();   
                
                }while(teorico[a-1][j]<1||practico[a-1][j]>7);
        }    
            
    }
     public static void agregarPonderaciones(double [][]pondNT, double [][]pondNP){
        Scanner leer = new Scanner(System.in);
        int a;
        do{  
        System.out.println("asignatura a la que quiere agregar ponderaciones");
        
        a = leer();
            System.out.println("");
        }while(a<=0 || a>pondNT.length);
        
     
           
            for (int j = 0; j < pondNT[0].length; j++) {
                
                 
                System.out.println("agregar ponderacion teorica nota "+(j+1)+" en %");
                pondNT[a-1][j]=leer.nextInt();   
               
                
        }
            
              for (int j = 0; j < pondNP[0].length; j++) {
                
                
                System.out.println("agregar ponderacion practica nota "+(j+1)+" en %");
                pondNP[a-1][j]=leer.nextInt();   
                
                
        }    
         
}  
     public static void mostrarNotas(double [][]teorico,double [][]practico,double[][]pondNT,double[][]pondNP){
         
         for (int i = 0; i < teorico.length; i++) {
             System.out.print("asignatura    "+(i+1)+" : ");
             System.out.print("notas Teoricas:  ");
             for (int a = 0; a < teorico[i].length; a++) {
                 System.out.print(teorico[i][a]+"\t");
             }
             System.out.println("");
             System.out.print("asignatura    "+(i+1)+" : ");
             System.out.print("notas Practicas: ");
              for (int b = 0; b < practico[i].length; b++) {
                 System.out.print(practico[i][b]+"\t");
             }
              System.out.println("");
             
             System.out.print("ponderaciones "+(i+1)+" : ");
             System.out.print("pond Teoricas:   ");
             for(int c=0; c<pondNT[i].length;c++){
             System.out.print(pondNT[i][c]+"% "); 
             }
             System.out.println("");
             System.out.print("ponderaciones "+(i+1)+" : ");
             System.out.print("pond Practicas:  ");
             for(int d=0; d<pondNP[i].length;d++){
             System.out.print(pondNP[i][d]+"% "); 
             }
             System.out.println("");
             System.out.println("");
         }
         System.out.println("nota: Promedio se guarda en ultima casilla");
    }
     public static double promedioTeorico(int ramo,double teorico[][], double[][] pondNT, int cantNT){
        double cont =0;
       
        
              for (int j = 0; j <teorico[0].length-1; j++) {
            cont= cont + (teorico[ramo-1][j]*(pondNT[ramo-1][j]/100));
        }
              
        double promTeorico= cont;
        
       teorico[ramo-1][cantNT]= promTeorico;
        
        
        return promTeorico;
    }
      public static double promedioPractico(int ramo, double practico[][], double [][] pondNP, int cantNP){
          double cont =0;
        
              for (int j = 0; j <practico[0].length-1; j++) {
            cont= cont + (practico[ramo-1][j]*(pondNP[ramo-1][j]/100));
        }
              
        double promPractico= cont;
        
       practico[ramo-1][cantNP]= promPractico;
        
        return promPractico;
      }
      
      
    
     
      
      
    public static void mostrarPromedioSeparado(double promT, double promP){
        System.out.println("el promedio teorico es: "+promT);
        System.out.println("el promedio Practico es: "+promP);
        
    }
    public static void mostrarPromedioJunto(double promT, double promP, double promFinal){
         System.out.println("el promedio teorico es: "+promT);
        System.out.println("el promedio Practico es: "+promP);
        System.out.println("");
        System.out.println("el promedio final es: "+promFinal);
    }
      
}

