package org.gengar.service;

import org.gengar.database.PersonDatabase;
import org.gengar.database.VotingDatabase;
import org.gengar.model.Person;

public class VotingService {
    private final PersonDatabase personDatabase;
    private final VotingDatabase votingDatabase;
    public VotingService(PersonDatabase personDatabase, VotingDatabase votingDatabase) {
        this.personDatabase = personDatabase;
        this.votingDatabase = votingDatabase;
    }

    public void addPerson(Person person) {
        personDatabase.addPerson(person);
    }
    public int getEligibleVoterCount() {
        return votingDatabase.getVoterList().size();
    }

}
