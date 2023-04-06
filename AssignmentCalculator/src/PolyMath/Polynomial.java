package PolyMath;

import java.util.Stack;

import Numbers.*;
import Numbers.Integer;

public class Polynomial {
	
	private Stack<Monomial> monomials;
	
	public Polynomial() {
		monomials=new Stack<>();
	}
	
	
	public static Polynomial build(String input) {
		Polynomial ans=new Polynomial();
		int exp=0;//the exponent of every monomial
		int add=0;//the numerator
		int add2=0;//the denominator
		String numString="";//the number as a string
		int num=0;//the number
		int power=0;// the power of every part of the number
		for(int i=0; i<input.length();i=i+1) {
			add=1;
			add2=1;
			if(input.charAt(i)!=' ') {//we ignore every char which is a space
				if(input.charAt(i)=='-') {//if there is a "-" sign, we need to add a negative number
					add=-1;
					i=i+1;//we also move one char ahead to check the number we need to add
				}	
				numString="";
				while(i<input.length()&&ans.helpBuild(input.charAt(i))) {// as long the char is a digit, we add it to the string representing the whole number
					numString=numString+input.charAt(i);
					i=i+1;
				}
				num=0;
				power=0;
				for(int j=numString.length()-1;j>-1;j=j-1) {
					int adding=Character.getNumericValue(numString.charAt(j));//we get the value of each digit
					int powerTemp=power;
					while(powerTemp>0) {// then we multiply it by 10 as many times as needed according to his place in the string
						adding=adding*10;
						powerTemp=powerTemp-1;
					}
					num=num+adding;//add then we add it to the whole number
					power=power+1;
				}
					
				add=add*num;//we multiply it by add in case its a negative number
				i=i-1;//we go back one place in case the next char is '/' so we don't skip it
				if(i<input.length()-2) {//there is no need to check if the number is rational when there are less the two chars left in the string,
					//because one for '/' and one digit at least for the denominator 
					if(input.charAt(i+1)=='/') {
						if(input.charAt(i+2)=='-') {//the same as we did for add
							add2=-1;
							i=i+3;
						}
						else
							i=i+2;//we move i two spaces, one for the last digit of the numerator and one for the '/' sign
						
						numString="";//the same as for add
						while(i<input.length()&&ans.helpBuild(input.charAt(i))) {
							numString=numString+input.charAt(i);
							i=i+1;
						}
						num=0;
						power=0;
						for(int j=numString.length()-1;j>-1;j=j-1) {
							int adding=Character.getNumericValue(numString.charAt(j));
							int powerTemp=power;
							while(powerTemp>0) {
								adding=adding*10;
								powerTemp=powerTemp-1;
							}
							num=num+adding;
							power=power+1;
						}
						add2=add2*num;
						Scalar coef=new Rational(add, add2);// in this instance the scalar is a rational
						Monomial insert=new Monomial(exp, coef);
						exp=exp+1;//we move the exponent one ahead for the next monomial
						ans.monomials.push(insert);// and add it to the stack
						
						}
					else {//when the next char is not '/'
						Scalar coef=new Integer(add);// in this instance the scalar is an integer
						Monomial insert=new Monomial(exp, coef);
						exp=exp+1;//we move the exponent one ahead for the next monomial
						ans.monomials.push(insert);// and add it to the stack
					}	
					}
					else {//when there are less then 2 chars left
						Scalar coef=new Integer(add);// in this instance the scalar is an integer
						Monomial insert=new Monomial(exp, coef);
						exp=exp+1;//we move the exponent one ahead for the next monomial
						ans.monomials.push(insert);// and add it to the stack
					}	
				}
			}
		
		
		return ans;
	}
	
	public boolean helpBuild(char c) {// a function to check if the char is a digit or not
		boolean ans=false;
		String nums="0123456789";
		for(int i=0;i<nums.length();i=i+1)
			if(nums.charAt(i)==c)
				ans=true;
		return ans;
		
	}
	
	
	

	public Polynomial add(Polynomial p) {
		Polynomial addP=p.copy();// we use a copy of p and this to not change the polynomial itself
		Polynomial thisP=this.copy();
		Stack<Monomial> temp=new Stack<>();//a temporary stack for the monomials
		int lowThis=0;//to check which polynomial is smaller, 0 for p and 1 for this
		if(this.monomials.size()<addP.getMonomials().size()) 
			lowThis=1;
		
		if(lowThis==0) {//when the size of this is bigger or equal to the size of p
			while(thisP.monomials.size()>addP.getMonomials().size()) {//until the stack sizes are not equal, we just add the monomials as they are
				Monomial now=thisP.monomials.pop();
				temp.push(now);
			}
			while(!thisP.monomials.isEmpty()) {//when the sizes are equal we add a monomial which is the sum of the monomial from this and the monomial from p
				Monomial now=thisP.monomials.pop();
				temp.push(now.add(addP.monomials.pop()));
			}
		}
		else {//when the size of p is bigger, the same as when the size of this is bigger or equal
			while(addP.monomials.size()>this.getMonomials().size()) {
				Monomial now=addP.monomials.pop();
				temp.push(now);
			}
			while(!thisP.monomials.isEmpty()) {
				Monomial now=thisP.monomials.pop();
				temp.push(now.add(addP.monomials.pop()));
			}
		}
		Polynomial ans=new Polynomial();
		while(!temp.isEmpty())//we need to reverse the order of the monomials in the stack
			ans.monomials.push(temp.pop());
		return ans;
		
		
	}
	
	
	
