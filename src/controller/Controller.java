package controller;

import javax.swing.JOptionPane;

public class Controller
{

public boolean isInt(String maybeInt)
{
	boolean isValid = false;

	try
	{
		Integer.parseInt(maybeInt);
		isValid = true;
	}
	catch (NumberFormatException error)
	{
		JOptionPane.showMessageDialog(null, "You need to type in a whole number :D");
	}

	return isValid;
}


public boolean isDouble(String mightBeDouble)
{
	boolean isValid = false;

	try
	{
		Double.parseDouble(mightBeDouble);
		isValid = true;
	}
	catch (NumberFormatException error)
	{
		JOptionPane.showMessageDialog(null, "Type in a decimal value AKA a number with a . in the middle");
	}
	return isValid;
}


}