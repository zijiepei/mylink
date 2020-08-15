class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
        this.prev = null;
        this.next =null;
    }
        }
public class DoubleLinkList {
    private  ListNode head;
    private  ListNode last;
    public DoubleLinkList() {
        this.head = null;
        this.last = null;
    }
    //头插法
    public void addFist(int val) {
        ListNode node = new ListNode(val);
        //1.如果是第一次插入
        if(this.head == null) {
            this.head = node;
            this.last = node;
            return;
        }
        //如果不是第一次插入
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }
    //尾插法
    public void addLast(int val) {
        ListNode node = new ListNode(val);
        //1.如果是第一次插入
        if(this.head == null) {
            this.head = node;
            this.last = node;
            return;
        }
        this.last.next = node;
        node.prev = this.last;
        this.last = node;
    }
    //任意位置插入下标从0号开始
    public void addRandom(int val,int place) {
        ListNode node = new ListNode(val);
        //1.先判断下标是否合法
        if(place < 0 || place > size()) {
            System.out.println("当前位置不合法");
        }
        if(place == 0) {
            addLast(val);
            return;
        }
        if(place == size()) {
            addLast(val);
            return;
        }
        ListNode prev = index(place);
        node.next = prev.next;
        prev.next.prev = node;
        prev.next = node;
        node.prev = prev.prev;
    }
    //先让一个引用走到要插入位置(用下标表示)的前一个
    public ListNode index(int place) {
        ListNode prev = this.head;
        int count = 0;
        while(count < place - 1) {
            prev = prev.next;
            count++;
        }
        return prev;
    }
    //确认一个关键字key是否在双向链表中如果存在返回它的下标,如果不存在则返回-1
    public int searchkey(int key) {
        //.双向链表是空的
        if(this.head == null) {
            System.out.println("这个双向链表是空的");
        }
        ListNode cur = this.head;
        int count = 0;
        while(cur != null) {
            if(cur.val == key) {
                return count;
            }
            count++;
            cur = cur.next;
        }
        return  -1;
    }
    //删除第一次出现关键字为key的节点：找到关键字key所在位置的前驱prev
    /*public ListNode findeprev(int key) {
        ListNode prev = this.head;
        if(this.head == null) {
            System.out.println("这个双向链表是空的，找不到关键字key的前驱");
        }       
        while(prev.next != null) {
            if(prev.next.val == key) {
              return prev;
            }
            prev = prev.next;
        }
        return null;
    }*/
    //删除第一次出现关键字为key的节点
    public void removefirstKey(int key) {
        if(this.head == null) {
            System.out.println("当前双项链表为空");
        }
        if(this.head.next == null) {
            if(this.head.val == key) {
                this.head = null;
                return;
            }else {
                return;
            }
        }
        if(this.head.val == key) {
            this.head = this.head.next;
            this.head.prev = null;
            return;
        }
        ListNode cur = this.head.next;
        while (cur.next != null) {
            if (cur.val == key) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                return;
            }
            cur = cur.next;
        }
        if(this.last.val == key) {
            this.last.prev.next = null;
            this.last = this.last.prev;
            return;
        }
    }
    //删除所有的关键字key的节点
    public void removeallKey(int key) {
        if(this.head == null) {
            System.out.println("当前双项链表为空");
        }
        if(this.head.next == null) {
            if(this.head.val == key) {
                this.head = null;
            }else {
                return;
            }
        }
        if(this.head.val == key) {
            this.head = this.head.next;
            this.head.prev = null;
        }
        ListNode cur = this.head.next;
        while (cur.next != null) {
            if (cur.val == key) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
            }
            cur = cur.next;
        }
        if(this.last.val == key) {
            this.last.prev.next = null;
            this.last = this.last.prev;
        }
    }
    //获取双向链表的长度
    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return  count;
    }
    //打印双向链表
    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
    public static void main(String[] args) {
        DoubleLinkList doubleLinkList = new DoubleLinkList();
        doubleLinkList.addLast(1);
        /*doubleLinkList.addLast(2);
        doubleLinkList.addLast(2);
        doubleLinkList.addLast(2);
        doubleLinkList.addLast(3);
        doubleLinkList.addLast(3);*/
        doubleLinkList.display();
        System.out.println();
        doubleLinkList.removeallKey(2);
        doubleLinkList.display();
    }
}
