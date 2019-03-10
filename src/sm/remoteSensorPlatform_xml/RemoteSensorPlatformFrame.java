package sm.remoteSensorPlatform_xml;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


import sm.main.UploadFrame;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;

public class RemoteSensorPlatformFrame extends JFrame{

	private JFrame frame;
	private String savePath = "src/instance/instance_RemoteSensorPlatform.xml";
	private Color Grey = UIManager.getColor("TextArea.disabledBackground");
	private Color white = Color.WHITE;
	private JButton save;
	private JButton clear;
	private JButton view;
	private JButton documents;
	private boolean saveIsClicked = false;
	private boolean savePageIsClicled = false;
	private JPanel buttonPanel;
	private JButton bt_prePage;
	private JButton bt_preItem;
	private JButton bt_savePage;
	private JPanel p1;
	private JButton bt_quitPage;
	private JPanel p2;
	private JButton bt_nextItem;
	private JButton bt_nextPage;
	private JTabbedPane tp_content;
	private JPanel p_description;
	private JPanel p_constraints;
	private JPanel p_capability;
	private JPanel p_contact;
	private JPanel p_component;
	private static JTextArea ta_description;
	private JScrollPane scrollPane;
	private JTextField tf_organizationID;
	private JTextField tf_platID;
	private static JTextField tf_UID;
	private JButton bt_UID;
	private static JCheckBox ckbx_UId;
	private static JCheckBox ckbx_longName;
	private static JCheckBox ckbx_shortName;
	private static JTextField tf_longName;
	private static JTextField tf_shortName;
	private static JCheckBox ckbx_associatedSensor;
	private DefaultTableModel model_associatedSensor;
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
	private static JTable tb_associatedSensor;
	private JTextField tf_associatedSensorName;
	private JTextField tf_associatedSensorID;
	private JButton bt_addAssociatedSensor;
	private JButton bt_deleAssociatedSensor;
	private static JCheckBox ckbx_otherIdentifier;
	private static JTable tb_otherIdentifier;
	private JTextField tf_otherIdentifierName;
	private JTextField tf_otherIdentifierValue;
	private JButton bt_addOtherIdentifier;
	private JButton bt_deleOtherIdentifier;
	private JTextField tf_keyword;
	private JButton bt_addKeyword;
	private JButton bt_clearKeyword;
	private static JTextArea ta_keyword;
	private static JCheckBox ckbx_platType;
	private static JCheckBox ckbx_sensorType;
	private static JCheckBox ckbx_orbitType;
	private static JCheckBox ckbx_application;
	private JTextField tf_application;
	private JButton bt_addApplication;
	private JButton bt_clearApplication;
	private static JTextArea ta_application;
	private static JCheckBox ckbx_otherClassifier;
	private static JTable tb_otherClassifier;
	private JTextField tf_otherClassifierName;
	private JTextField tf_otherClassifierValue;
	private JButton bt_addOtherClassifier;
	private JButton bt_deleOtherClassifier;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	private static JTextField tf_platType;
	private static JTextField tf_sensorType;
	private static JComboBox cbbx_orbitType;
	private JScrollPane scrollPane_5;
	private static JCheckBox ckbx_validTM;
	private static JCheckBox ckbx_legalConstraint;
	private static JCheckBox ckbx_securityConstraint;
	private static JComboBox cbbx_beginTM;
	private static JComboBox cbbx_endTM;
	private static JTextField tf_beginTM;
	private static JTextField tf_endTM;
	private static JTextArea ta_legalConstraint;
	private static JTextArea ta_securityConstraint;
	private JScrollPane scrollPane_6;
	private JScrollPane scrollPane_7;
	private JTabbedPane tp_capa;
	private JPanel p_characteristic;
	private JPanel p_capabilities;
	private JPanel p_position;
	private static JCheckBox ckbx_length;
	private static JCheckBox ckbx_width;
	private static JCheckBox ckbx_height;
	private static JCheckBox ckbx_weight;
	private static JCheckBox ckbx_life;
	private static JTextField tf_life;
	private static JTextField tf_length;
	private static JTextField tf_width;
	private static JTextField tf_height;
	private static JTextField tf_weight;
	private static JCheckBox ckbx_current;
	private static JCheckBox ckbx_voltage;
	private static JCheckBox ckbx_power;
	private static JCheckBox ckbx_outputPower;
	private static JTextField tf_outputPower;
	private static JTextField tf_power;
	private static JTextField tf_minCurrent;
	private static JTextField tf_maxCurrent;
	private static JTextField tf_minVoltage;
	private static JTextField tf_maxVoltage;
	private JLabel lb_line1;
	private JLabel lb_line2;
	private static JCheckBox ckbx_load;
	private static JTextField tf_load;
	private static JCheckBox ckbx_otherCharacter;
	private static JTable tb_otherCharacter;
	private JTextField tf_otherCharacterName;
	private JTextField tf_otherCharacterValue;
	private JButton bt_addOtherCharacter;
	private JButton bt_deleOtherCharacter;
	private JScrollPane scrollPane_8;
	private static JCheckBox ckbx_epochTM;
	private static JCheckBox ckbx_orbitHeight;
	private static JCheckBox ckbx_orbitCycle;
	private static JCheckBox ckbx_revisitingPeriod;
	private static JCheckBox ckbx_orbitInclination;
	private static JCheckBox ckbx_descendinNode;
	private static JCheckBox ckbx_orbitRigthAscension;
	private static JCheckBox ckbx_orbitEccentricity;
	private static JCheckBox ckbx_orbitArgumentOfPerigee;
	private static JCheckBox ckbx_orbitMeanAnomaly;
	private static JCheckBox ckbx_orbitMeanMotion;
	private static JCheckBox ckbx_orbitDecayRate;
	private static JCheckBox ckbx_observeBBox;
	private JLabel lb_lowerCorner;
	private JLabel lb_upperCorner;
	private static JTextField tf_lowerY;
	private static JTextField tf_upperY;
	private static JTextField tf_lowerX;
	private static JTextField tf_upperX;
	private JLabel lb_line3;
	private JLabel lb_line4;
	private static JTextField tf_epochTM;
	private static JTextField tf_orbitHeight;
	private static JTextField tf_orbitCycle;
	private static JTextField tf_revisitingPeriod;
	private static JTextField tf_orbitInclination;
	private static JTextField tf_descendingNode;
	private static JTextField tf_orbitRigthAscension;
	private static JTextField tf_orbitEccentricity;
	private static JTextField tf_orbitArgumentOfPerigee;
	private static JTextField tf_orbitMeanAnomaly;
	private static JTextField tf_orbitMeanMotion;
	private static JTextField tf_orbitDecayRate;
	private static JCheckBox ckbx_Tle;
	private static JCheckBox ckbx_TLE1;
	private static JCheckBox ckbx_TLE2;
	private static JTextField tf_TLESatID;
	private static JTextField tf_TLELineOne;
	private static JTextField tf_TLELineTwo;
	private static JCheckBox ckbx_storage;
	private static JCheckBox ckbx_dataRate;
	private static JTextField tf_storage;
	private static JTextField tf_dataRate;
	private static JCheckBox ckbx_transmissionMode;
	private static JCheckBox ckbx_controlWaveBand;
	private static JCheckBox ckbx_downloadLinkWaveBand;
	private static JCheckBox ckbx_downloadLinkRate;
	private static JCheckBox ckbx_communicationInterface;
	private static JTextField tf_transmissionMode;
	private static JTextField tf_controlWaveBand;
	private static JTextField tf_downloadLinkWaveBand;
	private static JTextField tf_downloadLinkRate;
	private static JTextField tf_communicationInterface;
	private static JCheckBox ckbx_otherCapability;
	private static JTable tb_otherCapability;
	private JTextField tf_otherCapabilityName;
	private JTextField tf_otherCapabilityValue;
	private JButton bt_addOtherCapability;
	private JButton bt_deleteOtherCapability;
	private JScrollPane scrollPane_9;
	private static JCheckBox ckbx_position;
	private static JCheckBox ckbx_spatialReference;
	private static JCheckBox ckbx_temperalReference;
	private JLabel lb_positionSRS;
	private JLabel lb_latitude;
	private JLabel lb_longtitude;
	private JLabel lb_altitude;
	private JLabel lb_spatioalRefrenceID;
	private JLabel lb_spatialReferenceOrigin;
	private JLabel lb_spatialReferenceX;
	private JLabel lb_spatialReferenceY;
	private JLabel lb_spatialReferenceZ;
	private JLabel lb_TMReferenceID;
	private JLabel lb_TMReferenceOrigin;
	private static JTextField tf_positionSRS;
	private static JTextField tf_latitude;
	private static JTextField tf_longtitude;
	private static JTextField tf_altitude;
	private static JTextField tf_spatialID;
	private static JTextField tf_spatialOrigin;
	private static JTextField tf_spatialX;
	private static JTextField tf_SpatialY;
	private static JTextField tf_spatialZ;
	private static JTextField tf_temperalID;
	private static JTextField tf_temperalOrigin;
	private static JCheckBox ckbx_role;
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
	private DefaultTableModel model_event;
	private DefaultTableModel model_contact;
	private static JTable tb_contacID;
	private static JTable tb_inte;
	private final ButtonGroup bg_eventTM = new ButtonGroup();
	private static JTable tb_input;
	private static JCheckBox ckbx_output;
	private static JTable tb_output;
	private static JCheckBox ckbx_parameter;
	private static JTable tb_parameter;
	private static JCheckBox ckbx_component;
	private static JTable tb_component;
	private static JCheckBox ckbx_connection;
	private static JTable tb_connection;
	
