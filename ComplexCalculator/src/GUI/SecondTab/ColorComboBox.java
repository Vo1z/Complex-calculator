package GUI.SecondTab;

import ConstsExceptionsEnums.Const;

import javax.swing.*;
import java.awt.*;

public class ColorComboBox extends JComboBox<String>
{
    String[] colors;

    ColorComboBox()
    {
        this.colors = new String[] {"Red", "Green", "Blue", "Yellow", "Cyan", "Magenta", "Orange"};

        this.setBackground(Const.BUTT_COLOR);
        this.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR, Const.BUTT_BORDER_THICKNESS));

        setColors();


    }

    private void setColors()
    {
        for (String color : this.colors)
        {
            this.addItem(color);
        }
    }

    public Color getSelectedColor()
    {
        switch(this.getSelectedItem().toString())
        {
            case "Red":
                return Color.red;
            case "Green":
                return Color.green;
            case "Blue":
                return Color.blue;
            case "Yellow":
                return Color.yellow;
            case "Cyan":
                return Color.cyan;
            case "Magenta":
                return Color.magenta;
            default:
                return Color.orange;
        }
    }
}
