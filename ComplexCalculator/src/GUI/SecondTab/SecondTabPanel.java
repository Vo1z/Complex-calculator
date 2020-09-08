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
        this.memPanelRows = 0;
        this.funcIndex = 0;
        this.functions = new ArrayList<>();
        this.drawingPanel = new DrawingPanel(this.functions);
        this.memorySection = createMemorySection();
        this.plusButton = createPlusButton();

        //Panel Properties
        this.setLayout(new GridLayout(Const.P2_LAYOUT_ROWS, Const.P2_LAYOUT_COLS,
                                      Const.P2_LAYOUT_HSPACE, Const.P2_LAYOUT_VSPACE));

        //Adding elements
        this.add(this.drawingPanel);
        this.add(this.memorySection);
        this.add(this.plusButton);

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

                        this.drawingPanel.updateFunctions(this.functions);
                        for(Function func : this.functions)
                        {
                            func.setDrawingPanelWidth(this.drawingPanel.getWidth());
                            func.setDrawingPanelHeight(this.drawingPanel.getHeight());
                        }
                    }
                }
                );
        reassigner.start();
    }

    public void removeFunction(int index)
    {
        this.memorySection.remove(index);
        this.functions.remove(index);

        this.funcIndex--;

        //Refreshes memory panel
        this.memorySection.setVisible(false);
        this.memorySection.setVisible(true);

        //Refreshes drawing panel
        this.drawingPanel.setVisible(false);
        this.drawingPanel.setVisible(true);
    }

    //Customize MemorySection here
    private JPanel createMemorySection()
    {
        JPanel memorySection = new JPanel();

        //MemorySection properties
        memorySection.setLayout(new GridLayout(this.memPanelRows, Const.P2_MEMPANEL_COLS,
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
                                                              -500, this.drawingPanel.getWidth() + 500);
        this.functions.add(createdFunction);
        this.drawingPanel.updateFunctions(this.functions);

        this.memorySection.add(new FunctionControlLine(createdFunction, equation, this, this.funcIndex), this.funcIndex);
        this.funcIndex++;

        //Refreshes memory panel
        this.memorySection.setVisible(false);
        this.memorySection.setVisible(true);

        //Refreshes drawing panel
        this.drawingPanel.setVisible(false);
        this.drawingPanel.setVisible(true);
    }
}