package com.vologzhin;

import com.vologzhin.matrix.Matrix;

public class Main {

    public static void main(String[] args) {
        double[][] m = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };



        Matrix matrix = new Matrix(3, 3, m);

    }
}
