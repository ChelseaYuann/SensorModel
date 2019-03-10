package sm.InsituPlat_xml;

import sm.InsituPlat_xml.Insitu_plat_frame;
import sm.main.UploadFrame;
import sm.readExcel.Excel2XML;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;


public class Temp1_xml{
//	private static String savePath = "src/instance/insituSensorPlatform.xml";
//	private static String xmlPath = "src/Resource/InsituSensorPlatform.xml";
	
	private static String savePath = "C:/Users/Chels/Desktop/instance/insituSensorPlatform.xml";
	
	public InputStream parsedoc() {
		InputStream file= this.getClass().getResourceAsStream("/InsituSensorPlatform.xml");
		return file;
	}
	
	public static void DOMcreate(){
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);
        try {
        	DocumentBuilder db = dbf.newDocumentBuilder();
        	Temp1_xml temp1_xml = new Temp1_xml();
        	InputStream file = temp1_xml.parsedoc();
        	
        	Document xmlDoc = db.parse(file);
        	Element sweField = xmlDoc.createElement("swe:field");
        	Element sweQuantity = xmlDoc.createElement("swe:Quantity");
        	Element swevalue = xmlDoc.createElement("swe:value");
        	
        	//获取根节点<sml:physicalSystem>
        	Element root = (Element)xmlDoc.getFirstChild();
        	
        	//Page One
        	//获取description节点
        	NodeList des_list = xmlDoc.getElementsByTagName("gml:description");
        	des_list.item(0).getFirstChild().setNodeValue(Insitu_plat_frame.getDescription());
        	System.out.println(des_list.item(0).getNodeName());
        	
        	//获取关键词keywords节点
//        	NodeList kwords = xmlDoc.getElementsByTagName("sml:keywords");
//        	Element smlkeywords = (Element) kwords.item(0);
        	NodeList kwordList = xmlDoc.getElementsByTagName("sml:KeywordList");
        	NodeList keyword = xmlDoc.getElementsByTagName("sml:keyword");
        	Element keywordList = (Element) kwordList.item(0);
        	String[] keywords = Insitu_plat_frame.getKeyword();
        	int keywordCount = keywords.length;
        	System.out.println("共有关键词个数："+keywordCount);
        	if (keywordCount<4||keywordCount==4) {
				for(int i=0;i<keywordCount;i++) {
					keyword.item(i).getFirstChild().setNodeValue(keywords[i]);
				}
				for(int i=keywordCount;i<4;i++) {
					keyword.item(i).getFirstChild().setNodeValue("");
				}
			}
        	else if (keywordCount>4) {
        		for(int i=0;i<4;i++) {
					keyword.item(i).getFirstChild().setNodeValue(keywords[i]);
				}
        		for (int j = 4; j < keywordCount; j++) {
					Element k = xmlDoc.createElement("sml:keyword");
					keywordList.appendChild(k);
					k.setTextContent(keywords[j]);
				}
			}	     
        	
        	//获取标识符identification
        	Element identifierList = (Element) xmlDoc.getElementsByTagName("sml:IdentifierList").item(0);
        	System.out.println(identifierList.getNodeName());
        	NodeList identifiers = xmlDoc.getElementsByTagName("sml:identifier");
        	int row_sensors = Insitu_plat_frame.getTableRow();
        	System.out.println(">>>>共搭载"+row_sensors+"个传感器");
        	for (int i = 0; i < identifiers.getLength(); i++) {
        		Element identifier = (Element) identifiers.item(i);
				Element term = (Element) identifier.getElementsByTagName("sml:Term").item(0);
				Element label = (Element) term.getElementsByTagName("sml:label").item(0);
				Element value = (Element) term.getElementsByTagName("sml:value").item(0);
				String labelContent = label.getFirstChild().getNodeValue();
				if (labelContent.equals("唯一标识码")) {
					value.getFirstChild().setNodeValue(Insitu_plat_frame.getUniqueID());
				}else if (labelContent.equals("全称")) {
					value.getFirstChild().setNodeValue(Insitu_plat_frame.getLongname());
				}else if (labelContent.equals("简称")) {
					value.getFirstChild().setNodeValue(Insitu_plat_frame.getShortname());
				}
				else if (labelContent.equals("搭载传感器名称")&&row_sensors>0) {
					value.getFirstChild().setNodeValue(Insitu_plat_frame.getAssociatedSensorInfo(0, 0));
				}else if (labelContent.equals("搭载传感器标识符")&&row_sensors>0) {
					value.getFirstChild().setNodeValue(Insitu_plat_frame.getAssociatedSensorInfo(0, 1));
				}
			}
        	if (row_sensors>1) {
				for (int i = 1; i < row_sensors; i++) {
					Element identifier = xmlDoc.createElement("sml:identifier");
					Element term = xmlDoc.createElement("sml:Term");
					Element label = xmlDoc.createElement("sml:label");
					Element value = xmlDoc.createElement("sml:value");
					String name = Insitu_plat_frame.getAssociatedSensorInfo(i, 0);
					String Id = Insitu_plat_frame.getAssociatedSensorInfo(i, 1);
					System.out.println(">>>>>搭载传感器信息（sensors>1时）----"+name+"---"+Id);
					term.setAttribute("definition", "urn:ogc:def:identifier:OGC:1.0:associatedSensorName");
					label.setTextContent("搭载传感器名称");
					value.setTextContent(name);
					term.appendChild(label);
					term.appendChild(value);
					identifier.appendChild(term);
					identifierList.appendChild(identifier);
					
					Element identifier2 = xmlDoc.createElement("sml:identifier");
					Element term2 = xmlDoc.createElement("sml:Term");
					Element label2 = xmlDoc.createElement("sml:label");
					Element value2 = xmlDoc.createElement("sml:value");
					term2.setAttribute("definition", "urn:ogc:def:identifier:OGC:1.0:associatedSensorUniqueID");
					label2.setTextContent("搭载传感器标识符");
					value2.setTextContent(Id);
					term2.appendChild(label2);
					term2.appendChild(value2);
					identifier2.appendChild(term2);
					identifierList.appendChild(identifier2);
				}
			}
        	if (Insitu_plat_frame.getCheckOtherID()&&Insitu_plat_frame.getOtherIdRow()>0) {
				for(int i=0;i<Insitu_plat_frame.getOtherIdRow();i++) {
					Element identifier = xmlDoc.createElement("sml:identifier");
					Element term = xmlDoc.createElement("sml:Term");
					Element label = xmlDoc.createElement("sml:label");
					Element value = xmlDoc.createElement("xml:value");
					term.setAttribute("definition", "urn:ogc:def:identifier:OGC:1.0:otherIdentifier");
					label.setTextContent(Insitu_plat_frame.getOtherIdentifierInfo(i, 0));
					value.setTextContent(Insitu_plat_frame.getOtherIdentifierInfo(i, 1));
					term.appendChild(label);
					term.appendChild(value);
					identifier.appendChild(term);
					identifierList.appendChild(identifier);
				}
			}
        	
        	//获取分类符classification
//        	Element classification = (Element) xmlDoc.getElementsByTagName("sml:classification").item(0);
        	Element classifierList = (Element) xmlDoc.getElementsByTagName("sml:ClassifierList").item(0);
        	NodeList classifiers = xmlDoc.getElementsByTagName("sml:classifier");
        	String[] intendedApp = Insitu_plat_frame.getIntendedApplication();
        	for (int i = 0; i < classifiers.getLength(); i++) {
    		Element classifier = (Element) classifiers.item(i);
			Element term = (Element) classifier.getElementsByTagName("sml:Term").item(0);
			Element label = (Element) term.getElementsByTagName("sml:label").item(0);
			Element value = (Element) term.getElementsByTagName("sml:value").item(0);
			String labelContent = label.getFirstChild().getNodeValue();
			if (labelContent.equals("站点类型")) {
				value.getFirstChild().setNodeValue(Insitu_plat_frame.getSiteType());
				}else if (labelContent.equals("传感器类型")) {
					value.getFirstChild().setNodeValue(Insitu_plat_frame.getSensorType());
				}else if (labelContent.equals("站点等级")) {
					value.getFirstChild().setNodeValue(Insitu_plat_frame.getStationLevel());
				}else if (labelContent.equals("共享等级")) {
					value.getFirstChild().setNodeValue(Insitu_plat_frame.getSharingLevel());
				}else if (labelContent.equals("预期应用")) {
					value.getFirstChild().setNodeValue(intendedApp[0]);
				}
				System.out.println(classifier.getNodeName()+label.getFirstChild().getNodeValue()+"="+value.getFirstChild().getNodeValue());
			}
        	if (intendedApp.length>1) {
        		for (int j = 1; j < intendedApp.length; j++) {
    			Element classifier = xmlDoc.createElement("sml:classifier");
				Element term = xmlDoc.createElement("sml:Term");
				Element label = xmlDoc.createElement("sml:label");
				Element value = xmlDoc.createElement("sml:value");
				term.setAttribute("definition", "urn:ogc:def:classifier:OGC:1.0:intendedApplication");
				label.setTextContent("预期应用");
				value.setTextContent(intendedApp[j]);
				term.appendChild(label);
				term.appendChild(value);
				classifier.appendChild(term);
				classifierList.appendChild(classifier);
				}
			}
        	if (Insitu_plat_frame.getCheckOtherClassifier()&&Insitu_plat_frame.getOtherClassifierRow()>0) {
        		for (int j = 0; j < Insitu_plat_frame.getOtherClassifierRow(); j++) {
    				Element classifier = xmlDoc.createElement("sml:classifier");
    				Element term = xmlDoc.createElement("sml:Term");
    				Element label = xmlDoc.createElement("sml:label");
    				Element value = xmlDoc.createElement("sml:value");
    				term.setAttribute("definition", "urn:ogc:def:classifier:OGC:1.0:otherClassifier");
    				label.setTextContent(Insitu_plat_frame.getOtherClassifier(j, 0)); 
    				value.setTextContent(Insitu_plat_frame.getOtherClassifier(j, 1));
    				term.appendChild(label);
    				term.appendChild(value);
    				classifier.appendChild(term);
    				classifierList.appendChild(classifier);
				}
			}
        	
        	//Page Two
        	//获得约束条件（有效时间；法律约束；安全约束）
        	//有效时间
        	Element validTM = (Element) xmlDoc.getElementsByTagName("sml:validTime").item(0);
        	Element TMPeriod = (Element) validTM.getElementsByTagName("gml:TimePeriod").item(0);
        	Element beginTM = (Element) TMPeriod.getElementsByTagName("gml:beginPosition").item(0);
        	Element endTM = (Element) TMPeriod.getElementsByTagName("gml:endPosition").item(0);
        	if (Insitu_plat_frame.getBeginTMChoice().equals("确定时间点")&&!Insitu_plat_frame.getBeginTM().equals("")) {
				beginTM.getFirstChild().setNodeValue(Insitu_plat_frame.getBeginTM());
			}else if(Insitu_plat_frame.getBeginTMChoice().equals("不定时间点")){
				TMPeriod.removeChild(beginTM);
				Element unknown = xmlDoc.createElement("gml:beginPosition");
        		unknown.setAttribute("indeterminatePosition", "unknown");
        		TMPeriod.appendChild(unknown);
			}
        	if (Insitu_plat_frame.getEndTMChoice().equals("确定时间点")&&!Insitu_plat_frame.getEndTM().equals("")) {
				endTM.getFirstChild().setNodeValue(Insitu_plat_frame.getEndTM());
			}else if(Insitu_plat_frame.getEndTMChoice().equals("不定时间点")){
				TMPeriod.removeChild(endTM);
				Element unknown = xmlDoc.createElement("gml:endPosition");
        		unknown.setAttribute("indeterminatePosition", "unknown");
        		TMPeriod.appendChild(unknown);
			}
        	//安全约束
        	Element securityConstraint = (Element) xmlDoc.getElementsByTagName("sml:securityConstraints").item(0);
        	Element securityNoticeText = (Element) xmlDoc.getElementsByTagName("ism:NoticeText").item(0);
        	if (Insitu_plat_frame.getSecurityConstraint().equals("")) {
				root.removeChild(securityConstraint);
			}else {
				securityNoticeText.getFirstChild().setNodeValue(Insitu_plat_frame.getSecurityConstraint());
			}
        	//法律约束
        	Element legalConstraint = (Element) xmlDoc.getElementsByTagName("sml:legalConstraints").item(0);
        	Element legalLimitation = (Element) xmlDoc.getElementsByTagName("gco:CharacterString").item(0);
        	if (Insitu_plat_frame.getLegalConstraint().equals("")) {
				root.removeChild(legalConstraint);
			}else {
				legalLimitation.getFirstChild().setNodeValue(Insitu_plat_frame.getLegalConstraint());
			}
        	
        	//Page Three
        	//获取站点特征characteristics
        	Element characteristics = (Element) xmlDoc.getElementsByTagName("sml:characteristics").item(0);
        	Element characteristicList = (Element) xmlDoc.getElementsByTagName("sml:CharacteristicList").item(0);
        	NodeList characteristic = xmlDoc.getElementsByTagName("sml:characteristic");
        	Element chara1 = (Element) characteristic.item(0);
        	Element chara2 = (Element) characteristic.item(1);
        	Element chara3 = (Element) characteristic.item(2);
        	if (Insitu_plat_frame.getPhyscWeight().equals("")&&Insitu_plat_frame.getPhyscHeight().equals("")&&Insitu_plat_frame.getPhyscWidth().equals("")
        			&&Insitu_plat_frame.getPhyscLength().equals("")&&!Insitu_plat_frame.checkPower()&&!Insitu_plat_frame.checkOutPower()
        			&&!Insitu_plat_frame.checkCurrentType()&&!Insitu_plat_frame.checkCurrent()&&!Insitu_plat_frame.checkVoltage()
        			&&!Insitu_plat_frame.checkStorage()&&!Insitu_plat_frame.checkTransMode()&&!Insitu_plat_frame.checkTSJG()
        			&&!Insitu_plat_frame.checkTXFS()&&!Insitu_plat_frame.checkLife()&&!Insitu_plat_frame.checkHumidity()
        			&&!Insitu_plat_frame.checkTemprature()&&!Insitu_plat_frame.checkProtectionGrade()&&!Insitu_plat_frame.checkMTBF()
        			&&!Insitu_plat_frame.checkIsOperab()) {
        		root.removeChild(characteristics);
			}
         	if (Insitu_plat_frame.getPhyscWeight().equals("")&&Insitu_plat_frame.getPhyscHeight().equals("")&&Insitu_plat_frame.getPhyscWidth().equals("")&&Insitu_plat_frame.getPhyscLength().equals("")) {
				characteristicList.removeChild(chara1);
			}
        	//物理特征
        	Element field1 = (Element) chara1.getElementsByTagName("swe:field").item(0);
        	Element dataRecord1 = (Element) field1.getElementsByTagName("swe:DataRecord").item(0);
        	NodeList fields1 = field1.getElementsByTagName("swe:field");
        	System.out.println("共"+fields1.getLength()+"个物理特征属性");
        	for (int i = 0; i < fields1.getLength(); i++) {
        		Element field = (Element) fields1.item(i);
        		Element value = (Element) field.getElementsByTagName("swe:value").item(0);
				String name = field.getAttribute("name");
				if (name.equals("长度")) {
					if (!Insitu_plat_frame.getPhyscLength().equals("")) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getPhyscLength());
					}else {
						dataRecord1.removeChild(field);
					}
				}
				else if(name.equals("宽度")) {
					if (!Insitu_plat_frame.getPhyscWidth().equals("")) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getPhyscWidth());
					}else {
						dataRecord1.removeChild(field);
					}
				}
				else if(name.equals("高度")) {
					if (!Insitu_plat_frame.getPhyscHeight().equals("")) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getPhyscHeight());
					}else {
						dataRecord1.removeChild(field);
					}
				}
				else if(name.equals("重量")) {
					if (!Insitu_plat_frame.getPhyscWeight().equals("")) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getPhyscWeight());
					}else {
						dataRecord1.removeChild(field);
					}
				}
				System.out.println("物理特征："+name+">>>"+value.getFirstChild().getNodeValue());
			}
        	//供电通信特征
        	if (!Insitu_plat_frame.checkPower()&&!Insitu_plat_frame.checkOutPower()&&!Insitu_plat_frame.checkCurrentType()
        			&&!Insitu_plat_frame.checkCurrent()&&!Insitu_plat_frame.checkVoltage()&&!Insitu_plat_frame.checkStorage()
        			&&!Insitu_plat_frame.checkTransMode()&&!Insitu_plat_frame.checkTSJG()&&!Insitu_plat_frame.checkTXFS()) {
				characteristicList.removeChild(chara2);
			}
        	Element dataRecord2 = (Element) chara2.getElementsByTagName("swe:DataRecord").item(0);
        	NodeList fields2 = chara2.getElementsByTagName("swe:field");
        	for (int i = 0; i < fields2.getLength(); i++) {
        		Element field = (Element) fields2.item(i);
        		Element value = (Element) field.getElementsByTagName("swe:value").item(0);
				String name = field.getAttribute("name");
				if (name.equals("电源类型")) {
					if (Insitu_plat_frame.checkCurrentType()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getCurrentType());
					}else {
						dataRecord2.removeChild(field);
					}
				}
				else if (name.equals("电流")) {
					if (Insitu_plat_frame.checkCurrent()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getCurrentLow()+" "+Insitu_plat_frame.getCurrentUp());
					}else {
						dataRecord2.removeChild(field);
					}
				}
				else if (name.equals("电压")) {
					if (Insitu_plat_frame.checkVoltage()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getVoltageLow()+" "+Insitu_plat_frame.getVoltageUp());
					}else {
						dataRecord2.removeChild(field);
					}
				}
				else if (name.equals("功率")) {
					if (Insitu_plat_frame.checkPower()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getPower());
					}else {
						dataRecord2.removeChild(field);
					}
				}
				else if (name.equals("输出功率")) {
					if (Insitu_plat_frame.checkOutPower()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getOutPower());
					}else {
						dataRecord2.removeChild(field);
					}
				}
				else if (name.equals("存储容量")) {
					if (Insitu_plat_frame.checkStorage()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getStorage());
					}else {
						dataRecord2.removeChild(field);
					}
				}
				else if (name.equals("数传方式")) {
					if (Insitu_plat_frame.checkTransMode()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getTransMode());
					}else {
						dataRecord2.removeChild(field);
					}
				}
				else if (name.equals("传输间隔")) {
					if (Insitu_plat_frame.checkTSJG()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getTSJG());
					}else {
						dataRecord2.removeChild(field);
					}
				}
				else if (name.equals("通信方式")) {
					if (Insitu_plat_frame.checkTXFS()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getTXFS());
					}else {
						dataRecord2.removeChild(field);
					}
				}
				System.out.println("供电特征："+name+">>>"+value.getFirstChild().getNodeValue());
			}
        	//工作环境特征
        	if (!Insitu_plat_frame.checkLife()&&!Insitu_plat_frame.checkHumidity()&&!Insitu_plat_frame.checkTemprature()
        			&&!Insitu_plat_frame.checkProtectionGrade()&&!Insitu_plat_frame.checkMTBF()&&!Insitu_plat_frame.checkIsOperab()) {
				characteristicList.removeChild(chara3);
			}
        	Element dataRecord3 = (Element) chara3.getElementsByTagName("swe:DataRecord").item(0);
        	NodeList fields3 = dataRecord3.getElementsByTagName("swe:field");
        	for (int i = 0; i < fields3.getLength(); i++) {
				Element field = (Element) fields3.item(i);
				Element value = (Element) field.getElementsByTagName("swe:value").item(0);
				String name = field.getAttribute("name");
				if (name.equals("设计寿命")) {
					if (Insitu_plat_frame.checkLife()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getLife());
					}else {
						dataRecord3.removeChild(field);
					}	
				}
				else if (name.equals("工作湿度范围")) {
					if (Insitu_plat_frame.checkHumidity()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getHumidityMin()+" "+Insitu_plat_frame.getHumidityMax());
					}else {
						dataRecord3.removeChild(field);
					}
				}
				else if (name.equals("工作温度范围")) {
					if (Insitu_plat_frame.checkTemprature()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getTempratureMin()+" "+Insitu_plat_frame.getTempratureMax());
					}else {
						dataRecord3.removeChild(field);
					}
				}
				else if (name.equals("防护等级")) {
					if (Insitu_plat_frame.checkProtectionGrade()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getProtectionGrade());
					}else {
						dataRecord3.removeChild(field);
					}
				}
				else if (name.equals("无故障时间")) {
					if (Insitu_plat_frame.checkMTBF()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getMTBF());
					}else {
						dataRecord3.removeChild(field);
					}
				}
				else if (name.equals("是否可控")) {
					if (Insitu_plat_frame.checkIsOperab()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getIsOperable());
					}else {
						dataRecord3.removeChild(field);
					}
				}
				System.out.println("环境特征："+name+">>>"+value.getFirstChild().getNodeValue());
			}
        	//其他特征
        	if (Insitu_plat_frame.checkOtherCharacter()) {
        		Element chara = xmlDoc.createElement("sml:characteristic");
				Element dataRcd = xmlDoc.createElement("swe:DataRecord");
				int num = Insitu_plat_frame.getOtherCharacterRow();
				for (int i = 0; i < num; i++) {
					sweField.setAttribute("name", Insitu_plat_frame.getOtherCharacterInfo(i, 0));
					sweQuantity.setAttribute("definition", "urn:ogc:def:property:OGC:1.0:otherCharacteristic");
					swevalue.setTextContent(Insitu_plat_frame.getOtherCharacterInfo(i, 1));
					sweQuantity.appendChild(swevalue);
					sweField.appendChild(sweQuantity);
					dataRcd.appendChild(sweField);
				}
				chara.appendChild(dataRcd);
				characteristicList.appendChild(chara);
			}
        	
        	//获取站点观测能力Capabilities
        	Element Capabilities = (Element) xmlDoc.getElementsByTagName("sml:capabilities").item(0);
        	Element CapabilityList = (Element) xmlDoc.getElementsByTagName("sml:CapabilityList").item(0);
        	NodeList Capability = xmlDoc.getElementsByTagName("sml:capability");
        	Element Capability1 = (Element) Capability.item(0);
        	Element Capability2 = (Element) Capability.item(1);
        	Element Capability3 = (Element) Capability.item(2);
        	Element Capability4 = (Element) Capability.item(3);
        	Element Capability5 = (Element) Capability.item(4);
        	//观测能力广度
        	Element dataRcd1 = (Element) Capability1.getElementsByTagName("swe:DataRecord").item(0);
        	NodeList CapFields1 = dataRcd1.getElementsByTagName("swe:field");
        	for (int i = 0; i < CapFields1.getLength(); i++) {
				Element field = (Element) CapFields1.item(i);
				String name = field.getAttribute("name");
				Element value = (Element) field.getElementsByTagName("swe:value").item(0);
				if (name.equals("原位探测类型")) {
					value.getFirstChild().setNodeValue(Insitu_plat_frame.getInsituType());
				}
				else if (name.equals("探测原理")) {
					if (Insitu_plat_frame.checkDetectionPrinciple()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getDetectionPrinciple());
					}else {
						dataRcd1.removeChild(field);
					}
				}
				else if (name.equals("极限过载")) {
					if (Insitu_plat_frame.checkOverloadLimitation()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getOverloadMin()+" "+Insitu_plat_frame.getOverloadMax());
					}else {
						dataRcd1.removeChild(field);
					}
				}
				else if (name.equals("量程范围")) {
					if (Insitu_plat_frame.checkMeasurementRange()) {
						value.getFirstChild().setNodeValue(Insitu_plat_frame.getMeasurRangeMin()+" "+Insitu_plat_frame.getOverloadMax());
					}else {
						dataRcd1.removeChild(field);
					}
				}
				else if (name.equals("观测包围盒")) {
					Element v2 = (Element) field.getElementsByTagName("swe:value").item(1);
					Element v3 = (Element) field.getElementsByTagName("swe:value").item(2);
					Element v4 = (Element) field.getElementsByTagName("swe:value").item(3);
					value.getFirstChild().setNodeValue(Insitu_plat_frame.getlWD());
					v2.getFirstChild().setNodeValue(Insitu_plat_frame.getlJD());
					v3.getFirstChild().setNodeValue(Insitu_plat_frame.getuWD());
					v4.getFirstChild().setNodeValue(Insitu_plat_frame.getuJD());	
				}
				System.out.println("观测广度："+name+">>>");
			}	
        	//观测能力深度	
        	if (!Insitu_plat_frame.checkObservationResolution()&&!Insitu_plat_frame.checkObservationRadius()&&!Insitu_plat_frame.checksensitivity()) {
				CapabilityList.removeChild(Capability2);
			}else {
				Element dataRcd2 = (Element) Capability2.getElementsByTagName("swe:DataRecord").item(0);
	        	NodeList CapFields2 = dataRcd2.getElementsByTagName("swe:field");
	        	for (int i = 0; i < CapFields2.getLength(); i++) {
	        		Element field = (Element) CapFields2.item(i);
					String name = field.getAttribute("name");
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					if (name.equals("观测分辨率")) {
						if (Insitu_plat_frame.checkObservationResolution()) {
							value.getFirstChild().setNodeValue(Insitu_plat_frame.getObserveResolution());
						}else {
							dataRcd2.removeChild(field);
						}
					}
					else if (name.equals("观测半径")) {
						if (Insitu_plat_frame.checkObservationRadius()) {
							value.getFirstChild().setNodeValue(Insitu_plat_frame.getObserveRadius());
						}else {
							dataRcd2.removeChild(field);
						}
					}
					else {
						if (Insitu_plat_frame.checksensitivity()) {
							value.getFirstChild().setNodeValue(Insitu_plat_frame.getSensitivity());
						}else {
							dataRcd2.removeChild(field);
						}
					}
					System.out.println("观测深度："+name+">>>"+value.getFirstChild().getNodeValue());
				}
			}
        	//观测能力频度
        	if (!Insitu_plat_frame.checkRespondTime()&&!Insitu_plat_frame.checkInterval()&&!Insitu_plat_frame.checkDuration()) {
				CapabilityList.removeChild(Capability3);
			}else {
				Element dataRcd3 = (Element) Capability3.getElementsByTagName("swe:DataRecord").item(0);
	        	NodeList CapFields3 = dataRcd3.getElementsByTagName("swe:field");
	        	for (int i = 0; i < CapFields3.getLength(); i++) {
	        		Element field = (Element) CapFields3.item(i);
					String name = field.getAttribute("name");
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					if (name.equals("采样周期")) {
						if (Insitu_plat_frame.checkInterval()) {
							value.getFirstChild().setNodeValue(Insitu_plat_frame.getInterval());
						}else {
							dataRcd3.removeChild(field);
						}
					}else if (name.equals("采样持续时间")) {
						if (Insitu_plat_frame.checkDuration()) {
							value.getFirstChild().setNodeValue(Insitu_plat_frame.getInterval());
						}else {
							dataRcd3.removeChild(field);
						}
					}else {
						if (Insitu_plat_frame.checkRespondTime()) {
							value.getFirstChild().setNodeValue(Insitu_plat_frame.getRespondTime());
						}else {
							dataRcd3.removeChild(field);
						}
					}
					System.out.println("观测频度："+name+">>>"+value.getFirstChild().getNodeValue());
				}
			}
        	//观测能力质量
        	if (!Insitu_plat_frame.checkSensitivityTolerance()&&!Insitu_plat_frame.checkDetectionAccuracy()
        			&&!Insitu_plat_frame.checkRepeatability()&&!Insitu_plat_frame.checkLagTolerance()
        			&&!Insitu_plat_frame.checkNonlinearityError()) {
        		CapabilityList.removeChild(Capability4);
			}else {
				Element dataRcd4 = (Element) Capability4.getElementsByTagName("swe:DataRecord").item(0);
	        	NodeList CapFields4 = dataRcd4.getElementsByTagName("swe:field");
	        	for (int i = 0; i < CapFields4.getLength(); i++) {
	        		Element field = (Element) CapFields4.item(i);
					String name = field.getAttribute("name");
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					if (name.equals("灵敏度允差")) {
						if (Insitu_plat_frame.checkSensitivityTolerance()) {
							value.getFirstChild().setNodeValue(Insitu_plat_frame.getSensitivityTolerence());
						}else {
							dataRcd4.removeChild(field);
						}
					}
					else if (name.equals("探测精度")) {
						if (Insitu_plat_frame.checkDetectionAccuracy()) {
							value.getFirstChild().setNodeValue(Insitu_plat_frame.getDetectionAccuracy());
						}else {
							dataRcd4.removeChild(field);
						}
					}
					else if (name.equals("重复性误差")) {
						if (Insitu_plat_frame.checkRepeatability()) {
							value.getFirstChild().setNodeValue(Insitu_plat_frame.getRepeatability());
						}else {
							dataRcd4.removeChild(field);
						}
					}
					else if (name.equals("滞后允差")) {
						if (Insitu_plat_frame.checkLagTolerance()) {
							value.getFirstChild().setNodeValue(Insitu_plat_frame.getLagTolerance());
						}else {
							dataRcd4.removeChild(field);
						}
					}
					else {
						if (Insitu_plat_frame.checkNonlinearityError()) {
							value.getFirstChild().setNodeValue(Insitu_plat_frame.getNonlinearError());
						}else {
							dataRcd4.removeChild(field);
						}
					}
					System.out.println("观测质量："+name+">>>"+value.getFirstChild().getNodeValue());
				}
			}
        	//观测能力数据
        	if (!Insitu_plat_frame.checkDataAccessLevel()&&!Insitu_plat_frame.checkDataFormat()&&!Insitu_plat_frame.checkDataQualityLevel()) {
        		CapabilityList.removeChild(Capability5);
        	}else {
            	Element dataRcd5 = (Element) Capability5.getElementsByTagName("swe:DataRecord").item(0);
            	NodeList CapFields5 = dataRcd5.getElementsByTagName("swe:field");
            	for (int i = 0; i < CapFields5.getLength(); i++) {
            		Element field = (Element) CapFields5.item(i);
					String name = field.getAttribute("name");
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					if (name.equals("数据获取等级")) {
						if (Insitu_plat_frame.checkDataAccessLevel()) {
							value.getFirstChild().setNodeValue(Insitu_plat_frame.getDataAccessLevel());
						}else {
							dataRcd5.removeChild(field);
						}
					}
					else if (name.equals("数据格式")) {
						if (Insitu_plat_frame.checkDataFormat()) {
							value.getFirstChild().setNodeValue(Insitu_plat_frame.getDataFormat());
						}else {
							dataRcd5.removeChild(field);
						}
					}
					else {
						if (Insitu_plat_frame.checkDataQualityLevel()) {
							value.getFirstChild().setNodeValue(Insitu_plat_frame.getDataQuantityLevel());
						}else {
							dataRcd5.removeChild(field);
						}
					}
					System.out.println("观测数据："+name+">>>"+value.getFirstChild().getNodeValue());
				}
			}
        	//其他观测能力
        	if (Insitu_plat_frame.checkOtherCapability()) {
				Element cap = xmlDoc.createElement("sml:capability");
				Element dataRcd = xmlDoc.createElement("swe:DataRecord");
				int num = Insitu_plat_frame.getOtherCapabilityRow();
				for (int i = 0; i < num; i++) {
					sweField.setAttribute("name", Insitu_plat_frame.getOtherCapability(i, 0));
					sweQuantity.setAttribute("definition", "urn:ogc:def:property:OGC:1.0:otherCapability");
					swevalue.setTextContent(Insitu_plat_frame.getOtherCapability(i, 1));
					sweQuantity.appendChild(swevalue);
					sweField.appendChild(sweQuantity);
					dataRcd.appendChild(sweField);
				}
				cap.appendChild(dataRcd);
				CapabilityList.appendChild(cap);
			}
        	
        	//获取站点位置
        	NodeList position = xmlDoc.getElementsByTagName("sml:position");
        	Element textPosition = (Element) position.item(0);
        	Element pointPosition = (Element) position.item(1);
        	Element vectorPosotion = (Element) position.item(2);
        	int choice = Insitu_plat_frame.checkPositionChoice();
        	switch (choice) {
			case 0:
				root.removeChild(textPosition);
				root.removeChild(pointPosition);
				root.removeChild(vectorPosotion); break;
			case 1:
				root.removeChild(pointPosition);
				root.removeChild(vectorPosotion);
				Element positionText = (Element) textPosition.getElementsByTagName("swe:value").item(0);
				positionText.getFirstChild().setNodeValue(Insitu_plat_frame.getTextPosition());break;
			case 2:
				root.removeChild(textPosition);
				root.removeChild(vectorPosotion); 
				Element coordinates = (Element) pointPosition.getElementsByTagName("gml:coordinates").item(0);
				pointPosition.setAttribute("srsName", Insitu_plat_frame.getPointSRS());
				coordinates.getFirstChild().setNodeValue(Insitu_plat_frame.getPointY()+" "+Insitu_plat_frame.getPointX());
				break;
			case 3:
				root.removeChild(textPosition);
				root.removeChild(pointPosition);
				NodeList locationValue = vectorPosotion.getElementsByTagName("swe:value");
				vectorPosotion.setAttribute("referenceFrame", Insitu_plat_frame.getLocSRS());
				locationValue.item(0).getFirstChild().setNodeValue(Insitu_plat_frame.getLocLat());
				locationValue.item(1).getFirstChild().setNodeValue(Insitu_plat_frame.getLocLon());
				locationValue.item(2).getFirstChild().setNodeValue(Insitu_plat_frame.getLocAlt());
				break;
			default:
				break;
			}
        	
        	//获取负责单位contact
        	Element contacts = (Element) xmlDoc.getElementsByTagName("sml:contacts").item(0);
        	Element contactList = (Element) contacts.getElementsByTagName("sml:ContactList").item(0);
        	Element contact = (Element) contactList.getElementsByTagName("sml:contact").item(0);
        	int contactNum = Insitu_plat_frame.getContactRow();
        	String role = "";
        	if (contactNum == 1) {
        		if (Insitu_plat_frame.getContactInfo(0, 0).equals("制造商")) {
					role = "manufacturer";
				}else if (Insitu_plat_frame.getContactInfo(0, 0).equals("管理者")) {
					role = "management";
				}else if (Insitu_plat_frame.getContactInfo(0, 0).equals("使用者")) {
					role = "user";
				}
        		contact.setAttribute("xlink:arcrole", "urn:ogc:def:role:OGC:1.0:"+role);
				NodeList Name = contact.getElementsByTagName("gco:CharacterString");
				Name.item(0).getFirstChild().setNodeValue(Insitu_plat_frame.getContactInfo(0, 1));
				Name.item(1).getFirstChild().setNodeValue(Insitu_plat_frame.getPerson());
				Element voice = (Element) contact.getElementsByTagName("gmd:voice").item(0);
				Element deliveryPoint = (Element) contact.getElementsByTagName("gmd:deliveryPoint").item(0);
				Element city = (Element) contact.getElementsByTagName("gmd:city").item(0);
				Element administrativeArea = (Element) contact.getElementsByTagName("gmd:administrativeArea").item(0);
				Element country = (Element) contact.getElementsByTagName("gmd:country").item(0);
				Element email = (Element) contact.getElementsByTagName("gmd:electronicMailAddress").item(0);
				Element code = (Element) contact.getElementsByTagName("gmd:postalCode").item(0);
				voice.getFirstChild().setNodeValue(Insitu_plat_frame.getTelephone());
				deliveryPoint.getFirstChild().setNodeValue(Insitu_plat_frame.getAddress());
				city.getFirstChild().setNodeValue(Insitu_plat_frame.getCity());
				administrativeArea.getFirstChild().setNodeValue(Insitu_plat_frame.getCountry());
				country.getFirstChild().setNodeValue(Insitu_plat_frame.getCountry());
				email.getFirstChild().setNodeValue(Insitu_plat_frame.getEMail());
				code.getFirstChild().setNodeValue(Insitu_plat_frame.getCode());
			}
        	//多个负责单位的情况
