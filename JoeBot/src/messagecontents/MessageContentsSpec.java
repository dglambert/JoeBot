package messagecontents;


import messagecontents.channel.ChannelSpec;
import messagecontents.hostname.HostNameSpec;
import messagecontents.login.LoginSpec;
import messagecontents.message.MessageSpec;
import messagecontents.nick.NickSpec;


public interface MessageContentsSpec
{

    //////////////////////////////////////////////
    // Get Methods ///////////////////////////////
    //////////////////////////////////////////////

    public ChannelSpec getChannel();

    public HostNameSpec getHostName();

    public LoginSpec getLogin();

    public NickSpec getSender();

    public MessageSpec getMessage();


    //////////////////////////////////////////////
    // Set Methods ///////////////////////////////
    //////////////////////////////////////////////

    public void setChannel(ChannelSpec channel);

    public void setHostName(HostNameSpec hostName);

    public void setLogin(LoginSpec login);

    public void setSender(NickSpec sender);

    public void setMessage(MessageSpec message);


}
