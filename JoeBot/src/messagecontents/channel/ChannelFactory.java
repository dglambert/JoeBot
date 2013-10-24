package messagecontents.channel;

public class ChannelFactory
{
    public ChannelSpec createChannel(String strChannel)
    {
    	ChannelSpec channel = new Channel(strChannel);
        return channel;
    }
	
}