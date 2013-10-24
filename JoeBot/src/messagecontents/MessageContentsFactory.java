package messagecontents;


public class MessageContentsFactory
{
    public MessageContentsSpec createMessageContents(String channel, String sender, String login, String hostName, String message)
    {
        MessageContentsSpec messageContents = new MessageContents(channel, sender, login, hostName, message);
        return messageContents;
    }

}