	public static String getDescription() {
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
	
	public static int getAssociatedSensorCount() {
		return tb_associatedSensor.getRowCount();
	}
	
	public static String getAssociatedSensorInfo(int a,int b) {
		return tb_associatedSensor.getValueAt(a, b).toString();
	}
	
	public static int getOtherIdentifierCount() {
		return tb_otherIdentifier.getRowCount();
	}
	
	public static String getOtherIdentifierInfo(int a,int b) {
		return tb_otherIdentifier.getValueAt(a, b).toString();
	}
	
	public static String getPlatformType() {
		return tf_platType.getText();
	}
	
	public static String getSensorType() {
		return tf_sensorType.getText();
	}
	
	public static String getOrbitType() {
		return cbbx_orbitType.getSelectedItem().toString();
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
	
	public static String getOverload() {
		return tf_load.getText();
	}
	
	public static int getOtherCharacterCount() {
		return tb_otherCharacter.getRowCount();
	}
	
	public static String getOtherCharacterInfo(int a,int b) {
		return tb_otherCharacter.getValueAt(a, b).toString();
	}
	
	public static String getEpochTM() {
		return tf_epochTM.getText();
	}
	
	public static String getOrbitHeight() {
		return tf_orbitHeight.getText();
	}
	
	public static String getOrbitCycle() {
		return tf_orbitCycle.getText();
	}
	
	public static String getRevisiteTM() {
		return tf_revisitingPeriod.getText();
	}
	
	public static String getOrbitInclination() {
		return tf_orbitInclination.getText();
	}
	
	public static String getLocaTimeOfDescendingNode() {
		return tf_descendingNode.getText();
	}
	
	public static String getOrbitRightAscension() {
		return tf_orbitRigthAscension.getText();
	}
	
	public static String getOrbitEccentricity() {
		return tf_orbitEccentricity.getText();
	}
	
	public static String getOrbitArgumentOfPerigee() {
		return tf_orbitArgumentOfPerigee.getText();
	}
	
	public static String getOrbitMeanMotion() {
		return tf_orbitMeanMotion.getText();
	}
	
	public static String getOrbitMeanAnomaly() {
		return tf_orbitMeanAnomaly.getText();
	}
	
	public static String getOrbitDecayRate() {
		return tf_orbitDecayRate.getText();
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
	
	public static String getTLESatID() {
		return tf_TLESatID.getText();
	}
	
	public static String getTLE1() {
		return tf_TLELineOne.getText();
	}
	
	public static String getTLE2() {
		return tf_TLELineTwo.getText();
	}
	
	public static String getStorage() {
		return tf_storage.getText();
	}
	
	public static String getDataRate() {
		return tf_dataRate.getText();
	}
	
	public static String getTransmissionMode() {
		return tf_transmissionMode.getText();
	}
	
	public static String getControlWaveBand() {
		return tf_controlWaveBand.getText();
	}
	
	public static String getDownloadLinkWaveBand() {
		return tf_downloadLinkWaveBand.getText();
	}
	
	public static String getDownloadLinkRate() {
		return tf_downloadLinkRate.getText();
	}
	
	public static String getCommunicationInterface() {
		return tf_communicationInterface.getText();
	}
	
	public static int getOtherCapabilityCount() {
		return tb_otherCapability.getRowCount();
	}
	
	public static String getOtherCapabilityInfo(int a,int b) {
		return tb_otherCapability.getValueAt(a, b).toString();
	}
	
	public static String[] getPosition() {
		String[] positon = {tf_positionSRS.getText(),tf_latitude.getText(),tf_longtitude.getText(),tf_altitude.getText()};
		return positon;
	}
	
	public static String[] getSpatialFrame() {
		String[] spatialFrame = {tf_spatialID.getText(),tf_spatialOrigin.getText(),
				tf_spatialX.getText(),tf_SpatialY.getText(),tf_spatialZ.getText()};
		return spatialFrame;
	}
	
	public static String[] getTemporalFrame() {
		String[] temporalFrame = {tf_temperalID.getText(),tf_temperalOrigin.getText()};
		return temporalFrame;
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
	
	public static int getContactNum() {
		return tb_contacID.getRowCount();
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
	
	public static int getParameterNum() {
		return tb_parameter.getRowCount();
	}
	
	public static String getParameterItem(int a,int b) {
		return tb_parameter.getValueAt(a, b).toString();
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
	
	public static boolean getLoad() {
		if (ckbx_load.isSelected()) {
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
	
	public static boolean checkEpochTime() {
		if (ckbx_epochTM.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOrbitHeight() {
		if (ckbx_orbitHeight.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOrbitCycle() {
		if (ckbx_orbitCycle.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkRevisitiongPeriod() {
		if (ckbx_revisitingPeriod.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOrbitInclination() {
		if (ckbx_orbitInclination.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkDescendingNode() {
		if (ckbx_descendinNode.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOrbitRightAscension() {
		if (ckbx_orbitRigthAscension.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOrbitEccentricity() {
		if (ckbx_orbitEccentricity.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkArgumentOfPerigee() {
		if (ckbx_orbitArgumentOfPerigee.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOrbitMeanMotion() {
		if (ckbx_orbitMeanMotion.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOrbitMeanAnomaly() {
		if (ckbx_orbitMeanAnomaly.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkOrbitDecayRate() {
		if (ckbx_orbitDecayRate.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkTLESatID() {
		if (ckbx_Tle.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkTLE1() {
		if (ckbx_TLE1.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkTLE2() {
		if (ckbx_TLE2.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkStorage() {
		if (ckbx_storage.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkDataRate() {
		if (ckbx_dataRate.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkTransmissionMode() {
		if (ckbx_transmissionMode.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkControlWaveBand() {
		if (ckbx_controlWaveBand.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkDownloadLinkWaveBand() {
		if (ckbx_downloadLinkWaveBand.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkDownloadLinkRate() {
		if (ckbx_downloadLinkRate.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkCommunicationInterface() {
		if (ckbx_communicationInterface.isSelected()) {
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
	
	public static boolean checkPosition() {
		if (ckbx_position.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkSpatialFrame() {
		if (ckbx_spatialReference.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkTemporalFrame() {
		if (ckbx_temperalReference.isSelected()) {
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
	
	
	/**
	 * Create the application.
	 */
	public RemoteSensorPlatformFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(RemoteSensorPlatformFrame.class.getResource("/sm/images/卫星平台.png")));
		frame.setTitle("卫星平台建模");
		frame.setBounds(400,100,850, 780);
		frame.setResizable(false);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		save = new JButton("保存");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveIsClicked = true;
				if (savePageIsClicled==true) {
					CreateRemoteSensorPlatformXML.SaveXML();
				}else if(savePageIsClicled==false){
					tipsDialog saveTip = new tipsDialog("请先对模型进行“保存编辑”操作！");
					saveTip.setLocationRelativeTo(frame);
					saveTip.setVisible(true);
				}
			}
		});
		save.setIcon(new ImageIcon(RemoteSensorPlatformFrame.class.getResource("/sm/images/save.jpg")));
		toolBar.add(save);
		
//		clear = new JButton("清空");
//		clear.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		clear.setIcon(new ImageIcon(RemoteSensorPlatformFrame.class.getResource("/sm/images/clear.jpg")));
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
		toolBar.add(view);
		
		documents = new JButton("附件");
		documents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UploadFrame fr = new UploadFrame();
				fr.setLocationRelativeTo(frame);
			}
		});
		documents.setIcon(new ImageIcon(RemoteSensorPlatformFrame.class.getResource("/sm/images/annex.jpg")));
		toolBar.add(documents);
		
		tp_content = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tp_content, BorderLayout.CENTER);
		
		p_description = new JPanel();
		tp_content.addTab("平台标识信息", null, p_description, null);
		GridBagLayout gbl_p_description = new GridBagLayout();
		gbl_p_description.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_p_description.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 34, 0, 0, 0, 35, 0, 0, 0, 0};
		gbl_p_description.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_p_description.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		p_description.setLayout(gbl_p_description);
		
		JLabel lb_description = new JLabel("卫星平台描述：");
		lb_description.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_description = new GridBagConstraints();
		gbc_lb_description.insets = new Insets(15, 10, 5, 5);
		gbc_lb_description.gridx = 0;
		gbc_lb_description.gridy = 0;
		p_description.add(lb_description, gbc_lb_description);
		
		JLabel lb_keywords = new JLabel("卫星发现关键词：");
		lb_keywords.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_keywords = new GridBagConstraints();
		gbc_lb_keywords.insets = new Insets(15, 10, 5, 5);
		gbc_lb_keywords.gridx = 5;
		gbc_lb_keywords.gridy = 0;
		p_description.add(lb_keywords, gbc_lb_keywords);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 10, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		p_description.add(scrollPane, gbc_scrollPane);
		
		ta_description = new JTextArea();
		scrollPane.setViewportView(ta_description);
		
		tf_keyword = new JTextField();
		hintText hintKeyword = new hintText(tf_keyword, "遥感/卫星中英文简称/搭载传感器等");
		tf_keyword.addFocusListener(new JTextFieldHintListener("遥感/卫星中英文简称/搭载传感器等", tf_keyword));
		tf_keyword.setColumns(10);
		GridBagConstraints gbc_tf_keyword = new GridBagConstraints();
		gbc_tf_keyword.insets = new Insets(0, 0, 5, 5);
		gbc_tf_keyword.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_keyword.gridx = 5;
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
		gbc_bt_addKeyword.gridx = 6;
		gbc_bt_addKeyword.gridy = 1;
		p_description.add(bt_addKeyword, gbc_bt_addKeyword);
		
		scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridheight = 2;
		gbc_scrollPane_3.gridwidth = 3;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 10);
		gbc_scrollPane_3.gridx = 7;
		gbc_scrollPane_3.gridy = 1;
		p_description.add(scrollPane_3, gbc_scrollPane_3);
		
		ta_keyword = new JTextArea();
		scrollPane_3.setViewportView(ta_keyword);
		ta_keyword.setBackground(SystemColor.info);
		
		bt_clearKeyword = new JButton("清空");
		bt_clearKeyword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta_keyword.setText("");
			}
		});
		GridBagConstraints gbc_bt_clearKeyword = new GridBagConstraints();
		gbc_bt_clearKeyword.insets = new Insets(0, 0, 5, 5);
		gbc_bt_clearKeyword.gridx = 6;
		gbc_bt_clearKeyword.gridy = 2;
		p_description.add(bt_clearKeyword, gbc_bt_clearKeyword);
		
		JLabel lb_identifier = new JLabel("标识符");
		lb_identifier.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_identifier = new GridBagConstraints();
		gbc_lb_identifier.insets = new Insets(0, 0, 5, 5);
		gbc_lb_identifier.gridx = 0;
		gbc_lb_identifier.gridy = 3;
		p_description.add(lb_identifier, gbc_lb_identifier);
		
		JLabel lb_classifier = new JLabel("分类符");
		lb_classifier.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_classifier = new GridBagConstraints();
		gbc_lb_classifier.insets = new Insets(0, 0, 5, 5);
		gbc_lb_classifier.gridx = 5;
		gbc_lb_classifier.gridy = 3;
		p_description.add(lb_classifier, gbc_lb_classifier);
		
		ckbx_UId = new JCheckBox("唯一标识符：");
		ckbx_UId.setSelected(true);
		GridBagConstraints gbc_ckbx_UId = new GridBagConstraints();
		gbc_ckbx_UId.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_UId.gridx = 0;
		gbc_ckbx_UId.gridy = 4;
		p_description.add(ckbx_UId, gbc_ckbx_UId);
		
		tf_organizationID = new JTextField();
		hintText hintOrgID = new hintText(tf_organizationID, "请输入组织标识");
		tf_organizationID.addFocusListener(new JTextFieldHintListener("请输入组织标识", tf_organizationID));
		tf_organizationID.setColumns(10);
		GridBagConstraints gbc_tf_organizationID = new GridBagConstraints();
		gbc_tf_organizationID.gridwidth = 4;
		gbc_tf_organizationID.insets = new Insets(0, 0, 5, 5);
		gbc_tf_organizationID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_organizationID.gridx = 1;
		gbc_tf_organizationID.gridy = 4;
		p_description.add(tf_organizationID, gbc_tf_organizationID);
		
		ckbx_platType = new JCheckBox("平台类型:");
		ckbx_platType.setSelected(true);
		GridBagConstraints gbc_ckbx_platType = new GridBagConstraints();
		gbc_ckbx_platType.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_platType.gridx = 5;
		gbc_ckbx_platType.gridy = 4;
		p_description.add(ckbx_platType, gbc_ckbx_platType);
		
		tf_platType = new JTextField();
		hintText hintPlatformType = new hintText(tf_platType, "遥感卫星平台");
		tf_platType.addFocusListener(new JTextFieldHintListener("遥感卫星平台", tf_platType));
		tf_platType.setColumns(10);
		GridBagConstraints gbc_tf_platType = new GridBagConstraints();
		gbc_tf_platType.gridwidth = 4;
		gbc_tf_platType.insets = new Insets(0, 0, 5, 10);
		gbc_tf_platType.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_platType.gridx = 6;
		gbc_tf_platType.gridy = 4;
		p_description.add(tf_platType, gbc_tf_platType);
		
		tf_platID = new JTextField();
		hintText hintPlatID = new hintText(tf_platID, "请输入卫星平台标识");
		tf_platID.addFocusListener(new JTextFieldHintListener("请输入卫星平台标识", tf_platID));
		tf_platID.setColumns(10);
		GridBagConstraints gbc_tf_platID = new GridBagConstraints();
		gbc_tf_platID.gridwidth = 4;
		gbc_tf_platID.insets = new Insets(0, 0, 5, 5);
		gbc_tf_platID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_platID.gridx = 1;
		gbc_tf_platID.gridy = 5;
		p_description.add(tf_platID, gbc_tf_platID);
		
		ckbx_sensorType = new JCheckBox("卫星类型:");
		ckbx_sensorType.setSelected(true);
		GridBagConstraints gbc_ckbx_sensorType = new GridBagConstraints();
		gbc_ckbx_sensorType.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_sensorType.gridx = 5;
		gbc_ckbx_sensorType.gridy = 5;
		p_description.add(ckbx_sensorType, gbc_ckbx_sensorType);
		
		tf_sensorType = new JTextField();
		hintText hintSensorType = new hintText(tf_sensorType, "陆地卫星/气象卫星/海洋卫星/导航卫星等");
		tf_sensorType.addFocusListener(new JTextFieldHintListener("陆地卫星/气象卫星/海洋卫星/导航卫星等", tf_sensorType));
		tf_sensorType.setColumns(10);
		GridBagConstraints gbc_tf_sensorType = new GridBagConstraints();
		gbc_tf_sensorType.gridwidth = 4;
		gbc_tf_sensorType.insets = new Insets(0, 0, 5, 10);
		gbc_tf_sensorType.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_sensorType.gridx = 6;
		gbc_tf_sensorType.gridy = 5;
		p_description.add(tf_sensorType, gbc_tf_sensorType);
		
		bt_UID = new JButton("生成");
		bt_UID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tf_organizationID.getText().equals("")&&!tf_platID.getText().equals("")&&
						(!tf_organizationID.getText().equals("请输入组织标识"))&&(!tf_platID.getText().equals("请输入卫星平台标识"))) {
					tf_UID.setText("urn:"+tf_organizationID.getText()+":def:identifier:OGC:2.0:"+tf_platID.getText());
				}
				else {
					tf_organizationID.setBorder(new LineBorder(Color.RED));
					tf_organizationID.setForeground(Color.RED);
					tf_organizationID.setText("请输入组织标识");
					tf_platID.setBorder(new LineBorder(Color.RED));
					tf_platID.setForeground(Color.RED);
					tf_platID.setText("请输入卫星平台标识");
				}
			}
		});
		GridBagConstraints gbc_bt_UID = new GridBagConstraints();
		gbc_bt_UID.insets = new Insets(0, 0, 5, 5);
		gbc_bt_UID.gridx = 0;
		gbc_bt_UID.gridy = 6;
		p_description.add(bt_UID, gbc_bt_UID);
		
		tf_UID = new JTextField();
		tf_UID.setColumns(10);
		GridBagConstraints gbc_tf_UID = new GridBagConstraints();
		gbc_tf_UID.gridwidth = 4;
		gbc_tf_UID.insets = new Insets(0, 0, 5, 5);
		gbc_tf_UID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_UID.gridx = 1;
		gbc_tf_UID.gridy = 6;
		p_description.add(tf_UID, gbc_tf_UID);
		
		ckbx_orbitType = new JCheckBox("轨道类型:");
		ckbx_orbitType.setSelected(true);
		GridBagConstraints gbc_ckbx_orbitType = new GridBagConstraints();
		gbc_ckbx_orbitType.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_orbitType.gridx = 5;
		gbc_ckbx_orbitType.gridy = 6;
		p_description.add(ckbx_orbitType, gbc_ckbx_orbitType);
		
		cbbx_orbitType = new JComboBox();
		cbbx_orbitType.setModel(new DefaultComboBoxModel(new String[] {"地球同步轨道", "太阳同步轨道", "其他轨道类型"}));
		GridBagConstraints gbc_cbbx_orbitType = new GridBagConstraints();
		gbc_cbbx_orbitType.gridwidth = 4;
		gbc_cbbx_orbitType.insets = new Insets(0, 0, 5, 10);
		gbc_cbbx_orbitType.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbx_orbitType.gridx = 6;
		gbc_cbbx_orbitType.gridy = 6;
		p_description.add(cbbx_orbitType, gbc_cbbx_orbitType);
		
		ckbx_longName = new JCheckBox("平台全称:");
		ckbx_longName.setSelected(true);
		GridBagConstraints gbc_ckbx_longName = new GridBagConstraints();
		gbc_ckbx_longName.anchor = GridBagConstraints.WEST;
		gbc_ckbx_longName.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_longName.gridx = 0;
		gbc_ckbx_longName.gridy = 7;
		p_description.add(ckbx_longName, gbc_ckbx_longName);
		
		tf_longName = new JTextField();
		tf_longName.setColumns(10);
		GridBagConstraints gbc_tf_longName = new GridBagConstraints();
		gbc_tf_longName.gridwidth = 4;
		gbc_tf_longName.insets = new Insets(0, 0, 5, 5);
		gbc_tf_longName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_longName.gridx = 1;
		gbc_tf_longName.gridy = 7;
		p_description.add(tf_longName, gbc_tf_longName);
		
		ckbx_application = new JCheckBox("预期应用:");
		ckbx_application.setSelected(true);
		GridBagConstraints gbc_ckbx_application = new GridBagConstraints();
		gbc_ckbx_application.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_application.gridx = 5;
		gbc_ckbx_application.gridy = 7;
		p_description.add(ckbx_application, gbc_ckbx_application);
		
		tf_application = new JTextField();
		hintText hintApplication = new hintText(tf_application, "对地观测成像/洪水观测等");
		tf_application.addFocusListener(new JTextFieldHintListener("对地观测成像/洪水观测等", tf_application));
		tf_application.setColumns(10);
		GridBagConstraints gbc_tf_application = new GridBagConstraints();
		gbc_tf_application.gridwidth = 2;
		gbc_tf_application.insets = new Insets(0, 0, 5, 5);
		gbc_tf_application.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_application.gridx = 6;
		gbc_tf_application.gridy = 7;
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
		gbc_bt_addApplication.gridx = 8;
		gbc_bt_addApplication.gridy = 7;
		p_description.add(bt_addApplication, gbc_bt_addApplication);
		
		bt_clearApplication = new JButton("清空");
		bt_clearApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta_application.setText("");
			}
		});
		GridBagConstraints gbc_bt_clearApplication = new GridBagConstraints();
		gbc_bt_clearApplication.insets = new Insets(0, 0, 5, 5);
		gbc_bt_clearApplication.gridx = 9;
		gbc_bt_clearApplication.gridy = 7;
		p_description.add(bt_clearApplication, gbc_bt_clearApplication);
		
		ckbx_shortName = new JCheckBox("平台简称:");
		ckbx_shortName.setSelected(true);
		GridBagConstraints gbc_ckbx_shortName = new GridBagConstraints();
		gbc_ckbx_shortName.anchor = GridBagConstraints.WEST;
		gbc_ckbx_shortName.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_shortName.gridx = 0;
		gbc_ckbx_shortName.gridy = 8;
		p_description.add(ckbx_shortName, gbc_ckbx_shortName);
		
		tf_shortName = new JTextField();
		tf_shortName.setColumns(10);
		GridBagConstraints gbc_tf_shortName = new GridBagConstraints();
		gbc_tf_shortName.gridwidth = 4;
		gbc_tf_shortName.insets = new Insets(0, 0, 5, 5);
		gbc_tf_shortName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_shortName.gridx = 1;
		gbc_tf_shortName.gridy = 8;
		p_description.add(tf_shortName, gbc_tf_shortName);
		
		scrollPane_4 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
		gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_4.gridheight = 3;
		gbc_scrollPane_4.gridwidth = 4;
		gbc_scrollPane_4.insets = new Insets(0, 0, 5, 10);
		gbc_scrollPane_4.gridx = 6;
		gbc_scrollPane_4.gridy = 8;
		p_description.add(scrollPane_4, gbc_scrollPane_4);
		
		ta_application = new JTextArea();
		scrollPane_4.setViewportView(ta_application);
		ta_application.setBackground(SystemColor.info);
		
		ckbx_associatedSensor = new JCheckBox("搭载传感器标识");
		ckbx_associatedSensor.setSelected(true);
		ckbx_associatedSensor.setHideActionText(true);
		GridBagConstraints gbc_ckbx_associatedSensor = new GridBagConstraints();
		gbc_ckbx_associatedSensor.anchor = GridBagConstraints.WEST;
		gbc_ckbx_associatedSensor.gridwidth = 3;
		gbc_ckbx_associatedSensor.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_associatedSensor.gridx = 0;
		gbc_ckbx_associatedSensor.gridy = 9;
		p_description.add(ckbx_associatedSensor, gbc_ckbx_associatedSensor);
		model_associatedSensor=new DefaultTableModel(new Object[][] {},new String[] {"传感器名称", "传感器标识符"});
		
		scrollPane_5 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_5 = new GridBagConstraints();
		gbc_scrollPane_5.gridheight = 2;
		gbc_scrollPane_5.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_5.gridwidth = 5;
		gbc_scrollPane_5.insets = new Insets(0, 10, 5, 5);
		gbc_scrollPane_5.gridx = 0;
		gbc_scrollPane_5.gridy = 10;
		p_description.add(scrollPane_5, gbc_scrollPane_5);
		
		tb_associatedSensor = new JTable();
		tb_associatedSensor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tb_associatedSensor.setBackground(new Color(176, 224, 230));
		scrollPane_5.setViewportView(tb_associatedSensor);
		tb_associatedSensor.setModel(model_associatedSensor);
		
		tf_associatedSensorName = new JTextField();
		hintText hintAssociatedSensorName = new hintText(tf_associatedSensorName, "如：HRG_SPOT5");
		tf_associatedSensorName.addFocusListener(new JTextFieldHintListener("HRG_SPOT5", tf_associatedSensorName));
		tf_associatedSensorName.setColumns(10);
		GridBagConstraints gbc_tf_associatedSensorName = new GridBagConstraints();
		gbc_tf_associatedSensorName.insets = new Insets(0, 10, 5, 5);
		gbc_tf_associatedSensorName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_associatedSensorName.gridx = 0;
		gbc_tf_associatedSensorName.gridy = 12;
		p_description.add(tf_associatedSensorName, gbc_tf_associatedSensorName);
		
		tf_associatedSensorID = new JTextField();
		hintText hintAssociatedSensorID = new hintText(tf_associatedSensorID, "如：HRG_SPOT5");
		tf_associatedSensorID.addFocusListener(new JTextFieldHintListener("HRG_SPOT5", tf_associatedSensorID));
		tf_associatedSensorID.setColumns(10);
		GridBagConstraints gbc_tf_associatedSensorID = new GridBagConstraints();
		gbc_tf_associatedSensorID.gridwidth = 2;
		gbc_tf_associatedSensorID.insets = new Insets(0, 0, 5, 5);
		gbc_tf_associatedSensorID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_associatedSensorID.gridx = 1;
		gbc_tf_associatedSensorID.gridy = 12;
		p_description.add(tf_associatedSensorID, gbc_tf_associatedSensorID);
		
		bt_addAssociatedSensor = new JButton("增加");
		bt_addAssociatedSensor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_associatedSensorName.getText(),"urn:ogc:feature:remoteSensor:"+tf_associatedSensorID.getText()};
				model_associatedSensor.addRow(info);
				tf_associatedSensorID.setText("");
				tf_associatedSensorName.setText("");
			}
		});
		GridBagConstraints gbc_bt_addAssociatedSensor = new GridBagConstraints();
		gbc_bt_addAssociatedSensor.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addAssociatedSensor.gridx = 3;
		gbc_bt_addAssociatedSensor.gridy = 12;
		p_description.add(bt_addAssociatedSensor, gbc_bt_addAssociatedSensor);
		
		bt_deleAssociatedSensor = new JButton("删除");
		bt_deleAssociatedSensor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_associatedSensor.getSelectedRow();
				if (selectedRow != -1) {
					model_associatedSensor.removeRow(selectedRow);
				}
			}
		});
		GridBagConstraints gbc_bt_deleAssociatedSensor = new GridBagConstraints();
		gbc_bt_deleAssociatedSensor.insets = new Insets(0, 0, 5, 5);
		gbc_bt_deleAssociatedSensor.gridx = 4;
		gbc_bt_deleAssociatedSensor.gridy = 12;
		p_description.add(bt_deleAssociatedSensor, gbc_bt_deleAssociatedSensor);
		
		ckbx_otherIdentifier = new JCheckBox("添加其它标识");
		ckbx_otherIdentifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_otherIdentifier.isSelected()) {
					tf_otherIdentifierName.setEditable(true);
					tf_otherIdentifierValue.setEditable(true);
					tf_otherIdentifierName.setBackground(white);
					tf_otherIdentifierValue.setBackground(white);
					bt_addOtherIdentifier.setEnabled(true);
					bt_deleOtherIdentifier.setEnabled(true);
				}else {
					tf_otherIdentifierName.setEditable(false);
					tf_otherIdentifierValue.setEditable(false);
					tf_otherIdentifierName.setBackground(Grey);
					tf_otherIdentifierValue.setBackground(Grey);
					bt_addOtherIdentifier.setEnabled(false);
					bt_deleOtherIdentifier.setEnabled(false);
					model_otherIdentifier.setRowCount(0);
				}	
			}
		});
		GridBagConstraints gbc_ckbx_otherIdentifier = new GridBagConstraints();
		gbc_ckbx_otherIdentifier.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_otherIdentifier.gridx = 0;
		gbc_ckbx_otherIdentifier.gridy = 13;
		p_description.add(ckbx_otherIdentifier, gbc_ckbx_otherIdentifier);
		model_otherClassifier = new DefaultTableModel(new Object[][] {},new String[] {"分类名称：", "分类内容："});
		
		ckbx_otherClassifier = new JCheckBox("添加其他分类");
		ckbx_otherClassifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_otherClassifier.isSelected()) {
					tf_otherClassifierName.setEditable(true);
					tf_otherClassifierValue.setEditable(true);
					tf_otherClassifierName.setBackground(white);
					tf_otherClassifierValue.setBackground(white);
					bt_addOtherClassifier.setEnabled(true);
					bt_deleOtherClassifier.setEnabled(true);
				}else {
					tf_otherClassifierName.setEditable(false);
					tf_otherClassifierValue.setEditable(false);
					tf_otherClassifierName.setBackground(Grey);
					tf_otherClassifierValue.setBackground(Grey);
					bt_addOtherClassifier.setEnabled(false);
					bt_deleOtherClassifier.setEnabled(false);
					model_otherClassifier.setRowCount(0);
				}
			}
		});
		GridBagConstraints gbc_ckbx_otherClassifier = new GridBagConstraints();
		gbc_ckbx_otherClassifier.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_otherClassifier.gridx = 5;
		gbc_ckbx_otherClassifier.gridy = 13;
		p_description.add(ckbx_otherClassifier, gbc_ckbx_otherClassifier);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 10);
		gbc_scrollPane_1.gridx = 5;
		gbc_scrollPane_1.gridy = 14;
		p_description.add(scrollPane_1, gbc_scrollPane_1);
		
		tb_otherClassifier = new JTable();
		scrollPane_1.setViewportView(tb_otherClassifier);
		tb_otherClassifier.setBackground(new Color(175, 238, 238));
		tb_otherClassifier.setModel(model_otherClassifier);
		model_otherIdentifier = new DefaultTableModel(new Object[][] {},new String[] {"标识名称：", "标识内容："});
		
		scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridheight = 2;
		gbc_scrollPane_2.gridwidth = 5;
		gbc_scrollPane_2.insets = new Insets(0, 10, 5, 5);
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 14;
		p_description.add(scrollPane_2, gbc_scrollPane_2);
		
		tb_otherIdentifier = new JTable();
		scrollPane_2.setViewportView(tb_otherIdentifier);
		tb_otherIdentifier.setBackground(new Color(175, 238, 238));
		tb_otherIdentifier.setModel(model_otherIdentifier);
		tb_otherIdentifier.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tf_otherIdentifierName = new JTextField();
		tf_otherIdentifierName.setEditable(false);
		tf_otherIdentifierName.setColumns(10);
		GridBagConstraints gbc_tf_otherIdentifierName = new GridBagConstraints();
		gbc_tf_otherIdentifierName.insets = new Insets(0, 10, 5, 5);
		gbc_tf_otherIdentifierName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherIdentifierName.gridx = 0;
		gbc_tf_otherIdentifierName.gridy = 16;
		p_description.add(tf_otherIdentifierName, gbc_tf_otherIdentifierName);
		
		tf_otherIdentifierValue = new JTextField();
		tf_otherIdentifierValue.setEditable(false);
		tf_otherIdentifierValue.setColumns(10);
		GridBagConstraints gbc_tf_otherIdentifierValue = new GridBagConstraints();
		gbc_tf_otherIdentifierValue.gridwidth = 2;
		gbc_tf_otherIdentifierValue.insets = new Insets(0, 0, 5, 5);
		gbc_tf_otherIdentifierValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherIdentifierValue.gridx = 1;
		gbc_tf_otherIdentifierValue.gridy = 16;
		p_description.add(tf_otherIdentifierValue, gbc_tf_otherIdentifierValue);
		
		bt_addOtherIdentifier = new JButton("增加");
		bt_addOtherIdentifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_otherIdentifierName.getText(),tf_otherIdentifierValue.getText()};
				model_otherIdentifier.addRow(info);
				tf_otherIdentifierName.setText("");
				tf_otherIdentifierValue.setText("");
			}
		});
		bt_addOtherIdentifier.setEnabled(false);
		GridBagConstraints gbc_bt_addOtherIdentifier = new GridBagConstraints();
		gbc_bt_addOtherIdentifier.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addOtherIdentifier.gridx = 3;
		gbc_bt_addOtherIdentifier.gridy = 16;
		p_description.add(bt_addOtherIdentifier, gbc_bt_addOtherIdentifier);
		
		bt_deleOtherIdentifier = new JButton("删除");
		bt_deleOtherIdentifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_otherIdentifier.getSelectedRow();
				if (selectedRow != -1) {
					model_otherIdentifier.removeRow(selectedRow);
				}
			}
		});
		bt_deleOtherIdentifier.setEnabled(false);
		GridBagConstraints gbc_bt_deleOtherIdentifier = new GridBagConstraints();
		gbc_bt_deleOtherIdentifier.insets = new Insets(0, 0, 5, 5);
		gbc_bt_deleOtherIdentifier.gridx = 4;
		gbc_bt_deleOtherIdentifier.gridy = 16;
		p_description.add(bt_deleOtherIdentifier, gbc_bt_deleOtherIdentifier);
		
		tf_otherClassifierName = new JTextField();
		tf_otherClassifierName.setEditable(false);
		tf_otherClassifierName.setColumns(10);
		GridBagConstraints gbc_tf_otherClassifierName = new GridBagConstraints();
		gbc_tf_otherClassifierName.insets = new Insets(0, 0, 5, 5);
		gbc_tf_otherClassifierName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherClassifierName.gridx = 5;
		gbc_tf_otherClassifierName.gridy = 16;
		p_description.add(tf_otherClassifierName, gbc_tf_otherClassifierName);
		
		tf_otherClassifierValue = new JTextField();
		tf_otherClassifierValue.setEditable(false);
		tf_otherClassifierValue.setColumns(10);
		GridBagConstraints gbc_tf_otherClassifierValue = new GridBagConstraints();
		gbc_tf_otherClassifierValue.gridwidth = 2;
		gbc_tf_otherClassifierValue.insets = new Insets(0, 0, 5, 5);
		gbc_tf_otherClassifierValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherClassifierValue.gridx = 6;
		gbc_tf_otherClassifierValue.gridy = 16;
		p_description.add(tf_otherClassifierValue, gbc_tf_otherClassifierValue);
		
		bt_addOtherClassifier = new JButton("增加");
		bt_addOtherClassifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_otherClassifierName.getText(),tf_otherClassifierValue.getText()};
				model_otherClassifier.addRow(info);
				tf_otherClassifierName.setText("");
				tf_otherClassifierValue.setText("");
			}
		});
		bt_addOtherClassifier.setEnabled(false);
		GridBagConstraints gbc_bt_addOtherClassifier = new GridBagConstraints();
		gbc_bt_addOtherClassifier.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addOtherClassifier.gridx = 8;
		gbc_bt_addOtherClassifier.gridy = 16;
		p_description.add(bt_addOtherClassifier, gbc_bt_addOtherClassifier);
		
		bt_deleOtherClassifier = new JButton("删除");
		bt_deleOtherClassifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_otherClassifier.getSelectedRow();
				if (selectedRow != -1) {
					model_otherClassifier.removeRow(selectedRow);
				}
			}
		});
		bt_deleOtherClassifier.setEnabled(false);
		GridBagConstraints gbc_bt_deleOtherClassifier = new GridBagConstraints();
		gbc_bt_deleOtherClassifier.insets = new Insets(0, 0, 5, 5);
		gbc_bt_deleOtherClassifier.gridx = 9;
		gbc_bt_deleOtherClassifier.gridy = 16;
		p_description.add(bt_deleOtherClassifier, gbc_bt_deleOtherClassifier);
		
		p_constraints = new JPanel();
		tp_content.addTab("约束条件信息", null, p_constraints, null);
		GridBagLayout gbl_p_constraints = new GridBagLayout();
		gbl_p_constraints.columnWidths = new int[]{0, 0, 0};
		gbl_p_constraints.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_p_constraints.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_p_constraints.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		p_constraints.setLayout(gbl_p_constraints);
		
		ckbx_validTM = new JCheckBox("有效时间");
		ckbx_validTM.setSelected(true);
		GridBagConstraints gbc_ckbx_validTM = new GridBagConstraints();
		gbc_ckbx_validTM.insets = new Insets(0, 20, 5, 5);
		gbc_ckbx_validTM.gridx = 0;
		gbc_ckbx_validTM.gridy = 0;
		p_constraints.add(ckbx_validTM, gbc_ckbx_validTM);
		
		JLabel lb_beginTM = new JLabel("起始时间:");
		GridBagConstraints gbc_lb_beginTM = new GridBagConstraints();
		gbc_lb_beginTM.anchor = GridBagConstraints.EAST;
		gbc_lb_beginTM.insets = new Insets(0, 20, 5, 5);
		gbc_lb_beginTM.gridx = 0;
		gbc_lb_beginTM.gridy = 1;
		p_constraints.add(lb_beginTM, gbc_lb_beginTM);
		
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
		p_constraints.add(cbbx_beginTM, gbc_cbbx_beginTM);
		
		tf_beginTM = new JTextField();
		hintText hintBeginTM = new hintText(tf_beginTM, "2018-01-01T08:00:00.0Z");
		tf_beginTM.addFocusListener(new JTextFieldHintListener("2018-01-01T08:00:00.0Z", tf_beginTM));
		tf_beginTM.setColumns(10);
		GridBagConstraints gbc_tf_beginTM = new GridBagConstraints();
		gbc_tf_beginTM.insets = new Insets(0, 0, 5, 30);
		gbc_tf_beginTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_beginTM.gridx = 1;
		gbc_tf_beginTM.gridy = 2;
		p_constraints.add(tf_beginTM, gbc_tf_beginTM);
		
		JLabel lb_endTM = new JLabel("结束时间:");
		GridBagConstraints gbc_lb_endTM = new GridBagConstraints();
		gbc_lb_endTM.anchor = GridBagConstraints.EAST;
		gbc_lb_endTM.insets = new Insets(0, 20, 5, 5);
		gbc_lb_endTM.gridx = 0;
		gbc_lb_endTM.gridy = 3;
		p_constraints.add(lb_endTM, gbc_lb_endTM);
		
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
		p_constraints.add(cbbx_endTM, gbc_cbbx_endTM);
		
		tf_endTM = new JTextField();
		hintText hintEndTM = new hintText(tf_endTM, "2028-01-01T08:00:00.0Z");
		tf_endTM.addFocusListener(new JTextFieldHintListener("2028-01-01T08:00:00.0Z", tf_endTM));
		tf_endTM.setColumns(10);
		GridBagConstraints gbc_tf_endTM = new GridBagConstraints();
		gbc_tf_endTM.insets = new Insets(0, 0, 5, 30);
		gbc_tf_endTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_endTM.gridx = 1;
		gbc_tf_endTM.gridy = 4;
		p_constraints.add(tf_endTM, gbc_tf_endTM);
		
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
		p_constraints.add(ckbx_legalConstraint, gbc_ckbx_legalConstraint);
		
		scrollPane_6 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_6 = new GridBagConstraints();
		gbc_scrollPane_6.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_6.gridwidth = 2;
		gbc_scrollPane_6.insets = new Insets(0, 30, 5, 30);
		gbc_scrollPane_6.gridx = 0;
		gbc_scrollPane_6.gridy = 6;
		p_constraints.add(scrollPane_6, gbc_scrollPane_6);
		
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
		p_constraints.add(ckbx_securityConstraint, gbc_ckbx_securityConstraint);
		
		scrollPane_7 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_7 = new GridBagConstraints();
		gbc_scrollPane_7.insets = new Insets(0, 30, 5, 30);
		gbc_scrollPane_7.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_7.gridwidth = 2;
		gbc_scrollPane_7.gridx = 0;
		gbc_scrollPane_7.gridy = 8;
		p_constraints.add(scrollPane_7, gbc_scrollPane_7);
		
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
		
		p_characteristic = new JPanel();
		tp_capa.addTab("     平台物理特征     ", null, p_characteristic, null);
		GridBagLayout gbl_p_characteristic = new GridBagLayout();
		gbl_p_characteristic.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_p_characteristic.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_p_characteristic.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_p_characteristic.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		p_characteristic.setLayout(gbl_p_characteristic);
		
		JLabel lb_physicalCharacter = new JLabel(" 平台物理特征");
		lb_physicalCharacter.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_physicalCharacter = new GridBagConstraints();
		gbc_lb_physicalCharacter.insets = new Insets(5, 5, 5, 5);
		gbc_lb_physicalCharacter.gridx = 0;
		gbc_lb_physicalCharacter.gridy = 0;
		p_characteristic.add(lb_physicalCharacter, gbc_lb_physicalCharacter);
		
		JLabel lb_workEnviroment = new JLabel("工作环境");
		lb_workEnviroment.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_workEnviroment = new GridBagConstraints();
		gbc_lb_workEnviroment.insets = new Insets(0, 0, 5, 5);
		gbc_lb_workEnviroment.gridx = 4;
		gbc_lb_workEnviroment.gridy = 0;
		p_characteristic.add(lb_workEnviroment, gbc_lb_workEnviroment);
		
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
		p_characteristic.add(ckbx_length, gbc_ckbx_length);
		
		tf_length = new JTextField();
		tf_length.setEditable(false);
		tf_length.setColumns(10);
		GridBagConstraints gbc_tf_length = new GridBagConstraints();
		gbc_tf_length.gridwidth = 3;
		gbc_tf_length.insets = new Insets(0, 0, 5, 5);
		gbc_tf_length.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_length.gridx = 1;
		gbc_tf_length.gridy = 1;
		p_characteristic.add(tf_length, gbc_tf_length);
		
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
		p_characteristic.add(ckbx_life, gbc_ckbx_life);
		
		tf_life = new JTextField();
		tf_life.setEditable(false);
		tf_life.setColumns(10);
		GridBagConstraints gbc_tf_life = new GridBagConstraints();
		gbc_tf_life.gridwidth = 3;
		gbc_tf_life.insets = new Insets(0, 0, 5, 0);
		gbc_tf_life.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_life.gridx = 5;
		gbc_tf_life.gridy = 1;
		p_characteristic.add(tf_life, gbc_tf_life);
		
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
		p_characteristic.add(ckbx_width, gbc_ckbx_width);
		
		tf_width = new JTextField();
		tf_width.setEditable(false);
		tf_width.setColumns(10);
		GridBagConstraints gbc_tf_width = new GridBagConstraints();
		gbc_tf_width.gridwidth = 3;
		gbc_tf_width.insets = new Insets(0, 0, 5, 5);
		gbc_tf_width.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_width.gridx = 1;
		gbc_tf_width.gridy = 2;
		p_characteristic.add(tf_width, gbc_tf_width);
		
		ckbx_load = new JCheckBox("有效载荷(kg):");
		ckbx_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_load.isSelected()) {
					tf_load.setEditable(true);
					tf_load.setBackground(white);
				}else {
					tf_load.setEditable(false);
					tf_load.setBackground(Grey);
					tf_load.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_load = new GridBagConstraints();
		gbc_ckbx_load.anchor = GridBagConstraints.WEST;
		gbc_ckbx_load.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_load.gridx = 4;
		gbc_ckbx_load.gridy = 2;
		p_characteristic.add(ckbx_load, gbc_ckbx_load);
		
		tf_load = new JTextField();
		tf_load.setEditable(false);
		tf_load.setColumns(10);
		GridBagConstraints gbc_tf_load = new GridBagConstraints();
		gbc_tf_load.gridwidth = 3;
		gbc_tf_load.insets = new Insets(0, 0, 5, 0);
		gbc_tf_load.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_load.gridx = 5;
		gbc_tf_load.gridy = 2;
		p_characteristic.add(tf_load, gbc_tf_load);
		
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
		p_characteristic.add(ckbx_height, gbc_ckbx_height);
		
		tf_height = new JTextField();
		tf_height.setEditable(false);
		tf_height.setColumns(10);
		GridBagConstraints gbc_tf_height = new GridBagConstraints();
		gbc_tf_height.gridwidth = 3;
		gbc_tf_height.insets = new Insets(0, 0, 5, 5);
		gbc_tf_height.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_height.gridx = 1;
		gbc_tf_height.gridy = 3;
		p_characteristic.add(tf_height, gbc_tf_height);
		
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
		p_characteristic.add(ckbx_weight, gbc_ckbx_weight);
		
		tf_weight = new JTextField();
		tf_weight.setEditable(false);
		tf_weight.setColumns(10);
		GridBagConstraints gbc_tf_weight = new GridBagConstraints();
		gbc_tf_weight.gridwidth = 3;
		gbc_tf_weight.insets = new Insets(0, 0, 5, 5);
		gbc_tf_weight.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_weight.gridx = 1;
		gbc_tf_weight.gridy = 4;
		p_characteristic.add(tf_weight, gbc_tf_weight);
		
		JLabel lb_electrical = new JLabel("  供电通信特征");
		lb_electrical.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_electrical = new GridBagConstraints();
		gbc_lb_electrical.insets = new Insets(0, 0, 5, 5);
		gbc_lb_electrical.gridx = 0;
		gbc_lb_electrical.gridy = 6;
		p_characteristic.add(lb_electrical, gbc_lb_electrical);
		
		ckbx_otherCharacter = new JCheckBox("添加其他特征:");
		GridBagConstraints gbc_ckbx_otherCharacter = new GridBagConstraints();
		gbc_ckbx_otherCharacter.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_otherCharacter.gridx = 4;
		gbc_ckbx_otherCharacter.gridy = 6;
		p_characteristic.add(ckbx_otherCharacter, gbc_ckbx_otherCharacter);
		
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
		p_characteristic.add(ckbx_current, gbc_ckbx_current);
		
		tf_minCurrent = new JTextField();
		tf_minCurrent.setEditable(false);
		tf_minCurrent.setColumns(10);
		GridBagConstraints gbc_tf_minCurrent = new GridBagConstraints();
		gbc_tf_minCurrent.insets = new Insets(0, 0, 5, 5);
		gbc_tf_minCurrent.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_minCurrent.gridx = 1;
		gbc_tf_minCurrent.gridy = 7;
		p_characteristic.add(tf_minCurrent, gbc_tf_minCurrent);
		
		lb_line1 = new JLabel("—");
		GridBagConstraints gbc_lb_line1 = new GridBagConstraints();
		gbc_lb_line1.insets = new Insets(0, 0, 5, 5);
		gbc_lb_line1.anchor = GridBagConstraints.EAST;
		gbc_lb_line1.gridx = 2;
		gbc_lb_line1.gridy = 7;
		p_characteristic.add(lb_line1, gbc_lb_line1);
		
		tf_maxCurrent = new JTextField();
		tf_maxCurrent.setEditable(false);
		tf_maxCurrent.setColumns(10);
		GridBagConstraints gbc_tf_maxCurrent = new GridBagConstraints();
		gbc_tf_maxCurrent.insets = new Insets(0, 0, 5, 5);
		gbc_tf_maxCurrent.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_maxCurrent.gridx = 3;
		gbc_tf_maxCurrent.gridy = 7;
		p_characteristic.add(tf_maxCurrent, gbc_tf_maxCurrent);
		
		scrollPane_8 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_8 = new GridBagConstraints();
		gbc_scrollPane_8.gridheight = 3;
		gbc_scrollPane_8.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_8.gridwidth = 4;
		gbc_scrollPane_8.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_8.gridx = 4;
		gbc_scrollPane_8.gridy = 7;
		p_characteristic.add(scrollPane_8, gbc_scrollPane_8);
		
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
		p_characteristic.add(ckbx_voltage, gbc_ckbx_voltage);
		
		tf_minVoltage = new JTextField();
		tf_minVoltage.setEditable(false);
		tf_minVoltage.setColumns(10);
		GridBagConstraints gbc_tf_minVoltage = new GridBagConstraints();
		gbc_tf_minVoltage.insets = new Insets(0, 0, 5, 5);
		gbc_tf_minVoltage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_minVoltage.gridx = 1;
		gbc_tf_minVoltage.gridy = 8;
		p_characteristic.add(tf_minVoltage, gbc_tf_minVoltage);
		
		lb_line2 = new JLabel("—");
		GridBagConstraints gbc_lb_line2 = new GridBagConstraints();
		gbc_lb_line2.insets = new Insets(0, 0, 5, 5);
		gbc_lb_line2.anchor = GridBagConstraints.EAST;
		gbc_lb_line2.gridx = 2;
		gbc_lb_line2.gridy = 8;
		p_characteristic.add(lb_line2, gbc_lb_line2);
		
		tf_maxVoltage = new JTextField();
		tf_maxVoltage.setEditable(false);
		tf_maxVoltage.setColumns(10);
		GridBagConstraints gbc_tf_maxVoltage = new GridBagConstraints();
		gbc_tf_maxVoltage.insets = new Insets(0, 0, 5, 5);
		gbc_tf_maxVoltage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_maxVoltage.gridx = 3;
		gbc_tf_maxVoltage.gridy = 8;
		p_characteristic.add(tf_maxVoltage, gbc_tf_maxVoltage);
		
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
		p_characteristic.add(ckbx_power, gbc_ckbx_power);
		
		tf_power = new JTextField();
		tf_power.setEditable(false);
		tf_power.setColumns(10);
		GridBagConstraints gbc_tf_power = new GridBagConstraints();
		gbc_tf_power.gridwidth = 3;
		gbc_tf_power.insets = new Insets(0, 0, 5, 5);
		gbc_tf_power.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_power.gridx = 1;
		gbc_tf_power.gridy = 9;
		p_characteristic.add(tf_power, gbc_tf_power);
		
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
		p_characteristic.add(ckbx_outputPower, gbc_ckbx_outputPower);
		
		tf_outputPower = new JTextField();
		tf_outputPower.setEditable(false);
		tf_outputPower.setColumns(10);
		GridBagConstraints gbc_tf_outputPower = new GridBagConstraints();
		gbc_tf_outputPower.gridwidth = 3;
		gbc_tf_outputPower.insets = new Insets(0, 0, 5, 5);
		gbc_tf_outputPower.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_outputPower.gridx = 1;
		gbc_tf_outputPower.gridy = 10;
		p_characteristic.add(tf_outputPower, gbc_tf_outputPower);
		
		tf_otherCharacterName = new JTextField();
		tf_otherCharacterName.setEditable(false);
		tf_otherCharacterName.setColumns(10);
		GridBagConstraints gbc_tf_otherCharacterName = new GridBagConstraints();
		gbc_tf_otherCharacterName.insets = new Insets(0, 0, 5, 5);
		gbc_tf_otherCharacterName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherCharacterName.gridx = 4;
		gbc_tf_otherCharacterName.gridy = 10;
		p_characteristic.add(tf_otherCharacterName, gbc_tf_otherCharacterName);
		
		tf_otherCharacterValue = new JTextField();
		tf_otherCharacterValue.setEditable(false);
		tf_otherCharacterValue.setColumns(10);
		GridBagConstraints gbc_tf_otherCharacterValue = new GridBagConstraints();
		gbc_tf_otherCharacterValue.insets = new Insets(0, 0, 5, 5);
		gbc_tf_otherCharacterValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherCharacterValue.gridx = 5;
		gbc_tf_otherCharacterValue.gridy = 10;
		p_characteristic.add(tf_otherCharacterValue, gbc_tf_otherCharacterValue);
		
		bt_addOtherCharacter = new JButton("增加");
		bt_addOtherCharacter.setEnabled(false);
		bt_addOtherCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] otherCharacter = {tf_otherCharacterName.getText(),tf_otherCharacterValue.getText()};
				model_otherCharacter.addRow(otherCharacter);
			}
		});
		GridBagConstraints gbc_bt_addOtherCharacter = new GridBagConstraints();
		gbc_bt_addOtherCharacter.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addOtherCharacter.gridx = 6;
		gbc_bt_addOtherCharacter.gridy = 10;
		p_characteristic.add(bt_addOtherCharacter, gbc_bt_addOtherCharacter);
		
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
		gbc_bt_deleOtherCharacter.insets = new Insets(0, 0, 5, 0);
		gbc_bt_deleOtherCharacter.gridx = 7;
		gbc_bt_deleOtherCharacter.gridy = 10;
		p_characteristic.add(bt_deleOtherCharacter, gbc_bt_deleOtherCharacter);
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
		tp_capa.addTab("     平台观测能力     ", null, p_capabilities, null);
		GridBagLayout gbl_p_capabilities = new GridBagLayout();
		gbl_p_capabilities.columnWidths = new int[]{0, 35, 35, 0, 36, 0, 0, 45, 0, 0, 0};
		gbl_p_capabilities.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_p_capabilities.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_p_capabilities.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		p_capabilities.setLayout(gbl_p_capabilities);
		
		JLabel lb_positionCapability = new JLabel("平台定位能力");
		lb_positionCapability.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_positionCapability = new GridBagConstraints();
		gbc_lb_positionCapability.gridwidth = 2;
		gbc_lb_positionCapability.anchor = GridBagConstraints.EAST;
		gbc_lb_positionCapability.insets = new Insets(5, 5, 5, 5);
		gbc_lb_positionCapability.gridx = 0;
		gbc_lb_positionCapability.gridy = 0;
		p_capabilities.add(lb_positionCapability, gbc_lb_positionCapability);
		
		JLabel lb_TLE = new JLabel("TLE卫星两行根数");
		lb_TLE.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_TLE = new GridBagConstraints();
		gbc_lb_TLE.gridwidth = 2;
		gbc_lb_TLE.insets = new Insets(0, 0, 5, 5);
		gbc_lb_TLE.gridx = 5;
		gbc_lb_TLE.gridy = 0;
		p_capabilities.add(lb_TLE, gbc_lb_TLE);
		
		ckbx_epochTM = new JCheckBox("发射时间:");
		ckbx_epochTM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_epochTM.isSelected()) {
					tf_epochTM.setEditable(true);
					tf_epochTM.setBackground(white);
				}else {
					tf_epochTM.setEditable(false);
					tf_epochTM.setBackground(Grey);
					tf_epochTM.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_epochTM = new GridBagConstraints();
		gbc_ckbx_epochTM.anchor = GridBagConstraints.WEST;
		gbc_ckbx_epochTM.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_epochTM.gridx = 0;
		gbc_ckbx_epochTM.gridy = 1;
		p_capabilities.add(ckbx_epochTM, gbc_ckbx_epochTM);
		
		tf_epochTM = new JTextField();
		hintText hintEpochTM = new hintText(tf_epochTM, "2002-05-04");
		tf_epochTM.addFocusListener(new JTextFieldHintListener("2002-05-04", tf_epochTM));
		tf_epochTM.setEditable(false);
		tf_epochTM.setColumns(10);
		GridBagConstraints gbc_tf_epochTM = new GridBagConstraints();
		gbc_tf_epochTM.gridwidth = 4;
		gbc_tf_epochTM.insets = new Insets(0, 0, 5, 5);
		gbc_tf_epochTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_epochTM.gridx = 1;
		gbc_tf_epochTM.gridy = 1;
		p_capabilities.add(tf_epochTM, gbc_tf_epochTM);
		
		ckbx_Tle = new JCheckBox("TLE卫星标识码:");
		ckbx_Tle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_Tle.isSelected()) {
					tf_TLESatID.setEditable(true);
					tf_TLESatID.setBackground(white);
				}else {
					tf_TLESatID.setEditable(false);
					tf_TLESatID.setBackground(Grey);
					tf_TLESatID.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_Tle = new GridBagConstraints();
		gbc_ckbx_Tle.gridwidth = 2;
		gbc_ckbx_Tle.anchor = GridBagConstraints.WEST;
		gbc_ckbx_Tle.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_Tle.gridx = 5;
		gbc_ckbx_Tle.gridy = 1;
		p_capabilities.add(ckbx_Tle, gbc_ckbx_Tle);
		
		tf_TLESatID = new JTextField();
		hintText hintTLE = new hintText(tf_TLESatID, "TLE标准卫星名称");
		tf_TLESatID.addFocusListener(new JTextFieldHintListener("TLE标准卫星名称", tf_TLESatID));
		tf_TLESatID.setEditable(false);
		tf_TLESatID.setColumns(10);
		GridBagConstraints gbc_tf_TLESatID = new GridBagConstraints();
		gbc_tf_TLESatID.gridwidth = 3;
		gbc_tf_TLESatID.insets = new Insets(0, 0, 5, 10);
		gbc_tf_TLESatID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_TLESatID.gridx = 7;
		gbc_tf_TLESatID.gridy = 1;
		p_capabilities.add(tf_TLESatID, gbc_tf_TLESatID);
		
		ckbx_orbitHeight = new JCheckBox("轨道高度(km):");
		ckbx_orbitHeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_orbitHeight.isSelected()) {
					tf_orbitHeight.setEditable(true);
					tf_orbitHeight.setBackground(white);
				}else {
					tf_orbitHeight.setEditable(false);
					tf_orbitHeight.setBackground(Grey);
					tf_orbitHeight.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_orbitHeight = new GridBagConstraints();
		gbc_ckbx_orbitHeight.anchor = GridBagConstraints.WEST;
		gbc_ckbx_orbitHeight.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_orbitHeight.gridx = 0;
		gbc_ckbx_orbitHeight.gridy = 2;
		p_capabilities.add(ckbx_orbitHeight, gbc_ckbx_orbitHeight);
		
		tf_orbitHeight = new JTextField();
		tf_orbitHeight.setEditable(false);
		tf_orbitHeight.setColumns(10);
		GridBagConstraints gbc_tf_orbitHeight = new GridBagConstraints();
		gbc_tf_orbitHeight.gridwidth = 4;
		gbc_tf_orbitHeight.insets = new Insets(0, 0, 5, 5);
		gbc_tf_orbitHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_orbitHeight.gridx = 1;
		gbc_tf_orbitHeight.gridy = 2;
		p_capabilities.add(tf_orbitHeight, gbc_tf_orbitHeight);
		
		ckbx_TLE1 = new JCheckBox("TLE轨道参数1:");
		ckbx_TLE1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_TLE1.isSelected()) {
					tf_TLELineOne.setEditable(true);
					tf_TLELineOne.setBackground(white);
				}else {
					tf_TLELineOne.setEditable(false);
					tf_TLELineOne.setBackground(Grey);
					tf_TLELineOne.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_TLE1 = new GridBagConstraints();
		gbc_ckbx_TLE1.gridwidth = 2;
		gbc_ckbx_TLE1.anchor = GridBagConstraints.WEST;
		gbc_ckbx_TLE1.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_TLE1.gridx = 5;
		gbc_ckbx_TLE1.gridy = 2;
		p_capabilities.add(ckbx_TLE1, gbc_ckbx_TLE1);
		
		tf_TLELineOne = new JTextField();
		tf_TLELineOne.setEditable(false);
		tf_TLELineOne.setColumns(10);
		GridBagConstraints gbc_tf_TLELineOne = new GridBagConstraints();
		gbc_tf_TLELineOne.gridwidth = 3;
		gbc_tf_TLELineOne.insets = new Insets(0, 0, 5, 10);
		gbc_tf_TLELineOne.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_TLELineOne.gridx = 7;
		gbc_tf_TLELineOne.gridy = 2;
		p_capabilities.add(tf_TLELineOne, gbc_tf_TLELineOne);
		
		ckbx_orbitCycle = new JCheckBox("轨道周期(min):");
		ckbx_orbitCycle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_orbitCycle.isSelected()) {
					tf_orbitCycle.setEditable(true);
					tf_orbitCycle.setBackground(white);
				}else {
					tf_orbitCycle.setEditable(false);
					tf_orbitCycle.setBackground(Grey);
					tf_orbitCycle.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_orbitCycle = new GridBagConstraints();
		gbc_ckbx_orbitCycle.anchor = GridBagConstraints.WEST;
		gbc_ckbx_orbitCycle.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_orbitCycle.gridx = 0;
		gbc_ckbx_orbitCycle.gridy = 3;
		p_capabilities.add(ckbx_orbitCycle, gbc_ckbx_orbitCycle);
		
		tf_orbitCycle = new JTextField();
		tf_orbitCycle.setEditable(false);
		tf_orbitCycle.setColumns(10);
		GridBagConstraints gbc_tf_orbitCycle = new GridBagConstraints();
		gbc_tf_orbitCycle.gridwidth = 4;
		gbc_tf_orbitCycle.insets = new Insets(0, 0, 5, 5);
		gbc_tf_orbitCycle.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_orbitCycle.gridx = 1;
		gbc_tf_orbitCycle.gridy = 3;
		p_capabilities.add(tf_orbitCycle, gbc_tf_orbitCycle);
		
		ckbx_TLE2 = new JCheckBox("TLE轨道参数2:");
		ckbx_TLE2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_TLE2.isSelected()) {
					tf_TLELineTwo.setEditable(true);
					tf_TLELineTwo.setBackground(white);
				}else {
					tf_TLELineTwo.setEditable(false);
					tf_TLELineTwo.setBackground(Grey);
					tf_TLELineTwo.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_TLE2 = new GridBagConstraints();
		gbc_ckbx_TLE2.gridwidth = 2;
		gbc_ckbx_TLE2.anchor = GridBagConstraints.WEST;
		gbc_ckbx_TLE2.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_TLE2.gridx = 5;
		gbc_ckbx_TLE2.gridy = 3;
		p_capabilities.add(ckbx_TLE2, gbc_ckbx_TLE2);
		
		tf_TLELineTwo = new JTextField();
		tf_TLELineTwo.setEditable(false);
		tf_TLELineTwo.setColumns(10);
		GridBagConstraints gbc_tf_TLELineTwo = new GridBagConstraints();
		gbc_tf_TLELineTwo.gridwidth = 3;
		gbc_tf_TLELineTwo.insets = new Insets(0, 0, 5, 10);
		gbc_tf_TLELineTwo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_TLELineTwo.gridx = 7;
		gbc_tf_TLELineTwo.gridy = 3;
		p_capabilities.add(tf_TLELineTwo, gbc_tf_TLELineTwo);
		
		ckbx_revisitingPeriod = new JCheckBox("重访周期(d):");
		ckbx_revisitingPeriod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_revisitingPeriod.isSelected()) {
					tf_revisitingPeriod.setEditable(true);
					tf_revisitingPeriod.setBackground(white);
				}else {
					tf_revisitingPeriod.setEditable(false);
					tf_revisitingPeriod.setBackground(Grey);
					tf_revisitingPeriod.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_revisitingPeriod = new GridBagConstraints();
		gbc_ckbx_revisitingPeriod.anchor = GridBagConstraints.WEST;
		gbc_ckbx_revisitingPeriod.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_revisitingPeriod.gridx = 0;
		gbc_ckbx_revisitingPeriod.gridy = 4;
		p_capabilities.add(ckbx_revisitingPeriod, gbc_ckbx_revisitingPeriod);
		
		tf_revisitingPeriod = new JTextField();
		tf_revisitingPeriod.setEditable(false);
		tf_revisitingPeriod.setColumns(10);
		GridBagConstraints gbc_tf_revisitingPeriod = new GridBagConstraints();
		gbc_tf_revisitingPeriod.gridwidth = 4;
		gbc_tf_revisitingPeriod.insets = new Insets(0, 0, 5, 5);
		gbc_tf_revisitingPeriod.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_revisitingPeriod.gridx = 1;
		gbc_tf_revisitingPeriod.gridy = 4;
		p_capabilities.add(tf_revisitingPeriod, gbc_tf_revisitingPeriod);
		
		JLabel lb_computingCapability = new JLabel("平台计算能力");
		lb_computingCapability.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_computingCapability = new GridBagConstraints();
		gbc_lb_computingCapability.gridwidth = 2;
		gbc_lb_computingCapability.insets = new Insets(0, 0, 5, 5);
		gbc_lb_computingCapability.gridx = 5;
		gbc_lb_computingCapability.gridy = 4;
		p_capabilities.add(lb_computingCapability, gbc_lb_computingCapability);
		
		ckbx_orbitInclination = new JCheckBox("轨道倾角(deg):");
		ckbx_orbitInclination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_orbitInclination.isSelected()) {
					tf_orbitInclination.setEditable(true);
					tf_orbitInclination.setBackground(white);
				}else {
					tf_orbitInclination.setEditable(false);
					tf_orbitInclination.setBackground(Grey);
					tf_orbitInclination.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_orbitInclination = new GridBagConstraints();
		gbc_ckbx_orbitInclination.anchor = GridBagConstraints.WEST;
		gbc_ckbx_orbitInclination.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_orbitInclination.gridx = 0;
		gbc_ckbx_orbitInclination.gridy = 5;
		p_capabilities.add(ckbx_orbitInclination, gbc_ckbx_orbitInclination);
		
		tf_orbitInclination = new JTextField();
		tf_orbitInclination.setEditable(false);
		tf_orbitInclination.setColumns(10);
		GridBagConstraints gbc_tf_orbitInclination = new GridBagConstraints();
		gbc_tf_orbitInclination.gridwidth = 4;
		gbc_tf_orbitInclination.insets = new Insets(0, 0, 5, 5);
		gbc_tf_orbitInclination.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_orbitInclination.gridx = 1;
		gbc_tf_orbitInclination.gridy = 5;
		p_capabilities.add(tf_orbitInclination, gbc_tf_orbitInclination);
		
		ckbx_storage = new JCheckBox("存储容量(GB):");
		ckbx_storage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_storage.isSelected()) {
					tf_storage.setEditable(true);
					tf_storage.setBackground(white);
				}else {
					tf_storage.setEditable(false);
					tf_storage.setBackground(Grey);
					tf_storage.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_storage = new GridBagConstraints();
		gbc_ckbx_storage.gridwidth = 2;
		gbc_ckbx_storage.anchor = GridBagConstraints.WEST;
		gbc_ckbx_storage.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_storage.gridx = 5;
		gbc_ckbx_storage.gridy = 5;
		p_capabilities.add(ckbx_storage, gbc_ckbx_storage);
		
		tf_storage = new JTextField();
		tf_storage.setEditable(false);
		tf_storage.setColumns(10);
		GridBagConstraints gbc_tf_storage = new GridBagConstraints();
		gbc_tf_storage.gridwidth = 3;
		gbc_tf_storage.insets = new Insets(0, 0, 5, 10);
		gbc_tf_storage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_storage.gridx = 7;
		gbc_tf_storage.gridy = 5;
		p_capabilities.add(tf_storage, gbc_tf_storage);
		
		ckbx_descendinNode = new JCheckBox("降交点地方时:");
		ckbx_descendinNode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_descendinNode.isSelected()) {
					tf_descendingNode.setEditable(true);
					tf_descendingNode.setBackground(white);
				}else {
					tf_descendingNode.setEditable(false);
					tf_descendingNode.setBackground(Grey);
					tf_descendingNode.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_descendinNode = new GridBagConstraints();
		gbc_ckbx_descendinNode.anchor = GridBagConstraints.WEST;
		gbc_ckbx_descendinNode.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_descendinNode.gridx = 0;
		gbc_ckbx_descendinNode.gridy = 6;
		p_capabilities.add(ckbx_descendinNode, gbc_ckbx_descendinNode);
		
		tf_descendingNode = new JTextField();
		hintText hintDescendingNode = new hintText(tf_descendingNode, "8:00AM");
		tf_descendingNode.addFocusListener(new JTextFieldHintListener("2002-05-04", tf_descendingNode));
		tf_descendingNode.setEditable(false);
		tf_descendingNode.setColumns(10);
		GridBagConstraints gbc_tf_descendingNode = new GridBagConstraints();
		gbc_tf_descendingNode.gridwidth = 4;
		gbc_tf_descendingNode.insets = new Insets(0, 0, 5, 5);
		gbc_tf_descendingNode.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_descendingNode.gridx = 1;
		gbc_tf_descendingNode.gridy = 6;
		p_capabilities.add(tf_descendingNode, gbc_tf_descendingNode);
		
		ckbx_dataRate = new JCheckBox("数据速率(Mbps):");
		ckbx_dataRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_dataRate.isSelected()) {
					tf_dataRate.setEditable(true);
					tf_dataRate.setBackground(white);
				}else {
					tf_dataRate.setEditable(false);
					tf_dataRate.setBackground(Grey);
					tf_dataRate.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_dataRate = new GridBagConstraints();
		gbc_ckbx_dataRate.gridwidth = 2;
		gbc_ckbx_dataRate.anchor = GridBagConstraints.WEST;
		gbc_ckbx_dataRate.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_dataRate.gridx = 5;
		gbc_ckbx_dataRate.gridy = 6;
		p_capabilities.add(ckbx_dataRate, gbc_ckbx_dataRate);
		
		tf_dataRate = new JTextField();
		tf_dataRate.setEditable(false);
		tf_dataRate.setColumns(10);
		GridBagConstraints gbc_tf_dataRate = new GridBagConstraints();
		gbc_tf_dataRate.gridwidth = 3;
		gbc_tf_dataRate.insets = new Insets(0, 0, 5, 10);
		gbc_tf_dataRate.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_dataRate.gridx = 7;
		gbc_tf_dataRate.gridy = 6;
		p_capabilities.add(tf_dataRate, gbc_tf_dataRate);
		
		ckbx_orbitEccentricity = new JCheckBox("偏心率(%):");
		ckbx_orbitEccentricity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_orbitEccentricity.isSelected()) {
					tf_orbitEccentricity.setEditable(true);
					tf_orbitEccentricity.setBackground(white);
				}else {
					tf_orbitEccentricity.setEditable(false);
					tf_orbitEccentricity.setBackground(Grey);
					tf_orbitEccentricity.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_orbitEccentricity = new GridBagConstraints();
		gbc_ckbx_orbitEccentricity.anchor = GridBagConstraints.WEST;
		gbc_ckbx_orbitEccentricity.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_orbitEccentricity.gridx = 0;
		gbc_ckbx_orbitEccentricity.gridy = 7;
		p_capabilities.add(ckbx_orbitEccentricity, gbc_ckbx_orbitEccentricity);
		
		tf_orbitEccentricity = new JTextField();
		tf_orbitEccentricity.setEditable(false);
		tf_orbitEccentricity.setColumns(10);
		GridBagConstraints gbc_tf_orbitEccentricity = new GridBagConstraints();
		gbc_tf_orbitEccentricity.gridwidth = 4;
		gbc_tf_orbitEccentricity.insets = new Insets(0, 0, 5, 5);
		gbc_tf_orbitEccentricity.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_orbitEccentricity.gridx = 1;
		gbc_tf_orbitEccentricity.gridy = 7;
		p_capabilities.add(tf_orbitEccentricity, gbc_tf_orbitEccentricity);
		
		JLabel lb_communicationCapability = new JLabel("供电通信能力");
		lb_communicationCapability.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_communicationCapability = new GridBagConstraints();
		gbc_lb_communicationCapability.gridwidth = 2;
		gbc_lb_communicationCapability.insets = new Insets(0, 0, 5, 5);
		gbc_lb_communicationCapability.gridx = 5;
		gbc_lb_communicationCapability.gridy = 7;
		p_capabilities.add(lb_communicationCapability, gbc_lb_communicationCapability);
		
		ckbx_orbitRigthAscension = new JCheckBox("升交点赤经(deg):");
		ckbx_orbitRigthAscension.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_orbitRigthAscension.isSelected()) {
					tf_orbitRigthAscension.setEditable(true);
					tf_orbitRigthAscension.setBackground(white);
				}else {
					tf_orbitRigthAscension.setEditable(false);
					tf_orbitRigthAscension.setBackground(Grey);
					tf_orbitRigthAscension.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_orbitRigthAscension = new GridBagConstraints();
		gbc_ckbx_orbitRigthAscension.gridwidth = 2;
		gbc_ckbx_orbitRigthAscension.anchor = GridBagConstraints.WEST;
		gbc_ckbx_orbitRigthAscension.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_orbitRigthAscension.gridx = 0;
		gbc_ckbx_orbitRigthAscension.gridy = 8;
		p_capabilities.add(ckbx_orbitRigthAscension, gbc_ckbx_orbitRigthAscension);
		
		tf_orbitRigthAscension = new JTextField();
		tf_orbitRigthAscension.setEditable(false);
		tf_orbitRigthAscension.setColumns(10);
		GridBagConstraints gbc_tf_orbitRigthAscension = new GridBagConstraints();
		gbc_tf_orbitRigthAscension.gridwidth = 3;
		gbc_tf_orbitRigthAscension.insets = new Insets(0, 0, 5, 5);
		gbc_tf_orbitRigthAscension.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_orbitRigthAscension.gridx = 2;
		gbc_tf_orbitRigthAscension.gridy = 8;
		p_capabilities.add(tf_orbitRigthAscension, gbc_tf_orbitRigthAscension);
		
		ckbx_transmissionMode = new JCheckBox("数传方式:");
		ckbx_transmissionMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_transmissionMode.isSelected()) {
					tf_transmissionMode.setEditable(true);
					tf_transmissionMode.setBackground(white);
				}else {
					tf_transmissionMode.setEditable(false);
					tf_transmissionMode.setBackground(Grey);
					tf_transmissionMode.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_transmissionMode = new GridBagConstraints();
		gbc_ckbx_transmissionMode.anchor = GridBagConstraints.WEST;
		gbc_ckbx_transmissionMode.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_transmissionMode.gridx = 5;
		gbc_ckbx_transmissionMode.gridy = 8;
		p_capabilities.add(ckbx_transmissionMode, gbc_ckbx_transmissionMode);
		
		tf_transmissionMode = new JTextField();
		hintText hintTransmissionMode = new hintText(tf_transmissionMode, "中继星下传/直接下传/实时传输/存储传输等");
		tf_transmissionMode.addFocusListener(new JTextFieldHintListener("中继星下传/直接下传/实时传输/存储传输等", tf_transmissionMode));
		tf_transmissionMode.setEditable(false);
		tf_transmissionMode.setColumns(10);
		GridBagConstraints gbc_tf_transmissionMode = new GridBagConstraints();
		gbc_tf_transmissionMode.gridwidth = 4;
		gbc_tf_transmissionMode.insets = new Insets(0, 0, 5, 10);
		gbc_tf_transmissionMode.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_transmissionMode.gridx = 6;
		gbc_tf_transmissionMode.gridy = 8;
		p_capabilities.add(tf_transmissionMode, gbc_tf_transmissionMode);
		
		ckbx_orbitArgumentOfPerigee = new JCheckBox("近地点幅角(deg):");
		ckbx_orbitArgumentOfPerigee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_orbitArgumentOfPerigee.isSelected()) {
					tf_orbitArgumentOfPerigee.setEditable(true);
					tf_orbitArgumentOfPerigee.setBackground(white);
				}else {
					tf_orbitArgumentOfPerigee.setEditable(false);
					tf_orbitArgumentOfPerigee.setBackground(Grey);
					tf_orbitArgumentOfPerigee.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_orbitArgumentOfPerigee = new GridBagConstraints();
		gbc_ckbx_orbitArgumentOfPerigee.gridwidth = 2;
		gbc_ckbx_orbitArgumentOfPerigee.anchor = GridBagConstraints.WEST;
		gbc_ckbx_orbitArgumentOfPerigee.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_orbitArgumentOfPerigee.gridx = 0;
		gbc_ckbx_orbitArgumentOfPerigee.gridy = 9;
		p_capabilities.add(ckbx_orbitArgumentOfPerigee, gbc_ckbx_orbitArgumentOfPerigee);
		
		tf_orbitArgumentOfPerigee = new JTextField();
		tf_orbitArgumentOfPerigee.setEditable(false);
		tf_orbitArgumentOfPerigee.setColumns(10);
		GridBagConstraints gbc_tf_orbitArgumentOfPerigee = new GridBagConstraints();
		gbc_tf_orbitArgumentOfPerigee.gridwidth = 3;
		gbc_tf_orbitArgumentOfPerigee.insets = new Insets(0, 0, 5, 5);
		gbc_tf_orbitArgumentOfPerigee.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_orbitArgumentOfPerigee.gridx = 2;
		gbc_tf_orbitArgumentOfPerigee.gridy = 9;
		p_capabilities.add(tf_orbitArgumentOfPerigee, gbc_tf_orbitArgumentOfPerigee);
		
		ckbx_controlWaveBand = new JCheckBox("遥测波段:");
		ckbx_controlWaveBand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_controlWaveBand.isSelected()) {
					tf_controlWaveBand.setEditable(true);
					tf_controlWaveBand.setBackground(white);
				}else {
					tf_controlWaveBand.setEditable(false);
					tf_controlWaveBand.setBackground(Grey);
					tf_controlWaveBand.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_controlWaveBand = new GridBagConstraints();
		gbc_ckbx_controlWaveBand.anchor = GridBagConstraints.WEST;
		gbc_ckbx_controlWaveBand.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_controlWaveBand.gridx = 5;
		gbc_ckbx_controlWaveBand.gridy = 9;
		p_capabilities.add(ckbx_controlWaveBand, gbc_ckbx_controlWaveBand);
		
		tf_controlWaveBand = new JTextField();
		hintText hintWaveBand = new hintText(tf_controlWaveBand, "S波段/X波段等");
		tf_controlWaveBand.addFocusListener(new JTextFieldHintListener("S波段/X波段等", tf_controlWaveBand));
		tf_controlWaveBand.setEditable(false);
		tf_controlWaveBand.setColumns(10);
		GridBagConstraints gbc_tf_controlWaveBand = new GridBagConstraints();
		gbc_tf_controlWaveBand.gridwidth = 4;
		gbc_tf_controlWaveBand.insets = new Insets(0, 0, 5, 10);
		gbc_tf_controlWaveBand.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_controlWaveBand.gridx = 6;
		gbc_tf_controlWaveBand.gridy = 9;
		p_capabilities.add(tf_controlWaveBand, gbc_tf_controlWaveBand);
		
		ckbx_orbitMeanAnomaly = new JCheckBox("平近点角(deg):");
		ckbx_orbitMeanAnomaly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_orbitMeanAnomaly.isSelected()) {
					tf_orbitMeanAnomaly.setEditable(true);
					tf_orbitMeanAnomaly.setBackground(white);
				}else {
					tf_orbitMeanAnomaly.setEditable(false);
					tf_orbitMeanAnomaly.setBackground(Grey);
					tf_orbitMeanAnomaly.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_orbitMeanAnomaly = new GridBagConstraints();
		gbc_ckbx_orbitMeanAnomaly.anchor = GridBagConstraints.WEST;
		gbc_ckbx_orbitMeanAnomaly.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_orbitMeanAnomaly.gridx = 0;
		gbc_ckbx_orbitMeanAnomaly.gridy = 10;
		p_capabilities.add(ckbx_orbitMeanAnomaly, gbc_ckbx_orbitMeanAnomaly);
		
		tf_orbitMeanAnomaly = new JTextField();
		tf_orbitMeanAnomaly.setEditable(false);
		tf_orbitMeanAnomaly.setColumns(10);
		GridBagConstraints gbc_tf_orbitMeanAnomaly = new GridBagConstraints();
		gbc_tf_orbitMeanAnomaly.gridwidth = 4;
		gbc_tf_orbitMeanAnomaly.insets = new Insets(0, 0, 5, 5);
		gbc_tf_orbitMeanAnomaly.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_orbitMeanAnomaly.gridx = 1;
		gbc_tf_orbitMeanAnomaly.gridy = 10;
		p_capabilities.add(tf_orbitMeanAnomaly, gbc_tf_orbitMeanAnomaly);
		
		ckbx_downloadLinkWaveBand = new JCheckBox("数据下行波段:");
		ckbx_downloadLinkWaveBand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_downloadLinkWaveBand.isSelected()) {
					tf_downloadLinkWaveBand.setEditable(true);
					tf_downloadLinkWaveBand.setBackground(white);
				}else {
					tf_downloadLinkWaveBand.setEditable(false);
					tf_downloadLinkWaveBand.setBackground(Grey);
					tf_downloadLinkWaveBand.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_downloadLinkWaveBand = new GridBagConstraints();
		gbc_ckbx_downloadLinkWaveBand.gridwidth = 2;
		gbc_ckbx_downloadLinkWaveBand.anchor = GridBagConstraints.WEST;
		gbc_ckbx_downloadLinkWaveBand.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_downloadLinkWaveBand.gridx = 5;
		gbc_ckbx_downloadLinkWaveBand.gridy = 10;
		p_capabilities.add(ckbx_downloadLinkWaveBand, gbc_ckbx_downloadLinkWaveBand);
		
		tf_downloadLinkWaveBand = new JTextField();
		hintText hintDownloadWaveBand = new hintText(tf_downloadLinkWaveBand, "S波段/X波段等");
		tf_downloadLinkWaveBand.addFocusListener(new JTextFieldHintListener("S波段/X波段等", tf_downloadLinkWaveBand));
		tf_downloadLinkWaveBand.setEditable(false);
		tf_downloadLinkWaveBand.setColumns(10);
		GridBagConstraints gbc_tf_downloadLinkWaveBand = new GridBagConstraints();
		gbc_tf_downloadLinkWaveBand.gridwidth = 3;
		gbc_tf_downloadLinkWaveBand.insets = new Insets(0, 0, 5, 10);
		gbc_tf_downloadLinkWaveBand.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_downloadLinkWaveBand.gridx = 7;
		gbc_tf_downloadLinkWaveBand.gridy = 10;
		p_capabilities.add(tf_downloadLinkWaveBand, gbc_tf_downloadLinkWaveBand);
		
		ckbx_orbitMeanMotion = new JCheckBox("平运动角(circ/d):");
		ckbx_orbitMeanMotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_orbitMeanMotion.isSelected()) {
					tf_orbitMeanMotion.setEditable(true);
					tf_orbitMeanMotion.setBackground(white);
				}else {
					tf_orbitMeanMotion.setEditable(false);
					tf_orbitMeanMotion.setBackground(Grey);
					tf_orbitMeanMotion.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_orbitMeanMotion = new GridBagConstraints();
		gbc_ckbx_orbitMeanMotion.gridwidth = 2;
		gbc_ckbx_orbitMeanMotion.anchor = GridBagConstraints.WEST;
		gbc_ckbx_orbitMeanMotion.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_orbitMeanMotion.gridx = 0;
		gbc_ckbx_orbitMeanMotion.gridy = 11;
		p_capabilities.add(ckbx_orbitMeanMotion, gbc_ckbx_orbitMeanMotion);
		
		tf_orbitMeanMotion = new JTextField();
		tf_orbitMeanMotion.setEditable(false);
		tf_orbitMeanMotion.setColumns(10);
		GridBagConstraints gbc_tf_orbitMeanMotion = new GridBagConstraints();
		gbc_tf_orbitMeanMotion.gridwidth = 3;
		gbc_tf_orbitMeanMotion.insets = new Insets(0, 0, 5, 5);
		gbc_tf_orbitMeanMotion.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_orbitMeanMotion.gridx = 2;
		gbc_tf_orbitMeanMotion.gridy = 11;
		p_capabilities.add(tf_orbitMeanMotion, gbc_tf_orbitMeanMotion);
		
		ckbx_downloadLinkRate = new JCheckBox("数据下行速率(Mbps):");
		ckbx_downloadLinkRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_downloadLinkRate.isSelected()) {
					tf_downloadLinkRate.setEditable(true);
					tf_downloadLinkRate.setBackground(white);
				}else {
					tf_downloadLinkRate.setEditable(false);
					tf_downloadLinkRate.setBackground(Grey);
					tf_downloadLinkRate.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_downloadLinkRate = new GridBagConstraints();
		gbc_ckbx_downloadLinkRate.gridwidth = 2;
		gbc_ckbx_downloadLinkRate.anchor = GridBagConstraints.WEST;
		gbc_ckbx_downloadLinkRate.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_downloadLinkRate.gridx = 5;
		gbc_ckbx_downloadLinkRate.gridy = 11;
		p_capabilities.add(ckbx_downloadLinkRate, gbc_ckbx_downloadLinkRate);
		
		tf_downloadLinkRate = new JTextField();
		tf_downloadLinkRate.setEditable(false);
		tf_downloadLinkRate.setColumns(10);
		GridBagConstraints gbc_tf_downloadLinkRate = new GridBagConstraints();
		gbc_tf_downloadLinkRate.gridwidth = 3;
		gbc_tf_downloadLinkRate.insets = new Insets(0, 0, 5, 10);
		gbc_tf_downloadLinkRate.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_downloadLinkRate.gridx = 7;
		gbc_tf_downloadLinkRate.gridy = 11;
		p_capabilities.add(tf_downloadLinkRate, gbc_tf_downloadLinkRate);
		
		ckbx_orbitDecayRate = new JCheckBox("衰减率(circ/d²):");
		ckbx_orbitDecayRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_orbitDecayRate.isSelected()) {
					tf_orbitDecayRate.setEditable(true);
					tf_orbitDecayRate.setBackground(white);
				}else {
					tf_orbitDecayRate.setEditable(false);
					tf_orbitDecayRate.setBackground(Grey);
					tf_orbitDecayRate.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_orbitDecayRate = new GridBagConstraints();
		gbc_ckbx_orbitDecayRate.gridwidth = 2;
		gbc_ckbx_orbitDecayRate.anchor = GridBagConstraints.WEST;
		gbc_ckbx_orbitDecayRate.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_orbitDecayRate.gridx = 0;
		gbc_ckbx_orbitDecayRate.gridy = 12;
		p_capabilities.add(ckbx_orbitDecayRate, gbc_ckbx_orbitDecayRate);
		
		tf_orbitDecayRate = new JTextField();
		tf_orbitDecayRate.setEditable(false);
		tf_orbitDecayRate.setColumns(10);
		GridBagConstraints gbc_tf_orbitDecayRate = new GridBagConstraints();
		gbc_tf_orbitDecayRate.gridwidth = 3;
		gbc_tf_orbitDecayRate.insets = new Insets(0, 0, 5, 5);
		gbc_tf_orbitDecayRate.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_orbitDecayRate.gridx = 2;
		gbc_tf_orbitDecayRate.gridy = 12;
		p_capabilities.add(tf_orbitDecayRate, gbc_tf_orbitDecayRate);
		
		ckbx_communicationInterface = new JCheckBox("通信接口:");
		ckbx_communicationInterface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_communicationInterface.isSelected()) {
					tf_communicationInterface.setEditable(true);
					tf_communicationInterface.setBackground(white);
				}else {
					tf_communicationInterface.setEditable(false);
					tf_communicationInterface.setBackground(Grey);
					tf_communicationInterface.setText("");
				}
			}
		});
		GridBagConstraints gbc_ckbx_communicationInterface = new GridBagConstraints();
		gbc_ckbx_communicationInterface.anchor = GridBagConstraints.WEST;
		gbc_ckbx_communicationInterface.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_communicationInterface.gridx = 5;
		gbc_ckbx_communicationInterface.gridy = 12;
		p_capabilities.add(ckbx_communicationInterface, gbc_ckbx_communicationInterface);
		
