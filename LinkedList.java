public class LinkedList{
    public static class Node{
        int data;
        Node next;
        
        public Node (int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;

    // Size of LinkedList
    public static int size;
    public void addFirst(int data){
         // step1 = create new node
         Node newNode=new Node(data);
         size++;
        if(head==null){
            head=tail=newNode;
            return;

        }
       

        //step2 - newNode nexxt =head
        newNode.next=head; //link

        //step 3 -head=newNode 
        head=newNode;
    }

    public void addLast(int data){

        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }

// add in the middle;

    public  void add (int idx, int data){

        // for adding at head;
        if(idx==0){
            addFirst(data);
            return; 
        }
        Node newNode= new Node(data);
        size++;
        Node temp=head;
        int i=0;

        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        //i=idx-1 temp->prev
        newNode.next=temp.next;
        temp.next=newNode;
    }

    // REMOVE IN A LINKEDLIST 1. REMOVE HEAD(FIRST)
    public int removeFirst(){

        if (size==0){
            System.out.println("Empty ll");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }
    public void print(){
        if(head==null){
            System.out.println("Empty linked list");
            return;

        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.err.println();
    }

    //REMOVE LAST NODE
    public int removeLast(){
        if(size==0){
            System.out.println("LL is empty!");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        //pre : i=size-2
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;

        }
        int val=prev.next.data;//tail.data; //tail data
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }

    //SEARCH IN THE LL
    public int itrSearch(int key){
        Node temp=head;
        int i=0;

        while(temp!=null){
            if(temp.data==key){
                return i; //key found
            }
            temp=temp.next;
            i++;
        }
        //key not  found
        return -1;

    }

    // SEARCH THROUGH RECURSION.

    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next,key);
        if(idx==-1){
            return -1;
        }
        return idx+1;

    }
    public int recSearch(int key){
        return helper(head,key);

    }
    //REVERSED A LINKED LIST 
    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
// DELETE NTH NODE FROM THE END
public void deleteNthNodefromEnd(int n){
    // claculate size
    int size=0;
    Node temp=head;
    while(temp!=null){
        temp=temp.next;
        size++;
    }
    if(n==size){
        head=head.next;
        return;
    } 

    //size-1
    int i=1;
    int iTofind=size-1;
    Node prev =head;
    while(i<iTofind){
        prev=prev.next;
        i++;
    }
    prev.next=prev.next.next;
    return;

    }

    // FIND MIDDLE USING SLOW-FAST POINTER
    public Node findMid( Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null&& fast.next!=null){
            slow=slow.next; //+1
            fast=fast.next.next;//+2

        }
        return slow; //slow is my mid node
    }

    public boolean checkPalindrome(){
    if(head==null && head.next==null){
        return true;
    }
    //step 1 calculate mid
    Node midnode= findMid(head);

    //step 2
    Node prev=null;
    Node curr= midnode;
    Node next;
    while(curr!=null){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }

    Node right= prev;
    Node left=head; // right head

// step 3 check 1st half and 2nd half
     while(right!=null){
        if(left.data!=right.data){
            return false;
        }
       left=left.next;
       right=right.next;
     
     
    }
    return true;
}
// CHECK WHETHER A CYCLE IS EXIST OR NOT

public static boolean isCycle(){
    Node slow=head;
    Node fast=head;
    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast){
            return true;
        }
        
     }
     return false;
}

// REMOVE CYCLE
public static void removeCycle(){
    //detect cycle
    Node slow=head;
    Node fast=head;
    boolean cycle =false;
    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast){
            cycle=true;
            break;
        }
            
        }
        if(cycle==false){
            return;
        }

    //find meeting point
    slow=head;
    Node prev=null;
    while(slow!=fast){
        prev=fast;
        slow=slow.next;
        fast=fast.next;

    }


    //remove cycle -> last.next=null;
    prev.next=null;


}

public void zigZag(){
    //mid node
    Node slow=head;
    Node fast=head.next;
    while(fast!=null &&fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
  Node mid= slow;

  //reverse 2nd half

  Node curr=mid.next;
  mid.next=null;
  Node prev=null;
  Node next;
  while(curr!=null){
    next=curr.next;
    curr.next=prev;
    prev=curr;
    curr=next;
  }


  Node left=head;
  Node right=prev;
  Node nextL,nextR;

  // alter merge zig zag merge

  while(left!=null && right!=null){
    nextL=left.next;
    left.next=right;
    nextR=right.next;
    right.next=nextL;

    left=nextL;
    right=nextR;


  }
}
   public static void main(String[] args) {
    LinkedList ll=new LinkedList();
    ll.addLast(1);
    ll.addLast(2);
    ll.addLast(3);
    ll.addLast(4);
    ll.addLast(5);
    //1->2->3->4->5
    
    // ll.add(2,14);
    // ll.print();
    // System.out.println(ll.size);

    // ll.removeFirst();
    // ll.print();
    // ll.removeLast();
    // ll.print();
    // System.out.println(ll.size);

    // System.out.println(ll.itrSearch(16)); 
    // System.out.println(ll.recSearch(16)); 
    // ll.reverse();
    // ll.print();
    
     ll.print();
     ll.zigZag();
     ll.print();
   }
   
    
}