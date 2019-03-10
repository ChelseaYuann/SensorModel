package sm.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


class TipsFrame extends JDialog{
	private final JPanel contentPanel = new JPanel();
	private JLabel lb;
	
	public TipsFrame(String string) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TipsFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/image-delayed.png")));
		setTitle("提示");
		setBounds(100, 100, 400, 200);
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			JLabel lb_icon = new JLabel("");
			lb_icon.setHorizontalAlignment(SwingConstants.CENTER);
			lb_icon.setIcon(new ImageIcon(TipsFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/warning.png")));
			contentPanel.add(lb_icon);
		}
		{
			JLabel lb_tip = new JLabel(string);
			lb_tip.setBackground(Color.WHITE);
			lb_tip.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lb_tip);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("\u786E\u5B9A");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		pack();
	}
}