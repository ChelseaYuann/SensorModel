package sm.InsituSensor_xml;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sm.main.UploadFrame;
import sm.remoteSensor_xml.FrameSensorFrame;
import sm.remoteSensor_xml.FrameSensorFrame.FOIDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.media.sound.ModelAbstractChannelMixer;

import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;


public class InsituSensorFrame extends JFrame{

	private static String savePath = "src/instance/insituSensor.xml";
	private JFrame frame;
	private Color Grey = UIManager.getColor("TextArea.disabledBackground");
	private JButton save;
	private JButton clear;
	private JButton view;
	private JButton documents;
	private boolean saveIsClicked = false;
	private boolean savePageIsClicled = false;
	private JButton bt_savePage;
	private JButton bt_exitPage;
	private JButton bt_lastPage;
	private JButton bt_nextPage;
	private int index = 0;
	private static JTextField tf_UID;
	private static JTextArea ta_description;
	private JTextField tf_keywords;
	private static JTextField tf_sensorType1;
	private static JTextField tf_sensorType2;
	private static JComboBox cbbx_shareLevel;
	private static JTextField tf_longName;
	private static JTextField tf_shortName;
	private static JTextArea ta_keywords;
	private static JTable tb_parentPlatform;
	private static JTable tb_otherIdentifier;
	private static JTable tb_otherClassifier;
	private JTextField tf_parentPlatformName;
	private JTextField tf_otherIdentifierName;
	private JTextField tf_otherClassifierName;
	private JTextField tf_otherClassifierContent;
	private JTextField tf_otherIdentifierContent;
	private JTextField tf_parentPlatformUID;
	private static JTextArea ta_application;
	private static JCheckBox ckbx_otherIdentifier;
	private static JCheckBox ckbx_otherClassifier;
	private JButton bt_addOtherIdentifier;
	private JButton bt_deleteOtherIdentifier;
	private JButton bt_addOtherClassifier;
	private JButton bt_deleteOtherClassifier;
	private static JTextField tf_beginTM;
	private static JTextField tf_endTM;
	private static JTextArea ta_legalConstraint;
	private static JTextArea ta_securityConstraint;
	private static JTextField tf_length;
	private static JTextField tf_width;
	private static JTextField tf_height;
	private static JTextField tf_weight;
	private static JTextField tf_minCurrent;
	private static JTextField tf_minVoltage;
	private static JTextField tf_power;
	private static JTextField tf_outputPower;
	private static JTable tb_otherCharacter;
	private static JTextField tf_life;
	private static JTextField tf_minHumidity;
	private static JTextField tf_maxHumidity;
	private static JTextField tf_minTemperature;
	private static JTextField tf_maxTemperature;
	private static JTextField tf_protectionGrade;
	private static JTextField tf_MTBF;
	private JTextField tf_otherCharacterName;
	private JTextField tf_otherCharacterContent;
	private static JTextField tf_detectType;
	private static JTextField tf_minOverload;
	private static JTextField tf_maxOverload;
	private static JTextField tf_minMeasurementRange;
	private static JTextField tf_maxMeasurementRange;
	private static JTextField tf_minFrequency;
	private static JTextField tf_maxFrequency;
	private static JTextField tf_lowerY;
	private static JTextField tf_upperY;
	private static JTextField tf_lowerX;
	private static JTextField tf_upperX;
	private static JTextField tf_sensitivityTolerance;
	private static JTextField tf_detectAccuracy;
	private static JTextField tf_repeatability;
	private static JTextField tf_lag;
	private static JTextField tf_nonlinearity;
	private static JTextField tf_dataAccessQuality;
	private static JTextField tf_dataFormat;
	private static JTextField tf_observeResolution;
	private static JTextField tf_radius;
	private static JTextField tf_sensitivity;
	private static JTextField tf_interval;
	private static JTextField tf_duration;
	private static JTextField tf_respondTM;
	private static JTable tb_otherCapability;
	private JTextField tf_otherCapaName;
	private JTextField tf_otherCapaContent;
	private static JTextField tf_pointSRS;
	private static JTextField tf_pointY;
	private static JTextField tf_pointX;
	private final ButtonGroup btGroup_position = new ButtonGroup();
	private static JTextField tf_locationSRS;
	private static JTextField tf_latitude;
	private static JTextField tf_longitude;
	private static JTextField tf_altitude;
	private static JComboBox cbbx_isOperable;
	private static JComboBox cbbx_currentType;
	private static JTextField tf_maxCurrent;
	private static JTextField tf_maxVoltage;
	private static JTextArea ta_detectPrinciple;
	private static JComboBox cbbx_dataAccessLevel;
	private static JTextArea ta_textPosition;
	private static JTextField tf_organizationName;
	private static JTextField tf_individualName;
	private static JTextField tf_telephone;
	private static JTextField tf_deliveryPoint;
	private static JTextField tf_city;
	private static JTextField tf_administration;
	private static JTextField tf_country;
	private static JTextField tf_email;
	private static JTextField tf_postCode;
	private static JTextField tf_eventID;
	private static JTextField tf_eventLabel;
	private static JTextField tf_eventPeriodStart;
	private static JTextField tf_eventPeriodEnd;
	private static JTextField tf_eventInstant;
	private static JTable tb_history;
	private static JTable tb_interface;
	private static JTable tb_contact;
	private static JTable tb_input;
	private static JTable tb_output;
	private static JTable tb_parameter;
	private static JTable tb_component;
	private static JTable tb_connection;
	private final ButtonGroup btGroup_eventTM = new ButtonGroup();
	private DefaultTableModel model_parentPlatform;
	private DefaultTableModel model_otherIdentifier;
	private DefaultTableModel model_otherClassifier;
	private DefaultTableModel model_otherCharacter;
	private DefaultTableModel model_otherCapability;
	private DefaultTableModel model_interface;
	private DefaultTableModel model_input;
	private DefaultTableModel model_output;
	private DefaultTableModel model_parameter;
	private DefaultTableModel model_component;
	private DefaultTableModel model_connection;
	private static JComboBox cbbx_beginTM;
	private static JComboBox cbbx_endTM;
	private static JComboBox cbbx_role;
	private static JTextArea ta_eventDescription;
	private static JCheckBox ckbx_legalConstraint;
	private static JCheckBox ckbx_securityConstraint;
	private static JCheckBox ckbx_length;
	private static JCheckBox ckbx_width;
	private static JCheckBox ckbx_height;
	private static JCheckBox ckbx_weight;
	private static JCheckBox ckbx_currentType;
	private static JCheckBox ckbx_current;
	private static JCheckBox ckbx_voltage;
	private static JCheckBox ckbx_power;
	private static JCheckBox ckbx_outputPower;
	private static JCheckBox ckbx_life;
	private static JCheckBox ckbx_humidity;
	private static JCheckBox ckbx_temperature;
	private static JCheckBox ckbx_protectionGrade;
	private static JCheckBox ckbx_MTBF;
	private static JCheckBox ckbx_isOperable;
	private static JCheckBox ckbx_otherCharacter;
	private static JCheckBox ckbx_detectPrinciple;
	private static JCheckBox ckbx_overload;
	private static JCheckBox ckbx_measurementRange;
	private static JCheckBox ckbx_frequencyRange;
	private static JCheckBox ckbx_observeResolution;
	private static JCheckBox ckbx_radius;
	private static JCheckBox ckbx_sensitivity;
	private static JCheckBox ckbx_interval;
	private static JCheckBox ckbx_duration;
	private static JCheckBox ckbx_respondTM;
	private static JCheckBox ckbx_sensitivityTolerance;
	private static JCheckBox ckbx_detectAccuracy;
	private static JCheckBox ckbx_repeatability;
	private static JCheckBox ckbx_lag;
	private static JCheckBox ckbx_nonlinearity;
	private static JCheckBox ckbx_dataAccessLevel;
	private static JCheckBox ckbx_dataAccessQuality;
	private static JCheckBox ckbx_dataFormat;
	private static JCheckBox ckbx_otherCapability;
	private static JRadioButton rbt_textPosition;
	private static JRadioButton rbt_pointPosition;
	private static JRadioButton rbt_location;
	private static JCheckBox ckbx_individualName;
	private static JCheckBox ckbx_telephone;
	private static JCheckBox ckbx_address;
	private static JCheckBox ckbx_eventID;
	private static JCheckBox ckbx_eventDescription;
	private static JRadioButton rbt_eventPeriod;
	private static JRadioButton rbt_eventInstant;
	private static JCheckBox ckbx_connection;
	private static JCheckBox ckbx_component;
	private static JCheckBox ckbx_parameter;
	private static JCheckBox ckbx_output;
	private static String[] parameterInfo;
	private static String[] parameterList;
	private static JCheckBox ckbx_FOI;
	private JButton bt_addFOI;
	private JButton bt_deleFOI;
	private static JTable tb_FOI;
	private static DefaultTableModel model_FOI;
	private JLabel lb_inheritance;
	private static JCheckBox ckbx_typeOf;
	private static JCheckBox ckbx_configuration;
	private static JTextField tf_typeOfUID;
	private static JTextField tf_typeOfUrl;
	private JLabel lb_setMode;
	private static JTextField tf_modeType;
	private JButton bt_selectParameter;
	private JButton bt_clearParameter;
	private static JTable tb_setValue;
	private static DefaultTableModel model_setValue;
	private JTextField tf_parameterName;
	private static JTextField tf_modeChoice;
	
	public static String getDescription() {
		return ta_description.getText();
	}

	public static String getUID() {
		return tf_UID.getText();
	}
	
