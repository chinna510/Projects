package com.spark.graphx.GraphXSample;

import org.apache.hadoop.yarn.state.Graph;

public class VertexProperty {

	public VertexProperty() {
	}

	public static class UserProperty extends VertexProperty {
		public String name;

		public UserProperty(String name) {
			this.name = name;
		}

	}

	public static class ProductProperty extends VertexProperty {
		public Graph graph = null;
		public String name;
		public Double price;

		public ProductProperty(String name, Double price) {
			this.name = name;
			this.price = price;
		}

	}
}