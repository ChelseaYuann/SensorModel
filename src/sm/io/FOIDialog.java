package sm.io;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class FOIDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tf_foiName;
	private JTextField tf_foiLink;

	/**
	 * Create the dialog.
	 */
	public FOIDialog() {
		setTitle("添加感兴趣特征");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lb_foiName = new JLabel("特征名称：");
			GridBagConstraints gbc_lb_foiName = new GridBagConstraints();
			gbc_lb_foiName.anchor = GridBagConstraints.EAST;
			gbc_lb_foiName.insets = new Insets(0, 10, 5, 5);
			gbc_lb_foiName.gridx = 0;
			gbc_lb_foiName.gridy = 1;
			contentPanel.add(lb_foiName, gbc_lb_foiName);
		}
		{
			tf_foiName = new JTextField();
			GridBagConstraints gbc_tf_foiName = new GridBagConstraints();
			gbc_tf_foiName.anchor = GridBagConstraints.NORTH;
			gbc_tf_foiName.insets = new Insets(0, 0, 5, 10);
			gbc_tf_foiName.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_foiName.gridx = 1;
			gbc_tf_foiName.gridy = 1;
			contentPanel.add(tf_foiName, gbc_tf_foiName);
			tf_foiName.setColumns(10);
		}
		{
			JLabel lb_foiLink = new JLabel("参考链接：");
			GridBagConstraints gbc_lb_foiLink = new GridBagConstraints();
			gbc_lb_foiLink.anchor = GridBagConstraints.EAST;
			gbc_lb_foiLink.insets = new Insets(0, 10, 5, 5);
			gbc_lb_foiLink.gridx = 0;
			gbc_lb_foiLink.gridy = 2;
			contentPanel.add(lb_foiLink, gbc_lb_foiLink);
		}
		{
			tf_foiLink = new JTextField();
			tf_foiLink.setColumns(10);
			GridBagConstraints gbc_tf_foiLink = new GridBagConstraints();
			gbc_tf_foiLink.insets = new Insets(0, 0, 5, 10);
			gbc_tf_foiLink.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_foiLink.gridx = 1;
			gbc_tf_foiLink.gridy = 2;
			contentPanel.add(tf_foiLink, gbc_tf_foiLink);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("确定");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String[] info= {tf_foiName.getText(),tf_foiLink.getText()};
//						model_output.addRow(info);
						tf_foiName.setText("");
						tf_foiLink.setText("");
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("退出");
				buttonPane.add(cancelButton);
			}
		}
	}
}
