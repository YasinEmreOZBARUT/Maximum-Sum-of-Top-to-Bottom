package DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GFG {
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
	    return triangle ;
	}

	public static void maxTotalPath() throws Exception
	{
	    int[][] arr = readFile() ;
	    for (int i = arr.length - 2 ; i >= 0 ; i--) 
	    {
	    	for (int j = 0 ; j < arr[i].length; j++) 
	    	{
	    	    if (j != arr[i].length-1) {
	    	        arr[i][j] += Math.max(arr[i + 1][j], arr[i + 1][j + 1]); 
	    	    } else {
	    	        arr[i][j] += arr[i+1][j];
	    	    }
	    	}
	    }
	    System.out.println(Integer.toString(arr[0][0])) ;
	}
	public static int decideSize() throws IOException {
		int lineNumber=0;
    	FileInputStream file=new FileInputStream("src\\q3.txt");
    	BufferedReader br=new BufferedReader(new InputStreamReader(file));
    	while(br.readLine()!=null) {
    		lineNumber++;
    	}
    	br.close();
    	return lineNumber;
	}

}
