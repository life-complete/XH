package org.tempuri;

public class EmrToExternalServiceSoapProxy implements org.tempuri.EmrToExternalServiceSoap {
  private String _endpoint = null;
  private org.tempuri.EmrToExternalServiceSoap emrToExternalServiceSoap = null;
  
  public EmrToExternalServiceSoapProxy() {
    _initEmrToExternalServiceSoapProxy();
  }
  
  public EmrToExternalServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmrToExternalServiceSoapProxy();
  }
  
  private void _initEmrToExternalServiceSoapProxy() {
    try {
      emrToExternalServiceSoap = (new org.tempuri.EmrToExternalServiceLocator()).getEmrToExternalServiceSoap();
      if (emrToExternalServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)emrToExternalServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)emrToExternalServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (emrToExternalServiceSoap != null)
      ((javax.xml.rpc.Stub)emrToExternalServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.EmrToExternalServiceSoap getEmrToExternalServiceSoap() {
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap;
  }
  
  public int testNurseGrid(java.lang.String[] params) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.testNurseGrid(params);
  }
  
  public int createNurseGrid(java.lang.String[] params) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.createNurseGrid(params);
  }
  
  public int appendNurseGridItem(java.lang.String[] paramValue) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.appendNurseGridItem(paramValue);
  }
  
  public int getNurseGridPageCount(java.lang.String[] params, javax.xml.rpc.holders.StringHolder totalPageCount) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getNurseGridPageCount(params, totalPageCount);
  }
  
  public void getNurseGridItem(java.lang.String[] params, org.tempuri.GetNurseGridItemNuserTable nuserTable, javax.xml.rpc.holders.IntHolder getNurseGridItemResult, org.tempuri.holders.GetNurseGridItemResponseNuserTableHolder nuserTable2) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    emrToExternalServiceSoap.getNurseGridItem(params, nuserTable, getNurseGridItemResult, nuserTable2);
  }
  
  public int uploadPatientImg(byte[] buffer, java.lang.String UHID, java.lang.String imgClsName, java.lang.String imgName) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.uploadPatientImg(buffer, UHID, imgClsName, imgName);
  }
  
  public byte[] downLoadPatientImg(java.lang.String UHID, java.lang.String imgClsName, java.lang.String imgName) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.downLoadPatientImg(UHID, imgClsName, imgName);
  }
  
  public boolean deletePatientImgs(java.lang.String UHID, java.lang.String imgClsName, java.lang.String imgName) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.deletePatientImgs(UHID, imgClsName, imgName);
  }
  
  public boolean movePatientImg(java.lang.String UHID, java.lang.String imgClsName, java.lang.String imgName, java.lang.String destImgClsName) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.movePatientImg(UHID, imgClsName, imgName, destImgClsName);
  }
  
  public int createPatientCls(java.lang.String UHID, java.lang.String imgClsName) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.createPatientCls(UHID, imgClsName);
  }
  
  public int renameFileOrFolderName(java.lang.String UHID, java.lang.String imgClsName, java.lang.String imgName, java.lang.String modifyName) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.renameFileOrFolderName(UHID, imgClsName, imgName, modifyName);
  }
  
  public void getImgWidthAndHeight(java.lang.String UHID, java.lang.String imgClsName, java.lang.String imgName, javax.xml.rpc.holders.IntHolder getImgWidthAndHeightResult, javax.xml.rpc.holders.IntHolder imgHeight) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    emrToExternalServiceSoap.getImgWidthAndHeight(UHID, imgClsName, imgName, getImgWidthAndHeightResult, imgHeight);
  }
  
  public java.lang.String getEmrParagraphEntity(java.lang.String hisId) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getEmrParagraphEntity(hisId);
  }
  
  public java.lang.String getEmrParagraphEntityAll(java.lang.String hisId) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getEmrParagraphEntityAll(hisId);
  }
  
  public int doCheckParagraphEntity(java.lang.String hisId, java.lang.String templateName, int SNum) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.doCheckParagraphEntity(hisId, templateName, SNum);
  }
  
  public java.lang.String[] getGetEmrParagraphEntity3(java.lang.String hisId, java.lang.String paragraphTitle) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getGetEmrParagraphEntity3(hisId, paragraphTitle);
  }
  
  public java.lang.String[][] getGetEmrParagraphByKeyWords(java.lang.String hisId, java.lang.String keyWords) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getGetEmrParagraphByKeyWords(hisId, keyWords);
  }
  
  public java.lang.String[] getEmrPrgrphEntityByPrgrphCode(java.lang.String hisId, java.lang.String primaryType, java.lang.String paragraphCode) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getEmrPrgrphEntityByPrgrphCode(hisId, primaryType, paragraphCode);
  }
  
  public java.lang.String getChartEvent(java.lang.String hisid, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getChartEvent(hisid, errorMsg);
  }
  
  public java.lang.String getTempChartEvent(java.lang.String hisid, java.util.Calendar inputDate, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getTempChartEvent(hisid, inputDate, errorMsg);
  }
  
  public void commonSqlForRecruit3AllPagesToXml(java.lang.String conn, java.lang.String uhid, java.lang.String date_Validated, java.lang.String formName, javax.xml.rpc.holders.IntHolder commonSqlForRecruit3AllPagesToXmlResult, javax.xml.rpc.holders.StringHolder xmlResult, javax.xml.rpc.holders.StringHolder msg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    emrToExternalServiceSoap.commonSqlForRecruit3AllPagesToXml(conn, uhid, date_Validated, formName, commonSqlForRecruit3AllPagesToXmlResult, xmlResult, msg);
  }
  
  public boolean getRecruit3BasicInfo(java.lang.String hisId, java.lang.String formName, javax.xml.rpc.holders.StringHolder returnXml, javax.xml.rpc.holders.StringHolder dateUpdate, javax.xml.rpc.holders.StringHolder uhid, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getRecruit3BasicInfo(hisId, formName, returnXml, dateUpdate, uhid, errorMsg);
  }
  
  public boolean getRecruit3BasicInfoEx(java.lang.String hisId, java.lang.String formName, javax.xml.rpc.holders.StringHolder returnXml, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getRecruit3BasicInfoEx(hisId, formName, returnXml, errorMsg);
  }
  
  public boolean saveRecruit3Xml(java.lang.String userId, java.lang.String formType, java.lang.String pageCount, java.lang.String hisId, java.lang.String formName, java.lang.String returnXml, javax.xml.rpc.holders.StringHolder dateUpdate, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.saveRecruit3Xml(userId, formType, pageCount, hisId, formName, returnXml, dateUpdate, errorMsg);
  }
  
  public java.lang.String hisDepartmentAndJobNumSync(java.lang.String detailXml, java.lang.String otherText) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.hisDepartmentAndJobNumSync(detailXml, otherText);
  }
  
  public boolean addUser(java.lang.String userXml) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.addUser(userXml);
  }
  
  public boolean updateUser(java.lang.String userXml) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.updateUser(userXml);
  }
  
  public boolean updateUserPerson(java.lang.String userPersonXml) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.updateUserPerson(userPersonXml);
  }
  
  public boolean deleteUser(java.lang.String userXml) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.deleteUser(userXml);
  }
  
  public boolean addOrg(java.lang.String orgXml) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.addOrg(orgXml);
  }
  
  public boolean updateOrg(java.lang.String orgXml) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.updateOrg(orgXml);
  }
  
  public boolean deleteOrg(java.lang.String orgXml) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.deleteOrg(orgXml);
  }
  
  public boolean setUserPrimaryOrg(java.lang.String userXml) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.setUserPrimaryOrg(userXml);
  }
  
  public boolean setUserOrgs(java.lang.String userXml, java.lang.String orgXml) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.setUserOrgs(userXml, orgXml);
  }
  
  public boolean updateUserPassword(java.lang.String userCode, java.lang.String password) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.updateUserPassword(userCode, password);
  }
  
  public void returnRecord_UHID(java.lang.String id, java.lang.String userName, java.lang.String returnReason, javax.xml.rpc.holders.BooleanHolder returnRecord_UHIDResult, javax.xml.rpc.holders.StringHolder msg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    emrToExternalServiceSoap.returnRecord_UHID(id, userName, returnReason, returnRecord_UHIDResult, msg);
  }
  
  public void returnRecord_HisId(java.lang.String id, java.lang.String userName, java.lang.String returnReason, javax.xml.rpc.holders.BooleanHolder returnRecord_HisIdResult, javax.xml.rpc.holders.StringHolder msg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    emrToExternalServiceSoap.returnRecord_HisId(id, userName, returnReason, returnRecord_HisIdResult, msg);
  }
  
  public java.lang.String getSubmissionHistory_UHID(java.lang.String id, org.tempuri.holders.ArrayOfStringHolder history, javax.xml.rpc.holders.StringHolder msg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getSubmissionHistory_UHID(id, history, msg);
  }
  
  public java.lang.String getSubmissionHistory_HisId(java.lang.String id, org.tempuri.holders.ArrayOfStringHolder history, javax.xml.rpc.holders.StringHolder msg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getSubmissionHistory_HisId(id, history, msg);
  }
  
  public void archiveFile(java.lang.String id, java.lang.String flag, javax.xml.rpc.holders.BooleanHolder archiveFileResult, javax.xml.rpc.holders.StringHolder msg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    emrToExternalServiceSoap.archiveFile(id, flag, archiveFileResult, msg);
  }
  
  public java.lang.String addSubmitStep(java.lang.String requestXml) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.addSubmitStep(requestXml);
  }
  
  public java.lang.String getRecruitSepStr(java.lang.String PATEINT_ID, java.lang.String nurseGenre, int index, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getRecruitSepStr(PATEINT_ID, nurseGenre, index, errorMsg);
  }
  
  public boolean doSetRecruitCombine(java.lang.String PATEINT_ID, java.lang.String nurseGenre, java.lang.String reString, int index, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.doSetRecruitCombine(PATEINT_ID, nurseGenre, reString, index, errorMsg);
  }
  
  public int getRecruitCharts(java.lang.String[] hisid, javax.xml.rpc.holders.StringHolder resultXml) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getRecruitCharts(hisid, resultXml);
  }
  
  public org.tempuri.ServiceOptionsResponseServiceOptionsResult serviceOptions() throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.serviceOptions();
  }
  
  public int split_EMR_UHID(java.lang.String UHID, java.lang.String DATE_VALIDATED, java.lang.String splitName, org.tempuri.holders.ArrayOfStringHolder splitList) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.split_EMR_UHID(UHID, DATE_VALIDATED, splitName, splitList);
  }
  
  public int split_EMR_UHID_ALL(java.lang.String UHID, java.lang.String DATE_VALIDATED, javax.xml.rpc.holders.StringHolder splitList) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.split_EMR_UHID_ALL(UHID, DATE_VALIDATED, splitList);
  }
  
  public int split_EMR_HISIDS(java.lang.String HISIDS, java.lang.String splitName, org.tempuri.holders.ArrayOfStringHolder splitList) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.split_EMR_HISIDS(HISIDS, splitName, splitList);
  }
  
  public java.lang.String splitEmrReturnXmlWithHisid(java.lang.String hisId, java.lang.String splitName) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.splitEmrReturnXmlWithHisid(hisId, splitName);
  }
  
  public java.lang.String splitEmrReturnXmlWithUhid(java.lang.String uhid, java.lang.String splitName) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.splitEmrReturnXmlWithUhid(uhid, splitName);
  }
  
  public int split_EMR_HISIDS_HTML_XML(java.lang.String HISIDS, javax.xml.rpc.holders.StringHolder strHtml, javax.xml.rpc.holders.StringHolder splitList) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.split_EMR_HISIDS_HTML_XML(HISIDS, strHtml, splitList);
  }
  
  public int split_EMR_HISIDS_ALL(java.lang.String HISIDS, javax.xml.rpc.holders.StringHolder splitList) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.split_EMR_HISIDS_ALL(HISIDS, splitList);
  }
  
  public int splitEmrReturnXml(java.lang.String HISIDS, java.lang.String docType, javax.xml.rpc.holders.StringHolder splitList) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.splitEmrReturnXml(HISIDS, docType, splitList);
  }
  
  public java.lang.String splitEmrReturnXmlForJava(java.lang.String HISIDS, java.lang.String docType) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.splitEmrReturnXmlForJava(HISIDS, docType);
  }
  
  public void split_Template_UHID(java.lang.String UHID, java.lang.String DATE_VALIDATED, org.tempuri.Split_Template_UHIDDt dt, javax.xml.rpc.holders.IntHolder split_Template_UHIDResult, org.tempuri.holders.Split_Template_UHIDResponseDtHolder dt2) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    emrToExternalServiceSoap.split_Template_UHID(UHID, DATE_VALIDATED, dt, split_Template_UHIDResult, dt2);
  }
  
  public void split_Template_HISIDS(java.lang.String HISIDS, org.tempuri.Split_Template_HISIDSDt dt, javax.xml.rpc.holders.IntHolder split_Template_HISIDSResult, org.tempuri.holders.Split_Template_HISIDSResponseDtHolder dt2) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    emrToExternalServiceSoap.split_Template_HISIDS(HISIDS, dt, split_Template_HISIDSResult, dt2);
  }
  
  public int split_Template_HISIDS_XML(java.lang.String HISIDS, javax.xml.rpc.holders.StringHolder resultXML) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.split_Template_HISIDS_XML(HISIDS, resultXML);
  }
  
  public int getDataFromEMR(java.lang.String selType, java.lang.String selColumns, java.lang.String keyWords, javax.xml.rpc.holders.StringHolder resultXML) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getDataFromEMR(selType, selColumns, keyWords, resultXML);
  }
  
  public java.lang.String getDataFromEMRForJava(java.lang.String selType, java.lang.String selColumns, java.lang.String keyWords) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getDataFromEMRForJava(selType, selColumns, keyWords);
  }
  
  public java.lang.String getSerialNumber() throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getSerialNumber();
  }
  
  public java.util.Calendar getServerDateTime() throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getServerDateTime();
  }
  
  public org.tempuri.GetInfoResponseGetInfoResult getInfo(java.lang.String paramName, java.lang.String[] paramValue) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getInfo(paramName, paramValue);
  }
  
  public org.tempuri.GetInfo2ResponseGetInfo2Result getInfo2(java.lang.String paramName, java.lang.String paramValue) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getInfo2(paramName, paramValue);
  }
  
  public java.lang.String getInfo4() throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getInfo4();
  }
  
  public boolean setInfo(java.lang.String paramName, java.lang.String[] paramValue) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.setInfo(paramName, paramValue);
  }
  
  public boolean setInfo2(java.lang.String paramName, java.lang.String paramValue) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.setInfo2(paramName, paramValue);
  }
  
  public boolean rePlugIn() throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.rePlugIn();
  }
  
  public java.lang.String testCache(java.lang.String key, java.lang.String value) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.testCache(key, value);
  }
  
  public boolean saveBatchRecruitPHP(java.lang.String param) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.saveBatchRecruitPHP(param);
  }
  
  public boolean saveBatchRecruit(java.lang.String param, javax.xml.rpc.holders.StringHolder msg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.saveBatchRecruit(param, msg);
  }
  
  public int getMaxPage(java.lang.String hisid, java.lang.String templateName) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getMaxPage(hisid, templateName);
  }
  
  public java.lang.String getRecruitInfoByPages(java.lang.String hisid, java.lang.String templateName, int startPage, int endPage, java.lang.String currentHospital) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getRecruitInfoByPages(hisid, templateName, startPage, endPage, currentHospital);
  }
  
  public java.lang.String getRecruitInfo(java.lang.String hisid, java.lang.String templateName) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getRecruitInfo(hisid, templateName);
  }
  
  public java.lang.String getEventDate(java.lang.String id, java.lang.String eventStr, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getEventDate(id, eventStr, errorMsg);
  }
  
  public java.lang.String getEvent(java.lang.String id, java.lang.String eventStr, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getEvent(id, eventStr, errorMsg);
  }
  
  public java.lang.String getRecruitTemplate(java.lang.String templateName, javax.xml.rpc.holders.StringHolder msg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getRecruitTemplate(templateName, msg);
  }
  
  public java.lang.String getRecordParagraphType(java.lang.String hospitalID) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getRecordParagraphType(hospitalID);
  }
  
  public java.lang.String[] getEmrFileSetInfo(java.lang.String uhid, java.lang.String dateValidated, javax.xml.rpc.holders.StringHolder errorMsg, java.lang.String[] primaryTypes) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getEmrFileSetInfo(uhid, dateValidated, errorMsg, primaryTypes);
  }
  
  public boolean getHospitalInfo(java.lang.String hisid, javax.xml.rpc.holders.StringHolder HTML, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getHospitalInfo(hisid, HTML, errorMsg);
  }
  
  public boolean getNurseInfo(java.lang.String hisid, javax.xml.rpc.holders.StringHolder HTML, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getNurseInfo(hisid, HTML, errorMsg);
  }
  
  public boolean getMISCELLANEOUSInfo(java.lang.String hisid, javax.xml.rpc.holders.StringHolder HTML, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getMISCELLANEOUSInfo(hisid, HTML, errorMsg);
  }
  
  public boolean doInsertTempChartNew(java.lang.String[][] myarray, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.doInsertTempChartNew(myarray, errorMsg);
  }
  
  public boolean doInsertTempChartNew2(java.lang.String xml, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.doInsertTempChartNew2(xml, errorMsg);
  }
  
  public boolean doInsertTempChartNew1(java.lang.String[] array, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.doInsertTempChartNew1(array, errorMsg);
  }
  
  public boolean getInfoNewChart(java.lang.String id, javax.xml.rpc.holders.StringHolder xmlStr, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getInfoNewChart(id, xmlStr, errorMsg);
  }
  
  public java.lang.String getNewChart(java.lang.String id, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getNewChart(id, errorMsg);
  }
  
  public java.lang.String getTempChartNew(java.lang.String strRequest) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getTempChartNew(strRequest);
  }
  
  public org.tempuri.GetConfigInfoResponseGetConfigInfoResult getConfigInfo(java.lang.String key, java.lang.String[] myparams) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getConfigInfo(key, myparams);
  }
  
  public java.lang.String getConfigInfoToXml(java.lang.String key, java.lang.String[] myparams) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.getConfigInfoToXml(key, myparams);
  }
  
  public java.lang.String autoBuildHospital(java.lang.String requestXml) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.autoBuildHospital(requestXml);
  }
  
  public java.lang.String autoBuildNurse(java.lang.String requestXml) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.autoBuildNurse(requestXml);
  }
  
  public java.lang.String createConsultation(java.lang.String[] parameters) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.createConsultation(parameters);
  }
  
  public java.lang.String delConsultation(java.lang.String HISis, java.lang.String consultationID) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    return emrToExternalServiceSoap.delConsultation(HISis, consultationID);
  }
  
  public void commonSqlForRecruit3AllPages(java.lang.String conn, java.lang.String uhid, java.lang.String date_Validated, java.lang.String formName, org.tempuri.CommonSqlForRecruit3AllPagesDsResult dsResult, javax.xml.rpc.holders.StringHolder msg, javax.xml.rpc.holders.IntHolder commonSqlForRecruit3AllPagesResult, org.tempuri.holders.CommonSqlForRecruit3AllPagesResponseDsResultHolder dsResult2) throws java.rmi.RemoteException{
    if (emrToExternalServiceSoap == null)
      _initEmrToExternalServiceSoapProxy();
    emrToExternalServiceSoap.commonSqlForRecruit3AllPages(conn, uhid, date_Validated, formName, dsResult, msg, commonSqlForRecruit3AllPagesResult, dsResult2);
  }
  
  
}