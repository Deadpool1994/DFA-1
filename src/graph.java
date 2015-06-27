import java.util.Scanner;


public class graph {

	vertex[] adjlist;
	char[] alphabet;
	int length;
	int n,num;

	
	public graph(){
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter number of States:");
		n= s.nextInt();
		adjlist = new vertex[n];
		length = n;
		System.out.println("States:");
		for(int i=0;i<n;i++)
		{
			adjlist[i] = new vertex(s.nextInt(),null,false);
		}
		
		System.out.println("enter the number of alphabets");
		num = s.nextInt();
		System.out.println("Enter the alphabets");
		alphabet = new char[num];
		String ex1 = s.nextLine();
		for(int i=0;i<num;i++){
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
        for (int v=0; v < length; v++) {
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
	        
	        
	        
	        for (int v=0; v < length; v++) {
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
	 
	 public void delete(){
		 
		 //System.out.println("Enter the node to be delete");
		 Scanner s = new Scanner(System.in);
		 //int node = indexForName(s.nextInt());
		 
		 System.out.println("The start state is:");
		 
		 int StartState = indexForName(s.nextInt());

		 
		 for(int i=0;i<adjlist.length;i++){
			 for(node nbr = adjlist[i].list;nbr!= null ; nbr = nbr.next){
				 int x =indexForName(nbr.destinationNode) ;
				 adjlist[x].flag = true;
			 }
		 }
		 
		 for(int i=0;i<adjlist.length;i++){
			 if(adjlist[i].flag == false && i!= StartState){
				 for(int j=i;j<adjlist.length-1;j++){
					 adjlist[j]=adjlist[j+1];
				 }
				 length--;
			 }
		 }
		 
	/*	 System.out.println(adjlist.length);
		 for(int i=node;i<adjlist.length-1;i++){
			 adjlist[i]=adjlist[i+1];
		 }
		 length--;*/
	 }
	 
	 public void makeTable(){
		 
		 char [][]table = new char [length][length];
		 //System.out.println(n+"+++"+num);
		 
		 System.out.println("Number of final state");
		 Scanner s = new Scanner(System.in);
		 int len = s.nextInt();
		 int []end = new int[len];
		 String ex = s.nextLine();
		 for(int i=0; i<len;i++){
			 String d=s.nextLine();
			 
			 end[i] = indexForName(Character.getNumericValue(d.charAt(0)));
			 System.out.println(end[i]);
		 }
		 
		 for(int i=0;i<length;i++){
			 for(int j=0;j<length;j++){
				 table[i][j]='*';
			 }
			
		 }
		 
	/*	 for(int i=0;i<len;i++){
			 
			 System.out.print(end[i]+ " ");
		 }
	*/	 
		 for(int i=0;i<len;i++){
			 for(int j=0;j<length;j++){
				 table[end[i]][j]='X';
				 table[j][end[i]]='X'; 				 
			 }
		 }
		 

		 for(int i=0;i<length;i++){
			 for(int j=0;j<length;j++){
				 
				 if(i<=j){
					 table[i][j]='Y';
				 }
				 
			 }
		 }
		 int count=0;
		 
		 for(int j=0;j<length;j++){
			 for(int i=0;i<length;i++){
				 
				 if(table[i][j]=='*'){
					 count++;
				 }
				 System.out.print(table[j][i]+" ");				 
			 }
			 System.out.println();
		 }
		 int flag=0;
		 int l=alphabet.length;
		 
		 while(flag!=count && count>-2){
			 flag=count;
			 System.out.println();
			 System.out.println(count);
			 
			 for(int j=0;j<length;j++){
				 for(int i=0;i<length;i++){
					 
					 if(j>i && table[j][i]=='*'){
						 
						 
						 
						 for(int k=0;k<l;k++){
							 
							 node state1 = adjlist[j].list;
							 node state2 = adjlist[i].list;
							 
							 while(state1!=null && state1.input != alphabet[k]){
								 state1 = state1.next;
							 }
							 while(state2!=null && state2.input != alphabet[k]){
								 state2 = state2.next;
							 }
							 if(state1!=null && state2!=null &&   state1.input==state2.input){
								 int row=indexForName(state1.destinationNode);
								 int col=indexForName(state2.destinationNode);
								 
								 if(row < col){
									 int tmp=row;
									 row = col;
									 col = tmp;
								 }
								 
								 System.out.println("the value of row = "+row+" and the value of col = "+col);
								 
								 if(table[row][col]!='*' && table[row][col]!='Y'){
									 table[j][i]='A';
									 count--;
								 }
								 
							 }
							 
							 
						 }
						 
					 }
					 
				 }
			 }
			 
			 
			 for(int i=0;i<length;i++){
				 for(int j=0;j<length;j++){
					 System.out.print(table[i][j]+" ");
				 }
				 System.out.println();
			 }
			 
			 System.out.println("should I continue");
			 
		 }
		

		 
		
		 
		 for(int i=0;i<length;i++){
			 for(int j=0;j<length;j++){
				 System.out.print(table[i][j]);
			 }
			 System.out.println();
		 }
		 
	 }
}
