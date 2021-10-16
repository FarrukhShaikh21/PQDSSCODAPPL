package pqt.dss.cod.view.Backing;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class createUpdateCod {
    public createUpdateCod() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    public Object getAttributeValue(String AttrName) {
        BindingContainer bdCont = BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding val = (AttributeBinding) bdCont.getControlBinding(AttrName);
        return val.getInputValue();
    }

    public String b2_action() {
                
        int i = Integer.parseInt(getAttributeValue("NewRankLevel").toString());
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Apply");
        DCBindingContainer dcBindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();  
        DCIteratorBinding LineVO= (DCIteratorBinding)dcBindings.get("DssCodMgrRecruitmentFormView2Iterator");  
        DCIteratorBinding DtlVO= (DCIteratorBinding)dcBindings.get("DssCodNewRecruitedMgrView1Iterator");  
        
        if(i<50){
            if(LineVO.getEstimatedRowCount() == 0 || DtlVO.getEstimatedRowCount() == 0){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please add Manager Recruited and new Recruited Manager Details", "");  
                 FacesContext.getCurrentInstance().addMessage(null, msg);                  
            }
            else{
                operationBinding.execute();
            }
        }
        else{            
            operationBinding.execute();                
        }
        
        return null;
    }
}
