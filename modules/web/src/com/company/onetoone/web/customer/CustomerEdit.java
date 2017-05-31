package com.company.onetoone.web.customer;

import com.company.onetoone.entity.CustomerDetails;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.onetoone.entity.Customer;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.components.actions.BaseAction;

import javax.inject.Inject;
import javax.inject.Named;

public class CustomerEdit extends AbstractEditor<Customer> {

    @Named("fieldGroup.details")
    private PickerField detailsField;

    @Inject
    private Metadata metadata;

    @Inject
    private DataManager dataManager;

    @Override
    protected void postInit() {
        Customer customer = getItem();

        detailsField.removeAllActions();
        detailsField.addAction(new BaseAction("create") {
            @Override
            public void actionPerform(Component component) {
                CustomerDetails details = metadata.create(CustomerDetails.class);
                openEditor(details, WindowManager.OpenType.THIS_TAB).addCloseWithCommitListener(() -> {
                    customer.setDetails(details);
                });
            }

            @Override
            public String getIcon() {
                return "icons/add.png";
            }
        });

        detailsField.addOpenAction();

        detailsField.addAction(new PickerField.ClearAction(detailsField) {
            @Override
            public void actionPerform(Component component) {
                if (customer.getDetails() != null)
                    dataManager.remove(customer.getDetails());

                super.actionPerform(component);
            }
        });
    }
}