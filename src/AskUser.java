import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class AskUser extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	public void show() {
		try {
			Display display = Display.getDefault();
			AskUser shell = new AskUser(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public AskUser(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new FillLayout(SWT.VERTICAL));
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
