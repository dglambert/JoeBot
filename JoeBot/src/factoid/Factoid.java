package factoid;

import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class Factoid implements FactoidSpec
{

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Attributes //////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private String stringFactoid;
    private Properties factoids = new Properties();
    private final String DIRECTORY = "factoids.properties";


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    Factoid(String strFactoid)
    {
        setFactoid(strFactoid);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Methods /////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void setFactoid(String strFactoid)
    {
        stringFactoid = strFactoid;
    }

    @Override
    public String getFactoid()
    {
        return stringFactoid;
    }

    @Override
    public String returnFactoid()
    {
        FileInputStream in = null;
        try
        {
            in = new FileInputStream(DIRECTORY);
            factoids.load(in);
            in.close();
            return factoids.getProperty(getFactoid(), "Factoid not found").trim();
        }
        catch(IOException ex)
        {
            return ex.toString() + "Inside of returnFactoid";
        }
        finally
        {
           closeStream(in);
        }
    }

    @Override
     public String addFactoid(String newFactoid, String factoidDef)
    {
        FileInputStream in = null;
        FileOutputStream out = null;

        try
        {
            in = new FileInputStream(DIRECTORY);
            factoids.load(in);
            in.close();

            factoids.setProperty(newFactoid, factoidDef);
            out = new FileOutputStream(DIRECTORY);
            factoids.store(out, null);
            out.close();
            return "Successfully Added";
        }
        catch(IOException ex)
        {
            return ex.toString() + "Inside Of addFactoid";
        }
        finally
        {
           closeStream(in);
           closeStream(out);
        }
    }

    public void closeStream(Closeable obj)
    {
    	try
        {
            if(obj != null)
            {
        		obj.close();
            }
        }
        catch(IOException e)
        {
        	// doesnt matter
        }
    }



}