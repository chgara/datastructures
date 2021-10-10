import SinglyLinkedList from './SinglyLinkedList';

/**
 * This is the main execution enviroment for all the linked list types of
 * data structures.
 */
const main = (): void => {
	const List = new SinglyLinkedList<number>();
	List.append(1);
	List.append(2);
	List.append(3);
	List.append(4);
	List.append(5);
	List.push(0);

	//Get the node before 3
	// const node = List.getPrevNodeByData(3);
	// if (node !== null) {
	// 	console.log(node.data);
	// }

	//	Get the node with data3
	// const node3 = List.getNodeByData(3);
	// if (node3 !== null) {
	// 	List.insertAfter(node3, 3);
	// }

	//Deleting node with data 3
	// List.deleteNodeByData(3, true);

	// console.log(List.getTail());

	List.pushTailToHead();
	List.printList();

	// console.log(List.length);
};
main();
