package GUI.SecondTab;

import CalcMath.Function;
import CalcMath.Interpreter;
import ConstsExceptionsEnums.Const;
import ConstsExceptionsEnums.IncorrectSpellException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SecondTabPanel extends JPanel
{
    private DrawingPanel drawingPanel;
    private JPanel memorySection;
    private JButton plusButton;
    private int memPanelRows;

    private int funcIndex;
    private ArrayList<Function> functions;


    public SecondTabPanel()
    {
        //Assign
        memPanelRows = 0;
        funcIndex = 0;
        functions = new ArrayList<>();
        drawingPanel = new DrawingPanel(functions);
        memorySection = createMemorySection();
        plusButton = createPlusButton();

        //Panel Properties
        this.setLayout(new GridLayout(Const.P2_LAYOUT_ROWS, Const.P2_LAYOUT_COLS,
                                      Const.P2_LAYOUT_HSPACE, Const.P2_LAYOUT_VSPACE));

        //Adding elements
        this.add(drawingPanel);
        this.add(memorySection);
        this.add(plusButton);

        //Reassigner
        Thread reassigner = new Thread(
                ()->
                {
                    while(!Thread.currentThread().isInterrupted())
                    {
                        //Sleeps for 500 ms
                        try
                        {
                            Thread.sleep(500);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }

                        drawingPanel.updateFunctions(functions);
                        for(Function func : functions)
                        {
                            func.setDrawingPanelWidth(drawingPanel.getWidth());
                            func.setDrawingPanelHeight(drawingPanel.getHeight());
                        }
                    }
                }
                );
        reassigner.start();
    }

    public void removeFunction(int index)
    {
        memorySection.remove(index);
        functions.remove(index);

        funcIndex--;

        //Refreshes memory panel
        memorySection.setVisible(false);
        memorySection.setVisible(true);

        //Refreshes drawing panel
        drawingPanel.setVisible(false);
        drawingPanel.setVisible(true);
    }

    //Customize MemorySection here
    private JPanel createMemorySection()
    {
        JPanel memorySection = new JPanel();

        //MemorySection properties
        memorySection.setLayout(new GridLayout(memPanelRows, Const.P2_MEMPANEL_COLS,
                                     Const.P2_MEMPANEL_HGAP, Const.P2_MEMPANEL_VGAP));
        memorySection.setBackground(Const.BUTT_COLOR);
        memorySection.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR, Const.BUTT_BORDER_THICKNESS));

        return memorySection;
    }

    private JButton createPlusButton()
    {
        JButton plusButton = new JButton("Add");

        plusButton.setBackground(Const.BUTT_COLOR);
        plusButton.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR, Const.BUTT_BORDER_THICKNESS));

        plusButton.addActionListener(
                e ->
                {
                    try
                    {
                        addFunction(JOptionPane.showInputDialog("Enter your function"));
                    }
                    catch (Exception incorrectSpellException)
                    {
                        JOptionPane.showInternalMessageDialog(null, "Bad input");
                    }
                }
        );

        return plusButton;
    }

    private void addFunction(String equation) throws IncorrectSpellException
    {
        Function createdFunction = Interpreter.createFunction(equation, Color.black,
                                                              -500, drawingPanel.getWidth() + 500);
        functions.add(createdFunction);
        drawingPanel.updateFunctions(functions);

        memorySection.add(new FunctionControlLine(createdFunction, equation, this, funcIndex), funcIndex);
        funcIndex++;

        //Refreshes memory panel
        memorySection.setVisible(false);
        memorySection.setVisible(true);

        //Refreshes drawing panel
        drawingPanel.setVisible(false);
        drawingPanel.setVisible(true);
    }
}