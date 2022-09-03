package it.thoson.nwsflutter.dialog;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GeneratePageDialog extends DialogWrapper {

    private final Listener listener;
    private JTextField pageNameTextField;
    private JPanel contentPanel;

    public GeneratePageDialog(final Listener listener) {
        super(null);
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
        this.listener.onGenerateBlocClicked(pageNameTextField.getText());
    }

    @Nullable
    @Override
    public JComponent getPreferredFocusedComponent() {
        return pageNameTextField;
    }

    public interface Listener {
        void onGenerateBlocClicked(String pageName);
    }
}
