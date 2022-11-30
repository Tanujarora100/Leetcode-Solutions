package Heap.KthPattern;

// package Heap;
//
// import java.util.ArrayList;
// import java.util.Collections;
//
// import java.util.LinkedList;
// import java.util.PriorityQueue;
//
// import javafx.util.*;
//
// public class kthClosest {
// static PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
// (a, b) -> b.getKey() != a.getKey() ? b.getKey() - a.getKey() : b.getValue() -
// a.getValue());
// // Lambda Expressions
// static ArrayList<Integer> ans = new ArrayList<>();
//
// static LinkedList<Integer> closest(int[] arr, int k, int x) {
// PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
// (a, b) -> b.getKey() != a.getKey() ? b.getKey() - a.getKey() : b.getValue() -
// a.getValue());
// for (int i = 0; i < arr.length; i++) {
// pq.add(new Pair<>(Math.abs(x - arr[i]), arr[i]));
// }
// while (pq.size() > k) {
// pq.remove();
// }
// LinkedList<Integer> list = new LinkedList<>();
// while (!pq.isEmpty()) {
// list.addFirst(pq.remove().getValue());
// }
// Collections.sort(list);
// return list;
// }
//
// public static void main(String[] args) {
// int arr[] = { 7, 8, 5, 4, 3, 2, 1 };
// closest(arr, 3, 5);
// System.out.println(closest(arr, 3, 5));
// }
// }
