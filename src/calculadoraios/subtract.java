/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadoraios;

/**
 *
 * @author JSEF1
 */
public class subtract extends MathOperation {

    public  subtract(double num1, double num2) {
        super(num1, num2);
    }
// se definen las dos varibles y se usa poliformismo
    @Override
    public double exe() {
        return num1 - num2;
    }
}