package Tests;

import Numbers.*;
import Numbers.Integer;
import PolyMath.Monomial;

public class MonomialTests {

	public static void main(String[] args) {
		MonomialTests tests = new MonomialTests();
		tests.testAdd();
		tests.testMul();
		tests.testEvaluate();
		tests.testDerivatives();
		tests.testSign();

	}
	public void testAdd () {
		System.out.println("=====TestAdd=====");
		Monomial m=new Monomial(3,new Integer(7));
		Monomial m1=new Monomial(3,new Integer(5));
		Monomial m2=new Monomial(3,new Rational(5,7));
		Monomial m3=new Monomial(2,new Rational(5,7));
		String []outputs= {"12x^3", "54/7x^3", null};
		int index=0;
		System.out.println(m.add(m1));
		Monomial add1=m.add(m1);
		if(add1.toString().equals(outputs[index]))
			System.out.println("true for "+m+"+"+m1+", the enswer is "+add1);
		else
			System.out.println("problem with "+m+"+"+m1+", the enswer is "+outputs[index]+" but the result was "+add1);
		
		index=index+1;
		Monomial add2=m.add(m2);
		if(add2.toString().equals(outputs[index]))
			System.out.println("true for "+m+"+"+m2+", the enswer is "+add2);
		else
			System.out.println("problem with "+m+"+"+m2+", the enswer is "+outputs[index]+" but the result was "+add2);
		
		index=index+1;
		Monomial add3=m.add(m3);
		if(add3==null)
			System.out.println("true for "+m+"+"+m3+", the enswer is "+add3);
		else
			System.out.println("problem with "+m+"+"+m3+", the enswer is "+outputs[index]+" but the result was "+add3);
	}
	public void testMul () {
		System.out.println("=====TestMul=====");
		Monomial m=new Monomial(3,new Integer(7));
		Monomial m1=new Monomial(3,new Integer(5));
		Monomial m2=new Monomial(5,new Rational(5,6));
		String []outputs= {"35x^6", "35/6x^8"};
		int index=0;
		System.out.println(m.mul(m1));
		Monomial mul1=m.mul(m1);
		if(mul1.toString().equals(outputs[index]))
			System.out.println("true for "+m+"*"+m1+", the enswer is "+mul1);
		else
			System.out.println("problem with "+m+"*"+m1+", the enswer is "+outputs[index]+" but the result was "+mul1);
		
		index=index+1;
		Monomial mul2=m.mul(m2);
		if(mul2.toString().equals(outputs[index]))
			System.out.println("true for "+m+"*"+m2+", the enswer is "+mul2);
		else
			System.out.println("problem with "+m+"*"+m2+", the enswer is "+outputs[index]+" but the result was "+mul2);
		
	}
	public void testEvaluate () {
		System.out.println("=====TestEvaluate=====");
		Monomial m=new Monomial(3,new Integer(7));
		Monomial m2=new Monomial(5,new Rational(5,6));
		String []outputs= {"189", "405/322102","189/1331"};
		int index=0;
		System.out.println(m.evaluate(new Integer(3)));
		Scalar e=m.evaluate(new Integer(3));
		if(e.toString().equals(outputs[index]))
			System.out.println("true for "+m);
		else
			System.out.println("problem with "+m);
		
		index++;
		System.out.println(m2.evaluate(new Rational(3,11)));
		Scalar e1=m2.evaluate(new Rational(3,11));
		if(e1.toString().equals(outputs[index]))
			System.out.println("true for "+m2);
		else
			System.out.println("problem with "+m2);
		index++;
		System.out.println(m.evaluate(new Rational(3,11)));
		Scalar e2=m.evaluate(new Rational(3,11));
		if(e2.toString().equals(outputs[index]))
			System.out.println("true for "+m);
		else
			System.out.println("problem with "+m);
	}
	public void testDerivatives () {
		System.out.println("=====TestDerivative=====");

		Monomial m=new Monomial(3,new Integer(7));
		Monomial m2=new Monomial(5,new Rational(5,6));
		String []outputs= {"21x^2", "25/6x^4"};
		int index=0;
		Monomial t1 =m.derivative();
		System.out.println(t1);
		if(t1.toString().equals(outputs[index]))
			System.out.println("true for "+m);
		else
			System.out.println("problem with "+m);
		index++;
		Monomial t2 =m2.derivative();
		System.out.println(t2);
		if(t2.toString().equals(outputs[index]))
			System.out.println("true for "+m2);
		else
			System.out.println("problem with "+m2);
	}
	public void testSign() {
		System.out.println("=====TestSign=====");

		Monomial m=new Monomial(3,new Integer(7));
		Monomial m2=new Monomial(5,new Rational(5,6));
		Monomial m3=new Monomial(3,new Integer(-7));
		Monomial m4=new Monomial(5,new Rational(-5,6));
		Monomial m5=new Monomial(3,new Integer(0));
		int []outputs= {1, 1,-1,-1,0};
		int index=0;
		int t1 =m.sign();
		System.out.println(t1);
		if(t1==outputs[index])
			System.out.println("true for "+m);
		else
			System.out.println("problem with "+m);
		index++;
		
		int t2 =m2.sign();
		System.out.println(t2);
		if(t2==outputs[index])
			System.out.println("true for "+m2);
		else
			System.out.println("problem with "+m2);
		index++;
		
		int t3 =m3.sign();
		System.out.println(t3);
		if(t3==outputs[index])
			System.out.println("true for "+m3);
		else
			System.out.println("problem with "+m3);
		index++;
		
		int t4 =m4.sign();
		System.out.println(t4);
		if(t4==outputs[index])
			System.out.println("true for "+m4);
		else
			System.out.println("problem with "+m4);
		index++;
		
		int t5 =m5.sign();
		System.out.println(t5);
		if(t5==outputs[index])
			System.out.println("true for "+m5);
		else
			System.out.println("problem with "+m5);
		
	}
	

}
