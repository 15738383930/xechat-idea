package cn.xeblog.action;

import cn.xeblog.entity.TextRender;
import cn.xeblog.enums.Command;
import cn.xeblog.enums.Style;
import cn.xeblog.mode.ModeContext;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.*;
import java.util.List;

/**
 * @author anlingyi
 * @date 2020/6/1
 */
public class ConsoleAction {

    private static JTextPane console;

    private static JPanel panel;

    private static JScrollPane consoleScroll;

    private static boolean isNewLine;

    public static void renderText(List<TextRender> list) {
        for (TextRender textRender : list) {
            renderText(textRender.getText(), textRender.getStyle());
        }
    }

    public static void renderText(String text, Style style) {
        if (isNewLine) {
            ModeContext.getMode().renderTextBefore();
        }

        render(text, style.get());

        isNewLine = text.endsWith("\n");
    }

    public static void showSimpleMsg(String msg) {
        renderText(msg + "\n", Style.DEFAULT);
    }

    public static void render(String content, AttributeSet attributeSet) {
        Document document = console.getDocument();
        try {
            document.insertString(document.getLength(), content, attributeSet);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        gotoConsoleLow();
    }

    public static void clean() {
        console.setText("");
    }

    public static void setConsoleTitle(String title) {
        ((TitledBorder)panel.getBorder()).setTitle(title);
    }

    public static void gotoConsoleLow() {
        JScrollBar scrollBar = consoleScroll.getVerticalScrollBar();
        scrollBar.setValue(scrollBar.getMaximum());
    }

    public static void showErrorMsg() {
        ConsoleAction.showSimpleMsg("输入的命令有误！帮助命令：" + Command.HELP.getCommand());
    }

    public static void showLoginMsg() {
        ConsoleAction.showSimpleMsg("请先登录！登录命令：" + Command.LOGIN.getCommand());
    }

    public static void setConsole(JTextPane console) {
        ConsoleAction.console = console;
    }

    public static void setPanel(JPanel panel) {
        ConsoleAction.panel = panel;
    }

    public static void setConsoleScroll(JScrollPane consoleScroll) {
        ConsoleAction.consoleScroll = consoleScroll;
    }

}
