import javax.swing.*;
import java.awt.*;

public class MainApp extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);

    public MainApp() {
        setupUI();
        showMainPage();
    }

    private void setupUI() {
        setTitle("고령층을 위한 스마트폰 학습 앱");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel.add(new MainPage(this), "MainPage");
        mainPanel.add(new LearningMaterialsPage(this), "LearningMaterialsPage");
        mainPanel.add(new LearningPage(this), "LearningPage");
        mainPanel.add(new QuizPage(this), "QuizPage");
        mainPanel.add(new ProgressPage(this), "ProgressPage");

        add(mainPanel);
    }

    public void showMainPage() {
        cardLayout.show(mainPanel, "MainPage");
    }

    public void showLearningMaterialsPage() {
        cardLayout.show(mainPanel, "LearningMaterialsPage");
    }

    public void showLearningPage() {
        cardLayout.show(mainPanel, "LearningPage");
    }

    public void showQuizPage() {
        cardLayout.show(mainPanel, "QuizPage");
    }

    public void showProgressPage() {
        cardLayout.show(mainPanel, "ProgressPage");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApp().setVisible(true));
    }
}
