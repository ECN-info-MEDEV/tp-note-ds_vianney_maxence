/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp_note_vdp_mn;

/**
 *
 * @author viann
 */
import java.util.Scanner;

public class BugExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un nombre : ");
        int number = scanner.nextInt();

        System.out.println("Le double du nombre est : " + doubleNumber(number));
    }

    private static int doubleNumber(int num) {
        Scanner anotherScanner = new Scanner(System.in); // Erreur : Ne pas fermer ce Scanner

        return num * 2;
    }
}


