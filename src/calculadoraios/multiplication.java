/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadoraios;

/**
 *
 * @author JSEF1
 */
public class multiplication extends MathOperation {
//se usa poliformismo y abstraccion 
    public  multiplication(double num1, double num2) {
        super(num1, num2);
    }
// se llama el metodo abstracto execute() "ejecutar en  español" .exe
    @Override
    public double exe() {
        return num1 * num2;
    }
}