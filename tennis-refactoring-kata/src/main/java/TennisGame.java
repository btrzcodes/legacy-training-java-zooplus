
public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (areEqualScore()) {
            return calculateEqualScore();
        } else if (isAdvantage()) {
            return calculateAdvantageScore();
        } else if (isWinScore()) {
            return calculcateWinScore();
        } else {
            return calculateRegularScore();
        }
    }

    private String calculcateWinScore() {
        String score;
        int minusResult = m_score1 - m_score2;
        if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private boolean isWinScore() {
        return isLongGame();
    }

    private String calculateAdvantageScore() {
        String score = "";
        if (m_score1 - m_score2 == 1) score = "Advantage player1";
        else if (m_score1 - m_score2 == -1) score = "Advantage player2";
        return score;
    }

    private boolean isAdvantage() {
        return isLongGame() && Math.abs(m_score1 - m_score2) == 1;
    }

    private String calculateRegularScore() {
        String score = "";

        score = calculcateScore(score, m_score1) + "-"+calculcateScore(score, m_score2);
        return score;
    }

    private String calculcateScore(String score, int tempScore) {
        switch (tempScore) {
            case 0:
                score = "Love";
                break;
            case 1:
                score = "Fifteen";
                break;

            case 2:
                score = "Thirty";
                break;
            case 3:
                score = "Forty";
                break;
        }
        return score;
    }

    private boolean isLongGame() {
        return m_score1 >= 4 || m_score2 >= 4;
    }

    private String calculateEqualScore() {
        String[] validScores = {"Love-All", "Fifteen-All", "Thirty-All"};

        return m_score1 < validScores.length ? validScores[m_score1] : "Deuce";
    }

    private boolean areEqualScore() {
        return m_score1 == m_score2;
    }
}
