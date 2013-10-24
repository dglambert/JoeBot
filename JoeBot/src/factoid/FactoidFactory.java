package factoid;

public class FactoidFactory
{
    public FactoidSpec createFactoid(String strFactoid)
    {
        FactoidSpec factoid = new Factoid(strFactoid);
        return factoid;
    }
}
