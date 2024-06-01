import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProgressPage extends JPanel {
    private MainApp mainApp;
    private List<TodayQuestion> questions;
    private int currentQuestionIndex = 0;
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;

    public ProgressPage(MainApp mainApp) {
        this.mainApp = mainApp;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        // 퀴즈 질문 생성
        questions = new ArrayList<>();
        questions.add(new TodayQuestion("오늘은 6월 12일, 공부 첫날! 공부하셨나요?", new String[]{"네! 퀴즈까지 다 했어요", "아니요, 내일은 할거에요!"}, 0));
        questions.add(new TodayQuestion("오늘은 2일차, 6월 13일! 공부하셨나요?", new String[]{"네, 뿌듯해요^^", "아니요, 또 미뤘어요."}, 2));

        // 패널 설정
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        optionsPanel.setBorder(BorderFactory.createTitledBorder("1주차"));

        ButtonGroup group = new ButtonGroup();
        optionButtons = new JRadioButton[2];
        Font font = new Font("함초롬돋움", Font.PLAIN, 16); // 글씨 크기 설정

        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setFont(font); // 폰트 설정
            group.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }

        questionLabel = new JLabel("", JLabel.CENTER);

        // 버튼 생성
        JButton nextButton = new JButton("내일 진도 체크");
        nextButton.addActionListener(e -> showNextQuestion());

        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> mainApp.showMainPage());

        // 오른쪽에 사진을 추가하는 패널 생성
        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("June.png"));
        Image image = icon.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH); // 크기 조정
        ImageIcon scaledIcon = new ImageIcon(image);
        imageLabel.setIcon(scaledIcon);

        centerPanel.add(questionLabel, BorderLayout.NORTH);
        centerPanel.add(optionsPanel, BorderLayout.CENTER);
        centerPanel.add(imageLabel, BorderLayout.SOUTH);

        add(backButton, BorderLayout.WEST);
        add(nextButton, BorderLayout.EAST);
        add(centerPanel, BorderLayout.CENTER);

        showNextQuestion();
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            TodayQuestion question = questions.get(currentQuestionIndex);
            questionLabel.setText(question.getQuestion());
            String[] options = question.getOptions();
            for (int i = 0; i < optionButtons.length; i++) {
                optionButtons[i].setText(options[i]);
            }
            currentQuestionIndex++;
        } else {
            JOptionPane.showMessageDialog(this, "1주차 공부 체크 완료!", "완료", JOptionPane.INFORMATION_MESSAGE);
            mainApp.showMainPage();
        }
    }
}

class TodayQuestion {
    private String question;
    private String[] options;
    private int correctIndex;

    public TodayQuestion(String question, String[] options, int correctIndex) {
        this.question = question;
        this.options = options;
        this.correctIndex = correctIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }
}
