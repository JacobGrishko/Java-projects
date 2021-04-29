package rationals;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		int inpNum, inpDen;
		
//Enter First rational number		
		JOptionPane.showMessageDialog(new JFrame(), "Hello, please enter 2 numbers as numerator and denominator.");
		
		inpNum =Integer.parseInt(JOptionPane.showInputDialog("numenator:"));
		do {
			inpDen =Integer.parseInt(JOptionPane.showInputDialog("denominator:")) ;
			if (inpDen==0)
				JOptionPane.showMessageDialog(new JFrame(), "denominator cannot be 0");
		}
		while  (inpDen==0);
		
		rational rational1 = new rational(inpNum, inpDen);
		rational redRational1 = rational1.reduce();
		
//Enter second rational number		
		JOptionPane.showMessageDialog(new JFrame(), "Great, now enter another 2 numbers as numerator and denominator.");
		
		inpNum =Integer.parseInt(JOptionPane.showInputDialog("numenator:"));
		do {
			inpDen =Integer.parseInt(JOptionPane.showInputDialog("denominator:")) ;
			if (inpDen==0)
				JOptionPane.showMessageDialog(new JFrame(), "denominator cannot be 0");
		}
		while  (inpDen==0);
		
		rational rational2 = new rational(inpNum, inpDen);
		rational redRational2 = rational2.reduce();
		
//Create strings of all comparisons
		String resInp = 		"First rational number you entered is: "+rational1.toString()+" reduced: "+redRational1.toString()+"\n"+
								"Second rational number you entered is: "+rational2.toString()+" reduced: "+redRational2.toString()+"\n";
		String resGreater =		redRational1.toString()+" is greater than "+redRational2.toString()+" :"+redRational1.greaterThan(redRational2)+"\n";
		String resEquals =		redRational1.toString()+" equals "+redRational2.toString()+" :"+redRational1.equals(redRational2)+"\n";
		String resPlus =		redRational1.toString()+"+"+redRational2.toString()+"="+redRational1.plus(redRational2)+"\n";
		String resMinus =		redRational1.toString()+"-"+redRational2.toString()+"="+redRational1.minus(redRational2)+"\n";
		String resMult =		redRational1.toString()+"*"+redRational2.toString()+"="+redRational1.multiply(redRational2)+"\n";				
		
//Show result				
		JOptionPane.showMessageDialog(new JFrame(), resInp+resGreater+resEquals+resPlus+resMinus+resMult);

	}

}
