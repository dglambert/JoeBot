package messagecontents.login;

public class LoginFactory
{
    public LoginSpec createLogin(String strLogin)
    {
    	LoginSpec login = new Login(strLogin);
        return login;
    }
	
}