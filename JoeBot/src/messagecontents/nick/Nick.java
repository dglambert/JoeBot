package messagecontents.nick;

class Nick implements NickSpec
{
    //////////////////////////////////////////////////////////////////
    // Attributes ////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    
    String stringNick;
    
    
    //////////////////////////////////////////////////////////////////
    // Constructors //////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    
	Nick(String strNick)
    {
    	setNick(strNick);
    }
    
    
    //////////////////////////////////////////////////////////////////
    // Set Methods ///////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    
    public void setNick(String strNick)
    {
    	stringNick = strNick;
    }
    
    //////////////////////////////////////////////////////////////////
    // Get Methods ///////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    
    public String getNick()
    {
    	return stringNick;
    }
}