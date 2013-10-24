package main;

import joebot.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class JoeBotMain
{
    private static final String DIRECTORY = "password.properties";

	public static void main(String[] args) throws Exception
    {
    	JoeBot bot = new JoeBot();


        bot.setVerbose(true);


        try
        {
            System.out.println("\n\n");
            bot.connect("irc.freenode.net");
        }
        catch(Exception e)
        {
        	System.out.println("\n\n\n\nCan't Connect: " + e + "\n\n\n");
            return;
        }

        Properties passwordFile = new Properties();
        String password = null;
        FileInputStream in = null;

        try
        {
            in = new FileInputStream(DIRECTORY);
            passwordFile.load(in);

            password = passwordFile.getProperty("password");
        }
        finally
        {
            in.close();
        }




        System.out.println("\n\n");
        bot.identify(password);
        Thread.sleep(10000); // Make sure there is enough time for the cloak to set


        System.out.println("\n\n");
        bot.joinChannel("##ssu13cs_seniorproject", "Beifang");
        Thread.sleep(3000);


		System.out.println("\n\n");
        bot.joinChannel("#ssu_cs", "201j");
        Thread.sleep(3000);


    }
}