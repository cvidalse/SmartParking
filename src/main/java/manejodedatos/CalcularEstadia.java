/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejodedatos;
import java.text.DateFormatSymbols;


/**
 *
 * @author marce
 */
public class CalcularEstadia {

    /**
     * @param args the command line arguments
     */

    
    /*
        Los metodos "ajustarX()" aseguran que los valores se trabajen en el modulo adecuado segun sea el caso.
    
        Todos los metodos "ajustarX()" deben recibir el mes de termino de la estadia, y por ende debiesen ser ejecutados DESPUES del metodo "extraerMes()"
        
        El metodo "extraerMes()" obtiene el mes de termino de la estadia, a partir de un "charArray[]" que contiene todos los caracteres
        del "String" que sera o ha sido guardado en el documento "datos.txt".

        El metodo "calcular()" estima el tiempo de estadia a partir de un "String".
        Se asume que este String es una linea de texto va ser guardada en el documento "datos.txt" y que su formato no ha sido alterado.
    
        Si se ha alterado el formato en el cual se guardan los datos, entonces los metodos "extraerMes" y "calcular" deben 
        ser ajustados para operar con las nuevas posiciones de los valores.
     */
    
        //Variables globlaes que almacenan distintas partes del tiempo de estadia
        private static int diaEstadia;
        private static int horaEstadia;
        private static int minutoEstadia;
        private static int segundoEstadia;
        
        private static void ajustarMes(String mes){
            
            //El "ajuste mensual" se basa en el mes de termino de la estadia.
            //Si el mes de termino de la estadia es distinto al mes de inicio, 
            //entonces se agregan al tiempo de estadia la cantidad de dias que tiene el mes de inicio de la estadia, 
            //es decir, el mes previo al que recibe este metodo.
        
            switch (mes){
            
                    case ("Mar"):
                    diaEstadia += 28;
                    break;
                    
                    case ("May"):
                    diaEstadia += 30;
                    break;
                
                    case ("Jul"):
                    diaEstadia += 30;
                    break;
                    
                    case ("Oct"):
                    diaEstadia += 30;
                    break;
                    
                    case ("Dec"):
                    diaEstadia += 30;
                    break;
                    
                    default:
                    diaEstadia += 31;
                    break;
                    
          /* Lista de las abreviaturas que usa Java.date() y las duraciones en dias de los respectivos meses.
                    
            Jan 31
            Feb 28
            Mar 31
            Apr
            May 31
            Jun
            Jul 31
            Aug 31
            Sep
            Oct 31
            Nov
            Dec 31*/
            }
        }

        private static void ajustarDia(String mes){
            
            //Verificacion de si es necesario "ajustar el mes".
            if (diaEstadia < 0){
                
                ajustarMes(mes);   
            }
           
            if (diaEstadia > 0){
            
                diaEstadia -= 1; 
            
                if (horaEstadia>= 0 && minutoEstadia >= 0  && segundoEstadia >= 0){
                
                    diaEstadia += 1;
                }   
            }
        }
        
        private static void ajustarHora(String mes){
        
            //Verificacion de si es necesario "ajustar las horas".
            if (horaEstadia < 0){
       
                horaEstadia += 24;
                ajustarDia(mes);
            }
        }        
        
        private static void ajustarMinuto(String mes){
            
            //Verificacion de si es necesario "ajustar los minutos".
            if (minutoEstadia < 0){
       
            minutoEstadia += 60;
            horaEstadia -= 1;
            
            ajustarHora(mes); 
            }
        }
        
        private static void ajustarSegundo (String mes){
            
            //Verificacion de si es necesario "ajustar los segundos".
            if (segundoEstadia < 0){
      
                segundoEstadia += 60;
                minutoEstadia -= 1;
                
                ajustarMinuto(mes);  
            }
        }
        
        private static String extraerMes (char [] charRaw) {
            
        /* Este metodo asume que el "String" del cual se obtuvo el "charArray[]" tiene el siguiente formato:
            
         AX Fecha ingreso DI1 ME1 d1 h1:m1:s1 ZZZ YYY1 Fecha salida DI2 ME2 d2 h2:m2:s2 ZZZ YYY2
        
            Donde:
            "AX" es el identificador del sensor del cual se obtuvo la data (la cantidad de caracteres puede variar, siendo el unico dato cuyo largo no afecta a la clase ni sus metodos).
            
            "DI1" y "DI2" represntan una abreviatura en ingles del dia en que inicia y termina la estadia respectivamente (por ejemplo: Tue = Tuesday = Martes).
            
            "ME1" y "ME2" son las abreviaturas en ingles de los meses de inicio y termino de la estadia respectivamente (por ejemplo: Apr = April = Abril).
            
            "d1" y "d2" son el valor numerico del dia de inicio y termino de la estadia, respectivamente (pueden tomar cualquier valor entero entre 1 y 31).
            
            "h1" y "h2" son el valor numerico de la hora de incio y termino de la estadia, respectivamente (pueden tomar cualquier valor entero entre 0 y 23).
            
            "m1" y "m2" son el valor numerico del minuto de inicio y termino de la estadia, respectivamente (pueden tomar calqueir valor entero entre 0 y 59).
            
            "s1" y "s2" son el valor numerico del segundo de inicio y termino de la estadia, respectivamente (pueden tomar calqueir valor entero entre 0 y 59).
            
            "ZZ1" es la abreviatura en ingles de la zona horaria en la que se tomo el dato (porejemplo, para chile es CLT).
            
            "YYY1" e "YYY2" son los anios de inicio y termino de la estadia, respectivamente.
            
           El formato es sensible a la ubicacion y cantidad de caracters, incluidos los signos de puntuacion y los espacios. 
           Si por cualquier motivo se cambia el formato, este metodo debe ser modificado para que los punteros de 
            "mesSalida.append( charRaw [ puntero ])" correspondan a la poscion de los caracteres que conforman "ME2".
        */    
            StringBuilder mesSalida = new StringBuilder();
            
            mesSalida.append( charRaw [ charRaw.length - 24]);
            mesSalida.append( charRaw [ charRaw.length - 23]);
            mesSalida.append( charRaw [ charRaw.length - 22]);
        
            return mesSalida.toString();
        }
        
