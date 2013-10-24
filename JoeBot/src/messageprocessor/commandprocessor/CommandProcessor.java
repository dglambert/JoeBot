package messageprocessor.commandprocessor;


import command.Command;
import joebot.JoeBot;


public class CommandProcessor
{

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Attributes //////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private JoeBot joeBot;
    private Command command;


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

	public CommandProcessor(JoeBot joeBot, Command command)
    {
        this.joeBot = joeBot;
        this.command = command;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Selection Methods ///////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void processCommand()
    {
    	if(command.getMessageContents().getMessage().containsFactoidDefinition())
        {
            factoidAdd();
            return;
        }

        if(command.getMessageContents().getMessage().containsFactoid())
        {
            factoid();
        }

        if(command.getMessageContents().getMessage().containsTell())
        {
            tell();
        }

        if(command.getMessageContents().getMessage().containsSay())
        {
            say();
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Command Methods /////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private void factoidAdd()
    {
        command.parseFactoid();
        command.getFactoid().addFactoid(command.getFactoid().getFactoid(), command.getFactoidDef());
    }

    private void factoid()
    {
        command.parseFactoid();
        joeBot.sendMessage(command.getMessageContents().getChannel().getChannel(), command.getFactoid().returnFactoid());
    }

    private void tell()
    {
        command.parseTell();

        if(command.getFactoid().returnFactoid().contentEquals("Factoid not found") )
        {
            joeBot.sendMessage(command.getMessageContents().getChannel().getChannel(), command.getMessageContents().getSender().getNick() + ", " + command.getFactoid().returnFactoid());
            return;
        }

        if(command.getRecipient().toLowerCase().contentEquals("me"))
        {
        	joeBot.sendMessage(command.getMessageContents().getChannel().getChannel(), command.getMessageContents().getSender().getNick() + ", " + command.getFactoid().returnFactoid());
            return;
        }

       	joeBot.sendMessage(command.getMessageContents().getChannel().getChannel(), command.getRecipient() + ", " + command.getFactoid().returnFactoid());
    }

    private void say()
    {
        command.parseSay();

        if(command.getSay() != null)
        {
            joeBot.sendMessage(command.getMessageContents().getChannel().getChannel(), command.getSay());
        }
    }

}
