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

      // Coordenadas del triángulo inicial (copo de nieve)
        double xp1 = 400, yp1 = 100;
        double xp2 = 200, yp2 = 500;
        double xp3 = 600, yp3 = 500;

        // Dibujar las tres aristas del triángulo inicial recursivamente
        paintKoch(g, nivel_de_recursividad, xp1, yp1, xp2, yp2);
        paintKoch(g, nivel_de_recursividad, xp2, yp2, xp3, yp3);
        paintKoch(g, nivel_de_recursividad, xp3, yp3, xp1, yp1);
    }
  // Método recursivo para dibujar la curva de Koch
    private void paintKoch(Graphics g, int nivel, double xp1, double yp1, double xp2, double yp2) {
        if (nivel == 0) {
            g.setColor(Color.RED);  // Establecer el color rojo para el dibujo
            // Caso base: dibujar una línea entre dos puntos
            g.drawLine((int) xp1, (int) yp1, (int) xp2, (int) yp2);
         } else {
            // Dividir el segmento en tres partes
            double dx = (xp2 - xp1) / 3.0;
            double dy = (yp2 - yp1) / 3.0;

            // Puntos intermedios
            double x1 = xp1 + dx;
            double y1 = yp1 + dy;
            double x2 = xp1 + 2 * dx;
            double y2 = yp1 + 2 * dy;

       // Calcular el vértice del triángulo equilátero
            double xx = (x1 + x2) / 2 - (dy * sin60);
            double yy = (y1 + y2) / 2 + (dx * sin60);
          // Llamadas recursivas para cada uno de los 4 nuevos segmentos
            paintKoch(g, nivel - 1, xp1, yp1, x1, y1);
            paintKoch(g, nivel - 1, x1, y1, xx, yy);

      paintKoch(g, nivel - 1, xx, yy, x2, y2);
            paintKoch(g, nivel - 1, x2, y2, xp2, yp2);
