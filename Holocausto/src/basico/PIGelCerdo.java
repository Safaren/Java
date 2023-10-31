package pigElCerdo;

import java.util.Random;
import java.util.Scanner;


public class PIGelCerdo {
	
	
	//colores
	static String blue = "\u001B[36m";
	static String yellow ="\u001B[33m";
	static String red = "\u001B[1;31m";
	static String green = "\u001B[32m";
	static String purple = "\u001B[35m";
	
	//function that clears the screen and restarts the terminal so that the colors can be seen
	public static void clearScreen() {
	    try {
	        if (System.getProperty("os.name").contains("Windows")) {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        } else {
	            System.out.print("\033[H\033[2J");
	            System.out.flush();
	        }
	    } catch (Exception e) {
	        // Manejo de excepciones
	    }
	}
	
	// function to roll the dice
	public static int thorwTheDie(Player player)
	{
		//
		Random rand = new Random();
		
		int dieRand = rand.nextInt(6)+1;
		
		System.out.println("Tirada de dado " + player + " = " + dieRand);
		
		
		return dieRand;
		
	}
	
	
	// function that checks if the player has won
	public static boolean winner(Player player, int point)
	{
		if (player.getPoints() + point >= 100)
		{
			System.out.println(red + "Ha ganado "+ yellow + player  );
			return true;
		}
		return false;
		
	}
	
	//function to choose the name of the player
	public static void chooseName(Player player, Scanner name)
	{
		System.out.println("Escribe tu nombre: ");
		String sname = player.getName() + name.nextLine();  
		player.setName(sname);
		
	}
	
	//function to restart dice rolls
	public static void emptyall(Player player)
	{
		for (int i=0;i < player.getDie().length;i++ )
		{
			player.getDie()[i]=0;
		}
	}
	
	//function to display points
	public static void scorePoints(Player player, int turn)
	{
		for (int i = 0;i <= turn;i++)
		{
			player.setPoints(player.getDie()[i] + player.getPoints());
			
			
		}
		
		
	}
	

	//
	public static void pulling()
	{
		
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	
	}
	
	public static void turn(Player player, int sum)
	{
		System.out.println(purple +"\nPuntos temporales conseguido del  " + yellow + player + red + " ("  + sum + ")\n");
		System.out.println(blue + "Tu turno "+ yellow + player + blue + " , tira el dado, pulsa Enter");
	}
	
	public static void displayPoint(Player player)
	{
		System.out.println(purple + "Puntos totales de " + yellow + player + ": " + red + player.getPoints());
	}
	
	
	
	
	public static void main(String[] args) {
		
		clearScreen();
		
		//Create players
		Player machine = new Player(0, "Máquina");
		Player human = new Player(0, "jugador ");
		
		boolean turn_human = true;
		byte next_thorw = 0; //dice roll counter
		
		int tem_point = 0; //
		int sum_tem_point = 0;
		boolean playing = true;
		byte tem_point_machine = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		chooseName(human, scanner);
		
		while (playing)
		{
			displayPoint(human);
			displayPoint(machine);
			
			while (turn_human) {
				
				turn(human, sum_tem_point);
				
				scanner.nextLine();
				tem_point = thorwTheDie(human);
				sum_tem_point += tem_point;
				
				if (tem_point == 1) 
				{
					turn_human = false;
				}
				
				else
				{
					human.getDie()[next_thorw] = tem_point;
					next_thorw += 1; 
					playing = !winner(human,sum_tem_point);
					turn_human = playing;
					if (playing) {
					System.out.println(green +"Cualquier tecla para seguir tirando el dado para pasar turno no ("+ red + "n"+ green + ")");
					String option = scanner.nextLine().toLowerCase();
					
					
						switch (option) 
						{
						case "s":
							
							break;
						case "n":
							
							scorePoints(human, next_thorw);
							
							turn_human = false;
							break;
					}
					}
				}			
			
			}
			next_thorw = 0; 
			tem_point_machine = 0;
			sum_tem_point = 0;
			
			
			while (!turn_human && playing)
			{

				displayPoint(human);
				displayPoint(machine);
				
				turn(machine, tem_point_machine);
				
				tem_point = thorwTheDie(machine);
				machine.setDie(next_thorw, tem_point);
				pulling();
				
				
				if (tem_point == 1) 
				{
					turn_human = true;
				}
				else
				{
				
					tem_point_machine = 0;
				
					for (int i = 0; i <= next_thorw; i++)
					{
						tem_point_machine += machine.getDie()[i];
					}
					
					if (tem_point_machine < 15)
					{
						if (next_thorw < 6 && human.getPoints() < machine.getPoints())
						{
							System.out.println(green + "La maquina decide tirar otra vez");
						}
						else if (next_thorw < 4)
						{
							System.out.println(green + "La maquina decide tirar otra vez");
						}
						else 
						{
							System.out.println(green + "La maquina decide pasar turno");
							turn_human = true;
						}
				}	
				
					else 
					{
						System.out.println(green + "La maquina decide pasar turno");
						turn_human = true;
					}
				
				
				playing = !winner(machine,tem_point_machine);
				
				if (turn_human && tem_point != 1  )
				{
					scorePoints(machine,next_thorw);
				}
				
				
				
				next_thorw += 1;
			}
			
			
			
		}
			emptyall(human);
			emptyall(machine);
			tem_point_machine = 0;
			next_thorw = 0;
			
			
			if (!playing)
			{
				System.out.println(purple + "¿Otra partida? Si(s) No (cualquier otra tecla) ");
				String option = scanner.nextLine().toLowerCase();
				switch (option)
				{
				case "s": 
					human.setPoints(0);
					machine.setPoints(0);
					playing = true;
					
					break;
				default:
					break;
				}
			}
			
		
		
	}
		scanner.close();
	}
}


