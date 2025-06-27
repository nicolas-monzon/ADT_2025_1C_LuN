package org.example.model;

import org.example.model.node.EdgeNode;
import org.example.model.node.VertexNode;

public class DynamicGraph implements Graph {

    private VertexNode vertexNode;

    @Override
    public void addNode(int node) {
        if(this.vertexNode == null) {
            this.vertexNode = new VertexNode(node,null, null);
            return;
        }

        VertexNode current = this.vertexNode;
        while(current.getNext() != null) {
            if(current.getValue() == node) {
                throw new RuntimeException("El nodo ya existe");
            }
            current = current.getNext();
        }

        if(current.getValue() == node) {
            throw new RuntimeException("El nodo ya existe");
        }

        current.setNext(new VertexNode(node,null, null));
    }

    @Override
    public void removeNode(int node) {
        if(this.vertexNode == null) {
            throw new RuntimeException("El nodo no existe");
        }

        if(this.vertexNode.getNext() == null) {
            if(this.vertexNode.getValue() == node) {
                this.vertexNode = null;
                return;
            }
            throw new RuntimeException("El nodo no existe");
        }

        if(this.vertexNode.getValue() == node) {
            this.vertexNode = this.vertexNode.getNext();
            return;
        }

        VertexNode backup = this.vertexNode;
        VertexNode current = this.vertexNode.getNext();

        while(current != null) {
            if(current.getValue() == node) {
                backup.setNext(current.getNext());
                return;
            }
            backup = current;
            current = current.getNext();
        }

        throw new RuntimeException("El nodo no existe");
    }

    @Override
    public Set getNodes() {
        Set set = new DynamicSet();
        VertexNode current = this.vertexNode;
        while(current != null) {
            set.add(current.getValue());
            current = current.getNext();
        }
        return set;
    }

    @Override
    public void addEdge(int from, int to, int weight) {
        VertexNode currentVertexNode = this.vertexNode;
        while(currentVertexNode != null) {
            if(currentVertexNode.getValue() == from) {
                EdgeNode currentEdgeNode = currentVertexNode.getEdgeNode();
                if (currentEdgeNode == null) {
                    currentVertexNode.setEdgeNode(new EdgeNode(findVertexToByValue(to), weight, null));
                    return;
                }

                while(currentEdgeNode.getNext() != null) {
                    if(currentEdgeNode.getTo().getValue() == to) {
                        throw new RuntimeException("La arista ya existe con peso: " + currentEdgeNode.getWeight());
                    }
                    currentEdgeNode = currentEdgeNode.getNext();
                }

                if(currentEdgeNode.getTo().getValue() == to) {
                    throw new RuntimeException("La arista ya existe con peso: " + currentEdgeNode.getWeight());
                }

                currentEdgeNode.setNext(new EdgeNode(findVertexToByValue(to), weight, null));

                return;
            }
            currentVertexNode = currentVertexNode.getNext();
        }
        throw new RuntimeException("No existe el nodo de salida");
    }

    private VertexNode findVertexToByValue(int value) {
        VertexNode currentVertexNode = this.vertexNode;
        while(currentVertexNode != null) {
            if(currentVertexNode.getValue() == value) {
                return currentVertexNode;
            }
            currentVertexNode = currentVertexNode.getNext();
        }
        throw new RuntimeException("No existe el nodo de salida");
    }

    @Override
    public void removeEdge(int from, int to) {
        VertexNode currentVertexNode = this.vertexNode;
        while(currentVertexNode != null) {
            if(currentVertexNode.getValue() == from) {
                EdgeNode currentEdgeNode = currentVertexNode.getEdgeNode();
                if (currentEdgeNode == null) {
                    throw new RuntimeException("La arista no existe");
                }

                if(currentEdgeNode.getNext() == null) {
                    if(currentEdgeNode.getTo().getValue() == to) {
                        currentVertexNode.setEdgeNode(null);
                        return;
                    }
                    throw new RuntimeException("La arista no existe");
                }

                if(currentEdgeNode.getTo().getValue() == to) {
                    currentVertexNode.setEdgeNode(null);
                    return;
                }

                EdgeNode backup = currentEdgeNode;
                currentEdgeNode = currentEdgeNode.getNext();
                while(currentEdgeNode.getNext() != null) {
                    if(currentEdgeNode.getTo().getValue() == to) {
                        backup.setNext(currentEdgeNode.getNext());
                        return;
                    }
                    backup = currentEdgeNode;
                    currentEdgeNode = currentEdgeNode.getNext();
                }

                if(currentEdgeNode.getTo().getValue() == to) {
                    backup.setNext(currentEdgeNode.getNext());
                    return;
                }

                throw new RuntimeException("No existe la arista");
            }
            currentVertexNode = currentVertexNode.getNext();
        }
        throw new RuntimeException("No existe la arista");
    }

    @Override
    public boolean edgeExists(int from, int to) {
        VertexNode currentVertexNode = this.vertexNode;
        while(currentVertexNode != null) {
            if(currentVertexNode.getValue() == from) {
                EdgeNode currentEdgeNode = currentVertexNode.getEdgeNode();
                if (currentEdgeNode == null) {
                    return false;
                }

                while(currentEdgeNode.getNext() != null) {
                    if(currentEdgeNode.getTo().getValue() == to) {
                        return true;
                    }
                    currentEdgeNode = currentEdgeNode.getNext();
                }

                return currentEdgeNode.getTo().getValue() == to;
            }
            currentVertexNode = currentVertexNode.getNext();
        }
        return false;
    }

    @Override
    public int weight(int from, int to) {
        VertexNode currentVertexNode = this.vertexNode;
        while(currentVertexNode != null) {
            if(currentVertexNode.getValue() == from) {
                EdgeNode currentEdgeNode = currentVertexNode.getEdgeNode();
                if (currentEdgeNode == null) {
                    throw new RuntimeException("No existe la arista");
                }

                while(currentEdgeNode.getNext() != null) {
                    if(currentEdgeNode.getTo().getValue() == to) {
                        return currentEdgeNode.getWeight();
                    }
                    currentEdgeNode = currentEdgeNode.getNext();
                }

                if(currentEdgeNode.getTo().getValue() == to) {
                    return currentEdgeNode.getWeight();
                }

                throw new RuntimeException("La arista no existe");
            }
            currentVertexNode = currentVertexNode.getNext();
        }
        throw new RuntimeException("No arista no existe");
    }
}
