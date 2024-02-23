package ejemplo1;

/**
 *
 * @author coxla
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    private JTextField usernameFiel;
    private JPasswordField passwordFiel;

    public Login() {
        
        
        //Etiqueta de bienvenida 
        JLabel titleLabel= new JLabel("Welcome");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20));
        titleLabel.setBounds(200, 10, 100, 30);
        this.add(titleLabel);

        //Cargar la imagen
        ImageIcon imagenIcon_xd = new ImageIcon(getClass().getResource("../imgs/login.png"));

        Image imageDemension = imagenIcon_xd.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        ImageIcon adjustedImageIcon = new ImageIcon(imageDemension);

        //JLabel Para mostrar la imagen
        JLabel imageLabel = new JLabel(adjustedImageIcon);
        imageLabel.setBounds(190, 30, 120, 100);
        this.add(imageLabel);

        //Etiqueta para el nombre de usuario
        JLabel usernameLabel = new JLabel("Código");
        usernameLabel.setBounds(70, 140, 80, 20);
        this.add(usernameLabel);
        //Campi de texto para el nombre del usuario
        usernameFiel = new JTextField();
        usernameFiel.setBounds(130, 140, 260, 25); //(x, y, width, height)
        this.add(usernameFiel);

        //Etiqeuta para la contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(50, 180, 80, 25);
        this.add(passwordLabel);
        //Campo para la contraseña
        passwordFiel = new JPasswordField();
        passwordFiel.setBounds(130, 180, 260, 25);
        this.add(passwordFiel);

        //--------------------
        //Boton de inicio de sesión
        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(180, 220, 150, 25);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(43, 191, 19));
        loginButton.addActionListener(this);
        this.add(loginButton);

        // Botón de Registro
        JButton registerButton = new JButton("Registrarse");
        registerButton.setBounds(180, 260, 150, 25); //Ajuste de posición
        registerButton.setBackground(new Color(214, 225, 50)); // Ajuste de color de boton, con color en RGB
        registerButton.addActionListener(this); // Agregamos un ActionListener al botón
        this.add(registerButton);

        //Creacion de la ventana de inicio
        this.setTitle("Login");
        this.setSize(500, 350);
        //this.setBounds(650, 400, 500, 350); //(x, y, width, height)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent Ae) {
        if (Ae.getActionCommand().equals("Iniciar Sesión")) {
            String username = usernameFiel.getText();
            String pwd = new String(passwordFiel.getPassword());
            System.out.println("Usuario: "+ username);
            System.out.println("Contraseña:" +pwd);
        } else if (Ae.getActionCommand().equals("Registrarse")) {
            System.out.println("Aquí debería hacerse el registro");
        }
    }

}
