package messagecontents.channel;

class Channel implements ChannelSpec
{
    ///////////////////////////////////////////////////////////////////
    // Attributes /////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    String stringChannel;


    ///////////////////////////////////////////////////////////////////
    // Constructors ///////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    Channel(String strChannel)
    {
    	setChannel(strChannel);
    }


    ///////////////////////////////////////////////////////////////////
    // Get Methods ////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    public String getChannel()
    {
    	return stringChannel;
    }


    ///////////////////////////////////////////////////////////////////
    // Set Methods ////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    public void setChannel(String strChannel)
    {
    	stringChannel = strChannel;
    }
}