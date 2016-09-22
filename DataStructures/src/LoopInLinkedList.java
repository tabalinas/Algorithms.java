
public class LoopInLinkedList {
    
    static <T> T find(LinkedList<T> list) {
        LinkedList.Node<T> meetNode = findFastSlowRunnerMeetNode(list);
        
        if(meetNode == null)
            return null;
        
        LinkedList.Node<T> node = findLoopNode(list, meetNode);
        return node.value;
    }

    private static <T> LinkedList.Node<T> findFastSlowRunnerMeetNode(LinkedList<T> list) {
        if(list.head == null)
            return null;
        
        LinkedList.Node<T> runner = list.head;
        LinkedList.Node<T> runner2x = list.head;
        LinkedList.Node<T> result = null;
        
        while(runner2x != null && runner2x.next != null) {
            runner = runner.next;
            runner2x = runner2x.next.next;
            
            if(runner == runner2x)
                return runner;
        }
        
        return null;
    }

    private static <T> LinkedList.Node<T> findLoopNode(LinkedList<T> list, LinkedList.Node<T> meetNode) {
        LinkedList.Node<T> result = meetNode;
        LinkedList.Node<T> runner = list.head;
        
        while(result != runner) {
            result = result.next;
            runner = runner.next;
        }
        
        return result;
    }

}
