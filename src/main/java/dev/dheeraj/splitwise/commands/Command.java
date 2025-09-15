package dev.dheeraj.splitwise.commands;

public interface Command {
    public boolean matches(String string);
    public void execute(String string);
}
