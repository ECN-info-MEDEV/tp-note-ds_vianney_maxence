/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp_note_vdp_mn;

/**
 *
 * @author viann
 */
public class BugExample {

    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        int result = divideNumbers(numerator, denominator);

        System.out.println("Result: " + result);
    }

    private static int divideNumbers(int numerator, int denominator) {
        return numerator / denominator; // Cette ligne provoquera une division par zéro
    }
}

