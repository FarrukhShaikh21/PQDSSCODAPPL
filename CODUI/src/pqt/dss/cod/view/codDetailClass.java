package pqt.dss.cod.view;

import javax.faces.application.FacesMessage;
import javax.faces.component.UISelectItems;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelHeader;
import oracle.adf.view.rich.component.rich.layout.RichPanelLabelAndMessage;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichButton;

import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.adf.view.rich.component.rich.output.RichSeparator;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.JboException;

import org.apache.myfaces.trinidad.component.UIXGroup;
import org.apache.myfaces.trinidad.component.UIXSwitcher;


public class codDetailClass {
    private RichInputText it3;
    private RichInputDate id1;
    private RichInputListOfValues newBranchNameId;
    private RichInputListOfValues demoteRankId;
    private RichInputListOfValues promoteRankId;
    private UIXSwitcher s1;
    private UISelectItems si1;
    private RichSelectOneChoice soc1;
    private RichInputText it2;
    private RichInputText it1;
    private RichInputListOfValues agentCodeId;
    private RichInputListOfValues currentBranchNameId;
    private RichPanelFormLayout pfl1;
    private RichButton b2;
    private RichButton b1;
    private UIXGroup g1;
    private RichToolbar t1;
    private RichPanelHeader ph1;
    private RichPanelStretchLayout psl1;
    private RichPanelGroupLayout pgl1;
    private RichPanelHeader ph2;
    private RichPanelHeader ph3;
    private RichSeparator s2;
    private RichSeparator s3;
    private RichTable t2;
    private RichTable t3;
    private RichPanelLabelAndMessage plam3;
    private RichOutputText ot3;
    private RichInputDate id4;
    private RichInputText it18;
    private RichPanelFormLayout pfl2;
    private RichInputText it7;
    private RichInputText it13;
    private RichInputText it19;
    private RichInputText it20;
    private RichInputText it21;
    private RichInputText it22;
    private UIXSwitcher s4;
    private RichInputText it23;

    public codDetailClass() {
    }

    public String Branch_action() {
        // Add event code here...
        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operation = bindings.getOperationBinding("callWorkflow");
        operation.getParamsMap().put("p_document_id", getAttributeValue("CodIdPk"));
        operation.getParamsMap().put("ApprovalType", "BRANCH");
        Object result = operation.execute();
        if (!operation.getErrors().isEmpty()) {
            JboException ex = new JboException("Some thing went wrong while sending Notification.");
            BindingContext bctx = BindingContext.getCurrent();
            ((DCBindingContainer) bctx.getCurrentBindingsEntry()).reportException(ex);
        }else{
        this.SendMessage();
        }
        return "backQuery";
    }

    public String Dss_action() {
        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operation = bindings.getOperationBinding("callWorkflow");
        operation.getParamsMap().put("p_document_id", getAttributeValue("CodIdPk"));
        operation.getParamsMap().put("ApprovalType", "DSS");
        Object result = operation.execute();
        if (!operation.getErrors().isEmpty()) {
            JboException ex = new JboException("Some thing went wrong while sending Notification.");
            BindingContext bctx = BindingContext.getCurrent();
            ((DCBindingContainer) bctx.getCurrentBindingsEntry()).reportException(ex);
        }
        this.SendMessage();
        return "backQuery";
    }

    public Object getAttributeValue(String AttrName) {
        BindingContainer bdCont = BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding val = (AttributeBinding) bdCont.getControlBinding(AttrName);
        return val.getInputValue();
    }

    public String Approve_action() {
        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operation = bindings.getOperationBinding("DssApprove");
        operation.execute();
        this.SendMessage();
        return "backQuery";
    }

    public void SendMessage() {
        FacesMessage Message = new FacesMessage("Workflow has been submitted successfully!");
        Message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, Message);
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setNewBranchNameId(RichInputListOfValues newBranchNameId) {
        this.newBranchNameId = newBranchNameId;
    }

    public RichInputListOfValues getNewBranchNameId() {
        return newBranchNameId;
    }

    public void setDemoteRankId(RichInputListOfValues demoteRankId) {
        this.demoteRankId = demoteRankId;
    }

    public RichInputListOfValues getDemoteRankId() {
        return demoteRankId;
    }

    public void setPromoteRankId(RichInputListOfValues promoteRankId) {
        this.promoteRankId = promoteRankId;
    }

