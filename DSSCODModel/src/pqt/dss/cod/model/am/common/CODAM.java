package pqt.dss.cod.model.am.common;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jun 06 12:13:10 PKT 2016
// ---------------------------------------------------------------------
public interface CODAM extends ApplicationModule {
    void Apply();


    void Rollback();

    void DssApprove();

    void callWorkflow(oracle.jbo.domain.Number p_document_id, String ApprovalType);

    void DeleteCommit();

    void callCODWorkflow(oracle.jbo.domain.Number p_document_id);
}
