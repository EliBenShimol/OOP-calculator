package Numbers;

public class Rational implements Scalar {
	
	private int numerator;
	private int denominator;
	
	public Rational(int numer, int denom) {	
		numerator=numer;
		if(denom==0)//when the denominator is 0 we throw an exception 
			throw new IllegalArgumentException("illegal input");
		denominator=denom;
		
	}

	@Override
	public Scalar add(Scalar s) {
		Scalar ans=s.addRational(this);
		return ans;
	}

	@Override
	public Scalar mul(Scalar s) {
		Scalar ans=s.mulRational(this);
		return ans;
	}

	@Override
	public Scalar addRational(Rational s) {
		int transform1=1;//to know if the denominator needed to be changed and change the numerator accordingly
		int transform2=1;
		int denom1=denominator;
		int denom2=s.denom();
		if(denom1!=denom2) {
			transform1=denom2;
			transform2=denom1;
			denom1=denom1*denom2;
		}
		
		int numer=numerator*transform1+s.numer()*transform2;//create a new numerator for the new Scalar
		Rational r=new Rational(numer, denom1);//we first make it a rational so we can use the reduce function
		r.reduce();
		Scalar ans=r;
		return ans;
	}

	@Override
	public Scalar addInteger(Integer s) {
		int add=s.getNumber();
		add=add*denominator;//when we add an integer the transform for him is always denominator
		int numer=numerator+add;
		Scalar ans= new Rational(numer, denominator);
		return ans;
	}

	@Override
	public Scalar mulRational(Rational s) {
		//multiply the numerators and the denominators with one another
		int numer=numerator*s.numer();
		int denom=denominator*s.denom();
		Rational r=new Rational(numer, denom);//we first make it a rational so we can use the reduce function
		r.reduce();
		Scalar ans=r;
		return ans;
	}

	@Override
	public Scalar mulInteger(Integer s) {
		int multi=s.getNumber();
		int numer=numerator*multi;
		Rational r=new Rational(numer, denominator);//we first make it a rational so we can use the reduce function
		r.reduce();
		Scalar ans=r;
		return ans;
	}

	@Override
	public Scalar power(int exponent) {
		int numer=numerator;
		int denom=denominator;
		Rational r;
		Scalar ans;
		if(exponent>0) {//when exponent if bigger then 0 we need to just multiply the numerator and the denominator exponent number of times
			for(int i=1;i<exponent;i=i+1) {
				numer=numer*numerator;
				denom=denom*denominator;
				}
			r= new Rational(numer, denom);//we first make it a rational so we can use the reduce function
			r.reduce();
			ans=r;
		}
		else if(exponent<0) {//when exponent is smaller the 0, we switch between the numerator and the denominator and use the same function but for -1*exponent
			Rational opposite=new Rational(denom, numer);
			ans=opposite.power(-1*exponent);
		}
		else //when exponent is 0
			ans=new Integer(1);
		return ans;
	}

	@Override
	public int sign() {
		int ans=1;
		if(numerator==0)
			ans=0;
		if(numerator<0)
			ans=-1*ans;
		if(denominator<0)
			ans=-1*ans;
				
		return ans;
	}

	@Override
	public Scalar neg() {
		// TODO Auto-generated method stub
		int numer=-1*numerator;
		int denom=denominator;
		if(numer<0&denom<0) {//if both the numerator and the denominator are negative then the rational is positive so we make them both positive
			numer=-1*numer;
			denom=-1*denom;
			
		}
		Rational r= new Rational(numer, denom);//we first make it a rational so we can use the reduce function
		r.reduce();
		Scalar ans=r;
		return ans;
	}
	
	public Rational reduce() {
		int numer=numerator;
		int denom=denominator;
		int neg=1;// the sign of the rational number
		if(numer<0) {//we check if the numerator is negative, if so we make numer positive to make the calculation easier 
			numer=-1*numer;
			neg=-1*neg;
		}
		if(denom<0) {//we check if the denominator is negative, if so we make denom positive to make the calculation easier
			denom=-1*denom;
			neg=-1*neg;
		}
		
		if(numer%denom==0) {// if denom is a divider of numer, the answer is numer/denom
			numer=numer/denom;
			denom=1;
		}
		else {// else we look for similar dividers add divide both numer and denom with them 
			int divider=2;
			int low=denom;
			if(numer<denom)
				low=numer;
			while(divider<=low) {
				while(numer%divider==0&denom%divider==0) {
					numer=numer/divider;
					denom=denom/divider;
				}
				divider=divider+1;
			}	
		}
		if(neg==-1)//if the sign was negative we need to negate the result 
			numer=-1*numer;
		Rational ans=new Rational(numer, denom);
		return ans;
			
	}
	@Override
	public String toString() {
		String ans="";
		Rational print=this.reduce();//we get the reduced version of the number
		int numer=print.numer();
		int denom=print.denom();
		int neg=1;// same as we did in reduce
		if(numer<0) {
			numer=-1*numer;
			neg=-1*neg;
		}
		if(denom<0) {
			denom=-1*denom;
			neg=-1*neg;
		}
		if(neg==-1)// if the sign was negative we add a "-" sign to the start of the string
			ans=ans+"-";
		if(denom!=1)//if denom is different then 1 we need to print it as well
			ans=ans+numer+"/"+denom;
		else// else we only print the numer
			ans=ans+numer;
		return ans;
	}
	
	@Override
	public double value() {
		Rational r=this.reduce();
		double numer=r.numer();//we need to make one of the numbers a double or the output of numer/denom will be an integer
		double ans=numer/r.denom();
		return ans;
	}
	
	public int numer() {
		return numerator;
	}
	
	public int denom() {
		return denominator;
	}
}
