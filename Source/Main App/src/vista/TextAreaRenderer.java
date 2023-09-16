
package vista;


import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;



public class TextAreaRenderer extends JEditorPane implements TableCellRenderer{
    public TextAreaRenderer() {
        //setLineWrap(true);
        //setWrapStyleWord(true);
        setToolTipText(this.getText());
        setContentType("text/html");
        Dimension d = new Dimension();
        d.setSize(250, 200);
        setMaximumSize(d);
        setPreferredSize(d);
        
    }

  public Component getTableCellRendererComponent(JTable jTable,
      Object obj, boolean isSelected, boolean hasFocus, int row,
      int column) {
        setText((String)obj);
    return this;
  }
}