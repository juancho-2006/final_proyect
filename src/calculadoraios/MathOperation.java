/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadoraios;

/**
 *
 * @author JSEF1
 */
public abstract class MathOperation {
    protected double num1;
    protected double num2;

    public MathOperation(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
// aqui se define un metodo abstracto, como se solicito 
    public abstract double exe();
}