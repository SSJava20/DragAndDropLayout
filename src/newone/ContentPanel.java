/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newone;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Жека
 */
public class ContentPanel extends JPanel {

    JPanel exception;
    Component current = null;
    MouseAdapter drag, pres;
    Component[] com;

    public ContentPanel() {
        this.setSize(560, 200);
        this.setOpaque(false);
        this.setLayout(null);
        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0),
                BorderFactory.createLineBorder(Color.RED)));
        pres = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (find(e.getPoint()) != null) {
                    current = find(e.getPoint());
                } else {
                    current = null;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getX() >= exception.getLocation().getX() && e.getY() >= exception.getLocation().getY()
                        && current != null) {
                    insertPanel(current, e);
                }
                current = null;
            }
        };
        drag = new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                if (current != null) {
                    if (find(e.getPoint()) != null) {
                        current.setLocation(e.getX() - current.getWidth() / 2, e.getY() - current.getHeight() / 2);
                    }
                }

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (MouseEvent.MOUSE_MOVED != 0) {
                    if (find(e.getPoint()) == null) {
                        ContentPanel.this.setCursor(Cursor.getDefaultCursor());
                    } else {
                        ContentPanel.this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    }
                }
            }
        };
        this.addMouseMotionListener(drag);
        this.addMouseListener(pres);
    }

    public void setExceptionComponent(Component c) {
        exception = (JPanel) c;
    }

    private void insertPanel(Component c,MouseEvent e) {
        ContentPanel.this.remove(current);
        Component comp = current;
        comp.setSize(new Dimension(current.getSize().width, current.getSize().height));
        comp.setPreferredSize(new Dimension(current.getSize().width, current.getSize().height));
        exception.add(comp);
        exception.getParent().revalidate();
        exception.getParent().repaint();
        exception.revalidate();
        exception.repaint();
    }

    private Component find(Point point) {
        com = this.getComponents();
        for (Component j : com) {
            if (!j.equals(exception)) {
                JPanel c = (JPanel) j;
                int compX = (int) c.getLocation().getX();
                int compY = (int) c.getLocation().getY();
                int endX = compX + c.getWidth();
                int endY = compY + c.getHeight();
                if (((compX <= (int) point.getX()) && (compY <= (int) point.getY()))
                        && ((endX >= (int) point.getX()) && (endY >= (int) point.getY()))) {
                    return c;
                }
            }
        }
        return null;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
