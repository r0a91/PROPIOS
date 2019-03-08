
import java.util.*;
import java.io.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;

public class OrderManager extends JFrame {

    public static final String newline = "\n";
    public static final String GET_TOTAL = "Get Total";
    public static final String CREATE_ORDER = "Create Order";
    public static final String EDIT_ORDER = "Editar Orden";
    public static final String GUARDAR_ORDER = "Guardar";
    public static final String EXIT = "Exit";
    public static final String CA_ORDER = "California Order";
    public static final String NON_CA_ORDER
            = "Non-California Order";

    public static final String OVERSEAS_ORDER = "Overseas Order";

    private JComboBox cmbOrderType;
    private JTextField txtOrderAmount, txtAdditionalTax,
            txtAdditionalSH, editar;
    private JLabel lblOrderType, lblOrderAmount, numeroOrden;
    private JLabel lblAdditionalTax, lblAdditionalSH;
    private JLabel lblTotal, lblTotalValue;
    JButton getTotalButton, createOrderButton, exitButton, editarButton, guardarButton;

    private OrderVisitor objVisitor;

    public OrderManager() {
        super("Visitor Pattern - Example");

        //Create the visitor instance
        objVisitor = new OrderVisitor();

        cmbOrderType = new JComboBox();
        cmbOrderType.addItem(OrderManager.CA_ORDER);
        cmbOrderType.addItem(OrderManager.NON_CA_ORDER);
        cmbOrderType.addItem(OrderManager.OVERSEAS_ORDER);

        txtOrderAmount = new JTextField(10);
        txtAdditionalTax = new JTextField(10);
        txtAdditionalSH = new JTextField(10);
        editar = new JTextField(10);

        numeroOrden = new JLabel("No 1");
        lblOrderType = new JLabel("Order Type:");
        lblOrderAmount = new JLabel("Order Amount:");
        lblAdditionalTax
                = new JLabel("Additional Tax(CA Orders Only):");
        lblAdditionalSH
                = new JLabel("Additional S & H(Overseas Orders Only):");

        lblTotal = new JLabel("Result:");
        lblTotalValue
                = new JLabel("Click Create or GetTotal Button");

        //Create the open button
        getTotalButton = new JButton(OrderManager.GET_TOTAL);
        getTotalButton.setMnemonic(KeyEvent.VK_G);
        createOrderButton = new JButton(OrderManager.CREATE_ORDER);
        getTotalButton.setMnemonic(KeyEvent.VK_C);
        exitButton = new JButton(OrderManager.EXIT);
        exitButton.setMnemonic(KeyEvent.VK_X);
        editarButton = new JButton(OrderManager.EDIT_ORDER);
        editarButton.setMnemonic(KeyEvent.VK_V);
        guardarButton = new JButton(OrderManager.GUARDAR_ORDER);
        guardarButton.setMnemonic(KeyEvent.VK_N);
        ButtonHandler objButtonHandler = new ButtonHandler(this);

        getTotalButton.addActionListener(objButtonHandler);
        createOrderButton.addActionListener(objButtonHandler);
        editarButton.addActionListener(objButtonHandler);
        guardarButton.addActionListener(objButtonHandler);
        exitButton.addActionListener(new ButtonHandler());

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel();

        JPanel panel = new JPanel();
        GridBagLayout gridbag2 = new GridBagLayout();
        panel.setLayout(gridbag2);
        GridBagConstraints gbc2 = new GridBagConstraints();
        panel.add(getTotalButton);
        panel.add(createOrderButton);
        panel.add(exitButton);
        panel.add(editar);
        panel.add(editarButton);
        panel.add(guardarButton);
        gbc2.anchor = GridBagConstraints.EAST;
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gridbag2.setConstraints(createOrderButton, gbc2);
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gridbag2.setConstraints(getTotalButton, gbc2);
        gbc2.gridx = 2;
        gbc2.gridy = 0;
        gridbag2.setConstraints(exitButton, gbc2);
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gridbag2.setConstraints(editar, gbc2);
        gbc2.gridx = 1;
        gbc2.gridy = 1;
        gridbag2.setConstraints(editarButton, gbc2);
        gbc2.gridx = 2;
        gbc2.gridy = 1;
        gridbag2.setConstraints(guardarButton, gbc2);

        //****************************************************
        GridBagLayout gridbag = new GridBagLayout();
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        buttonPanel.add(lblOrderType);
        buttonPanel.add(cmbOrderType);
        buttonPanel.add(numeroOrden);
        buttonPanel.add(lblOrderAmount);
        buttonPanel.add(txtOrderAmount);
        buttonPanel.add(lblAdditionalTax);
        buttonPanel.add(txtAdditionalTax);
        buttonPanel.add(lblAdditionalSH);
        buttonPanel.add(txtAdditionalSH);
        buttonPanel.add(lblTotal);
        buttonPanel.add(lblTotalValue);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderType, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(cmbOrderType, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gridbag.setConstraints(numeroOrden, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblOrderAmount, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(txtOrderAmount, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gridbag.setConstraints(lblAdditionalTax, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gridbag.setConstraints(txtAdditionalTax, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gridbag.setConstraints(lblAdditionalSH, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gridbag.setConstraints(txtAdditionalSH, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gridbag.setConstraints(lblTotal, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gridbag.setConstraints(lblTotalValue, gbc);

        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 40;

        //****************************************************
        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();

        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(panel, BorderLayout.CENTER);
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
            SwingUtilities.updateComponentTreeUI(
                    OrderManager.this);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static void main(String[] args) {
        JFrame frame = new OrderManager();

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }
        );

        //frame.pack();
        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    public void setTotalValue(String msg) {
        lblTotalValue.setText(msg);
    }

    public OrderVisitor getOrderVisitor() {
        return objVisitor;
    }

    public String getOrderType() {
        return (String) cmbOrderType.getSelectedItem();
    }

    public String getOrderAmount() {
        return txtOrderAmount.getText();
    }

    public String getTax() {
        return txtAdditionalTax.getText();
    }

    public String getSH() {
        return txtAdditionalSH.getText();
    }

    public void setOrderAmount(String monto) {
        txtOrderAmount.setText(monto);
    }

    public void setTax(String monto) {
        txtAdditionalTax.setText(monto);
    }

    public void setSH(String monto) {
        txtAdditionalSH.setText(monto);
    }

    public void setNumeorOrden(int numero) {
        this.numeroOrden.setText("No " + numero);
    }

    public String getValorEditar() {
        return editar.getText();
    }

    public void desactivarBoton(int caso) {
        switch (caso) {
            case 1: {//activar editar
                guardarButton.setEnabled(true);
                createOrderButton.setEnabled(false);
                break;
            }
            case 2: {
                guardarButton.setEnabled(false);
                createOrderButton.setEnabled(true);
                break;
            }

        }
        repaint();

    }

} // End of class OrderManager

class ButtonHandler implements ActionListener {

    OrderManager objOrderManager;
    private Map<String, Order> coleccion;

    public void actionPerformed(ActionEvent e) {

        String totalResult = null;

        if (e.getActionCommand()
                .equals(OrderManager.EXIT)) {
            System.exit(1);
        }

        if (e.getActionCommand()
                .equals(OrderManager.CREATE_ORDER)) {
            //get input values
            String orderType = objOrderManager.getOrderType();
            String strOrderAmount
                    = objOrderManager.getOrderAmount();
            String strTax = objOrderManager.getTax();
            String strSH = objOrderManager.getSH();

            double dblOrderAmount = 0.0;
            double dblTax = 0.0;
            double dblSH = 0.0;

            if (strOrderAmount.trim().length() == 0) {
                strOrderAmount = "0.0";
            }
            if (strTax.trim().length() == 0) {
                strTax = "0.0";
            }
            if (strSH.trim().length() == 0) {
                strSH = "0.0";
            }

            dblOrderAmount = new Double(strOrderAmount).doubleValue();
            dblTax = new Double(strTax).doubleValue();
            dblSH = new Double(strSH).doubleValue();

            //Create the order
            Order order = createOrder(orderType, dblOrderAmount,
                    dblTax, dblSH);

            //Get the Visitor
            /*OrderVisitor visitor
                    = objOrderManager.getOrderVisitor();

            // accept the visitor instance
            order.accept(visitor);*/
            coleccion.put(coleccion.size() + 1 + "", order);
            objOrderManager.setNumeorOrden(coleccion.size() + 1);
            objOrderManager.setTotalValue("Order Created Successfully");
            objOrderManager.setOrderAmount("");
            objOrderManager.setTax("");
            objOrderManager.setSH("");

        }

        if (e.getActionCommand()
                .equals(OrderManager.GET_TOTAL)) {
            //Get the Visitor
            /*OrderVisitor visitor
                    = objOrderManager.getOrderVisitor();
            totalResult = new Double(
                    visitor.getOrderTotal()).toString();
            totalResult = " Orders Total = " + totalResult;
            objOrderManager.setTotalValue(totalResult);*/
            obtenerTotal();
        }

        if (e.getActionCommand()
                .equals(OrderManager.EDIT_ORDER)) {
            editarOrden();
        }
        if (e.getActionCommand()
                .equals(OrderManager.GUARDAR_ORDER)) {
            guardarOrden();
        }
    }

    public void obtenerTotal() {
        double total = 0;
        OrderVisitor visitor;
        AllOrders ao = new AllOrders(coleccion);
        while (ao.hasNext()) {
            Order order = (Order) ao.next();

            visitor = objOrderManager.getOrderVisitor();

            // accept the visitor instance
            total = total + order.accept(visitor);
        }
        objOrderManager.setTotalValue(total + "");
    }

    public void editarOrden() {
        String numeroOrdens = objOrderManager.getValorEditar();
        if (!numeroOrdens.isEmpty()) {
            if (coleccion.containsKey(numeroOrdens)) {
                Order orden = coleccion.get(numeroOrdens);
                if (orden instanceof OverseasOrder) {
                    OverseasOrder oo = (OverseasOrder) orden;
                    objOrderManager.setOrderAmount(oo.getOrderAmount() + "");
                    objOrderManager.setSH(oo.getAdditionalSH() + "");
                    objOrderManager.setTax("");
                }
                if (orden instanceof CaliforniaOrder) {
                    CaliforniaOrder co = (CaliforniaOrder) orden;
                    objOrderManager.setOrderAmount(co.getOrderAmount() + "");
                    objOrderManager.setTax(co.getAdditionalTax() + "");
                    objOrderManager.setSH("");
                }
                if (orden instanceof NonCaliforniaOrder) {
                    NonCaliforniaOrder nco = (NonCaliforniaOrder) orden;
                    objOrderManager.setOrderAmount(nco.getOrderAmount() + "");
                    objOrderManager.setTax("");
                    objOrderManager.setSH("");
                }
                objOrderManager.desactivarBoton(1);
            }
        }
    }

    public void guardarOrden() {
        String orderType = objOrderManager.getOrderType();
        String strOrderAmount = objOrderManager.getOrderAmount();
        String strTax = objOrderManager.getTax();
        String strSH = objOrderManager.getSH();

        double dblOrderAmount = 0.0;
        double dblTax = 0.0;
        double dblSH = 0.0;

        if (strOrderAmount.trim().length() == 0) {
            strOrderAmount = "0.0";
        }
        if (strTax.trim().length() == 0) {
            strTax = "0.0";
        }
        if (strSH.trim().length() == 0) {
            strSH = "0.0";
        }

        dblOrderAmount = new Double(strOrderAmount).doubleValue();
        dblTax = new Double(strTax).doubleValue();
        dblSH = new Double(strSH).doubleValue();

        //Create the order
        Order order = createOrder(orderType, dblOrderAmount,
                dblTax, dblSH);

        //Get the Visitor
        /*OrderVisitor visitor
                    = objOrderManager.getOrderVisitor();

            // accept the visitor instance
            order.accept(visitor);*/
        coleccion.put(objOrderManager.getValorEditar() + "", order);
        objOrderManager.setNumeorOrden(coleccion.size() + 1);
        objOrderManager.setTotalValue("Orden modificada satisfactoriamente.");
        objOrderManager.setOrderAmount("");
        objOrderManager.setTax("");
        objOrderManager.setSH("");
        objOrderManager.desactivarBoton(2);
    }

    public Order createOrder(String orderType,
            double orderAmount, double tax, double SH) {
        if (orderType.equalsIgnoreCase(OrderManager.CA_ORDER)) {
            return new CaliforniaOrder(orderAmount, tax);
        }
        if (orderType.equalsIgnoreCase(
                OrderManager.NON_CA_ORDER)) {
            return new NonCaliforniaOrder(orderAmount);
        }
        if (orderType.equalsIgnoreCase(
                OrderManager.OVERSEAS_ORDER)) {
            return new OverseasOrder(orderAmount, SH);
        }
        return null;
    }

    public ButtonHandler() {

    }

    public ButtonHandler(OrderManager inObjOrderManager) {
        objOrderManager = inObjOrderManager;
        coleccion = new HashMap();
    }

} // End of class ButtonHandler

