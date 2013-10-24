package messagecontents;

import messagecontents.channel.ChannelFactory;
import messagecontents.channel.ChannelSpec;

import messagecontents.hostname.HostNameFactory;
import messagecontents.hostname.HostNameSpec;

import messagecontents.login.LoginFactory;
import messagecontents.login.LoginSpec;

import messagecontents.message.MessageFactory;
import messagecontents.message.MessageSpec;

import messagecontents.nick.NickFactory;
import messagecontents.nick.NickSpec;


class MessageContents implements MessageContentsSpec
{
    ///////////////////////////////////////////////////////////////////
    // Attributes /////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    private ChannelSpec channel;
    private NickSpec sender;
    private LoginSpec login;
    private HostNameSpec hostName;
    private MessageSpec message;

    private ChannelFactory channelFactory = new ChannelFactory();
    private NickFactory nickFactory = new NickFactory();
    private LoginFactory loginFactory = new LoginFactory();
    private HostNameFactory hostNameFactory = new HostNameFactory();
    private MessageFactory messageFactory = new MessageFactory();


    ///////////////////////////////////////////////////////////////////
    // Constructors ///////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////


    MessageContents(String channelStr, String senderStr, String loginStr, String hostNameStr, String messageStr)
    {
        channel = channelFactory.createChannel(channelStr);
        sender = nickFactory.createNick(senderStr);
        login = loginFactory.createLogin(loginStr);
        hostName = hostNameFactory.createHostName(hostNameStr);
        message = messageFactory.createMessage(messageStr);

    }


    //////////////////////////////////////////////////////////////////
    // Get Methods ///////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////

    @Override
    public ChannelSpec getChannel()
    {
        return channel;
    }

    @Override
    public HostNameSpec getHostName()
    {
        return hostName;
    }

    @Override
    public LoginSpec getLogin()
    {
        return login;
    }

    @Override
    public NickSpec getSender()
    {
        return sender;
    }

    @Override
    public MessageSpec getMessage()
    {
        return message;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Set Methods /////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void setChannel( ChannelSpec channel )
    {
        this.channel = channel;
    }

    @Override
    public void setHostName( HostNameSpec hostName )
    {
        this.hostName = hostName;
    }

    @Override
    public void setLogin( LoginSpec login )
    {
        this.login = login;
    }

    @Override
    public void setSender( NickSpec sender )
    {
        this.sender = sender;
    }

    @Override
    public void setMessage( MessageSpec message )
    {
        this.message = message;
    }

    
}
