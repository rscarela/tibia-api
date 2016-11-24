package org.rscarela.tibia;

import org.jsoup.nodes.Document;

/**
 * @Author Renan Scarela
 */
public interface ResponseParser<T> {

	T parse(Document response);

}
