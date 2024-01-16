/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp_note_vdp_mn;

/**
 *
 * @author viann
 */
import java.util.Random;

public class SecurityFlawExample {

    private static Random insecureRandom = new Random();

    public static void main(String[] args) {
        int secretValue = generateSecretValue();
        System.out.println("Secret Value: " + secretValue);
    }

    private static int generateSecretValue() {
        return insecureRandom.nextInt(); // Utilisation incorrecte de random()
    }
}
