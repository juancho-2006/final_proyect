/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadoraios;

/**
 *
 * @author JSEF1
 */
public class divide extends MathOperation {

    public  divide(double num1, double num2) {
        super(num1, num2);
    }
//se usa clase abstracta y tiene su respectivo manejo de excepciones
    //aqui se realiza una excepcion para evitar numeros imaginarios dividos entre cero
    @Override
    public double exe() {
      try {
            return num1 / num2;

        } catch (ArithmeticException e) {
            System.out.println("no se puede divr por cero" + e.getMessage());
        }
        return 0;
    }
}