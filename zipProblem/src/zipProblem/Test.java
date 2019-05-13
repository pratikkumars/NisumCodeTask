package zipProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Test {
	static int lastEnd =0;
	static int lastStart =0;
	static List<Range> modifiedList = new ArrayList<Range>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputZipRanges = sc.next();
		String inputZipRangeswithoutbrace = inputZipRanges.replaceAll("\\[", "");
		
		String[] a = inputZipRangeswithoutbrace.split("\\]");
		List <Range> l = new ArrayList<Range>();
		for(String m:a){
			String []b =m.split(",");
			Range r = new Range(Integer.parseInt(b[0]),Integer.parseInt(b[1]));
			l.add(r);
		}
		l.sort((o1,o2)->o1.getStart()-o2.getStart());
		
		ListIterator<Range> it = l.listIterator();
		
		
		while (it.hasNext() ) {
		  Range r1 = it.next();
		  if(l.size()>it.nextIndex()){
			  Range r2 = l.get(it.nextIndex());
			  if(r1.getEnd()>r2.getStart() && r1.getStart()>lastEnd){
				  if(r1.getEnd()<r2.getEnd()){
					  modifiedList.add(new Range(r1.getStart(),r2.getEnd())); 
					  lastEnd = r2.getEnd();
					  lastStart=r1.getStart();
				  }else{
					  addZipRangeInReationToLastaddedRange( r1);
					  
				  }
				  
				  it.next();
			  }else if(r1.getEnd()>r2.getStart() && r1.getStart()<lastEnd){
				  if(lastEnd<r2.getEnd()){
					  modifiedList.remove(modifiedList.size()-1);
					  modifiedList.add(new Range(lastStart,r2.getEnd())); 
					  lastEnd = r2.getEnd();
				  }
				  
				  it.next();
			  }
			  
			  else{
				  addZipRangeInReationToLastaddedRange( r1);
				  
			  }
		  }else{
			  addZipRangeInReationToLastaddedRange( r1);
			  
		  }
		}
		//printing modifiedList
		System.out.println();
		for(Range x:modifiedList){
			System.out.print("["+x.getStart()+","+x.getEnd()+"]");
		}
		
	}
	private static void addZipRangeInReationToLastaddedRange( Range r1) {
		if(r1.getStart()>lastEnd){
			  modifiedList.add(r1); 
			  lastEnd = r1.getEnd();
			  lastStart=r1.getStart();
		  }else{
			  if(r1.getEnd()>lastEnd){
				  modifiedList.remove(modifiedList.size()-1);
				  modifiedList.add(new Range(lastStart,r1.getEnd()));
				  lastEnd = r1.getEnd();
				  
			  }
		  }
	}

}

class Range {
	private int start;
	private int end;
	
	
	
	public Range() {
		
	}
	public Range(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}

}
