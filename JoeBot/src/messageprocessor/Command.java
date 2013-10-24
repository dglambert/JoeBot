package messageprocessor;

import messagecontents.channel.*;
import nick.*;
import login.*;
import hostname.*;
import message.*;
import joebot.*;


class Command implements CommandSpec
{
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Attributes ///////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    JoeBot joeBot;
    ChannelSpec channel;
    NickSpec sender;
    LoginSpec login;
    HostNameSpec hostName;
    MessageSpec message;


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors /////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

	Command(JoeBot bot, ChannelSpec channel, NickSpec sender, LoginSpec login, HostNameSpec hostName, MessageSpec message)
    {
        joeBot = bot;
        this.channel = channel;
        this.sender = sender;
        this.login = login;
        this.hostName = hostName;
        this.message = message;

        processCommand();
    }


    void processCommand()
    {
        joeBot.sendMessage(channel.getChannel(), "before factoid()");
    	if(message.isFactoid())
        	factoid();

        joeBot.sendMessage(channel.getChannel(), "before tell()");
        if(message.isTell())
            tell();

        joeBot.sendMessage(channel.getChannel(), "before say()");
        if(message.isSay())
            say();
    }

    void factoid()
    {
    	if(message.getMessage().startsWith(",helloworld"))
        {
        	joeBot.sendMessage(channel.getChannel(), "Helloworld is the program all programmers start learning with.");
            return;
        }
    }

    void tell()
    {
        int tell = message.getMessage().indexOf("tell");
        int about = message.getMessage().indexOf("about", tell);

        String nick = message.getMessage().substring(tell + "tell".length(),about-1);
        nick = nick.trim();

        joeBot.sendMessage(channel.getChannel(), "\n\ntell: " +  tell + " about: " + about " nick: " + nick);


        if(nick.toLowerCase().contentEquals("me"))
        {
        	joeBot.sendMessage(channel.getChannel(), sender.getNick() + ", Helloworld is the program all programmers start learning with.");
            return;
        }

       	joeBot.sendMessage(channel.getChannel(), nick + ", Helloworld is the program all programmers start learning with.");
    }

    void say()
    {
    	int say = message.getMessage().indexOf("say");
        say = say + "say".length();

        joeBot.sendMessage(channel.getChannel(), message.getMessage().substring(say));
    }









}