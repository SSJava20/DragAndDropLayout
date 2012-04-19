/**
 *
 */
package newone;

import newone.layouts.MyVerticalLayout;
import newone.layouts.MyDiagonalLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import newone.layouts.*;

/**
 * @author GAL version 17.04.2012
 */
public class LayoutFactory {

    private LayoutFactory() {
    }

    public static LayoutManager getLayout(String str) {
        if (str.equals("Circle Layout")) {
            return new CircleLayout();
        }
        if (str.equals("Diagonal Layout")) {
            return new MyDiagonalLayout();
        }
        if (str.equals("Vertical Layout")) {
            return new MyVerticalLayout();
        }
         if (str.equals("Flow Layout")) {
            return new FlowLayout();
        }
        return null;
    }
}
