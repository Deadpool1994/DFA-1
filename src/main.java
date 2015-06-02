import java.util.Scanner;


public class main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner sc = new Scanner(System.in);
        //System.out.print("Enter graph input file name: ");
        //String file = sc.nextLine();
        graph g = new graph();
        g.print();
		g.check();
		
	}

}
