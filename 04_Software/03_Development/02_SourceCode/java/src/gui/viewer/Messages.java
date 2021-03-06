/*
 * The MIT License
 *
 * Copyright 2017 Olimpia Popica, Benone Aligica
 *
 * Contact: contact[a(t)]annotate[(d){o}t]zone
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package gui.viewer;

import common.Icons;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 * The type Messages.
 *
 * @author Olimpia Popica
 */
public class Messages {

    private static final String OPT_PANE_BKG = "OptionPane.background";
    private static final String OPT_PANE_MSG_FRONT = "OptionPane.messageFont";
    private static final String OPT_PANE_BUTTON_FRONT = "OptionPane.buttonFont";
    private static final String PANEL_BKG = "Panel.background";
    private static final String TAHOMA_FONT = "Tahoma";

    /**
     * Show warning yes no messager int.
     *
     * @param parent  the parent
     * @param message the message
     * @param title   the title
     * @return the int
     */
    public static int showWarningYesNoMessager(Component parent, String message, String title) {
        UIManager.put(OPT_PANE_BKG, Color.white);
        UIManager.put(PANEL_BKG, Color.white);
        return JOptionPane.showConfirmDialog(parent, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, Icons.EXCLAMATION_ICON);
    }

    /**
     * Show warning err yes no message int.
     *
     * @param parent  the parent
     * @param message the message
     * @param title   the title
     * @return the int
     */
    public static int showWarningErrYesNoMessage(Component parent, String message, String title) {
        UIManager.put(OPT_PANE_BKG, Color.white);
        UIManager.put(PANEL_BKG, Color.white);
        UIManager.put(OPT_PANE_MSG_FRONT, new FontUIResource(new Font(TAHOMA_FONT, Font.PLAIN, 11)));
        UIManager.put(OPT_PANE_BUTTON_FRONT, new FontUIResource(new Font(TAHOMA_FONT, Font.PLAIN, 11)));
        return JOptionPane.showConfirmDialog(parent, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, Icons.ERROR_ICON);
    }

    /**
     * Show question message int.
     *
     * @param parent  the parent
     * @param message the message
     * @param title   the title
     * @return the int
     */
    public static int showQuestionMessage(Component parent, String message, String title) {
        UIManager.put(OPT_PANE_BKG, Color.white);
        UIManager.put(PANEL_BKG, Color.white);
        UIManager.put(OPT_PANE_MSG_FRONT, new FontUIResource(new Font(TAHOMA_FONT, Font.PLAIN, 11)));
        UIManager.put(OPT_PANE_BUTTON_FRONT, new FontUIResource(new Font(TAHOMA_FONT, Font.PLAIN, 11)));
        return JOptionPane.showConfirmDialog(parent, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, Icons.QUESTION_ICON);
    }

    /**
     * Show info message.
     *
     * @param parent  the parent
     * @param message the message
     * @param title   the title
     */
    public static void showInfoMessage(Component parent, String message, String title) {
        UIManager.put(OPT_PANE_BKG, Color.white);
        UIManager.put(PANEL_BKG, Color.white);
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE, Icons.INFO_ICON);
    }

    /**
     * Show error message.
     *
     * @param parent  the parent
     * @param message the message
     * @param title   the title
     */
    public static void showErrorMessage(Component parent, String message, String title) {
        UIManager.put(OPT_PANE_BKG, Color.white);
        UIManager.put(PANEL_BKG, Color.white);
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE, Icons.ERROR_ICON);
    }

    /**
     * Show ok message.
     *
     * @param parent  the parent
     * @param message the message
     * @param title   the title
     */
    public static void showOkMessage(Component parent, String message, String title) {
        UIManager.put(OPT_PANE_BKG, Color.white);
        UIManager.put(PANEL_BKG, Color.white);
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE, Icons.OK_ICON);
    }

    /**
     * Show warning message.
     *
     * @param parent  the parent
     * @param message the message
     * @param title   the title
     */
    public static void showWarningMessage(Component parent, String message, String title) {
        UIManager.put(OPT_PANE_BKG, Color.white);
        UIManager.put(PANEL_BKG, Color.white);
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.WARNING_MESSAGE, Icons.EXCLAMATION_ICON);
    }

    /**
     * Show question yes no cancel message int.
     *
     * @param parent  the parent
     * @param message the message
     * @param title   the title
     * @return the int
     */
    public static int showQuestionYesNoCancelMessage(Component parent, String message, String title) {
        UIManager.put(OPT_PANE_BKG, Color.white);
        UIManager.put(PANEL_BKG, Color.white);
        return JOptionPane.showConfirmDialog(parent, message, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, Icons.QUESTION_ICON);
    }

    /**
     * Show input message object.
     *
     * @param parent  the parent
     * @param message the message
     * @param title   the title
     * @return the object
     */
    public static Object showInputMessage(Component parent, String message, String title) {
        UIManager.put(OPT_PANE_BKG, Color.white);
        UIManager.put(PANEL_BKG, Color.white);
        return JOptionPane.showInputDialog(parent, message, title, JOptionPane.WARNING_MESSAGE, Icons.EXCLAMATION_ICON, null, null);
    }

    /**
     * Show question message int.
     *
     * @param parent     the parent
     * @param message    the message
     * @param title      the title
     * @param optionType the option type
     * @param options    the options
     * @param selected   the selected
     * @return the int
     */
    public static int showQuestionMessage(Component parent, String message, String title, int optionType, Object[] options, Object selected) {
        UIManager.put(OPT_PANE_BKG, Color.white);
        UIManager.put(PANEL_BKG, Color.white);
        return JOptionPane.showOptionDialog(parent, message, title, optionType, JOptionPane.QUESTION_MESSAGE, Icons.QUESTION_ICON,
                options, selected);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        showInputMessage(null, "test", "test");
    }
}
