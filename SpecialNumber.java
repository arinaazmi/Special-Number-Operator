package lab3;

import java.util.*;

public abstract class SpecialNumber {
	
	public abstract SpecialNumber add(SpecialNumber N) throws Lab3Exception;
	
	public abstract SpecialNumber divideByInt(int x) throws Lab3Exception;
	
	/**
	 * This method computes the average of a list of type SpecialNumber.
	 * 
	 * @param lis the list of SpecialNumber that the average will be taken of
	 * @return average of the list of SpecialNumbers  
	 * @throws Lab3Exception "List cannot be empty" if list is empty
	 */
	
	public static SpecialNumber computeAverage(List<SpecialNumber> lis) throws Lab3Exception {
		
		
		if ((lis == null) || (lis.size() == 0)) {
			throw new Lab3Exception("List cannot be empty");
		}
		int size_of_list=lis.size();
		SpecialNumber total = lis.get(0);
		for (int i=1;i<size_of_list;i++) {
			total= total.add(lis.get(i));
		}
		return total.divideByInt(size_of_list);
	}
	

}
