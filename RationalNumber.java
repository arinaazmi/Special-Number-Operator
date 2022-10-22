package lab3;

/**
 * This class inherits from SpecialNumber class and implements Comparable.
 * It has two fields, numerator and denominator. It has an add and a divideByInt method.
 * Also, it implements hashCode, equals, and compareTo.
 * 
 * @author Arina
 * @version 1.0
 */ 
public class RationalNumber extends SpecialNumber implements Comparable<RationalNumber>{
	int numerator; 
	int denominator;
	
	public RationalNumber(int numi, int deno) throws Lab3Exception {
		if (deno == 0) {
			throw new Lab3Exception("Denominator cannot be zero");
		}
		numerator = numi;
		denominator =deno;
		
	}

	public SpecialNumber add(SpecialNumber N) throws Lab3Exception {
		
		if (!(N instanceof RationalNumber)){
			throw new Lab3Exception("Cannot add an incompatible type");
		}
		int n=0;
		int d=0;
		RationalNumber ran = (RationalNumber)N;
		if (denominator==ran.denominator) {
			n= numerator + ran.numerator;
			d=ran.numerator;
		}
		else {
			d=ran.denominator*denominator;
			n=(denominator*ran.numerator)+(ran.denominator*numerator);
		}
		
		RationalNumber sum = new RationalNumber(n,d);
		
		return sum;
	}

	public SpecialNumber divideByInt(int x) throws Lab3Exception {
		if (x==0) {
			throw new Lab3Exception("Cannot divide by zero");
		}
		RationalNumber num= new RationalNumber(numerator,denominator*x);
		return num;
		
	}

	@Override
	public int hashCode() {
		return (int)((double)numerator/(double)denominator);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RationalNumber other = (RationalNumber) obj;
		double d1 = (double)numerator/(double)denominator;
		double d2 = (double)other.numerator/(double)other.denominator;
		return d1==d2;
	}

	@Override
	public int compareTo(RationalNumber other) {
		double d1 = (double)numerator/(double)denominator;
		double d2 = (double)other.numerator/(double)other.denominator;
		if (d1<d2) {
			return -1;
		}
		else if (d1==d2) {
			return 0;
		}
		return 1;
	}
	
	


}
