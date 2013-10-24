package messagecontents.message;

public interface MessageSpec
{
	// What would I like to do to a Message?
    //
	// get this message
    // set this message
    // possibly get a specific word of the message based on an index number
    // translate message
    // search message on the internet
    //


    ///////////////////////////////////////////////////////////////////
    // Get Methods ////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    /**
	* Returns the String value of this Message
	*
	* @return - String value of this Message
	*/
    public String getMessage();


    ///////////////////////////////////////////////////////////////////
    // Set Methods ////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    /**
	* Sets the String value of this Message
	*
	* @param strMsg - a message represented as a String
	*/
    public void setMessage(String strMsg);


    public boolean containsCommand();

    public boolean containsTell();

    public boolean containsSay();

    public boolean containsFactoid();

    public boolean containsFactoidDefinition();

}