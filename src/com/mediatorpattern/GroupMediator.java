package com.mediatorpattern;

import java.util.ArrayList;
import java.util.List;

/*
 * �н���ģʽ
 */
public class GroupMediator implements Group {

	/*
	 * С���Ա�ĳ����װ
	 */
	static abstract class GroupMemberBase implements GroupMember {

		protected Group group;

		@Override
		public void joinedParty(Group group) {
			System.out.printf("%s ���뵽��С����\n", this);
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
	 * ��̬�ڲ������̳��ⲿ����߾�̬�ڲ��࣬����ֱ�Ӽ̳�һ����ڲ��࣬��Ϊ���̳е��ڲ�������ʼ������һ�β��ܴ�����
	 */
	static class Andersen extends GroupMemberBase {

		@Override
		public String toString() {
			return "��ͽ��";
		}
	}

	static class Chef extends GroupMemberBase {

		@Override
		public String toString() {
			return "��ʦ";
		}
	}

	static class Fairy extends GroupMemberBase {

		@Override
		public String toString() {
			return "С����";
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
				System.out.printf("\t\t\t�¼��������� %s\n", actor);
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

		// ��������
		Andersen andersen = new Andersen();
		Fairy fairy = new Fairy();
		Chef chef = new Chef();

		// �������˶����뵽��С����
		party.addMember(andersen);
		party.addMember(fairy);
		party.addMember(chef);
		System.out.println("-------------------");

		// ��ͽ��Ҫ������, �н��߾ͻ�֪ͨ������.
		andersen.act(ActionEnum.TABLE);
		System.out.println("-------------------");

		// ���鷢�����ʻ�, �н��߾ͻ�֪ͨ����������
		fairy.act(ActionEnum.FOND);
		System.out.println("-------------------");

		// ��ʦ�����˷�, �н��߾ͻ�֪ͨ����������
		chef.act(ActionEnum.HUNT);
	}

}
