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
}
