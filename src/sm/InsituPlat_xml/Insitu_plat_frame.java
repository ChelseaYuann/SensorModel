package sm.InsituPlat_xml;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import sm.main.UploadFrame;


public class Insitu_plat_frame extends JFrame{
	
	private static String savePath = "src/instance/insituSensorPlatform.xml";
	private Color White = new Color(255, 255, 255);
	private Color Grey = UIManager.getColor("TextArea.disabledBackground");
	private boolean saveIsClicked = false;
	private boolean savePageIsSelected = false;
	private int index;
	private JFrame frame;
	private static JTextArea ta_des;
	private JTextField org_ID;
	private static JTextArea ta_kwords;
	private static String[] keywords;
	private static JTextField tf_longname;
	private static JTextField tf_shortname;
	private static JTable table_sensor_id;
	private static JCheckBox check_otherId;
	private static JTable table_otherId;
	private static JTextArea ta_appli;
	private static JTextField tf_sitetype;
	private static JTextField tf_sensortype;
	private static JComboBox cb_siteLevel;
	public static JComboBox cb_shareLevel;
	private static JTextField ta_creat;
	private JTextField siteID;
	private static JCheckBox check_otherClass;
	private static JTable table_otherclass;
	private static JComboBox bgTM;
	private static JComboBox endTM;
	public static JCheckBox ckbx_legal;
	private static JTextArea ta_legalConstra;
	private static JCheckBox ckbx_safe;
	private static JTextArea ta_securityConstraint;
	private static JTextField textField_l;
	private static JTextField textField_w;
	private static JTextField textField_h;
	private static JTextField textField_m;
	private static JTextField textField_life;
	private static JTextField tf_humidLow;
	private static JTextField tf_tempLow;
	private static JTextField textField_protGrade;
	private static JCheckBox checkBox_power;
	private static JCheckBox checkBox_current;
	private static JCheckBox checkBox_voltage;
	private static JCheckBox chckbxw;
	private static JCheckBox chckbxw_1;
	private static JCheckBox chckbxm;
	private static JCheckBox ckbx_TransMode;
	private static JCheckBox chckbx_CSJG;
	private static JCheckBox checkBox_TXFS;
	private static JTextField textField_MTBF;
	private static JComboBox comboBox_power;
	public static JComboBox cbbx_TransMode;
	private static JTextField textField_currentMin;
	private static JTextField textField_currentMax;
	private static JTextField textField_voltageMin;
	private static JTextField textField_voltageMax;
	private static JTextField textField_pow;
	private static JTextField textField_outPow;
	private static JTextField textField_store;
	private static JTextField textField_CSJG;
	private static JTextField textField_TXFS;
	private static DefaultTableModel otherCharacterModel;
	private static JTable table_otherChara;
	private static JCheckBox checkBox_life;
	private static JCheckBox checkBox_humidR;
	private static JCheckBox checkBox_tempR;
	private static JCheckBox checkBox_protGrade;
	private static JCheckBox checkBox_MTBF;
	private static JCheckBox checkBox_isOperate;
	private static JTextField tf_Interval;
	private static JTextField tf_insituType;
	private static JTextField tf_overloadLow;
	private static JTextField tf_measuMin;
	private static JTextField tf_measuMax;
	private static JTextField tf_lWD;
	private static JTextField tf_uWD;
	private static JTextField tf_lJD;
	private static JTextField tf_uJD;
	private static JTextField tf_obsResolu;
	private static JTextField tf_radius;
	private static JTextField tf_sensi;
	private static JTextField tf_dura;
	private static JTextField tf_respon;
	private static JTextField tf_sensiTole;
	private static JTextField tf_accuracy;
	private static JTextField tf_repeat;
	private static JTextField tf_lag;
	private static JTextField tf_nonline;
	private static JTable tb_otherCapa;
	private static JTextField tf_pointSRS;
	private static JTextField tf_pointY;
	private static JTextField tf_pointX;
	private static JTextField tf_locSRS;
	private static JTextField tf_locLat;
	private static JTextField tf_locLon;
	private static JTextField tf_locAlt;
	private static JTextField tf_vldTm_name;
	private static JTextField tf_bgTM;
	private static JTextField tf_endTM;
	private static JTextField tf_orgniz;
	private static JTextField tf_person;
	private static JTextField tf_tele;
	private static JTextField tf_addr;
	private static JTextField tf_city;
	private static JTextField tf_admi;
	private static JTextField tf_country;
	private static JTextField tf_code;
	private static JTextField tf_email;
	private static JTable tb_contacID;
	private static JTable tb_inte;
	private static JTextField tf_EBeginTM;
	private static JTextField tf_EEndTM;
	private static JTextField tf_ETMIns;
	private static JTable tb_event;
	private static JTable tb_input;
	private static JTable tb_Out;
	private static JTable tb_param;
	private static JTable tb_comp;
	private JFileChooser jfc;
	private static JTextField tf_humidUp;
	private static JTextField tf_temUp;
	private static JComboBox comboBox_isOperate;
	private static JTextField tf_overloadUp;
	private static JTextField tf_dataQuliLevel;
	private static JTextField tf_dataFormat;
	private static JTextField tf_kword;
	private static JTextField tf_sensorName;
	private static JTextField tf_sensorID;
	private JTextField tf_otheridentifier;
	private JTextField tf_otherUID;
	private JTextField tf_otherclass;
	private JTextField tf_otherclassId;
	private JTextField tf_application;
	private JTextField tf_othercharactername;
	private JTextField tf_othercharactercontent;
	private static JCheckBox ckbx_detecPrinc;
	private static JCheckBox ckbx_overload;
	private static JCheckBox ckbx_measuRange;
	private static JCheckBox ckbx_obsResolu;
	private static JCheckBox ckbx_radius;
	private static JCheckBox ckbx_sensi;
	private static JCheckBox ckbx_Interval;
	private static JCheckBox ckbx_dura;
	private static JCheckBox ckbx_respon;
	private static JCheckBox ckbx_sensiTole;
	private static JCheckBox ckbx_accuracy;
	private static JCheckBox ckbx_repeat;
	private static JCheckBox ckbx_lag;
	private static JCheckBox ckbx_nonLine;
	private static JCheckBox ckbx_accessLevel;
	private static JCheckBox ckbx_dataQualiLevel;
	private static JCheckBox ckbx_dataFormat;
	private static JCheckBox ckbx_otherCapa;
	private static JTextArea ta_detecPrinc;
	private static JComboBox cbbox_accessLevel;
	private JTextField tf_otherCapName;
	private JTextField tf_otherCapContent;
	private static JRadioButton bt_text;
	private static JTextArea ta_text;
	private static JRadioButton bt_point;
	private static JRadioButton bt_location;
	private static JComboBox cbbx_role;
	private static JCheckBox ckbx_person;
	private static JCheckBox ckbx_tele;
	private static JCheckBox ckbx_addr;
	private static JRadioButton ckbx_ETime;
	private static JCheckBox ckbx_EDesc;
	private static JRadioButton ckbx_ETMIns;
	private static JCheckBox ckbx_output;
	private static JCheckBox ckbx_param;
	private static JCheckBox ckbx_comp;
	private static JTextArea ta_EDesc;
	public static DefaultTableModel contactModel;
	public static DefaultTableModel eventModel;
	private final ButtonGroup bg = new ButtonGroup();
	private static JCheckBox ckbx_eventID;
	private static JTextField tf_eventId;
	private static JTextField tf_eventLabel;
	private static JCheckBox ckbx_role;
	private static JCheckBox ckbx_orgniz;
	private static DefaultTableModel interfaceModel;
	private static DefaultTableModel inputModel;
	private static DefaultTableModel outputModel;
	private static DefaultTableModel parameterModel;
	private static DefaultTableModel componentModel;
	private static DefaultTableModel connectionModel;
	private static JTable tb_connection;
	private static JCheckBox ckbx_connection;
	private static JCheckBox checkBox_otherChara;
	private JPanel des_panel;
	private JPanel cst_panel;
	private JPanel capa_panel;
	private JPanel cont_panel;
	private JPanel comp_panel;
	private JButton bt_savePage;
	private JButton bt_clearPage;
	private JButton bt_nextItem;
	private JButton bt_nextPage;
	private JButton bt_preItem;
	private JButton bt_prePage;
	private JPanel pblankLeft;
	private JPanel pblank;
	private JTabbedPane tP_capa;
	private JPanel panel_charac;
	private JPanel panel_capab;
	private JPanel panel_posi;
	private JButton save;
	private JButton bt_add_otherClass;
	private JButton bt_delete_otherClass;
	private JCheckBox chckbx_w;
	private DefaultTableModel tableotherClass;
	private DefaultTableModel model_otherCapa;
	private JButton bt_addCharacter;
	private JButton bt_deleCharacter;
	private JButton bt_addcapa;
	private JButton bt_deleCapa;
	private JButton bt_addIn;
	private JButton bt_deleIn;
	
	public static String getDescription(){
		return ta_des.getText();
	}

	public static String getUniqueID() {
		return ta_creat.getText();
	}
	
	public static String []getKeyword() {
		String[] keyword = ta_kwords.getText().trim().split("\n");
		return keyword;
	}
	
	public static String getLongname() {
		return tf_longname.getText();
	}
	
	public static String getShortname() {
		return tf_shortname.getText();
	}
	
	public static int getTableRow() {
		return table_sensor_id.getRowCount();
	}
	
	public static String getAssociatedSensorInfo(int a,int b){
		return table_sensor_id.getValueAt(a, b).toString();
	}
	
	public static boolean getCheckOtherID() {
		return check_otherId.isSelected();
	}
	
	public static int getOtherIdRow() {
		return table_otherId.getRowCount();
	}
	public static String getOtherIdentifierInfo(int a,int b){
		return table_otherId.getValueAt(a, b).toString();
	}
	
	public static String getSiteType() {
		return tf_sitetype.getText();
	}
	
	public static String getSensorType() {
		return tf_sensortype.getText();
	}
	
	public static String getStationLevel(){
		return (String) cb_siteLevel.getSelectedItem();
	}
	
	public static String getSharingLevel() {
		return (String)cb_shareLevel.getSelectedItem();
	}
	
	public static String[] getIntendedApplication() {
		String[] app = ta_appli.getText().trim().split("\n");
		return app;
	}
	
