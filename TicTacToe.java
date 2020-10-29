import java.util.Scanner;
class Game {

	//initializing Data Structure which are going to be used
	private static int[] rows;
	private static int[] cols;
	private static int diag;
	private static int antiDiag;
	private static String[][] matrix;
	
	Game(int size) {
	//default allocations
		rows = new int[size];
		cols = new int[size];
		diag = 0;
		antiDiag = 0;
	}
	
	
	public void printArray() {
	//printer function to just print matrix of game
		System.out.println();
		for (int i = 0;i < 3 ;i++){
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				
				System.out.print(matrix[i][j]+" |");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void startGame() {
		matrix = new String[3][3];
				
		for (int i = 0;i < 3 ;i++){
			for (int j = 0; j < 3; j++) {
				matrix[i][j] = " ";
			}
		}
		System.out.println("********* Game Started *********");
	}
	public int move(int row, int col, int player){
		if(player == 0){
			matrix[row][col] = "X";
		}
		else if(player == 1){
			matrix[row][col] = "O";
		}
		int playerValue = (player == 0) ? 1 : -1;
		
		
		if (row == col) {
			diag += playerValue;
		}
		if (row + col == cols.length -1) {
			antiDiag += playerValue;
		}
		
		rows[row] += playerValue;
		cols[col] += playerValue;
		
		int size = cols.length;
		
		if(Math.abs(diag) == size || Math.abs(antiDiag) == size || Math.abs(rows[row]) == size || Math.abs(cols[col]) == size)
		return player;
		
		return -10;
	}
}

class TicTacToe {
	public static void main(String[] args)throws Exception {
		System.out.println("This is Tic Tac Toe game for two players ");
		Scanner input = new Scanner(System.in);
		int size = 3;
		int player = 1;
		int row =0 ;
		int col = 0;
		boolean flag = true;
		Game obj = new Game(size);
		obj.startGame();
		System.out.println("Enter valid range from 0 to 2");
		for (int i = 0; i < size * size ; i++) {
			player = (player+1)%2;
			System.out.println("Enter row and col value player : "+player);
			row = input.nextInt();
			col = input.nextInt();
			
			
		
			int val = obj.move(row,col,player);
			obj.printArray();
			Thread.sleep(2500);
			new ProcessBuilder("clear").inheritIO().start().waitFor();
			if(val == 0){
				flag = false;
				System.out.println("********** \t Player one wins \t *********");
				break;
			}
			else if(val == 1){
				flag = false;
				System.out.println("********** \t Player 2 wins \t **********");
				break;
			}			
			
		}
		if(flag)
		System.out.println("********* \t Game Draw \t *********");
		input.close();
	}
}
