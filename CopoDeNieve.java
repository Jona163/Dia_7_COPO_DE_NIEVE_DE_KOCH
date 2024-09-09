import javax.swing.*;
import java.awt.*;

/*
 @Jony
 * Programa para generar la curva de Koch (Copo de nieve)
 */

public class CopoDeNieve extends JPanel {
    double sin60 = Math.sin(Math.PI / 3.0);  // Valor de sin(60 grados)
    int nivel_de_recursividad = 5;  // Nivel de profundidad para el fractal

    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Copo de nieve de Koch");
        CopoDeNieve panel = new CopoDeNieve();

        // Configurar el marco de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);  // Tamaño de la ventana
        frame.add(panel);  // Agregar el panel que dibujará el fractal
        frame.setVisible(true);  // Hacer visible la ventana
    }

  @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
