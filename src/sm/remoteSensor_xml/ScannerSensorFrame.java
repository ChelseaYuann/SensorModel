package sm.remoteSensor_xml;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import sm.main.UploadFrame;

public class ScannerSensorFrame extends JFrame{

	private static String savePath = "src/instance/instance_ScannerSensor.xml";
	private JFrame frame;
	private Color Grey = UIManager.getColor("TextArea.disabledBackground");
	private Color white = Color.WHITE;
	private DefaultTableModel model_parentPlatform;
	private DefaultTableModel model_otherIdentifier;
	private DefaultTableModel model_otherClassifier;
	private DefaultTableModel model_otherCharacter;
	private DefaultTableModel model_otherCapability;
	private DefaultTableModel model_contact;
	private DefaultTableModel model_event;
	private DefaultTableModel model_interface;
	private DefaultTableModel model_input;
	private DefaultTableModel model_output;
	private DefaultTableModel model_opticalBandCharacter;
	private JButton save;
	private JButton clear;
	private JButton view;
	private JButton documents;
	private boolean saveIsClicked = false;
	private boolean savePageIsClicled = false;
	private JTabbedPane tp_content;
	private JPanel p_description;
	private JPanel p_constraint;
	private JPanel p_capability;
	private JTabbedPane tp_capa;
	private JPanel p_character;
	private JPanel p_capabilities;
	private JPanel p_position;
	private JPanel p_contact;
	private JPanel p_component;
	private JPanel buttonPanel;
	private JButton bt_prePage;
	private JButton bt_preItem;
	private JButton bt_savePage;
	private JButton bt_quitPage;
	private JButton bt_nextItem;
	private JButton bt_nextPage;
	private static JTextArea ta_description;
	private JTextField tf_keyword;
	private JButton bt_addKeyword;
	private static JTextArea ta_keyword;
	private JButton bt_deleKeyword;
	private JCheckBox ckbx_UID;
	private JTextField tf_organizationID;
	private JCheckBox ckbx_sensorType;
	private static JTextField tf_sensorType;
	private JTextField tf_sensorID;
	private JCheckBox ckbx_scannerType;
	private JButton bt_creatUID;
	private static JTextField tf_UID;
	private static JComboBox cbbx_scannerType;
	private JCheckBox ckbx_application;
	private JTextField tf_application;
	private JButton bt_addApplication;
	private static JTextArea ta_application;
	private JButton bt_deleApplication;
	private JCheckBox ckbx_longName;
	private static JTextField tf_longName;
	private JCheckBox ckbx_shortName;
	private static JTextField tf_shortName;
	private static JCheckBox ckbx_parentPlatform;
	private static JTable tb_parentPlatform;
	private JTextField tf_parentPlatformName;
	private JTextField tf_parentPlatformID;
	private JButton bt_addParentPlatform;
	private JButton bt_deleParentPlatform;
	private static JCheckBox ckbx_otherIdentifier;
	private JTextField tf_otherIDentifierContent;
	private JTextField tf_otherIdentifierName;
	private JButton bt_deleIdentifier;
	private JButton bt_addIdentifier;
	private static JCheckBox ckbx_otherclassifier;
	private JTextField tf_otherClassifierContent;
	private JTextField tf_otherClassifierName;
	private JButton bt_addClassifier;
	private JButton bt_deleClassifier;
	private static JTable tb_otherIdentifier;
	private static JTable tb_otherClassifier;
	private static JCheckBox ckbx_validTM;
	private static JComboBox cbbx_beginTM;
	private static JTextField tf_beginTM;
	private static JComboBox cbbx_endTM;
	private static JTextField tf_endTM;
	private static JCheckBox ckbx_legalConstraint;
	private static JTextArea ta_legalConstraint;
	private static JCheckBox ckbx_securityConstraint;
	private static JTextArea ta_securityConstraint;
	private static JCheckBox ckbx_length;
	private static JTextField tf_length;
	private static JCheckBox ckbx_life;
	private static JTextField tf_life;
	private static JCheckBox ckbx_width;
	private static JTextField tf_width;
	private static JCheckBox ckbx_height;
	private static JTextField tf_height;
	private static JCheckBox ckbx_weight;
	private static JTextField tf_weight;
	private static JCheckBox ckbx_otherCharacter;
	private static JCheckBox ckbx_current;
	private static JTextField tf_maxCurrent;
	private static JTextField tf_minCurrent;
	private static JTable tb_otherCharacter;
	private static JCheckBox ckbx_voltage;
	private static JTextField tf_minVoltage;
	private static JTextField tf_maxVoltage;
	private static JCheckBox ckbx_power;
	private static JTextField tf_power;
	private static JCheckBox ckbx_outputPower;
	private static JTextField tf_outputPower;
	private JTextField tf_otherCharacterName;
	private JTextField tf_otherCharacterValue;
	private JButton bt_addOtherCharacter;
	private JButton bt_deleOtherCharacter;
	private static JRadioButton rbt_textPosition;
	private static JTextArea ta_textPosition;
	private static JTextField tf_pointSRS;
	private static JTextField tf_pointX;
	private static JTextField tf_pointY;
	private static JTextField tf_locationSRS;
	private static JTextField tf_latitude;
	private static JTextField tf_longitude;
	private static JTextField tf_altitude;
	private static JRadioButton rbt_pointPosition;
	private static JRadioButton rbt_location;
	private final ButtonGroup bg_position = new ButtonGroup();
	private JCheckBox ckbx_role;
	private static JComboBox cbbx_role;
	private static JCheckBox ckbx_eventID;
	private static JTextField tf_eventId;
	private static JTextField tf_eventLabel;
	private static JCheckBox ckbx_orgniz;
	private static JTextField tf_orgniz;
	private static JCheckBox ckbx_EDesc;
	private static JTextArea ta_EDesc;
	private static JCheckBox ckbx_person;
	private static JTextField tf_person;
	private static JCheckBox ckbx_tele;
	private static JTextField tf_tele;
	private static JCheckBox ckbx_addr;
	private static JTextField tf_addr;
	private static JTextField tf_city;
	private static JTextField tf_admi;
	private static JTextField tf_country;
	private static JTextField tf_code;
	private static JTextField tf_email;
	private static JRadioButton rbt_ETime;
	private static JTextField tf_EBeginTM;
	private static JTextField tf_EEndTM;
	private static JTextField tf_ETMIns;
	private static JRadioButton rbt_ETMIns;
	private static JTable tb_event;
	private static JTable tb_inte;
	private static JTable tb_contacID;
	private ButtonGroup bg_eventTM = new ButtonGroup();
	private static JCheckBox ckbx_input;
	private JButton bt_addInput;
	private JButton bt_deleInput;
	private static JTable tb_input;
	private JScrollPane scrollPane_14;
	private static JCheckBox ckbx_output;
	private static JTable tb_output;
	private JScrollPane scrollPane_15;
	private JButton bt_addOutput;
	private JButton bt_deleOutput;
	private static String[] opticalBandCharacter = new String[5];
	private static JTextField tf_bandsCategory;
	private static JCheckBox ckbx_bandsRange;
	private static JTextField tf_minBandsRange;
	private static JTextField tf_maxBandsRange;
	private static JCheckBox ckbx_revisitTM;
	private static JTextField tf_revisitTM;
	private static JCheckBox ckbx_bandsNumber;
	private static JTextField tf_bandsNumber;
	private static JCheckBox ckbx_swath;
	private static JCheckBox ckbx_fov;
	private static JCheckBox ckbx_geolocationAccuracy;
	private static JCheckBox ckbx_groundResolution;
	private static JCheckBox ckbx_angleAccuracy;
	private static JTextField tf_minSwath;
	private static JTextField tf_maxSwath;
	private static JTextField tf_fov;
	private static JTextField tf_geolocationAccuracy;
	private static JTextField tf_minGroungResolution;
	private static JTextField tf_maxGroungResolution;
	private static JTextField tf_angleAccuracy;
	private static JCheckBox ckbx_distanceAccuracy;
	private static JTextField tf_distanceAccuracy;
	private static JCheckBox ckbx_sideSwingAngle;
	private static JTextField tf_sideSwingAngle;
	private static JCheckBox ckbx_radiationAccuracy;
	private static JTextField tf_radiationAccuracy;
	private static JTextField tf_lowerY;
	private static JTextField tf_lowerX;
	private static JCheckBox ckbx_dataAccessLevel;
	private static JTextField tf_upperY;
	private static JComboBox cbbx_dataAccessLevel;
	private static JTextField tf_upperX;
	private static JTextField tf_dataAccessQuality;
	private static JCheckBox ckbx_dataAccessQuality;
	private static JCheckBox ckbx_dataFormat;
	private static JTextField tf_dataFormat;
	private static JCheckBox ckbx_opticalBandCharacteristics;
	private JButton bt_addOpticalBandCharacter;
	private JButton bt_deleOpticalBandCharacter;
	private static JTable tb_opticalBandCharacter;
	private static JCheckBox ckbx_otherCapability;
	private static JCheckBox ckbx_IFOV;
	private static JTextField tf_IFOV;
	private static JCheckBox ckbx_quantilizationLevel;
	private static JTextField tf_quantizationLevel;
	private static JCheckBox ckbx_nadirResolution;
	private static JTextField tf_nadirResolution;
	private static JTable tb_otherCapability;
	private JTextField tf_otherCapaName;
	private JTextField tf_otherCapaContent;
	private JButton bt_addOtherCapa;
	private JButton bt_deleteOtherCapa;
	private static JCheckBox ckbx_FOI;
	private JButton bt_addFOI;
	private JButton bt_deleFOI;
	private static JTable tb_FOI;
	private static DefaultTableModel model_FOI;

	public static String getDescripition() {
		return ta_description.getText();
	}
	
	public static String getUID() {
		return tf_UID.getText();
	}
	
	public static String[] getKeywords() {
		String[] keyword = ta_keyword.getText().split("\n");
		return keyword;
	}
	
	public static String getLongname() {
		return tf_longName.getText();
	}
	
	public static String getShortname() {
		return tf_shortName.getText();
	}
	
	public static int getParentPlatformCount() {
		return tb_parentPlatform.getRowCount();
	}
	
	public static String getParentPlatformInfo(int a,int b) {
		return tb_parentPlatform.getValueAt(a, b).toString();
	}
	
	public static String getSensorType() {
		return tf_sensorType.getText();
	}
	
	public static String getScannerType() {
		return cbbx_scannerType.getSelectedItem().toString();
	}
	
	public static String[] getApplication() {
		String[] application = ta_application.getText().split("\n");
		return application;
	}
	
	public static int getOtherIdentifierCount() {
		return tb_otherIdentifier.getRowCount();
	}
	
	public static String getOtherIdentifierInfo(int a,int b) {
		return tb_otherIdentifier.getValueAt(a, b).toString();
	}
	
	public static int getOtherClassiifierCount() {
		return tb_otherClassifier.getRowCount();
	}
	
	public static String getOtherClassifierInfo(int a,int b) {
		return tb_otherClassifier.getValueAt(a, b).toString();
	}
	
	public static String getBeginTMStates() {
		return cbbx_beginTM.getSelectedItem().toString();
	}
	
	public static String getBeginTM() {
		return tf_beginTM.getText();
	}
	
	public static String getEndTMStates() {
		return cbbx_endTM.getSelectedItem().toString();
	}
	
	public static String getEndTM() {
		return tf_endTM.getText();
	}
	
	public static String getLegalConstraint() {
		return ta_legalConstraint.getText();
	}
	
	public static String getSecurityConstraint() {
		return ta_securityConstraint.getText();
	}
	
	public static String getSensorLength() {
		return tf_length.getText();
	}
	
	public static String getSensorWidth() {
		return tf_width.getText();
	}
	
	public static String getSensorHeight() {
		return tf_height.getText();
	}
	
	public static String getSensorWeigh() {
		return tf_weight.getText();
	}
	
	public static String getCurrent() {
		return tf_minCurrent.getText()+" "+tf_maxCurrent.getText();
	}
	
	public static String getVoltage() {
		return tf_minVoltage.getText()+" "+tf_maxVoltage.getText();
	}
	
	public static String getPower() {
		return tf_power.getText();
	}

	public static String getOutputPower() {
		return tf_outputPower.getText();
	}

	public static String getLife() {
		return tf_life.getText();
	}
	
	public static int getOtherCharacterCount() {
		return tb_otherCharacter.getRowCount();
	}
	
	public static String getOtherCharacterInfo(int a,int b) {
		return tb_otherCharacter.getValueAt(a, b).toString();
	}

	public static String getBandsCategory() {
		return tf_bandsCategory.getText();
	}

	public static String getBandsRange() {
		return tf_minBandsRange.getText()+" "+tf_maxBandsRange.getText();
	}

	public static String getBandsNumber() {
		return tf_bandsNumber.getText();
	}

	public static String getSwath() {
		return tf_minSwath.getText()+" "+tf_maxSwath.getText();
	}

	public static String getFOV() {
		return tf_fov.getText();
	}

	public static String getGroundResolutionRange() {
		return tf_minGroungResolution.getText()+" "+tf_maxGroungResolution.getText();
	}

	public static String getSideSwingAngle() {
		return tf_sideSwingAngle.getText();
	}

	public static String getLowerY() {
		return tf_lowerY.getText();
	}

	public static String getLowerX() {
		return tf_lowerX.getText();
	}

	public static String getUpperY() {
		return tf_upperY.getText();
	}

	public static String getUpperX() {
		return tf_upperX.getText();
	}
	
	public static int getOpticalBandCharacterCount() {
		return tb_opticalBandCharacter.getRowCount();
	}
	
	public static String[] getOpticalBandCharacterInfo(int row) {
		JTable tb = tb_opticalBandCharacter;
		String[] c = {tb.getValueAt(row, 0).toString(),tb.getValueAt(row, 1).toString(),
				tb.getValueAt(row, 2).toString(),tb.getValueAt(row, 3).toString(),tb.getValueAt(row, 4).toString()};
		return c;
	}

	public static String getIFOV() {
		return tf_IFOV.getText();
	}

	public static String getQuantizationLevel() {
		return tf_quantizationLevel.getText();
	}

	public static String getNadirResolution() {
		return tf_nadirResolution.getText();
	}

	public static String getRevisitingPeriod() {
		return tf_revisitTM.getText();
	}

	public static String getGeolocationAccuracy() {
		return tf_geolocationAccuracy.getText();
	}

	public static String getAngleAccuracy() {
		return tf_angleAccuracy.getText();
	}

	public static String getDistanceAccuracy() {
		return tf_distanceAccuracy.getText();
	}

	public static String getRadiationAccuracy() {
		return tf_radiationAccuracy.getText();
	}

	public static String getDataAccessLevel() {
		return cbbx_dataAccessLevel.getSelectedItem().toString();
	}

	public static String getDataAccessQuality() {
		return tf_dataAccessQuality.getText();
	}

	public static String getDataFormat() {
		return tf_dataFormat.getText();
	}
	
	public static int getOtherCapabilityCount() {
		return tb_otherCapability.getRowCount();
	}
	
	public static String getOtherCapabilityInfo(int a,int b) {
		return tb_otherCapability.getValueAt(a, b).toString();
	}
	
	public static int getPositionChoice() {
		if (rbt_textPosition.isSelected()) {
			return 1;
		}else if (rbt_pointPosition.isSelected()) {
			return 2;
		}else if (rbt_location.isSelected()) {
			return 3;
		}else {
			return 0;
		}
	}
	
	public static String getTextPosition() {
		return ta_textPosition.getText();
	}
	
	public static String[] get2Dposition() {
		String[] point = {tf_pointSRS.getText(),tf_pointY.getText(),tf_pointX.getText()};
		return point;
	}
	
	public static String[] get3DPosition() {
		String[] positon = {tf_locationSRS.getText(),tf_latitude.getText(),tf_longitude.getText(),tf_altitude.getText()};
		return positon;
	}
	
	public static String getRole() {
		return cbbx_role.getSelectedItem().toString();
	}
	
	public static String getOrganizationName() {
		return tf_orgniz.getText();
	}
	
	public static String getIndividualName() {
		return tf_person.getText();
	}
	
	public static String getTelephone() {
		return tf_tele.getText();
	}
	
	public static String getDeliveryPoint() {
		return tf_addr.getText();
	}
	
	public static String getCity() {
		return tf_city.getText();
	}
	
	public static String getAdministration() {
		return tf_admi.getText();
	}
	
	public static String getCountry() {
		return tf_country.getText();
	}
	
	public static String getPostcode() {
		return tf_code.getText();
	}
	
	public static String getEmail() {
		return tf_email.getText();
	}
	
	public static int getContactCount() {
		return tb_contacID.getRowCount();
	}
	
	public static String getContactInfo(int a,int b) {
		return tb_contacID.getValueAt(a, b).toString();
	}
	
	public static String getEventID() {
		return tf_eventId.getText();
	}
	
	public static String getEventLabel() {
		return tf_eventLabel.getText();
	}
	
	public static String getEventDescription() {
		return ta_EDesc.getText();
	}
	
	public static int getEventTMChoice() {
		if (rbt_ETime.isSelected()) {
			return 1;
		}else if(rbt_ETMIns.isSelected()){
			return 2;
		}else {
			return 0;
		}
	}
	
	public static String getEventBeginTM() {
		return tf_EBeginTM.getText();
	}
	
	public static String getEventEndTM() {
		return tf_EEndTM.getText();
	}
	
	public static String getEventInstance() {
		return tf_ETMIns.getText();
	}
	
	public static int getEventNum() {
		return tb_event.getRowCount();
	}
	
	public static String getEventInfo(int a,int b) {
		return tb_event.getValueAt(a, b).toString();
	}
	
	public static int getInterfaceNum() {
		return tb_inte.getRowCount();
	}
	
	public static String getInterfaceInfo(int a,int b) {
		return tb_inte.getValueAt(a, b).toString();
	}
	
	public static int getInputNum() {
		return tb_input.getRowCount();
	}
	
	public static String getInputInfo(int a,int b) {
		return tb_input.getValueAt(a, b).toString();
	}
	
	public static int getOutputNum() {
		return tb_output.getRowCount();
	}
	
	public static String getOutputInfo(int a,int b) {
		return tb_output.getValueAt(a, b).toString();
	}
	
	public static int getFOINum() {
		return tb_FOI.getRowCount();
	}
	
	public static String getFOIInfo(int a,int b) {
		return tb_FOI.getValueAt(a, b).toString();
	}
	
