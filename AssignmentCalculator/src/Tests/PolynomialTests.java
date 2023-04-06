package Tests;

import Numbers.Rational;
import Numbers.Integer;
import PolyMath.Polynomial;


public class PolynomialTests {

	public static void main(String[] args) {
		PolynomialTests t = new PolynomialTests();
		t.testBuild();
		System.out.println();
		t.testAdd();
		System.out.println();
		t.testMul();
		System.out.println();
		t.testEvaluate();
		System.out.println();
		t.testDerivative();

	}
	public void testBuild() {
		System.out.println("=====TestBuild=====");

		Polynomial p = new Polynomial();
		p=p.build("1 2 3");
		Polynomial p1 = new Polynomial();
		p1=p1.build("0 1 2 3");
		Polynomial p2 = new Polynomial();
		p2=p2.build("0 0 0 0 0 0 7");
		Polynomial p3 = new Polynomial();
		p3=p3.build("5");
		Polynomial p4 = new Polynomial();
		p4=p4.build("11");
		String []outputs= {"1+2x+3x^2", "x+2x^2+3x^3", "7x^6","5","11"};
		int index = 0;
		if (p.toString().equals(outputs[index])) {
			System.out.println("Polynomial true");
		}else {
			System.out.println("Polynomial wrong, expected: "+outputs[index]+" recieved: "+p.toString());
		}
		index++;
		
		if (p1.toString().equals(outputs[index])) {
			System.out.println("Polynomial true");
		}else {
			System.out.println("Polynomial wrong, expected: "+outputs[index]+" recieved: "+p1);
		}
		index++;
		
		if (p2.toString().equals(outputs[index])) {
			System.out.println("Polynomial true");
		}else {
			System.out.println("Polynomial wrong, expected: "+outputs[index]+" recieved: "+p2);
		}
		index++;
		
		if (p3.toString().equals(outputs[index])) {
			System.out.println("Polynomial true");
		}else {
			System.out.println("Polynomial wrong, expected: "+outputs[index]+" recieved: "+p3);
		}
		index++;
		
		if (p4.toString().equals(outputs[index])) {
			System.out.println("Polynomial true");
		}else {
			System.out.println("Polynomial wrong, expected: "+outputs[index]+" recieved: "+p4);
		}
		index++;
	}

	public void testAdd() {
		System.out.println("=====TestAdd=====");

		Polynomial p = new Polynomial();
		Polynomial p1 = p.build("0 1 2 3");
		Polynomial p2 = p.build("0 0 0 0 0 0 7");
		Polynomial p3 = p.build("5");
		Polynomial p4=p.build("1 2 8");
		Polynomial[] outputs = {p.build("0 1 2 3 0 0 7"), p.build("5 1 2 3"), p.build("1 3 10 3")};
		
		
		int index = 0;
		if (p1.add(p2).toString().equals(outputs[index].toString())) {
			System.out.println("Output is true");
		}else {
			System.out.println("Polynomial wrong, expected: "+outputs[index]+" recieved: "+p1.add(p2));
		}
		index++;
		
		if (p1.add(p3).toString().equals(outputs[index].toString())) {
			System.out.println("Output is true");
		}else {
			System.out.println("Polynomial wrong, expected: "+outputs[index]+" recieved: "+p1.add(p3));
		}
		index++;
		
		if (p1.add(p4).toString().equals(outputs[index].toString())) {
			System.out.println("Output is true");
		}else {
			System.out.println("Polynomial wrong, expected: "+outputs[index]+" recieved: "+p1.add(p4));
		}
		index++;
		
	}