    public RichInputListOfValues getPromoteRankId() {
        return promoteRankId;
    }

    public void setS1(UIXSwitcher s1) {
        this.s1 = s1;
    }

    public UIXSwitcher getS1() {
        return s1;
    }

    public void setSi1(UISelectItems si1) {
        this.si1 = si1;
    }

    public UISelectItems getSi1() {
        return si1;
    }

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setAgentCodeId(RichInputListOfValues agentCodeId) {
        this.agentCodeId = agentCodeId;
    }

    public RichInputListOfValues getAgentCodeId() {
        return agentCodeId;
    }

    public void setCurrentBranchNameId(RichInputListOfValues currentBranchNameId) {
        this.currentBranchNameId = currentBranchNameId;
    }

    public RichInputListOfValues getCurrentBranchNameId() {
        return currentBranchNameId;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }


    public void setB2(RichButton b2) {
        this.b2 = b2;
    }

    public RichButton getB2() {
        return b2;
    }

    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB1() {
        return b1;
    }

    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }

    public void setT1(RichToolbar t1) {
        this.t1 = t1;
    }

    public RichToolbar getT1() {
        return t1;
    }

    public void setPh1(RichPanelHeader ph1) {
        this.ph1 = ph1;
    }

    public RichPanelHeader getPh1() {
        return ph1;
    }

    public void setPsl1(RichPanelStretchLayout psl1) {
        this.psl1 = psl1;
    }

    public RichPanelStretchLayout getPsl1() {
        return psl1;
    }


    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setPh2(RichPanelHeader ph2) {
        this.ph2 = ph2;
    }

    public RichPanelHeader getPh2() {
        return ph2;
    }

    public void setPh3(RichPanelHeader ph3) {
        this.ph3 = ph3;
    }

    public RichPanelHeader getPh3() {
        return ph3;
    }

    public void setS2(RichSeparator s2) {
        this.s2 = s2;
    }

    public RichSeparator getS2() {
        return s2;
    }

    public void setS3(RichSeparator s3) {
        this.s3 = s3;
    }

    public RichSeparator getS3() {
        return s3;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    public void setT3(RichTable t3) {
        this.t3 = t3;
    }

    public RichTable getT3() {
        return t3;
    }

    public void setPlam3(RichPanelLabelAndMessage plam3) {
        this.plam3 = plam3;
    }

    public RichPanelLabelAndMessage getPlam3() {
        return plam3;
    }

    public void setOt3(RichOutputText ot3) {
        this.ot3 = ot3;
    }

    public RichOutputText getOt3() {
        return ot3;
    }

    public void setId4(RichInputDate id4) {
        this.id4 = id4;
    }

    public RichInputDate getId4() {
        return id4;
    }


    public void setIt18(RichInputText it18) {
        this.it18 = it18;
    }

    public RichInputText getIt18() {
        return it18;
    }


    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
    }

    public void setIt7(RichInputText it7) {
        this.it7 = it7;
    }

    public RichInputText getIt7() {
        return it7;
    }

    public void setIt13(RichInputText it13) {
        this.it13 = it13;
    }

    public RichInputText getIt13() {
        return it13;
    }

    public void setIt19(RichInputText it19) {
        this.it19 = it19;
    }

    public RichInputText getIt19() {
        return it19;
    }

    public void setIt20(RichInputText it20) {
        this.it20 = it20;
    }

    public RichInputText getIt20() {
        return it20;
    }

    public void setIt21(RichInputText it21) {
        this.it21 = it21;
    }

    public RichInputText getIt21() {
        return it21;
    }

    public void setIt22(RichInputText it22) {
        this.it22 = it22;
    }

    public RichInputText getIt22() {
        return it22;
    }

    public void setS4(UIXSwitcher s4) {
        this.s4 = s4;
    }

    public UIXSwitcher getS4() {
        return s4;
    }
    public String SubmitForApproval() {
        // Add event code here...
        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operation = bindings.getOperationBinding("callCODWorkflow");
        operation.getParamsMap().put("p_document_id", getAttributeValue("CodIdPk"));
        operation.execute();

        return "backQuery";
    }

    public void setIt23(RichInputText it23) {
        this.it23 = it23;
    }

    public RichInputText getIt23() {
        return it23;
    }
}
