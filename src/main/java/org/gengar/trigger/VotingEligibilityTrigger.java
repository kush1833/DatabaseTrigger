package org.gengar.trigger;

import org.gengar.database.PersonDatabase;
import org.gengar.database.VotingDatabase;
import org.gengar.model.Address;
import org.gengar.model.Person;
import org.gengar.model.Voter;

import java.util.HashSet;
import java.util.Set;

public class VotingEligibilityTrigger extends BaseTrigger {
    private final VotingDatabase votingDatabase;
    private final PersonDatabase personDatabase;

    public VotingEligibilityTrigger(PersonDatabase personDatabase, VotingDatabase votingDatabase) {
        this.votingDatabase = votingDatabase;
        this.personDatabase = personDatabase;
    }
    @Override
    public void operation() {
        Set<Person> personList = personDatabase.getPersonList();
        Set<Person> listToAdd = new HashSet<>();
        for(Person person: personList) {
            if(votingDatabase.getVoterList().isEmpty()) {
                listToAdd.add(person);
            }
            else {
                for (Voter voter : votingDatabase.getVoterList()) {
                    if (!voter.getPerson().equals(person)) {
                        listToAdd.add(person);
                    }
                }
            }
        }
        for(Person person: listToAdd) {
            if(person.getAge() >= 18) {
                System.out.println("Adding a new eligible voter: " + person.getName());
                Voter voter = new Voter();
                voter.setPerson(person);
                Address address = new Address();
                address.setCity("abc");
                address.setState("def");
                address.setCountry("ghi");
                voter.setAddress(address);
                votingDatabase.addVoter(voter);
            }
        }
    }
}
