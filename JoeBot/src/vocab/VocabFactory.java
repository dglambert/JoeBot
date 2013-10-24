package vocab;


public class VocabFactory
{
    public VocabSpec createVocab(String strVocab)
    {
        VocabSpec vocab = new Vocab(strVocab);
        return vocab;
    }
}