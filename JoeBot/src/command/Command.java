package command;


import factoid.FactoidSpec;
import factoid.FactoidFactory;
import messagecontents.MessageContentsSpec;

public class Command
{
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Attributes //////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private MessageContentsSpec messageContents;

    private FactoidFactory factoidFactory = new FactoidFactory();

    private FactoidSpec factoid;

    private String strFactoid = null;
    private String strFactoidDef = null;

    private String strRecipient;
    private String strSay = null;

    private boolean addingUpdatingFactoid;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////


    public Command(MessageContentsSpec messageContents)
    {
        this.messageContents = messageContents;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Methods /////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean addingFactoid()
    {
        return addingUpdatingFactoid;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Get Methods /////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public MessageContentsSpec getMessageContents()
    {
        return messageContents;
    }

    public FactoidSpec getFactoid()
    {
        return factoid;
    }

    public String getRecipient()
    {
        return strRecipient;
    }

    public String getSay()
    {
        return strSay;
    }

    public String getFactoidDef()
    {
        return strFactoidDef;
    }

//    public String getFactoidStr()
//    {
//        return strFactoid;
//    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Parse Methods ///////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void parseFactoid()
    {
        final String assignmentOp = "is";

        String remainingMessage = null;

        int beginningOfFactoid = getMessageContents().getMessage().getMessage().indexOf(",");
        int endOfFactoid = getMessageContents().getMessage().getMessage().indexOf(" ", beginningOfFactoid);

        if(endOfFactoid == -1)
        {
            strFactoid = messageContents.getMessage().getMessage().substring(beginningOfFactoid + 1).trim().toLowerCase();
        }
        else
        {
            strFactoid = messageContents.getMessage().getMessage().substring(beginningOfFactoid + 1, endOfFactoid).trim().toLowerCase();
            remainingMessage = messageContents.getMessage().getMessage().substring(endOfFactoid).trim();
        }

        factoid = factoidFactory.createFactoid(strFactoid);

        if( remainingMessage != null && remainingMessage.trim().startsWith(assignmentOp) )
        {
            strFactoidDef = remainingMessage.substring( remainingMessage.indexOf(assignmentOp) + assignmentOp.length());
        }

    }

    public void parseTell()
    {

        int tell = messageContents.getMessage().getMessage().indexOf("tell");
        int about = messageContents.getMessage().getMessage().indexOf("about", tell);

        strRecipient = messageContents.getMessage().getMessage().substring(tell + "tell".length(),about-1).trim();

        String remainingMessage = messageContents.getMessage().getMessage().substring(about + "about".length()).trim();
        int endOfFactoid = remainingMessage.indexOf(" ");

        if(endOfFactoid == -1)
        {
            strFactoid = remainingMessage.toLowerCase();
        }
        else
        {
            strFactoid = remainingMessage.substring(0, endOfFactoid).trim().toLowerCase();
        }

        factoid = factoidFactory.createFactoid(strFactoid);

    }

    public void parseSay()
    {

        int say = messageContents.getMessage().getMessage().indexOf("say");
        say += "say".length();

        if(messageContents.getSender().getNick().equalsIgnoreCase("devin_") || messageContents.getSender().getNick().equalsIgnoreCase("devin-") )
        {
            strSay = messageContents.getMessage().getMessage().substring(say).trim();
        }

    }


}