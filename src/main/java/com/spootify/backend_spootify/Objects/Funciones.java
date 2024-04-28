package com.spootify.backend_spootify.Objects;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Funciones {
    
    public static String convertirDuracion(int segundos){

        float minutosExactos = segundos/60;

        if (minutosExactos>60) {
            float horasExactas = minutosExactos/60;

            int minutos = (int) horasExactas%60;
            int horas = (int) horasExactas;

            return String.format("%s h %s min", horas,minutos);
        }

        int minutos = (int) minutosExactos;
        return String.format("%s min", minutos);
    }

}
