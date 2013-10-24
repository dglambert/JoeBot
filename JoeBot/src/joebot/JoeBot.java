package joebot;

import org.jibble.pircbot.*;
import messageprocessor.MessageProcessor;
import messagecontents.MessageContentsFactory;
import messagecontents.MessageContentsSpec;

public class JoeBot extends PircBot
{

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Attributes ///////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    private MessageContentsFactory messageContentsFactory = new MessageContentsFactory();
    private MessageContentsSpec messageContents;


    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors //////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    public JoeBot()
    {
    	this.setName("JoeBot");
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onDisconnect()
    {

    	while(!isConnected())
        {
        	try
            {
            	reconnect();
            }
            catch(Exception e)
            {
            	// Couldn't reconnect to server yet.
               	try
				{
					Thread.sleep(10000);
				}
				catch(Exception sleep)
				{
					System.out.println("Cant sleep onDisconnect" +  sleep);
					break;
				}
            }
        }
    }

    @Override
    public void onJoin(String channel, String sender, String login, String hostName)
    {
        final String welcomeMessage = "Welcome Back";

        if(!sender.equals(this.getName())) // replaced "JoeBot" w/ this.getName()
        {
        	sendMessage(channel, sender + ", " + welcomeMessage);
        }
    }

    @Override
    public void onMessage(String channel, String sender, String login, String hostName, String message)
    {
        messageContents = messageContentsFactory.createMessageContents(channel, sender, login, hostName, message);

        MessageProcessor msgPrc = new MessageProcessor(this, messageContents);

        msgPrc.processMessage();

    }



}