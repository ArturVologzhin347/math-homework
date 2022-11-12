package com.vologzhin;

import com.vologzhin.commands.DeterminantMatrixCommand;
import com.vologzhin.commands.SolveEquationSystem;
import com.vologzhin.commands.multiplyMatrixCommand;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Бесконечный цикл
        while (true) {
            System.out.println("Выберите, что вы хотите сделать: ");

            System.out.println("1) Посчитать определитель матрицы");
            System.out.println("2) Умножить 2 матрицы");
            System.out.println("3) Решить систему уравнений методом Крамера");

            int selected = scanner.nextInt();

            // Определяем дальнейшие действия
            switch (selected) {
                case 1 -> DeterminantMatrixCommand.run(scanner);
                case 2 -> multiplyMatrixCommand.run(scanner);
                case 3 -> SolveEquationSystem.run(scanner);
                default -> System.out.println("Такой команды нет, попробуйте снова");
            }
        }
    }

    // Выходим из программы с сообщением об ошибке и возможностью продолжить сессию
    public static void exitWithException(Scanner scanner, String message) {
        System.out.printf("Произошла ошибка: %s\n", message);
        System.out.println("Вы хотите выйти (y), или попробовать снова? (n): ");
        String answer = scanner.next().trim().toLowerCase(Locale.ROOT);

        switch (answer) {
            default:
            case "y":
            case "yes":
                System.exit(0);
                break;

            case "n":
            case "no":
                break;
        }

    }

}
