package com.tarang.practice.cdci.one;

public class MatrixRotate {

	public static void main(String[] args) {

		MatrixRotate m = new MatrixRotate();
		// int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
		// { 13, 14, 15, 16 } };
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int order = 3;

		System.out.println("Matrix\n");
		for (int i = 0; i < order; i++) {
			for (int j = 0; j < order; j++) {
				System.out.print(matrix[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
		int[][] newMatrix = m.rotateMatrix(matrix, order);
		System.out.println("\nNew Matrix\n");
		for (int i = 0; i < order; i++) {
			for (int j = 0; j < order; j++) {
				System.out.print(newMatrix[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
	}

	private int[][] rotateMatrix(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				// save top
				int top = matrix[first][i];

				// left->top
				matrix[first][i] = matrix[last - offset][first];

				// bottom->left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right->bottom
				matrix[last][last - offset] = matrix[i][last];

				// top->right
				matrix[i][last] = top;

			}
		}
		return matrix;
	}

	/*
	 * private int[][] rotateMatrix(int[][] matrix, int order) { // int[][]
	 * cornerElements = secureCornerElements(matrix, order);
	 * 
	 * for (int i = 0; i < order; i++) { for (int j = i + 1; j < order - i; i++)
	 * { int temp = 0; matrix = rotateElements(matrix, i, j, order); } } return
	 * matrix; }
	 * 
	 * private int[][] rotateElements(int[][] matrix, int i, int j, int order) {
	 * int temp; temp = matrix[i][j]; matrix[i][j] = matrix[j][order - i - 1];
	 * matrix[j][order - i - 1] = matrix[order - i - 1][order - j - 1];
	 * matrix[order - i - 1][order - j - 1] = matrix[order - j - 1][i];
	 * matrix[order - j - 1][i] = temp; return matrix; }
	 */

	/*
	 * private int[][] secureCornerElements(int[][] matrix, int order) { int[][]
	 * cornerElements = new int[2][2]; cornerElements[0][0] = matrix[order][0];
	 * cornerElements[0][1] = matrix[0][0]; cornerElements[1][0] =
	 * matrix[order][order]; cornerElements[1][1] = matrix[0][order]; return
	 * cornerElements; }
	 */
}
