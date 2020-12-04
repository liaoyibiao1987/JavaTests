package com.mediatorpattern;

import java.util.ArrayList;
import java.util.List;

/*
 * 中介者模式
 */
public class GroupMediator implements Group {

	/*
	 * 小组成员的抽象封装
	 */
	static abstract class GroupMemberBase implements GroupMember {

		protected Group group;

		@Override
		public void joinedParty(Group group) {
			System.out.printf("%s 加入到了小组中\n", this);
			this.group = group;
		}

		@Override
		public void partyAction(ActionEnum action) {
			System.out.printf("%s %s\n", this, action.getDescription());
		}

		@Override
		public void act(ActionEnum action) {
			if (group != null) {
				System.out.printf("%s %s\n", this, action);
				group.act(this, action);
			}
		}

		@Override
		public abstract String toString();

	}

	/*
	 * 静态内部类必须继承外部类或者静态内部类，不能直接继承一般的内部类，因为被继承的内部类必须初始化主类一次才能创建。
	 */
	static class Andersen extends GroupMemberBase {

		@Override
		public String toString() {
			return "安徒生";
		}
	}

	static class Chef extends GroupMemberBase {

		@Override
		public String toString() {
			return "厨师";
		}
	}

	static class Fairy extends GroupMemberBase {

		@Override
		public String toString() {
			return "小精灵";
		}
	}

	
	
	private final List<GroupMember> members;

	public GroupMediator() {
		members = new ArrayList<>();
	}

	@Override
	public void act(GroupMember actor, ActionEnum action) {
		for (GroupMember member : members) {
			if (!member.equals(actor)) {
				member.partyAction(action);
			}else {
				System.out.printf("\t\t\t事件触发者是 %s\n", actor);
			}
		}
	}

	@Override
	public void addMember(GroupMember member) {
		members.add(member);
		member.joinedParty(this);
	}

	public static void main(String[] args) {
		Group party = new GroupMediator();

		// 有三种人
		Andersen andersen = new Andersen();
		Fairy fairy = new Fairy();
		Chef chef = new Chef();

		// 这三种人都加入到了小组中
		party.addMember(andersen);
		party.addMember(fairy);
		party.addMember(chef);
		System.out.println("-------------------");

		// 安徒生要讲故事, 中介者就会通知其他人.
		andersen.act(ActionEnum.TABLE);
		System.out.println("-------------------");

		// 精灵发现了鲜花, 中介者就会通知其他所有人
		fairy.act(ActionEnum.FOND);
		System.out.println("-------------------");

		// 厨师做好了饭, 中介者就会通知其他所有人
		chef.act(ActionEnum.HUNT);
	}

}
