package messagecontents.message;

public class MessageFactory
{
    public MessageSpec createMessage(String strMsg)
    {
    	MessageSpec message = new Message(strMsg);
        return message;
    }
	
}