/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.ScrollPaneLayout;

/**
 *
 * @author ajpap
 */
public class OrderGroup extends javax.swing.JPanel {
    OrderPanel[] op;
    JPanel contents;
    /**
     * Creates new form OrderGroup
     */
    public OrderGroup(int n) {
        initComponents();
        contents = new JPanel();
        contents.setLayout(new GridLayout(1,0));
        jScrollPane1.setLayout(new ScrollPaneLayout());
        op = new OrderPanel[n];
        for(int i = 0; i < n; i++)
        {
            op[i] = new OrderPanel();
            contents.add(op[i]);
            op[i].setOrderNum(i+1);
            op[i].setVisible(true);
        }
        jScrollPane1.getViewport().add(contents);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orderPanel2 = new forms.OrderPanel();
        jScrollPane1 = new javax.swing.JScrollPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void resize(int n)
    {
        op = null;
        op = new OrderPanel[n];
        contents.removeAll();
        for(int i = 0; i < n; i++)
        {
            op[i] = new OrderPanel();
            contents.add(op[i]);
            op[i].setOrderNum(i+1);
            op[i].setVisible(true);
        }        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private forms.OrderPanel orderPanel2;
    // End of variables declaration//GEN-END:variables
}
