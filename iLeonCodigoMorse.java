import java.util.Scanner;
import java.util.InputMismatchException;

public class iLeonCodigoMorse {
		
    	public static void main(String[] args) {
            //array para letras
            String[] abc = {"A",  "B",   "C",   "D",  "E", "F",  "G",  "H",  "I",  "J",   "K",  "L",  "M",  "N", "O", "P",   "Q",   "R",   "S",  "T", "U", "V",   "W",  "X",   "Y",  "Z",    "0",    "1",    "2",    "3",    "4",    "5",    "6",    "7",    "8",    "9"};
            String[] morse ={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..","-----",".----","..---","...--","....-",".....","_....","--...","---..","----."};

            boolean salir = false;
            Scanner s = new Scanner(System.in);
            int opc = 0;
            do
            {
                System.out.println("Que quieres realizar (ingresa el numero de opcion)");
                System.out.println("1 de texto a morse");
                System.out.println("2 de morse a texto");
                System.out.println("3 salir");  
                opc = comproDatoIngresado(s,1,3);
                s.nextLine();//para limpiar scaner
                salir = ejecOpcSel(opc,s, abc,morse);
            }
            while(!salir);
          } 
          public static boolean ejecOpcSel (int opc, Scanner s, String[] abc, String[] morse)
          {              
              if (opc ==1)
              {
                  System.out.println("Introduce texto");
                  String texto = s.nextLine();
                  String textoTrad = texto.toUpperCase();//Para que todo sea mayusculas
                  String mensajeTraducido = textAmorse(textoTrad,abc, morse);
                  System.out.println("La traduccion es: ");
                  System.out.println(mensajeTraducido);
              }
              else if (opc == 2)
              {
                System.out.println("Introduce codigo morse");
                String texto = s.nextLine();                
                String mensajeTraducido = morseAtext(texto,abc,morse);
                System.out.println("La traduccion es: ");
                System.out.println(mensajeTraducido);
              }
              else if (opc == 3)
              {
                  return true;
              }

              return false;

          }
          public static String textAmorse(String textoTrad, String[] abc, String[] morse)
          {
              String mensajeMorse = "";
              for (int i = 0; i < textoTrad.length(); i++)
              {
                  int j =0;
                  boolean terminar = false;
                  if(Character.toString(textoTrad.charAt(i)).equals(" "))
                  {
                      mensajeMorse +="   ";
                  }
                  else
                  {
                      do
                      {
                          if(Character.toString(textoTrad.charAt(i)).equals(abc[j]))
                          {
                              mensajeMorse += morse[j]+ " ";
                              terminar = true;
                          }
                          j ++;   
                          if(j==abc.length)
                          {
                              if(!terminar)
                              {
                                  terminar = true;
                              }
                          }

                      }
                      while(!terminar);

                  }                  

              }
              return mensajeMorse;
          }
          public static String morseAtext(String textoTrad, String[] abc, String[] morse)
          {
            String mensajeEspa = "";
            String caractMorse = "";
            int i = 0;
            do 
            {   
                boolean terminCaract = false;
                do
                {
                    if(Character.toString(textoTrad.charAt(i)).equals(" "))
                    {
                        terminCaract = true;
                    }
                    else
                    {
                        caractMorse += Character.toString(textoTrad.charAt(i));
                        i++;
                    }

                }
                while((!terminCaract)&&(i<textoTrad.length()));

                int j = 0;
                  boolean terminar = false;



                      do
                      {
                          if(caractMorse.equals(morse[j]))
                          {
                              mensajeEspa += abc[j];
                              terminar = true;
                          }
                          j ++;   
                          if(j==morse.length)
                          {
                              if(!terminar)
                              {
                                  terminar = true;
                              }
                          }

                      }
                      while(!terminar);
                      caractMorse = "";
                i++;
                try
                {
                    if (Character.toString(textoTrad.charAt(i)).equals(""))
                {
                    if (Character.toString(textoTrad.charAt(i+1)).equals(""))
                    {
                        mensajeEspa += " ";
                        i+=2;
                    }                                        
                }

                }
                catch(StringIndexOutOfBoundsException e)
                {

                }
                catch (Exception e)
                {}
                
            }
            while (i<textoTrad.length());
            return mensajeEspa;

          }
          public static int comproDatoIngresado(Scanner s, int min, int max)
          {
              int val = 0;
              boolean error = false;
              do 
              {
                  error = false;
                  try
                  {
                      val = s.nextInt();
                      if(!((val>=min) && (val<=max)))
                      {                          
                          System.out.println("la opcion no existe");
                          System.out.println("Tiene que ser entre"+ min +" y "+ max);
                          error = true;                      
                      }
                      
                  }
                  catch (InputMismatchException e)
                  {
                      System.out.println("la opcion no existe. Se esperaba un numero");
                      error = true;
                      s.nextLine();
                  }
                  catch(Exception e)
                  {
                      System.out.println("error inesperado." + e);
                      error = true;
                  }
              }
              while(error);
              return val;
    }                    
}

  