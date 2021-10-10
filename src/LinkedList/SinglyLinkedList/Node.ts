/**
 * This is the main Node for the SinglyLinkedList structure
 * @param data - The data that should contain the node
 */
export default class Node<T> {
	private nodeData: T;
	public next: Node<T> | null = null;

	constructor(data: T) {
		this.nodeData = data;
	}

	public get data(): T {
		return this.nodeData;
	}
	public set data(d: T) {
		this.nodeData = d;
	}
}
