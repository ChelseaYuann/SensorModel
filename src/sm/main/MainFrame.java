package sm.main;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import com.sun.corba.se.spi.orb.StringPair;

import sm.InsituPlat_xml.*;
import sm.InsituSensor_xml.InsituSensorFrame;
import sm.readExcel.Excel2XmlFrame;
import sm.readExcel.ReadExcelUtils;
import sm.remoteSensorPlatform_xml.RemoteSensorPlatformFrame;
import sm.remoteSensor_xml.FrameSensorFrame;
import sm.remoteSensor_xml.NonimagingSensorFrame;
import sm.remoteSensor_xml.RadarSensorFrame;
import sm.remoteSensor_xml.ScannerSensorFrame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame{
	private static JFrame mf = new JFrame();
	private JTree tree;
	private JFileChooser jfc;
	private String fname;
	private File f;
	private JTextArea ta;
	private DefaultMutableTreeNode chosen;
	private DefaultMutableTreeNode node_DM,node_HK,node_HT;
	private boolean openIsClicked = false;
	private static JTextArea ta_exampleList;
	private static JTabbedPane tbDH;
	
	
	/**
	 * 初始化主界面.
	 */
	public MainFrame() {
		mf.setTitle("Sensor Model");
		mf.setSize(900, 550);
		mf.setLocation((mf.getWidth()-400)/2, (mf.getHeight()-360)/2);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		mf.setIconImage(Toolkit.getDefaultToolkit().getImage(Insitu_plat_frame.class.getResource("/sm/images/globe.png")));
		
		initmenu();
		
		//主界面使用GridBagLayout布局管理器
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl.rowHeights = new int[]{0, 0};
		gbl.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gbl.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		mf.getContentPane().setLayout(gbl);
		
		//导航建模树及实例树面板
		tbDH = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tbDH = new GridBagConstraints();
		gbc_tbDH.insets = new Insets(0, 0, 0, 5);
		gbc_tbDH.fill = GridBagConstraints.BOTH;
		gbc_tbDH.gridx = 0;
		gbc_tbDH.gridy = 0;
		mf.getContentPane().add(tbDH, gbc_tbDH);

		
		//构造传感器导航树tree
		tree = new JTree();
		tree.setEditable(true);
		JScrollPane jspTr = new JScrollPane();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("传感器建模") {
				{
					DefaultMutableTreeNode node11;
					node_DM = new DefaultMutableTreeNode("地面领域");
						node_DM.add(node11 = new DefaultMutableTreeNode("水环境监测站/点"));
							node11.add(new DefaultMutableTreeNode("水文站/点"));
							node11.add(new DefaultMutableTreeNode("水质站/点"));
							node11.add(new DefaultMutableTreeNode("雨量站/点"));
							node11.add(new DefaultMutableTreeNode("蒸发量站/点"));
							node11.add(new DefaultMutableTreeNode("泥沙站/点"));
						node_DM.add(node11 = new DefaultMutableTreeNode("大气环境监测站/点"));
							node11.add(new DefaultMutableTreeNode("气象监测站/点"));
							node11.add(new DefaultMutableTreeNode("颗粒污染物监测站/点"));
							node11.add(new DefaultMutableTreeNode("气态污染物监测站/点"));
							node11.add(new DefaultMutableTreeNode("其他大气环境监测站/点"));
						node_DM.add(new DefaultMutableTreeNode("地质灾害监测站/点"));
					add(node_DM);
					node_HK = new DefaultMutableTreeNode("航空领域");
						node_HK.add(node11 = new DefaultMutableTreeNode("飞机"));
							node11.add(new DefaultMutableTreeNode("无人机"));
							node11.add(new DefaultMutableTreeNode("直升机"));
							node11.add(new DefaultMutableTreeNode("滑翔机"));
							node11.add(new DefaultMutableTreeNode("旋翼机"));
							node11.add(new DefaultMutableTreeNode("扑翼机"));
							node11.add(new DefaultMutableTreeNode("其他"));
						node_HK.add(new DefaultMutableTreeNode("气球"));
					add(node_HK);
					node_HT = new DefaultMutableTreeNode("航天领域");
						node_HT.add(node11 = new DefaultMutableTreeNode("陆地资源卫星"));
							node11.add(new DefaultMutableTreeNode("Landsat"));
							node11.add(new DefaultMutableTreeNode("SPOT"));
							node11.add(new DefaultMutableTreeNode("IKONOS"));
							node11.add(new DefaultMutableTreeNode("QuickBird"));
							node11.add(new DefaultMutableTreeNode("CBERS"));
							node11.add(new DefaultMutableTreeNode("JERS"));
							node11.add(new DefaultMutableTreeNode("IRS"));
							node11.add(new DefaultMutableTreeNode("WorldView"));
							node11.add(new DefaultMutableTreeNode("GF"));							
						node_HT.add(node11= new DefaultMutableTreeNode("海洋卫星"));
							node11.add(new DefaultMutableTreeNode("SEASAT"));
							node11.add(new DefaultMutableTreeNode("MOS"));
							node11.add(new DefaultMutableTreeNode("ERS"));
							node11.add(new DefaultMutableTreeNode("RADARSAT"));
						node_HT.add(node11 = new DefaultMutableTreeNode("气象卫星"));
							node11.add(new DefaultMutableTreeNode("NOAA"));
							node11.add(new DefaultMutableTreeNode("GMS"));
							node11.add(new DefaultMutableTreeNode("FY"));	
					add(node_HT);
				}
			}
		));
		tbDH.addTab("模型导航", null, jspTr, null);
		jspTr.setViewportView(tree);
		
		
