
public class TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private String player1Name;
    private String player2Name;
    private String[] points = {"Love","Fifteen","Thirty","Forty"};

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public String getScore() {
        String score = "";
        if (isEqualPoints(scorePlayer1, scorePlayer2))
            score = calculateEqualScore();
        else if (isWinnerOrAdvantage())
            score = calculateAdvantageWinner();
        else
            score = calculateNotEqualScore();
        return score;
    }

    private boolean isWinnerOrAdvantage() {
        return scorePlayer1 >= 4 || scorePlayer2 >= 4;
    }

    private boolean isEqualPoints(int m_score1, int m_score2) {
        return m_score1 == m_score2;
    }

    private String calculateAdvantageWinner() {
        String score;
        int minusResult = scorePlayer1 - scorePlayer2;
        String winOrAdvantage = Math.abs(minusResult)>=2?"Win for ":"Advantage ";
        String candidate = minusResult>0?"player1":"player2";
        score = winOrAdvantage + candidate;
        return score;
    }

    private String calculateNotEqualScore() {
        return points[scorePlayer1] + "-" + points[scorePlayer2];
    }

    private String calculateEqualScore() {
        String score;
        if(scorePlayer1 <= 2)
            score = points[scorePlayer1]+"-All";
        else
            score = "Deuce";
        return score;
    }
}
