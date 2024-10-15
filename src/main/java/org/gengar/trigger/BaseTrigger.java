package org.gengar.trigger;

public abstract class BaseTrigger implements Trigger {
    private String triggerName;

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }
}
