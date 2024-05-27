import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class ProgressPage extends JPanel {
    private MainApp mainApp;
    private Calendar calendar = Calendar.getInstance();
    private DatabaseManager dbManager = new DatabaseManager();

    public ProgressPage(MainApp mainApp) {
        this.mainApp = mainApp;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        String progress = dbManager.getLearningProgress();
        JLabel progressLabel = new JLabel("<html>" + progress.replace("\n", "<br>") + "</html>", JLabel.CENTER);

        JLabel dateLabel = new JLabel("현재 날짜: " + calendar.getTime().toString(), JLabel.CENTER);

        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> mainApp.showMainPage());

        add(new JLabel("전체 진도 현황", JLabel.CENTER), BorderLayout.NORTH);
        add(progressLabel, BorderLayout.CENTER);
        add(dateLabel, BorderLayout.SOUTH);
        add(backButton, BorderLayout.WEST);
    }
}
