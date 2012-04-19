/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newone;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author Jeka
 */
public class LayoutPanel extends JPanel {

    public LayoutPanel() {
        this.setOpaque(false);
        this.setLayout(null);
    }

    public void setLayoutManager(LayoutManager mng) {
        this.setLayout(mng);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.getLayout() != null) {
            g.drawString(this.getLayout().getClass().getName(),this.getWidth()/2-100,this.getHeight()/2);
        } else {
            g.drawString("Null Layout", 10, 10);
        }
    }
}
