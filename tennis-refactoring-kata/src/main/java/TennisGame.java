
public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String score = "";
        if (isTied()) {
            score = getScoreNameWhenTied(player1Score);
        } else if (anyPlayerScoreIsBiggerThanThree()) {
            score = getScoreNameWhenAnyIsOverThree();
        } else {
            score = getScoreNameWhenBothAreUnderThree();
        }
        return score;
    }

    private String getScoreNameWhenBothAreUnderThree() {
        return String.format("%s-%s", getIndividualScoreName(player1Score), getIndividualScoreName(player2Score));
    }

    private String getIndividualScoreName(int score) {
        String tempScore = "";
        switch (score) {
            case 0:
                tempScore = "Love";
                break;
            case 1:
                tempScore = "Fifteen";
                break;
            case 2:
                tempScore = "Thirty";
                break;
            case 3:
                tempScore = "Forty";
                break;
        }
        return tempScore;
    }

    private String getScoreNameWhenAnyIsOverThree() {
        String score;
        int diffBetweenPlayers = this.player1Score - this.player2Score;
        if (diffBetweenPlayers == 1) score = "Advantage player1";
        else if (diffBetweenPlayers == -1) score = "Advantage player2";
        else if (diffBetweenPlayers >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private boolean anyPlayerScoreIsBiggerThanThree() {
        return this.player1Score >= 4 || this.player2Score >= 4;
    }

    private boolean isTied() {
        return this.player1Score == this.player2Score;
    }

    private static String getScoreNameWhenTied(int m_score1) {
        String score;
        switch (m_score1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }
}
