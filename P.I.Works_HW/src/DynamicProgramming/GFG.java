package DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GFG {
	static int result;
	public static void main(String[] args) throws Exception
	{
	    maxTotalPath() ;
	}

	public static int[][] readFile() throws Exception
	{
		int size=decideSize();
	    ClassLoader loader = Thread.currentThread().getContextClassLoader() ;
	    InputStream file = loader.getResourceAsStream("q3.txt") ;

	    Scanner scan = new Scanner(file) ;

	    int[][] triangle = new int[size][size] ;
	    int m = 0, n = 0 ;
	    String line ;
	    while(scan.hasNext())
	    {
	        line = scan.nextLine() ;
	        String[] numbers = line.split(" ");

	        for(int i = 0 ; i < numbers.length ; i++)
	        {
	            triangle[m][n] = Integer.parseInt(numbers[i]) ;
	            n += 1 ;
	        }
	        n = 0 ;
	        m += 1 ;
	    }
	    scan.close() ;
	    file.close();
	    return triangle ;
	}

	public static void maxTotalPath() throws Exception
	{
	    int[][] arr = readFile() ;
	    for(int i=0;i<arr.length;i++) {
	    	System.out.println();
	    	for(int j=0;j<arr[i].length;j++) {
	    		System.out.print(arr[i][j]+"\t");
	    	}
	    }
	    int total=maxFound(arr,0,0);
	    System.out.println();
	    System.out.println("The maximum sum from top to bottom:");
	    System.out.println(total);
	}
	public static int maxFound(int[][] arr1,int row,int column) {
		int temp1=0,temp2=0;
		if(row<=arr1.length-1) {
		if(row==0 && column==0) {
			result+=arr1[row][column];
		}else {
		
		for(int l=2;l<=(arr1[row][column])/2;l++) {
    		if((arr1[row][column])%l==0 && arr1[row][column]!=0) {
    			temp1=arr1[row][column];
    			break;
    		}
    	}
		for(int f=2;f<=(arr1[row][column+1])/2;f++) {
    		if((arr1[row][column+1])%f==0 && arr1[row][column+1]!=0) {
    			temp2=arr1[row][column+1];
    			break;
    		}
    	
    	}
		//System.out.print(arr1[row][column]+" "+arr1[row][column+1]);
		//System.out.println();
		if(temp2==Math.max(temp1, temp2)) {
			column+=1;}
		
		}
		
		}
		else {
			return result;
		}
		
		result+=Math.max(temp1, temp2);
		//System.out.println(result);
		return maxFound(arr1,row+1,column);
	}
	public static int decideSize() throws IOException {
		int lineNumber=0;
    	FileInputStream file=new FileInputStream("src\\q3.txt");
    	BufferedReader br=new BufferedReader(new InputStreamReader(file));
    	while(br.readLine()!=null) {
    		lineNumber++;
    	}
    	br.close();
    	file.close();
    	return lineNumber;
	}

}
