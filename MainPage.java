import javax.swing.*;
import java.awt.*;

public class MainPage extends JPanel {
    private MainApp mainApp;

    public MainPage(MainApp mainApp) {
        this.mainApp = mainApp;
        setupUI();
    }

    private void setupUI() {
        setLayout(new GridLayout(3, 1, 10, 10));

        JButton learningMaterialsButton = new JButton("학습자료집");
        JButton todayLearningButton = new JButton("오늘의 학습");
        JButton progressButton = new JButton("전체 진도 현황");
        JButton quizButton = new JButton("퀴즈");

        learningMaterialsButton.addActionListener(e -> mainApp.showLearningMaterialsPage());
        todayLearningButton.addActionListener(e -> mainApp.showLearningPage());
        progressButton.addActionListener(e -> mainApp.showProgressPage());
        quizButton.addActionListener(e -> mainApp.showQuizPage());

        add(learningMaterialsButton);
        add(todayLearningButton);
        add(progressButton);
        add(quizButton);
    }
}
