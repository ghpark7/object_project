import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LearningMaterialsPage extends JPanel {
    private MainApp mainApp;
    private List<LearningContent> learningMaterials;

    public LearningMaterialsPage(MainApp mainApp) {
        this.mainApp = mainApp;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        // 학습자료 목록 생성
        learningMaterials = new ArrayList<>();
        learningMaterials.add(new LearningContent("스마트폰 앱 검색", "스마트폰에서 앱을 검색하는 방법에 대한 상세 가이드."));
        learningMaterials.add(new LearningContent("문자 보내기", "문자 메시지를 보내는 방법에 대한 상세 가이드."));
        learningMaterials.add(new LearningContent("카메라 사용", "스마트폰 카메라를 사용하는 방법에 대한 상세 가이드."));
        learningMaterials.add(new LearningContent("카카오톡 사용", "카카오톡을 사용하는 방법에 대한 상세 가이드."));
        learningMaterials.add(new LearningContent("앱 설치", "앱을 설치하는 방법에 대한 상세 가이드."));

        JPanel materialsPanel = new JPanel(new GridLayout(learningMaterials.size(), 1, 10, 10));
        for (LearningContent material : learningMaterials) {
            JButton materialButton = new JButton(material.getTitle());
            materialButton.setToolTipText(material.getDescription());
            materialButton.addActionListener(e -> JOptionPane.showMessageDialog(this, material.getDescription(), material.getTitle(), JOptionPane.INFORMATION_MESSAGE));
            materialsPanel.add(materialButton);
        }

        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> mainApp.showMainPage());

        add(new JLabel("학습자료집", JLabel.CENTER), BorderLayout.NORTH);
        add(materialsPanel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }
}
