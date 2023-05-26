package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {
    public static void main(String[] args) throws Exception {
        Users users = InputView.inputUsers();
        LadderRewards ladderRewards = InputView.inputRewards(users.getUsersSize());
        LadderHeight ladderHeight = InputView.inputHeight();

        LadderGame ladderGame = new LadderGame(users, ladderHeight);
        ResultView.printLadder(ladderGame, ladderRewards);

        LadderGameResult ladderResult = ladderGame.play(ladderRewards);
        execute(ladderResult);
    }

    private static void execute(LadderGameResult ladderResult) {

        GameStatus gameStatus = new GameStatus(true);
        while(gameStatus.repeatable())
        {
            drawUserResult(ladderResult , gameStatus);
        }
    }

    private static void drawUserResult(LadderGameResult ladderResult, GameStatus gameStatus) {
        String inputUser = InputView.inputUserName();

        if( ResultView.isContinueGame(inputUser) == false )
        {
            gameStatus.stop();
        }

        ResultView.showResultReward(inputUser, ladderResult);

    }
}
