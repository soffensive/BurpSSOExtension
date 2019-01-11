/**
 * EsPReSSO - Extension for Processing and Recognition of Single Sign-On Protocols.
 * Copyright (C) 2015 Tim Guenther and Christian Mainka
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package de.rub.nds.burp.espresso.gui.attacker.saml;

import de.rub.nds.burp.espresso.gui.attacker.IAttack;
import de.rub.nds.burp.utilities.ByteArrayHelper;
import de.rub.nds.burp.utilities.Logging;
import de.rub.nds.burp.utilities.XMLHelper;
import de.rub.nds.burp.utilities.listeners.AbstractCodeEvent;
import de.rub.nds.burp.utilities.listeners.CodeListenerController;
import de.rub.nds.burp.utilities.listeners.events.SamlCodeEvent;
import de.rub.nds.burp.utilities.protocols.xmlenc.AsymmetricAlgorithm;
import de.rub.nds.burp.utilities.protocols.xmlenc.SymmetricAlgorithm;
import de.rub.nds.burp.utilities.protocols.xmlenc.XmlEncryptionHelper;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import wsattacker.library.xmlutilities.dom.DomUtilities;

/**
 * The Encryption Attack
 *
 * @author Nurullah Erinola
 * @author Juraj Somorovsky
 * @version 1.0
 */
public class UIEncryptionAttack extends javax.swing.JPanel implements IAttack {

    private String saml = "";
    private CodeListenerController listeners = null;
    private XmlEncryptionHelper xmlEncryptionHelper;

