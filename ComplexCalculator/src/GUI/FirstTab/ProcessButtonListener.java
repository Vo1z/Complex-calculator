package GUI.FirstTab;

import CalcMath.Interpreter;
import CalcMath.Polynomial;
import CalcMath.SystemType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessButtonListener implements ActionListener
{
    private DynamicLabel activeArea, memoryArea;
    private Polynomial poly;
    private String result;
    private String selectedType;

    ProcessButtonListener(DynamicLabel activeArea, DynamicLabel memoryArea, String selectedType)
    {
        this.activeArea = activeArea;
        this.memoryArea = memoryArea;
        this.selectedType = selectedType;
        this.poly = null;
        this.result = "";

    }

    private void processEquation()
    {
        SystemType systemType = SystemType.DECIMAL;

        switch(selectedType)
        {
            case "Decimal":
                systemType = SystemType.DECIMAL;
                break;
            case "Hexadecimal":
                systemType = SystemType.HEXADECIMAL;
                break;
            case "Octal":
                systemType = SystemType.OCTAL;
                break;
            default:
                systemType = SystemType.BINARY;
                break;
        }

        try
        {
            poly = Interpreter.createPolynomial(activeArea.getContent(), systemType);
            result += poly.getResult();
        }
        catch (Exception ex)
        {
            result = "Error";
        }
    }

    public void setSelectedType(String selectedType)
    {
        this.selectedType = selectedType;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        processEquation();
        memoryArea.replaceContent(activeArea.getContent() + " = " + result + " \n");
        activeArea.replaceContent("");

        result = "";
    }
}
