package com.vologzhin.matrix;

public class Matrix {
    int width, height;
    private double[][] m;

    public Matrix(int width, int height, double[][] m) {
        this.width = width;
        this.height = height;
        this.m = m;

        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width and height must be more then zero.");
        }

        if (m.length != width) {
            throw new IllegalArgumentException("matrix width must be width param.");
        }

        for (double[] column : m) {
            if (column.length != height) {
                throw new IllegalArgumentException("matrix length mast be == length param.");
            }
        }
    }

    public Matrix(int size, double[][] m) {
        this(size, size, m);
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
        return super.toString();
    }

}
