package Tests;
import Numbers.*;
import Numbers.Integer;

public class IntegerTests {
	//the function toString is tested in all the functions, because thats how we print the answer
	/*
	 * tests for function add , addInteger, addRational 
	 */
	public void testAdd() {
		System.out.println("--------- Add-----------");
		Integer i=new Integer(5);
		Scalar s=new Integer(3);//when the input is an integer in a form of a scalar
		Scalar s2=new Rational(2,3);//when the input is a Rational in a form of a scalar
		Integer i2=new Integer(24);//when the input is an integer
		Rational r=new Rational(12,5);//when the input is a Rational
		String []outputs= {"8", "17/3", "29", "37/5"};
		int index=0;
		Scalar add1=i.add(s);
		if(add1.toString().equals(outputs[index]))
			System.out.println("true for "+i+"+"+s+", the enswer is "+add1);
		else
			System.out.println("problem with "+i+"+"+s+", the enswer is "+outputs[index]+" but the result was "+add1);
		
		index=index+1;
		Scalar add2=i.add(s2);
		if(add2.toString().equals(outputs[index]))
			System.out.println("true for "+i+"+"+s2+", the enswer is "+add2);
		else
			System.out.println("problem with "+i+"+"+s2+", the enswer is "+outputs[index]+" but the result was "+add2);
		
		index=index+1;
		Scalar add3=i.addInteger(i2);
		if(add3.toString().equals(outputs[index]))
			System.out.println("true for "+i+"+"+i2+", the enswer is "+add3);
		else
			System.out.println("problem with "+i+"+"+i2+", the enswer is "+outputs[index]+" but the result was "+add3);
		
		index=index+1;
		Scalar add4=i.addRational(r);
		if(add4.toString().equals(outputs[index]))
			System.out.println("true for "+i+"+"+r+", the enswer is "+add4);
		else
			System.out.println("problem with "+i+"+"+r+", the enswer is "+outputs[index]+" but the result was "+add4);
		
	}
	
	
	
