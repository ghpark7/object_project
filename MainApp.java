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

        customizeButtons();

        add(mainPanel);
    }

    // 버튼 스타일 변경 메서드
    private void customizeButtons() {
        UIManager.put("Button.background", Color.PINK); // 버튼 배경색을 파란색으로 설정
        UIManager.put("Button.foreground", Color.WHITE); // 버튼 텍스트 색상을 흰색으로 설정
        UIManager.put("Button.font", new Font("함초롬돋움", Font.BOLD, 14)); // 버튼 폰트 변경
        mainPanel.setBackground(new Color(255, 255, 255)); // 메인 패널 배경색을 흰색으로 설정
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

    // CameraPage를 생성하여 보여줄 수 있도록 코드 작성
    public void showCameraPage() {
        CameraPage cameraPage = new CameraPage(this);
        mainPanel.add(cameraPage, "CameraPage"); // 메인 패널에 CameraPage 추가
        cardLayout.show(mainPanel, "CameraPage"); // CameraPage로 이동
    }
}
