package vocab;


import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;


class Vocab implements VocabSpec
{
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Attributes //////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private String stringVocab;
    private Properties vocabulary = new Properties();


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    Vocab(String strVocab)
    {
        setVocab(strVocab);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Methods /////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public String returnVocab()
    {
        FileInputStream in = null;
        try
        {
            in = new FileInputStream("c:\\factoids\\vocabulary.properties");//////// Not the correct directory
            vocabulary.load(in);
            in.close();
            return vocabulary.getProperty(getVocab(), "Sorry, I don't understand").trim();
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
    public void setVocab(String strVocab)
    {
        stringVocab = strVocab;
    }

    @Override
    public String getVocab()
    {
        return stringVocab;
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