	public static boolean getCheckOtherClassifier() {
		if (check_otherClass.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static int getOtherClassifierRow() {
		return table_otherclass.getRowCount();
	}
	
	public static String getOtherClassifier(int a,int b){
		return table_otherclass.getValueAt(a, b).toString();
	}
	
	public static String getBeginTMChoice() {
		return bgTM.getSelectedItem().toString();
	}
	
	public static String getBeginTM() {
		return tf_bgTM.getText();
	}
	
	public static String getEndTMChoice() {
		return endTM.getSelectedItem().toString();
	}
	
	public static String getEndTM() {
		return tf_endTM.getText();
	}
	
	public static boolean checkLegal() {
		if (ckbx_legal.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean getCheckSecurity() {
		if (ckbx_safe.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String getLegalConstraint() {
		return ta_legalConstra.getText();
	}
	
	public static String getSecurityConstraint() {
		return ta_securityConstraint.getText();
	}
	
	public static String getPhyscLength() {
		return textField_l.getText();
	}
	
	public static String getPhyscWidth() {
		return textField_w.getText();
	}
	
	public static String getPhyscHeight() {
		return textField_h.getText();
	}
	
	public static String getPhyscWeight() {
		return textField_m.getText();
	}
	
	public static boolean checkCurrentType() {
		if (checkBox_power.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String getCurrentType() {
		return comboBox_power.getSelectedItem().toString();
	}
	
	public static boolean checkCurrent() {
		if (checkBox_current.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String getCurrentLow() {
		return textField_currentMin.getText();
	}
	
	public static String getCurrentUp() {
		return textField_currentMax.getText();
	}
	
	public static boolean checkVoltage() {
		if (checkBox_voltage.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String getVoltageLow() {
		return textField_voltageMin.getText();
	}
	
	public static String getVoltageUp() {
		return textField_voltageMax.getText();
	}
	
	public static boolean checkPower() {
		if (chckbxw.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String getPower() {
		return textField_pow.getText();
	}
	
	public static boolean checkOutPower() {
		if (chckbxw_1.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String getOutPower() {
		return textField_outPow.getText();
	}
	
	public static boolean checkStorage() {
		if (chckbxm.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String getStorage() {
		return textField_store.getText();
	}
	
	public static boolean checkTransMode() {
		if (chckbx_CSJG.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String getTransMode() {
		return cbbx_TransMode.getSelectedItem().toString();
	}
	
	public static boolean checkTSJG() {
		if (chckbx_CSJG.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String getTSJG() {
		return textField_CSJG.getText();
	}
	
	public static boolean checkTXFS() {
		if (checkBox_TXFS.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String getTXFS() {
		return textField_TXFS.getText();
	}
	
	public static boolean checkLife() {
		if (checkBox_life.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkHumidity() {
		if (checkBox_humidR.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkTemprature() {
		if (checkBox_tempR.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkProtectionGrade() {
		if (checkBox_protGrade.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkMTBF() {
		if (checkBox_MTBF.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkIsOperab() {
		if (checkBox_isOperate.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String getlWD() {
		return tf_lWD.getText();
	}
	
	public static String getuWD() {
		return tf_uWD.getText();
	}
	
	public static String getlJD() {
		return tf_lJD.getText();
	}
	
	public static String getuJD() {
		return tf_uJD.getText();
	}
	
	public static String getLife() {
		return textField_life.getText();
	}
	
    public static String getHumidityMin() {
		return tf_humidLow.getText();
	}
	
    public static String getHumidityMax() {
		return tf_humidUp.getText();
	}
    
    public static String getTempratureMin() {
		return tf_tempLow.getText();
	}
    
    public static String getTempratureMax() {
		return tf_temUp.getText();
	}
	
    public static String getProtectionGrade() {
		return textField_protGrade.getText();
	}
	
    public static String getMTBF() {
		return textField_MTBF.getText();
	}
	
    public static String getIsOperable() {
		return comboBox_isOperate.getSelectedItem().toString();
	}
	
    public static String getInsituType() {
		return tf_insituType.getText();
	}
    
    public static boolean checkDetectionPrinciple() {
		if (ckbx_detecPrinc.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getDetectionPrinciple() {
		return ta_detecPrinc.getText();
	}
    
    public static boolean checkOverloadLimitation() {
		if (ckbx_overload.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getOverloadMin() {
		return tf_overloadLow.getText();
	}
    
    public static String getOverloadMax() {
		return tf_overloadUp.getText();
	}
    
    public static boolean checkMeasurementRange() {
		if (ckbx_measuRange.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getMeasurRangeMin() {
		return tf_measuMin.getText();
	}
    
    public static String getMeasurRangeMax() {
		return tf_measuMax.getText();
	}
    
    
    public static boolean checkObservationResolution() {
		if (ckbx_obsResolu.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getObserveResolution() {
		return tf_obsResolu.getText();
	}
    
    public static boolean checkObservationRadius() {
		if (ckbx_radius.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getObserveRadius() {
		return tf_radius.getText();
	}
    
    public static boolean checksensitivity() {
		if (ckbx_sensi.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getSensitivity() {
		return tf_sensi.getText();
	}
    
    public static boolean checkInterval() {
		if (ckbx_Interval.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getInterval() {
		return tf_Interval.getText();
	}
    
    public static boolean checkDuration() {
		if (ckbx_dura.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getDuration() {
		return tf_dura.getText();
	}
    
    public static boolean checkRespondTime() {
		if (ckbx_respon.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getRespondTime() {
		return tf_respon.getText();
	}
    
    public static boolean checkSensitivityTolerance() {
		if (ckbx_sensiTole.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getSensitivityTolerence() {
		return tf_sensiTole.getText();
	}
    
    public static boolean checkDetectionAccuracy() {
		if (ckbx_accuracy.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getDetectionAccuracy() {
		return tf_accuracy.getText();
	}
    
    public static boolean checkRepeatability() {
		if (ckbx_repeat.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getRepeatability() {
		return tf_repeat.getText();
	}
    
    public static boolean checkLagTolerance() {
		if (ckbx_lag.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getLagTolerance() {
		return tf_lag.getText();
	}
    
    public static boolean checkNonlinearityError() {
		if (ckbx_nonLine.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getNonlinearError() {
		return tf_nonline.getText();
	}
    
    public static boolean checkDataAccessLevel() {
		if (ckbx_accessLevel.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getDataAccessLevel() {
		return cbbox_accessLevel.getSelectedItem().toString();
	}
    
    public static boolean checkDataFormat() {
		if (ckbx_dataFormat.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getDataFormat() {
		return tf_dataFormat.getText();
	}
    
    public static boolean checkDataQualityLevel() {
		if (ckbx_dataQualiLevel.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getDataQuantityLevel() {
		return tf_dataQuliLevel.getText();
	}
    
    public static boolean checkOtherCapability() {
		if (ckbx_otherCapa.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static boolean checkOtherCharacter() {
		if (ckbx_otherCapa.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static int getOtherCapabilityRow() {
    	return tb_otherCapa.getRowCount();
    }
    
    public static String getOtherCapability(int a,int b) {
		return tb_otherCapa.getValueAt(a, b).toString();
	}

    public static int checkPositionChoice() {
    	if (bt_text.isSelected()) {
			return 1;
		}else if (bt_point.isSelected()) {
			return 2;
		}else if(bt_location.isSelected()){
			return 3;
		}else {
			return 0;
		}
    }
    
    public static String getTextPosition() {
    	return ta_text.getText();
    }
    
    public static String getPointSRS() {
		return tf_pointSRS.getText();
	}
    
    public static String getPointX() {
		return tf_pointX.getText();
	}
    
    public static String getPointY() {
		return tf_pointY.getText();
	}
    
    public static String getLocSRS() {
		return tf_locSRS.getText();
	}
    
    public static String getLocAlt() {
		return tf_locAlt.getText();
	}
    
    public static String getLocLon() {
		return tf_locLon.getText();
	}
    
    public static String getLocLat() {
		return tf_locLat.getText();
	}
    
    public static boolean checkRole() {
		if (ckbx_role.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static boolean checkOrganization() {
		if (ckbx_orgniz.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static boolean checkPerson() {
		if (ckbx_person.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static boolean checkTele() {
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
    
    public static boolean checkEventDescription() {
		if (ckbx_EDesc.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
    
    public static int checkETimeChoice() {
		if (ckbx_ETime.isSelected()) {
			return 1;
		}else if (ckbx_ETMIns.isSelected()) {
			return 2;
		}else {
			return 0;
		}
	}
    
    public static String getResponsibleParty() {
		return cbbx_role.getSelectedItem().toString();
	}
    
    public static String getOrganization() {
		return tf_orgniz.getText();
	}
    
    public static String getPerson() {
		return tf_person.getText();
	}
    
    public static String getTelephone() {
		return tf_tele.getText();
	}
    
    public static String getAddress() {
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
    
    public static String getCode() {
		return tf_code.getText();
	}
    
    public static String getEMail() {
		return tf_email.getText();
	}
    
    public static boolean checkEventID() {
		if (ckbx_eventID.isSelected()) {
			return true;
		}else {
			return false;
		}
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
    
    public static String getEBeginTM() {
		return tf_EBeginTM.getText();
	}
    
    public static String getEEndTM() {
		return tf_EEndTM.getText();
	}
    
    public static String getEventInstance() {
		return tf_ETMIns.getText();
	}
    
    public static int getContactRow() {
		return tb_contacID.getRowCount();
	}
    
    public static String getContactInfo(int a,int b) {
		return tb_contacID.getValueAt(a, b).toString();
	}
    
    public static int getEventRow() {
		return tb_event.getRowCount();
	}
    
    public static String getEventInfo(int a,int b) {
		return tb_event.getValueAt(a, b).toString();
	}
    
    public static int getInterfaceRow() {
		return tb_inte.getRowCount();
	}
    
    public static String getInterfaceInfo(int a,int b) {
		return tb_inte.getValueAt(a, b).toString();
	}
    
    public static String getInputInfo(int a,int b) {
		return tb_input.getValueAt(a, b).toString();
	}
    
    public static int getInputRow() {
		return tb_input.getRowCount();
	}
    
    public static int getOutputRow() {
		return tb_Out.getRowCount();
	}
    
    public static String getOutputInfo(int a,int b) {
		return tb_Out.getValueAt(a, b).toString();
	}
    
    public static int getParameterRow() {
		return tb_param.getRowCount();
	}
    
    public static String getParameterInfo(int a,int b) {
		return tb_param.getValueAt(a, b).toString();
	}
    
    public static int getComponentRow() {
		return tb_comp.getRowCount();
	}
    
    public static String getComponentInfo(int a,int b) {
		return tb_comp.getValueAt(a, b).toString();
	}
    
    public static int getConnectionRow() {
		return tb_connection.getRowCount();
	}
    
    public static String getConnectInfo(int a,int b) {
		return tb_connection.getValueAt(a, b).toString();
	}
    

    
    public static int getOtherCharacterRow() {
		return table_otherChara.getRowCount();
	}
    
    public static String getOtherCharacterInfo(int a,int b) {
		return table_otherChara.getValueAt(a, b).toString();
	}
    
       
	
	/**
	 * Initialize the contents of the frame.
	 */
	public Insitu_plat_frame() {
		init();
	}
	
	public void init() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Insitu_plat_frame.class.getResource("/sm/images/原位站点.png")));
		frame.setResizable(false);
		frame.setTitle("通用地面站点建模");
		frame.setBounds(400,100,850, 780);
		
		//初始化工具条
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
	
		save = new JButton("保存");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveIsClicked = true;
				if (savePageIsSelected==true) {
					Temp1_xml.saveXML();
				}else if(savePageIsSelected==false){
					tipsDialog saveTip = new tipsDialog("请先对模型进行“保存编辑”操作！");
					saveTip.setLocationRelativeTo(frame);
					saveTip.setVisible(true);
				}
			}
		});
		save.setIcon(new ImageIcon(Insitu_plat_frame.class.getResource("/sm/images/save.jpg")));
		toolBar.add(save);
		
//		JButton clear = new JButton("清空");
//		clear.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
//		clear.setIcon(new ImageIcon(Insitu_plat_frame.class.getResource("/sm/images/clear.jpg")));
//		toolBar.add(clear);
		
		JButton view = new JButton("查看");
		view.setIcon(new ImageIcon(Insitu_plat_frame.class.getResource("/sm/images/view2.jpg")));
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
		
		JButton annex = new JButton("附件");
		annex.setIcon(new ImageIcon(Insitu_plat_frame.class.getResource("/sm/images/annex.jpg")));
		toolBar.add(annex);
		annex.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				UploadFrame fr = new UploadFrame();
				fr.setLocationRelativeTo(frame);
			}
		});
		
		JTabbedPane tp = new JTabbedPane(JTabbedPane.TOP);
		tp.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int selectedIndex = tp.getSelectedIndex();  //获得选中的选项卡索引
                String title = tp.getTitleAt(selectedIndex); //获得选项卡标签
                index = selectedIndex;
			}
		});
		frame.getContentPane().add(tp, BorderLayout.CENTER);
		//站点标识信息页面
		des_panel = new JPanel();
		tp.addTab("站点标识信息", null, des_panel, null);
		GridBagLayout gbl_des_panel = new GridBagLayout();
		gbl_des_panel.columnWidths = new int[]{325, 325, 0};
		gbl_des_panel.rowHeights = new int[]{581, 0};
		gbl_des_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_des_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		des_panel.setLayout(gbl_des_panel);
		
		JPanel p1 = new JPanel();
		GridBagConstraints gbc_p1 = new GridBagConstraints();
		gbc_p1.insets = new Insets(0, 0, 0, 5);
		gbc_p1.fill = GridBagConstraints.BOTH;
		gbc_p1.gridx = 0;
		gbc_p1.gridy = 0;
		des_panel.add(p1, gbc_p1);
		GridBagLayout gbl_p1 = new GridBagLayout();
		gbl_p1.columnWidths = new int[]{78, 17, 56, 15, 0, 27, 0};
		gbl_p1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 0, 0, 74, 0, 0};
		gbl_p1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_p1.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		p1.setLayout(gbl_p1);
		
		JLabel label_des = new JLabel("站点描述：");
		GridBagConstraints gbc_label_des = new GridBagConstraints();
		gbc_label_des.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_des.gridwidth = 4;
		gbc_label_des.insets = new Insets(15, 10, 5, 5);
		gbc_label_des.gridx = 0;
		gbc_label_des.gridy = 0;
		p1.add(label_des, gbc_label_des);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.insets = new Insets(0, 10, 5, 10);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		p1.add(scrollPane, gbc_scrollPane);
		
		ta_des = new JTextArea();
		ta_des.setLineWrap(true);
		scrollPane.setViewportView(ta_des);
		
		JLabel label_id = new JLabel("标识符");
		GridBagConstraints gbc_label_id = new GridBagConstraints();
		gbc_label_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_id.gridwidth = 2;
		gbc_label_id.insets = new Insets(0, 10, 5, 5);
		gbc_label_id.gridx = 0;
		gbc_label_id.gridy = 2;
		p1.add(label_id, gbc_label_id);
		
		JCheckBox check_UID = new JCheckBox("唯一标识码:");
		check_UID.setPreferredSize(new Dimension(85, 23));
		check_UID.setSelected(true);
		GridBagConstraints gbc_check_UID = new GridBagConstraints();
		gbc_check_UID.fill = GridBagConstraints.HORIZONTAL;
		gbc_check_UID.insets = new Insets(0, 10, 5, 5);
		gbc_check_UID.gridx = 0;
		gbc_check_UID.gridy = 3;
		p1.add(check_UID, gbc_check_UID);
		
		org_ID = new JTextField();
		org_ID.addMouseListener(new MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent e) {
				org_ID.setForeground(Color.black);
				org_ID.setBorder(new LineBorder(Color.black));
				org_ID.setText("");
			}
		});
		hintText hintOrgID = new hintText(org_ID, "请输入组织标识");
		org_ID.addFocusListener(new JTextFieldHintListener("请输入组织标识", org_ID));
		GridBagConstraints gbc_org_ID = new GridBagConstraints();
		gbc_org_ID.gridwidth = 5;
		gbc_org_ID.insets = new Insets(0, 0, 5, 0);
		gbc_org_ID.fill = GridBagConstraints.HORIZONTAL;
		gbc_org_ID.gridx = 1;
		gbc_org_ID.gridy = 3;
		p1.add(org_ID, gbc_org_ID);
		org_ID.setColumns(10);
		
		siteID = new JTextField();
		siteID.addMouseListener(new MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent e) {
				siteID.setForeground(Color.black);
				siteID.setBorder(new LineBorder(Color.black));
				siteID.setText("");
			}
		});
		hintText hintSiteID = new hintText(siteID, "请输入站点标识");
		siteID.addFocusListener(new JTextFieldHintListener("请输入站点标识", siteID));
		GridBagConstraints gbc_siteID = new GridBagConstraints();
		gbc_siteID.gridwidth = 5;
		gbc_siteID.insets = new Insets(0, 0, 5, 0);
		gbc_siteID.fill = GridBagConstraints.HORIZONTAL;
		gbc_siteID.gridx = 1;
		gbc_siteID.gridy = 4;
		p1.add(siteID, gbc_siteID);
		siteID.setColumns(10);
		
		JButton create = new JButton("生成");
		create.setMinimumSize(new Dimension(30, 23));
		create.setMaximumSize(new Dimension(30, 23));
		create.setPreferredSize(new Dimension(30, 20));
		GridBagConstraints gbc_create = new GridBagConstraints();
		gbc_create.fill = GridBagConstraints.HORIZONTAL;
		gbc_create.insets = new Insets(0, 10, 5, 5);
		gbc_create.gridx = 0;
		gbc_create.gridy = 5;
		p1.add(create, gbc_create);
		
		ta_creat = new JTextField();
		ta_creat.setBackground(Color.WHITE);
		GridBagConstraints gbc_ta_creat = new GridBagConstraints();
		gbc_ta_creat.gridwidth = 5;
		gbc_ta_creat.insets = new Insets(0, 0, 5, 0);
		gbc_ta_creat.fill = GridBagConstraints.HORIZONTAL;
		gbc_ta_creat.gridx = 1;
		gbc_ta_creat.gridy = 5;
		p1.add(ta_creat, gbc_ta_creat);
		ta_creat.setColumns(10);
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((!org_ID.getText().equals(""))&&(!siteID.getText().equals(""))
						&&(!org_ID.getText().equals("请输入组织标识"))&&(!siteID.getText().equals("请输入站点标识"))) {
					ta_creat.setText("urn:"+org_ID.getText()+":insituSensor:platform:"+siteID.getText());
				}else if (org_ID.getText().equals("")||siteID.getText().equals("")) {
					org_ID.setBorder(new LineBorder(Color.RED));
					org_ID.setForeground(Color.RED);
					org_ID.setText("请输入组织标识");
					siteID.setBorder(new LineBorder(Color.RED));
					siteID.setForeground(Color.RED);
					siteID.setText("请输入站点标识");
				}	
			}
		});
		
		JCheckBox check_longnname = new JCheckBox("站点全称:");
		check_longnname.setSelected(true);
		GridBagConstraints gbc_check_longnname = new GridBagConstraints();
		gbc_check_longnname.fill = GridBagConstraints.HORIZONTAL;
		gbc_check_longnname.insets = new Insets(0, 10, 5, 5);
		gbc_check_longnname.gridx = 0;
		gbc_check_longnname.gridy = 6;
		p1.add(check_longnname, gbc_check_longnname);
		
		tf_longname = new JTextField();
		GridBagConstraints gbc_tf_longname = new GridBagConstraints();
		gbc_tf_longname.gridwidth = 5;
		gbc_tf_longname.insets = new Insets(0, 0, 5, 0);
		gbc_tf_longname.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_longname.gridx = 1;
		gbc_tf_longname.gridy = 6;
		p1.add(tf_longname, gbc_tf_longname);
		tf_longname.setColumns(10);
		
		JCheckBox check_shortname = new JCheckBox("站点简称:");
		check_shortname.setSelected(true);
		GridBagConstraints gbc_check_shortname = new GridBagConstraints();
		gbc_check_shortname.fill = GridBagConstraints.HORIZONTAL;
		gbc_check_shortname.insets = new Insets(0, 10, 5, 5);
		gbc_check_shortname.gridx = 0;
		gbc_check_shortname.gridy = 7;
		p1.add(check_shortname, gbc_check_shortname);
		
		tf_shortname = new JTextField();
		GridBagConstraints gbc_tf_shortname = new GridBagConstraints();
		gbc_tf_shortname.gridwidth = 5;
		gbc_tf_shortname.insets = new Insets(0, 0, 5, 0);
		gbc_tf_shortname.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_shortname.gridx = 1;
		gbc_tf_shortname.gridy = 7;
		p1.add(tf_shortname, gbc_tf_shortname);
		tf_shortname.setColumns(10);
		
		JCheckBox check_sensor_id = new JCheckBox("搭载传感器标识");
		check_sensor_id.setHideActionText(true);
		check_sensor_id.setSelected(true);
		GridBagConstraints gbc_check_sensor_id = new GridBagConstraints();
		gbc_check_sensor_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_check_sensor_id.gridwidth = 4;
		gbc_check_sensor_id.insets = new Insets(0, 10, 5, 5);
		gbc_check_sensor_id.gridx = 0;
		gbc_check_sensor_id.gridy = 8;
		p1.add(check_sensor_id, gbc_check_sensor_id);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_5 = new GridBagConstraints();
		gbc_scrollPane_5.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_5.gridwidth = 6;
		gbc_scrollPane_5.insets = new Insets(0, 5, 5, 0);
		gbc_scrollPane_5.gridx = 0;
		gbc_scrollPane_5.gridy = 9;
		p1.add(scrollPane_5, gbc_scrollPane_5);
		
		table_sensor_id = new JTable();
		table_sensor_id.setBackground(new Color(175, 238, 238));
		scrollPane_5.setViewportView(table_sensor_id);
		DefaultTableModel model= new DefaultTableModel(
				new Object[][] {},
				new String[] {"传感器名称", "传感器标识码"}
			);
		table_sensor_id.setModel(model);
		table_sensor_id.getColumnModel().getColumn(0).setPreferredWidth(85);
		table_sensor_id.getColumnModel().getColumn(1).setPreferredWidth(200);
		table_sensor_id.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单行选中模式
		table_sensor_id.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){
                int selectedRow = table_sensor_id.getSelectedRow(); //获得选中行索引
                Object oa = model.getValueAt(selectedRow, 0);
                Object ob = model.getValueAt(selectedRow, 1);
                tf_sensorName.setText(oa.toString());  //给文本框赋值
                tf_sensorID.setText(ob.toString());
            }
        });
		
		tf_sensorName = new JTextField();
		hintText hintSensorName = new hintText(tf_sensorName, "如：雷达水位计");
		tf_sensorName.addFocusListener(new JTextFieldHintListener("如：雷达水位计", tf_sensorName));
		GridBagConstraints gbc_tf_sensorName = new GridBagConstraints();
		gbc_tf_sensorName.insets = new Insets(0, 5, 5, 5);
		gbc_tf_sensorName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_sensorName.gridx = 0;
		gbc_tf_sensorName.gridy = 10;
		p1.add(tf_sensorName, gbc_tf_sensorName);
		tf_sensorName.setColumns(10);
		
		tf_sensorID = new JTextField();
		hintText hintSensorID = new hintText(tf_sensorID, "如：Hydrological");
		tf_sensorID.addFocusListener(new JTextFieldHintListener("如：Hydrological", tf_sensorID));
		GridBagConstraints gbc_tf_sensorID = new GridBagConstraints();
		gbc_tf_sensorID.gridwidth = 3;
		gbc_tf_sensorID.insets = new Insets(0, 0, 5, 5);
		gbc_tf_sensorID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_sensorID.gridx = 1;
		gbc_tf_sensorID.gridy = 10;
		p1.add(tf_sensorID, gbc_tf_sensorID);
		tf_sensorID.setColumns(10);
		
		JButton bt_addSensorID = new JButton("增加");
		bt_addSensorID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_sensorName.getText(),"urn:ogc:feature:insiteSensor:"+tf_sensorID.getText()};
				model.addRow(info);//添加一行
//				int rowCount = table_sensor_id.getRowCount()+1;//行数加一
				tf_sensorName.setText("");
				tf_sensorID.setText("");
			}
		});
		GridBagConstraints gbc_bt_addSensorID = new GridBagConstraints();
		gbc_bt_addSensorID.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addSensorID.gridx = 4;
		gbc_bt_addSensorID.gridy = 10;
		p1.add(bt_addSensorID, gbc_bt_addSensorID);
		
		JButton bt_deleteSensorID = new JButton("删除");
		bt_deleteSensorID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table_sensor_id.getSelectedRow();//获得选中行的索引
				if(selectedRow!=-1)  //存在选中行
                {
                    model.removeRow(selectedRow);  //删除行
                }
			}
		});
		GridBagConstraints gbc_bt_deleteSensorID = new GridBagConstraints();
		gbc_bt_deleteSensorID.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt_deleteSensorID.insets = new Insets(0, 0, 5, 0);
		gbc_bt_deleteSensorID.gridx = 5;
		gbc_bt_deleteSensorID.gridy = 10;
		p1.add(bt_deleteSensorID, gbc_bt_deleteSensorID);
		
		check_otherId = new JCheckBox("添加其它标识");
		check_otherId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (check_otherId.isSelected()) {
					tf_otheridentifier.setEditable(true);
					tf_otherUID.setEditable(true);
					tf_otheridentifier.setBackground(White);
					tf_otherUID.setBackground(White);
				}else if (!check_otherId.isSelected()) {
					tf_otheridentifier.setEditable(false);
					tf_otherUID.setEditable(false);
					tf_otheridentifier.setBackground(Grey);
					tf_otherUID.setBackground(Grey);
					tf_otherUID.setText("");
					tf_otheridentifier.setText("");
					model.setRowCount(0);
				}	
			}
		});
		GridBagConstraints gbc_check_otherId = new GridBagConstraints();
		gbc_check_otherId.fill = GridBagConstraints.HORIZONTAL;
		gbc_check_otherId.gridwidth = 4;
		gbc_check_otherId.insets = new Insets(0, 10, 5, 5);
		gbc_check_otherId.gridx = 0;
		gbc_check_otherId.gridy = 11;
		p1.add(check_otherId, gbc_check_otherId);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
		gbc_scrollPane_4.insets = new Insets(0, 5, 5, 0);
		gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_4.gridwidth = 6;
		gbc_scrollPane_4.gridx = 0;
		gbc_scrollPane_4.gridy = 12;
		p1.add(scrollPane_4, gbc_scrollPane_4);
		
		table_otherId = new JTable();
		table_otherId.setBackground(new Color(175, 238, 238));
		DefaultTableModel otherIdentifierTable = new DefaultTableModel(new Object[][] {},new String[] {"标识名称", "标识内容"});
		table_otherId.setModel(otherIdentifierTable);
		table_otherId.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_otherId.getColumnModel().getColumn(1).setPreferredWidth(130);
		scrollPane_4.setViewportView(table_otherId);
		table_otherId.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单行选中模式
		table_otherId.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){
                int selectedRow = table_otherId.getSelectedRow(); //获得选中行索引
                Object oa = otherIdentifierTable.getValueAt(selectedRow, 0);
                Object ob = otherIdentifierTable.getValueAt(selectedRow, 1);
                tf_otheridentifier.setText(oa.toString());  //给文本框赋值
                tf_otherUID.setText(ob.toString());
            }
        });
		
		tf_otheridentifier = new JTextField();
		tf_otheridentifier.setEditable(false);
		tf_otheridentifier.setColumns(10);
		GridBagConstraints gbc_tf_otheridentifier = new GridBagConstraints();
		gbc_tf_otheridentifier.insets = new Insets(0, 0, 0, 5);
		gbc_tf_otheridentifier.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otheridentifier.gridx = 0;
		gbc_tf_otheridentifier.gridy = 13;
		p1.add(tf_otheridentifier, gbc_tf_otheridentifier);
		
		tf_otherUID = new JTextField("");
		tf_otherUID.setEditable(false);
		tf_otherUID.setColumns(10);
		GridBagConstraints gbc_tf_otherUID = new GridBagConstraints();
		gbc_tf_otherUID.gridwidth = 3;
		gbc_tf_otherUID.insets = new Insets(0, 0, 0, 5);
		gbc_tf_otherUID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherUID.gridx = 1;
		gbc_tf_otherUID.gridy = 13;
		p1.add(tf_otherUID, gbc_tf_otherUID);
		
		JButton bt_addID = new JButton("增加");
		bt_addID.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] info = {tf_otheridentifier.getText(),tf_otherUID.getText()};
					otherIdentifierTable.addRow(info);//添加一行
					tf_otheridentifier.setText("");
					tf_otherUID.setText("");
			}
		});
		GridBagConstraints gbc_bt_addID = new GridBagConstraints();
		gbc_bt_addID.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt_addID.insets = new Insets(0, 0, 0, 5);
		gbc_bt_addID.gridx = 4;
		gbc_bt_addID.gridy = 13;
		p1.add(bt_addID, gbc_bt_addID);
		
		JButton bt_deleteID = new JButton("删除");
		bt_deleteID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table_otherId.getSelectedRow();//获得选中行的索引
				if(selectedRow!=-1)  //存在选中行
                {
					otherIdentifierTable.removeRow(selectedRow);  //删除行
                }
			}
		});
		GridBagConstraints gbc_bt_deleteID = new GridBagConstraints();
		gbc_bt_deleteID.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt_deleteID.gridx = 5;
		gbc_bt_deleteID.gridy = 13;
		p1.add(bt_deleteID, gbc_bt_deleteID);
		
		JPanel p2 = new JPanel();
		p2.setFocusable(false);
		GridBagConstraints gbc_p2 = new GridBagConstraints();
		gbc_p2.fill = GridBagConstraints.BOTH;
		gbc_p2.gridx = 1;
		gbc_p2.gridy = 0;
		des_panel.add(p2, gbc_p2);
		GridBagLayout gbl_p2 = new GridBagLayout();
		gbl_p2.columnWidths = new int[]{139, 140, -25, 70, 0, 0};
		gbl_p2.rowHeights = new int[]{25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0, 21, 0, 0};
		gbl_p2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_p2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0};
		p2.setLayout(gbl_p2);
		
		JLabel label_key = new JLabel("站点发现关键词:");
		GridBagConstraints gbc_label_key = new GridBagConstraints();
		gbc_label_key.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_key.gridwidth = 4;
		gbc_label_key.insets = new Insets(15, 10, 5, 5);
		gbc_label_key.gridx = 0;
		gbc_label_key.gridy = 0;
		p2.add(label_key, gbc_label_key);
		
		tf_kword = new JTextField();
		hintText hintKeyword = new hintText(tf_kword, "原位/水文监测/……");
		tf_kword.addFocusListener(new JTextFieldHintListener("原位/水文监测/……", tf_kword));
		GridBagConstraints gbc_tf_kword = new GridBagConstraints();
		gbc_tf_kword.insets = new Insets(0, 5, 5, 5);
		gbc_tf_kword.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_kword.gridx = 0;
		gbc_tf_kword.gridy = 1;
		p2.add(tf_kword, gbc_tf_kword);
		tf_kword.setColumns(10);
		
		JButton bt_add_key = new JButton("增加");
		bt_add_key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keyword = tf_kword.getText();
				ta_kwords.append(keyword+"\n");
				tf_kword.setText("");
			}
		});
		GridBagConstraints gbc_bt_add_key = new GridBagConstraints();
		gbc_bt_add_key.insets = new Insets(0, 0, 5, 10);
		gbc_bt_add_key.gridx = 1;
		gbc_bt_add_key.gridy = 1;
		p2.add(bt_add_key, gbc_bt_add_key);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridheight = 3;
		gbc_scrollPane_2.gridwidth = 3;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 10);
		gbc_scrollPane_2.gridx = 2;
		gbc_scrollPane_2.gridy = 1;
		p2.add(scrollPane_2, gbc_scrollPane_2);
		
		ta_kwords = new JTextArea();
		ta_kwords.setBackground(SystemColor.info);
		scrollPane_2.setViewportView(ta_kwords);
		
		JButton bt_delete_key = new JButton("清空");
		bt_delete_key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta_kwords.setText("");
			}
		});
		GridBagConstraints gbc_bt_delete_key = new GridBagConstraints();
		gbc_bt_delete_key.insets = new Insets(0, 0, 5, 10);
		gbc_bt_delete_key.gridx = 1;
		gbc_bt_delete_key.gridy = 2;
		p2.add(bt_delete_key, gbc_bt_delete_key);
		
		JLabel label_classi = new JLabel("分类符");
		GridBagConstraints gbc_label_classi = new GridBagConstraints();
		gbc_label_classi.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_classi.gridwidth = 2;
		gbc_label_classi.insets = new Insets(0, 10, 5, 5);
		gbc_label_classi.gridx = 0;
		gbc_label_classi.gridy = 4;
		p2.add(label_classi, gbc_label_classi);
		
		JCheckBox check_sitetype = new JCheckBox("站点类型:");
		check_sitetype.setSelected(true);
		GridBagConstraints gbc_check_sitetype = new GridBagConstraints();
		gbc_check_sitetype.fill = GridBagConstraints.HORIZONTAL;
		gbc_check_sitetype.insets = new Insets(0, 10, 5, 5);
		gbc_check_sitetype.gridx = 0;
		gbc_check_sitetype.gridy = 5;
		p2.add(check_sitetype, gbc_check_sitetype);
		
		tf_sitetype = new JTextField();
		GridBagConstraints gbc_tf_sitetype = new GridBagConstraints();
		gbc_tf_sitetype.gridwidth = 4;
		gbc_tf_sitetype.insets = new Insets(0, 0, 5, 10);
		gbc_tf_sitetype.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_sitetype.gridx = 1;
		gbc_tf_sitetype.gridy = 5;
		p2.add(tf_sitetype, gbc_tf_sitetype);
		tf_sitetype.setColumns(10);
		
		JCheckBox check_sensortype = new JCheckBox("传感器类型:");
		check_sensortype.setSelected(true);
		GridBagConstraints gbc_check_sensortype = new GridBagConstraints();
		gbc_check_sensortype.fill = GridBagConstraints.HORIZONTAL;
		gbc_check_sensortype.insets = new Insets(0, 10, 5, 5);
		gbc_check_sensortype.gridx = 0;
		gbc_check_sensortype.gridy = 6;
		p2.add(check_sensortype, gbc_check_sensortype);
		
		tf_sensortype = new JTextField();
		GridBagConstraints gbc_tf_sensortype = new GridBagConstraints();
		gbc_tf_sensortype.gridwidth = 4;
		gbc_tf_sensortype.insets = new Insets(0, 0, 5, 10);
		gbc_tf_sensortype.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_sensortype.gridx = 1;
		gbc_tf_sensortype.gridy = 6;
		p2.add(tf_sensortype, gbc_tf_sensortype);
		tf_sensortype.setColumns(10);
		
		JCheckBox check_sitelevel = new JCheckBox("站点等级:");
		check_sitelevel.setSelected(true);
		GridBagConstraints gbc_check_sitelevel = new GridBagConstraints();
		gbc_check_sitelevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_check_sitelevel.insets = new Insets(0, 10, 5, 5);
		gbc_check_sitelevel.gridx = 0;
		gbc_check_sitelevel.gridy = 7;
		p2.add(check_sitelevel, gbc_check_sitelevel);
		
		cb_siteLevel = new JComboBox();
		cb_siteLevel.setModel(new DefaultComboBoxModel(new String[] {"国家一级", "国家二级", "自定义等级"}));
		GridBagConstraints gbc_cb_siteLevel = new GridBagConstraints();
		gbc_cb_siteLevel.gridwidth = 4;
		gbc_cb_siteLevel.insets = new Insets(0, 0, 5, 10);
		gbc_cb_siteLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_siteLevel.gridx = 1;
		gbc_cb_siteLevel.gridy = 7;
		p2.add(cb_siteLevel, gbc_cb_siteLevel);
		
		JCheckBox check_shareLevel = new JCheckBox("共享级别:");
		check_shareLevel.setSelected(true);
		GridBagConstraints gbc_check_shareLevel = new GridBagConstraints();
		gbc_check_shareLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_check_shareLevel.insets = new Insets(0, 10, 5, 5);
		gbc_check_shareLevel.gridx = 0;
		gbc_check_shareLevel.gridy = 8;
		p2.add(check_shareLevel, gbc_check_shareLevel);
		
		cb_shareLevel = new JComboBox();
		cb_shareLevel.setModel(new DefaultComboBoxModel(new String[] {"公开", "限制"}));
		GridBagConstraints gbc_cb_shareLevel = new GridBagConstraints();
		gbc_cb_shareLevel.gridwidth = 4;
		gbc_cb_shareLevel.insets = new Insets(0, 0, 5, 10);
		gbc_cb_shareLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_shareLevel.gridx = 1;
		gbc_cb_shareLevel.gridy = 8;
		p2.add(cb_shareLevel, gbc_cb_shareLevel);
		
		JCheckBox check_appli = new JCheckBox("预期应用:");
		check_appli.setSelected(true);
		GridBagConstraints gbc_check_appli = new GridBagConstraints();
		gbc_check_appli.fill = GridBagConstraints.HORIZONTAL;
		gbc_check_appli.insets = new Insets(0, 10, 5, 5);
		gbc_check_appli.gridx = 0;
		gbc_check_appli.gridy = 9;
		p2.add(check_appli, gbc_check_appli);
		
		tf_application = new JTextField();
		hintText applicationHint = new hintText(tf_application, "灾害/预测/其他");
		tf_application.addFocusListener(new JTextFieldHintListener("灾害/预测/其他", tf_application));
		tf_application.setColumns(10);
		GridBagConstraints gbc_tf_application = new GridBagConstraints();
		gbc_tf_application.gridwidth = 2;
		gbc_tf_application.insets = new Insets(0, 0, 5, 5);
		gbc_tf_application.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_application.gridx = 1;
		gbc_tf_application.gridy = 9;
		p2.add(tf_application, gbc_tf_application);
		
		JButton bt_addAppli = new JButton("增加");
		bt_addAppli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta_appli.append(tf_application.getText()+"\n");
				tf_application.setText("");
			}
		});
		GridBagConstraints gbc_bt_addAppli = new GridBagConstraints();
		gbc_bt_addAppli.insets = new Insets(0, 0, 5, 10);
		gbc_bt_addAppli.gridx = 3;
		gbc_bt_addAppli.gridy = 9;
		p2.add(bt_addAppli, gbc_bt_addAppli);
		
		JButton bt_deleteAppli = new JButton("清空");
		bt_deleteAppli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta_appli.setText("");
			}
		});
		GridBagConstraints gbc_bt_deleteAppli = new GridBagConstraints();
		gbc_bt_deleteAppli.insets = new Insets(0, 0, 5, 10);
		gbc_bt_deleteAppli.gridx = 4;
		gbc_bt_deleteAppli.gridy = 9;
		p2.add(bt_deleteAppli, gbc_bt_deleteAppli);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridheight = 2;
		gbc_scrollPane_3.gridwidth = 4;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 10);
		gbc_scrollPane_3.gridx = 1;
		gbc_scrollPane_3.gridy = 10;
		p2.add(scrollPane_3, gbc_scrollPane_3);
		
		ta_appli = new JTextArea();
		ta_appli.setBackground(SystemColor.info);
		scrollPane_3.setViewportView(ta_appli);
		
		check_otherClass = new JCheckBox("添加其他分类");
		GridBagConstraints gbc_check_otherClass = new GridBagConstraints();
		gbc_check_otherClass.fill = GridBagConstraints.HORIZONTAL;
		gbc_check_otherClass.gridwidth = 3;
		gbc_check_otherClass.insets = new Insets(0, 10, 5, 5);
		gbc_check_otherClass.gridx = 0;
		gbc_check_otherClass.gridy = 12;
		p2.add(check_otherClass, gbc_check_otherClass);
		check_otherClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (check_otherClass.isSelected()) {
					tf_otherclass.setEditable(true);
					tf_otherclass.setBackground(White);
					tf_otherclassId.setEditable(true);
					tf_otherclassId.setBackground(White);
					bt_add_otherClass.setEnabled(true);
					bt_delete_otherClass.setEnabled(true);
				}else {
					tf_otherclass.setEditable(false);
					tf_otherclass.setBackground(Grey);
					tf_otherclassId.setEditable(false);
					tf_otherclassId.setBackground(Grey);
					tf_otherclass.setText("");
					tf_otherclassId.setText("");
					bt_add_otherClass.setEnabled(false);
					bt_delete_otherClass.setEnabled(false);
					tableotherClass.setRowCount(0);
				}	
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 5, 5, 10);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 13;
		p2.add(scrollPane_1, gbc_scrollPane_1);
		
		table_otherclass = new JTable();
		table_otherclass.setBackground(new Color(175, 238, 238));
		tableotherClass = new DefaultTableModel(new Object[][] {},new String[] {"分类名称", "分类内容"});
		table_otherclass.setModel(tableotherClass);
		table_otherclass.getColumnModel().getColumn(0).setPreferredWidth(65);
		table_otherclass.getColumnModel().getColumn(1).setPreferredWidth(135);
		scrollPane_1.setViewportView(table_otherclass);
		table_otherclass.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单行选中模式
		table_otherclass.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){
                int selectedRow = table_otherclass.getSelectedRow(); //获得选中行索引
                Object oa = tableotherClass.getValueAt(selectedRow, 0);
                Object ob = tableotherClass.getValueAt(selectedRow, 1);
                tf_otherclass.setText(oa.toString());  //给文本框赋值
                tf_otherclassId.setText(ob.toString());
            }
        });
		
		tf_otherclass = new JTextField();
		tf_otherclass.setEditable(false);
		tf_otherclass.setColumns(10);
		GridBagConstraints gbc_tf_otherclass = new GridBagConstraints();
		gbc_tf_otherclass.insets = new Insets(0, 5, 0, 5);
		gbc_tf_otherclass.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherclass.gridx = 0;
		gbc_tf_otherclass.gridy = 14;
		p2.add(tf_otherclass, gbc_tf_otherclass);
		
		tf_otherclassId = new JTextField("");
		tf_otherclassId.setEditable(false);
		tf_otherclassId.setColumns(10);
		GridBagConstraints gbc_tf_otherclassId = new GridBagConstraints();
		gbc_tf_otherclassId.gridwidth = 2;
		gbc_tf_otherclassId.insets = new Insets(0, 0, 0, 5);
		gbc_tf_otherclassId.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherclassId.gridx = 1;
		gbc_tf_otherclassId.gridy = 14;
		p2.add(tf_otherclassId, gbc_tf_otherclassId);
		
		bt_add_otherClass = new JButton("增加");
		bt_add_otherClass.setEnabled(false);
		bt_add_otherClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_otherclass.getText(),tf_otherclassId.getText()};
				tableotherClass.addRow(info);//添加一行
				tf_otherclass.setText("");
				tf_otherclassId.setText("");
			}
		});
		GridBagConstraints gbc_bt_add_otherClass = new GridBagConstraints();
		gbc_bt_add_otherClass.insets = new Insets(0, 0, 0, 5);
		gbc_bt_add_otherClass.gridx = 3;
		gbc_bt_add_otherClass.gridy = 14;
		p2.add(bt_add_otherClass, gbc_bt_add_otherClass);
		
		bt_delete_otherClass = new JButton("删除");
		bt_delete_otherClass.setEnabled(false);
		bt_delete_otherClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table_otherclass.getSelectedRow();//获得选中行的索引
				if(selectedRow!=-1)  //存在选中行
                {
					tableotherClass.removeRow(selectedRow);  //删除行
                }
			}
		});
		GridBagConstraints gbc_bt_delete_otherClass = new GridBagConstraints();
		gbc_bt_delete_otherClass.anchor = GridBagConstraints.SOUTH;
		gbc_bt_delete_otherClass.insets = new Insets(0, 0, 0, 10);
		gbc_bt_delete_otherClass.gridx = 4;
		gbc_bt_delete_otherClass.gridy = 14;
		p2.add(bt_delete_otherClass, gbc_bt_delete_otherClass);
		
		cst_panel = new JPanel();
		tp.addTab("约束条件信息", null, cst_panel, null);
		GridBagLayout gbl_cst_panel = new GridBagLayout();
		gbl_cst_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_cst_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 29, 0, 0, 0, 0, 26, 0, 0, 0, 0, 0};
		gbl_cst_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_cst_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		cst_panel.setLayout(gbl_cst_panel);
		
		JCheckBox ckbx_vldTm = new JCheckBox("有效时间");
		ckbx_vldTm.setSelected(true);
		GridBagConstraints gbc_ckbx_vldTm = new GridBagConstraints();
		gbc_ckbx_vldTm.insets = new Insets(0, 0, 15, 5);
		gbc_ckbx_vldTm.gridx = 0;
		gbc_ckbx_vldTm.gridy = 0;
		cst_panel.add(ckbx_vldTm, gbc_ckbx_vldTm);
		
		JLabel lb_beginTM = new JLabel("起始时间:");
		GridBagConstraints gbc_lb_beginTM = new GridBagConstraints();
		gbc_lb_beginTM.insets = new Insets(0, 10, 5, 5);
		gbc_lb_beginTM.gridx = 0;
		gbc_lb_beginTM.gridy = 1;
		cst_panel.add(lb_beginTM, gbc_lb_beginTM);
		
		bgTM = new JComboBox();
		bgTM.setModel(new DefaultComboBoxModel(new String[] {"确定时间点", "不定时间点"}));
		GridBagConstraints gbc_bgTM = new GridBagConstraints();
		gbc_bgTM.gridwidth = 4;
		gbc_bgTM.insets = new Insets(0, 0, 5, 15);
		gbc_bgTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_bgTM.gridx = 1;
		gbc_bgTM.gridy = 1;
		cst_panel.add(bgTM, gbc_bgTM);
		bgTM.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (bgTM.getSelectedItem().equals("不定时间点")) {
					tf_bgTM.setEditable(false);
					tf_bgTM.setBackground(UIManager.getColor("TextArea.disabledBackground"));
					tf_bgTM.setText("");
				}else {
					tf_bgTM.setEditable(true);
					tf_bgTM.setBackground(new Color(255, 255, 255));
				}
			}
		});
		
		
		tf_bgTM = new JTextField();
		hintText bgTMHint = new hintText(tf_bgTM, "2018-01-01T08:00:00.0Z");
		tf_bgTM.addFocusListener(new JTextFieldHintListener("2018-01-01T08:00:00.0Z", tf_bgTM));
		GridBagConstraints gbc_tf_bgTM = new GridBagConstraints();
		gbc_tf_bgTM.gridwidth = 4;
		gbc_tf_bgTM.insets = new Insets(0, 0, 5, 15);
		gbc_tf_bgTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_bgTM.gridx = 1;
		gbc_tf_bgTM.gridy = 2;
		cst_panel.add(tf_bgTM, gbc_tf_bgTM);
		tf_bgTM.setColumns(10);
		
		JLabel lb_endTM = new JLabel("结束时间:");
		GridBagConstraints gbc_lb_endTM = new GridBagConstraints();
		gbc_lb_endTM.insets = new Insets(0, 10, 5, 5);
		gbc_lb_endTM.gridx = 0;
		gbc_lb_endTM.gridy = 3;
		cst_panel.add(lb_endTM, gbc_lb_endTM);
		
		endTM = new JComboBox();
		endTM.setModel(new DefaultComboBoxModel(new String[] {"确定时间点", "不定时间点"}));
		GridBagConstraints gbc_endTM = new GridBagConstraints();
		gbc_endTM.gridwidth = 4;
		gbc_endTM.insets = new Insets(0, 0, 5, 15);
		gbc_endTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_endTM.gridx = 1;
		gbc_endTM.gridy = 3;
		cst_panel.add(endTM, gbc_endTM);
		endTM.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (endTM.getSelectedItem().equals("不定时间点")) {
					tf_endTM.setEditable(false);
					tf_endTM.setBackground(UIManager.getColor("TextArea.disabledBackground"));
				}else {
					tf_endTM.setEditable(true);
					tf_endTM.setBackground(new Color(255, 255, 255));
				}
			}
		});
		
		tf_endTM = new JTextField();
		hintText edTMHint = new hintText(tf_endTM, "2020-01-01T08:00:00.0Z");
		tf_endTM.addFocusListener(new JTextFieldHintListener("2020-01-01T08:00:00.0Z", tf_endTM));
		tf_endTM.setColumns(10);
		GridBagConstraints gbc_tf_endTM = new GridBagConstraints();
		gbc_tf_endTM.gridwidth = 4;
		gbc_tf_endTM.insets = new Insets(0, 0, 5, 15);
		gbc_tf_endTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_endTM.gridx = 1;
		gbc_tf_endTM.gridy = 4;
		cst_panel.add(tf_endTM, gbc_tf_endTM);
		
		ckbx_legal = new JCheckBox("法律约束概述");
		GridBagConstraints gbc_ckbx_legal = new GridBagConstraints();
		gbc_ckbx_legal.gridwidth = 2;
		gbc_ckbx_legal.insets = new Insets(10, 0, 10, 5);
		gbc_ckbx_legal.gridx = 0;
		gbc_ckbx_legal.gridy = 5;
		cst_panel.add(ckbx_legal, gbc_ckbx_legal);
		ckbx_legal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_legal.isSelected()) {
					ta_legalConstra.setEditable(true);
					ta_legalConstra.setBackground(new Color(255, 255, 255));
				}else {
					ta_legalConstra.setBackground(UIManager.getColor("TextArea.disabledBackground"));
					ta_legalConstra.setEditable(false);
					ta_legalConstra.setText("");
				}
			}
		});
		
		JScrollPane scrollPane_18 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_18 = new GridBagConstraints();
		gbc_scrollPane_18.gridheight = 4;
		gbc_scrollPane_18.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_18.gridwidth = 5;
		gbc_scrollPane_18.insets = new Insets(0, 50, 5, 25);
		gbc_scrollPane_18.gridx = 0;
		gbc_scrollPane_18.gridy = 6;
		cst_panel.add(scrollPane_18, gbc_scrollPane_18);
		
		ta_legalConstra = new JTextArea();
		ta_legalConstra.setBackground(UIManager.getColor("TextArea.disabledBackground"));
		ta_legalConstra.setEditable(false);
		scrollPane_18.setViewportView(ta_legalConstra);
		
		ckbx_safe = new JCheckBox("安全约束概述");
		GridBagConstraints gbc_ckbx_safe = new GridBagConstraints();
		gbc_ckbx_safe.gridwidth = 2;
		gbc_ckbx_safe.insets = new Insets(10, 0, 10, 5);
		gbc_ckbx_safe.gridx = 0;
		gbc_ckbx_safe.gridy = 10;
		cst_panel.add(ckbx_safe, gbc_ckbx_safe);
		ckbx_safe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_safe.isSelected()) {
					ta_securityConstraint.setEditable(true);
					ta_securityConstraint.setBackground(new Color(255, 255, 255));
				}else {
					ta_securityConstraint.setEditable(false);
					ta_securityConstraint.setBackground(UIManager.getColor("TextArea.disabledBackground"));
					ta_securityConstraint.setText("");
				}
			}
		});
		
		JScrollPane scrollPane_19 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_19 = new GridBagConstraints();
		gbc_scrollPane_19.gridheight = 4;
		gbc_scrollPane_19.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_19.gridwidth = 5;
		gbc_scrollPane_19.insets = new Insets(0, 50, 5, 25);
		gbc_scrollPane_19.gridx = 0;
		gbc_scrollPane_19.gridy = 11;
		cst_panel.add(scrollPane_19, gbc_scrollPane_19);
		
		ta_securityConstraint = new JTextArea();
		ta_securityConstraint.setBackground(UIManager.getColor("TextArea.disabledBackground"));
		scrollPane_19.setViewportView(ta_securityConstraint);
		//“特征能力信息”页面
		capa_panel = new JPanel();
		tp.addTab("特征能力信息", null, capa_panel, null);
		GridBagLayout gbl_capa_panel = new GridBagLayout();
		gbl_capa_panel.columnWidths = new int[]{0, 0};
		gbl_capa_panel.rowHeights = new int[]{0, 0};
		gbl_capa_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_capa_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		capa_panel.setLayout(gbl_capa_panel);
		
		tP_capa = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tP_capa = new GridBagConstraints();
		gbc_tP_capa.fill = GridBagConstraints.BOTH;
		gbc_tP_capa.gridx = 0;
		gbc_tP_capa.gridy = 0;
		capa_panel.add(tP_capa, gbc_tP_capa);
		
		panel_charac = new JPanel();
		tP_capa.addTab("          站点特征          ", null, panel_charac, null);
		tP_capa.setBackgroundAt(0, SystemColor.activeCaption);
		GridBagLayout gbl_panel_charac = new GridBagLayout();
		gbl_panel_charac.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_charac.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_charac.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0};
		gbl_panel_charac.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_charac.setLayout(gbl_panel_charac);
		
		JLabel label_physic = new JLabel(" 站点物理特征");
		label_physic.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_label_physic = new GridBagConstraints();
		gbc_label_physic.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_physic.gridwidth = 2;
		gbc_label_physic.insets = new Insets(5, 5, 5, 5);
		gbc_label_physic.gridx = 0;
		gbc_label_physic.gridy = 0;
		panel_charac.add(label_physic, gbc_label_physic);
		
		JLabel label_environ = new JLabel("工作环境");
		label_environ.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_label_environ = new GridBagConstraints();
		gbc_label_environ.anchor = GridBagConstraints.SOUTH;
		gbc_label_environ.insets = new Insets(0, 0, 5, 5);
		gbc_label_environ.gridx = 6;
		gbc_label_environ.gridy = 0;
		panel_charac.add(label_environ, gbc_label_environ);
		
		JCheckBox chckbx_l = new JCheckBox("长度(m):");
		GridBagConstraints gbc_chckbx_l = new GridBagConstraints();
		gbc_chckbx_l.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbx_l.insets = new Insets(0, 0, 5, 5);
		gbc_chckbx_l.gridx = 0;
		gbc_chckbx_l.gridy = 1;
		panel_charac.add(chckbx_l, gbc_chckbx_l);
		chckbx_l.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbx_l.isSelected()) {
					textField_l.setEditable(true);
					textField_l.setBackground(White);
				}else {
					textField_l.setEditable(false);
					textField_l.setBackground(Grey);
					textField_l.setText("");
				}
			}
		});
		
		textField_l = new JTextField();
		textField_l.setEditable(false);
		GridBagConstraints gbc_textField_l = new GridBagConstraints();
		gbc_textField_l.gridwidth = 5;
		gbc_textField_l.insets = new Insets(0, 0, 5, 5);
		gbc_textField_l.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_l.gridx = 1;
		gbc_textField_l.gridy = 1;
		panel_charac.add(textField_l, gbc_textField_l);
		textField_l.setColumns(10);
		
		checkBox_life = new JCheckBox("设计寿命(year):");
		GridBagConstraints gbc_checkBox_life = new GridBagConstraints();
		gbc_checkBox_life.anchor = GridBagConstraints.WEST;
		gbc_checkBox_life.gridwidth = 2;
		gbc_checkBox_life.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_life.gridx = 6;
		gbc_checkBox_life.gridy = 1;
		panel_charac.add(checkBox_life, gbc_checkBox_life);
		checkBox_life.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox_life.isSelected()) {
					textField_life.setEditable(true);
					textField_life.setBackground(White);
				}else {
					textField_life.setEditable(false);
					textField_life.setBackground(Grey);
					textField_life.setText("");
				}
			}
		});
		
		textField_life = new JTextField();
		textField_life.setEditable(false);
		textField_life.setColumns(10);
		GridBagConstraints gbc_textField_life = new GridBagConstraints();
		gbc_textField_life.gridwidth = 5;
		gbc_textField_life.insets = new Insets(0, 0, 5, 5);
		gbc_textField_life.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_life.gridx = 8;
		gbc_textField_life.gridy = 1;
		panel_charac.add(textField_life, gbc_textField_life);
		
		chckbx_w = new JCheckBox("宽度(m):");
		GridBagConstraints gbc_chckbx_w = new GridBagConstraints();
		gbc_chckbx_w.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbx_w.insets = new Insets(0, 0, 5, 5);
		gbc_chckbx_w.gridx = 0;
		gbc_chckbx_w.gridy = 2;
		panel_charac.add(chckbx_w, gbc_chckbx_w);
		chckbx_w.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbx_w.isSelected()) {
					textField_w.setEditable(true);
					textField_w.setBackground(White);
				}else {
					textField_w.setEditable(false);
					textField_w.setBackground(Grey);
					textField_w.setText("");
				}
			}
		});
		
		textField_w = new JTextField();
		textField_w.setEditable(false);
		GridBagConstraints gbc_textField_w = new GridBagConstraints();
		gbc_textField_w.gridwidth = 5;
		gbc_textField_w.insets = new Insets(0, 0, 5, 5);
		gbc_textField_w.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_w.gridx = 1;
		gbc_textField_w.gridy = 2;
		panel_charac.add(textField_w, gbc_textField_w);
		textField_w.setColumns(10);
		
		checkBox_humidR = new JCheckBox("工作湿度范围(%):");
		GridBagConstraints gbc_checkBox_humidR = new GridBagConstraints();
		gbc_checkBox_humidR.anchor = GridBagConstraints.WEST;
		gbc_checkBox_humidR.gridwidth = 2;
		gbc_checkBox_humidR.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_humidR.gridx = 6;
		gbc_checkBox_humidR.gridy = 2;
		panel_charac.add(checkBox_humidR, gbc_checkBox_humidR);
		checkBox_humidR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox_humidR.isSelected()) {
					tf_humidLow.setEditable(true);
					tf_humidLow.setBackground(White);
					tf_humidUp.setEditable(true);
					tf_humidUp.setBackground(White);
				}else {
					tf_humidLow.setEditable(false);
					tf_humidLow.setBackground(Grey);
					tf_humidUp.setEditable(false);
					tf_humidUp.setBackground(Grey);
					tf_humidLow.setText("");
					tf_humidUp.setText("");
				}
			}
		});
		
		tf_humidLow = new JTextField();
		tf_humidLow.setEditable(false);
		tf_humidLow.setColumns(10);
		GridBagConstraints gbc_tf_humidLow = new GridBagConstraints();
		gbc_tf_humidLow.gridwidth = 2;
		gbc_tf_humidLow.insets = new Insets(0, 0, 5, 5);
		gbc_tf_humidLow.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_humidLow.gridx = 8;
		gbc_tf_humidLow.gridy = 2;
		panel_charac.add(tf_humidLow, gbc_tf_humidLow);
		
		JLabel lb_humidJG = new JLabel("—");
		GridBagConstraints gbc_lb_humidJG = new GridBagConstraints();
		gbc_lb_humidJG.insets = new Insets(0, 0, 5, 5);
		gbc_lb_humidJG.anchor = GridBagConstraints.EAST;
		gbc_lb_humidJG.gridx = 10;
		gbc_lb_humidJG.gridy = 2;
		panel_charac.add(lb_humidJG, gbc_lb_humidJG);
		
		tf_humidUp = new JTextField();
		tf_humidUp.setEditable(false);
		tf_humidUp.setColumns(10);
		GridBagConstraints gbc_tf_humidUp = new GridBagConstraints();
		gbc_tf_humidUp.gridwidth = 2;
		gbc_tf_humidUp.insets = new Insets(0, 0, 5, 5);
		gbc_tf_humidUp.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_humidUp.gridx = 11;
		gbc_tf_humidUp.gridy = 2;
		panel_charac.add(tf_humidUp, gbc_tf_humidUp);
		
		JCheckBox checkBox_h = new JCheckBox("高度(m):");
		GridBagConstraints gbc_checkBox_h = new GridBagConstraints();
		gbc_checkBox_h.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBox_h.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_h.gridx = 0;
		gbc_checkBox_h.gridy = 3;
		panel_charac.add(checkBox_h, gbc_checkBox_h);
		checkBox_h.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox_h.isSelected()) {
					textField_h.setEditable(true);
					textField_h.setBackground(White);
				}else {
					textField_h.setEditable(false);
					textField_h.setBackground(Grey);
					textField_h.setText("");
				}
			}
		});
		
		textField_h = new JTextField();
		textField_h.setEditable(false);
		textField_h.setColumns(10);
		GridBagConstraints gbc_textField_h = new GridBagConstraints();
		gbc_textField_h.gridwidth = 5;
		gbc_textField_h.insets = new Insets(0, 0, 5, 5);
		gbc_textField_h.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_h.gridx = 1;
		gbc_textField_h.gridy = 3;
		panel_charac.add(textField_h, gbc_textField_h);
		
		checkBox_tempR = new JCheckBox("工作温度范围(℃):");
		GridBagConstraints gbc_checkBox_tempR = new GridBagConstraints();
		gbc_checkBox_tempR.anchor = GridBagConstraints.WEST;
		gbc_checkBox_tempR.gridwidth = 2;
		gbc_checkBox_tempR.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_tempR.gridx = 6;
		gbc_checkBox_tempR.gridy = 3;
		panel_charac.add(checkBox_tempR, gbc_checkBox_tempR);
		checkBox_tempR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox_tempR.isSelected()) {
					tf_tempLow.setEditable(true);
					tf_tempLow.setBackground(White);
					tf_temUp.setEditable(true);
					tf_temUp.setBackground(White);
				}else {
					tf_tempLow.setEditable(false);
					tf_tempLow.setBackground(Grey);
					tf_temUp.setEditable(false);
					tf_temUp.setBackground(Grey);
					tf_tempLow.setText("");
					tf_temUp.setText("");
				}
			}
		});
		
		tf_tempLow = new JTextField();
		tf_tempLow.setEditable(false);
		tf_tempLow.setColumns(10);
		GridBagConstraints gbc_tf_tempLow = new GridBagConstraints();
		gbc_tf_tempLow.gridwidth = 2;
		gbc_tf_tempLow.insets = new Insets(0, 0, 5, 5);
		gbc_tf_tempLow.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_tempLow.gridx = 8;
		gbc_tf_tempLow.gridy = 3;
		panel_charac.add(tf_tempLow, gbc_tf_tempLow);
		
		JLabel lb_temJG = new JLabel("—");
		GridBagConstraints gbc_lb_temJG = new GridBagConstraints();
		gbc_lb_temJG.insets = new Insets(0, 0, 5, 5);
		gbc_lb_temJG.anchor = GridBagConstraints.EAST;
		gbc_lb_temJG.gridx = 10;
		gbc_lb_temJG.gridy = 3;
		panel_charac.add(lb_temJG, gbc_lb_temJG);
		
		tf_temUp = new JTextField();
		tf_temUp.setEditable(false);
		tf_temUp.setColumns(10);
		GridBagConstraints gbc_tf_temUp = new GridBagConstraints();
		gbc_tf_temUp.gridwidth = 2;
		gbc_tf_temUp.insets = new Insets(0, 0, 5, 5);
		gbc_tf_temUp.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_temUp.gridx = 11;
		gbc_tf_temUp.gridy = 3;
		panel_charac.add(tf_temUp, gbc_tf_temUp);
		
		JCheckBox checkBox_m = new JCheckBox("质量(kg):");
		GridBagConstraints gbc_checkBox_m = new GridBagConstraints();
		gbc_checkBox_m.gridwidth = 2;
		gbc_checkBox_m.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBox_m.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_m.gridx = 0;
		gbc_checkBox_m.gridy = 4;
		panel_charac.add(checkBox_m, gbc_checkBox_m);
		checkBox_m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox_m.isSelected()) {
					textField_m.setEditable(true);
					textField_m.setBackground(White);
				}else {
					textField_m.setEditable(false);
					textField_m.setBackground(Grey);
					textField_m.setText("");
				}
			}
		});
		
		textField_m = new JTextField();
		textField_m.setEditable(false);
		textField_m.setColumns(10);
		GridBagConstraints gbc_textField_m = new GridBagConstraints();
		gbc_textField_m.gridwidth = 4;
		gbc_textField_m.insets = new Insets(0, 0, 5, 5);
		gbc_textField_m.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_m.gridx = 2;
		gbc_textField_m.gridy = 4;
		panel_charac.add(textField_m, gbc_textField_m);
		
		checkBox_protGrade = new JCheckBox("防护等级:");
		GridBagConstraints gbc_checkBox_protGrade = new GridBagConstraints();
		gbc_checkBox_protGrade.anchor = GridBagConstraints.WEST;
		gbc_checkBox_protGrade.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_protGrade.gridx = 6;
		gbc_checkBox_protGrade.gridy = 4;
		panel_charac.add(checkBox_protGrade, gbc_checkBox_protGrade);
		checkBox_protGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox_protGrade.isSelected()) {
					textField_protGrade.setEditable(true);
					textField_protGrade.setBackground(White);
				}else {
					textField_protGrade.setEditable(false);
					textField_protGrade.setBackground(Grey);
					textField_protGrade.setText("");
				}
			}
		});
		
		textField_protGrade = new JTextField();
		textField_protGrade.setEditable(false);
		textField_protGrade.setColumns(10);
		GridBagConstraints gbc_textField_protGrade = new GridBagConstraints();
		gbc_textField_protGrade.gridwidth = 6;
		gbc_textField_protGrade.insets = new Insets(0, 0, 5, 5);
		gbc_textField_protGrade.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_protGrade.gridx = 7;
		gbc_textField_protGrade.gridy = 4;
		panel_charac.add(textField_protGrade, gbc_textField_protGrade);
		
		checkBox_MTBF = new JCheckBox("无故障时间(h):");
		GridBagConstraints gbc_checkBox_MTBF = new GridBagConstraints();
		gbc_checkBox_MTBF.anchor = GridBagConstraints.WEST;
		gbc_checkBox_MTBF.gridwidth = 2;
		gbc_checkBox_MTBF.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_MTBF.gridx = 6;
		gbc_checkBox_MTBF.gridy = 5;
		panel_charac.add(checkBox_MTBF, gbc_checkBox_MTBF);
		checkBox_MTBF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox_MTBF.isSelected()) {
					textField_MTBF.setEditable(true);
					textField_MTBF.setBackground(White);
				}else {
					textField_MTBF.setEditable(false);
					textField_MTBF.setBackground(Grey);
					textField_MTBF.setText("");
				}	
			}
		});
		
		textField_MTBF = new JTextField();
		textField_MTBF.setEditable(false);
		textField_MTBF.setColumns(10);
		GridBagConstraints gbc_textField_MTBF = new GridBagConstraints();
		gbc_textField_MTBF.gridwidth = 5;
		gbc_textField_MTBF.insets = new Insets(0, 0, 5, 5);
		gbc_textField_MTBF.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_MTBF.gridx = 8;
		gbc_textField_MTBF.gridy = 5;
		panel_charac.add(textField_MTBF, gbc_textField_MTBF);
		
		JLabel label_elec = new JLabel("  供电通信特征");
		label_elec.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_label_elec = new GridBagConstraints();
		gbc_label_elec.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_elec.gridwidth = 2;
		gbc_label_elec.insets = new Insets(0, 0, 5, 5);
		gbc_label_elec.gridx = 0;
		gbc_label_elec.gridy = 6;
		panel_charac.add(label_elec, gbc_label_elec);
		
		checkBox_isOperate = new JCheckBox("是否可控:");
		GridBagConstraints gbc_checkBox_isOperate = new GridBagConstraints();
		gbc_checkBox_isOperate.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_isOperate.gridx = 6;
		gbc_checkBox_isOperate.gridy = 6;
		panel_charac.add(checkBox_isOperate, gbc_checkBox_isOperate);
		
		comboBox_isOperate = new JComboBox();
		comboBox_isOperate.setEnabled(false);
		comboBox_isOperate.setModel(new DefaultComboBoxModel(new String[] {"TRUE", "FALSE"}));
		GridBagConstraints gbc_comboBox_isOperate = new GridBagConstraints();
		gbc_comboBox_isOperate.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_isOperate.gridwidth = 6;
		gbc_comboBox_isOperate.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_isOperate.gridx = 7;
		gbc_comboBox_isOperate.gridy = 6;
		panel_charac.add(comboBox_isOperate, gbc_comboBox_isOperate);
		checkBox_isOperate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox_isOperate.isSelected()) {
					comboBox_isOperate.enable();
				}else {
					comboBox_isOperate.enable(false);
				}
			}
		});
		
		checkBox_power = new JCheckBox("电源类型:");
		GridBagConstraints gbc_checkBox_power = new GridBagConstraints();
		gbc_checkBox_power.gridwidth = 2;
		gbc_checkBox_power.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBox_power.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_power.gridx = 0;
		gbc_checkBox_power.gridy = 7;
		panel_charac.add(checkBox_power, gbc_checkBox_power);
		
		comboBox_power = new JComboBox();
		comboBox_power.setEnabled(false);
		comboBox_power.setModel(new DefaultComboBoxModel(new String[] {"直流电源", "交流电源", "太阳能浮充","其他电源类型"}));
		GridBagConstraints gbc_comboBox_power = new GridBagConstraints();
		gbc_comboBox_power.gridwidth = 4;
		gbc_comboBox_power.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_power.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_power.gridx = 2;
		gbc_comboBox_power.gridy = 7;
		panel_charac.add(comboBox_power, gbc_comboBox_power);
		checkBox_power.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox_power.isSelected()) {
					comboBox_power.enable();
				}else {
					comboBox_power.enable(false);
				}
			}
		});
		
		checkBox_current = new JCheckBox("电流(A):");
		GridBagConstraints gbc_checkBox_current = new GridBagConstraints();
		gbc_checkBox_current.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBox_current.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_current.gridx = 0;
		gbc_checkBox_current.gridy = 8;
		panel_charac.add(checkBox_current, gbc_checkBox_current);
		checkBox_current.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox_current.isSelected()) {
					textField_currentMax.setEditable(true);
					textField_currentMin.setEditable(true);
					textField_currentMax.setBackground(White);
					textField_currentMin.setBackground(White);
				}else {
					textField_currentMax.setEditable(false);
					textField_currentMax.setBackground(Grey);
					textField_currentMin.setEditable(false);
					textField_currentMin.setBackground(Grey);
					textField_currentMax.setText("");
					textField_currentMin.setText("");
				}	
			}
		});
		
		textField_currentMin = new JTextField();
		textField_currentMin.setEditable(false);
		textField_currentMin.setColumns(10);
		GridBagConstraints gbc_textField_currentMin = new GridBagConstraints();
		gbc_textField_currentMin.gridwidth = 2;
		gbc_textField_currentMin.insets = new Insets(0, 0, 5, 5);
		gbc_textField_currentMin.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_currentMin.gridx = 1;
		gbc_textField_currentMin.gridy = 8;
		panel_charac.add(textField_currentMin, gbc_textField_currentMin);
		
		JLabel label_range = new JLabel("—");
		GridBagConstraints gbc_label_range = new GridBagConstraints();
		gbc_label_range.insets = new Insets(0, 0, 5, 5);
		gbc_label_range.gridx = 3;
		gbc_label_range.gridy = 8;
		panel_charac.add(label_range, gbc_label_range);
		
		textField_currentMax = new JTextField();
		textField_currentMax.setEditable(false);
		textField_currentMax.setColumns(10);
		GridBagConstraints gbc_textField_currentMax = new GridBagConstraints();
		gbc_textField_currentMax.gridwidth = 2;
		gbc_textField_currentMax.insets = new Insets(0, 0, 5, 5);
		gbc_textField_currentMax.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_currentMax.gridx = 4;
		gbc_textField_currentMax.gridy = 8;
		panel_charac.add(textField_currentMax, gbc_textField_currentMax);
		
		checkBox_voltage = new JCheckBox("电压(V):");
		GridBagConstraints gbc_checkBox_voltage = new GridBagConstraints();
		gbc_checkBox_voltage.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBox_voltage.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_voltage.gridx = 0;
		gbc_checkBox_voltage.gridy = 9;
		panel_charac.add(checkBox_voltage, gbc_checkBox_voltage);
		checkBox_voltage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox_voltage.isSelected()) {
					textField_voltageMin.setEditable(true);
					textField_voltageMin.setBackground(White);
					textField_voltageMax.setEditable(true);
					textField_voltageMax.setBackground(White);
				}else {
					textField_voltageMin.setEditable(false);
					textField_voltageMax.setEnabled(false);
					textField_voltageMin.setBackground(Grey);
					textField_voltageMax.setBackground(Grey);
					textField_voltageMax.setText("");
					textField_voltageMin.setText("");
				}
			}
		});
		
		textField_voltageMin = new JTextField();
		textField_voltageMin.setEditable(false);
		textField_voltageMin.setColumns(10);
		GridBagConstraints gbc_textField_voltageMin = new GridBagConstraints();
		gbc_textField_voltageMin.gridwidth = 2;
		gbc_textField_voltageMin.insets = new Insets(0, 0, 5, 5);
		gbc_textField_voltageMin.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_voltageMin.gridx = 1;
		gbc_textField_voltageMin.gridy = 9;
		panel_charac.add(textField_voltageMin, gbc_textField_voltageMin);
		
		JLabel label_VR = new JLabel("—");
		GridBagConstraints gbc_label_VR = new GridBagConstraints();
		gbc_label_VR.insets = new Insets(0, 0, 5, 5);
		gbc_label_VR.gridx = 3;
		gbc_label_VR.gridy = 9;
		panel_charac.add(label_VR, gbc_label_VR);
		
		textField_voltageMax = new JTextField();
		textField_voltageMax.setEditable(false);
		textField_voltageMax.setColumns(10);
		GridBagConstraints gbc_textField_voltageMax = new GridBagConstraints();
		gbc_textField_voltageMax.gridwidth = 2;
		gbc_textField_voltageMax.insets = new Insets(0, 0, 5, 5);
		gbc_textField_voltageMax.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_voltageMax.gridx = 4;
		gbc_textField_voltageMax.gridy = 9;
		panel_charac.add(textField_voltageMax, gbc_textField_voltageMax);
		
		checkBox_otherChara = new JCheckBox("添加其他特征:");
		GridBagConstraints gbc_checkBox_otherChara = new GridBagConstraints();
		gbc_checkBox_otherChara.anchor = GridBagConstraints.WEST;
		gbc_checkBox_otherChara.gridwidth = 2;
		gbc_checkBox_otherChara.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_otherChara.gridx = 6;
		gbc_checkBox_otherChara.gridy = 9;
		panel_charac.add(checkBox_otherChara, gbc_checkBox_otherChara);
		checkBox_otherChara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox_otherChara.isSelected()) {
					tf_othercharactername.setEditable(true);
					tf_othercharactername.setBackground(White);
					tf_othercharactercontent.setEditable(true);
					tf_othercharactercontent.setBackground(White);
					bt_addCharacter.setEnabled(true);
					bt_deleCharacter.setEnabled(true);
				}else {
					tf_othercharactername.setEditable(false);
					tf_othercharactercontent.setEnabled(false);
					tf_othercharactername.setBackground(Grey);
					tf_othercharactercontent.setBackground(Grey);
					bt_addCharacter.setEnabled(false);
					bt_deleCharacter.setEnabled(false);
					otherCharacterModel.setRowCount(0);
				}
			}
		});
		
		chckbxw = new JCheckBox("功率(W):");
		GridBagConstraints gbc_chckbxw = new GridBagConstraints();
		gbc_chckbxw.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxw.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxw.gridx = 0;
		gbc_chckbxw.gridy = 10;
		panel_charac.add(chckbxw, gbc_chckbxw);
		chckbxw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxw.isSelected()) {
					textField_pow.setEditable(true);
					textField_pow.setBackground(White);
				}else {
					textField_pow.setEditable(false);
					textField_pow.setBackground(Grey);
					textField_pow.setText("");
				}	
			}
		});
		
		textField_pow = new JTextField();
		textField_pow.setEditable(false);
		textField_pow.setColumns(10);
		GridBagConstraints gbc_textField_pow = new GridBagConstraints();
		gbc_textField_pow.gridwidth = 5;
		gbc_textField_pow.insets = new Insets(0, 0, 5, 5);
		gbc_textField_pow.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_pow.gridx = 1;
		gbc_textField_pow.gridy = 10;
		panel_charac.add(textField_pow, gbc_textField_pow);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_6 = new GridBagConstraints();
		gbc_scrollPane_6.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_6.gridheight = 4;
		gbc_scrollPane_6.gridwidth = 7;
		gbc_scrollPane_6.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_6.gridx = 6;
		gbc_scrollPane_6.gridy = 10;
		panel_charac.add(scrollPane_6, gbc_scrollPane_6);
		
		table_otherChara = new JTable();
		table_otherChara.setBackground(new Color(175, 238, 238));
		otherCharacterModel = new DefaultTableModel(new Object[][] {},new String[] {"字段名称", "字段内容"});
		table_otherChara.setModel(otherCharacterModel);
		scrollPane_6.setViewportView(table_otherChara);
		table_otherChara.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单行选中模式
		table_otherChara.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){
                int selectedRow = table_otherChara.getSelectedRow(); //获得选中行索引
                Object oa = otherCharacterModel.getValueAt(selectedRow, 0);
                Object ob = otherCharacterModel.getValueAt(selectedRow, 1);
                tf_othercharactername.setText(oa.toString());  //给文本框赋值
                tf_othercharactercontent.setText(ob.toString());
            }
        });
		
		chckbxw_1 = new JCheckBox("输出功率(W):");
		GridBagConstraints gbc_chckbxw_1 = new GridBagConstraints();
		gbc_chckbxw_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxw_1.gridwidth = 2;
		gbc_chckbxw_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxw_1.gridx = 0;
		gbc_chckbxw_1.gridy = 11;
		panel_charac.add(chckbxw_1, gbc_chckbxw_1);
		chckbxw_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxw_1.isSelected()) {
					textField_outPow.setEditable(true);
					textField_outPow.setBackground(White);
				}else {
					textField_outPow.setEditable(false);
					textField_outPow.setBackground(Grey);
					textField_outPow.setText("");
				}	
			}
		});
		
		textField_outPow = new JTextField();
		textField_outPow.setEditable(false);
		textField_outPow.setColumns(10);
		GridBagConstraints gbc_textField_outPow = new GridBagConstraints();
		gbc_textField_outPow.gridwidth = 4;
		gbc_textField_outPow.insets = new Insets(0, 0, 5, 5);
		gbc_textField_outPow.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_outPow.gridx = 2;
		gbc_textField_outPow.gridy = 11;
		panel_charac.add(textField_outPow, gbc_textField_outPow);
		
		chckbxm = new JCheckBox("存储容量(MB):");
		GridBagConstraints gbc_chckbxm = new GridBagConstraints();
		gbc_chckbxm.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxm.gridwidth = 2;
		gbc_chckbxm.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxm.gridx = 0;
		gbc_chckbxm.gridy = 12;
		panel_charac.add(chckbxm, gbc_chckbxm);
		chckbxm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxm.isSelected()) {
					textField_store .setEditable(true);
					textField_store .setBackground(White);
				}else {
					textField_store .setEditable(false);
					textField_store .setBackground(Grey);
					textField_store.setText("");
				}	
			}
		});
		
		textField_store = new JTextField();
		textField_store.setEditable(false);
		textField_store.setColumns(10);
		GridBagConstraints gbc_textField_store = new GridBagConstraints();
		gbc_textField_store.gridwidth = 4;
		gbc_textField_store.insets = new Insets(0, 0, 5, 5);
		gbc_textField_store.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_store.gridx = 2;
		gbc_textField_store.gridy = 12;
		panel_charac.add(textField_store, gbc_textField_store);
		
		ckbx_TransMode = new JCheckBox("数传模式:");
		GridBagConstraints gbc_ckbx_TransMode = new GridBagConstraints();
		gbc_ckbx_TransMode.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_TransMode.gridwidth = 2;
		gbc_ckbx_TransMode.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_TransMode.gridx = 0;
		gbc_ckbx_TransMode.gridy = 13;
		panel_charac.add(ckbx_TransMode, gbc_ckbx_TransMode);
		
		cbbx_TransMode = new JComboBox();
		cbbx_TransMode.setEnabled(false);
		cbbx_TransMode.setModel(new DefaultComboBoxModel(new String[] {"中继星下传", "直接下传", "实时传输", "存储传输"}));
		GridBagConstraints gbc_cbbx_TransMode = new GridBagConstraints();
		gbc_cbbx_TransMode.gridwidth = 4;
		gbc_cbbx_TransMode.insets = new Insets(0, 0, 5, 5);
		gbc_cbbx_TransMode.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbx_TransMode.gridx = 2;
		gbc_cbbx_TransMode.gridy = 13;
		panel_charac.add(cbbx_TransMode, gbc_cbbx_TransMode);
		ckbx_TransMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_TransMode.isSelected()) {
					cbbx_TransMode.enable();
				}else {
					cbbx_TransMode.enable(false);
				}
			}
		});
		
		chckbx_CSJG = new JCheckBox("传输间隔(h):");
		GridBagConstraints gbc_chckbx_CSJG = new GridBagConstraints();
		gbc_chckbx_CSJG.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbx_CSJG.gridwidth = 2;
		gbc_chckbx_CSJG.insets = new Insets(0, 0, 5, 5);
		gbc_chckbx_CSJG.gridx = 0;
		gbc_chckbx_CSJG.gridy = 14;
		panel_charac.add(chckbx_CSJG, gbc_chckbx_CSJG);
		chckbx_CSJG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbx_CSJG.isSelected()) {
					textField_CSJG.setEditable(true);
					textField_CSJG.setBackground(White);
				}else {
					textField_CSJG.setEditable(false);
					textField_CSJG.setBackground(Grey);
					textField_CSJG.setText("");
				}	
			}
		});
		
		textField_CSJG = new JTextField();
		textField_CSJG.setEditable(false);
		textField_CSJG.setColumns(10);
		GridBagConstraints gbc_textField_CSJG = new GridBagConstraints();
		gbc_textField_CSJG.gridwidth = 4;
		gbc_textField_CSJG.insets = new Insets(0, 0, 5, 5);
		gbc_textField_CSJG.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_CSJG.gridx = 2;
		gbc_textField_CSJG.gridy = 14;
		panel_charac.add(textField_CSJG, gbc_textField_CSJG);
		
		tf_othercharactername = new JTextField();
		tf_othercharactername.setEditable(false);
		GridBagConstraints gbc_tf_othercharactername = new GridBagConstraints();
		gbc_tf_othercharactername.gridwidth = 2;
		gbc_tf_othercharactername.insets = new Insets(0, 5, 5, 5);
		gbc_tf_othercharactername.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_othercharactername.gridx = 6;
		gbc_tf_othercharactername.gridy = 14;
		panel_charac.add(tf_othercharactername, gbc_tf_othercharactername);
		tf_othercharactername.setColumns(10);
		
		tf_othercharactercontent = new JTextField();
		tf_othercharactercontent.setEditable(false);
		tf_othercharactercontent.setColumns(10);
		GridBagConstraints gbc_tf_othercharactercontent = new GridBagConstraints();
		gbc_tf_othercharactercontent.gridwidth = 3;
		gbc_tf_othercharactercontent.insets = new Insets(0, 0, 5, 5);
		gbc_tf_othercharactercontent.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_othercharactercontent.gridx = 8;
		gbc_tf_othercharactercontent.gridy = 14;
		panel_charac.add(tf_othercharactercontent, gbc_tf_othercharactercontent);
		
		bt_addCharacter = new JButton("增加");
		bt_addCharacter.setEnabled(false);
		bt_addCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_othercharactername.getText(),tf_othercharactercontent.getText()};
				otherCharacterModel.addRow(info);//添加一行
				tf_othercharactername.setText("");
				tf_othercharactercontent.setText("");
			}
		});
		GridBagConstraints gbc_bt_addCharacter = new GridBagConstraints();
		gbc_bt_addCharacter.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addCharacter.gridx = 11;
		gbc_bt_addCharacter.gridy = 14;
		panel_charac.add(bt_addCharacter, gbc_bt_addCharacter);
		
		bt_deleCharacter = new JButton("删除");
		bt_deleCharacter.setEnabled(false);
		bt_deleCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table_otherChara.getSelectedRow();//获得选中行的索引
				if(selectedRow!=-1)  //存在选中行
                {
					otherCharacterModel.removeRow(selectedRow);  //删除行
                }
			}
		});
		GridBagConstraints gbc_bt_deleCharacter = new GridBagConstraints();
		gbc_bt_deleCharacter.gridwidth = 2;
		gbc_bt_deleCharacter.insets = new Insets(0, 0, 5, 0);
		gbc_bt_deleCharacter.gridx = 12;
		gbc_bt_deleCharacter.gridy = 14;
		panel_charac.add(bt_deleCharacter, gbc_bt_deleCharacter);
		
		checkBox_TXFS = new JCheckBox("通信方式:");
		GridBagConstraints gbc_checkBox_TXFS = new GridBagConstraints();
		gbc_checkBox_TXFS.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBox_TXFS.gridwidth = 2;
		gbc_checkBox_TXFS.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_TXFS.gridx = 0;
		gbc_checkBox_TXFS.gridy = 15;
		panel_charac.add(checkBox_TXFS, gbc_checkBox_TXFS);
		checkBox_TXFS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox_TXFS.isSelected()) {
					textField_TXFS.setEditable(true);
					textField_TXFS.setBackground(White);
				}else {
					textField_TXFS.setEditable(false);
					textField_TXFS.setBackground(Grey);
					textField_TXFS.setText("");
				}	
			}
		});
		
		textField_TXFS = new JTextField();
		textField_TXFS.setEditable(false);
		hintText TXFSHint = new hintText(textField_TXFS, "VHF/卫星/GSM/GPRS/PSTN/其他");
		textField_TXFS.addFocusListener(new JTextFieldHintListener("VHF/卫星/GSM/GPRS/PSTN/其他", textField_TXFS));
		textField_TXFS.setColumns(10);
		GridBagConstraints gbc_textField_TXFS = new GridBagConstraints();
		gbc_textField_TXFS.gridwidth = 4;
		gbc_textField_TXFS.insets = new Insets(0, 0, 5, 5);
		gbc_textField_TXFS.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_TXFS.gridx = 2;
		gbc_textField_TXFS.gridy = 15;
		panel_charac.add(textField_TXFS, gbc_textField_TXFS);
		
		panel_capab = new JPanel();
		tP_capa.addTab("         站点观测能力         ", null, panel_capab, null);
		tP_capa.setBackgroundAt(1, SystemColor.activeCaption);
		GridBagLayout gbl_panel_capab = new GridBagLayout();
		gbl_panel_capab.columnWidths = new int[]{0, 0, 0, -11, 0, 0, 0, 22, 0, 0, 0, 0, 0, 0};
		gbl_panel_capab.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_capab.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_capab.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_capab.setLayout(gbl_panel_capab);
		
		JLabel lb_b = new JLabel("观测能力广度");
		lb_b.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_b = new GridBagConstraints();
		gbc_lb_b.fill = GridBagConstraints.HORIZONTAL;
		gbc_lb_b.gridwidth = 2;
		gbc_lb_b.insets = new Insets(3, 0, 5, 5);
		gbc_lb_b.gridx = 0;
		gbc_lb_b.gridy = 0;
		panel_capab.add(lb_b, gbc_lb_b);
		
		JLabel lb_qua = new JLabel("观测能力质量");
		lb_qua.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_qua = new GridBagConstraints();
		gbc_lb_qua.gridwidth = 2;
		gbc_lb_qua.insets = new Insets(3, 0, 5, 5);
		gbc_lb_qua.gridx = 6;
		gbc_lb_qua.gridy = 0;
		panel_capab.add(lb_qua, gbc_lb_qua);
		
		JCheckBox ckbx_insituType = new JCheckBox("原位探测类型:");
		ckbx_insituType.setSelected(true);
		GridBagConstraints gbc_ckbx_insituType = new GridBagConstraints();
		gbc_ckbx_insituType.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_insituType.gridwidth = 2;
		gbc_ckbx_insituType.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_insituType.gridx = 0;
		gbc_ckbx_insituType.gridy = 1;
		panel_capab.add(ckbx_insituType, gbc_ckbx_insituType);
		
		tf_insituType = new JTextField();
		GridBagConstraints gbc_tf_insituType = new GridBagConstraints();
		gbc_tf_insituType.gridwidth = 4;
		gbc_tf_insituType.insets = new Insets(0, 0, 5, 5);
		gbc_tf_insituType.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_insituType.gridx = 2;
		gbc_tf_insituType.gridy = 1;
		panel_capab.add(tf_insituType, gbc_tf_insituType);
		tf_insituType.setColumns(10);
		
		ckbx_sensiTole = new JCheckBox("灵敏度允差(%):");
		GridBagConstraints gbc_ckbx_sensiTole = new GridBagConstraints();
		gbc_ckbx_sensiTole.anchor = GridBagConstraints.WEST;
		gbc_ckbx_sensiTole.gridwidth = 2;
		gbc_ckbx_sensiTole.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_sensiTole.gridx = 6;
		gbc_ckbx_sensiTole.gridy = 1;
		panel_capab.add(ckbx_sensiTole, gbc_ckbx_sensiTole);
		ckbx_sensiTole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_sensiTole.isSelected()) {
					tf_sensiTole.setEditable(true);
					tf_sensiTole.setBackground(White);
				}else {
					tf_sensiTole.setEditable(false);
					tf_sensiTole.setBackground(Grey);
					tf_sensiTole.setText("");
				}	
			}
		});
		
		tf_sensiTole = new JTextField();
		tf_sensiTole.setEditable(false);
		tf_sensiTole.setColumns(10);
		GridBagConstraints gbc_tf_sensiTole = new GridBagConstraints();
		gbc_tf_sensiTole.gridwidth = 5;
		gbc_tf_sensiTole.insets = new Insets(0, 0, 5, 0);
		gbc_tf_sensiTole.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_sensiTole.gridx = 8;
		gbc_tf_sensiTole.gridy = 1;
		panel_capab.add(tf_sensiTole, gbc_tf_sensiTole);
		
		ckbx_detecPrinc = new JCheckBox("探测原理:");
		GridBagConstraints gbc_ckbx_detecPrinc = new GridBagConstraints();
		gbc_ckbx_detecPrinc.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_detecPrinc.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_detecPrinc.gridx = 0;
		gbc_ckbx_detecPrinc.gridy = 2;
		panel_capab.add(ckbx_detecPrinc, gbc_ckbx_detecPrinc);
		ckbx_detecPrinc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_detecPrinc.isSelected()) {
					ta_detecPrinc.setEditable(true);
					ta_detecPrinc.setBackground(White);
				}else {
					ta_detecPrinc.setEditable(false);
					ta_detecPrinc.setBackground(Grey);
					ta_detecPrinc.setText("");
				}	
			}
		});
		
		JScrollPane scrollPane_7 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_7 = new GridBagConstraints();
		gbc_scrollPane_7.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_7.gridheight = 2;
		gbc_scrollPane_7.gridwidth = 5;
		gbc_scrollPane_7.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_7.gridx = 1;
		gbc_scrollPane_7.gridy = 2;
		panel_capab.add(scrollPane_7, gbc_scrollPane_7);
		
		ta_detecPrinc = new JTextArea();
		ta_detecPrinc.setBackground(SystemColor.menu);
		ta_detecPrinc.setEditable(false);
		scrollPane_7.setViewportView(ta_detecPrinc);
		
		ckbx_accuracy = new JCheckBox("探测精度(%):");
		GridBagConstraints gbc_ckbx_accuracy = new GridBagConstraints();
		gbc_ckbx_accuracy.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_accuracy.gridx = 6;
		gbc_ckbx_accuracy.gridy = 2;
		panel_capab.add(ckbx_accuracy, gbc_ckbx_accuracy);
		ckbx_accuracy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_accuracy.isSelected()) {
					tf_accuracy.setEditable(true);
					tf_accuracy.setBackground(White);
				}else {
					tf_accuracy.setEditable(false);
					tf_accuracy.setBackground(Grey);
					tf_accuracy.setText("");
				}	
			}
		});
		
		tf_accuracy = new JTextField();
		tf_accuracy.setEditable(false);
		tf_accuracy.setColumns(10);
		GridBagConstraints gbc_tf_accuracy = new GridBagConstraints();
		gbc_tf_accuracy.gridwidth = 6;
		gbc_tf_accuracy.insets = new Insets(0, 0, 5, 0);
		gbc_tf_accuracy.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_accuracy.gridx = 7;
		gbc_tf_accuracy.gridy = 2;
		panel_capab.add(tf_accuracy, gbc_tf_accuracy);
		
		ckbx_repeat = new JCheckBox("重复性误差(%):");
		GridBagConstraints gbc_ckbx_repeat = new GridBagConstraints();
		gbc_ckbx_repeat.anchor = GridBagConstraints.WEST;
		gbc_ckbx_repeat.gridwidth = 2;
		gbc_ckbx_repeat.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_repeat.gridx = 6;
		gbc_ckbx_repeat.gridy = 3;
		panel_capab.add(ckbx_repeat, gbc_ckbx_repeat);
		ckbx_repeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_repeat.isSelected()) {
					tf_repeat.setEditable(true);
					tf_repeat.setBackground(White);
				}else {
					tf_repeat.setEditable(false);
					tf_repeat.setBackground(Grey);
					tf_repeat.setText("");
				}	
			}
		});
		
		tf_repeat = new JTextField();
		tf_repeat.setEditable(false);
		tf_repeat.setColumns(10);
		GridBagConstraints gbc_tf_repeat = new GridBagConstraints();
		gbc_tf_repeat.gridwidth = 5;
		gbc_tf_repeat.insets = new Insets(0, 0, 5, 0);
		gbc_tf_repeat.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_repeat.gridx = 8;
		gbc_tf_repeat.gridy = 3;
		panel_capab.add(tf_repeat, gbc_tf_repeat);
		
		ckbx_overload = new JCheckBox("极限过载(M):");
		GridBagConstraints gbc_ckbx_overload = new GridBagConstraints();
		gbc_ckbx_overload.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_overload.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_overload.gridx = 0;
		gbc_ckbx_overload.gridy = 4;
		panel_capab.add(ckbx_overload, gbc_ckbx_overload);
		ckbx_overload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_overload.isSelected()) {
					tf_overloadLow.setEditable(true);
					tf_overloadLow.setBackground(White);
					tf_overloadUp.setEditable(true);
					tf_overloadUp.setBackground(White);
				}else {
					tf_overloadLow.setEditable(false);
					tf_overloadLow.setBackground(Grey);
					tf_overloadLow.setText("");
					tf_overloadUp.setEditable(false);
					tf_overloadUp.setBackground(Grey);
					tf_overloadUp.setText("");
				}
			}
		});
		
		tf_overloadLow = new JTextField();
		tf_overloadLow.setEditable(false);
		tf_overloadLow.setColumns(10);
		GridBagConstraints gbc_tf_overloadLow = new GridBagConstraints();
		gbc_tf_overloadLow.gridwidth = 2;
		gbc_tf_overloadLow.insets = new Insets(0, 0, 5, 5);
		gbc_tf_overloadLow.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_overloadLow.gridx = 1;
		gbc_tf_overloadLow.gridy = 4;
		panel_capab.add(tf_overloadLow, gbc_tf_overloadLow);
		
		JLabel lb_overloadR = new JLabel("—");
		GridBagConstraints gbc_lb_overloadR = new GridBagConstraints();
		gbc_lb_overloadR.fill = GridBagConstraints.HORIZONTAL;
		gbc_lb_overloadR.insets = new Insets(0, 0, 5, 5);
		gbc_lb_overloadR.gridx = 3;
		gbc_lb_overloadR.gridy = 4;
		panel_capab.add(lb_overloadR, gbc_lb_overloadR);
		
		tf_overloadUp = new JTextField();
		tf_overloadUp.setEditable(false);
		tf_overloadUp.setColumns(10);
		GridBagConstraints gbc_tf_overloadUp = new GridBagConstraints();
		gbc_tf_overloadUp.gridwidth = 2;
		gbc_tf_overloadUp.insets = new Insets(0, 0, 5, 5);
		gbc_tf_overloadUp.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_overloadUp.gridx = 4;
		gbc_tf_overloadUp.gridy = 4;
		panel_capab.add(tf_overloadUp, gbc_tf_overloadUp);
		
		ckbx_lag = new JCheckBox("滞后允差(%):");
		GridBagConstraints gbc_ckbx_lag = new GridBagConstraints();
		gbc_ckbx_lag.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_lag.gridx = 6;
		gbc_ckbx_lag.gridy = 4;
		panel_capab.add(ckbx_lag, gbc_ckbx_lag);
		ckbx_lag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_lag.isSelected()) {
					tf_lag.setEditable(true);
					tf_lag.setBackground(White);
				}else {
					tf_lag.setEditable(false);
					tf_lag.setBackground(Grey);
					tf_lag.setText("");
				}
			}
		});
		
		tf_lag = new JTextField();
		tf_lag.setEditable(false);
		tf_lag.setColumns(10);
		GridBagConstraints gbc_tf_lag = new GridBagConstraints();
		gbc_tf_lag.gridwidth = 6;
		gbc_tf_lag.insets = new Insets(0, 0, 5, 0);
		gbc_tf_lag.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_lag.gridx = 7;
		gbc_tf_lag.gridy = 4;
		panel_capab.add(tf_lag, gbc_tf_lag);
		
		ckbx_measuRange = new JCheckBox("量程范围(m):");
		GridBagConstraints gbc_ckbx_measuRange = new GridBagConstraints();
		gbc_ckbx_measuRange.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_measuRange.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_measuRange.gridx = 0;
		gbc_ckbx_measuRange.gridy = 5;
		panel_capab.add(ckbx_measuRange, gbc_ckbx_measuRange);
		ckbx_measuRange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_measuRange.isSelected()) {
					tf_measuMin.setEditable(true);
					tf_measuMin.setBackground(White);
					tf_measuMax.setEditable(true);
					tf_measuMax.setBackground(White);
				}else {
					tf_measuMin.setEditable(false);
					tf_measuMin.setBackground(Grey);
					tf_measuMin.setText("");
					tf_measuMax.setEditable(false);
					tf_measuMax.setBackground(Grey);
					tf_measuMax.setText("");
				}
			}
		});
		
		tf_measuMin = new JTextField();
		tf_measuMin.setEditable(false);
		GridBagConstraints gbc_tf_measuMin = new GridBagConstraints();
		gbc_tf_measuMin.gridwidth = 2;
		gbc_tf_measuMin.anchor = GridBagConstraints.NORTH;
		gbc_tf_measuMin.insets = new Insets(0, 0, 5, 5);
		gbc_tf_measuMin.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_measuMin.gridx = 1;
		gbc_tf_measuMin.gridy = 5;
		panel_capab.add(tf_measuMin, gbc_tf_measuMin);
		tf_measuMin.setColumns(10);
		
		JLabel lb_measuR = new JLabel("—");
		GridBagConstraints gbc_lb_measuR = new GridBagConstraints();
		gbc_lb_measuR.fill = GridBagConstraints.HORIZONTAL;
		gbc_lb_measuR.insets = new Insets(0, 0, 5, 5);
		gbc_lb_measuR.gridx = 3;
		gbc_lb_measuR.gridy = 5;
		panel_capab.add(lb_measuR, gbc_lb_measuR);
		
		tf_measuMax = new JTextField();
		tf_measuMax.setEditable(false);
		tf_measuMax.setColumns(10);
		GridBagConstraints gbc_tf_measuMax = new GridBagConstraints();
		gbc_tf_measuMax.gridwidth = 2;
		gbc_tf_measuMax.insets = new Insets(0, 0, 5, 5);
		gbc_tf_measuMax.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_measuMax.gridx = 4;
		gbc_tf_measuMax.gridy = 5;
		panel_capab.add(tf_measuMax, gbc_tf_measuMax);
		
		ckbx_nonLine = new JCheckBox("非线性误差(%):");
		GridBagConstraints gbc_ckbx_nonLine = new GridBagConstraints();
		gbc_ckbx_nonLine.anchor = GridBagConstraints.WEST;
		gbc_ckbx_nonLine.gridwidth = 2;
		gbc_ckbx_nonLine.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_nonLine.gridx = 6;
		gbc_ckbx_nonLine.gridy = 5;
		panel_capab.add(ckbx_nonLine, gbc_ckbx_nonLine);
		ckbx_nonLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_nonLine.isSelected()) {
					tf_nonline.setEditable(true);
					tf_nonline.setBackground(White);
				}else {
					tf_nonline.setEditable(false);
					tf_nonline.setBackground(Grey);
					tf_nonline.setText("");
				}	
			}
		});
		
		tf_nonline = new JTextField();
		tf_nonline.setEditable(false);
		tf_nonline.setColumns(10);
		GridBagConstraints gbc_tf_nonline = new GridBagConstraints();
		gbc_tf_nonline.gridwidth = 5;
		gbc_tf_nonline.insets = new Insets(0, 0, 5, 0);
		gbc_tf_nonline.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_nonline.gridx = 8;
		gbc_tf_nonline.gridy = 5;
		panel_capab.add(tf_nonline, gbc_tf_nonline);
		
		JCheckBox ckbx_obsBBox = new JCheckBox("观测范围(纬度-经度):");
		ckbx_obsBBox.setSelected(true);
		GridBagConstraints gbc_ckbx_obsBBox = new GridBagConstraints();
		gbc_ckbx_obsBBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_obsBBox.gridwidth = 6;
		gbc_ckbx_obsBBox.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_obsBBox.gridx = 0;
		gbc_ckbx_obsBBox.gridy = 6;
		panel_capab.add(ckbx_obsBBox, gbc_ckbx_obsBBox);
		
		JLabel lb_data = new JLabel("观测能力数据");
		lb_data.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_data = new GridBagConstraints();
		gbc_lb_data.gridwidth = 2;
		gbc_lb_data.insets = new Insets(0, 0, 5, 5);
		gbc_lb_data.gridx = 6;
		gbc_lb_data.gridy = 6;
		panel_capab.add(lb_data, gbc_lb_data);
		
		JLabel lb_lCorner = new JLabel("  左下角点:");
		GridBagConstraints gbc_lb_lCorner = new GridBagConstraints();
		gbc_lb_lCorner.fill = GridBagConstraints.HORIZONTAL;
		gbc_lb_lCorner.insets = new Insets(0, 0, 5, 5);
		gbc_lb_lCorner.gridx = 0;
		gbc_lb_lCorner.gridy = 7;
		panel_capab.add(lb_lCorner, gbc_lb_lCorner);
		
		tf_lWD = new JTextField();
		tf_lWD.setColumns(10);
		GridBagConstraints gbc_tf_lWD = new GridBagConstraints();
		gbc_tf_lWD.gridwidth = 2;
		gbc_tf_lWD.insets = new Insets(0, 0, 5, 5);
		gbc_tf_lWD.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_lWD.gridx = 1;
		gbc_tf_lWD.gridy = 7;
		panel_capab.add(tf_lWD, gbc_tf_lWD);
		
		JLabel lb_lR = new JLabel("—");
		GridBagConstraints gbc_lb_lR = new GridBagConstraints();
		gbc_lb_lR.fill = GridBagConstraints.HORIZONTAL;
		gbc_lb_lR.insets = new Insets(0, 0, 5, 5);
		gbc_lb_lR.gridx = 3;
		gbc_lb_lR.gridy = 7;
		panel_capab.add(lb_lR, gbc_lb_lR);
		
		tf_lJD = new JTextField();
		tf_lJD.setColumns(10);
		GridBagConstraints gbc_tf_lJD = new GridBagConstraints();
		gbc_tf_lJD.gridwidth = 2;
		gbc_tf_lJD.insets = new Insets(0, 0, 5, 5);
		gbc_tf_lJD.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_lJD.gridx = 4;
		gbc_tf_lJD.gridy = 7;
		panel_capab.add(tf_lJD, gbc_tf_lJD);
		
		ckbx_accessLevel = new JCheckBox("数据获取等级:");
		GridBagConstraints gbc_ckbx_accessLevel = new GridBagConstraints();
		gbc_ckbx_accessLevel.anchor = GridBagConstraints.WEST;
		gbc_ckbx_accessLevel.gridwidth = 2;
		gbc_ckbx_accessLevel.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_accessLevel.gridx = 6;
		gbc_ckbx_accessLevel.gridy = 7;
		panel_capab.add(ckbx_accessLevel, gbc_ckbx_accessLevel);
		ckbx_accessLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_accessLevel.isSelected()) {
					cbbox_accessLevel.enable();
				}else {
					cbbox_accessLevel.enable(false);
				}	
			}
		});
		
		cbbox_accessLevel = new JComboBox();
		cbbox_accessLevel.setEnabled(false);
		cbbox_accessLevel.setModel(new DefaultComboBoxModel(new String[] {"公开", "限制"}));
		GridBagConstraints gbc_cbbox_accessLevel = new GridBagConstraints();
		gbc_cbbox_accessLevel.gridwidth = 5;
		gbc_cbbox_accessLevel.insets = new Insets(0, 0, 5, 0);
		gbc_cbbox_accessLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbox_accessLevel.gridx = 8;
		gbc_cbbox_accessLevel.gridy = 7;
		panel_capab.add(cbbox_accessLevel, gbc_cbbox_accessLevel);
		
		JLabel lb_UCoener = new JLabel("  右上角点:");
		GridBagConstraints gbc_lb_UCoener = new GridBagConstraints();
		gbc_lb_UCoener.fill = GridBagConstraints.HORIZONTAL;
		gbc_lb_UCoener.insets = new Insets(0, 0, 5, 5);
		gbc_lb_UCoener.gridx = 0;
		gbc_lb_UCoener.gridy = 8;
		panel_capab.add(lb_UCoener, gbc_lb_UCoener);
		
		tf_uWD = new JTextField();
		tf_uWD.setColumns(10);
		GridBagConstraints gbc_tf_uWD = new GridBagConstraints();
		gbc_tf_uWD.gridwidth = 2;
		gbc_tf_uWD.insets = new Insets(0, 0, 5, 5);
		gbc_tf_uWD.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_uWD.gridx = 1;
		gbc_tf_uWD.gridy = 8;
		panel_capab.add(tf_uWD, gbc_tf_uWD);
		
		JLabel lb_uR = new JLabel("—");
		GridBagConstraints gbc_lb_uR = new GridBagConstraints();
		gbc_lb_uR.anchor = GridBagConstraints.EAST;
		gbc_lb_uR.insets = new Insets(0, 0, 5, 5);
		gbc_lb_uR.gridx = 3;
		gbc_lb_uR.gridy = 8;
		panel_capab.add(lb_uR, gbc_lb_uR);
		
		tf_uJD = new JTextField();
		tf_uJD.setColumns(10);
		GridBagConstraints gbc_tf_uJD = new GridBagConstraints();
		gbc_tf_uJD.gridwidth = 2;
		gbc_tf_uJD.insets = new Insets(0, 0, 5, 5);
		gbc_tf_uJD.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_uJD.gridx = 4;
		gbc_tf_uJD.gridy = 8;
		panel_capab.add(tf_uJD, gbc_tf_uJD);
		
		ckbx_dataQualiLevel = new JCheckBox("数据质量等级:");
		GridBagConstraints gbc_ckbx_dataQualiLevel = new GridBagConstraints();
		gbc_ckbx_dataQualiLevel.anchor = GridBagConstraints.WEST;
		gbc_ckbx_dataQualiLevel.gridwidth = 2;
		gbc_ckbx_dataQualiLevel.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_dataQualiLevel.gridx = 6;
		gbc_ckbx_dataQualiLevel.gridy = 8;
		panel_capab.add(ckbx_dataQualiLevel, gbc_ckbx_dataQualiLevel);
		ckbx_dataQualiLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_dataQualiLevel.isSelected()) {
					tf_dataQuliLevel.setEditable(true);
					tf_dataQuliLevel.setBackground(White);
				}else {
					tf_dataQuliLevel.setEditable(false);
					tf_dataQuliLevel.setBackground(Grey);
					tf_dataQuliLevel.setText("");
				}
			}
		});
		
		tf_dataQuliLevel = new JTextField();
		tf_dataQuliLevel.setEditable(false);
		tf_dataQuliLevel.setColumns(10);
		GridBagConstraints gbc_tf_dataQuliLevel = new GridBagConstraints();
		gbc_tf_dataQuliLevel.gridwidth = 5;
		gbc_tf_dataQuliLevel.insets = new Insets(0, 0, 5, 0);
		gbc_tf_dataQuliLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_dataQuliLevel.gridx = 8;
		gbc_tf_dataQuliLevel.gridy = 8;
		panel_capab.add(tf_dataQuliLevel, gbc_tf_dataQuliLevel);
		
		JLabel lb_d = new JLabel("观测能力深度");
		lb_d.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_d = new GridBagConstraints();
		gbc_lb_d.fill = GridBagConstraints.HORIZONTAL;
		gbc_lb_d.gridwidth = 2;
		gbc_lb_d.insets = new Insets(0, 0, 5, 5);
		gbc_lb_d.gridx = 0;
		gbc_lb_d.gridy = 9;
		panel_capab.add(lb_d, gbc_lb_d);
		
		ckbx_dataFormat = new JCheckBox("数据格式:");
		GridBagConstraints gbc_ckbx_dataFormat = new GridBagConstraints();
		gbc_ckbx_dataFormat.anchor = GridBagConstraints.WEST;
		gbc_ckbx_dataFormat.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_dataFormat.gridx = 6;
		gbc_ckbx_dataFormat.gridy = 9;
		panel_capab.add(ckbx_dataFormat, gbc_ckbx_dataFormat);
		ckbx_dataFormat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_dataFormat.isSelected()) {
					tf_dataFormat.setEditable(true);
					tf_dataFormat.setBackground(White);
				}else {
					tf_dataFormat.setEditable(false);
					tf_dataFormat.setBackground(Grey);
					tf_dataFormat.setText("");
				}	
			}
		});
		
		tf_dataFormat = new JTextField();
		tf_dataFormat.setEditable(false);
		tf_dataFormat.setColumns(10);
		GridBagConstraints gbc_tf_dataFormat = new GridBagConstraints();
		gbc_tf_dataFormat.gridwidth = 6;
		gbc_tf_dataFormat.insets = new Insets(0, 0, 5, 0);
		gbc_tf_dataFormat.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_dataFormat.gridx = 7;
		gbc_tf_dataFormat.gridy = 9;
		panel_capab.add(tf_dataFormat, gbc_tf_dataFormat);
		
		ckbx_obsResolu = new JCheckBox("观测分辨率(%):");
		GridBagConstraints gbc_ckbx_obsResolu = new GridBagConstraints();
		gbc_ckbx_obsResolu.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_obsResolu.gridwidth = 2;
		gbc_ckbx_obsResolu.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_obsResolu.gridx = 0;
		gbc_ckbx_obsResolu.gridy = 10;
		panel_capab.add(ckbx_obsResolu, gbc_ckbx_obsResolu);
		ckbx_obsResolu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_obsResolu.isSelected()) {
					tf_obsResolu.setEditable(true);
					tf_obsResolu.setBackground(White);
				}else {
					tf_obsResolu.setEditable(false);
					tf_obsResolu.setBackground(Grey);
					tf_obsResolu.setText("");
				}
			}
		});
		
		tf_obsResolu = new JTextField();
		tf_obsResolu.setEditable(false);
		tf_obsResolu.setColumns(10);
		GridBagConstraints gbc_tf_obsResolu = new GridBagConstraints();
		gbc_tf_obsResolu.gridwidth = 4;
		gbc_tf_obsResolu.insets = new Insets(0, 0, 5, 5);
		gbc_tf_obsResolu.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_obsResolu.gridx = 2;
		gbc_tf_obsResolu.gridy = 10;
		panel_capab.add(tf_obsResolu, gbc_tf_obsResolu);
		
		ckbx_otherCapa = new JCheckBox("添加其他观测能力");
		GridBagConstraints gbc_ckbx_otherCapa = new GridBagConstraints();
		gbc_ckbx_otherCapa.anchor = GridBagConstraints.WEST;
		gbc_ckbx_otherCapa.gridwidth = 2;
		gbc_ckbx_otherCapa.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_otherCapa.gridx = 6;
		gbc_ckbx_otherCapa.gridy = 10;
		panel_capab.add(ckbx_otherCapa, gbc_ckbx_otherCapa);
		ckbx_otherCapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_otherCapa.isSelected()) {
					tf_otherCapName.setEditable(true);
					tf_otherCapName.setBackground(White);
					tf_otherCapContent.setEditable(true);
					tf_otherCapContent.setBackground(White);
					bt_addcapa.setEnabled(true);
					bt_deleCapa.setEnabled(true);
				}else {
					tf_otherCapName.setEditable(false);
					tf_otherCapName.setBackground(Grey);
					tf_otherCapName.setText("");
					tf_otherCapContent.setEditable(false);
					tf_otherCapContent.setBackground(Grey);
					tf_otherCapContent.setText("");
					bt_addcapa.setEnabled(false);
					bt_deleCapa.setEnabled(false);
					model_otherCapa.setRowCount(0);
				}	
			}
		});
		
		ckbx_radius = new JCheckBox("观测半径(m):");
		GridBagConstraints gbc_ckbx_radius = new GridBagConstraints();
		gbc_ckbx_radius.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_radius.gridwidth = 2;
		gbc_ckbx_radius.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_radius.gridx = 0;
		gbc_ckbx_radius.gridy = 11;
		panel_capab.add(ckbx_radius, gbc_ckbx_radius);
		ckbx_radius.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_radius.isSelected()) {
					tf_radius.setEditable(true);
					tf_radius.setBackground(White);
				}else {
					tf_radius.setEditable(false);
					tf_radius.setBackground(Grey);
					tf_radius.setText("");
				}
			}
		});
		
		tf_radius = new JTextField();
		tf_radius.setEditable(false);
		tf_radius.setColumns(10);
		GridBagConstraints gbc_tf_radius = new GridBagConstraints();
		gbc_tf_radius.gridwidth = 4;
		gbc_tf_radius.insets = new Insets(0, 0, 5, 5);
		gbc_tf_radius.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_radius.gridx = 2;
		gbc_tf_radius.gridy = 11;
		panel_capab.add(tf_radius, gbc_tf_radius);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_8 = new GridBagConstraints();
		gbc_scrollPane_8.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_8.gridheight = 5;
		gbc_scrollPane_8.gridwidth = 7;
		gbc_scrollPane_8.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_8.gridx = 6;
		gbc_scrollPane_8.gridy = 11;
		panel_capab.add(scrollPane_8, gbc_scrollPane_8);
		
		tb_otherCapa = new JTable();
		tb_otherCapa.setBackground(new Color(175, 238, 238));
		model_otherCapa = new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"字段名称", "字段内容"
				}
			);
		tb_otherCapa.setModel(model_otherCapa);
		scrollPane_8.setViewportView(tb_otherCapa);
		tb_otherCapa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单行选中模式
		tb_otherCapa.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){
                int selectedRow = tb_otherCapa.getSelectedRow(); //获得选中行索引
                Object oa = model_otherCapa.getValueAt(selectedRow, 0);
                Object ob = model_otherCapa.getValueAt(selectedRow, 1);
                tf_otherCapName.setText(oa.toString());  //给文本框赋值
                tf_otherCapContent.setText(ob.toString());
            }
        });
		
		
		ckbx_sensi = new JCheckBox("灵敏度(%):");
		GridBagConstraints gbc_ckbx_sensi = new GridBagConstraints();
		gbc_ckbx_sensi.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_sensi.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_sensi.gridx = 0;
		gbc_ckbx_sensi.gridy = 12;
		panel_capab.add(ckbx_sensi, gbc_ckbx_sensi);
		ckbx_sensi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_sensi.isSelected()) {
					tf_sensi.setEditable(true);
					tf_sensi.setBackground(White);
				}else {
					tf_sensi.setEditable(false);
					tf_sensi.setBackground(Grey);
					tf_sensi.setText("");
				}	
			}
		});
		
		tf_sensi = new JTextField();
		tf_sensi.setEditable(false);
		tf_sensi.setColumns(10);
		GridBagConstraints gbc_tf_sensi = new GridBagConstraints();
		gbc_tf_sensi.gridwidth = 5;
		gbc_tf_sensi.insets = new Insets(0, 0, 5, 5);
		gbc_tf_sensi.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_sensi.gridx = 1;
		gbc_tf_sensi.gridy = 12;
		panel_capab.add(tf_sensi, gbc_tf_sensi);
		
		JLabel lb_f = new JLabel("观测能力频度");
		lb_f.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_f = new GridBagConstraints();
		gbc_lb_f.fill = GridBagConstraints.HORIZONTAL;
		gbc_lb_f.gridwidth = 2;
		gbc_lb_f.insets = new Insets(0, 0, 5, 5);
		gbc_lb_f.gridx = 0;
		gbc_lb_f.gridy = 13;
		panel_capab.add(lb_f, gbc_lb_f);
		
		ckbx_Interval = new JCheckBox("采样周期(s):");
		GridBagConstraints gbc_ckbx_Interval = new GridBagConstraints();
		gbc_ckbx_Interval.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_Interval.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_Interval.gridx = 0;
		gbc_ckbx_Interval.gridy = 14;
		panel_capab.add(ckbx_Interval, gbc_ckbx_Interval);
		ckbx_Interval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_Interval.isSelected()) {
					tf_Interval.setEditable(true);
					tf_Interval.setBackground(White);
				}else {
					tf_Interval.setEditable(false);
					tf_Interval.setBackground(Grey);
					tf_Interval.setText("");
				}
			}
		});
		
		tf_Interval = new JTextField();
		tf_Interval.setEditable(false);
		GridBagConstraints gbc_tf_Interval = new GridBagConstraints();
		gbc_tf_Interval.gridwidth = 5;
		gbc_tf_Interval.insets = new Insets(0, 0, 5, 5);
		gbc_tf_Interval.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_Interval.gridx = 1;
		gbc_tf_Interval.gridy = 14;
		panel_capab.add(tf_Interval, gbc_tf_Interval);
		tf_Interval.setColumns(10);
		
		ckbx_dura = new JCheckBox("采样持续时间(s):");
		GridBagConstraints gbc_ckbx_dura = new GridBagConstraints();
		gbc_ckbx_dura.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_dura.gridwidth = 2;
		gbc_ckbx_dura.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_dura.gridx = 0;
		gbc_ckbx_dura.gridy = 15;
		panel_capab.add(ckbx_dura, gbc_ckbx_dura);
		ckbx_dura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_dura.isSelected()) {
					tf_dura.setEditable(true);
					tf_dura.setBackground(White);
				}else {
					tf_dura.setEditable(false);
					tf_dura.setBackground(Grey);
					tf_dura.setText("");
				}	
			}
		});
		
		tf_dura = new JTextField();
		tf_dura.setEditable(false);
		tf_dura.setColumns(10);
		GridBagConstraints gbc_tf_dura = new GridBagConstraints();
		gbc_tf_dura.gridwidth = 4;
		gbc_tf_dura.insets = new Insets(0, 0, 5, 5);
		gbc_tf_dura.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_dura.gridx = 2;
		gbc_tf_dura.gridy = 15;
		panel_capab.add(tf_dura, gbc_tf_dura);
		
		ckbx_respon = new JCheckBox("响应时间(s):");
		GridBagConstraints gbc_ckbx_respon = new GridBagConstraints();
		gbc_ckbx_respon.fill = GridBagConstraints.HORIZONTAL;
		gbc_ckbx_respon.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_respon.gridx = 0;
		gbc_ckbx_respon.gridy = 16;
		panel_capab.add(ckbx_respon, gbc_ckbx_respon);
		ckbx_respon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_respon.isSelected()) {
					tf_respon.setEditable(true);
					tf_respon.setBackground(White);
				}else {
					tf_respon.setEditable(false);
					tf_respon.setBackground(Grey);
					tf_respon.setText("");
				}
			}
		});
		
		tf_respon = new JTextField();
		tf_respon.setEditable(false);
		tf_respon.setColumns(10);
		GridBagConstraints gbc_tf_respon = new GridBagConstraints();
		gbc_tf_respon.gridwidth = 5;
		gbc_tf_respon.insets = new Insets(0, 0, 5, 5);
		gbc_tf_respon.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_respon.gridx = 1;
		gbc_tf_respon.gridy = 16;
		panel_capab.add(tf_respon, gbc_tf_respon);
		
		tf_otherCapName = new JTextField();
		tf_otherCapName.setEditable(false);
		GridBagConstraints gbc_tf_otherCapName = new GridBagConstraints();
		gbc_tf_otherCapName.insets = new Insets(0, 5, 5, 5);
		gbc_tf_otherCapName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherCapName.gridx = 6;
		gbc_tf_otherCapName.gridy = 16;
		panel_capab.add(tf_otherCapName, gbc_tf_otherCapName);
		tf_otherCapName.setColumns(10);
		
		tf_otherCapContent = new JTextField();
		tf_otherCapContent.setEditable(false);
		GridBagConstraints gbc_tf_otherCapContent = new GridBagConstraints();
		gbc_tf_otherCapContent.gridwidth = 2;
		gbc_tf_otherCapContent.insets = new Insets(0, 0, 5, 5);
		gbc_tf_otherCapContent.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_otherCapContent.gridx = 7;
		gbc_tf_otherCapContent.gridy = 16;
		panel_capab.add(tf_otherCapContent, gbc_tf_otherCapContent);
		tf_otherCapContent.setColumns(10);
		
		bt_addcapa = new JButton("增加");
		bt_addcapa.setEnabled(false);
		bt_addcapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {tf_otherCapName.getText(),tf_otherCapContent.getText()};
				model_otherCapa.addRow(info);//添加一行
				tf_otherCapName.setText("");
				tf_otherCapContent.setText("");
			}
		});
		GridBagConstraints gbc_bt_addcapa = new GridBagConstraints();
		gbc_bt_addcapa.gridwidth = 2;
		gbc_bt_addcapa.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addcapa.gridx = 9;
		gbc_bt_addcapa.gridy = 16;
		panel_capab.add(bt_addcapa, gbc_bt_addcapa);
		
		bt_deleCapa = new JButton("删除");
		bt_deleCapa.setEnabled(false);
		GridBagConstraints gbc_bt_deleCapa = new GridBagConstraints();
		gbc_bt_deleCapa.gridwidth = 2;
		gbc_bt_deleCapa.insets = new Insets(0, 0, 5, 0);
		gbc_bt_deleCapa.gridx = 11;
		gbc_bt_deleCapa.gridy = 16;
		panel_capab.add(bt_deleCapa, gbc_bt_deleCapa);
		bt_deleCapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_otherCapa.getSelectedRow();//获得选中行的索引
				if(selectedRow!=-1)  //存在选中行
                {
					model_otherCapa.removeRow(selectedRow);  //删除行
                }
			}
		});
		
		panel_posi = new JPanel();
		tP_capa.addTab("         站点位置            ", null, panel_posi, null);
		tP_capa.setBackgroundAt(2, SystemColor.activeCaption);
		GridBagLayout gbl_panel_posi = new GridBagLayout();
		gbl_panel_posi.columnWidths = new int[]{0, 0, 0, 39, 0, 0, 0};
		gbl_panel_posi.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 134, 0, 0};
		gbl_panel_posi.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_posi.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_posi.setLayout(gbl_panel_posi);
		
		JLabel lb_desPosit = new JLabel("为了支持提供物理组件或系统的静态和动态位置，可以利用以下任一方法来说明站点\"在哪里\"。");
		lb_desPosit.setFont(new Font("宋体", Font.ITALIC, 12));
		GridBagConstraints gbc_lb_desPosit = new GridBagConstraints();
		gbc_lb_desPosit.gridwidth = 5;
		gbc_lb_desPosit.insets = new Insets(15, 0, 10, 5);
		gbc_lb_desPosit.gridx = 0;
		gbc_lb_desPosit.gridy = 0;
		panel_posi.add(lb_desPosit, gbc_lb_desPosit);
		
		
		ButtonGroup positionButton = new ButtonGroup();
		positionButton.add(bt_text);
		positionButton.add(bt_point);
		positionButton.add(bt_location);
		bt_text = new JRadioButton("文字描述");
		positionButton.add(bt_text);
		bt_text.setForeground(SystemColor.textHighlight);
		bt_text.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_bt_text = new GridBagConstraints();
		gbc_bt_text.anchor = GridBagConstraints.WEST;
		gbc_bt_text.insets = new Insets(0, 0, 5, 5);
		gbc_bt_text.gridx = 1;
		gbc_bt_text.gridy = 1;
		panel_posi.add(bt_text, gbc_bt_text);
		bt_text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bt_text.isSelected()) {
					ta_text.setEditable(true);
					ta_text.setBackground(White);
					tf_pointSRS.setEditable(false);
					tf_pointX.setEditable(false);
					tf_pointY.setEditable(false);
					tf_pointSRS.setBackground(Grey);
					tf_pointX.setBackground(Grey);
					tf_pointY.setBackground(Grey);
					tf_pointSRS.setText("");
					tf_pointX.setText("");
					tf_pointY.setText("");
					tf_locSRS.setEditable(false);
					tf_locLat.setEditable(false);
					tf_locAlt.setEditable(false);
					tf_locLon.setEditable(false);
					tf_locSRS.setBackground(Grey);
					tf_locLat.setBackground(Grey);
					tf_locAlt.setBackground(Grey);
					tf_locLon.setBackground(Grey);
					tf_locSRS.setText("");
					tf_locLat.setText("");
					tf_locLon.setText("");
					tf_locAlt.setText("");
				}	
			}
		});
		
		JScrollPane scrollPane_9 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_9 = new GridBagConstraints();
		gbc_scrollPane_9.gridheight = 2;
		gbc_scrollPane_9.gridwidth = 5;
		gbc_scrollPane_9.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_9.insets = new Insets(0, 0, 5, 40);
		gbc_scrollPane_9.gridx = 1;
		gbc_scrollPane_9.gridy = 2;
		panel_posi.add(scrollPane_9, gbc_scrollPane_9);
		
		ta_text = new JTextArea();
		ta_text.setEditable(false);
		scrollPane_9.setViewportView(ta_text);
		
		bt_point = new JRadioButton("平面坐标 (纬度，经度)");
		positionButton.add(bt_point);
		bt_point.setForeground(SystemColor.textHighlight);
		bt_point.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_bt_point = new GridBagConstraints();
		gbc_bt_point.anchor = GridBagConstraints.WEST;
		gbc_bt_point.gridwidth = 2;
		gbc_bt_point.insets = new Insets(10, 0, 5, 5);
		gbc_bt_point.gridx = 1;
		gbc_bt_point.gridy = 4;
		panel_posi.add(bt_point, gbc_bt_point);
		bt_point.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bt_point.isSelected()) {
					tf_pointSRS.setEditable(true);
					tf_pointX.setEditable(true);
					tf_pointY.setEditable(true);
					tf_pointSRS.setBackground(White);
					tf_pointX.setBackground(White);
					tf_pointY.setBackground(White);
					ta_text.setEditable(false);
					ta_text.setBackground(Grey);
					ta_text.setText("");
					tf_locSRS.setEditable(false);
					tf_locLat.setEditable(false);
					tf_locAlt.setEditable(false);
					tf_locLon.setEditable(false);
					tf_locSRS.setBackground(Grey);
					tf_locLat.setBackground(Grey);
					tf_locAlt.setBackground(Grey);
					tf_locLon.setBackground(Grey);
					tf_locSRS.setText("");
					tf_locLat.setText("");
					tf_locLon.setText("");
					tf_locAlt.setText("");
				}	
			}
		});
		
		JLabel lb_pointSRS = new JLabel("  参考坐标系统:");
		GridBagConstraints gbc_lb_pointSRS = new GridBagConstraints();
		gbc_lb_pointSRS.anchor = GridBagConstraints.WEST;
		gbc_lb_pointSRS.insets = new Insets(0, 0, 5, 5);
		gbc_lb_pointSRS.gridx = 1;
		gbc_lb_pointSRS.gridy = 5;
		panel_posi.add(lb_pointSRS, gbc_lb_pointSRS);
		
		tf_pointSRS = new JTextField();
		hintText pointSRSHint = new hintText(tf_pointSRS, "urn:ogc:def:crs:OGC:1.3:EPSG:4329");
		tf_pointSRS.addFocusListener(new JTextFieldHintListener("urn:ogc:def:crs:OGC:1.3:EPSG:4329", tf_pointSRS));
		tf_pointSRS.setEditable(false);
		GridBagConstraints gbc_tf_pointSRS = new GridBagConstraints();
		gbc_tf_pointSRS.gridwidth = 4;
		gbc_tf_pointSRS.insets = new Insets(0, 0, 5, 40);
		gbc_tf_pointSRS.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_pointSRS.gridx = 2;
		gbc_tf_pointSRS.gridy = 5;
		panel_posi.add(tf_pointSRS, gbc_tf_pointSRS);
		tf_pointSRS.setColumns(10);
		
		JLabel lb_point = new JLabel("  点坐标(deg):");
		GridBagConstraints gbc_lb_point = new GridBagConstraints();
		gbc_lb_point.anchor = GridBagConstraints.WEST;
		gbc_lb_point.insets = new Insets(0, 0, 5, 5);
		gbc_lb_point.gridx = 1;
		gbc_lb_point.gridy = 6;
		panel_posi.add(lb_point, gbc_lb_point);
		
		tf_pointY = new JTextField();
		tf_pointY.setEditable(false);
		GridBagConstraints gbc_tf_pointY = new GridBagConstraints();
		gbc_tf_pointY.insets = new Insets(0, 0, 5, 5);
		gbc_tf_pointY.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_pointY.gridx = 2;
		gbc_tf_pointY.gridy = 6;
		panel_posi.add(tf_pointY, gbc_tf_pointY);
		tf_pointY.setColumns(10);
		
		JLabel lb_sep = new JLabel("，");
		GridBagConstraints gbc_lb_sep = new GridBagConstraints();
		gbc_lb_sep.insets = new Insets(0, 0, 5, 5);
		gbc_lb_sep.gridx = 3;
		gbc_lb_sep.gridy = 6;
		panel_posi.add(lb_sep, gbc_lb_sep);
		
		tf_pointX = new JTextField();
		tf_pointX.setEditable(false);
		tf_pointX.setColumns(10);
		GridBagConstraints gbc_tf_pointX = new GridBagConstraints();
		gbc_tf_pointX.insets = new Insets(0, 0, 5, 5);
		gbc_tf_pointX.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_pointX.gridx = 4;
		gbc_tf_pointX.gridy = 6;
		panel_posi.add(tf_pointX, gbc_tf_pointX);
		
		bt_location = new JRadioButton("空间位置");
		positionButton.add(bt_location);
		bt_location.setForeground(SystemColor.textHighlight);
		bt_location.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_bt_location = new GridBagConstraints();
		gbc_bt_location.anchor = GridBagConstraints.WEST;
		gbc_bt_location.gridwidth = 2;
		gbc_bt_location.insets = new Insets(10, 0, 5, 5);
		gbc_bt_location.gridx = 1;
		gbc_bt_location.gridy = 7;
		panel_posi.add(bt_location, gbc_bt_location);
		bt_location.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bt_location.isSelected()) {
					tf_locSRS.setEditable(true);
					tf_locLat.setEditable(true);
					tf_locAlt.setEditable(true);
					tf_locLon.setEditable(true);
					tf_locSRS.setBackground(White);
					tf_locLat.setBackground(White);
					tf_locAlt.setBackground(White);
					tf_locLon.setBackground(White);
					ta_text.setEditable(false);
					ta_text.setBackground(Grey);
					ta_text.setText("");
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
		
		JLabel lb_locSRS = new JLabel("  参考坐标系统:");
		GridBagConstraints gbc_lb_locSRS = new GridBagConstraints();
		gbc_lb_locSRS.anchor = GridBagConstraints.EAST;
		gbc_lb_locSRS.insets = new Insets(0, 0, 5, 5);
		gbc_lb_locSRS.gridx = 1;
		gbc_lb_locSRS.gridy = 8;
		panel_posi.add(lb_locSRS, gbc_lb_locSRS);
		
		tf_locSRS = new JTextField();
		hintText locSRSHint = new hintText(tf_locSRS, "urn:ogc:def:crs:OGC:1.3:EPSG:4329");
		tf_locSRS.addFocusListener(new JTextFieldHintListener("urn:ogc:def:crs:OGC:1.3:EPSG:4329", tf_locSRS));
		tf_locSRS.setEditable(false);
		tf_locSRS.setColumns(10);
		GridBagConstraints gbc_tf_locSRS = new GridBagConstraints();
		gbc_tf_locSRS.insets = new Insets(0, 0, 5, 40);
		gbc_tf_locSRS.gridwidth = 4;
		gbc_tf_locSRS.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_locSRS.gridx = 2;
		gbc_tf_locSRS.gridy = 8;
		panel_posi.add(tf_locSRS, gbc_tf_locSRS);
		
		JLabel lb_locLat = new JLabel("  纬度(deg):");
		GridBagConstraints gbc_lb_locLat = new GridBagConstraints();
		gbc_lb_locLat.anchor = GridBagConstraints.WEST;
		gbc_lb_locLat.insets = new Insets(0, 0, 5, 5);
		gbc_lb_locLat.gridx = 1;
		gbc_lb_locLat.gridy = 9;
		panel_posi.add(lb_locLat, gbc_lb_locLat);
		
		tf_locLat = new JTextField();
		tf_locLat.setEditable(false);
		tf_locLat.setColumns(10);
		GridBagConstraints gbc_tf_locLat = new GridBagConstraints();
		gbc_tf_locLat.gridwidth = 2;
		gbc_tf_locLat.insets = new Insets(0, 0, 5, 5);
		gbc_tf_locLat.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_locLat.gridx = 2;
		gbc_tf_locLat.gridy = 9;
		panel_posi.add(tf_locLat, gbc_tf_locLat);
		
		JLabel lb_locLon = new JLabel("  经度(deg):");
		GridBagConstraints gbc_lb_locLon = new GridBagConstraints();
		gbc_lb_locLon.anchor = GridBagConstraints.WEST;
		gbc_lb_locLon.insets = new Insets(0, 0, 5, 5);
		gbc_lb_locLon.gridx = 1;
		gbc_lb_locLon.gridy = 10;
		panel_posi.add(lb_locLon, gbc_lb_locLon);
		
		tf_locLon = new JTextField();
		tf_locLon.setEditable(false);
		tf_locLon.setColumns(10);
		GridBagConstraints gbc_tf_locLon = new GridBagConstraints();
		gbc_tf_locLon.gridwidth = 2;
		gbc_tf_locLon.insets = new Insets(0, 0, 5, 5);
		gbc_tf_locLon.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_locLon.gridx = 2;
		gbc_tf_locLon.gridy = 10;
		panel_posi.add(tf_locLon, gbc_tf_locLon);
		
		JLabel lb_locAlt = new JLabel("  海拔(m):");
		GridBagConstraints gbc_lb_locAlt = new GridBagConstraints();
		gbc_lb_locAlt.insets = new Insets(0, 0, 5, 5);
		gbc_lb_locAlt.anchor = GridBagConstraints.WEST;
		gbc_lb_locAlt.gridx = 1;
		gbc_lb_locAlt.gridy = 11;
		panel_posi.add(lb_locAlt, gbc_lb_locAlt);
		
		tf_locAlt = new JTextField();
		tf_locAlt.setEditable(false);
		tf_locAlt.setColumns(10);
		GridBagConstraints gbc_tf_locAlt = new GridBagConstraints();
		gbc_tf_locAlt.gridwidth = 2;
		gbc_tf_locAlt.insets = new Insets(0, 0, 5, 5);
		gbc_tf_locAlt.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_locAlt.gridx = 2;
		gbc_tf_locAlt.gridy = 11;
		panel_posi.add(tf_locAlt, gbc_tf_locAlt);
		
		
		//“联系服务信息”页面
		cont_panel = new JPanel();
		tp.addTab("联系服务信息", null, cont_panel, null);
		GridBagLayout gbl_cont_panel = new GridBagLayout();
		gbl_cont_panel.columnWidths = new int[]{0, 0, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_cont_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 39, 0, 27, 0};
		gbl_cont_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_cont_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		cont_panel.setLayout(gbl_cont_panel);
		
		JLabel lb_respon = new JLabel("负责单位");
		lb_respon.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_respon = new GridBagConstraints();
		gbc_lb_respon.insets = new Insets(10, 0, 5, 5);
		gbc_lb_respon.gridx = 0;
		gbc_lb_respon.gridy = 0;
		cont_panel.add(lb_respon, gbc_lb_respon);
		
		JLabel lb_history = new JLabel("服务历史");
		lb_history.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_history = new GridBagConstraints();
		gbc_lb_history.fill = GridBagConstraints.HORIZONTAL;
		gbc_lb_history.gridwidth = 2;
		gbc_lb_history.insets = new Insets(10, 0, 5, 5);
		gbc_lb_history.gridx = 5;
		gbc_lb_history.gridy = 0;
		cont_panel.add(lb_history, gbc_lb_history);
		
		ckbx_role = new JCheckBox("负责角色:");
		ckbx_role.setSelected(true);
		GridBagConstraints gbc_ckbx_role = new GridBagConstraints();
		gbc_ckbx_role.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_role.gridx = 0;
		gbc_ckbx_role.gridy = 1;
		cont_panel.add(ckbx_role, gbc_ckbx_role);
		
		cbbx_role = new JComboBox();
		cbbx_role.setModel(new DefaultComboBoxModel(new String[] {"制造商", "管理者", "使用者"}));
		GridBagConstraints gbc_cbbx_role = new GridBagConstraints();
		gbc_cbbx_role.gridwidth = 4;
		gbc_cbbx_role.insets = new Insets(0, 0, 5, 5);
		gbc_cbbx_role.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbx_role.gridx = 1;
		gbc_cbbx_role.gridy = 1;
		cont_panel.add(cbbx_role, gbc_cbbx_role);
		
		ckbx_eventID = new JCheckBox("事件编号:");
		GridBagConstraints gbc_ckbx_eventID = new GridBagConstraints();
		gbc_ckbx_eventID.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_eventID.gridx = 5;
		gbc_ckbx_eventID.gridy = 1;
		cont_panel.add(ckbx_eventID, gbc_ckbx_eventID);
		ckbx_eventID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_eventID.isSelected()) {
					tf_eventId.setEditable(true);
					tf_eventLabel.setEditable(true);
					tf_eventId.setBackground(White);
					tf_eventLabel.setBackground(White);
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
		tf_eventId.setColumns(10);
		GridBagConstraints gbc_tf_eventId = new GridBagConstraints();
		gbc_tf_eventId.insets = new Insets(0, 0, 5, 5);
		gbc_tf_eventId.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_eventId.gridx = 6;
		gbc_tf_eventId.gridy = 1;
		cont_panel.add(tf_eventId, gbc_tf_eventId);
		
		JLabel lb_eventLabel = new JLabel("事件标签:");
		GridBagConstraints gbc_lb_eventLabel = new GridBagConstraints();
		gbc_lb_eventLabel.gridwidth = 2;
		gbc_lb_eventLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lb_eventLabel.gridx = 7;
		gbc_lb_eventLabel.gridy = 1;
		cont_panel.add(lb_eventLabel, gbc_lb_eventLabel);
		
		tf_eventLabel = new JTextField();
		hintText eventLabelHint = new hintText(tf_eventLabel, "如：SOS");
		tf_eventLabel.addFocusListener(new JTextFieldHintListener("如：SOS", tf_eventLabel));
		tf_eventLabel.setEditable(false);
		tf_eventLabel.setColumns(10);
		GridBagConstraints gbc_tf_eventLabel = new GridBagConstraints();
		gbc_tf_eventLabel.gridwidth = 2;
		gbc_tf_eventLabel.insets = new Insets(0, 0, 5, 0);
		gbc_tf_eventLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_eventLabel.gridx = 9;
		gbc_tf_eventLabel.gridy = 1;
		cont_panel.add(tf_eventLabel, gbc_tf_eventLabel);
		
		ckbx_orgniz = new JCheckBox("组织名称:");
		ckbx_orgniz.setSelected(true);
		GridBagConstraints gbc_ckbx_orgniz = new GridBagConstraints();
		gbc_ckbx_orgniz.insets = new Insets(0, 10, 5, 5);
		gbc_ckbx_orgniz.gridx = 0;
		gbc_ckbx_orgniz.gridy = 2;
		cont_panel.add(ckbx_orgniz, gbc_ckbx_orgniz);
		
		tf_orgniz = new JTextField();
		GridBagConstraints gbc_tf_orgniz = new GridBagConstraints();
		gbc_tf_orgniz.gridwidth = 4;
		gbc_tf_orgniz.insets = new Insets(0, 0, 5, 5);
		gbc_tf_orgniz.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_orgniz.gridx = 1;
		gbc_tf_orgniz.gridy = 2;
		cont_panel.add(tf_orgniz, gbc_tf_orgniz);
		tf_orgniz.setColumns(10);
		
		ckbx_EDesc = new JCheckBox("事件描述:");
		GridBagConstraints gbc_ckbx_EDesc = new GridBagConstraints();
		gbc_ckbx_EDesc.anchor = GridBagConstraints.WEST;
		gbc_ckbx_EDesc.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_EDesc.gridx = 5;
		gbc_ckbx_EDesc.gridy = 2;
		cont_panel.add(ckbx_EDesc, gbc_ckbx_EDesc);
		ckbx_EDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_EDesc.isSelected()) {
					ta_EDesc.setBackground(White);
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
		cont_panel.add(ckbx_person, gbc_ckbx_person);
		ckbx_person.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_person.isSelected()) {
					tf_person.setEditable(true);
					tf_person.setBackground(White);
				}else {
					tf_person.setEditable(false);
					tf_person.setBackground(Grey);
					tf_person.setText("");
				}	
			}
		});
		
		tf_person = new JTextField();
		tf_person.setEditable(false);
		tf_person.setColumns(10);
		GridBagConstraints gbc_tf_person = new GridBagConstraints();
		gbc_tf_person.gridwidth = 4;
		gbc_tf_person.insets = new Insets(0, 0, 5, 5);
		gbc_tf_person.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_person.gridx = 1;
		gbc_tf_person.gridy = 3;
		cont_panel.add(tf_person, gbc_tf_person);
		
		JScrollPane scrollPane_12 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_12 = new GridBagConstraints();
		gbc_scrollPane_12.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_12.gridheight = 2;
		gbc_scrollPane_12.gridwidth = 6;
		gbc_scrollPane_12.insets = new Insets(0, 20, 5, 10);
		gbc_scrollPane_12.gridx = 5;
		gbc_scrollPane_12.gridy = 3;
		cont_panel.add(scrollPane_12, gbc_scrollPane_12);
		
		ta_EDesc = new JTextArea();
		ta_EDesc.setEditable(false);
		scrollPane_12.setViewportView(ta_EDesc);
		
		JLabel lb_contInfo = new JLabel("   联系信息:");
		GridBagConstraints gbc_lb_contInfo = new GridBagConstraints();
		gbc_lb_contInfo.anchor = GridBagConstraints.WEST;
		gbc_lb_contInfo.insets = new Insets(0, 10, 5, 5);
		gbc_lb_contInfo.gridx = 0;
		gbc_lb_contInfo.gridy = 4;
		cont_panel.add(lb_contInfo, gbc_lb_contInfo);
		
		ckbx_tele = new JCheckBox("电话:");
		GridBagConstraints gbc_ckbx_tele = new GridBagConstraints();
		gbc_ckbx_tele.anchor = GridBagConstraints.WEST;
		gbc_ckbx_tele.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_tele.gridx = 1;
		gbc_ckbx_tele.gridy = 4;
		cont_panel.add(ckbx_tele, gbc_ckbx_tele);
		ckbx_tele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (ckbx_tele.isSelected()) {
						tf_tele.setEditable(true);
						tf_tele.setBackground(White);
					}else {
						tf_tele.setEditable(false);
						tf_tele.setBackground(Grey);
						tf_tele.setText("");
					}
			}
		});
		
		tf_tele = new JTextField();
		tf_tele.setEditable(false);
		tf_tele.setColumns(10);
		GridBagConstraints gbc_tf_tele = new GridBagConstraints();
		gbc_tf_tele.gridwidth = 3;
		gbc_tf_tele.insets = new Insets(0, 0, 5, 5);
		gbc_tf_tele.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_tele.gridx = 2;
		gbc_tf_tele.gridy = 4;
		cont_panel.add(tf_tele, gbc_tf_tele);
		
		ckbx_addr = new JCheckBox("地址:");
		GridBagConstraints gbc_ckbx_addr = new GridBagConstraints();
		gbc_ckbx_addr.anchor = GridBagConstraints.WEST;
		gbc_ckbx_addr.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_addr.gridx = 1;
		gbc_ckbx_addr.gridy = 5;
		cont_panel.add(ckbx_addr, gbc_ckbx_addr);
		ckbx_addr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_addr.isSelected()) {
					tf_addr.setEditable(true);
					tf_city.setEditable(true);
					tf_admi.setEditable(true);
					tf_country.setEditable(true);
					tf_code.setEditable(true);
					tf_email.setEditable(true);
					tf_addr.setBackground(White);
					tf_city.setBackground(White);
					tf_admi.setBackground(White);
					tf_country.setBackground(White);
					tf_code.setBackground(White);
					tf_email.setBackground(White);
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
		cont_panel.add(lb_tipETM, gbc_lb_tipETM);
		
		JLabel label = new JLabel("邮寄地址:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 6;
		cont_panel.add(label, gbc_label);
		
		tf_addr = new JTextField();
		tf_addr.setEditable(false);
		tf_addr.setColumns(10);
		GridBagConstraints gbc_tf_addr = new GridBagConstraints();
		gbc_tf_addr.gridwidth = 3;
		gbc_tf_addr.insets = new Insets(0, 0, 5, 5);
		gbc_tf_addr.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_addr.gridx = 2;
		gbc_tf_addr.gridy = 6;
		cont_panel.add(tf_addr, gbc_tf_addr);
		
		ckbx_ETime = new JRadioButton("事件时间范围:");
		bg.add(ckbx_ETime);
		GridBagConstraints gbc_ckbx_ETime = new GridBagConstraints();
		gbc_ckbx_ETime.anchor = GridBagConstraints.WEST;
		gbc_ckbx_ETime.gridwidth = 2;
		gbc_ckbx_ETime.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_ETime.gridx = 5;
		gbc_ckbx_ETime.gridy = 6;
		cont_panel.add(ckbx_ETime, gbc_ckbx_ETime);
		ckbx_ETime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_ETime.isSelected()) {
					tf_EBeginTM.setEditable(true);
					tf_EEndTM.setEditable(true);
					tf_EBeginTM.setBackground(White);
					tf_EEndTM.setBackground(White);
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
		cont_panel.add(lb_city, gbc_lb_city);
		
		tf_city = new JTextField();
		tf_city.setEditable(false);
		tf_city.setColumns(10);
		GridBagConstraints gbc_tf_city = new GridBagConstraints();
		gbc_tf_city.gridwidth = 3;
		gbc_tf_city.insets = new Insets(0, 0, 5, 5);
		gbc_tf_city.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_city.gridx = 2;
		gbc_tf_city.gridy = 7;
		cont_panel.add(tf_city, gbc_tf_city);
		
		JLabel lb_EBeginTM = new JLabel(" 起始时间:");
		GridBagConstraints gbc_lb_EBeginTM = new GridBagConstraints();
		gbc_lb_EBeginTM.anchor = GridBagConstraints.EAST;
		gbc_lb_EBeginTM.insets = new Insets(0, 0, 5, 5);
		gbc_lb_EBeginTM.gridx = 5;
		gbc_lb_EBeginTM.gridy = 7;
		cont_panel.add(lb_EBeginTM, gbc_lb_EBeginTM);
		
		tf_EBeginTM = new JTextField();
		hintText ebgTMHint = new hintText(tf_EBeginTM, "2017-08-01T11:30:00.000Z");
		tf_EBeginTM.addFocusListener(new JTextFieldHintListener("2017-08-01T11:30:00.000Z", tf_EBeginTM));
		tf_EBeginTM.setEditable(false);
		tf_EBeginTM.setColumns(10);
		GridBagConstraints gbc_tf_EBeginTM = new GridBagConstraints();
		gbc_tf_EBeginTM.gridwidth = 5;
		gbc_tf_EBeginTM.insets = new Insets(0, 0, 5, 10);
		gbc_tf_EBeginTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_EBeginTM.gridx = 6;
		gbc_tf_EBeginTM.gridy = 7;
		cont_panel.add(tf_EBeginTM, gbc_tf_EBeginTM);
		
		JLabel lb_admi = new JLabel("行政区域:");
		GridBagConstraints gbc_lb_admi = new GridBagConstraints();
		gbc_lb_admi.anchor = GridBagConstraints.WEST;
		gbc_lb_admi.insets = new Insets(0, 0, 5, 5);
		gbc_lb_admi.gridx = 1;
		gbc_lb_admi.gridy = 8;
		cont_panel.add(lb_admi, gbc_lb_admi);
		
		tf_admi = new JTextField();
		tf_admi.setEditable(false);
		tf_admi.setColumns(10);
		GridBagConstraints gbc_tf_admi = new GridBagConstraints();
		gbc_tf_admi.gridwidth = 3;
		gbc_tf_admi.insets = new Insets(0, 0, 5, 5);
		gbc_tf_admi.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_admi.gridx = 2;
		gbc_tf_admi.gridy = 8;
		cont_panel.add(tf_admi, gbc_tf_admi);
		
		JLabel lb_EEndTM = new JLabel(" 结束时间:");
		GridBagConstraints gbc_lb_EEndTM = new GridBagConstraints();
		gbc_lb_EEndTM.anchor = GridBagConstraints.EAST;
		gbc_lb_EEndTM.insets = new Insets(0, 0, 5, 5);
		gbc_lb_EEndTM.gridx = 5;
		gbc_lb_EEndTM.gridy = 8;
		cont_panel.add(lb_EEndTM, gbc_lb_EEndTM);
		
		tf_EEndTM = new JTextField();
		hintText eedTMHint = new hintText(tf_EEndTM, "2017-08-01T18:30:00.000Z");
		tf_EEndTM.addFocusListener(new JTextFieldHintListener("2017-08-01T18:30:00.000Z", tf_EEndTM));
		tf_EEndTM.setEditable(false);
		tf_EEndTM.setColumns(10);
		GridBagConstraints gbc_tf_EEndTM = new GridBagConstraints();
		gbc_tf_EEndTM.gridwidth = 5;
		gbc_tf_EEndTM.insets = new Insets(0, 0, 5, 10);
		gbc_tf_EEndTM.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_EEndTM.gridx = 6;
		gbc_tf_EEndTM.gridy = 8;
		cont_panel.add(tf_EEndTM, gbc_tf_EEndTM);
		
		JLabel lb_country = new JLabel("国家:");
		GridBagConstraints gbc_lb_country = new GridBagConstraints();
		gbc_lb_country.anchor = GridBagConstraints.WEST;
		gbc_lb_country.insets = new Insets(0, 0, 5, 5);
		gbc_lb_country.gridx = 1;
		gbc_lb_country.gridy = 9;
		cont_panel.add(lb_country, gbc_lb_country);
		
		tf_country = new JTextField();
		tf_country.setEditable(false);
		tf_country.setColumns(10);
		GridBagConstraints gbc_tf_country = new GridBagConstraints();
		gbc_tf_country.gridwidth = 3;
		gbc_tf_country.insets = new Insets(0, 0, 5, 5);
		gbc_tf_country.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_country.gridx = 2;
		gbc_tf_country.gridy = 9;
		cont_panel.add(tf_country, gbc_tf_country);
		
		ckbx_ETMIns = new JRadioButton("事件时刻:");
		bg.add(ckbx_ETMIns);
		GridBagConstraints gbc_ckbx_ETMIns = new GridBagConstraints();
		gbc_ckbx_ETMIns.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_ETMIns.gridx = 5;
		gbc_ckbx_ETMIns.gridy = 9;
		cont_panel.add(ckbx_ETMIns, gbc_ckbx_ETMIns);
		ckbx_ETMIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_ETMIns.isSelected()) {
					tf_ETMIns.setEditable(true);
					tf_ETMIns.setBackground(White);
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
		tf_ETMIns.setColumns(10);
		GridBagConstraints gbc_tf_ETMIns = new GridBagConstraints();
		gbc_tf_ETMIns.gridwidth = 5;
		gbc_tf_ETMIns.insets = new Insets(0, 0, 5, 10);
		gbc_tf_ETMIns.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_ETMIns.gridx = 6;
		gbc_tf_ETMIns.gridy = 9;
		cont_panel.add(tf_ETMIns, gbc_tf_ETMIns);
		
		JButton bt_addE = new JButton("增加");
		bt_addE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {getEventID(),getEventLabel()};
				eventModel.addRow(info);
			}
		});
		
		JLabel lb_code = new JLabel("邮政编码:");
		GridBagConstraints gbc_lb_code = new GridBagConstraints();
		gbc_lb_code.anchor = GridBagConstraints.WEST;
		gbc_lb_code.insets = new Insets(0, 0, 5, 5);
		gbc_lb_code.gridx = 1;
		gbc_lb_code.gridy = 10;
		cont_panel.add(lb_code, gbc_lb_code);
		
		tf_code = new JTextField();
		tf_code.setEditable(false);
		tf_code.setColumns(10);
		GridBagConstraints gbc_tf_code = new GridBagConstraints();
		gbc_tf_code.gridwidth = 3;
		gbc_tf_code.insets = new Insets(0, 0, 5, 5);
		gbc_tf_code.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_code.gridx = 2;
		gbc_tf_code.gridy = 10;
		cont_panel.add(tf_code, gbc_tf_code);
		GridBagConstraints gbc_bt_addE = new GridBagConstraints();
		gbc_bt_addE.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addE.gridx = 9;
		gbc_bt_addE.gridy = 10;
		cont_panel.add(bt_addE, gbc_bt_addE);
		
		JButton bt_deleE = new JButton("删除");
		bt_deleE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_event.getSelectedRow();
				if(selectedRow!=-1)  //存在选中行
                {
                    eventModel.removeRow(selectedRow);  //删除行
                }
			}
		});
		GridBagConstraints gbc_bt_deleE = new GridBagConstraints();
		gbc_bt_deleE.insets = new Insets(0, 0, 5, 10);
		gbc_bt_deleE.gridx = 10;
		gbc_bt_deleE.gridy = 10;
		cont_panel.add(bt_deleE, gbc_bt_deleE);
		
		JLabel lb_email = new JLabel("电子邮箱:");
		GridBagConstraints gbc_lb_email = new GridBagConstraints();
		gbc_lb_email.anchor = GridBagConstraints.WEST;
		gbc_lb_email.insets = new Insets(0, 0, 5, 5);
		gbc_lb_email.gridx = 1;
		gbc_lb_email.gridy = 11;
		cont_panel.add(lb_email, gbc_lb_email);
		
		tf_email = new JTextField();
		tf_email.setEditable(false);
		tf_email.setColumns(10);
		GridBagConstraints gbc_tf_email = new GridBagConstraints();
		gbc_tf_email.gridwidth = 3;
		gbc_tf_email.insets = new Insets(0, 0, 5, 5);
		gbc_tf_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_email.gridx = 2;
		gbc_tf_email.gridy = 11;
		cont_panel.add(tf_email, gbc_tf_email);
		
		JScrollPane scrollPane_13 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_13 = new GridBagConstraints();
		gbc_scrollPane_13.gridheight = 3;
		gbc_scrollPane_13.gridwidth = 6;
		gbc_scrollPane_13.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_13.insets = new Insets(0, 5, 5, 10);
		gbc_scrollPane_13.gridx = 5;
		gbc_scrollPane_13.gridy = 11;
		cont_panel.add(scrollPane_13, gbc_scrollPane_13);
		
		tb_event = new JTable();
		tb_event.setBackground(new Color(175, 238, 238));
		eventModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"事件编号", "事件标签"
				}
			);
		tb_event.setModel(eventModel);
		scrollPane_13.setViewportView(tb_event);
		tb_event.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton bt_addCon = new JButton("增加");
		bt_addCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = {getResponsibleParty(),getOrganization()};
				contactModel.addRow(info);//添加一行
			}
		});
		GridBagConstraints gbc_bt_addCon = new GridBagConstraints();
		gbc_bt_addCon.anchor = GridBagConstraints.SOUTH;
		gbc_bt_addCon.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addCon.gridx = 3;
		gbc_bt_addCon.gridy = 12;
		cont_panel.add(bt_addCon, gbc_bt_addCon);
		
		JButton bt_deleCon = new JButton("删除");
		bt_deleCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_contacID.getSelectedRow();//获得选中行的索引
				if(selectedRow!=-1)  //存在选中行
                {
                    contactModel.removeRow(selectedRow);  //删除行
                }
			}
		});
		GridBagConstraints gbc_bt_deleCon = new GridBagConstraints();
		gbc_bt_deleCon.insets = new Insets(0, 0, 5, 5);
		gbc_bt_deleCon.gridx = 4;
		gbc_bt_deleCon.gridy = 12;
		cont_panel.add(bt_deleCon, gbc_bt_deleCon);
		
		JLabel lb_interface = new JLabel("服务接口");
		lb_interface.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_interface = new GridBagConstraints();
		gbc_lb_interface.fill = GridBagConstraints.HORIZONTAL;
		gbc_lb_interface.gridwidth = 2;
		gbc_lb_interface.insets = new Insets(0, 0, 5, 5);
		gbc_lb_interface.gridx = 5;
		gbc_lb_interface.gridy = 14;
		cont_panel.add(lb_interface, gbc_lb_interface);
		
		JButton bt_addInte = new JButton("增加");
		bt_addInte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				interfaceDialog interfaceDialog = new interfaceDialog();
				interfaceDialog.setVisible(true);
				interfaceDialog.setAlwaysOnTop(true);
			}
		});
		GridBagConstraints gbc_bt_addInte = new GridBagConstraints();
		gbc_bt_addInte.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addInte.gridx = 9;
		gbc_bt_addInte.gridy = 14;
		cont_panel.add(bt_addInte, gbc_bt_addInte);
		
		JButton bt_deleInte = new JButton("删除");
		bt_deleInte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_inte.getSelectedRow();
				if(selectedRow!=-1) 
                {
                    model.removeRow(selectedRow); 
                }
			}
		});
		GridBagConstraints gbc_bt_deleInte = new GridBagConstraints();
		gbc_bt_deleInte.insets = new Insets(0, 0, 5, 10);
		gbc_bt_deleInte.gridx = 10;
		gbc_bt_deleInte.gridy = 14;
		cont_panel.add(bt_deleInte, gbc_bt_deleInte);
		
		JScrollPane scrollPane_11 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_11 = new GridBagConstraints();
		gbc_scrollPane_11.gridheight = 3;
		gbc_scrollPane_11.insets = new Insets(0, 5, 5, 10);
		gbc_scrollPane_11.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_11.gridwidth = 6;
		gbc_scrollPane_11.gridx = 5;
		gbc_scrollPane_11.gridy = 15;
		cont_panel.add(scrollPane_11, gbc_scrollPane_11);
		
		tb_inte = new JTable();
		tb_inte.setBackground(new Color(175, 238, 238));
		interfaceModel = new DefaultTableModel(
				new Object[][] {},
				new String[] {"接口名称", "服务类型", "服务地址", "传感器标识码"});
		tb_inte.setModel(interfaceModel);
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
		cont_panel.add(scrollPane_10, gbc_scrollPane_10);
		
		tb_contacID = new JTable();
		contactModel =new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"负责单位", "联系组织"
				}
			);
		tb_contacID.setModel(contactModel);
		scrollPane_10.setViewportView(tb_contacID);
		tb_contacID.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//“平台组件信息”页面
		comp_panel = new JPanel();
		tp.addTab("传感器部件信息", null, comp_panel, null);
		GridBagLayout gbl_comp_panel = new GridBagLayout();
		gbl_comp_panel.columnWidths = new int[]{33, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_comp_panel.rowHeights = new int[]{0, 0, 0, 32, 0, 0, 0, 32, 0, 0, 0, 31, 0, 0, 0, 31, 0, 0, 0, 0, 0};
		gbl_comp_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_comp_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		comp_panel.setLayout(gbl_comp_panel);
		
		JCheckBox ckbx_input = new JCheckBox("添加输入：");
		ckbx_input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_input.isSelected()) {
					bt_addIn.setEnabled(true);
					bt_deleIn.setEnabled(true);
				}else {
					bt_addIn.setEnabled(false);
					bt_deleIn.setEnabled(false);
					inputModel.setRowCount(0);
				}
			}
		});
		ckbx_input.setSelected(true);
		GridBagConstraints gbc_ckbx_input = new GridBagConstraints();
		gbc_ckbx_input.gridwidth = 6;
		gbc_ckbx_input.anchor = GridBagConstraints.WEST;
		gbc_ckbx_input.insets = new Insets(15, 0, 5, 5);
		gbc_ckbx_input.gridx = 1;
		gbc_ckbx_input.gridy = 0;
		comp_panel.add(ckbx_input, gbc_ckbx_input);
		
		bt_addIn = new JButton("增加");
		bt_addIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputDialog inDialog = new inputDialog(); 	
				inDialog.setLocationRelativeTo(frame);
				inDialog.setVisible(true);
				inDialog.setAlwaysOnTop(true);
			}
		});
		GridBagConstraints gbc_bt_addIn = new GridBagConstraints();
		gbc_bt_addIn.anchor = GridBagConstraints.SOUTH;
		gbc_bt_addIn.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addIn.gridx = 7;
		gbc_bt_addIn.gridy = 0;
		comp_panel.add(bt_addIn, gbc_bt_addIn);
		
		bt_deleIn = new JButton("删除");
		bt_deleIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_input.getSelectedRow();
				if(selectedRow!=-1)  
                {
                    inputModel.removeRow(selectedRow);  
                }
			}
		});
		GridBagConstraints gbc_bt_deleIn = new GridBagConstraints();
		gbc_bt_deleIn.anchor = GridBagConstraints.SOUTH;
		gbc_bt_deleIn.insets = new Insets(0, 0, 5, 20);
		gbc_bt_deleIn.gridx = 8;
		gbc_bt_deleIn.gridy = 0;
		comp_panel.add(bt_deleIn, gbc_bt_deleIn);
		
		JScrollPane scrollPane_14 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_14 = new GridBagConstraints();
		gbc_scrollPane_14.gridheight = 3;
		gbc_scrollPane_14.insets = new Insets(0, 0, 5, 20);
		gbc_scrollPane_14.gridwidth = 8;
		gbc_scrollPane_14.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_14.gridx = 1;
		gbc_scrollPane_14.gridy = 1;
		comp_panel.add(scrollPane_14, gbc_scrollPane_14);
		
		tb_input = new JTable();
		tb_input.setBackground(new Color(175, 238, 238));
		inputModel = new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"输入现象名称：", "输入现象定义："
				}
			);
		tb_input.setModel(inputModel);
		scrollPane_14.setViewportView(tb_input);
		
		ckbx_output = new JCheckBox("添加输出：");
		GridBagConstraints gbc_ckbx_output = new GridBagConstraints();
		gbc_ckbx_output.gridwidth = 6;
		gbc_ckbx_output.anchor = GridBagConstraints.WEST;
		gbc_ckbx_output.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_output.gridx = 1;
		gbc_ckbx_output.gridy = 4;
		comp_panel.add(ckbx_output, gbc_ckbx_output);
		
		JButton bt_addOut = new JButton("增加");
		bt_addOut.setEnabled(false);
		bt_addOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputDialog outDialog = new outputDialog();
				outDialog.setLocationRelativeTo(frame);
				outDialog.setVisible(true);
				outDialog.setAlwaysOnTop(true);
			}
		});
		GridBagConstraints gbc_bt_addOut = new GridBagConstraints();
		gbc_bt_addOut.anchor = GridBagConstraints.SOUTH;
		gbc_bt_addOut.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addOut.gridx = 7;
		gbc_bt_addOut.gridy = 4;
		comp_panel.add(bt_addOut, gbc_bt_addOut);
		
		JButton bt_deleOut = new JButton("删除");
		bt_deleOut.setEnabled(false);
		bt_deleOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_Out.getSelectedRow();
				if(selectedRow!=-1)  
                {
                    outputModel.removeRow(selectedRow);  
                }
			}
		});
		GridBagConstraints gbc_bt_deleOut = new GridBagConstraints();
		gbc_bt_deleOut.anchor = GridBagConstraints.SOUTH;
		gbc_bt_deleOut.insets = new Insets(0, 0, 5, 20);
		gbc_bt_deleOut.gridx = 8;
		gbc_bt_deleOut.gridy = 4;
		comp_panel.add(bt_deleOut, gbc_bt_deleOut);
		ckbx_output.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_output.isSelected()) {
					bt_addOut.setEnabled(true);
					bt_deleOut.setEnabled(true);
				}else {
					bt_addOut.setEnabled(false);
					bt_deleOut.setEnabled(false);
					outputModel.setRowCount(0);
				}	
			}
		});
		
		JScrollPane scrollPane_15 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_15 = new GridBagConstraints();
		gbc_scrollPane_15.gridheight = 3;
		gbc_scrollPane_15.gridwidth = 8;
		gbc_scrollPane_15.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_15.insets = new Insets(0, 0, 5, 20);
		gbc_scrollPane_15.gridx = 1;
		gbc_scrollPane_15.gridy = 5;
		comp_panel.add(scrollPane_15, gbc_scrollPane_15);
		
		tb_Out = new JTable();
		tb_Out.setBackground(new Color(175, 238, 238));
		outputModel = new DefaultTableModel(new Object[][] {},new String[] {"输出名称：", "输出定义：", "输出单位："});
		tb_Out.setModel(outputModel);
		scrollPane_15.setViewportView(tb_Out);
		
		ckbx_param = new JCheckBox("添加参数：");
		GridBagConstraints gbc_ckbx_param = new GridBagConstraints();
		gbc_ckbx_param.gridwidth = 6;
		gbc_ckbx_param.anchor = GridBagConstraints.WEST;
		gbc_ckbx_param.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_param.gridx = 1;
		gbc_ckbx_param.gridy = 8;
		comp_panel.add(ckbx_param, gbc_ckbx_param);
		
		JButton bt_addParam = new JButton("增加");
		bt_addParam.setEnabled(false);
		bt_addParam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameterDialog parameterDialog = new parameterDialog();	
				parameterDialog.setLocationRelativeTo(frame);
				parameterDialog.setAlwaysOnTop(true);
				parameterDialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_bt_addParam = new GridBagConstraints();
		gbc_bt_addParam.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addParam.gridx = 7;
		gbc_bt_addParam.gridy = 8;
		comp_panel.add(bt_addParam, gbc_bt_addParam);
		
		JButton bt_deleParam = new JButton("删除");
		bt_deleParam.setEnabled(false);
		bt_deleParam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_param.getSelectedRow();
				if(selectedRow!=-1)  
                {
                    parameterModel.removeRow(selectedRow); 
                }
				
			}
		});
		GridBagConstraints gbc_bt_deleParam = new GridBagConstraints();
		gbc_bt_deleParam.insets = new Insets(0, 0, 5, 20);
		gbc_bt_deleParam.gridx = 8;
		gbc_bt_deleParam.gridy = 8;
		comp_panel.add(bt_deleParam, gbc_bt_deleParam);
		ckbx_param.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_param.isSelected()) {
					bt_addParam.setEnabled(true);
					bt_deleParam.setEnabled(true);
				}else {
					bt_addParam.setEnabled(false);
					bt_deleParam.setEnabled(false);
					parameterModel.setRowCount(0);
				}	
			}
		});
		
		
		JScrollPane scrollPane_16 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_16 = new GridBagConstraints();
		gbc_scrollPane_16.gridheight = 3;
		gbc_scrollPane_16.gridwidth = 8;
		gbc_scrollPane_16.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_16.insets = new Insets(0, 0, 5, 20);
		gbc_scrollPane_16.gridx = 1;
		gbc_scrollPane_16.gridy = 9;
		comp_panel.add(scrollPane_16, gbc_scrollPane_16);
		
		tb_param = new JTable();
		tb_param.setBackground(new Color(175, 238, 238));
		parameterModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u53C2\u6570\u540D\u79F0\uFF1A", "\u53C2\u6570\u5B9A\u4E49\uFF1A", "\u53C2\u6570\u5355\u4F4D\uFF1A"
				}
			);
		tb_param.setModel(parameterModel);
		tb_param.getColumnModel().getColumn(0).setPreferredWidth(80);
		tb_param.getColumnModel().getColumn(1).setPreferredWidth(80);
		tb_param.getColumnModel().getColumn(2).setPreferredWidth(80);
		scrollPane_16.setViewportView(tb_param);
		
		ckbx_comp = new JCheckBox("添加平台组件：");
		GridBagConstraints gbc_ckbx_comp = new GridBagConstraints();
		gbc_ckbx_comp.gridwidth = 6;
		gbc_ckbx_comp.anchor = GridBagConstraints.WEST;
		gbc_ckbx_comp.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_comp.gridx = 1;
		gbc_ckbx_comp.gridy = 12;
		comp_panel.add(ckbx_comp, gbc_ckbx_comp);
		
		JButton bt_addComp = new JButton("增加");
		bt_addComp.setEnabled(false);
		bt_addComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				componentDialog componentDialog = new componentDialog();
				componentDialog.setLocationRelativeTo(frame);
				componentDialog.setAlwaysOnTop(true);
				componentDialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_bt_addComp = new GridBagConstraints();
		gbc_bt_addComp.insets = new Insets(0, 0, 5, 5);
		gbc_bt_addComp.gridx = 7;
		gbc_bt_addComp.gridy = 12;
		comp_panel.add(bt_addComp, gbc_bt_addComp);
		
		JButton bt_deleComp = new JButton("删除");
		bt_deleComp.setEnabled(false);
		bt_deleComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_comp.getSelectedRow();//获得选中行的索引
				if(selectedRow!=-1)  //存在选中行
                {
                    componentModel.removeRow(selectedRow);  //删除行
                }	
			}
		});
		GridBagConstraints gbc_bt_deleComp = new GridBagConstraints();
		gbc_bt_deleComp.insets = new Insets(0, 0, 5, 20);
		gbc_bt_deleComp.gridx = 8;
		gbc_bt_deleComp.gridy = 12;
		comp_panel.add(bt_deleComp, gbc_bt_deleComp);
		ckbx_comp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_comp.isSelected()) {
					bt_addComp.setEnabled(true);
					bt_deleComp.setEnabled(true);
				}else {
					bt_addComp.setEnabled(false);
					bt_deleComp.setEnabled(false);
					componentModel.setRowCount(0);
				}	
			}
		});
		
		JScrollPane scrollPane_17 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_17 = new GridBagConstraints();
		gbc_scrollPane_17.gridheight = 3;
		gbc_scrollPane_17.gridwidth = 8;
		gbc_scrollPane_17.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_17.insets = new Insets(0, 0, 5, 20);
		gbc_scrollPane_17.gridx = 1;
		gbc_scrollPane_17.gridy = 13;
		comp_panel.add(scrollPane_17, gbc_scrollPane_17);
		
		tb_comp = new JTable();
		tb_comp.setBackground(new Color(175, 238, 238));
		componentModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"组件中文名称", "组件英文名称"
				}
			);
		tb_comp.setModel(componentModel);
		scrollPane_17.setViewportView(tb_comp);
		
		ckbx_connection = new JCheckBox("添加组件关系：");
		GridBagConstraints gbc_ckbx_connection = new GridBagConstraints();
		gbc_ckbx_connection.gridwidth = 2;
		gbc_ckbx_connection.anchor = GridBagConstraints.WEST;
		gbc_ckbx_connection.insets = new Insets(0, 0, 5, 5);
		gbc_ckbx_connection.gridx = 1;
		gbc_ckbx_connection.gridy = 16;
		comp_panel.add(ckbx_connection, gbc_ckbx_connection);
		
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
		gbc_bt_addConnection.gridx = 7;
		gbc_bt_addConnection.gridy = 16;
		comp_panel.add(bt_addConnection, gbc_bt_addConnection);
		
		JButton bt_deleConnection = new JButton("删除");
		bt_deleConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tb_connection.getSelectedRow();//获得选中行的索引
				if(selectedRow!=-1)  //存在选中行
                {
                    connectionModel.removeRow(selectedRow);  //删除行
                }
			}
		});
		bt_deleConnection.setEnabled(false);
		GridBagConstraints gbc_bt_deleConnection = new GridBagConstraints();
		gbc_bt_deleConnection.anchor = GridBagConstraints.WEST;
		gbc_bt_deleConnection.insets = new Insets(0, 0, 5, 0);
		gbc_bt_deleConnection.gridx = 8;
		gbc_bt_deleConnection.gridy = 16;
		comp_panel.add(bt_deleConnection, gbc_bt_deleConnection);
		ckbx_connection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckbx_connection.isSelected()) {
					bt_addConnection.setEnabled(true);
					bt_deleConnection.setEnabled(true);
				}else {
					bt_addConnection.setEnabled(false);
					bt_deleConnection.setEnabled(false);
					connectionModel.setRowCount(0);
				}	
			}
		});
		
		JScrollPane scrollPane_20 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_20 = new GridBagConstraints();
		gbc_scrollPane_20.gridwidth = 8;
		gbc_scrollPane_20.gridheight = 2;
		gbc_scrollPane_20.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_20.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_20.gridx = 1;
		gbc_scrollPane_20.gridy = 17;
		comp_panel.add(scrollPane_20, gbc_scrollPane_20);
		connectionModel = new DefaultTableModel(new Object[][] {},new String[] {"Source", "Destination"});
		tb_connection = new JTable();
		tb_connection.setBackground(new Color(175, 238, 238));
		tb_connection.setModel(connectionModel);
		scrollPane_20.setViewportView(tb_connection);
		
		JPanel buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		bt_savePage = new JButton("保存编辑");
		bt_savePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savePageIsSelected = true;
				try {
					Temp1_xml.DOMcreate();
					save.setEnabled(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		bt_prePage = new JButton("<<");
		bt_prePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//按钮可用情况
				if (index==1||index==2||index==3||index==4) {
					tp.setSelectedIndex(index-1);
				}
			}
		});
		
		buttonPanel.add(bt_prePage);
		bt_preItem = new JButton("<");
		bt_preItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tP_capa.getSelectedIndex()==1||tP_capa.getSelectedIndex()==2) {
					tP_capa.setSelectedIndex(tP_capa.getSelectedIndex()-1);
				}
			}
		});
		buttonPanel.add(bt_preItem);
		
		pblankLeft = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pblankLeft.getLayout();
		buttonPanel.add(pblankLeft);
		buttonPanel.add(bt_savePage);
		
		bt_clearPage = new JButton("放弃编辑");
		bt_clearPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		buttonPanel.add(bt_clearPage);
		
		pblank = new JPanel();
		buttonPanel.add(pblank);
		
		bt_nextItem = new JButton(">");
		bt_nextItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tP_capa.getSelectedIndex()==0||tP_capa.getSelectedIndex()==1) {
					tP_capa.setSelectedIndex(tP_capa.getSelectedIndex()+1);
				}
			}
		});
		buttonPanel.add(bt_nextItem);
		
		bt_nextPage = new JButton(">>");
		bt_nextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//按钮可用情况
				if (index==0||index==1||index==2||index==3) {
					tp.setSelectedIndex(index+1);	
				}		
			}
		});
		buttonPanel.add(bt_nextPage);
		
		frame.setVisible(true);
	}
	
	//使得控件在屏幕居中
	public void  centerWindow(JComponent component) { 
		Toolkit toolkit = Toolkit.getDefaultToolkit(); 
		Dimension scmSize = toolkit.getScreenSize(); 
		Dimension size = component.getPreferredSize(); 
		int width = component.WIDTH, 
			height   =   component.HEIGHT; 
		component.setLocation(scmSize.width/2 - (width/2), scmSize.height/2 - (height/2)); 
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
			setIconImage(Toolkit.getDefaultToolkit().getImage(Insitu_plat_frame.class.getResource("/sm/images/utils.png")));
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
							interfaceModel.addRow(info);
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
			setIconImage(Toolkit.getDefaultToolkit().getImage(Insitu_plat_frame.class.getResource("/sm/images/utils.png")));
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
							inputModel.addRow(info);
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
			setIconImage(Toolkit.getDefaultToolkit().getImage(Insitu_plat_frame.class.getResource("/sm/images/utils.png")));
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
							outputModel.addRow(info);
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
	
	class parameterDialog extends JDialog{
		private final JPanel contentPanel = new JPanel();
		private JTextField tf_name;
		private JTextField tf_Definition;
		private JTextField tf_Uom;

		/**
		 * Create the dialog.
		 */
		public parameterDialog() {
			setTitle("输入对话框");
			setBounds(100, 100, 450, 300);
			setIconImage(Toolkit.getDefaultToolkit().getImage(Insitu_plat_frame.class.getResource("/sm/images/utils.png")));
			getContentPane().setLayout(new BorderLayout());
			setModal(true);
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			GridBagLayout gbl_contentPanel = new GridBagLayout();
			gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
			gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			contentPanel.setLayout(gbl_contentPanel);
			{
				JLabel lb_Name = new JLabel("参数名称：");
				GridBagConstraints gbc_lb_Name = new GridBagConstraints();
				gbc_lb_Name.anchor = GridBagConstraints.EAST;
				gbc_lb_Name.insets = new Insets(0, 0, 5, 5);
				gbc_lb_Name.gridx = 1;
				gbc_lb_Name.gridy = 1;
				contentPanel.add(lb_Name, gbc_lb_Name);
			}
			{
				tf_name = new JTextField();
				GridBagConstraints gbc_tf_name = new GridBagConstraints();
				gbc_tf_name.gridwidth = 6;
				gbc_tf_name.insets = new Insets(0, 0, 5, 5);
				gbc_tf_name.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_name.gridx = 2;
				gbc_tf_name.gridy = 1;
				contentPanel.add(tf_name, gbc_tf_name);
				tf_name.setColumns(10);
			}
			{
				JLabel lb_Definition = new JLabel("参数定义：");
				GridBagConstraints gbc_lb_Definition = new GridBagConstraints();
				gbc_lb_Definition.anchor = GridBagConstraints.EAST;
				gbc_lb_Definition.insets = new Insets(0, 0, 5, 5);
				gbc_lb_Definition.gridx = 1;
				gbc_lb_Definition.gridy = 2;
				contentPanel.add(lb_Definition, gbc_lb_Definition);
			}
			{
				tf_Definition = new JTextField();
				tf_Definition.setColumns(10);
				GridBagConstraints gbc_tf_Definition = new GridBagConstraints();
				gbc_tf_Definition.gridwidth = 6;
				gbc_tf_Definition.insets = new Insets(0, 0, 5, 5);
				gbc_tf_Definition.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_Definition.gridx = 2;
				gbc_tf_Definition.gridy = 2;
				contentPanel.add(tf_Definition, gbc_tf_Definition);
			}
			{
				JLabel lb_Uom = new JLabel("参数单位：");
				GridBagConstraints gbc_lb_Uom = new GridBagConstraints();
				gbc_lb_Uom.anchor = GridBagConstraints.EAST;
				gbc_lb_Uom.insets = new Insets(0, 0, 5, 5);
				gbc_lb_Uom.gridx = 1;
				gbc_lb_Uom.gridy = 3;
				contentPanel.add(lb_Uom, gbc_lb_Uom);
			}
			{
				tf_Uom = new JTextField();
				tf_Uom.setColumns(10);
				GridBagConstraints gbc_tf_Uom = new GridBagConstraints();
				gbc_tf_Uom.gridwidth = 6;
				gbc_tf_Uom.insets = new Insets(0, 0, 5, 5);
				gbc_tf_Uom.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_Uom.gridx = 2;
				gbc_tf_Uom.gridy = 3;
				contentPanel.add(tf_Uom, gbc_tf_Uom);
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("确认");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String[] info= {tf_name.getText(),"urn:ogc:def:property:OGC:1.0:"+tf_Definition.getText(),tf_Uom.getText()};
							parameterModel.addRow(info);
							tf_name.setText("");
							tf_Definition.setText("");
							tf_Uom.setText("");
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
	
	class componentDialog extends JDialog{
		private final JPanel contentPanel = new JPanel();
		private JTextField tf_name;
		private JTextField tf_Ename;
		
		public componentDialog() {
			setBounds(100, 100, 450, 300);
			setTitle("输入对话框");
			setIconImage(Toolkit.getDefaultToolkit().getImage(Insitu_plat_frame.class.getResource("/sm/images/utils.png")));
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
							componentModel.addRow(info);
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
			setIconImage(Toolkit.getDefaultToolkit().getImage(Insitu_plat_frame.class.getResource("/sm/images/utils.png")));
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
							connectionModel.addRow(info);
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
