package com.jk.model;

import java.io.Serializable;
import java.util.List;


public class Tree implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7996576349450788271L;

	private String id;
	
	private String text;
	
	private String pid;
	
	private String href;

	private List<Tree> nodes;//子节点列表

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}


	public List<Tree> getNodes() {
		return nodes;
	}

	public void setNodes(List<Tree> nodes) {
		this.nodes = nodes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Tree tree = (Tree) o;

		return id.equals(tree.id);

	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return "Tree{" +
				"id='" + id + '\'' +
				", text='" + text + '\'' +
				", pid='" + pid + '\'' +
				", href='" + href + '\'' +
				", nodes=" + nodes +
				'}';
	}
}
