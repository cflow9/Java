
package javaapplication2;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JeopardyApp extends Frame implements ActionListener, ItemListener, MouseListener, KeyListener {
    MenuBar menubar = this.addMenuBar();

    public JeopardyApp()
    {
        this.setLayout((LayoutManager)null);
        this.setSize(1000, 500);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt)
            {
                evt.getWindow().dispose();
            }
        });
        this.setVisible(true);
        this.toFront();
        this.requestFocus();
    }

    public MenuBar makeMenus(String[] menus) {
        for(int m = 0; m < menus.length; ++m) {
            if(menus[m].length() > 0) {
                int r = menus[m].indexOf("|");
                if(r < 0) {
                    r = menus[m].length();
                }

                int e;
                for(Menu newmenu = this.addMenu(menus[m].substring(0, r), this.menubar); r >= 0 && r < menus[m].length(); r = e) {
                    e = menus[m].indexOf("|", r + 1);
                    if(e < 0) {
                        e = menus[m].length();
                    }

                    MenuItem newmi = this.addMenuItem(menus[m].substring(r + 1, e), newmenu, this);
                    newmi.setActionCommand(newmenu.getActionCommand() + "|" + newmi.getActionCommand());
                }
            }
        }

        return this.menubar;
    }

    public Button addButton(String txt, int left, int top, int width, int height, ActionListener listener) {
        Button newComp = new Button(txt);
        this.add(newComp);
        newComp.setBounds(left, top, width, height);
        if(listener != null) {
            newComp.addActionListener(listener);
        }

        return newComp;
    }

    public Checkbox addCheckbox(String text, int left, int top, int width, int height, ItemListener listener) {
        Checkbox newComp = new Checkbox(text);
        this.add(newComp);
        newComp.setBounds(left, top, width, height);
        if(listener != null) {
            newComp.addItemListener(listener);
        }

        return newComp;
    }

    public TextField addTextField(String txt, int left, int top, int width, int height, ActionListener listener) {
        TextField newComp = new TextField(txt);
        this.add(newComp);
        newComp.setBounds(left, top, width, height);
        if(listener != null) {
            newComp.addActionListener(listener);
        }

        return newComp;
    }

    public TextArea addTextArea(String txt, int left, int top, int width, int height, KeyListener listener) {
        TextArea newComp = new TextArea(txt);
        this.add(newComp);
        newComp.setBounds(left, top, width, height);
        if(listener != null) {
            newComp.addKeyListener(listener);
        }

        return newComp;
    }

    public Label addLabel(String txt, int left, int top, int width, int height, MouseListener listener) {
        Label newComp = new Label(txt);
        this.add(newComp);
        newComp.setBounds(left, top, width, height);
        if(listener != null) {
            newComp.addMouseListener(listener);
        }

        return newComp;
    }

    public JLabel addJLabel(ImageIcon img, int left, int top, int width, int height, MouseListener listener) {
        JLabel newComp = new JLabel(img);
        this.add(newComp);
        newComp.setBounds(left, top, width, height);
        if(listener != null) {
            newComp.addMouseListener(listener);
        }

        return newComp;
    }

    public List addList(String words, int left, int top, int width, int height, ItemListener listener) {
        List newComp = new List();

        while(words.length() > 0) {
            int s = words.indexOf("|");
            if(s < 0) {
                newComp.add(words);
                words = "";
            } else {
                newComp.add(words.substring(0, s));
                words = words.substring(s + 1);
            }
        }

        this.add(newComp);
        newComp.setBounds(left, top, width, height);
        if(listener != null) {
            newComp.addItemListener(listener);
        }

        return newComp;
    }

    public Choice addChoice(String words, int left, int top, int width, int height, ItemListener listener) {
        Choice newComp = new Choice();

        while(words.length() > 0) {
            int s = words.indexOf("|");
            if(s < 0) {
                newComp.add(words);
                words = "";
            } else {
                newComp.add(words.substring(0, s));
                words = words.substring(s + 1);
            }
        }

        this.add(newComp);
        newComp.setBounds(left, top, width, height);
        if(listener != null) {
            newComp.addItemListener(listener);
        }

        return newComp;
    }

    public MenuItem addMenuItem(String mText, Menu mu, ActionListener listener) {
        MenuItem c = new MenuItem(mText);
        mu.add(c);
        if(listener != null) {
            c.addActionListener(listener);
        }

        return c;
    }

    public Menu addMenu(String mText, Menu mu) {
        Menu c = new Menu(mText);
        mu.add(c);
        return c;
    }

    public Menu addMenu(String mText, MenuBar mb) {
        Menu c = new Menu(mText);
        mb.add(c);
        return c;
    }

    public Menu addMenu(String mText) {
        int d = mText.indexOf("|");
        if(d < 0) {
            d = mText.length();
        }

        String id = mText.substring(0, d);
        Menu c = new Menu(id);
        this.menubar.add(c);

        while(d < mText.length()) {
            int e = mText.indexOf("|", d + 1);
            if(e < 0) {
                e = mText.length();
            }

            String cmd = mText.substring(d + 1, e);
            MenuItem mi = this.addMenuItem(cmd, c, this);
            mi.setActionCommand(id + "|" + cmd);
            c.add(mi);
            d = e;
        }

        return c;
    }

    public MenuBar addMenuBar() {
        MenuBar c = new MenuBar();
        this.setMenuBar(c);
        return c;
    }

    public Process runProgram(String programName) {
        Process handle = null;

        try {
            handle = Runtime.getRuntime().exec(programName);
        } catch (IOException var4) {
        }

        return handle;
    }

    public String chooseFile() {
        FileDialog fd = new FileDialog(this);
        fd.setVisible(true);
        return fd.getDirectory() + fd.getFile();
    }

    public Image loadImage(String filename) {
        ImageIcon im = new ImageIcon(filename);
        int c = 0;

        do {
            ++c;
        } while(c < 100000 && im.getImageLoadStatus() != 8);

        return im.getImage();
    }

    public boolean loadList(List list, String filename) {
        try {
            list.removeAll();
            try (BufferedReader e = new BufferedReader(new FileReader(filename))) {
                while(e.ready()) {
                    list.add(e.readLine());
                }
            }
            return true;
        } catch (IOException var4) {
            this.output(var4.toString());
            return false;
        }
    }

    public boolean saveList(String filename, List list) {
        try (PrintWriter e = new PrintWriter(new FileWriter(filename))) {

            for(int c = 0; c < list.getItemCount(); ++c) {
                e.println(list.getItem(c));
            }

        } catch (IOException var5) {
            this.output(var5.toString());
            return false;
        }
        return true;
    }

    public String getType(Object ob) {
        String c = ob.getClass().toString();
        int p = c.lastIndexOf(".");
        if(p < 0) {
            p = -1;
        }

        return c.substring(p + 1);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        this.actions(evt.getSource(), evt.getActionCommand());
    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        Object source = evt.getSource();
        String t = this.getType(source);
        String command = "";
        switch (t) {
            case "List":
                command = ((List)source).getSelectedItem();
                break;
            case "Choice":
                command = ((Choice)source).getSelectedItem();
                break;
            default:
                command = evt.getItem().toString();
                break;
        }

        this.actions(source, command);
    }

    public void actions(Object source, String command) {
        this.output(source.toString() + ":" + command);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        this.actions(source, "");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }
@Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        Object source = e.getSource();
        this.actions(source, e.getKeyChar() + "");
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void output(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void outputString(String message) {
        this.output(message);
    }

    public void output(char info) {
        this.output(info + "");
    }

    public void output(byte info) {
        this.output(info + "");
    }

    public void output(int info) {
        this.output(info + "");
    }

    public void output(long info) {
        this.output(info + "");
    }

    public void output(double info) {
        this.output(info + "");
    }

    public void output(boolean info) {
        this.output(info + "");
    }

    public String input(String prompt) {
        return JOptionPane.showInputDialog(this, prompt);
    }

    public String inputString(String prompt) {
        return this.input(prompt);
    }

    public String input() {
        return this.input("");
    }

    public char inputChar(String prompt) {
        boolean result = false;

        char result1;
        try {
            result1 = this.input(prompt).charAt(0);
        } catch (Exception var4) {
            result1 = 0;
        }

        return result1;
    }

    public byte inputByte(String prompt) {
        boolean result = false;

        byte result1;
        try {
            result1 = Byte.valueOf(this.input(prompt).trim()).byteValue();
        } catch (Exception var4) {
            result1 = 0;
        }

        return result1;
    }

    public int inputInt(String prompt) {
        boolean result = false;

        int result1;
        try {
            result1 = Integer.parseInt(this.input(prompt).trim());
        } catch (Exception var4) {
            result1 = 0;
        }

        return result1;
    }

    public long inputLong(String prompt) {
        long result = 0L;

        try {
            result = Long.parseLong(this.input(prompt).trim());
        } catch (Exception var5) {
            result = 0L;
        }

        return result;
    }

    public double inputDouble(String prompt) {
        double result = 0.0D;

        try {
            result = Double.parseDouble(this.input(prompt).trim());
        } catch (Exception var5) {
            result = 0.0D;
        }

        return result;
    }

    public boolean inputBoolean(String prompt) {
        boolean result = false;

        try {
            result = Boolean.parseBoolean(this.input(prompt).trim());
        } catch (Exception var4) {
            result = false;
        }

        return result;
    }
}
