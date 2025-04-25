import java.util.Scanner;

public class CalculadoraProPro {

    static Scanner entrada = new Scanner(System.in);
    static double[] resultados = new double[100];
    static int contadorResultados = 0;

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            try {
                mostrarMenuFiguras();
                int figura = Integer.parseInt(entrada.nextLine());

                System.out.println("\nSeleccione la operacion:");
                System.out.println("1. Area");
                System.out.println("2. Perimetro");
                System.out.println("3. Potencia");
                System.out.print("Opcion: ");
                int operacion = Integer.parseInt(entrada.nextLine());

                double resultado = ejecutarOperacion(figura, operacion);
                guardarResultado(resultado);
                System.out.println("Resultado: " + resultado);

            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese solo números válidos.");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }

            System.out.print("\n¿Desea realizar otra operación? (s/n): ");
            String respuesta = entrada.nextLine().toLowerCase();
            continuar = respuesta.equals("s");
        }

        mostrarResultados();
        System.out.println("Gracias por usar la calculadora.");
    }

    // Muestra las figuras disponibles
    public static void mostrarMenuFiguras() {
        System.out.println("\nSeleccione la figura:");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono");
    }

    // Ejecuta la operación elegida
    public static double ejecutarOperacion(int figura, int operacion) {
        switch (operacion) {
            case 1: return calcularArea(figura);
            case 2: return calcularPerimetro(figura);
            case 3: return calcularPotencia();
            default: 
                System.out.println("Operación no válida.");
                return 0;
        }
    }

    
    public static double calcularArea(int figura) {
        switch (figura) {
            case 1:
                System.out.print("Radio: ");
                double radio = Double.parseDouble(entrada.nextLine());
                return Math.PI * radio * radio;
            case 2:
                System.out.print("Lado: ");
                double lado = Double.parseDouble(entrada.nextLine());
                return lado * lado;
            case 3:
                System.out.print("Base: ");
                double base = Double.parseDouble(entrada.nextLine());
                System.out.print("Altura: ");
                double altura = Double.parseDouble(entrada.nextLine());
                return (base * altura) / 2;
            case 4:
                System.out.print("Base: ");
                double baseR = Double.parseDouble(entrada.nextLine());
                System.out.print("Altura: ");
                double alturaR = Double.parseDouble(entrada.nextLine());
                return baseR * alturaR;
            case 5:
                System.out.print("Lado: ");
                double ladoP = Double.parseDouble(entrada.nextLine());
                return (5 * ladoP * ladoP) / (4 * Math.tan(Math.PI / 5));
            default:
                System.out.println("Figura no válida.");
                return 0;
        }
    }

    
    public static double calcularPerimetro(int figura) {
        switch (figura) {
            case 1:
                System.out.print("Radio: ");
                double radio = Double.parseDouble(entrada.nextLine());
                return 2 * Math.PI * radio;
            case 2:
                System.out.print("Lado: ");
                double lado = Double.parseDouble(entrada.nextLine());
                return 4 * lado;
            case 3:
                System.out.print("Lado 1: ");
                double l1 = Double.parseDouble(entrada.nextLine());
                System.out.print("Lado 2: ");
                double l2 = Double.parseDouble(entrada.nextLine());
                System.out.print("Lado 3: ");
                double l3 = Double.parseDouble(entrada.nextLine());
                return l1 + l2 + l3;
            case 4:
                System.out.print("Base: ");
                double baseR = Double.parseDouble(entrada.nextLine());
                System.out.print("Altura: ");
                double alturaR = Double.parseDouble(entrada.nextLine());
                return 2 * (baseR + alturaR);
            case 5:
                System.out.print("Lado: ");
                double ladoP = Double.parseDouble(entrada.nextLine());
                return 5 * ladoP;
            default:
                System.out.println("Figura no válida.");
                return 0;
        }
    }

    // Método para calcular potencia recursivamente
    public static double calcularPotencia() {
        System.out.print("Ingrese la base: ");
        int base = Integer.parseInt(entrada.nextLine());
        System.out.print("Ingrese el exponente (entero >= 0): ");
        int exponente = Integer.parseInt(entrada.nextLine());
        return potenciaRecursiva(base, exponente);
    }

    public static int potenciaRecursiva(int base, int exponente) {
        if (exponente == 0) return 1;
        return base * potenciaRecursiva(base, exponente - 1);
    }

    
    public static void guardarResultado(double resultado) {
        resultados[contadorResultados] = resultado;
        contadorResultados++;
    }

    
    public static void mostrarResultados() {
        System.out.println("\n--- Resultados almacenados ---");
        for (int i = 0; i < contadorResultados; i++) {
            System.out.println("Operación " + (i + 1) + ": " + resultados[i]);
        }
    }
}
