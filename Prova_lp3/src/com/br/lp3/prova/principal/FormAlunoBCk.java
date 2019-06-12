package com.br.lp3.prova.principal;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FormAlunoBCk extends JInternalFrame {
	
	

        private JLabel lFileName;
        private JTextField tfFile;
        private JButton fcButton;
        private JLabel lFileError;

        private JLabel lName;
        private JTextField tfName;
        private JLabel lNameError;

        private JLabel lLastName;
        private JTextField tfLastName;
        private JLabel lLastNameError;

        private JLabel lAddress;
        private JTextField tfAddress;
        private JLabel lAddressError;

        private JLabel lZipCode;
        private JTextField tfZipCode;
        private JLabel lZipCodeError;

        private JLabel lCountry;
        private JComboBox<String> cbCountry;
        private JLabel lCountryError;

        private JLabel lEmail;
        private JTextField tfEmail;
        private JLabel lEmailError;

        private JLabel lWebsite;
        private JTextField tfWebsite;
        private JLabel lWebsiteError;

        private JButton submitButton;
        private JButton submitButton2;

        private void build() {
                this.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();

                // Row 1 - Filename
                        // Col 1
                this.lFileName = new JLabel("Filename:");
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.insets = new Insets(5, 0, 0, 10);
                gbc.anchor = GridBagConstraints.LINE_END;
                this.add(this.lFileName, gbc);

                        // Col 2
                this.tfFile = new JTextField(20);
                this.tfFile.setEditable(false);
                gbc.gridx = 1;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.LINE_START;
                this.add(this.tfFile, gbc);

                this.fcButton = new JButton("Browse");
                gbc.gridx = 2;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.LINE_START;
                this.fcButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser fc = new JFileChooser();
                        int returnVal = fc.showOpenDialog(null);

                        if (returnVal == JFileChooser.APPROVE_OPTION) {
                            FormAlunoBCk.this.tfFile.setText(fc.getSelectedFile().getAbsolutePath().toLowerCase());
                    }

                } }) ;
                this.add(this.fcButton, gbc);

                // Row 2 - File not selected Error
                        // Col 1 - Empty

                        // Col 2
                this.lFileError = new JLabel("Please select a file.");
                this.lFileError.setForeground(Color.RED);
                this.lFileError.setVisible(false);
                gbc.gridx = 1;
                gbc.gridy = 1;
                gbc.anchor = GridBagConstraints.LINE_START;
                this.add(this.lFileError, gbc);

                // Row 3 - Name
                        // Col 1
                this.lName = new JLabel("First Name:");
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.anchor = GridBagConstraints.LINE_END;
                gbc.insets = new Insets(15, 0, 0, 10);
                this.add(this.lName, gbc);

                        // Col 2
                this.tfName = new JTextField(15);
                gbc.gridx = 1;
                gbc.gridy = 2;
                gbc.anchor = GridBagConstraints.LINE_START;
                this.add(this.tfName, gbc);

                        // Col 3
                this.lNameError = new JLabel("Please insert your First Name.");
                this.lNameError.setForeground(Color.RED);
                this.lNameError.setVisible(false);
                gbc.gridx = 2;
                gbc.gridy = 2;
                gbc.anchor = GridBagConstraints.LINE_START;
                this.add(this.lNameError, gbc);

                // Row 4 - Last Name
                        // Col 1
                this.lLastName = new JLabel("Last Name:");
                gbc.gridx = 0;
                gbc.gridy = 3;
                gbc.anchor = GridBagConstraints.LINE_END;
                gbc.insets = new Insets(5, 0, 0, 10);
                this.add(this.lLastName, gbc);

                        // Col 2
                this.tfLastName = new JTextField(15);
                gbc.gridx = 1;
                gbc.gridy = 3;
                gbc.anchor = GridBagConstraints.LINE_START;
                this.add(this.tfLastName, gbc);

                        // Col 3
                this.lLastNameError = new JLabel("Please insert your last name.");
                this.lLastNameError.setForeground(Color.RED);
                this.lLastNameError.setVisible(false);
                gbc.gridx = 2;
                gbc.gridy = 3;
                gbc.anchor = GridBagConstraints.LINE_START;
                this.add(this.lLastNameError, gbc);

                // Row 5 - Address
                        // Col 1
                this.lAddress = new JLabel("Address:");
                gbc.gridx = 0;
                gbc.gridy = 4;
                gbc.anchor = GridBagConstraints.LINE_END;
                gbc.insets = new Insets(15, 0, 0, 10);
                this.add(this.lAddress, gbc);

                        // Col 2
                this.tfAddress= new JTextField(20);
                gbc.gridx = 1;
                gbc.gridy = 4;
                gbc.anchor = GridBagConstraints.LINE_START;
                this.add(this.tfAddress, gbc);

                        // Col 3
                this.lAddressError = new JLabel("Please insert your address.");
                this.lAddressError.setForeground(Color.RED);
                this.lAddressError.setVisible(false);
                gbc.gridx = 2;
                gbc.gridy = 4;
                gbc.anchor = GridBagConstraints.LINE_START;
                this.add(this.lAddressError, gbc);

                // Row 6 - ZipCode
                        // Col 1
                this.lZipCode = new JLabel("Zip Code:");
                gbc.gridx = 0;
                gbc.gridy = 5;
                gbc.anchor = GridBagConstraints.LINE_END;
                gbc.insets = new Insets(5, 0, 0, 10);
                this.add(this.lZipCode, gbc);

                        // Col 2
                this.tfZipCode = new JTextField(6);
                gbc.gridx = 1;
                gbc.gridy = 5;
                gbc.anchor = GridBagConstraints.LINE_START;
                this.add(this.tfZipCode, gbc);

                        // Col 3
                this.lZipCodeError = new JLabel("Please insert your zip code.");
                this.lZipCodeError.setForeground(Color.RED);
                this.lZipCodeError.setVisible(false);
                gbc.gridx = 2;
                gbc.gridy = 5;
                gbc.anchor = GridBagConstraints.LINE_START;
                this.add(this.lZipCodeError, gbc);

                // Row 7 - Country
                        // Col 1
                this.lCountry = new JLabel("Country:");
                gbc.gridx = 0;
                gbc.gridy = 6;
                gbc.anchor = GridBagConstraints.LINE_END;
                this.add(this.lCountry, gbc);

                        // Col 2
                String []countries = {"", "Italy", "UK", "USA"};
                this.cbCountry = new JComboBox<String>(countries);
                gbc.gridx = 1;
                gbc.gridy = 6;
                gbc.anchor = GridBagConstraints.LINE_START;
                this.add(this.cbCountry, gbc);

                        // Col 3
                this.lCountryError = new JLabel("Please select your country.");
                this.lCountryError.setForeground(Color.RED);
                this.lCountryError.setVisible(false);
                gbc.gridx = 2;
                gbc.gridy = 6;
                gbc.anchor = GridBagConstraints.LINE_START;
                this.add(this.lCountryError, gbc);

                // Row 8 - Email
                        // Col 1
                this.lEmail = new JLabel("Email:");
                gbc.gridx = 0;
                gbc.gridy = 7;
                gbc.anchor = GridBagConstraints.LINE_END;
                gbc.insets = new Insets(15, 0, 0, 10);
                this.add(this.lEmail, gbc);

                        // Col 2
                this.tfEmail = new JTextField(15);
                gbc.gridx = 1;
                gbc.gridy = 7;
                gbc.anchor = GridBagConstraints.LINE_START;
                this.add(this.tfEmail, gbc);

                        // Col 3
                this.lEmailError = new JLabel("Please insert your email.");
                this.lEmailError.setForeground(Color.RED);
                this.lEmailError.setVisible(false);
                gbc.gridx = 2;
                gbc.gridy = 7;
                gbc.anchor = GridBagConstraints.LINE_START;
                this.add(this.lEmailError, gbc);

                // Row 9 - Website
                        // Col 1
                this.lWebsite = new JLabel("Website:");
                gbc.gridx = 0;
                gbc.gridy = 8;
                gbc.anchor = GridBagConstraints.LINE_END;
                gbc.insets = new Insets(5, 0, 0, 10);
                this.add(this.lWebsite, gbc);

                        // Col 2
                this.tfWebsite = new JTextField(15);
                gbc.gridx = 1;
                gbc.gridy = 8;
                gbc.anchor = GridBagConstraints.LINE_START;
                this.add(this.tfWebsite, gbc);
                
                gbc.weightx = 0.0;
                gbc.gridwidth = 3;
                this.add(this.tfWebsite, gbc);

                        // Col 3
                this.lWebsiteError = new JLabel("Please insert your website.");
                this.lWebsiteError.setForeground(Color.RED);
                this.lWebsiteError.setVisible(false);
                gbc.gridx = 2;
                gbc.gridy = 8;
                gbc.gridwidth = 4;
                gbc.anchor = GridBagConstraints.LINE_START;
                this.add(this.lWebsiteError, gbc);

                // Row 10 - Submit 
                        // Col 1 empty

                        // Col 2
                this.submitButton = new JButton("Submit");
                gbc.gridx = 1;
                gbc.gridy = 9;
                gbc.anchor = GridBagConstraints.LINE_START;
                gbc.insets = new Insets(25, 0, 0, 10);

                this.add(this.submitButton, gbc);
                
                this.submitButton2 = new JButton("Submit 2");
                gbc.gridx = 2;
                gbc.gridy = 9;
                gbc.anchor = GridBagConstraints.LINE_START;
                gbc.insets = new Insets(25, 0, 0, 10);

                this.add(this.submitButton2, gbc);

        }


        // CONSTRUCTOR
        public FormAlunoBCk () {
            this.build();
        }

        public FormAlunoBCk(String titulo, boolean b, boolean c, boolean d, boolean e) {
			super(titulo, b, c, d, e);
			this.build();
		}


		// GETTERS AND SETTERS
        public JLabel getlFileName() {
            return this.lFileName;
        }



        public void setlFileName(JLabel lFileName) {
            this.lFileName = lFileName;
        }



        public JTextField getTfFile() {
            return this.tfFile;
        }



        public void setTfFile(JTextField tfFile) {
            this.tfFile = tfFile;
        }



        public JButton getFcButton() {
            return this.fcButton;
        }



        public void setFcButton(JButton fcButton) {
            this.fcButton = fcButton;
        }



        public JLabel getlFileError() {
            return this.lFileError;
        }



        public void setlFileError(JLabel lFileError) {
            this.lFileError = lFileError;
        }



        public JLabel getlName() {
            return this.lName;
        }



        public void setlName(JLabel lName) {
            this.lName = lName;
        }



        public JTextField getTfName() {
            return this.tfName;
        }



        public void setTfName(JTextField tfName) {
            this.tfName = tfName;
        }



        public JLabel getlNameError() {
            return this.lNameError;
        }



        public void setlNameError(JLabel lNameError) {
            this.lNameError = lNameError;
        }



        public JLabel getlLastName() {
            return this.lLastName;
        }



        public void setlLastName(JLabel lLastName) {
            this.lLastName = lLastName;
        }



        public JTextField getTfLastName() {
            return this.tfLastName;
        }



        public void setTfLastName(JTextField tfLastName) {
            this.tfLastName = tfLastName;
        }



        public JLabel getlLastNameError() {
            return this.lLastNameError;
        }



        public void setlLastNameError(JLabel lLastNameError) {
            this.lLastNameError = lLastNameError;
        }



        public JLabel getlAddress() {
            return this.lAddress;
        }



        public void setlAddress(JLabel lAddress) {
            this.lAddress = lAddress;
        }



        public JTextField getTfAddress() {
            return this.tfAddress;
        }



        public void setTfAddress(JTextField tfAddress) {
            this.tfAddress = tfAddress;
        }



        public JLabel getlAddressError() {
            return this.lAddressError;
        }



        public void setlAddressError(JLabel lAddressError) {
            this.lAddressError = lAddressError;
        }



        public JLabel getlZipCode() {
            return this.lZipCode;
        }



        public void setlZipCode(JLabel lZipCode) {
            this.lZipCode = lZipCode;
        }



        public JTextField getTfZipCode() {
            return this.tfZipCode;
        }



        public void setTfZipCode(JTextField tfZipCode) {
            this.tfZipCode = tfZipCode;
        }



        public JLabel getlZipCodeError() {
            return this.lZipCodeError;
        }



        public void setlZipCodeError(JLabel lZipCodeError) {
            this.lZipCodeError = lZipCodeError;
        }



        public JLabel getlCountry() {
            return this.lCountry;
        }



        public void setlCountry(JLabel lCountry) {
            this.lCountry = lCountry;
        }



        public JComboBox<String> getCbCountry() {
            return this.cbCountry;
        }



        public void setCbCountry(JComboBox<String> cbCountry) {
            this.cbCountry = cbCountry;
        }



        public JLabel getlCountryError() {
            return this.lCountryError;
        }



        public void setlCountryError(JLabel lCountryError) {
            this.lCountryError = lCountryError;
        }



        public JLabel getlEmail() {
            return this.lEmail;
        }



        public void setlEmail(JLabel lEmail) {
            this.lEmail = lEmail;
        }



        public JTextField getTfEmail() {
            return this.tfEmail;
        }



        public void setTfEmail(JTextField tfEmail) {
            this.tfEmail = tfEmail;
        }



        public JLabel getlEmailError() {
            return this.lEmailError;
        }



        public void setlEmailError(JLabel lEmailError) {
            this.lEmailError = lEmailError;
        }



        public JLabel getlWebsite() {
            return this.lWebsite;
        }



        public void setlWebsite(JLabel lWebsite) {
            this.lWebsite = lWebsite;
        }



        public JTextField getTfWebsite() {
            return this.tfWebsite;
        }



        public void setTfWebsite(JTextField tfWebsite) {
            this.tfWebsite = tfWebsite;
        }



        public JLabel getlWebsiteError() {
            return this.lWebsiteError;
        }



        public void setlWebsiteError(JLabel lWebsiteError) {
            this.lWebsiteError = lWebsiteError;
        }



        public JButton getSubmitButton() {
            return this.submitButton;
        }



        public void setSubmitButton(JButton submitButton) {
            this.submitButton = submitButton;
        }

}
