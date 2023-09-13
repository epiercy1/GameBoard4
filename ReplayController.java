import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class ReplayController {
	public static void main(String[] args) {
		ReplayController controller = new ReplayController();
		controller.go();
	}
	
	public void go() {
		File file = new File("output.dat");
		Scanner input = null;
		try {
			input = new Scanner(file);
		}
		catch(FileNotFoundException e) {
			System.out.println("Could not create output.dat");
			return;
		}
		IsolaBoard board = new IsolaBoard();
		IsolaTextView view = new IsolaTextView(board);
		BoardSpace current = BoardSpace.Player1;
		while(board.checkWinner() == BoardSpace.Available) {
			view.display();
			String move = makeMove(current, board);
			input.next(move);
			makeMove(current, board);
			if(current == BoardSpace.Player1)
				current = BoardSpace.Player2;
			else
				current = BoardSpace.Player1;
			System.out.println("Player " + board.checkWinner() + "won.");
			
		}
			
		input.close();
		
			}
			public String makeMove(BoardSpace current, IsolaBoard board) { 
				Scanner input = new Scanner(System.in);
				boolean moveMade = false;
				//while(! moveMade){
					System.out.print("Enter the row numberfor your move: ");
					int row = input.nextInt();
					System.out.print("Enter the column number for your move: ");
					int col = input.nextInt();
					board.movePlayer(current, new BoardPosition(row, col));
					return ""+row + " "+col;
			
			
		//}
		
		
		
		
		
	}
}