	public static boolean checkFOI() {
		if (ckbx_FOI.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOtherIdentifier() {
		if (ckbx_otherIdentifier.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOtherClassifier() {
		if (ckbx_otherclassifier.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkLegalConstraint() {
		if (ckbx_legalConstraint.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkSecurityConstraint() {
		if (ckbx_securityConstraint.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkLength() {
		if (ckbx_length.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkWidth() {
		if (ckbx_width.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkHeight() {
		if (ckbx_height.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkWeight() {
		if (ckbx_weight.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkCurrent() {
		if (ckbx_current.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkVoltage() {
		if (ckbx_voltage.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkPower() {
		if (ckbx_power.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOutputPower() {
		if (ckbx_outputPower.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkLife() {
		if (ckbx_life.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOtherCharacter() {
		if (ckbx_otherCharacter.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkBandsRange() {
		if (ckbx_bandsRange.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkBandsNumber() {
		if (ckbx_bandsNumber.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkSwath() {
		if (ckbx_swath.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkFOV() {
		if (ckbx_fov.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkGroungResolution() {
		if (ckbx_groundResolution.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkSideSwingAngle() {
		if (ckbx_sideSwingAngle.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOpticalBandCharacter() {
		if (ckbx_opticalBandCharacteristics.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkRevisitingPeriod() {
		if (ckbx_revisitTM.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkGeolocationAccuracy() {
		if (ckbx_geolocationAccuracy.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkAngleAccuracy() {
		if (ckbx_angleAccuracy.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkDistanceAccuracy() {
		if (ckbx_distanceAccuracy.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkRadiationAccuracy() {
		if (ckbx_radiationAccuracy.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkDataAccessLevel() {
		if (ckbx_dataAccessLevel.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkDataAccessQuality() {
		if (ckbx_dataAccessQuality.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkDataFormat() {
		if (ckbx_dataFormat.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOtherCapability() {
		if (ckbx_otherCapability.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkTextPosition() {
		if (rbt_textPosition.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkPointPosition() {
		if (rbt_pointPosition.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkLocationPosition() {
		if (rbt_location.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkIndividualName() {
		if (ckbx_person.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkTelephone() {
		if (ckbx_tele.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkAddress() {
		if (ckbx_addr.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkEventID() {
		if (ckbx_eventID.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkEventDescription() {
		if (ckbx_EDesc.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkEventPeriod() {
		if (rbt_ETime.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkEventInstance() {
		if (rbt_ETMIns.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOutput() {
		if (ckbx_output.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	/**
	 * Create the application.
	 */
	public ScannerSensorFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ScannerSensorFrame.class.getResource("/sm/images/卫星平台.png")));
		frame.setTitle("扫描类型传感器建模");
		frame.setBounds(400,100,850, 780);
		frame.setResizable(false);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		save = new JButton("保存");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveIsClicked = true;
				if (savePageIsClicled==true) {
					CreateScannerSensorXML.SaveXML();
				}else if(savePageIsClicled==false){
					tipsDialog saveTip = new tipsDialog("请先对模型进行“保存编辑”操作！");
					saveTip.setLocationRelativeTo(frame);
					saveTip.setVisible(true);
				}
			}
		});
		save.setIcon(new ImageIcon(ScannerSensorFrame.class.getResource("/sm/images/save.jpg")));
		toolBar.add(save);
		
//		clear = new JButton("清空");
//		clear.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		clear.setIcon(new ImageIcon(ScannerSensorFrame.class.getResource("/sm/images/clear.jpg")));
//		toolBar.add(clear);
		
		view = new JButton("查看");
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (saveIsClicked==true) {
					viewer v = new viewer();
					v.read();
					v.setLocationRelativeTo(frame);
					v.setAlwaysOnTop(true);
					v.setVisible(true);
				}else{
					tipsDialog viewTip = new tipsDialog("请先对模型进行“保存”操作！");
					viewTip.setLocationRelativeTo(frame);
					viewTip.setAlwaysOnTop(true);
					viewTip.setVisible(true);
				}	
			}
		});
		view.setIcon(new ImageIcon(ScannerSensorFrame.class.getResource("/sm/images/view2.jpg")));
		toolBar.add(view);
		
		documents = new JButton("附件");
		documents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UploadFrame fr = new UploadFrame();
				fr.setLocationRelativeTo(frame);
			}
		});
		documents.setIcon(new ImageIcon(ScannerSensorFrame.class.getResource("/sm/images/annex.jpg")));
		toolBar.add(documents);
		
		tp_content = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tp_content, BorderLayout.CENTER);
		
		p_description = new JPanel();
		tp_content.addTab("传感器标识信息", null, p_description, null);
		GridBagLayout gbl_p_description = new GridBagLayout();
		gbl_p_description.columnWidths = new int[]{0, 75, 38, 38, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_p_description.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35, 0, 31, 0, 0, 34, 0, 34, 0, 0};
		gbl_p_description.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_p_description.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		p_description.setLayout(gbl_p_description);
		
		model_parentPlatform = new DefaultTableModel(new Object[][] {},new String[] {"平台名称", "平台标识符"});
		model_otherIdentifier = new DefaultTableModel(new Object[][] {},new String[] {"标识名称", "标识内容"});
		model_otherClassifier = new DefaultTableModel(new Object[][] {},new String[] {"分类名称", "分类内容"});
		
		JLabel lb_description = new JLabel("传感器描述：");
		lb_description.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_description = new GridBagConstraints();
		gbc_lb_description.anchor = GridBagConstraints.WEST;
		gbc_lb_description.gridwidth = 2;
		gbc_lb_description.insets = new Insets(15, 20, 5, 5);
		gbc_lb_description.gridx = 0;
		gbc_lb_description.gridy = 0;
		p_description.add(lb_description, gbc_lb_description);
		
		JLabel lb_keywords = new JLabel("传感器发现关键词：");
		lb_keywords.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_keywords = new GridBagConstraints();
		gbc_lb_keywords.anchor = GridBagConstraints.WEST;
		gbc_lb_keywords.gridwidth = 2;
		gbc_lb_keywords.insets = new Insets(15, 20, 5, 5);
		gbc_lb_keywords.gridx = 6;
		gbc_lb_keywords.gridy = 0;
		p_description.add(lb_keywords, gbc_lb_keywords);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.insets = new Insets(0, 10, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		p_description.add(scrollPane, gbc_scrollPane);
		
		ta_description = new JTextArea();
		scrollPane.setViewportView(ta_description);
		
		tf_keyword = new JTextField();
		hintText hintKeyword = new hintText(tf_keyword, "遥感/传感器中英文简称/应用等");
		tf_keyword.addFocusListener(new JTextFieldHintListener("遥感/传感器中英文简称/应用等", tf_keyword));
		tf_keyword.setColumns(10);
		GridBagConstraints gbc_tf_keyword = new GridBagConstraints();
		gbc_tf_keyword.gridwidth = 2;
		gbc_tf_keyword.insets = new Insets(0, 0, 5, 5);
		gbc_tf_keyword.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_keyword.gridx = 6;
		gbc_tf_keyword.gridy = 1;
		p_description.add(tf_keyword, gbc_tf_keyword);
		
		bt_addKeyword = new JButton("增加");
		bt_addKeyword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta_keyword.append(tf_keyword.getText()+"\n");
				tf_keyword.setText("");
			}
		});
		GridBagConstraints gbc_bt_addKeyword = new GridBagConstraints();
		gbc_bt_addKeyword.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addKeyword.gridx = 8;
		gbc_bt_addKeyword.gridy = 1;
		p_description.add(bt_addKeyword, gbc_bt_addKeyword);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_5 = new GridBagConstraints();
		gbc_scrollPane_5.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_5.gridheight = 2;
		gbc_scrollPane_5.gridwidth = 2;
		gbc_scrollPane_5.insets = new Insets(0, 0, 5, 10);
		gbc_scrollPane_5.gridx = 9;
		gbc_scrollPane_5.gridy = 1;
		p_description.add(scrollPane_5, gbc_scrollPane_5);
		
		ta_keyword = new JTextArea();
		scrollPane_5.setViewportView(ta_keyword);
		ta_keyword.setBackground(SystemColor.info);
		
		bt_deleKeyword = new JButton("清空");
		bt_deleKeyword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta_keyword.setText("");
			}
		});
		GridBagConstraints gbc_bt_deleKeyword = new GridBagConstraints();
		gbc_bt_deleKeyword.insets = new Insets(0, 0, 5, 5);
		gbc_bt_deleKeyword.gridx = 8;
		gbc_bt_deleKeyword.gridy = 2;
		p_description.add(bt_deleKeyword, gbc_bt_deleKeyword);
		
		JLabel lb_identifier = new JLabel("标识符");
		lb_identifier.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_identifier = new GridBagConstraints();
		gbc_lb_identifier.anchor = GridBagConstraints.WEST;
		gbc_lb_identifier.gridwidth = 2;
		gbc_lb_identifier.insets = new Insets(0, 20, 5, 5);
		gbc_lb_identifier.gridx = 0;
		gbc_lb_identifier.gridy = 3;
		p_description.add(lb_identifier, gbc_lb_identifier);
		
		JLabel lb_classifier = new JLabel("分类符");
		lb_classifier.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_classifier = new GridBagConstraints();
		gbc_lb_classifier.anchor = GridBagConstraints.WEST;
		gbc_lb_classifier.gridwidth = 2;
		gbc_lb_classifier.insets = new Insets(0, 20, 5, 5);
		gbc_lb_classifier.gridx = 6;
		gbc_lb_classifier.gridy = 3;
		p_description.add(lb_classifier, gbc_lb_classifier);
		
		ckbx_UID = new JCheckBox("唯一标识符：");
		ckbx_UID.setSelected(true);
		GridBagConstraints gbc_ckbx_UID = new GridBagConstraints();
		gbc_ckbx_UID.anchor = GridBagConstraints.WEST;
		gbc_ckbx_UID.gridwidth = 2;
		gbc_ckbx_UID.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_UID.gridx = 0;
		gbc_ckbx_UID.gridy = 4;
		p_description.add(ckbx_UID, gbc_ckbx_UID);
		
		tf_organizationID = new JTextField();
		hintText hintOrganizationID = new hintText(tf_organizationID, "请输入组织标识");
		tf_organizationID.addFocusListener(new JTextFieldHintListener("请输入组织标识", tf_organizationID));
		tf_organizationID.addMouseListener(new MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent e) {
				tf_organizationID.setForeground(Color.black);
				tf_organizationID.setBorder(new LineBorder(Color.black));
				tf_organizationID.setText("");
			}
		});
		tf_organizationID.setColumns(10);
		GridBagConstraints gbc_tf_organizationID = new GridBagConstraints();
		gbc_tf_organizationID.gridwidth = 4;
		gbc_tf_organizationID.insets = new Insets(0, 0, 5, 5);
		gbc_tf_organizationID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_organizationID.gridx = 2;
		gbc_tf_organizationID.gridy = 4;
		p_description.add(tf_organizationID, gbc_tf_organizationID);
		
		ckbx_sensorType = new JCheckBox("传感器类型：");
		ckbx_sensorType.setSelected(true);
		GridBagConstraints gbc_ckbx_sensorType = new GridBagConstraints();
		gbc_ckbx_sensorType.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_sensorType.gridx = 6;
		gbc_ckbx_sensorType.gridy = 4;
		p_description.add(ckbx_sensorType, gbc_ckbx_sensorType);
		
		tf_sensorType = new JTextField();
		hintText hintSensorType = new hintText(tf_sensorType, "扫描类型传感器");
		tf_sensorType.addFocusListener(new JTextFieldHintListener("扫描类型传感器", tf_sensorType));
		tf_sensorType.setColumns(10);
		GridBagConstraints gbc_tf_sensorType = new GridBagConstraints();
		gbc_tf_sensorType.gridwidth = 4;
		gbc_tf_sensorType.insets = new Insets(0, 0, 5, 10);
		gbc_tf_sensorType.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_sensorType.gridx = 7;
		gbc_tf_sensorType.gridy = 4;
		p_description.add(tf_sensorType, gbc_tf_sensorType);
		
		tf_sensorID = new JTextField();
		hintText hintSensorID = new hintText(tf_sensorID, "请输入传感器标识");
		tf_sensorID.addFocusListener(new JTextFieldHintListener("请输入传感器标识", tf_sensorID));
		tf_sensorID.addMouseListener(new MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent e) {
				tf_sensorID.setForeground(Color.black);
				tf_sensorID.setBorder(new LineBorder(Color.black));
				tf_sensorID.setText("");
			}
		});
		tf_sensorID.setColumns(10);
		GridBagConstraints gbc_tf_sensorID = new GridBagConstraints();
		gbc_tf_sensorID.gridwidth = 4;
		gbc_tf_sensorID.insets = new Insets(0, 0, 5, 5);
		gbc_tf_sensorID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_sensorID.gridx = 2;
		gbc_tf_sensorID.gridy = 5;
		p_description.add(tf_sensorID, gbc_tf_sensorID);
		
		ckbx_scannerType = new JCheckBox("扫描类型：");
		ckbx_scannerType.setSelected(true);
		GridBagConstraints gbc_ckbx_scannerType = new GridBagConstraints();
		gbc_ckbx_scannerType.anchor = GridBagConstraints.WEST;
		gbc_ckbx_scannerType.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_scannerType.gridx = 6;
		gbc_ckbx_scannerType.gridy = 5;
		p_description.add(ckbx_scannerType, gbc_ckbx_scannerType);
		
		bt_creatUID = new JButton("生成");
		bt_creatUID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((!tf_organizationID.getText().equals(""))&&(!tf_sensorID.getText().equals(""))
						&&(!tf_organizationID.getText().equals("请输入组织标识"))&&(!tf_sensorID.getText().equals("请输入传感器标识"))) {
					tf_UID.setText("urn:"+tf_organizationID.getText()+":def:identifier:OGC:2.0:"+tf_sensorID.getText());
				}else if (tf_organizationID.getText().equals("")||tf_sensorID.getText().equals("")) {
					tf_organizationID.setBorder(new LineBorder(Color.RED));
					tf_organizationID.setForeground(Color.RED);
					tf_organizationID.setText("请输入组织标识");
					tf_sensorID.setBorder(new LineBorder(Color.RED));
					tf_sensorID.setForeground(Color.RED);
					tf_sensorID.setText("请输入传感器标识");
				}
			}
		});
		
		cbbx_scannerType = new JComboBox();
		cbbx_scannerType.setModel(new DefaultComboBoxModel(new String[] {"摆扫式", "推扫式"}));
		GridBagConstraints gbc_cbbx_scannerType = new GridBagConstraints();
		gbc_cbbx_scannerType.gridwidth = 4;
		gbc_cbbx_scannerType.insets = new Insets(0, 0, 5, 10);
		gbc_cbbx_scannerType.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbx_scannerType.gridx = 7;
		gbc_cbbx_scannerType.gridy = 5;
		p_description.add(cbbx_scannerType, gbc_cbbx_scannerType);
		GridBagConstraints gbc_bt_creatUID = new GridBagConstraints();
		gbc_bt_creatUID.insets = new Insets(0, 5, 5, 5);
		gbc_bt_creatUID.gridx = 0;
		gbc_bt_creatUID.gridy = 6;
		p_description.add(bt_creatUID, gbc_bt_creatUID);
		
		tf_UID = new JTextField();
		tf_UID.setColumns(10);
		GridBagConstraints gbc_tf_UID = new GridBagConstraints();
		gbc_tf_UID.gridwidth = 5;
		gbc_tf_UID.insets = new Insets(0, 0, 5, 5);
		gbc_tf_UID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_UID.gridx = 1;
		gbc_tf_UID.gridy = 6;
		p_description.add(tf_UID, gbc_tf_UID);
		
		ckbx_application = new JCheckBox("预期应用：");
		ckbx_application.setSelected(true);
		GridBagConstraints gbc_ckbx_application = new GridBagConstraints();
		gbc_ckbx_application.anchor = GridBagConstraints.WEST;
		gbc_ckbx_application.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_application.gridx = 6;
		gbc_ckbx_application.gridy = 6;
		p_description.add(ckbx_application, gbc_ckbx_application);
		
		tf_application = new JTextField();
		hintText hintApplication = new hintText(tf_application, "对地观测成像等");
		tf_application.addFocusListener(new JTextFieldHintListener("对地观测成像等", tf_application));
		tf_application.setColumns(10);
		GridBagConstraints gbc_tf_application = new GridBagConstraints();
		gbc_tf_application.gridwidth = 2;
		gbc_tf_application.insets = new Insets(0, 0, 5, 5);
		gbc_tf_application.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_application.gridx = 7;
		gbc_tf_application.gridy = 6;
		p_description.add(tf_application, gbc_tf_application);
		
		bt_addApplication = new JButton("增加");
		bt_addApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta_application.append(tf_application.getText()+"\n");
				tf_application.setText("");
			}
		});
		GridBagConstraints gbc_bt_addApplication = new GridBagConstraints();
		gbc_bt_addApplication.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addApplication.gridx = 9;
		gbc_bt_addApplication.gridy = 6;
		p_description.add(bt_addApplication, gbc_bt_addApplication);
		
		bt_deleApplication = new JButton("清空");
		bt_deleApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta_application.setText("");
			}
		});
		GridBagConstraints gbc_bt_deleApplication = new GridBagConstraints();
		gbc_bt_deleApplication.insets = new Insets(0, 0, 5, 5);
		gbc_bt_deleApplication.gridx = 10;
		gbc_bt_deleApplication.gridy = 6;
		p_description.add(bt_deleApplication, gbc_bt_deleApplication);
		
		ckbx_longName = new JCheckBox("传感器全称：");
		ckbx_longName.setSelected(true);
		GridBagConstraints gbc_ckbx_longName = new GridBagConstraints();
		gbc_ckbx_longName.anchor = GridBagConstraints.WEST;
		gbc_ckbx_longName.gridwidth = 2;
		gbc_ckbx_longName.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_longName.gridx = 0;
		gbc_ckbx_longName.gridy = 7;
		p_description.add(ckbx_longName, gbc_ckbx_longName);
		
		tf_longName = new JTextField();
		tf_longName.setColumns(10);
		GridBagConstraints gbc_tf_longName = new GridBagConstraints();
		gbc_tf_longName.gridwidth = 4;
		gbc_tf_longName.insets = new Insets(0, 0, 5, 5);
		gbc_tf_longName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_longName.gridx = 2;
		gbc_tf_longName.gridy = 7;
		p_description.add(tf_longName, gbc_tf_longName);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
		gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_4.gridheight = 3;
		gbc_scrollPane_4.gridwidth = 4;
		gbc_scrollPane_4.insets = new Insets(0, 0, 5, 10);
		gbc_scrollPane_4.gridx = 7;
		gbc_scrollPane_4.gridy = 7;
		p_description.add(scrollPane_4, gbc_scrollPane_4);
		
		ta_application = new JTextArea();
		scrollPane_4.setViewportView(ta_application);
		ta_application.setBackground(SystemColor.info);
		
		ckbx_shortName = new JCheckBox("传感器简称：");
		ckbx_shortName.setSelected(true);
		GridBagConstraints gbc_ckbx_shortName = new GridBagConstraints();
		gbc_ckbx_shortName.anchor = GridBagConstraints.WEST;
		gbc_ckbx_shortName.gridwidth = 2;
		gbc_ckbx_shortName.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_shortName.gridx = 0;
		gbc_ckbx_shortName.gridy = 8;
		p_description.add(ckbx_shortName, gbc_ckbx_shortName);
		
		tf_shortName = new JTextField();
		tf_shortName.setColumns(10);
		GridBagConstraints gbc_tf_shortName = new GridBagConstraints();
		gbc_tf_shortName.gridwidth = 4;
		gbc_tf_shortName.insets = new Insets(0, 0, 5, 5);
		gbc_tf_shortName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_shortName.gridx = 2;
		gbc_tf_shortName.gridy = 8;
		p_description.add(tf_shortName, gbc_tf_shortName);
		
		ckbx_parentPlatform = new JCheckBox("所属平台标识：");
		ckbx_parentPlatform.setSelected(true);
		GridBagConstraints gbc_ckbx_parentPlatform = new GridBagConstraints();
		gbc_ckbx_parentPlatform.anchor = GridBagConstraints.WEST;
		gbc_ckbx_parentPlatform.gridwidth = 2;
		gbc_ckbx_parentPlatform.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_parentPlatform.gridx = 0;
		gbc_ckbx_parentPlatform.gridy = 9;
		p_description.add(ckbx_parentPlatform, gbc_ckbx_parentPlatform);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 3;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 6;
		gbc_scrollPane_1.insets = new Insets(0, 10, 5, 5);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 10;
		p_description.add(scrollPane_1, gbc_scrollPane_1);
		
		tb_parentPlatform = new JTable();
		tb_parentPlatform.setBackground(new Color(175, 238, 238));
		tb_parentPlatform.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(tb_parentPlatform);
		tb_parentPlatform.setModel(model_parentPlatform);
		
		tf_parentPlatformName = new JTextField();
		hintText hintPlatformName = new hintText(tf_parentPlatformName, "平台简称");
		tf_parentPlatformName.addFocusListener(new JTextFieldHintListener("平台简称", tf_parentPlatformName));
		tf_parentPlatformName.setColumns(10);
		GridBagConstraints gbc_tf_parentPlatformName = new GridBagConstraints();
		gbc_tf_parentPlatformName.gridwidth = 2;
		gbc_tf_parentPlatformName.insets = new Insets(0, 5, 5, 5);
		gbc_tf_parentPlatformName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_parentPlatformName.gridx = 0;
		gbc_tf_parentPlatformName.gridy = 13;
		p_description.add(tf_parentPlatformName, gbc_tf_parentPlatformName);
		
		tf_parentPlatformID = new JTextField();
		hintText hintPlatformID = new hintText(tf_parentPlatformID, "平台标识符简称");
		tf_parentPlatformID.addFocusListener(new JTextFieldHintListener("平台标识符简称", tf_parentPlatformID));
		tf_parentPlatformID.setColumns(10);
		GridBagConstraints gbc_tf_parentPlatformID = new GridBagConstraints();
		gbc_tf_parentPlatformID.gridwidth = 2;
		gbc_tf_parentPlatformID.insets = new Insets(0, 0, 5, 5);
		gbc_tf_parentPlatformID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_parentPlatformID.gridx = 2;
		gbc_tf_parentPlatformID.gridy = 13;
		p_description.add(tf_parentPlatformID, gbc_tf_parentPlatformID);
		
		bt_addParentPlatform = new JButton("增加");
		bt_addParentPlatform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_parentPlatformName.getText(),tf_parentPlatformID.getText()};
				model_parentPlatform.addRow(info);
				tf_parentPlatformName.setText("");
				tf_parentPlatformID.setText("");
			}
		});
		GridBagConstraints gbc_bt_addParentPlatform = new GridBagConstraints();
		gbc_bt_addParentPlatform.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addParentPlatform.gridx = 4;
		gbc_bt_addParentPlatform.gridy = 13;
		p_description.add(bt_addParentPlatform, gbc_bt_addParentPlatform);
		
		bt_deleParentPlatform = new JButton("删除");
		bt_deleParentPlatform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_parentPlatform.getSelectedRow();
				if (selectedRow != -1) {
					model_parentPlatform.removeRow(selectedRow);
				}
			}
		});
		GridBagConstraints gbc_bt_deleParentPlatform = new GridBagConstraints();
		gbc_bt_deleParentPlatform.insets = new Insets(0, 0, 5, 5);
		gbc_bt_deleParentPlatform.gridx = 5;
		gbc_bt_deleParentPlatform.gridy = 13;
		p_description.add(bt_deleParentPlatform, gbc_bt_deleParentPlatform);
		
		ckbx_otherIdentifier = new JCheckBox("添加其它标识：");
		ckbx_otherIdentifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_otherIdentifier.isSelected()) {
					tf_otherIdentifierName.setEditable(true);
					tf_otherIDentifierContent.setEditable(true);
					tf_otherIdentifierName.setBackground(white);
					tf_otherIDentifierContent.setBackground(white);
					bt_addIdentifier.setEnabled(true);
					bt_deleIdentifier.setEnabled(true);
				}else {
					tf_otherIdentifierName.setEditable(false);
					tf_otherIDentifierContent.setEditable(false);
					tf_otherIdentifierName.setBackground(Grey);
					tf_otherIDentifierContent.setBackground(Grey);
					bt_addIdentifier.setEnabled(false);
					bt_deleIdentifier.setEnabled(false);
					tf_otherIdentifierName.setText("");
					tf_otherIDentifierContent.setText("");
					model_otherIdentifier.setRowCount(0);
				}
			}
		});
		GridBagConstraints gbc_ckbx_otherIdentifier = new GridBagConstraints();
		gbc_ckbx_otherIdentifier.anchor = GridBagConstraints.WEST;
		gbc_ckbx_otherIdentifier.gridwidth = 2;
		gbc_ckbx_otherIdentifier.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_otherIdentifier.gridx = 0;
		gbc_ckbx_otherIdentifier.gridy = 14;
		p_description.add(ckbx_otherIdentifier, gbc_ckbx_otherIdentifier);
		
		ckbx_otherclassifier = new JCheckBox("添加其它分类：");
		ckbx_otherclassifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_otherclassifier.isSelected()) {
					tf_otherClassifierContent.setEditable(true);
					tf_otherClassifierName.setEditable(true);
					tf_otherClassifierName.setBackground(white);
					tf_otherClassifierContent.setBackground(white);
					bt_addClassifier.setEnabled(true);
					bt_deleClassifier.setEnabled(true);
				}else {
					tf_otherClassifierContent.setEditable(false);
					tf_otherClassifierName.setEditable(false);
					tf_otherClassifierName.setBackground(Grey);
					tf_otherClassifierContent.setBackground(Grey);
					bt_addClassifier.setEnabled(false);
					bt_deleClassifier.setEnabled(false);
					tf_otherClassifierName.setText("");
					tf_otherClassifierContent.setText("");
					model_otherClassifier.setRowCount(0);
				}
			}
		});
		GridBagConstraints gbc_ckbx_otherclassifier = new GridBagConstraints();
		gbc_ckbx_otherclassifier.gridwidth = 2;
		gbc_ckbx_otherclassifier.anchor = GridBagConstraints.WEST;
		gbc_ckbx_otherclassifier.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_otherclassifier.gridx = 6;
		gbc_ckbx_otherclassifier.gridy = 14;
		p_description.add(ckbx_otherclassifier, gbc_ckbx_otherclassifier);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridheight = 3;
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridwidth = 6;
		gbc_scrollPane_2.insets = new Insets(0, 10, 5, 5);
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 15;
		p_description.add(scrollPane_2, gbc_scrollPane_2);
		
		tb_otherIdentifier = new JTable();
		tb_otherIdentifier.setBackground(new Color(175, 238, 238));
		tb_otherIdentifier.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_2.setViewportView(tb_otherIdentifier);
		tb_otherIdentifier.setModel(model_otherIdentifier);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.gridheight = 3;
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridwidth = 5;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 10);
		gbc_scrollPane_3.gridx = 6;
		gbc_scrollPane_3.gridy = 15;
		p_description.add(scrollPane_3, gbc_scrollPane_3);
		
		tb_otherClassifier = new JTable();
		tb_otherClassifier.setBackground(new Color(175, 238, 238));
		tb_otherClassifier.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_3.setViewportView(tb_otherClassifier);
		tb_otherClassifier.setModel(model_otherClassifier);
		
		tf_otherIdentifierName = new JTextField();
		tf_otherIdentifierName.setEditable(false);
		tf_otherIdentifierName.setColumns(10);
		GridBagConstraints gbc_tf_otherIdentifierName = new GridBagConstraints();
		gbc_tf_otherIdentifierName.gridwidth = 2;
		gbc_tf_otherIdentifierName.insets = new Insets(0, 5, 0, 5);
		gbc_tf_otherIdentifierName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherIdentifierName.gridx = 0;
		gbc_tf_otherIdentifierName.gridy = 18;
		p_description.add(tf_otherIdentifierName, gbc_tf_otherIdentifierName);
		
		tf_otherIDentifierContent = new JTextField();
		tf_otherIDentifierContent.setEditable(false);
		tf_otherIDentifierContent.setColumns(10);
		GridBagConstraints gbc_tf_otherIDentifierContent = new GridBagConstraints();
		gbc_tf_otherIDentifierContent.gridwidth = 2;
		gbc_tf_otherIDentifierContent.insets = new Insets(0, 0, 0, 5);
		gbc_tf_otherIDentifierContent.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherIDentifierContent.gridx = 2;
		gbc_tf_otherIDentifierContent.gridy = 18;
		p_description.add(tf_otherIDentifierContent, gbc_tf_otherIDentifierContent);
		
		bt_addIdentifier = new JButton("增加");
		bt_addIdentifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_otherIdentifierName.getText(),tf_otherIDentifierContent.getText()};
				model_otherIdentifier.addRow(info);
				tf_otherIDentifierContent.setText("");
				tf_otherIdentifierName.setText("");
			}
		});
		bt_addIdentifier.setEnabled(false);
		GridBagConstraints gbc_bt_addIdentifier = new GridBagConstraints();
		gbc_bt_addIdentifier.insets = new Insets(0, 0, 0, 5);
		gbc_bt_addIdentifier.gridx = 4;
		gbc_bt_addIdentifier.gridy = 18;
		p_description.add(bt_addIdentifier, gbc_bt_addIdentifier);
		
		bt_deleIdentifier = new JButton("删除");
		bt_deleIdentifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_otherIdentifier.getSelectedRow();
				if (selectedRow != -1) {
					model_otherIdentifier.removeRow(selectedRow);
				}
			}
		});
		bt_deleIdentifier.setEnabled(false);
		GridBagConstraints gbc_bt_deleIdentifier = new GridBagConstraints();
		gbc_bt_deleIdentifier.insets = new Insets(0, 0, 0, 5);
		gbc_bt_deleIdentifier.gridx = 5;
		gbc_bt_deleIdentifier.gridy = 18;
		p_description.add(bt_deleIdentifier, gbc_bt_deleIdentifier);
		
		tf_otherClassifierName = new JTextField();
		tf_otherClassifierName.setEditable(false);
		tf_otherClassifierName.setColumns(10);
		GridBagConstraints gbc_tf_otherClassifierName = new GridBagConstraints();
		gbc_tf_otherClassifierName.insets = new Insets(0, 0, 0, 5);
		gbc_tf_otherClassifierName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherClassifierName.gridx = 6;
		gbc_tf_otherClassifierName.gridy = 18;
		p_description.add(tf_otherClassifierName, gbc_tf_otherClassifierName);
		
		tf_otherClassifierContent = new JTextField();
		tf_otherClassifierContent.setEditable(false);
		tf_otherClassifierContent.setColumns(10);
		GridBagConstraints gbc_tf_otherClassifierContent = new GridBagConstraints();
		gbc_tf_otherClassifierContent.gridwidth = 2;
		gbc_tf_otherClassifierContent.insets = new Insets(0, 0, 0, 5);
		gbc_tf_otherClassifierContent.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherClassifierContent.gridx = 7;
		gbc_tf_otherClassifierContent.gridy = 18;
		p_description.add(tf_otherClassifierContent, gbc_tf_otherClassifierContent);
		
		bt_addClassifier = new JButton("增加");
		bt_addClassifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_otherClassifierName.getText(),tf_otherClassifierContent.getText()};
				model_otherClassifier.addRow(info);
				tf_otherClassifierName.setText("");
				tf_otherClassifierContent.setText("");
			}
		});
		bt_addClassifier.setEnabled(false);
		GridBagConstraints gbc_bt_addClassifier = new GridBagConstraints();
		gbc_bt_addClassifier.insets = new Insets(0, 0, 0, 5);
		gbc_bt_addClassifier.gridx = 9;
		gbc_bt_addClassifier.gridy = 18;
		p_description.add(bt_addClassifier, gbc_bt_addClassifier);
		
		bt_deleClassifier = new JButton("删除");
		bt_deleClassifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_otherClassifier.getSelectedRow();
				if (selectedRow != -1) {
					model_otherClassifier.removeRow(selectedRow);
				}
			}
		});
		bt_deleClassifier.setEnabled(false);
		GridBagConstraints gbc_bt_deleClassifier = new GridBagConstraints();
		gbc_bt_deleClassifier.insets = new Insets(0, 0, 0, 10);
		gbc_bt_deleClassifier.gridx = 10;
		gbc_bt_deleClassifier.gridy = 18;
		p_description.add(bt_deleClassifier, gbc_bt_deleClassifier);
		
		p_constraint = new JPanel();
		tp_content.addTab("约束条件信息", null, p_constraint, null);
		GridBagLayout gbl_p_constraint = new GridBagLayout();
		gbl_p_constraint.columnWidths = new int[]{0, 0, 0};
		gbl_p_constraint.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_p_constraint.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_p_constraint.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		p_constraint.setLayout(gbl_p_constraint);
		
		ckbx_validTM = new JCheckBox("有效时间");
		ckbx_validTM.setSelected(true);
		GridBagConstraints gbc_ckbx_validTM = new GridBagConstraints();
		gbc_ckbx_validTM.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_validTM.gridx = 0;
		gbc_ckbx_validTM.gridy = 0;
		p_constraint.add(ckbx_validTM, gbc_ckbx_validTM);
		
		JLabel lb_beginTM = new JLabel("起始时间:");
		GridBagConstraints gbc_lb_beginTM = new GridBagConstraints();
		gbc_lb_beginTM.anchor = GridBagConstraints.EAST;
		gbc_lb_beginTM.insets = new Insets(0, 0, 5, 5);
		gbc_lb_beginTM.gridx = 0;
		gbc_lb_beginTM.gridy = 1;
		p_constraint.add(lb_beginTM, gbc_lb_beginTM);
		
		cbbx_beginTM = new JComboBox();
		cbbx_beginTM.setModel(new DefaultComboBoxModel(new String[] {"确定时间点", "不定时间点"}));
		cbbx_beginTM.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cbbx_beginTM.getSelectedItem().equals("确定时间点")) {
					tf_beginTM.setEditable(true);
					tf_beginTM.setBackground(white);
				}else if (cbbx_beginTM.getSelectedItem().equals("不定时间点")) {
					tf_beginTM.setEditable(false);
					tf_beginTM.setBackground(Grey);
					tf_beginTM.setText("");
				}
			}
		});
		GridBagConstraints gbc_cbbx_beginTM = new GridBagConstraints();
		gbc_cbbx_beginTM.insets = new Insets(0, 0, 5, 30);
		gbc_cbbx_beginTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbx_beginTM.gridx = 1;
		gbc_cbbx_beginTM.gridy = 1;
		p_constraint.add(cbbx_beginTM, gbc_cbbx_beginTM);
		
		tf_beginTM = new JTextField();
		hintText bgTMHint = new hintText(tf_beginTM, "2018-01-01T08:00:00.0Z");
		tf_beginTM.addFocusListener(new JTextFieldHintListener("2018-01-01T08:00:00.0Z", tf_beginTM));
		tf_beginTM.setColumns(10);
		GridBagConstraints gbc_tf_beginTM = new GridBagConstraints();
		gbc_tf_beginTM.insets = new Insets(0, 0, 5, 30);
		gbc_tf_beginTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_beginTM.gridx = 1;
		gbc_tf_beginTM.gridy = 2;
		p_constraint.add(tf_beginTM, gbc_tf_beginTM);
		
		JLabel lb_endTM = new JLabel("结束时间:");
		GridBagConstraints gbc_lb_endTM = new GridBagConstraints();
		gbc_lb_endTM.anchor = GridBagConstraints.EAST;
		gbc_lb_endTM.insets = new Insets(0, 0, 5, 5);
		gbc_lb_endTM.gridx = 0;
		gbc_lb_endTM.gridy = 3;
		p_constraint.add(lb_endTM, gbc_lb_endTM);
		
		cbbx_endTM = new JComboBox();
		cbbx_endTM.setModel(new DefaultComboBoxModel(new String[] {"确定时间点", "不定时间点"}));
		cbbx_endTM.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cbbx_endTM.getSelectedItem().equals("确定时间点")) {
					tf_endTM.setEditable(true);
					tf_endTM.setBackground(white);
				}else if (cbbx_endTM.getSelectedItem().equals("不定时间点")) {
					tf_endTM.setEditable(false);
					tf_endTM.setBackground(Grey);
					tf_endTM.setText("");
				}	
			}
		});
		GridBagConstraints gbc_cbbx_endTM = new GridBagConstraints();
		gbc_cbbx_endTM.insets = new Insets(0, 0, 5, 30);
		gbc_cbbx_endTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbx_endTM.gridx = 1;
		gbc_cbbx_endTM.gridy = 3;
		p_constraint.add(cbbx_endTM, gbc_cbbx_endTM);
		
		tf_endTM = new JTextField();
		hintText edTMHint = new hintText(tf_endTM, "2020-01-01T08:00:00.0Z");
		tf_endTM.addFocusListener(new JTextFieldHintListener("2020-01-01T08:00:00.0Z", tf_endTM));
		tf_endTM.setColumns(10);
		tf_endTM.setColumns(10);
		GridBagConstraints gbc_tf_endTM = new GridBagConstraints();
		gbc_tf_endTM.insets = new Insets(0, 0, 5, 30);
		gbc_tf_endTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_endTM.gridx = 1;
		gbc_tf_endTM.gridy = 4;
		p_constraint.add(tf_endTM, gbc_tf_endTM);
		
		ckbx_legalConstraint = new JCheckBox("法律约束概述");
		ckbx_legalConstraint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_legalConstraint.isSelected()) {
					ta_legalConstraint.setEditable(true);
					ta_legalConstraint.setBackground(white);
				}else {
					ta_legalConstraint.setEditable(false);
					ta_legalConstraint.setBackground(Grey);
					ta_legalConstraint.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_legalConstraint = new GridBagConstraints();
		gbc_ckbx_legalConstraint.insets = new Insets(0, 20, 5, 5);
		gbc_ckbx_legalConstraint.gridx = 0;
		gbc_ckbx_legalConstraint.gridy = 5;
		p_constraint.add(ckbx_legalConstraint, gbc_ckbx_legalConstraint);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_6 = new GridBagConstraints();
		gbc_scrollPane_6.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_6.gridwidth = 2;
		gbc_scrollPane_6.insets = new Insets(0, 30, 5, 30);
		gbc_scrollPane_6.gridx = 0;
		gbc_scrollPane_6.gridy = 6;
		p_constraint.add(scrollPane_6, gbc_scrollPane_6);
		
		ta_legalConstraint = new JTextArea();
		ta_legalConstraint.setBackground(Grey);
		ta_legalConstraint.setEditable(false);
		scrollPane_6.setViewportView(ta_legalConstraint);
		
		ckbx_securityConstraint = new JCheckBox("安全约束概述");
		ckbx_securityConstraint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_securityConstraint.isSelected()) {
					ta_securityConstraint.setEditable(true);
					ta_securityConstraint.setBackground(white);
				}else {
					ta_securityConstraint.setEditable(false);
					ta_securityConstraint.setBackground(Grey);
					ta_securityConstraint.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_securityConstraint = new GridBagConstraints();
		gbc_ckbx_securityConstraint.insets = new Insets(0, 20, 5, 5);
		gbc_ckbx_securityConstraint.gridx = 0;
		gbc_ckbx_securityConstraint.gridy = 7;
		p_constraint.add(ckbx_securityConstraint, gbc_ckbx_securityConstraint);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_7 = new GridBagConstraints();
		gbc_scrollPane_7.insets = new Insets(0, 30, 5, 30);
		gbc_scrollPane_7.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_7.gridwidth = 2;
		gbc_scrollPane_7.gridx = 0;
		gbc_scrollPane_7.gridy = 8;
		p_constraint.add(scrollPane_7, gbc_scrollPane_7);
		
		ta_securityConstraint = new JTextArea();
		ta_securityConstraint.setBackground(Grey);
		ta_securityConstraint.setEditable(false);
		scrollPane_7.setViewportView(ta_securityConstraint);
		
		p_capability = new JPanel();
		tp_content.addTab("特征能力信息", null, p_capability, null);
		GridBagLayout gbl_p_capability = new GridBagLayout();
		gbl_p_capability.columnWidths = new int[]{0, 0};
		gbl_p_capability.rowHeights = new int[]{0, 0};
		gbl_p_capability.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_p_capability.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		p_capability.setLayout(gbl_p_capability);
		
		tp_capa = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tp_capa = new GridBagConstraints();
		gbc_tp_capa.fill = GridBagConstraints.BOTH;
		gbc_tp_capa.gridx = 0;
		gbc_tp_capa.gridy = 0;
		p_capability.add(tp_capa, gbc_tp_capa);
		
		p_character = new JPanel();
		tp_capa.addTab("传感器物理特征", null, p_character, null);
		GridBagLayout gbl_p_character = new GridBagLayout();
		gbl_p_character.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_p_character.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_p_character.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_p_character.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		p_character.setLayout(gbl_p_character);
		
		JLabel lb_physicalCharacter = new JLabel(" 传感器物理特征");
		lb_physicalCharacter.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_physicalCharacter = new GridBagConstraints();
		gbc_lb_physicalCharacter.insets = new Insets(5, 5, 5, 5);
		gbc_lb_physicalCharacter.gridx = 0;
		gbc_lb_physicalCharacter.gridy = 0;
		p_character.add(lb_physicalCharacter, gbc_lb_physicalCharacter);
		
		JLabel lb_workEnviroment = new JLabel("工作环境");
		lb_workEnviroment.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_workEnviroment = new GridBagConstraints();
		gbc_lb_workEnviroment.insets = new Insets(0, 0, 5, 5);
		gbc_lb_workEnviroment.gridx = 4;
		gbc_lb_workEnviroment.gridy = 0;
		p_character.add(lb_workEnviroment, gbc_lb_workEnviroment);
		
		ckbx_length = new JCheckBox("长度(m):");
		ckbx_length.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_length.isSelected()) {
					tf_length.setEditable(true);
					tf_length.setBackground(white);
				}else {
					tf_length.setEditable(false);
					tf_length.setBackground(Grey);
					tf_length.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_length = new GridBagConstraints();
		gbc_ckbx_length.anchor = GridBagConstraints.WEST;
		gbc_ckbx_length.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_length.gridx = 0;
		gbc_ckbx_length.gridy = 1;
		p_character.add(ckbx_length, gbc_ckbx_length);
		
		tf_length = new JTextField();
		tf_length.setEditable(false);
		tf_length.setColumns(10);
		GridBagConstraints gbc_tf_length = new GridBagConstraints();
		gbc_tf_length.gridwidth = 3;
		gbc_tf_length.insets = new Insets(0, 0, 5, 5);
		gbc_tf_length.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_length.gridx = 1;
		gbc_tf_length.gridy = 1;
		p_character.add(tf_length, gbc_tf_length);
		
		ckbx_life = new JCheckBox("设计寿命(year):");
		ckbx_life.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_life.isSelected()) {
					tf_life.setEditable(true);
					tf_life.setBackground(white);
				}else {
					tf_life.setEditable(false);
					tf_life.setBackground(Grey);
					tf_life.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_life = new GridBagConstraints();
		gbc_ckbx_life.anchor = GridBagConstraints.WEST;
		gbc_ckbx_life.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_life.gridx = 4;
		gbc_ckbx_life.gridy = 1;
		p_character.add(ckbx_life, gbc_ckbx_life);
		
		tf_life = new JTextField();
		tf_life.setEditable(false);
		tf_life.setColumns(10);
		GridBagConstraints gbc_tf_life = new GridBagConstraints();
		gbc_tf_life.gridwidth = 3;
		gbc_tf_life.insets = new Insets(0, 0, 5, 10);
		gbc_tf_life.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_life.gridx = 5;
		gbc_tf_life.gridy = 1;
		p_character.add(tf_life, gbc_tf_life);
		
		ckbx_width = new JCheckBox("宽度(m):");
		ckbx_width.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_width.isSelected()) {
					tf_width.setEditable(true);
					tf_width.setBackground(white);
				}else {
					tf_width.setEditable(false);
					tf_width.setBackground(Grey);
					tf_width.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_width = new GridBagConstraints();
		gbc_ckbx_width.anchor = GridBagConstraints.WEST;
		gbc_ckbx_width.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_width.gridx = 0;
		gbc_ckbx_width.gridy = 2;
		p_character.add(ckbx_width, gbc_ckbx_width);
		
		tf_width = new JTextField();
		tf_width.setEditable(false);
		tf_width.setColumns(10);
		GridBagConstraints gbc_tf_width = new GridBagConstraints();
		gbc_tf_width.gridwidth = 3;
		gbc_tf_width.insets = new Insets(0, 0, 5, 5);
		gbc_tf_width.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_width.gridx = 1;
		gbc_tf_width.gridy = 2;
		p_character.add(tf_width, gbc_tf_width);
		
		ckbx_height = new JCheckBox("高度(m):");
		ckbx_height.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_height.isSelected()) {
					tf_height.setEditable(true);
					tf_height.setBackground(white);
				}else {
					tf_height.setEditable(false);
					tf_height.setBackground(Grey);
					tf_height.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_height = new GridBagConstraints();
		gbc_ckbx_height.anchor = GridBagConstraints.WEST;
		gbc_ckbx_height.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_height.gridx = 0;
		gbc_ckbx_height.gridy = 3;
		p_character.add(ckbx_height, gbc_ckbx_height);
		
		tf_height = new JTextField();
		tf_height.setEditable(false);
		tf_height.setColumns(10);
		GridBagConstraints gbc_tf_height = new GridBagConstraints();
		gbc_tf_height.gridwidth = 3;
		gbc_tf_height.insets = new Insets(0, 0, 5, 5);
		gbc_tf_height.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_height.gridx = 1;
		gbc_tf_height.gridy = 3;
		p_character.add(tf_height, gbc_tf_height);
		
		ckbx_weight = new JCheckBox("质量(kg):");
		ckbx_weight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_weight.isSelected()) {
					tf_weight.setEditable(true);
					tf_weight.setBackground(white);
				}else {
					tf_weight.setEditable(false);
					tf_weight.setBackground(Grey);
					tf_weight.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_weight = new GridBagConstraints();
		gbc_ckbx_weight.anchor = GridBagConstraints.WEST;
		gbc_ckbx_weight.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_weight.gridx = 0;
		gbc_ckbx_weight.gridy = 4;
		p_character.add(ckbx_weight, gbc_ckbx_weight);
		
		tf_weight = new JTextField();
		tf_weight.setEditable(false);
		tf_weight.setColumns(10);
		GridBagConstraints gbc_tf_weight = new GridBagConstraints();
		gbc_tf_weight.gridwidth = 3;
		gbc_tf_weight.insets = new Insets(0, 0, 5, 5);
		gbc_tf_weight.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_weight.gridx = 1;
		gbc_tf_weight.gridy = 4;
		p_character.add(tf_weight, gbc_tf_weight);
		
		JLabel lb_electrical = new JLabel("  供电通信特征");
		lb_electrical.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_electrical = new GridBagConstraints();
		gbc_lb_electrical.insets = new Insets(0, 0, 5, 5);
		gbc_lb_electrical.gridx = 0;
		gbc_lb_electrical.gridy = 6;
		p_character.add(lb_electrical, gbc_lb_electrical);
		
		ckbx_otherCharacter = new JCheckBox("添加其他特征:");
		GridBagConstraints gbc_ckbx_otherCharacter = new GridBagConstraints();
		gbc_ckbx_otherCharacter.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_otherCharacter.gridx = 4;
		gbc_ckbx_otherCharacter.gridy = 6;
		p_character.add(ckbx_otherCharacter, gbc_ckbx_otherCharacter);
		
		ckbx_current = new JCheckBox("电流(A):");
		ckbx_current.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_current.isSelected()) {
					tf_minCurrent.setEditable(true);
					tf_maxCurrent.setEditable(true);
					tf_minCurrent.setBackground(white);
					tf_maxCurrent.setBackground(white);
				}else {
					tf_minCurrent.setEditable(false);
					tf_maxCurrent.setEditable(false);
					tf_minCurrent.setBackground(Grey);
					tf_maxCurrent.setBackground(Grey);
					tf_minCurrent.setText("");
					tf_maxCurrent.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_current = new GridBagConstraints();
		gbc_ckbx_current.anchor = GridBagConstraints.WEST;
		gbc_ckbx_current.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_current.gridx = 0;
		gbc_ckbx_current.gridy = 7;
		p_character.add(ckbx_current, gbc_ckbx_current);
		
		tf_minCurrent = new JTextField();
		tf_minCurrent.setEditable(false);
		tf_minCurrent.setColumns(10);
		GridBagConstraints gbc_tf_minCurrent = new GridBagConstraints();
		gbc_tf_minCurrent.insets = new Insets(0, 0, 5, 5);
		gbc_tf_minCurrent.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_minCurrent.gridx = 1;
		gbc_tf_minCurrent.gridy = 7;
		p_character.add(tf_minCurrent, gbc_tf_minCurrent);
		
		JLabel lb_line1 = new JLabel("—");
		GridBagConstraints gbc_lb_line1 = new GridBagConstraints();
		gbc_lb_line1.insets = new Insets(0, 0, 5, 5);
		gbc_lb_line1.anchor = GridBagConstraints.EAST;
		gbc_lb_line1.gridx = 2;
		gbc_lb_line1.gridy = 7;
		p_character.add(lb_line1, gbc_lb_line1);
		
		tf_maxCurrent = new JTextField();
		tf_maxCurrent.setEditable(false);
		tf_maxCurrent.setColumns(10);
		GridBagConstraints gbc_tf_maxCurrent = new GridBagConstraints();
		gbc_tf_maxCurrent.insets = new Insets(0, 0, 5, 5);
		gbc_tf_maxCurrent.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_maxCurrent.gridx = 3;
		gbc_tf_maxCurrent.gridy = 7;
		p_character.add(tf_maxCurrent, gbc_tf_maxCurrent);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_8 = new GridBagConstraints();
		gbc_scrollPane_8.gridheight = 3;
		gbc_scrollPane_8.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_8.gridwidth = 4;
		gbc_scrollPane_8.insets = new Insets(0, 0, 5, 10);
		gbc_scrollPane_8.gridx = 4;
		gbc_scrollPane_8.gridy = 7;
		p_character.add(scrollPane_8, gbc_scrollPane_8);
		
		tb_otherCharacter = new JTable();
		tb_otherCharacter.setBackground(new Color(175, 238, 238));
		scrollPane_8.setViewportView(tb_otherCharacter);
		model_otherCharacter = new DefaultTableModel(new Object[][] {},new String[] {"字段名称", "字段内容"});
		tb_otherCharacter.setModel(model_otherCharacter);
		tb_otherCharacter.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ckbx_voltage = new JCheckBox("电压(V):");
		ckbx_voltage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_voltage.isSelected()) {
					tf_minVoltage.setEditable(true);
					tf_maxVoltage.setEditable(true);
					tf_minVoltage.setBackground(white);
					tf_maxVoltage.setBackground(white);
				}else {
					tf_minVoltage.setEditable(false);
					tf_maxVoltage.setEditable(false);
					tf_minVoltage.setBackground(Grey);
					tf_maxVoltage.setBackground(Grey);
					tf_minVoltage.setText("");
					tf_maxVoltage.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_voltage = new GridBagConstraints();
		gbc_ckbx_voltage.anchor = GridBagConstraints.WEST;
		gbc_ckbx_voltage.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_voltage.gridx = 0;
		gbc_ckbx_voltage.gridy = 8;
		p_character.add(ckbx_voltage, gbc_ckbx_voltage);
		
		tf_minVoltage = new JTextField();
		tf_minVoltage.setEditable(false);
		tf_minVoltage.setColumns(10);
		GridBagConstraints gbc_tf_minVoltage = new GridBagConstraints();
		gbc_tf_minVoltage.insets = new Insets(0, 0, 5, 5);
		gbc_tf_minVoltage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_minVoltage.gridx = 1;
		gbc_tf_minVoltage.gridy = 8;
		p_character.add(tf_minVoltage, gbc_tf_minVoltage);
		
		JLabel lb_line2 = new JLabel("—");
		GridBagConstraints gbc_lb_line2 = new GridBagConstraints();
		gbc_lb_line2.insets = new Insets(0, 0, 5, 5);
		gbc_lb_line2.anchor = GridBagConstraints.EAST;
		gbc_lb_line2.gridx = 2;
		gbc_lb_line2.gridy = 8;
		p_character.add(lb_line2, gbc_lb_line2);
		
		tf_maxVoltage = new JTextField();
		tf_maxVoltage.setEditable(false);
		tf_maxVoltage.setColumns(10);
		GridBagConstraints gbc_tf_maxVoltage = new GridBagConstraints();
		gbc_tf_maxVoltage.insets = new Insets(0, 0, 5, 5);
		gbc_tf_maxVoltage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_maxVoltage.gridx = 3;
		gbc_tf_maxVoltage.gridy = 8;
		p_character.add(tf_maxVoltage, gbc_tf_maxVoltage);
		
		ckbx_power = new JCheckBox("功率(W):");
		ckbx_power.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_power.isSelected()) {
					tf_power.setEditable(true);
					tf_power.setBackground(white);
				}else {
					tf_power.setEditable(false);
					tf_power.setBackground(Grey);
					tf_power.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_power = new GridBagConstraints();
		gbc_ckbx_power.anchor = GridBagConstraints.WEST;
		gbc_ckbx_power.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_power.gridx = 0;
		gbc_ckbx_power.gridy = 9;
		p_character.add(ckbx_power, gbc_ckbx_power);
		
		tf_power = new JTextField();
		tf_power.setEditable(false);
		tf_power.setColumns(10);
		GridBagConstraints gbc_tf_power = new GridBagConstraints();
		gbc_tf_power.gridwidth = 3;
		gbc_tf_power.insets = new Insets(0, 0, 5, 5);
		gbc_tf_power.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_power.gridx = 1;
		gbc_tf_power.gridy = 9;
		p_character.add(tf_power, gbc_tf_power);
		
		ckbx_outputPower = new JCheckBox("输出功率(W):");
		ckbx_outputPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_outputPower.isSelected()) {
					tf_outputPower.setEditable(true);
					tf_outputPower.setBackground(white);
				}else {
					tf_outputPower.setEditable(false);
					tf_outputPower.setBackground(Grey);
					tf_outputPower.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_outputPower = new GridBagConstraints();
		gbc_ckbx_outputPower.anchor = GridBagConstraints.WEST;
		gbc_ckbx_outputPower.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_outputPower.gridx = 0;
		gbc_ckbx_outputPower.gridy = 10;
		p_character.add(ckbx_outputPower, gbc_ckbx_outputPower);
		
		tf_outputPower = new JTextField();
		tf_outputPower.setEditable(false);
		tf_outputPower.setColumns(10);
		GridBagConstraints gbc_tf_outputPower = new GridBagConstraints();
		gbc_tf_outputPower.gridwidth = 3;
		gbc_tf_outputPower.insets = new Insets(0, 0, 5, 5);
		gbc_tf_outputPower.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_outputPower.gridx = 1;
		gbc_tf_outputPower.gridy = 10;
		p_character.add(tf_outputPower, gbc_tf_outputPower);
		
		tf_otherCharacterName = new JTextField();
		tf_otherCharacterName.setEditable(false);
		tf_otherCharacterName.setColumns(10);
		GridBagConstraints gbc_tf_otherCharacterName = new GridBagConstraints();
		gbc_tf_otherCharacterName.insets = new Insets(0, 0, 5, 5);
		gbc_tf_otherCharacterName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherCharacterName.gridx = 4;
		gbc_tf_otherCharacterName.gridy = 10;
		p_character.add(tf_otherCharacterName, gbc_tf_otherCharacterName);
		
		tf_otherCharacterValue = new JTextField();
		tf_otherCharacterValue.setEditable(false);
		tf_otherCharacterValue.setColumns(10);
		GridBagConstraints gbc_tf_otherCharacterValue = new GridBagConstraints();
		gbc_tf_otherCharacterValue.insets = new Insets(0, 0, 5, 5);
		gbc_tf_otherCharacterValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherCharacterValue.gridx = 5;
		gbc_tf_otherCharacterValue.gridy = 10;
		p_character.add(tf_otherCharacterValue, gbc_tf_otherCharacterValue);
		
		bt_addOtherCharacter = new JButton("增加");
		bt_addOtherCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_otherCharacterName.getText(),tf_otherCharacterValue.getText()};
				model_otherCharacter.addRow(info);
				tf_otherCharacterName.setText("");
				tf_otherCharacterValue.setText("");
			}
		});
		bt_addOtherCharacter.setEnabled(false);
		GridBagConstraints gbc_bt_addOtherCharacter = new GridBagConstraints();
		gbc_bt_addOtherCharacter.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addOtherCharacter.gridx = 6;
		gbc_bt_addOtherCharacter.gridy = 10;
		p_character.add(bt_addOtherCharacter, gbc_bt_addOtherCharacter);
		
		bt_deleOtherCharacter = new JButton("删除");
		bt_deleOtherCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_otherCharacter.getSelectedRow();
				if (selectedRow != -1) {
					model_otherCharacter.removeRow(selectedRow);
				}
			}
		});
		bt_deleOtherCharacter.setEnabled(false);
		GridBagConstraints gbc_bt_deleOtherCharacter = new GridBagConstraints();
		gbc_bt_deleOtherCharacter.insets = new Insets(0, 0, 5, 5);
		gbc_bt_deleOtherCharacter.gridx = 7;
		gbc_bt_deleOtherCharacter.gridy = 10;
		p_character.add(bt_deleOtherCharacter, gbc_bt_deleOtherCharacter);
		ckbx_otherCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_otherCharacter.isSelected()) {
					tf_otherCharacterName.setEditable(true);
					tf_otherCharacterValue.setEditable(true);
					tf_otherCharacterName.setBackground(white);
					tf_otherCharacterValue.setBackground(white);
					bt_addOtherCharacter.setEnabled(true);
					bt_deleOtherCharacter.setEnabled(true);
				}else {
					tf_otherCharacterName.setEditable(false);
					tf_otherCharacterValue.setEditable(false);
					tf_otherCharacterName.setBackground(Grey);
					tf_otherCharacterValue.setBackground(Grey);
					tf_otherCharacterName.setText("");
					tf_otherCharacterValue.setText("");
					bt_addOtherCharacter.setEnabled(false);
					bt_deleOtherCharacter.setEnabled(false);
					model_otherCharacter.setRowCount(0);
				}
			}
		});
		
		p_capabilities = new JPanel();
		tp_capa.addTab("传感器观测能力", null, p_capabilities, null);
		GridBagLayout gbl_p_capabilities = new GridBagLayout();
		gbl_p_capabilities.columnWidths = new int[]{0, 55, 98, 34, 97, 113, 0, 0, 0, 0, 0};
		gbl_p_capabilities.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 23, 26, 0, 0, 0, 0};
		gbl_p_capabilities.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_p_capabilities.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		p_capabilities.setLayout(gbl_p_capabilities);
		
		JLabel lb_capaBreadth = new JLabel("观测能力广度");
		lb_capaBreadth.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_capaBreadth = new GridBagConstraints();
		gbc_lb_capaBreadth.gridwidth = 2;
		gbc_lb_capaBreadth.insets = new Insets(5, 5, 5, 5);
		gbc_lb_capaBreadth.gridx = 0;
		gbc_lb_capaBreadth.gridy = 0;
		p_capabilities.add(lb_capaBreadth, gbc_lb_capaBreadth);
		
		JLabel lb_obsFrequency = new JLabel("观测能力频度");
		lb_obsFrequency.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_obsFrequency = new GridBagConstraints();
		gbc_lb_obsFrequency.gridwidth = 2;
		gbc_lb_obsFrequency.insets = new Insets(0, 0, 5, 5);
		gbc_lb_obsFrequency.gridx = 5;
		gbc_lb_obsFrequency.gridy = 0;
		p_capabilities.add(lb_obsFrequency, gbc_lb_obsFrequency);
		
		JCheckBox ckbx_bandsCategory = new JCheckBox("波段类别:");
		ckbx_bandsCategory.setSelected(true);
		GridBagConstraints gbc_ckbx_bandsCategory = new GridBagConstraints();
		gbc_ckbx_bandsCategory.anchor = GridBagConstraints.WEST;
		gbc_ckbx_bandsCategory.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_bandsCategory.gridx = 0;
		gbc_ckbx_bandsCategory.gridy = 1;
		p_capabilities.add(ckbx_bandsCategory, gbc_ckbx_bandsCategory);
		
		tf_bandsCategory = new JTextField();
		hintText hintBandCategory = new hintText(tf_bandsCategory, "VIS/NIR/SWIR/MWIR/TIR等");
		tf_bandsCategory.addFocusListener(new JTextFieldHintListener("VIS/NIR/SWIR/MWIR/TIR等", tf_bandsCategory));
		tf_bandsCategory.setColumns(10);
		GridBagConstraints gbc_tf_bandsCategory = new GridBagConstraints();
		gbc_tf_bandsCategory.gridwidth = 4;
		gbc_tf_bandsCategory.insets = new Insets(0, 0, 5, 5);
		gbc_tf_bandsCategory.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_bandsCategory.gridx = 1;
		gbc_tf_bandsCategory.gridy = 1;
		p_capabilities.add(tf_bandsCategory, gbc_tf_bandsCategory);
		
		ckbx_bandsRange = new JCheckBox("波段范围(μm):");
		ckbx_bandsRange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_bandsRange.isSelected()) {
					tf_minBandsRange.setEditable(true);
					tf_maxBandsRange.setEditable(true);
					tf_minBandsRange.setBackground(white);
					tf_maxBandsRange.setBackground(white);
				}else {
					tf_minBandsRange.setEditable(false);
					tf_maxBandsRange.setEditable(false);
					tf_minBandsRange.setBackground(Grey);
					tf_maxBandsRange.setBackground(Grey);
					tf_minBandsRange.setText("");
					tf_maxBandsRange.setText("");
				}
			}
		});
		
