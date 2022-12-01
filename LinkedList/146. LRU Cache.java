package Stacks;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int val;
    Node next;
    Node prev;
    public int value;

    Node(int key, int value) {
        this.key = key;
        this.val = value;
    }

    public class LRUcacheQuestion {
        LinkedList list;
        Map<Integer, Node> map;
        Integer cap;

        class LinkedList {
            Node head;
            Node tail;

            LinkedList() {
                head = new Node(0, 0);
                tail = new Node(0, 0);
                head.next = tail;
                // Pointing to tail
                tail.prev = head;
            }

            void moveToHead(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                addTohead(node);
            }

            void addTohead(Node node) {
                Node temp = head.next;
                head.next = node;
                node.next = temp;
                node.prev = head;
                temp.prev = node;
            }

            void removeTail() {
                Node newTail = tail.prev.prev;
                newTail.next = tail;
                tail.prev = newTail;

            }

            Node getTail() {
                return tail.prev;
                // Address of Node just behind the tail of the LinkedList.
            }
        }

        public void LRUCache2(int capacity) {
            list = new LinkedList();
            map = new HashMap<>();
            cap = capacity;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null)
                return -1;
            list.moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                list.moveToHead(node);
                node.value = value;
            } else {
                Node newNode = new Node(key, value);
                if (map.size() == cap) {
                    Node tail = list.getTail();
                    map.remove(tail.key);
                    list.removeTail();
                }
                map.put(key, newNode);
                list.addTohead(newNode);
            }
        }
    }

}
