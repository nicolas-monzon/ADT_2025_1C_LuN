package org.example.model;

import org.example.model.node.KeyNode;
import org.example.model.node.ValueNode;

public class DynamicMultipleDictionary implements MultipleDictionary {

    private KeyNode node;

    @Override
    public void add(int k, int v) {
        if (node == null) {
            node = new KeyNode(k, new ValueNode(v, null), null);
            return;
        }

        KeyNode candidate = node;
        while (candidate.getNext() != null) {
            if (candidate.getKey() == k) {
                ValueNode current = candidate.getValues();
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(new ValueNode(v, null));
            }
            candidate = candidate.getNext();
        }

        if (candidate.getKey() == k) {
            ValueNode current = candidate.getValues();
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new ValueNode(v, null));
        }
        candidate.setNext(new KeyNode(k, new ValueNode(v, null), null));
    }

    @Override
    public void remove(int k, int v) {
        if (node == null) {
            return;
        }

        if (node.getNext() == null) {
            if (node.getKey() == k) {
                if (node.getValues().getNext() == null) {
                    if (node.getValues().getValue() == v) {
                        this.node = null;
                        return;
                    }
                    return;
                }

                if (node.getValues().getValue() == v) {
                    node.setValues(node.getValues().getNext());
                    return;
                }

                ValueNode previous = node.getValues();
                ValueNode current = node.getValues().getNext();
                while (current != null) {
                    if (current.getValue() == v) {
                        previous.setNext(current.getNext());
                        return;
                    }
                    previous = current;
                    current = current.getNext();
                }
            }
            return;
        }

        KeyNode previous = node;
        KeyNode current = node.getNext();

        while (current.getNext() != null) {
            if (current.getKey() == k) {
                if (current.getValues().getNext() == null) {
                    if (current.getValues().getValue() == v) {
                        previous.setNext(current.getNext());
                        return;
                    }
                    return;
                }

                if (current.getValues().getValue() == v) {
                    current.setValues(current.getValues().getNext());
                    return;
                }

                ValueNode previousValue = node.getValues();
                ValueNode currentVlue = node.getValues().getNext();
                while (currentVlue != null) {
                    if (currentVlue.getValue() == v) {
                        previousValue.setNext(currentVlue.getNext());
                        return;
                    }
                    previousValue = currentVlue;
                    currentVlue = currentVlue.getNext();
                }
            }
            previous = current;
            current = current.getNext();
        }

        if (current.getKey() == k) {
            if (current.getValues().getNext() == null) {
                if (current.getValues().getValue() == v) {
                    previous.setNext(current.getNext());
                    return;
                }
                return;
            }

            if (current.getValues().getValue() == v) {
                current.setValues(current.getValues().getNext());
                return;
            }

            ValueNode previousValue = node.getValues();
            ValueNode currentVlue = node.getValues().getNext();
            while (currentVlue != null) {
                if (currentVlue.getValue() == v) {
                    previousValue.setNext(currentVlue.getNext());
                    return;
                }
                previousValue = currentVlue;
                currentVlue = currentVlue.getNext();
            }
        }
    }

    @Override
    public Set getKeys() {
        Set keys = new DynamicSet();
        KeyNode current = node;
        while (current != null) {
            keys.add(current.getKey());
            current = current.getNext();
        }
        return keys;
    }

    @Override
    public List get(int k) {
        KeyNode current = node;
        while (current != null) {
            if (current.getKey() == k) {
                ValueNode valueNode = current.getValues();
                List list = new DLinkedList();
                while (valueNode != null) {
                    list.add(valueNode.getValue());
                    valueNode = valueNode.getNext();
                }
                return list;
            }
            current = current.getNext();
        }
        throw new RuntimeException("No se encontró la clave");
    }
}
