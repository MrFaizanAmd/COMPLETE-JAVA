public class MultiDimensionalArray {
    public static void main(String[] args) {
        // Create a 2D array
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Access elements in the 2D array
        System.out.println("Element at (1,1) in 2D array: " + matrix[1][1]);

        // Modify an element in the 2D array
        matrix[0][0] = 99;
        System.out.println("Modified 2D matrix: " + java.util.Arrays.deepToString(matrix));

        // Iterate through the 2D matrix
        System.out.println("Iterating through the 2D matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Create a 3D array
        int[][][] cube = {
            {
                {1, 2, 3},
                {4, 5, 6}
            },
            {
                {7, 8, 9},
                {10, 11, 12}
            },
            {
                {13, 14, 15},
                {16, 17, 18}
            }
        };

        // Access elements in the 3D array
        System.out.println("Element at (2,1,1) in 3D array: " + cube[2][1][1]);

        // Modify an element in the 3D array
        cube[1][0][2] = 42;
        System.out.println("Modified 3D array: " + java.util.Arrays.deepToString(cube));

        // Iterate through the 3D array
        System.out.println("Iterating through the 3D array:");
        for (int i = 0; i < cube.length; i++) {
            System.out.println("Layer " + i + ":");
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    System.out.print(cube[i][j][k] + " ");
                }
                System.out.println();
            }
        }
    }
}
