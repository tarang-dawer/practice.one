package com.tarang.practice.cdci.one;

public class SetMatrixRowColumnZero {
	public static void main(String[] args) {

		SetMatrixRowColumnZero s = new SetMatrixRowColumnZero();
		// int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
		// { 13, 14, 15, 16 } };
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 0, 8, 9 } };
		int orderX = 3, orderY = 3;

		System.out.println("Matrix\n");
		for (int i = 0; i < orderX; i++) {
			for (int j = 0; j < orderY; j++) {
				System.out.print(matrix[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}

		int[][] newMatrix = s.transformMatrix(matrix, orderX, orderY);

		System.out.println("New Matrix\n");
		for (int i = 0; i < orderX; i++) {
			for (int j = 0; j < orderY; j++) {
				System.out.print(newMatrix[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
	}

	private int[][] transformMatrix(int[][] matrix, int orderX, int orderY) {

		boolean[] rowCheck = new boolean[orderX];
		boolean[] columnCheck = new boolean[orderY];

		for (int i = 0; i < orderX; i++)
			for (int j = 0; j < orderY; j++) {
				if (matrix[i][j] == 0) {
					rowCheck[i] = true;
					columnCheck[j] = true;
				}
			}

		for (int i = 0; i < orderX; i++)
			for (int j = 0; j < orderY; j++) {
				if (rowCheck[i] || columnCheck[j]) {
					matrix[i][j] = 0;
				}
			}
		return matrix;
	}

}