		ckbx_revisitTM = new JCheckBox("重访周期(day):");
		ckbx_revisitTM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_revisitTM.isSelected()) {
					tf_revisitTM.setEditable(true);
					tf_revisitTM.setBackground(Color.white);
				}else {
					tf_revisitTM.setEditable(false);
					tf_revisitTM.setBackground(Grey);
					tf_revisitTM.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_revisitTM = new GridBagConstraints();
		gbc_ckbx_revisitTM.anchor = GridBagConstraints.WEST;
		gbc_ckbx_revisitTM.gridwidth = 2;
		gbc_ckbx_revisitTM.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_revisitTM.gridx = 5;
		gbc_ckbx_revisitTM.gridy = 1;
		p_capabilities.add(ckbx_revisitTM, gbc_ckbx_revisitTM);
		
		tf_revisitTM = new JTextField();
		tf_revisitTM.setEditable(false);
		tf_revisitTM.setColumns(10);
		GridBagConstraints gbc_tf_revisitTM = new GridBagConstraints();
		gbc_tf_revisitTM.gridwidth = 3;
		gbc_tf_revisitTM.insets = new Insets(0, 0, 5, 10);
		gbc_tf_revisitTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_revisitTM.gridx = 7;
		gbc_tf_revisitTM.gridy = 1;
		p_capabilities.add(tf_revisitTM, gbc_tf_revisitTM);
		GridBagConstraints gbc_ckbx_bandsRange = new GridBagConstraints();
		gbc_ckbx_bandsRange.gridwidth = 2;
		gbc_ckbx_bandsRange.anchor = GridBagConstraints.WEST;
		gbc_ckbx_bandsRange.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_bandsRange.gridx = 0;
		gbc_ckbx_bandsRange.gridy = 2;
		p_capabilities.add(ckbx_bandsRange, gbc_ckbx_bandsRange);
		
		tf_minBandsRange = new JTextField();
		tf_minBandsRange.setEditable(false);
		tf_minBandsRange.setColumns(10);
		GridBagConstraints gbc_tf_minBandsRange = new GridBagConstraints();
		gbc_tf_minBandsRange.insets = new Insets(0, 0, 5, 5);
		gbc_tf_minBandsRange.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_minBandsRange.gridx = 2;
		gbc_tf_minBandsRange.gridy = 2;
		p_capabilities.add(tf_minBandsRange, gbc_tf_minBandsRange);
		
		JLabel label_2 = new JLabel("—");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 2;
		p_capabilities.add(label_2, gbc_label_2);
		
		tf_maxBandsRange = new JTextField();
		tf_maxBandsRange.setEditable(false);
		tf_maxBandsRange.setColumns(10);
		GridBagConstraints gbc_tf_maxBandsRange = new GridBagConstraints();
		gbc_tf_maxBandsRange.insets = new Insets(0, 0, 5, 5);
		gbc_tf_maxBandsRange.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_maxBandsRange.gridx = 4;
		gbc_tf_maxBandsRange.gridy = 2;
		p_capabilities.add(tf_maxBandsRange, gbc_tf_maxBandsRange);
		
		ckbx_bandsNumber = new JCheckBox("波段数:");
		ckbx_bandsNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_bandsNumber.isSelected()) {
					tf_bandsNumber.setEditable(true);
					tf_bandsNumber.setBackground(Color.white);
				}else {
					tf_bandsNumber.setEditable(false);
					tf_bandsNumber.setBackground(Grey);
					tf_bandsNumber.setText("");
				}
			}
		});
		
		JLabel lb_obsQuality = new JLabel("观测能力质量");
		lb_obsQuality.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_obsQuality = new GridBagConstraints();
		gbc_lb_obsQuality.gridwidth = 2;
		gbc_lb_obsQuality.insets = new Insets(5, 5, 5, 5);
		gbc_lb_obsQuality.gridx = 5;
		gbc_lb_obsQuality.gridy = 2;
		p_capabilities.add(lb_obsQuality, gbc_lb_obsQuality);
		GridBagConstraints gbc_ckbx_bandsNumber = new GridBagConstraints();
		gbc_ckbx_bandsNumber.anchor = GridBagConstraints.WEST;
		gbc_ckbx_bandsNumber.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_bandsNumber.gridx = 0;
		gbc_ckbx_bandsNumber.gridy = 3;
		p_capabilities.add(ckbx_bandsNumber, gbc_ckbx_bandsNumber);
		
		tf_bandsNumber = new JTextField();
		tf_bandsNumber.setEditable(false);
		tf_bandsNumber.setColumns(10);
		GridBagConstraints gbc_tf_bandsNumber = new GridBagConstraints();
		gbc_tf_bandsNumber.gridwidth = 4;
		gbc_tf_bandsNumber.insets = new Insets(0, 0, 5, 5);
		gbc_tf_bandsNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_bandsNumber.gridx = 1;
		gbc_tf_bandsNumber.gridy = 3;
		p_capabilities.add(tf_bandsNumber, gbc_tf_bandsNumber);
		
		ckbx_swath = new JCheckBox("成像宽度(km):");
		ckbx_swath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_swath.isSelected()) {
					tf_minSwath.setEditable(true);
					tf_minSwath.setBackground(Color.white);
					tf_maxSwath.setEditable(true);
					tf_maxSwath.setBackground(Color.white);
				}else {
					tf_minSwath.setEditable(false);
					tf_minSwath.setBackground(Grey);
					tf_minSwath.setText("");
					tf_maxSwath.setEditable(false);
					tf_maxSwath.setBackground(Grey);
					tf_maxSwath.setText("");
				}
			}
		});
		
		ckbx_geolocationAccuracy = new JCheckBox("地理定位精度(m):");
		ckbx_geolocationAccuracy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_geolocationAccuracy.isSelected()) {
					tf_geolocationAccuracy.setEditable(true);
					tf_geolocationAccuracy.setBackground(white);
				}else {
					tf_geolocationAccuracy.setEditable(false);
					tf_geolocationAccuracy.setBackground(Grey);
					tf_geolocationAccuracy.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_geolocationAccuracy = new GridBagConstraints();
		gbc_ckbx_geolocationAccuracy.gridwidth = 2;
		gbc_ckbx_geolocationAccuracy.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_geolocationAccuracy.gridx = 5;
		gbc_ckbx_geolocationAccuracy.gridy = 3;
		p_capabilities.add(ckbx_geolocationAccuracy, gbc_ckbx_geolocationAccuracy);
		
		tf_geolocationAccuracy = new JTextField();
		tf_geolocationAccuracy.setEditable(false);
		tf_geolocationAccuracy.setColumns(10);
		GridBagConstraints gbc_tf_geolocationAccuracy = new GridBagConstraints();
		gbc_tf_geolocationAccuracy.gridwidth = 3;
		gbc_tf_geolocationAccuracy.insets = new Insets(0, 0, 5, 10);
		gbc_tf_geolocationAccuracy.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_geolocationAccuracy.gridx = 7;
		gbc_tf_geolocationAccuracy.gridy = 3;
		p_capabilities.add(tf_geolocationAccuracy, gbc_tf_geolocationAccuracy);
		GridBagConstraints gbc_ckbx_swath = new GridBagConstraints();
		gbc_ckbx_swath.anchor = GridBagConstraints.WEST;
		gbc_ckbx_swath.gridwidth = 2;
		gbc_ckbx_swath.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_swath.gridx = 0;
		gbc_ckbx_swath.gridy = 4;
		p_capabilities.add(ckbx_swath, gbc_ckbx_swath);
		
		tf_minSwath = new JTextField();
		tf_minSwath.setEditable(false);
		tf_minSwath.setColumns(10);
		GridBagConstraints gbc_tf_minSwath = new GridBagConstraints();
		gbc_tf_minSwath.insets = new Insets(0, 0, 5, 5);
		gbc_tf_minSwath.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_minSwath.gridx = 2;
		gbc_tf_minSwath.gridy = 4;
		p_capabilities.add(tf_minSwath, gbc_tf_minSwath);
		
		JLabel lb_line5 = new JLabel("—");
		GridBagConstraints gbc_lb_line5 = new GridBagConstraints();
		gbc_lb_line5.insets = new Insets(0, 0, 5, 5);
		gbc_lb_line5.gridx = 3;
		gbc_lb_line5.gridy = 4;
		p_capabilities.add(lb_line5, gbc_lb_line5);
		
		tf_maxSwath = new JTextField();
		tf_maxSwath.setEditable(false);
		tf_maxSwath.setColumns(10);
		GridBagConstraints gbc_tf_maxSwath = new GridBagConstraints();
		gbc_tf_maxSwath.insets = new Insets(0, 0, 5, 5);
		gbc_tf_maxSwath.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_maxSwath.gridx = 4;
		gbc_tf_maxSwath.gridy = 4;
		p_capabilities.add(tf_maxSwath, gbc_tf_maxSwath);
		
		ckbx_fov = new JCheckBox("视场角(deg):");
		ckbx_fov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_fov.isSelected()) {
					tf_fov.setEditable(true);
					tf_fov.setBackground(Color.white);
				}else {
					tf_fov.setEditable(false);
					tf_fov.setBackground(Grey);
					tf_fov.setText("");
				}
			}
		});
		
		ckbx_angleAccuracy = new JCheckBox("角度精度(deg):");
		ckbx_angleAccuracy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_angleAccuracy.isSelected()) {
					tf_angleAccuracy.setEditable(true);
					tf_angleAccuracy.setBackground(white);
				}else {
					tf_angleAccuracy.setEditable(false);
					tf_angleAccuracy.setBackground(Grey);
					tf_angleAccuracy.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_angleAccuracy = new GridBagConstraints();
		gbc_ckbx_angleAccuracy.anchor = GridBagConstraints.WEST;
		gbc_ckbx_angleAccuracy.gridwidth = 2;
		gbc_ckbx_angleAccuracy.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_angleAccuracy.gridx = 5;
		gbc_ckbx_angleAccuracy.gridy = 4;
		p_capabilities.add(ckbx_angleAccuracy, gbc_ckbx_angleAccuracy);
		
		tf_angleAccuracy = new JTextField();
		tf_angleAccuracy.setEditable(false);
		tf_angleAccuracy.setColumns(10);
		GridBagConstraints gbc_tf_angleAccuracy = new GridBagConstraints();
		gbc_tf_angleAccuracy.gridwidth = 3;
		gbc_tf_angleAccuracy.insets = new Insets(0, 0, 5, 10);
		gbc_tf_angleAccuracy.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_angleAccuracy.gridx = 7;
		gbc_tf_angleAccuracy.gridy = 4;
		p_capabilities.add(tf_angleAccuracy, gbc_tf_angleAccuracy);
		GridBagConstraints gbc_ckbx_fov = new GridBagConstraints();
		gbc_ckbx_fov.gridwidth = 2;
		gbc_ckbx_fov.anchor = GridBagConstraints.WEST;
		gbc_ckbx_fov.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_fov.gridx = 0;
		gbc_ckbx_fov.gridy = 5;
		p_capabilities.add(ckbx_fov, gbc_ckbx_fov);
		
		tf_fov = new JTextField();
		tf_fov.setEditable(false);
		tf_fov.setColumns(10);
		GridBagConstraints gbc_tf_fov = new GridBagConstraints();
		gbc_tf_fov.gridwidth = 3;
		gbc_tf_fov.insets = new Insets(0, 0, 5, 5);
		gbc_tf_fov.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_fov.gridx = 2;
		gbc_tf_fov.gridy = 5;
		p_capabilities.add(tf_fov, gbc_tf_fov);
		
		ckbx_groundResolution = new JCheckBox("地面分辨率(m):");
		ckbx_groundResolution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_groundResolution.isSelected()) {
					tf_minGroungResolution.setEditable(true);
					tf_minGroungResolution.setBackground(white);
					tf_maxGroungResolution.setEditable(true);
					tf_maxGroungResolution.setBackground(white);
				}else {
					tf_minGroungResolution.setEditable(false);
					tf_minGroungResolution.setBackground(Grey);
					tf_minGroungResolution.setText("");
					tf_maxGroungResolution.setEditable(false);
					tf_maxGroungResolution.setBackground(Grey);
					tf_maxGroungResolution.setText("");
				}
			}
		});
		
		ckbx_distanceAccuracy = new JCheckBox("距离精度(m):");
		ckbx_distanceAccuracy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_distanceAccuracy.isSelected()) {
					tf_distanceAccuracy.setEditable(true);
					tf_distanceAccuracy.setBackground(white);
				}else {
					tf_distanceAccuracy.setEditable(false);
					tf_distanceAccuracy.setBackground(Grey);
					tf_distanceAccuracy.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_distanceAccuracy = new GridBagConstraints();
		gbc_ckbx_distanceAccuracy.anchor = GridBagConstraints.WEST;
		gbc_ckbx_distanceAccuracy.gridwidth = 2;
		gbc_ckbx_distanceAccuracy.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_distanceAccuracy.gridx = 5;
		gbc_ckbx_distanceAccuracy.gridy = 5;
		p_capabilities.add(ckbx_distanceAccuracy, gbc_ckbx_distanceAccuracy);
		
		tf_distanceAccuracy = new JTextField();
		tf_distanceAccuracy.setEditable(false);
		tf_distanceAccuracy.setColumns(10);
		GridBagConstraints gbc_tf_distanceAccuracy = new GridBagConstraints();
		gbc_tf_distanceAccuracy.gridwidth = 3;
		gbc_tf_distanceAccuracy.insets = new Insets(0, 0, 5, 10);
		gbc_tf_distanceAccuracy.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_distanceAccuracy.gridx = 7;
		gbc_tf_distanceAccuracy.gridy = 5;
		p_capabilities.add(tf_distanceAccuracy, gbc_tf_distanceAccuracy);
		GridBagConstraints gbc_ckbx_groundResolution = new GridBagConstraints();
		gbc_ckbx_groundResolution.anchor = GridBagConstraints.WEST;
		gbc_ckbx_groundResolution.gridwidth = 2;
		gbc_ckbx_groundResolution.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_groundResolution.gridx = 0;
		gbc_ckbx_groundResolution.gridy = 6;
		p_capabilities.add(ckbx_groundResolution, gbc_ckbx_groundResolution);
		
		tf_minGroungResolution = new JTextField();
		tf_minGroungResolution.setEditable(false);
		tf_minGroungResolution.setColumns(10);
		GridBagConstraints gbc_tf_minGroungResolution = new GridBagConstraints();
		gbc_tf_minGroungResolution.insets = new Insets(0, 0, 5, 5);
		gbc_tf_minGroungResolution.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_minGroungResolution.gridx = 2;
		gbc_tf_minGroungResolution.gridy = 6;
		p_capabilities.add(tf_minGroungResolution, gbc_tf_minGroungResolution);
		
		JLabel label_3 = new JLabel("—");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 3;
		gbc_label_3.gridy = 6;
		p_capabilities.add(label_3, gbc_label_3);
		
		tf_maxGroungResolution = new JTextField();
		tf_maxGroungResolution.setEditable(false);
		tf_maxGroungResolution.setColumns(10);
		GridBagConstraints gbc_tf_maxGroungResolution = new GridBagConstraints();
		gbc_tf_maxGroungResolution.insets = new Insets(0, 0, 5, 5);
		gbc_tf_maxGroungResolution.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_maxGroungResolution.gridx = 4;
		gbc_tf_maxGroungResolution.gridy = 6;
		p_capabilities.add(tf_maxGroungResolution, gbc_tf_maxGroungResolution);
		
		ckbx_sideSwingAngle = new JCheckBox("侧摆角(deg):");
		ckbx_sideSwingAngle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_sideSwingAngle.isSelected()) {
					tf_sideSwingAngle.setEditable(true);
					tf_sideSwingAngle.setBackground(white);
				}else {
					tf_sideSwingAngle.setEditable(false);
					tf_sideSwingAngle.setBackground(Grey);
					tf_sideSwingAngle.setText("");
				}
			}
		});
		
		ckbx_radiationAccuracy = new JCheckBox("辐射精度:");
		ckbx_radiationAccuracy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_radiationAccuracy.isSelected()) {
					tf_radiationAccuracy.setEditable(true);
					tf_radiationAccuracy.setBackground(white);
				}else {
					tf_radiationAccuracy.setEditable(false);
					tf_radiationAccuracy.setBackground(Grey);
					tf_radiationAccuracy.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_radiationAccuracy = new GridBagConstraints();
		gbc_ckbx_radiationAccuracy.anchor = GridBagConstraints.WEST;
		gbc_ckbx_radiationAccuracy.gridwidth = 2;
		gbc_ckbx_radiationAccuracy.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_radiationAccuracy.gridx = 5;
		gbc_ckbx_radiationAccuracy.gridy = 6;
		p_capabilities.add(ckbx_radiationAccuracy, gbc_ckbx_radiationAccuracy);
		
		tf_radiationAccuracy = new JTextField();
		tf_radiationAccuracy.setEditable(false);
		tf_radiationAccuracy.setColumns(10);
		GridBagConstraints gbc_tf_radiationAccuracy = new GridBagConstraints();
		gbc_tf_radiationAccuracy.gridwidth = 3;
		gbc_tf_radiationAccuracy.insets = new Insets(0, 0, 5, 10);
		gbc_tf_radiationAccuracy.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_radiationAccuracy.gridx = 7;
		gbc_tf_radiationAccuracy.gridy = 6;
		p_capabilities.add(tf_radiationAccuracy, gbc_tf_radiationAccuracy);
		GridBagConstraints gbc_ckbx_sideSwingAngle = new GridBagConstraints();
		gbc_ckbx_sideSwingAngle.anchor = GridBagConstraints.WEST;
		gbc_ckbx_sideSwingAngle.gridwidth = 2;
		gbc_ckbx_sideSwingAngle.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_sideSwingAngle.gridx = 0;
		gbc_ckbx_sideSwingAngle.gridy = 7;
		p_capabilities.add(ckbx_sideSwingAngle, gbc_ckbx_sideSwingAngle);
		
		tf_sideSwingAngle = new JTextField();
		tf_sideSwingAngle.setEditable(false);
		tf_sideSwingAngle.setColumns(10);
		GridBagConstraints gbc_tf_sideSwingAngle = new GridBagConstraints();
		gbc_tf_sideSwingAngle.gridwidth = 3;
		gbc_tf_sideSwingAngle.insets = new Insets(0, 0, 5, 5);
		gbc_tf_sideSwingAngle.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_sideSwingAngle.gridx = 2;
		gbc_tf_sideSwingAngle.gridy = 7;
		p_capabilities.add(tf_sideSwingAngle, gbc_tf_sideSwingAngle);
		
		JLabel lb_obsData = new JLabel("观测能力数据");
		lb_obsData.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_obsData = new GridBagConstraints();
		gbc_lb_obsData.gridwidth = 2;
		gbc_lb_obsData.insets = new Insets(0, 0, 5, 5);
		gbc_lb_obsData.gridx = 5;
		gbc_lb_obsData.gridy = 7;
		p_capabilities.add(lb_obsData, gbc_lb_obsData);
		
		JCheckBox ckbx_observedBBox = new JCheckBox("观测范围(纬度-经度):");
		ckbx_observedBBox.setSelected(true);
		GridBagConstraints gbc_ckbx_observedBBox = new GridBagConstraints();
		gbc_ckbx_observedBBox.anchor = GridBagConstraints.WEST;
		gbc_ckbx_observedBBox.gridwidth = 4;
		gbc_ckbx_observedBBox.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_observedBBox.gridx = 0;
		gbc_ckbx_observedBBox.gridy = 8;
		p_capabilities.add(ckbx_observedBBox, gbc_ckbx_observedBBox);
		
		ckbx_dataAccessLevel = new JCheckBox("数据获取等级:");
		ckbx_dataAccessLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_dataAccessLevel.isSelected()) {
					ckbx_dataAccessLevel.setEnabled(true);
				}else {
					ckbx_dataAccessLevel.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_ckbx_dataAccessLevel = new GridBagConstraints();
		gbc_ckbx_dataAccessLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_dataAccessLevel.gridwidth = 2;
		gbc_ckbx_dataAccessLevel.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_dataAccessLevel.gridx = 5;
		gbc_ckbx_dataAccessLevel.gridy = 8;
		p_capabilities.add(ckbx_dataAccessLevel, gbc_ckbx_dataAccessLevel);
		
		cbbx_dataAccessLevel = new JComboBox();
		cbbx_dataAccessLevel.setModel(new DefaultComboBoxModel(new String[] {"公开", "限制"}));
		cbbx_dataAccessLevel.setEnabled(false);
		GridBagConstraints gbc_cbbx_dataAccessLevel = new GridBagConstraints();
		gbc_cbbx_dataAccessLevel.gridwidth = 3;
		gbc_cbbx_dataAccessLevel.insets = new Insets(0, 0, 5, 10);
		gbc_cbbx_dataAccessLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbx_dataAccessLevel.gridx = 7;
		gbc_cbbx_dataAccessLevel.gridy = 8;
		p_capabilities.add(cbbx_dataAccessLevel, gbc_cbbx_dataAccessLevel);
		
		JLabel lb_lowerCorner = new JLabel("  左下角点:");
		GridBagConstraints gbc_lb_lowerCorner = new GridBagConstraints();
		gbc_lb_lowerCorner.insets = new Insets(0, 0, 5, 5);
		gbc_lb_lowerCorner.gridx = 0;
		gbc_lb_lowerCorner.gridy = 9;
		p_capabilities.add(lb_lowerCorner, gbc_lb_lowerCorner);
		
		tf_lowerY = new JTextField();
		tf_lowerY.setColumns(10);
		GridBagConstraints gbc_tf_lowerY = new GridBagConstraints();
		gbc_tf_lowerY.gridwidth = 2;
		gbc_tf_lowerY.insets = new Insets(0, 0, 5, 5);
		gbc_tf_lowerY.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_lowerY.gridx = 1;
		gbc_tf_lowerY.gridy = 9;
		p_capabilities.add(tf_lowerY, gbc_tf_lowerY);
		
		JLabel label = new JLabel("—");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 9;
		p_capabilities.add(label, gbc_label);
		
		tf_lowerX = new JTextField();
		tf_lowerX.setColumns(10);
		GridBagConstraints gbc_tf_lowerX = new GridBagConstraints();
		gbc_tf_lowerX.insets = new Insets(0, 0, 5, 5);
		gbc_tf_lowerX.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_lowerX.gridx = 4;
		gbc_tf_lowerX.gridy = 9;
		p_capabilities.add(tf_lowerX, gbc_tf_lowerX);
		
		ckbx_dataAccessQuality = new JCheckBox("数据质量等级:");
		ckbx_dataAccessQuality.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_dataAccessQuality.isSelected()) {
					tf_dataAccessQuality.setEditable(true);
					tf_dataAccessQuality.setBackground(Color.white);
				}else {
					tf_dataAccessQuality.setEditable(false);
					tf_dataAccessQuality.setBackground(Grey);
					tf_dataAccessQuality.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_dataAccessQuality = new GridBagConstraints();
		gbc_ckbx_dataAccessQuality.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_dataAccessQuality.gridwidth = 2;
		gbc_ckbx_dataAccessQuality.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_dataAccessQuality.gridx = 5;
		gbc_ckbx_dataAccessQuality.gridy = 9;
		p_capabilities.add(ckbx_dataAccessQuality, gbc_ckbx_dataAccessQuality);
		
		tf_dataAccessQuality = new JTextField();
		tf_dataAccessQuality.setEditable(false);
		tf_dataAccessQuality.setColumns(10);
		GridBagConstraints gbc_tf_dataAccessQuality = new GridBagConstraints();
		gbc_tf_dataAccessQuality.gridwidth = 3;
		gbc_tf_dataAccessQuality.insets = new Insets(0, 0, 5, 10);
		gbc_tf_dataAccessQuality.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_dataAccessQuality.gridx = 7;
		gbc_tf_dataAccessQuality.gridy = 9;
		p_capabilities.add(tf_dataAccessQuality, gbc_tf_dataAccessQuality);
		
		JLabel lb_upperCorner = new JLabel("  右上角点:");
		GridBagConstraints gbc_lb_upperCorner = new GridBagConstraints();
		gbc_lb_upperCorner.insets = new Insets(0, 0, 5, 5);
		gbc_lb_upperCorner.gridx = 0;
		gbc_lb_upperCorner.gridy = 10;
		p_capabilities.add(lb_upperCorner, gbc_lb_upperCorner);
		
		tf_upperY = new JTextField();
		tf_upperY.setColumns(10);
		GridBagConstraints gbc_tf_upperY = new GridBagConstraints();
		gbc_tf_upperY.gridwidth = 2;
		gbc_tf_upperY.insets = new Insets(0, 0, 5, 5);
		gbc_tf_upperY.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_upperY.gridx = 1;
		gbc_tf_upperY.gridy = 10;
		p_capabilities.add(tf_upperY, gbc_tf_upperY);
		
		JLabel label_1 = new JLabel("—");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 10;
		p_capabilities.add(label_1, gbc_label_1);
		
		tf_upperX = new JTextField();
		tf_upperX.setColumns(10);
		GridBagConstraints gbc_tf_upperX = new GridBagConstraints();
		gbc_tf_upperX.insets = new Insets(0, 0, 5, 5);
		gbc_tf_upperX.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_upperX.gridx = 4;
		gbc_tf_upperX.gridy = 10;
		p_capabilities.add(tf_upperX, gbc_tf_upperX);
		
		ckbx_dataFormat = new JCheckBox("数据格式:");
		ckbx_dataFormat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_dataFormat.isSelected()) {
					tf_dataFormat.setEditable(true);
					tf_dataFormat.setBackground(Color.white);
				}else {
					tf_dataFormat.setEditable(false);
					tf_dataFormat.setBackground(Grey);
					tf_dataFormat.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_dataFormat = new GridBagConstraints();
		gbc_ckbx_dataFormat.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_dataFormat.gridwidth = 2;
		gbc_ckbx_dataFormat.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_dataFormat.gridx = 5;
		gbc_ckbx_dataFormat.gridy = 10;
		p_capabilities.add(ckbx_dataFormat, gbc_ckbx_dataFormat);
		
		tf_dataFormat = new JTextField();
		tf_dataFormat.setEditable(false);
		tf_dataFormat.setColumns(10);
		GridBagConstraints gbc_tf_dataFormat = new GridBagConstraints();
		gbc_tf_dataFormat.gridwidth = 3;
		gbc_tf_dataFormat.insets = new Insets(0, 0, 5, 10);
		gbc_tf_dataFormat.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_dataFormat.gridx = 7;
		gbc_tf_dataFormat.gridy = 10;
		p_capabilities.add(tf_dataFormat, gbc_tf_dataFormat);
		
		JLabel lb_obsDepth = new JLabel("观测能力深度");
		lb_obsDepth.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_obsDepth = new GridBagConstraints();
		gbc_lb_obsDepth.gridwidth = 2;
		gbc_lb_obsDepth.insets = new Insets(0, 0, 5, 5);
		gbc_lb_obsDepth.gridx = 0;
		gbc_lb_obsDepth.gridy = 11;
		p_capabilities.add(lb_obsDepth, gbc_lb_obsDepth);
		
		ckbx_opticalBandCharacteristics = new JCheckBox("观测波段特征:");
		ckbx_opticalBandCharacteristics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_opticalBandCharacteristics.isSelected()) {
					bt_addOpticalBandCharacter.setEnabled(true);
					bt_deleOpticalBandCharacter.setEnabled(true);
				}else {
					bt_addOpticalBandCharacter.setEnabled(false);
					bt_deleOpticalBandCharacter.setEnabled(false);
					model_opticalBandCharacter.setRowCount(0);
				}
			}
		});
		GridBagConstraints gbc_ckbx_opticalBandCharacteristics = new GridBagConstraints();
		gbc_ckbx_opticalBandCharacteristics.anchor = GridBagConstraints.WEST;
		gbc_ckbx_opticalBandCharacteristics.gridwidth = 2;
		gbc_ckbx_opticalBandCharacteristics.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_opticalBandCharacteristics.gridx = 0;
		gbc_ckbx_opticalBandCharacteristics.gridy = 12;
		p_capabilities.add(ckbx_opticalBandCharacteristics, gbc_ckbx_opticalBandCharacteristics);
		
		bt_addOpticalBandCharacter = new JButton("+");
		bt_addOpticalBandCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optical_BandCharacteristic bandCharac = new optical_BandCharacteristic();
				bandCharac.setLocationRelativeTo(frame);
				bandCharac.setVisible(true);
			}
		});
		bt_addOpticalBandCharacter.setEnabled(false);
		GridBagConstraints gbc_bt_addOpticalBandCharacter = new GridBagConstraints();
		gbc_bt_addOpticalBandCharacter.anchor = GridBagConstraints.EAST;
		gbc_bt_addOpticalBandCharacter.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addOpticalBandCharacter.gridx = 2;
		gbc_bt_addOpticalBandCharacter.gridy = 12;
		p_capabilities.add(bt_addOpticalBandCharacter, gbc_bt_addOpticalBandCharacter);
		
		bt_deleOpticalBandCharacter = new JButton("-");
		bt_deleOpticalBandCharacter.setEnabled(false);
		GridBagConstraints gbc_bt_deleOpticalBandCharacter = new GridBagConstraints();
		gbc_bt_deleOpticalBandCharacter.anchor = GridBagConstraints.WEST;
		gbc_bt_deleOpticalBandCharacter.insets = new Insets(0, 0, 5, 5);
		gbc_bt_deleOpticalBandCharacter.gridx = 4;
		gbc_bt_deleOpticalBandCharacter.gridy = 12;
		p_capabilities.add(bt_deleOpticalBandCharacter, gbc_bt_deleOpticalBandCharacter);
		
		ckbx_otherCapability = new JCheckBox("添加其他观测能力:");
		GridBagConstraints gbc_ckbx_otherCapability = new GridBagConstraints();
		gbc_ckbx_otherCapability.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_otherCapability.gridwidth = 5;
		gbc_ckbx_otherCapability.insets = new Insets(0, 0, 5, 0);
		gbc_ckbx_otherCapability.gridx = 5;
		gbc_ckbx_otherCapability.gridy = 12;
		p_capabilities.add(ckbx_otherCapability, gbc_ckbx_otherCapability);
		
		ckbx_otherCapability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_otherCapability.isSelected()) {
					tf_otherCapaName.setEditable(true);
					tf_otherCapaName.setBackground(Color.white);
					tf_otherCapaContent.setEditable(true);
					tf_otherCapaContent.setBackground(Color.white);
					bt_addOtherCapa.setEnabled(true);
					bt_deleteOtherCapa.setEnabled(true);
				}else {
					tf_otherCapaName.setEditable(false);
					tf_otherCapaName.setBackground(Grey);
					tf_otherCapaContent.setEditable(false);
					tf_otherCapaContent.setBackground(Grey);
					tf_otherCapaName.setText("");
					tf_otherCapaContent.setText("");
					bt_addOtherCapa.setEnabled(false);
					bt_deleteOtherCapa.setEnabled(false);
					model_otherCapability.setRowCount(0);
				}
			}
		});
		
		JScrollPane scrollPane_9 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_9 = new GridBagConstraints();
		gbc_scrollPane_9.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_9.gridheight = 2;
		gbc_scrollPane_9.gridwidth = 5;
		gbc_scrollPane_9.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_9.gridx = 0;
		gbc_scrollPane_9.gridy = 13;
		p_capabilities.add(scrollPane_9, gbc_scrollPane_9);
		
		tb_opticalBandCharacter = new JTable();
		tb_opticalBandCharacter.setBackground(new Color(175, 238, 238));
		scrollPane_9.setViewportView(tb_opticalBandCharacter);
		model_opticalBandCharacter = new DefaultTableModel(new Object[][] {},new String[] {"波段名称", "波段宽度", "光谱分辨率", "辐射分辨率","应用"});
		tb_opticalBandCharacter.setModel(model_opticalBandCharacter);
		
		ckbx_IFOV = new JCheckBox("瞬时视场角(deg):");
		ckbx_IFOV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_IFOV.isSelected()) {
					tf_IFOV.setEditable(true);
					tf_IFOV.setBackground(white);
				}else {
					tf_IFOV.setEditable(false);
					tf_IFOV.setBackground(Grey);
					tf_IFOV.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_IFOV = new GridBagConstraints();
		gbc_ckbx_IFOV.gridwidth = 2;
		gbc_ckbx_IFOV.anchor = GridBagConstraints.WEST;
		gbc_ckbx_IFOV.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_IFOV.gridx = 0;
		gbc_ckbx_IFOV.gridy = 15;
		p_capabilities.add(ckbx_IFOV, gbc_ckbx_IFOV);
		
		tf_IFOV = new JTextField();
		tf_IFOV.setEditable(false);
		tf_IFOV.setColumns(10);
		GridBagConstraints gbc_tf_IFOV = new GridBagConstraints();
		gbc_tf_IFOV.gridwidth = 3;
		gbc_tf_IFOV.insets = new Insets(0, 0, 5, 5);
		gbc_tf_IFOV.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_IFOV.gridx = 2;
		gbc_tf_IFOV.gridy = 15;
		p_capabilities.add(tf_IFOV, gbc_tf_IFOV);
		
		ckbx_quantilizationLevel = new JCheckBox("量化等级:");
		ckbx_quantilizationLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_quantilizationLevel.isSelected()) {
					tf_quantizationLevel.setEditable(true);
					tf_quantizationLevel.setBackground(white);
				}else {
					tf_quantizationLevel.setEditable(false);
					tf_quantizationLevel.setBackground(Grey);
					tf_quantizationLevel.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_quantilizationLevel = new GridBagConstraints();
		gbc_ckbx_quantilizationLevel.anchor = GridBagConstraints.WEST;
		gbc_ckbx_quantilizationLevel.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_quantilizationLevel.gridx = 0;
		gbc_ckbx_quantilizationLevel.gridy = 16;
		p_capabilities.add(ckbx_quantilizationLevel, gbc_ckbx_quantilizationLevel);
		
		tf_quantizationLevel = new JTextField();
		tf_quantizationLevel.setEditable(false);
		tf_quantizationLevel.setColumns(10);
		GridBagConstraints gbc_tf_quantizationLevel = new GridBagConstraints();
		gbc_tf_quantizationLevel.gridwidth = 4;
		gbc_tf_quantizationLevel.insets = new Insets(0, 0, 5, 5);
		gbc_tf_quantizationLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_quantizationLevel.gridx = 1;
		gbc_tf_quantizationLevel.gridy = 16;
		p_capabilities.add(tf_quantizationLevel, gbc_tf_quantizationLevel);
		
		tf_otherCapaName = new JTextField();
		tf_otherCapaName.setEditable(false);
		tf_otherCapaName.setColumns(10);
		GridBagConstraints gbc_tf_otherCapaName = new GridBagConstraints();
		gbc_tf_otherCapaName.insets = new Insets(0, 0, 5, 5);
		gbc_tf_otherCapaName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherCapaName.gridx = 5;
		gbc_tf_otherCapaName.gridy = 16;
		p_capabilities.add(tf_otherCapaName, gbc_tf_otherCapaName);
		
		tf_otherCapaContent = new JTextField();
		tf_otherCapaContent.setEditable(false);
		tf_otherCapaContent.setColumns(10);
		GridBagConstraints gbc_tf_otherCapaContent = new GridBagConstraints();
		gbc_tf_otherCapaContent.gridwidth = 2;
		gbc_tf_otherCapaContent.insets = new Insets(0, 0, 5, 5);
		gbc_tf_otherCapaContent.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherCapaContent.gridx = 6;
		gbc_tf_otherCapaContent.gridy = 16;
		p_capabilities.add(tf_otherCapaContent, gbc_tf_otherCapaContent);
		
		bt_addOtherCapa = new JButton("增加");
		bt_addOtherCapa.setEnabled(false);
		bt_addOtherCapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_otherCapaName.getText(),tf_otherCapaContent.getText()};
				model_otherCapability.addRow(info);
				tf_otherCapaName.setText("");
				tf_otherCapaContent.setText("");
			}
		});
		GridBagConstraints gbc_bt_addOtherCapa = new GridBagConstraints();
		gbc_bt_addOtherCapa.anchor = GridBagConstraints.SOUTH;
		gbc_bt_addOtherCapa.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addOtherCapa.gridx = 8;
		gbc_bt_addOtherCapa.gridy = 16;
		p_capabilities.add(bt_addOtherCapa, gbc_bt_addOtherCapa);
		
		bt_deleteOtherCapa = new JButton("删除");
		bt_deleteOtherCapa.setEnabled(false);
		bt_deleteOtherCapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_otherCapability.getSelectedRow();
				if (selectedRow != -1) {
					model_otherCapability.removeRow(selectedRow);
				}
			}
		});
		GridBagConstraints gbc_bt_deleteOtherCapa = new GridBagConstraints();
		gbc_bt_deleteOtherCapa.insets = new Insets(0, 0, 5, 5);
		gbc_bt_deleteOtherCapa.gridx = 9;
		gbc_bt_deleteOtherCapa.gridy = 16;
		p_capabilities.add(bt_deleteOtherCapa, gbc_bt_deleteOtherCapa);
		
		ckbx_nadirResolution = new JCheckBox("星下点分辨率:");
		ckbx_nadirResolution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_nadirResolution.isSelected()) {
					tf_nadirResolution.setEditable(true);
					tf_nadirResolution.setBackground(white);
				}else {
					tf_nadirResolution.setEditable(false);
					tf_nadirResolution.setBackground(Grey);
					tf_nadirResolution.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_nadirResolution = new GridBagConstraints();
		gbc_ckbx_nadirResolution.anchor = GridBagConstraints.WEST;
		gbc_ckbx_nadirResolution.gridwidth = 2;
		gbc_ckbx_nadirResolution.insets = new Insets(0, 0, 0, 5);
		gbc_ckbx_nadirResolution.gridx = 0;
		gbc_ckbx_nadirResolution.gridy = 17;
		p_capabilities.add(ckbx_nadirResolution, gbc_ckbx_nadirResolution);
		
		JScrollPane scrollPane_31 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_31 = new GridBagConstraints();
		gbc_scrollPane_31.gridheight = 3;
		gbc_scrollPane_31.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_31.gridwidth = 5;
		gbc_scrollPane_31.insets = new Insets(0, 0, 5, 10);
		gbc_scrollPane_31.gridx = 5;
		gbc_scrollPane_31.gridy = 13;
		p_capabilities.add(scrollPane_31, gbc_scrollPane_31);
		
		tb_otherCapability = new JTable();
		tb_otherCapability.setBackground(new Color(175, 238, 238));
		model_otherCapability = new DefaultTableModel(new Object[][] {},new String[] {"字段名称", "字段内容"});
		tb_otherCapability.setModel(model_otherCapability);
		scrollPane_31.setViewportView(tb_otherCapability);
		tb_otherCapability.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tf_nadirResolution = new JTextField();
		tf_nadirResolution.setEditable(false);
		tf_nadirResolution.setColumns(10);
		GridBagConstraints gbc_tf_nadirResolution = new GridBagConstraints();
		gbc_tf_nadirResolution.gridwidth = 3;
		gbc_tf_nadirResolution.insets = new Insets(0, 0, 0, 5);
		gbc_tf_nadirResolution.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_nadirResolution.gridx = 2;
		gbc_tf_nadirResolution.gridy = 17;
		p_capabilities.add(tf_nadirResolution, gbc_tf_nadirResolution);
		
		p_position= new JPanel();
		tp_capa.addTab("传感器位置信息", null, p_position, null);
		GridBagLayout gbl_p_position = new GridBagLayout();
		gbl_p_position.columnWidths = new int[]{58, 0, 0, 0, 52, 0, 0, 0};
		gbl_p_position.rowHeights = new int[]{0, 0, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_p_position.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_p_position.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		p_position.setLayout(gbl_p_position);
		
		JLabel lb_positionDescription = new JLabel("为了支持提供物理组件或系统的静态和动态位置，可以利用以下任一方法来说明传感器\"在哪里\"。");
		lb_positionDescription.setFont(new Font("宋体", Font.ITALIC, 12));
		GridBagConstraints gbc_lb_positionDescription = new GridBagConstraints();
		gbc_lb_positionDescription.gridwidth = 7;
		gbc_lb_positionDescription.anchor = GridBagConstraints.NORTH;
		gbc_lb_positionDescription.insets = new Insets(40, 0, 25, 5);
		gbc_lb_positionDescription.gridx = 0;
		gbc_lb_positionDescription.gridy = 0;
		p_position.add(lb_positionDescription, gbc_lb_positionDescription);
		
		rbt_textPosition = new JRadioButton("文字描述");
		bg_position.add(rbt_textPosition);
		rbt_textPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbt_textPosition.isSelected()) {
					ta_textPosition.setEditable(true);
					ta_textPosition.setBackground(white);
					tf_pointSRS.setEditable(false);
					tf_pointX.setEditable(false);
					tf_pointY.setEditable(false);
					tf_pointSRS.setBackground(Grey);
					tf_pointX.setBackground(Grey);
					tf_pointY.setBackground(Grey);
					tf_pointSRS.setText("");
					tf_pointX.setText("");
					tf_pointY.setText("");
					tf_locationSRS.setEditable(false);
					tf_latitude.setEditable(false);
					tf_longitude.setEditable(false);
					tf_altitude.setEditable(false);
					tf_locationSRS.setBackground(Grey);
					tf_latitude.setBackground(Grey);
					tf_longitude.setBackground(Grey);
					tf_altitude.setBackground(Grey);
					tf_locationSRS.setText("");
					tf_latitude.setText("");
					tf_longitude.setText("");
					tf_altitude.setText("");
				}
			}
		});
		rbt_textPosition.setForeground(SystemColor.textHighlight);
		rbt_textPosition.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_rbt_textPosition = new GridBagConstraints();
		gbc_rbt_textPosition.anchor = GridBagConstraints.WEST;
		gbc_rbt_textPosition.gridwidth = 3;
		gbc_rbt_textPosition.insets = new Insets(0, 0, 5, 5);
		gbc_rbt_textPosition.gridx = 1;
		gbc_rbt_textPosition.gridy = 1;
		p_position.add(rbt_textPosition, gbc_rbt_textPosition);
		
		JScrollPane scrollPane_41 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_41 = new GridBagConstraints();
		gbc_scrollPane_41.gridheight = 2;
		gbc_scrollPane_41.gridwidth = 7;
		gbc_scrollPane_41.insets = new Insets(0, 20, 5, 30);
		gbc_scrollPane_41.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_41.gridx = 1;
		gbc_scrollPane_41.gridy = 2;
		p_position.add(scrollPane_41, gbc_scrollPane_41);
		
		ta_textPosition = new JTextArea();
		ta_textPosition.setBackground(SystemColor.control);
		scrollPane_41.setViewportView(ta_textPosition);
		
		rbt_pointPosition = new JRadioButton("平面坐标 (纬度，经度)");
		bg_position.add(rbt_pointPosition);
		rbt_pointPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbt_pointPosition.isSelected()) {
					tf_pointSRS.setEditable(true);
					tf_pointX.setEditable(true);
					tf_pointY.setEditable(true);
					tf_pointSRS.setBackground(Color.white);
					tf_pointX.setBackground(Color.white);
					tf_pointY.setBackground(Color.white);
					ta_textPosition.setEditable(false);
					ta_textPosition.setBackground(Grey);
					ta_textPosition.setText("");
					tf_locationSRS.setEditable(false);
					tf_latitude.setEditable(false);
					tf_longitude.setEditable(false);
					tf_altitude.setEditable(false);
					tf_locationSRS.setBackground(Grey);
					tf_latitude.setBackground(Grey);
					tf_longitude.setBackground(Grey);
					tf_altitude.setBackground(Grey);
					tf_locationSRS.setText("");
					tf_latitude.setText("");
					tf_longitude.setText("");
					tf_altitude.setText("");
				}
			}
		});
		rbt_pointPosition.setForeground(SystemColor.textHighlight);
		rbt_pointPosition.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_rbt_pointPosition = new GridBagConstraints();
		gbc_rbt_pointPosition.anchor = GridBagConstraints.WEST;
		gbc_rbt_pointPosition.gridwidth = 6;
		gbc_rbt_pointPosition.insets = new Insets(10, 0, 5, 5);
		gbc_rbt_pointPosition.gridx = 1;
		gbc_rbt_pointPosition.gridy = 4;
		p_position.add(rbt_pointPosition, gbc_rbt_pointPosition);
		
		JLabel lb_pointSRS = new JLabel("  参考坐标系统:");
		GridBagConstraints gbc_lb_pointSRS = new GridBagConstraints();
		gbc_lb_pointSRS.gridwidth = 3;
		gbc_lb_pointSRS.insets = new Insets(0, 0, 5, 5);
		gbc_lb_pointSRS.gridx = 1;
		gbc_lb_pointSRS.gridy = 5;
		p_position.add(lb_pointSRS, gbc_lb_pointSRS);
		
		tf_pointSRS = new JTextField();
		hintText pointSRSHint = new hintText(tf_pointSRS, "urn:ogc:def:crs:OGC:1.3:EPSG:4329");
		tf_pointSRS.addFocusListener(new JTextFieldHintListener("urn:ogc:def:crs:OGC:1.3:EPSG:4329", tf_pointSRS));
		tf_pointSRS.setEditable(false);
		tf_pointSRS.setColumns(10);
		GridBagConstraints gbc_tf_pointSRS = new GridBagConstraints();
		gbc_tf_pointSRS.gridwidth = 3;
		gbc_tf_pointSRS.insets = new Insets(0, 0, 5, 40);
		gbc_tf_pointSRS.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_pointSRS.gridx = 4;
		gbc_tf_pointSRS.gridy = 5;
		p_position.add(tf_pointSRS, gbc_tf_pointSRS);
		
		JLabel lb_point = new JLabel("  点坐标(deg):");
		GridBagConstraints gbc_lb_point = new GridBagConstraints();
		gbc_lb_point.gridwidth = 3;
		gbc_lb_point.insets = new Insets(0, 0, 5, 5);
		gbc_lb_point.gridx = 1;
		gbc_lb_point.gridy = 6;
		p_position.add(lb_point, gbc_lb_point);
		
		tf_pointY = new JTextField();
		tf_pointY.setEditable(false);
		tf_pointY.setColumns(10);
		GridBagConstraints gbc_tf_pointY = new GridBagConstraints();
		gbc_tf_pointY.insets = new Insets(0, 0, 5, 5);
		gbc_tf_pointY.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_pointY.gridx = 4;
		gbc_tf_pointY.gridy = 6;
		p_position.add(tf_pointY, gbc_tf_pointY);
		
		JLabel lb_dot = new JLabel("，");
		GridBagConstraints gbc_lb_dot = new GridBagConstraints();
		gbc_lb_dot.insets = new Insets(0, 0, 5, 5);
		gbc_lb_dot.anchor = GridBagConstraints.EAST;
		gbc_lb_dot.gridx = 5;
		gbc_lb_dot.gridy = 6;
		p_position.add(lb_dot, gbc_lb_dot);
		
		tf_pointX = new JTextField();
		tf_pointX.setEditable(false);
		tf_pointX.setColumns(10);
		GridBagConstraints gbc_tf_pointX = new GridBagConstraints();
		gbc_tf_pointX.insets = new Insets(0, 0, 5, 40);
		gbc_tf_pointX.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_pointX.gridx = 6;
		gbc_tf_pointX.gridy = 6;
		p_position.add(tf_pointX, gbc_tf_pointX);
		
		rbt_location = new JRadioButton("空间位置");
		bg_position.add(rbt_location);
		rbt_location.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbt_location.isSelected()) {
					tf_locationSRS.setEditable(true);
					tf_latitude.setEditable(true);
					tf_longitude.setEditable(true);
					tf_altitude.setEditable(true);
					tf_locationSRS.setBackground(Color.white);
					tf_latitude.setBackground(Color.white);
					tf_longitude.setBackground(Color.white);
					tf_altitude.setBackground(Color.white);
					ta_textPosition.setEditable(false);
					ta_textPosition.setBackground(Grey);
					ta_textPosition.setText("");
					tf_pointSRS.setEditable(false);
					tf_pointX.setEditable(false);
					tf_pointY.setEditable(false);
					tf_pointSRS.setBackground(Grey);
					tf_pointX.setBackground(Grey);
					tf_pointY.setBackground(Grey);
					tf_pointSRS.setText("");
					tf_pointX.setText("");
					tf_pointY.setText("");
				}
			}
		});
		rbt_location.setForeground(SystemColor.textHighlight);
		rbt_location.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_rbt_location = new GridBagConstraints();
		gbc_rbt_location.anchor = GridBagConstraints.WEST;
		gbc_rbt_location.gridwidth = 3;
		gbc_rbt_location.insets = new Insets(10, 0, 5, 5);
		gbc_rbt_location.gridx = 1;
		gbc_rbt_location.gridy = 7;
		p_position.add(rbt_location, gbc_rbt_location);
		
		JLabel lb_locationSRS = new JLabel("  参考坐标系统:");
		GridBagConstraints gbc_lb_locationSRS = new GridBagConstraints();
		gbc_lb_locationSRS.gridwidth = 3;
		gbc_lb_locationSRS.insets = new Insets(0, 0, 5, 5);
		gbc_lb_locationSRS.gridx = 1;
		gbc_lb_locationSRS.gridy = 8;
		p_position.add(lb_locationSRS, gbc_lb_locationSRS);
		
		tf_locationSRS = new JTextField();
		hintText locSRSHint = new hintText(tf_locationSRS, "urn:ogc:def:crs:OGC:1.3:EPSG:4329");
		tf_locationSRS.addFocusListener(new JTextFieldHintListener("urn:ogc:def:crs:OGC:1.3:EPSG:4329", tf_locationSRS));
		tf_locationSRS.setEditable(false);
		tf_locationSRS.setColumns(10);
		GridBagConstraints gbc_tf_locationSRS = new GridBagConstraints();
		gbc_tf_locationSRS.gridwidth = 3;
		gbc_tf_locationSRS.insets = new Insets(0, 0, 5, 40);
		gbc_tf_locationSRS.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_locationSRS.gridx = 4;
		gbc_tf_locationSRS.gridy = 8;
		p_position.add(tf_locationSRS, gbc_tf_locationSRS);
		
		JLabel lb_latitude = new JLabel("  纬度(deg):");
		GridBagConstraints gbc_lb_latitude = new GridBagConstraints();
		gbc_lb_latitude.gridwidth = 3;
		gbc_lb_latitude.insets = new Insets(0, 0, 5, 5);
		gbc_lb_latitude.gridx = 1;
		gbc_lb_latitude.gridy = 9;
		p_position.add(lb_latitude, gbc_lb_latitude);
		
		tf_latitude = new JTextField();
		tf_latitude.setEditable(false);
		tf_latitude.setColumns(10);
		GridBagConstraints gbc_tf_latitude = new GridBagConstraints();
		gbc_tf_latitude.insets = new Insets(0, 0, 5, 5);
		gbc_tf_latitude.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_latitude.gridx = 4;
		gbc_tf_latitude.gridy = 9;
		p_position.add(tf_latitude, gbc_tf_latitude);
		
		JLabel lb_longitude = new JLabel("  经度(deg):");
		GridBagConstraints gbc_lb_longitude = new GridBagConstraints();
		gbc_lb_longitude.gridwidth = 3;
		gbc_lb_longitude.insets = new Insets(0, 0, 5, 5);
		gbc_lb_longitude.gridx = 1;
		gbc_lb_longitude.gridy = 10;
		p_position.add(lb_longitude, gbc_lb_longitude);
		
		tf_longitude = new JTextField();
		tf_longitude.setEditable(false);
		tf_longitude.setColumns(10);
		GridBagConstraints gbc_tf_longitude = new GridBagConstraints();
		gbc_tf_longitude.insets = new Insets(0, 0, 5, 5);
		gbc_tf_longitude.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_longitude.gridx = 4;
		gbc_tf_longitude.gridy = 10;
		p_position.add(tf_longitude, gbc_tf_longitude);
		
		JLabel lb_altitude = new JLabel("  海拔(m):");
		GridBagConstraints gbc_lb_altitude = new GridBagConstraints();
		gbc_lb_altitude.gridwidth = 3;
		gbc_lb_altitude.insets = new Insets(0, 0, 5, 5);
		gbc_lb_altitude.gridx = 1;
		gbc_lb_altitude.gridy = 11;
		p_position.add(lb_altitude, gbc_lb_altitude);
		
		tf_altitude = new JTextField();
		tf_altitude.setEditable(false);
		tf_altitude.setColumns(10);
		GridBagConstraints gbc_tf_altitude = new GridBagConstraints();
		gbc_tf_altitude.insets = new Insets(0, 0, 5, 5);
		gbc_tf_altitude.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_altitude.gridx = 4;
		gbc_tf_altitude.gridy = 11;
		p_position.add(tf_altitude, gbc_tf_altitude);
		
		p_contact = new JPanel();
		tp_content.addTab("联系服务信息", null, p_contact, null);
		GridBagLayout gbl_p_contact = new GridBagLayout();
		gbl_p_contact.columnWidths = new int[]{0, 0, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_p_contact.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 39, 0, 27, 0};
		gbl_p_contact.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_p_contact.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		p_contact.setLayout(gbl_p_contact);
		
		JLabel lb_respon = new JLabel("负责单位");
		lb_respon.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_respon = new GridBagConstraints();
		gbc_lb_respon.insets = new Insets(10, 0, 5, 5);
		gbc_lb_respon.gridx = 0;
		gbc_lb_respon.gridy = 0;
		p_contact.add(lb_respon, gbc_lb_respon);
		
		JLabel lb_history = new JLabel("服务历史");
		lb_history.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_history = new GridBagConstraints();
		gbc_lb_history.fill = GridBagConstraints.HORIZONTAL;
		gbc_lb_history.gridwidth = 2;
		gbc_lb_history.insets = new Insets(10, 0, 5, 5);
		gbc_lb_history.gridx = 5;
		gbc_lb_history.gridy = 0;
		p_contact.add(lb_history, gbc_lb_history);
		
		ckbx_role = new JCheckBox("负责角色:");
		ckbx_role.setSelected(true);
		GridBagConstraints gbc_ckbx_role = new GridBagConstraints();
		gbc_ckbx_role.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_role.gridx = 0;
		gbc_ckbx_role.gridy = 1;
		p_contact.add(ckbx_role, gbc_ckbx_role);
		
		cbbx_role = new JComboBox();
		cbbx_role.setModel(new DefaultComboBoxModel(new String[] {"制造商", "管理者", "使用者"}));
		GridBagConstraints gbc_cbbx_role = new GridBagConstraints();
		gbc_cbbx_role.gridwidth = 4;
		gbc_cbbx_role.insets = new Insets(0, 0, 5, 5);
		gbc_cbbx_role.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbx_role.gridx = 1;
		gbc_cbbx_role.gridy = 1;
		p_contact.add(cbbx_role, gbc_cbbx_role);
		
		ckbx_eventID = new JCheckBox("事件编号:");
		GridBagConstraints gbc_ckbx_eventID = new GridBagConstraints();
		gbc_ckbx_eventID.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_eventID.gridx = 5;
		gbc_ckbx_eventID.gridy = 1;
		p_contact.add(ckbx_eventID, gbc_ckbx_eventID);
		ckbx_eventID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_eventID.isSelected()) {
					tf_eventId.setEditable(true);
					tf_eventLabel.setEditable(true);
					tf_eventId.setBackground(white);
					tf_eventLabel.setBackground(white);
				}else {
					tf_eventId.setEditable(false);
					tf_eventLabel.setEditable(false);
					tf_eventId.setBackground(Grey);
					tf_eventLabel.setBackground(Grey);
					tf_eventId.setText("");
					tf_eventLabel.setText("");
				}	
			}
		});
		
		tf_eventId = new JTextField();
		hintText eventIDHint = new hintText(tf_eventId, "如：E1");
		tf_eventId.addFocusListener(new JTextFieldHintListener("如：E1", tf_eventId));
		tf_eventId.setEditable(false);
		GridBagConstraints gbc_tf_eventId = new GridBagConstraints();
		gbc_tf_eventId.insets = new Insets(0, 0, 5, 5);
		gbc_tf_eventId.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_eventId.gridx = 6;
		gbc_tf_eventId.gridy = 1;
		p_contact.add(tf_eventId, gbc_tf_eventId);
		
		JLabel lb_eventLabel = new JLabel("事件标签:");
		GridBagConstraints gbc_lb_eventLabel = new GridBagConstraints();
		gbc_lb_eventLabel.gridwidth = 2;
		gbc_lb_eventLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lb_eventLabel.gridx = 7;
		gbc_lb_eventLabel.gridy = 1;
		p_contact.add(lb_eventLabel, gbc_lb_eventLabel);
		
		tf_eventLabel = new JTextField();
		hintText eventLabelHint = new hintText(tf_eventLabel, "如：SOS");
		tf_eventLabel.addFocusListener(new JTextFieldHintListener("如：SOS", tf_eventLabel));
		tf_eventLabel.setEditable(false);
		GridBagConstraints gbc_tf_eventLabel = new GridBagConstraints();
		gbc_tf_eventLabel.gridwidth = 2;
		gbc_tf_eventLabel.insets = new Insets(0, 0, 5, 0);
		gbc_tf_eventLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_eventLabel.gridx = 9;
		gbc_tf_eventLabel.gridy = 1;
		p_contact.add(tf_eventLabel, gbc_tf_eventLabel);
		
		ckbx_orgniz = new JCheckBox("组织名称:");
		ckbx_orgniz.setSelected(true);
		GridBagConstraints gbc_ckbx_orgniz = new GridBagConstraints();
		gbc_ckbx_orgniz.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_orgniz.gridx = 0;
		gbc_ckbx_orgniz.gridy = 2;
		p_contact.add(ckbx_orgniz, gbc_ckbx_orgniz);
		
		tf_orgniz = new JTextField();
		GridBagConstraints gbc_tf_orgniz = new GridBagConstraints();
		gbc_tf_orgniz.gridwidth = 4;
		gbc_tf_orgniz.insets = new Insets(0, 0, 5, 5);
		gbc_tf_orgniz.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_orgniz.gridx = 1;
		gbc_tf_orgniz.gridy = 2;
		p_contact.add(tf_orgniz, gbc_tf_orgniz);
		tf_orgniz.setColumns(10);
		
		ckbx_EDesc = new JCheckBox("事件描述:");
		GridBagConstraints gbc_ckbx_EDesc = new GridBagConstraints();
		gbc_ckbx_EDesc.anchor = GridBagConstraints.WEST;
		gbc_ckbx_EDesc.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_EDesc.gridx = 5;
		gbc_ckbx_EDesc.gridy = 2;
		p_contact.add(ckbx_EDesc, gbc_ckbx_EDesc);
		ckbx_EDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_EDesc.isSelected()) {
					ta_EDesc.setBackground(white);
					ta_EDesc.setEditable(true);
				}else {
					ta_EDesc.setBackground(Grey);
					ta_EDesc.setEditable(true);
					ta_EDesc.setText("");
				}	
			}
		});
		
		ckbx_person = new JCheckBox("个人名称:");
		GridBagConstraints gbc_ckbx_person = new GridBagConstraints();
		gbc_ckbx_person.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_person.gridx = 0;
		gbc_ckbx_person.gridy = 3;
		p_contact.add(ckbx_person, gbc_ckbx_person);
		ckbx_person.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_person.isSelected()) {
					tf_person.setEditable(true);
					tf_person.setBackground(white);
				}else {
					tf_person.setEditable(false);
					tf_person.setBackground(Grey);
					tf_person.setText("");
				}	
			}
		});
		
		tf_person = new JTextField();
		tf_person.setEditable(false);
		GridBagConstraints gbc_tf_person = new GridBagConstraints();
		gbc_tf_person.gridwidth = 4;
		gbc_tf_person.insets = new Insets(0, 0, 5, 5);
		gbc_tf_person.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_person.gridx = 1;
		gbc_tf_person.gridy = 3;
		p_contact.add(tf_person, gbc_tf_person);
		
		JScrollPane scrollPane_12 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_12 = new GridBagConstraints();
		gbc_scrollPane_12.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_12.gridheight = 2;
		gbc_scrollPane_12.gridwidth = 6;
		gbc_scrollPane_12.insets = new Insets(0, 20, 5, 10);
		gbc_scrollPane_12.gridx = 5;
		gbc_scrollPane_12.gridy = 3;
		p_contact.add(scrollPane_12, gbc_scrollPane_12);
		
		ta_EDesc = new JTextArea();
		ta_EDesc.setEditable(false);
		scrollPane_12.setViewportView(ta_EDesc);
		
		JLabel lb_contInfo = new JLabel("   联系信息:");
		GridBagConstraints gbc_lb_contInfo = new GridBagConstraints();
		gbc_lb_contInfo.anchor = GridBagConstraints.WEST;
		gbc_lb_contInfo.insets = new Insets(0, 10, 5, 5);
		gbc_lb_contInfo.gridx = 0;
		gbc_lb_contInfo.gridy = 4;
		p_contact.add(lb_contInfo, gbc_lb_contInfo);
		
		ckbx_tele = new JCheckBox("电话:");
		GridBagConstraints gbc_ckbx_tele = new GridBagConstraints();
		gbc_ckbx_tele.anchor = GridBagConstraints.WEST;
		gbc_ckbx_tele.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_tele.gridx = 1;
		gbc_ckbx_tele.gridy = 4;
		p_contact.add(ckbx_tele, gbc_ckbx_tele);
		ckbx_tele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (ckbx_tele.isSelected()) {
						tf_tele.setEditable(true);
						tf_tele.setBackground(white);
					}else {
						tf_tele.setEditable(false);
						tf_tele.setBackground(Grey);
						tf_tele.setText("");
					}
			}
		});
		
		tf_tele = new JTextField();
		tf_tele.setEditable(false);
		GridBagConstraints gbc_tf_tele = new GridBagConstraints();
		gbc_tf_tele.gridwidth = 3;
		gbc_tf_tele.insets = new Insets(0, 0, 5, 5);
		gbc_tf_tele.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_tele.gridx = 2;
		gbc_tf_tele.gridy = 4;
		p_contact.add(tf_tele, gbc_tf_tele);
		
		ckbx_addr = new JCheckBox("地址:");
		GridBagConstraints gbc_ckbx_addr = new GridBagConstraints();
		gbc_ckbx_addr.anchor = GridBagConstraints.WEST;
		gbc_ckbx_addr.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_addr.gridx = 1;
		gbc_ckbx_addr.gridy = 5;
		p_contact.add(ckbx_addr, gbc_ckbx_addr);
		ckbx_addr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_addr.isSelected()) {
					tf_addr.setEditable(true);
					tf_city.setEditable(true);
					tf_admi.setEditable(true);
					tf_country.setEditable(true);
					tf_code.setEditable(true);
					tf_email.setEditable(true);
					tf_addr.setBackground(white);
					tf_city.setBackground(white);
					tf_admi.setBackground(white);
					tf_country.setBackground(white);
					tf_code.setBackground(white);
					tf_email.setBackground(white);
				}else {
					tf_addr.setEditable(false);
					tf_city.setEditable(false);
					tf_admi.setEditable(false);
					tf_country.setEditable(false);
					tf_code.setEditable(false);
					tf_email.setEditable(false);
					tf_addr.setBackground(Grey);
					tf_city.setBackground(Grey);
					tf_admi.setBackground(Grey);
					tf_country.setBackground(Grey);
					tf_code.setBackground(Grey);
					tf_email.setBackground(Grey);
					tf_addr.setText("");
					tf_city.setText("");
					tf_admi.setText("");
					tf_country.setText("");
					tf_code.setText("");
					tf_email.setText("");
				}	
			}
		});
		
		JLabel lb_tipETM = new JLabel("请在以下两种方式中选择一种描述事件时间。");
		lb_tipETM.setForeground(new Color(47, 79, 79));
		lb_tipETM.setFont(new Font("宋体", Font.ITALIC, 12));
		GridBagConstraints gbc_lb_tipETM = new GridBagConstraints();
		gbc_lb_tipETM.anchor = GridBagConstraints.SOUTH;
		gbc_lb_tipETM.gridwidth = 6;
		gbc_lb_tipETM.insets = new Insets(0, 0, 5, 0);
		gbc_lb_tipETM.gridx = 5;
		gbc_lb_tipETM.gridy = 5;
		p_contact.add(lb_tipETM, gbc_lb_tipETM);
		
		JLabel labeladress = new JLabel("邮寄地址:");
		GridBagConstraints gbc_labeladress = new GridBagConstraints();
		gbc_labeladress.anchor = GridBagConstraints.WEST;
		gbc_labeladress.insets = new Insets(0, 0, 5, 5);
		gbc_labeladress.gridx = 1;
		gbc_labeladress.gridy = 6;
		p_contact.add(labeladress, gbc_labeladress);
		
		tf_addr = new JTextField();
		tf_addr.setEditable(false);
		GridBagConstraints gbc_tf_addr = new GridBagConstraints();
		gbc_tf_addr.gridwidth = 3;
		gbc_tf_addr.insets = new Insets(0, 0, 5, 5);
		gbc_tf_addr.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_addr.gridx = 2;
		gbc_tf_addr.gridy = 6;
		p_contact.add(tf_addr, gbc_tf_addr);
		
		rbt_ETime = new JRadioButton("事件时间范围:");
		bg_eventTM.add(rbt_ETime);
		GridBagConstraints gbc_rbt_ETime = new GridBagConstraints();
		gbc_rbt_ETime.anchor = GridBagConstraints.WEST;
		gbc_rbt_ETime.gridwidth = 2;
		gbc_rbt_ETime.insets = new Insets(0, 0, 5, 5);
		gbc_rbt_ETime.gridx = 5;
		gbc_rbt_ETime.gridy = 6;
		p_contact.add(rbt_ETime, gbc_rbt_ETime);
		rbt_ETime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbt_ETime.isSelected()) {
					tf_EBeginTM.setEditable(true);
					tf_EEndTM.setEditable(true);
					tf_EBeginTM.setBackground(white);
					tf_EEndTM.setBackground(white);
					tf_ETMIns.setEditable(false);
					tf_ETMIns.setBackground(Grey);
					tf_ETMIns.setText("");
				}	
			}
		});
		
		JLabel lb_city = new JLabel("城市:");
		GridBagConstraints gbc_lb_city = new GridBagConstraints();
		gbc_lb_city.anchor = GridBagConstraints.WEST;
		gbc_lb_city.insets = new Insets(0, 0, 5, 5);
		gbc_lb_city.gridx = 1;
		gbc_lb_city.gridy = 7;
		p_contact.add(lb_city, gbc_lb_city);
		
		tf_city = new JTextField();
		tf_city.setEditable(false);
		GridBagConstraints gbc_tf_city = new GridBagConstraints();
		gbc_tf_city.gridwidth = 3;
		gbc_tf_city.insets = new Insets(0, 0, 5, 5);
		gbc_tf_city.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_city.gridx = 2;
		gbc_tf_city.gridy = 7;
		p_contact.add(tf_city, gbc_tf_city);
		
		JLabel lb_EBeginTM = new JLabel(" 起始时间:");
		GridBagConstraints gbc_lb_EBeginTM = new GridBagConstraints();
		gbc_lb_EBeginTM.anchor = GridBagConstraints.EAST;
		gbc_lb_EBeginTM.insets = new Insets(0, 0, 5, 5);
		gbc_lb_EBeginTM.gridx = 5;
		gbc_lb_EBeginTM.gridy = 7;
		p_contact.add(lb_EBeginTM, gbc_lb_EBeginTM);
		
		tf_EBeginTM = new JTextField();
		hintText ebgTMHint = new hintText(tf_EBeginTM, "2017-08-01T11:30:00.000Z");
		tf_EBeginTM.addFocusListener(new JTextFieldHintListener("2017-08-01T11:30:00.000Z", tf_EBeginTM));
		tf_EBeginTM.setEditable(false);
		GridBagConstraints gbc_tf_EBeginTM = new GridBagConstraints();
		gbc_tf_EBeginTM.gridwidth = 5;
		gbc_tf_EBeginTM.insets = new Insets(0, 0, 5, 10);
		gbc_tf_EBeginTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_EBeginTM.gridx = 6;
		gbc_tf_EBeginTM.gridy = 7;
		p_contact.add(tf_EBeginTM, gbc_tf_EBeginTM);
		
		JLabel lb_admi = new JLabel("行政区域:");
		GridBagConstraints gbc_lb_admi = new GridBagConstraints();
		gbc_lb_admi.anchor = GridBagConstraints.WEST;
		gbc_lb_admi.insets = new Insets(0, 0, 5, 5);
		gbc_lb_admi.gridx = 1;
		gbc_lb_admi.gridy = 8;
		p_contact.add(lb_admi, gbc_lb_admi);
		
		tf_admi = new JTextField();
		tf_admi.setEditable(false);
		GridBagConstraints gbc_tf_admi = new GridBagConstraints();
		gbc_tf_admi.gridwidth = 3;
		gbc_tf_admi.insets = new Insets(0, 0, 5, 5);
		gbc_tf_admi.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_admi.gridx = 2;
		gbc_tf_admi.gridy = 8;
		p_contact.add(tf_admi, gbc_tf_admi);
		
		JLabel lb_EEndTM = new JLabel(" 结束时间:");
		GridBagConstraints gbc_lb_EEndTM = new GridBagConstraints();
		gbc_lb_EEndTM.anchor = GridBagConstraints.EAST;
		gbc_lb_EEndTM.insets = new Insets(0, 0, 5, 5);
		gbc_lb_EEndTM.gridx = 5;
		gbc_lb_EEndTM.gridy = 8;
		p_contact.add(lb_EEndTM, gbc_lb_EEndTM);
		
		tf_EEndTM = new JTextField();
		hintText eedTMHint = new hintText(tf_EEndTM, "2017-08-01T18:30:00.000Z");
		tf_EEndTM.addFocusListener(new JTextFieldHintListener("2017-08-01T18:30:00.000Z", tf_EEndTM));
		tf_EEndTM.setEditable(false);
		GridBagConstraints gbc_tf_EEndTM = new GridBagConstraints();
		gbc_tf_EEndTM.gridwidth = 5;
		gbc_tf_EEndTM.insets = new Insets(0, 0, 5, 10);
		gbc_tf_EEndTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_EEndTM.gridx = 6;
		gbc_tf_EEndTM.gridy = 8;
		p_contact.add(tf_EEndTM, gbc_tf_EEndTM);
		
		JLabel lb_country = new JLabel("国家:");
		GridBagConstraints gbc_lb_country = new GridBagConstraints();
		gbc_lb_country.anchor = GridBagConstraints.WEST;
		gbc_lb_country.insets = new Insets(0, 0, 5, 5);
		gbc_lb_country.gridx = 1;
		gbc_lb_country.gridy = 9;
		p_contact.add(lb_country, gbc_lb_country);
		
		tf_country = new JTextField();
		tf_country.setEditable(false);
		GridBagConstraints gbc_tf_country = new GridBagConstraints();
		gbc_tf_country.gridwidth = 3;
		gbc_tf_country.insets = new Insets(0, 0, 5, 5);
		gbc_tf_country.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_country.gridx = 2;
		gbc_tf_country.gridy = 9;
		p_contact.add(tf_country, gbc_tf_country);
		
		rbt_ETMIns = new JRadioButton("事件时刻:");
		bg_eventTM.add(rbt_ETMIns);
		GridBagConstraints gbc_rbt_ETMIns = new GridBagConstraints();
		gbc_rbt_ETMIns.insets = new Insets(0, 0, 5, 5);
		gbc_rbt_ETMIns.gridx = 5;
		gbc_rbt_ETMIns.gridy = 9;
		p_contact.add(rbt_ETMIns, gbc_rbt_ETMIns);
		rbt_ETMIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbt_ETMIns.isSelected()) {
					tf_ETMIns.setEditable(true);
					tf_ETMIns.setBackground(white);
					tf_EBeginTM.setEditable(false);
					tf_EEndTM.setEditable(false);
					tf_EBeginTM.setBackground(Grey);
					tf_EEndTM.setBackground(Grey);
					tf_EBeginTM.setText("");
					tf_EEndTM.setText("");
				}	
			}
		});
		
		tf_ETMIns = new JTextField();
		hintText eventInstanceHint = new hintText(tf_ETMIns, "2017-08-01T11:30:00.000Z");
		tf_ETMIns.addFocusListener(new JTextFieldHintListener("2017-08-01T11:30:00.000Z", tf_ETMIns));
		tf_ETMIns.setEditable(false);
		GridBagConstraints gbc_tf_ETMIns = new GridBagConstraints();
		gbc_tf_ETMIns.gridwidth = 5;
		gbc_tf_ETMIns.insets = new Insets(0, 0, 5, 10);
		gbc_tf_ETMIns.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_ETMIns.gridx = 6;
		gbc_tf_ETMIns.gridy = 9;
		p_contact.add(tf_ETMIns, gbc_tf_ETMIns);
		
		JButton bt_addE = new JButton("增加");
		bt_addE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_eventId.getText(),tf_eventLabel.getText()};
				model_event.addRow(info);
			}
		});
		
		JLabel lb_code = new JLabel("邮政编码:");
		GridBagConstraints gbc_lb_code = new GridBagConstraints();
		gbc_lb_code.anchor = GridBagConstraints.WEST;
		gbc_lb_code.insets = new Insets(0, 0, 5, 5);
		gbc_lb_code.gridx = 1;
		gbc_lb_code.gridy = 10;
		p_contact.add(lb_code, gbc_lb_code);
		
		tf_code = new JTextField();
		tf_code.setEditable(false);
		GridBagConstraints gbc_tf_code = new GridBagConstraints();
		gbc_tf_code.gridwidth = 3;
		gbc_tf_code.insets = new Insets(0, 0, 5, 5);
		gbc_tf_code.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_code.gridx = 2;
		gbc_tf_code.gridy = 10;
		p_contact.add(tf_code, gbc_tf_code);
		GridBagConstraints gbc_bt_addE = new GridBagConstraints();
		gbc_bt_addE.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addE.gridx = 9;
		gbc_bt_addE.gridy = 10;
		p_contact.add(bt_addE, gbc_bt_addE);
		
		JButton bt_deleE = new JButton("删除");
		bt_deleE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_event.getSelectedRow();
				if(selectedRow!=-1)  //存在选中行
                {
                    model_event.removeRow(selectedRow);  //删除行
                }
			}
		});
		GridBagConstraints gbc_bt_deleE = new GridBagConstraints();
		gbc_bt_deleE.insets = new Insets(0, 0, 5, 10);
		gbc_bt_deleE.gridx = 10;
		gbc_bt_deleE.gridy = 10;
		p_contact.add(bt_deleE, gbc_bt_deleE);
		
		JLabel lb_email = new JLabel("电子邮箱:");
		GridBagConstraints gbc_lb_email = new GridBagConstraints();
		gbc_lb_email.anchor = GridBagConstraints.WEST;
		gbc_lb_email.insets = new Insets(0, 0, 5, 5);
		gbc_lb_email.gridx = 1;
		gbc_lb_email.gridy = 11;
		p_contact.add(lb_email, gbc_lb_email);
		
		tf_email = new JTextField();
		tf_email.setEditable(false);
		GridBagConstraints gbc_tf_email = new GridBagConstraints();
		gbc_tf_email.gridwidth = 3;
		gbc_tf_email.insets = new Insets(0, 0, 5, 5);
		gbc_tf_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_email.gridx = 2;
		gbc_tf_email.gridy = 11;
		p_contact.add(tf_email, gbc_tf_email);
		
		JScrollPane scrollPane_13 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_13 = new GridBagConstraints();
		gbc_scrollPane_13.gridheight = 3;
		gbc_scrollPane_13.gridwidth = 6;
		gbc_scrollPane_13.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_13.insets = new Insets(0, 5, 5, 10);
		gbc_scrollPane_13.gridx = 5;
		gbc_scrollPane_13.gridy = 11;
		p_contact.add(scrollPane_13, gbc_scrollPane_13);
		
		tb_event = new JTable();
		tb_event.setBackground(new Color(175, 238, 238));
		model_event = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"事件编号", "事件标签"
				}
			);
		tb_event.setModel(model_event);
		scrollPane_13.setViewportView(tb_event);
		tb_event.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton bt_addCon = new JButton("增加");
		bt_addCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {cbbx_role.getSelectedItem().toString(),tf_orgniz.getText()};
				model_contact.addRow(info);//添加一行
			}
		});
		GridBagConstraints gbc_bt_addCon = new GridBagConstraints();
		gbc_bt_addCon.anchor = GridBagConstraints.SOUTH;
		gbc_bt_addCon.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addCon.gridx = 3;
		gbc_bt_addCon.gridy = 12;
		p_contact.add(bt_addCon, gbc_bt_addCon);
		
		JButton bt_deleCon = new JButton("删除");
		bt_deleCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_contacID.getSelectedRow();//获得选中行的索引
				if(selectedRow!=-1)  //存在选中行
                {
                    model_contact.removeRow(selectedRow);  //删除行
                }
			}
		});
		GridBagConstraints gbc_bt_deleCon = new GridBagConstraints();
		gbc_bt_deleCon.insets = new Insets(0, 0, 5, 5);
		gbc_bt_deleCon.gridx = 4;
		gbc_bt_deleCon.gridy = 12;
		p_contact.add(bt_deleCon, gbc_bt_deleCon);
		
		JLabel lb_interface = new JLabel("服务接口");
		lb_interface.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_interface = new GridBagConstraints();
		gbc_lb_interface.fill = GridBagConstraints.HORIZONTAL;
		gbc_lb_interface.gridwidth = 2;
		gbc_lb_interface.insets = new Insets(0, 0, 5, 5);
		gbc_lb_interface.gridx = 5;
		gbc_lb_interface.gridy = 14;
		p_contact.add(lb_interface, gbc_lb_interface);
		
		JButton bt_addInte = new JButton("增加");
		bt_addInte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				interfaceDialog interfaceDialog = new interfaceDialog();
				interfaceDialog.setLocationRelativeTo(frame);
				interfaceDialog.setVisible(true);
				interfaceDialog.setAlwaysOnTop(true);
			}
		});
		GridBagConstraints gbc_bt_addInte = new GridBagConstraints();
		gbc_bt_addInte.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addInte.gridx = 9;
		gbc_bt_addInte.gridy = 14;
		p_contact.add(bt_addInte, gbc_bt_addInte);
		
		JButton bt_deleInte = new JButton("删除");
		bt_deleInte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_inte.getSelectedRow();
				if(selectedRow!=-1) 
                {
                    model_interface.removeRow(selectedRow); 
                }
			}
		});
		GridBagConstraints gbc_bt_deleInte = new GridBagConstraints();
		gbc_bt_deleInte.insets = new Insets(0, 0, 5, 10);
		gbc_bt_deleInte.gridx = 10;
		gbc_bt_deleInte.gridy = 14;
		p_contact.add(bt_deleInte, gbc_bt_deleInte);
		
		JScrollPane scrollPane_11 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_11 = new GridBagConstraints();
		gbc_scrollPane_11.gridheight = 3;
		gbc_scrollPane_11.insets = new Insets(0, 5, 5, 10);
		gbc_scrollPane_11.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_11.gridwidth = 6;
		gbc_scrollPane_11.gridx = 5;
		gbc_scrollPane_11.gridy = 15;
		p_contact.add(scrollPane_11, gbc_scrollPane_11);
		
		tb_inte = new JTable();
		tb_inte.setBackground(new Color(175, 238, 238));
		model_interface = new DefaultTableModel(
				new Object[][] {},
				new String[] {"接口名称", "服务类型", "服务地址", "传感器标识码"});
		tb_inte.setModel(model_interface);
		tb_inte.getColumnModel().getColumn(0).setPreferredWidth(60);
		tb_inte.getColumnModel().getColumn(1).setPreferredWidth(60);
		tb_inte.getColumnModel().getColumn(2).setPreferredWidth(58);
		tb_inte.getColumnModel().getColumn(3).setPreferredWidth(95);
		scrollPane_11.setViewportView(tb_inte);
		
		JScrollPane scrollPane_10 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_10 = new GridBagConstraints();
		gbc_scrollPane_10.gridheight = 3;
		gbc_scrollPane_10.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_10.gridwidth = 5;
		gbc_scrollPane_10.insets = new Insets(0, 15, 5, 5);
		gbc_scrollPane_10.gridx = 0;
		gbc_scrollPane_10.gridy = 13;
		p_contact.add(scrollPane_10, gbc_scrollPane_10);
		
		tb_contacID = new JTable();
		model_contact =new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"负责单位", "联系组织"
				}
			);
		tb_contacID.setModel(model_contact);
		scrollPane_10.setViewportView(tb_contacID);
		tb_contacID.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		p_component = new JPanel();
		tp_content.addTab("传感器部件信息", null, p_component, null);
		GridBagLayout gbl_p_component = new GridBagLayout();
		gbl_p_component.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_p_component.rowHeights = new int[]{0, 52, 0, 0, 0, 0, 0, 0};
		gbl_p_component.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_p_component.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		p_component.setLayout(gbl_p_component);
		
		ckbx_input = new JCheckBox("添加输入：");
		ckbx_input.setSelected(true);
		GridBagConstraints gbc_ckbx_input = new GridBagConstraints();
		gbc_ckbx_input.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_input.gridx = 0;
		gbc_ckbx_input.gridy = 0;
		p_component.add(ckbx_input, gbc_ckbx_input);
		
		bt_addInput = new JButton("增加");
		bt_addInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputDialog in = new inputDialog();
				in.setLocationRelativeTo(frame);
				in.setAlwaysOnTop(true);
				in.setVisible(true);
			}
		});
		GridBagConstraints gbc_bt_addInput = new GridBagConstraints();
		gbc_bt_addInput.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addInput.gridx = 2;
		gbc_bt_addInput.gridy = 0;
		p_component.add(bt_addInput, gbc_bt_addInput);
		
		bt_deleInput = new JButton("删除");
		bt_deleInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_input.getSelectedRow();
				if (selectedRow != -1) {
					model_input.removeRow(selectedRow);
				}
			}
		});
		GridBagConstraints gbc_bt_deleInput = new GridBagConstraints();
		gbc_bt_deleInput.insets = new Insets(0, 0, 5, 15);
		gbc_bt_deleInput.gridx = 3;
		gbc_bt_deleInput.gridy = 0;
		p_component.add(bt_deleInput, gbc_bt_deleInput);
		
		scrollPane_14 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_14 = new GridBagConstraints();
		gbc_scrollPane_14.insets = new Insets(0, 10, 5, 10);
		gbc_scrollPane_14.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_14.gridwidth = 4;
		gbc_scrollPane_14.gridx = 0;
		gbc_scrollPane_14.gridy = 1;
		p_component.add(scrollPane_14, gbc_scrollPane_14);
		
		tb_input = new JTable();
		scrollPane_14.setViewportView(tb_input);
		model_input = new DefaultTableModel(new Object[][] {},new String[] {"输入现象名称：", "输入现象定义："});
		tb_input.setModel(model_input);
		tb_input.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tb_input.setBackground(new Color(176, 224, 230));
		
		ckbx_output = new JCheckBox("添加输出：");
		ckbx_output.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_output.isSelected()) {
					bt_addOutput.setEnabled(true);
					bt_deleOutput.setEnabled(true);
				}else {
					bt_addOutput.setEnabled(false);
					bt_deleOutput.setEnabled(false);
					model_output.setRowCount(0);
				}
			}
		});
		GridBagConstraints gbc_ckbx_output = new GridBagConstraints();
		gbc_ckbx_output.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_output.gridx = 0;
		gbc_ckbx_output.gridy = 2;
		p_component.add(ckbx_output, gbc_ckbx_output);
		
		bt_addOutput = new JButton("增加");
		bt_addOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputDialog out = new outputDialog();
				out.setLocationRelativeTo(frame);
				out.setAlwaysOnTop(true);
				out.setVisible(true);
			}
		});
		bt_addOutput.setEnabled(false);
		GridBagConstraints gbc_bt_addOutput = new GridBagConstraints();
		gbc_bt_addOutput.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addOutput.gridx = 2;
		gbc_bt_addOutput.gridy = 2;
		p_component.add(bt_addOutput, gbc_bt_addOutput);
		
		bt_deleOutput = new JButton("删除");
		bt_deleOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_output.getSelectedRow();
				if (selectedRow != -1) {
					model_output.removeRow(selectedRow);
				}
			}
		});
		bt_deleOutput.setEnabled(false);
		GridBagConstraints gbc_bt_deleOutput = new GridBagConstraints();
		gbc_bt_deleOutput.insets = new Insets(0, 0, 5, 0);
		gbc_bt_deleOutput.gridx = 3;
		gbc_bt_deleOutput.gridy = 2;
		p_component.add(bt_deleOutput, gbc_bt_deleOutput);
		
		scrollPane_15 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_15 = new GridBagConstraints();
		gbc_scrollPane_15.insets = new Insets(0, 10, 5, 10);
		gbc_scrollPane_15.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_15.gridwidth = 4;
		gbc_scrollPane_15.gridx = 0;
		gbc_scrollPane_15.gridy = 3;
		p_component.add(scrollPane_15, gbc_scrollPane_15);
		
		tb_output = new JTable();
		model_output = new DefaultTableModel(new Object[][] {},new String[] {"输出名称", "输出定义", "输出单位"});
		tb_output.setModel(model_output);
		scrollPane_15.setViewportView(tb_output);
		tb_output.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tb_output.setBackground(new Color(176, 224, 230));
		
		ckbx_FOI = new JCheckBox("感兴趣特征（FOI）：");
		ckbx_FOI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_FOI.isSelected()) {
					bt_addFOI.setEnabled(true);
					bt_deleFOI.setEnabled(true);
				}else {
					bt_addFOI.setEnabled(false);
					bt_deleFOI.setEnabled(false);
					model_FOI.setRowCount(0);
				}
			}
		});
		GridBagConstraints gbc_ckbx_FOI = new GridBagConstraints();
		gbc_ckbx_FOI.anchor = GridBagConstraints.WEST;
		gbc_ckbx_FOI.gridwidth = 2;
		gbc_ckbx_FOI.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_FOI.gridx = 0;
		gbc_ckbx_FOI.gridy = 4;
		p_component.add(ckbx_FOI, gbc_ckbx_FOI);
		
		bt_addFOI = new JButton("增加");
		bt_addFOI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FOIDialog foiDialog = new FOIDialog();
				foiDialog.setLocationRelativeTo(frame);
				foiDialog.setAlwaysOnTop(true);
				foiDialog.setVisible(true);
			}
		});
		bt_addFOI.setEnabled(false);
		GridBagConstraints gbc_bt_addFOI = new GridBagConstraints();
		gbc_bt_addFOI.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addFOI.gridx = 2;
		gbc_bt_addFOI.gridy = 4;
		p_component.add(bt_addFOI, gbc_bt_addFOI);
		
		bt_deleFOI = new JButton("删除");
		bt_deleFOI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_FOI.getSelectedRow();
				if (selectedRow != -1) {
					model_FOI.removeRow(selectedRow);
				}
			}
		});
		bt_deleFOI.setEnabled(false);
		GridBagConstraints gbc_bt_deleFOI = new GridBagConstraints();
		gbc_bt_deleFOI.insets = new Insets(0, 0, 5, 0);
		gbc_bt_deleFOI.gridx = 3;
		gbc_bt_deleFOI.gridy = 4;
		p_component.add(bt_deleFOI, gbc_bt_deleFOI);
		
		JScrollPane scrollPane_16 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_16 = new GridBagConstraints();
		gbc_scrollPane_16.insets = new Insets(0, 10, 5, 10);
		gbc_scrollPane_16.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_16.gridwidth = 4;
		gbc_scrollPane_16.gridx = 0;
		gbc_scrollPane_16.gridy = 5;
		p_component.add(scrollPane_16, gbc_scrollPane_16);
		
		tb_FOI = new JTable();
		model_FOI = new DefaultTableModel(new Object[][] {},new String[] {"特征名称:","URL地址:"});
		tb_FOI.setModel(model_FOI);
		scrollPane_16.setViewportView(tb_FOI);
		tb_FOI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tb_FOI.setBackground(new Color(176, 224, 230));
		
		buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		bt_prePage = new JButton("<<");
		bt_prePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tp_content.getSelectedIndex();
				if (index==1||index==2||index==3||index==4) {
					tp_content.setSelectedIndex(index-1);
				}	
			}
		});
		buttonPanel.add(bt_prePage);
		
		bt_preItem = new JButton("<");
		bt_preItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tp_capa.getSelectedIndex();
				if (index==1||index==2) {
					tp_capa.setSelectedIndex(index-1);
				}
			}
		});
		buttonPanel.add(bt_preItem);
		
		JPanel p1 = new JPanel();
		buttonPanel.add(p1);
		
		bt_savePage = new JButton("保存编辑");
		bt_savePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savePageIsClicled = true;
				try {
					CreateScannerSensorXML.DomCreate();
					save.setEnabled(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		buttonPanel.add(bt_savePage);
		
		bt_quitPage = new JButton("放弃编辑");
		bt_quitPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();	
			}
		});
		buttonPanel.add(bt_quitPage);
		
		JPanel p2 = new JPanel();
		buttonPanel.add(p2);
		
		bt_nextItem = new JButton(">");
		bt_nextItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tp_capa.getSelectedIndex();
				if (index==0||index==1) {
					tp_capa.setSelectedIndex(index+1);
				}
			}
		});
		buttonPanel.add(bt_nextItem);
		
		bt_nextPage = new JButton(">>");
		bt_nextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tp_content.getSelectedIndex();
				if (index==0||index==1||index==2||index==3) {
					tp_content.setSelectedIndex(index+1);
				}
			}
		});
		buttonPanel.add(bt_nextPage);
		
		frame.dispose();
		frame.setVisible(true);
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
	
	public class hintText{
		public hintText(JTextField tf,String hint) {
			tf.setForeground(Color.GRAY);
			tf.setText(hint);
		}
	}
	
	//JTextfield中出现默认提示内容，当获取焦点时自动消失
	public class JTextFieldHintListener implements FocusListener {
	    private String HintText;
	    private JTextField TextField;

	    public JTextFieldHintListener(String hintText, JTextField textField) {
	        this.HintText = hintText;
	        this.TextField = textField;
	    }
	    @Override
	    public void focusGained(FocusEvent e) {
	        String temp = TextField.getText();
	        if(temp.equals(HintText)){
	            TextField.setText("");
	            TextField.setForeground(Color.BLACK);
	        }
	    }
	    @Override
	    public void focusLost(FocusEvent e) {
	        String temp = TextField.getText();
	        if(temp.equals("")){
	            TextField.setForeground(Color.GRAY);
	            TextField.setText(HintText);
	        }
	    }
	}
	
	class viewer extends JDialog{
		private final JPanel contentPanel = new JPanel();
		private JTextArea ta_view;
		
		public viewer() {
			setTitle("查看");
			setBounds(100, 100, 800, 700);
			setModal(true);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel = new JPanel();
				contentPanel.add(panel, BorderLayout.CENTER);
				panel.setLayout(new BorderLayout(0, 0));
				{
					ta_view = new JTextArea();
					JScrollPane jsp = new JScrollPane(ta_view);
					panel.add(jsp, BorderLayout.CENTER);
					ta_view.setEditable(false);
				}
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton cancelButton = new JButton("退出");
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					buttonPane.add(cancelButton);
				}
			}
			read();
		}
		
		public void read() {
			String cont = "";
			try{
				FileReader fr = new FileReader(savePath);
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
	
	public class optical_BandCharacteristic extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTextField tf_bandName;
		private JTextField tf_minBandWidth;
		private JTextField tf_maxBandWidth;
		private JTextField tf_spectralResolution;
		private JTextField tf_radiationResolution;
		private JTextArea ta_bandApplication;

		/**
		 * Create the dialog.
		 */
		public optical_BandCharacteristic() {
			setTitle("观测波段特征");
			setBounds(100, 100, 450, 300);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			GridBagLayout gbl_contentPanel = new GridBagLayout();
			gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			contentPanel.setLayout(gbl_contentPanel);
			{
				JLabel lb_bandName = new JLabel("\u6CE2\u6BB5\u540D\u79F0\uFF1A");
				GridBagConstraints gbc_lb_bandName = new GridBagConstraints();
				gbc_lb_bandName.insets = new Insets(0, 0, 5, 5);
				gbc_lb_bandName.gridx = 0;
				gbc_lb_bandName.gridy = 0;
				contentPanel.add(lb_bandName, gbc_lb_bandName);
			}
			{
				tf_bandName = new JTextField();
				GridBagConstraints gbc_tf_bandName = new GridBagConstraints();
				gbc_tf_bandName.gridwidth = 3;
				gbc_tf_bandName.insets = new Insets(0, 0, 5, 0);
				gbc_tf_bandName.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_bandName.gridx = 1;
				gbc_tf_bandName.gridy = 0;
				contentPanel.add(tf_bandName, gbc_tf_bandName);
				tf_bandName.setColumns(10);
			}
			{
				JLabel lb_bandWidthRange = new JLabel("\u6CE2\u6BB5\u5BBD\u5EA6\u8303\u56F4(\u03BCm)\uFF1A");
				GridBagConstraints gbc_lb_bandWidthRange = new GridBagConstraints();
				gbc_lb_bandWidthRange.anchor = GridBagConstraints.EAST;
				gbc_lb_bandWidthRange.insets = new Insets(0, 0, 5, 5);
				gbc_lb_bandWidthRange.gridx = 0;
				gbc_lb_bandWidthRange.gridy = 1;
				contentPanel.add(lb_bandWidthRange, gbc_lb_bandWidthRange);
			}
			{
				tf_minBandWidth = new JTextField();
				tf_minBandWidth.setColumns(10);
				GridBagConstraints gbc_tf_minBandWidth = new GridBagConstraints();
				gbc_tf_minBandWidth.insets = new Insets(0, 0, 5, 5);
				gbc_tf_minBandWidth.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_minBandWidth.gridx = 1;
				gbc_tf_minBandWidth.gridy = 1;
				contentPanel.add(tf_minBandWidth, gbc_tf_minBandWidth);
			}
			{
				JLabel lb_1 = new JLabel("-");
				GridBagConstraints gbc_lb_1 = new GridBagConstraints();
				gbc_lb_1.insets = new Insets(0, 0, 5, 5);
				gbc_lb_1.anchor = GridBagConstraints.EAST;
				gbc_lb_1.gridx = 2;
				gbc_lb_1.gridy = 1;
				contentPanel.add(lb_1, gbc_lb_1);
			}
			{
				tf_maxBandWidth = new JTextField();
				tf_maxBandWidth.setColumns(10);
				GridBagConstraints gbc_tf_maxBandWidth = new GridBagConstraints();
				gbc_tf_maxBandWidth.insets = new Insets(0, 0, 5, 0);
				gbc_tf_maxBandWidth.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_maxBandWidth.gridx = 3;
				gbc_tf_maxBandWidth.gridy = 1;
				contentPanel.add(tf_maxBandWidth, gbc_tf_maxBandWidth);
			}
			{
				JLabel lb_spectralResolution = new JLabel("\u5149\u8C31\u5206\u8FA8\u7387(nm)\uFF1A");
				GridBagConstraints gbc_lb_spectralResolution = new GridBagConstraints();
				gbc_lb_spectralResolution.anchor = GridBagConstraints.EAST;
				gbc_lb_spectralResolution.insets = new Insets(0, 0, 5, 5);
				gbc_lb_spectralResolution.gridx = 0;
				gbc_lb_spectralResolution.gridy = 2;
				contentPanel.add(lb_spectralResolution, gbc_lb_spectralResolution);
			}
			{
				tf_spectralResolution = new JTextField();
				tf_spectralResolution.setColumns(10);
				GridBagConstraints gbc_tf_spectralResolution = new GridBagConstraints();
				gbc_tf_spectralResolution.gridwidth = 3;
				gbc_tf_spectralResolution.insets = new Insets(0, 0, 5, 0);
				gbc_tf_spectralResolution.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_spectralResolution.gridx = 1;
				gbc_tf_spectralResolution.gridy = 2;
				contentPanel.add(tf_spectralResolution, gbc_tf_spectralResolution);
			}
			{
				JLabel lb_radiationResolution = new JLabel("\u8F90\u5C04\u5206\u8FA8\u7387\uFF1A");
				GridBagConstraints gbc_lb_radiationResolution = new GridBagConstraints();
				gbc_lb_radiationResolution.insets = new Insets(0, 0, 5, 5);
				gbc_lb_radiationResolution.gridx = 0;
				gbc_lb_radiationResolution.gridy = 3;
				contentPanel.add(lb_radiationResolution, gbc_lb_radiationResolution);
			}
			{
				tf_radiationResolution = new JTextField();
				tf_radiationResolution.setColumns(10);
				GridBagConstraints gbc_tf_radiationResolution = new GridBagConstraints();
				gbc_tf_radiationResolution.gridwidth = 3;
				gbc_tf_radiationResolution.insets = new Insets(0, 0, 5, 0);
				gbc_tf_radiationResolution.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_radiationResolution.gridx = 1;
				gbc_tf_radiationResolution.gridy = 3;
				contentPanel.add(tf_radiationResolution, gbc_tf_radiationResolution);
			}
			{
				JLabel lb_bandApplication = new JLabel("\u6CE2\u6BB5\u5E94\u7528\uFF1A");
				GridBagConstraints gbc_lb_bandApplication = new GridBagConstraints();
				gbc_lb_bandApplication.insets = new Insets(0, 0, 5, 5);
				gbc_lb_bandApplication.gridx = 0;
				gbc_lb_bandApplication.gridy = 4;
				contentPanel.add(lb_bandApplication, gbc_lb_bandApplication);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.gridheight = 2;
				gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridwidth = 3;
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 4;
				contentPanel.add(scrollPane, gbc_scrollPane);
				{
					ta_bandApplication = new JTextArea();
					scrollPane.setViewportView(ta_bandApplication);
				}
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("确认");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							opticalBandCharacter[0] = tf_bandName.getText();
							opticalBandCharacter[1] = tf_minBandWidth.getText()+" "+tf_maxBandWidth.getText();
							opticalBandCharacter[2] = tf_spectralResolution.getText();
							opticalBandCharacter[3] = tf_radiationResolution.getText();
							opticalBandCharacter[4] = ta_bandApplication.getText();
							model_opticalBandCharacter.addRow(opticalBandCharacter);
							tf_bandName.setText("");
							tf_minBandWidth.setText("");
							tf_maxBandWidth.setText("");
							tf_spectralResolution.setText("");
							tf_radiationResolution.setText("");
							ta_bandApplication.setText("");
						}
					});
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				}
				{
					JButton cancelButton = new JButton("取消");
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					cancelButton.setActionCommand("Cancel");
					buttonPane.add(cancelButton);
				}
			}
		}
		
		public String[] getContent() {
			String[] cStrings = {tf_bandName.getText(),
					tf_minBandWidth.getText()+" "+tf_maxBandWidth.getText(),
					tf_spectralResolution.getText(),
					tf_radiationResolution.getText(),
					};
			return cStrings;
		}
	}
	
	class interfaceDialog extends JDialog{
		private final JPanel contentPanel = new JPanel();
		private JTextField tf_name;
		private JTextField tf_type;
		private JTextField tf_URL;
		private JTextField tf_UID;
		
		public interfaceDialog() {
			setTitle("请输入服务接口信息：");
			setBounds(100, 100, 450, 300);
			setIconImage(Toolkit.getDefaultToolkit().getImage(ScannerSensorFrame.class.getResource("/sm/images/utils.png")));
			setAlwaysOnTop(true);
			setModal(true);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			GridBagLayout gbl_contentPanel = new GridBagLayout();
			gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			contentPanel.setLayout(gbl_contentPanel);
			{
				JLabel lb_name = new JLabel("接口名称：");
				GridBagConstraints gbc_lb_name = new GridBagConstraints();
				gbc_lb_name.insets = new Insets(0, 0, 5, 5);
				gbc_lb_name.anchor = GridBagConstraints.SOUTH;
				gbc_lb_name.gridx = 1;
				gbc_lb_name.gridy = 1;
				contentPanel.add(lb_name, gbc_lb_name);
			}
			{
				tf_name = new JTextField();
				hintText nameHint = new hintText(tf_name, "如：MODIS_SOS");
				tf_name.addFocusListener(new JTextFieldHintListener("如：MODIS_SOS", tf_name));
				GridBagConstraints gbc_tf_name = new GridBagConstraints();
				gbc_tf_name.gridwidth = 5;
				gbc_tf_name.insets = new Insets(0, 0, 5, 5);
				gbc_tf_name.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_name.gridx = 2;
				gbc_tf_name.gridy = 1;
				contentPanel.add(tf_name, gbc_tf_name);
				tf_name.setColumns(10);
			}
			{
				JLabel lb_type = new JLabel("接口类型：");
				GridBagConstraints gbc_lb_type = new GridBagConstraints();
				gbc_lb_type.insets = new Insets(0, 0, 5, 5);
				gbc_lb_type.gridx = 1;
				gbc_lb_type.gridy = 2;
				contentPanel.add(lb_type, gbc_lb_type);
			}
			{
				tf_type = new JTextField();
				hintText typeHint = new hintText(tf_type, "如：SOS");
				tf_type.addFocusListener(new JTextFieldHintListener("如：SOS", tf_type));
				tf_type.setColumns(10);
				GridBagConstraints gbc_tf_type = new GridBagConstraints();
				gbc_tf_type.gridwidth = 5;
				gbc_tf_type.insets = new Insets(0, 0, 5, 5);
				gbc_tf_type.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_type.gridx = 2;
				gbc_tf_type.gridy = 2;
				contentPanel.add(tf_type, gbc_tf_type);
			}
			{
				JLabel lb_URL = new JLabel("服务地址(URL)：");
				GridBagConstraints gbc_lb_URL = new GridBagConstraints();
				gbc_lb_URL.insets = new Insets(0, 0, 5, 5);
				gbc_lb_URL.gridx = 1;
				gbc_lb_URL.gridy = 3;
				contentPanel.add(lb_URL, gbc_lb_URL);
			}
			{
				tf_URL = new JTextField();
				hintText URLHint = new hintText(tf_URL, "如：http://swe.cn/SOS/MODIS_SOS");
				tf_URL.addFocusListener(new JTextFieldHintListener("如：http://swe.cn/SOS/MODIS_SOS", tf_URL));
				tf_URL.setColumns(10);
				GridBagConstraints gbc_tf_URL = new GridBagConstraints();
				gbc_tf_URL.gridwidth = 5;
				gbc_tf_URL.insets = new Insets(0, 0, 5, 5);
				gbc_tf_URL.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_URL.gridx = 2;
				gbc_tf_URL.gridy = 3;
				contentPanel.add(tf_URL, gbc_tf_URL);
			}
			{
				JLabel lb_ = new JLabel("传感器标识码：");
				GridBagConstraints gbc_lb_ = new GridBagConstraints();
				gbc_lb_.insets = new Insets(0, 0, 5, 5);
				gbc_lb_.gridx = 1;
				gbc_lb_.gridy = 4;
				contentPanel.add(lb_, gbc_lb_);
			}
			{
				tf_UID = new JTextField();
				hintText UIDHint = new hintText(tf_UID, "如：MODIS");
				tf_UID.addFocusListener(new JTextFieldHintListener("如：MODIS", tf_UID));
				tf_UID.setColumns(10);
				GridBagConstraints gbc_tf_UID = new GridBagConstraints();
				gbc_tf_UID.gridwidth = 5;
				gbc_tf_UID.insets = new Insets(0, 0, 5, 5);
				gbc_tf_UID.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_UID.gridx = 2;
				gbc_tf_UID.gridy = 4;
				contentPanel.add(tf_UID, gbc_tf_UID);
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("确认");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String[] info = {tf_name.getText(),tf_type.getText(),tf_URL.getText(),"urn:ogc:feature:sensor:OGC:1.0:"+tf_UID.getText()};
							model_interface.addRow(info);
							tf_name.setText("");
							tf_type.setText("");
							tf_URL.setText("");
							tf_UID.setText("");
						}
					});
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				}
				{
					JButton cancelButton = new JButton("取消");
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					buttonPane.add(cancelButton);
				}
			}
		}
	}
	
	class inputDialog extends JDialog{
		private final JPanel contentPanel = new JPanel();
		private JTextField tf_inputName;
		private JTextField tf_inputDefinition;
		
		public inputDialog() {
			setBounds(100, 100, 450, 300);
			setTitle("输入对话框");
			setIconImage(Toolkit.getDefaultToolkit().getImage(ScannerSensorFrame.class.getResource("/sm/images/utils.png")));
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			setModal(true);
			GridBagLayout gbl_contentPanel = new GridBagLayout();
			gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			contentPanel.setLayout(gbl_contentPanel);
			{
				JLabel lb_inputName = new JLabel("输入现象名称：");
				GridBagConstraints gbc_lb_inputName = new GridBagConstraints();
				gbc_lb_inputName.anchor = GridBagConstraints.EAST;
				gbc_lb_inputName.insets = new Insets(0, 0, 5, 5);
				gbc_lb_inputName.gridx = 1;
				gbc_lb_inputName.gridy = 1;
				contentPanel.add(lb_inputName, gbc_lb_inputName);
			}
			{
				tf_inputName = new JTextField();
				hintText inNameHint = new hintText(tf_inputName, "如：温度");
				tf_inputName.addFocusListener(new JTextFieldHintListener("如：温度", tf_inputName));
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.gridwidth = 5;
				gbc_textField.insets = new Insets(0, 0, 5, 5);
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.gridx = 2;
				gbc_textField.gridy = 1;
				contentPanel.add(tf_inputName, gbc_textField);
				tf_inputName.setColumns(10);
			}
			{
				JLabel lb_inoutDefinition = new JLabel("输入现象定义：");
				GridBagConstraints gbc_lb_inoutDefinition = new GridBagConstraints();
				gbc_lb_inoutDefinition.anchor = GridBagConstraints.EAST;
				gbc_lb_inoutDefinition.insets = new Insets(0, 0, 5, 5);
				gbc_lb_inoutDefinition.gridx = 1;
				gbc_lb_inoutDefinition.gridy = 2;
				contentPanel.add(lb_inoutDefinition, gbc_lb_inoutDefinition);
			}
			{
				tf_inputDefinition = new JTextField();
				hintText inDefHint = new hintText(tf_inputDefinition, "如：AirTemperature");
				tf_inputDefinition.addFocusListener(new JTextFieldHintListener("如：AirTemperature", tf_inputDefinition));
				tf_inputDefinition.setColumns(10);
				GridBagConstraints gbc_tf_inputDefinition = new GridBagConstraints();
				gbc_tf_inputDefinition.gridwidth = 5;
				gbc_tf_inputDefinition.insets = new Insets(0, 0, 5, 5);
				gbc_tf_inputDefinition.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_inputDefinition.gridx = 2;
				gbc_tf_inputDefinition.gridy = 2;
				contentPanel.add(tf_inputDefinition, gbc_tf_inputDefinition);
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("确认");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String[] info = {tf_inputName.getText(),"urn:ogc:def:property:OGC:1.0:"+tf_inputDefinition.getText()};
							model_input.addRow(info);
							tf_inputDefinition.setText("");
							tf_inputName.setText("");
						}
					});
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				}
				{
					JButton cancelButton = new JButton("取消");
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					buttonPane.add(cancelButton);
				}
			}
		}
	}
	
	class outputDialog extends JDialog{
		private final JPanel contentPanel = new JPanel();
		private JTextField tf_outputname;
		private JTextField tf_outputDefinition;
		private JTextField tf_outputUom;

		/**
		 * Create the dialog.
		 */
		public outputDialog() {
			setTitle("输入对话框");
			setBounds(100, 100, 450, 300);
			setIconImage(Toolkit.getDefaultToolkit().getImage(ScannerSensorFrame.class.getResource("/sm/images/utils.png")));
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			setModal(true);
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			GridBagLayout gbl_contentPanel = new GridBagLayout();
			gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
			gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			contentPanel.setLayout(gbl_contentPanel);
			{
				JLabel lb_outputName = new JLabel("输出名称：");
				GridBagConstraints gbc_lb_outputName = new GridBagConstraints();
				gbc_lb_outputName.anchor = GridBagConstraints.EAST;
				gbc_lb_outputName.insets = new Insets(0, 0, 5, 5);
				gbc_lb_outputName.gridx = 1;
				gbc_lb_outputName.gridy = 1;
				contentPanel.add(lb_outputName, gbc_lb_outputName);
			}
			{
				tf_outputname = new JTextField();
				hintText outDefHint = new hintText(tf_outputname, "如：温度");
				tf_outputname.addFocusListener(new JTextFieldHintListener("如：温度", tf_outputname));
				GridBagConstraints gbc_tf_outputname = new GridBagConstraints();
				gbc_tf_outputname.gridwidth = 6;
				gbc_tf_outputname.insets = new Insets(0, 0, 5, 5);
				gbc_tf_outputname.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_outputname.gridx = 2;
				gbc_tf_outputname.gridy = 1;
				contentPanel.add(tf_outputname, gbc_tf_outputname);
				tf_outputname.setColumns(10);
			}
			{
				JLabel lb_outputDefinition = new JLabel("输出定义：");
				GridBagConstraints gbc_lb_outputDefinition = new GridBagConstraints();
				gbc_lb_outputDefinition.anchor = GridBagConstraints.EAST;
				gbc_lb_outputDefinition.insets = new Insets(0, 0, 5, 5);
				gbc_lb_outputDefinition.gridx = 1;
				gbc_lb_outputDefinition.gridy = 2;
				contentPanel.add(lb_outputDefinition, gbc_lb_outputDefinition);
			}
			{
				tf_outputDefinition = new JTextField();
				hintText outDefHint = new hintText(tf_outputDefinition, "如：Temperature");
				tf_outputDefinition.addFocusListener(new JTextFieldHintListener("如：Temperature", tf_outputDefinition));
				tf_outputDefinition.setColumns(10);
				GridBagConstraints gbc_tf_outputDefinition = new GridBagConstraints();
				gbc_tf_outputDefinition.gridwidth = 6;
				gbc_tf_outputDefinition.insets = new Insets(0, 0, 5, 5);
				gbc_tf_outputDefinition.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_outputDefinition.gridx = 2;
				gbc_tf_outputDefinition.gridy = 2;
				contentPanel.add(tf_outputDefinition, gbc_tf_outputDefinition);
			}
			{
				JLabel lb_outputUom = new JLabel("输出单位：");
				GridBagConstraints gbc_lb_outputUom = new GridBagConstraints();
				gbc_lb_outputUom.anchor = GridBagConstraints.EAST;
				gbc_lb_outputUom.insets = new Insets(0, 0, 5, 5);
				gbc_lb_outputUom.gridx = 1;
				gbc_lb_outputUom.gridy = 3;
				contentPanel.add(lb_outputUom, gbc_lb_outputUom);
			}
			{
				tf_outputUom = new JTextField();
				hintText uomDefHint = new hintText(tf_outputUom, "如：cel");
				tf_outputUom.addFocusListener(new JTextFieldHintListener("如：cel", tf_outputUom));
				tf_outputUom.setColumns(10);
				GridBagConstraints gbc_tf_outputUom = new GridBagConstraints();
				gbc_tf_outputUom.gridwidth = 6;
				gbc_tf_outputUom.insets = new Insets(0, 0, 5, 5);
				gbc_tf_outputUom.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_outputUom.gridx = 2;
				gbc_tf_outputUom.gridy = 3;
				contentPanel.add(tf_outputUom, gbc_tf_outputUom);
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("确认");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String[] info= {tf_outputname.getText(),tf_outputDefinition.getText(),tf_outputUom.getText()};
							model_output.addRow(info);
							tf_outputname.setText("");
							tf_outputDefinition.setText("");
							tf_outputUom.setText("");
						}
					});
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				}
				{
					JButton cancelButton = new JButton("取消");
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					buttonPane.add(cancelButton);
				}
			}
		}
	}
	
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
			setIconImage(Toolkit.getDefaultToolkit().getImage(ScannerSensorFrame.class.getResource("/sm/images/utils.png")));
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
				JLabel lb_foiLink = new JLabel("URL地址：");
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
							model_FOI.addRow(info);
							tf_foiName.setText("");
							tf_foiLink.setText("");
						}
					});
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				}
				{
					JButton cancelButton = new JButton("退出");
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					buttonPane.add(cancelButton);
				}
			}
		}
	}

}
