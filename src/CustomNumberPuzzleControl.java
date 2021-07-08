import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here		
		int a=-1;

        for(int i=0;i<=15;i++)
        {
            if(buttons[i]==buttonClicked)
            {
                a=i;
                break;
            }
        }

        if((a+1==emptyCellId && (a+1)%4!=0) || (a-1) ==emptyCellId && (a%4!=0) || a+4==emptyCellId || a-4==emptyCellId)
        {
                swapButton(buttons[emptyCellId], buttonClicked);
                return a;
        }
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		int index=0;
		//Your logic here
		boolean here = false;
		while(index!=15) {
		int a = getRandomNumber();
		a = (a%15) + 1;
		for(int i=0;i<15;i++){
			if(arr[i]==a)
				here= true;
		}
		if(here==false) {
			arr[index]=a;
			index++;
		}
		here = false;
		}
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		
		int[] arr = getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<15;i++)
	            if(arr[i]!=i+1)
	                return false;
		
		return winner;
	}
}