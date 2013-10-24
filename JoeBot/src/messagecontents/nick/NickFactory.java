package messagecontents.nick;

public class NickFactory
{
	public NickSpec createNick(String strNick)
    {
    	NickSpec nick = new Nick(strNick);
        return nick;
    }
}