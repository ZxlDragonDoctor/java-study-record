package test.commandPattern;

// test.commandPattern.Command Interface
public interface Command {
    void execute();
}

// ConcreteCommand for SystemExit
class SystemExitCommand implements Command {
    private SystemExitClass systemExit;

    public SystemExitCommand(SystemExitClass systemExit) {
        this.systemExit = systemExit;
    }

    @Override
    public void execute() {
        systemExit.exitSystem();
    }
}

// ConcreteCommand for DisplayHelp
class DisplayHelpCommand implements Command {
    private DisplayHelpClass displayHelp;

    public DisplayHelpCommand(DisplayHelpClass displayHelp) {
        this.displayHelp = displayHelp;
    }

    @Override
    public void execute() {
        displayHelp.showHelp();
    }
}

// Receiver - test.commandPattern.SystemExitClass
class SystemExitClass {
    public void exitSystem() {
        System.out.println("Exiting system...");
    }
}

// Receiver - test.commandPattern.DisplayHelpClass
class DisplayHelpClass {
    public void showHelp() {
        System.out.println("Displaying help...");
    }
}

// Invoker - test.commandPattern.FunctionButton
class FunctionButton {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Test Class
class CommandPatternTest {
    public static void main(String[] args) {
        // Create receivers
        SystemExitClass systemExit = new SystemExitClass();
        DisplayHelpClass displayHelp = new DisplayHelpClass();

        // Create commands
        Command exitCommand = new SystemExitCommand(systemExit);
        Command helpCommand = new DisplayHelpCommand(displayHelp);

        // Create function buttons
        FunctionButton exitButton = new FunctionButton();
        FunctionButton helpButton = new FunctionButton();

        // Set commands for function buttons
        exitButton.setCommand(exitCommand);
        helpButton.setCommand(helpCommand);

        // Simulate pressing the buttons
        exitButton.pressButton();  // Should exit the system
        helpButton.pressButton();  // Should display help
    }
}
