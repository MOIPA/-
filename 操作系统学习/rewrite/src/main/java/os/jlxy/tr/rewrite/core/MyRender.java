package os.jlxy.tr.rewrite.core;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class MyRender implements TableCellRenderer{

	public static final DefaultTableCellRenderer DEFAULT_RENDERER =
			new DefaultTableCellRenderer();

	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		Component renderer =
				DEFAULT_RENDERER.getTableCellRendererComponent(table, value,
				isSelected, hasFocus, row, column);
				Color foreground, background;
			
			if(value.equals("running"))renderer.setBackground(Color.green);
			else renderer.setBackground(Color.white);
				
		return null;
	}
	
}
