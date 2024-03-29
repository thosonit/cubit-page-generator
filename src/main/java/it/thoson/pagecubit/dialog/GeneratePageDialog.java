package it.thoson.pagecubit.dialog;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GeneratePageDialog extends DialogWrapper {

    private final Listener listener;
    private JTextField pageNameTextField;
    private JPanel contentPanel;

    public GeneratePageDialog(final Listener listener) {
        super(false);
        this.listener = listener;
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return contentPanel;
    }

    @Override
    protected void doOKAction() {
        super.doOKAction();
        this.listener.onGeneratePageClicked(pageNameTextField.getText());
    }

    @Nullable
    @Override
    public JComponent getPreferredFocusedComponent() {
        return pageNameTextField;
    }

    public interface Listener {
        void onGeneratePageClicked(String pageName);
    }
}
