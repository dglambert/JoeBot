package messagecontents.hostname;

public class HostNameFactory
{
    public HostNameSpec createHostName(String strHostName)
    {
    	HostNameSpec hostName = new HostName(strHostName);
        return hostName;
    }
	
}