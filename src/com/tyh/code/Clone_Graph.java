package com.tyh.code;

import java.util.HashMap;

import com.tyh.structure.UndirectedGraphNode;

public class Clone_Graph {
	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null) return node;
    	//if the node had been created
    	if(map.containsKey(node.label)) return map.get(node.label);
    	//else create a new node, and put it into the map
    	UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
    	map.put(node.label, clone);
    	//build its neighbors list
    	for(UndirectedGraphNode neighbor : node.neighbors){
    		clone.neighbors.add(cloneGraph(neighbor));
    	}
    	return clone;
    }
}
