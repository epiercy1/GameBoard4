import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class TwoPlayerController {
	public static void main(String[] args) {
		TwoPlayerController controller = new TwoPlayerController();
		controller.go();
	}
	
	
	public void go() {
		IsolaBoard board = new IsolaBoard();
		IsolaTextView view = new IsolaTextView(board);
		BoardSpace current = BoardSpace.Player1;
		File file = new File("output.dat");
		PrintWriter output = null;
		try {
			output = new PrintWriter(file);
		}
		catch(FileNotFoundException e) {
			System.out.println("Could not create output.dat");
			return;
		}
		while(board.checkWinner() == BoardSpace.Available) {
			view.display();
			String move = makeMove(current, board);
			if(current == BoardSpace.Player1)
				current = BoardSpace.Player2;
			else
				current = BoardSpace.Player1;
			System.out.println("Player " + board.checkWinner() + "won.");
			output.println(move);
		}
			
		output.close();
		
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
