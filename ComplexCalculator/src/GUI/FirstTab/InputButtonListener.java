package GUI.FirstTab;

import ConstsExceptionsEnums.ButtType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputButtonListener implements ActionListener
{
    private String toSend;
    private DynamicLabel whereToSend;
    private ButtType buttType;

    InputButtonListener(String toSend, DynamicLabel whereToSend, ButtType buttType)
    {
        this.toSend = toSend;
        this.whereToSend = whereToSend;
        this.buttType = buttType;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (buttType == ButtType.APPEND)
        {
            whereToSend.appendContent(toSend);
        }
        else if (buttType == ButtType.REPLACE_ALL)
        {
            whereToSend.replaceContent(toSend);
        }
        else if (buttType == ButtType.REPLACE_BACK)
        {
            whereToSend.replaceBack(toSend);
        }
    }
}