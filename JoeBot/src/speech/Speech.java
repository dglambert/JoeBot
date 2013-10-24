package speech;

import messagecontents.MessageContentsSpec;
import vocab.VocabFactory;
import vocab.VocabSpec;

public class Speech
{

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Attributes //////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private MessageContentsSpec messageContents;

    private VocabFactory vocabFactory = new VocabFactory();
    private VocabSpec vocab;

    private boolean containsGreeting;


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

	public Speech(MessageContentsSpec messageContents)
    {
        this.messageContents = messageContents;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Methods /////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public VocabSpec getVocab()
    {
        return vocab;
    }


//    public void parseSpeech()
//    {
//        String lowerCaseMessage = messageContents.getMessage().getMessage().toLowerCase();
//
//        if(lowerCaseMessage.startsWith("joebot"))
//        {
//            lowerCaseMessage = lowerCaseMessage.substring(  lowerCaseMessage.indexOf(" ",    lowerCaseMessage.indexOf("joebot"))   ).trim();
//
//
//
//            if(lowerCaseMessage.startsWith(vocab.returnVocab()) )
//            {
//               //////
//            }
//
//            if(lowerCaseMessage.contains("hello") || lowerCaseMessage.contains("hey") || lowerCaseMessage.contains("hola") || lowerCaseMessage.contains("hi") || lowerCaseMessage.contains("bonjour"))
//            {
//                joeBot.sendMessage(messageContents.getChannel().getChannel(), messageContents.getSender().getNick() + ", Hello");
//                return;
//            }
//
//            if(lowerCaseMessage.contains("whats up") || lowerCaseMessage.contains("what's up"))
//            {
//                joeBot.sendMessage(messageContents.getChannel().getChannel(), messageContents.getSender().getNick() + ", nothing, I'm a bot");
//                return;
//            }
//
//            if(lowerCaseMessage.contains("how are you") || lowerCaseMessage.contains("hru") || lowerCaseMessage.contains("how are u") || lowerCaseMessage.contains("how r u") || lowerCaseMessage.contains("how r you"))
//            {
//                joeBot.sendMessage(messageContents.getChannel().getChannel(), messageContents.getSender().getNick() + ", If I had feeling, I would probably be annoyed at you");
//                return;
//            }
//        }
//
//    }


    public void processSpeech()
    {

    }

    public boolean containsGreeting()
    {
        return containsGreeting;
    }

}


