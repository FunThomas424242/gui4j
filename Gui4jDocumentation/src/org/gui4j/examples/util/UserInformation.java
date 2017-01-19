package org.gui4j.examples.util;

import org.gui4j.util.Translator;

/**
 * Kann verwendet werden um in der Applikation den Programmablaug 
 * zu unterbrechen um den Benutzer �ber ein Problem zu informieren.
 * Wird insbesondere von Gui4j verwendet f�r die Validierung von
 * Eingabewerten.
 */
public class UserInformation extends RuntimeException
{
	private final String informationTag;
	private final Object[] informationArgs;
	
	/**
	 * Constructor for UserInformation.
	 * @param informationTag
	 * @param informationArgs
	 */
	public UserInformation(String informationTag, Object[] informationArgs)
	{
		super(informationTag);
		this.informationTag = informationTag;
		this.informationArgs = informationArgs;
	}
    
    public UserInformation(String informationTag)
    {
        this(informationTag,null);
    }

	public UserInformation(String informationTag, Object[] informationArgs, Throwable cause)
	{
		super(informationTag, cause);
		this.informationTag = informationTag;
		this.informationArgs = informationArgs;
	}
	
    /**
     * Liefert den �bersetzten Text zur�ck
     * @param translator
     * @return String
     */
	public String getInformationMessage(Translator translator)
	{
		return translator.translate(informationTag, informationArgs);
	}
    
    public Object[] getInformationArgs() {
        return informationArgs;
    }

    public String getInformationTag() {
        return informationTag;
    }

    public String toString()
    {
        return getClass().getName() + "[" + informationTag + ", " + informationArgs.length + "]";
    }

}
