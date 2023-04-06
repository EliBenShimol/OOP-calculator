package PolyMath;
import Numbers.*;
import Numbers.Integer;

public class Monomial{
	private int exponent;
	private Scalar coefficient;
	
	public Monomial(int exponent, Scalar coefficient) {
		this.exponent=exponent;
		this.coefficient=coefficient;
	}
	

	public Monomial add(Monomial m) {
		if(exponent!=m.getExponent())
			return null;
		else {
			Scalar add=coefficient.add(m.getCoefficient());//we combine the coefficients 
			Monomial ans=new Monomial(exponent, add);
			return ans;
		
		}	
	}
	
	
	public Monomial mul(Monomial m) {//when multiplying we add the exponents to one another add multiply the coefficients
		int exp=exponent+m.getExponent();
		Scalar multi=coefficient.mul(m.getCoefficient());
		Monomial ans=new Monomial(exp, multi);
		return ans;
		
		}
	
	
	public Scalar evaluate(Scalar s) {
		Scalar ans=new Integer(1);
		ans=ans.mul(s);
		int exp=exponent;
		ans=ans.power(exp);	//we first evaluate the part x^exponent 
		ans=ans.mul(coefficient);//the multiply it by coefficient
		return ans;
		
			
			
	}
	
	public Monomial derivative() {
		Scalar multi;
		if(exponent>0)//we need to multiply coefficient by the positive value of exponent
			multi=new Integer(exponent);
		else
			multi=new Integer(-1*exponent);
		int exp=exponent-1;//the exponent is getting smaller by 1
		Scalar coef=coefficient.mul(multi);
		Monomial ans=new Monomial(exp, coef);
		return ans;
		
	}
	
	public int sign() {
		return coefficient.sign();
	}
	
	
	public String toString() {
		String ans="x";
		double coValue=coefficient.value();
		if(coValue!=1&coValue!=-1)//if coefficient is not 1 or -1 we print it
			ans=coefficient.toString()+ans;
		else if(coValue==-1)// if its -1 we only add the "-" sign, if its 1 we don't add anything
			ans="-"+ans;
		if(exponent!=1&exponent!=0)// when the exponent is not 1 or 0 we print it 
			ans=ans+"^"+exponent;
		else if(exponent==0)// if the exponent is 0 the answer is only coefficient, if the exponent is 1 the answer is coefficient+"x"
			ans=coefficient.toString();
		if(coValue==0)// if coefficient is 0 the answer is 0
			ans="0";
		return ans;
		
			
	}
	
	public int getExponent() {
		return exponent;
	}
	
	public Scalar getCoefficient() {
		return coefficient;
	}
}
