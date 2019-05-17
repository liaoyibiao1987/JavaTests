package com.mediatorpattern;

public interface GroupMember {

	void joinedParty(Group group);

	void partyAction(ActionEnum action);

	void act(ActionEnum action);
}
