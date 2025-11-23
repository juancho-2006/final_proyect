/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadoraios;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JSEF1
 */
public class Calculadora {

    // Cambiado a List<String> para mayor claridad sobre lo que se guarda
    private final List<String> historial;
  
    public Calculadora() {
        // usamos arraylist( son dinamicos)  
       this.historial = new ArrayList<>();
    }

    /**
     * Evalúa una expresión matemática completa en formato String.
     * @param expr La expresión a evaluar (ej: "5*3+10")
     * @return El resultado de la operación
     */
    public double evaluar(String expr) {
        // Validación básica antes de empezar
        if (expr == null || expr.isEmpty()) {
            throw new IllegalArgumentException("La expresión no puede estar vacía.");
        }
        
        List<String> tokens = separar(expr);

        // Se organiza por prioridad de operaciones aritméticas (MDAS)
        resolverMD(tokens);

        double resultado = resolverSR(tokens);

        // Guardar en historial
        historial.add(expr + " = " + resultado);

        return resultado;
    }

    // Getter para historial
    public List<String> getHistorial() {
        return historial;
    }
    //Setter para historial
   public void setHistorial(List<String> nuevoHistorial) {
        try {
        if (nuevoHistorial == null) {
            System.out.println("La lista esta vacia .");
            return;
        }

        historial.clear();
        historial.addAll(nuevoHistorial);

    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}



    public void limpiarHistorial() {
        historial.clear();
    }

    // --- Métodos de cálculo ---
    
    /**
     * Divide la expresión en números y operadores individuales (tokens).
     */
    private List<String> separar(String expr) {
        List<String> tokens = new ArrayList<>();
        String numero = "";

        for (char c : expr.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                numero += c;
            } else {
                if (!numero.isEmpty()) {
                    tokens.add(numero);
                }
                tokens.add(String.valueOf(c));
                numero = "";
            }
        }
        if (!numero.isEmpty()) {
            tokens.add(numero);
        }
        return tokens;
    }

    /**
     * Resuelve Multiplicaciones, Divisiones y Porcentajes en la lista de tokens.
     */
    private void resolverMD(List<String> tokens) {
        int i = 0;

        while (i < tokens.size()) {
            String op = tokens.get(i);

            if (op.equals("x") || op.equals("÷")) {
                double a = Double.parseDouble(tokens.get(i - 1));
                double b = Double.parseDouble(tokens.get(i + 1));

                MathOperation operacion;

                if (op.equals("x")) {
                    operacion = new multiplication(a, b);
                } else {
                    operacion = new divide(a, b);
                }

                double r = operacion.exe();

                // Reemplazar la operación por el resultado
                tokens.set(i - 1, String.valueOf(r));
                 tokens.remove(i);// Eliminar el operador
                tokens.remove(i); // Eliminar el segundo operando (que ahora está en la posición 'i')
                // No incrementamos 'i' porque los elementos siguientes se movieron
            } else if (op.equals("%")) {
                double a = Double.parseDouble(tokens.get(i - 1));
                double r = a / 100.0;
                
                tokens.set(i - 1, String.valueOf(r));
                tokens.remove(i); // eliminar el símbolo %
                // No incrementamos 'i'
            } else {
                i++; // Pasar al siguiente token
            }
        }
    }

    /**
     * Resuelve Sumas y Restas restantes en la lista de tokens.
     */
    private double resolverSR(List<String> tokens) {
        if (tokens.isEmpty()) return 0; // Manejo básico si la lista queda vacía

        double resultado = Double.parseDouble(tokens.get(0));
        for (int i = 1; i < tokens.size(); i += 2) {
            String op = tokens.get(i);
            double num = Double.parseDouble(tokens.get(i + 1));

            MathOperation operacion;
            if (op.equals("+")) {
                operacion = new add(resultado, num);
            } else {
                operacion = new subtract(resultado, num);
            }

            resultado = operacion.exe();
        }
        return resultado;
    }
}