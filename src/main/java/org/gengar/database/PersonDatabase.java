package org.gengar.database;

import org.gengar.model.Person;
import org.gengar.trigger.BaseTrigger;
import org.gengar.trigger.Trigger;

import java.util.*;

public class PersonDatabase {
    private final Set<Person> personList = new HashSet<>();
    private final Map<String, Trigger> triggerMap = new HashMap<>();

    private PersonDatabase(){}

    public Set<Person> getPersonList() {
        return personList;
    }
    public void registerTrigger(BaseTrigger trigger) {
        triggerMap.put(trigger.getTriggerName(), trigger);
    }
    public void unregisterTrigger(String triggerName) {
        triggerMap.remove(triggerName);
    }

    public void addPerson(Person person) {
        this.personList.add(person);
        for(Trigger trigger: triggerMap.values()) {
            trigger.operation();
        }
    }
    public static PersonDatabaseBuilder builder() {
        return new PersonDatabaseBuilder();
    }
    public static class PersonDatabaseBuilder {
        public PersonDatabase build() {
            return new PersonDatabase();
        }
    }
}
