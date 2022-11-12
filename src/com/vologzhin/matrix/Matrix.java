package com.vologzhin.matrix;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    int width, height;
    private final double[][] m;

    public Matrix(int width, int height) {
        this.width = width;
        this.height = height;

        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width and height must be more then zero.");
        }

        m = new double[width][height];
    }

    public Matrix(int size) {
        this(size, size);
    }

    public Matrix(double[][] m) {
        this.width = m.length;
        this.height = m[0].length;
        this.m = new double[width][height];

        for (int i = 0; i < width; i++) {
            System.arraycopy(m[i], 0, this.m[i], 0, height);
        }
    }

    public double determinant() {
        if (!isSquare()) {
            return Double.NaN;
        }

        switch (width) {
            case 1:
                return m[0][0];

            case 2:
                return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);

            default:
                double result = 0.0;

                for (int i = 0; i < height; i++) {
                    Matrix sub = subMatrix(this, 1, i + 1);
                    result += (Math.pow(-1, 1 + i + 1) * m[0][i] * sub.determinant());
                }

                return result;
        }
    }

    public Matrix transpose() {
        Matrix result = new Matrix(height, width);
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                result.m[j][i] = this.m[i][j];
        return result;
    }

    public Matrix multiply(Matrix matrix) {
        if (this.height != matrix.width) {
            throw new RuntimeException("Illegal matrix dimensions.");
        }

        Matrix result = new Matrix(this.width, matrix.height);
        for (int i = 0; i < result.width; i++)
            for (int j = 0; j < result.height; j++)
                for (int k = 0; k < this.height; k++)
                    result.m[i][j] += (this.m[i][k] * matrix.m[k][j]);

        return result;
    }

    private static Matrix subMatrix(Matrix matrix, int excludeRow, int excludeColumn) {
        Matrix result = new Matrix(matrix.width - 1, matrix.height - 1);

        for (int i = 0, p = 0; i < matrix.width; i++) {
            if (i != excludeRow - 1) {
                for (int j = 0, q = 0; j < matrix.height; j++) {
                    if (j != excludeColumn - 1) {
                        result.m[p][q] = matrix.m[i][j];
                        q++;
                    }
                }
                p++;
            }
        }

        return result;
    }


    public boolean isSquare() {
        return height == width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (double[] rows : m) {
            builder
                    .append(Arrays.toString(rows))
                    .append("\n");
        }

        return builder.toString();
    }

    public static Matrix fromInput(String name, Scanner scanner) {

        System.out.printf("Введите кол-во строк матрицы %s: ", name);
        int width = scanner.nextInt();

        System.out.printf("Введите кол-во колонок матрицы %s: ", name);
        int height = scanner.nextInt();

        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width and height must be more then zero.");
        }

        double[][] m = new double[width][height];

        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++) {
                System.out.printf("%s (%d, %d): ", name, i + 1, j + 1);
                m[i][j] = scanner.nextDouble();
            }

        return new Matrix(m);
    }

}
