
public class TennisGame {
    
    private int matchScorePlayer1 = 0;
    private int matchScorePlayer2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            matchScorePlayer1 += 1;
        else
            matchScorePlayer2 += 1;
    }

    public String getScore() {
        String score = "";
        if (matchScorePlayer1==matchScorePlayer2)
        {
            score = getMatchScoreIfEven();
        }
        else if (matchScorePlayer1>=4 || matchScorePlayer2>=4)
        {
            score = getIfPlayerWon();
        }
        else
        {
            score = getRestScores(score);
        }
        return score;
    }

    private String getRestScores(String score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = matchScorePlayer1;
            else { score +="-"; tempScore = matchScorePlayer2;}
            switch(tempScore)
            {
                case 0:
                    score +="Love";
                    break;
                case 1:
                    score +="Fifteen";
                    break;
                case 2:
                    score +="Thirty";
                    break;
                case 3:
                    score +="Forty";
                    break;
            }
        }
        return score;
    }

    private String getIfPlayerWon() {
        String score;
        int minusResult = matchScorePlayer1-matchScorePlayer2;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private String getMatchScoreIfEven() {
        String score;
        switch (matchScorePlayer1)
        {
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
