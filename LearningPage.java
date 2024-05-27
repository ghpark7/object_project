import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LearningPage extends JPanel {
    private MainApp mainApp;
    private List<LearningContent> learningContents;

    public LearningPage(MainApp mainApp) {
        this.mainApp = mainApp;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        // 학습 콘텐츠 목록을 생성
        learningContents = new ArrayList<>();
        learningContents.add(new LearningContent("앱 검색하기", "스마트폰에서 앱을 검색하는 방법을 학습합니다."));
        learningContents.add(new LearningContent("문자 보내기", "문자 메시지를 보내는 방법을 학습합니다."));
        learningContents.add(new LearningContent("카메라 사용하기", "스마트폰 카메라를 사용하는 방법을 학습합니다."));
        learningContents.add(new LearningContent("카카오톡 사용하기", "카카오톡을 사용하는 방법을 학습합니다."));
        learningContents.add(new LearningContent("앱 설치하기", "앱을 설치하는 방법을 학습합니다."));

        JPanel contentPanel = new JPanel(new GridLayout(learningContents.size(), 1, 10, 10));
        for (LearningContent content : learningContents) {
            JButton contentButton = new JButton(content.getTitle());
            contentButton.setToolTipText(content.getDescription());
            contentButton.addActionListener(e -> JOptionPane.showMessageDialog(this, content.getDescription(), content.getTitle(), JOptionPane.INFORMATION_MESSAGE));
            contentPanel.add(contentButton);
        }

        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> mainApp.showMainPage());

        add(new JLabel("오늘의 학습", JLabel.CENTER), BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }
}
