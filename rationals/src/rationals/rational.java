package rationals;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.math.*;

public class rational {

	private int _numerator;
	private int _denominator;

	//Constructor
	public rational(int num, int den)
	{
		if (den==0 || den<0) {
			JOptionPane.showMessageDialog(new JFrame(), "denominator cannot be 0 or negative. Try again.");
			this._numerator = 0;
			this._denominator = 1;
		}
		this._numerator = num;
		this._denominator = den;
	}
	
	//Compare 2 rational numbers (greater than)
	public boolean greaterThan(rational num)
	{
		return _numerator*num._denominator>_denominator*num._numerator;
	}
	
	//Compare 2 rational numbers (equals) 
	public boolean equals(rational num)
	{
		System.out.println(_numerator);
		System.out.println(_denominator);
		System.out.println(num._numerator);
		System.out.println(num._denominator);
		
		System.out.println(_numerator*num._denominator==_denominator*num._numerator);
		return _numerator*num._denominator==_denominator*num._numerator;
	}
	
	//Add 2 rational numbers
	public rational plus(rational num)
	{
		rational retRational = new rational((_numerator*num._denominator)+(_denominator*num._numerator),(_denominator*num._denominator));
		return retRational;
	}
	
	//Subtract  
	public rational minus(rational num)
	{
		rational retRational = new rational((_numerator*num._denominator)-(_denominator*num._numerator),(_denominator*num._denominator));
		return retRational;
	}
	
	//Multiply 2 rational numbers
	public rational multiply(rational num)
	{
		rational retRational = new rational((_numerator*num._numerator),(_denominator*num._denominator));
		return retRational;
	}
	
	//Get numerator
	public int get_numerator() {
		return _numerator;
	}

	//Get denominator
	public int get_denominator() {
		return _denominator;
	}
	
	//Show a rational number as P/Q
	public String toString()
	{
		String str=_numerator+"/"+_denominator;
		return str;
	}
	
	//Reduce the rational number to the minimum
	public rational reduce()
	{
		BigInteger bi1 = BigInteger.valueOf(_numerator);
		BigInteger bi2 = BigInteger.valueOf(_denominator);
		BigInteger bi3 = bi1.gcd(bi2);
		
		rational retRational = new rational((bi1.intValue()/bi3.intValue()),(bi2.intValue()/bi3.intValue()));
		return retRational;
	}
}
