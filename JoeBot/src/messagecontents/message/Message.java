package messagecontents.message;

class Message implements MessageSpec
{
    ///////////////////////////////////////////////////////////////////
    // Attributes /////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    private String stringMessage;


    ///////////////////////////////////////////////////////////////////
    // Constructors ///////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    Message(String strMsg)
    {
    	setMessage(strMsg);
    }


    ///////////////////////////////////////////////////////////////////
    // Get Methods ////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    @Override
    public String getMessage()
    {
    	return stringMessage;
    }


    ///////////////////////////////////////////////////////////////////
    // Set Methods ////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    @Override
    public void setMessage(String strMsg)
    {
    	stringMessage = strMsg;
    }


    ///////////////////////////////////////////////////////////////////
    // Class Specific Methods /////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    @Override
    public boolean containsCommand()
    {

        if(containsFactoidDefinition())
        {
            return true;
        }

        if(containsFactoid())
        {
            return true;
        }

        if(containsSay())
        {
            return true;
        }

        if(containsTell())
        {
            return true;
        }

        return false;
    }

    @Override
    public boolean containsSay()
    {
    	if(stringMessage.toLowerCase().contains("joebot, say"))
        {
        	return true;
        }

        if(stringMessage.toLowerCase().contains("joebot: say"))
        {
        	return true;
        }

        if(stringMessage.toLowerCase().contains("joebot say"))
        {
        	return true;
        }

        return false;
    }

    @Override
    public boolean containsTell()
    {
    	if(stringMessage.toLowerCase().contains("joebot, tell"))
        {
            return true;
        }

        if(stringMessage.toLowerCase().contains("joebot: tell"))
        {
        	return true;
        }

        if(stringMessage.toLowerCase().contains("joebot tell"))
        {
        	return true;
        }

        return false;
    }

    @Override
    public boolean containsFactoid()
    {
    	if(stringMessage.trim().startsWith(","))
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean containsFactoidDefinition()
    {
        if(containsFactoid())
        {
            int endOfFactoid = stringMessage.indexOf(' ');

            if( -1 != stringMessage.indexOf("is", endOfFactoid))
            {
               return true;
            }
        }

        return false;
    }
}