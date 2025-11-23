/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadoraios;
// el paquete donde se encuentran todas las clases
/**
 *
 * @author JSEF1, and la vic 
 */
public class add extends MathOperation {

    public  add(double num1, double num2) {
        super(num1, num2);
    }
// es un metodo abstracto usando poliformismo, como se explico en clase
    @Override
    public double exe() {
        return num1 + num2;
    }
}