package domain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

public interface ProductMenu {

    abstract void showMenuButtons() throws Exception;
    abstract void showAddButtons();
    abstract void showViewButtons();
    abstract void showComboBoxes();
    abstract void showLabel();
    abstract void showRadioButtons();
}