	public void testMul() {
		System.out.println("=====TestMul=====");
		Polynomial p = new Polynomial();
		Polynomial p1=Polynomial.build("1 2 3");
		Polynomial p2=Polynomial.build("2 2");
		Polynomial p3=Polynomial.build("10 2 3");
		Polynomial p4=Polynomial.build("5");
		Polynomial[] outputs = {p.build("2 6 10 6"), p.build("5 10 15"), p.build("4 8 4"), p.build("50 10 15")};
		
		int index = 0;
		if (p1.mul(p2).toString().equals(outputs[index].toString())) {
			System.out.println("Output is true");
		}else {
			System.out.println("Polynomial wrong, expected: "+outputs[index]+" recieved: "+p1.mul(p2));
		}
		index++;
		
		if (p1.mul(p4).toString().equals(outputs[index].toString())) {
			System.out.println("Output is true");
		}else {
			System.out.println("Polynomial wrong, expected: "+outputs[index]+" recieved: "+p1.mul(p4));
		}
		index++;
		
		if (p2.mul(p2).toString().equals(outputs[index].toString())) {
			System.out.println("Output is true");
		}else {
			System.out.println("Polynomial wrong, expected: "+outputs[index]+" recieved: "+p2.mul(p2));
		}
		index++;
		
		if (p3.mul(p4).toString().equals(outputs[index].toString())) {
			System.out.println("Output is true");
		}else {
			System.out.println("Polynomial wrong, expected: "+outputs[index]+" recieved: "+p3.mul(p4));
		}
		index++;
	}
	
	public void testEvaluate() {
		System.out.println("=====TestEvaluate=====");
		Polynomial p = new Polynomial();
		Polynomial p1=Polynomial.build("1 2 3");//2/3
		Polynomial p2=Polynomial.build("2 2");//4
		Polynomial p3=Polynomial.build("10 2 3 2");//3
		Polynomial p4=Polynomial.build("5"); //100
		String[] outputs = {"11/3", "10", "97", "5"};
		int index=0;
		if(p1.evaluate(new Rational(2,3)).toString().equals(outputs[index])) {
			System.out.println("Output is true");
		}else {
			System.out.println("Output wrong, expected: "+outputs[index]+" recived: "+p1.evaluate(new Rational(2,3)));
		}
		index++;
		
		if(p2.evaluate(new Integer(4)).toString().equals(outputs[index])) {
			System.out.println("Output is true");
		}else {
			System.out.println("Output wrong, expected: "+outputs[index]+" recived: "+p2.evaluate(new Integer(4)));
		}
		index++;
		
		if(p3.evaluate(new Integer(3)).toString().equals(outputs[index])) {
			System.out.println("Output is true");
		}else {
			System.out.println("Output wrong, expected: "+outputs[index]+" recived: "+p3.evaluate(new Integer(3)));
		}
		index++;
		
		if(p4.evaluate(new Integer(100)).toString().equals(outputs[index])) {
			System.out.println("Output is true");
		}else {
			System.out.println("Output wrong, expected: "+outputs[index]+" recived: "+p4.evaluate(new Integer(100)));
		}
		index++;
		
	}
	
	public void testDerivative() {
		System.out.println("=====TestDerivative=====");

		Polynomial p = new Polynomial();
		Polynomial p1=Polynomial.build("1 2 3");
		Polynomial p2=Polynomial.build("2 2");
		Polynomial p3=Polynomial.build("10 5 3 4");
		Polynomial p4=Polynomial.build("5");
		Polynomial[] outputs = {p.build("2 6"), p.build("2"), p.build("5 6 12"), p.build("0")};
		
		
		int index = 0;
		if (p1.derivative().toString().equals(outputs[index].toString())) {
			System.out.println("Output is true");
		}else {
			System.out.println("Polynomial wrong, expected: "+outputs[index]+" recieved: "+p1.derivative());
		}
		index++;
		
		if (p2.derivative().toString().equals(outputs[index].toString())) {
			System.out.println("Output is true");
		}else {
			System.out.println("Polynomial wrong, expected: "+outputs[index]+" recieved: "+p2.derivative());
		}
		index++;
		
		if (p3.derivative().toString().equals(outputs[index].toString())) {
			System.out.println("Output is true");
		}else {
			System.out.println("Polynomial wrong, expected: "+outputs[index]+" recieved: "+p3.derivative());
		}
		index++;
		
		if (p4.derivative().toString().equals(outputs[index].toString())) {
			System.out.println("Output is true");
		}else {
			System.out.println("Polynomial wrong, expected: "+outputs[index]+" recieved: "+p4.derivative());
		}
		index++;
	}

}
