package level01.exercise02.application;

import level01.exercise02.model.DniCalculator;

public class RunDni {

    public static void run() {
        System.out.println("=== DNI Calculation Started ===");

        DniCalculator calculator = new DniCalculator();
        int[] dniNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 99999999};

        for (int dni : dniNumbers) {
            char letter = calculator.calculateLetter(dni);
            System.out.printf("DNI %08d → Letter: %c%n", dni, letter);
        }

        System.out.println("=== DNI Calculation Finished ===");
    }
}
