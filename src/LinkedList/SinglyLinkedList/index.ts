import Node from './Node';

/**
 * This class implements the main SinglyLinkedList data
 * structure of data structures book in java
 * @param data - The data that should contain the node
 */
export default class SinglyLinkedList<T> {
	public head: Node<T> | null = null;

	get length(): number {
		if (this.head === null) {
			return 0;
		}
		let tempNode: Node<T> | null = this.head;
		let length = 0;
		while (tempNode !== null) {
			tempNode = tempNode.next;
			length++;
		}
		return length;
	}

	/**
	 * Returns the last element of the list
	 * @remarks this is not a proprety of the list
	 */
	public getTail(): Node<T> | null {
		if (this.head === null || this.head.next === null) {
			return this.head;
		}
		let tempNode = this.head;
		while (tempNode.next !== null) {
			tempNode = tempNode.next;
		}
		return tempNode;
	}

	/**
	 * Push the given that to a new Node in the front of the list
	 * @param data - The data that should contain the node
	 */
	public push(data: T): void {
		const newNode = new Node(data);
		newNode.next = this.head;
		this.head = newNode;
	}

	/**
	 * Push the tail to the head
	 */
	public pushTailToHead(): void {
		//TODO: this makes an infinite loop
		// const tail = this.getTail();
		// if (tail === null || tail === this.head) {
		// 	return;
		// }
		// tail.next = this.head;
		// this.head = tail;
		// return;
	}

	/**
	 * Appends the data given to the tail of the list
	 * @param data - The data that should contain the node
	 */
	public append(data: T): void {
		const newNode = new Node(data);
		if (this.head === null) {
			this.head = newNode;
			return;
		}
		//Travel till find the final node
		let last = this.head;
		while (last.next !== null) {
			last = last.next;
		}
		last.next = newNode;
	}

	/**
	 * Appends the data given to the tail of the list
	 * @param prevNode - the node that will preced the new one
	 * @param data - The data that should contain the node
	 */
	public insertAfter(prevNode: Node<T>, data: T): void {
		if (prevNode === null) {
			console.log('The given node does not exsit');
			return;
		}
		const newNode = new Node(data);

		//Swiping the next node of prevNode with the new on
		newNode.next = prevNode.next;
		prevNode.next = newNode;
	}

	/**
	 * Returns the first node that have the given data
	 * @param data - The node that should contain the data
	 */
	public getNodeByData(data: T): Node<T> | null {
		let tempNode = this.head;
		while (tempNode !== null) {
			if (tempNode.data === data) {
				return tempNode;
			}
			tempNode = tempNode.next;
		}
		return null;
	}
	/**
	 * Returns the previus node that have the given data
	 * @param data - The node that should contain the data
	 */
	public getPrevNodeByData(data: T): Node<T> | null {
		if (
			this.head === null ||
			(this.head !== null &&
				(this.head.data === data || this.head.next === null))
		) {
			return null;
		}

		let tempNode = this.head.next;
		let prevNode = this.head;
		while (tempNode !== null) {
			if (tempNode.data === data) {
				return prevNode;
			}
			prevNode = tempNode;
			tempNode = tempNode.next;
		}
		return null;
	}

	/**
	 * Deletes the entire list
	 */
	public deleteList() {
		this.head = null;
	}

	/**
	 * Deletes the first node that have the data given
	 *
	 * @remarks
	 * setting the isRecursive parameter to true gill delete
	 * all the nodes that have the data
	 *
	 * @param data - The data that should contain the node
	 * @param isRecursive - Will eliminate recursivly all nodes with that data
	 * default to false
	 */
	public deleteNodeByData(data: T, isRecursive = false): void {
		const prevNode = this.getPrevNodeByData(data);
		if (prevNode !== null && prevNode.next !== null) {
			//Searching if the node with the data have a child
			if (prevNode.next.next !== null) {
				prevNode.next = prevNode.next.next;
			} else {
				prevNode.next = null;
			}

			if (isRecursive) this.deleteNodeByData(data);
		}
		return;
	}

	public printList(): void {
		let tempNode = this.head;
		while (tempNode !== null) {
			console.log(tempNode.data);
			tempNode = tempNode.next;
		}
	}
}
