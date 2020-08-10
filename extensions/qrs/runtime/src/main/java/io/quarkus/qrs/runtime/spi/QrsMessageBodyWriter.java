package io.quarkus.qrs.runtime.spi;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.MessageBodyWriter;

import io.quarkus.qrs.runtime.core.LazyMethod;
import io.quarkus.qrs.runtime.core.QrsRequestContext;

/**
 * Extension of MessageBodyWriter which can write directly to a Vert.x response
 */
// FIXME: do we actually need to make it extend MessageBodyWriter?
public interface QrsMessageBodyWriter<T> extends MessageBodyWriter<T> {

    public boolean isWriteable(Class<?> type, LazyMethod target, MediaType mediaType);

    public void writeResponse(T o, QrsRequestContext context) throws WebApplicationException;

}
