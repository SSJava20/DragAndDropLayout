/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newone.layouts;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Jeka
 */
public class CircleLayout implements LayoutManager {

    ArrayList components;
    ArrayList names;
    private boolean isCircle;

    /**
     * Creates a new CircleLayout that lays out components in a perfect circle
     */
    public CircleLayout() {
        this(true);
    }

    /**
     * Creates a new CircleLayout that lays out components in either an Ellipse
     * or a Circle. Ellipse Layout is not yet implemented.
     *
     * @param circle Indicated the shape to use. It's true for circle or false
     * for ellipse.
     */
    public CircleLayout(boolean circle) {
        isCircle = circle;
    }

    /**
     * For compatibility with LayoutManager interface
     */
    public void addLayoutComponent(String name, Component comp) {
    }

    /**
     * Arranges the parent's Component objects in either an Ellipse or a Circle.
     * Ellipse is not yet implemented.
     */
    public void layoutContainer(Container parent) {
        int x, y, w, h, s, c;
        int n = parent.getComponentCount();
        double parentWidth = parent.getSize().width;
        double parentHeight = parent.getSize().height;
        Insets insets = parent.getInsets();
        int centerX = (int) (parentWidth - (insets.left + insets.right)) / 2;
        int centerY = (int) (parentHeight - (insets.top + insets.bottom)) / 2;

        Component comp = null;
        Dimension compPS = null;
        if (n == 1) {
            comp = parent.getComponent(0);
            x = centerX;
            y = centerY;
            compPS = comp.getPreferredSize();
            w = compPS.width;
            h = compPS.height;
            comp.setBounds(x, y, w, h);
        } else {
            double r = (Math.min(parentWidth - (insets.left + insets.right), parentHeight
                    - (insets.top + insets.bottom))) / 2;
            r *= 0.75; // Multiply by .75 to account for extreme right and bottom
            // Components
            for (int i = 0; i < n; i++) {
                comp = parent.getComponent(i);
                compPS = comp.getPreferredSize();
                if (isCircle) {
                    c = (int) (r * Math.cos(2 * i * Math.PI / n));
                    s = (int) (r * Math.sin(2 * i * Math.PI / n));
                } else {
                    c = (int) ((centerX * 0.75) * Math.cos(2 * i * Math.PI / n));
                    s = (int) ((centerY * 0.75) * Math.sin(2 * i * Math.PI / n));
                }
                x = c + centerX;
                y = s + centerY;

                w = compPS.width;
                h = compPS.height;

                comp.setBounds(x, y, w, h);
            }
        }

    }

    @Override
    public void removeLayoutComponent(Component comp) {
    }

    @Override
    public Dimension preferredLayoutSize(Container target) {
        return target.getSize();
    }

    @Override
    public Dimension minimumLayoutSize(Container target) {
        return target.getSize();
    }
}
