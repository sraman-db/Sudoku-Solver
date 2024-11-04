public class Solver_main {
    public static boolean check_Row(SudokuSolver test, int i, int j){
        for (int col=0; col<9; col++){
            if (col == j) continue;
            if(test.sudoku[i][col] == test.sudoku[i][j] && test.sudoku[i][col] != 0){
                return false;
            }
        }
        return true;
    }
    public static boolean check_Column(SudokuSolver test, int i, int j){
        for (int row=0; row<9; row++){
            if (row == i) continue;
            if(test.sudoku[row][j] == test.sudoku[i][j] && test.sudoku[row][j] != 0){
                return false;
            }
        }
        return true;
    }
    public static int[] showgrid(int i, int j){
        if (i == 0 || i == 1 || i == 2){
            if (j == 0 || j == 1 || j == 2){
                return new int[] {0,0};
            }
            else if(j == 3 || j == 4 || j == 5){
                return new int[] {0, 3};
            }
            else{
                return new int[] {0, 6};
            }
        }
        else if (i == 3 || i == 4 || i == 5){
            if (j == 0 || j == 1 || j == 2){
                return new int[] {3,0};
            }
            else if(j == 3 || j == 4 || j == 5){
                return new int[] {3, 3};
            }
            else{
                return new int[] {3, 6};
            }
        }else{
            if (j == 0 || j == 1 || j == 2){
                return new int[] {6,0};
            }
            else if(j == 3 || j == 4 || j == 5){
                return new int[] {6, 3};
            }
            else{
                return new int[] {6, 6};
            }
        }
    }
    public static boolean checkgridBox(SudokuSolver test, int i, int j){
        int[] startingPt = showgrid(i, j);
        for(int row = startingPt[0]; row < startingPt[0] + 3; row++){
            for(int col = startingPt[1]; col < startingPt[1] + 3; col++){
                if (row == i && col == j) continue;
                if(test.sudoku[row][col] == test.sudoku[i][j] && test.sudoku[row][col] != 0){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean is_Valid_cell(SudokuSolver test){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if (check_Row(test, i, j) && check_Column(test, i, j) && checkgridBox(test, i, j)){
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isEmpty(int c){
        if (c >= 1 && c<= 9) return false;
        return true;
    }
    public static void solve(SudokuSolver test, int i, int j) {
        if (i == 8 && j == 9) {
            test.show();
            return;
        }
        if(j >= 9 && i < 8){
            solve(test, i+1,  0);
            return;
        }
        if(isEmpty(test.sudoku[i][j])){
            for(int val = 1; val <= 9; val++){
                test.sudoku[i][j] = val;
                if (check_Row(test, i, j) && check_Column(test, i, j) && checkgridBox(test, i, j)) {
                    solve(test, i, j+1);
                }
                test.sudoku[i][j] = 0;
            }
        } else {
            solve(test, i, j+1);
        }
    }
    public static void update_Result(int[][] result, int[][] solution) {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                solution[i][j] = result[i][j];
            }
        }
    }
    public static boolean get_firstsolution(SudokuSolver test, int i, int j, int[][] solution) {
        if (i == 8 && j == 9) {
            update_Result(test.sudoku, solution);
            return true;
        }
        if(j >= 9 && i < 8){
            if (get_firstsolution(test, i+1,  0, solution)) {
                return true;
            }
            return false;
        }
        if(isEmpty(test.sudoku[i][j])){
            for(int val = 1; val <= 9; val++){
                test.sudoku[i][j] = val;
                if (check_Row(test, i, j) && check_Column(test, i, j) && checkgridBox(test, i, j)) {
                    if (get_firstsolution(test, i, j+1, solution)) {
                        return true;
                    }
                }
                test.sudoku[i][j] = 0;
            }
        } else {
            if (get_firstsolution(test, i, j+1, solution)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        new GUI_ss();
    }
}