package com.vologzhin;

import com.vologzhin.commands.DeterminantCramerCommand;
import com.vologzhin.commands.MultiplyMatrixesCommand;
import com.vologzhin.commands.SolveEquationSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите, что вы хотите сделать: ");

            System.out.println("1) Посчитать определитель матрицы");
            System.out.println("2) Умножить 2 матрицы");
            System.out.println("3) Решить систему уравнений методом Крамера");

            int selected = scanner.nextInt();

            switch (selected) {
                case 1:
                    DeterminantCramerCommand.run(scanner);

                case 2:
                    MultiplyMatrixesCommand.run(scanner);

                case 3:
                    SolveEquationSystem.run(scanner);

                default: {
                    System.out.println("Такой команды нет, попробуйте снова");
                }
            }
        }
    }


}
