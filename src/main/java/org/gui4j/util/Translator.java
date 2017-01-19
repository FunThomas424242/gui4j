package org.gui4j.util;

/**
 * Interface for general translation of tags
 */
public interface Translator
{
	/**
	 * Translates a given tag with arguments
	 * @param tag the tag to translate
	 * @param args arguments to be in translation of the given tag
	 * @return the translated string
	*/
    String translate(String tag, Object[] args);
    
    /**
     * Liefert <code>true</code> zur�ck, falls eine �bersetzung definiert ist
     * @param tag
     * @return boolean
     */
    boolean isDefined(String tag);
}
