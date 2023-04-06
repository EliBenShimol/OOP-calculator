package Tests;

import Numbers.Integer;
import Numbers.Rational;
import Numbers.Scalar;

public class RationalTests {

	public static void main(String[] args) {
		RationalTests t=new RationalTests();
		t.testAdd();
		t.testMul();
		t.testPower();
		t.testSign();
		t.testNeg();
	}
	
	public void testAdd() {
		System.out.println("--------- Add-----------");
		Rational r=new Rational(10,7);
		Scalar s=new Integer(3);//when the input is an integer in a form of a scalar
		Scalar s2=new Rational(2,3);//when the input is a Rational in a form of a scalar
		Integer i=new Integer(24);//when the input is an integer
		Rational r2=new Rational(12,5);//when the input is a Rational
		String []outputs= {"31/7", "44/21", "178/7", "134/35"};
		int index=0;
		Scalar add1=r.add(s);
		if(add1.toString().equals(outputs[index]))
			System.out.println("true for "+r+"+"+s+", the enswer is "+add1);
		else
			System.out.println("problem with "+r+"+"+s+", the enswer is "+outputs[index]+" but the result was "+add1);
		
		index=index+1;
		Scalar add2=r.add(s2);
		if(add2.toString().equals(outputs[index]))
			System.out.println("true for "+r+"+"+s2+", the enswer is "+add2);
		else
			System.out.println("problem with "+r+"+"+s2+", the enswer is "+outputs[index]+" but the result was "+add2);
		
		index=index+1;
		Scalar add3=r.addInteger(i);
		if(add3.toString().equals(outputs[index]))
			System.out.println("true for "+r+"+"+i+", the enswer is "+add3);
		else
			System.out.println("problem with "+r+"+"+i+", the enswer is "+outputs[index]+" but the result was "+add3);
		
		index=index+1;
		Scalar add4=r.addRational(r2);
		if(add4.toString().equals(outputs[index]))
			System.out.println("true for "+r+"+"+r2+", the enswer is "+add4);
		else
			System.out.println("problem with "+r+"+"+r2+", the enswer is "+outputs[index]+" but the result was "+add4);
	}

