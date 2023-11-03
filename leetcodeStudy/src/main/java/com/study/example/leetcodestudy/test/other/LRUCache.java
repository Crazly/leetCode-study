package com.study.example.leetcodestudy.test.other;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU是Least Recently Used的缩写，即最近最少使用，是一种常用的页面置换算法，选择最近最久未使用的页面予以淘汰
 * LRUCache可以简单修改代码然后cv到LeetCode进行测试 https://leetcode-cn.com/problems/lru-cache-lcci/
 */
public class LRUCache {

    public int capacity;

    public int size;

    static class LRUDoubleLinkedNode {
        String key;
        int val;
        LRUDoubleLinkedNode next;
        LRUDoubleLinkedNode prev;

        LRUDoubleLinkedNode(String key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUDoubleLinkedNode head;

    public LRUDoubleLinkedNode tail;

    public Map<String, LRUDoubleLinkedNode> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new LRUDoubleLinkedNode("head", 0);
        tail = new LRUDoubleLinkedNode("tail", 0);
        cache = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 插入页面
     */
    public void put(String key, int val) {
        if (capacity == 0) {
            throw new RuntimeException("capacity is zero");
        }
        LRUDoubleLinkedNode node = cache.get(key);
        if (node != null) {
            node.val = val;
            moveToHead(node);
        }else {
            LRUDoubleLinkedNode newNode = new LRUDoubleLinkedNode(key, val);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                String removeKey = removeLast();
                cache.remove(removeKey);
                size--;
            }
        }
    }

    /**
     * 取出页面
     */
    public int get(String key) {
        if (!cache.containsKey(key)) {
            throw new RuntimeException("get err");
        }
        LRUDoubleLinkedNode node = cache.get(key);
        moveToHead(node);
        return node.val;
    }

    /**
     * 移动页面至头部
     */
    private void moveToHead(LRUDoubleLinkedNode node) {
        remove(node);
        addToHead(node);
    }

    /**
     * 头插法添加页面
     */
    private void addToHead(LRUDoubleLinkedNode node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    /**
     * 删除页面
     */
    private void remove(LRUDoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 删除尾部页面
     */
    private String removeLast() {
        LRUDoubleLinkedNode node = tail.prev;
        remove(node);
        return node.key;
    }

    /**
     * 测试
     * 因为LRU结构较为复杂，单一测试案例完全无法验证算法的正确性，因此可以前往LeetCode界面进行测试
     */
    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(1);

        System.out.println("---------------原缓存---------------");
        System.out.println(lruCache.cache.toString());
        System.out.println("\n");

        System.out.println("---------------put测试---------------");
        lruCache.put("1", 2);
        System.out.println(lruCache.cache.toString());
        lruCache.put("1",3);
        System.out.println(lruCache.cache.toString());
        lruCache.put("2", 5);
        System.out.println(lruCache.cache.toString());
        System.out.println("\n");

        System.out.println("---------------get测试---------------");
        int page = lruCache.get("2");
        System.out.println(page);
        lruCache.get("1");

    }
}

