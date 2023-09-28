package br.com.gabriele.alura.hotel.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import controllers.HospedeController;
import modelo.Hospede;

@SuppressWarnings("serial")
public class RegistroHospede extends JFrame {

    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JTextField txtTelefone;
    private JTextField txtNreserva;
    private Component txtDataN;
    private JComboBox<String> txtNacionalidade;
    private JLabel labelExit;
    private JLabel labelAtras;
    int xMouse, yMouse;

    private HospedeController controller;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegistroHospede frame = new RegistroHospede();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
     public RegistroHospede() {
        controller = new HospedeController();

        setIconImage(
                Toolkit.getDefaultToolkit().getImage(RegistroHospede.class.getResource("/img/lOGO-50PX.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 634);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.text);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setUndecorated(true);
        contentPane.setLayout(null);

        JPanel header = new JPanel();
        header.setBounds(-54, 0, 910, 36);
        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                headerMouseDragged(e);

            }
        });
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                headerMousePressed(e);
            }
        });

        JPanel btnexit = new JPanel();
        btnexit.setBounds(857, 0, 53, 36);
        contentPane.add(btnexit);
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuPrincipal principal = new MenuPrincipal();
                principal.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(Color.white);
                labelExit.setForeground(Color.black);
            }
        });
        btnexit.setLayout(null);
        btnexit.setBackground(Color.white);

        labelExit = new JLabel("X");
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setForeground(SystemColor.black);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        header.setLayout(null);
        header.setBackground(SystemColor.text);
        header.setOpaque(false);
        header.setBounds(0, 0, 910, 36);
        contentPane.add(header);

        JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReservasView reservas = new ReservasView();
                reservas.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAtras.setBackground(Color.white);
                labelAtras.setForeground(Color.black);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAtras.setBackground(new Color(12, 138, 199));
                labelAtras.setForeground(Color.white);
            }
        });
        btnAtras.setLayout(null);
        btnAtras.setBackground(new Color(12, 138, 199));
        btnAtras.setBounds(0, 0, 53, 36);
        header.add(btnAtras);

        labelAtras = new JLabel("<");
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setForeground(Color.WHITE);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
        labelAtras.setBounds(0, 0, 53, 36);
        btnAtras.add(labelAtras);

        txtNome = new JTextField();
        txtNome.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtNome.setBounds(560, 135, 285, 33);
        txtNome.setBackground(Color.WHITE);
        txtNome.setColumns(10);
        txtNome.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtNome);

        txtSobrenome = new JTextField();
        txtSobrenome.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtSobrenome.setBounds(560, 204, 285, 33);
        txtSobrenome.setColumns(10);
        txtSobrenome.setBackground(Color.WHITE);
        txtSobrenome.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtSobrenome);

        JDateChooser txtDataN = new JDateChooser();
        txtDataN.setBounds(560, 278, 285, 36);
        txtDataN.getCalendarButton()
                .setIcon(new ImageIcon(RegistroHospede.class.getResource("/img/icon-reservas.png")));
        txtDataN.getCalendarButton().setBackground(SystemColor.textHighlight);
        txtDataN.setDateFormatString("yyyy-MM-dd");
        

        txtNacionalidade = new JComboBox<String>();
        txtNacionalidade.setBounds(560, 350, 289, 36);
        txtNacionalidade.setBackground(SystemColor.text);
        txtNacionalidade.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtNacionalidade.setModel(new DefaultComboBoxModel<String>(new String[] {
            "alemão", "andorrano", "angolano", "antiguano", "saudita", "argelino", "argentino", "armênio",
            "australiano", "austríaco", "azerbaijano", "bahamense", "bangladês, bangladense", "barbadiano",
            "bahreinita", "belga", "belizenho", "beninês", "belarusso", "boliviano", "bósnio", "botsuanês",
            "brasileiro", "bruneíno", "búlgaro", "burkineonse, burkinabé", "burundês", "butanês", "cabo-verdiano",
            "camerounês", "cambojano", "catariano", "canadense", "cazaque", "chadiano", "chileno", "chinês",
            "cipriota", "colombiano", "comoriano", "congolês", "congolês", "sul-coreano", "norte-coreano",
            "costa-marfinense, marfinense", "costa-ricense", "croata", "cubano", "dinamarquês", "djiboutiano",
            "dominiquense", "egípcio", "salvadorenho", "emiradense, emirático", "equatoriano", "eritreu", "eslovaco",
            "esloveno", "espanhol", "estadunidense, (norte-)americano", "estoniano", "etíope", "fijiano",
            "filipino", "finlandês", "francês", "gabonês", "gambiano", "ganês ou ganense", "georgiano", "granadino",
            "grego", "guatemalteco", "guianês", "guineense", "guineense, bissau-guineense", "equato-guineense",
            "haitiano", "hondurenho", "húngaro", "iemenita", "cookiano", "marshallês", "salomonense", "indiano",
            "indonésio", "iraniano", "iraquiano", "irlandês", "islandês", "34", "jamaicano", "japonês", "jordaniano",
            "kiribatiano", "kuwaitiano", "laosiano", "lesotiano", "letão", "libanês", "liberiano", "líbio",
            "liechtensteiniano", "lituano", "luxemburguês", "macedônio", "madagascarense", "malásio", "malawiano",
            "maldivo", "maliano", "maltês", "marroquino", "mauriciano", "mauritano", "mexicano", "myanmarense",
            "micronésio", "moçambicano", "moldovo", "monegasco", "mongol", "montenegrino", "namibiano", "nauruano",
            "nepalês", "nicaraguense", "nigerino", "nigeriano", "niuiano", "norueguês", "neozelandês", "omani",
            "neerlandês", "palauano", "palestino", "panamenho", "papua, papuásio", "paquistanês", "paraguaio",
            "peruano", "polonês, polaco", "português", "queniano", "quirguiz", "britânico", "centro-africano",
            "tcheco", "dominicano", "romeno", "ruandês", "russo", "samoano", "santa-lucense", "são-cristovense",
            "samarinês", "santomense", "são-vicentino", "seichelense", "senegalês", "sérvio", "singapurense", "sírio",
            "somaliano, somali", "sri-lankês", "suázi", "sudanês", "sul-sudanês", "sueco", "suíço", "surinamês",
            "tajique", "tailandês", "tanzaniano", "timorense", "togolês", "tonganês", "trinitário", "tunisiano",
            "turcomeno", "turco", "tuvaluano", "ucraniano", "ugandês", "uruguaio", "uzbeque", "vanuatuense",
            "vaticano", "venezuelano", "vietnamita", "zambiano", "zimbabueano" }));
        contentPane.add(txtNacionalidade);

        JLabel lblNome = new JLabel("NOME");
        lblNome.setBounds(562, 119, 253, 14);
        lblNome.setForeground(SystemColor.textInactiveText);
        lblNome.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNome);

        JLabel lblSobrenome = new JLabel("SOBRENOME");
        lblSobrenome.setBounds(560, 189, 255, 14);
        lblSobrenome.setForeground(SystemColor.textInactiveText);
        lblSobrenome.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblSobrenome);

        JLabel lblDataN = new JLabel("DATA DE NASCIMENTO");
        lblDataN.setBounds(560, 256, 255, 14);
        lblDataN.setForeground(SystemColor.textInactiveText);
        lblDataN.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblDataN);

        JLabel lblNacionalidade = new JLabel("NACIONALIDADE");
        lblNacionalidade.setBounds(560, 326, 255, 14);
        lblNacionalidade.setForeground(SystemColor.textInactiveText);
        lblNacionalidade.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNacionalidade);

        JLabel lblTelefone = new JLabel("TELEFONE");
        lblTelefone.setBounds(562, 406, 255, 14);
        lblTelefone.setForeground(SystemColor.textInactiveText);
        lblTelefone.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtTelefone.setBounds(560, 426, 285, 33);
        txtTelefone.setBackground(Color.WHITE);
        txtTelefone.setColumns(10);
        txtTelefone.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtTelefone);

        JLabel lblNReserva = new JLabel("Nº RESERVA");
        lblNReserva.setBounds(562, 485, 253, 14);
        lblNReserva.setForeground(SystemColor.textInactiveText);
        lblNReserva.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNReserva);

        txtNreserva = new JTextField();
        txtNreserva.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtNreserva.setBounds(560, 506, 285, 33);
        txtNreserva.setBackground(Color.WHITE);
        txtNreserva.setColumns(10);
        txtNreserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtNreserva);

        JLabel lblNewLabel = new JLabel("REGISTRO DE HÓSPEDE");
        lblNewLabel.setBounds(352, 42, 318, 33);
        lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 22));
        lblNewLabel.setForeground(new Color(12, 138, 199));
        contentPane.add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(314, 76, 343, 2);
        separator.setForeground(new Color(12, 138, 199));
        contentPane.add(separator);

        JPanel btnRegistrar = new JPanel();
        btnRegistrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registrarHospede();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnRegistrar.setBackground(new Color(12, 138, 199));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnRegistrar.setBackground(SystemColor.textHighlight);
            }
        });
        btnRegistrar.setLayout(null);
        btnRegistrar.setBackground(SystemColor.textHighlight);
        btnRegistrar.setBounds(560, 563, 285, 46);
        contentPane.add(btnRegistrar);

        JLabel lblRegistrar = new JLabel("Registrar");
        lblRegistrar.setForeground(Color.WHITE);
        lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegistrar.setFont(new Font("Roboto", Font.PLAIN, 16));
        lblRegistrar.setBounds(0, 0, 285, 46);
        btnRegistrar.add(lblRegistrar);
    }

    // Método para registrar um hóspede
    private void registrarHospede() {
        String nome = txtNome.getText();
        String sobrenome = txtSobrenome.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataNascimento = sdf.format(( txtDataN));
        String nacionalidade = (String) txtNacionalidade.getSelectedItem();
        String telefone = txtTelefone.getText();
        String numeroReserva = txtNreserva.getText();

        if (nome.isEmpty() || sobrenome.isEmpty() || dataNascimento.isEmpty() || nacionalidade.isEmpty()
                || telefone.isEmpty() || numeroReserva.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos!", "Campos Vazios",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            Hospede hospede = new Hospede();

            if (controller.registrarHospede(hospede)) {
                JOptionPane.showMessageDialog(this, "Hóspede registrado com sucesso!", "Registro bem-sucedido",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao registrar o hóspede!", "Erro no registro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void headerMousePressed(MouseEvent e) {
        xMouse = e.getX();
        yMouse = e.getY();
    }

    private void headerMouseDragged(MouseEvent e) {
        int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        setLocation(x - xMouse, y - yMouse);
    }
}