	/*
	 * tests for function mul , mulInteger, mulRational 
	 */
	public void testMul() {
		System.out.println("--------- Multiply-----------");
		Integer i=new Integer(5);
		Scalar s=new Integer(3);//when the input is an integer in a form of a scalar
		Scalar s2=new Rational(2,3);//when the input is a Rational in a form of a scalar
		Integer i2=new Integer(24);//when the input is an integer
		Rational r=new Rational(12,5);//when the input is a Rational and becomes an integer
		Rational r2=new Rational(12,7);//when the input is a Rational
		String []outputs= {"15", "10/3", "120", "12", "60/7"};
		int index=0;
		Scalar mul1=i.mul(s);
		if(mul1.toString().equals(outputs[index]))
			System.out.println("true for "+i+"*"+s+", the enswer is "+mul1);
		else
			System.out.println("problem with "+i+"*"+s);
		
		index=index+1;
		Scalar mul2=i.mul(s2);
		if(mul2.toString().equals(outputs[index]))
			System.out.println("true for "+i+"*"+s2+", the enswer is "+mul2);
		else
			System.out.println("problem with "+i+"*"+s2+", the enswer is "+outputs[index]+" but the result was "+mul2);
		
		index=index+1;
		Scalar mul3=i.mulInteger(i2);
		if(mul3.toString().equals(outputs[index]))
			System.out.println("true for "+i+"*"+i2+", the enswer is "+mul3);
		else
			System.out.println("problem with "+i+"*"+i2+", the enswer is "+outputs[index]+" but the result was "+mul3);
		
		index=index+1;
		Scalar mul4=i.mulRational(r);
		if(mul4.toString().equals(outputs[index]))
			System.out.println("true for "+i+"*"+r+", the enswer is "+mul4);
		else
			System.out.println("problem with "+i+"*"+r+", the enswer is "+outputs[index]+" but the result was "+mul4);
		
		index=index+1;
		Scalar mul5=i.mulRational(r2);
		if(mul5.toString().equals(outputs[index]))
			System.out.println("true for "+i+"*"+r2+", the enswer is "+mul5);
		else
			System.out.println("problem with "+i+"*"+r2+", the enswer is "+outputs[index]+" but the result was "+mul5);
	}
	
	
	/*
	 * tests for function power
	 */
	public void testPower() {
		System.out.println("--------- power-----------");
		Integer i=new Integer(2);
		int power1=5;//checks for an exponent larger then 0
		int power2=-5;//checks for an exponent smaller then 0
		int power3=0;//checks for an exponent equals 0
		String[]outputs= {"32", "1/32", "1"};
		int index=0;
		Scalar exp1=i.power(power1);
		if(exp1.toString().equals(outputs[index]))
			System.out.println("true for "+i+"^"+power1+", the enswer is "+exp1);
		else
			System.out.println("problem with "+i+"^"+power1+", the enswer is "+outputs[index]+" but the result was "+exp1);
		index=index+1;
		
		
		Scalar exp2=i.power(power2);
		if(exp2.toString().equals(outputs[index]))
			System.out.println("true for "+i+"^"+power2+", the enswer is "+exp2);
		else
			System.out.println("problem with "+i+"^"+power2+", the enswer is "+outputs[index]+" but the result was "+exp2);
		index=index+1;
		
		
		Scalar exp3=i.power(power3);
		if(exp3.toString().equals(outputs[index]))
			System.out.println("true for "+i+"^"+power3+", the enswer is "+exp3);
		else
			System.out.println("problem with "+i+"^"+power3+", the enswer is "+outputs[index]+" but the result was "+exp3);
		index=index+1;	
	}
	
	
	/*
	 * tests for function sign
	 */
	public void testSign() {
		System.out.println("--------- sign-----------");
		Integer i=new Integer(2);
		Integer i2=new Integer(-5);
		Integer i3=new Integer(0);
		int[]outputs= {1,-1,0};
		int index=0;
		int sign1=i.sign();
		if(sign1==outputs[index])
			System.out.println("true for "+i);
		else 
			System.out.println("problem with "+i+", the enswer is"+outputs[index]+" but the result was "+sign1);
		
		index=index+1;
		int sign2=i2.sign();
		if(sign2==outputs[index])
			System.out.println("true for "+i2);
		else 
			System.out.println("problem with "+i2+", the enswer is"+outputs[index]+" but the result was "+sign2);
		
		index=index+1;
		int sign3=i3.sign();
		if(sign3==outputs[index])
			System.out.println("true for "+i3);
		else 
			System.out.println("problem with "+i3+", the enswer is"+outputs[index]+" but the result was "+sign3);
		
		
	}
	
	
	/*
	 * tests for function neg
	 */
	
	public void testNeg() {
		System.out.println("--------- Neg-----------");
		Integer i=new Integer(2);
		Integer i2=new Integer(-5);
		Integer i3=new Integer(0);
		String[]outputs= {"-2","5","0"};
		int index=0;
		Scalar neg1=i.neg();
		if(neg1.toString().equals(outputs[index]))
			System.out.println("true for "+i);
		else 
			System.out.println("problem with "+i+", the enswer is"+outputs[index]+" but the result was "+neg1);
		
		index=index+1;
		Scalar neg2=i2.neg();
		if(neg2.toString().equals(outputs[index]))
			System.out.println("true for "+i2);
		else 
			System.out.println("problem with "+i2+", the enswer is"+outputs[index]+" but the result was "+neg2);
		
		index=index+1;
		Scalar neg3=i3.neg();
		if(neg3.toString().equals(outputs[index]))
			System.out.println("true for "+i3);
		else 
			System.out.println("problem with "+i3+", the enswer is"+outputs[index]+" but the result was "+neg3);
		
	}
	public static void main(String[]args) {
		IntegerTests t=new IntegerTests();
		t.testAdd();
		t.testMul();
		t.testPower();
		t.testSign();
		t.testNeg();
	
	}

}
