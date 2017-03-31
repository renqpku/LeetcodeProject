package com.renqpku;

public class AddTwoNumbers_2 {
	ListNode resultNode = null;
	ListNode tempNode1, tempNode2 = null;

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int temp = 0, node1Value = 0, node2Value = 0;
		tempNode1 = l1;
		tempNode2 = l2;

		while (tempNode1 != null | tempNode2 != null) {

			if (tempNode1 != null)
				node1Value = tempNode1.val;
			else
				node1Value = 0;

			if (tempNode2 != null)
				node2Value = tempNode2.val;
			else
				node2Value = 0;

			int tempValue = node1Value + node2Value;

			ListNode tempNode = new ListNode( (tempValue + temp) % 10);

			addNode(tempNode);

			if (tempNode1 != null)
				tempNode1 = tempNode1.next;
			if (tempNode2 != null)
				tempNode2 = tempNode2.next;
			if ( (tempValue+temp) >= 10) {
				temp = 1;
			} else {
				temp = 0;
			}
		}
		
		if(temp == 1) {
		    ListNode tempNode = new ListNode(temp);

			addNode(tempNode);
		}

		return resultNode;
	}

	private void addNode(ListNode l2) {
		if (resultNode != null) {
			ListNode tln = resultNode;
			while (tln.next != null) {
				tln = tln.next;
			}
			tln.next = l2;
		} else {
			resultNode = l2;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbers_2 t = new AddTwoNumbers_2();
		ListNode node1 = t.new ListNode(1);
		ListNode node2 = t.new ListNode(4);
		ListNode node3 = t.new ListNode(3);
		//node1.next = node2;
		//node2.next = node3;
		ListNode node4 = t.new ListNode(9);
		ListNode node5 = t.new ListNode(9);
		ListNode node6 = t.new ListNode(9);
		ListNode node7 = t.new ListNode(4);
		node4.next = node5;
		//node5.next = node6;
		//node6.next = node7;

		// while (node1 != null) {
		// System.out.println(node1.val + ",");
		// node1 = node1.next;
		// }
		// while (node4 != null) {
		// System.out.println(node4.val + ",");
		// node4 = node4.next;
		// }

		ListNode r = t.addTwoNumbers(node1, node4);
		while (r != null) {
			System.out.println(r.val + ",");
			r = r.next;
		}
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	// 	Solution in Leetcode
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	}
}