//		tree.addTreeSelectionListener(new TreeSelectionListener() {
//			public void valueChanged(TreeSelectionEvent e) {
//				chosen = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
//				Object[] path = chosen.getUserObjectPath();
//				String user = chosen.toString();
//				System.out.println(user);
//			}
//		});
		
		
		//水文站点右键菜单
//		JPopupMenu popupMenu_sw = new JPopupMenu();
//		addPopup(tree, popupMenu_sw);
//	
//		JMenuItem mi_swzd = new JMenuItem("水文站/点建模");
//		popupMenu_sw.add(mi_swzd);
//		
//		JMenu m_swSensor = new JMenu("水文站/点传感器建模");
//		popupMenu_sw.add(m_swSensor);
//		
//		JMenuItem mi_waterLevel = new JMenuItem("水位传感器建模");
//		m_swSensor.add(mi_waterLevel);
//		
//		JMenuItem mi_flow = new JMenuItem("流量传感器建模");
//		m_swSensor.add(mi_flow);
//		
//		JMenuItem mi_rainFall = new JMenuItem("雨量传感器建模");
//		m_swSensor.add(mi_rainFall);
//		
//		JMenuItem mi_evaporation = new JMenuItem("蒸发量传感器建模");
//		m_swSensor.add(mi_evaporation);
//		
//		JMenuItem mi_nsl = new JMenuItem("泥沙量传感器建模");
//		m_swSensor.add(mi_nsl);
//		
//		JMenuItem mi_othersw = new JMenuItem("其他传感器建模");
//		m_swSensor.add(mi_othersw);
		
		JPanel panel_xmlExample = new JPanel();
		tbDH.addTab("模型实例", null, panel_xmlExample, null);
		GridBagLayout gbl_panel_xmlExample = new GridBagLayout();
		gbl_panel_xmlExample.columnWidths = new int[]{0, 0};
		gbl_panel_xmlExample.rowHeights = new int[]{0, 0};
		gbl_panel_xmlExample.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_xmlExample.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_xmlExample.setLayout(gbl_panel_xmlExample);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_xmlExample.add(scrollPane, gbc_scrollPane);
		
		ta_exampleList = new JTextArea();
		ta_exampleList.setBackground(SystemColor.info);
		scrollPane.setViewportView(ta_exampleList);
		
		JTabbedPane tbXS = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tbXS = new GridBagConstraints();
		gbc_tbXS.gridwidth = 5;
		gbc_tbXS.fill = GridBagConstraints.BOTH;
		gbc_tbXS.gridx = 1;
		gbc_tbXS.gridy = 0;
		mf.getContentPane().add(tbXS, gbc_tbXS);
		
		JPanel tbxml = new JPanel();
		ta = new JTextArea(" ");
		JScrollPane jsp_xml = new JScrollPane();
		tbXS.addTab("模型编码浏览", tbxml);
		BorderLayout xmlLayout = new BorderLayout(0,0);
		tbxml.setLayout(xmlLayout);
		tbxml.add(jsp_xml, BorderLayout.CENTER);
		jsp_xml.setViewportView(ta);	
		
		mf.setVisible(true);
	}
	
	public void initmenu()
	{
		JMenuBar menuBar = new JMenuBar();
		mf.setJMenuBar(menuBar);
		
		JMenu mFile = new JMenu("文件");
		menuBar.add(mFile);
		
		JMenuItem miOpen = new JMenuItem("打开 (O)");
		mFile.add(miOpen);
		
		JMenuItem miSave = new JMenuItem("保存(S)");
		mFile.add(miSave);
		
		JSeparator spline = new JSeparator();
		mFile.add(spline);
		
		JMenuItem miNewExcel = new JMenuItem("导入Excel表格……");
		mFile.add(miNewExcel);
		//注册菜单栏监听事件
		miNewExcel.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e){
				Excel2XmlFrame excel2XmlFrame = new Excel2XmlFrame();
				excel2XmlFrame.setLocationRelativeTo(mf);
				excel2XmlFrame.setVisible(true);
			}
		});
		
		JSeparator spExit = new JSeparator();
		mFile.add(spExit);
		
		JMenuItem miExit = new JMenuItem("退出 (E)");
		mFile.add(miExit);
		
		JMenu mJM = new JMenu("传感器建模");
		menuBar.add(mJM);
		
		JMenu mInsitu = new JMenu("原位传感器建模");
		mJM.add(mInsitu);
		
		JMenuItem miInsitusi = new JMenuItem("原位站/点建模");
		//原位站点建模
		miInsitusi.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent e)
			{
				Insitu_plat_frame Insitu_plat_frame = new Insitu_plat_frame();
				Insitu_plat_frame.setLocationRelativeTo(mf);
				Insitu_plat_frame.setAlwaysOnTop(true);
				//mf.setEnabled(false);
			}
		});
		mInsitu.add(miInsitusi);
		
		JMenuItem miInsitusen = new JMenuItem("原位传感器建模");
		//原位传感器建模
		miInsitusen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsituSensorFrame insituSensorFrame = new InsituSensorFrame();
				insituSensorFrame.setLocationRelativeTo(mf);
				//mFile.setEnabled(false);
			}
		});
		mInsitu.add(miInsitusen);
		
		JMenu mRemote = new JMenu("遥感传感器建模");
		mJM.add(mRemote);
		
		JMenuItem mRemotesi = new JMenuItem("遥感平台建模");
		//卫星平台建模
		mRemotesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoteSensorPlatformFrame remoteSensorPlatform = new RemoteSensorPlatformFrame();
				remoteSensorPlatform.setLocationRelativeTo(mf);
			}
		});
		mRemote.add(mRemotesi);
		
		JMenu mRemotesen = new JMenu("遥感传感器建模");
		mRemote.add(mRemotesen);
		
		JMenuItem miFrame = new JMenuItem("摄影类型传感器建模");
		//摄影类型传感器建模
		miFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameSensorFrame frameSensorFrame = new FrameSensorFrame();
				frameSensorFrame.setLocationRelativeTo(mf);
			}
		});
		mRemotesen.add(miFrame);
		
		JMenuItem miScanner = new JMenuItem("扫描类型传感器建模");
		//扫描类型传感器建模
		miScanner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScannerSensorFrame scannerFrame = new ScannerSensorFrame();
				scannerFrame.setLocationRelativeTo(mf);
			}
		});
		mRemotesen.add(miScanner);
		
		JMenuItem miRadar = new JMenuItem("雷达类型传感器建模");
		//雷达类型传感器建模
		miRadar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RadarSensorFrame radarFrame = new RadarSensorFrame();
				radarFrame.setLocationRelativeTo(mf);
			}
		});
		mRemotesen.add(miRadar);
		
		JMenuItem miNonimage = new JMenuItem("非成像类型传感器建模");
		//非成像类型传感器建模
		miNonimage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NonimagingSensorFrame nonimaginFrame = new NonimagingSensorFrame();
				nonimaginFrame.setLocationRelativeTo(mf);
			}
		});
		mRemotesen.add(miNonimage);
		
		
		JMenu mHelp = new JMenu("帮助");
		menuBar.add(mHelp);
		
		miOpen.setMnemonic('O');
		miOpen.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e)
			{
				openIsClicked = true;
				jfc = new JFileChooser("F:/");
				jfc.setAcceptAllFileFilterUsed(false);
				final String[][]fileNames = {{".xml", "XML模型文件(*.xml)"},
											 {".xls", "excel 文件(*.xls)"},
						                     {".doc", "Word 文件(*.doc)"},
						                     {".txt","TXT文本文档（*.txt)"}};
				//显示所有格式文件
				jfc.addChoosableFileFilter(new FileFilter() {
					
					@Override
					public String getDescription() {
						return "所有文件（*.*）";
					}
					
					@Override
					public boolean accept(File f) {			
						return true;
					}
				});
				
				//循环添加需要显示的xml模型文件
				for (final String[] fileName : fileNames) {
					jfc.setFileFilter(new FileFilter(){
						public boolean accept(File file) {
							if(file.getName().endsWith(fileName[0])||file.isDirectory()) 
								return true;
							return false;
						}
						public String getDescription() {
							return fileName[1];
						}
					});
				}
				jfc.showOpenDialog(null);
				f = jfc.getSelectedFile();
				fname = f.getAbsolutePath();
				String cont = "";
				try{
					FileReader fr = new FileReader(fname);
					int rd;
					rd = fr.read();
					while(rd != -1)
					{
						cont = cont+(char)rd;
						rd = fr.read();
					}
				}catch(IOException e1){};
				ta.setText(cont);
				
				//将读入的xml文档类型显示左侧
				ta_exampleList.append(fname+"\n");
				tbDH.setSelectedIndex(1);
			}
		});
		
		miSave.setMnemonic('S');
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e)
			{
				if (openIsClicked == true) {
					jfc = new JFileChooser("F:/");
					jfc.showSaveDialog(null);
					f = jfc.getSelectedFile();
					fname = f.getAbsolutePath();
					try{
						FileWriter fw = new FileWriter(fname+".xml");
						String w;
						w = ta.getText();
						fw.write(w);
						fw.close();
					}catch(IOException e1){};
				}else {
					tipsDialog tip = new tipsDialog("请先打开文件！");
					tip.setLocationRelativeTo(mf);
					tip.setAlwaysOnTop(true);
					tip.setVisible(true);
				}
			}
		});
		
		miExit.setMnemonic('E');
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e)
			{
				System.exit(0);
				
			}
		});
		
	}
	//添加右键弹出窗口静态方法
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
//	private static void nodePopup(DefaultMutableTreeNode node) {
//		node.
//	}
	
	
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
}

