package org.gengar;

import org.gengar.database.PersonDatabase;
import org.gengar.database.VotingDatabase;
import org.gengar.model.Person;
import org.gengar.service.VotingService;
import org.gengar.trigger.VotingEligibilityTrigger;

public class DatabaseTriggerApplication {

    public static void main(String[] args) {
        PersonDatabase personDatabase = PersonDatabase.builder().build();
        VotingDatabase votingDatabase = VotingDatabase.builder().build();
        VotingEligibilityTrigger trigger = new VotingEligibilityTrigger(personDatabase, votingDatabase);
        personDatabase.registerTrigger(trigger);

        VotingService votingService = new VotingService(personDatabase, votingDatabase);
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        person1.setName("Nathuram Gandhi");
        person1.setAge(55);
        person2.setName("Mohandas Karamchand Godse");
        person2.setAge(44);
        person3.setName("Jawaharlal Jinnah");
        person3.setAge(17);
        votingService.addPerson(person1);
        System.out.println("Total eligible voters: " + votingService.getEligibleVoterCount());
        votingService.addPerson(person3);
        System.out.println("Total eligible voters: " + votingService.getEligibleVoterCount());
        votingService.addPerson(person2);
        System.out.println("Total eligible voters: " + votingService.getEligibleVoterCount());
    }
}
