package controller;
import java.awt.Toolkit;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class JTxtFieldAlphaNumeric extends PlainDocument 
{
	public static final String LOWERCASE  = "abcdefghijklmnopqrstuvwxyz ";
    public static final String UPPERCASE  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
	public static final String ALPHA   = LOWERCASE + UPPERCASE;
	public static final String NUMERIC = "0123456789 ";
	public static final String ALPHA_NUMERIC = ALPHA + NUMERIC;
	private int limit;

	protected String acceptedChars = null;
	protected boolean negativeAccepted = false;

	public JTxtFieldAlphaNumeric(int limitation) 
	{
		this(ALPHA_NUMERIC);
		
		this.limit = limitation;	
	}

	public JTxtFieldAlphaNumeric(String acceptedchars)
	{
		acceptedChars = acceptedchars;
	}

	public void setNegativeAccepted(boolean negativeaccepted)
	{
		if(acceptedChars.equals(NUMERIC) || acceptedChars.equals(ALPHA_NUMERIC))
		{
			negativeAccepted = negativeaccepted;
		    acceptedChars += "-";
		}
	}

	 public void insertString(int offset, String  str, AttributeSet attrs) throws BadLocationException 
	 {
		if (str == null) 
			return;
		else if((getLength() + str.length()) > limit)
		{	
			Toolkit.getDefaultToolkit().beep();
			return;
		}

		for (int i=0; i < str.length(); i++) 
		{
		    if(acceptedChars.indexOf(String.valueOf(str.charAt(i))) == -1)
		         return;
		}

		if (negativeAccepted && str.indexOf("-") != -1) 
		{
			if (str.indexOf("-") != 0 || offset != 0 )
				return;
		}

		str = str.toUpperCase();
		super.insertString(offset, str, attrs);	
	 }
}
