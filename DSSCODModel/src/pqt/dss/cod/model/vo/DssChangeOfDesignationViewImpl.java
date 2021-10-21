package pqt.dss.cod.model.vo;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;

import pqt.dss.cod.model.vo.common.DssChangeOfDesignationView;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jul 13 18:39:19 PKT 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DssChangeOfDesignationViewImpl extends ViewObjectImpl implements DssChangeOfDesignationView {
    /**
     * This is the default constructor (do not remove).
     */
    public DssChangeOfDesignationViewImpl() {
    }

    /**
     * Returns the variable value for VC_Agent_CNIC.
     * @return variable value for VC_Agent_CNIC
     */
    public String getVC_Agent_CNIC() {
        return (String) ensureVariableManager().getVariableValue("VC_Agent_CNIC");
    }

    /**
     * Sets <code>value</code> for variable VC_Agent_CNIC.
     * @param value value to bind as VC_Agent_CNIC
     */
    public void setVC_Agent_CNIC(String value) {
        ensureVariableManager().setVariableValue("VC_Agent_CNIC", value);
    }

    /**
     * Returns the variable value for VC_Branch_Name.
     * @return variable value for VC_Branch_Name
     */
    public String getVC_Branch_Name() {
        return (String) ensureVariableManager().getVariableValue("VC_Branch_Name");
    }

    /**
     * Sets <code>value</code> for variable VC_Branch_Name.
     * @param value value to bind as VC_Branch_Name
     */
    public void setVC_Branch_Name(String value) {
        ensureVariableManager().setVariableValue("VC_Branch_Name", value);
    }

    /**
     * Returns the variable value for NVC_WfDocumentId.
     * @return variable value for NVC_WfDocumentId
     */
    public Number getNVC_WfDocumentId() {
        return (Number) ensureVariableManager().getVariableValue("NVC_WfDocumentId");
        
    }

    /**
     * Sets <code>value</code> for variable NVC_WfDocumentId.
     * @param value value to bind as NVC_WfDocumentId
     */
    public void setNVC_WfDocumentId(Number value) {
        ensureVariableManager().setVariableValue("NVC_WfDocumentId", value);
        this.exeViewCrieteria(value);
    }
    public void exeViewCrieteria(Number val) {
        ViewObject vo = this.getViewObject();
        ViewCriteria vc = this.getViewCriteria("NotificationViewCriteria");
        vo.applyViewCriteria(vc);
        vo.setNamedWhereClauseParam("NVC_WfDocumentId", val);
        vo.executeQuery();
    }


    /**
     * Returns the variable value for P_AGENT_CODE.
     * @return variable value for P_AGENT_CODE
     */
    public String getP_AGENT_CODE() {
        return (String) ensureVariableManager().getVariableValue("P_AGENT_CODE");
    }

    /**
     * Sets <code>value</code> for variable P_AGENT_CODE.
     * @param value value to bind as P_AGENT_CODE
     */
    public void setP_AGENT_CODE(String value) {
        ensureVariableManager().setVariableValue("P_AGENT_CODE", value);
    }

    /**
     * Returns the variable value for VC_Doc_No.
     * @return variable value for VC_Doc_No
     */
    public String getVC_Doc_No() {
        return (String) ensureVariableManager().getVariableValue("VC_Doc_No");
    }

    /**
     * Sets <code>value</code> for variable VC_Doc_No.
     * @param value value to bind as VC_Doc_No
     */
    public void setVC_Doc_No(String value) {
        ensureVariableManager().setVariableValue("VC_Doc_No", value);
    }
    public void codSearchUser()
    {
              FacesContext fctx = FacesContext.getCurrentInstance();
              ExternalContext ectx = fctx.getExternalContext();
              HttpSession userSession = (HttpSession) ectx.getSession(false);
//              userSession.setAttribute("SSV_UserDept", 3);
//              userSession.setAttribute("pUserId",1139);
//              userSession.setAttribute("SSV_UserType","BO");

              ViewCriteria vc = this.getViewCriteria("DssChangeOfDesignationViewCriteria");
              this.applyViewCriteria(vc);
              setWhereClause(null);
//              FacesContext fctx = FacesContext.getCurrentInstance();
//              ExternalContext ectx = fctx.getExternalContext();
//              HttpSession userSession = (HttpSession) ectx.getSession(false);
              Object VUserID = userSession.getAttribute("pUserId") == null ? "0" : userSession.getAttribute("pUserId");
              
                if (userSession.getAttribute("SSV_UserType").equals("BO")) {
                    setWhereClause("((exists (select 1 FROM DSS_SM_USERS AA, PQT_IL_LOC_BRANCH_DTL BD " + " WHERE 1=1" +
                                   " AND AA.USER_ID_PK  =" + userSession.getAttribute("pUserId") +
                                   " AND AA.GIS_LOCATION_ID_FK = BD.IL_LOC_ID_FK " +
                                   " AND BD.BRANCH_CODE = QRSLT.BRANCH_CODE_FK)))");
                }
                
              /*   setWhereClause("(exists\n" + 
              " (select 1 \n" + 
              " from DSS_SM_USERS a\n" + 
              " where a.user_id_pk = "+ VUserID+"\n" + 
              " and a.GIS_LOCATION_ID_FK = QRSLT.GIS_LOCATION_ID_FK ) OR '"+userSession.getAttribute("SSV_UserType")+"'!= 'BO'"+") ");   */
              
//              setWhereClause("exists\n" + 
//              " (select 1 \n" + 
//              "          from dss_sm_user_branch a\n" + 
//              "         where a.user_id_fk = "+ VUserID+"\n" + 
//              "           and a.branch_code = Branch_Name)");
//              setWhereClause("USER_ID_FK =" + VUserID);
              executeQuery();
          }


}

