package CalcMath;

import ConstsExceptionsEnums.Const;

import java.awt.*;
import java.util.ArrayList;

public class Function
{
    //Visuals
    private boolean isVisible;
    private Color funcColor;
    //Math
    private double x;
    private int drawingPanelWidth;
    private int drawingPanelHeight;
    private ArrayList<String> varBuffer;
    private ArrayList<String> operationsBufferCopy;
    private ArrayList<String> operationsBuffer;
    private ArrayList<Integer> numbersBuffer;
    private ArrayList<int[]> dots;

    Function(ArrayList<String> varBuffer, ArrayList<String> operationsBuffer, Color funcColor, int x1, int x2)
    {
        this.funcColor = funcColor;
        this.varBuffer = varBuffer;
        this.operationsBuffer = operationsBuffer;
        this.operationsBufferCopy = new ArrayList<>(operationsBuffer);
        this.numbersBuffer = new ArrayList<>();
        this.dots = new ArrayList<>();
        this.isVisible = true;
        this.x = 0;
        this.drawingPanelWidth = 0;
        this.drawingPanelHeight = 0;

        createDotMap(x1, x2);
    }

    private void createDotMap(int x1, int x2)
    {
        for (int i = x1; i < x2; i++)
        {
            if (i != 0)
            {
                this.dots.add(new int[]{i, calculateResult(i)});
            }
        }
    }

    private int calculateResult(int x)
    {
        assignX(x);

        int operationIndex = 0;
        int modifiedNumber = 0;
        int result = 0;

        while (operationsBuffer.size() > 0)
        {
            while(operationsBuffer.contains("SQRT:"))
            {
                operationIndex = operationsBuffer.indexOf("SQRT:");
                modifiedNumber = (int)Math.round(Math.sqrt(numbersBuffer.get(operationIndex)));

                this.numbersBuffer.remove(operationIndex);
                this.numbersBuffer.add(operationIndex, modifiedNumber);
                this.operationsBuffer.remove(operationIndex);
            }

            while(operationsBuffer.contains("^"))
            {
                operationIndex = operationsBuffer.indexOf("^");
                modifiedNumber = (int)Math.round(Math.pow(numbersBuffer.get(operationIndex), numbersBuffer.get(operationIndex + 1)));

                this.numbersBuffer.remove(operationIndex + 1);
                this.numbersBuffer.remove(operationIndex);
                this.numbersBuffer.add(operationIndex, modifiedNumber);
                this.operationsBuffer.remove(operationIndex);
            }

            while(operationsBuffer.contains("%"))
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

            while(operationsBuffer.contains("/"))
            {
                operationIndex = this.operationsBuffer.indexOf("/");
                modifiedNumber = this.numbersBuffer.get(operationIndex) / numbersBuffer.get(operationIndex + 1);

                this.numbersBuffer.remove(operationIndex + 1);
                this.numbersBuffer.remove(operationIndex);
                this.numbersBuffer.add(operationIndex, modifiedNumber);
                this.operationsBuffer.remove(operationIndex);
            }

            while(this.operationsBuffer.contains("+"))
            {
                operationIndex = this.operationsBuffer.indexOf("+");
                modifiedNumber = this.numbersBuffer.get(operationIndex) + numbersBuffer.get(operationIndex + 1);

                this.numbersBuffer.remove(operationIndex + 1);
                this.numbersBuffer.remove(operationIndex);
                this.numbersBuffer.add(operationIndex, modifiedNumber);
                this.operationsBuffer.remove(operationIndex);
            }

            while(this.operationsBuffer.contains("-"))
            {
                operationIndex = this.operationsBuffer.indexOf("-");
                modifiedNumber = this.numbersBuffer.get(operationIndex) - this.numbersBuffer.get(operationIndex + 1);

                this.numbersBuffer.remove(operationIndex + 1);
                this.numbersBuffer.remove(operationIndex);
                this.numbersBuffer.add(operationIndex, modifiedNumber);
                this.operationsBuffer.remove(operationIndex);
            }
        }

        if (this.numbersBuffer.size() > 0)
        {
            result = -this.numbersBuffer.get(0);
        }

        return result;
    }

    private void assignX(int x)
    {
        this.numbersBuffer = new ArrayList<>();
        this.operationsBuffer = new ArrayList<>(operationsBufferCopy);

        for(String var : this.varBuffer)
        {
            if (var.contains("x"))
            {
                this.numbersBuffer.add(x);
            }
            else
            {
                this.numbersBuffer.add(Integer.parseInt(var));
            }
        }
    }

    public void draw(Graphics g)
    {
        if(this.isVisible)
        {
            g.setColor(this.funcColor);
        }
        else
        {
            g.setColor(Const.FUNCTION_INVISIBLE_COLOR);
        }
        for (int i = 0; i < dots.size() - 1; i++)
        {
            try
            {
                g.drawLine(this.dots.get(i)[0] + this.drawingPanelWidth/2, dots.get(i)[1] + this.drawingPanelHeight/2,
                        this.dots.get(i + 1)[0] + this.drawingPanelWidth/2, dots.get(i + 1)[1] + this.drawingPanelHeight/2);
            }
            catch (IndexOutOfBoundsException e)
            {
            }
        }
    }

    //Setters
    public void setVisible(boolean isVisible)
    {
        this.isVisible = isVisible;
    }

    public void setFuncColor(Color funcColor)
    {
        this.funcColor = funcColor;
    }

    public void setDrawingPanelHeight(int drawingPanelHeight)
    {
        this.drawingPanelHeight = drawingPanelHeight;
    }

    public void setDrawingPanelWidth(int drawingPanelWidth)
    {
        this.drawingPanelWidth = drawingPanelWidth;
    }
}