	public void testMul() {
		System.out.println("--------- Multiply-----------");
		Rational r=new Rational(10,7);
		Scalar s=new Integer(3);//when the input is an integer in a form of a scalar
		Scalar s2=new Rational(2,3);//when the input is a Rational in a form of a scalar
		Integer i2=new Integer(24);//when the input is an integer
		Rational r1=new Rational(7,10);//when the input is a Rational and becomes an integer
		Rational r2=new Rational(12,7);//when the input is a Rational
		Integer i1=new Integer(7);
		String []outputs= {"30/7", "20/21", "240/7", "1", "120/49","10"};
		int index=0;
		Scalar mul1=r.mul(s);
		if(mul1.toString().equals(outputs[index]))
			System.out.println("true for "+r+"*"+s+", the enswer is "+mul1);
		else
			System.out.println("problem with "+r+"*"+s);
		
		index=index+1;
		Scalar mul2=r.mul(s2);
		if(mul2.toString().equals(outputs[index]))
			System.out.println("true for "+r+"*"+s2+", the enswer is "+mul2);
		else
			System.out.println("problem with "+r+"*"+s2+", the enswer is "+outputs[index]+" but the result was "+mul2);
		
		index=index+1;
		Scalar mul3=r.mulInteger(i2);
		if(mul3.toString().equals(outputs[index]))
			System.out.println("true for "+r+"*"+i2+", the enswer is "+mul3);
		else
			System.out.println("problem with "+r+"*"+i2+", the enswer is "+outputs[index]+" but the result was "+mul3);
		
		index=index+1;
		Scalar mul4=r.mulRational(r1);
		if(mul4.toString().equals(outputs[index]))
			System.out.println("true for "+r+"*"+r1+", the enswer is "+mul4);
		else
			System.out.println("problem with "+r+"*"+r1+", the enswer is "+outputs[index]+" but the result was "+mul4);
		
		index=index+1;
		Scalar mul5=r.mulRational(r2);
		if(mul5.toString().equals(outputs[index]))
			System.out.println("true for "+r+"*"+r2+", the enswer is "+mul5);
		else
			System.out.println("problem with "+r+"*"+r2+", the enswer is "+outputs[index]+" but the result was "+mul5);
		index=index+1;
		Scalar mul6=r.mulInteger(i1);
		if(mul6.toString().equals(outputs[index]))
			System.out.println("true for "+r+"*"+i1+", the enswer is "+mul6);
		else
			System.out.println("problem with "+r+"*"+i1+", the enswer is "+outputs[index]+" but the result was "+mul6);
	}
	public void testPower() {
		System.out.println("--------- power-----------");
		Rational r=new Rational(10,7);
		int power1=5;//checks for an exponent larger then 0
		int power2=-2;//checks for an exponent smaller then 0
		int power3=0;//checks for an exponent equals 0
		String[]outputs= {"100000/16807", "49/100", "1"};
		int index=0;
		Scalar exp1=r.power(power1);
		if(exp1.toString().equals(outputs[index]))
			System.out.println("true for "+r+"^"+power1+", the enswer is "+exp1);
		else
			System.out.println("problem with "+r+"^"+power1+", the enswer is "+outputs[index]+" but the result was "+exp1);
		index=index+1;
		
		
		Scalar exp2=r.power(power2);
		if(exp2.toString().equals(outputs[index]))
			System.out.println("true for "+r+"^"+power2+", the enswer is "+exp2);
		else
			System.out.println("problem with "+r+"^"+power2+", the enswer is "+outputs[index]+" but the result was "+exp2);
		index=index+1;
		
		
		Scalar exp3=r.power(power3);
		if(exp3.toString().equals(outputs[index]))
			System.out.println("true for "+r+"^"+power3+", the enswer is "+exp3);
		else
			System.out.println("problem with "+r+"^"+power3+", the enswer is "+outputs[index]+" but the result was "+exp3);
		index=index+1;	
	}
	public void testSign() {
		System.out.println("--------- sign-----------");
		Rational r1=new Rational(10,7);
		Rational r2=new Rational(-10,7);
		Rational r3=new Rational(0,1);
		int[]outputs= {1,-1,0};
		int index=0;
		int sign1=r1.sign();
		if(sign1==outputs[index])
			System.out.println("true for "+r1);
		else 
			System.out.println("problem with "+r1+", the enswer is"+outputs[index]+" but the result was "+sign1);
		
		index=index+1;
		int sign2=r2.sign();
		if(sign2==outputs[index])
			System.out.println("true for "+r2);
		else 
			System.out.println("problem with "+r2+", the enswer is"+outputs[index]+" but the result was "+sign2);
		
		index=index+1;
		int sign3=r3.sign();
		if(sign3==outputs[index])
			System.out.println("true for "+r3);
		else 
			System.out.println("problem with "+r3+", the enswer is"+outputs[index]+" but the result was "+sign3);
		
		
	}
	public void testNeg() {
		System.out.println("--------- Neg-----------");
		Rational r=new Rational(10,7);
		Rational r2=new Rational(-5,6);
		Rational r3=new Rational(0,1);
		String[]outputs= {"-10/7","5/6","0"};
		int index=0;
		Scalar neg1=r.neg();
		if(neg1.toString().equals(outputs[index]))
			System.out.println("true for "+r);
		else 
			System.out.println("problem with "+r+", the enswer is"+outputs[index]+" but the result was "+neg1);
		
		index=index+1;
		Scalar neg2=r2.neg();
		if(neg2.toString().equals(outputs[index]))
			System.out.println("true for "+r2);
		else 
			System.out.println("problem with "+r2+", the enswer is"+outputs[index]+" but the result was "+neg2);
		
		index=index+1;
		Scalar neg3=r3.neg();
		if(neg3.toString().equals(outputs[index]))
			System.out.println("true for "+r3);
		else 
			System.out.println("problem with "+r3+", the enswer is"+outputs[index]+" but the result was "+neg3);
		
	}
}
