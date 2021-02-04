package doublyLinkedList;

class Node<T> {
	T data;
	Node<T> previous;
	Node<T> next;
}

class LinkedList {
	
	public <T> Node makeNewNode(T data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		node.previous = null;
		return node;
	}

	public <T> Node insert(T data, Node node) {
		if(node == null) return makeNewNode(data);
		
		Node tempHead = node;
		while(node.next != null) {
			node = node.next;
		}
		
		Node secondNode = makeNewNode(data);
		secondNode.previous = node;
		node.next = secondNode;
		return tempHead;
	}
	
		public <T> Node addFirstNode(Node head, T data) {
		if(head == null) return makeNewNode(data);
		
		Node start = makeNewNode(data);
		head.previous = start;
		start.next = head;
		
		return start;
	}
		
		public <T> Node addLastNode(Node head, T data) {
		if(head == null) return makeNewNode(data);
		
		Node last = makeNewNode(data);
		head.next = last;
		last.previous = head;
		
		return last;
	}
		
		public <T> Node atGivenIndex(Node head, T data, T position, T firstPostion, T secondPostion) {
			
			if(head == null) { 
				if(position == firstPostion) {
					return makeNewNode(data);
				}
				else return null;
			}
			
			if (position == firstPostion) {
				Node in = new Node();
				head.previous = in;
				in.next = head;
				return in;
				
			}
			
			Node node = head;
			
			while(node != null && position > secondPostion) {
				node = node.next;
				position--;
			}
			
			Node out = makeNewNode(data);
			out.next = node.next;
			out.previous = node;
			if(node.next != null) {
				node.next.previous = out;
			}
			node.next = out;
			return head;
			
		}
		
		public <T>Node deleteFirstNode(Node head){
			if(head == null) return null;
			
			if(head.next != null) {
				head.next.previous = null;
			}
			return head.next;
		}
		
		public <T>Node deleteLastNode(Node head){
			if(head == null) return null;
			
			while(head.next != null) {
				head = head.next;
			}
			if(head.previous != null) {
				head.previous.next = null;
			}
			return head.previous;
		}
		
		public <T> Node deleteAtGivenIndex(Node head, T position, T firstPostion, T secondPostion) {
			if(head == null) {
				return head;
			}
			
			if (position == firstPostion) {
				if(head.next != null) {
					head.next.previous = null;
				}
				return head.next;
			}
			Node node = head;
			
			while(node != null && position > 1) {
				node = node.next;
				position--;
			}
			if(node == null) {
				return head;
			}
			if(node.next != null) {
				node.next.previous = node.previous;
			}
			node.previous.next = node.next;
			return head;
		}
}


class DoublyLinkedList{
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		Node head = null;
		
		
		//head = linkedList.addFirstNode(head, data);
		//head = linkedList.addLastNode(head, data);
		//head = linkedList.atGivenIndex(head, data, firstPosition, lastPosition)
		//head = linkedList.deleteFirstNode(head);
		//head = linkedList.deleteLastNode(head);
		//head = linkedList.deleteAtGivenIndex(head, data, firstPosition, lastPosition);
		
		
	}
}


