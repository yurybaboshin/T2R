import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Main extends ApplicationWindow {
	private Action action;
	private Action action_1;
	private Action action_2;
	/**
	 * Create the application window.
	 */
	public Main() {
		super(null);
		createActions();
//		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
		{
			action = new Action("Список заказов") {
			};
		}
		{
			action_1 = new Action("База клиентов") {
			};
		}
		{
			action_2 = new Action("Выход") {
				  public void run() {
				     System.exit(0);
				    }
			};
		}
	}
	

	/**
	 * Create the menu manager.
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");
		{
			MenuManager menuManager_1 = new MenuManager("New MenuManager");
			menuManager_1.setMenuText("Документы");
			menuManager.add(menuManager_1);
			menuManager_1.add(action);
			menuManager_1.add(action_1);
			menuManager_1.add(new Separator());
			menuManager_1.add(action_2);
		}
		return menuManager;
	}

	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			// Запросить логин и пароль
			AskUser askUser = new AskUser(null); 
			askUser.show();
			
			Main window = new Main();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Тестовое приложение");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
}
