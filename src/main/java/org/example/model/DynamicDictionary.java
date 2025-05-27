package org.example.model;

import org.example.model.node.KeyNode;
import org.example.model.node.ValueNode;

public class DynamicDictionary implements Dictionary {

    private KeyNode node;

    @Override
    public void add(int key, int value) {
        if(node == null) {
            node = new KeyNode(key, new ValueNode(value, null), null);
            return;
        }

        KeyNode current = node;
        while(current.getNext() != null) {
            if(current.getKey() == key) {
                if(current.getValues().getValue() != value) {
                    throw new RuntimeException("Duplicate key");
                }
                return;
            }
            current = current.getNext();
        }
        if(current.getKey() == key) {
            if(current.getValues().getValue() != value) {
                throw new RuntimeException("Duplicate key");
            }
            return;
        }
        current.setNext(new KeyNode(key, new ValueNode(value, null), null));
    }

    @Override
    public int get(int key) {
        KeyNode current = node;
        while(current != null) {
            if(current.getKey() == key) {
                return current.getValues().getValue();
            }
            current = current.getNext();
        }
        throw new RuntimeException("No such key");
    }

    @Override
    public void remove(int key, int value) {
        if(node == null) {
            return;
        }

        if(node.getNext() == null) {
            if(node.getKey() == key) {
                if(node.getValues().getValue() == value) {
                    node = null;
                }
                return;
            }
        }

        KeyNode previous = node;
        KeyNode current = node.getNext();
        while(current != null) {
            if (current.getKey() == key) {
                if (current.getValues().getValue() == value) {
                    previous.setNext(current.getNext());
                }
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }

    @Override
    public Set getKeys() {
        DynamicSet set = new DynamicSet();
        KeyNode current = node;
        while(current != null) {
            set.add(current.getKey());
            current = current.getNext();
        }
        return set;
    }
}
