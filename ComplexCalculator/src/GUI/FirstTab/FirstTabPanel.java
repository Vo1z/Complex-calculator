package GUI.FirstTab;

import ConstsExceptionsEnums.Const;
import ConstsExceptionsEnums.ButtType;

import javax.swing.*;
import java.awt.*;

public class FirstTabPanel extends JPanel
{
    private DynamicLabel memoryArea;
    private DynamicLabel activeArea;

    private JPanel ioPanel;
    private JPanel topButtonPanel;
    private JPanel botButtonPanel;
    ProcessButtonListener procButtListen;

    public FirstTabPanel()
    {
        //Assign
        this.memoryArea = new DynamicLabel("");
        this.activeArea = new DynamicLabel("");
        this.procButtListen = new ProcessButtonListener(activeArea, memoryArea, "Decimal");
        this.ioPanel = createIOPanel();
        this.topButtonPanel = createTopButtonPanel();
        this.botButtonPanel = createBotButtonPanel();

        //Panel Properties
        setLayout(new GridLayout(Const.P1_LAYOUT_ROWS, Const.P1_LAYOUT_COLS,
                                 Const.P1_LAYOUT_HSPACE, Const.P1_LAYOUT_VSPACE));

        //Adding elements
        this.add(this.ioPanel);
        this.add(this.topButtonPanel);
        this.add(this.botButtonPanel);
    }

    //Top panel
    private JPanel createIOPanel()
    {
        JPanel ioPanel = new JPanel();

        ioPanel.setLayout(new GridLayout(3, 1));

        //Customize IO
        this.activeArea.setFont(Const.ACTIVE_AREA_FONT);
        this.activeArea.setBackground(Const.FUNCTION_INVISIBLE_COLOR);
        this.memoryArea.setFont(Const.MEMORY_AREA_FONT);
        this.memoryArea.setBackground(Const.FUNCTION_INVISIBLE_COLOR);

        ioPanel.add(this.memoryArea);
        ioPanel.add(this.activeArea);
        ioPanel.add(createComboBox());

        return ioPanel;
    }

    //Middle panel
    private JPanel createTopButtonPanel()
    {
        JPanel buttonsPanel = new JPanel();
        JButton button;

        buttonsPanel.setLayout(new GridLayout(Const.P1_TOP_LAYOUT_ROWS, Const.P1_TOP_LAYOUT_ROWS));

        //1-9 buttons
        for (int i = 1; i < 10; i++)
        {
            //Customize buttons here
            button = new JButton("" + i);
            button.setBackground(Const.BUTT_COLOR);
            button.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                            Const.BUTT_BORDER_THICKNESS));
            button.addActionListener(new InputButtonListener(i + "", this.activeArea, ButtType.APPEND));