    /**
     * Creates new form UIEncryptionAttack
     */
    public UIEncryptionAttack() {
        xmlEncryptionHelper = new XmlEncryptionHelper();
        initComponents();
        initEditorsAndListener();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sysPubButtonGroup = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaSymmetricKey = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaCertificate = new javax.swing.JTextArea();
        jComboBoxPublicAlgo = new javax.swing.JComboBox<>();
        jButtonEncryptSymmetricKey = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaEncryptedKey = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaXmlData = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaCipherData = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxSymmetricAlgo = new javax.swing.JComboBox<>();
        jButtonEncryptXML = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextAreaXmlHex = new javax.swing.JTextArea();
        jLabelWarningKeySize = new javax.swing.JLabel();
        jLabelWarningBlockSize = new javax.swing.JLabel();

        jLabel3.setText("Certificate:");

        jTextAreaSymmetricKey.setColumns(20);
        jTextAreaSymmetricKey.setLineWrap(true);
        jTextAreaSymmetricKey.setText("01 02 03 04 05 06 07 08 01 02 03 04 05 06 07 08");
        jScrollPane1.setViewportView(jTextAreaSymmetricKey);

        jLabel1.setText("Public key encryption:");

        jTextAreaCertificate.setColumns(20);
        jTextAreaCertificate.setText("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----");
        jScrollPane3.setViewportView(jTextAreaCertificate);

        jComboBoxPublicAlgo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonEncryptSymmetricKey.setText("Encrypt");
        jButtonEncryptSymmetricKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncryptSymmetricKeyActionPerformed(evt);
            }
        });

        jLabel4.setText("Symmetric key:");
        jLabel4.setToolTipText("Will be encrypted with the server public key.");

        jLabel5.setText("EncryptedKey:");

        jTextAreaEncryptedKey.setEditable(false);
        jTextAreaEncryptedKey.setColumns(20);
        jTextAreaEncryptedKey.setLineWrap(true);
        jScrollPane2.setViewportView(jTextAreaEncryptedKey);

        jLabel6.setText("Symmetric key encryption:");

        jLabel7.setText("XML data:");

        jTextAreaXmlData.setColumns(20);
        jTextAreaXmlData.setLineWrap(true);
        jTextAreaXmlData.setText("<saml:Assertion xmlns:saml=\"urn:oasis:names:tc:SAML:2.0:assertion\" Version=\"2.0\" ID=\"_009df3b376b737bdb3fd890f6740543e9ca17c4e71\" IssueInstant=\"2018-03-04T12:46:12Z\">\n</saml:Assertion>");
        jScrollPane4.setViewportView(jTextAreaXmlData);

        jLabel8.setText("CipherData:");

        jTextAreaCipherData.setEditable(false);
        jTextAreaCipherData.setColumns(20);
        jTextAreaCipherData.setLineWrap(true);
        jTextAreaCipherData.setRows(5);
        jScrollPane5.setViewportView(jTextAreaCipherData);

        jLabel2.setText("Algorithm:");

        jLabel10.setText("Algorithm:");

        jComboBoxSymmetricAlgo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSymmetricAlgo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSymmetricAlgoActionPerformed(evt);
            }
        });

        jButtonEncryptXML.setText("Encrypt");
        jButtonEncryptXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncryptXMLActionPerformed(evt);
            }
        });

        jTextAreaXmlHex.setColumns(20);
        jTextAreaXmlHex.setLineWrap(true);
        jScrollPane6.setViewportView(jTextAreaXmlHex);

        jLabelWarningKeySize.setForeground(new java.awt.Color(255, 0, 51));
        jLabelWarningKeySize.setText("Need x byte for encryption!");

        jLabelWarningBlockSize.setForeground(new java.awt.Color(255, 0, 51));
        jLabelWarningBlockSize.setText("Blocksize");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxPublicAlgo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEncryptSymmetricKey))
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSymmetricAlgo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEncryptXML))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(8, 8, 8)
                                .addComponent(jLabelWarningKeySize, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelWarningBlockSize))
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabelWarningKeySize)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxPublicAlgo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEncryptSymmetricKey))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelWarningBlockSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxSymmetricAlgo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEncryptXML))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEncryptSymmetricKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncryptSymmetricKeyActionPerformed
        Logging.getInstance().log(getClass(), "Start encryption of symmetric key.", Logging.INFO);
        String certificate = jTextAreaCertificate.getText();
        byte[] symmetricKey = ByteArrayHelper.hexStringToByteArray(jTextAreaSymmetricKey.getText());
        xmlEncryptionHelper.setSymmetricKey(symmetricKey);
        String algorithmURI = jComboBoxPublicAlgo.getItemAt(jComboBoxPublicAlgo.getSelectedIndex());
        AsymmetricAlgorithm algorithm = AsymmetricAlgorithm.getByURI(algorithmURI);
        try {
            String encryptedKey = xmlEncryptionHelper.encryptKey(certificate, algorithm);
            jTextAreaEncryptedKey.setText(encryptedKey);
            jTextAreaEncryptedKey.selectAll();
            jTextAreaEncryptedKey.copy();
        } catch (InvalidKeyException | NoSuchAlgorithmException | CertificateException | BadPaddingException
                | IllegalBlockSizeException | NoSuchPaddingException ex) {
            Logging.getInstance().log(getClass(), ex);
        }
        // Set key 
        try {
            Document doc = XMLHelper.stringToDom(saml);
            DomUtilities.evaluateXPath(doc, "//xenc:EncryptedKey//xenc:CipherValue").get(0).setTextContent(jTextAreaEncryptedKey.getText());
            saml = XMLHelper.docToString(doc);      
            notifyAllTabs(new SamlCodeEvent(this, saml));
            Logging.getInstance().log(getClass(), "Setting new encrypted symmetric key was successfull.", Logging.INFO);
        } catch (XPathExpressionException ex) {
            Logging.getInstance().log(getClass(), ex);
        }
    }//GEN-LAST:event_jButtonEncryptSymmetricKeyActionPerformed

    private void jButtonEncryptXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncryptXMLActionPerformed
        Logging.getInstance().log(getClass(), "Start ciphertext computation.", Logging.INFO);
        byte[] symmetricKey = ByteArrayHelper.hexStringToByteArray(jTextAreaSymmetricKey.getText());
        xmlEncryptionHelper.setSymmetricKey(symmetricKey);
        String algorithmURI = jComboBoxSymmetricAlgo.getItemAt(jComboBoxSymmetricAlgo.getSelectedIndex());
        SymmetricAlgorithm algorithm = SymmetricAlgorithm.getByURI(algorithmURI);
        String hexXml = jTextAreaXmlHex.getText();
        byte[] data = ByteArrayHelper.hexStringToByteArray(hexXml);
        try {
            String result = xmlEncryptionHelper.encryptData(data, algorithm);
            jTextAreaCipherData.setText(result);
            jTextAreaCipherData.selectAll();
            jTextAreaCipherData.copy();
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException
                | IllegalBlockSizeException | InvalidAlgorithmParameterException | NoSuchPaddingException ex) {
            Logging.getInstance().log(getClass(), ex);
        }
        // Set ciphertext 
        try {
            Document doc = XMLHelper.stringToDom(saml);
            DomUtilities.evaluateXPath(doc, "//xenc:EncryptedData/xenc:CipherData/xenc:CipherValue").get(0).setTextContent(jTextAreaCipherData.getText());
            saml = XMLHelper.docToString(doc);      
            notifyAllTabs(new SamlCodeEvent(this, saml));
            Logging.getInstance().log(getClass(), "Setting new ciphertext was successfull.", Logging.INFO);
        } catch (XPathExpressionException ex) {
            Logging.getInstance().log(getClass(), ex);
        }
    }//GEN-LAST:event_jButtonEncryptXMLActionPerformed

    private void jComboBoxSymmetricAlgoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSymmetricAlgoActionPerformed
        checkKeyLength();
        updateHexData();
    }//GEN-LAST:event_jComboBoxSymmetricAlgoActionPerformed

    /**
     * Is called every time new Code is available.
     *
     * @param evt {@link de.rub.nds.burp.utilities.listeners.AbstractCodeEvent}
     * The new source code.
     */
    @Override
    public void setCode(AbstractCodeEvent evt) {
        this.saml = evt.getCode();
        // Set certificate if available
        NodeList list = XMLHelper.stringToDom(saml).getElementsByTagNameNS("*", "X509Certificate");
        if(list.getLength() > 0) {
            jTextAreaCertificate.setText("-----BEGIN CERTIFICATE-----\n" + list.item(0).getTextContent() + "\n-----END CERTIFICATE-----");
        } else {
             jTextAreaCertificate.setText("-----BEGIN CERTIFICATE-----\n" + "\n" + "\n-----END CERTIFICATE-----");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEncryptSymmetricKey;
    private javax.swing.JButton jButtonEncryptXML;
    private javax.swing.JComboBox<String> jComboBoxPublicAlgo;
    private javax.swing.JComboBox<String> jComboBoxSymmetricAlgo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelWarningBlockSize;
    private javax.swing.JLabel jLabelWarningKeySize;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextAreaCertificate;
    private javax.swing.JTextArea jTextAreaCipherData;
    private javax.swing.JTextArea jTextAreaEncryptedKey;
    private javax.swing.JTextArea jTextAreaSymmetricKey;
    private javax.swing.JTextArea jTextAreaXmlData;
    private javax.swing.JTextArea jTextAreaXmlHex;
    private javax.swing.ButtonGroup sysPubButtonGroup;
    // End of variables declaration//GEN-END:variables

    private void initEditorsAndListener() {
        // Init jComboBoxes
        jComboBoxPublicAlgo.setModel(new DefaultComboBoxModel(AsymmetricAlgorithm.getURIs()));
        jComboBoxPublicAlgo.setSelectedIndex(0);
        jComboBoxSymmetricAlgo.setModel(new DefaultComboBoxModel(SymmetricAlgorithm.getURIs()));
        jComboBoxSymmetricAlgo.setSelectedIndex(0);
        // Set listeners for jTextares
        jTextAreaXmlData.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateHexData();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateHexData();
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                updateHexData();
            }
        });
        jTextAreaSymmetricKey.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                checkKeyLength();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                checkKeyLength();
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                checkKeyLength();
            }
        });
        jTextAreaXmlHex.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                checkBlocksize();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                checkBlocksize();
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                checkBlocksize();
            }
        });
        // Update jLabels and jTextareas
        checkKeyLength();
        updateHexData();
    }

    private void checkKeyLength() {
        int requiredSize = SymmetricAlgorithm.getByURI(jComboBoxSymmetricAlgo.getItemAt(jComboBoxSymmetricAlgo.getSelectedIndex())).getKeyLength();
        int size = requiredSize - jTextAreaSymmetricKey.getText().replaceAll("\\s", "").length()*4; 
        if (size != 0) {
            jLabelWarningKeySize.setText("Need " + requiredSize/8 + " byte for encryption!");
            jButtonEncryptXML.setEnabled(false);
        } else {
            jLabelWarningKeySize.setText("");
            jButtonEncryptXML.setEnabled(true);
        }
    }
    
    private void checkBlocksize() {
        SymmetricAlgorithm algorithm = SymmetricAlgorithm.getByURI(jComboBoxSymmetricAlgo.getItemAt(jComboBoxSymmetricAlgo.getSelectedIndex()));
        if(!algorithm.isUsingGCMMode()) {
            int blocksize = algorithm.getBlockSize();
            int length = jTextAreaXmlHex.getText().replaceAll("\\s", "").length();
            if(length % blocksize != 0) {
                jLabelWarningBlockSize.setText("Input length not multiple of "+ blocksize +" bytes!");
                jButtonEncryptXML.setEnabled(false);
            } else {
                jLabelWarningBlockSize.setText("");
                jButtonEncryptXML.setEnabled(true);
            }
        }
    }
    
    private void updateHexData() {
        String algorithmURI = jComboBoxSymmetricAlgo.getItemAt(jComboBoxSymmetricAlgo.getSelectedIndex());
        SymmetricAlgorithm algorithm = SymmetricAlgorithm.getByURI(algorithmURI);
        byte[] xml = jTextAreaXmlData.getText().getBytes();
        byte[] padding = xmlEncryptionHelper.computePadding(xml, algorithm);
        byte[] data = ByteArrayHelper.concatenate(xml, padding);
        jTextAreaXmlHex.setText(ByteArrayHelper.bytesToHexString(data));        
    }
    
    /**
     * Set the listener for the editor.
     *
     * @param listeners
     * {@link de.rub.nds.burp.utilities.listeners.CodeListenerController}
     */
    @Override
    public void setListener(CodeListenerController listeners) {
        this.listeners = listeners;
        this.listeners.addCodeListener(this);
    }

    /**
     * Notify all registered listeners with the new code.
     *
     * @param code The new source code.
     */
    @Override
    public void notifyAllTabs(AbstractCodeEvent evt) {
        if(listeners != null){
            listeners.notifyAll(evt);
        }
    }
}
