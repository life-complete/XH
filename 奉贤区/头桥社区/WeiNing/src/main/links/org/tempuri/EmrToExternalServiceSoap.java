/**
 * EmrToExternalServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface EmrToExternalServiceSoap extends java.rmi.Remote {
    public int testNurseGrid(java.lang.String[] params) throws java.rmi.RemoteException;
    public int createNurseGrid(java.lang.String[] params) throws java.rmi.RemoteException;
    public int appendNurseGridItem(java.lang.String[] paramValue) throws java.rmi.RemoteException;
    public int getNurseGridPageCount(java.lang.String[] params, javax.xml.rpc.holders.StringHolder totalPageCount) throws java.rmi.RemoteException;
    public void getNurseGridItem(java.lang.String[] params, org.tempuri.GetNurseGridItemNuserTable nuserTable, javax.xml.rpc.holders.IntHolder getNurseGridItemResult, org.tempuri.holders.GetNurseGridItemResponseNuserTableHolder nuserTable2) throws java.rmi.RemoteException;
    public int uploadPatientImg(byte[] buffer, java.lang.String UHID, java.lang.String imgClsName, java.lang.String imgName) throws java.rmi.RemoteException;
    public byte[] downLoadPatientImg(java.lang.String UHID, java.lang.String imgClsName, java.lang.String imgName) throws java.rmi.RemoteException;
    public boolean deletePatientImgs(java.lang.String UHID, java.lang.String imgClsName, java.lang.String imgName) throws java.rmi.RemoteException;
    public boolean movePatientImg(java.lang.String UHID, java.lang.String imgClsName, java.lang.String imgName, java.lang.String destImgClsName) throws java.rmi.RemoteException;
    public int createPatientCls(java.lang.String UHID, java.lang.String imgClsName) throws java.rmi.RemoteException;
    public int renameFileOrFolderName(java.lang.String UHID, java.lang.String imgClsName, java.lang.String imgName, java.lang.String modifyName) throws java.rmi.RemoteException;
    public void getImgWidthAndHeight(java.lang.String UHID, java.lang.String imgClsName, java.lang.String imgName, javax.xml.rpc.holders.IntHolder getImgWidthAndHeightResult, javax.xml.rpc.holders.IntHolder imgHeight) throws java.rmi.RemoteException;
    public java.lang.String getEmrParagraphEntity(java.lang.String hisId) throws java.rmi.RemoteException;
    public java.lang.String getEmrParagraphEntityAll(java.lang.String hisId) throws java.rmi.RemoteException;
    public int doCheckParagraphEntity(java.lang.String hisId, java.lang.String templateName, int SNum) throws java.rmi.RemoteException;
    public java.lang.String[] getGetEmrParagraphEntity3(java.lang.String hisId, java.lang.String paragraphTitle) throws java.rmi.RemoteException;
    public java.lang.String[][] getGetEmrParagraphByKeyWords(java.lang.String hisId, java.lang.String keyWords) throws java.rmi.RemoteException;
    public java.lang.String[] getEmrPrgrphEntityByPrgrphCode(java.lang.String hisId, java.lang.String primaryType, java.lang.String paragraphCode) throws java.rmi.RemoteException;
    public java.lang.String getChartEvent(java.lang.String hisid, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException;
    public java.lang.String getTempChartEvent(java.lang.String hisid, java.util.Calendar inputDate, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException;
    public void commonSqlForRecruit3AllPagesToXml(java.lang.String conn, java.lang.String uhid, java.lang.String date_Validated, java.lang.String formName, javax.xml.rpc.holders.IntHolder commonSqlForRecruit3AllPagesToXmlResult, javax.xml.rpc.holders.StringHolder xmlResult, javax.xml.rpc.holders.StringHolder msg) throws java.rmi.RemoteException;
    public boolean getRecruit3BasicInfo(java.lang.String hisId, java.lang.String formName, javax.xml.rpc.holders.StringHolder returnXml, javax.xml.rpc.holders.StringHolder dateUpdate, javax.xml.rpc.holders.StringHolder uhid, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException;
    public boolean getRecruit3BasicInfoEx(java.lang.String hisId, java.lang.String formName, javax.xml.rpc.holders.StringHolder returnXml, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException;
    public boolean saveRecruit3Xml(java.lang.String userId, java.lang.String formType, java.lang.String pageCount, java.lang.String hisId, java.lang.String formName, java.lang.String returnXml, javax.xml.rpc.holders.StringHolder dateUpdate, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException;
    public java.lang.String hisDepartmentAndJobNumSync(java.lang.String detailXml, java.lang.String otherText) throws java.rmi.RemoteException;
    public boolean addUser(java.lang.String userXml) throws java.rmi.RemoteException;
    public boolean updateUser(java.lang.String userXml) throws java.rmi.RemoteException;
    public boolean updateUserPerson(java.lang.String userPersonXml) throws java.rmi.RemoteException;
    public boolean deleteUser(java.lang.String userXml) throws java.rmi.RemoteException;
    public boolean addOrg(java.lang.String orgXml) throws java.rmi.RemoteException;
    public boolean updateOrg(java.lang.String orgXml) throws java.rmi.RemoteException;
    public boolean deleteOrg(java.lang.String orgXml) throws java.rmi.RemoteException;
    public boolean setUserPrimaryOrg(java.lang.String userXml) throws java.rmi.RemoteException;
    public boolean setUserOrgs(java.lang.String userXml, java.lang.String orgXml) throws java.rmi.RemoteException;
    public boolean updateUserPassword(java.lang.String userCode, java.lang.String password) throws java.rmi.RemoteException;
    public void returnRecord_UHID(java.lang.String id, java.lang.String userName, java.lang.String returnReason, javax.xml.rpc.holders.BooleanHolder returnRecord_UHIDResult, javax.xml.rpc.holders.StringHolder msg) throws java.rmi.RemoteException;
    public void returnRecord_HisId(java.lang.String id, java.lang.String userName, java.lang.String returnReason, javax.xml.rpc.holders.BooleanHolder returnRecord_HisIdResult, javax.xml.rpc.holders.StringHolder msg) throws java.rmi.RemoteException;
    public java.lang.String getSubmissionHistory_UHID(java.lang.String id, org.tempuri.holders.ArrayOfStringHolder history, javax.xml.rpc.holders.StringHolder msg) throws java.rmi.RemoteException;
    public java.lang.String getSubmissionHistory_HisId(java.lang.String id, org.tempuri.holders.ArrayOfStringHolder history, javax.xml.rpc.holders.StringHolder msg) throws java.rmi.RemoteException;
    public void archiveFile(java.lang.String id, java.lang.String flag, javax.xml.rpc.holders.BooleanHolder archiveFileResult, javax.xml.rpc.holders.StringHolder msg) throws java.rmi.RemoteException;
    public java.lang.String addSubmitStep(java.lang.String requestXml) throws java.rmi.RemoteException;
    public java.lang.String getRecruitSepStr(java.lang.String PATEINT_ID, java.lang.String nurseGenre, int index, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException;
    public boolean doSetRecruitCombine(java.lang.String PATEINT_ID, java.lang.String nurseGenre, java.lang.String reString, int index, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException;
    public int getRecruitCharts(java.lang.String[] hisid, javax.xml.rpc.holders.StringHolder resultXml) throws java.rmi.RemoteException;
    public org.tempuri.ServiceOptionsResponseServiceOptionsResult serviceOptions() throws java.rmi.RemoteException;
    public int split_EMR_UHID(java.lang.String UHID, java.lang.String DATE_VALIDATED, java.lang.String splitName, org.tempuri.holders.ArrayOfStringHolder splitList) throws java.rmi.RemoteException;
    public int split_EMR_UHID_ALL(java.lang.String UHID, java.lang.String DATE_VALIDATED, javax.xml.rpc.holders.StringHolder splitList) throws java.rmi.RemoteException;
    public int split_EMR_HISIDS(java.lang.String HISIDS, java.lang.String splitName, org.tempuri.holders.ArrayOfStringHolder splitList) throws java.rmi.RemoteException;
    public java.lang.String splitEmrReturnXmlWithHisid(java.lang.String hisId, java.lang.String splitName) throws java.rmi.RemoteException;
    public java.lang.String splitEmrReturnXmlWithUhid(java.lang.String uhid, java.lang.String splitName) throws java.rmi.RemoteException;
    public int split_EMR_HISIDS_HTML_XML(java.lang.String HISIDS, javax.xml.rpc.holders.StringHolder strHtml, javax.xml.rpc.holders.StringHolder splitList) throws java.rmi.RemoteException;
    public int split_EMR_HISIDS_ALL(java.lang.String HISIDS, javax.xml.rpc.holders.StringHolder splitList) throws java.rmi.RemoteException;
    public int splitEmrReturnXml(java.lang.String HISIDS, java.lang.String docType, javax.xml.rpc.holders.StringHolder splitList) throws java.rmi.RemoteException;
    public java.lang.String splitEmrReturnXmlForJava(java.lang.String HISIDS, java.lang.String docType) throws java.rmi.RemoteException;
    public void split_Template_UHID(java.lang.String UHID, java.lang.String DATE_VALIDATED, org.tempuri.Split_Template_UHIDDt dt, javax.xml.rpc.holders.IntHolder split_Template_UHIDResult, org.tempuri.holders.Split_Template_UHIDResponseDtHolder dt2) throws java.rmi.RemoteException;
    public void split_Template_HISIDS(java.lang.String HISIDS, org.tempuri.Split_Template_HISIDSDt dt, javax.xml.rpc.holders.IntHolder split_Template_HISIDSResult, org.tempuri.holders.Split_Template_HISIDSResponseDtHolder dt2) throws java.rmi.RemoteException;
    public int split_Template_HISIDS_XML(java.lang.String HISIDS, javax.xml.rpc.holders.StringHolder resultXML) throws java.rmi.RemoteException;
    public int getDataFromEMR(java.lang.String selType, java.lang.String selColumns, java.lang.String keyWords, javax.xml.rpc.holders.StringHolder resultXML) throws java.rmi.RemoteException;
    public java.lang.String getDataFromEMRForJava(java.lang.String selType, java.lang.String selColumns, java.lang.String keyWords) throws java.rmi.RemoteException;
    public java.lang.String getSerialNumber() throws java.rmi.RemoteException;
    public java.util.Calendar getServerDateTime() throws java.rmi.RemoteException;
    public org.tempuri.GetInfoResponseGetInfoResult getInfo(java.lang.String paramName, java.lang.String[] paramValue) throws java.rmi.RemoteException;
    public org.tempuri.GetInfo2ResponseGetInfo2Result getInfo2(java.lang.String paramName, java.lang.String paramValue) throws java.rmi.RemoteException;
    public java.lang.String getInfo4() throws java.rmi.RemoteException;
    public boolean setInfo(java.lang.String paramName, java.lang.String[] paramValue) throws java.rmi.RemoteException;
    public boolean setInfo2(java.lang.String paramName, java.lang.String paramValue) throws java.rmi.RemoteException;
    public boolean rePlugIn() throws java.rmi.RemoteException;
    public java.lang.String testCache(java.lang.String key, java.lang.String value) throws java.rmi.RemoteException;
    public boolean saveBatchRecruitPHP(java.lang.String param) throws java.rmi.RemoteException;
    public boolean saveBatchRecruit(java.lang.String param, javax.xml.rpc.holders.StringHolder msg) throws java.rmi.RemoteException;
    public int getMaxPage(java.lang.String hisid, java.lang.String templateName) throws java.rmi.RemoteException;
    public java.lang.String getRecruitInfoByPages(java.lang.String hisid, java.lang.String templateName, int startPage, int endPage, java.lang.String currentHospital) throws java.rmi.RemoteException;
    public java.lang.String getRecruitInfo(java.lang.String hisid, java.lang.String templateName) throws java.rmi.RemoteException;
    public java.lang.String getEventDate(java.lang.String id, java.lang.String eventStr, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException;
    public java.lang.String getEvent(java.lang.String id, java.lang.String eventStr, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException;
    public java.lang.String getRecruitTemplate(java.lang.String templateName, javax.xml.rpc.holders.StringHolder msg) throws java.rmi.RemoteException;
    public java.lang.String getRecordParagraphType(java.lang.String hospitalID) throws java.rmi.RemoteException;
    public java.lang.String[] getEmrFileSetInfo(java.lang.String uhid, java.lang.String dateValidated, javax.xml.rpc.holders.StringHolder errorMsg, java.lang.String[] primaryTypes) throws java.rmi.RemoteException;
    public boolean getHospitalInfo(java.lang.String hisid, javax.xml.rpc.holders.StringHolder HTML, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException;
    public boolean getNurseInfo(java.lang.String hisid, javax.xml.rpc.holders.StringHolder HTML, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException;
    public boolean getMISCELLANEOUSInfo(java.lang.String hisid, javax.xml.rpc.holders.StringHolder HTML, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException;
    public boolean doInsertTempChartNew(java.lang.String[][] myarray, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException;
    public boolean doInsertTempChartNew2(java.lang.String xml, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException;
    public boolean doInsertTempChartNew1(java.lang.String[] array, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException;
    public boolean getInfoNewChart(java.lang.String id, javax.xml.rpc.holders.StringHolder xmlStr, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException;
    public java.lang.String getNewChart(java.lang.String id, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException;
    public java.lang.String getTempChartNew(java.lang.String strRequest) throws java.rmi.RemoteException;
    public org.tempuri.GetConfigInfoResponseGetConfigInfoResult getConfigInfo(java.lang.String key, java.lang.String[] myparams) throws java.rmi.RemoteException;
    public java.lang.String getConfigInfoToXml(java.lang.String key, java.lang.String[] myparams) throws java.rmi.RemoteException;
    public java.lang.String autoBuildHospital(java.lang.String requestXml) throws java.rmi.RemoteException;
    public java.lang.String autoBuildNurse(java.lang.String requestXml) throws java.rmi.RemoteException;
    public java.lang.String createConsultation(java.lang.String[] parameters) throws java.rmi.RemoteException;
    public java.lang.String delConsultation(java.lang.String HISis, java.lang.String consultationID) throws java.rmi.RemoteException;
    public void commonSqlForRecruit3AllPages(java.lang.String conn, java.lang.String uhid, java.lang.String date_Validated, java.lang.String formName, org.tempuri.CommonSqlForRecruit3AllPagesDsResult dsResult, javax.xml.rpc.holders.StringHolder msg, javax.xml.rpc.holders.IntHolder commonSqlForRecruit3AllPagesResult, org.tempuri.holders.CommonSqlForRecruit3AllPagesResponseDsResultHolder dsResult2) throws java.rmi.RemoteException;
}
