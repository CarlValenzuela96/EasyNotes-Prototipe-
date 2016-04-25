
package easynotes;


import java.util.Scanner;


public class EasyNotes {

    //Probaaando
    
    public static void main(String[] args) {
        int cantR = cantRamos(); 
        int cantN = cantNotas();
         
        double [][]ramos = agregarRamos(cantR,cantN+1);
        menuPrincipal(ramos,cantN);
        
        }
       
    public static int leer(){
        Scanner leer = new Scanner(System.in);
        int num = leer.nextInt();
        return num;
    }   
    
    
    public static void menuPrincipal(double [][]asign, int cantNotas){
         int opc;
        do{
        System.out.println("----------menu------------");    
        System.out.println("1. Agregar notas");
        System.out.println("2. Ver notas agregadas");
        System.out.println("3. Calcular promedio");
        System.out.println("4. salir");
        
         opc = leer();
        switch(opc){
            case 1 :agregarNotas(asign); break;
            case 2: mostrarNotas(asign);break;
            case 3: mostrarPromedio(promedio(asign,cantNotas));break;
            case 4: break;
            default: break;
        }
        }while(opc !=4);
    }
    
    public static int cantNotas(){
        int asign;
        do{
        System.out.println("ingrese cantidad de notas de las asignaturas");
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
    public static void agregarNotas(double [][]asign){
        Scanner leer = new Scanner(System.in);
        int a;
        do{  
        System.out.println("asignatura a la que quiere agregar notas");
        
        a = leer();
        }while(a<=0 || a>asign.length);
        
             
            for (int j = 0; j < asign[0].length-1; j++) {
                do{
                
                System.out.println("agregar nota "+(j+1));
                asign[a-1][j]=leer.nextDouble();   
                
                }while(asign[a-1][j]<1||asign[a-1][j]>7);
        }    
         
    
}  
     public static void mostrarNotas(double [][]asign){
         
         for (int i = 0; i < asign.length; i++) {
             System.out.print("asignatura "+(i+1)+" : ");
             for (int j = 0; j < asign[i].length; j++) {
                 System.out.print(asign[i][j]+"\t");
             }
             System.out.println("");
         }
         System.out.println("nota: Promedio se guarda en ultima casilla");
    }
     
      public static double promedio(double asign[][], int cantNotas){
        double cont =0;
        int ramo;
          System.out.println("asignatura a promediar:");
          ramo= leer();
        
              for (int j = 0; j <asign[0].length-1; j++) {
            cont= cont + asign[ramo-1][j];
        }
              
        double promedio= cont/cantNotas;
        
       asign[ramo-1][cantNotas]= promedio;
        
       estadoRamo(asign,cantNotas,ramo);
        
        return promedio;
    }
      
      public static void estadoRamo(double asign[][], int cantNotas, int ramo){
           
          System.out.println(ramo);
          if(asign[ramo-1][cantNotas] >=4){
              
              System.out.println("usted esta aprobado");
          }else{
              
              System.out.println("usted esta reprobado");
          }  
    
      }
     
      
      
    public static void mostrarPromedio(double prom){
        System.out.println("el promedio es: "+prom);
        
    }
    
        
    
   
       
   
       
    
   
}
