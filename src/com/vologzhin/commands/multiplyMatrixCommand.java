package com.vologzhin.commands;

import com.vologzhin.Main;
import com.vologzhin.matrix.Matrix;

import java.util.Scanner;

public class multiplyMatrixCommand {

    public static void run(Scanner scanner) {
        try {
            Matrix matrix1 = Matrix.fromInput("A", scanner);
            Matrix matrix2 = Matrix.fromInput("B", scanner);

            System.out.println("РЕЗУЛЬТАТ:");

            System.out.println(matrix1.multiply(matrix2));
        } catch (Exception e) {
            Main.exitWithException(scanner, e.getMessage());
        }

    }

}
