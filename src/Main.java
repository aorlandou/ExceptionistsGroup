import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import java.awt.event.ActionEvent;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Button;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.widgets.Canvas;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Main {
	/*Connecting to
	our database
	DB data = new DB();data.getConnection();

	

	/**
	 * Launch the application.
	 * @param args
	 */
	protected Shell shlWelcome;
	public static void main(String[] args) {
		DB data = new DB();
		//data.getConnection();
		try {
			maingraphics window = new maingraphics();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlWelcome.open();
		shlWelcome.layout();
		while (!shlWelcome.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlWelcome = new Shell();
		shlWelcome.setBackground(SWTResourceManager.getColor(230, 230, 250));
		shlWelcome.setSize(731, 215);
		shlWelcome.setText("Welcome!");
		shlWelcome.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Label input1_lbl = new Label(shlWelcome, SWT.NONE);
		input1_lbl.setBackground(SWTResourceManager.getColor(230, 230, 250));
		input1_lbl.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		input1_lbl.setAlignment(SWT.CENTER);
		input1_lbl.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		input1_lbl.setText("If you want to sign up press 1, if you want to log up press 2");

		Button Button1 = new Button(shlWelcome, SWT.NONE);
		Button1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SignUp.creatAccount();
			}
		});
		Button1.setForeground(SWTResourceManager.getColor(0, 0, 0));
		Button1.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		Button1.setText("Button 1");

		Button Button2 = new Button(shlWelcome, SWT.NONE);
		Button2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Login log = new Login();
				log.loginmethod();
			}
		});
		Button2.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		Button2.setText("Button 2");

	}
}
