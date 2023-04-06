package Numbers;

public class Integer implements Scalar {
	
	private int number;

	public Integer(int i) {	
		number=i;
	}

	@Override
	public Scalar add(Scalar s) {
		Scalar ans=s.addInteger(this);//we don't know if scalar will be a rational or an integer, so we add the integer to scalar to avoid problems
		return ans;
	}

	@Override
	public Scalar mul(Scalar s) {
		Scalar ans=s.mulInteger(this);//we don't know if scalar will be a rational or an integer, so we multiply the scalar integer number of times to avoid problems
		return ans;
	}

	@Override
	public Scalar addRational(Rational s) {
		Scalar ans=s.addInteger(this);//used the rational function addInteger
		return ans;
	}

	@Override
	public Scalar addInteger(Integer s) {
		int add=s.getNumber();//gets the value of the integer
		int ansInt=number+add;
		Scalar ans =new Integer(ansInt);//create a new Scalar with the new value
		return ans;
	}

	@Override
	public Scalar mulRational(Rational s) {
		Scalar ans=s.mulInteger(this);//used the rational function mulInteger
		return ans;
	}

	@Override
	public Scalar mulInteger(Integer s) {
		int add=s.getNumber();//gets the value of the integer
		int ansInt=number*add;
		Scalar ans =new Integer(ansInt);//create a new Scalar with the new value
		return ans;
	}

	@Override
	public Scalar power(int exponent) {
		int ansInt=number;
		Scalar ans;
		if(exponent>0) {//when the exponent is positive we multiply number exponent number of times
			for(int i=1;i<exponent;i=i+1)
				ansInt=ansInt*number;
			ans=new Integer(ansInt);
		}
		else if(exponent<0) {//when exponent is negative we create a rational 1/number and use the rational function power for -1*exponent
			Rational r=new Rational(1, number);
			ans=r.power(-1*exponent);
			
		}
		else //when exponent is 0
			ans=new Integer(1);
		return ans;
	}

	@Override
	public int sign() {
		int ans=0;
		if(number>0)
			ans=1;
		if(number<0)
			ans=-1;
		return ans;
	}

	@Override
	public Scalar neg() {
		int ansInt=-1*number;
		Scalar ans=new Integer(ansInt);
		return ans;
	}
	
	@Override
	public double value() {
		return number;
	}
	
	@Override
	public String toString() {
		String s=number+"";
		return s;
	}
	
	public int getNumber() {
		return number;
	}
}
