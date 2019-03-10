package sm.main;

import java.awt.Event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;
import com.sun.org.apache.regexp.internal.REUtil;
import com.sun.swing.internal.plaf.metal.resources.metal_zh_TW;

import java.awt.event.*;

import java.io.*;
import java.net.HttpURLConnection;  
import java.net.URL;
import java.util.ArrayList; 

public class UploadFrame extends JFrame{

	private Color White = new Color(255, 255, 255);
	private Color Grey = UIManager.getColor("TextArea.disabledBackground");
	private static boolean isDone = false;
	private JFrame frame;
	private static JTextField tf_photoPath;
	private static JTextArea ta_annex;
	private JPanel pnl_image; 
	private JLabel label;
	private JFileChooser jfc;
	private File f;
	private String fname;
	private JLabel lb_photoName;
	private static JTextField tf_photoName;
	private static JTextField tf_annexName;
	private static JTextArea ta_photoDes;
	private static JTextArea ta_annexDes;
	private static ArrayList<String[]> annexList = new ArrayList<>();
	private JTextField tf_annexPath;
	private JButton bt_openAnnex;
	private static JCheckBox ckbx_UpldImg;
	private static JCheckBox ckbx_upldOther;
	private JButton bt_ok;
	
	/**
	 * Create the application.
	 */
	public UploadFrame(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(UploadFrame.class.getResource("/sm/images/annex.jpg")));
		frame.setBounds(100, 100, 651, 700);
		frame.setResizable(false);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.setTitle("添加附件");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{139, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 30, 0, 0, 0, 0, 0, 36, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		ckbx_UpldImg = new JCheckBox("传感器（站点）图片：");
		GridBagConstraints gbc_ckbx_UpldImg = new GridBagConstraints();
		gbc_ckbx_UpldImg.gridwidth = 2;
		gbc_ckbx_UpldImg.anchor = GridBagConstraints.WEST;
		gbc_ckbx_UpldImg.insets = new Insets(10, 10, 5, 5);
		gbc_ckbx_UpldImg.gridx = 0;
		gbc_ckbx_UpldImg.gridy = 0;
		frame.getContentPane().add(ckbx_UpldImg, gbc_ckbx_UpldImg);
		
		tf_photoPath = new JTextField();
		tf_photoPath.setEnabled(false);
		tf_photoPath.setEditable(false);
		GridBagConstraints gbc_tf_photoPath = new GridBagConstraints();
		gbc_tf_photoPath.gridwidth = 2;
		gbc_tf_photoPath.insets = new Insets(10, 0, 5, 5);
		gbc_tf_photoPath.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_photoPath.gridx = 2;
		gbc_tf_photoPath.gridy = 0;
		frame.getContentPane().add(tf_photoPath, gbc_tf_photoPath);
		tf_photoPath.setColumns(10);
		
		JButton bt_OpenImage = new JButton("打开");
		bt_OpenImage.setEnabled(false);
		bt_OpenImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UploadImage();
			}
		});
		GridBagConstraints gbc_bt_OpenImage = new GridBagConstraints();
		gbc_bt_OpenImage.insets = new Insets(10, 0, 5, 15);
		gbc_bt_OpenImage.gridx = 5;
		gbc_bt_OpenImage.gridy = 0;
		frame.getContentPane().add(bt_OpenImage, gbc_bt_OpenImage);
		
		lb_photoName = new JLabel("图片名称：");
		GridBagConstraints gbc_lb_photoName = new GridBagConstraints();
		gbc_lb_photoName.insets = new Insets(0, 0, 5, 5);
		gbc_lb_photoName.gridx = 0;
		gbc_lb_photoName.gridy = 1;
		frame.getContentPane().add(lb_photoName, gbc_lb_photoName);
		
		tf_photoName = new JTextField();
		tf_photoName.setEditable(false);
		tf_photoName.setColumns(10);
		GridBagConstraints gbc_tf_photoName = new GridBagConstraints();
		gbc_tf_photoName.gridwidth = 5;
		gbc_tf_photoName.insets = new Insets(0, 0, 5, 10);
		gbc_tf_photoName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_photoName.gridx = 1;
		gbc_tf_photoName.gridy = 1;
		frame.getContentPane().add(tf_photoName, gbc_tf_photoName);
		
		JLabel lb_photoDes = new JLabel("图片描述：");
		GridBagConstraints gbc_lb_photoDes = new GridBagConstraints();
		gbc_lb_photoDes.insets = new Insets(0, 0, 5, 5);
		gbc_lb_photoDes.gridx = 0;
		gbc_lb_photoDes.gridy = 2;
		frame.getContentPane().add(lb_photoDes, gbc_lb_photoDes);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.gridheight = 2;
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridwidth = 5;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 10);
		gbc_scrollPane_3.gridx = 1;
		gbc_scrollPane_3.gridy = 2;
		frame.getContentPane().add(scrollPane_3, gbc_scrollPane_3);
		
		ta_photoDes = new JTextArea();
		scrollPane_3.setViewportView(ta_photoDes);
		ta_photoDes.setBackground(SystemColor.menu);
		ta_photoDes.setEditable(false);
		ckbx_UpldImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_UpldImg.isSelected()) {
					tf_photoName.setEditable(true);
					ta_photoDes.setEditable(true);
					tf_photoPath.setBackground(White);
					tf_photoName.setBackground(White);
					ta_photoDes.setBackground(White);
					bt_OpenImage.setEnabled(true);
				}else if (!ckbx_UpldImg.isSelected()) {
					tf_photoName.setEditable(false);
					ta_photoDes.setEditable(false);
					tf_photoPath.setBackground(Grey);
					tf_photoName.setBackground(Grey);
					ta_photoDes.setBackground(Grey);
					bt_OpenImage.setEnabled(false);
				}	
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.insets = new Insets(0, 10, 5, 10);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		pnl_image = new JPanel();
		scrollPane.setViewportView(pnl_image);
		pnl_image.setBackground(new Color(245, 255, 250));
		
		label = new JLabel("");
		pnl_image.add(label);
		
		ckbx_upldOther = new JCheckBox("传感器（站点）其他附件：");
		GridBagConstraints gbc_ckbx_upldOther = new GridBagConstraints();
		gbc_ckbx_upldOther.gridwidth = 3;
		gbc_ckbx_upldOther.anchor = GridBagConstraints.WEST;
		gbc_ckbx_upldOther.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_upldOther.gridx = 0;
		gbc_ckbx_upldOther.gridy = 5;
		frame.getContentPane().add(ckbx_upldOther, gbc_ckbx_upldOther);
		
		JButton bt_add = new JButton("添加");
		bt_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf_annexName.getText().equals("")||tf_annexPath.getText().equals("")||ta_annexDes.getText().equals("")) {
					TipsFrame tip = new TipsFrame("请输入附件完整信息！");
					tip.setAlwaysOnTop(true);
					tip.setLocationRelativeTo(frame);
					tip.setVisible(true);
				}else {
					String[] info = {tf_annexName.getText(),tf_annexPath.getText(),ta_annexDes.getText()};
					annexList.add(info);
					ta_annex.append(info[0]+" "+info[1]+" "+info[2]+"\n");
					tf_annexName.setText("");
					tf_annexPath.setText("");
					ta_annexDes.setText("");
				}
			}
		});
		bt_add.setEnabled(false);
		GridBagConstraints gbc_bt_add = new GridBagConstraints();
		gbc_bt_add.insets = new Insets(0, 0, 5, 5);
		gbc_bt_add.gridx = 3;
		gbc_bt_add.gridy = 5;
		frame.getContentPane().add(bt_add, gbc_bt_add);
		
		JButton bt_clear = new JButton("清空");
		bt_clear.setEnabled(false);
		GridBagConstraints gbc_bt_clear = new GridBagConstraints();
		gbc_bt_clear.insets = new Insets(0, 0, 5, 10);
		gbc_bt_clear.gridx = 5;
		gbc_bt_clear.gridy = 5;
		frame.getContentPane().add(bt_clear, gbc_bt_clear);
		bt_clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta_annex.setText(" ");
			}
		});
		ckbx_upldOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_upldOther.isSelected()) {
					tf_annexName.setEditable(true);
					tf_annexName.setBackground(White);
					ta_annexDes.setBackground(White);
					ta_annexDes.setEditable(true);
					tf_annexPath.setBackground(White);
					bt_openAnnex.setEnabled(true);
					bt_add.setEnabled(true);
					bt_clear.setEnabled(true);
				}else if (!ckbx_upldOther.isSelected()) {
					tf_annexName.setEditable(false);
					tf_annexName.setBackground(Grey);
					ta_annexDes.setBackground(Grey);
					ta_annexDes.setEditable(false);
					bt_openAnnex.setEnabled(false);
					tf_annexPath.setBackground(Grey);
					bt_add.setEnabled(false);
					bt_clear.setEnabled(false);
				}
			}
		});
		
		JLabel lb_annexName = new JLabel("附件名称：");
		GridBagConstraints gbc_lb_annexName = new GridBagConstraints();
		gbc_lb_annexName.insets = new Insets(0, 0, 5, 5);
		gbc_lb_annexName.gridx = 0;
		gbc_lb_annexName.gridy = 6;
		frame.getContentPane().add(lb_annexName, gbc_lb_annexName);
		
		tf_annexName = new JTextField();
		tf_annexName.setEditable(false);
		tf_annexName.setColumns(10);
		GridBagConstraints gbc_tf_annexName = new GridBagConstraints();
		gbc_tf_annexName.gridwidth = 5;
		gbc_tf_annexName.insets = new Insets(0, 0, 5, 10);
		gbc_tf_annexName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_annexName.gridx = 1;
		gbc_tf_annexName.gridy = 6;
		frame.getContentPane().add(tf_annexName, gbc_tf_annexName);
		

		
		bt_openAnnex = new JButton("打开附件");
		bt_openAnnex.setEnabled(false);
		bt_openAnnex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfc = new JFileChooser("F:/");
				jfc.setAcceptAllFileFilterUsed(false);
				final String[][]fileNames = {{".doc", "word 文档(*.doc)"},
											 {".pdf", "pdf格式文档(*.pdf)"},
							                 {".txt", "txt文本文件(*.txt)"}};
				
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
				jfc.setMultiSelectionEnabled(true);
				f=jfc.getSelectedFile();
				fname = f.getAbsolutePath(); 
				tf_annexPath.setText(fname);

			}
		});
		GridBagConstraints gbc_bt_openAnnex = new GridBagConstraints();
		gbc_bt_openAnnex.insets = new Insets(0, 0, 5, 5);
		gbc_bt_openAnnex.gridx = 0;
		gbc_bt_openAnnex.gridy = 7;
		frame.getContentPane().add(bt_openAnnex, gbc_bt_openAnnex);
		
		tf_annexPath = new JTextField();
		tf_annexPath.setEnabled(false);
		tf_annexPath.setEditable(false);
		tf_annexPath.setColumns(10);
		GridBagConstraints gbc_tf_annexPath = new GridBagConstraints();
		gbc_tf_annexPath.gridwidth = 5;
		gbc_tf_annexPath.insets = new Insets(0, 0, 5, 10);
		gbc_tf_annexPath.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_annexPath.gridx = 1;
		gbc_tf_annexPath.gridy = 7;
		frame.getContentPane().add(tf_annexPath, gbc_tf_annexPath);
		
		JLabel lb_annexDes = new JLabel("附件描述：");
		GridBagConstraints gbc_lb_annexDes = new GridBagConstraints();
		gbc_lb_annexDes.insets = new Insets(0, 0, 5, 5);
		gbc_lb_annexDes.gridx = 0;
		gbc_lb_annexDes.gridy = 8;
		frame.getContentPane().add(lb_annexDes, gbc_lb_annexDes);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridheight = 2;
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridwidth = 5;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 10);
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 8;
		frame.getContentPane().add(scrollPane_2, gbc_scrollPane_2);
		
		ta_annexDes = new JTextArea();
		scrollPane_2.setViewportView(ta_annexDes);
		ta_annexDes.setBackground(SystemColor.menu);
		ta_annexDes.setEditable(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 6;
		gbc_scrollPane_1.insets = new Insets(0, 10, 5, 10);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 10;
		frame.getContentPane().add(scrollPane_1, gbc_scrollPane_1);
		
		ta_annex = new JTextArea();
		ta_annex.setBackground(new Color(245, 255, 250));
		scrollPane_1.setViewportView(ta_annex);
		
		JButton bt_Exit = new JButton("退出");
		bt_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		bt_ok = new JButton("完成");
		bt_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isDone = true;
				frame.dispose();
			}
		});
		GridBagConstraints gbc_bt_ok = new GridBagConstraints();
		gbc_bt_ok.insets = new Insets(0, 0, 20, 5);
		gbc_bt_ok.gridx = 3;
		gbc_bt_ok.gridy = 11;
		frame.getContentPane().add(bt_ok, gbc_bt_ok);
		GridBagConstraints gbc_bt_Exit = new GridBagConstraints();
		gbc_bt_Exit.insets = new Insets(0, 0, 20, 0);
		gbc_bt_Exit.gridx = 5;
		gbc_bt_Exit.gridy = 11;
		frame.getContentPane().add(bt_Exit, gbc_bt_Exit);
		
	}

	public void UploadImage() 
	{
		jfc = new JFileChooser("F:/");
		Image image = null; 
		jfc.setAcceptAllFileFilterUsed(false);
		final String[][]fileNames = {{".jpeg", "jpeg文件交换格式(*.jepg)"},
									 {".jpg", "jpg文件交换格式(*.jpg)"},
					                 {".png", "可移植的网络图形(*.png)"},
					                 {".bmp","windows位图（*.bmp)"}};
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
		
		//循环添加需要显示的图片格式文件
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
		jfc.setMultiSelectionEnabled(true);
		f=jfc.getSelectedFile();
		//将图片及位置添加到面板
		label.setIcon(new ImageIcon(f.getPath()));
		tf_photoPath.setText(f.getAbsolutePath());
//		try {
//			
//		}catch(IOException e) {}
	}
	
	
	/**
	 * get方法
	 */
	public static boolean checkPhotoInfo() {
		if (ckbx_UpldImg.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkAnnexInfo() {
		if (ckbx_upldOther.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public static boolean getIsDone() {
		return isDone;
	}
	
	public static String[] getPhotoInfo() {
		String[] info = {tf_photoPath.getText(),tf_photoName.getText(),ta_photoDes.getText()};
		return info;
	}
	
	public static ArrayList<String[]> getAnnex() {
		return annexList;
	}
	
}
