package com.biz;

import java.util.HashSet;
import java.util.Set;

import akka.persistence.query.javadsl.ReadJournal;
import akka.stream.javadsl.Source;

public class MaterializedValues {

	public Source<RichEvent, QueryMetadata> byTagsWithMeta(Set<String> tags) {
		//Set<String> tags1 = new HashSet<String>();
		tags.add("blue");
		tags.add("red");
		return null;

	}
	
}
