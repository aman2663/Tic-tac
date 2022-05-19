import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tic_Tac {
	static ArrayList<Integer> player=new ArrayList<>();
	static ArrayList<Integer> cpu=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char gameboard[][]= {{' ','|',' ','|',' '},
							{'-','+','-','+','-'},
							{' ','|',' ','|',' '},
							{'-','+','-','+','-'},
							 {' ','|',' ','|',' '}};
		print(gameboard);
		Scanner ob=new Scanner(System.in);
		Random rand=new Random();
		while(true)
		{
			System.out.print("Enter position from 1-9:");
			int playerpos=ob.nextInt();
			while(player.contains(playerpos)||cpu.contains(playerpos))
			{
				System.out.print("Please Enter new position,This one is already occupied:");
				playerpos=ob.nextInt();
			}
			placepiece(gameboard,playerpos,"player");
			String result=checkWinner();
			if(result.length()>0)
			{
				System.out.println(result);
				break;
			}
			int cpupos=rand.nextInt(9)+1;
			while(player.contains(cpupos)||cpu.contains(cpupos))
			{
				cpupos=rand.nextInt(9)+1;
			}
			placepiece(gameboard,cpupos,"cpu");
			result=checkWinner();
			if(result.length()>0)
			{
				System.out.print(result);
				break;
			}
			print(gameboard);
		}
	}
	public static void print(char gameboard[][])
	{
		for(char row[]:gameboard)
		{
			for(char c:row)
				System.out.print(c);
			System.out.println();
		}
	}
	public static void placepiece(char gameboard[][],int pos,String user)
	{
		char symbol;
		if(user.equals("player"))
			{
				player.add(pos);
				symbol='X';
			}
		else
			{
				cpu.add(pos);
				symbol='O';
			}
		switch(pos)
		{
			case 1:
				gameboard[0][0]=symbol;
				break;
			case 2:
				gameboard[0][2]=symbol;
				break;
			case 3:
				gameboard[0][4]=symbol;
				break;
			case 4:
				gameboard[2][0]=symbol;
				break;
			case 5:
				gameboard[2][2]=symbol;
				break;
			case 6:
				gameboard[2][4]=symbol;
				break;
			case 7:
				gameboard[4][0]=symbol;
				break;
			case 8:
				gameboard[4][2]=symbol;
				break;
			case 9:
				gameboard[4][4]=symbol;
				break;
			default:
				break;
		}
	}
	public static String checkWinner()
	{
		List<Integer> top=Arrays.asList(1,2,3);
		List<Integer> mid=Arrays.asList(4,5,6);
		List<Integer> bottom=Arrays.asList(7,8,9);
		List<Integer> left=Arrays.asList(1,4,7);
		List<Integer> midc=Arrays.asList(2,5,8);
		List<Integer> right=Arrays.asList(3,6,9);
		List<Integer> cross1=Arrays.asList(1,5,9);
		List<Integer> cross2=Arrays.asList(3,5,7);
		List<List> winning=new ArrayList<List>();
		winning.add(top);
		winning.add(mid);
		winning.add(bottom);
		winning.add(left);
		winning.add(midc);
		winning.add(right);
		winning.add(cross1);
		winning.add(cross2);
		for(List l:winning)
		{
			if(player.containsAll(l))
				return "Congratulation! You Won.";
			else if(cpu.containsAll(l))
				return "Cpu Won! Sorry (.";
			else if(player.size()+cpu.size()==9)
				return "Tie";
		}
		return "";	
	}
}
