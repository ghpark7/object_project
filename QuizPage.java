import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class QuizPage extends JPanel {
    private MainApp mainApp;
    private List<QuizQuestion> questions;
    private int currentQuestionIndex = 0;
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;

    public QuizPage(MainApp mainApp) {
        this.mainApp = mainApp;
        setupSearchingUI();
        setupTextingUI();
        setupSavingEmergencyUI();
        setupCameraUI();
        setupFontUI();
    }

    private void setupSearchingUI() {
        setLayout(new BorderLayout());

        // 퀴즈 질문 생성
        questions = new ArrayList<>();
        questions.add(new QuizQuestion("앱을 설치하고 싶어요. 어떤 아이콘을 찾아야 할까요?", new String[]{"1", "2", "3", "4"}, 3));
        questions.add(new QuizQuestion("시계 앱을 설치하고 싶어요. 어떤 버튼을 누를까요?", new String[]{"1", "2", "3", "4"}, 2));
        questions.add(new QuizQuestion("시계 앱을 모두 설치했어요. 어떤 버튼을 누르면 앱에 접속할 수 있을까요?", new String[]{"1", "2", "3", "4"}, 2));

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        ButtonGroup group = new ButtonGroup();
        optionButtons = new JRadioButton[4];
        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i] = new JRadioButton();
            group.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }

        questionLabel = new JLabel("", JLabel.CENTER);
        JButton nextButton = new JButton("다음 문제");
        nextButton.addActionListener(e -> showNextQuestion());

        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> mainApp.showMainPage());

        add(questionLabel, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.EAST);
        add(backButton, BorderLayout.WEST);

        showNextQuestion();
    }

    private void setupTextingUI() {
        setLayout(new BorderLayout());

        // 퀴즈 질문 생성
        questions = new ArrayList<>();
        questions.add(new QuizQuestion("내용을 다 적었어요. 전송하려면 어디를 눌러야 할까요?", new String[]{"1", "2", "3"}, 0));
        questions.add(new QuizQuestion("보낸 문자를 삭제하고 싶어요. 어떻게 할까요?", new String[]{"1", "2", "3"}, 1));

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        ButtonGroup group = new ButtonGroup();
        optionButtons = new JRadioButton[3];
        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i] = new JRadioButton();
            group.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }

        questionLabel = new JLabel("", JLabel.CENTER);
        JButton nextButton = new JButton("다음 문제");
        nextButton.addActionListener(e -> showNextQuestion());

        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> mainApp.showMainPage());

        add(questionLabel, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.EAST);
        add(backButton, BorderLayout.WEST);

        showNextQuestion();
    }

    private void setupSavingEmergencyUI() {
        setLayout(new BorderLayout());

        // 퀴즈 질문 생성
        questions = new ArrayList<>();
        questions.add(new QuizQuestion("긴급 연락처 저장을 하려면 무엇을 눌러야할까요?", new String[]{"1", "2", "3", "4"}, 3));
        questions.add(new QuizQuestion("비상 연락처를 설정하기 위해서 무슨 아이콘을 눌러야 할까요?", new String[]{"1", "2", "3", "4"}, 1));
        questions.add(new QuizQuestion("비상 연락처로 긴급 연락을 하고 싶을 때 할 수 있는 것이 아닌 것은 무엇일까요?", new String[]{"1", "2", "3", "4"}, 0));

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        ButtonGroup group = new ButtonGroup();
        optionButtons = new JRadioButton[4];
        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i] = new JRadioButton();
            group.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }

        questionLabel = new JLabel("", JLabel.CENTER);
        JButton nextButton = new JButton("다음 문제");
        nextButton.addActionListener(e -> showNextQuestion());

        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> mainApp.showMainPage());

        add(questionLabel, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.EAST);
        add(backButton, BorderLayout.WEST);

        showNextQuestion();
    }

    private void setupCameraUI() {
        setLayout(new BorderLayout());

        // 퀴즈 질문 생성
        questions = new ArrayList<>();
        questions.add(new QuizQuestion("큐알코드에 카메라를 가져다댔어요. 다음으로 해야할 동작은 무엇일까요?", new String[]{"1", "2", "3", "4"}, 3));
        questions.add(new QuizQuestion("내 얼굴 사진을 찍고 싶어요. 어떤 버튼을 누를까요?", new String[]{"1", "2", "3", "4"}, 1));
        questions.add(new QuizQuestion("동영상을 찍고 싶어요. 어떤 버튼을 누를까요?", new String[]{"1", "2", "3", "4"}, 2));

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        ButtonGroup group = new ButtonGroup();
        optionButtons = new JRadioButton[4];
        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i] = new JRadioButton();
            group.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }

        questionLabel = new JLabel("", JLabel.CENTER);
        JButton nextButton = new JButton("다음 문제");
        nextButton.addActionListener(e -> showNextQuestion());

        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> mainApp.showMainPage());

        add(questionLabel, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.EAST);
        add(backButton, BorderLayout.WEST);

        showNextQuestion();
    }

    private void setupFontUI() {
        setLayout(new BorderLayout());

        // 퀴즈 질문 생성
        questions = new ArrayList<>();
        questions.add(new QuizQuestion("설정으로 들어가려면 어떤 버튼을 눌러야 할까요?", new String[]{"1", "2", "3"}, 1));
        questions.add(new QuizQuestion("글자 크기를 키우려면 아래의 점을 어느쪽으로 움직여야 할까요?", new String[]{"1", "2", "3"}, 0));

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        ButtonGroup group = new ButtonGroup();
        optionButtons = new JRadioButton[3];
        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i] = new JRadioButton();
            group.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }

        questionLabel = new JLabel("", JLabel.CENTER);
        JButton nextButton = new JButton("다음 문제");
        nextButton.addActionListener(e -> showNextQuestion());

        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> mainApp.showMainPage());

        add(questionLabel, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.EAST);
        add(backButton, BorderLayout.WEST);

        showNextQuestion();
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            QuizQuestion question = questions.get(currentQuestionIndex);
            questionLabel.setText(question.getQuestion());
            String[] options = question.getOptions();
            for (int i = 0; i < optionButtons.length; i++) {
                optionButtons[i].setText(options[i]);
            }
            currentQuestionIndex++;
        } else {
            JOptionPane.showMessageDialog(this, "퀴즈를 완료했습니다!", "완료", JOptionPane.INFORMATION_MESSAGE);
            mainApp.showMainPage();
        }
    }
}

class QuizQuestion {
    private String question;
    private String[] options;
    private int correctIndex;

    public QuizQuestion(String question, String[] options, int correctIndex) {
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
