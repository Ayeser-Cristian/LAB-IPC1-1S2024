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
        
        
        // Etiqueta con el título "Login"
        JLabel titleLabel= new JLabel("Welcome");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20)); // Establece el tipo de letra y el tamaño
        titleLabel.setBounds(200, 10, 100, 30); // Posición y tamaño (x, y, width, height)
        /*
        x: La posición horizontal de la esquina superior izquierda de la ventana en píxeles desde el borde izquierdo de la pantalla.
        y: La posición vertical de la esquina superior izquierda de la ventana en píxeles desde la parte superior de la pantalla.
        width: El ancho de la ventana en píxeles.
        height: La altura de la ventana en píxeles.
         */
        this.add(titleLabel);

        //Cargar la imagen
        ImageIcon imagenIcon_xd = new ImageIcon(getClass().getResource("../imgs/login.png"));
        
        // Ajusta el tamaño de la imagen, es decir, redimencionar
        Image imageDemension = imagenIcon_xd.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        // Crear un nuevo ImageIcon con la imagen ajustada
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
        loginButton.setBounds(180, 220, 150, 25); //Ajuste de posición
        loginButton.setForeground(Color.WHITE); // Ajuste de color de letra
        loginButton.setBackground(new Color(43, 191, 19)); // Ajuste de color de boton, con color en RGB
        loginButton.addActionListener(this); // Agregamos un ActionListener al botón
        this.add(loginButton);

        // Botón de Registro
        JButton registerButton = new JButton("Registrarse");
        registerButton.setBounds(180, 260, 150, 25); //Ajuste de posición
        registerButton.setBackground(new Color(214, 225, 50)); // Ajuste de color de boton, con color en RGB
        registerButton.addActionListener(this); // Agregamos un ActionListener al botón
        this.add(registerButton);

        //Creacion de la ventana de inicio
        this.setTitle("Login");  // Título de la ventana
        this.setSize(500, 350);//Tamaño de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        this.setLayout(null); // Diseño nulo (sin diseño predeterminado), para poder posicionar los componentes donde queramos
        this.setResizable(false);  // No permite redimensionar la ventana
        this.setLocationRelativeTo(null); //Despliega la ventana en el centro de la pantalla
        this.setVisible(true); // Hace visible la ventana

    }

    @Override
    public void actionPerformed(ActionEvent Ae) {
        if (Ae.getActionCommand().equals("Iniciar Sesión")) {
            String username = usernameFiel.getText();
            String pwd = new String(passwordFiel.getPassword());
            System.out.println("Usuario: "+ username);
            System.out.println("Contraseña:" +pwd);
            
            if(username.equals("admin") && pwd.equals("123")){
               Administrador vtn_admin = new Administrador();
               this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "User and/or password incorrect.", "Error con el LOGIN", 0);
            }
            
        } else if (Ae.getActionCommand().equals("Registrarse")) {
            System.out.println("Aquí debería hacerse el registro");
        }
    }

}
