package CalcMath;

import java.util.ArrayList;

public class Polynomial
{
    private ArrayList<Double> numbersBuffer;
    private ArrayList<String> operationsBuffer;

    Polynomial(ArrayList<Double> numbersBuffer, ArrayList<String> operationsBuffer)
    {
        this.numbersBuffer = numbersBuffer;
        this.operationsBuffer = operationsBuffer;
    }

    private double calculateResult()
    {
        int operationIndex = 0;
        double modifiedNumber = 0;
        double result = 0;

        while (operationsBuffer.size() > 0)
        {
            while(operationsBuffer.contains("SQRT:"))
            {
                operationIndex = operationsBuffer.indexOf("SQRT:");
                modifiedNumber = Math.sqrt(numbersBuffer.get(operationIndex));

                numbersBuffer.remove(operationIndex);
                numbersBuffer.add(operationIndex, modifiedNumber);
                operationsBuffer.remove(operationIndex);
            }

            while(operationsBuffer.contains("^"))
            {
                operationIndex = operationsBuffer.indexOf("^");
                modifiedNumber = Math.pow(numbersBuffer.get(operationIndex), numbersBuffer.get(operationIndex + 1));

                numbersBuffer.remove(operationIndex + 1);
                numbersBuffer.remove(operationIndex);
                numbersBuffer.add(operationIndex, modifiedNumber);
                operationsBuffer.remove(operationIndex);
            }

            while(operationsBuffer.contains("%"))
            {
                operationIndex = operationsBuffer.indexOf("%");
                modifiedNumber = numbersBuffer.get(operationIndex) / 100;

                numbersBuffer.remove(operationIndex);
                numbersBuffer.add(operationIndex, modifiedNumber);
                operationsBuffer.remove(operationIndex);
            }

            while(operationsBuffer.contains("*"))
            {
                operationIndex = operationsBuffer.indexOf("*");
                modifiedNumber = numbersBuffer.get(operationIndex) * numbersBuffer.get(operationIndex + 1);

                numbersBuffer.remove(operationIndex + 1);
                numbersBuffer.remove(operationIndex);
                numbersBuffer.add(operationIndex, modifiedNumber);
                operationsBuffer.remove(operationIndex);
            }

            while(operationsBuffer.contains("/"))
            {
                operationIndex = operationsBuffer.indexOf("/");
                modifiedNumber = numbersBuffer.get(operationIndex) / numbersBuffer.get(operationIndex + 1);

                numbersBuffer.remove(operationIndex + 1);
                numbersBuffer.remove(operationIndex);
                numbersBuffer.add(operationIndex, modifiedNumber);
                operationsBuffer.remove(operationIndex);
            }

            while(operationsBuffer.contains("+"))
            {
                operationIndex = operationsBuffer.indexOf("+");
                modifiedNumber = numbersBuffer.get(operationIndex) + numbersBuffer.get(operationIndex + 1);

                numbersBuffer.remove(operationIndex + 1);
                numbersBuffer.remove(operationIndex);
                numbersBuffer.add(operationIndex, modifiedNumber);
                operationsBuffer.remove(operationIndex);
            }

            while(operationsBuffer.contains("-"))
            {
                operationIndex = operationsBuffer.indexOf("-");
                modifiedNumber = numbersBuffer.get(operationIndex) - numbersBuffer.get(operationIndex + 1);

                numbersBuffer.remove(operationIndex + 1);
                numbersBuffer.remove(operationIndex);
                numbersBuffer.add(operationIndex, modifiedNumber);
                operationsBuffer.remove(operationIndex);
            }
        }

        if(numbersBuffer.size() > 0)
        {
            result = numbersBuffer.get(0);
        }

        return result;
    }

    public double getResult()
    {
        return calculateResult();
    }
}