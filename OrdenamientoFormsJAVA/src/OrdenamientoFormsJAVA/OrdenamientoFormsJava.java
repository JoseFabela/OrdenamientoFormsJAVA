package OrdenamientoFormsJAVA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class OrdenamientoFormsJava extends JFrame {
	private static final long serialVersionUID = 1L;

    private JComboBox<String> sortingAlgorithmComboBox;
    private JList<String> armyListBox;

    public OrdenamientoFormsJava() {
        // Configuración de la ventana principal
        setTitle("Army Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Configuración del ComboBox para seleccionar el algoritmo de ordenamiento
        sortingAlgorithmComboBox = new JComboBox<>(getSortingAlgorithmNames());
        add(sortingAlgorithmComboBox);

        // Configuración de la JList para mostrar la lista de unidades
        armyListBox = new JList<>();
        add(armyListBox);

        // Configuración del botón para ejecutar el juego
        JButton runGameButton = new JButton("Run Game");
        runGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGame();
            }
        });
        add(runGameButton);

        // Muestra la ventana
        setVisible(true);
    }

    private void runGame() {
        List<Unit> army = generateArmy();

        // Obtiene el algoritmo de ordenamiento seleccionado
        ISortAlgorithm<Unit> sortingAlgorithm = getSortingAlgorithm(sortingAlgorithmComboBox.getSelectedIndex() + 1);

        // Ordena el ejército si se seleccionó un algoritmo válido
        if (sortingAlgorithm != null) {
            army = sortingAlgorithm.sort(army, (u1, u2) -> u1.compareTo(u2));

            // Muestra el ejército ordenado en la JList
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (Unit unit : army) {
                listModel.addElement(unit.toString());
            }
            armyListBox.setModel(listModel);
        }
    }

    private String[] getSortingAlgorithmNames() {
        // Retorna los nombres de los algoritmos de ordenamiento
        return new String[]{"Shell Sort", "Selection Sort", "HeapSort", "QuickSort", "BubbleSort",
                "CocktailSort", "InsertionSort", "BucketSort", "CountingSort", "MergeSort",
                "BinaryTreeSort", "RadixSort", "GnomeSort", "NaturalMergeSort", "StraightMergeSort"};
    }

    private ISortAlgorithm<Unit> getSortingAlgorithm(int choice) {
        // Retorna la instancia del algoritmo de ordenamiento seleccionado
        switch (choice) {
            case 1:
                return new ShellSort<>();
            case 2:
                return new SelectionSort<>();
            case 3:
                return new HeapSort<>();
            case 4:
                return new QuickSort<>();
            case 5:
                return new BubbleSort<>();
            case 6:
                return new CocktailSort<>();
            case 7:
                return new InsertionSort<>();
            case 8:
                return new BucketSort<>();
            case 9:
                return new CountingSort<>();
            case 10:
                return new MergeSort<>();
            case 11:
                return new BinaryTreeSort<>();
            case 12:
                return new RadixSort<>();
            case 13:
                return new GnomeSort<>();
            case 14:
                return new NaturalMergeSort<>();
            case 15:
                return new StraightMergeSort<>();
            // Agrega más casos para los demás algoritmos de ordenamiento
            default:
                return null;
        }
    }

    
    

    private List<Unit> generateArmy() {
        List<Unit> army = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            String name = "Unit" + i;
            int level = random.nextInt(10) + 1;
            int attackPower = random.nextInt(100) + 1;
            int speed = random.nextInt(50) + 1;

            Unit unit = new Unit(name, level, attackPower, speed);
            army.add(unit);
        }

        return army;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OrdenamientoFormsJava());
    }
}



