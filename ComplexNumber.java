package lab3;

import java.util.Objects;

public class ComplexNumber extends SpecialNumber implements Comparable<ComplexNumber>{
	double real;
	double imaginary;
	
	public ComplexNumber(double r, double i) {
		this.real=r;
		this.imaginary=i;
	}

	public SpecialNumber add(SpecialNumber N) throws Lab3Exception {
		if (!(N instanceof ComplexNumber)){
			throw new Lab3Exception("Cannot add an incompatible type");
		}
		double re=0.0;
		double im=0.0;
		ComplexNumber con=(ComplexNumber)N;
		re=this.real+con.real;
		im=this.imaginary+con.imaginary;
		
		ComplexNumber sum = new ComplexNumber(re,im);
		return sum;	
	}

	public SpecialNumber divideByInt(int x) throws Lab3Exception{
		if (x==0) {
			throw new Lab3Exception("Cannot divide by zero");
		}
		ComplexNumber con = new ComplexNumber(real/x, imaginary/x);
		return con;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(imaginary, real);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComplexNumber other = (ComplexNumber) obj;
		return Double.doubleToLongBits(imaginary) == Double.doubleToLongBits(other.imaginary)
				&& Double.doubleToLongBits(real) == Double.doubleToLongBits(other.real);
	}

	@Override
	public int compareTo(ComplexNumber other) {
		double d1= Math.sqrt((real*real) + (imaginary*imaginary));
		double d2= Math.sqrt((other.real*other.real) + (other.imaginary*other.imaginary));
		if (d1<d1)
			return -1;
		else if (d1==d2)
			return 0;
		else
			return 1;
	}
	
	

}