//        	else if (contactNum>1) {
//				
//			}
        	
        	
        	//获取附件信息 document
        	
        	
        	
        	//获取服务历史History
        	Element history = (Element) xmlDoc.getElementsByTagName("sml:history").item(0);
        	Element eventList = (Element) xmlDoc.getElementsByTagName("sml:EventList").item(0);
        	Element event = (Element) eventList.getElementsByTagName("sml:event").item(0);
        	if (!Insitu_plat_frame.checkEventID()&&!Insitu_plat_frame.checkEventDescription()&&Insitu_plat_frame.checkETimeChoice()==0) {
				root.removeChild(history);
			}else {
				Element eventLabel = (Element) event.getElementsByTagName("swe:label").item(0);
				Element eventDescription = (Element) event.getElementsByTagName("swe:description").item(0);
				Element time = (Element) event.getElementsByTagName("sml:time").item(0);
				Element timePeriod = (Element) time.getElementsByTagName("gml:TimePeriod").item(0);
				//判断事件编号标签复选框
				if (Insitu_plat_frame.checkEventID()) {
					eventLabel.getFirstChild().setNodeValue(Insitu_plat_frame.getEventID());
				}else {
					event.removeChild(eventLabel);
				}
				//判断事件描述复选框
				if (Insitu_plat_frame.checkEventDescription()) {
					eventDescription.getFirstChild().setNodeValue(Insitu_plat_frame.getEventDescription());
				}else {
					event.removeChild(eventDescription);
				}
				//判断事件时间选择
				if (Insitu_plat_frame.checkETimeChoice()==1) {
					timePeriod.setAttribute("gml:id", Insitu_plat_frame.getEventID());
					Element eventGeginTM = (Element) timePeriod.getElementsByTagName("gml:beginPosition").item(0);
					Element eventEndTM = (Element) timePeriod.getElementsByTagName("gml:endPosition").item(0);
					eventGeginTM.getFirstChild().setNodeValue(Insitu_plat_frame.getEBeginTM());
					eventEndTM.getFirstChild().setNodeValue(Insitu_plat_frame.getEEndTM());
				}else if (Insitu_plat_frame.checkETimeChoice()==2) {
					time.removeChild(timePeriod);
					Element timeInstant = xmlDoc.createElement("gml:TimeInstant");
					Element timePosition = xmlDoc.createElement("gml:timePosition");
					timeInstant.setAttribute("gml:id", Insitu_plat_frame.getEventID());
					timePosition.setTextContent(Insitu_plat_frame.getEventInstance());
					timeInstant.appendChild(timePosition);
					time.appendChild(timeInstant);
				}else {
					event.removeChild(time);
				}
			}
        	
        	//外部文档
        	Element documentation = (Element) xmlDoc.getElementsByTagName("sml:documentation").item(0);
        	if (UploadFrame.getIsDone()==true) {
        		Element documentList = (Element) documentation.getElementsByTagName("sml:DocumentList").item(0);
            	Element document = (Element) documentList.getElementsByTagName("sml:document").item(0);
            	String[] photoInfo = UploadFrame.getPhotoInfo();
            	ArrayList<String[]> annexs = UploadFrame.getAnnex();
            	int annexNum = annexs.size();
            	for (int i = 0; i < annexNum; i++) {
					Element document_i = (Element) document.cloneNode(true);
					String[] annex = annexs.get(i);
					Element url_i = (Element) document_i.getElementsByTagName("gmd:URL").item(0);
					Element nameString_i = (Element) document_i.getElementsByTagName("gco:CharacterString").item(0);
					Element descriptionString_i = (Element) document_i.getElementsByTagName("gco:CharacterString").item(1);
					url_i.getFirstChild().setNodeValue(annex[0]);
					nameString_i.getFirstChild().setNodeValue(annex[1]);
					descriptionString_i.getFirstChild().setNodeValue(annex[2]);		
					documentList.appendChild(document_i);
				}
            	if (UploadFrame.checkPhotoInfo()==true) {
            		Element url = (Element) document.getElementsByTagName("gmd:URL").item(0);
					Element nameString = (Element) document.getElementsByTagName("gco:CharacterString").item(0);
					Element descriptionString = (Element) document.getElementsByTagName("gco:CharacterString").item(1);
					url.getFirstChild().setNodeValue(photoInfo[0]);
					nameString.getFirstChild().setNodeValue(photoInfo[1]);
					descriptionString.getFirstChild().setNodeValue(photoInfo[2]);				
				}          	
			}else {
				root.removeChild(documentation);
			}
        	
        	
        	
        	//获取服务接口Interfaces
        	Element interfaces = (Element) xmlDoc.getElementsByTagName("sml:interfaces").item(0);
        	Element interfaceList = (Element) xmlDoc.getElementsByTagName("sml:InterfaceList").item(0);
        	Element intface = (Element) interfaceList.getElementsByTagName("sml:interface").item(0);
        	System.out.println("接口个数："+Insitu_plat_frame.getInterfaceRow());
        	if (Insitu_plat_frame.getInterfaceRow()==0) {
				root.removeChild(interfaces);
			}
        	else if (Insitu_plat_frame.getInterfaceRow()==1) {
				intface.setAttribute("name", Insitu_plat_frame.getInterfaceInfo(0, 0));
				NodeList interfaceValue = intface.getElementsByTagName("swe:value");
				interfaceValue.item(0).getFirstChild().setNodeValue(Insitu_plat_frame.getInterfaceInfo(0, 2));
				interfaceValue.item(1).getFirstChild().setNodeValue(Insitu_plat_frame.getInterfaceInfo(0, 1));
				interfaceValue.item(2).getFirstChild().setNodeValue(Insitu_plat_frame.getInterfaceInfo(0, 3));
			}
        	//多个接口情况
        	else if (Insitu_plat_frame.getInterfaceRow()>1) {
        		intface.setAttribute("name", Insitu_plat_frame.getInterfaceInfo(0, 0));
				NodeList interfaceValue = intface.getElementsByTagName("swe:value");
				interfaceValue.item(0).getFirstChild().setNodeValue(Insitu_plat_frame.getInterfaceInfo(0, 2));
				interfaceValue.item(1).getFirstChild().setNodeValue(Insitu_plat_frame.getInterfaceInfo(0, 1));
				interfaceValue.item(2).getFirstChild().setNodeValue(Insitu_plat_frame.getInterfaceInfo(0, 3));
				for (int i = 1; i < Insitu_plat_frame.getInterfaceRow(); i++) {
					Element inter = (Element) interfaceList.cloneNode(true);
					NodeList interValue = inter.getElementsByTagName("swe:value");
					inter.setAttribute("name", Insitu_plat_frame.getInterfaceInfo(i, 0));
					interValue.item(0).getFirstChild().setNodeValue(Insitu_plat_frame.getInterfaceInfo(i, 2));
					interValue.item(1).getFirstChild().setNodeValue(Insitu_plat_frame.getInterfaceInfo(i, 1));
					interValue.item(2).getFirstChild().setNodeValue(Insitu_plat_frame.getInterfaceInfo(i, 3));
				}
			}
        	
        	
        	//获取输入输出
        	Element inputs = (Element) xmlDoc.getElementsByTagName("sml:inputs").item(0);
        	Element inputList = (Element) xmlDoc.getElementsByTagName("sml:InputList").item(0);
        	Element input = (Element) inputList.getElementsByTagName("sml:input").item(0);
        	Element property = (Element) input.getElementsByTagName("swe:ObservableProperty").item(0);
        	if (Insitu_plat_frame.getInputRow()==0) {
				root.removeChild(inputs);
			}else if (Insitu_plat_frame.getInputRow()==1) {
				input.setAttribute("name", Insitu_plat_frame.getInputInfo(0, 0));
				property.setAttribute("definition",Insitu_plat_frame.getInputInfo(0, 1));
			}else if (Insitu_plat_frame.getInputRow()>1) {
				input.setAttribute("name", Insitu_plat_frame.getInputInfo(0, 0));
				property.setAttribute("definition",Insitu_plat_frame.getInputInfo(0, 1));
				for(int i=1;i<Insitu_plat_frame.getInputRow();i++) {
					Element in = xmlDoc.createElement("sml:input");
					Element observable = xmlDoc.createElement("swe:ObservableProperty");
					in.setAttribute("name", Insitu_plat_frame.getInputInfo(i, 0));
					observable.setAttribute("definition",Insitu_plat_frame.getInputInfo(i, 1));
					observable.setNodeValue("");
					in.appendChild(observable);
					inputList.appendChild(in);
				}
			}   
        	
        	Element outputs = (Element) xmlDoc.getElementsByTagName("sml:outputs").item(0);
        	Element outputList = (Element) xmlDoc.getElementsByTagName("sml:OutputList").item(0);
        	Element output = (Element) outputList.getElementsByTagName("sml:output").item(0);
        	Element outdef = (Element) output.getElementsByTagName("swe:Quantity").item(0);
        	Element outUom = (Element) output.getElementsByTagName("swe:uom").item(0);
        	if (Insitu_plat_frame.getOutputRow()==0) {
				root.removeChild(outputs);
			}else if (Insitu_plat_frame.getOutputRow()==1) {
				output.setAttribute("name", Insitu_plat_frame.getOutputInfo(0, 0));
				outdef.setAttribute("definition", Insitu_plat_frame.getOutputInfo(0, 1));
				outUom.setAttribute("code", Insitu_plat_frame.getOutputInfo(0, 2));
			}else if (Insitu_plat_frame.getOutputRow()>1) {
				output.setAttribute("name", Insitu_plat_frame.getOutputInfo(0, 0));
				outdef.setAttribute("definition", Insitu_plat_frame.getOutputInfo(0, 1));
				outUom.setAttribute("code", Insitu_plat_frame.getOutputInfo(0, 2));
				for (int i = 1; i < Insitu_plat_frame.getOutputRow(); i++) {
					Element out = xmlDoc.createElement("sml:output");
					Element quantity = xmlDoc.createElement("swe:Quantity");
					Element outputUom = xmlDoc.createElement("swe:uom");
					out.setAttribute("name", Insitu_plat_frame.getOutputInfo(i, 0));
					quantity.setAttribute("definition", Insitu_plat_frame.getOutputInfo(i, 1));
					outputUom.setAttribute("code", Insitu_plat_frame.getOutputInfo(i, 2));
					quantity.appendChild(outputUom);
					out.appendChild(quantity);
					outputList.appendChild(out);
				}
			}
        	
        	
        	//获取参数
        	Element parameters = (Element) xmlDoc.getElementsByTagName("sml:parameters").item(0);
        	if (Insitu_plat_frame.getParameterRow()==0) {
				root.removeChild(parameters);
			}
        	
        	
        	//获取站点组件
        	Element components = (Element) xmlDoc.getElementsByTagName("sml:components").item(0);
        	Element componentList = (Element) xmlDoc.getElementsByTagName("sml:ComponentList").item(0);
        	Element component = (Element) componentList.getElementsByTagName("sml:component").item(0);
        	if (Insitu_plat_frame.getComponentRow()==0) {
				root.removeChild(components);
			}else if (Insitu_plat_frame.getComponentRow()==1) {
				component.setAttribute("name", Insitu_plat_frame.getComponentInfo(0, 0));
				component.setAttribute("xlink:Title", Insitu_plat_frame.getComponentInfo(0, 1));
				component.setAttribute("xlink:href", Insitu_plat_frame.getComponentInfo(0, 1));
			}else if (Insitu_plat_frame.getComponentRow()>1) {
				component.setAttribute("name", Insitu_plat_frame.getComponentInfo(0, 0));
				component.setAttribute("xlink:Title", Insitu_plat_frame.getComponentInfo(0, 1));
				component.setAttribute("xlink:href", Insitu_plat_frame.getComponentInfo(0, 1));
				for (int i = 1; i < Insitu_plat_frame.getComponentRow(); i++) {
					Element comp = (Element) component.cloneNode(true);
					comp.setAttribute("name", Insitu_plat_frame.getComponentInfo(i, 0));
					comp.setAttribute("xlink:Title", Insitu_plat_frame.getComponentInfo(i, 1));
					comp.setAttribute("xlink:href", Insitu_plat_frame.getComponentInfo(i, 1));
		        	componentList.appendChild(comp);
				}
			}
        	
        	//获取组件关系
        	Element connections = (Element) xmlDoc.getElementsByTagName("sml:connections").item(0);
        	Element connectionList = (Element) xmlDoc.getElementsByTagName("sml:ConnectionList").item(0);
        	Element link = (Element) connectionList.getElementsByTagName("sml:Link").item(0);
        	Element source = (Element) link.getElementsByTagName("sml:source").item(0);
        	Element destination = (Element) link.getElementsByTagName("sml:destination").item(0);
        	if (Insitu_plat_frame.getConnectionRow()==0) {
				root.removeChild(connections);
			}else if (Insitu_plat_frame.getConnectionRow()==1) {
				source.setAttribute("ref", Insitu_plat_frame.getConnectInfo(0, 0));
				destination.setAttribute("ref", Insitu_plat_frame.getConnectInfo(0, 1));
			}else if (Insitu_plat_frame.getConnectionRow()>1) {
				source.setAttribute("ref", Insitu_plat_frame.getConnectInfo(0, 0));
				destination.setAttribute("ref", Insitu_plat_frame.getConnectInfo(0, 1));
				for (int i = 1; i < Insitu_plat_frame.getConnectionRow(); i++) {
					Element lk = (Element) link.cloneNode(true);
					Element s = (Element) lk.getElementsByTagName("sml:source").item(0);
		        	Element d = (Element) lk.getElementsByTagName("sml:destination").item(0);
		        	s.setAttribute("ref", Insitu_plat_frame.getConnectInfo(i, 0));
					d.setAttribute("ref", Insitu_plat_frame.getConnectInfo(i, 1));
					lk.appendChild(s);
					lk.appendChild(d);
					connectionList.appendChild(lk);
				}
			}       	        	
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			DOMSource xmlSource = new DOMSource(xmlDoc);
			StreamResult outXml = new StreamResult(new File(savePath));
			tf.transform(xmlSource, outXml);
		} catch (IOException e2) {
			e2.printStackTrace();
		}catch (Exception e) {
			e.getMessage();
		}
    }
	
	
	public static void saveXML() {
		JFileChooser jfc = new JFileChooser("C:/");
		jfc.setAcceptAllFileFilterUsed(false);
		jfc.setFileFilter(new FileNameExtensionFilter("xml格式模型文件（*.xml）","xml"));
		jfc.showSaveDialog(null);
		File f = jfc.getSelectedFile();
		String fname = f.getAbsolutePath();
		DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db= dbf.newDocumentBuilder();
			Document xmlDoc = db.parse(savePath);
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf= tff.newTransformer();
			DOMSource source = new DOMSource(xmlDoc);
			StreamResult out = new StreamResult(new File(fname+".xml"));
			tf.transform(source, out);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
