package zipProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import model.ZipRange;

public class ZipProblem {
	
	private List<ZipRange> modifiedList = new ArrayList<ZipRange>();
    private int lastAddedRangeEnd =0;
	private int lastAddedRangeStart =0;
	
	public String optimizingZipRages(String inputZipRanges){
		
		
		List <ZipRange> zipRanges = covertZipRangeStringInListOfZipRangeModel(inputZipRanges);
		ListIterator<ZipRange> it = zipRanges.listIterator();
		while (it.hasNext() ) {
			ZipRange r1 = it.next();
			
			  if(zipRanges.size()>it.nextIndex()){
				  ZipRange r2 = zipRanges.get(it.nextIndex());
				  if(r1.getEnd()>r2.getStart() && r1.getStart()>lastAddedRangeEnd){
					  if(r1.getEnd()<r2.getEnd()){
						  modifiedList.add(new ZipRange(r1.getStart(),r2.getEnd())); 
						  lastAddedRangeEnd = r2.getEnd();
						  lastAddedRangeStart=r1.getStart();
					  }else{
						  addZipRangeInReationToLastaddedRange( r1);
						  
					  }
					  
					  it.next();
				  }else if(r1.getEnd()>r2.getStart() && r1.getStart()<lastAddedRangeEnd){
					  if(lastAddedRangeEnd<r2.getEnd()){
						  modifiedList.remove(modifiedList.size()-1);
						  modifiedList.add(new ZipRange(lastAddedRangeStart,r2.getEnd())); 
						  lastAddedRangeEnd = r2.getEnd();
						  
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
		StringBuilder sb=new StringBuilder(); 
			for(ZipRange x:modifiedList){
				sb.append("["+x.getStart()+","+x.getEnd()+"]");
			}
		
		return sb.toString();
	}

	private List<ZipRange> covertZipRangeStringInListOfZipRangeModel(String inputZipRanges) {
		
		String inputZipRangeswithoutbrace = inputZipRanges.replaceAll("\\[", "");
		String[] a = inputZipRangeswithoutbrace.split("\\]");
		List <ZipRange> l = new ArrayList<ZipRange>();
		for(String m:a){
			String []b =m.split(",");
			ZipRange r = new ZipRange(Integer.parseInt(b[0]),Integer.parseInt(b[1]));
			l.add(r);
		}
		l.sort((o1,o2)->o1.getStart()-o2.getStart());
		return l;
	}

	private void addZipRangeInReationToLastaddedRange( ZipRange r1) {
		if(r1.getStart()>lastAddedRangeEnd){
			modifiedList.add(r1); 
			  
			lastAddedRangeEnd = r1.getEnd();
			lastAddedRangeStart=r1.getStart();
		  }else{
			  if(r1.getEnd()>lastAddedRangeEnd){
				  modifiedList.remove(modifiedList.size()-1);
				  modifiedList.add(new ZipRange(lastAddedRangeStart,r1.getEnd()));
				  lastAddedRangeEnd = r1.getEnd();
				  
			  }
		  }
	}
}
