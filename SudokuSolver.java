import java.util.*;

public class SudokuSolver {
    int[][] sudoku = new int[9][9];

        Scanner sd = new Scanner(System.in);
        void input(){
            for(int x=0; x<9; x++){
                for(int y=0; y<9; y++){
                    sudoku[x][y] = sd.nextInt();
                }
            }
        }
        void show(){
            for(int x=0; x<9; x++){
                for(int y=0; y<9; y++){
                    System.out.print(sudoku[x][y] + "  ");
                }
                System.out.println();
            }
            System.out.println();
        }
        SudokuSolver(){};
        SudokuSolver(int[][] sudoku){
            this.sudoku = sudoku;
        }

}
