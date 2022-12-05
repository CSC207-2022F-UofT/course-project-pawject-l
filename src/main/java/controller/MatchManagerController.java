package controller;

import useCase.Match.MatchManagerInputBoundary;
import useCase.Chat.ChatManagerInputBoundary;
import useCase.Match.MatchManagerRequestModel;

import java.io.IOException;

public class MatchManagerController {

    final MatchManagerInputBoundary matchInput;
    final ChatManagerInputBoundary chatInput;

    public MatchManagerController(MatchManagerInputBoundary matchInput, ChatManagerInputBoundary chatInput) {
        this.matchInput = matchInput;
        this.chatInput = chatInput;
    }

    public void manageMatch(String p1_id, String p2_id, boolean p1_owner_decision) throws IOException {
        MatchManagerRequestModel requestModel = new MatchManagerRequestModel(p1_id, p2_id, p1_owner_decision);

        if (matchInput.manageMatch(requestModel)) {
            chatInput.createChat(p1_id, p2_id);
        }
    }
}
