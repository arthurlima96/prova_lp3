package com.br.lp3.prova.principal;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GriBagLayoutExampleMain {
    public static void main(String[] args) {
        JPanel formPanel = createFormPanel();
        JFrame frame = createFrame();
        frame.add(formPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel createFormPanel() {
        //initialize fields
        JTextField nameField = new JTextField(10);
        JTextField streetField = new JTextField(10),
                cityField = new JTextField(5), zipCodeField = new JTextField(5);
        JTextField phoneNumberField = new JTextField();
        JTextField ageField = new JTextField();
        JTextPane descriptionField = new JTextPane();
        descriptionField.setBorder(new LineBorder(Color.gray));
        JButton submitBtn = new JButton("Submit");

        //create panel
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        //using FormBuilder
        FormBuilder.init(panel)
                   .add("Full Name", nameField, FormBuilder::spanX3)
                   .newRow()
                   .addLabelsAsRowHeading("", "Street", "City", "Zip Code")
                   .newRow()
                   .add("Address", streetField).add(cityField).add(zipCodeField)
                   .newRow()
                   .add("Phone", phoneNumberField).add("Age", ageField)
                   .newRow()
                   .add("Description", descriptionField, FormBuilder::spanX3, FormBuilder::spanY2,
                           FormBuilder::fillParentY)
                   .newRow()
                   .newRow()
                   .skipColumns(2).add(submitBtn, FormBuilder::spanX2);

        return panel;
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame("GridBagLayout Builder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400, 300));
        return frame;
    }
}