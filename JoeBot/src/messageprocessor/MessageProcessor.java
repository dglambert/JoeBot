package messageprocessor;

import speech.Speech;
import command.Command;
import messagecontents.MessageContentsSpec;
import joebot.JoeBot;
import messageprocessor.commandprocessor.CommandProcessor;
import messageprocessor.speechprocessor.SpeechProcessor;


public class MessageProcessor
{
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Attributes //////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private JoeBot joeBot;
    private MessageContentsSpec messageContents;


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

	public MessageProcessor(JoeBot bot, MessageContentsSpec msgContents)
    {
        joeBot = bot;
        messageContents = msgContents;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Methods /////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void processMessage()
    {
    	if(messageContents.getMessage().containsCommand())
        {
        	Command command = new Command(messageContents);
            CommandProcessor commandProcessor = new CommandProcessor(joeBot, command);
            commandProcessor.processCommand();
        }
        else
        {
            Speech speech = new Speech(messageContents);
            SpeechProcessor speechProcessor = new SpeechProcessor(joeBot, speech);
            speechProcessor.processSpeech();
        }
    }
}