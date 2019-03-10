package sm.readExcel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.formula.ptg.TblPtg;

public class Excel2XmlFrame extends JFrame {

	private String path = "src/instance/instance_Excel2xml.xml";
	private JPanel contentPane;
	private static JTextField tf_theme;
	private JTextField tf_keyword;
	private static JTable tb_keywords;
	private static DefaultTableModel model_keywords;
	private JTextField tf_file;
	private JFileChooser jfc;
	private File file;
	private String fileName = "";
	private JTextArea ta_view;
	private boolean createIsClicked = false;
	private static ArrayList<Object[][]> info = new ArrayList<>();
	private int addKeyFlag = 0;
	
	/**
	 *get方法
	 */
	public static String getTheme() {
		return tf_theme.getText(); 
	}
	
	public static int getKeywordsNum() {
		return tb_keywords.getRowCount();
	}
	
	public static String[] getKeyword(int i) {
		String[] info = {tb_keywords.getValueAt(i, 0).toString(),tb_keywords.getValueAt(i, 1).toString()};
		return info;
	}
	
	public static ArrayList<Object[][]> getKeywordContent() {
		return info;
	}

	
	/**
	 * Create the frame.
	 */
	public Excel2XmlFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Excel2XmlFrame.class.getResource("/sm/images/utils.png")));
		setTitle("基于Excel表格建模");
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton bt_create = new JButton("生成");
		bt_create.setIcon(new ImageIcon(Excel2XmlFrame.class.getResource("/sm/images/view2.jpg")));
		bt_create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (addKeyFlag>0) {
					createIsClicked = true;
					Excel2XML.DomCreate();
				}else {
					tipsDialog tip = new tipsDialog("请先填入完整信息!");
					tip.setLocationRelativeTo(contentPane);
					tip.setAlwaysOnTop(true);
					tip.setVisible(true);
				}
			}
		});
		toolBar.add(bt_create);
		
		JButton bt_clear = new JButton("清空");
		bt_clear.setIcon(new ImageIcon(Excel2XmlFrame.class.getResource("/sm/images/clear.jpg")));
		bt_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_file.setText("");
				tf_keyword.setText("");
				tf_theme.setText("");
				model_keywords.setRowCount(0);
				ta_view.setText("");			
			}
		});
		toolBar.add(bt_clear);
		
		JButton bt_save = new JButton("保存");
		bt_save.setIcon(new ImageIcon(Excel2XmlFrame.class.getResource("/sm/images/save.jpg")));
		bt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (createIsClicked==true) {
					Excel2XML.SaveXml();
					xmlViewer();
				}else {
					tipsDialog tip = new tipsDialog("请先点击生成完成建模！");
					tip.setLocationRelativeTo(contentPane);
					tip.setAlwaysOnTop(true);
					tip.setVisible(true);
				}
			}
		});
		toolBar.add(bt_save);
		
		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_mainPanel.rowHeights = new int[]{0, 0, 0, 0, 39, 0, 0, 0, 0, 0};
		gbl_mainPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		mainPanel.setLayout(gbl_mainPanel);
		
		JLabel lb_theme = new JLabel("主题");
		GridBagConstraints gbc_lb_theme = new GridBagConstraints();
		gbc_lb_theme.insets = new Insets(10, 20, 5, 5);
		gbc_lb_theme.gridx = 0;
		gbc_lb_theme.gridy = 0;
		mainPanel.add(lb_theme, gbc_lb_theme);
		
		tf_theme = new JTextField();
		GridBagConstraints gbc_tf_theme = new GridBagConstraints();
		gbc_tf_theme.gridwidth = 2;
		gbc_tf_theme.insets = new Insets(10, 0, 5, 5);
		gbc_tf_theme.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_theme.gridx = 1;
		gbc_tf_theme.gridy = 0;
		mainPanel.add(tf_theme, gbc_tf_theme);
		tf_theme.setColumns(10);
		
		JLabel lb_keyword = new JLabel("关键词");
		GridBagConstraints gbc_lb_keyword = new GridBagConstraints();
		gbc_lb_keyword.anchor = GridBagConstraints.EAST;
		gbc_lb_keyword.insets = new Insets(0, 20, 5, 5);
		gbc_lb_keyword.gridx = 0;
		gbc_lb_keyword.gridy = 1;
		mainPanel.add(lb_keyword, gbc_lb_keyword);
		
		tf_keyword = new JTextField();
		tf_keyword.setColumns(10);
		GridBagConstraints gbc_tf_keyword = new GridBagConstraints();
		gbc_tf_keyword.gridwidth = 2;
		gbc_tf_keyword.insets = new Insets(0, 0, 5, 5);
		gbc_tf_keyword.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_keyword.gridx = 1;
		gbc_tf_keyword.gridy = 1;
		mainPanel.add(tf_keyword, gbc_tf_keyword);
		model_keywords = new DefaultTableModel(new Object[][] {},new String[] {"关键词", "Excel表格"});
		
		JButton bt_addKeyword = new JButton("+");
		bt_addKeyword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf_file.getText().equals("")||tf_keyword.getText().equals("")) {
					tipsDialog tip = new tipsDialog("请输入关键词和打开文件的完整信息！");
					tip.setAlwaysOnTop(true);
					tip.setLocationRelativeTo(contentPane);
					tip.setVisible(true);
				}else {
					addKeyFlag++;
					String[] info = {tf_keyword.getText(),tf_file.getText()};
					model_keywords.addRow(info);
					tf_file.setText("");
					tf_keyword.setText("");
				}	
			}
		});
		
		JButton bt_openFile = new JButton("打开文件");
		bt_openFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfc = new JFileChooser();
				jfc.setAcceptAllFileFilterUsed(false);
				String formatDescription = "Excel 文件(*.xl,*.xls,*.xlsx,*.xlsm,*.xlsb,*.xlam,*.xltx,*.xltm,*.xla,*.xlt,*.xlm,*.xlw)";
				//显示所有格式文件
				jfc.addChoosableFileFilter(new FileFilter() {
					public String getDescription() {
						return "所有文件（*.*）";
					}
					public boolean accept(File f) {			
						return true;
					}
				});
				//添加需要显示的excel模型文件
				jfc.setFileFilter(new FileFilter(){
					public boolean accept(File file) {
						if(file.getName().endsWith(".xl")||file.getName().endsWith(".xls")||file.getName().endsWith(".xlsx")
								||file.getName().endsWith(".xlsm")||file.getName().endsWith(".xlsb")||file.getName().endsWith(".xlam")||
								file.getName().endsWith(".xltx")||file.getName().endsWith(".xltm")||file.getName().endsWith(".xla")||
								file.getName().endsWith(".xlt")||file.getName().endsWith(".xlm")||file.getName().endsWith(".xlw")||file.isDirectory()) 
							return true;
						return false;
					}
					public String getDescription() {
						return formatDescription;
					}
				});
				jfc.showOpenDialog(null);
				file = jfc.getSelectedFile();
				fileName = file.getAbsolutePath();	
				tf_file.setText(fileName);
				try {
					ReadExcelUtils readExcelUtils = new ReadExcelUtils(fileName);
					Object[][] c = ReadExcelUtils.getExcelContent();
					//检验文件读入
//					for (int i = 0; i < c.length; i++) {
//						for (int j = 0; j < c[0].length; j++) {
//							System.out.println("<"+c[i][j]+">");
//						}
//					}
					info.add(c);
				}catch (Exception e1) {
					e1.printStackTrace();
				}		
			}
		});
		GridBagConstraints gbc_bt_openFile = new GridBagConstraints();
		gbc_bt_openFile.insets = new Insets(0, 0, 5, 5);
		gbc_bt_openFile.gridx = 1;
		gbc_bt_openFile.gridy = 2;
		mainPanel.add(bt_openFile, gbc_bt_openFile);
		
		tf_file = new JTextField();
		tf_file.setColumns(10);
		GridBagConstraints gbc_tf_file = new GridBagConstraints();
		gbc_tf_file.insets = new Insets(0, 0, 5, 5);
		gbc_tf_file.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_file.gridx = 2;
		gbc_tf_file.gridy = 2;
		mainPanel.add(tf_file, gbc_tf_file);
		bt_addKeyword.setFont(new Font("宋体", Font.BOLD, 18));
		GridBagConstraints gbc_bt_addKeyword = new GridBagConstraints();
		gbc_bt_addKeyword.anchor = GridBagConstraints.EAST;
		gbc_bt_addKeyword.insets = new Insets(0, 0, 5, 10);
		gbc_bt_addKeyword.gridx = 3;
		gbc_bt_addKeyword.gridy = 2;
		mainPanel.add(bt_addKeyword, gbc_bt_addKeyword);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 10);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		mainPanel.add(scrollPane, gbc_scrollPane);
		
		tb_keywords = new JTable();
		tb_keywords.setBackground(new Color(175, 238, 238));
		tb_keywords.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(tb_keywords);
		tb_keywords.setModel(model_keywords);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 4;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 4;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 5;
		mainPanel.add(scrollPane_1, gbc_scrollPane_1);
		
		ta_view = new JTextArea();
		ta_view.setBackground(SystemColor.info);
		scrollPane_1.setViewportView(ta_view);
	}
	
	class tipsDialog extends JDialog{
		private final JPanel contentPanel = new JPanel();
		private JLabel lb;
		
		public tipsDialog(String string) {
			setIconImage(Toolkit.getDefaultToolkit().getImage(tipsDialog.class.getResource("/com/sun/java/swing/plaf/windows/icons/image-delayed.png")));
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
				lb_icon.setIcon(new ImageIcon(tipsDialog.class.getResource("/javax/swing/plaf/metal/icons/ocean/warning.png")));
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
	
	public void xmlViewer() {
		String cont = "";
		try{
			FileReader fr = new FileReader(path);
			int rd;
			rd = fr.read();
			while(rd != -1)
			{
				cont = cont+(char)rd;
				rd = fr.read();
			}
		}catch(IOException e1){};
		ta_view.setText(cont);
	}
}