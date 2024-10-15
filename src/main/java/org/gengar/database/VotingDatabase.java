package org.gengar.database;

import org.gengar.model.Voter;

import java.util.ArrayList;
import java.util.List;

public class VotingDatabase {
    private final List<Voter> voterList = new ArrayList<>();
    private VotingDatabase(){}
    public List<Voter> getVoterList() {
        return voterList;
    }
    public void addVoter(Voter voter) {
        this.voterList.add(voter);
    }
    public static VotingDatabaseBuilder builder() {
        return new VotingDatabaseBuilder();
    }
    public static class VotingDatabaseBuilder {
        public VotingDatabase build() {
            return new VotingDatabase();
        }
    }
}
