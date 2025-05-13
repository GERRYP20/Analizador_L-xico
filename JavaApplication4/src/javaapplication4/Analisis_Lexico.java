/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

/**
 *
 * @author Gerardo
 */
public class Analisis_Lexico
{
    
    String lexema;
    String nombre;
    int numero;
    
        String[][] diccionario = {
            {"estructura", "PALABRA_RESERVADA", "1"},
            {"todos", "PALABRA_RESERVADA", "1"},
            {"constante", "PALABRA_RESERVADA", "1"},
            {"sinvalor", "PALABRA_RESERVADA", "1"},
            {"arranque", "PALABRA_RESERVADA", "1"},
            {"mostrar", "FUNCION_SALIDA", "2"},
            {"leer", "FUNCION_ENTRADA", "3"},
            {"número", "TIPO_DATO", "4"},
            {"10", "LITERAL_NUMERICO", "5"},
            {"\"..\"", "LITERAL_CADENA", "6"},
            {"=", "OPERADOR_ASIGNACION", "7"},
            {"+", "OPERADOR_ARITMETICO", "8"},
            {"-", "OPERADOR_ARITMETICO", "8"},
            {"*", "OPERADOR_ARITMETICO", "8"},
            {"/", "OPERADOR_ARITMETICO", "8"},
            {"(", "AGRUPADOR", "9"},
            {")", "AGRUPADOR", "9"},
            {"[", "AGRUPADOR", "9"},
            {"]", "AGRUPADOR", "9"},
            {";", "PUNTO_Y_COMA", "10"},
            {"Inicio", "IDENTIFICADOR", "11"},
            {"número1", "IDENTIFICADOR", "11"},
            {"resultado", "IDENTIFICADOR", "11"}
        };
        
    public Analisis_Lexico Etiquetar(String palabra) {
        Analisis_Lexico objLexico = new Analisis_Lexico();

        objLexico.lexema = palabra;
        int index = 0;

        boolean bandera = false;

        while (index < objLexico.diccionario.length) {

            if (palabra.equals(diccionario[index][0])) {
                bandera = true;
                objLexico.nombre = diccionario[index][1];
                objLexico.numero = Integer.parseInt(diccionario[index][2]);
                break;
            }
            index++;
        }

        if (bandera) {
            return objLexico;
        }

        //Parte del automata para etiquetados fuera de tabla de tokens fijos
        int matTransiciones[][] = {
            {2,1,-1,4},
            {-1,1,-1,-1},
            {3,2,2,2},
            {-1,-1,-1,-1},
            {-1,4,-1,4},
        };
        String nombres[] = {"errorDesconocido", "Entero", "errorCadena", "Cadena", "Variable"};
        int numeros[] = {100, 50, 102, 51, 52};
        String posiblesErrores[] = {"errorDesconocido", "errorNumero", "errorCadena", "errorCadena", "errorVariable"};
        int numerosError[] = {100, 101, 102, 102, 104};

        int estado = 0;
        int pos = 0;
        char arrCar[] = palabra.toCharArray();
        boolean bandera2 = true;

        
        // Si la palabra está entre comillas, es una cadena válida
if (palabra.length() >= 2 && palabra.charAt(0) == '"' && palabra.charAt(palabra.length() - 1) == '"') {
    objLexico.nombre = "Cadena";
    objLexico.numero = 51;
    return objLexico;
}

        
        for (int i = 0; i < arrCar.length; i++) {
            if (arrCar[i] == '"') {
                pos = 0;
                
            } else if (Character.isDigit(arrCar[i])) {
                pos = 1;
                
            } else if (isPI(arrCar[i])) {
                pos = 2;
                
            } else if (Character.isUpperCase(arrCar[i]) || Character.isLowerCase(arrCar[i])) {
                pos = 3;
                
            } else {
                bandera2 = false;
                break;
            }

            if (matTransiciones[estado][pos] != -1) {
                estado = matTransiciones[estado][pos];
            } else {
                bandera2 = false;
                break;
            }
        }
        
        if (bandera2) {
            objLexico.nombre = nombres[estado];
            objLexico.numero = numeros[estado];
        }else{
            objLexico.nombre = posiblesErrores[estado];
            objLexico.numero = numerosError[estado];
        }

       
        return objLexico;

    }
    
    public boolean isPI(char caracter) {
        char[] PI = {
             '%',  '[', ']',  '_', '!',
        };
        boolean bandera = false;

        for (int i = 0; i < PI.length; i++) {
            if (caracter == PI[i]) {
                bandera = true;
            }
        }
        return bandera;
    }
}
