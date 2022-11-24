package useCase;

//use case layer

import java.io.IOException;

public interface MatchManagerInputBoundary {
    public boolean manageMatch(MatchManagerRequestModel matchManagerRequestModel) throws IOException;
}
