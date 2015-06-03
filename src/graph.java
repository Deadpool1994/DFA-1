import java.util.Scanner;


public class graph {

	vertex[] adjlist;
	char[] alphabet;
	
	public graph(){
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter number of States:");
		int n= s.nextInt();
		adjlist = new vertex[n];
		System.out.println("States:");
		for(int i=0;i<n;i++)
		{
			adjlist[i] = new vertex(s.nextInt(),null);
		}
		
		System.out.println("enter the number of alphabets");
		int num = s.nextInt();
		System.out.println("Enter the alphabets");
		alphabet = new char[n];
		String ex1 = s.nextLine();
		for(int i=0;i<n;i++){
			String cut = s.nextLine();
			alphabet[i]=cut.charAt(0);
		}
		
		System.out.println("enter the number of transitions");
		int relation = s.nextInt();
		System.out.println("Enter the Transitions in this form: Character firststate secondstate");
		String ex = s.nextLine();
		while(relation != 0){
			
			String l= s.nextLine();
			
			char a=l.charAt(0);
			int v1 = indexForName(Character.getNumericValue(l.charAt(2)));
			//System.out.println("h"+v1);
			//int v2 = indexForName(Character.getNumericValue(l.charAt(4)));
			int v2 = Character.getNumericValue(l.charAt(4));
			
			adjlist[v1].list = new node(a, v2, adjlist[v1].list);
			
			relation--;
		}	
	}
	
	int indexForName(int vadd) {
        for (int v=0; v < adjlist.length; v++) {
            if (adjlist[v].vNumber == vadd) {
                return v;
            }
        }
        return -1;
    }   
	
	
	 public void print() {
	        System.out.println();
	        
	        /*if(adjlist[0].list == null)
	        {
	        	System.out.println("hey "+adjlist[0].vNumber);
	        }*/
	        
	        
	        
	        for (int v=0; v < adjlist.length; v++) {
	            System.out.print(adjlist[v].vNumber);
	            for (node nbr=adjlist[v].list; nbr != null;nbr=nbr.next) {
	                System.out.print(" --> " + nbr.input +nbr.destinationNode);
	            }
	            System.out.println("\n");
	        }
	    }
	 
	 public void check(){
		 
		 
		 
		 System.out.println("The string is:");
		 Scanner s = new Scanner (System.in);
		 String check = s.nextLine();
		 int flag = 0;
		 for(int i=0;i<check.length();i++){
			 for(int j=0;j<alphabet.length;j++){
				 if(check.charAt(i)==alphabet[j]){
					 flag = 1;
				 }
			 }
			 if(flag == 1){
				 flag = 0;
			 }
			 else{
				 System.out.println("the string is out of the alphabet");
				 System.exit(0);
			 }
		 }
		 
		 System.out.println("The start state is:");
		 
		 int StartState = indexForName(s.nextInt());
		 
		 System.out.println("The number of final states :");
		 int k = s.nextInt();
		 int []finalState = new int[k];
		 for(int i=0;i<k;i++){
			 finalState[i]= indexForName(s.nextInt());
		 }
		 //int finalState = indexForName(s.nextInt());
		 
		 for(int i=0;i<check.length();i++){
			 
			 node cState = adjlist[StartState].list;
			 
			 while(cState.input != check.charAt(i)){
				 
				 cState = cState.next;
				 
			 }
			 if (cState.input == check.charAt(i)){
				 StartState = indexForName(cState.destinationNode);
			 }
			 
		 }
		 int completeFlag = 0;
		 for(int i=0;i<k;i++){
			 if (StartState == finalState[i]){
				 completeFlag = 2;
				 System.out.println("Yes!!!  Yes It is accepted");
			 }
		 }
		 
		 if (completeFlag == 0){
			 System.out.println("String is not accepted");
		 }
		 
		 
	 }
	
	
}
