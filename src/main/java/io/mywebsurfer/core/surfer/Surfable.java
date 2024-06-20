package io.mywebsurfer.core.surfer;

import java.util.List;

/**
 * @author gentjan koli�aj
 */
public interface Surfable<O> {

  List<O> surf() throws Exception;

}
