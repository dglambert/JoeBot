package factoid;


public interface FactoidSpec
{
    public String returnFactoid();

    public String addFactoid(String newFactoid, String factoidDef);

    public String getFactoid();

    public void setFactoid(String strFactoid);
}
