package com.mediatorpattern;

import com.mediatorpattern.ActionEnum;
import com.mediatorpattern.GroupMember;

public interface Group {
	void addMember(GroupMember member);
	 
    void act(GroupMember actor, ActionEnum action);
}