	public  Polynomial mul(Polynomial p) {
		Polynomial mulP=p.copy();// we use a copy of p and this to not change the polynomial itself
		Polynomial thisP=this.copy();
		Polynomial ans=new Polynomial();//the answer we will return 
		Stack<Monomial> temp=new Stack<>();// a temporary stack for the monomials of each multiply
		Polynomial tempCheck=new Polynomial();//a polynomial to reverse the order of the monomials that are in temp
		while(!mulP.monomials.isEmpty()) {//when multiplying we take one monomial from p and multiply every monomial in this with the monomial from p
			temp.clear();//we clear temp and tempCheck at the start of each multiply
			tempCheck.monomials.clear();
			Monomial multi=mulP.monomials.pop();//the monomial from p
			while(!thisP.monomials.isEmpty()) {//multiply multi with every monomial from this and add it to temp
				Monomial add=thisP.monomials.pop().mul(multi);	
				temp.push(add);
			}
			/*
			 * this part is to add zeros to the polynomial if needed
			 */
			Monomial last=null;//we check the last monomial in temp(which has the smallest exponent)
			if(!temp.isEmpty()) 
				last=temp.peek();
			
			if(last!=null&&last.getExponent()>0) {//if the exponent is not 0 then we need to add 0 to the places where the isn't already a monomial
				int add=last.getExponent();//the number of times we need to add zero
				while(add>0) {
					add=add-1;
					Scalar s=new Integer(0);
					Monomial zero=new Monomial(add, s);
					temp.push(zero);
				}
			}
			
			while(!temp.isEmpty())//we move the monomials to tempCheck to reverse the order of them to be in the right order
				tempCheck.monomials.push(temp.pop());
			ans=tempCheck.add(ans);//we add each polynomial to the answer 
			thisP=this.copy();//we need to copy p again because we emptied the copy
		}
		return ans;
	}
	
	
	
	
	public Scalar evaluate(Scalar s) {
		Polynomial thisP=this.copy();// we use a copy of this to not change the polynomial itself
		Monomial now=thisP.monomials.pop();
		Scalar ans=now.evaluate(s);//the scalar we will return
		while(!thisP.monomials.isEmpty()) {//while there are monomials in the polynomial
			now=thisP.monomials.pop();
			Scalar tempEval=now.evaluate(s);//we evaluate each monomial alone
			ans=ans.add(tempEval);//the add it to the scalar we will return 
		}
		return ans;
	}
	
	
	
	public Polynomial derivative() {
		Polynomial ans=new Polynomial();//the polynomial we will return 
		Stack<Monomial> temp=new Stack<>();// a temporary stack to help put the monomials in the right order in ans
		Polynomial thisP=this.copy();// we use a copy of this to not change the polynomial itself
		while(!thisP.monomials.isEmpty())
			temp.push(thisP.monomials.pop().derivative());//we put in temp all the derivatives of the monomials in this
		while(!temp.isEmpty())
			ans.monomials.push(temp.pop());//then transfer it to ans to make it in the right order
		return ans;
		
	}
	
	
		
	@Override
	public String toString() {
		String ans="";
		Polynomial thisP=this.copy();// we use a copy of this to not change the polynomial itself
		while(!thisP.monomials.isEmpty()) {
			Monomial print=thisP.monomials.pop();
			if(print!=null&&print.sign()==1) {//when the monomial is positive we need a '+' sign
				ans="+"+print.toString()+ans;
			}
			else if(print!=null&&print.sign()==-1) {//else the number already has '-' sign so we don't need to add it
				ans=print.toString()+ans;
			}//there isn't an option for sign 0 because we don't print a monomial 0, unless the polynomial is 0
		}
		if(ans.length()>0&&ans.charAt(0)=='+')//we need to remove a '+' sign in the end if the first number is positive 
			ans=ans.substring(1);
		if(ans.equals(""))//when the polynomial is empty or all 0
			ans="0";
		return ans;
		}
	
	public Stack<Monomial> getMonomials(){
		return monomials;
	}
	
	public Polynomial copy() {// a function to copy the polynomial 
		Polynomial copy=new Polynomial();
		Stack <Monomial> temp=new Stack<>();
		while(!monomials.isEmpty()) 
			temp.push(monomials.pop());
		while(!temp.isEmpty()) {
			Monomial now=temp.pop();
			monomials.push(now);
			copy.monomials.push(now);
		}
		
		return copy;
	}

}
