package CalcMath;

import ConstsExceptionsEnums.IncorrectSpellException;

import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interpreter
{

    public static Polynomial createPolynomial(String equation, SystemType systemType) throws IncorrectSpellException
    {
        Pattern pattern;
        Matcher matcher;
        String regexDecimal = "\\d+(\\.\\d+)?";
        String regexHexadecimal = "[0-9A-F]+";
        String regexOctal = "[0-7]+";
        String regexBinary = "([1?|0?]+)";
        String regexSign = "\\+|\\-|\\*|\\/|\\^|(SQRT:)|%";
        String regexSpellCheck = "\\++|\\-+|\\*+|\\/+|\\^+|(SQRT:)+|\\.+|(\\d+SQRT:)|^(SQRT:\\d)|(SQRT:^\\d)|(%+)|(\\d+%\\d+)";

        //Assign
        ArrayList<Double> numbersBuffer = new ArrayList<>();
        ArrayList<String> operationsBuffer = new ArrayList<>();

        //Spell check
        if(equation.matches(regexSpellCheck))
        {
            throw new IncorrectSpellException();
        }

        //Buffers numbers
        switch(systemType)
        {
            case DECIMAL:
                pattern = Pattern.compile(regexDecimal);
                matcher = pattern.matcher(equation);
                break;
            case HEXADECIMAL:
                pattern = Pattern.compile(regexHexadecimal);
                matcher = pattern.matcher(equation);
                break;
            case OCTAL:
                pattern = Pattern.compile(regexOctal);
                matcher = pattern.matcher(equation);
                break;
            default:
                pattern = Pattern.compile(regexBinary);
                matcher = pattern.matcher(equation);
                break;
        }

        while (matcher.find())
        {
            switch(systemType)
            {
                case DECIMAL:
                    numbersBuffer.add(Double.parseDouble(matcher.group()));
                    break;
                case HEXADECIMAL:
                    numbersBuffer.add((double)Integer.parseInt(matcher.group(), 16));
                    break;
                case OCTAL:
                    numbersBuffer.add((double)Integer.parseInt(matcher.group(), 8));
                    break;
                default:
                    numbersBuffer.add((double)Integer.parseInt(matcher.group(), 2));
                    break;
            }
        }

        //Buffers operations
        pattern = Pattern.compile(regexSign);
        matcher = pattern.matcher(equation);

        while (matcher.find())
        {
            operationsBuffer.add(matcher.group());
        }

        return new Polynomial(numbersBuffer, operationsBuffer);
    }

    public static Function createFunction(String equation,Color color, int x1, int x2) throws IncorrectSpellException
    {

        Pattern pattern;
        Matcher matcher;
        String regexDecimal = "\\d+(\\.\\d+)?|x";
        String regexOperations = "\\+|\\-|\\*|\\/|\\^|(SQRT:)|%";
        String regexSpellCheck = "\\++|\\-+|\\*+|\\/+|\\^+|(SQRT:)+|\\.+|(\\d+SQRT:)|" +
                                 "^(SQRT:\\d)|(SQRT:^\\d)|(%+)|(\\d+%\\d+)|x+|\\d+(\\.\\d+)?x|x\\d+(\\.\\d+)?";

        //Assign
        ArrayList<String> varBuffer = new ArrayList<>();
        ArrayList<String> operationsBuffer = new ArrayList<>();

        //Buffers numbers and variables
        pattern = Pattern.compile(regexDecimal);
        matcher = pattern.matcher(equation);

        while (matcher.find())
        {
            varBuffer.add(matcher.group());
        }

        //Buffers operations
        pattern = Pattern.compile(regexOperations);
        matcher = pattern.matcher(equation);

        while (matcher.find())
        {
            operationsBuffer.add(matcher.group());
        }

        return new Function(varBuffer, operationsBuffer, color, x1, x2);
    }
}