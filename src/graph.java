import java.util.Scanner;


public class graph {

	vertex[] adjlist;
	
	public graph(){
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter number of nodes:");
		int n= s.nextInt();
		adjlist = new vertex[n];
		for(int i=0;i<n;i++)
		{
			adjlist[i] = new vertex(s.nextInt(),null);
		}
		System.out.println("enter the number of relations");
		int relation = s.nextInt();
		//System.out.println("reltion"+relation);
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
	        
	        if(adjlist[0].list == null)
	        {
	        	System.out.println("hey "+adjlist[0].vNumber);
	        }
	        
	        for (int v=0; v < adjlist.length; v++) {
	            System.out.print(adjlist[v].vNumber);
	            for (node nbr=adjlist[v].list; nbr != null;nbr=nbr.next) {
	                System.out.print(" --> " + nbr.input +nbr.destinationNode);
	            }
	            System.out.println("\n");
	        }
	    }
	
	
}