	public static String[] getKeywords() {
		String[] keyword = ta_keywords.getText().split("\n");
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
	
	public static int getOtherIdentifierCount() {
		return tb_otherIdentifier.getRowCount();
	}
	
	public static String getOtherIdentifierInfo(int a,int b) {
		return tb_otherIdentifier.getValueAt(a, b).toString();
	}
	
	public static String getSensorType1() {
		return tf_sensorType1.getText();
	}
	
	public static String getSensorType2() {
		return tf_sensorType2.getText();
	}
	
	public static String getShareLevel() {
		return cbbx_shareLevel.getSelectedItem().toString();
	}
	
	public static String[] getApplication() {
		String[] application = ta_application.getText().split("\n");
		return application;
	}
	
	public static int getOtherClassifierCount() {
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
	
	public static String getCurrentType() {
		return cbbx_currentType.getSelectedItem().toString();
	}

	public static String getMinCurrent() {
		return tf_minCurrent.getText();
	}

	public static String getMaxCurrent() {
		return tf_maxCurrent.getText();
	}
	
	public static String getMinVoltage() {
		return tf_minVoltage.getText();
	}

	public static String getMaxVoltage() {
		return tf_maxVoltage.getText();
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
	
	public static String getMinHumidity() {
		return tf_minHumidity.getText();
	}
	
	public static String getMaxHumidity() {
		return tf_maxHumidity.getText();
	}
	
	public static String getMinTemperature() {
		return tf_minTemperature.getText();
	}
	
	public static String getMaxTemperature() {
		return tf_maxTemperature.getText();
	}
	
	public static String getProtectionGrade() {
		return tf_protectionGrade.getText();
	}
	
	public static String getMTBF() {
		return tf_MTBF.getText();
	}
	
	public static String getIsOperable() {
		return cbbx_isOperable.getSelectedItem().toString();
	}
	
	public static int getOtherCharacterCount() {
		return tb_otherCharacter.getRowCount();
	}
	
	public static String getOtherCharacterInfo(int a,int b) {
		return tb_otherCharacter.getValueAt(a, b).toString();
	}
	
	public static String getDetectType() {
		return tf_detectType.getText();
	}
	
	public static String getDetectPrinciple() {
		return ta_detectPrinciple.getText();
	}
	
	public static String getMinOverload() {
		return tf_minOverload.getText();
	}
	
	public static String getMaxOverload() {
		return tf_maxOverload.getText();
	}
	
	public static String getMinMeasurementRange() {
		return tf_minMeasurementRange.getText();
	}
	
	public static String getMaxMeasurementRange() {
		return tf_maxMeasurementRange.getText();
	}
	
	public static String getMinFrequency() {
		return tf_minFrequency.getText();
	}
	
	public static String getMaxFrequency() {
		return tf_maxFrequency.getText();
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
	
	public static String getObserveResolution() {
		return tf_observeResolution.getText();
	}
	
	public static String getRadius() {
		return tf_radius.getText();
	}
	
	public static String getSensitivity() {
		return tf_sensitivity.getText();
	}
	
	public static String getInterval() {
		return tf_interval.getText();
	}
	
	public static String getDuration() {
		return tf_duration.getText();
	}
	
	public static String getRespondTM() {
		return tf_respondTM.getText();
	}
	
	public static String getSensitivityTolerance() {
		return tf_sensitivityTolerance.getText();
	}
	
	public static String getDetectAccuracy() {
		return tf_detectAccuracy.getText();
	}
	
	public static String getRepeatability() {
		return tf_repeatability.getText();
	}
	
	public static String getLag() {
		return tf_lag.getText();
	}
	
	public static String getNonlinearity() {
		return tf_nonlinearity.getText();
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
	
	public static String getTextPosition() {
		return ta_textPosition.getText();
	}
	
	public static String getPointSRS() {
		return tf_pointSRS.getText();
	}
	
	public static String getPointY() {
		return tf_pointY.getText();
	}
	
	public static String getPointX() {
		return tf_pointX.getText();
	}
	
	public static String getLocationSRS() {
		return tf_locationSRS.getText();
	}
	
	public static String getLatitude() {
		return tf_latitude.getText();
	}
	
	public static String getLongitude() {
		return tf_longitude.getText();
	}
	
	public static String getAltitude() {
		return tf_altitude.getText();
	}
	
	public static String getRole() {
		return cbbx_role.getSelectedItem().toString();
	}
	
	public static String getOrganizationName() {
		return tf_organizationName.getText();
	}
	
	public static String getIndividualName() {
		return tf_individualName.getText();
	}
	
	public static String getTelephone() {
		return tf_telephone.getText();
	}
	
	public static String getDeliveryPoint() {
		return tf_deliveryPoint.getText();
	}
	
	public static String getCity() {
		return tf_city.getText();
	}
	
	public static String getAdministration() {
		return tf_administration.getText();
	}
	
	public static String getCountry() {
		return tf_country.getText();
	}
	
	public static String getPostcode() {
		return tf_postCode.getText();
	}
	
	public static String getEmail() {
		return tf_email.getText();
	}
	
	public static int getContactNum() {
		return tb_contact.getRowCount();
	}
	
	public static String getEventID() {
		return tf_eventID.getText();
	}
	
	public static String getEventLabel() {
		return tf_eventLabel.getText();
	}
	
	public static String getEventDescription() {
		return ta_eventDescription.getText();
	}
	
	public static int getEventTMChoice() {
		if (rbt_eventPeriod.isSelected()) {
			return 1;
		}else if(rbt_eventInstant.isSelected()){
			return 2;
		}else {
			return 0;
		}
	}
	
	public static String getEventBeginTM() {
		return tf_eventPeriodStart.getText();
	}
	
	public static String getEventEndTM() {
		return tf_eventPeriodEnd.getText();
	}
	
	public static String getEventInstance() {
		return tf_eventInstant.getText();
	}
	
	public static int getEventNum() {
		return tb_history.getRowCount();
	}
	
	public static String getEventInfo(int a,int b) {
		return tb_history.getValueAt(a, b).toString();
	}
	
	public static int getInterfaceNum() {
		return tb_interface.getRowCount();
	}
	
	public static String getInterfaceInfo(int a,int b) {
		return tb_interface.getValueAt(a, b).toString();
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
	
	public static int getParameterNum() {
		return tb_parameter.getRowCount();
	}
	
	public static String getParameterItem(int a,int b) {
		return tb_parameter.getValueAt(a, b).toString();
	}	
	
	public static String[] getParameterList() {
		for (int i = 0; i < getParameterNum(); i++) {
			parameterList[i] = getParameterItem(i, 0);
		}
		return parameterList;
	}
	
	public static String getParameterName() {
		return parameterInfo[0];
	}
	
	public static String getParameterDescription() {
		return parameterInfo[1];
	}
	
	public static String getParameterValue() {
		return parameterInfo[2];
	}
	
	public static int getComponentNum() {
		return tb_component.getRowCount();
	}
	
	public static String getComponentInfo(int a,int b) {
		return tb_component.getValueAt(a, b).toString();
	}
	
	public static int getConnectionNum() {
		return tb_connection.getRowCount();
	}
	
	public static String getConnectionInfo(int a,int b) {
		return tb_connection.getValueAt(a, b).toString();
	}

	
	public static int getFOINum() {
		return tb_FOI.getRowCount();
	}
	
	public static String getFOIInfo(int a,int b) {
		return tb_FOI.getValueAt(a, b).toString();
	}
	
	public static String getTypeOfUID() {
		return tf_typeOfUID.getText();	
	}
	
	public static String getTypeOfURL() {
		return tf_typeOfUrl.getText();
	}
	
	public static int getSetValueNum() {
		return tb_setValue.getRowCount();
	}
	
	public static String getSetValueInfo(int a,int b) {
		return tb_setValue.getValueAt(a, b).toString();
	}
	
	public static String getModeType() {
		return tf_modeType.getText();
	}
	
	public static String getModeChoice() {
		return tf_modeChoice.getText();
	}
	
	public static boolean checkOtherIdentifier() {
		if (ckbx_otherIdentifier.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOtherClassifier() {
		if (ckbx_otherClassifier.isSelected()) {
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
	
	public static boolean checkCurrentType() {
		if (ckbx_currentType.isSelected()) {
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
	
	public static boolean checkHumidity() {
		if (ckbx_humidity.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkTemperature() {
		if (ckbx_temperature.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkProtectGrade() {
		if (ckbx_protectionGrade.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkMTBF() {
		if (ckbx_MTBF.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkIsOperable() {
		if (ckbx_isOperable.isSelected()) {
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
	
	public static boolean checkDetectPrinciple() {
		if (ckbx_detectPrinciple.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOverload() {
		if (ckbx_overload.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkMeasurementRange() {
		if (ckbx_measurementRange.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkFrequency() {
		if (ckbx_frequencyRange.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkObserveResolution() {
		if (ckbx_observeResolution.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkRadius() {
		if (ckbx_radius.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkSensitivity() {
		if (ckbx_sensitivity.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkInterval() {
		if (ckbx_interval.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkDuration() {
		if (ckbx_duration.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkRespondTM() {
		if (ckbx_respondTM.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkSensitivityTolerance() {
		if (ckbx_sensitivityTolerance.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkDetectAccuracy() {
		if (ckbx_detectAccuracy.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkRepeatability() {
		if (ckbx_repeatability.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkLag() {
		if (ckbx_lag.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkNonlinearity() {
		if (ckbx_nonlinearity.isSelected()) {
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
	
	public static int checkPositionChoice() {
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
		if (ckbx_individualName.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkTelephone() {
		if (ckbx_telephone.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkAddress() {
		if (ckbx_address.isSelected()) {
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
		if (ckbx_eventDescription.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkEventPeriod() {
		if (rbt_eventPeriod.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkEventInstance() {
		if (rbt_eventInstant.isSelected()) {
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
	
	public static boolean checkParameter() {
		if (ckbx_parameter.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkComponent() {
		if (ckbx_component.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkConnection() {
		if (ckbx_connection.isSelected()) {
			return true;
		}else {
			return false;
		}
	}	
	
	public static boolean checkFOI() {
		if (ckbx_FOI.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkInheritance() {
		if (ckbx_typeOf.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkConfiguration() {
		if (ckbx_configuration.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Create the application.
	 */
	public InsituSensorFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(InsituSensorFrame.class.getResource("/sm/images/原位站点.png")));
		frame.setTitle("原位传感器建模");
		frame.setBounds(400,100,850, 780);
		frame.setResizable(false);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		save = new JButton("保存");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveIsClicked = true;
				if (savePageIsClicled==true) {
					Temp2_xml.saveXML();
				}else if(savePageIsClicled==false){
					tipsDialog saveTip = new tipsDialog("请先对模型进行“保存编辑”操作！");
					saveTip.setLocationRelativeTo(frame);
					saveTip.setVisible(true);
				}
			}
		});
		save.setIcon(new ImageIcon(InsituSensorFrame.class.getResource("/sm/images/save.jpg")));
		toolBar.add(save);
		
//		clear = new JButton("清空");
//		clear.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		clear.setIcon(new ImageIcon(InsituSensorFrame.class.getResource("/sm/images/clear.jpg")));
//		toolBar.add(clear);
//		
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
		toolBar.add(view);
		
		documents = new JButton("附件");
		documents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UploadFrame fr = new UploadFrame();
				fr.setLocationRelativeTo(frame);
			}
		});
		documents.setIcon(new ImageIcon(InsituSensorFrame.class.getResource("/sm/images/annex.jpg")));
		toolBar.add(documents);
		
		JTabbedPane tp_content = new JTabbedPane(JTabbedPane.TOP);
		tp_content.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int selectedIndex = tp_content.getSelectedIndex();  //获得选中的选项卡索引
                String title = tp_content.getTitleAt(selectedIndex); //获得选项卡标签
                index = selectedIndex;
			}
		});
		frame.getContentPane().add(tp_content, BorderLayout.CENTER);
		
		JPanel panel_description = new JPanel();
		tp_content.addTab("传感器标识信息", null, panel_description, null);
		GridBagLayout gbl_panel_description = new GridBagLayout();
		gbl_panel_description.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_description.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 33, 0, 0, 0, 0, 0, 0};
		gbl_panel_description.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_description.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_description.setLayout(gbl_panel_description);
		
		JLabel lb_description = new JLabel("传感器简述：");
		lb_description.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_description = new GridBagConstraints();
		gbc_lb_description.gridwidth = 2;
		gbc_lb_description.insets = new Insets(15, 10, 5, 5);
		gbc_lb_description.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lb_description.gridx = 0;
		gbc_lb_description.gridy = 0;
		panel_description.add(lb_description, gbc_lb_description);
		
		JLabel lb_keywords = new JLabel("传感器发现关键词：");
		lb_keywords.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_keywords = new GridBagConstraints();
		gbc_lb_keywords.gridwidth = 2;
		gbc_lb_keywords.insets = new Insets(15, 10, 5, 5);
		gbc_lb_keywords.gridx = 5;
		gbc_lb_keywords.gridy = 0;
		panel_description.add(lb_keywords, gbc_lb_keywords);
		
		ta_description = new JTextArea();
		GridBagConstraints gbc_ta_description = new GridBagConstraints();
		gbc_ta_description.gridwidth = 5;
		gbc_ta_description.gridheight = 2;
		gbc_ta_description.insets = new Insets(0, 10, 5, 5);
		gbc_ta_description.fill = GridBagConstraints.BOTH;
		gbc_ta_description.gridx = 0;
		gbc_ta_description.gridy = 1;
		panel_description.add(ta_description, gbc_ta_description);
		
		tf_keywords = new JTextField();
		hintText hintKeyword = new hintText(tf_keywords, "原位/水文/气象/……");
		tf_keywords.addFocusListener(new JTextFieldHintListener("原位/水文/气象/……", tf_keywords));
		tf_keywords.setColumns(10);
		GridBagConstraints gbc_tf_keywords = new GridBagConstraints();
		gbc_tf_keywords.gridwidth = 2;
		gbc_tf_keywords.insets = new Insets(0, 10, 5, 5);
		gbc_tf_keywords.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_keywords.gridx = 5;
		gbc_tf_keywords.gridy = 1;
		panel_description.add(tf_keywords, gbc_tf_keywords);
		
		JButton bt_addKeywords = new JButton("增加");
		bt_addKeywords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tf_keywords.getText().equals("")) {
					String keyword = tf_keywords.getText();
					ta_keywords.append(keyword+"\n");
					tf_keywords.setText("");
				}
			}
		});
		GridBagConstraints gbc_bt_addKeywords = new GridBagConstraints();
		gbc_bt_addKeywords.anchor = GridBagConstraints.SOUTH;
		gbc_bt_addKeywords.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addKeywords.gridx = 7;
		gbc_bt_addKeywords.gridy = 1;
		panel_description.add(bt_addKeywords, gbc_bt_addKeywords);
		
		JScrollPane scrollPane_14 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_14 = new GridBagConstraints();
		gbc_scrollPane_14.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_14.gridheight = 2;
		gbc_scrollPane_14.gridwidth = 3;
		gbc_scrollPane_14.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_14.gridx = 8;
		gbc_scrollPane_14.gridy = 1;
		panel_description.add(scrollPane_14, gbc_scrollPane_14);
		
		ta_keywords = new JTextArea();
		scrollPane_14.setViewportView(ta_keywords);
		ta_keywords.setBackground(SystemColor.info);
		
		JButton bt_clearKeywords = new JButton("清空");
		bt_clearKeywords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta_keywords.setText("");
			}
		});
		GridBagConstraints gbc_bt_clearKeywords = new GridBagConstraints();
		gbc_bt_clearKeywords.insets = new Insets(0, 0, 5, 5);
		gbc_bt_clearKeywords.gridx = 7;
		gbc_bt_clearKeywords.gridy = 2;
		panel_description.add(bt_clearKeywords, gbc_bt_clearKeywords);
		
		JLabel lb_identifier = new JLabel("标识符");
		lb_identifier.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_identifier = new GridBagConstraints();
		gbc_lb_identifier.insets = new Insets(15, 10, 5, 5);
		gbc_lb_identifier.anchor = GridBagConstraints.WEST;
		gbc_lb_identifier.gridx = 0;
		gbc_lb_identifier.gridy = 3;
		panel_description.add(lb_identifier, gbc_lb_identifier);
		
		JLabel lb_classifier = new JLabel("分类符");
		lb_classifier.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_classifier = new GridBagConstraints();
		gbc_lb_classifier.insets = new Insets(15, 10, 5, 5);
		gbc_lb_classifier.gridx = 5;
		gbc_lb_classifier.gridy = 3;
		panel_description.add(lb_classifier, gbc_lb_classifier);
		
		JCheckBox ckbx_UniqueID = new JCheckBox("唯一标识码：");
		ckbx_UniqueID.setSelected(true);
		GridBagConstraints gbc_ckbx_UniqueID = new GridBagConstraints();
		gbc_ckbx_UniqueID.anchor = GridBagConstraints.WEST;
		gbc_ckbx_UniqueID.gridwidth = 2;
		gbc_ckbx_UniqueID.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_UniqueID.gridx = 0;
		gbc_ckbx_UniqueID.gridy = 4;
		panel_description.add(ckbx_UniqueID, gbc_ckbx_UniqueID);
		
		JTextField tf_orgID = new JTextField();
		hintText hintOrgID = new hintText(tf_orgID, "请输入组织标识");
		tf_orgID.addFocusListener(new JTextFieldHintListener("请输入组织标识", tf_orgID));
		GridBagConstraints gbc_tf_orgID = new GridBagConstraints();
		gbc_tf_orgID.gridwidth = 3;
		gbc_tf_orgID.insets = new Insets(0, 0, 5, 5);
		gbc_tf_orgID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_orgID.gridx = 2;
		gbc_tf_orgID.gridy = 4;
		panel_description.add(tf_orgID, gbc_tf_orgID);
		tf_orgID.setColumns(10);
		tf_orgID.addMouseListener(new MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent e) {
				tf_orgID.setForeground(Color.black);
				tf_orgID.setBorder(new LineBorder(Color.black));
				tf_orgID.setText("");
			}
		});
		
		JCheckBox ckbx_sensorType1 = new JCheckBox("传感器类型：");
		ckbx_sensorType1.setSelected(true);
		GridBagConstraints gbc_ckbx_sensorType1 = new GridBagConstraints();
		gbc_ckbx_sensorType1.anchor = GridBagConstraints.WEST;
		gbc_ckbx_sensorType1.gridwidth = 2;
		gbc_ckbx_sensorType1.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_sensorType1.gridx = 5;
		gbc_ckbx_sensorType1.gridy = 4;
		panel_description.add(ckbx_sensorType1, gbc_ckbx_sensorType1);
		
		tf_sensorType1 = new JTextField();
		hintText hintSensorType1 = new hintText(tf_sensorType1, "地面原位传感器");
		tf_sensorType1.addFocusListener(new JTextFieldHintListener("地面原位传感器", tf_sensorType1));
		GridBagConstraints gbc_tf_sensorType1 = new GridBagConstraints();
		gbc_tf_sensorType1.gridwidth = 4;
		gbc_tf_sensorType1.insets = new Insets(0, 0, 5, 10);
		gbc_tf_sensorType1.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_sensorType1.gridx = 7;
		gbc_tf_sensorType1.gridy = 4;
		panel_description.add(tf_sensorType1, gbc_tf_sensorType1);
		tf_sensorType1.setColumns(10);
		
		JTextField tf_sensorID = new JTextField();
		
		hintText hintSensorID = new hintText(tf_sensorID, "请输入传感器标识");
		tf_sensorID.addFocusListener(new JTextFieldHintListener("请输入传感器标识", tf_sensorID));
		tf_sensorID.setColumns(10);
		GridBagConstraints gbc_tf_sensorID = new GridBagConstraints();
		gbc_tf_sensorID.gridwidth = 3;
		gbc_tf_sensorID.insets = new Insets(0, 0, 5, 5);
		gbc_tf_sensorID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_sensorID.gridx = 2;
		gbc_tf_sensorID.gridy = 5;
		panel_description.add(tf_sensorID, gbc_tf_sensorID);
		tf_sensorID.addMouseListener(new MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent e) {
				tf_sensorID.setForeground(Color.black);
				tf_sensorID.setBorder(new LineBorder(Color.black));
				tf_sensorID.setText("");
			}
		});
		
		JCheckBox ckbx_sensorType2 = new JCheckBox("传感器类型：");
		ckbx_sensorType2.setSelected(true);
		GridBagConstraints gbc_ckbx_sensorType2 = new GridBagConstraints();
		gbc_ckbx_sensorType2.anchor = GridBagConstraints.WEST;
		gbc_ckbx_sensorType2.gridwidth = 2;
		gbc_ckbx_sensorType2.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_sensorType2.gridx = 5;
		gbc_ckbx_sensorType2.gridy = 5;
		panel_description.add(ckbx_sensorType2, gbc_ckbx_sensorType2);
		
		tf_sensorType2 = new JTextField();
		hintText hintSensorType2 = new hintText(tf_sensorType2, "如：流速水位计");
		tf_sensorType2.addFocusListener(new JTextFieldHintListener("如：流速水位计", tf_sensorType2));
		tf_sensorType2.setColumns(10);
		GridBagConstraints gbc_tf_sensorType2 = new GridBagConstraints();
		gbc_tf_sensorType2.gridwidth = 4;
		gbc_tf_sensorType2.insets = new Insets(0, 0, 5, 10);
		gbc_tf_sensorType2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_sensorType2.gridx = 7;
		gbc_tf_sensorType2.gridy = 5;
		panel_description.add(tf_sensorType2, gbc_tf_sensorType2);
		
		JButton bt_creatUID = new JButton("生成");
		bt_creatUID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((!tf_orgID.getText().equals(""))&&(!tf_sensorID.getText().equals(""))
						&&(!tf_orgID.getText().equals("请输入组织标识码！"))&&(!tf_sensorID.getText().equals("请输入传感器标识码！"))) {
					tf_UID.setText("urn:"+tf_orgID.getText()+":def:identifier:OGC:2.0:"+tf_sensorID.getText());
				}else if (tf_orgID.getText().equals("")||tf_sensorID.getText().equals("")) {
					tf_orgID.setBorder(new LineBorder(Color.RED));
					tf_orgID.setForeground(Color.RED);
					tf_orgID.setText("请输入组织标识");
					tf_sensorID.setBorder(new LineBorder(Color.RED));
					tf_sensorID.setForeground(Color.RED);
					tf_sensorID.setText("请输入传感器标识");
				}
			}
		});
		GridBagConstraints gbc_bt_creatUID = new GridBagConstraints();
		gbc_bt_creatUID.insets = new Insets(0, 0, 5, 5);
		gbc_bt_creatUID.gridx = 0;
		gbc_bt_creatUID.gridy = 6;
		panel_description.add(bt_creatUID, gbc_bt_creatUID);
		
		tf_UID = new JTextField();
		tf_UID.setColumns(10);
		GridBagConstraints gbc_tf_UID = new GridBagConstraints();
		gbc_tf_UID.gridwidth = 4;
		gbc_tf_UID.insets = new Insets(0, 0, 5, 5);
		gbc_tf_UID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_UID.gridx = 1;
		gbc_tf_UID.gridy = 6;
		panel_description.add(tf_UID, gbc_tf_UID);
		
		JCheckBox ckbx_shareLevel = new JCheckBox("共享等级：");
		ckbx_shareLevel.setSelected(true);
		GridBagConstraints gbc_ckbx_shareLevel = new GridBagConstraints();
		gbc_ckbx_shareLevel.anchor = GridBagConstraints.WEST;
		gbc_ckbx_shareLevel.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_shareLevel.gridx = 5;
		gbc_ckbx_shareLevel.gridy = 6;
		panel_description.add(ckbx_shareLevel, gbc_ckbx_shareLevel);
		
		cbbx_shareLevel = new JComboBox();
		cbbx_shareLevel.setModel(new DefaultComboBoxModel(new String[] {"公开", "限制"}));
		GridBagConstraints gbc_cbbx_shareLevel = new GridBagConstraints();
		gbc_cbbx_shareLevel.insets = new Insets(0, 0, 5, 10);
		gbc_cbbx_shareLevel.gridwidth = 5;
		gbc_cbbx_shareLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbx_shareLevel.gridx = 6;
		gbc_cbbx_shareLevel.gridy = 6;
		panel_description.add(cbbx_shareLevel, gbc_cbbx_shareLevel);
		
		JCheckBox ckbx_longName = new JCheckBox("传感器全称：");
		ckbx_longName.setSelected(true);
		GridBagConstraints gbc_ckbx_longName = new GridBagConstraints();
		gbc_ckbx_longName.anchor = GridBagConstraints.WEST;
		gbc_ckbx_longName.gridwidth = 2;
		gbc_ckbx_longName.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_longName.gridx = 0;
		gbc_ckbx_longName.gridy = 7;
		panel_description.add(ckbx_longName, gbc_ckbx_longName);
		
		tf_longName = new JTextField();
		tf_longName.setColumns(10);
		GridBagConstraints gbc_tf_longName = new GridBagConstraints();
		gbc_tf_longName.gridwidth = 3;
		gbc_tf_longName.insets = new Insets(0, 0, 5, 5);
		gbc_tf_longName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_longName.gridx = 2;
		gbc_tf_longName.gridy = 7;
		panel_description.add(tf_longName, gbc_tf_longName);
		
		JCheckBox ckbx_intendedApplication = new JCheckBox("预期应用：");
		ckbx_intendedApplication.setSelected(true);
		GridBagConstraints gbc_ckbx_intendedApplication = new GridBagConstraints();
		gbc_ckbx_intendedApplication.anchor = GridBagConstraints.WEST;
		gbc_ckbx_intendedApplication.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_intendedApplication.gridx = 5;
		gbc_ckbx_intendedApplication.gridy = 7;
		panel_description.add(ckbx_intendedApplication, gbc_ckbx_intendedApplication);
		
		JTextField tf_intendedApplication = new JTextField();
		hintText hintApplication = new hintText(tf_intendedApplication, "水文/气象观测/……");
		tf_intendedApplication.addFocusListener(new JTextFieldHintListener("水文/气象观测/……", tf_intendedApplication));
		tf_intendedApplication.setColumns(10);
		GridBagConstraints gbc_tf_intendedApplication = new GridBagConstraints();
		gbc_tf_intendedApplication.gridwidth = 3;
		gbc_tf_intendedApplication.insets = new Insets(0, 0, 5, 5);
		gbc_tf_intendedApplication.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_intendedApplication.gridx = 6;
		gbc_tf_intendedApplication.gridy = 7;
		panel_description.add(tf_intendedApplication, gbc_tf_intendedApplication);
		
		JButton bt_addApplication = new JButton("增加");
		bt_addApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tf_intendedApplication.getText().equals("")) {
					ta_application.append(tf_intendedApplication.getText()+"\n");
					tf_intendedApplication.setText("");
				}
			}
		});
		GridBagConstraints gbc_bt_addApplication = new GridBagConstraints();
		gbc_bt_addApplication.anchor = GridBagConstraints.SOUTH;
		gbc_bt_addApplication.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addApplication.gridx = 9;
		gbc_bt_addApplication.gridy = 7;
		panel_description.add(bt_addApplication, gbc_bt_addApplication);
		
		JButton bt_clearApplication = new JButton("清空");
		bt_clearApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta_application.setText("");
			}
		});
		GridBagConstraints gbc_bt_clearApplication = new GridBagConstraints();
		gbc_bt_clearApplication.insets = new Insets(0, 0, 5, 10);
		gbc_bt_clearApplication.gridx = 10;
		gbc_bt_clearApplication.gridy = 7;
		panel_description.add(bt_clearApplication, gbc_bt_clearApplication);
		
		JCheckBox ckbx_shortName = new JCheckBox("传感器简称：");
		ckbx_shortName.setSelected(true);
		GridBagConstraints gbc_ckbx_shortName = new GridBagConstraints();
		gbc_ckbx_shortName.anchor = GridBagConstraints.WEST;
		gbc_ckbx_shortName.gridwidth = 2;
		gbc_ckbx_shortName.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_shortName.gridx = 0;
		gbc_ckbx_shortName.gridy = 8;
		panel_description.add(ckbx_shortName, gbc_ckbx_shortName);
		
		tf_shortName = new JTextField();
		tf_shortName.setColumns(10);
		GridBagConstraints gbc_tf_shortName = new GridBagConstraints();
		gbc_tf_shortName.gridwidth = 3;
		gbc_tf_shortName.insets = new Insets(0, 0, 5, 5);
		gbc_tf_shortName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_shortName.gridx = 2;
		gbc_tf_shortName.gridy = 8;
		panel_description.add(tf_shortName, gbc_tf_shortName);
		
		JScrollPane sp3 = new JScrollPane();
		GridBagConstraints gbc_sp3 = new GridBagConstraints();
		gbc_sp3.gridheight = 3;
		gbc_sp3.fill = GridBagConstraints.BOTH;
		gbc_sp3.gridwidth = 5;
		gbc_sp3.insets = new Insets(0, 0, 5, 10);
		gbc_sp3.gridx = 6;
		gbc_sp3.gridy = 8;
		panel_description.add(sp3, gbc_sp3);
		
		ta_application = new JTextArea();
		sp3.setViewportView(ta_application);
		ta_application.setBackground(SystemColor.info);
		
		JCheckBox ckbx_parentPlatform = new JCheckBox("所属平台标识：");
		ckbx_parentPlatform.setSelected(true);
		GridBagConstraints gbc_ckbx_parentPlatform = new GridBagConstraints();
		gbc_ckbx_parentPlatform.anchor = GridBagConstraints.WEST;
		gbc_ckbx_parentPlatform.gridwidth = 5;
		gbc_ckbx_parentPlatform.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_parentPlatform.gridx = 0;
		gbc_ckbx_parentPlatform.gridy = 9;
		panel_description.add(ckbx_parentPlatform, gbc_ckbx_parentPlatform);
		
		JScrollPane sp1 = new JScrollPane();
		GridBagConstraints gbc_sp1 = new GridBagConstraints();
		gbc_sp1.gridheight = 2;
		gbc_sp1.fill = GridBagConstraints.BOTH;
		gbc_sp1.gridwidth = 5;
		gbc_sp1.insets = new Insets(0, 10, 5, 5);
		gbc_sp1.gridx = 0;
		gbc_sp1.gridy = 10;
		panel_description.add(sp1, gbc_sp1);
		
		tb_parentPlatform = new JTable();
		tb_parentPlatform.setBackground(new Color(175, 238, 238));
		sp1.setViewportView(tb_parentPlatform);
		model_parentPlatform = new DefaultTableModel(new Object[][] {},new String[] {"平台名称", "平台标识符"});
		tb_parentPlatform.setModel(model_parentPlatform);
		tb_parentPlatform.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ckbx_otherClassifier = new JCheckBox("添加其它分类：");
		GridBagConstraints gbc_ckbx_otherClassifier = new GridBagConstraints();
		gbc_ckbx_otherClassifier.anchor = GridBagConstraints.WEST;
		gbc_ckbx_otherClassifier.gridwidth = 2;
		gbc_ckbx_otherClassifier.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_otherClassifier.gridx = 5;
		gbc_ckbx_otherClassifier.gridy = 11;
		panel_description.add(ckbx_otherClassifier, gbc_ckbx_otherClassifier);
		ckbx_otherClassifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_otherClassifier.isSelected()) {
					tf_otherClassifierContent.setEditable(true);
					tf_otherClassifierName.setEditable(true);
					tf_otherClassifierName.setBackground(Color.white);
					tf_otherClassifierContent.setBackground(Color.white);
					bt_addOtherClassifier.setEnabled(true);
					bt_deleteOtherClassifier.setEnabled(true);
				}else {
					tf_otherClassifierContent.setEditable(false);
					tf_otherClassifierName.setEditable(false);
					tf_otherClassifierName.setBackground(Grey);
					tf_otherClassifierContent.setBackground(Grey);
					tf_otherClassifierContent.setText("");
					tf_otherClassifierName.setText("");
					bt_addOtherClassifier.setEnabled(false);
					bt_deleteOtherClassifier.setEnabled(false);
					model_otherClassifier.setRowCount(0);
				}
			}
		});
		
		tf_parentPlatformName = new JTextField();
		hintText hintPlatformName = new hintText(tf_parentPlatformName, "如:XX水文观测站");
		tf_parentPlatformName.addFocusListener(new JTextFieldHintListener("如:XX水文观测站", tf_parentPlatformName));
		GridBagConstraints gbc_tf_parentPlatformName = new GridBagConstraints();
		gbc_tf_parentPlatformName.gridwidth = 2;
		gbc_tf_parentPlatformName.insets = new Insets(0, 10, 5, 5);
		gbc_tf_parentPlatformName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_parentPlatformName.gridx = 0;
		gbc_tf_parentPlatformName.gridy = 12;
		panel_description.add(tf_parentPlatformName, gbc_tf_parentPlatformName);
		tf_parentPlatformName.setColumns(10);
		
		tf_parentPlatformUID = new JTextField();
		hintText hintPlatformID = new hintText(tf_parentPlatformUID, "如:hydrological");
		tf_parentPlatformUID.addFocusListener(new JTextFieldHintListener("如:hydrological", tf_parentPlatformUID));
		tf_parentPlatformUID.setColumns(10);
		GridBagConstraints gbc_tf_parentPlatformUID = new GridBagConstraints();
		gbc_tf_parentPlatformUID.insets = new Insets(0, 0, 5, 5);
		gbc_tf_parentPlatformUID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_parentPlatformUID.gridx = 2;
		gbc_tf_parentPlatformUID.gridy = 12;
		panel_description.add(tf_parentPlatformUID, gbc_tf_parentPlatformUID);
		
		JButton bt_addParentPlatform = new JButton("增加");
		bt_addParentPlatform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf_parentPlatformName.getText().equals("")||tf_parentPlatformUID.getText().equals("")) {
					tipsDialog tip = new tipsDialog("请输入所属平台的完整信息！");
					tip.setLocationRelativeTo(frame);
					tip.setAlwaysOnTop(true);
					tip.setVisible(true);
				}else {
					String[] info= {tf_parentPlatformName.getText(),"urn:ogc:feature:insiteSensor:platform::"+tf_parentPlatformUID.getText()};
					model_parentPlatform.addRow(info);
					tf_parentPlatformName.setText("");
					tf_parentPlatformUID.setText("");
				}
			}
		});
		GridBagConstraints gbc_bt_addParentPlatform = new GridBagConstraints();
		gbc_bt_addParentPlatform.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addParentPlatform.gridx = 3;
		gbc_bt_addParentPlatform.gridy = 12;
		panel_description.add(bt_addParentPlatform, gbc_bt_addParentPlatform);
		
		JButton bt_deleteParentPlatform = new JButton("删除");
		bt_deleteParentPlatform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_parentPlatform.getSelectedRow();
				if (selectedRow != -1) {
					model_parentPlatform.removeRow(selectedRow);
				}
			}
		});
		GridBagConstraints gbc_bt_deleteParentPlatform = new GridBagConstraints();
		gbc_bt_deleteParentPlatform.insets = new Insets(0, 0, 5, 5);
		gbc_bt_deleteParentPlatform.gridx = 4;
		gbc_bt_deleteParentPlatform.gridy = 12;
		panel_description.add(bt_deleteParentPlatform, gbc_bt_deleteParentPlatform);
		
		JScrollPane sp4 = new JScrollPane();
		GridBagConstraints gbc_sp4 = new GridBagConstraints();
		gbc_sp4.insets = new Insets(0, 10, 5, 10);
		gbc_sp4.gridheight = 3;
		gbc_sp4.fill = GridBagConstraints.BOTH;
		gbc_sp4.gridwidth = 6;
		gbc_sp4.gridx = 5;
		gbc_sp4.gridy = 12;
		panel_description.add(sp4, gbc_sp4);
		
		tb_otherClassifier = new JTable();
		tb_otherClassifier.setBackground(new Color(175, 238, 238));
		sp4.setViewportView(tb_otherClassifier);
		model_otherClassifier = new DefaultTableModel(new Object[][] {},new String[] {"分类名称", "分类内容"});
		tb_otherClassifier.setModel(model_otherClassifier);
		tb_otherClassifier.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ckbx_otherIdentifier = new JCheckBox("添加其它标识：");
		GridBagConstraints gbc_ckbx_otherIdentifier = new GridBagConstraints();
		gbc_ckbx_otherIdentifier.anchor = GridBagConstraints.WEST;
		gbc_ckbx_otherIdentifier.gridwidth = 5;
		gbc_ckbx_otherIdentifier.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_otherIdentifier.gridx = 0;
		gbc_ckbx_otherIdentifier.gridy = 13;
		panel_description.add(ckbx_otherIdentifier, gbc_ckbx_otherIdentifier);
		ckbx_otherIdentifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_otherIdentifier.isSelected()) {
					tf_otherIdentifierContent.setEditable(true);
					tf_otherIdentifierName.setEditable(true);
					tf_otherIdentifierContent.setBackground(Color.white);
					tf_otherIdentifierName.setBackground(Color.white);
					bt_addOtherIdentifier.setEnabled(true);
					bt_deleteOtherIdentifier.setEnabled(true);
				}else {
					tf_otherIdentifierContent.setEditable(false);
					tf_otherIdentifierName.setEditable(false);
					tf_otherIdentifierContent.setBackground(Grey);
					tf_otherIdentifierName.setBackground(Grey);
					tf_otherIdentifierContent.setText("");
					tf_otherIdentifierName.setText("");
					bt_addOtherIdentifier.setEnabled(false);
					bt_deleteOtherIdentifier.setEnabled(false);
					model_otherIdentifier.setRowCount(0);
				}
			}
		});
		
		JScrollPane sp2 = new JScrollPane();
		GridBagConstraints gbc_sp2 = new GridBagConstraints();
		gbc_sp2.gridheight = 2;
		gbc_sp2.fill = GridBagConstraints.BOTH;
		gbc_sp2.gridwidth = 5;
		gbc_sp2.insets = new Insets(0, 10, 5, 5);
		gbc_sp2.gridx = 0;
		gbc_sp2.gridy = 14;
		panel_description.add(sp2, gbc_sp2);
		
		tb_otherIdentifier = new JTable();
		tb_otherIdentifier.setBackground(new Color(175, 238, 238));
		sp2.setViewportView(tb_otherIdentifier);
		model_otherIdentifier = new DefaultTableModel(new Object[][] {},new String[] {"标识名称", "标识内容"});
		tb_otherIdentifier.setModel(model_otherIdentifier);
		tb_otherIdentifier.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tf_otherClassifierName = new JTextField();
		tf_otherClassifierName.setEditable(false);
		tf_otherClassifierName.setColumns(10);
		GridBagConstraints gbc_tf_otherClassifierName = new GridBagConstraints();
		gbc_tf_otherClassifierName.gridwidth = 2;
		gbc_tf_otherClassifierName.insets = new Insets(0, 10, 5, 5);
		gbc_tf_otherClassifierName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherClassifierName.gridx = 5;
		gbc_tf_otherClassifierName.gridy = 15;
		panel_description.add(tf_otherClassifierName, gbc_tf_otherClassifierName);
		
		tf_otherClassifierContent = new JTextField();
		tf_otherClassifierContent.setEditable(false);
		tf_otherClassifierContent.setColumns(10);
		GridBagConstraints gbc_tf_otherClassifierContent = new GridBagConstraints();
		gbc_tf_otherClassifierContent.gridwidth = 2;
		gbc_tf_otherClassifierContent.insets = new Insets(0, 0, 5, 5);
		gbc_tf_otherClassifierContent.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherClassifierContent.gridx = 7;
		gbc_tf_otherClassifierContent.gridy = 15;
		panel_description.add(tf_otherClassifierContent, gbc_tf_otherClassifierContent);
		
		bt_addOtherClassifier = new JButton("增加");
		bt_addOtherClassifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_otherClassifierName.getText(),tf_otherClassifierContent.getText()};
				model_otherClassifier.addRow(info);
				tf_otherClassifierName.setText("");
				tf_otherClassifierContent.setText("");
			}
		});
		bt_addOtherClassifier.setEnabled(false);
		GridBagConstraints gbc_bt_addOtherClassifier = new GridBagConstraints();
		gbc_bt_addOtherClassifier.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addOtherClassifier.gridx = 9;
		gbc_bt_addOtherClassifier.gridy = 15;
		panel_description.add(bt_addOtherClassifier, gbc_bt_addOtherClassifier);
		
		bt_deleteOtherClassifier = new JButton("删除");
		bt_deleteOtherClassifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_otherClassifier.getSelectedRow();
				if (selectedRow != -1) {
					model_otherClassifier.removeRow(selectedRow);
				}
			}
		});
		bt_deleteOtherClassifier.setEnabled(false);
		GridBagConstraints gbc_bt_deleteOtherClassifier = new GridBagConstraints();
		gbc_bt_deleteOtherClassifier.insets = new Insets(0, 0, 5, 10);
		gbc_bt_deleteOtherClassifier.gridx = 10;
		gbc_bt_deleteOtherClassifier.gridy = 15;
		panel_description.add(bt_deleteOtherClassifier, gbc_bt_deleteOtherClassifier);
		
		tf_otherIdentifierName = new JTextField();
		tf_otherIdentifierName.setEditable(false);
		tf_otherIdentifierName.setColumns(10);
		GridBagConstraints gbc_tf_otherIdentifierName = new GridBagConstraints();
		gbc_tf_otherIdentifierName.gridwidth = 2;
		gbc_tf_otherIdentifierName.insets = new Insets(0, 10, 0, 5);
		gbc_tf_otherIdentifierName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherIdentifierName.gridx = 0;
		gbc_tf_otherIdentifierName.gridy = 16;
		panel_description.add(tf_otherIdentifierName, gbc_tf_otherIdentifierName);
		
		tf_otherIdentifierContent = new JTextField();
		tf_otherIdentifierContent.setEditable(false);
		tf_otherIdentifierContent.setColumns(10);
		GridBagConstraints gbc_tf_otherIdentifierContent = new GridBagConstraints();
		gbc_tf_otherIdentifierContent.insets = new Insets(0, 0, 0, 5);
		gbc_tf_otherIdentifierContent.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherIdentifierContent.gridx = 2;
		gbc_tf_otherIdentifierContent.gridy = 16;
		panel_description.add(tf_otherIdentifierContent, gbc_tf_otherIdentifierContent);
		
		bt_addOtherIdentifier = new JButton("增加");
		bt_addOtherIdentifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_otherIdentifierName.getText(),tf_otherIdentifierContent.getText()};
				model_otherIdentifier.addRow(info);
				tf_otherIdentifierName.setText("");
				tf_otherIdentifierContent.setText("");
			}
		});
		bt_addOtherIdentifier.setEnabled(false);
		GridBagConstraints gbc_bt_addOtherIdentifier = new GridBagConstraints();
		gbc_bt_addOtherIdentifier.insets = new Insets(0, 0, 0, 5);
		gbc_bt_addOtherIdentifier.gridx = 3;
		gbc_bt_addOtherIdentifier.gridy = 16;
		panel_description.add(bt_addOtherIdentifier, gbc_bt_addOtherIdentifier);
		
		bt_deleteOtherIdentifier = new JButton("删除");
		bt_deleteOtherIdentifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_otherIdentifier.getSelectedRow();
				if (selectedRow != -1) {
					model_otherIdentifier.removeRow(selectedRow);
				}
			}
		});
		bt_deleteOtherIdentifier.setEnabled(false);
		GridBagConstraints gbc_bt_deleteOtherIdentifier = new GridBagConstraints();
		gbc_bt_deleteOtherIdentifier.insets = new Insets(0, 0, 0, 5);
		gbc_bt_deleteOtherIdentifier.gridx = 4;
		gbc_bt_deleteOtherIdentifier.gridy = 16;
		panel_description.add(bt_deleteOtherIdentifier, gbc_bt_deleteOtherIdentifier);
		
		JPanel panel_constraints = new JPanel();
		tp_content.addTab("约束条件信息", null, panel_constraints, null);
		GridBagLayout gbl_panel_constraints = new GridBagLayout();
		gbl_panel_constraints.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_constraints.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 33, 0, 0, 0, 33, 0, 0};
		gbl_panel_constraints.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_constraints.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_constraints.setLayout(gbl_panel_constraints);
		
		JCheckBox ckbx_validTM = new JCheckBox("有效时间");
		ckbx_validTM.setSelected(true);
		GridBagConstraints gbc_ckbx_validTM = new GridBagConstraints();
		gbc_ckbx_validTM.anchor = GridBagConstraints.WEST;
		gbc_ckbx_validTM.insets = new Insets(0, 50, 5, 5);
		gbc_ckbx_validTM.gridx = 0;
		gbc_ckbx_validTM.gridy = 0;
		panel_constraints.add(ckbx_validTM, gbc_ckbx_validTM);
		
		JLabel lb_beginTM = new JLabel("起始时间:");
		GridBagConstraints gbc_lb_beginTM = new GridBagConstraints();
		gbc_lb_beginTM.insets = new Insets(10, 50, 10, 5);
		gbc_lb_beginTM.gridx = 0;
		gbc_lb_beginTM.gridy = 1;
		panel_constraints.add(lb_beginTM, gbc_lb_beginTM);
		
		cbbx_beginTM = new JComboBox();
		cbbx_beginTM.setModel(new DefaultComboBoxModel(new String[] {"确定时间点", "不定时间点"}));
		cbbx_beginTM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbbx_beginTM.getSelectedItem().equals("不定时间点")) {
					tf_beginTM.setEditable(false);
					tf_beginTM.setBackground(Grey);
					tf_beginTM.setText("");
				}else if (cbbx_beginTM.getSelectedItem().equals("确定时间点")) {
					tf_beginTM.setEditable(true);
					tf_beginTM.setBackground(Color.white);
				}
			}
		});
		GridBagConstraints gbc_cbbx_beginTM = new GridBagConstraints();
		gbc_cbbx_beginTM.gridwidth = 4;
		gbc_cbbx_beginTM.insets = new Insets(0, 0, 5, 30);
		gbc_cbbx_beginTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbx_beginTM.gridx = 1;
		gbc_cbbx_beginTM.gridy = 1;
		panel_constraints.add(cbbx_beginTM, gbc_cbbx_beginTM);
		
		tf_beginTM = new JTextField();
		hintText hintBeginTM = new hintText(tf_beginTM, "如：2018-01-01T08:00:00.0Z");
		tf_beginTM.addFocusListener(new JTextFieldHintListener("如：2018-01-01T08:00:00.0Z", tf_beginTM));
		tf_beginTM.setColumns(10);
		GridBagConstraints gbc_tf_beginTM = new GridBagConstraints();
		gbc_tf_beginTM.gridwidth = 4;
		gbc_tf_beginTM.insets = new Insets(0, 0, 5, 30);
		gbc_tf_beginTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_beginTM.gridx = 1;
		gbc_tf_beginTM.gridy = 2;
		panel_constraints.add(tf_beginTM, gbc_tf_beginTM);
		
		JLabel lb_endTM = new JLabel("结束时间:");
		GridBagConstraints gbc_lb_endTM = new GridBagConstraints();
		gbc_lb_endTM.insets = new Insets(10, 50, 5, 5);
		gbc_lb_endTM.gridx = 0;
		gbc_lb_endTM.gridy = 3;
		panel_constraints.add(lb_endTM, gbc_lb_endTM);
		
		cbbx_endTM = new JComboBox();
		cbbx_endTM.setModel(new DefaultComboBoxModel(new String[] {"确定时间点", "不定时间点"}));
		cbbx_endTM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbbx_endTM.getSelectedItem().equals("确定时间点")) {
					tf_endTM.setEditable(true);
					tf_endTM.setBackground(Color.white);
				}else if (cbbx_endTM.getSelectedItem().equals("不定时间点")) {
					tf_endTM.setEditable(false);
					tf_endTM.setBackground(Grey);
					tf_endTM.setText("");
				}
			}
		});
		GridBagConstraints gbc_cbbx_endTM = new GridBagConstraints();
		gbc_cbbx_endTM.gridwidth = 4;
		gbc_cbbx_endTM.insets = new Insets(0, 0, 5, 30);
		gbc_cbbx_endTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbx_endTM.gridx = 1;
		gbc_cbbx_endTM.gridy = 3;
		panel_constraints.add(cbbx_endTM, gbc_cbbx_endTM);
		
		tf_endTM = new JTextField();
		hintText hintEndTM = new hintText(tf_endTM, "如：2020-01-01T08:00:00.0Z");
		tf_endTM.addFocusListener(new JTextFieldHintListener("如：2020-01-01T08:00:00.0Z", tf_endTM));
		tf_endTM.setColumns(10);
		GridBagConstraints gbc_tf_endTM = new GridBagConstraints();
		gbc_tf_endTM.gridwidth = 4;
		gbc_tf_endTM.insets = new Insets(0, 0, 5, 30);
		gbc_tf_endTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_endTM.gridx = 1;
		gbc_tf_endTM.gridy = 4;
		panel_constraints.add(tf_endTM, gbc_tf_endTM);
		
		ckbx_legalConstraint = new JCheckBox("法律约束概述");
		GridBagConstraints gbc_ckbx_legalConstraint = new GridBagConstraints();
		gbc_ckbx_legalConstraint.insets = new Insets(10, 0, 5, 5);
		gbc_ckbx_legalConstraint.gridx = 0;
		gbc_ckbx_legalConstraint.gridy = 5;
		panel_constraints.add(ckbx_legalConstraint, gbc_ckbx_legalConstraint);
		ckbx_legalConstraint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_legalConstraint.isSelected()) {
					ta_legalConstraint.setEditable(true);
					ta_legalConstraint.setBackground(Color.white);
				}else {
					ta_legalConstraint.setEditable(false);
					ta_legalConstraint.setBackground(Grey);
					ta_legalConstraint.setText("");
				}
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 3;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.insets = new Insets(0, 50, 5, 30);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 6;
		panel_constraints.add(scrollPane_1, gbc_scrollPane_1);
		
		ta_legalConstraint = new JTextArea();
		scrollPane_1.setViewportView(ta_legalConstraint);
		ta_legalConstraint.setEditable(false);
		ta_legalConstraint.setBackground(SystemColor.menu);
		
		ckbx_securityConstraint = new JCheckBox("安全约束概述");
		GridBagConstraints gbc_ckbx_securityConstraint = new GridBagConstraints();
		gbc_ckbx_securityConstraint.insets = new Insets(10, 0, 5, 5);
		gbc_ckbx_securityConstraint.gridx = 0;
		gbc_ckbx_securityConstraint.gridy = 9;
		panel_constraints.add(ckbx_securityConstraint, gbc_ckbx_securityConstraint);
		ckbx_securityConstraint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_securityConstraint.isSelected()) {
					ta_securityConstraint.setEditable(true);
					ta_securityConstraint.setBackground(Color.white);
				}
				else {
					ta_securityConstraint.setEditable(false);
					ta_securityConstraint.setBackground(Grey);
					ta_securityConstraint.setText("");
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 50, 5, 30);
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 10;
		panel_constraints.add(scrollPane, gbc_scrollPane);
		
		ta_securityConstraint = new JTextArea();
		scrollPane.setViewportView(ta_securityConstraint);
		ta_securityConstraint.setEditable(false);
		ta_securityConstraint.setBackground(SystemColor.menu);
		
		JPanel panel_characterCapability = new JPanel();
		tp_content.addTab("特征能力信息", null, panel_characterCapability, null);
		GridBagLayout gbl_panel_characterCapability = new GridBagLayout();
		gbl_panel_characterCapability.columnWidths = new int[]{0, 0};
		gbl_panel_characterCapability.rowHeights = new int[]{0, 0};
		gbl_panel_characterCapability.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_characterCapability.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_characterCapability.setLayout(gbl_panel_characterCapability);
		
		JTabbedPane tp_capability = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tp_capability = new GridBagConstraints();
		gbc_tp_capability.fill = GridBagConstraints.BOTH;
		gbc_tp_capability.gridx = 0;
		gbc_tp_capability.gridy = 0;
		panel_characterCapability.add(tp_capability, gbc_tp_capability);
		
		JPanel panel_generalCharacter = new JPanel();
		tp_capability.addTab("     传感器物理特征     ", null, panel_generalCharacter, null);
		GridBagLayout gbl_panel_generalCharacter = new GridBagLayout();
		gbl_panel_generalCharacter.columnWidths = new int[]{35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_generalCharacter.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, 0, 0, 0, 0};
		gbl_panel_generalCharacter.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_generalCharacter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_generalCharacter.setLayout(gbl_panel_generalCharacter);
		
		JLabel lb_physicalCharacter = new JLabel("传感器物理特征");
		lb_physicalCharacter.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_physicalCharacter = new GridBagConstraints();
		gbc_lb_physicalCharacter.gridwidth = 2;
		gbc_lb_physicalCharacter.insets = new Insets(5, 5, 5, 5);
		gbc_lb_physicalCharacter.gridx = 0;
		gbc_lb_physicalCharacter.gridy = 0;
		panel_generalCharacter.add(lb_physicalCharacter, gbc_lb_physicalCharacter);
		
		JLabel lb_workEnviroment = new JLabel("工作环境");
		lb_workEnviroment.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_workEnviroment = new GridBagConstraints();
		gbc_lb_workEnviroment.gridwidth = 2;
		gbc_lb_workEnviroment.insets = new Insets(0, 0, 5, 5);
		gbc_lb_workEnviroment.gridx = 7;
		gbc_lb_workEnviroment.gridy = 0;
		panel_generalCharacter.add(lb_workEnviroment, gbc_lb_workEnviroment);
		
		ckbx_length = new JCheckBox("长度(m):");
		ckbx_length.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_length.isSelected()) {
					tf_length.setEditable(true);
					tf_length.setBackground(Color.white);
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
		panel_generalCharacter.add(ckbx_length, gbc_ckbx_length);
		
		tf_length = new JTextField();
		tf_length.setEditable(false);
		tf_length.setColumns(10);
		GridBagConstraints gbc_tf_length = new GridBagConstraints();
		gbc_tf_length.gridwidth = 6;
		gbc_tf_length.insets = new Insets(0, 0, 5, 5);
		gbc_tf_length.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_length.gridx = 1;
		gbc_tf_length.gridy = 1;
		panel_generalCharacter.add(tf_length, gbc_tf_length);
		
		ckbx_life = new JCheckBox("设计寿命(year):");
		ckbx_life.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_life.isSelected()) {
					tf_life.setEditable(true);
					tf_life.setBackground(Color.white);
				}else {
					tf_life.setEditable(false);
					tf_life.setBackground(Grey);
					tf_life.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_life = new GridBagConstraints();
		gbc_ckbx_life.gridwidth = 2;
		gbc_ckbx_life.anchor = GridBagConstraints.WEST;
		gbc_ckbx_life.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_life.gridx = 7;
		gbc_ckbx_life.gridy = 1;
		panel_generalCharacter.add(ckbx_life, gbc_ckbx_life);
		
		tf_life = new JTextField();
		tf_life.setEditable(false);
		tf_life.setColumns(10);
		GridBagConstraints gbc_tf_life = new GridBagConstraints();
		gbc_tf_life.gridwidth = 5;
		gbc_tf_life.insets = new Insets(0, 0, 5, 0);
		gbc_tf_life.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_life.gridx = 9;
		gbc_tf_life.gridy = 1;
		panel_generalCharacter.add(tf_life, gbc_tf_life);
		
		ckbx_width = new JCheckBox("宽度(m):");
		ckbx_width.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_width.isSelected()) {
					tf_width.setEditable(true);
					tf_width.setBackground(Color.white);
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
		panel_generalCharacter.add(ckbx_width, gbc_ckbx_width);
		
		tf_width = new JTextField();
		tf_width.setEditable(false);
		tf_width.setColumns(10);
		GridBagConstraints gbc_tf_width = new GridBagConstraints();
		gbc_tf_width.gridwidth = 6;
		gbc_tf_width.insets = new Insets(0, 0, 5, 5);
		gbc_tf_width.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_width.gridx = 1;
		gbc_tf_width.gridy = 2;
		panel_generalCharacter.add(tf_width, gbc_tf_width);
		
		ckbx_humidity = new JCheckBox("工作湿度范围(%):");
		ckbx_humidity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_humidity.isSelected()) {
					tf_maxHumidity.setEditable(true);
					tf_maxHumidity.setBackground(Color.white);
					tf_minHumidity.setEditable(true);
					tf_minHumidity.setBackground(Color.white);
				}else {
					tf_maxHumidity.setEditable(false);
					tf_maxHumidity.setBackground(Grey);
					tf_maxHumidity.setText("");
					tf_minHumidity.setEditable(false);
					tf_minHumidity.setBackground(Grey);
					tf_minHumidity.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_humidity = new GridBagConstraints();
		gbc_ckbx_humidity.gridwidth = 2;
		gbc_ckbx_humidity.anchor = GridBagConstraints.WEST;
		gbc_ckbx_humidity.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_humidity.gridx = 7;
		gbc_ckbx_humidity.gridy = 2;
		panel_generalCharacter.add(ckbx_humidity, gbc_ckbx_humidity);
		
		tf_minHumidity = new JTextField();
		tf_minHumidity.setEditable(false);
		tf_minHumidity.setColumns(10);
		GridBagConstraints gbc_tf_minHumidity = new GridBagConstraints();
		gbc_tf_minHumidity.gridwidth = 2;
		gbc_tf_minHumidity.insets = new Insets(0, 0, 5, 5);
		gbc_tf_minHumidity.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_minHumidity.gridx = 9;
		gbc_tf_minHumidity.gridy = 2;
		panel_generalCharacter.add(tf_minHumidity, gbc_tf_minHumidity);
		
		JLabel lb_line1 = new JLabel("—");
		GridBagConstraints gbc_lb_line1 = new GridBagConstraints();
		gbc_lb_line1.insets = new Insets(0, 0, 5, 5);
		gbc_lb_line1.anchor = GridBagConstraints.EAST;
		gbc_lb_line1.gridx = 11;
		gbc_lb_line1.gridy = 2;
		panel_generalCharacter.add(lb_line1, gbc_lb_line1);
		
		tf_maxHumidity = new JTextField();
		tf_maxHumidity.setEditable(false);
		tf_maxHumidity.setColumns(10);
		GridBagConstraints gbc_tf_maxHumidity = new GridBagConstraints();
		gbc_tf_maxHumidity.gridwidth = 2;
		gbc_tf_maxHumidity.insets = new Insets(0, 0, 5, 0);
		gbc_tf_maxHumidity.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_maxHumidity.gridx = 12;
		gbc_tf_maxHumidity.gridy = 2;
		panel_generalCharacter.add(tf_maxHumidity, gbc_tf_maxHumidity);
		
		ckbx_height = new JCheckBox("高度(m):");
		ckbx_height.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_height.isSelected()) {
					tf_height.setEditable(true);
					tf_height.setBackground(Color.white);
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
		panel_generalCharacter.add(ckbx_height, gbc_ckbx_height);
		
		tf_height = new JTextField();
		tf_height.setEditable(false);
		tf_height.setColumns(10);
		GridBagConstraints gbc_tf_height = new GridBagConstraints();
		gbc_tf_height.gridwidth = 6;
		gbc_tf_height.insets = new Insets(0, 0, 5, 5);
		gbc_tf_height.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_height.gridx = 1;
		gbc_tf_height.gridy = 3;
		panel_generalCharacter.add(tf_height, gbc_tf_height);
		
		ckbx_temperature = new JCheckBox("工作温度范围(℃):");
		ckbx_temperature.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_temperature.isSelected()) {
					tf_maxTemperature.setEditable(true);
					tf_maxTemperature.setBackground(Color.white);
					tf_minTemperature.setEditable(true);
					tf_minTemperature.setBackground(Color.white);
				}else {
					tf_maxTemperature.setEditable(false);
					tf_maxTemperature.setBackground(Grey);
					tf_maxTemperature.setText("");
					tf_minTemperature.setEditable(false);
					tf_minTemperature.setBackground(Grey);
					tf_minTemperature.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_temperature = new GridBagConstraints();
		gbc_ckbx_temperature.gridwidth = 2;
		gbc_ckbx_temperature.anchor = GridBagConstraints.WEST;
		gbc_ckbx_temperature.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_temperature.gridx = 7;
		gbc_ckbx_temperature.gridy = 3;
		panel_generalCharacter.add(ckbx_temperature, gbc_ckbx_temperature);
		
		tf_minTemperature = new JTextField();
		tf_minTemperature.setEditable(false);
		tf_minTemperature.setColumns(10);
		GridBagConstraints gbc_tf_minTemperature = new GridBagConstraints();
		gbc_tf_minTemperature.gridwidth = 2;
		gbc_tf_minTemperature.insets = new Insets(0, 0, 5, 5);
		gbc_tf_minTemperature.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_minTemperature.gridx = 9;
		gbc_tf_minTemperature.gridy = 3;
		panel_generalCharacter.add(tf_minTemperature, gbc_tf_minTemperature);
		
		JLabel lb_line2 = new JLabel("—");
		GridBagConstraints gbc_lb_line2 = new GridBagConstraints();
		gbc_lb_line2.insets = new Insets(0, 0, 5, 5);
		gbc_lb_line2.anchor = GridBagConstraints.EAST;
		gbc_lb_line2.gridx = 11;
		gbc_lb_line2.gridy = 3;
		panel_generalCharacter.add(lb_line2, gbc_lb_line2);
		
		tf_maxTemperature = new JTextField();
		tf_maxTemperature.setEditable(false);
		tf_maxTemperature.setColumns(10);
		GridBagConstraints gbc_tf_maxTemperature = new GridBagConstraints();
		gbc_tf_maxTemperature.gridwidth = 2;
		gbc_tf_maxTemperature.insets = new Insets(0, 0, 5, 0);
		gbc_tf_maxTemperature.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_maxTemperature.gridx = 12;
		gbc_tf_maxTemperature.gridy = 3;
		panel_generalCharacter.add(tf_maxTemperature, gbc_tf_maxTemperature);
		
		ckbx_weight = new JCheckBox("质量(kg):");
		ckbx_weight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_weight.isSelected()) {
					tf_weight.setEditable(true);
					tf_weight.setBackground(Color.white);
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
		panel_generalCharacter.add(ckbx_weight, gbc_ckbx_weight);
		
		tf_weight = new JTextField();
		tf_weight.setEditable(false);
		tf_weight.setColumns(10);
		GridBagConstraints gbc_tf_weight = new GridBagConstraints();
		gbc_tf_weight.gridwidth = 6;
		gbc_tf_weight.insets = new Insets(0, 0, 5, 5);
		gbc_tf_weight.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_weight.gridx = 1;
		gbc_tf_weight.gridy = 4;
		panel_generalCharacter.add(tf_weight, gbc_tf_weight);
		
		ckbx_protectionGrade = new JCheckBox("防护等级:");
		ckbx_protectionGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_protectionGrade.isSelected()) {
					tf_protectionGrade.setEditable(true);
					tf_protectionGrade.setBackground(Color.white);
				}else {
					tf_protectionGrade.setEditable(false);
					tf_protectionGrade.setBackground(Grey);
					tf_protectionGrade.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_protectionGrade = new GridBagConstraints();
		gbc_ckbx_protectionGrade.anchor = GridBagConstraints.WEST;
		gbc_ckbx_protectionGrade.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_protectionGrade.gridx = 7;
		gbc_ckbx_protectionGrade.gridy = 4;
		panel_generalCharacter.add(ckbx_protectionGrade, gbc_ckbx_protectionGrade);
		
		tf_protectionGrade = new JTextField();
		tf_protectionGrade.setEditable(false);
		tf_protectionGrade.setColumns(10);
		GridBagConstraints gbc_tf_protectionGrade = new GridBagConstraints();
		gbc_tf_protectionGrade.gridwidth = 6;
		gbc_tf_protectionGrade.insets = new Insets(0, 0, 5, 0);
		gbc_tf_protectionGrade.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_protectionGrade.gridx = 8;
		gbc_tf_protectionGrade.gridy = 4;
		panel_generalCharacter.add(tf_protectionGrade, gbc_tf_protectionGrade);
		
		ckbx_MTBF = new JCheckBox("无故障时间(h):");
		ckbx_MTBF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_MTBF.isSelected()) {
					tf_MTBF.setEditable(true);
					tf_MTBF.setBackground(Color.white);
				}else {
					tf_MTBF.setEditable(false);
					tf_MTBF.setBackground(Grey);
					tf_MTBF.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_MTBF = new GridBagConstraints();
		gbc_ckbx_MTBF.gridwidth = 2;
		gbc_ckbx_MTBF.anchor = GridBagConstraints.WEST;
		gbc_ckbx_MTBF.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_MTBF.gridx = 7;
		gbc_ckbx_MTBF.gridy = 5;
		panel_generalCharacter.add(ckbx_MTBF, gbc_ckbx_MTBF);
		
		tf_MTBF = new JTextField();
		tf_MTBF.setEditable(false);
		tf_MTBF.setColumns(10);
		GridBagConstraints gbc_tf_MTBF = new GridBagConstraints();
		gbc_tf_MTBF.gridwidth = 5;
		gbc_tf_MTBF.insets = new Insets(0, 0, 5, 0);
		gbc_tf_MTBF.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_MTBF.gridx = 9;
		gbc_tf_MTBF.gridy = 5;
		panel_generalCharacter.add(tf_MTBF, gbc_tf_MTBF);
		
		JLabel lb_electricalCharac = new JLabel("  供电通信特征");
		lb_electricalCharac.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_electricalCharac = new GridBagConstraints();
		gbc_lb_electricalCharac.gridwidth = 2;
		gbc_lb_electricalCharac.insets = new Insets(0, 0, 5, 5);
		gbc_lb_electricalCharac.gridx = 0;
		gbc_lb_electricalCharac.gridy = 6;
		panel_generalCharacter.add(lb_electricalCharac, gbc_lb_electricalCharac);
		
		ckbx_isOperable = new JCheckBox("是否可控:");
		ckbx_isOperable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_isOperable.isSelected()) {
					cbbx_isOperable.setEnabled(true);
				}else {
					cbbx_isOperable.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_ckbx_isOperable = new GridBagConstraints();
		gbc_ckbx_isOperable.anchor = GridBagConstraints.WEST;
		gbc_ckbx_isOperable.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_isOperable.gridx = 7;
		gbc_ckbx_isOperable.gridy = 6;
		panel_generalCharacter.add(ckbx_isOperable, gbc_ckbx_isOperable);
		
		cbbx_isOperable = new JComboBox();
		cbbx_isOperable.setEnabled(false);
		cbbx_isOperable.setModel(new DefaultComboBoxModel(new String[] {"TRUE", "FALSE"}));
		GridBagConstraints gbc_cbbx_isOperable = new GridBagConstraints();
		gbc_cbbx_isOperable.gridwidth = 6;
		gbc_cbbx_isOperable.insets = new Insets(0, 0, 5, 0);
		gbc_cbbx_isOperable.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbx_isOperable.gridx = 8;
		gbc_cbbx_isOperable.gridy = 6;
		panel_generalCharacter.add(cbbx_isOperable, gbc_cbbx_isOperable);
		
		ckbx_currentType = new JCheckBox("电源类型:");
		ckbx_currentType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_currentType.isSelected()) {
					cbbx_currentType.setEnabled(true);
				}else {
					cbbx_currentType.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_ckbx_currentType = new GridBagConstraints();
		gbc_ckbx_currentType.anchor = GridBagConstraints.WEST;
		gbc_ckbx_currentType.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_currentType.gridx = 0;
		gbc_ckbx_currentType.gridy = 7;
		panel_generalCharacter.add(ckbx_currentType, gbc_ckbx_currentType);
		
		cbbx_currentType = new JComboBox();
		cbbx_currentType.setModel(new DefaultComboBoxModel(new String[] {"直流电源", "交流电源", "其他电源类型"}));
		cbbx_currentType.setEnabled(false);
		GridBagConstraints gbc_cbbx_currentType = new GridBagConstraints();
		gbc_cbbx_currentType.gridwidth = 6;
		gbc_cbbx_currentType.insets = new Insets(0, 0, 5, 5);
		gbc_cbbx_currentType.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbx_currentType.gridx = 1;
		gbc_cbbx_currentType.gridy = 7;
		panel_generalCharacter.add(cbbx_currentType, gbc_cbbx_currentType);
		
		ckbx_current = new JCheckBox("电流(A):");
		ckbx_current.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_current.isSelected()) {
					tf_minCurrent.setEditable(true);
					tf_minCurrent.setBackground(Color.white);
					tf_maxCurrent.setEditable(true);
					tf_maxCurrent.setBackground(Color.white);
				}else {
					tf_minCurrent.setEditable(false);
					tf_minCurrent.setBackground(Grey);
					tf_minCurrent.setText("");
					tf_maxCurrent.setEditable(false);
					tf_maxCurrent.setBackground(Grey);
					tf_maxCurrent.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_current = new GridBagConstraints();
		gbc_ckbx_current.anchor = GridBagConstraints.WEST;
		gbc_ckbx_current.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_current.gridx = 0;
		gbc_ckbx_current.gridy = 8;
		panel_generalCharacter.add(ckbx_current, gbc_ckbx_current);
		
		tf_minCurrent = new JTextField();
		tf_minCurrent.setEditable(false);
		tf_minCurrent.setColumns(10);
		GridBagConstraints gbc_tf_minCurrent = new GridBagConstraints();
		gbc_tf_minCurrent.gridwidth = 2;
		gbc_tf_minCurrent.insets = new Insets(0, 0, 5, 5);
		gbc_tf_minCurrent.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_minCurrent.gridx = 1;
		gbc_tf_minCurrent.gridy = 8;
		panel_generalCharacter.add(tf_minCurrent, gbc_tf_minCurrent);
		
		JLabel label_2 = new JLabel("—");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.gridx = 4;
		gbc_label_2.gridy = 8;
		panel_generalCharacter.add(label_2, gbc_label_2);
		
		tf_maxCurrent = new JTextField();
		tf_maxCurrent.setEditable(false);
		tf_maxCurrent.setColumns(10);
		GridBagConstraints gbc_tf_maxCurrent = new GridBagConstraints();
		gbc_tf_maxCurrent.gridwidth = 2;
		gbc_tf_maxCurrent.insets = new Insets(0, 0, 5, 5);
		gbc_tf_maxCurrent.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_maxCurrent.gridx = 5;
		gbc_tf_maxCurrent.gridy = 8;
		panel_generalCharacter.add(tf_maxCurrent, gbc_tf_maxCurrent);
		
		ckbx_otherCharacter = new JCheckBox("添加其他特征:");
		GridBagConstraints gbc_ckbx_otherCharacter = new GridBagConstraints();
		gbc_ckbx_otherCharacter.gridwidth = 2;
		gbc_ckbx_otherCharacter.anchor = GridBagConstraints.WEST;
		gbc_ckbx_otherCharacter.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_otherCharacter.gridx = 7;
		gbc_ckbx_otherCharacter.gridy = 8;
		panel_generalCharacter.add(ckbx_otherCharacter, gbc_ckbx_otherCharacter);
		
		ckbx_voltage = new JCheckBox("电压(V):");
		ckbx_voltage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_voltage.isSelected()) {
					tf_minVoltage.setEditable(true);
					tf_minVoltage.setBackground(Color.white);
					tf_maxVoltage.setEditable(true);
					tf_maxVoltage.setBackground(Color.white);
				}else {
					tf_minVoltage.setEditable(false);
					tf_minVoltage.setBackground(Grey);
					tf_minVoltage.setText("");
					tf_maxVoltage.setEditable(false);
					tf_maxVoltage.setBackground(Grey);
					tf_maxVoltage.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_voltage = new GridBagConstraints();
		gbc_ckbx_voltage.anchor = GridBagConstraints.WEST;
		gbc_ckbx_voltage.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_voltage.gridx = 0;
		gbc_ckbx_voltage.gridy = 9;
		panel_generalCharacter.add(ckbx_voltage, gbc_ckbx_voltage);
		
		tf_minVoltage = new JTextField();
		tf_minVoltage.setEditable(false);
		tf_minVoltage.setColumns(10);
		GridBagConstraints gbc_tf_minVoltage = new GridBagConstraints();
		gbc_tf_minVoltage.gridwidth = 2;
		gbc_tf_minVoltage.insets = new Insets(0, 0, 5, 5);
		gbc_tf_minVoltage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_minVoltage.gridx = 1;
		gbc_tf_minVoltage.gridy = 9;
		panel_generalCharacter.add(tf_minVoltage, gbc_tf_minVoltage);
		
		JLabel label_4 = new JLabel("—");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 4;
		gbc_label_4.gridy = 9;
		panel_generalCharacter.add(label_4, gbc_label_4);
		
		tf_maxVoltage = new JTextField();
		tf_maxVoltage.setEditable(false);
		tf_maxVoltage.setColumns(10);
		GridBagConstraints gbc_tf_maxVoltage = new GridBagConstraints();
		gbc_tf_maxVoltage.gridwidth = 2;
		gbc_tf_maxVoltage.insets = new Insets(0, 0, 5, 5);
		gbc_tf_maxVoltage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_maxVoltage.gridx = 5;
		gbc_tf_maxVoltage.gridy = 9;
		panel_generalCharacter.add(tf_maxVoltage, gbc_tf_maxVoltage);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridwidth = 7;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridheight = 3;
		gbc_scrollPane_2.gridx = 7;
		gbc_scrollPane_2.gridy = 9;
		panel_generalCharacter.add(scrollPane_2, gbc_scrollPane_2);
		
		tb_otherCharacter = new JTable();
		tb_otherCharacter.setBackground(new Color(175, 238, 238));
		scrollPane_2.setViewportView(tb_otherCharacter);
		model_otherCharacter = new DefaultTableModel(new Object[][] {},new String[] {"字段名称", "字段内容"});
		tb_otherCharacter.setModel(model_otherCharacter);
		tb_otherCharacter.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ckbx_power = new JCheckBox("功率(W):");
		ckbx_power.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_power.isSelected()) {
					tf_power.setEditable(true);
					tf_power.setBackground(Color.white);
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
		gbc_ckbx_power.gridy = 10;
		panel_generalCharacter.add(ckbx_power, gbc_ckbx_power);
		
		tf_power = new JTextField();
		tf_power.setEditable(false);
		tf_power.setColumns(10);
		GridBagConstraints gbc_tf_power = new GridBagConstraints();
		gbc_tf_power.gridwidth = 6;
		gbc_tf_power.insets = new Insets(0, 0, 5, 5);
		gbc_tf_power.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_power.gridx = 1;
		gbc_tf_power.gridy = 10;
		panel_generalCharacter.add(tf_power, gbc_tf_power);
		
		ckbx_outputPower = new JCheckBox("输出功率(W):");
		ckbx_outputPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_outputPower.isSelected()) {
					tf_outputPower.setEditable(true);
					tf_outputPower.setBackground(Color.white);
				}else {
					tf_outputPower.setEditable(false);
					tf_outputPower.setBackground(Grey);
					tf_outputPower.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_outputPower = new GridBagConstraints();
		gbc_ckbx_outputPower.anchor = GridBagConstraints.WEST;
		gbc_ckbx_outputPower.gridwidth = 2;
		gbc_ckbx_outputPower.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_outputPower.gridx = 0;
		gbc_ckbx_outputPower.gridy = 11;
		panel_generalCharacter.add(ckbx_outputPower, gbc_ckbx_outputPower);
		
		tf_outputPower = new JTextField();
		tf_outputPower.setEditable(false);
		tf_outputPower.setColumns(10);
		GridBagConstraints gbc_tf_outputPower = new GridBagConstraints();
		gbc_tf_outputPower.gridwidth = 5;
		gbc_tf_outputPower.insets = new Insets(0, 0, 5, 5);
		gbc_tf_outputPower.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_outputPower.gridx = 2;
		gbc_tf_outputPower.gridy = 11;
		panel_generalCharacter.add(tf_outputPower, gbc_tf_outputPower);
		
		tf_otherCharacterName = new JTextField();
		tf_otherCharacterName.setEditable(false);
		tf_otherCharacterName.setColumns(10);
		GridBagConstraints gbc_tf_otherCharacterName = new GridBagConstraints();
		gbc_tf_otherCharacterName.insets = new Insets(0, 0, 5, 5);
		gbc_tf_otherCharacterName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherCharacterName.gridx = 7;
		gbc_tf_otherCharacterName.gridy = 12;
		panel_generalCharacter.add(tf_otherCharacterName, gbc_tf_otherCharacterName);
		
		tf_otherCharacterContent = new JTextField();
		tf_otherCharacterContent.setEditable(false);
		tf_otherCharacterContent.setColumns(10);
		GridBagConstraints gbc_tf_otherCharacterContent = new GridBagConstraints();
		gbc_tf_otherCharacterContent.gridwidth = 3;
		gbc_tf_otherCharacterContent.insets = new Insets(0, 0, 5, 5);
		gbc_tf_otherCharacterContent.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherCharacterContent.gridx = 8;
		gbc_tf_otherCharacterContent.gridy = 12;
		panel_generalCharacter.add(tf_otherCharacterContent, gbc_tf_otherCharacterContent);
		
		JButton bt_addCharacter = new JButton("增加");
		bt_addCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_otherCharacterName.getText(),tf_otherCharacterContent.getText()};
				model_otherCharacter.addRow(info);
				tf_otherCharacterName.setText("");
				tf_otherCharacterContent.setText("");
			}
		});
		bt_addCharacter.setEnabled(false);
		GridBagConstraints gbc_bt_addCharacter = new GridBagConstraints();
		gbc_bt_addCharacter.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addCharacter.gridx = 12;
		gbc_bt_addCharacter.gridy = 12;
		panel_generalCharacter.add(bt_addCharacter, gbc_bt_addCharacter);
		
		JButton bt_deleteCharacter = new JButton("删除");
		bt_deleteCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_otherCharacter.getSelectedRow();
				if (selectedRow != -1) {
					model_otherCharacter.removeRow(selectedRow);		
				}
			}
		});
		bt_deleteCharacter.setEnabled(false);
		GridBagConstraints gbc_bt_deleteCharacter = new GridBagConstraints();
		gbc_bt_deleteCharacter.insets = new Insets(0, 0, 5, 0);
		gbc_bt_deleteCharacter.gridx = 13;
		gbc_bt_deleteCharacter.gridy = 12;
		panel_generalCharacter.add(bt_deleteCharacter, gbc_bt_deleteCharacter);
		ckbx_otherCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_otherCharacter.isSelected()) {
					tf_otherCharacterName.setEditable(true);
					tf_otherCharacterName.setBackground(Color.white);
					tf_otherCharacterContent.setEditable(true);
					tf_otherCharacterContent.setBackground(Color.white);
					bt_addCharacter.setEnabled(true);
					bt_deleteCharacter.setEnabled(true);
				}else {
					tf_otherCharacterName.setEditable(false);
					tf_otherCharacterName.setBackground(Grey);
					tf_otherCharacterContent.setEditable(false);
					tf_otherCharacterContent.setBackground(Grey);
					tf_otherCharacterName.setText("");
					tf_otherCharacterContent.setText("");
					bt_addCharacter.setEnabled(false);
					bt_deleteCharacter.setEnabled(false);
					model_otherCharacter.setRowCount(0);
				}
			}
		});
		
		JPanel panel_capability = new JPanel();
		tp_capability.addTab("     传感器观测能力     ", null, panel_capability, null);
		GridBagLayout gbl_panel_capability = new GridBagLayout();
		gbl_panel_capability.columnWidths = new int[]{0, 0, 118, 34, 97, 113, 0, 0, 0, 0, 0, 0};
		gbl_panel_capability.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_capability.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_capability.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_capability.setLayout(gbl_panel_capability);
		
		JLabel lb_capaBreadth = new JLabel("观测能力广度");
		lb_capaBreadth.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_capaBreadth = new GridBagConstraints();
		gbc_lb_capaBreadth.gridwidth = 2;
		gbc_lb_capaBreadth.insets = new Insets(5, 5, 5, 5);
		gbc_lb_capaBreadth.gridx = 0;
		gbc_lb_capaBreadth.gridy = 0;
		panel_capability.add(lb_capaBreadth, gbc_lb_capaBreadth);
		
		JLabel lb_obsQuality = new JLabel("观测能力质量");
		lb_obsQuality.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_obsQuality = new GridBagConstraints();
		gbc_lb_obsQuality.fill = GridBagConstraints.HORIZONTAL;
		gbc_lb_obsQuality.gridwidth = 2;
		gbc_lb_obsQuality.insets = new Insets(5, 5, 5, 5);
		gbc_lb_obsQuality.gridx = 5;
		gbc_lb_obsQuality.gridy = 0;
		panel_capability.add(lb_obsQuality, gbc_lb_obsQuality);
		
		JCheckBox ckbx_detectType = new JCheckBox("原位探测类型:");
		ckbx_detectType.setSelected(true);
		GridBagConstraints gbc_ckbx_detectType = new GridBagConstraints();
		gbc_ckbx_detectType.anchor = GridBagConstraints.WEST;
		gbc_ckbx_detectType.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_detectType.gridwidth = 2;
		gbc_ckbx_detectType.gridx = 0;
		gbc_ckbx_detectType.gridy = 1;
		panel_capability.add(ckbx_detectType, gbc_ckbx_detectType);
		
		tf_detectType = new JTextField();
		tf_detectType.setColumns(10);
		GridBagConstraints gbc_tf_detectType = new GridBagConstraints();
		gbc_tf_detectType.gridwidth = 3;
		gbc_tf_detectType.insets = new Insets(0, 0, 5, 5);
		gbc_tf_detectType.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_detectType.gridx = 2;
		gbc_tf_detectType.gridy = 1;
		panel_capability.add(tf_detectType, gbc_tf_detectType);
		
		ckbx_sensitivityTolerance = new JCheckBox("灵敏度允差(%):");
		ckbx_sensitivityTolerance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_sensitivityTolerance.isSelected()) {
					tf_sensitivityTolerance.setEditable(true);
					tf_sensitivityTolerance.setBackground(Color.white);
				}else {
					tf_sensitivityTolerance.setEditable(false);
					tf_sensitivityTolerance.setBackground(Grey);
					tf_sensitivityTolerance.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_sensitivityTolerance = new GridBagConstraints();
		gbc_ckbx_sensitivityTolerance.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_sensitivityTolerance.gridwidth = 2;
		gbc_ckbx_sensitivityTolerance.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_sensitivityTolerance.gridx = 5;
		gbc_ckbx_sensitivityTolerance.gridy = 1;
		panel_capability.add(ckbx_sensitivityTolerance, gbc_ckbx_sensitivityTolerance);
		
		tf_sensitivityTolerance = new JTextField();
		tf_sensitivityTolerance.setEditable(false);
		tf_sensitivityTolerance.setColumns(10);
		GridBagConstraints gbc_tf_sensitivityTolerance = new GridBagConstraints();
		gbc_tf_sensitivityTolerance.gridwidth = 4;
		gbc_tf_sensitivityTolerance.insets = new Insets(0, 0, 5, 0);
		gbc_tf_sensitivityTolerance.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_sensitivityTolerance.gridx = 7;
		gbc_tf_sensitivityTolerance.gridy = 1;
		panel_capability.add(tf_sensitivityTolerance, gbc_tf_sensitivityTolerance);
		
		ckbx_detectPrinciple = new JCheckBox("探测原理:");
		ckbx_detectPrinciple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_detectPrinciple.isSelected()) {
					ta_detectPrinciple.setEditable(true);
					ta_detectPrinciple.setBackground(Color.white);
				}else {
					ta_detectPrinciple.setEditable(false);
					ta_detectPrinciple.setBackground(Grey);
					ta_detectPrinciple.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_detectPrinciple = new GridBagConstraints();
		gbc_ckbx_detectPrinciple.anchor = GridBagConstraints.WEST;
		gbc_ckbx_detectPrinciple.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_detectPrinciple.gridx = 0;
		gbc_ckbx_detectPrinciple.gridy = 2;
		panel_capability.add(ckbx_detectPrinciple, gbc_ckbx_detectPrinciple);
		
		ta_detectPrinciple = new JTextArea();
		ta_detectPrinciple.setEditable(false);
		ta_detectPrinciple.setBackground(SystemColor.menu);
		GridBagConstraints gbc_ta_detectPrinciple = new GridBagConstraints();
		gbc_ta_detectPrinciple.gridwidth = 4;
		gbc_ta_detectPrinciple.gridheight = 2;
		gbc_ta_detectPrinciple.insets = new Insets(0, 0, 5, 5);
		gbc_ta_detectPrinciple.fill = GridBagConstraints.BOTH;
		gbc_ta_detectPrinciple.gridx = 1;
		gbc_ta_detectPrinciple.gridy = 2;
		panel_capability.add(ta_detectPrinciple, gbc_ta_detectPrinciple);
		
		ckbx_detectAccuracy = new JCheckBox("探测精度(%):");
		ckbx_detectAccuracy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_detectAccuracy.isSelected()) {
					tf_detectAccuracy.setEditable(true);
					tf_detectAccuracy.setBackground(Color.white);
				}else {
					tf_detectAccuracy.setEditable(false);
					tf_detectAccuracy.setBackground(Grey);
					tf_detectAccuracy.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_detectAccuracy = new GridBagConstraints();
		gbc_ckbx_detectAccuracy.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_detectAccuracy.gridwidth = 2;
		gbc_ckbx_detectAccuracy.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_detectAccuracy.gridx = 5;
		gbc_ckbx_detectAccuracy.gridy = 2;
		panel_capability.add(ckbx_detectAccuracy, gbc_ckbx_detectAccuracy);
		
		tf_detectAccuracy = new JTextField();
		tf_detectAccuracy.setEditable(false);
		tf_detectAccuracy.setColumns(10);
		GridBagConstraints gbc_tf_detectAccuracy = new GridBagConstraints();
		gbc_tf_detectAccuracy.gridwidth = 4;
		gbc_tf_detectAccuracy.insets = new Insets(0, 0, 5, 0);
		gbc_tf_detectAccuracy.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_detectAccuracy.gridx = 7;
		gbc_tf_detectAccuracy.gridy = 2;
		panel_capability.add(tf_detectAccuracy, gbc_tf_detectAccuracy);
		
		ckbx_repeatability = new JCheckBox("重复性误差(%):");
		ckbx_repeatability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_repeatability.isSelected()) {
					tf_repeatability.setEditable(true);
					tf_repeatability.setBackground(Color.white);
				}else {
					tf_repeatability.setEditable(false);
					tf_repeatability.setBackground(Grey);
					tf_repeatability.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_repeatability = new GridBagConstraints();
		gbc_ckbx_repeatability.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_repeatability.gridwidth = 2;
		gbc_ckbx_repeatability.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_repeatability.gridx = 5;
		gbc_ckbx_repeatability.gridy = 3;
		panel_capability.add(ckbx_repeatability, gbc_ckbx_repeatability);
		
		tf_repeatability = new JTextField();
		tf_repeatability.setEditable(false);
		tf_repeatability.setColumns(10);
		GridBagConstraints gbc_tf_repeatability = new GridBagConstraints();
		gbc_tf_repeatability.gridwidth = 4;
		gbc_tf_repeatability.insets = new Insets(0, 0, 5, 0);
		gbc_tf_repeatability.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_repeatability.gridx = 7;
		gbc_tf_repeatability.gridy = 3;
		panel_capability.add(tf_repeatability, gbc_tf_repeatability);
		
		ckbx_overload = new JCheckBox("极限过载(M):");
		ckbx_overload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_overload.isSelected()) {
					tf_minOverload.setEditable(true);
					tf_minOverload.setBackground(Color.white);
					tf_maxOverload.setEditable(true);
					tf_maxOverload.setBackground(Color.white);
				}else {
					tf_minOverload.setEditable(false);
					tf_minOverload.setBackground(Grey);
					tf_minOverload.setText("");
					tf_maxOverload.setEditable(false);
					tf_maxOverload.setBackground(Grey);
					tf_maxOverload.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_overload = new GridBagConstraints();
		gbc_ckbx_overload.anchor = GridBagConstraints.WEST;
		gbc_ckbx_overload.gridwidth = 2;
		gbc_ckbx_overload.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_overload.gridx = 0;
		gbc_ckbx_overload.gridy = 4;
		panel_capability.add(ckbx_overload, gbc_ckbx_overload);
		
		tf_minOverload = new JTextField();
		tf_minOverload.setEditable(false);
		tf_minOverload.setColumns(10);
		GridBagConstraints gbc_tf_minOverload = new GridBagConstraints();
		gbc_tf_minOverload.insets = new Insets(0, 0, 5, 5);
		gbc_tf_minOverload.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_minOverload.gridx = 2;
		gbc_tf_minOverload.gridy = 4;
		panel_capability.add(tf_minOverload, gbc_tf_minOverload);
		
		JLabel lb_line4 = new JLabel("—");
		GridBagConstraints gbc_lb_line4 = new GridBagConstraints();
		gbc_lb_line4.insets = new Insets(0, 0, 5, 5);
		gbc_lb_line4.gridx = 3;
		gbc_lb_line4.gridy = 4;
		panel_capability.add(lb_line4, gbc_lb_line4);
		
		tf_maxOverload = new JTextField();
		tf_maxOverload.setEditable(false);
		tf_maxOverload.setColumns(10);
		GridBagConstraints gbc_tf_maxOverload = new GridBagConstraints();
		gbc_tf_maxOverload.insets = new Insets(0, 0, 5, 5);
		gbc_tf_maxOverload.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_maxOverload.gridx = 4;
		gbc_tf_maxOverload.gridy = 4;
		panel_capability.add(tf_maxOverload, gbc_tf_maxOverload);
		
		ckbx_lag = new JCheckBox("滞后允差(%):");
		ckbx_lag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_lag.isSelected()) {
					tf_lag.setEditable(true);
					tf_lag.setBackground(Color.white);
				}else {
					tf_lag.setEditable(false);
					tf_lag.setBackground(Grey);
					tf_lag.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_lag = new GridBagConstraints();
		gbc_ckbx_lag.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_lag.gridwidth = 2;
		gbc_ckbx_lag.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_lag.gridx = 5;
		gbc_ckbx_lag.gridy = 4;
		panel_capability.add(ckbx_lag, gbc_ckbx_lag);
		
		tf_lag = new JTextField();
		tf_lag.setEditable(false);
		tf_lag.setColumns(10);
		GridBagConstraints gbc_tf_lag = new GridBagConstraints();
		gbc_tf_lag.gridwidth = 4;
		gbc_tf_lag.insets = new Insets(0, 0, 5, 0);
		gbc_tf_lag.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_lag.gridx = 7;
		gbc_tf_lag.gridy = 4;
		panel_capability.add(tf_lag, gbc_tf_lag);
		
		ckbx_measurementRange = new JCheckBox("量程范围(m):");
		ckbx_measurementRange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_measurementRange.isSelected()) {
					tf_minMeasurementRange.setEditable(true);
					tf_minMeasurementRange.setBackground(Color.white);
					tf_maxMeasurementRange.setEditable(true);
					tf_maxMeasurementRange.setBackground(Color.white);
				}else {
					tf_minMeasurementRange.setEditable(false);
					tf_minMeasurementRange.setBackground(Grey);
					tf_minMeasurementRange.setText("");
					tf_maxMeasurementRange.setEditable(false);
					tf_maxMeasurementRange.setBackground(Grey);
					tf_maxMeasurementRange.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_measurementRange = new GridBagConstraints();
		gbc_ckbx_measurementRange.anchor = GridBagConstraints.WEST;
		gbc_ckbx_measurementRange.gridwidth = 2;
		gbc_ckbx_measurementRange.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_measurementRange.gridx = 0;
		gbc_ckbx_measurementRange.gridy = 5;
		panel_capability.add(ckbx_measurementRange, gbc_ckbx_measurementRange);
		
		tf_minMeasurementRange = new JTextField();
		tf_minMeasurementRange.setEditable(false);
		tf_minMeasurementRange.setColumns(10);
		GridBagConstraints gbc_tf_minMeasurementRange = new GridBagConstraints();
		gbc_tf_minMeasurementRange.insets = new Insets(0, 0, 5, 5);
		gbc_tf_minMeasurementRange.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_minMeasurementRange.gridx = 2;
		gbc_tf_minMeasurementRange.gridy = 5;
		panel_capability.add(tf_minMeasurementRange, gbc_tf_minMeasurementRange);
		
		JLabel lb_line5 = new JLabel("—");
		GridBagConstraints gbc_lb_line5 = new GridBagConstraints();
		gbc_lb_line5.insets = new Insets(0, 0, 5, 5);
		gbc_lb_line5.gridx = 3;
		gbc_lb_line5.gridy = 5;
		panel_capability.add(lb_line5, gbc_lb_line5);
		
		tf_maxMeasurementRange = new JTextField();
		tf_maxMeasurementRange.setEditable(false);
		tf_maxMeasurementRange.setColumns(10);
		GridBagConstraints gbc_tf_maxMeasurementRange = new GridBagConstraints();
		gbc_tf_maxMeasurementRange.insets = new Insets(0, 0, 5, 5);
		gbc_tf_maxMeasurementRange.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_maxMeasurementRange.gridx = 4;
		gbc_tf_maxMeasurementRange.gridy = 5;
		panel_capability.add(tf_maxMeasurementRange, gbc_tf_maxMeasurementRange);
		
		ckbx_nonlinearity = new JCheckBox("非线性误差(%):");
		ckbx_nonlinearity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_nonlinearity.isSelected()) {
					tf_nonlinearity.setEditable(true);
					tf_nonlinearity.setBackground(Color.white);
				}else {
					tf_nonlinearity.setEditable(false);
					tf_nonlinearity.setBackground(Grey);
					tf_nonlinearity.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_nonlinearity = new GridBagConstraints();
		gbc_ckbx_nonlinearity.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_nonlinearity.gridwidth = 2;
		gbc_ckbx_nonlinearity.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_nonlinearity.gridx = 5;
		gbc_ckbx_nonlinearity.gridy = 5;
		panel_capability.add(ckbx_nonlinearity, gbc_ckbx_nonlinearity);
		
		tf_nonlinearity = new JTextField();
		tf_nonlinearity.setEditable(false);
		tf_nonlinearity.setColumns(10);
		GridBagConstraints gbc_tf_nonlinearity = new GridBagConstraints();
		gbc_tf_nonlinearity.gridwidth = 4;
		gbc_tf_nonlinearity.insets = new Insets(0, 0, 5, 0);
		gbc_tf_nonlinearity.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_nonlinearity.gridx = 7;
		gbc_tf_nonlinearity.gridy = 5;
		panel_capability.add(tf_nonlinearity, gbc_tf_nonlinearity);
		
		ckbx_frequencyRange = new JCheckBox("波段频率范围(m):");
		ckbx_frequencyRange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_frequencyRange.isSelected()) {
					tf_minFrequency.setEditable(true);
					tf_minFrequency.setBackground(Color.white);
					tf_maxFrequency.setEditable(true);
					tf_maxFrequency.setBackground(Color.white);
				}else {
					tf_minFrequency.setEditable(false);
					tf_minFrequency.setBackground(Grey);
					tf_minFrequency.setText("");
					tf_maxFrequency.setEditable(false);
					tf_maxFrequency.setBackground(Grey);
					tf_maxFrequency.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_frequencyRange = new GridBagConstraints();
		gbc_ckbx_frequencyRange.gridwidth = 2;
		gbc_ckbx_frequencyRange.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_frequencyRange.gridx = 0;
		gbc_ckbx_frequencyRange.gridy = 6;
		panel_capability.add(ckbx_frequencyRange, gbc_ckbx_frequencyRange);
		
		tf_minFrequency = new JTextField();
		tf_minFrequency.setEditable(false);
		tf_minFrequency.setColumns(10);
		GridBagConstraints gbc_tf_minFrequency = new GridBagConstraints();
		gbc_tf_minFrequency.insets = new Insets(0, 0, 5, 5);
		gbc_tf_minFrequency.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_minFrequency.gridx = 2;
		gbc_tf_minFrequency.gridy = 6;
		panel_capability.add(tf_minFrequency, gbc_tf_minFrequency);
		
		JLabel lb_line6 = new JLabel("—");
		GridBagConstraints gbc_lb_line6 = new GridBagConstraints();
		gbc_lb_line6.insets = new Insets(0, 0, 5, 5);
		gbc_lb_line6.gridx = 3;
		gbc_lb_line6.gridy = 6;
		panel_capability.add(lb_line6, gbc_lb_line6);
		
		tf_maxFrequency = new JTextField();
		tf_maxFrequency.setEditable(false);
		tf_maxFrequency.setColumns(10);
		GridBagConstraints gbc_tf_maxFrequency = new GridBagConstraints();
		gbc_tf_maxFrequency.insets = new Insets(0, 0, 5, 5);
		gbc_tf_maxFrequency.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_maxFrequency.gridx = 4;
		gbc_tf_maxFrequency.gridy = 6;
		panel_capability.add(tf_maxFrequency, gbc_tf_maxFrequency);
		
		JLabel lb_obsData = new JLabel("观测能力数据");
		lb_obsData.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_obsData = new GridBagConstraints();
		gbc_lb_obsData.fill = GridBagConstraints.HORIZONTAL;
		gbc_lb_obsData.gridwidth = 2;
		gbc_lb_obsData.insets = new Insets(0, 0, 5, 5);
		gbc_lb_obsData.gridx = 5;
		gbc_lb_obsData.gridy = 6;
		panel_capability.add(lb_obsData, gbc_lb_obsData);
		
		JCheckBox ckbx_observedBBox = new JCheckBox("观测范围(纬度-经度):");
		ckbx_observedBBox.setSelected(true);
		GridBagConstraints gbc_ckbx_observedBBox = new GridBagConstraints();
		gbc_ckbx_observedBBox.anchor = GridBagConstraints.WEST;
		gbc_ckbx_observedBBox.gridwidth = 4;
		gbc_ckbx_observedBBox.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_observedBBox.gridx = 0;
		gbc_ckbx_observedBBox.gridy = 7;
		panel_capability.add(ckbx_observedBBox, gbc_ckbx_observedBBox);
		
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
		gbc_ckbx_dataAccessLevel.gridy = 7;
		panel_capability.add(ckbx_dataAccessLevel, gbc_ckbx_dataAccessLevel);
		
		cbbx_dataAccessLevel = new JComboBox();
		cbbx_dataAccessLevel.setModel(new DefaultComboBoxModel(new String[] {"公开", "限制"}));
		cbbx_dataAccessLevel.setEnabled(false);
		GridBagConstraints gbc_cbbx_dataAccessLevel = new GridBagConstraints();
		gbc_cbbx_dataAccessLevel.gridwidth = 4;
		gbc_cbbx_dataAccessLevel.insets = new Insets(0, 0, 5, 0);
		gbc_cbbx_dataAccessLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbx_dataAccessLevel.gridx = 7;
		gbc_cbbx_dataAccessLevel.gridy = 7;
		panel_capability.add(cbbx_dataAccessLevel, gbc_cbbx_dataAccessLevel);
		
		JLabel lb_lowerCorner = new JLabel("  左下角点:");
		GridBagConstraints gbc_lb_lowerCorner = new GridBagConstraints();
		gbc_lb_lowerCorner.insets = new Insets(0, 0, 5, 5);
		gbc_lb_lowerCorner.gridx = 0;
		gbc_lb_lowerCorner.gridy = 8;
		panel_capability.add(lb_lowerCorner, gbc_lb_lowerCorner);
		
		tf_lowerY = new JTextField();
		tf_lowerY.setColumns(10);
		GridBagConstraints gbc_tf_lowerY = new GridBagConstraints();
		gbc_tf_lowerY.gridwidth = 2;
		gbc_tf_lowerY.insets = new Insets(0, 0, 5, 5);
		gbc_tf_lowerY.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_lowerY.gridx = 1;
		gbc_tf_lowerY.gridy = 8;
		panel_capability.add(tf_lowerY, gbc_tf_lowerY);
		
		JLabel label = new JLabel("—");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 8;
		panel_capability.add(label, gbc_label);
		
		tf_lowerX = new JTextField();
		tf_lowerX.setColumns(10);
		GridBagConstraints gbc_tf_lowerX = new GridBagConstraints();
		gbc_tf_lowerX.insets = new Insets(0, 0, 5, 5);
		gbc_tf_lowerX.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_lowerX.gridx = 4;
		gbc_tf_lowerX.gridy = 8;
		panel_capability.add(tf_lowerX, gbc_tf_lowerX);
		
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
		gbc_ckbx_dataAccessQuality.gridy = 8;
		panel_capability.add(ckbx_dataAccessQuality, gbc_ckbx_dataAccessQuality);
		
		tf_dataAccessQuality = new JTextField();
		tf_dataAccessQuality.setEditable(false);
		tf_dataAccessQuality.setColumns(10);
		GridBagConstraints gbc_tf_dataAccessQuality = new GridBagConstraints();
		gbc_tf_dataAccessQuality.gridwidth = 4;
		gbc_tf_dataAccessQuality.insets = new Insets(0, 0, 5, 0);
		gbc_tf_dataAccessQuality.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_dataAccessQuality.gridx = 7;
		gbc_tf_dataAccessQuality.gridy = 8;
		panel_capability.add(tf_dataAccessQuality, gbc_tf_dataAccessQuality);
		
		JLabel lb_upperCorner = new JLabel("  右上角点:");
		GridBagConstraints gbc_lb_upperCorner = new GridBagConstraints();
		gbc_lb_upperCorner.insets = new Insets(0, 0, 5, 5);
		gbc_lb_upperCorner.gridx = 0;
		gbc_lb_upperCorner.gridy = 9;
		panel_capability.add(lb_upperCorner, gbc_lb_upperCorner);
		
		tf_upperY = new JTextField();
		tf_upperY.setColumns(10);
		GridBagConstraints gbc_tf_upperY = new GridBagConstraints();
		gbc_tf_upperY.gridwidth = 2;
		gbc_tf_upperY.insets = new Insets(0, 0, 5, 5);
		gbc_tf_upperY.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_upperY.gridx = 1;
		gbc_tf_upperY.gridy = 9;
		panel_capability.add(tf_upperY, gbc_tf_upperY);
		
		JLabel label_1 = new JLabel("—");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 9;
		panel_capability.add(label_1, gbc_label_1);
		
		tf_upperX = new JTextField();
		tf_upperX.setColumns(10);
		GridBagConstraints gbc_tf_upperX = new GridBagConstraints();
		gbc_tf_upperX.insets = new Insets(0, 0, 5, 5);
		gbc_tf_upperX.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_upperX.gridx = 4;
		gbc_tf_upperX.gridy = 9;
		panel_capability.add(tf_upperX, gbc_tf_upperX);
		
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
		gbc_ckbx_dataFormat.gridy = 9;
		panel_capability.add(ckbx_dataFormat, gbc_ckbx_dataFormat);
		
		tf_dataFormat = new JTextField();
		tf_dataFormat.setEditable(false);
		tf_dataFormat.setColumns(10);
		GridBagConstraints gbc_tf_dataFormat = new GridBagConstraints();
		gbc_tf_dataFormat.gridwidth = 4;
		gbc_tf_dataFormat.insets = new Insets(0, 0, 5, 0);
		gbc_tf_dataFormat.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_dataFormat.gridx = 7;
		gbc_tf_dataFormat.gridy = 9;
		panel_capability.add(tf_dataFormat, gbc_tf_dataFormat);
		
		JLabel lb_obsDepth = new JLabel("观测能力深度");
		lb_obsDepth.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_obsDepth = new GridBagConstraints();
		gbc_lb_obsDepth.gridwidth = 2;
		gbc_lb_obsDepth.insets = new Insets(0, 0, 5, 5);
		gbc_lb_obsDepth.gridx = 0;
		gbc_lb_obsDepth.gridy = 10;
		panel_capability.add(lb_obsDepth, gbc_lb_obsDepth);
		
		ckbx_observeResolution = new JCheckBox("观测分辨率(%):");
		ckbx_observeResolution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_observeResolution.isSelected()) {
					tf_observeResolution.setEditable(true);
					tf_observeResolution.setBackground(Color.white);
				}else {
					tf_observeResolution.setEditable(false);
					tf_observeResolution.setBackground(Grey);
					tf_observeResolution.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_observeResolution = new GridBagConstraints();
		gbc_ckbx_observeResolution.anchor = GridBagConstraints.WEST;
		gbc_ckbx_observeResolution.gridwidth = 2;
		gbc_ckbx_observeResolution.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_observeResolution.gridx = 0;
		gbc_ckbx_observeResolution.gridy = 11;
		panel_capability.add(ckbx_observeResolution, gbc_ckbx_observeResolution);
		
		tf_observeResolution = new JTextField();
		tf_observeResolution.setEditable(false);
		tf_observeResolution.setColumns(10);
		GridBagConstraints gbc_tf_observeResolution = new GridBagConstraints();
		gbc_tf_observeResolution.gridwidth = 3;
		gbc_tf_observeResolution.insets = new Insets(0, 0, 5, 5);
		gbc_tf_observeResolution.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_observeResolution.gridx = 2;
		gbc_tf_observeResolution.gridy = 11;
		panel_capability.add(tf_observeResolution, gbc_tf_observeResolution);
		
		ckbx_otherCapability = new JCheckBox("添加其他观测能力:");
		GridBagConstraints gbc_ckbx_otherCapability = new GridBagConstraints();
		gbc_ckbx_otherCapability.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_otherCapability.gridwidth = 6;
		gbc_ckbx_otherCapability.insets = new Insets(0, 0, 5, 0);
		gbc_ckbx_otherCapability.gridx = 5;
		gbc_ckbx_otherCapability.gridy = 11;
		panel_capability.add(ckbx_otherCapability, gbc_ckbx_otherCapability);
		
		ckbx_radius = new JCheckBox("观测半径(m):");
		ckbx_radius.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_radius.isSelected()) {
					tf_radius.setEditable(true);
					tf_radius.setBackground(Color.white);
				}else {
					tf_radius.setEditable(false);
					tf_radius.setBackground(Grey);
					tf_radius.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_radius = new GridBagConstraints();
		gbc_ckbx_radius.anchor = GridBagConstraints.WEST;
		gbc_ckbx_radius.gridwidth = 2;
		gbc_ckbx_radius.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_radius.gridx = 0;
		gbc_ckbx_radius.gridy = 12;
		panel_capability.add(ckbx_radius, gbc_ckbx_radius);
		
		tf_radius = new JTextField();
		tf_radius.setEditable(false);
		tf_radius.setColumns(10);
		GridBagConstraints gbc_tf_radius = new GridBagConstraints();
		gbc_tf_radius.gridwidth = 3;
		gbc_tf_radius.insets = new Insets(0, 0, 5, 5);
		gbc_tf_radius.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_radius.gridx = 2;
		gbc_tf_radius.gridy = 12;
		panel_capability.add(tf_radius, gbc_tf_radius);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.gridheight = 3;
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridwidth = 6;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_3.gridx = 5;
		gbc_scrollPane_3.gridy = 12;
		panel_capability.add(scrollPane_3, gbc_scrollPane_3);
		
		tb_otherCapability = new JTable();
		tb_otherCapability.setBackground(new Color(175, 238, 238));
		model_otherCapability = new DefaultTableModel(new Object[][] {},new String[] {"字段名称", "字段内容"});
		tb_otherCapability.setModel(model_otherCapability);
		scrollPane_3.setViewportView(tb_otherCapability);
		tb_otherCapability.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ckbx_sensitivity = new JCheckBox("灵敏度(%):");
		ckbx_sensitivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_sensitivity.isSelected()) {
					tf_sensitivity.setEditable(true);
					tf_sensitivity.setBackground(Color.white);
				}else {
					tf_sensitivity.setEditable(false);
					tf_sensitivity.setBackground(Grey);
					tf_sensitivity.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_sensitivity = new GridBagConstraints();
		gbc_ckbx_sensitivity.anchor = GridBagConstraints.WEST;
		gbc_ckbx_sensitivity.gridwidth = 2;
		gbc_ckbx_sensitivity.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_sensitivity.gridx = 0;
		gbc_ckbx_sensitivity.gridy = 13;
		panel_capability.add(ckbx_sensitivity, gbc_ckbx_sensitivity);
		
		tf_sensitivity = new JTextField();
		tf_sensitivity.setEditable(false);
		tf_sensitivity.setColumns(10);
		GridBagConstraints gbc_tf_sensitivity = new GridBagConstraints();
		gbc_tf_sensitivity.gridwidth = 3;
		gbc_tf_sensitivity.insets = new Insets(0, 0, 5, 5);
		gbc_tf_sensitivity.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_sensitivity.gridx = 2;
		gbc_tf_sensitivity.gridy = 13;
		panel_capability.add(tf_sensitivity, gbc_tf_sensitivity);
		
		JLabel lb_obsFrequency = new JLabel("观测能力频度");
		lb_obsFrequency.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_obsFrequency = new GridBagConstraints();
		gbc_lb_obsFrequency.gridwidth = 2;
		gbc_lb_obsFrequency.insets = new Insets(0, 0, 5, 5);
		gbc_lb_obsFrequency.gridx = 0;
		gbc_lb_obsFrequency.gridy = 14;
		panel_capability.add(lb_obsFrequency, gbc_lb_obsFrequency);
		
		ckbx_interval = new JCheckBox("采样周期(s):");
		ckbx_interval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_interval.isSelected()) {
					tf_interval.setEditable(true);
					tf_interval.setBackground(Color.white);
				}else {
					tf_interval.setEditable(false);
					tf_interval.setBackground(Grey);
					tf_interval.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_interval = new GridBagConstraints();
		gbc_ckbx_interval.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_interval.gridx = 0;
		gbc_ckbx_interval.gridy = 15;
		panel_capability.add(ckbx_interval, gbc_ckbx_interval);
		
		tf_interval = new JTextField();
		tf_interval.setEditable(false);
		tf_interval.setColumns(10);
		GridBagConstraints gbc_tf_interval = new GridBagConstraints();
		gbc_tf_interval.gridwidth = 3;
		gbc_tf_interval.insets = new Insets(0, 0, 5, 5);
		gbc_tf_interval.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_interval.gridx = 2;
		gbc_tf_interval.gridy = 15;
		panel_capability.add(tf_interval, gbc_tf_interval);
		
		tf_otherCapaName = new JTextField();
		tf_otherCapaName.setEditable(false);
		tf_otherCapaName.setColumns(10);
		GridBagConstraints gbc_tf_otherCapaName = new GridBagConstraints();
		gbc_tf_otherCapaName.insets = new Insets(0, 0, 5, 5);
		gbc_tf_otherCapaName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherCapaName.gridx = 5;
		gbc_tf_otherCapaName.gridy = 15;
		panel_capability.add(tf_otherCapaName, gbc_tf_otherCapaName);
		
		tf_otherCapaContent = new JTextField();
		tf_otherCapaContent.setEditable(false);
		tf_otherCapaContent.setColumns(10);
		GridBagConstraints gbc_tf_otherCapaContent = new GridBagConstraints();
		gbc_tf_otherCapaContent.gridwidth = 3;
		gbc_tf_otherCapaContent.insets = new Insets(0, 0, 5, 5);
		gbc_tf_otherCapaContent.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherCapaContent.gridx = 6;
		gbc_tf_otherCapaContent.gridy = 15;
		panel_capability.add(tf_otherCapaContent, gbc_tf_otherCapaContent);
		
		JButton bt_addOtherCapa = new JButton("增加");
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
		gbc_bt_addOtherCapa.gridx = 9;
		gbc_bt_addOtherCapa.gridy = 15;
		panel_capability.add(bt_addOtherCapa, gbc_bt_addOtherCapa);
		
		JButton bt_deleteOtherCapa = new JButton("删除");
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
		gbc_bt_deleteOtherCapa.insets = new Insets(0, 0, 5, 0);
		gbc_bt_deleteOtherCapa.gridx = 10;
		gbc_bt_deleteOtherCapa.gridy = 15;
		panel_capability.add(bt_deleteOtherCapa, gbc_bt_deleteOtherCapa);
		
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
		
		ckbx_duration = new JCheckBox("采样持续时间(s):");
		ckbx_duration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_duration.isSelected()) {
					tf_duration.setEditable(true);
					tf_duration.setBackground(Color.white);
				}else {
					tf_duration.setEditable(false);
					tf_duration.setBackground(Grey);
					tf_duration.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_duration = new GridBagConstraints();
		gbc_ckbx_duration.gridwidth = 2;
		gbc_ckbx_duration.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_duration.gridx = 0;
		gbc_ckbx_duration.gridy = 16;
		panel_capability.add(ckbx_duration, gbc_ckbx_duration);
		
		tf_duration = new JTextField();
		tf_duration.setEditable(false);
		tf_duration.setColumns(10);
		GridBagConstraints gbc_tf_duration = new GridBagConstraints();
		gbc_tf_duration.gridwidth = 3;
		gbc_tf_duration.insets = new Insets(0, 0, 5, 5);
		gbc_tf_duration.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_duration.gridx = 2;
		gbc_tf_duration.gridy = 16;
		panel_capability.add(tf_duration, gbc_tf_duration);
		
		ckbx_respondTM = new JCheckBox("响应时间(s):");
		ckbx_respondTM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_respondTM.isSelected()) {
					tf_respondTM.setEditable(true);
					tf_respondTM.setBackground(Color.white);
				}else {
					tf_respondTM.setEditable(false);
					tf_respondTM.setBackground(Grey);
					tf_respondTM.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_respondTM = new GridBagConstraints();
		gbc_ckbx_respondTM.insets = new Insets(0, 0, 0, 5);
		gbc_ckbx_respondTM.gridx = 0;
		gbc_ckbx_respondTM.gridy = 17;
		panel_capability.add(ckbx_respondTM, gbc_ckbx_respondTM);
		
		tf_respondTM = new JTextField();
		tf_respondTM.setEditable(false);
		tf_respondTM.setColumns(10);
		GridBagConstraints gbc_tf_respondTM = new GridBagConstraints();
		gbc_tf_respondTM.gridwidth = 3;
		gbc_tf_respondTM.insets = new Insets(0, 0, 0, 5);
		gbc_tf_respondTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_respondTM.gridx = 2;
		gbc_tf_respondTM.gridy = 17;
		panel_capability.add(tf_respondTM, gbc_tf_respondTM);
		
		JPanel panel_position = new JPanel();
		tp_capability.addTab("     传感器位置     ", null, panel_position, null);
		GridBagLayout gbl_panel_position = new GridBagLayout();
		gbl_panel_position.columnWidths = new int[]{58, 0, 0, 0, 52, 0, 0, 0};
		gbl_panel_position.rowHeights = new int[]{0, 0, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_position.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_position.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_position.setLayout(gbl_panel_position);
		
		JLabel lb_positionDescription = new JLabel("为了支持提供物理组件或系统的静态和动态位置，可以利用以下任一方法来说明站点\"在哪里\"。");
		lb_positionDescription.setFont(new Font("宋体", Font.ITALIC, 12));
		GridBagConstraints gbc_lb_positionDescription = new GridBagConstraints();
		gbc_lb_positionDescription.gridwidth = 7;
		gbc_lb_positionDescription.anchor = GridBagConstraints.NORTH;
		gbc_lb_positionDescription.insets = new Insets(40, 0, 25, 5);
		gbc_lb_positionDescription.gridx = 0;
		gbc_lb_positionDescription.gridy = 0;
		panel_position.add(lb_positionDescription, gbc_lb_positionDescription);
		
		rbt_textPosition = new JRadioButton("文字描述");
		rbt_textPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbt_textPosition.isSelected()) {
					ta_textPosition.setEditable(true);
					ta_textPosition.setBackground(Color.white);
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
		btGroup_position.add(rbt_textPosition);
		rbt_textPosition.setForeground(SystemColor.textHighlight);
		rbt_textPosition.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_rbt_textPosition = new GridBagConstraints();
		gbc_rbt_textPosition.anchor = GridBagConstraints.WEST;
		gbc_rbt_textPosition.gridwidth = 3;
		gbc_rbt_textPosition.insets = new Insets(0, 0, 5, 5);
		gbc_rbt_textPosition.gridx = 1;
		gbc_rbt_textPosition.gridy = 1;
		panel_position.add(rbt_textPosition, gbc_rbt_textPosition);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
		gbc_scrollPane_4.gridheight = 2;
		gbc_scrollPane_4.gridwidth = 7;
		gbc_scrollPane_4.insets = new Insets(0, 20, 5, 30);
		gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_4.gridx = 1;
		gbc_scrollPane_4.gridy = 2;
		panel_position.add(scrollPane_4, gbc_scrollPane_4);
		
		ta_textPosition = new JTextArea();
		ta_textPosition.setBackground(SystemColor.control);
		scrollPane_4.setViewportView(ta_textPosition);
		
		rbt_pointPosition = new JRadioButton("平面坐标 (纬度，经度)");
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
		btGroup_position.add(rbt_pointPosition);
		rbt_pointPosition.setForeground(SystemColor.textHighlight);
		rbt_pointPosition.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_rbt_pointPosition = new GridBagConstraints();
		gbc_rbt_pointPosition.anchor = GridBagConstraints.WEST;
		gbc_rbt_pointPosition.gridwidth = 6;
		gbc_rbt_pointPosition.insets = new Insets(10, 0, 5, 5);
		gbc_rbt_pointPosition.gridx = 1;
		gbc_rbt_pointPosition.gridy = 4;
		panel_position.add(rbt_pointPosition, gbc_rbt_pointPosition);
		
		JLabel lb_pointSRS = new JLabel("  参考坐标系统:");
		GridBagConstraints gbc_lb_pointSRS = new GridBagConstraints();
		gbc_lb_pointSRS.gridwidth = 3;
		gbc_lb_pointSRS.insets = new Insets(0, 0, 5, 5);
		gbc_lb_pointSRS.gridx = 1;
		gbc_lb_pointSRS.gridy = 5;
		panel_position.add(lb_pointSRS, gbc_lb_pointSRS);
		
		tf_pointSRS = new JTextField();
		hintText hintPointSRS = new hintText(tf_pointSRS, "urn:ogc:def:crs:OGC:1.3:EPSG:4329");
		tf_pointSRS.addFocusListener(new JTextFieldHintListener("urn:ogc:def:crs:OGC:1.3:EPSG:4329",tf_pointSRS ));
		tf_pointSRS.setEditable(false);
		tf_pointSRS.setColumns(10);
		GridBagConstraints gbc_tf_pointSRS = new GridBagConstraints();
		gbc_tf_pointSRS.gridwidth = 3;
		gbc_tf_pointSRS.insets = new Insets(0, 0, 5, 40);
		gbc_tf_pointSRS.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_pointSRS.gridx = 4;
		gbc_tf_pointSRS.gridy = 5;
		panel_position.add(tf_pointSRS, gbc_tf_pointSRS);
		
		JLabel lb_point = new JLabel("  点坐标(deg):");
		GridBagConstraints gbc_lb_point = new GridBagConstraints();
		gbc_lb_point.gridwidth = 3;
		gbc_lb_point.insets = new Insets(0, 0, 5, 5);
		gbc_lb_point.gridx = 1;
		gbc_lb_point.gridy = 6;
		panel_position.add(lb_point, gbc_lb_point);
		
		tf_pointY = new JTextField();
		tf_pointY.setEditable(false);
		tf_pointY.setColumns(10);
		GridBagConstraints gbc_tf_pointY = new GridBagConstraints();
		gbc_tf_pointY.insets = new Insets(0, 0, 5, 5);
		gbc_tf_pointY.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_pointY.gridx = 4;
		gbc_tf_pointY.gridy = 6;
		panel_position.add(tf_pointY, gbc_tf_pointY);
		
		JLabel label_3 = new JLabel("，");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.gridx = 5;
		gbc_label_3.gridy = 6;
		panel_position.add(label_3, gbc_label_3);
		
		tf_pointX = new JTextField();
		tf_pointX.setEditable(false);
		tf_pointX.setColumns(10);
		GridBagConstraints gbc_tf_pointX = new GridBagConstraints();
		gbc_tf_pointX.insets = new Insets(0, 0, 5, 40);
		gbc_tf_pointX.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_pointX.gridx = 6;
		gbc_tf_pointX.gridy = 6;
		panel_position.add(tf_pointX, gbc_tf_pointX);
		
		rbt_location = new JRadioButton("空间位置");
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
		btGroup_position.add(rbt_location);
		rbt_location.setForeground(SystemColor.textHighlight);
		rbt_location.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_rbt_location = new GridBagConstraints();
		gbc_rbt_location.anchor = GridBagConstraints.WEST;
		gbc_rbt_location.gridwidth = 3;
		gbc_rbt_location.insets = new Insets(10, 0, 5, 5);
		gbc_rbt_location.gridx = 1;
		gbc_rbt_location.gridy = 7;
		panel_position.add(rbt_location, gbc_rbt_location);
		
		JLabel lb_locationSRS = new JLabel("  参考坐标系统:");
		GridBagConstraints gbc_lb_locationSRS = new GridBagConstraints();
		gbc_lb_locationSRS.gridwidth = 3;
		gbc_lb_locationSRS.insets = new Insets(0, 0, 5, 5);
		gbc_lb_locationSRS.gridx = 1;
		gbc_lb_locationSRS.gridy = 8;
		panel_position.add(lb_locationSRS, gbc_lb_locationSRS);
		
		tf_locationSRS = new JTextField();
		hintText hintLocationSRS = new hintText(tf_locationSRS, "urn:ogc:def:crs:OGC:1.3:EPSG:4329");
		tf_locationSRS.addFocusListener(new JTextFieldHintListener("urn:ogc:def:crs:OGC:1.3:EPSG:4329", tf_locationSRS));
		tf_locationSRS.setEditable(false);
		tf_locationSRS.setColumns(10);
		GridBagConstraints gbc_tf_locationSRS = new GridBagConstraints();
		gbc_tf_locationSRS.gridwidth = 3;
		gbc_tf_locationSRS.insets = new Insets(0, 0, 5, 40);
		gbc_tf_locationSRS.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_locationSRS.gridx = 4;
		gbc_tf_locationSRS.gridy = 8;
		panel_position.add(tf_locationSRS, gbc_tf_locationSRS);
		
		JLabel lb_latitude = new JLabel("  纬度(deg):");
		GridBagConstraints gbc_lb_latitude = new GridBagConstraints();
		gbc_lb_latitude.gridwidth = 3;
		gbc_lb_latitude.insets = new Insets(0, 0, 5, 5);
		gbc_lb_latitude.gridx = 1;
		gbc_lb_latitude.gridy = 9;
		panel_position.add(lb_latitude, gbc_lb_latitude);
		
		tf_latitude = new JTextField();
		tf_latitude.setEditable(false);
		tf_latitude.setColumns(10);
		GridBagConstraints gbc_tf_latitude = new GridBagConstraints();
		gbc_tf_latitude.insets = new Insets(0, 0, 5, 5);
		gbc_tf_latitude.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_latitude.gridx = 4;
		gbc_tf_latitude.gridy = 9;
		panel_position.add(tf_latitude, gbc_tf_latitude);
		
		JLabel lb_longitude = new JLabel("  经度(deg):");
		GridBagConstraints gbc_lb_longitude = new GridBagConstraints();
		gbc_lb_longitude.gridwidth = 3;
		gbc_lb_longitude.insets = new Insets(0, 0, 5, 5);
		gbc_lb_longitude.gridx = 1;
		gbc_lb_longitude.gridy = 10;
		panel_position.add(lb_longitude, gbc_lb_longitude);
		
		tf_longitude = new JTextField();
		tf_longitude.setEditable(false);
		tf_longitude.setColumns(10);
		GridBagConstraints gbc_tf_longitude = new GridBagConstraints();
		gbc_tf_longitude.insets = new Insets(0, 0, 5, 5);
		gbc_tf_longitude.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_longitude.gridx = 4;
		gbc_tf_longitude.gridy = 10;
		panel_position.add(tf_longitude, gbc_tf_longitude);
		
		JLabel lb_altitude = new JLabel("  海拔(m):");
		GridBagConstraints gbc_lb_altitude = new GridBagConstraints();
		gbc_lb_altitude.gridwidth = 3;
		gbc_lb_altitude.insets = new Insets(0, 0, 5, 5);
		gbc_lb_altitude.gridx = 1;
		gbc_lb_altitude.gridy = 11;
		panel_position.add(lb_altitude, gbc_lb_altitude);
		
		tf_altitude = new JTextField();
		tf_altitude.setEditable(false);
		tf_altitude.setColumns(10);
		GridBagConstraints gbc_tf_altitude = new GridBagConstraints();
		gbc_tf_altitude.insets = new Insets(0, 0, 5, 5);
		gbc_tf_altitude.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_altitude.gridx = 4;
		gbc_tf_altitude.gridy = 11;
		panel_position.add(tf_altitude, gbc_tf_altitude);
		
		JPanel panel_contact = new JPanel();
		tp_content.addTab("联系服务信息", null, panel_contact, null);
		GridBagLayout gbl_panel_contact = new GridBagLayout();
		gbl_panel_contact.columnWidths = new int[]{0, 37, 0, 0, 0, 26, 120, 49, 0, 0, 0};
		gbl_panel_contact.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 37, 0, 0};
		gbl_panel_contact.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_contact.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_contact.setLayout(gbl_panel_contact);
		
		JLabel lb_responsibleParty = new JLabel("负责单位");
		lb_responsibleParty.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_responsibleParty = new GridBagConstraints();
		gbc_lb_responsibleParty.insets = new Insets(5, 5, 5, 5);
		gbc_lb_responsibleParty.gridx = 0;
		gbc_lb_responsibleParty.gridy = 0;
		panel_contact.add(lb_responsibleParty, gbc_lb_responsibleParty);
		
		JLabel lb_history = new JLabel("服务历史");
		lb_history.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_history = new GridBagConstraints();
		gbc_lb_history.gridwidth = 2;
		gbc_lb_history.insets = new Insets(0, 10, 5, 5);
		gbc_lb_history.gridx = 5;
		gbc_lb_history.gridy = 0;
		panel_contact.add(lb_history, gbc_lb_history);
		
		JCheckBox ckbx_role = new JCheckBox("负责角色:");
		ckbx_role.setSelected(true);
		GridBagConstraints gbc_ckbx_role = new GridBagConstraints();
		gbc_ckbx_role.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_role.gridx = 0;
		gbc_ckbx_role.gridy = 1;
		panel_contact.add(ckbx_role, gbc_ckbx_role);
		
		cbbx_role = new JComboBox();
		cbbx_role.setModel(new DefaultComboBoxModel(new String[] {"制造商", "管理者", "使用者"}));
		GridBagConstraints gbc_cbbx_role = new GridBagConstraints();
		gbc_cbbx_role.gridwidth = 4;
		gbc_cbbx_role.insets = new Insets(0, 0, 5, 5);
		gbc_cbbx_role.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbx_role.gridx = 1;
		gbc_cbbx_role.gridy = 1;
		panel_contact.add(cbbx_role, gbc_cbbx_role);
		
		ckbx_eventID = new JCheckBox("事件编号:");
		GridBagConstraints gbc_ckbx_eventID = new GridBagConstraints();
		gbc_ckbx_eventID.gridwidth = 2;
		gbc_ckbx_eventID.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_eventID.gridx = 5;
		gbc_ckbx_eventID.gridy = 1;
		panel_contact.add(ckbx_eventID, gbc_ckbx_eventID);
		
		tf_eventID = new JTextField();
		tf_eventID.setEditable(false);
		tf_eventID.setColumns(10);
		GridBagConstraints gbc_tf_eventID = new GridBagConstraints();
		gbc_tf_eventID.insets = new Insets(0, 0, 5, 5);
		gbc_tf_eventID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_eventID.gridx = 7;
		gbc_tf_eventID.gridy = 1;
		panel_contact.add(tf_eventID, gbc_tf_eventID);
		
		JLabel lb_eventLabel = new JLabel("事件标签:");
		GridBagConstraints gbc_lb_eventLabel = new GridBagConstraints();
		gbc_lb_eventLabel.anchor = GridBagConstraints.EAST;
		gbc_lb_eventLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lb_eventLabel.gridx = 8;
		gbc_lb_eventLabel.gridy = 1;
		panel_contact.add(lb_eventLabel, gbc_lb_eventLabel);
		
		tf_eventLabel = new JTextField();
		tf_eventLabel.setEditable(false);
		tf_eventLabel.setColumns(10);
		GridBagConstraints gbc_tf_eventLabel = new GridBagConstraints();
		gbc_tf_eventLabel.insets = new Insets(0, 0, 5, 0);
		gbc_tf_eventLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_eventLabel.gridx = 9;
		gbc_tf_eventLabel.gridy = 1;
		panel_contact.add(tf_eventLabel, gbc_tf_eventLabel);
		
		JCheckBox ckbx_organizationName = new JCheckBox("组织名称:");
		ckbx_organizationName.setSelected(true);
		GridBagConstraints gbc_ckbx_organizationName = new GridBagConstraints();
		gbc_ckbx_organizationName.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_organizationName.gridx = 0;
		gbc_ckbx_organizationName.gridy = 2;
		panel_contact.add(ckbx_organizationName, gbc_ckbx_organizationName);
		
		tf_organizationName = new JTextField();
		tf_organizationName.setColumns(10);
		GridBagConstraints gbc_tf_organizationName = new GridBagConstraints();
		gbc_tf_organizationName.gridwidth = 4;
		gbc_tf_organizationName.insets = new Insets(0, 0, 5, 5);
		gbc_tf_organizationName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_organizationName.gridx = 1;
		gbc_tf_organizationName.gridy = 2;
		panel_contact.add(tf_organizationName, gbc_tf_organizationName);
		
		ckbx_individualName = new JCheckBox("个人名称:");
		ckbx_individualName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_individualName.isSelected()) {
					tf_individualName.setEditable(true);
					tf_individualName.setBackground(Color.white);
				}else {
					tf_individualName.setEditable(false);
					tf_individualName.setBackground(Grey);
					tf_individualName.setText("");
				}
			}
		});
		
		ckbx_eventDescription = new JCheckBox("事件描述:");
		GridBagConstraints gbc_ckbx_eventDescription = new GridBagConstraints();
		gbc_ckbx_eventDescription.gridwidth = 2;
		gbc_ckbx_eventDescription.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_eventDescription.gridx = 5;
		gbc_ckbx_eventDescription.gridy = 2;
		panel_contact.add(ckbx_eventDescription, gbc_ckbx_eventDescription);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_5 = new GridBagConstraints();
		gbc_scrollPane_5.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_5.gridheight = 2;
		gbc_scrollPane_5.gridwidth = 3;
		gbc_scrollPane_5.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_5.gridx = 7;
		gbc_scrollPane_5.gridy = 2;
		panel_contact.add(scrollPane_5, gbc_scrollPane_5);
		
		ta_eventDescription = new JTextArea();
		ta_eventDescription.setBackground(UIManager.getColor("Button.background"));
		scrollPane_5.setViewportView(ta_eventDescription);
		GridBagConstraints gbc_ckbx_individualName = new GridBagConstraints();
		gbc_ckbx_individualName.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_individualName.gridx = 0;
		gbc_ckbx_individualName.gridy = 3;
		panel_contact.add(ckbx_individualName, gbc_ckbx_individualName);
		
		tf_individualName = new JTextField();
		tf_individualName.setEditable(false);
		tf_individualName.setColumns(10);
		GridBagConstraints gbc_tf_individualName = new GridBagConstraints();
		gbc_tf_individualName.gridwidth = 4;
		gbc_tf_individualName.insets = new Insets(0, 0, 5, 5);
		gbc_tf_individualName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_individualName.gridx = 1;
		gbc_tf_individualName.gridy = 3;
		panel_contact.add(tf_individualName, gbc_tf_individualName);
		
		JLabel lb_contactInfo = new JLabel("   联系信息:");
		GridBagConstraints gbc_lb_contactInfo = new GridBagConstraints();
		gbc_lb_contactInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lb_contactInfo.gridx = 0;
		gbc_lb_contactInfo.gridy = 4;
		panel_contact.add(lb_contactInfo, gbc_lb_contactInfo);
		
		ckbx_telephone = new JCheckBox("电话:");
		ckbx_telephone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_telephone.isSelected()) {
					tf_telephone.setEditable(true);
					tf_telephone.setBackground(Color.white);
				}else {
					tf_telephone.setEditable(false);
					tf_telephone.setBackground(Grey);
					tf_telephone.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_telephone = new GridBagConstraints();
		gbc_ckbx_telephone.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_telephone.gridx = 1;
		gbc_ckbx_telephone.gridy = 4;
		panel_contact.add(ckbx_telephone, gbc_ckbx_telephone);
		
		tf_telephone = new JTextField();
		tf_telephone.setEditable(false);
		tf_telephone.setColumns(10);
		GridBagConstraints gbc_tf_telephone = new GridBagConstraints();
		gbc_tf_telephone.gridwidth = 3;
		gbc_tf_telephone.insets = new Insets(0, 0, 5, 5);
		gbc_tf_telephone.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_telephone.gridx = 2;
		gbc_tf_telephone.gridy = 4;
		panel_contact.add(tf_telephone, gbc_tf_telephone);
		
		JLabel lb_edes = new JLabel("请在以下两种方式中选择一种描述事件时间。");
		lb_edes.setForeground(new Color(47, 79, 79));
		lb_edes.setFont(new Font("宋体", Font.ITALIC, 12));
		GridBagConstraints gbc_lb_edes = new GridBagConstraints();
		gbc_lb_edes.gridwidth = 5;
		gbc_lb_edes.insets = new Insets(0, 0, 5, 0);
		gbc_lb_edes.gridx = 5;
		gbc_lb_edes.gridy = 4;
		panel_contact.add(lb_edes, gbc_lb_edes);
		
		ckbx_address = new JCheckBox("地址:");
		ckbx_address.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_address.isSelected()) {
					tf_deliveryPoint.setEditable(true);
					tf_city.setEditable(true);
					tf_administration.setEditable(true);
					tf_country.setEditable(true);
					tf_email.setEditable(true);
					tf_postCode.setEditable(true);
					tf_deliveryPoint.setBackground(Color.white);
					tf_city.setBackground(Color.white);
					tf_email.setBackground(Color.white);
					tf_administration.setBackground(Color.white);
					tf_postCode.setBackground(Color.white);
					tf_country.setBackground(Color.white);
				}else {
					tf_deliveryPoint.setEditable(false);
					tf_city.setEditable(false);
					tf_administration.setEditable(false);
					tf_country.setEditable(false);
					tf_email.setEditable(false);
					tf_postCode.setEditable(false);
					tf_deliveryPoint.setBackground(Grey);
					tf_city.setBackground(Grey);
					tf_email.setBackground(Grey);
					tf_administration.setBackground(Grey);
					tf_postCode.setBackground(Grey);
					tf_country.setBackground(Grey);
					tf_deliveryPoint.setText("");
					tf_city.setText("");
					tf_country.setText("");
					tf_administration.setText("");
					tf_postCode.setText("");
					tf_email.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_address = new GridBagConstraints();
		gbc_ckbx_address.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_address.gridx = 1;
		gbc_ckbx_address.gridy = 5;
		panel_contact.add(ckbx_address, gbc_ckbx_address);
		
		rbt_eventPeriod = new JRadioButton("事件时间范围:");
		btGroup_eventTM.add(rbt_eventPeriod);
		GridBagConstraints gbc_rbt_eventPeriod = new GridBagConstraints();
		gbc_rbt_eventPeriod.anchor = GridBagConstraints.WEST;
		gbc_rbt_eventPeriod.gridwidth = 2;
		gbc_rbt_eventPeriod.insets = new Insets(0, 0, 5, 5);
		gbc_rbt_eventPeriod.gridx = 6;
		gbc_rbt_eventPeriod.gridy = 5;
		panel_contact.add(rbt_eventPeriod, gbc_rbt_eventPeriod);
		
		JLabel lb_deliveryPoint = new JLabel("邮寄地址：");
		GridBagConstraints gbc_lb_deliveryPoint = new GridBagConstraints();
		gbc_lb_deliveryPoint.anchor = GridBagConstraints.EAST;
		gbc_lb_deliveryPoint.insets = new Insets(0, 0, 5, 5);
		gbc_lb_deliveryPoint.gridx = 1;
		gbc_lb_deliveryPoint.gridy = 6;
		panel_contact.add(lb_deliveryPoint, gbc_lb_deliveryPoint);
		
		tf_deliveryPoint = new JTextField();
		tf_deliveryPoint.setEditable(false);
		tf_deliveryPoint.setColumns(10);
		GridBagConstraints gbc_tf_deliveryPoint = new GridBagConstraints();
		gbc_tf_deliveryPoint.gridwidth = 3;
		gbc_tf_deliveryPoint.insets = new Insets(0, 0, 5, 5);
		gbc_tf_deliveryPoint.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_deliveryPoint.gridx = 2;
		gbc_tf_deliveryPoint.gridy = 6;
		panel_contact.add(tf_deliveryPoint, gbc_tf_deliveryPoint);
		
		JLabel lb_eventPeriodStart = new JLabel(" 起始时间:");
		GridBagConstraints gbc_lb_eventPeriodStart = new GridBagConstraints();
		gbc_lb_eventPeriodStart.anchor = GridBagConstraints.EAST;
		gbc_lb_eventPeriodStart.insets = new Insets(0, 0, 5, 5);
		gbc_lb_eventPeriodStart.gridx = 6;
		gbc_lb_eventPeriodStart.gridy = 6;
		panel_contact.add(lb_eventPeriodStart, gbc_lb_eventPeriodStart);
		
		tf_eventPeriodStart = new JTextField();
		hintText hintEventPeriodBegin = new hintText(tf_eventPeriodStart, "2018-06-01T10:00:00Z");
		tf_eventPeriodStart.addFocusListener(new JTextFieldHintListener("2018-06-01T10:00:00Z", tf_eventPeriodStart));
		tf_eventPeriodStart.setEditable(false);
		tf_eventPeriodStart.setColumns(10);
		GridBagConstraints gbc_tf_eventPeriodStart = new GridBagConstraints();
		gbc_tf_eventPeriodStart.gridwidth = 3;
		gbc_tf_eventPeriodStart.insets = new Insets(0, 0, 5, 0);
		gbc_tf_eventPeriodStart.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_eventPeriodStart.gridx = 7;
		gbc_tf_eventPeriodStart.gridy = 6;
		panel_contact.add(tf_eventPeriodStart, gbc_tf_eventPeriodStart);
		
		JLabel lb_city = new JLabel("城市:");
		GridBagConstraints gbc_lb_city = new GridBagConstraints();
		gbc_lb_city.anchor = GridBagConstraints.EAST;
		gbc_lb_city.insets = new Insets(0, 0, 5, 5);
		gbc_lb_city.gridx = 1;
		gbc_lb_city.gridy = 7;
		panel_contact.add(lb_city, gbc_lb_city);
		
		tf_city = new JTextField();
		tf_city.setEditable(false);
		tf_city.setColumns(10);
		GridBagConstraints gbc_tf_city = new GridBagConstraints();
		gbc_tf_city.gridwidth = 3;
		gbc_tf_city.insets = new Insets(0, 0, 5, 5);
		gbc_tf_city.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_city.gridx = 2;
		gbc_tf_city.gridy = 7;
		panel_contact.add(tf_city, gbc_tf_city);
		
		JLabel lb_eventPeriodEnd = new JLabel(" 结束时间:");
		GridBagConstraints gbc_lb_eventPeriodEnd = new GridBagConstraints();
		gbc_lb_eventPeriodEnd.anchor = GridBagConstraints.EAST;
		gbc_lb_eventPeriodEnd.insets = new Insets(0, 0, 5, 5);
		gbc_lb_eventPeriodEnd.gridx = 6;
		gbc_lb_eventPeriodEnd.gridy = 7;
		panel_contact.add(lb_eventPeriodEnd, gbc_lb_eventPeriodEnd);
		
		tf_eventPeriodEnd = new JTextField();
		hintText hintEventPeriodEnd = new hintText(tf_eventPeriodEnd, "2019-06-01T10:00:00Z");
		tf_eventPeriodEnd.addFocusListener(new JTextFieldHintListener("2019-06-01T10:00:00Z", tf_eventPeriodEnd));
		tf_eventPeriodEnd.setEditable(false);
		tf_eventPeriodEnd.setColumns(10);
		GridBagConstraints gbc_tf_eventPeriodEnd = new GridBagConstraints();
		gbc_tf_eventPeriodEnd.gridwidth = 3;
		gbc_tf_eventPeriodEnd.insets = new Insets(0, 0, 5, 0);
		gbc_tf_eventPeriodEnd.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_eventPeriodEnd.gridx = 7;
		gbc_tf_eventPeriodEnd.gridy = 7;
		panel_contact.add(tf_eventPeriodEnd, gbc_tf_eventPeriodEnd);
		
		JLabel lb_administration = new JLabel("行政区域:");
		GridBagConstraints gbc_lb_administration = new GridBagConstraints();
		gbc_lb_administration.insets = new Insets(0, 0, 5, 5);
		gbc_lb_administration.anchor = GridBagConstraints.EAST;
		gbc_lb_administration.gridx = 1;
		gbc_lb_administration.gridy = 8;
		panel_contact.add(lb_administration, gbc_lb_administration);
		
		tf_administration = new JTextField();
		tf_administration.setEditable(false);
		tf_administration.setColumns(10);
		GridBagConstraints gbc_tf_administration = new GridBagConstraints();
		gbc_tf_administration.gridwidth = 3;
		gbc_tf_administration.insets = new Insets(0, 0, 5, 5);
		gbc_tf_administration.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_administration.gridx = 2;
		gbc_tf_administration.gridy = 8;
		panel_contact.add(tf_administration, gbc_tf_administration);
		
		rbt_eventInstant = new JRadioButton("事件时刻:");
		btGroup_eventTM.add(rbt_eventInstant);
		GridBagConstraints gbc_rbt_eventInstant = new GridBagConstraints();
		gbc_rbt_eventInstant.anchor = GridBagConstraints.WEST;
		gbc_rbt_eventInstant.insets = new Insets(0, 0, 5, 5);
		gbc_rbt_eventInstant.gridx = 6;
		gbc_rbt_eventInstant.gridy = 8;
		panel_contact.add(rbt_eventInstant, gbc_rbt_eventInstant);
		
		tf_eventInstant = new JTextField();
		hintText hintEventInstance = new hintText(tf_eventInstant, "2018-01-01T10:00:00Z");
		tf_eventInstant.addFocusListener(new JTextFieldHintListener("2018-01-01T10:00:00Z", tf_eventInstant));
		tf_eventInstant.setEditable(false);
		tf_eventInstant.setColumns(10);
		GridBagConstraints gbc_tf_eventInstant = new GridBagConstraints();
		gbc_tf_eventInstant.gridwidth = 3;
		gbc_tf_eventInstant.insets = new Insets(0, 0, 5, 0);
		gbc_tf_eventInstant.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_eventInstant.gridx = 7;
		gbc_tf_eventInstant.gridy = 8;
		panel_contact.add(tf_eventInstant, gbc_tf_eventInstant);
		
		JLabel lb_country = new JLabel("国家:");
		GridBagConstraints gbc_lb_country = new GridBagConstraints();
		gbc_lb_country.insets = new Insets(0, 0, 5, 5);
		gbc_lb_country.anchor = GridBagConstraints.EAST;
		gbc_lb_country.gridx = 1;
		gbc_lb_country.gridy = 9;
		panel_contact.add(lb_country, gbc_lb_country);
		
		tf_country = new JTextField();
		tf_country.setEditable(false);
		tf_country.setColumns(10);
		GridBagConstraints gbc_tf_country = new GridBagConstraints();
		gbc_tf_country.gridwidth = 3;
		gbc_tf_country.insets = new Insets(0, 0, 5, 5);
		gbc_tf_country.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_country.gridx = 2;
		gbc_tf_country.gridy = 9;
		panel_contact.add(tf_country, gbc_tf_country);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_6 = new GridBagConstraints();
		gbc_scrollPane_6.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_6.gridheight = 3;
		gbc_scrollPane_6.gridwidth = 3;
		gbc_scrollPane_6.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_6.gridx = 6;
		gbc_scrollPane_6.gridy = 9;
		panel_contact.add(scrollPane_6, gbc_scrollPane_6);
		
		tb_history = new JTable();
		tb_history.setBackground(new Color(175, 238, 238));
		scrollPane_6.setViewportView(tb_history);
		DefaultTableModel model_history = new DefaultTableModel(new Object[][] {},new String[] {"事件编号", "事件标签"});
		tb_history.setModel(model_history);
		tb_history.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lb_postCode = new JLabel("邮政编码:");
		GridBagConstraints gbc_lb_postCode = new GridBagConstraints();
		gbc_lb_postCode.insets = new Insets(0, 0, 5, 5);
		gbc_lb_postCode.anchor = GridBagConstraints.EAST;
		gbc_lb_postCode.gridx = 1;
		gbc_lb_postCode.gridy = 10;
		panel_contact.add(lb_postCode, gbc_lb_postCode);
		
		tf_postCode = new JTextField();
		tf_postCode.setEditable(false);
		tf_postCode.setColumns(10);
		GridBagConstraints gbc_tf_postCode = new GridBagConstraints();
		gbc_tf_postCode.gridwidth = 3;
		gbc_tf_postCode.insets = new Insets(0, 0, 5, 5);
		gbc_tf_postCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_postCode.gridx = 2;
		gbc_tf_postCode.gridy = 10;
		panel_contact.add(tf_postCode, gbc_tf_postCode);
		
		JButton bt_addHistory = new JButton("增加");
		bt_addHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_eventID.getText(),tf_eventLabel.getText()};
				model_history.addRow(info);
				tf_eventID.setText("");
				tf_eventLabel.setText("");
			}
		});
		GridBagConstraints gbc_bt_addHistory = new GridBagConstraints();
		gbc_bt_addHistory.insets = new Insets(0, 0, 5, 0);
		gbc_bt_addHistory.gridx = 9;
		gbc_bt_addHistory.gridy = 10;
		panel_contact.add(bt_addHistory, gbc_bt_addHistory);
		
		JLabel lb_email = new JLabel("电子邮箱:");
		GridBagConstraints gbc_lb_email = new GridBagConstraints();
		gbc_lb_email.insets = new Insets(0, 0, 5, 5);
		gbc_lb_email.anchor = GridBagConstraints.EAST;
		gbc_lb_email.gridx = 1;
		gbc_lb_email.gridy = 11;
		panel_contact.add(lb_email, gbc_lb_email);
		
		tf_email = new JTextField();
		tf_email.setEditable(false);
		tf_email.setColumns(10);
		GridBagConstraints gbc_tf_email = new GridBagConstraints();
		gbc_tf_email.gridwidth = 3;
		gbc_tf_email.insets = new Insets(0, 0, 5, 5);
		gbc_tf_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_email.gridx = 2;
		gbc_tf_email.gridy = 11;
		panel_contact.add(tf_email, gbc_tf_email);
		
		JButton bt_deleteHistory = new JButton("删除");
		bt_deleteHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_history.getSelectedRow();
				if (selectedRow != -1) {
					model_history.removeRow(selectedRow);
				}
			}
		});

		GridBagConstraints gbc_bt_deleteHistory = new GridBagConstraints();
		gbc_bt_deleteHistory.insets = new Insets(0, 0, 5, 0);
		gbc_bt_deleteHistory.gridx = 9;
		gbc_bt_deleteHistory.gridy = 11;
		panel_contact.add(bt_deleteHistory, gbc_bt_deleteHistory);
		
		JButton bt_addContact = new JButton("增加");
		GridBagConstraints gbc_bt_addContact = new GridBagConstraints();
		gbc_bt_addContact.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addContact.gridx = 3;
		gbc_bt_addContact.gridy = 12;
		panel_contact.add(bt_addContact, gbc_bt_addContact);
		
		JButton bt_deleteContact = new JButton("删除");
		GridBagConstraints gbc_bt_deleteContact = new GridBagConstraints();
		gbc_bt_deleteContact.insets = new Insets(0, 0, 5, 5);
		gbc_bt_deleteContact.gridx = 4;
		gbc_bt_deleteContact.gridy = 12;
		panel_contact.add(bt_deleteContact, gbc_bt_deleteContact);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_8 = new GridBagConstraints();
		gbc_scrollPane_8.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_8.gridheight = 4;
		gbc_scrollPane_8.gridwidth = 5;
		gbc_scrollPane_8.insets = new Insets(0, 10, 5, 5);
		gbc_scrollPane_8.gridx = 0;
		gbc_scrollPane_8.gridy = 13;
		panel_contact.add(scrollPane_8, gbc_scrollPane_8);
		
		tb_contact = new JTable();
		scrollPane_8.setViewportView(tb_contact);
		DefaultTableModel model_contact = new DefaultTableModel(new Object[][] {},new String[] {"负责单位", "联系组织"});
		tb_contact.setModel(model_contact);
		tb_contact.setBackground(new Color(175, 238, 238));
		tb_contact.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bt_addContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {cbbx_role.getSelectedItem().toString(),tf_organizationName.getText()};
				model_contact.addRow(info);
				tf_organizationName.setText("");
			}
		});
		bt_deleteContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_contact.getSelectedRow();
				if (selectedRow != -1) {
					model_contact.removeRow(selectedRow);
				}
			}
		});
		
		JLabel lb_interface = new JLabel("服务接口");
		lb_interface.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_interface = new GridBagConstraints();
		gbc_lb_interface.insets = new Insets(0, 0, 5, 5);
		gbc_lb_interface.gridx = 6;
		gbc_lb_interface.gridy = 13;
		panel_contact.add(lb_interface, gbc_lb_interface);
		
		JButton bt_addInterface = new JButton("增加");
		GridBagConstraints gbc_bt_addInterface = new GridBagConstraints();
		gbc_bt_addInterface.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addInterface.gridx = 8;
		gbc_bt_addInterface.gridy = 13;
		panel_contact.add(bt_addInterface, gbc_bt_addInterface);
		
		JButton bt_deleteInterface = new JButton("删除");
		GridBagConstraints gbc_bt_deleteInterface = new GridBagConstraints();
		gbc_bt_deleteInterface.insets = new Insets(0, 0, 5, 0);
		gbc_bt_deleteInterface.gridx = 9;
		gbc_bt_deleteInterface.gridy = 13;
		panel_contact.add(bt_deleteInterface, gbc_bt_deleteInterface);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_7 = new GridBagConstraints();
		gbc_scrollPane_7.gridheight = 3;
		gbc_scrollPane_7.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_7.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_7.gridwidth = 4;
		gbc_scrollPane_7.gridx = 6;
		gbc_scrollPane_7.gridy = 14;
		panel_contact.add(scrollPane_7, gbc_scrollPane_7);
		
		tb_interface = new JTable();
		tb_interface.setBackground(new Color(175, 238, 238));
		scrollPane_7.setViewportView(tb_interface);
		model_interface = new DefaultTableModel(new Object[][] {},new String[] {"接口名称", "服务类型", "服务地址", "传感器标识码"});
		tb_interface.setModel(model_interface);
		tb_interface.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bt_addInterface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaceDialog interfaceDialog = new interfaceDialog();
				interfaceDialog.setLocationRelativeTo(frame);
				interfaceDialog.setVisible(true);
				interfaceDialog.setAlwaysOnTop(true);
			}
		});
		bt_deleteInterface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_interface.getSelectedRow();
				if (selectedRow != -1) {
					model_interface.removeRow(selectedRow);
				}
	
			}
		});
		
		JPanel panel_component = new JPanel();
		tp_content.addTab("传感器部件信息", null, panel_component, null);
		GridBagLayout gbl_panel_component = new GridBagLayout();
		gbl_panel_component.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_component.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_component.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_component.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_component.setLayout(gbl_panel_component);
		
		JCheckBox ckbx_input = new JCheckBox("添加输入：");
		ckbx_input.setSelected(true);
		GridBagConstraints gbc_ckbx_input = new GridBagConstraints();
		gbc_ckbx_input.gridwidth = 2;
		gbc_ckbx_input.insets = new Insets(15, 10, 5, 5);
		gbc_ckbx_input.gridx = 0;
		gbc_ckbx_input.gridy = 0;
		panel_component.add(ckbx_input, gbc_ckbx_input);
		
		JButton bt_addInput = new JButton("增加");
		bt_addInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputDialog inDialog = new inputDialog(); 	
				inDialog.setLocationRelativeTo(frame);
				inDialog.setVisible(true);
				inDialog.setAlwaysOnTop(true);
			}
		});
		GridBagConstraints gbc_bt_addInput = new GridBagConstraints();
		gbc_bt_addInput.insets = new Insets(15, 0, 5, 5);
		gbc_bt_addInput.gridx = 4;
		gbc_bt_addInput.gridy = 0;
		panel_component.add(bt_addInput, gbc_bt_addInput);
		
		JButton bt_deleteInput = new JButton("删除");
		bt_deleteInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_input.getSelectedRow();
				if (selectedRow != -1) {
					model_input.removeRow(selectedRow);
				}
			}
		});
		GridBagConstraints gbc_bt_deleteInput = new GridBagConstraints();
		gbc_bt_deleteInput.insets = new Insets(15, 0, 5, 20);
		gbc_bt_deleteInput.gridx = 5;
		gbc_bt_deleteInput.gridy = 0;
		panel_component.add(bt_deleteInput, gbc_bt_deleteInput);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_9 = new GridBagConstraints();
		gbc_scrollPane_9.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_9.gridwidth = 5;
		gbc_scrollPane_9.insets = new Insets(0, 0, 5, 20);
		gbc_scrollPane_9.gridx = 1;
		gbc_scrollPane_9.gridy = 1;
		panel_component.add(scrollPane_9, gbc_scrollPane_9);
		
		tb_input = new JTable();
		scrollPane_9.setViewportView(tb_input);
		tb_input.setBackground(new Color(176, 224, 230));
		model_input = new DefaultTableModel(new Object[][] {},new String[] {"输入现象名称：", "输入现象定义："});
		tb_input.setModel(model_input);
		tb_input.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ckbx_output = new JCheckBox("添加输出：");
		GridBagConstraints gbc_ckbx_output = new GridBagConstraints();
		gbc_ckbx_output.gridwidth = 2;
		gbc_ckbx_output.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_output.gridx = 0;
		gbc_ckbx_output.gridy = 2;
		panel_component.add(ckbx_output, gbc_ckbx_output);
		
		JButton bt_addOutput = new JButton("增加");
		bt_addOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputDialog outDialog = new outputDialog();
				outDialog.setLocationRelativeTo(frame);
				outDialog.setVisible(true);
				outDialog.setAlwaysOnTop(true);
			}
		});
		bt_addOutput.setEnabled(false);
		GridBagConstraints gbc_bt_addOutput = new GridBagConstraints();
		gbc_bt_addOutput.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addOutput.gridx = 4;
		gbc_bt_addOutput.gridy = 2;
		panel_component.add(bt_addOutput, gbc_bt_addOutput);
		
		JButton bt_deleteOutput = new JButton("删除");
		bt_deleteOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_output.getSelectedRow();
				if (selectedRow != -1) {
					model_output.removeRow(selectedRow);
				}
			}
		});
		bt_deleteOutput.setEnabled(false);
		GridBagConstraints gbc_bt_deleteOutput = new GridBagConstraints();
		gbc_bt_deleteOutput.insets = new Insets(0, 0, 5, 20);
		gbc_bt_deleteOutput.gridx = 5;
		gbc_bt_deleteOutput.gridy = 2;
		panel_component.add(bt_deleteOutput, gbc_bt_deleteOutput);
		ckbx_output.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_output.isSelected()) {
					bt_addOutput.setEnabled(true);
					bt_deleteOutput.setEnabled(true);
				}else {
					bt_addOutput.setEnabled(false);
					bt_deleteOutput.setEnabled(false);
					model_output.setColumnCount(0);
				}
			}
		});
		
		JScrollPane scrollPane_10 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_10 = new GridBagConstraints();
		gbc_scrollPane_10.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_10.gridwidth = 5;
		gbc_scrollPane_10.insets = new Insets(0, 0, 5, 20);
		gbc_scrollPane_10.gridx = 1;
		gbc_scrollPane_10.gridy = 3;
		panel_component.add(scrollPane_10, gbc_scrollPane_10);
		
		tb_output = new JTable();
		scrollPane_10.setViewportView(tb_output);
		model_output =new DefaultTableModel(new Object[][] {},new String[] {"输出名称：", "输出定义：", "输出单位："});
		tb_output.setModel(model_output);
		tb_output.setBackground(new Color(176, 224, 230));
		tb_output.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ckbx_parameter = new JCheckBox("添加参数：");
		GridBagConstraints gbc_ckbx_parameter = new GridBagConstraints();
		gbc_ckbx_parameter.gridwidth = 2;
		gbc_ckbx_parameter.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_parameter.gridx = 0;
		gbc_ckbx_parameter.gridy = 4;
		panel_component.add(ckbx_parameter, gbc_ckbx_parameter);
		
		JButton bt_addParameter = new JButton("增加");
		bt_addParameter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParameterFrame parameterFrame = new ParameterFrame();	
				parameterFrame.setLocationRelativeTo(frame);
				parameterFrame.setAlwaysOnTop(true);
				parameterFrame.setVisible(true);
			}
		});
		bt_addParameter.setEnabled(false);
		GridBagConstraints gbc_bt_addParameter = new GridBagConstraints();
		gbc_bt_addParameter.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addParameter.gridx = 4;
		gbc_bt_addParameter.gridy = 4;
		panel_component.add(bt_addParameter, gbc_bt_addParameter);
		
		JButton bt_deleteParameter = new JButton("删除");
		bt_deleteParameter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_parameter.getSelectedRow();
				if (selectedRow != -1) {
					model_parameter.removeRow(selectedRow);
				}
			}
		});
		bt_deleteParameter.setEnabled(false);
		GridBagConstraints gbc_bt_deleteParameter = new GridBagConstraints();
		gbc_bt_deleteParameter.insets = new Insets(0, 0, 5, 20);
		gbc_bt_deleteParameter.gridx = 5;
		gbc_bt_deleteParameter.gridy = 4;
		panel_component.add(bt_deleteParameter, gbc_bt_deleteParameter);
		ckbx_parameter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_parameter.isSelected()) {
					bt_addParameter.setEnabled(true);
					bt_deleteParameter.setEnabled(true);
				}else {
					bt_addParameter.setEnabled(false);
					bt_deleteParameter.setEnabled(false);
					model_parameter.setColumnCount(0);
				}
			}
		});
		
		JScrollPane scrollPane_11 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_11 = new GridBagConstraints();
		gbc_scrollPane_11.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_11.gridwidth = 5;
		gbc_scrollPane_11.insets = new Insets(0, 0, 5, 20);
		gbc_scrollPane_11.gridx = 1;
		gbc_scrollPane_11.gridy = 5;
		panel_component.add(scrollPane_11, gbc_scrollPane_11);
		
		tb_parameter = new JTable();
		scrollPane_11.setViewportView(tb_parameter);
		model_parameter=new DefaultTableModel(new Object[][] {},new String[] { "参数定义：", "参数单位："});
		tb_parameter.setModel(model_parameter);
		tb_parameter.setBackground(new Color(176, 224, 230));
		tb_parameter.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ckbx_component = new JCheckBox("添加平台组件：");
		GridBagConstraints gbc_ckbx_component = new GridBagConstraints();
		gbc_ckbx_component.gridwidth = 3;
		gbc_ckbx_component.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_component.gridx = 0;
		gbc_ckbx_component.gridy = 6;
		panel_component.add(ckbx_component, gbc_ckbx_component);
		
		JButton bt_addComponent = new JButton("增加");
		bt_addComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				componentDialog componentDialog = new componentDialog();
				componentDialog.setLocationRelativeTo(frame);
				componentDialog.setAlwaysOnTop(true);
				componentDialog.setVisible(true);
			}
		});
		bt_addComponent.setEnabled(false);
		GridBagConstraints gbc_bt_addComponent = new GridBagConstraints();
		gbc_bt_addComponent.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addComponent.gridx = 4;
		gbc_bt_addComponent.gridy = 6;
		panel_component.add(bt_addComponent, gbc_bt_addComponent);
		
		JButton bt_deleteComponent = new JButton("删除");
		bt_deleteComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_component.getSelectedRow();
				if (selectedRow != -1) {
					model_component.removeRow(selectedRow);
				}
			}
		});
		bt_deleteComponent.setEnabled(false);
		GridBagConstraints gbc_bt_deleteComponent = new GridBagConstraints();
		gbc_bt_deleteComponent.insets = new Insets(0, 0, 5, 20);
		gbc_bt_deleteComponent.gridx = 5;
		gbc_bt_deleteComponent.gridy = 6;
		panel_component.add(bt_deleteComponent, gbc_bt_deleteComponent);
		ckbx_component.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_component.isSelected()) {
					bt_addComponent.setEnabled(true);
					bt_deleteComponent.setEnabled(true);
				}else {
					bt_addComponent.setEnabled(false);
					bt_deleteComponent.setEnabled(false);
					model_component.setRowCount(0);
				}
			}
		});
		
		JScrollPane scrollPane_12 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_12 = new GridBagConstraints();
		gbc_scrollPane_12.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_12.gridwidth = 5;
		gbc_scrollPane_12.insets = new Insets(0, 0, 5, 20);
		gbc_scrollPane_12.gridx = 1;
		gbc_scrollPane_12.gridy = 7;
		panel_component.add(scrollPane_12, gbc_scrollPane_12);
		
		tb_component = new JTable();
		scrollPane_12.setViewportView(tb_component);
		model_component =new DefaultTableModel(new Object[][] {},new String[] {"组件中文名称：", "组件英文名称："});
		tb_component.setModel(model_component);
		tb_component.setBackground(new Color(176, 224, 230));
		tb_component.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ckbx_connection = new JCheckBox("添加组件关系：");
		GridBagConstraints gbc_ckbx_connection = new GridBagConstraints();
		gbc_ckbx_connection.gridwidth = 3;
		gbc_ckbx_connection.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_connection.gridx = 0;
		gbc_ckbx_connection.gridy = 8;
		panel_component.add(ckbx_connection, gbc_ckbx_connection);
		
		JButton bt_addConnection = new JButton("增加");
		bt_addConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connectDialog connec = new connectDialog();	
				connec.setLocationRelativeTo(frame);
				connec.setVisible(true);
				connec.setAlwaysOnTop(true);
			}
		});
		bt_addConnection.setEnabled(false);
		GridBagConstraints gbc_bt_addConnection = new GridBagConstraints();
		gbc_bt_addConnection.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addConnection.gridx = 4;
		gbc_bt_addConnection.gridy = 8;
		panel_component.add(bt_addConnection, gbc_bt_addConnection);
		
		JButton bt_deleteConnection = new JButton("删除");
		bt_deleteConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_connection.getSelectedRow();
				if (selectedRow != -1) {
					model_connection.removeRow(selectedRow);
				}
			}
		});
		bt_deleteConnection.setEnabled(false);
		GridBagConstraints gbc_bt_deleteConnection = new GridBagConstraints();
		gbc_bt_deleteConnection.insets = new Insets(0, 0, 5, 20);
		gbc_bt_deleteConnection.gridx = 5;
		gbc_bt_deleteConnection.gridy = 8;
		panel_component.add(bt_deleteConnection, gbc_bt_deleteConnection);
		ckbx_connection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_connection.isSelected()) {
					bt_addConnection.setEnabled(true);
					bt_deleteConnection.setEnabled(true);
				}else {
					bt_addConnection.setEnabled(false);
					bt_deleteConnection.setEnabled(false);
					model_connection.setRowCount(0);
				}
			}
		});
		
		JScrollPane scrollPane_13 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_13 = new GridBagConstraints();
		gbc_scrollPane_13.insets = new Insets(0, 0, 5, 20);
		gbc_scrollPane_13.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_13.gridwidth = 5;
		gbc_scrollPane_13.gridx = 1;
		gbc_scrollPane_13.gridy = 9;
		panel_component.add(scrollPane_13, gbc_scrollPane_13);
		
		tb_connection = new JTable();
		scrollPane_13.setViewportView(tb_connection);
		model_connection = new DefaultTableModel(new Object[][] {},new String[] {"Source", "Destination"});
		tb_connection.setModel(model_connection);
		tb_connection.setBackground(new Color(176, 224, 230));
		tb_connection.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JPanel panel_configuration = new JPanel();
		tp_content.addTab("传感器配置信息", null, panel_configuration, null);
		GridBagLayout gbl_panel_configuration = new GridBagLayout();
		gbl_panel_configuration.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_configuration.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_configuration.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_configuration.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_configuration.setLayout(gbl_panel_configuration);
		
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
		gbc_ckbx_FOI.gridy = 0;
		panel_configuration.add(ckbx_FOI, gbc_ckbx_FOI);
		
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
		gbc_bt_addFOI.gridx = 4;
		gbc_bt_addFOI.gridy = 0;
		panel_configuration.add(bt_addFOI, gbc_bt_addFOI);
		
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
		gbc_bt_deleFOI.insets = new Insets(0, 0, 5, 10);
		gbc_bt_deleFOI.gridx = 5;
		gbc_bt_deleFOI.gridy = 0;
		panel_configuration.add(bt_deleFOI, gbc_bt_deleFOI);
		
		JScrollPane scrollPane_15 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_15 = new GridBagConstraints();
		gbc_scrollPane_15.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_15.gridwidth = 6;
		gbc_scrollPane_15.insets = new Insets(0, 10, 5, 10);
		gbc_scrollPane_15.gridx = 0;
		gbc_scrollPane_15.gridy = 1;
		panel_configuration.add(scrollPane_15, gbc_scrollPane_15);
		
		tb_FOI = new JTable();
		model_FOI = new DefaultTableModel(new Object[][] {},new String[] {"特征名称：", "URL地址"});
		tb_FOI.setModel(model_FOI);
		scrollPane_15.setViewportView(tb_FOI);
		tb_FOI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tb_FOI.setBackground(new Color(176, 224, 230));
		
		ckbx_typeOf = new JCheckBox("继承基类");
		ckbx_typeOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_typeOf.isSelected()) {
					tf_typeOfUID.setEditable(true);
					tf_typeOfUrl.setEditable(true);
					tf_typeOfUID.setBackground(Color.white);
					tf_typeOfUrl.setBackground(Color.white);
				}else {
					tf_typeOfUID.setEditable(false);
					tf_typeOfUrl.setEditable(false);
					tf_typeOfUID.setBackground(Grey);
					tf_typeOfUrl.setBackground(Grey);
					tf_typeOfUID.setText("");
					tf_typeOfUrl.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_typeOf = new GridBagConstraints();
		gbc_ckbx_typeOf.anchor = GridBagConstraints.WEST;
		gbc_ckbx_typeOf.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_typeOf.gridx = 0;
		gbc_ckbx_typeOf.gridy = 2;
		panel_configuration.add(ckbx_typeOf, gbc_ckbx_typeOf);
		
		JLabel lb_typeOfUID = new JLabel("基类唯一标识符：");
		GridBagConstraints gbc_lb_typeOfUID = new GridBagConstraints();
		gbc_lb_typeOfUID.anchor = GridBagConstraints.EAST;
		gbc_lb_typeOfUID.insets = new Insets(0, 10, 5, 5);
		gbc_lb_typeOfUID.gridx = 0;
		gbc_lb_typeOfUID.gridy = 3;
		panel_configuration.add(lb_typeOfUID, gbc_lb_typeOfUID);
		
		tf_typeOfUID = new JTextField();
		tf_typeOfUID.setEditable(false);
		GridBagConstraints gbc_tf_typeOfUID = new GridBagConstraints();
		gbc_tf_typeOfUID.gridwidth = 5;
		gbc_tf_typeOfUID.insets = new Insets(0, 0, 5, 10);
		gbc_tf_typeOfUID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_typeOfUID.gridx = 1;
		gbc_tf_typeOfUID.gridy = 3;
		panel_configuration.add(tf_typeOfUID, gbc_tf_typeOfUID);
		tf_typeOfUID.setColumns(10);
		
		JLabel lb_typeOfUrl = new JLabel("基类URL：");
		GridBagConstraints gbc_lb_typeOfUrl = new GridBagConstraints();
		gbc_lb_typeOfUrl.insets = new Insets(0, 0, 5, 5);
		gbc_lb_typeOfUrl.gridx = 0;
		gbc_lb_typeOfUrl.gridy = 4;
		panel_configuration.add(lb_typeOfUrl, gbc_lb_typeOfUrl);
		
		tf_typeOfUrl = new JTextField();
		tf_typeOfUrl.setEditable(false);
		tf_typeOfUrl.setColumns(10);
		GridBagConstraints gbc_tf_typeOfUrl = new GridBagConstraints();
		gbc_tf_typeOfUrl.gridwidth = 5;
		gbc_tf_typeOfUrl.insets = new Insets(0, 0, 5, 10);
		gbc_tf_typeOfUrl.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_typeOfUrl.gridx = 1;
		gbc_tf_typeOfUrl.gridy = 4;
		panel_configuration.add(tf_typeOfUrl, gbc_tf_typeOfUrl);
		
		ckbx_configuration = new JCheckBox("配置");
		ckbx_configuration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_configuration.isSelected()) {
					tf_parameterName.setEditable(true);
					tf_parameterName.setBackground(Color.white);
					bt_selectParameter.setEnabled(true);
					bt_clearParameter.setEnabled(true);
					tf_modeType.setEditable(true);
					tf_modeType.setBackground(Color.white);
					tf_modeChoice.setEditable(true);
					tf_modeChoice.setBackground(Color.white);
				}else {
					tf_parameterName.setEditable(false);
					tf_parameterName.setBackground(Grey);
					bt_selectParameter.setEnabled(false);
					bt_clearParameter.setEnabled(false);
					tf_modeType.setEditable(false);
					tf_modeType.setBackground(Grey);
					tf_modeChoice.setEditable(false);
					tf_modeChoice.setBackground(Grey);
					model_setValue.setRowCount(0);
				}
			}
		});
		GridBagConstraints gbc_ckbx_configuration = new GridBagConstraints();
		gbc_ckbx_configuration.anchor = GridBagConstraints.WEST;
		gbc_ckbx_configuration.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_configuration.gridx = 0;
		gbc_ckbx_configuration.gridy = 5;
		panel_configuration.add(ckbx_configuration, gbc_ckbx_configuration);
		
		JLabel lb_setValue = new JLabel("参数配置：");
		GridBagConstraints gbc_lb_setValue = new GridBagConstraints();
		gbc_lb_setValue.insets = new Insets(0, 0, 5, 5);
		gbc_lb_setValue.gridx = 0;
		gbc_lb_setValue.gridy = 6;
		panel_configuration.add(lb_setValue, gbc_lb_setValue);
		
		tf_parameterName = new JTextField();
		tf_parameterName.setEditable(false);
		tf_parameterName.setColumns(10);
		GridBagConstraints gbc_tf_parameterName = new GridBagConstraints();
		gbc_tf_parameterName.insets = new Insets(0, 0, 5, 5);
		gbc_tf_parameterName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_parameterName.gridx = 1;
		gbc_tf_parameterName.gridy = 6;
		panel_configuration.add(tf_parameterName, gbc_tf_parameterName);
		
		bt_selectParameter = new JButton("+");
		bt_selectParameter.setEnabled(false);
		bt_selectParameter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf_parameterName.getText().equals("")) {
					tipsDialog tip = new tipsDialog("请输入要配置参数名称：");
					tip.setLocationRelativeTo(tb_setValue);
					tip.setAlwaysOnTop(true);
					tip.setVisible(true);
				}else {
					String[] info = {tf_parameterName.getText(),""};
					model_setValue.addRow(info);
					tf_parameterName.setText("");
				}
			}
		});
		GridBagConstraints gbc_bt_selectParameter = new GridBagConstraints();
		gbc_bt_selectParameter.insets = new Insets(0, 0, 5, 5);
		gbc_bt_selectParameter.gridx = 2;
		gbc_bt_selectParameter.gridy = 6;
		panel_configuration.add(bt_selectParameter, gbc_bt_selectParameter);
		
		JScrollPane scrollPane_17 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_17 = new GridBagConstraints();
		gbc_scrollPane_17.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_17.gridheight = 3;
		gbc_scrollPane_17.gridwidth = 3;
		gbc_scrollPane_17.insets = new Insets(0, 0, 5, 10);
		gbc_scrollPane_17.gridx = 3;
		gbc_scrollPane_17.gridy = 6;
		panel_configuration.add(scrollPane_17, gbc_scrollPane_17);
		
		tb_setValue = new JTable();
		tb_setValue.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tb_setValue.setBackground(new Color(175, 238, 238));
		scrollPane_17.setViewportView(tb_setValue);
		model_setValue = new DefaultTableModel(new Object[][] {},new String[] {"参数名称：", "设置参数值："});
		tb_setValue.setModel(model_setValue);
		
		
		bt_clearParameter = new JButton("-");
		bt_clearParameter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_setValue.getSelectedRow();
				if (selectedRow != -1) {
					model_setValue.removeRow(selectedRow);
				}
			}
		});
		bt_clearParameter.setEnabled(false);
		GridBagConstraints gbc_bt_clearParameter = new GridBagConstraints();
		gbc_bt_clearParameter.insets = new Insets(0, 0, 5, 5);
		gbc_bt_clearParameter.gridx = 2;
		gbc_bt_clearParameter.gridy = 7;
		panel_configuration.add(bt_clearParameter, gbc_bt_clearParameter);
		
		lb_setMode = new JLabel("模式选择：");
		GridBagConstraints gbc_lb_setMode = new GridBagConstraints();
		gbc_lb_setMode.insets = new Insets(0, 0, 5, 5);
		gbc_lb_setMode.gridx = 0;
		gbc_lb_setMode.gridy = 9;
		panel_configuration.add(lb_setMode, gbc_lb_setMode);
		
		tf_modeType = new JTextField();
		tf_modeType.setEditable(false);
		GridBagConstraints gbc_tf_modeType = new GridBagConstraints();
		gbc_tf_modeType.gridwidth = 2;
		gbc_tf_modeType.insets = new Insets(0, 0, 5, 5);
		gbc_tf_modeType.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_modeType.gridx = 1;
		gbc_tf_modeType.gridy = 9;
		panel_configuration.add(tf_modeType, gbc_tf_modeType);
		
		tf_modeChoice = new JTextField();
		tf_modeChoice.setEditable(false);
		GridBagConstraints gbc_tf_modeChoice = new GridBagConstraints();
		gbc_tf_modeChoice.gridwidth = 3;
		gbc_tf_modeChoice.insets = new Insets(0, 0, 5, 10);
		gbc_tf_modeChoice.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_modeChoice.gridx = 3;
		gbc_tf_modeChoice.gridy = 9;
		panel_configuration.add(tf_modeChoice, gbc_tf_modeChoice);
		
		lb_inheritance = new JLabel("");
		GridBagConstraints gbc_lb_inheritance = new GridBagConstraints();
		gbc_lb_inheritance.gridwidth = 2;
		gbc_lb_inheritance.insets = new Insets(0, 0, 0, 5);
		gbc_lb_inheritance.gridx = 0;
		gbc_lb_inheritance.gridy = 11;
		panel_configuration.add(lb_inheritance, gbc_lb_inheritance);
		
		JPanel panel_pageButton = new JPanel();
		frame.getContentPane().add(panel_pageButton, BorderLayout.SOUTH);
		
		bt_lastPage = new JButton("<<");
		bt_lastPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index==1||index==2||index==3||index==4||index==5) {
					tp_content.setSelectedIndex(index-1);
				}
			}
		});
		panel_pageButton.add(bt_lastPage);
		
		JButton bt_lastItem = new JButton("<");
		bt_lastItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tp_capability.getSelectedIndex()==1||tp_capability.getSelectedIndex()==2) {
					tp_capability.setSelectedIndex(tp_capability.getSelectedIndex()-1);
				}
			}
		});
		panel_pageButton.add(bt_lastItem);
		
		bt_savePage = new JButton("保存编辑");
		bt_savePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savePageIsClicled = true;
				try {
					Temp2_xml.DOMcreate();
					save.setEnabled(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_pageButton.add(bt_savePage);
		
		bt_exitPage = new JButton("放弃编辑");
		bt_exitPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel_pageButton.add(bt_exitPage);
		
		JButton bt_nextItem = new JButton(">");
		bt_nextItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tp_capability.getSelectedIndex()==0||tp_capability.getSelectedIndex()==1) {
					tp_capability.setSelectedIndex(tp_capability.getSelectedIndex()+1);
				}
			}
		});
		panel_pageButton.add(bt_nextItem);
		
		bt_nextPage = new JButton(">>");
		bt_nextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index==0||index==1||index==2||index==3||index==4) {
					tp_content.setSelectedIndex(index+1);
				}
			}
		});
		panel_pageButton.add(bt_nextPage);
		
		
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
	
	class interfaceDialog extends JDialog{
		private final JPanel contentPanel = new JPanel();
		private JTextField tf_name;
		private JTextField tf_type;
		private JTextField tf_URL;
		private JTextField tf_UID;
		
		public interfaceDialog() {
			setTitle("请输入服务接口信息：");
			setBounds(100, 100, 450, 300);
			setIconImage(Toolkit.getDefaultToolkit().getImage(InsituSensorFrame.class.getResource("/sm/images/utils.png")));
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
			setIconImage(Toolkit.getDefaultToolkit().getImage(InsituSensorFrame.class.getResource("/sm/images/utils.png")));
			setTitle("输入对话框");
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
			setIconImage(Toolkit.getDefaultToolkit().getImage(InsituSensorFrame.class.getResource("/sm/images/utils.png")));
			setBounds(100, 100, 450, 300);
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
	
	public class ParameterFrame extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTextField tf_paraName;
		private JTable tb_item;
		private JTextField tf_paraDefinition;
		private JTextField tf_paraUom;
		private DefaultTableModel model_item;
		private String[] parameterInfo= new String[3];
		private JTextArea ta_ParaDescription;
		private JTextArea ta_paraValue; 

		/**
		 * Create the dialog.
		 */
		public ParameterFrame() {
			setTitle("输入对话框");
			setBounds(100, 100, 500, 650);
			setIconImage(Toolkit.getDefaultToolkit().getImage(InsituSensorFrame.class.getResource("/sm/images/utils.png")));
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			GridBagLayout gbl_contentPanel = new GridBagLayout();
			gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
			gbl_contentPanel.rowHeights = new int[]{0, 0, 29, 0, 38, 0, 0, 0, 0, 0};
			gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			contentPanel.setLayout(gbl_contentPanel);
			{
				JLabel lb_name = new JLabel("参数名称：");
				GridBagConstraints gbc_lb_name = new GridBagConstraints();
				gbc_lb_name.anchor = GridBagConstraints.EAST;
				gbc_lb_name.insets = new Insets(0, 10, 5, 5);
				gbc_lb_name.gridx = 0;
				gbc_lb_name.gridy = 0;
				contentPanel.add(lb_name, gbc_lb_name);
			}
			{
				tf_paraName = new JTextField();
				GridBagConstraints gbc_tf_paraName = new GridBagConstraints();
				gbc_tf_paraName.gridwidth = 4;
				gbc_tf_paraName.anchor = GridBagConstraints.NORTH;
				gbc_tf_paraName.insets = new Insets(0, 0, 5, 0);
				gbc_tf_paraName.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_paraName.gridx = 1;
				gbc_tf_paraName.gridy = 0;
				contentPanel.add(tf_paraName, gbc_tf_paraName);
				tf_paraName.setColumns(10);
			}
			{
				JLabel lb_paraDescription = new JLabel("参数描述：");
				GridBagConstraints gbc_lb_paraDescription = new GridBagConstraints();
				gbc_lb_paraDescription.insets = new Insets(0, 10, 5, 5);
				gbc_lb_paraDescription.gridx = 0;
				gbc_lb_paraDescription.gridy = 1;
				contentPanel.add(lb_paraDescription, gbc_lb_paraDescription);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.gridwidth = 4;
				gbc_scrollPane.gridheight = 2;
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 1;
				contentPanel.add(scrollPane, gbc_scrollPane);
				{
					ta_ParaDescription = new JTextArea();
					ta_ParaDescription.setBackground(SystemColor.info);
					scrollPane.setViewportView(ta_ParaDescription);
				}
			}
			{
				JLabel lb_item = new JLabel("参数列表：");
				GridBagConstraints gbc_lb_item = new GridBagConstraints();
				gbc_lb_item.insets = new Insets(0, 10, 5, 5);
				gbc_lb_item.gridx = 0;
				gbc_lb_item.gridy = 3;
				contentPanel.add(lb_item, gbc_lb_item);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.gridwidth = 5;
				gbc_scrollPane.gridheight = 2;
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.insets = new Insets(0, 10, 5, 0);
				gbc_scrollPane.gridx = 0;
				gbc_scrollPane.gridy = 4;
				contentPanel.add(scrollPane, gbc_scrollPane);
				{
					tb_item = new JTable();
					model_item = new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"定义：", "单位："
							}
						);
					tb_item.setModel(model_item);
					scrollPane.setViewportView(tb_item);
					tb_item.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				}
			}
			{
				tf_paraDefinition = new JTextField();
				tf_paraDefinition.setColumns(10);
				GridBagConstraints gbc_tf_paraDefinition = new GridBagConstraints();
				gbc_tf_paraDefinition.gridwidth = 2;
				gbc_tf_paraDefinition.insets = new Insets(0, 10, 5, 5);
				gbc_tf_paraDefinition.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_paraDefinition.gridx = 0;
				gbc_tf_paraDefinition.gridy = 6;
				contentPanel.add(tf_paraDefinition, gbc_tf_paraDefinition);
			}
			{
				tf_paraUom = new JTextField();
				tf_paraUom.setColumns(10);
				GridBagConstraints gbc_tf_paraUom = new GridBagConstraints();
				gbc_tf_paraUom.insets = new Insets(0, 0, 5, 5);
				gbc_tf_paraUom.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_paraUom.gridx = 2;
				gbc_tf_paraUom.gridy = 6;
				contentPanel.add(tf_paraUom, gbc_tf_paraUom);
			}
			{
				JButton bt_add = new JButton("+");
				bt_add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String[] info = {tf_paraDefinition.getText(),tf_paraUom.getText()};
						model_parameter.addRow(info);
						model_item.addRow(info);
						tf_paraDefinition.setText("");
						tf_paraUom.setText("");
					}
				});
				bt_add.setFont(new Font("宋体", Font.BOLD, 18));
				GridBagConstraints gbc_bt_add = new GridBagConstraints();
				gbc_bt_add.insets = new Insets(0, 0, 5, 5);
				gbc_bt_add.gridx = 3;
				gbc_bt_add.gridy = 6;
				contentPanel.add(bt_add, gbc_bt_add);
			}
			{
				JButton bt_delete = new JButton("-");
				bt_delete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int selectedRow = tb_item.getSelectedRow();
						if (selectedRow != -1) {
							model_item.removeRow(selectedRow);
						}
					}
				});
				bt_delete.setFont(new Font("宋体", Font.BOLD, 18));
				GridBagConstraints gbc_bt_delete = new GridBagConstraints();
				gbc_bt_delete.insets = new Insets(0, 0, 5, 0);
				gbc_bt_delete.gridx = 4;
				gbc_bt_delete.gridy = 6;
				contentPanel.add(bt_delete, gbc_bt_delete);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.gridwidth = 4;
				gbc_scrollPane.gridheight = 2;
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 7;
				contentPanel.add(scrollPane, gbc_scrollPane);
				{
					ta_paraValue = new JTextArea();
					ta_paraValue.setBackground(SystemColor.info);
					scrollPane.setViewportView(ta_paraValue);
				}
			}
			{
				JLabel lb_paraValue = new JLabel("参数值：");
				GridBagConstraints gbc_lb_paraValue = new GridBagConstraints();
				gbc_lb_paraValue.insets = new Insets(0, 10, 5, 5);
				gbc_lb_paraValue.anchor = GridBagConstraints.WEST;
				gbc_lb_paraValue.gridx = 0;
				gbc_lb_paraValue.gridy = 7;
				contentPanel.add(lb_paraValue, gbc_lb_paraValue);
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("确认");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							parameterInfo[0]=tf_paraName.getText();
							parameterInfo[1]=ta_ParaDescription.getText();
							parameterInfo[2]=ta_paraValue.getText();
							dispose();
						}
					});
					okButton.setActionCommand("OK");
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
	}
	
	class componentDialog extends JDialog{
		private final JPanel contentPanel = new JPanel();
		private JTextField tf_name;
		private JTextField tf_Ename;
		
		public componentDialog() {
			setBounds(100, 100, 450, 300);
			setTitle("输入对话框");
			setIconImage(Toolkit.getDefaultToolkit().getImage(InsituSensorFrame.class.getResource("/sm/images/utils.png")));
			setModal(true);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			GridBagLayout gbl_contentPanel = new GridBagLayout();
			gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			contentPanel.setLayout(gbl_contentPanel);
			{
				JLabel lb_name = new JLabel("组件中文名称：");
				GridBagConstraints gbc_lb_name = new GridBagConstraints();
				gbc_lb_name.anchor = GridBagConstraints.EAST;
				gbc_lb_name.insets = new Insets(0, 0, 5, 5);
				gbc_lb_name.gridx = 1;
				gbc_lb_name.gridy = 1;
				contentPanel.add(lb_name, gbc_lb_name);
			}
			{
				tf_name = new JTextField();
				hintText nameHint = new hintText(tf_name, "如：温度计");
				tf_name.addFocusListener(new JTextFieldHintListener("如：温度计", tf_name));
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
				JLabel lb_Ename = new JLabel("组件英文简称：");
				GridBagConstraints gbc_lb_Ename = new GridBagConstraints();
				gbc_lb_Ename.anchor = GridBagConstraints.EAST;
				gbc_lb_Ename.insets = new Insets(0, 0, 5, 5);
				gbc_lb_Ename.gridx = 1;
				gbc_lb_Ename.gridy = 2;
				contentPanel.add(lb_Ename, gbc_lb_Ename);
			}
			{
				tf_Ename = new JTextField();
				hintText enameHint = new hintText(tf_Ename, "如：thermometer");
				tf_Ename.addFocusListener(new JTextFieldHintListener("如：thermometer",tf_Ename));
				tf_Ename.setColumns(10);
				GridBagConstraints gbc_tf_Ename = new GridBagConstraints();
				gbc_tf_Ename.gridwidth = 5;
				gbc_tf_Ename.insets = new Insets(0, 0, 5, 5);
				gbc_tf_Ename.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_Ename.gridx = 2;
				gbc_tf_Ename.gridy = 2;
				contentPanel.add(tf_Ename, gbc_tf_Ename);
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("确认");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String[] info = {tf_name.getText(),"urn:ogc:feature:insituSensorPlatform:"+tf_Ename.getText()};
							model_component.addRow(info);
							tf_name.setText("");
							tf_Ename.setText("");
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
	
	class connectDialog extends JDialog{
		private final JPanel contentPanel = new JPanel();
		private JTextField tf_source;
		private JTextField tf_destination;
		private JLabel lb_source;
		
		public connectDialog() {
			setBounds(100, 100, 450, 300);
			setIconImage(Toolkit.getDefaultToolkit().getImage(InsituSensorFrame.class.getResource("/sm/images/utils.png")));
			setTitle("输入对话框");
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
				lb_source = new JLabel("Source：");
				GridBagConstraints gbc_lb_source = new GridBagConstraints();
				gbc_lb_source.anchor = GridBagConstraints.EAST;
				gbc_lb_source.insets = new Insets(0, 0, 5, 5);
				gbc_lb_source.gridx = 1;
				gbc_lb_source.gridy = 1;
				contentPanel.add(lb_source, gbc_lb_source);
			}
			{
				tf_source = new JTextField();
				hintText sourceHint = new hintText(tf_source, "components:thermometer:outputs:temperature");
				tf_source.addFocusListener(new JTextFieldHintListener("components:thermometer:outputs:temperature", tf_source));
				GridBagConstraints gbc_tf_source = new GridBagConstraints();
				gbc_tf_source.gridwidth = 5;
				gbc_tf_source.insets = new Insets(0, 0, 5, 5);
				gbc_tf_source.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_source.gridx = 2;
				gbc_tf_source.gridy = 1;
				contentPanel.add(tf_source, gbc_tf_source);
				tf_source.setColumns(10);
			}
			{
				JLabel lb_destination = new JLabel("Destination：");
				GridBagConstraints gbc_lb_destination = new GridBagConstraints();
				gbc_lb_destination.anchor = GridBagConstraints.EAST;
				gbc_lb_destination.insets = new Insets(0, 0, 5, 5);
				gbc_lb_destination.gridx = 1;
				gbc_lb_destination.gridy = 2;
				contentPanel.add(lb_destination, gbc_lb_destination);
			}
			{
				tf_destination = new JTextField();
				hintText destinationHint = new hintText(tf_destination, "outputs:weather:temperature");
				tf_destination.addFocusListener(new JTextFieldHintListener("outputs:weather:temperature", tf_destination));
				tf_destination.setColumns(10);
				GridBagConstraints gbc_tf_destination = new GridBagConstraints();
				gbc_tf_destination.gridwidth = 5;
				gbc_tf_destination.insets = new Insets(0, 0, 5, 5);
				gbc_tf_destination.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_destination.gridx = 2;
				gbc_tf_destination.gridy = 2;
				contentPanel.add(tf_destination, gbc_tf_destination);
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("确认");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String[] info = {"urn:ogc:"+tf_source.getText(),"urn:ogc:"+tf_destination.getText()};
							model_connection.addRow(info);
							tf_source.setText("");
							tf_destination.setText("");
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
			setIconImage(Toolkit.getDefaultToolkit().getImage(FrameSensorFrame.class.getResource("/sm/images/utils.png")));
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
}
