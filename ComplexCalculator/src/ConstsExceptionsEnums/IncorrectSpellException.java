package ConstsExceptionsEnums;

public class IncorrectSpellException extends Exception
{
    public IncorrectSpellException()
    {
        super("Equation is written incorrectly");
    }
}
