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

        while (this.operationsBuffer.size() > 0)
        {
            while(this.operationsBuffer.contains("SQRT:"))
            {
                operationIndex = this.operationsBuffer.indexOf("SQRT:");
                modifiedNumber = Math.sqrt(this.numbersBuffer.get(operationIndex));

                this.numbersBuffer.remove(operationIndex);
                this.numbersBuffer.add(operationIndex, modifiedNumber);
                this.operationsBuffer.remove(operationIndex);
            }

            while(this.operationsBuffer.contains("^"))
            {
                operationIndex = this.operationsBuffer.indexOf("^");
                modifiedNumber = Math.pow(this.numbersBuffer.get(operationIndex), this.numbersBuffer.get(operationIndex + 1));

                this.numbersBuffer.remove(operationIndex + 1);
                this.numbersBuffer.remove(operationIndex);
                this.numbersBuffer.add(operationIndex, modifiedNumber);
                this.operationsBuffer.remove(operationIndex);
            }

            while(this.operationsBuffer.contains("%"))
            {
                operationIndex = this.operationsBuffer.indexOf("%");
                modifiedNumber = this.numbersBuffer.get(operationIndex) / 100;

                this.numbersBuffer.remove(operationIndex);
                this.numbersBuffer.add(operationIndex, modifiedNumber);
                this.operationsBuffer.remove(operationIndex);
            }

            while(this.operationsBuffer.contains("*"))
            {
                operationIndex = this.operationsBuffer.indexOf("*");
                modifiedNumber = this.numbersBuffer.get(operationIndex) * this.numbersBuffer.get(operationIndex + 1);

                this.numbersBuffer.remove(operationIndex + 1);
                this.numbersBuffer.remove(operationIndex);
                this.numbersBuffer.add(operationIndex, modifiedNumber);
                this.operationsBuffer.remove(operationIndex);
            }

            while(this.operationsBuffer.contains("/"))
            {
                operationIndex = this.operationsBuffer.indexOf("/");
                modifiedNumber = this.numbersBuffer.get(operationIndex) / this.numbersBuffer.get(operationIndex + 1);

                this.numbersBuffer.remove(operationIndex + 1);
                this.numbersBuffer.remove(operationIndex);
                this.numbersBuffer.add(operationIndex, modifiedNumber);
                this.operationsBuffer.remove(operationIndex);
            }

            while(this.operationsBuffer.contains("+"))
            {
                operationIndex = this.operationsBuffer.indexOf("+");
                modifiedNumber = this.numbersBuffer.get(operationIndex) + this.numbersBuffer.get(operationIndex + 1);

                this.numbersBuffer.remove(operationIndex + 1);
                this.numbersBuffer.remove(operationIndex);
                this.numbersBuffer.add(operationIndex, modifiedNumber);
                this.operationsBuffer.remove(operationIndex);
            }

            while(operationsBuffer.contains("-"))
            {
                operationIndex = this.operationsBuffer.indexOf("-");
                modifiedNumber = this.numbersBuffer.get(operationIndex) - this.numbersBuffer.get(operationIndex + 1);

                this.numbersBuffer.remove(operationIndex + 1);
                this.numbersBuffer.remove(operationIndex);
                this.numbersBuffer.add(operationIndex, modifiedNumber);
                this.operationsBuffer.remove(operationIndex);
            }
        }

        if(this.numbersBuffer.size() > 0)
        {
            result = this.numbersBuffer.get(0);
        }

        return result;
    }

    public double getResult()
    {
        return calculateResult();
    }
}