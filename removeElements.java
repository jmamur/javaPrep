 public ListNode removeElements(ListNode head, int val) {
       ListNode ret = new ListNode(-1);
        ret.next = head;
        ListNode cur = ret;
        while(cur.next != null)
        {
            if(cur.next.val == val)
            {
                cur.next = cur.next.next;
            }
            else
            {
                cur = cur.next;
            }
        }
        return ret.next;
    }