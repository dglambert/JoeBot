package messageprocessor;

import channel.*;
import nick.*;
import login.*;
import hostname.*;
import message.*;
import joebot.*;


class Speak implements SpeakSpec
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
    
	Speak(JoeBot bot, ChannelSpec channel, NickSpec sender, LoginSpec login, HostNameSpec hostName, MessageSpec message)
    {
        joeBot = bot;
        this.channel = channel;
        this.sender = sender;
        this.login = login;
        this.hostName = hostName;
        this.message = message;
    	
        processSpeak();
    }
    
    
    void processSpeak()
    {
    	String lowerCaseMessage = message.getMessage().toLowerCase();
        
        if(lowerCaseMessage.startsWith("joebot"))
        {
            if(lowerCaseMessage.contains("hello") || lowerCaseMessage.contains("hey") || lowerCaseMessage.contains("hola") || lowerCaseMessage.contains("hi") || lowerCaseMessage.contains("bonjour"))
            {
                joeBot.sendMessage(channel.getChannel(), sender.getNick() + ", Hello");
                return;
            }
            
            if(lowerCaseMessage.contains("whats up") || lowerCaseMessage.contains("what's up"))
            {
                joeBot.sendMessage(channel.getChannel(), sender.getNick() + ", nothing, I'm a bot");
                return;
            }
            
            if(lowerCaseMessage.contains("how are you") || lowerCaseMessage.contains("hru") || lowerCaseMessage.contains("how are u") || lowerCaseMessage.contains("how r u") || lowerCaseMessage.contains("how r you"))
            {
                joeBot.sendMessage(channel.getChannel(), sender.getNick() + ", If I had feeling, I would probably be annoyed at you");
                return;
            }
        }
    }
    
    
    
    
}


  