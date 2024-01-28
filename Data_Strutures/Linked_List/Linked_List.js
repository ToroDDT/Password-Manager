class Node {
    constructor(value){
        this.value = value,
        this.next = null
    }
}

class LinkedList {
    constructor(head = null){
        this.head = head
    }
    getLast() {
       let lastNode = this.head
        if(lastNode){
            while(lastNode.next){
                lastNode = lastNode.next
            }
        }
        return lastNode.value
 }
    getSize () {
        let count = 0
        let lastNode = this.head
        if(lastNode){
            while(lastNode){
                lastNode = lastNode.next
                count++
            }
        }
        return count
    }

    removeNthNode (nth) {
        // get the length of the linkedList 
        let LengthOfLinkedList = this.getSize()
        // get the node that will be removed 
        let removeNth = LengthOfLinkedList - nth
        //
        let node = this.head
        if(node) {
            for(let i = removeNth; i<= 0; i--){
                node.next
            }
        }
    }
}

// start from the end of the linked list 
// starting from the end of the list 
// get a node for X indexes away from the last node 


let Node1 = new Node(1)
let Node2 = new Node(2)
let Node3 = new Node(3)
let Node4 = new Node(4)
Node1.next = Node2
Node2.next = Node3
Node3.next = Node4
let newLinkedList = new LinkedList(Node1)
console.log(newLinkedList.getLast())
