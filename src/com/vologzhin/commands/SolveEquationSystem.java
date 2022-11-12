package com.vologzhin.commands;

import com.vologzhin.Main;
import com.vologzhin.matrix.Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class SolveEquationSystem {

    public static void run(Scanner scanner) {

        try {
            System.out.print("Введите количество неизвестных в системе уравнений: ");
            int unknowns = scanner.nextInt();

            if (unknowns <= 0) {
                throw new RuntimeException("Неизвестных не может быть меньше 1");
            }

            System.out.println("""
                    
                    Введите значения уравнений:
                    Вот эти, в круглых скобках:
                    | x + y = (12)
                    | x - y = (16)
                    
                    """);

            double[] values = new double[unknowns];

            for (int i = 0; i < unknowns; i++) {
                System.out.printf("Значение %d: ", i + 1);
                values[i] = scanner.nextDouble();
            }

            System.out.println(Arrays.toString(values));

            Matrix matrix = Matrix.fromInput(scanner, "A", values.length, values.length);
            double[] results = matrix.kramer(values);

            System.out.println("РЕЗУЛЬТАТ:");

            for (int i = 0; i < results.length; i++) {
                System.out.printf("X%d = %f\n", i, results[i]);
            }

        } catch (Exception e) {
            Main.exitWithException(scanner, e.getMessage());
        }

    }
}
