package rpg;
import java.util.Scanner;

public class GameLoop {
	static Scanner scanner = new Scanner(System.in);
	
	static Player player;
	
	public static int readInt(String prompt, int userChoices) {
		int input;
		
		do {
			System.out.println(prompt);
			try {
				input = Integer.parseInt(scanner.next());
			}catch(Exception e) {
				input = -1;
				System.out.println("entrez un nombre");
			}
		}while(input < 1 || input > userChoices);
		return input;
	}
	public static void clearConsole() {
		for(int i = 0; i < 100; i++) 
			System.out.println();
	}
	public static void printSeparator(int n) {
		for(int i = 0; i < n; i++) 
			System.out.print("-");
		System.out.println();
	}
	public static void printHeading(String title) {
		printSeparator(2);
		System.out.println(title);
		printSeparator(2);
		
	}
	
	public static void toContinue() {
		System.out.println("\ntaper commencer sur une touche pour continuer...");
		scanner.next();
	}
	
	public static void startGame() {
		boolean nameSet = false;
		String name;
		clearConsole();
		printSeparator(40);
		printSeparator(30);
		System.out.println("AGE OF DARKNESS");
		System.out.println("TEXT RPG BY YAMIL ISSA");
		printSeparator(30);
		printSeparator(40);
		toContinue();
		
		do {
			clearConsole();
			printHeading("entrez votre nom: ");
			name = scanner.next();
			clearConsole();
			printHeading("vous vous nommez" + " " + name + " " + ".\n c'est bien ça ?");
			System.out.println("(1) Yes!");
			System.out.println("(2) No je veux modifiez mon nom");
			int input = readInt("->", 2);
			if(input ==1) {
				nameSet = true;
			}
		}while(!nameSet);
		
		player = new Player(name);
		
		//start main game loop
		
	}

}
