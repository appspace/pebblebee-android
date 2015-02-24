package ca.appspace.android.pebblebee.ecobee;

import java.io.Serializable;

/**
 * Created by Eugene on 2015-02-19.
 */
public class ApiRequest implements ApiInfoObject {

    private Selection selection;
    private Page page;

    public Selection getSelection() {
        return selection;
    }

    public void setSelection(Selection selection) {
        this.selection = selection;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