        private static int extraerValor ( char [] horaChar , int posicion){
            
            //Este metodo recibe un "char [] horaChar" que se asume posee solo numeros, junto con la posicion del segundo caracter del dato que se desea recibir.
            
            //Por ejemplo, si se esta usando el formato original y se desea obtener el dia de termino de la estadia,  el "int posicion" debiese tener un valor de "largo - 11",
            //donde "largo" es la cantidad de caracteres que contiene  "horaChar".
            
        StringBuilder sb = new StringBuilder();
        sb.append(horaChar[posicion - 1]);
        sb.append(horaChar[posicion]);
        int valor = Integer.parseInt(sb.toString());
            
        return valor ;   
        }
        
        public static String calcular (String dataRAW){

            /* 
            Este metodo recibe el "String" que ha de ser agregado al documento "datos.txt".
            
            Este metodo asume que el "String" recibido tiene un formato especifico, el cual es sensible a la ubicacion y cantidad de caracters, 
            incluidos los signos de puntuacion y los espacios. 
            
            Si por cualquier motivo se cambia el formato, este metodo debe ser modificado para que los punteros "largo - X" sigan apuntandoo a los datos correspondientes.
            
            El formato ausmido es el siguiente:
            
         AX Fecha ingreso DI1 ME1 d1 h1:m1:s1 ZZZ YYY1 Fecha salida DI2 ME2 d2 h2:m2:s2 ZZZ YYY2
        
            Donde:
            
            "AX" es el identificador del sensoor del cual se obtuvo la data (la cantidad de caracteres puede variar, siendo el unico dato cuyo largo no afecta a la clase ni sus metodos).
            
            "DI1" y "DI2" represntan una abreviatura en ingles del dia en que inicia y termina la estadia respectivamente (por ejemplo: Tue = Tuesday = Martes).
            
            "ME1" y "ME2" son las abreviaturas en ingles de los meses de inicio y termino de la estadia respectivamente (por ejemplo: Apr = April = Abril).
            
            "d1" y "d2" son el valor numerico del dia de inicio y termino de la estadia, respectivamente (pueden tomar cualquier valor entero entre 1 y 31).
            
            "h1" y "h2" son el valor numerico de la hora de incio y termino de la estadia, respectivamente (pueden tomar cualquier valor entero entre 0 y 23).
            
            "m1" y "m2" son el valor numerico del minuto de inicio y termino de la estadia, respectivamente (pueden tomar calqueir valor entero entre 0 y 59).
            
            "s1" y "s2" son el valor numerico del segundo de inicio y termino de la estadia, respectivamente (pueden tomar calqueir valor entero entre 0 y 59).
            
            "ZZ1" es la abreviatura en ingles de la zona horaria en la que se tomo el dato (porejemplo, para chile es CLT).
            
            "YYY1" e "YYY2" son los anios de inicio y termino de la estadia, respectivamente.
        */    

            char [] charRaw = dataRAW.toCharArray();
            String mesSalida = extraerMes (charRaw);
            
            
            char[] horaChar = dataRAW.replaceAll("\\D+","").toCharArray();
        
            int largo = horaChar.length;
            //variables que contendran los valores de las horas de entrada y salida
            int diaEntrada = extraerValor (horaChar , largo - 23);
            int horaEntrada = extraerValor (horaChar , largo - 21);
            int minutoEntrada = extraerValor (horaChar , largo - 19);
            int segundoEntrada = extraerValor (horaChar , largo - 17);
            int diaSalida = extraerValor (horaChar , largo - 11);
            int horaSalida = extraerValor (horaChar , largo - 9);
            int minutoSalida = extraerValor (horaChar , largo - 7);
            int segundoSalida = extraerValor (horaChar , largo - 5);
            
            //estos "ints" guardan la diferencia entre los valores de "entrada" y "salida" 
            //es decir los valores de "estadia"
            diaEstadia = diaSalida - diaEntrada;
            horaEstadia = horaSalida - horaEntrada;
            minutoEstadia = minutoSalida - minutoEntrada;
            segundoEstadia = segundoSalida - segundoEntrada;
        
            //aqui se ajustan los valores "int" para que trabajen en formato de dias, horas, minutos, segundos
            ajustarDia(mesSalida);
            ajustarHora(mesSalida);
            ajustarMinuto(mesSalida);
            ajustarSegundo(mesSalida);
            
            //resultado
            String tiempoEstadia = " Su estadia fue de " + diaEstadia + " dia(s) con " + horaEstadia + " : " + minutoEstadia + " : " + segundoEstadia;
    
            return tiempoEstadia;
        }
  }