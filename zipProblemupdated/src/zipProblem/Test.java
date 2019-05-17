package zipProblem;

import java.util.Scanner;


public class Test {
	
	public static void main(String[] args) {
		System.out.println("enter zipranges [a,b][c,d]... format");
		Scanner sc = new Scanner(System.in);
		String inputZipRanges = sc.next();
		
		ZipProblem solInstance = new ZipProblem();
		System.out.println(solInstance.optimizingZipRages(inputZipRanges));	
	}
	

}


