package ru.ssau.tk.ArtKsenInc.OOP_JAVA.ui.settings_windows;

import ru.ssau.tk.ArtKsenInc.OOP_JAVA.functions.TabulatedFunction;
import ru.ssau.tk.ArtKsenInc.OOP_JAVA.operations.TabulatedFunctionOperationService;
import ru.ssau.tk.ArtKsenInc.OOP_JAVA.ui.TabulatedFunctionByArraysWindow;
import ru.ssau.tk.ArtKsenInc.OOP_JAVA.ui.TabulatedFunctionByMathFunctionWindow;

import javax.swing.*;
import java.awt.*;

public class SettingsWindowChooseTheWayCreateTF extends JDialog {
    private TabulatedFunction function;
    private final TabulatedFunctionOperationService factoryService;
    private JFrame owner;
    public SettingsWindowChooseTheWayCreateTF(JFrame owner, TabulatedFunctionOperationService factoryService) {
        super(owner, "Создание табулированной функции", true);  // Модальное окно
        this.owner = owner;
        this.factoryService = factoryService;
        setSize(500, 100);
        setLocationRelativeTo(owner);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Кнопка для открытия окна TabulatedFunctionByArraysWindow
        JButton arrayFactoryButton = new JButton("Создать функцию по массивам");
        arrayFactoryButton.addActionListener(_ -> openTabulatedFunctionByArraysWindow());

        // Кнопка для открытия окна TabulatedFunctionByMathFunctionWindow
        JButton listFactoryButton = new JButton("Создать функцию по математической функции");
        listFactoryButton.addActionListener(_ -> openTabulatedFunctionByMathFunctionWindow());

        JPanel panel = new JPanel();
        panel.add(arrayFactoryButton);
        panel.add(listFactoryButton);

        add(panel, BorderLayout.CENTER);
    }

    // Метод для открытия окна TabulatedFunctionByArraysWindow
    private void openTabulatedFunctionByArraysWindow() {
        TabulatedFunctionByArraysWindow arraysWindow = new TabulatedFunctionByArraysWindow(owner, factoryService.getFactory());
        function = arraysWindow.getTabulatedFunction(); // Получаем функцию после закрытия окна
        dispose(); // Закрываем текущее окно после выбора
    }

    // Метод для открытия окна TabulatedFunctionByMathFunctionWindow
    private void openTabulatedFunctionByMathFunctionWindow() {
        TabulatedFunctionByMathFunctionWindow mathWindow = new TabulatedFunctionByMathFunctionWindow(owner, factoryService.getFactory());
        function = mathWindow.getTabulatedFunction(); // Получаем функцию после закрытия окна
        dispose(); // Закрываем текущее окно после выбора
    }

    public TabulatedFunction getTabulatedFunction() {
        return function;  // Возвращаем выбранную или созданную функцию
    }
}
