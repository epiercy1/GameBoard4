
public class IsolaTextView {
	private IsolaBoard board;
	public IsolaTextView(IsolaBoard board) {
		this.board = board;
	}
	public void display() {
		for(int row = 0; row < board.getHeight(); row++) {
			for(int col = 0; col < board.getWidth(); col++) {
				BoardSpace which = board.get(row, col);
				if(which == BoardSpace.Player1)
					System.out.print("1");
				if(which == BoardSpace.Player2)
					System.out.print("2");
				else
					System.out.print("_");
			}
		}
	}
}