		tf_communicationInterface = new JTextField();
		hintText hintCommunicationInterface = new hintText(tf_communicationInterface, "如：RS232/USB");
		tf_communicationInterface.addFocusListener(new JTextFieldHintListener("如：RS232/USB", tf_communicationInterface));
		tf_communicationInterface.setEditable(false);
		tf_communicationInterface.setColumns(10);
		GridBagConstraints gbc_tf_communicationInterface = new GridBagConstraints();
		gbc_tf_communicationInterface.gridwidth = 4;
		gbc_tf_communicationInterface.insets = new Insets(0, 0, 5, 10);
		gbc_tf_communicationInterface.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_communicationInterface.gridx = 6;
		gbc_tf_communicationInterface.gridy = 12;
		p_capabilities.add(tf_communicationInterface, gbc_tf_communicationInterface);
		
		ckbx_observeBBox = new JCheckBox("观测范围(纬度-经度):");
		ckbx_observeBBox.setSelected(true);
		GridBagConstraints gbc_ckbx_observeBBox = new GridBagConstraints();
		gbc_ckbx_observeBBox.gridwidth = 2;
		gbc_ckbx_observeBBox.anchor = GridBagConstraints.WEST;
		gbc_ckbx_observeBBox.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_observeBBox.gridx = 0;
		gbc_ckbx_observeBBox.gridy = 13;
		p_capabilities.add(ckbx_observeBBox, gbc_ckbx_observeBBox);
		