            buttonsPanel.add(button);
        }

        //'0' button
        button = new JButton("0");
        button.setBackground(Const.BUTT_COLOR);
        button.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                     Const.BUTT_BORDER_THICKNESS));
        button.addActionListener(new InputButtonListener("0", this.activeArea, ButtType.APPEND));
        buttonsPanel.add(button);

        //A button
        button = new JButton("A");
        button.setBackground(Const.BUTT_COLOR);
        button.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                        Const.BUTT_BORDER_THICKNESS));
        button.addActionListener(new InputButtonListener("A", this.activeArea, ButtType.APPEND));
        buttonsPanel.add(button);

        //B button
        button = new JButton("B");
        button.setBackground(Const.BUTT_COLOR);
        button.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                        Const.BUTT_BORDER_THICKNESS));
        button.addActionListener(new InputButtonListener("B", this.activeArea, ButtType.APPEND));
        buttonsPanel.add(button);

        //C button
        button = new JButton("C");
        button.setBackground(Const.BUTT_COLOR);
        button.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                        Const.BUTT_BORDER_THICKNESS));
        button.addActionListener(new InputButtonListener("C", this.activeArea, ButtType.APPEND));
        buttonsPanel.add(button);

        //D button
        button = new JButton("D");
        button.setBackground(Const.BUTT_COLOR);
        button.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                        Const.BUTT_BORDER_THICKNESS));
        button.addActionListener(new InputButtonListener("D", this.activeArea, ButtType.APPEND));
        buttonsPanel.add(button);

        //E button
        button = new JButton("E");
        button.setBackground(Const.BUTT_COLOR);
        button.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                        Const.BUTT_BORDER_THICKNESS));
        button.addActionListener(new InputButtonListener("E", this.activeArea, ButtType.APPEND));
        buttonsPanel.add(button);

        //F button
        button = new JButton("F");
        button.setBackground(Const.BUTT_COLOR);
        button.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                        Const.BUTT_BORDER_THICKNESS));
        button.addActionListener(new InputButtonListener("F", this.activeArea, ButtType.APPEND));
        buttonsPanel.add(button);

        //Dot button
        button = new JButton(".");
        button.setBackground(Const.BUTT_COLOR);
        button.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                        Const.BUTT_BORDER_THICKNESS));
        button.addActionListener(new InputButtonListener(".", this.activeArea, ButtType.APPEND));
        buttonsPanel.add(button);

        //Power button
        button = new JButton("^");
        button.addActionListener(new InputButtonListener("^", this.activeArea, ButtType.APPEND));
        button.setBackground(Const.BUTT_COLOR);
        button.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                             Const.BUTT_BORDER_THICKNESS));
        buttonsPanel.add(button);

        return buttonsPanel;
    }

    //Lower panel
    private JPanel createBotButtonPanel()
    {
        JPanel operationsPanel = new JPanel();

        operationsPanel.setLayout(new GridLayout(Const.P1_BUTT_LAYOUT_ROWS, Const.P1_BUTT_LAYOUT_COLS));

        //Customize buttons here
        JButton plusSymbol = new JButton("+");
        plusSymbol.addActionListener(new InputButtonListener(" + ", this.activeArea, ButtType.APPEND));
        plusSymbol.setBackground(Const.BUTT_COLOR);
        plusSymbol.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                            Const.BUTT_BORDER_THICKNESS));
        operationsPanel.add(plusSymbol);

        JButton minusSymbol = new JButton("-");
        minusSymbol.addActionListener(new InputButtonListener(" - ", this.activeArea, ButtType.APPEND));
        minusSymbol.setBackground(Const.BUTT_COLOR);
        minusSymbol.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                             Const.BUTT_BORDER_THICKNESS));
        operationsPanel.add(minusSymbol);

        JButton multiplySymbol = new JButton("*");
        multiplySymbol.addActionListener(new InputButtonListener(" * ", this.activeArea, ButtType.APPEND));
        multiplySymbol.setBackground(Const.BUTT_COLOR);
        multiplySymbol.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                                Const.BUTT_BORDER_THICKNESS));
        operationsPanel.add(multiplySymbol);

        JButton divisionSymbol = new JButton("/");
        divisionSymbol.addActionListener(new InputButtonListener(" / ", this.activeArea, ButtType.APPEND));
        divisionSymbol.setBackground(Const.BUTT_COLOR);
        divisionSymbol.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                                Const.BUTT_BORDER_THICKNESS));
        operationsPanel.add(divisionSymbol);

        JButton percentageSymbol = new JButton("%");
        percentageSymbol.addActionListener(new InputButtonListener("%", this.activeArea, ButtType.APPEND));
        percentageSymbol.setBackground(Const.BUTT_COLOR);
        percentageSymbol.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                                  Const.BUTT_BORDER_THICKNESS));
        operationsPanel.add(percentageSymbol);

        JButton sqrtSymbol = new JButton("sqrt");
        sqrtSymbol.addActionListener(new InputButtonListener("SQRT:", this.activeArea, ButtType.APPEND));
        sqrtSymbol.setBackground(Const.BUTT_COLOR);
        sqrtSymbol.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                            Const.BUTT_BORDER_THICKNESS));
        operationsPanel.add(sqrtSymbol);

        JButton equalSymbol = new JButton("=");
        equalSymbol.setBackground(Const.BUTT_EQUAL_COLOR);
        equalSymbol.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                        Const.BUTT_BORDER_THICKNESS));

        equalSymbol.addActionListener(this.procButtListen);
        operationsPanel.add(equalSymbol);


        JButton clearSymbol = new JButton("C");
        clearSymbol.setBackground(Const.BUTT_C_COLOR);
        clearSymbol.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                             Const.BUTT_BORDER_THICKNESS));
        clearSymbol.addActionListener(new InputButtonListener("", this.activeArea, ButtType.REPLACE_ALL));
        operationsPanel.add(clearSymbol);

        JButton backSymbol = new JButton("BackSpace");
        backSymbol.setBackground(Const.BUTT_C_COLOR);
        backSymbol.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,
                                                            Const.BUTT_BORDER_THICKNESS));
        backSymbol.addActionListener(new InputButtonListener("", this.activeArea, ButtType.REPLACE_BACK));
        operationsPanel.add(backSymbol);

        return operationsPanel;
    }

    //Combo box (representation selection)
    private JComboBox<String> createComboBox()
    {
        String[] representationNames = {"Decimal", "Hexadecimal", "Octal", "Binary"};
        JComboBox<String> systemsCB = new JComboBox<>(representationNames);

        //Customize combo box here
        systemsCB.setBackground(Const.BUTT_COLOR);
        systemsCB.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR, Const.BUTT_BORDER_THICKNESS));
        systemsCB.setFont(Const.CB_FONT);

        Thread typeAssigner = new Thread(
                ()->
                {
                    while (!Thread.currentThread().isInterrupted())
                    {
                        try
                        {
                            Thread.sleep(2000);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }

                        this.procButtListen.setSelectedType(systemsCB.getSelectedItem().toString().trim());
                    }
                }
                );
        typeAssigner.start();

        return systemsCB;
    }
}
