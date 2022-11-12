package com.vologzhin.commands;

import com.vologzhin.Main;
import com.vologzhin.matrix.Matrix;

import java.util.Scanner;

public class DeterminantMatrixCommand {

    public static void run(Scanner scanner) {
        try {
            Matrix matrix = Matrix.fromInput("A", scanner);

            if (!matrix.isSquare()) {
                throw new RuntimeException("Матрица не квадратная, определитель посчитать нельзя.");
            }

            System.out.printf("\ndet%s = %f\n", "A", matrix.determinant());
        } catch (Exception e) {
            Main.exitWithException(scanner, e.getMessage());
        }
    }

}
