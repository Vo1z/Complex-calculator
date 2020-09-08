package GUI.FirstTab;

import ConstsExceptionsEnums.ButtType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputButtonListener implements ActionListener
{
    private String toSend;
    private DynamicLabel placeToSend;
    private ButtType buttType;

    InputButtonListener(String toSend, DynamicLabel placeToSend, ButtType buttType)
    {
        this.toSend = toSend;
        this.placeToSend = placeToSend;
        this.buttType = buttType;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (this.buttType == ButtType.APPEND)
        {
            this.placeToSend.appendContent(toSend);
        }
        else if (this.buttType == ButtType.REPLACE_ALL)
        {
            this.placeToSend.replaceContent(toSend);
        }
        else if (this.buttType == ButtType.REPLACE_BACK)
        {
            this.placeToSend.replaceBack(toSend);
        }
    }
}