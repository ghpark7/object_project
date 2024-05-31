import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class EmergeTelQuizPage extends JPanel {
    private MainApp mainApp;
    private List<QuizQuestion> questions;
    private int currentQuestionIndex = 0;
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup group;

    public EmergeTelQuizPage(MainApp mainApp) {
        this.mainApp = mainApp;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        // 퀴즈 질문 생성
        questions = new ArrayList<>();
        questions.add(new QuizQuestion("EmergeTelQuiz1.png", new String[]{"전화", "연락처", "설정", "카카오톡"}, 2, "긴급 연락처 저장을 하기 위해서는 안전 및 긴급 항목에 들어가 긴급 연락처 항목을 터치해야해요. \n긴급 SOS 설정도 여기서 할 수 있어요."));
        questions.add(new QuizQuestion("EmergeTelQuiz2.png", new String[]{"잠금화면 및 AOD", "보안 및 개인정보 보호", "위치", "안전 및 긴급"}, 3, "긴급 연락처 저장을 하기 위해서는 안전 및 긴급 항목에 들어가 긴급 연락처 항목을 터치해야해요.\n긴급 SOS 설정도 여기서 할 수 있어요."));
        questions.add(new QuizQuestion("EmergeTelQuiz3.png", new String[]{"잠금을 풀고 전화 아이콘을 눌러 연락한다.", "잠금을 풀고 카카오톡 아이콘을 눌러 보이스톡을 누른다.", "스마트폰 측면 버튼을 5번 누른 후 뜨는 전화 버튼을 눌러서 민다.", "잠금화면에서 카메라 버튼을 민다."}, 2, "긴급 SOS를 설정하면 스마트폰 측면 버튼을 빠르게 5번 눌러 긴급 연락을 취할 수 있습니다."));
        
        // 질문 라벨 설정
        questionLabel = new JLabel();
        questionLabel.setHorizontalAlignment(JLabel.CENTER);

        // 옵션 패널 설정
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        group = new ButtonGroup();
        optionButtons = new JRadioButton[4];
        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i] = new JRadioButton();
            group.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }

        // 버튼 설정
        JButton nextButton = new JButton("다음 문제");
        nextButton.addActionListener(e -> showNextQuestion());

        JButton previousButton = new JButton("이전 문제");
        previousButton.addActionListener(e -> showPreviousQuestion());

        JButton submitButton = new JButton("정답 확인");
        submitButton.addActionListener(e -> checkAnswer());

        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> {
            resetQuiz();
            mainApp.showMainPage();
        });

        // 네비게이션 패널 설정
        JPanel navigationPanel = new JPanel(new FlowLayout());
        navigationPanel.add(previousButton);
        navigationPanel.add(submitButton);
        navigationPanel.add(nextButton);

        // 상단 패널 설정
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(backButton);

        // 중앙 패널 설정
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(questionLabel, BorderLayout.NORTH);
        centerPanel.add(optionsPanel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(navigationPanel, BorderLayout.SOUTH);

        showNextQuestion();
    }

    // 다음 질문을 표시하는 메서드
    private void showNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            QuizQuestion question = questions.get(currentQuestionIndex);
            questionLabel.setIcon(question.getQuestion());
            String[] options = question.getOptions();
            for (int i = 0; i < optionButtons.length; i++) {
                optionButtons[i].setText(options[i]);
                optionButtons[i].setSelected(false);
            }
            currentQuestionIndex++;
        } else {
            JOptionPane.showMessageDialog(this, "퀴즈를 완료했습니다!", "완료", JOptionPane.INFORMATION_MESSAGE);
            resetQuiz();
            mainApp.showMainPage();
        }
    }

    // 이전 질문을 표시하는 메서드
    private void showPreviousQuestion() {
        if (currentQuestionIndex > 1) {
            currentQuestionIndex -= 2;
            showNextQuestion();
        } else if (currentQuestionIndex == 1) {
            currentQuestionIndex--;
            showNextQuestion();
        }
    }

     // 정답을 확인하는 메서드
    private void checkAnswer() {
        if (currentQuestionIndex > 0) {
            QuizQuestion question = questions.get(currentQuestionIndex - 1);
            int selectedOption = -1;
            for (int i = 0; i < optionButtons.length; i++) {
                if (optionButtons[i].isSelected()) {
                    selectedOption = i;
                    break;
                }
            }
            if (selectedOption == question.getCorrectIndex()) {
                JOptionPane.showMessageDialog(this, "정답입니다! \n해설: " + question.getExplanation(), "정답", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "틀렸습니다. \n해설: " + question.getExplanation(), "오답", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

     // 퀴즈를 초기화하는 메서드
    private void resetQuiz() {
        currentQuestionIndex = 0;
        group.clearSelection();
        showNextQuestion();
    }
}

class QuizQuestion {
    private ImageIcon question;
    private String[] options;
    private int correctIndex;
    private String explanation;

    public QuizQuestion(String imagePath, String[] options, int correctIndex, String explanation) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        this.question = new ImageIcon(scaledImage);
        this.options = options;
        this.correctIndex = correctIndex;
        this.explanation = explanation;
    }

    public ImageIcon getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }

    public String getExplanation() {
        return explanation;
    }
}