		ckbx_otherCapability = new JCheckBox("添加其他观测能力:");
		ckbx_otherCapability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_otherCapability.isSelected()) {
					tf_otherCapabilityName.setEditable(true);
					tf_otherCapabilityName.setBackground(white);
					tf_otherCapabilityValue.setEditable(true);
					tf_otherCapabilityValue.setBackground(white);
					bt_addOtherCapability.setEnabled(true);
					bt_deleteOtherCapability.setEnabled(true);
				}else {
					tf_otherCapabilityName.setEditable(false);
					tf_otherCapabilityName.setBackground(Grey);
					tf_otherCapabilityValue.setEditable(false);
					tf_otherCapabilityValue.setBackground(Grey);
					bt_addOtherCapability.setEnabled(false);
					bt_deleteOtherCapability.setEnabled(false);
					tf_otherCapabilityName.setText("");
					tf_otherCapabilityName.setText("");
					model_otherCapability.setRowCount(0);
				}
			}
		});
		GridBagConstraints gbc_ckbx_otherCapability = new GridBagConstraints();
		gbc_ckbx_otherCapability.gridwidth = 2;
		gbc_ckbx_otherCapability.anchor = GridBagConstraints.WEST;
		gbc_ckbx_otherCapability.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_otherCapability.gridx = 5;
		gbc_ckbx_otherCapability.gridy = 13;
		p_capabilities.add(ckbx_otherCapability, gbc_ckbx_otherCapability);
		
		lb_lowerCorner = new JLabel("  左下角点:");
		GridBagConstraints gbc_lb_lowerCorner = new GridBagConstraints();
		gbc_lb_lowerCorner.anchor = GridBagConstraints.EAST;
		gbc_lb_lowerCorner.insets = new Insets(0, 0, 5, 5);
		gbc_lb_lowerCorner.gridx = 0;
		gbc_lb_lowerCorner.gridy = 14;
		p_capabilities.add(lb_lowerCorner, gbc_lb_lowerCorner);
		
		tf_lowerY = new JTextField();
		tf_lowerY.setColumns(10);
		GridBagConstraints gbc_tf_lowerY = new GridBagConstraints();
		gbc_tf_lowerY.gridwidth = 2;
		gbc_tf_lowerY.insets = new Insets(0, 0, 5, 5);
		gbc_tf_lowerY.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_lowerY.gridx = 1;
		gbc_tf_lowerY.gridy = 14;
		p_capabilities.add(tf_lowerY, gbc_tf_lowerY);
		
		lb_line3 = new JLabel("—");
		GridBagConstraints gbc_lb_line3 = new GridBagConstraints();
		gbc_lb_line3.insets = new Insets(0, 0, 5, 5);
		gbc_lb_line3.anchor = GridBagConstraints.EAST;
		gbc_lb_line3.gridx = 3;
		gbc_lb_line3.gridy = 14;
		p_capabilities.add(lb_line3, gbc_lb_line3);
		
		tf_lowerX = new JTextField();
		tf_lowerX.setColumns(10);
		GridBagConstraints gbc_tf_lowerX = new GridBagConstraints();
		gbc_tf_lowerX.insets = new Insets(0, 0, 5, 5);
		gbc_tf_lowerX.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_lowerX.gridx = 4;
		gbc_tf_lowerX.gridy = 14;
		p_capabilities.add(tf_lowerX, gbc_tf_lowerX);
		
		scrollPane_9 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_9 = new GridBagConstraints();
		gbc_scrollPane_9.gridheight = 2;
		gbc_scrollPane_9.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_9.gridwidth = 5;
		gbc_scrollPane_9.insets = new Insets(0, 0, 5, 10);
		gbc_scrollPane_9.gridx = 5;
		gbc_scrollPane_9.gridy = 14;
		p_capabilities.add(scrollPane_9, gbc_scrollPane_9);
		
		tb_otherCapability = new JTable();
		scrollPane_9.setViewportView(tb_otherCapability);
		model_otherCapability = new DefaultTableModel(new Object[][] {},new String[] {"字段名称", "字段内容"});
		tb_otherCapability.setModel(model_otherCapability);
		tb_otherCapability.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		lb_upperCorner = new JLabel("  右上角点:");
		GridBagConstraints gbc_lb_upperCorner = new GridBagConstraints();
		gbc_lb_upperCorner.anchor = GridBagConstraints.EAST;
		gbc_lb_upperCorner.insets = new Insets(0, 0, 5, 5);
		gbc_lb_upperCorner.gridx = 0;
		gbc_lb_upperCorner.gridy = 15;
		p_capabilities.add(lb_upperCorner, gbc_lb_upperCorner);
		
		tf_upperY = new JTextField();
		tf_upperY.setColumns(10);
		GridBagConstraints gbc_tf_upperY = new GridBagConstraints();
		gbc_tf_upperY.gridwidth = 2;
		gbc_tf_upperY.insets = new Insets(0, 0, 5, 5);
		gbc_tf_upperY.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_upperY.gridx = 1;
		gbc_tf_upperY.gridy = 15;
		p_capabilities.add(tf_upperY, gbc_tf_upperY);
		
		lb_line4 = new JLabel("—");
		GridBagConstraints gbc_lb_line4 = new GridBagConstraints();
		gbc_lb_line4.insets = new Insets(0, 0, 5, 5);
		gbc_lb_line4.anchor = GridBagConstraints.EAST;
		gbc_lb_line4.gridx = 3;
		gbc_lb_line4.gridy = 15;
		p_capabilities.add(lb_line4, gbc_lb_line4);
		
		tf_upperX = new JTextField();
		tf_upperX.setColumns(10);
		GridBagConstraints gbc_tf_upperX = new GridBagConstraints();
		gbc_tf_upperX.insets = new Insets(0, 0, 5, 5);
		gbc_tf_upperX.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_upperX.gridx = 4;
		gbc_tf_upperX.gridy = 15;
		p_capabilities.add(tf_upperX, gbc_tf_upperX);
		
		tf_otherCapabilityName = new JTextField();
		tf_otherCapabilityName.setEditable(false);
		tf_otherCapabilityName.setColumns(10);
		GridBagConstraints gbc_tf_otherCapabilityName = new GridBagConstraints();
		gbc_tf_otherCapabilityName.insets = new Insets(0, 0, 0, 5);
		gbc_tf_otherCapabilityName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherCapabilityName.gridx = 5;
		gbc_tf_otherCapabilityName.gridy = 16;
		p_capabilities.add(tf_otherCapabilityName, gbc_tf_otherCapabilityName);
		
		tf_otherCapabilityValue = new JTextField();
		tf_otherCapabilityValue.setEditable(false);
		tf_otherCapabilityValue.setColumns(10);
		GridBagConstraints gbc_tf_otherCapabilityValue = new GridBagConstraints();
		gbc_tf_otherCapabilityValue.gridwidth = 2;
		gbc_tf_otherCapabilityValue.insets = new Insets(0, 0, 0, 5);
		gbc_tf_otherCapabilityValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherCapabilityValue.gridx = 6;
		gbc_tf_otherCapabilityValue.gridy = 16;
		p_capabilities.add(tf_otherCapabilityValue, gbc_tf_otherCapabilityValue);
		
		bt_addOtherCapability = new JButton("增加");
		bt_addOtherCapability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_otherCapabilityName.getText(),tf_otherCapabilityValue.getText()};
				model_otherCapability.addRow(info);
				tf_otherCapabilityName.setText("");
				tf_otherCapabilityValue.setText("");
			}
		});
		bt_addOtherCapability.setEnabled(false);
		GridBagConstraints gbc_bt_addOtherCapability = new GridBagConstraints();
		gbc_bt_addOtherCapability.insets = new Insets(0, 0, 0, 5);
		gbc_bt_addOtherCapability.gridx = 8;
		gbc_bt_addOtherCapability.gridy = 16;
		p_capabilities.add(bt_addOtherCapability, gbc_bt_addOtherCapability);
		
		bt_deleteOtherCapability = new JButton("删除");
		bt_deleteOtherCapability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_otherCapability.getSelectedRow();
				if (selectedRow != -1) {
					model_otherCapability.removeRow(selectedRow);
				}
			}
		});
		bt_deleteOtherCapability.setEnabled(false);
		GridBagConstraints gbc_bt_deleteOtherCapability = new GridBagConstraints();
		gbc_bt_deleteOtherCapability.insets = new Insets(0, 0, 0, 5);
		gbc_bt_deleteOtherCapability.gridx = 9;
		gbc_bt_deleteOtherCapability.gridy = 16;
		p_capabilities.add(bt_deleteOtherCapability, gbc_bt_deleteOtherCapability);
		
		p_position = new JPanel();
		tp_capa.addTab("     平台位置信息     ", null, p_position, null);
		GridBagLayout gbl_p_position = new GridBagLayout();
		gbl_p_position.columnWidths = new int[]{0, 0, 0, 0};
		gbl_p_position.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_p_position.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_p_position.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		p_position.setLayout(gbl_p_position);
		
		ckbx_position = new JCheckBox("空间位置");
		ckbx_position.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_position.isSelected()) {
					tf_positionSRS.setEditable(true);
					tf_latitude.setEditable(true);
					tf_longtitude.setEditable(true);
					tf_altitude.setEditable(true);
					tf_positionSRS.setBackground(white);
					tf_latitude.setBackground(white);
					tf_altitude.setBackground(white);
					tf_longtitude.setBackground(white);
				}else {
					tf_positionSRS.setEditable(false);
					tf_latitude.setEditable(false);
					tf_longtitude.setEditable(false);
					tf_altitude.setEditable(false);
					tf_positionSRS.setBackground(Grey);
					tf_latitude.setBackground(Grey);
					tf_altitude.setBackground(Grey);
					tf_longtitude.setBackground(Grey);
					tf_positionSRS.setText("");
					tf_latitude.setText("");
					tf_longtitude.setText("");
					tf_altitude.setText("");
				}
			}
		});
		ckbx_position.setForeground(SystemColor.textHighlight);
		ckbx_position.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_ckbx_position = new GridBagConstraints();
		gbc_ckbx_position.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_position.gridx = 0;
		gbc_ckbx_position.gridy = 0;
		p_position.add(ckbx_position, gbc_ckbx_position);
		
		lb_positionSRS = new JLabel("  参考坐标系统:");
		GridBagConstraints gbc_lb_positionSRS = new GridBagConstraints();
		gbc_lb_positionSRS.gridwidth = 2;
		gbc_lb_positionSRS.insets = new Insets(0, 0, 5, 5);
		gbc_lb_positionSRS.gridx = 0;
		gbc_lb_positionSRS.gridy = 1;
		p_position.add(lb_positionSRS, gbc_lb_positionSRS);
		
		tf_positionSRS = new JTextField();
		hintText hintPositionSRS = new hintText(tf_positionSRS, "urn:ogc:def:crs:OGC:1.3:EPSG:4329");
		tf_positionSRS.addFocusListener(new JTextFieldHintListener("urn:ogc:def:crs:OGC:1.3:EPSG:4329", tf_positionSRS));
		tf_positionSRS.setEditable(false);
		tf_positionSRS.setColumns(10);
		GridBagConstraints gbc_tf_positionSRS = new GridBagConstraints();
		gbc_tf_positionSRS.insets = new Insets(0, 0, 5, 0);
		gbc_tf_positionSRS.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_positionSRS.gridx = 2;
		gbc_tf_positionSRS.gridy = 1;
		p_position.add(tf_positionSRS, gbc_tf_positionSRS);
		
		lb_latitude = new JLabel("  纬度(deg):");
		GridBagConstraints gbc_lb_latitude = new GridBagConstraints();
		gbc_lb_latitude.gridwidth = 2;
		gbc_lb_latitude.insets = new Insets(0, 0, 5, 5);
		gbc_lb_latitude.gridx = 0;
		gbc_lb_latitude.gridy = 2;
		p_position.add(lb_latitude, gbc_lb_latitude);
		
		tf_latitude = new JTextField();
		tf_latitude.setEditable(false);
		tf_latitude.setColumns(10);
		GridBagConstraints gbc_tf_latitude = new GridBagConstraints();
		gbc_tf_latitude.insets = new Insets(0, 0, 5, 0);
		gbc_tf_latitude.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_latitude.gridx = 2;
		gbc_tf_latitude.gridy = 2;
		p_position.add(tf_latitude, gbc_tf_latitude);
		
		lb_longtitude = new JLabel("  经度(deg):");
		GridBagConstraints gbc_lb_longtitude = new GridBagConstraints();
		gbc_lb_longtitude.gridwidth = 2;
		gbc_lb_longtitude.insets = new Insets(0, 0, 5, 5);
		gbc_lb_longtitude.gridx = 0;
		gbc_lb_longtitude.gridy = 3;
		p_position.add(lb_longtitude, gbc_lb_longtitude);
		
		tf_longtitude = new JTextField();
		tf_longtitude.setEditable(false);
		tf_longtitude.setColumns(10);
		GridBagConstraints gbc_tf_longtitude = new GridBagConstraints();
		gbc_tf_longtitude.insets = new Insets(0, 0, 5, 0);
		gbc_tf_longtitude.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_longtitude.gridx = 2;
		gbc_tf_longtitude.gridy = 3;
		p_position.add(tf_longtitude, gbc_tf_longtitude);
		
		lb_altitude = new JLabel("  海拔(m):");
		GridBagConstraints gbc_lb_altitude = new GridBagConstraints();
		gbc_lb_altitude.gridwidth = 2;
		gbc_lb_altitude.insets = new Insets(0, 0, 5, 5);
		gbc_lb_altitude.gridx = 0;
		gbc_lb_altitude.gridy = 4;
		p_position.add(lb_altitude, gbc_lb_altitude);
		
		tf_altitude = new JTextField();
		tf_altitude.setEditable(false);
		tf_altitude.setColumns(10);
		GridBagConstraints gbc_tf_altitude = new GridBagConstraints();
		gbc_tf_altitude.insets = new Insets(0, 0, 5, 0);
		gbc_tf_altitude.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_altitude.gridx = 2;
		gbc_tf_altitude.gridy = 4;
		p_position.add(tf_altitude, gbc_tf_altitude);
		
		ckbx_spatialReference = new JCheckBox("空间参考坐标系");
		ckbx_spatialReference.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_spatialReference.isSelected()) {
					tf_spatialID.setEditable(true);
					tf_spatialOrigin.setEditable(true);
					tf_spatialX.setEditable(true);
					tf_SpatialY.setEditable(true);
					tf_spatialZ.setEditable(true);
					tf_spatialID.setBackground(white);
					tf_spatialOrigin.setBackground(white);
					tf_spatialX.setBackground(white);
					tf_SpatialY.setBackground(white);;
					tf_spatialZ.setBackground(white);	
				}else {
					tf_spatialID.setEditable(false);
					tf_spatialOrigin.setEditable(false);
					tf_spatialX.setEditable(false);
					tf_SpatialY.setEditable(false);
					tf_spatialZ.setEditable(false);
					tf_spatialID.setBackground(Grey);
					tf_spatialOrigin.setBackground(Grey);
					tf_spatialX.setBackground(Grey);
					tf_SpatialY.setBackground(Grey);
					tf_spatialZ.setBackground(Grey);
					tf_spatialID.setText("");tf_spatialOrigin.setText("");
					tf_spatialX.setText("");tf_SpatialY.setText("");tf_spatialZ.setText("");
				}
			}
		});
		ckbx_spatialReference.setForeground(SystemColor.textHighlight);
		ckbx_spatialReference.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_ckbx_spatialReference = new GridBagConstraints();
		gbc_ckbx_spatialReference.anchor = GridBagConstraints.WEST;
		gbc_ckbx_spatialReference.gridwidth = 2;
		gbc_ckbx_spatialReference.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_spatialReference.gridx = 0;
		gbc_ckbx_spatialReference.gridy = 5;
		p_position.add(ckbx_spatialReference, gbc_ckbx_spatialReference);
		
		lb_spatioalRefrenceID = new JLabel("坐标系ID:");
		GridBagConstraints gbc_lb_spatioalRefrenceID = new GridBagConstraints();
		gbc_lb_spatioalRefrenceID.gridwidth = 2;
		gbc_lb_spatioalRefrenceID.insets = new Insets(0, 0, 5, 5);
		gbc_lb_spatioalRefrenceID.gridx = 0;
		gbc_lb_spatioalRefrenceID.gridy = 6;
		p_position.add(lb_spatioalRefrenceID, gbc_lb_spatioalRefrenceID);
		
		tf_spatialID = new JTextField();
		hintText hintSpatialID = new hintText(tf_spatialID, "S1");
		tf_spatialID.addFocusListener(new JTextFieldHintListener("S1", tf_spatialID));
		tf_spatialID.setEditable(false);
		tf_spatialID.setColumns(10);
		GridBagConstraints gbc_tf_spatialID = new GridBagConstraints();
		gbc_tf_spatialID.insets = new Insets(0, 0, 5, 0);
		gbc_tf_spatialID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_spatialID.gridx = 2;
		gbc_tf_spatialID.gridy = 6;
		p_position.add(tf_spatialID, gbc_tf_spatialID);
		
		lb_spatialReferenceOrigin = new JLabel("坐标系原点描述:");
		GridBagConstraints gbc_lb_spatialReferenceOrigin = new GridBagConstraints();
		gbc_lb_spatialReferenceOrigin.gridwidth = 2;
		gbc_lb_spatialReferenceOrigin.insets = new Insets(0, 0, 5, 5);
		gbc_lb_spatialReferenceOrigin.gridx = 0;
		gbc_lb_spatialReferenceOrigin.gridy = 7;
		p_position.add(lb_spatialReferenceOrigin, gbc_lb_spatialReferenceOrigin);
		
		tf_spatialOrigin = new JTextField();
		tf_spatialOrigin.setEditable(false);
		tf_spatialOrigin.setColumns(10);
		GridBagConstraints gbc_tf_spatialOrigin = new GridBagConstraints();
		gbc_tf_spatialOrigin.insets = new Insets(0, 0, 5, 0);
		gbc_tf_spatialOrigin.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_spatialOrigin.gridx = 2;
		gbc_tf_spatialOrigin.gridy = 7;
		p_position.add(tf_spatialOrigin, gbc_tf_spatialOrigin);
		
		lb_spatialReferenceX = new JLabel("X轴定义:");
		GridBagConstraints gbc_lb_spatialReferenceX = new GridBagConstraints();
		gbc_lb_spatialReferenceX.gridwidth = 2;
		gbc_lb_spatialReferenceX.insets = new Insets(0, 0, 5, 5);
		gbc_lb_spatialReferenceX.gridx = 0;
		gbc_lb_spatialReferenceX.gridy = 8;
		p_position.add(lb_spatialReferenceX, gbc_lb_spatialReferenceX);
		
		tf_spatialX = new JTextField();
		tf_spatialX.setEditable(false);
		tf_spatialX.setColumns(10);
		GridBagConstraints gbc_tf_spatialX = new GridBagConstraints();
		gbc_tf_spatialX.insets = new Insets(0, 0, 5, 0);
		gbc_tf_spatialX.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_spatialX.gridx = 2;
		gbc_tf_spatialX.gridy = 8;
		p_position.add(tf_spatialX, gbc_tf_spatialX);
		
		lb_spatialReferenceY = new JLabel("Y轴定义:");
		GridBagConstraints gbc_lb_spatialReferenceY = new GridBagConstraints();
		gbc_lb_spatialReferenceY.gridwidth = 2;
		gbc_lb_spatialReferenceY.insets = new Insets(0, 0, 5, 5);
		gbc_lb_spatialReferenceY.gridx = 0;
		gbc_lb_spatialReferenceY.gridy = 9;
		p_position.add(lb_spatialReferenceY, gbc_lb_spatialReferenceY);
		
		tf_SpatialY = new JTextField();
		tf_SpatialY.setEditable(false);
		tf_SpatialY.setColumns(10);
		GridBagConstraints gbc_tf_SpatialY = new GridBagConstraints();
		gbc_tf_SpatialY.insets = new Insets(0, 0, 5, 0);
		gbc_tf_SpatialY.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_SpatialY.gridx = 2;
		gbc_tf_SpatialY.gridy = 9;
		p_position.add(tf_SpatialY, gbc_tf_SpatialY);
		
		lb_spatialReferenceZ = new JLabel("Z轴定义:");
		GridBagConstraints gbc_lb_spatialReferenceZ = new GridBagConstraints();
		gbc_lb_spatialReferenceZ.gridwidth = 2;
		gbc_lb_spatialReferenceZ.insets = new Insets(0, 0, 5, 5);
		gbc_lb_spatialReferenceZ.gridx = 0;
		gbc_lb_spatialReferenceZ.gridy = 10;
		p_position.add(lb_spatialReferenceZ, gbc_lb_spatialReferenceZ);
		
		tf_spatialZ = new JTextField();
		tf_spatialZ.setEditable(false);
		tf_spatialZ.setColumns(10);
		GridBagConstraints gbc_tf_spatialZ = new GridBagConstraints();
		gbc_tf_spatialZ.insets = new Insets(0, 0, 5, 0);
		gbc_tf_spatialZ.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_spatialZ.gridx = 2;
		gbc_tf_spatialZ.gridy = 10;
		p_position.add(tf_spatialZ, gbc_tf_spatialZ);
		
		ckbx_temperalReference = new JCheckBox("时间参考坐标系");
		ckbx_temperalReference.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_temperalReference.isSelected()) {
					tf_temperalID.setEditable(true);
					tf_temperalOrigin.setEditable(true);
					tf_temperalID.setBackground(white);
					tf_temperalOrigin.setBackground(white);
				}else {
					tf_temperalID.setEditable(false);
					tf_temperalOrigin.setEditable(false);
					tf_temperalID.setBackground(Grey);
					tf_temperalOrigin.setBackground(Grey);
					tf_temperalID.setText("");
					tf_temperalOrigin.setText("");
				}
			}
		});
		ckbx_temperalReference.setForeground(SystemColor.textHighlight);
		ckbx_temperalReference.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_ckbx_temperalReference = new GridBagConstraints();
		gbc_ckbx_temperalReference.anchor = GridBagConstraints.WEST;
		gbc_ckbx_temperalReference.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_temperalReference.gridwidth = 2;
		gbc_ckbx_temperalReference.gridx = 0;
		gbc_ckbx_temperalReference.gridy = 11;
		p_position.add(ckbx_temperalReference, gbc_ckbx_temperalReference);
		
		lb_TMReferenceID = new JLabel("坐标系ID:");
		GridBagConstraints gbc_lb_TMReferenceID = new GridBagConstraints();
		gbc_lb_TMReferenceID.insets = new Insets(0, 0, 5, 5);
		gbc_lb_TMReferenceID.gridwidth = 2;
		gbc_lb_TMReferenceID.gridx = 0;
		gbc_lb_TMReferenceID.gridy = 12;
		p_position.add(lb_TMReferenceID, gbc_lb_TMReferenceID);
		
		tf_temperalID = new JTextField();
		hintText hintTemeralID = new hintText(tf_temperalID, "T1");
		tf_temperalID.addFocusListener(new JTextFieldHintListener("T1", tf_temperalID));
		tf_temperalID.setEditable(false);
		tf_temperalID.setColumns(10);
		GridBagConstraints gbc_tf_temperalID = new GridBagConstraints();
		gbc_tf_temperalID.insets = new Insets(0, 0, 5, 0);
		gbc_tf_temperalID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_temperalID.gridx = 2;
		gbc_tf_temperalID.gridy = 12;
		p_position.add(tf_temperalID, gbc_tf_temperalID);
		
		lb_TMReferenceOrigin = new JLabel("坐标系原点描述:");
		GridBagConstraints gbc_lb_TMReferenceOrigin = new GridBagConstraints();
		gbc_lb_TMReferenceOrigin.gridwidth = 2;
		gbc_lb_TMReferenceOrigin.insets = new Insets(0, 0, 0, 5);
		gbc_lb_TMReferenceOrigin.gridx = 0;
		gbc_lb_TMReferenceOrigin.gridy = 13;
		p_position.add(lb_TMReferenceOrigin, gbc_lb_TMReferenceOrigin);
		
		tf_temperalOrigin = new JTextField();
		tf_temperalOrigin.setEditable(false);
		tf_temperalOrigin.setColumns(10);
		GridBagConstraints gbc_tf_temperalOrigin = new GridBagConstraints();
		gbc_tf_temperalOrigin.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_temperalOrigin.gridx = 2;
		gbc_tf_temperalOrigin.gridy = 13;
		p_position.add(tf_temperalOrigin, gbc_tf_temperalOrigin);
		model_otherCapability = new DefaultTableModel(new Object[][] {},new String[] {"字段名称", "字段内容"});
		model_otherCharacter = new DefaultTableModel(new Object[][] {},new String[] {"字段名称", "字段内容"});
		
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
		hintText hintEventID = new hintText(tf_eventId, "如：E1");
		tf_eventId.addFocusListener(new JTextFieldHintListener("如：E1", tf_eventId));
		tf_eventId.setEditable(false);
		GridBagConstraints gbc_tf_eventId = new GridBagConstraints();
		gbc_tf_eventId.insets = new Insets(0, 0, 5, 5);
		gbc_tf_eventId.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_eventId.gridx = 6;
		gbc_tf_eventId.gridy = 1;
		p_contact.add(tf_eventId, gbc_tf_eventId);
		
		JLabel lb_eventLabel = new JLabel("事件标签:");
		hintText hintEventLabel = new hintText(tf_eventLabel, "如：SOS");
		tf_eventLabel.addFocusListener(new JTextFieldHintListener("如：SOS", tf_eventLabel));
		GridBagConstraints gbc_lb_eventLabel = new GridBagConstraints();
		gbc_lb_eventLabel.gridwidth = 2;
		gbc_lb_eventLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lb_eventLabel.gridx = 7;
		gbc_lb_eventLabel.gridy = 1;
		p_contact.add(lb_eventLabel, gbc_lb_eventLabel);
		
		tf_eventLabel = new JTextField();
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
		
		JLabel label = new JLabel("邮寄地址:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 6;
		p_contact.add(label, gbc_label);
		
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
		hintText hintEventBeginTM = new hintText(tf_EBeginTM, "如：2015-06-01T10:00:00Z");
		tf_EBeginTM.addFocusListener(new JTextFieldHintListener("如：2015-06-01T10:00:00Z", tf_EBeginTM));
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
		hintText hintEventEndTM = new hintText(tf_EEndTM, "如：2025-06-01T10:00:00Z");
		tf_EEndTM.addFocusListener(new JTextFieldHintListener("如：2025-06-01T10:00:00Z", tf_EEndTM));
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
		hintText hintEventInstance = new hintText(tf_ETMIns, "2018-03-01T10:00:00Z");
		tf_ETMIns.addFocusListener(new JTextFieldHintListener("2018-03-01T10:00:00Z", tf_ETMIns));
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
		gbl_p_component.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_p_component.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_p_component.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_p_component.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		p_component.setLayout(gbl_p_component);
		
		JCheckBox ckbx_input = new JCheckBox("添加输入：");
		ckbx_input.setSelected(true);
		GridBagConstraints gbc_ckbx_input = new GridBagConstraints();
		gbc_ckbx_input.gridwidth = 2;
		gbc_ckbx_input.insets = new Insets(15, 10, 5, 5);
		gbc_ckbx_input.gridx = 0;
		gbc_ckbx_input.gridy = 0;
		p_component.add(ckbx_input, gbc_ckbx_input);
		
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
		p_component.add(bt_addInput, gbc_bt_addInput);
		
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
		p_component.add(bt_deleteInput, gbc_bt_deleteInput);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_91 = new GridBagConstraints();
		gbc_scrollPane_91.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_91.gridwidth = 5;
		gbc_scrollPane_91.insets = new Insets(0, 20, 5, 20);
		gbc_scrollPane_91.gridx = 1;
		gbc_scrollPane_91.gridy = 1;
		p_component.add(scrollPane_9, gbc_scrollPane_91);
		
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
		p_component.add(ckbx_output, gbc_ckbx_output);
		
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
		p_component.add(bt_addOutput, gbc_bt_addOutput);
		
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
		p_component.add(bt_deleteOutput, gbc_bt_deleteOutput);
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
		
		JScrollPane scrollPane_101 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_101 = new GridBagConstraints();
		gbc_scrollPane_101.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_101.gridwidth = 5;
		gbc_scrollPane_101.insets = new Insets(0, 20, 5, 20);
		gbc_scrollPane_101.gridx = 1;
		gbc_scrollPane_101.gridy = 3;
		p_component.add(scrollPane_101, gbc_scrollPane_101);
		
		tb_output = new JTable();
		scrollPane_101.setViewportView(tb_output);
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
		p_component.add(ckbx_parameter, gbc_ckbx_parameter);
		
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
		p_component.add(bt_addParameter, gbc_bt_addParameter);
		
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
		p_component.add(bt_deleteParameter, gbc_bt_deleteParameter);
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
		
		JScrollPane scrollPane_111 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_111 = new GridBagConstraints();
		gbc_scrollPane_111.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_111.gridwidth = 5;
		gbc_scrollPane_111.insets = new Insets(0, 20, 5, 20);
		gbc_scrollPane_111.gridx = 1;
		gbc_scrollPane_111.gridy = 5;
		p_component.add(scrollPane_111, gbc_scrollPane_111);
		
		tb_parameter = new JTable();
		scrollPane_111.setViewportView(tb_parameter);
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
		p_component.add(ckbx_component, gbc_ckbx_component);
		
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
		p_component.add(bt_addComponent, gbc_bt_addComponent);
		
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
		p_component.add(bt_deleteComponent, gbc_bt_deleteComponent);
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
		
		JScrollPane scrollPane_121 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_121 = new GridBagConstraints();
		gbc_scrollPane_121.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_121.gridwidth = 5;
		gbc_scrollPane_121.insets = new Insets(0, 20, 5, 20);
		gbc_scrollPane_121.gridx = 1;
		gbc_scrollPane_121.gridy = 7;
		p_component.add(scrollPane_121, gbc_scrollPane_121);
		
		tb_component = new JTable();
		scrollPane_121.setViewportView(tb_component);
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
		p_component.add(ckbx_connection, gbc_ckbx_connection);
		
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
		p_component.add(bt_addConnection, gbc_bt_addConnection);
		
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
		p_component.add(bt_deleteConnection, gbc_bt_deleteConnection);
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
		
		JScrollPane scrollPane_131 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_131 = new GridBagConstraints();
		gbc_scrollPane_131.insets = new Insets(0, 20, 5, 20);
		gbc_scrollPane_131.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_131.gridwidth = 5;
		gbc_scrollPane_131.gridx = 1;
		gbc_scrollPane_131.gridy = 9;
		p_component.add(scrollPane_131, gbc_scrollPane_131);
		
		tb_connection = new JTable();
		scrollPane_131.setViewportView(tb_connection);
		model_connection = new DefaultTableModel(new Object[][] {},new String[] {"Source", "Destination"});
		tb_connection.setModel(model_connection);
		tb_connection.setBackground(new Color(176, 224, 230));
		tb_connection.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
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
		
		p1 = new JPanel();
		buttonPanel.add(p1);
		
		bt_savePage = new JButton("保存编辑");
		bt_savePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savePageIsClicled = true;
				try {
					CreateRemoteSensorPlatformXML.DomCreate();
					save.setEnabled(true);
				} catch (Exception e1) {
					e1.printStackTrace();
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
		
		p2 = new JPanel();
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
		private JLabel lb_line4;
		
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
			setIconImage(Toolkit.getDefaultToolkit().getImage(RemoteSensorPlatformFrame.class.getResource("/sm/images/utils.png")));
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
			getContentPane().setLayout(new BorderLayout());
			setIconImage(Toolkit.getDefaultToolkit().getImage(RemoteSensorPlatformFrame.class.getResource("/sm/images/utils.png")));
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
			setIconImage(Toolkit.getDefaultToolkit().getImage(RemoteSensorPlatformFrame.class.getResource("/sm/images/utils.png")));
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
		private String[] parameterItem;
		private JTextArea ta_ParaDescription;
		private JTextArea ta_paraValue;


		/**
		 * Create the dialog.
		 */
		public ParameterFrame() {
			setTitle("输入对话框");
			setBounds(100, 100, 500, 650);
			setIconImage(Toolkit.getDefaultToolkit().getImage(RemoteSensorPlatformFrame.class.getResource("/sm/images/utils.png")));
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
				JLabel lb_name = new JLabel("\u53C2\u6570\u540D\u79F0\uFF1A");
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
				JLabel lb_paraDescription = new JLabel("\u53C2\u6570\u63CF\u8FF0\uFF1A");
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
				JLabel lb_item = new JLabel("\u53C2\u6570\u5217\u8868\uFF1A");
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
				JLabel lb_paraValue = new JLabel("\u53C2\u6570\u503C\uFF1A");
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
			setIconImage(Toolkit.getDefaultToolkit().getImage(RemoteSensorPlatformFrame.class.getResource("/sm/images/utils.png")));
			setTitle("输入对话框");
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
			setIconImage(Toolkit.getDefaultToolkit().getImage(RemoteSensorPlatformFrame.class.getResource("/sm/images/utils.png")));
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
	
	class viewer extends JDialog{
		private final JPanel contentPanel = new JPanel();
		private JTextArea ta_view;
		
		public viewer() {
			setTitle("查看");
			setIconImage(Toolkit.getDefaultToolkit().getImage("src/sm/images/view2.jpg"));
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
				FileReader fr = new FileReader(savePath );
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
