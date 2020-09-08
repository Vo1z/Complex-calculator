package GUI.SecondTab;

import CalcMath.Function;
import ConstsExceptionsEnums.Const;

import javax.swing.*;
import java.awt.*;

public class FunctionControlLine extends JPanel
{
    private Function function;
    private String title;
    private SecondTabPanel tabPanel;
    private int index;

    private JCheckBox checkBox;
    private ColorComboBox colorComboBox;
    private JButton minusButton;

    FunctionControlLine(Function function, String title, SecondTabPanel tabPanel, int index) {
        this.function = function;
        this.title = title;
        this.tabPanel = tabPanel;
        this.index = index;
        this.colorComboBox = new ColorComboBox();
        this.checkBox = createCheckBox();
        this.minusButton = createMinusButton();

        //FunctionControlLine configuration
        this.setBackground(Const.BUTT_COLOR);
        this.setLayout(new GridLayout(1, 3, 0, 0));
        this.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR, Const.BUTT_BORDER_THICKNESS));
        this.setVisible(true);

        //Adding to panel
        this.add(this.checkBox);
        this.add(this.colorComboBox);
        this.add(this.minusButton);

        Thread checker = new Thread(
                () ->
                {
                    while (!Thread.currentThread().isInterrupted()) {
                        //Thread sleeps for 500 ms
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        function.setVisible(this.checkBox.isSelected());
                        function.setFuncColor(this.colorComboBox.getSelectedColor());
                    }
                }
        );
        checker.start();
    }

    private JCheckBox createCheckBox()
    {
        JCheckBox createdCheckBox = new JCheckBox(title);

        createdCheckBox.setSelected(true);
        this.function.setVisible(createdCheckBox.isSelected());

        return createdCheckBox;
    }

    private JButton createMinusButton()
    {
        JButton minusButton = new JButton("Delete");

        minusButton.setBackground(Const.BUTT_COLOR);
        minusButton.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR, Const.BUTT_BORDER_THICKNESS));

        minusButton.addActionListener((event)-> this.tabPanel.removeFunction(index));

        return minusButton;
    }
}
