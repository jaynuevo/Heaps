import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Heap {
	public int size,num;
	public int [] mH;
	boolean end=false, fromLeft, cross=false;
	public int position;
	public Heap(){
		String input;
		int[] arrA = null;
		Scanner scan = new Scanner(System.in);
		int index = 0;
		System.out.println("Start with [0 or n]?");
		
		input = scan.nextLine();
		
		if(input.equals("n")){
			System.out.println("Input array of size n: ");
			input = scan.nextLine();
			
			String[] parts = input.split(",");
			arrA = new int[parts.length];
			
			for(int i=0; i < parts.length; i++){
				arrA[i] =  Integer.parseInt(parts[i]);
			}

			System.out.println("Input accepted. Size of n set to " +parts.length);
			System.out.println("Choose heap order [ma(x) or mi(n)]: ");
			input = scan.nextLine();
			
			size = arrA.length;
			mH = new int [size+1];
			position = 0;
			
			if(input.equals("n")){
				createHeapMin(arrA);
				display();
				displayTree();
				while(true){
					System.out.println("Choose operation [(D)elete | (I)nsert | (E)xit]");
					input = scan.nextLine();
				
					if(input.equals("I") || input.equals("i")){
						System.out.println("Insert what?");
						num = scan.nextInt();
						scan.nextLine();
					
						mH = Arrays.copyOf(mH,  mH.length+1);
					
						mH[position++] = num;
						System.out.println("CURENT POS IS" +position);
						bubbleUpMin();
						display();
					}
				
				
					else if(input.equals("D") || input.equals("d")){
						System.out.println("Delete what?");
						num = scan.nextInt();
						scan.nextLine();
					
					//int index;
					
						for(int j =0 ; j< mH.length; j++){
							if(mH[j] == num){
								index = j;
								break;
							}
							else 
								continue;
						}
						
						mH[index] = mH[mH.length-1];
						position--;
						sinkDownMin(index);
						mH = Arrays.copyOf(mH,  mH.length-1);
						display();
					}
					
					else if(input.equals("E") || input.equals("e")){
						System.exit(1);
					}
				
				}
			}
			else if(input.equals("x")){
				createHeapMax(arrA);
				display();
				displayTree();
				while(true){
					System.out.println("Choose operation [(D)elete | (I)nsert | (E)xit]");
					input = scan.nextLine();
				
					if(input.equals("I") || input.equals("i")){
						System.out.println("Insert what?");
						num = scan.nextInt();
						scan.nextLine();

						mH = Arrays.copyOf(mH,  mH.length+1);
					
						mH[position++] = num;
						System.out.println("CURENT POS IS" +position);
						bubbleUpMax();
						display();
					}
				
				
					else if(input.equals("D") || input.equals("d")){
						System.out.println("Delete what?");
						num = scan.nextInt();
						scan.nextLine();
				
					//int index;
					
						for(int j =0 ; j< mH.length; j++){
							if(mH[j] == num){
								index = j;
								break;
							}
							else 
								continue;
						}
					
						mH[index] = mH[mH.length-1];
						position--;
						sinkDownMax(index);
						mH = Arrays.copyOf(mH,  mH.length-1);
						display();
					}
					else if(input.equals("E") || input.equals("e")){
						System.exit(1);
					}
				
				}
			}
			
		}
		
		
		else if(input.equals("0")){

			System.out.println("Choose heap order [ma(x) or mi(n)]: ");
			input = scan.nextLine();
			
			mH = new int [0];
			//arrA = new int[0];
			position = 0;
			
			if(input.equals("n")){
				//createHeapMin(arrA);
				//display();
				while(true){
					
					System.out.println("Choose operation [(D)elete | (I)nsert | (E)xit]");
					input = scan.nextLine();
				
					if(input.equals("I") || input.equals("i")){
						System.out.println("Insert what?");
						num = scan.nextInt();
						scan.nextLine();
					
						if(mH.length == 0){
							mH = Arrays.copyOf(mH,  mH.length+2);
							//System.out.println(mH.length);
							mH[position+1]=num;
							position = 2;
							displayTree();
							continue;
						}
						
						mH = Arrays.copyOf(mH,  mH.length+1);
					//System.out.println("NEW SIZE IS: " + mH.length);
						mH[position++] = num;
						System.out.println("CURENT POS IS" +position);
						bubbleUpMin();
						display();
						displayTree();
					}
				
				
					else if(input.equals("D") || input.equals("d")){
						System.out.println("Delete what?");
						num = scan.nextInt();
						scan.nextLine();
					
					//int index;
					
						for(int j =0 ; j< mH.length; j++){
							if(mH[j] == num){
								index = j;
								break;
							}
							else 
								continue;
						}
						
						mH[index] = mH[mH.length-1];
						position--;
						sinkDownMin(index);
						mH = Arrays.copyOf(mH,  mH.length-1);
						display();
						displayTree();
					}
					else if(input.equals("E") || input.equals("e")){
						System.exit(1);
					}
				
				}
			}
			else if(input.equals("x")){
				
				while(true){
					System.out.println("Choose operation [(D)elete | (I)nsert | (E)xit]");
					input = scan.nextLine();
				
					if(input.equals("I") || input.equals("i")){
						System.out.println("Insert what?");
						num = scan.nextInt();
						scan.nextLine();

						
						
						if(mH.length == 0){
							mH = Arrays.copyOf(mH,  mH.length+2);
							//System.out.println(mH.length);
							mH[position+1]=num;
							position = 2;
							displayTree();
							continue;
						}
						
						
						
						
						mH = Arrays.copyOf(mH,  mH.length+1);
					
						mH[position++] = num;
						System.out.println("CURENT POS IS" +position);
						bubbleUpMax();
						display();
						displayTree();
					}
				
				
					else if(input.equals("D") || input.equals("d")){
						System.out.println("Delete what?");
						num = scan.nextInt();
						scan.nextLine();
				
					//int index;
					
						for(int j =0 ; j< mH.length; j++){
							if(mH[j] == num){
								index = j;
								break;
							}
							else 
								continue;
						}
					
						mH[index] = mH[mH.length-1];
						position--;
						sinkDownMax(index);
						mH = Arrays.copyOf(mH,  mH.length-1);
						display();
						displayTree();
					}
					else if(input.equals("E") || input.equals("e")){
						System.exit(1);
					}
				
				}
			}
		}
		
		
		
		
	/*	Heap m = new Heap(arrA.length);
		System.out.print("\nMin-Heap : ");
		m.createHeap(arrA);		
		m.display();
		System.out.print("Extract Min :");
		for(int i=0;i<arrA.length;i++){
			System.out.print("  " + m.extractMin());
		}*/

	
	}
	public void createHeapMin(int [] arrA){
		if(arrA.length>0){
			for(int i=0;i<arrA.length;i++){
				insertMin(arrA[i]);
			}
		}		
	}
	public void display(){
		for(int i=1;i<mH.length;i++){
			System.out.print(" " + mH[i]);			
		}
		System.out.println("");
	}
	
	
	public void displayTree(){
		int i=0;
		System.out.print("( " +mH[1] +" (");
		
			i++;
			par(i);
			if(mH.length!=2){
			System.out.println("");
			System.out.println("    ))");
			System.out.println("))");
			
			}
			
		
	}
	
	
	public void par(int i){
		int tmp, index;
		String s ="    ";
		
		
		try{
			index = i*2;
			tmp = mH[index];
			System.out.print("\n"  +String.join("", Collections.nCopies(i, s))      +"( " +tmp +" ( ");
			
			i++;
			fromLeft = true;
			cross = false;
			par(index);
			//if(end==false)
			//System.out.println("");
			if(fromLeft == false || cross == true){
				System.out.println(String.join("", Collections.nCopies(i-1, s)) +"))");
				end = false;
			}
			
			//i--;
				fromLeft = true;
				cross =true;
			parRight(i, index+1);
			//par(index);
			//parRight(i, index+1);
			
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.print("))");
			System.out.println("");
			end = true;
			//System.out.println(String.join("", Collections.nCopies(i-1, s)) +")ho)");
			
		}

		
	}
	
	
	public void parRight(int i, int indx){
		int tmp, index;
		String s ="    ";
		
		try{
			index = indx;
			tmp = mH[index];
			//System.out.println("TMP IS "+(i*2+1));
			//System.out.println(tmp);
			//if((i*2+1) != mH.length-1)
			
			//System.out.println("LAST NUM IS "+i);
			System.out.print("\n"  +String.join("", Collections.nCopies(i-1, s))      +"( " +tmp +" ( ");
			fromLeft = false;
			par(index);
			
			//if(i!=1)
			//parRight(i, index*2+1);
			//System.out.println("I is : "+i);
			//i--;
			//parRight(index);
			//i--;
		}
		catch(ArrayIndexOutOfBoundsException e){
			//System.out.print("      ( " +mH[i*2] +" (");
			//System.out.println("))");
			//System.out.println(String.join("", Collections.nCopies(i-1, s)) +")ho)");
			end = true;
			
		}
	}
	
	
	
	
	
	
	public void insertMin(int x){
		if(position==0){
			mH[position+1]=x;
			position = 2;
		}else{
			mH[position++]=x;
			bubbleUpMin();
		}
	}
	public void bubbleUpMin(){
		int pos = position-1;
		//System.out.println(pos);
		//System.out.println(mH[pos/2]);
		//System.out.println(mH[pos]);
		while(pos>0 && mH[pos/2]>mH[pos]){
			int y = mH[pos];
			mH[pos]=mH[pos/2];
			//System.out.println("child is " +mH[pos]);
			
			mH[pos/2] = y;
			//System.out.println("parent  is " +mH[pos/2]);
			pos = pos/2;
			//System.out.println("pos is" +pos);
		}
	}
	
	
	
	
	
	
	public void createHeapMax(int [] arrA){
		if(arrA.length>0){
			for(int i=0;i<arrA.length;i++){
				insertMax(arrA[i]);
			}
		}		
	}

	public void insertMax(int x){
		if(position==0){
			mH[position+1]=x;
			position = 2;
		}else{
			mH[position++]=x;
			//System.out.println("ANOTHER");
			bubbleUpMax();
		}
	}
	public void bubbleUpMax(){
		int pos = position-1;
		while(pos>0 && mH[pos/2]<mH[pos] && pos/2!=0){
			int y = mH[pos];
			mH[pos]=mH[pos/2];
			//System.out.println("child is " +mH[pos]);
			
			mH[pos/2] = y;
			//System.out.println("parent  is " +mH[pos/2]);
			pos = pos/2;
			//System.out.println("pos is" +pos);
		}
	}
	
	
	
	
	
	/*public int extractMin(){
		int min = mH[1];
		mH[1]=mH[position-1];
		mH[position-1]=0;
		position--;		
		sinkDown(1);
		return min;
	}*/
	
	public void sinkDownMin(int k){
	  int a = mH[k];
		int smallest =k;
		if(2*k<position && mH[smallest]>mH[2*k]){
			smallest = 2*k;
		}
		if(2*k+1<position && mH[smallest]>mH[2*k+1]){
			smallest = 2*k+1;
		}
		if(smallest!=k){
			swap(k,smallest);
			sinkDownMin(smallest);
		}
				
	}
	
	
	public void sinkDownMax(int k){
		  int a = mH[k];
			int big =k;
			if(2*k<position && mH[big]<mH[2*k]){
				big = 2*k;
			}
			if(2*k+1<position && mH[big]<mH[2*k+1]){
				big = 2*k+1;
			}
			if(big!=k){
				swap(k,big);
				sinkDownMax(big);
			}
					
		}
	
	public void swap(int a, int b){
		int temp = mH[a];
		mH[a] = mH[b];
		mH[b] = temp;
	}
	
	public static void main(String args[]){	
		new Heap();
		
	}
	
		
}